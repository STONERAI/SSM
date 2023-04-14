package com.atguigu.mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Emp {

    private Integer empId;

    private String empName;

    private Integer age;

    private String gender;

    private Integer deptId;

    private Dept dept;

}
