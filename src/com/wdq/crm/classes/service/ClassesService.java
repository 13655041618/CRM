package com.wdq.crm.classes.service;

import com.wdq.crm.classes.domain.CrmClasses;

import java.util.List;

/**
 * Created by haier on 2017/7/11.
 */
public interface ClassesService {
    List<CrmClasses> findAll();

    CrmClasses findById(String classesId);

    void updateUpload(CrmClasses model);
}
