package com.example.liangl.jpa;

import com.example.liangl.data.SpitterRepository;
import com.example.liangl.model.Spitter;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
@Primary
public class JpaSpitterRepository implements SpitterRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Spitter save(Spitter spitter) {
        em.persist(spitter);
        return spitter;
    }

    @Override
    public Spitter findByUsername(String username) {
        return null;
    }

    @Override
    public Spitter findOne(long id) {
        return em.find(Spitter.class, id);
    }

    @Override
    public List<Spitter> findAll() {
        return null;
    }
}
