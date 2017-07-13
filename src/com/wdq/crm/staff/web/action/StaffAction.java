package com.wdq.crm.staff.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.wdq.crm.department.domain.CrmDepartment;
import com.wdq.crm.department.service.DepartmentService;
import com.wdq.crm.staff.domain.CrmStaff;
import com.wdq.crm.staff.service.StaffService;
import com.wdq.crm.utils.MyStringUtil;

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

    public String editUI() {
        CrmStaff findStaff = staffService.findStaffById(crmStaff.getStaffId());
        ActionContext.getContext().getValueStack().push(findStaff);
        List<CrmDepartment> allDepartment = departmentService.findAll();
        ActionContext.getContext().getValueStack().set("allDepartment",allDepartment);
        return "editUI";
    }

    private DepartmentService departmentService;

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    public String edit() {
        //不能直接在action更新staff，因为crmstaff是模型驱动，获取到的值是在更新之前的值
        staffService.update(crmStaff);
        return "edit";
    }
}
