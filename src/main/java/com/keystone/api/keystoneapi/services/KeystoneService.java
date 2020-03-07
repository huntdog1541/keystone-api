package com.keystone.api.keystoneapi.services;

import com.keystone.api.keystoneapi.model.KeystoneRequest;
import keystone.Keystone;
import keystone.KeystoneEncoded;
import keystone.exceptions.AssembleFailedKeystoneException;

import java.util.Arrays;
import java.util.Collections;

public class KeystoneService {

    public boolean execute(KeystoneRequest request)
    {
        boolean isSuccessful = false;
        try(Keystone keystone = new Keystone(request.getArchitecture(), request.getMode()))
        {
            KeystoneEncoded encoded = keystone.assemble(request.getInstructions());
            System.out.println("Number of Statements: " + encoded.getNumberOfStatements());
            System.out.println("Address: " + encoded.getAddress());
            request.getOutput().setByteSize(request.getMode());
            request.getOutput().setMachineCode(encoded.getMachineCode());
            request.getOutput().setBytes(Collections.singletonList(Arrays.toString(encoded.getMachineCode())));
            request.getOutput().updateValues();
            System.out.println("Machine Code: " + Arrays.toString(encoded.getMachineCode()));
            isSuccessful = true;
        }
        catch(AssembleFailedKeystoneException e)
        {
            System.out.println(e.getMessage());
        }
        return isSuccessful;
    }
}
