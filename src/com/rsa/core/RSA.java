package com.rsa.core;

import javax.swing.*;
import java.math.BigInteger;
import java.util.Random;

public class RSA {
    public void rsa_encrypt(String text , JTextArea resultArea)
    {
        BigInteger[] message = new BigInteger[text.length()];
        BigInteger[] cryto_message = new BigInteger[text.length()];

        resultArea.setText("");
        Random random = new Random();

        int bits = 128;
        BigInteger p_val = BigInteger.probablePrime(bits , random);
        BigInteger q_val = BigInteger.probablePrime(bits , random);
        resultArea.append("p = " + p_val.toString() + "\n");
        resultArea.append("q = " + q_val.toString() + "\n");
        BigInteger n_val = p_val.multiply(q_val);
        resultArea.append("n = " + n_val.toString() + "\n");
        BigInteger phi_val = p_val.subtract(BigInteger.valueOf(1)).multiply(q_val.subtract(BigInteger.valueOf(1)));
        resultArea.append("phi_val = " + phi_val.toString() + "\n");
        BigInteger d_val;
        BigInteger e = new BigInteger("3");
        while (phi_val.gcd(e).intValue()>1){
            e = e.add(new BigInteger("2"));
        }
        d_val = e.modInverse(phi_val);
        resultArea.append("e = " + e.toString() + "\n");
        resultArea.append("d = " + d_val.toString() + "\n");
        for(int i = 0 ; i < text.length(); i++)
        {
            resultArea.append(""+ text.codePointAt(i) + " ");
            message[i] = BigInteger.valueOf(text.codePointAt(i));
        }

        for(int i = 0; i < text.length(); i++)
        {
            cryto_message[i] = message[i].modPow(e , n_val);
           // resultArea.append(cryto_message[i].toString() + " ");
        }

        for(int i = 0; i< text.length(); i++)
        {
            resultArea.append(Character.toString(cryto_message[i].modPow(d_val,n_val).intValue()));
        }



    }
}
