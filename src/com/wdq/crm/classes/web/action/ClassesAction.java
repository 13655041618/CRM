package com.wdq.crm.classes.web.action;

import com.opensymphony.xwork2.interceptor.annotations.InputConfig;
import com.wdq.crm.base.BaseAction;
import com.wdq.crm.classes.domain.CrmClasses;
import com.wdq.crm.utils.MyStringUtil;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by haier on 2017/7/14.
 */
public class ClassesAction extends BaseAction<CrmClasses> {
    /**
     * 查询所有
     * @return
     */
    public String findAll() {
        List<CrmClasses> allClasses = this.getClassesService().findAll();
        this.set("allClasses",allClasses);
        return "findAll";
    }

    /**
     * 上传前回显一下数据
     * @return
     */
    public String uploadUI() {
        CrmClasses findClasses = this.getClassesService().findById(this.getModel().getClassId());
        this.push(findClasses);
        return "uploadUI";
    }
    private File schedule;	// 内容
    private String scheduleFileName;	// 文件名
    private String scheduleContentType;	// 类型

    public void setSchedule(File schedule) {
        this.schedule = schedule;
    }

    public void setScheduleFileName(String scheduleFileName) {
        this.scheduleFileName = scheduleFileName;
    }

    public void setScheduleContentType(String scheduleContentType) {
        this.scheduleContentType = scheduleContentType;
    }
    @InputConfig(resultName = "uploadInput")
    public String upload() throws IOException {
        //获取父目录
        String parentDir = ServletActionContext.getServletContext().getRealPath("/WEB-INF/upload");
        String fileName = MyStringUtil.getUUID() + "_" +  scheduleFileName;
        //保存
        FileUtils.copyFile(schedule,new File(parentDir,fileName));
        this.getModel().setUploadTime(new Date());
        this.getModel().setUploadPath("/WEB-INF/upload/"+fileName);
        this.getModel().setUploadFilename(scheduleFileName);
        this.getClassesService().updateUpload(this.getModel());
        return "upload";
    }
}
