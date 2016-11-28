package com.ro.learn.transactionalscope;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

/**
 * Created by rohan on 2016-11-27.
 */
@Stateless(name = "TransactionEJB")
public class TransactionEJB implements TransactionEJBRemote {
    @Inject
    TransactionActivity transactionActivity;
    @Inject
    TransactionalScopedBean bean1;

    public String getIdsWithTransaction() {
        String key = bean1.getMyInstanceId() + " " + transactionActivity.getIdsWithTransaction();
        System.out.println(key);
        return key;
    }

}
