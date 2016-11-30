package com.name.crow.context;

import org.apache.cayenne.DataChannel;
import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.access.Transaction;
import org.apache.cayenne.configuration.server.ServerRuntime;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * Created by pchandramohan on 11/20/16.
 */

@Component
public class CrowCayenneContext {

    private final ServerRuntime runtime;

    public ObjectContext getContext() {
        ObjectContext context = null;
        try {
            context = runtime.getContext();
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
        }
        return context;
    }

    public ObjectContext getNestedContext(ObjectContext parent) {
        ObjectContext context = null;
        try {
            context = runtime.getContext((DataChannel) parent);
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
        }
        return context;
    }


    public DataSource getDataSource() {
        DataSource ds = null;
        try {
            String dataNode = "crow-mysql";
            ds = runtime.getDataSource(dataNode);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ds;
    }

    public Transaction getNewTransaction() {
        Transaction tx = null;
        try {
            tx = runtime.getDataDomain().createTransaction();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return tx;
    }

    public CrowCayenneContext() {
        this.runtime = new ServerRuntime("cayenne-project.xml");
    }


}
