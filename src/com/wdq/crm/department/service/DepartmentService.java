package com.wdq.crm.department.service;

import com.wdq.crm.department.domain.CrmDepartment;

import java.util.List;

/**
 * Created by haier on 2017/7/10.
 */
public interface DepartmentService {
    List<CrmDepartment> findAll();
}
