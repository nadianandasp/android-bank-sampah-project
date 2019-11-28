package com.sahitya.banksampahsahitya.utils;

import com.sahitya.banksampahsahitya.rest.client.ApiClient;
import com.sahitya.banksampahsahitya.rest.service.LoginService;

public class LoginUtils {

    public static LoginService getLoginService(){
        return ApiClient.getClient().create(LoginService.class);
    }
}
