package com.zch.controller;

import com.zch.entity.Authority;
import com.zch.repository.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

/**
 * Created by chensuo on 2018-7-31.
 */
@Controller
public class AuthorityController {
    @Autowired
    private AuthorityRepository authorityRepository;

    /**
     * 权限列表页面
     * @param model
     * @return
     */
    @RequestMapping("/auth_ls")
    public String authorityList(Model model) {
        List<Authority> authorityList = authorityRepository.getAllAuthorityList();
        model.addAttribute("authority_list", authorityList);
        return "auth_list";
    }
}
