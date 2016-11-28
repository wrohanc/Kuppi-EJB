package com.ro.learn.session.singleton;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by rohan on 2016-11-26.
 */
@Startup
@Singleton(name = "SingletonEJB")//not for RMI
public class SingletonEJB {
    private ArrayList list;

    public SingletonEJB() {
        System.out.println("SingletonEJB Constructor :" + new Date());
        list = new ArrayList<String>();
    }

    @PostConstruct
    private void postConstruct() {
        System.out.println("SingletonEJB.PostConstruct" + new Date());
    }

    public void addItem(String item) {
        list.add(item);
        System.out.println(list);
    }

    public void removeItem(String item) {
        list.remove(item);
        System.out.println(list);
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<String> items() {
        return list;
    }
}
