package com.ro.learn.transactionalscope;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.TransactionScoped;
import javax.transaction.Transactional;

/**
 * Created by rohan on 2016-11-27.
 */
@Stateless
public class TransactionActivity {
    @Inject
    TransactionalScopedBean bean1;
    @Inject
    TransactionalScopedBean bean2;

    @Transactional
    public String getIdsWithTransaction() {
        return bean1.getMyInstanceId() + " " + bean2.getMyInstanceId();
    }
}
