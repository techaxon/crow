package com.name.crow.dao;

import com.name.crow.dao.auto._Role;

/**
 * Created by pchandramohan on 6/11/15.
 */
public class Role extends _Role {

    public Integer getRoleId() {
        return (getObjectId() != null && !getObjectId().isTemporary())
                ? (Integer) getObjectId().getIdSnapshot().get(ID_PK_COLUMN)
                : null;
    }
}
