package com.wdq.crm.post.dao;

import com.wdq.crm.department.domain.CrmDepartment;
import com.wdq.crm.post.domain.CrmPost;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by haier on 2017/7/10.
 */
public class PostDaoImpl extends HibernateDaoSupport implements PostDao {
    @Override
    public List<CrmPost> findAll(CrmDepartment crmDepartment) {
        return (List<CrmPost>) this.getHibernateTemplate().find("from CrmPost where department = ?",crmDepartment);
    }
}
