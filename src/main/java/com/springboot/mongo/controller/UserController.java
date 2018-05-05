package com.springboot.mongo.controller;

import com.springboot.mongo.co.UserCo;
import com.springboot.mongo.dto.ResponseHandler;
import com.springboot.mongo.dto.UserDto;
import com.springboot.mongo.service.UserService;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService userService;

    //Create user
    @PostMapping("/create")
    public ResponseHandler<UserDto> signup(@Valid @RequestBody UserCo userCo) {
        UserDto userDto = userService.saveUser(userCo);
        return new ResponseHandler<UserDto>(200, userDto);
    }

    //Get User by id
    @GetMapping("/user/{id}")
    public ResponseHandler<UserDto> getUserById(@PathVariable String id) {
        return new ResponseHandler<UserDto>(200, userService.getUserById(id));
    }

    //Get list of user
    @GetMapping("/users")
    public ResponseHandler<List<UserDto>> getUsers(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer per_page) {
        return new ResponseHandler<List<UserDto>>(200, userService.getUsers(page, per_page));
    }

    //Update user
    @PutMapping("/user/{id}")
    public ResponseHandler<UserDto> updateUser(@PathVariable String id, @Valid @RequestBody UserCo userCo) {
        UserDto userDto = userService.updateUser(id, userCo);
        return new ResponseHandler<UserDto>(200, userDto);
    }

    //delete user
    @DeleteMapping("/user/{id}")
    public ResponseHandler<UserDto> deleteUserById(@PathVariable String id) {
        userService.deleteUserById(id);
        return new ResponseHandler<UserDto>(200, "User Deleted SuccessFully");
    }

}
