package com.practice.db.service;

import com.practice.db.mapper.EmpMapper;
import com.practice.db.vo.EmpVO;


import java.util.List;


public interface EmpService {

    public List<EmpVO> getEmpList();
}
