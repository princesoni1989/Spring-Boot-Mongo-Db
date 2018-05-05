package com.springboot.mongo.service;

import com.springboot.mongo.co.UserCo;
import com.springboot.mongo.dao.UserRepository;
import com.springboot.mongo.dto.UserDto;
import com.springboot.mongo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDto saveUser(UserCo userCo) {
        User user = new User();
        user.setUsername(userCo.getUsername());
        user.setEmail(userCo.getEmail());
        user.setPassword(userCo.getPassword());
        user.setFirstName(userCo.getFirstName());
        user.setLastName(userCo.getLastName());
        User userResponse = userRepository.save(user);
        return new UserDto().getInstance(userResponse);
    }


    public UserDto getUserById(String id) {
        Optional<User> user = userRepository.findById(id);
        return new UserDto().getInstance(user.get());
    }

    public List<UserDto> getUsers(Integer page, Integer per_page) {
        int pageNo = (page != null) ? page : 0;
        int per_page_no = (per_page != null) ? per_page : 10;
        PageRequest pageRequest = new PageRequest(pageNo, per_page_no);
        return new UserDto().getInstance(userRepository.findAll(pageRequest));

    }

    public UserDto updateUser(String id, UserCo userCo) {
        Optional<User> user = userRepository.findById(id);
        User updateUser = user.get();
        updateUser.setUsername(userCo.getUsername());
        updateUser.setEmail(userCo.getEmail());
        updateUser.setPassword(userCo.getPassword());
        updateUser.setFirstName(userCo.getFirstName());
        updateUser.setLastName(userCo.getLastName());
        User userResponse = userRepository.save(updateUser);
        return new UserDto().getInstance(userResponse);
    }

    public void deleteUserById(String id) {
        userRepository.deleteById(id);
    }
}
