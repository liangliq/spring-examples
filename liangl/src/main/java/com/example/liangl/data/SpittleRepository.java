package com.example.liangl.data;

import com.example.liangl.model.Spittle;

import java.util.List;

/**
 * Created by cpekl-ddim-2 on 11/5/18.
 */
public interface SpittleRepository {
    List<Spittle> findSpittles(long max,int count);
}
