<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
   <link href="css/ui-lightness/jquery-ui-1.8.23.custom.css"
          rel="stylesheet" type="text/css"/>
	<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="js/jquery-ui-1.8.23.custom.min.js"></script>
    <script type="text/javascript" src="js/jquery.ui.datepicker-zh-CN.js"></script>
  
   <script type="text/javascript">
      $(function(){
        $("#datepicker").datepicker({
          dateFormat:'yy年mm月dd日',
          autoSize:true
        });
        // 指定日期的格式是 yyyy-mm-dd
        // 不指定则是 yyyy年mm月dd日
        $("#datepicker").datepicker("option",$.datepicker.regional["zh-CN"]);
      });
    </script>
    <style type="text/css">
      /* em是相对长度单位。相对于当前对象内文本的字体尺寸 */
      .ui-datepicker { 
        width: 17em; 
        padding: .2em .2em 0; 
        font-size: 15px;
      }
    </style>
  
  </head>
  
  <body>
  <form>
     用户名：<input type="text" name="username" id="username">
     <span id="msg"></span><br><br>
    
    <!--  <a href="javascript:chkRepeat()">验证用户名</a><br> -->
    
    密码：<input type="password" name="password" id="password"><br><br>
  出生日期：  <input name="birthday" type="text" id="datepicker"/>日期格式：yyyy-MM-dd<br><br>
  
    兴趣爱好：<input type="checkbox" value="足球" name="fav">足球
    <input type="checkbox" value="篮球" name="fav">篮球

    <br><br><a href="javascript:chkUser()">登录</a>
    <input type="button" id="btn" value="添加">
			
    <div id="res"></div>
    <br>
    <table id="tb1" border="1">
    	<tr>
    		<td>用户名</td>
    		<td>真实姓名</td>
    		<td>出生日期</td>
    		<td>爱好</td>   	
    	</tr>

    </table>
    
    
    
    
     <table>
            <tr>
                <td><h5>城市下拉框</h5></td>
                <td>
                    <select id="province" style="width:130px" onfocus="showProvince()">
                        <option>请选择省市/其他...</option>
                    </select>
                        <select id="city" style=" width:130px">
                        <option >请选择城市/其他...</option>
                        </select>
                </td>
            </tr>
</table>
   </form> 
  </body>
  
   <script type="text/javascript">
   $(function(){
   		//jquery
   		$("#username").bind({
   			blur:function(){
   				//通过ajax发送请求
   				
   				$.get("repeat?type=chkuser","username="
   				+$(this).val(),function(data){
   					if(data=="0"){
   						$("#msg").html("<font color='green'>该用户名可以使用</font>");
   					}else if(data=="1"){
   						$("#msg").html("<font color='red'>该用户名已存在</font>");
   						$("#username").focus();//聚焦事件没起作用
   					}else{
   						alert("服务器可能出现了异常");
   					}
		
   				});	
   				
   				
   			}
   		});	
   		$("#btn").bind("click",function(){
   			$.ajax({
   				type:"Post",
   				url:"repeat?type=form",
   				data:$("form").serialize(),
   				success:function(data){
   					alert(data);
   					var obj = eval("("+data+")");
   					alert(obj);
  					appendData2Table("tb1",obj);
   				}
   			});
   		
   		
   		});	
   });
   
   function appendData2Table(id,jsonObj){

	//定义数组，用来拼接字符串
	var data=new Array();
	//获得表格对象所对应的html
	var htmlText=document.getElementById(id).innerHTML;
	//创建表格的行，将JSON数据添加到行中
	//遍历JSON数组
	
		//通过拼接html字符串添加
		//通过数组的push方法进行添加
		data.push("<tr id="+jsonObj.username+">");
		data.push("<td>"+jsonObj.username+"</td>");
		data.push("<td>"+jsonObj.password+"</td>");
		data.push("<td>"+jsonObj.birthday+"</td>");
		data.push("<td>"+jsonObj.fav+"</td>");
		data.push("</tr>");
	
	//将数组中的内容连接起来
	var content=data.join("");
	htmlText+=content;
	//最终完成表格数据的添加
	document.getElementById(id).innerHTML=htmlText;
	$("#tb1 tr:even").css("background-color","#FFA07A");
   	$("#tb1 tr:odd").css("background-color","#FFFFE0");
}
   

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
*发送请求，检查用户名、密码是否正确
*/
	function chkUser(){
	
	//1.创建XMLHttpRequest
	createXMLHttpRequest();
	
	//2./获得用户名、密码
	var username=document.getElementById("username").value;
	var password=document.getElementById("password").value;
	
	//3.与服务器建立连接：open
	var url="login?username="+username+"&password="+password;
	xhr.open("GET",url,true);
	
	//4.设置回调函数，获得服务器响应数据
	xhr.onreadystatechange=function(){
		if(xhr.readyState==4){
			//status,200表示响应正常
			if(xhr.status==200){
				//alert("从服务器返回的值为"+xhr.responseText);
				var res=xhr.responseText;
				if(res=='0'){
					document.getElementById("res").innerHTML="登陆成功";
				}else{
					document.getElementById("res").innerHTML="<font color='red'>登陆失败</font>";
				
				}
			}else{
				alert(xhr.status+"出现了异常"+xhr.responseText);
			}
		}
	}
	
	//5.发送请求
	xhr.send(null);
}
  



