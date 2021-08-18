package com.example.swagger.controller;

import com.example.swagger.dto.UserReq;
import com.example.swagger.dto.UserRes;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"API 정보를 제공하는 Controller"})
@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    // Param 별로 붙히면 가독성이 떨어진다.
    @GetMapping("/plus/{x}")
    public int plus(
            @ApiParam(value = "x 값")
            @PathVariable int x
            ,
            @ApiParam(value = "y 값")
            @RequestParam int y) {
        return x + y;
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "x", required = true, paramType = "path", dataType = "int", value = "x 값"),
            @ApiImplicitParam(name = "y", required = true, paramType = "query", dataType = "int", value = "y 값")
    })
    @GetMapping("/plus2/{x}")
    public int plus2(@PathVariable int x, @RequestParam int y) {
        return x + y;
    }


    @ApiResponse(code = 502, message = "사용자의 나이가 10살 이하일때")
    @ApiOperation(value = "사용자의 이름과 나이를 echo하는 메소드")
    @GetMapping("/user")
    public UserRes user(UserReq userReq) {
        return new UserRes(userReq.getName(), userReq.getAge());
    }

    @PostMapping("/user")
    public UserRes userPost(@RequestBody UserReq userReq) {
        return new UserRes(userReq.getName(), userReq.getAge());
    }
}
