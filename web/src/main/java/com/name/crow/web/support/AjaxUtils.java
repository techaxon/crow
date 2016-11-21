package com.name.crow.web.support;

/**
 * Created by pchandramohan on 11/18/16.
 */
public class AjaxUtils {

    private AjaxUtils() {
    }

    public static boolean isAjaxRequest(String requestedWith) {
        return requestedWith != null ? "XMLHttpRequest".equals(requestedWith) : false;
    }
}
