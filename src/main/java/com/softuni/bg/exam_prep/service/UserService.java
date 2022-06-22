package com.softuni.bg.exam_prep.service;

import com.softuni.bg.exam_prep.model.entity.User;
import com.softuni.bg.exam_prep.model.service.UserServiceModel;
import com.softuni.bg.exam_prep.model.view.UserViewModel;

import java.util.List;

public interface UserService {
    UserServiceModel registerUser(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    void loginUser(long id, String username);

    User findById(long id);

    List<UserViewModel> findAllUserAndCountOfOrdersOrderByCountDesc();
}
