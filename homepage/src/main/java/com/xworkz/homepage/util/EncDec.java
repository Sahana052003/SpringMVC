package com.xworkz.homepage.util;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class EncDec {

    private static final String SECRET_KEY = "1234567890123456"; // 16-char key for AES.....This key must be same for ecrypt and decrypt the password

    // Encrypting the  plain text password
    public static String encrypt(String strToEncrypt) throws Exception {
        //Eg.  password: "Password@123" convert this password to byte array, and then wrapps that inot AES key object
        SecretKeySpec secretKey = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
        //Creating a cipher object
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
    }

    // Decrypt cipher text
    public static String decrypt(String strToDecrypt) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
    }
}



//Here this process is
//1.Plain text password -> Encrypted text -> then stored in DB
//2. Encrypted text -> Decrypted Back password -> Compared these password during signin.jsp