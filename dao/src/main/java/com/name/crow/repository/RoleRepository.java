package com.name.crow.repository;

import com.name.crow.context.CrowCayenneContext;
import com.name.crow.dao.Role;
import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.query.SelectQuery;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by pchandramohan on 11/29/16.
 */

@Repository
public class RoleRepository {

    @Autowired
    private CrowCayenneContext crowCayenneContext;


    public List findAll() {
        ObjectContext context = crowCayenneContext.getContext();
        SelectQuery selectQuery = new SelectQuery(Role.class);
        return context.performQuery(selectQuery);
    }

    public Role save(String name, String description) {
        ObjectContext context = crowCayenneContext.getContext();

        Role r = context.newObject(Role.class);
        r.setDescription(description);
        r.setRolename(name);

        DateTime dt = new DateTime();
        r.setCreatedDate(dt.toDate());
        context.commitChanges();
        return r;
    }
}
