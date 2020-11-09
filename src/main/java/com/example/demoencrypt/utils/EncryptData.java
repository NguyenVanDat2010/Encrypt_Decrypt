//package com.example.demoencrypt.utils;
//
//import com.example.demoencrypt.model.AppUser;
//import com.example.demoencrypt.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//import javax.crypto.*;
//import java.io.IOException;
//import java.io.Serializable;
//import java.security.InvalidKeyException;
//import java.security.KeyFactory;
//import java.security.NoSuchAlgorithmException;
//import java.security.PublicKey;
//import java.security.spec.InvalidKeySpecException;
//import java.security.spec.X509EncodedKeySpec;
//import java.util.Arrays;
//import java.util.Base64;
//
//@Component
//public class EncryptData {
//    @Autowired
//    private UserService userService;
//
//    @Value("${file.encrypt.publicKey}")
//    private String publicKey;
//
//    public UserService getUserService() {
//        return userService;
//    }
//
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }
//
//    public String getPublicKey() {
//        return publicKey;
//    }
//
//    public void setPublicKey(String publicKey) {
//        this.publicKey = publicKey;
//    }
//
//    public String  encryptData(String username) {
//        try {
//            // Tạo public key
//            X509EncodedKeySpec spec = new X509EncodedKeySpec(publicKey.getBytes());
//            KeyFactory factory = KeyFactory.getInstance("RSA");
//            PublicKey pubKey = factory.generatePublic(spec);
//
//            // Mã hoá dữ liệu
//            Cipher cipher = Cipher.getInstance("RSA");
//            cipher.init(Cipher.ENCRYPT_MODE, pubKey);
//            byte encryptOut[] = cipher.doFinal(username.getBytes());
//            String strEncrypt = Base64.getEncoder().encodeToString(encryptOut);
//            System.out.println("Chuỗi sau khi mã hoá: " + strEncrypt);
//            return strEncrypt;
//        } catch (Exception e) {
//            System.out.println("Error: " + e.getMessage());
//        }
//        return null;
//    }
//}
