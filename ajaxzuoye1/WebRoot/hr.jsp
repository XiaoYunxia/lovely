<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

<style media="screen">
* {
	margin: 0;
	padding: 0;
}

header {
	padding: 1em 0;
	text-align: center;
	background-color: #69c;
	color: #fff;
	font-size: 300%;
}

header span {
	font-size: 50%;
	margin-left: 1em;
	color: #eee;
}

footer {
	position: absolute;
	bottom: 0;
	padding: 2em 0;
	text-align: center;
	background-color: #69c;
	color: #fff;
	width: 100%;
	clear: both;
}

.content {
	width: 85%;
	overflow: auto;
	float: right;
	min-height: 300px;
}

.nav {
	float: left;
	background-color: #eee;
	width: 15%;
	position: fixed;
	height: 100%;
	overflow: auto;
}

ul {
	list-style-type: none;
	margin-top: 1em;
}

li a {
	display: block;
	color: #000;
	padding: 8px 0 8px 16px;
	text-decoration: none;
}

li a:hover {
	background-color: #69c;
	color: white;
}

table {
	width: 100%;
	border-collapse: collapse;
	margin: 2m auto;
}

th, td {
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #cfc;
}
</style>
<title></title>
</head>

<body>
	<form>
		<header>人力资源管理<span>员工信息列表</span></header>
	
	<div class="nav">
		<ul>
			<li><a href="new.jsp">添加员工</a></li>
			<li><a href="#">部门信息</a></li>
			<li><a href="#">其他</a></li>
		</ul>
	</div>
	<div class="content">
		<table>
			<tr>
				<th>编号</th>
				<th>姓名</th>
				<th>职位</th>
				<th>电话</th>
				<th>电子邮件</th>
				<th>编辑</th>
				<th>删除</th>
			</tr>
			
		<c:forEach items="${list}" var="s">
			<tr>
				<td>${s.id }</td>
				<td>${s.name }</td>
				<td>${s.job }</td>
				<td>${s.phone }</td>
				<td>${s.email }</td>
				<td>

						<a href="edit.jsp?id=${s.id }&name=${s.name}&job=${s.job}&phone=${s.phone}&email=${s.email}">
						<input type="button" value="编辑"></a>
					
				</td>
				<td>
						<input type="hidden" name="id" id="id" value="${s.id }">
						<a href="javascript:deletes(${s.id })"><input type="button" value="删除"></a>
					
				</td>
			</tr>
		</c:forEach>
		</table>

	</div>
	<footer>Copyright (c) 2016 牛耳教育 All Rights Reserved.</footer>
	</form>
</body>
 <script type="text/javascript">
  var xhr;

  /*
  *创建XMLHttpRequest
  */
  function createXMLHttpRequest(){
  	//1.创建XMLHttpRequest对象
  	if(window.XMLHttpRequest){
  	//非IE内核浏览器
  		xhr=new XMLHttpRequest();
  	}else{
  		//IE浏览器
  		try{
  			xhr=new ActiveXObject("Msxml2.XMLHTTP");
  		}catch(e){
  			//IE低版本
  			xhr=new ActiveXObject("Microsoft.XMLHTTP");
 		 }
  }   
}
/*
*发送请求，删除是否成功
*/
	function deletes(id){
	
	//1.创建XMLHttpRequest
	createXMLHttpRequest();
	
	//3.与服务器建立连接：open
	var url="StaffDelete?id="+id;
	xhr.open("GET",url,true);
	
	//4.设置回调函数，获得服务器响应数据
	xhr.onreadystatechange=function(){
		if(xhr.readyState==4){
			//status,200表示响应正常
			if(xhr.status==200){
				//alert("从服务器返回的值为"+xhr.responseText);
				var res=xhr.responseText;
				res=eval(res);
				if(res==true){
					alert("删除成功");
				}else if(res==false){
					alert("删除失败");
				
				}
			}else{
				alert(xhr.status+"出现了异常"+xhr.responseText);
			}
		}
	}
	
	//5.发送请求
	xhr.send(null);
}
  </script>
</html>
