package com.wdq.crm.staff.service;

import com.wdq.crm.staff.dao.StaffDao;
import com.wdq.crm.staff.domain.CrmStaff;
import com.wdq.crm.utils.MyStringUtil;

import java.util.List;

/**
 * Created by haier on 2017/7/9.
 */
public class StaffServiceImpl implements StaffService {
    private StaffDao staffDao;

    public void setStaffDao(StaffDao staffDao) {
        this.staffDao = staffDao;
    }

    @Override
    public CrmStaff login(CrmStaff crmStaff) {
        String pwd = MyStringUtil.getMD5Value(crmStaff.getLoginPwd());
        return staffDao.find(crmStaff.getLoginName(),pwd);
    }

    @Override
    public List<CrmStaff> findAllStaff() {
        return staffDao.findAll();
    }
}
