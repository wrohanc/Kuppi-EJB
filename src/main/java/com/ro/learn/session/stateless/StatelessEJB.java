package com.ro.learn.session.stateless;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by rohan on 2016-11-26.
 */
@Stateless(name = "StatelessEJB")
public class StatelessEJB implements StatelessEJBRemote {
    private ArrayList list;//todo this is wrong - just to show this does not work as expected

    public StatelessEJB() {
        list = new ArrayList<String>();
        System.out.println("StatelessEJB.PostConstruct called :" + new Date());

    }

    @PostConstruct
    private void postConstruct() {
        System.out.println("StatelessEJB.PostConstruct called :" + new Date());
    }

    @PreDestroy
    private void preDestroy() {
        System.out.println("StatelessEJB.PreDestroy called :" + new Date());
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
