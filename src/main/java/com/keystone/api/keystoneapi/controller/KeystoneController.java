package com.keystone.api.keystoneapi.controller;

import com.keystone.api.keystoneapi.model.KeystoneRequest;
import com.keystone.api.keystoneapi.services.KeystoneService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KeystoneController
{
    KeystoneService keystoneService = new KeystoneService();

    @PostMapping("/keystone")
    KeystoneRequest create(@RequestBody KeystoneRequest keystoneRequest)
    {
        if(keystoneRequest.getArchitecture() != null && keystoneRequest.getMode() != null)
        {
            keystoneRequest.setValidRequest(true);
            boolean isSuccessful = keystoneService.execute(keystoneRequest);
            keystoneRequest.setSuccess(isSuccessful);
        }

        return keystoneRequest;
    }
}
