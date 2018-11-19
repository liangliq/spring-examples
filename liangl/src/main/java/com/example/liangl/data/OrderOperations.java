package com.example.liangl.data;

import com.example.liangl.model.Order;

import java.util.List;

/**
 * Created by cpekl-ddim-2 on 11/19/18.
 */
public interface OrderOperations {

    List<Order> findOrderByType(String t);
}
