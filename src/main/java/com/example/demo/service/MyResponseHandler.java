package com.example.demo.service;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.util.EntityUtils;

import java.io.IOException;


public class MyResponseHandler implements ResponseHandler<String> {

    @Override
    public String handleResponse(final HttpResponse response) throws IOException {

        //Get the status of the response
        int status = response.getStatusLine().getStatusCode();
        if (status >= 200 && status < 300) {
            HttpEntity entity = response.getEntity();
            if(entity == null) {
                return " Нет ответа от сервера ";
            } else {
                return EntityUtils.toString(entity); // иначе вернуть
            }

        } else {
            return "Error status -> "  +status;
        }
    }
}

