package com.example.liangl.data;

import com.example.liangl.model.Spitter;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpitterRepository {

    Spitter save(Spitter spitter);

    Spitter findByUsername(String username);

    Spitter findOne(Long id);

    List<Spitter> findAll ();
}
