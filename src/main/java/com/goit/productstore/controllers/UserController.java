package com.goit.productstore.controllers;

import com.goit.productstore.models.role.Role;
import com.goit.productstore.models.role.RoleService;
import com.goit.productstore.models.user.User;
import com.goit.productstore.models.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final RoleService roleService;

    @RequestMapping("/user")
    public ModelAndView viewUserPage(){
        List<User> listUsers = userService.getAll();
        ModelAndView result = new ModelAndView("user");
        result.addObject("listUsers", listUsers);
        return result;
    }

    @RequestMapping("/createUser")
    public ModelAndView viewCreateUserPage(){
        User user = new User();
        ModelAndView result = new ModelAndView("createUser");
        result.addObject("user", user);
        List<Role> listRoles = roleService.getAll();
        result.addObject("listRoles", listRoles);
        return result;
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public ModelAndView saveNewUser(@ModelAttribute("user") User user) {
        user.setRoles(user.getRoles());
        userService.create(user);
        ModelAndView result = new ModelAndView("user");
        List<User> listUsers = userService.getAll();
        result.addObject("listUsers", listUsers);
        return result;
    }

    @RequestMapping("/updateUser/{uuid}")
    public ModelAndView showUpdateUserPage(@PathVariable(name = "uuid") UUID uuid) {
        ModelAndView result = new ModelAndView("updateUser");
        User user = userService.getById(uuid);
        result.addObject("user", user);
        List<Role> listRoles = roleService.getAll();
        result.addObject("listRoles", listRoles);
        return result;
    }

    @RequestMapping("/deleteUser/{uuid}")
    public ModelAndView deleteUser(@PathVariable(name = "uuid") UUID uuid){
        userService.deleteById(uuid);
        ModelAndView result = new ModelAndView("user");
        List<User> listUsers = userService.getAll();
        result.addObject("listUsers", listUsers);
        return result;
    }
}
