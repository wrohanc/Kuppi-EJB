package com.ro.learn.client;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

/**
 * Created by rohan on 2016-11-26.
 */
public class InitContext {
    Context context;

    private static InitContext ourInstance = new InitContext();

    public static InitContext getInstance() {
        return ourInstance;
    }

    public Context getContext(){
        return context;
    }

    private InitContext() {
        Properties prop = new Properties();

        prop.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
        prop.put(Context.PROVIDER_URL, "http-remoting://127.0.0.1:8080");
        prop.put(Context.SECURITY_PRINCIPAL, "rohan");
        prop.put(Context.SECURITY_CREDENTIALS, "Zaq1xsw@");

        prop.put("jboss.naming.client.ejb.context", true);

        try {
            context = new InitialContext(prop);
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}
