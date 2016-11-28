package com.ro.learn.client;

import com.ro.learn.session.stateless.StatelessEJBRemote;

import javax.naming.NamingException;

/**
 * Created by rohan on 2016-11-26.
 */
public class StatelessRMI {
    public static void main(String[] args) throws NamingException {
        StatelessRMI rmi = new StatelessRMI();
        StatelessEJBRemote remote = (StatelessEJBRemote) InitContext.getInstance().
                getContext().lookup("/Kuppi-EJB-1.0/StatelessEJB!com.ro.learn.session.stateless.StatelessEJBRemote");

        rmi.addItem("A", remote);
        rmi.addItem("B", remote);
        rmi.addItem("C", remote);
        rmi.addItem("D", remote);
        rmi.addItem("E", remote);

        rmi.getItems(remote);

        StatelessEJBRemote remote1 = (StatelessEJBRemote) InitContext.getInstance().
                getContext().lookup("/Kuppi-EJB-1.0/StatelessEJB!com.ro.learn.session.stateless.StatelessEJBRemote");
        rmi.addItem("A", remote1);
        rmi.addItem("B", remote1);
        rmi.addItem("C", remote1);
        rmi.addItem("D", remote1);
        rmi.addItem("E", remote1);

        rmi.getItems(remote1);
    }

    public void addItem(String item, StatelessEJBRemote remote) {
        remote.addItem(item);
    }

    public void getItems(StatelessEJBRemote remote) {
        System.out.println(remote.items());
    }
}
