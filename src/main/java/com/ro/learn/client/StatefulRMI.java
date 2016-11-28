package com.ro.learn.client;

import com.ro.learn.session.stateful.StatefulEJBRemote;

import javax.naming.NamingException;

/**
 * Created by rohan on 2016-11-26.
 */
public class StatefulRMI {
    public static void main(String[] args) throws NamingException {
        StatefulRMI rmi = new StatefulRMI();
        StatefulEJBRemote remote = (StatefulEJBRemote) InitContext.getInstance().
                getContext().lookup("/Kuppi-EJB-1.0/StatefulEJB!com.ro.learn.session.stateful.StatefulEJBRemote");
        rmi.addItem("A", remote);
        rmi.addItem("B", remote);
        rmi.addItem("C", remote);
        rmi.addItem("D", remote);
        rmi.addItem("E", remote);

        rmi.getItems(remote);

        StatefulEJBRemote remote1 = (StatefulEJBRemote) InitContext.getInstance().
                getContext().lookup("/Kuppi-EJB-1.0/StatefulEJB!com.ro.learn.session.stateful.StatefulEJBRemote");
        rmi.addItem("A", remote1);
        rmi.addItem("B", remote1);
        rmi.addItem("C", remote1);
        rmi.addItem("D", remote1);
        rmi.addItem("E", remote1);

        rmi.getItems(remote1);
    }

    public void addItem(String item, StatefulEJBRemote remote) {
       remote.addItem(item);
    }

    public void getItems(StatefulEJBRemote remote) {
        System.out.println(remote.items());
    }
}
