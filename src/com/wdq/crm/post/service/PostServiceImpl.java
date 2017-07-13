package com.wdq.crm.post.service;

import com.wdq.crm.department.domain.CrmDepartment;
import com.wdq.crm.post.dao.PostDao;
import com.wdq.crm.post.domain.CrmPost;

import java.util.List;

/**
 * Created by haier on 2017/7/10.
 */
public class PostServiceImpl implements PostService {
    private PostDao postDao;

    public void setPostDao(PostDao postDao) {
        this.postDao = postDao;
    }

    @Override
    public List<CrmPost> findAll(CrmDepartment crmDepartment) {
        return postDao.findAll(crmDepartment);
    }
}
