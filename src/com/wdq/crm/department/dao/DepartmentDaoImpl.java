package com.wdq.crm.department.dao;

import com.wdq.crm.department.domain.CrmDepartment;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by haier on 2017/7/10.
 */
public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao {
    @Override
    public List<CrmDepartment> findAll() {
        return (List<CrmDepartment>) this.getHibernateTemplate().find("from CrmDepartment");
    }
}
