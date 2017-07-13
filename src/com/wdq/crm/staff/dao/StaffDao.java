package com.wdq.crm.staff.dao;

import com.wdq.crm.staff.domain.CrmStaff;

import java.util.List;

/**
 * Created by haier on 2017/7/9.
 */
public interface StaffDao {
    /**
     * 通过用户名和密码查询用户
     * @param loginName
     * @param loginPwd
     * @return
     */
    CrmStaff find(String loginName,String loginPwd);

    List<CrmStaff> findAll();

    CrmStaff findStaffById(String staffId);

}
