package com.ro.learn.client;

import javax.jms.ConnectionFactory;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.naming.NamingException;

/**
 * Created by rohan on 2016-11-26.
 */
public class JMSReceiver {
    ConnectionFactory connectionFactory;
    Queue queue;

    public static void main(String[] args) throws NamingException {
        JMSReceiver receiver = new JMSReceiver();
        receiver.receiveMessage();
    }

    public void receiveMessage () throws NamingException {
        String body=null;
        connectionFactory = (ConnectionFactory) InitContext.getInstance().getContext().lookup("jms/RemoteConnectionFactory");
        queue = (Queue) InitContext.getInstance().getContext().lookup("jms/queue/OutQueue");
        try (JMSContext context = connectionFactory.createContext("rohan", "Zaq1xsw@");){
            JMSConsumer consumer = context.createConsumer(queue);
            while (true) {
                body = consumer.receiveBody(String.class);
                System.out.println(body);
            }
        }

    }
}
