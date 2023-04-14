package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Emp;

public interface EmpMapper {

    /**
     * 根据员工Id查询员工信息
     * @param empId
     * @return
     */
    Emp getEmpByEmpId(Integer empId);
}
