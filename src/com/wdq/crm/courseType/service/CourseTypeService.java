package com.wdq.crm.courseType.service;

import com.wdq.crm.courseType.domain.CrmCourseType;
import com.wdq.crm.courseType.page.PageBean;

import java.util.List;

/**
 * Created by haier on 2017/7/11.
 */
public interface CourseTypeService {
    List<CrmCourseType> findAll();

    List<CrmCourseType> findAll(CrmCourseType crmCourseType);

    /**
     * 通过id查询详情
     * @param couresTypeId
     * @return
     */
    CrmCourseType findById(String couresTypeId);

    /**
     * 添加或编辑
     * @param crmCourseType
     */
    void addOrEdit(CrmCourseType crmCourseType);

    /**
     * 分页 + 条件查询
     * @param crmCourseType 条件
     * @param pageNum 当前页
     * @param pageSize 每页多少记录
     * @return
     */
    PageBean<CrmCourseType> findAll(CrmCourseType crmCourseType, int pageNum, int pageSize);
}
