package com.name.crow.dao;

import org.apache.cayenne.exp.Expression;
import org.apache.cayenne.query.SelectQuery;

/**
 * Created by pchandramohan on 6/11/15.
 */
public class BaseDaoImpl<T> {

    private SelectQuery proto(Class<T> clazz, Expression expression) {
        return new SelectQuery(clazz, expression);
    }
}
