package com.example.demoencrypt.controller;

import com.example.demoencrypt.model.AppUser;
import com.example.demoencrypt.service.UserService;
import com.example.demoencrypt.utils.DecryptData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/api/users")
public class ApiController {
    @Autowired
    private UserService userService;

    @Autowired
    private DecryptData decryptData;

//    @Autowired
//    private EncryptData encryptData;

    @GetMapping("/getUserByUsername")
    public ResponseEntity<?> getUserByUsername(@PathParam("username") String username){
        System.out.println(username);
        String uname = decryptData.decryptData(username);
        System.out.println(uname);
        return new ResponseEntity<>(userService.getUserByUsername(uname), HttpStatus.OK);
    }
}
