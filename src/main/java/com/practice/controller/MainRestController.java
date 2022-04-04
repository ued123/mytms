package com.practice.controller;

import com.practice.db.service.EmpService;
import com.practice.db.vo.EmpVO;
import com.practice.mq.MyMqttClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainRestController {

    @Autowired
    EmpService empService;

    @Autowired
    MyMqttClient mqttClient;

    @GetMapping(value = "/mainframe")
    public List<EmpVO> mainframe(Model model) {

        List<EmpVO> testAll = empService.getEmpList();
        return testAll;
    }

    @GetMapping(value = "/mqttboard")
    public String mattTest(Model model) throws InterruptedException {

        //Receive message from MyMqttClient not Machine

        mqttClient.init("map");

        Thread.sleep(1000);

        mqttClient.subscribe(0);

        Thread.sleep(1000);
        return "mqtt test begin";
    }
}
