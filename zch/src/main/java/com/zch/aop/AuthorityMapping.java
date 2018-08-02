package com.zch.aop;

import java.util.HashMap;

/**
 * Created by chensuo on 2018-8-1.
 */
public class AuthorityMapping {

    public static final HashMap<String, String> AUTH_MAPPING = new HashMap<>();

    static {
        AUTH_MAPPING.put("com.zch.controller.LoginController.loginValidate", "LOGIN_VALIDATE");
        AUTH_MAPPING.put("com.zch.controller.AuthorityController.authorityList", "AUTH_LIST");
    }
}
