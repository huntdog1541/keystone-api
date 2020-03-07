package com.keystone.api.keystoneapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import keystone.KeystoneMode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Output
{
    private byte[] machineCode;
    private List<String> bytes;
    private List<String> binary;
    private List<String> hex;
    private List<String> octal;


    @JsonIgnore
    private KeystoneRequest keystoneRequest;
    @JsonIgnore
    private int byteSize;
    @JsonIgnore
    private boolean leadingZeros = false;

    public Output()
    {
        bytes = new ArrayList<>();
        binary = new ArrayList<>();
        hex = new ArrayList<>();
        octal = new ArrayList<>();
    }

    @Override
    public String toString()
    {
        return "Machine Code: " + Arrays.toString(machineCode) + " Bytes: " + String.join("\n", bytes) +
                " Binary: " + String.join("\n", binary) +
                " Hex: " + String.join("\n", hex) + " Octal: " + String.join("\n", octal);
    }

    public void SetAllValues(List<String> bytes)
    {

    }

    public void updateValues()
    {
        leadingZeros = keystoneRequest.isLeadingZeros();
        System.out.println("Leading Zeros: " + keystoneRequest.isLeadingZeros());
        System.out.println("Byte Size: " + byteSize);
        for(byte b : machineCode)
        {
            System.out.println(b);
            binary.add(convertByteToBinary(b));
            hex.add(convertByteToHex(b));
            octal.add(convertByteToOctal(b));
        }
    }

    private String convertByteToBinary(byte b)
    {
        String binary = String.format("%8s", Integer.toBinaryString(b & 0xFF));
        return leadingZeros? binary.replace(' ', '0') : binary.trim();
    }

    private String convertByteToHex(byte b)
    {
        return String.format("%2s", Integer.toHexString(b & 0xFF)).replace(' ', '0');
    }

    private String convertByteToOctal(byte b)
    {
        return String.format("%3s", Integer.toOctalString(b & 0xFF)).replace(' ', '0');
    }

    public byte[] getMachineCode() {
        return machineCode;
    }

    public void setMachineCode(byte[] machineCode) {
        this.machineCode = machineCode;
    }

    public List<String> getBytes() {
        return bytes;
    }

    public void setBytes(List<String> bytes) {
        this.bytes = bytes;
    }

    public List<String> getBinary() {
        return binary;
    }

    public void setBinary(List<String> binary) {
        this.binary = binary;
    }

    public List<String> getHex() {
        return hex;
    }

    public void setHex(List<String> hex) {
        this.hex = hex;
    }

    public List<String> getOctal() {
        return octal;
    }

    public void setOctal(List<String> octal) {
        this.octal = octal;
    }

    public boolean isLeadingZeros() {
        return leadingZeros;
    }

    public void setLeadingZeros(boolean leadingZeros) {
        this.leadingZeros = leadingZeros;
    }

    public KeystoneRequest getKeystoneRequest() {
        return keystoneRequest;
    }

    public void setKeystoneRequest(KeystoneRequest keystoneRequest) {
        this.keystoneRequest = keystoneRequest;
    }

    public void setByteSize(KeystoneMode mode)
    {
        switch (mode)
        {
            case Mode16: byteSize = 16; break;
            case Mode32: byteSize = 32; break;
            case Mode64: byteSize = 64; break;
        }
    }
}
