package com.softuni.bg.exam_prep.service;

import com.softuni.bg.exam_prep.model.service.OrderServiceModel;
import com.softuni.bg.exam_prep.model.view.OrderViewModel;

import java.util.List;

public interface OrderService {
    void addOrder(OrderServiceModel map);

    List<OrderViewModel> findAllOrdersOrderByPriceDesc();

    void readyOrder(Long id);
}
