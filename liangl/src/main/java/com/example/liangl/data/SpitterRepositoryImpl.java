package com.example.liangl.data;

import com.example.liangl.model.Spitter;
import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;
import org.springframework.stereotype.Component;

@Component
public class SpitterRepositoryImpl implements SpitterRepository {
    @Override
    public Spitter save(Spitter spitter) {
        return spitter;
    }

    @Override
    public Spitter findByUsername(String username){
        return new Spitter(33L, "Kate", "Liu", "LK", "123");
    }
}
