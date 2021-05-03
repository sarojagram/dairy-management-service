package com.agraminfotech.dairymanagement.security.user;

import com.agraminfotech.dairymanagement.base.ApiDTO;
import com.agraminfotech.dairymanagement.security.BCryptPasswordEncoder;
import com.agraminfotech.dairymanagement.security.role.Role;
import com.agraminfotech.dairymanagement.security.role.RoleService;
import com.agraminfotech.dairymanagement.security.user.dto.UserDTO;
import com.agraminfotech.dairymanagement.security.user.dto.UserMapper;
import com.agraminfotech.dairymanagement.utils.Helper;
import com.agraminfotech.dairymanagement.utils.Strings;
import com.agraminfotech.dairymanagement.utils.dateutils.DateUtils;
import com.agraminfotech.dairymanagement.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class UserController {

    private UserService userService;

    private UserMapper userMapper;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private RoleService roleService;

    private Helper helper;

    @Autowired
    private UserController(UserService userService, UserMapper userMapper,
                           BCryptPasswordEncoder bCryptPasswordEncoder,RoleService roleService,
                           Helper helper){
        this.userService = userService;
        this.userMapper = userMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.roleService = roleService;
        this.helper = helper;
    }

    @PostMapping(value = "root/user/save")
    private ResponseEntity<Response> saveRootUser(@RequestBody UserDTO userDTO){
        String message = "";
        int statusCode;
        try{
            if(userService.isRootUserAlreadyPresent())
                return Helper.getResponseEntity(null,"Seems like already root user present so can not create another one.",100);
            User user = userMapper.toEntity(userDTO);
            user.setUsername(userDTO.getUsername().toLowerCase(Locale.ROOT));
            if(userService.existsByUsername(user.getUsername()))
                return Helper.getResponseEntity(null,Strings.USERNAME_ALREADY_EXISTS,100);
            if(userService.existsByEmail(user.getEmail()))
                return Helper.getResponseEntity(null,Strings.EMAIL_ALREADY_EXISTS,100);
            Date currentDate = DateUtils.getCurrentDate(true);
            user.setCreatedDate(currentDate);
            user.setEnabled(true);
            user.setPassword(bCryptPasswordEncoder.bCryptPasswordEncoder().encode(user.getPassword()));
            Collection<Role> roles = new ArrayList<>();
            Role role = roleService.findByName("ADMIN");
            roles.add(role);
            user.setRoles(roles);
            user = userService.saveOrUpdate(user);
            userDTO = userMapper.toDTO(user);
            message = Strings.SAVE_SUCCESSFULLY;
            statusCode = 200;
        }catch(Exception e){
            e.printStackTrace();
            message = Strings.SOMETHING_WENT_WRONG;
            statusCode = 500;
        }

        return  Helper.getResponseEntity(userDTO,message,statusCode);
    }

    @PostMapping(value = "admin/user/save")
    private ResponseEntity<Response> save(@RequestBody UserDTO userDTO) {

        String message = "";
        int statusCode;
        try{
            User user = userMapper.toEntity(userDTO);
            user.setUsername(userDTO.getUsername().toLowerCase(Locale.ROOT));
            if(userService.existsByUsername(user.getUsername()))
                return Helper.getResponseEntity(null,Strings.USERNAME_ALREADY_EXISTS,100);
            if(userService.existsByEmail(user.getEmail()))
                return Helper.getResponseEntity(null,Strings.EMAIL_ALREADY_EXISTS,100);

            Date currentDate = DateUtils.getCurrentDate(true);
            user.setCreatedDate(currentDate);
            User currentUser = helper.getCurrentUser();
            user.setCreatedBy(currentUser);
            user.setEnabled(true);
            user.setPassword(bCryptPasswordEncoder.bCryptPasswordEncoder().encode(user.getPassword()));
            Collection<Long> roleIds = userDTO.getRoleIds();
            Collection<Role> roles = new ArrayList<>();
            if(roleIds.size() > 0){
                for (Long id: roleIds){
                    Role role = roleService.findById(id);
                    if(role != null){
                        roles.add(role);
                    }else return  Helper.getResponseEntity(null,"No such role found in our database.Please contact admin.",100);
                }
            }else return  Helper.getResponseEntity(null,"Seems like no any role assign to this user.First assign role to perform action.", 100);
            user.setRoles(roles);
            user = userService.saveOrUpdate(user);
            userDTO = userMapper.toDTO(user);
            message = Strings.SAVE_SUCCESSFULLY;
            statusCode = 200;
        }catch(Exception e){
            e.printStackTrace();
           message = Strings.SOMETHING_WENT_WRONG;
           statusCode = 500;
        }

       return Helper.getResponseEntity(userDTO,message,statusCode);
    }

    @GetMapping(value = "user/findAll/basicInfo")
    private ResponseEntity<Response> findAllBasicInfo(){
        List<ApiDTO> users = null;
        String message = "";
        int statusCode;
        try{
            users = userService.findAllBasic();
            statusCode = 200;
        }catch(Exception e){
            e.printStackTrace();
            message = Strings.SOMETHING_WENT_WRONG;
            statusCode = 500;
        }

        return Helper.getResponseEntity(users,message, statusCode);
    }

    @GetMapping(value = "admin/user/findAll/detailInfo")
    private ResponseEntity<Response> findAllDetailInfo(){
        List<UserDTO> users = null;
        String message = "";
        int statusCode;
        try{
            users = userService.findAllDetailInfo();
            statusCode = 200;
        }catch(Exception e){
            e.printStackTrace();
            message = Strings.SOMETHING_WENT_WRONG;
            statusCode = 500;
        }

        return Helper.getResponseEntity(users,message, statusCode);
    }

    @GetMapping(value = "user/findById")
    private ResponseEntity<Response> findById(Long id){
        UserDTO user = null;
        String message = "";
        int statusCode;
        try{
           user = userService.findUserDetailById(id);
            statusCode = 200;
        }catch(Exception e){
            e.printStackTrace();
            message = Strings.SOMETHING_WENT_WRONG;
            statusCode = 500;
        }

        return Helper.getResponseEntity(user,message, statusCode);
    }

    @GetMapping(value = "user/validate/username")
    private ResponseEntity<Response> validateUsername(String username){
        String message = "";
        int statusCode;
        try{
            if(userService.existsByUsername(username)){
                message = Strings.USERNAME_ALREADY_EXISTS;
                statusCode = 100;
            }else statusCode = 200;
        }catch(Exception e){
            e.printStackTrace();
            message = Strings.SOMETHING_WENT_WRONG;
            statusCode = 500;
        }

        return Helper.getResponseEntity(null,message, statusCode);
    }

    @GetMapping(value = "user/validate/email")
    private ResponseEntity<Response> validateEmail(String email){
        String message = "";
        int statusCode;
        try{
            if(userService.existsByEmail(email)){
                message = Strings.EMAIL_ALREADY_EXISTS;
                statusCode = 100;
            }else statusCode = 200;
        }catch(Exception e){
            e.printStackTrace();
            message = Strings.SOMETHING_WENT_WRONG;
            statusCode = 500;
        }

        return Helper.getResponseEntity(null,message, statusCode);
    }

    @PutMapping(value = "admin/user/enabledOrDisabled")
    private ResponseEntity<Response> enabledOrDisabledUser(boolean status){
        String message = "";
        int statusCode ;
        try{
            User user = helper.getCurrentUser();
            user.setEnabled(status);
            userService.saveOrUpdate(user);
            message = Strings.UPDATE_SUCCESSFULLY;
            statusCode = 200;
        }catch(Exception e){
           e.printStackTrace();
           message = Strings.SOMETHING_WENT_WRONG;
           statusCode = 500;
        }

        return Helper.getResponseEntity(null,message,statusCode);
    }

    @PutMapping(value = "admin/user/resetPassword")
    private ResponseEntity<Response> resetUserPasswordByAdmin(@RequestBody UserDTO userDTO){
        String message = "";
        int statusCode ;
        try{
            User user = helper.getCurrentUser();
            user.setPassword(bCryptPasswordEncoder.bCryptPasswordEncoder().encode(userDTO.getPassword()));
            userService.saveOrUpdate(user);
            message = Strings.UPDATE_SUCCESSFULLY;
            statusCode = 200;
        }catch(Exception e){
            e.printStackTrace();
            message = Strings.SOMETHING_WENT_WRONG;
            statusCode = 500;
        }

        return Helper.getResponseEntity(null,message,statusCode);
    }

    @PutMapping(value = "user/resetPassword")
    private ResponseEntity<Response> resetUserPasswordByThemSelves(@RequestBody UserDTO userDTO){
        String message = "";
        int statusCode ;
        try{
            User user = helper.getCurrentUser();
            if(bCryptPasswordEncoder.bCryptPasswordEncoder().matches(userDTO.getPassword(),user.getPassword())){
                user.setPassword(bCryptPasswordEncoder.bCryptPasswordEncoder().encode(userDTO.getPassword()));
                userService.saveOrUpdate(user);
                message = Strings.UPDATE_SUCCESSFULLY;
                statusCode = 200;
            }else{
                message = "Seems like old password does not matched.Please try again!";
                statusCode = 100;
            }
        }catch(Exception e){
            e.printStackTrace();
            message = Strings.SOMETHING_WENT_WRONG;
            statusCode = 500;
        }

        return Helper.getResponseEntity(null,message,statusCode);
    }
}
