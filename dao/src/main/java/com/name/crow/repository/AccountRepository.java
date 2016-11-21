package com.name.crow.repository;

import com.name.crow.context.CrowCayenneContext;
import com.name.crow.dao.UserAccount;
import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.exp.Expression;
import org.apache.cayenne.query.SelectQuery;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pchandramohan on 11/20/16.
 */

@Repository
public class AccountRepository {

    @Autowired
    private CrowCayenneContext crowCayenneContext;

    public UserAccount findByEmail(String username) {

        ObjectContext context = crowCayenneContext.getDataContext();

        Map param = new HashMap();
        param.put("username", username);

        Expression expression = Expression.fromString("username = $username");

        SelectQuery selectQuery = proto(expression).queryWithParameters(param);
        selectQuery.setDistinct(true);

        return (UserAccount) context.performQuery(selectQuery);
    }

    public List<UserAccount> findAllUsers() {
        ObjectContext context = crowCayenneContext.getDataContext();
        SelectQuery selectQuery = new SelectQuery(UserAccount.class);
        return context.performQuery(selectQuery);
    }

    private SelectQuery proto(Expression expression) {
        SelectQuery selectQuery = new SelectQuery(UserAccount.class, expression);
        return selectQuery;
    }

    public UserAccount save(String email, String username, String password, String role) {
        ObjectContext context = crowCayenneContext.getDataContext();

        UserAccount u = context.newObject(UserAccount.class);
        u.setEmail(email);
        u.setPassword(password);
        u.setUsername(username);

        DateTime dt = new DateTime();
        u.setCreatedDate(dt.toDate());
        context.commitChanges();
        return u;
    }


}
