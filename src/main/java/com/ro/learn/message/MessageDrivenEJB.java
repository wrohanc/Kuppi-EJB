package com.ro.learn.message;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * Created by rohan on 2016-11-26.
 */
@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "java:jboss/exported/jms/queue/InQueue"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class MessageDrivenEJB implements MessageListener {


    public void onMessage(Message message) {
        try {
            Object o = message.getBody(Object.class);
            System.out.println(o);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
