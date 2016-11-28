package com.ro.learn.client;

import javax.jms.*;
import javax.naming.NamingException;

/**
 * Created by rohan on 2016-11-26.
 */
public class JMSSender {
    ConnectionFactory connectionFactory;
    Queue queue;

    public static void main(String[] args) throws NamingException {
        JMSSender jmsSender = new JMSSender();
        jmsSender.sendMessage("Test message");

    }

    public void sendMessage(String payload) throws NamingException {
        connectionFactory = (ConnectionFactory) InitContext.getInstance().getContext().lookup("jms/RemoteConnectionFactory");
        queue = (Queue) InitContext.getInstance().getContext().lookup("jms/queue/OutQueue");
        try (JMSContext context = connectionFactory.createContext("rohan", "Zaq1xsw@");) {
            context.createProducer().send(queue, payload);
        }
    }
}
