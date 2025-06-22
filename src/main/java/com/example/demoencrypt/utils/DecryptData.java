package com.example.demoencrypt.utils;

import com.example.demoencrypt.model.AppUser;
import com.example.demoencrypt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
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
            byte[] bytes = Base64.getDecoder().decode(privateKey);
        // Tạo private key
            PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(bytes);

            KeyFactory factory = KeyFactory.getInstance("RSA");
            PrivateKey privKey = factory.generatePrivate(spec);

            // Giải mã dữ liệu
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.DECRYPT_MODE, privKey);

            byte[] decryptOut = cipher.doFinal(Base64.getDecoder().decode(username));
            return new String(decryptOut);
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
        return null;
    }
}
