package com.magusabdul.miniprojectspringboot.services;

import com.magusabdul.miniprojectspringboot.models.repos.AppUserRepo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = AppUserService.class)
class AppUserServiceTest {

    @MockBean
    private AppUserRepo appUserRepo;

    @Autowired
    private AppUserService appUserService;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Test
    void testLoadUserByUsername() {  

    }

    @Test
    void testRegisterAppUser() {

    }
}
