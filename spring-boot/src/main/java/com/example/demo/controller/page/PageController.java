package com.example.demo.controller.page;

import com.example.demo.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {

    @RequestMapping("/main")
    public String main() {
        return "main.html";
    }

    /*
    * 컨트롤러에서는 ResponseBody 사용하지 않는게 맞고 혹시나 그러해야할시에만 사용하는게 ResponseBody | GetMapping
    * */
    @ResponseBody
    @GetMapping("/user")
    public User user() {
        var user = new User();
        user.setName("센 네임");
        user.setAddress("fast 캠퍼스");
        return user;
    }
}
