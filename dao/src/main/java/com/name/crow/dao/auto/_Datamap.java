package com.name.crow.dao.auto;

import java.util.List;

import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.query.NamedQuery;

import com.name.crow.dao.Role;
import com.name.crow.dao.UserAccount;

/**
 * This class was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public class _Datamap {

    public static final String FIND_ALL_ROLES_QUERYNAME = "findAllRoles";

    public static final String FIND_ALL_USERS_QUERYNAME = "findAllUsers";

    public List<Role> performFindAllRoles(ObjectContext context) {
        return context.performQuery(new NamedQuery("findAllRoles"));
    }

    public List<UserAccount> performFindAllUsers(ObjectContext context) {
        return context.performQuery(new NamedQuery("findAllUsers"));
    }
}