package com.wdq.crm.post.dao;

import com.wdq.crm.base.BaseDao;
import com.wdq.crm.department.domain.CrmDepartment;
import com.wdq.crm.post.domain.CrmPost;

import java.util.List;

/**
 * Created by haier on 2017/7/10.
 */
public interface PostDao extends BaseDao<CrmPost> {
    List<CrmPost> findAll(CrmDepartment crmDepartment);
}
