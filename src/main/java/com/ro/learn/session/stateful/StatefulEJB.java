package com.ro.learn.session.stateful;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by rohan on 2016-11-26.
 */
@Stateful(name = "StatefulEJB")//todo cannot be a web service or rest
public class StatefulEJB implements StatefulEJBRemote {
    private ArrayList list;

    public StatefulEJB() {
        System.out.println("StatefulEJB.Constructor called : " + new Date());
    }

    @PostConstruct
    private void postConstruct() {
        list = new ArrayList<String>();
        System.out.println("StatefulEJB.PostConstruct called :" + new Date());
    }

    @PreDestroy
    private void preDestroy() {
        System.out.println("StatefulEJB.PreDestroy called :" + new Date());
    }

    @PrePassivate
    private void prePassivate() {
        System.out.println("StatefulEJB.PrePassivate called :" + new Date());
    }

    @PostActivate
    private void postActivate() {
        System.out.println("StatefulEJB.PostActivate called :" + new Date());
    }

    public void addItem(String item) {
        list.add(item);
        System.out.println(list);
    }

    public void removeItem(String item) {
        list.remove(item);
        System.out.println(list);
    }

    //@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    //@TransactionAttribute(TransactionAttributeType.MANDATORY)
    //@TransactionAttribute(TransactionAttributeType.NEVER)
    //@TransactionAttribute(TransactionAttributeType.REQUIRED)
    //@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    //@TransactionAttribute(TransactionAttributeType.SUPPORTS)
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<String> items() {
        return list;
    }
}
