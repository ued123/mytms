package com.practice.db.service;

import com.practice.db.mapper.EmpMapper;
import com.practice.db.vo.EmpVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class EmpServiceImpl implements EmpService {

    private final EmpMapper empMapper;

    public EmpServiceImpl(EmpMapper empMapper) {
        this.empMapper = empMapper;
    }

    @Override
    public List<EmpVO> getEmpList() {
        return empMapper.getEmpList();
    }
}
