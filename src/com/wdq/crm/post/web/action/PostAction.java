package com.wdq.crm.post.web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.wdq.crm.base.BaseAction;
import com.wdq.crm.post.domain.CrmPost;
import com.wdq.crm.post.service.PostServiceImpl;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.apache.struts2.ServletActionContext;

import java.io.IOException;
import java.util.List;

/**
 * Created by haier on 2017/7/10.
 */
public class PostAction extends BaseAction<CrmPost> {
    public String findAllWithDepartment() throws IOException {
        List<CrmPost> all = this.getPostService().findAll(this.getModel().getDepartment());
        //排除不需要的数据
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setExcludes(new String[]{"department","staffSet"});
        //将list转换成json
        String jsonData = JSONArray.fromObject(all,jsonConfig).toString();
        System.out.println(jsonData);
        ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
        ServletActionContext.getResponse().getWriter().print(jsonData);
        return "none";
    }
}
