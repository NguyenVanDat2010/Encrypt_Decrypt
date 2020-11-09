//package com.example.demoencrypt.utils;
//
//import java.security.*;
//
//public class GenerateKeys {
//    private KeyPairGenerator keyGen;
//    private PrivateKey privateKey;
//    private PublicKey publicKey;
//
//    public GenerateKeys(){}
//
//    public KeyPairGenerator getKeyGen() {
//        return keyGen;
//    }
//
//    public void setKeyGen(KeyPairGenerator keyGen) {
//        this.keyGen = keyGen;
//    }
//
//    public PrivateKey getPrivateKey() {
//        return privateKey;
//    }
//
//    public void setPrivateKey(PrivateKey privateKey) {
//        this.privateKey = privateKey;
//    }
//
//    public PublicKey getPublicKey() {
//        return publicKey;
//    }
//
//    public void setPublicKey(PublicKey publicKey) {
//        this.publicKey = publicKey;
//    }
//
//    public void generateSecureKeys() throws NoSuchAlgorithmException {
//        this.keyGen = KeyPairGenerator.getInstance("RSA");
//        this.keyGen.initialize(1024);
//    }
//
//    // Khởi tạo cặp khóa
//    private void createKeys(){
//        KeyPair pair = this.keyGen.generateKeyPair();
//        this.privateKey = pair.getPrivate();
//        this.publicKey = pair.getPublic();
//    }
//}
