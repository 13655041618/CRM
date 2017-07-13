package com.wdq.crm.staff.dao;

import com.wdq.crm.base.BaseDaoImpl;
import com.wdq.crm.staff.domain.CrmStaff;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by haier on 2017/7/9.
 */
public class StaffDaoImpl extends BaseDaoImpl<CrmStaff> implements StaffDao{
    @Override
    public CrmStaff find(String loginName, String loginPwd) {
        List<CrmStaff> allStaff = (List<CrmStaff>) this.getHibernateTemplate().find("from CrmStaff where loginName=? and loginPwd = ?", loginName,loginPwd);
        if (allStaff.size() == 1) {
            return allStaff.get(0);
        }
        return null;
    }
}
