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

    @Override
    public CrmStaff findStaffById(String staffId) {
        return staffDao.findStaffById(staffId);
    }

    @Override
    public void update(CrmStaff crmStaff) {
        //更新某个用户，不需要执行update操作，因为hibernate的一级缓存中存在findStaff的快照，当findStaff的值被重新设置了之后，将比对快照中的数据，由于不一致会自动更新到数据库
        CrmStaff findStaff = staffDao.findStaffById(crmStaff.getStaffId());
        if (!findStaff.getLoginPwd().equals(crmStaff.getLoginPwd())) {
            findStaff.setLoginPwd(MyStringUtil.getMD5Value(crmStaff.getLoginPwd()));
        }
        findStaff.setLoginName(crmStaff.getLoginName());
        findStaff.setStaffName(crmStaff.getStaffName());
        findStaff.setGender(crmStaff.getGender());
        findStaff.setOnDutyDate(crmStaff.getOnDutyDate());
        findStaff.setPost(crmStaff.getPost());
    }
}
