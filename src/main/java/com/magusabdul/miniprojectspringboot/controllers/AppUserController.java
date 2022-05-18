package com.magusabdul.miniprojectspringboot.controllers;

import com.magusabdul.miniprojectspringboot.dto.AppUserData;
import com.magusabdul.miniprojectspringboot.dto.ResponseData;
import com.magusabdul.miniprojectspringboot.models.entities.AppUser;
import com.magusabdul.miniprojectspringboot.services.AppUserService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class AppUserController {
    
    @Autowired
    private AppUserService appUserService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/register")
    public ResponseEntity<ResponseData<AppUser>> register(@RequestBody AppUserData userdata) {
        
        ResponseData<AppUser> responseData = new ResponseData<>();
        AppUser appUser = modelMapper.map(userdata, AppUser.class);
        responseData.setPayload(appUserService.registerAppUser(appUser));
        responseData.setStatus(true);
        responseData.getMessage().add("AppUser saved");

        return ResponseEntity.ok(responseData);
    }
}
