package com.wdq.crm.base;

import org.hibernate.criterion.DetachedCriteria;

import java.io.Serializable;
import java.util.List;

/**
 * Created by haier on 2017/7/13.
 */
public interface BaseDao<T> {
    void save(T t);

    void delete(T t);

    void update(T t);

    void saveOrUpdate(T t);

    T findById(Serializable id);

    List<T> findAll();

    /**
     * 条件查询
     * @param condition
     * @param params
     * @return
     */
    List<T> findAll(String condition, Object[] params);

    int getTotalRecord(String condition, Object[] params);

    /**
     * 分页  查询结果
     * @param condition 条件
     * @param params 条件的实际参数
     * @param stratIndex 开始索引
     * @param pageSize 每页多少记录
     * @return
     */
    List<T> findAll(String condition, Object[] params, int stratIndex, int pageSize);

    /**
     * 离线查询，使用的是BQC
     * @param criteria
     * @return
     */
    List<T> findAll(DetachedCriteria criteria);
    List<T> findAll(DetachedCriteria criteria,int startIndex,int pageSize);
}
