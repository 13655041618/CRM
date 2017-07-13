package com.wdq.crm.staff.service;

import com.wdq.crm.staff.domain.CrmStaff;

import java.util.List;

/**
 * Created by haier on 2017/7/9.
 */
public interface StaffService {
    CrmStaff login(CrmStaff crmStaff);

    List<CrmStaff> findAllStaff();

    CrmStaff findStaffById(String staffId);


    void update(CrmStaff crmStaff);
}
