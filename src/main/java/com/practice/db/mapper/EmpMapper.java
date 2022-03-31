package com.practice.db.mapper;

import com.practice.db.vo.EmpVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface EmpMapper {

    List<EmpVO> getEmpList();
}
