<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/Calendar.js"></script>
	<script type="text/javascript">
		function showPost(obj){
			var depId = obj.value;
			var xmlhttp = null;
			/*首先判断一下使用的浏览器类型*/
			if (window.XMLHttpRequest) {// code for all new browsers
				xmlhttp = new XMLHttpRequest();
			} else if (window.ActiveXObject) {// code for IE5 and IE6
				xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
			}

			if (xmlhttp != null) {
				xmlhttp.onreadystatechange = state_Change;
				var url ="${pageContext.request.contextPath}/postAction_findAllWithDepartment?department.depId=" + depId;
				xmlhttp.open("GET", url, true);
				xmlhttp.send(null);
			}
			 function state_Change() {//回调函数
				if(xmlhttp.readyState == 4 && xmlhttp.status == 200) {//状态码匹配，表示成功发送请求
					var textData = xmlhttp.responseText;//获取响应消息体
					console.log(textData);
					var jsonData = eval("("+textData+")");
					var post = document.getElementById("postSelectId");
					post.innerHTML = "<option value=''>----请选择----</option>";
					for(var i = 0;i<jsonData.length;i++) {
						var postObj = jsonData[i];
						var postId = postObj.postId;
						var postName = postObj.postName;
						post.innerHTML += "<option value='"+postId+"'>"+postName+"</option>";
					}
				}
			};
		}
	</script>
</head>

<body class="emp_body">
<table border="0" cellspacing="0" cellpadding="0" width="100%">
  <tr>
    <td class="topg"></td>
  </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0"  class="wukuang"width="100%">
  <tr>
    <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
    <td width="44%" align="left">[员工管理]</td>
   
    <td width="52%"align="right">
    	<!-- 提交表单 -->
       <a href="javascript:void(0)" onclick="document.forms[0].submit()">
       	<img src="${pageContext.request.contextPath}/images/button/save.gif" />
       </a>
       <!-- 执行js，进行返回 -->
       <a href="javascript:void(0)" onclick="window.history.go(-1)"><img src="${pageContext.request.contextPath}/images/button/tuihui.gif" /></a>
      
    </td>
    <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
  </tr>
</table>

<s:form namespace="/" action="staffAction_edit">
	<s:textfield name="%{'staffId'}" type="hidden"/>
	<table width="88%" border="0" class="emp_table" style="width:80%;">
	 <tr>
	    <td>登录名：</td>
	    <td><s:textfield name="%{'loginName'}"/>
	    <td>密码：</td>
	    <td><s:password name="%{'loginPwd'}" showPassword="true"/> </td>
	  </tr>
	 <tr>
	    <td>姓名：</td>
	    <td><s:textfield name="%{'staffName'}"/> </td>
	    <td>性别：</td>
	    <td>
	    	<s:radio list="{'男','女'}" name="%{'gender'}"/>
	    </td>
	  </tr>

	 <tr>
	    <td width="10%">所属部门：</td>
	    <td width="20%">
			<s:select list="%{allDepartment}" name="%{'post.department.depId'}" listKey="depId" listValue="depName" headerValue="---请选择---" headerKey="" onchange="showPost(this)"/>
	    </td>
	    <td width="8%">职务：</td>
	    <td width="62%">
			<s:select list="post != null ? post.department.postSet:{}" name="%{'post.postId'}" listKey="postId" listValue="postName" headerValue="---请选择---" headerKey="" id="postSelectId"/>
	    </td>
	  </tr>
	  <tr>
	    <td width="10%">入职时间：</td>
	    <td width="20%">
			<s:textfield name="%{'onDutyDate'}" readonly="true" onfocus="c.showMoreDay=true; c.show(this);">
				<s:param name="%{'value'}"><s:date name="onDutyDate" format="yyyy-MM-dd"/></s:param>
			</s:textfield>
	    </td>
	    <td width="8%"></td>
	    <td width="62%"></td>
	  </tr>
	</table>
</s:form>

</body>
</html>
