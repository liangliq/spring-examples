package com.example.liangl.data;

import com.example.liangl.model.Spitter;
import org.springframework.stereotype.Repository;

@Repository
public interface SpitterRepository {

    Spitter save(Spitter spitter);

    Spitter findByUsername(String username);
}
