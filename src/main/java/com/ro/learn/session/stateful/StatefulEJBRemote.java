package com.ro.learn.session.stateful;

import javax.ejb.Remote;
import java.util.List;

/**
 * Created by rohan on 2016-11-26.
 */
@Remote
public interface StatefulEJBRemote {
    public void addItem(String item);
    public void removeItem(String item);
    public List<String> items();
}
