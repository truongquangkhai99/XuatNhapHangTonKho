/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import static java.lang.Math.random;
import static java.lang.StrictMath.random;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.Random;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 *
 * @author Admin
 */
public class HashingPassWord {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InvalidKeySpecException, NoSuchAlgorithmException {
        System.out.println(doHashing("123"));
    }
    public static String doHashing(String passWord) throws NoSuchAlgorithmException{
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(passWord.getBytes());
        byte[] resultByteArray =messageDigest.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : resultByteArray) {
            sb.append(String.format("%2x", b));
        }
        return sb.toString();
    }
    
}
