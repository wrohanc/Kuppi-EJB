package com.ro.learn.client;

import com.ro.learn.transactionalscope.TransactionEJBRemote;

import javax.naming.NamingException;

/**
 * Created by rohan on 2016-11-27.
 */
public class TransactionalTest {
    public static void main(String[] args) throws NamingException {
        TransactionalTest rmi = new TransactionalTest();
        TransactionEJBRemote remote = (TransactionEJBRemote) InitContext.getInstance().
                getContext().lookup("/Kuppi-EJB-1.0/TransactionEJB!com.ro.learn.transactionalscope.TransactionEJBRemote");

        System.out.println(remote.getIdsWithTransaction());

    }
}
