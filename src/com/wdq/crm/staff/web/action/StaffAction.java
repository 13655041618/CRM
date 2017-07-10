package com.wdq.crm.staff.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.wdq.crm.staff.domain.CrmStaff;
import com.wdq.crm.staff.service.StaffService;

import java.util.List;

/**
 * Created by haier on 2017/7/9.
 */
public class StaffAction extends ActionSupport implements ModelDriven<CrmStaff> {
    private CrmStaff crmStaff = new CrmStaff();
    @Override
    public CrmStaff getModel() {
        return crmStaff;
    }

    private StaffService staffService;

    public void setStaffService(StaffService staffService) {
        this.staffService = staffService;
    }
    public String login() {
        CrmStaff findStaff = staffService.login(crmStaff);
        if (findStaff != null) {
            ActionContext.getContext().getSession().put("loginStaff", findStaff);
            return SUCCESS;
        }
        this.addFieldError("","用户名或密码错误");
        return "login";
    }

    public String home() {
        return "home";
    }

    public String findAll() {
        List<CrmStaff> list = staffService.findAllStaff();
        ActionContext.getContext().put("allStaff",list);
        return "findAll";
    }
}
