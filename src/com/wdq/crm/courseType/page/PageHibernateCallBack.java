package com.wdq.crm.courseType.page;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;

import java.util.List;

/**
 * Created by haier on 2017/7/12.
 */
public class PageHibernateCallBack<T> implements HibernateCallback<List<T>> {
    private String hql;
    private Object[] params;
    private int startIndex;
    private int pageSize;
    @Override
    public List<T> doInHibernate(Session session) throws HibernateException {
        Query query = session.createQuery(hql);
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                query.setParameter(i, params[i]);
            }
        }
        query.setFirstResult(startIndex);
        query.setMaxResults(pageSize);
        return query.list();
    }

    public PageHibernateCallBack<T> setHql(String hql) {
        this.hql = hql;
        return this;
    }

    public PageHibernateCallBack<T> setParams(Object[] params) {
        this.params = params;
        return this;
    }

    public PageHibernateCallBack<T> setStartIndex(int startIndex) {
        this.startIndex = startIndex;
        return this;
    }

    public PageHibernateCallBack<T> setPageSize(int pageSize) {
        this.pageSize = pageSize;
        return this;
    }
}
