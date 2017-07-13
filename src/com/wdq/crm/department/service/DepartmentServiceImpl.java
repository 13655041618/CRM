package com.wdq.crm.department.service;

import com.wdq.crm.department.dao.DepartmentDao;
import com.wdq.crm.department.domain.CrmDepartment;

import java.util.List;

/**
 * Created by haier on 2017/7/10.
 */
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentDao departmentDao;

    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override
    public List<CrmDepartment> findAll() {
        return departmentDao.findAll();
    }
}
