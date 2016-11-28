package com.ro.learn.transactionalscope;

import javax.ejb.Remote;

/**
 * Created by rohan on 2016-11-27.
 */
@Remote
public interface TransactionEJBRemote {
    public String getIdsWithTransaction();
}
