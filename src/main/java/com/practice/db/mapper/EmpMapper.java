package com.practice.db.mapper;

import com.practice.db.vo.EmpVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpMapper {

    List<EmpVO> getEmpList();
}
