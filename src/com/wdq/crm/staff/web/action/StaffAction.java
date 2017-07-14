package com.wdq.crm.staff.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.wdq.crm.base.BaseAction;
import com.wdq.crm.department.domain.CrmDepartment;
import com.wdq.crm.department.service.DepartmentService;
import com.wdq.crm.staff.domain.CrmStaff;
import com.wdq.crm.staff.service.StaffService;
import com.wdq.crm.utils.MyStringUtil;

import java.util.List;

/**
 * Created by haier on 2017/7/9.
 */
public class StaffAction extends BaseAction<CrmStaff> {
    public String login() {
        CrmStaff findStaff = this.getStaffService().login(this.getModel());
        if (findStaff != null) {
            this.putSession("loginStaff", findStaff);
            return SUCCESS;
        }
        this.addFieldError("","用户名或密码错误");
        return "login";
    }

    public String home() {
        return "home";
    }

    public String findAll() {
        List<CrmStaff> list = this.getStaffService().findAllStaff();
        this.put("allStaff",list);
        return "findAll";
    }

    public String editUI() {
        CrmStaff findStaff = this.getStaffService().findStaffById(this.getModel().getStaffId());
        this.push(findStaff);
        List<CrmDepartment> allDepartment = this.getDepartmentService().findAll();
        this.set("allDepartment",allDepartment);
        return "editUI";
    }
    public String edit() {
        //不能直接在action更新staff，因为crmstaff是模型驱动，获取到的值是在更新之前的值
        this.getStaffService().update(this.getModel());
        return "edit";
    }
}
