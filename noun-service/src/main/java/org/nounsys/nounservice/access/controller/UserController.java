package org.nounsys.nounservice.access.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:gaoxu
 * @create:2020-03-16 15:38
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @ApiOperation("用户登陆")
    @ApiImplicitParams({@ApiImplicitParam(name = "userName",value = "用户名",required = true,dataType = "String",paramType="query"),
            @ApiImplicitParam(name = "password",value = "密码",required = true,dataType = "String",paramType="query")})
    @PostMapping(value = "/login")
    public ResponseEntity Login(@RequestParam String userName, @RequestParam  String password){
        if (userName.equals("admin")&&password.equals("admin")){
            return ResponseEntity.ok("OK");
        }else{
            return ResponseEntity.ok("Fail");
        }
    }
}
