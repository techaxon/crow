package com.name.crow.context;

import org.apache.cayenne.*;
import org.apache.cayenne.access.DataContext;
import org.apache.cayenne.graph.GraphDiff;
import org.apache.cayenne.graph.GraphManager;
import org.apache.cayenne.map.EntityResolver;
import org.apache.cayenne.query.Query;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

/**
 * Created by pchandramohan on 11/20/16.
 */

@Component
public class CrowCayenneContext extends BaseContext {


    public DataContext getDataContext() {
        DataContext context = null;
        try {
            context = (DataContext) BaseContext.getThreadObjectContext();
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
        }
        return context;
    }

    @Override
    public void commitChanges() {

    }

    @Override
    public void commitChangesToParent() {

    }

    @Override
    public void deleteObject(Object object) throws DeleteDenyException {

    }

    @Override
    public void deleteObjects(Collection<?> objects) throws DeleteDenyException {

    }

    @Override
    public Collection<?> deletedObjects() {
        return null;
    }

    @Override
    public EntityResolver getEntityResolver() {
        return null;
    }

    @Override
    public QueryResponse onQuery(ObjectContext originatingContext, Query query) {
        return null;
    }

    @Override
    public GraphManager getGraphManager() {
        return null;
    }

    @Override
    public ObjectContext createChildContext() {
        return null;
    }

    @Override
    public boolean hasChanges() {
        return false;
    }

    @Override
    public Persistent localObject(ObjectId id, Object prototype) {
        return null;
    }

    @Override
    public Collection<?> modifiedObjects() {
        return null;
    }

    @Override
    public <T> T newObject(Class<T> persistentClass) {
        return null;
    }

    @Override
    public void registerNewObject(Object object) {

    }

    @Override
    public Collection<?> newObjects() {
        return null;
    }

    @Override
    public QueryResponse performGenericQuery(Query query) {
        return null;
    }

    @Override
    public List performQuery(Query query) {
        return null;
    }

    @Override
    public void propertyChanged(Persistent object, String property, Object oldValue, Object newValue) {

    }

    @Override
    public void rollbackChanges() {

    }

    @Override
    public void rollbackChangesLocally() {

    }

    @Override
    public Collection<?> uncommittedObjects() {
        return null;
    }

    @Override
    protected GraphDiff onContextFlush(ObjectContext originatingContext, GraphDiff changes, boolean cascade) {
        return null;
    }
}
