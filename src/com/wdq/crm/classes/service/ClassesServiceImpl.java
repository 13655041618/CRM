package com.wdq.crm.classes.service;

import com.wdq.crm.classes.dao.ClassesDao;
import com.wdq.crm.classes.domain.CrmClasses;

import java.util.List;

/**
 * Created by haier on 2017/7/14.
 */
public class ClassesServiceImpl implements ClassesService {
    private ClassesDao classesDao;

    public void setClassesDao(ClassesDao classesDao) {
        this.classesDao = classesDao;
    }

    @Override
    public List<CrmClasses> findAll() {
        return classesDao.findAll();
    }

    @Override
    public CrmClasses findById(String classesId) {
        return classesDao.findById(classesId);
    }

    @Override
    public void updateUpload(CrmClasses classes) {
        //利用一级缓存和快照，令hibernate自动实现更新数据库
        CrmClasses findClasses = this.classesDao.findById(classes.getClassId());
        findClasses.setUploadFilename(classes.getUploadFilename());
        findClasses.setUploadPath(classes.getUploadPath());
        findClasses.setUploadTime(classes.getUploadTime());
    }
}
