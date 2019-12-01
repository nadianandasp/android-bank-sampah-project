package com.sahitya.banksampahsahitya.utils;

import com.sahitya.banksampahsahitya.rest.client.ApiClient;
import com.sahitya.banksampahsahitya.rest.service.RegisterApiService;

public class RegisterApiUtils {
    public static RegisterApiService getRegisterApiService(){
        return ApiClient.getClient().create(RegisterApiService.class);
    }
}
