package com.anisat.food.orchestrator.controller;

import com.anisat.food.orchestrator.controller.model.OrderServiceDto;
import com.anisat.food.orchestrator.convertor.OrchestratorConvertor;
import com.anisat.food.orchestrator.dao.OrchetratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedHashSet;
import java.util.Set;

@Controller
public class HomepageController {

    @Autowired
    OrchetratorRepository orchetratorRepository;

    @Autowired
    OrchestratorConvertor orchestratorConvertor;

    @RequestMapping(method = RequestMethod.GET,value = {",","/home","/index"})
    public String getHomepage() {
        return "home";
    }

    @GetMapping(value = "/api/v1/orchestrator/order",produces = "application/json")
    @ResponseBody
    public Set<OrderServiceDto> getAllNewOrders() {
        Set<OrderServiceDto> orderServiceDtos = new LinkedHashSet<>();
        orchetratorRepository.findAll().forEach(enti -> {
            orderServiceDtos.add(orchestratorConvertor.fromOrderServiceDaoToDto(enti));
        });
        return orderServiceDtos;
    }
}
