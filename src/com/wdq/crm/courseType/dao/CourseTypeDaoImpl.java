package com.wdq.crm.courseType.dao;

import com.wdq.crm.courseType.domain.CrmCourseType;
import com.wdq.crm.courseType.page.PageHibernateCallBack;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by haier on 2017/7/11.
 */
public class CourseTypeDaoImpl extends HibernateDaoSupport implements CourseTypeDao {
    @Override
    public List<CrmCourseType> findAll() {
        return (List<CrmCourseType>) this.getHibernateTemplate().find("from CrmCourseType ");
    }

    @Override
    public List<CrmCourseType> findAll(String condition, Object[] params) {
        String hql = "from CrmCourseType where 1=1 " + condition;
        return (List<CrmCourseType>) this.getHibernateTemplate().find(hql,params);
    }

    @Override
    public CrmCourseType findById(String couresTypeId) {
        return this.getHibernateTemplate().get(CrmCourseType.class,couresTypeId);
    }

    @Override
    public void saveOrUpdate(CrmCourseType crmCourseType) {
        this.getHibernateTemplate().saveOrUpdate(crmCourseType);
    }

    @Override
    public int getTotalRecord(String condition, Object[] params) {
        String hql = "select count(*) from  CrmCourseType c where 1=1 " + condition;
        List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql,params);
        return list.get(0).intValue();
    }

    @Override
    public List<CrmCourseType> findAll(String condition, Object[] params, int stratIndex, int pageSize) {
        String hql = "from CrmCourseType where 1=1 " + condition;
        return this.getHibernateTemplate().execute(new PageHibernateCallBack<CrmCourseType>().setHql(hql).setParams(params).setStartIndex(stratIndex).setPageSize(pageSize));
    }
}
