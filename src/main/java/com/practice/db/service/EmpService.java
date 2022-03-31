package com.practice.db.service;

import com.practice.db.mapper.EmpMapper;
import com.practice.db.vo.EmpVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpService {

    EmpMapper empMapper;

    /*
        생성자를 직접 명시하여 EmpService초기화 될때 인터페이스에 생성자 강제주입.
     */
    public EmpService(EmpMapper empMapper) {
        this.empMapper = empMapper;
    }
    public List<EmpVO> getEmpList() {
        return empMapper.getEmpList();
    }
}
