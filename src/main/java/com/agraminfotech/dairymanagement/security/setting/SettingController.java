package com.agraminfotech.dairymanagement.security.setting;

import com.agraminfotech.dairymanagement.security.user.UserService;
import com.agraminfotech.dairymanagement.utils.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user/setting")
public class SettingController {

    private UserService userService;

    private SettingService settingService;

    private Helper helper;

    @Autowired
    private SettingController(UserService userService, SettingService settingService,Helper helper){
        this.userService = userService;
        this.settingService = settingService;
        this.helper = helper;
    }

}
