package com.example.demoencrypt.utils;

import com.example.demoencrypt.model.AppUser;
import com.example.demoencrypt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.FileInputStream;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Arrays;
import java.util.Base64;

@Component
public class DecryptData {
    @Autowired
    private UserService userService;

    @Value("${file.encrypt.privateKey}")
    private String privateKey;

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String decryptData(String username) {
        try {
            byte[] bytes = privateKey.getBytes("UTF-8");
//            System.out.println(bytes);
        // Tạo private key
//            PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(bytes);

//            System.out.println(privateKey.getBytes());


            // Đọc file chứa private key
//            FileInputStream fis = new FileInputStream("D:\\CRYPPT\\demo1\\src\\com\\demo\\RSA/privateKey.txt");
//            byte[] b = new byte[fis.available()];
//            fis.read(b);
//            fis.close();
//
//            // Tạo private key
//            PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(b);

            KeyFactory factory = KeyFactory.getInstance("RSA");
            PrivateKey privKey = factory.generatePrivate(new PKCS8EncodedKeySpec(getPrivateKey().getBytes()));

            // Giải mã dữ liệu
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, privKey);

            byte[] decryptOut = cipher.doFinal(Base64.getDecoder().decode(username));
            return new String(decryptOut);
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
        return null;
    }
}
