package com.ro.learn.businesslogic;

import com.ro.learn.util.Order;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Created by rohan on 2016-11-27.
 */
@Stateless(name = "OrderManagerEJB")
public class OrderManagerEJB {

    @EJB//todo explain
    private EmailSenderEJB emailSender;

    public Order placeOrder(Order order){
        //business logic here
        System.out.println("Order symbol :" + order.getSymbol());
        System.out.println("Order qty :" + order.getQty());
        System.out.println("Order price :" + order.getPrice());
        System.out.println("Order value :" + order.getQty()*order.getPrice());

        emailSender.sendEmail();

        return order;
    }
}
