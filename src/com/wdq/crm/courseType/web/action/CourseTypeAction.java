package com.wdq.crm.courseType.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.wdq.crm.courseType.domain.CrmCourseType;
import com.wdq.crm.courseType.page.PageBean;
import com.wdq.crm.courseType.service.CourseTypeService;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * Created by haier on 2017/7/11.
 */
public class CourseTypeAction extends ActionSupport implements ModelDriven<CrmCourseType> {
    private CrmCourseType crmCourseType = new CrmCourseType();
    @Override
    public CrmCourseType getModel() {
        return crmCourseType;
    }

    private CourseTypeService courseTypeService;

    public void setCourseTypeService(CourseTypeService courseTypeService) {
        this.courseTypeService = courseTypeService;
    }
    private int pageNum = 1;
    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }
    private int pageSize = 2;  //固定值
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    public String findAll() {
        /*List<CrmCourseType> all = courseTypeService.findAll(crmCourseType);
        ActionContext.getContext().put("all", all);*/
        PageBean<CrmCourseType> pageBean = courseTypeService.findAll(crmCourseType,pageNum,pageSize);
        ActionContext.getContext().put("pageBean",pageBean);
        return "findAll";
    }

    /**
     * 添加或编辑jsp页面
     * @return
     */
    public String addOrEditUI() {
        if (StringUtils.isNotBlank(crmCourseType.getCourseTypeId())) {
            CrmCourseType findCT = courseTypeService.findById(crmCourseType.getCourseTypeId());
            ActionContext.getContext().getValueStack().push(findCT);
        }
        return "addOrEditUI";
    }

    /**
     * 添加或编辑功能
     * @return
     */
    public String addOrEdit() {
        if (StringUtils.isNotBlank(crmCourseType.getCourseName()) || crmCourseType.getCourseCost()!=null ||
                StringUtils.isNotBlank(crmCourseType.getRemark()) || crmCourseType.getTotal()!=null) {
            courseTypeService.addOrEdit(crmCourseType);
        }
        return "addOrEdit";
    }
}
