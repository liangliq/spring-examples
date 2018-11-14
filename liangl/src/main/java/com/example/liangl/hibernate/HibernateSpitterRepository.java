package com.example.liangl.hibernate;


import com.example.liangl.data.SpitterRepository;
import com.example.liangl.model.Spitter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.lang.invoke.SerializedLambda;
import java.util.List;

/**
 * Created by cpekl-ddim-2 on 11/14/18.
 */
@Component
@Primary
public class HibernateSpitterRepository implements SpitterRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public HibernateSpitterRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSesstion(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Spitter save(Spitter spitter) {
        Serializable id = currentSesstion().save(spitter);
        return new Spitter((Long) id,
                spitter.getFirstname(),
                spitter.getLastname(),
                spitter.getUsername(),
                spitter.getPassword());
    }

    @Override
    public Spitter findByUsername(String username) {
        return (Spitter) currentSesstion().createCriteria(Spitter.class)
                .add(Restrictions.eq("username", username))
                .list().get(0);
    }

    @Override
    public Spitter findOne(long id) {
        return (Spitter) currentSesstion().get(Spitter.class, id);
    }

    @Override
    public List<Spitter> findAll() {
        return null;
    }
}
