package com.practice.controller;

import com.practice.db.service.EmpService;
import com.practice.db.vo.EmpVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainRestController {

    @Autowired
    EmpService empService;

    @GetMapping(value = "/mainframe")
    public List<EmpVO> mainframe(Model model) {

        List<EmpVO> testAll = empService.getEmpList();
        return testAll;
    }
}
