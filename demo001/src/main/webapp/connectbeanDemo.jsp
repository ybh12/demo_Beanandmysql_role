<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="bean.demo.ConnectBean"%>
<%@page import="bean.demo.dataBean"%>
<%@page import="java.io.IOException"%>
<%@page import="java.sql.*"%>
<%@ page import="java.sql.Connection"%>

  
<!DOCTYPE html>
<html>
<head>

<title>Insert title here</title>
</head>
<body>
 <jsp:useBean id="data" class="bean.demo.dataBean" scope="session"/>
 <jsp:useBean id="connect" class="bean.demo.ConnectBean" scope="session"/>
<%  
String sql;

if(request.getParameter("login_submit")!=null) {
  sql=connect.access(request.getParameter("account"));
 
}else sql="select * from user";

System.out.println(sql);
ResultSet rs=connect.selectSql(sql);

%>
<table border="1" width="800">
<tr>
  <td width="100" align="center">ID</td>
   <td width="200" align="center">用户</td>
   <td width="200" align="center">性别</td>
   <td width="200" align="center">所在班级</td>
   <td width="200" align="center">权限</td>
    <td width="400" align="center">操作</td>   
</tr>

<%  while(rs.next()){    %>	

  <tr>
	 <td width="100" align="center"><%=rs.getInt("id_user")%></td>
     <td width="200" align="center"><%=rs.getString("username")%></td>
     <td width="200" align="center"><%=rs.getString("gender")%></td>
     <td width="200" align="center"><%=rs.getString("department")%></td>
     <td width="200" align="center"><%=rs.getString("access_rights")%></td>
     <td align="center"><a href="updateDemo?id_user=<%=rs.getInt("id_user") %>" >修改</a>
        <a href="deleteDemo?id_user=<%=rs.getInt("id_user") %>" onclick="return confirm('确定将此记录删除?')">删除</a>
     </td>    
   </tr>
<% }   %>


</table>

<input type="button" value="返回首页" onclick="{location.href='index.html'}" />
<input type="button" value="新增记录" onclick="{location.href='user.html'}" />

</body>
</html>