package com.name.crow.dao;

import com.name.crow.context.CrowCayenneContext;
import com.name.crow.dao.auto._UserAccount;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by pchandramohan on 6/11/15.
 */

public class UserAccount extends _UserAccount {

    public UserAccount() {
    }

    @Autowired
    private CrowCayenneContext crowCayenneContext;

    public UserAccount(String username, String email, String password) {
        super.setUsername(username);
        super.setEmail(email);
        super.setPassword(password);
    }


    public Integer getUserId() {
        return (getObjectId() != null && !getObjectId().isTemporary())
                ? (Integer) getObjectId().getIdSnapshot().get(ID_PK_COLUMN)
                : null;
    }

}
