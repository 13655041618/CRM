package com.wdq.crm.department.dao;

import com.wdq.crm.department.domain.CrmDepartment;

import java.util.List;

/**
 * Created by haier on 2017/7/10.
 */
public interface DepartmentDao {
    List<CrmDepartment> findAll();
}
