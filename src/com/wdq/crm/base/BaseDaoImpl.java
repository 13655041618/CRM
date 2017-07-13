package com.wdq.crm.base;

import com.wdq.crm.courseType.page.PageHibernateCallBack;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by haier on 2017/7/13.
 */
public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {
    private Class beanClass;
    //T 在编译时只是一个变量，在运行时通过字节码文件才能获得具体类型
    public BaseDaoImpl() {
        //获得运行时的类型，BaseDaoImpl<CrmStaff>被参数化的类型
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        //获得实际参数，是获得所有参数，此时只有一个
        beanClass = (Class) type.getActualTypeArguments()[0];
    }
    @Override
    public void save(T t) {
        this.getHibernateTemplate().save(t);
    }

    @Override
    public void delete(T t) {
        this.getHibernateTemplate().delete(t);
    }

    @Override
    public void update(T t) {
        this.getHibernateTemplate().update(t);
    }

    @Override
    public void saveOrUpdate(T t) {
        this.getHibernateTemplate().saveOrUpdate(t);
    }

    @Override
    public T findById(Serializable id) {
        return (T) this.getHibernateTemplate().get(beanClass,id);
    }

    @Override
    public List<T> findAll() {
        return (List<T>) this.getHibernateTemplate().find("from " + beanClass.getName());
    }

    @Override
    public List<T> findAll(String condition, Object[] params) {
        String hql = "from " + beanClass.getName() + " where 1=1 " + condition;
        return (List<T>) this.getHibernateTemplate().find(hql,params);
    }
    @Override
    public int getTotalRecord(String condition, Object[] params) {
        String hql = "select count(*) from " + beanClass.getName() + " where 1=1 " + condition;
        List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql,params);
        return list.get(0).intValue();
    }

    @Override
    public List<T> findAll(String condition, Object[] params, int stratIndex, int pageSize) {
        String hql = "from "+ beanClass.getName()+" where 1=1 " + condition;
        return this.getHibernateTemplate().execute(new PageHibernateCallBack<T>().setHql(hql).setParams(params).setStartIndex(stratIndex).setPageSize(pageSize));
    }

    @Override
    public List<T> findAll(DetachedCriteria criteria) {
        return (List<T>) this.getHibernateTemplate().findByCriteria(criteria);
    }

    @Override
    public List<T> findAll(DetachedCriteria criteria, int startIndex, int pageSize) {
        return (List<T>) this.getHibernateTemplate().findByCriteria(criteria,startIndex,pageSize);
    }
}
