package com.wdq.crm.courseType.service;

import com.wdq.crm.courseType.dao.CourseTypeDao;
import com.wdq.crm.courseType.domain.CrmCourseType;
import com.wdq.crm.courseType.page.PageBean;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haier on 2017/7/11.
 */
public class CourseTypeServiceImpl implements CourseTypeService {
    private CourseTypeDao courseTypeDao;

    public void setCourseTypeDao(CourseTypeDao courseTypeDao) {
        this.courseTypeDao = courseTypeDao;
    }

    @Override
    public List<CrmCourseType> findAll() {
        return courseTypeDao.findAll();
    }

    @Override
    public List<CrmCourseType> findAll(CrmCourseType crmCourseType) {
        StringBuilder sb = new StringBuilder();
        List<Object> paramsList = new ArrayList<Object>();
        if (StringUtils.isNotBlank(crmCourseType.getCourseName())) {
            sb.append(" and courseName like ?");
            paramsList.add("%"+crmCourseType.getCourseName()+"%");
        }
        if (StringUtils.isNotBlank(crmCourseType.getRemark())) {
            sb.append(" and remark like ?");
            paramsList.add("%"+crmCourseType.getRemark()+"%");
        }
        if (StringUtils.isNotBlank(crmCourseType.getTotalStart())) {
            sb.append(" and total >= ?");
            paramsList.add(Integer.parseInt(crmCourseType.getTotalStart()));
        }
        if (StringUtils.isNotBlank(crmCourseType.getTotalEnd())) {
            sb.append(" and total <= ?");
            paramsList.add(Integer.parseInt(crmCourseType.getTotalEnd()));
        }
        if (StringUtils.isNotBlank(crmCourseType.getCourseCostStart())) {
            sb.append(" and total >= ?");
            paramsList.add(Double.parseDouble(crmCourseType.getCourseCostStart()));
        }
        if (StringUtils.isNotBlank(crmCourseType.getCourseCostEnd())) {
            sb.append(" and total <= ?");
            paramsList.add(Double.parseDouble(crmCourseType.getCourseCostEnd()));
        }
        String condition = sb.toString();
        Object[] params = paramsList.toArray();
        return courseTypeDao.findAll(condition,params);
    }

    @Override
    public CrmCourseType findById(String couresTypeId) {
        return courseTypeDao.findById(couresTypeId);
    }

    @Override
    public void addOrEdit(CrmCourseType crmCourseType) {
        courseTypeDao.saveOrUpdate(crmCourseType);
    }

    @Override
    public PageBean<CrmCourseType> findAll(CrmCourseType crmCourseType, int pageNum, int pageSize) {
        StringBuilder sb = new StringBuilder();
        List<Object> paramsList = new ArrayList<Object>();
        if (StringUtils.isNotBlank(crmCourseType.getCourseName())) {
            sb.append(" and courseName like ?");
            paramsList.add("%"+crmCourseType.getCourseName()+"%");
        }
        if (StringUtils.isNotBlank(crmCourseType.getRemark())) {
            sb.append(" and remark like ?");
            paramsList.add("%"+crmCourseType.getRemark()+"%");
        }
        if (StringUtils.isNotBlank(crmCourseType.getTotalStart())) {
            sb.append(" and total >= ?");
            paramsList.add(Integer.parseInt(crmCourseType.getTotalStart()));
        }
        if (StringUtils.isNotBlank(crmCourseType.getTotalEnd())) {
            sb.append(" and total <= ?");
            paramsList.add(Integer.parseInt(crmCourseType.getTotalEnd()));
        }
        if (StringUtils.isNotBlank(crmCourseType.getCourseCostStart())) {
            sb.append(" and total >= ?");
            paramsList.add(Double.parseDouble(crmCourseType.getCourseCostStart()));
        }
        if (StringUtils.isNotBlank(crmCourseType.getCourseCostEnd())) {
            sb.append(" and total <= ?");
            paramsList.add(Double.parseDouble(crmCourseType.getCourseCostEnd()));
        }
        String condition = sb.toString();
        Object[] params = paramsList.toArray();
        int totalRecord = courseTypeDao.getTotalRecord(condition,params);
        PageBean<CrmCourseType> pageBean = new PageBean<CrmCourseType>(pageNum,pageSize,totalRecord);
        List<CrmCourseType> data = courseTypeDao.findAll(condition,params,pageBean.getStartIndex(),pageBean.getPageSize());
        pageBean.setData(data);
        return pageBean;
    }
}
