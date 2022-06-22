package com.softuni.bg.exam_prep.web;

import com.softuni.bg.exam_prep.model.view.OrderViewModel;
import com.softuni.bg.exam_prep.security.CurrentUser;
import com.softuni.bg.exam_prep.service.OrderService;
import com.softuni.bg.exam_prep.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final OrderService orderService;
    private final UserService userService;


    public HomeController(CurrentUser currentUser, OrderService orderService, UserService userService) {
        this.currentUser = currentUser;
        this.orderService = orderService;
        this.userService = userService;
    }

    @GetMapping()
    public String index(Model model){
        if (currentUser.getId() == null){
            return "index";
        }


        List<OrderViewModel> orderViewModels = orderService.findAllOrdersOrderByPriceDesc();
        model.addAttribute("orders",orderViewModels);
        model.addAttribute("totalTime",orderViewModels
                .stream().map(orderViewModel -> orderViewModel.getCategory().getNeededTime())
                .reduce(Integer::sum).orElse(0));

        model.addAttribute("users",userService.findAllUserAndCountOfOrdersOrderByCountDesc());

        return "home";
    }

}
