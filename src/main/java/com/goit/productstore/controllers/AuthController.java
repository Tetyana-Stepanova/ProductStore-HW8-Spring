package com.goit.productstore.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class AuthController {

    @RequestMapping(value = {"/main", "/"}, method = RequestMethod.GET)
    public ModelAndView viewMainPage(){
        ModelAndView result = new ModelAndView("main");
        return result;
    }

}
