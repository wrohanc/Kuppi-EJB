package com.ro.learn.transactionalscope;

import javax.transaction.TransactionScoped;
import java.io.Serializable;

/**
 * Created by rohan on 2016-11-27.
 */
@TransactionScoped
public class TransactionalScopedBean implements Serializable{
    private static Integer instanceId = 0;
    private int myInstanceId;

    public TransactionalScopedBean() {
        synchronized (instanceId){
            instanceId++;
            myInstanceId = instanceId;
        }
    }

    public int getMyInstanceId(){
        return myInstanceId;
    }
}
