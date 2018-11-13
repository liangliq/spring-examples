package com.example.liangl.jdbc;

import com.example.liangl.data.SpittleRepository;
import com.example.liangl.model.Spittle;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by cpekl-ddim-2 on 11/12/18.
 */

@Component
public class JdbcSpittleRepository implements SpittleRepository {

    @Override
    public List<Spittle> findSpittles(long max, int count) {
        return null;
    }

    @Override
    public Spittle findOne(long spittleId) {
        return null;
    }
}
