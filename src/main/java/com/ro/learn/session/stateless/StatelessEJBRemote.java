package com.ro.learn.session.stateless;

import javax.ejb.Remote;
import java.util.List;

/**
 * Created by rohan on 2016-11-26.
 */
@Remote
public interface StatelessEJBRemote {
    public void addItem(String item);
    public void removeItem(String item);
    public List<String> items();
}
