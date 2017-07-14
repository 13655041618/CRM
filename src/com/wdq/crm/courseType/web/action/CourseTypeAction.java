package com.wdq.crm.courseType.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.wdq.crm.base.BaseAction;
import com.wdq.crm.courseType.domain.CrmCourseType;
import com.wdq.crm.courseType.page.PageBean;
import com.wdq.crm.courseType.service.CourseTypeService;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * Created by haier on 2017/7/11.
 */
public class CourseTypeAction extends BaseAction<CrmCourseType> {
    public String findAll() {
        /*List<CrmCourseType> all = courseTypeService.findAll(this.getModel());
        ActionContext.getContext().put("all", all);*/
        PageBean<CrmCourseType> pageBean = this.getCourseTypeService().findAll(this.getModel(),this.getPageNum(),this.getPageSize());
        this.put("pageBean",pageBean);
        return "findAll";
    }

    /**
     * 添加或编辑jsp页面
     * @return
     */
    public String addOrEditUI() {
        if (StringUtils.isNotBlank(this.getModel().getCourseTypeId())) {
            CrmCourseType findCT = this.getCourseTypeService().findById(this.getModel().getCourseTypeId());
            this.push(findCT);
        }
        return "addOrEditUI";
    }

    /**
     * 添加或编辑功能
     * @return
     */
    public String addOrEdit() {
        if (StringUtils.isNotBlank(this.getModel().getCourseName()) || this.getModel().getCourseCost()!=null ||
                StringUtils.isNotBlank(this.getModel().getRemark()) || this.getModel().getTotal()!=null) {
            this.getCourseTypeService().addOrEdit(this.getModel());
        }
        return "addOrEdit";
    }
}
