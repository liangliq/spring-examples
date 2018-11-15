package com.example.liangl.hibernate;


import com.example.liangl.data.SpitterRepository;
import com.example.liangl.model.Spitter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by cpekl-ddim-2 on 11/14/18.
 */
@Component
@Repository
@Primary
public class HibernateSpitterRepository implements SpitterRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public HibernateSpitterRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    @Transactional
    public Spitter save(Spitter spitter) {
        Serializable id = currentSession().save(spitter);
        return new Spitter((Long) id,
                spitter.getFirstname(),
                spitter.getLastname(),
                spitter.getUsername(),
                spitter.getPassword());
    }

    @Override
    @Transactional
    public Spitter findByUsername(String username) {
        return (Spitter) currentSession().createCriteria(Spitter.class)
                .add(Restrictions.eq("username", username))
                .list().get(0);
    }

    @Override
    @Transactional
    public Spitter findOne(long id) {
        return (Spitter) currentSession().get(Spitter.class, id);
    }

    @Override
    public List<Spitter> findAll() {
        return null;
    }
}