function showProvince(){
	
	//1.创建XMLHttpRequest
	createXMLHttpRequest();
	
	//3.与服务器建立连接：open
	var url="area?pid=0";
	xhr.open("GET",url,true);
	
	//4.设置回调函数，获得服务器响应数据
	xhr.onreadystatechange=function(){
		if(xhr.readyState==4){
			//status,200表示响应正常
			if(xhr.status==200){
				//alert("从服务器返回的值为"+xhr.responseText);
				var res=xhr.responseText;
					res=eval(res);
					alert(res);
					addProvince(res);
			}
		}
	}	
	//5.发送请求
	xhr.send(null);
}

function addProvince(res){
	var provinceObj=document.getElementById("province");	
		//属性options表示下拉框的选项
		var opts=provinceObj.options;

		//清除原有的下拉项
		opts.length=0;
		//遍历JSON数组
		for(var i=0;i<res.length;i++){
			jsonObj=res[i];
			var provinceValue=jasonObj.tb_areaId;
			var provinceName=jsonObj.areaName;
			var opt=new Option();
			opt.value=provinceValue;
			opt.text=provinceName;
			//将option对象添加至options中
			opts.add(opt);
		}
}
	/*
	*实现省市级联
	*/
	function change(){
		var province=document.getElementById("province").value;
		//通过ajax发送请求
		createXMLHttpRequest();
		var url="area?areaname="+province;
		xhr.open("GET",url,true);
		//设置状态改变时的回调函数
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4){
				if(xhr.status==200){
					//获得响应城市
					var data=xhr.responseText;
					//动态加载城市（id="city"）的下拉框
					//将字符串转换成json对象
					data=
					addCity(data);
				}
			}
		}
		//获得服务器响应的内容
		xhr.send(null);
	}
	
	
	
	function addCity(){
		var cityObj=document.getElementById("city");
		//通过js动态添加、删除下拉框
		
		//属性options表示下拉框的选项
		var opts=cityObj.options;

		//创建option对象
		/*
		var opt=new Option();
		opt.value="";
		opt.text="";
		opts.add(opt);
		*/
		//清除原有的下拉项
		opts.length=0;
		//遍历JSON数组
		for(var i=0;i<city.length;i++){
			jsonObj=city[i];
			var cityValue=jasonObj.id;
			var cityName=jsonObj.name;
			var opt=new Option();
			opt.value=cityValue;
			opt.text=cityName;
			//将option对象添加至options中
			opts.add(opt);
		}
	}
  </script>
</html>
