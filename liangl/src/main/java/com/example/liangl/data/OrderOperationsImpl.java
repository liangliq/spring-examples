package com.example.liangl.data;

import com.example.liangl.model.Order;
import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * Created by cpekl-ddim-2 on 11/19/18.
 */
public class OrderOperationsImpl implements OrderOperations {

    @Autowired
    private MongoOperations operations;
    @Override
    public List<Order> findOrderByType(String t) {
        /*String type = t.equals("NET") ? "WEB": t;
        Criteria where = Criteria.where("type").is(t);
        Query query = Query.query(where);
        return operations.find(query, Order.class);*/
        return null;
    }
}
