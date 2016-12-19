package com.name.crow.repository;

import com.name.crow.context.CrowCayenneContext;
import com.name.crow.dao.Role;
import com.name.crow.dao.UserAccount;
import com.name.crow.dao.UserRole;
import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.access.Transaction;
import org.apache.cayenne.exp.Expression;
import org.apache.cayenne.query.EJBQLQuery;
import org.apache.cayenne.query.SelectQuery;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountRepository.class);

    @Autowired
    private CrowCayenneContext crowCayenneContext;


    public UserAccount findByUsername(String username) {
        ObjectContext context = crowCayenneContext.getContext();
        return findByUsername(username, context);
    }

    public UserAccount findByUsername(String username, ObjectContext context) {
        LOGGER.debug("1 ********************>  :  " + username);
        Map param = new HashMap();
        param.put("username", username);

        Expression expression = Expression.fromString("username = $username");

        SelectQuery selectQuery = proto(UserAccount.class, expression).queryWithParameters(param);
        selectQuery.setDistinct(true);
        List<UserAccount> userAccounts = context.performQuery(selectQuery);
        LOGGER.debug("2 ********************>  :  " + userAccounts.stream().findFirst().get());
        return userAccounts.stream().findFirst().get();
    }

    public List<UserRole> findUserRoles(String username) {
        ObjectContext parent = crowCayenneContext.getContext();
        return findUserRoles(username, parent);
    }

    public List<UserRole> findUserRoles(String username, ObjectContext context) {

        Expression expression = Expression.fromString("username = $username");
        StringBuffer ejbql = new StringBuffer();
        ejbql.append("select ur FROM UserRole ur, UserAccount u WHERE  ur.userid = u AND u.username = '")
                .append(username)
                .append("'");

        EJBQLQuery selectQuery = proto(ejbql.toString());
        List<UserRole> roles = context.performQuery(selectQuery);

        return roles;
    }


    public List findAllUsers() {
        ObjectContext context = crowCayenneContext.getContext();
        SelectQuery selectQuery = new SelectQuery(UserAccount.class);
        return context.performQuery(selectQuery);
    }



    private SelectQuery proto(Class clazz, Expression expression) {
        return new SelectQuery(clazz, expression);
    }

    private EJBQLQuery proto(String ejbql) {
        return new EJBQLQuery(ejbql);
    }

    public UserAccount save(String email, String username, String password, String role) {
        ObjectContext parent = crowCayenneContext.getContext();
        ObjectContext child = crowCayenneContext.getNestedContext(parent);

        Transaction tx = crowCayenneContext.getNewTransaction();
        UserAccount u = child.newObject(UserAccount.class);
        u.setEmail(email);
        u.setPassword(password);
        u.setUsername(username);

        boolean isadmin = ("ADMIN".equals(role));
        u.setIsAdmin(isadmin);

        DateTime dt = new DateTime();
        u.setCreatedDate(dt.toDate());


        UserRole ur = child.newObject(UserRole.class);
        ur.setRoleid(getRoleByName(child, role));
        ur.setUserid(u);

        ur.setCreatedDate(dt.toDate());

        Transaction.bindThreadTransaction(tx);
        try {
            parent.commitChanges();
            child.commitChanges();
            tx.commit();
        } catch (Exception ex) {
            tx.setRollbackOnly();
        } finally {
            Transaction.bindThreadTransaction(null);

            if (tx.getStatus() == Transaction.STATUS_MARKED_ROLLEDBACK) {
                try {
                    tx.rollback();
                } catch (Exception rollbackEx) {
                    rollbackEx.printStackTrace();
                }
            }
        }

        return u;
    }


    public Role getRoleByName(ObjectContext roleContext, String name) {
        //ObjectContext roleContext = crowCayenneContext.getContext();

        Map<String, String> param = new HashMap<String, String>();
        param.put("rolename", name);
        Expression expression = Expression.fromString("rolename = $rolename");
        SelectQuery sq = proto(Role.class, expression).queryWithParameters(param);
        List<Role> roles = roleContext.performQuery(sq);

        return roles.stream().findFirst().get();
    }


    public int deleteByUsername(String username) {
        ObjectContext context = crowCayenneContext.getContext();
        context.deleteObjects(findUserRoles(username, context));
        context.deleteObject(findByUsername(username, context));
        List deletedObj = (List) context.deletedObjects();
        context.commitChanges();
        return deletedObj != null ? deletedObj.size() : 0;
    }


}
