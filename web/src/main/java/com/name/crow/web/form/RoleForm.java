package com.name.crow.web.form;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by pchandramohan on 12/18/16.
 */
public class RoleForm {

    private static final String NOT_BLANK_MESSAGE = "{notBlank.message}";
    private static final String EMAIL_MESSAGE = "{email.message}";

    @NotBlank(message = RoleForm.NOT_BLANK_MESSAGE)
    @Email(message = RoleForm.EMAIL_MESSAGE)
    private String roleName;

    @NotBlank(message = RoleForm.NOT_BLANK_MESSAGE)
    private String roleDescription;

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
