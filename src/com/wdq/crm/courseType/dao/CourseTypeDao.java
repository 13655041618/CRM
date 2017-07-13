package com.wdq.crm.courseType.dao;

import com.wdq.crm.courseType.domain.CrmCourseType;

import java.util.List;

/**
 * Created by haier on 2017/7/11.
 */
public interface CourseTypeDao {
    /**
     * 查询所有
     * @return
     */
    List<CrmCourseType> findAll();

    /**
     * 条件查询
     * @param condition
     * @param params
     * @return
     */
    List<CrmCourseType> findAll(String condition, Object[] params);

    /**
     * 通过id查询详情
     * @param couresTypeId
     * @return
     */
    CrmCourseType findById(String couresTypeId);

    /**
     * 保存或更新
     * @param crmCourseType
     */
    void saveOrUpdate(CrmCourseType crmCourseType);

    int getTotalRecord(String condition, Object[] params);

    /**
     * 分页  查询结果
     * @param condition 条件
     * @param params 条件的实际参数
     * @param stratIndex 开始索引
     * @param pageSize 每页多少记录
     * @return
     */
    List<CrmCourseType> findAll(String condition, Object[] params, int stratIndex, int pageSize);
}
