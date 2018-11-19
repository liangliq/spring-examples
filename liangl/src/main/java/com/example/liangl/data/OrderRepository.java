package com.example.liangl.data;

import com.example.liangl.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * Created by cpekl-ddim-2 on 11/19/18.
 */
public interface OrderRepository extends MongoRepository<Order,String> {

    List<Order> findByCustomer(String c);

    List<Order> fingByCustomerLike(String c);

    List<Order> fingByCustomerAndType(String c, String t);

    List<Order> fingByCustomerLikeAndType(String c, String t);

    @Query("{'customer': 'Chuch Wagon', 'type': '?0'}")
    List<Order> findChucksOrders(String t);
}
