package com.wdq.crm.post.service;

import com.wdq.crm.department.domain.CrmDepartment;
import com.wdq.crm.post.domain.CrmPost;

import java.util.List;

/**
 * Created by haier on 2017/7/10.
 */
public interface PostService {
    List<CrmPost> findAll(CrmDepartment crmDepartment);
}
