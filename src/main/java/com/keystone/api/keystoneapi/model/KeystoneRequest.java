package com.keystone.api.keystoneapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import keystone.KeystoneArchitecture;
import keystone.KeystoneMode;

import java.util.Collections;
import java.util.List;

public class KeystoneRequest {

    @JsonProperty("architecture")
    private KeystoneArchitecture architecture;
    @JsonProperty("mode")
    private KeystoneMode mode;
    private boolean isSuccess = false;
    private boolean isValidRequest = false;
    //@JsonProperty("instructions")
    //private List<String> instructions;
    @JsonProperty("instructions")
    private String instructions;
    @JsonProperty("leadingZeros")
    private boolean leadingZeros = false;
    private Output output;

    public KeystoneRequest()
    {
        architecture = KeystoneArchitecture.X86;
        mode = KeystoneMode.Mode32;
        instructions = "";
        isValidRequest = true;
        output = new Output();
        output.setKeystoneRequest(this);
    }

    @Override
    public String toString()
    {
        return "Architecture: " + architecture.name() + " Mode: " + mode.name() + " Instructions: [" +
                String.join("\n", instructions) + "] Output: [" + output.toString() +
                " isSuccess: " + isSuccess + " isValidRequest: " + isValidRequest + "\n";
    }

    public KeystoneArchitecture getArchitecture() {
        return architecture;
    }

    public void setArchitecture(KeystoneArchitecture architecture) {
        this.architecture = architecture;
    }

    public KeystoneMode getMode() {
        return mode;
    }

    public void setMode(KeystoneMode mode) {
        this.mode = mode;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public boolean isValidRequest() {
        return isValidRequest;
    }

    public void setValidRequest(boolean validRequest) {
        isValidRequest = validRequest;
    }

    /*public List<String> getInstructions() {
        return instructions;
    }*/

    /*public void setInstructions(List<String> instructions) {
        this.instructions = instructions;
    }*/

    public String getInstructions()
    {
        return instructions;
    }

    public void setInstructions(String instructions)
    {
        this.instructions = instructions;
    }

    public Output getOutput() {
        return output;
    }

    public void setOutput(Output output) {
        this.output = output;
    }

    public boolean isLeadingZeros() {
        return leadingZeros;
    }

    public void setLeadingZeros(boolean leadingZeros) {
        this.leadingZeros = leadingZeros;
    }
}
