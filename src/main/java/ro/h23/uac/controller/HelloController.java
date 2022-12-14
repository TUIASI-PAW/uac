package ro.h23.uac.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class HelloController {

    // http://localhost:8080/hello
    @RequestMapping("/hello")
    public @ResponseBody String helloWorld() {
        return "Hello, World";
    }

    // http://localhost:8080/hellouser
    @RequestMapping("/hellouser")
    public @ResponseBody String helloUser() {
        return "Hello, User";
    }
}
