package com.zch.controller;

import com.zch.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by chensuo on 2018-7-31.
 */
@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

}