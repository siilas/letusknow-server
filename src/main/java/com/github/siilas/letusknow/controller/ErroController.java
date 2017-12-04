package com.github.siilas.letusknow.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErroController implements ErrorController {

    private static final String ERROR_PATH = "/erro";

    @RequestMapping(ERROR_PATH)
    public String error() {
        return "erro";
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

}
