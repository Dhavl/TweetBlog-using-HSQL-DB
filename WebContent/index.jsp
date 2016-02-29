<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page  import="java.util.*" %>
<%@page  import="com.sample.org.GetsSets" %>
<%@page import="com.sample.org.TGetsSets" %>


<%! 
String name;
String un;
String comment;
String date;
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Assignment#1</title>
<style type="text/css">

body
{
	font-family:Arial, Helvetica, sans-serif;
}
h1 
{    
	font-size: 30px;
}
h3 
{    
	font-size: 20px;
}
.container
{
	margin: auto;
    width: 24%;
    border:3px solid #8AC007;
    padding: 10px;
}

</style>

</head>

<!-- <script type="text/javascript">
        
        function redirect()
        {
        	document.location = "/TweetBlog/indexServlet";
        }
</script> -->

<bod>

<div class="container" align="center">
<h1>TweetBlog</h1>  
<div><h3><a href="login.jsp">Login</a>|  <a href="signup.jsp">Signup</a> </h3></div>
</div>

<div align="center"> <h4> <a href="/TweetBlog/indexServlet">Click here to view the Comments: </a> </h4></div>


<div align="center">
 <h3>Recent posts:</h3> 
<table>
  <%
  	@SuppressWarnings("unchecked")
 	List <TGetsSets> tgs = (List <TGetsSets>) request.getAttribute("tgs");
if(tgs==null)
{
	%>
	
<h4> There are no posts in Database! </h4>
	
	<%
}
else
{
	for (TGetsSets r: tgs)
	{
		un = r.getUsername();
		comment = r.getComment();
		date = r.getDate();
 %>
 
     <tr>
    <td><Strong>Blog: </Strong> <%= comment%></td>
    </tr>
    <tr>
    <td><font color="darkgrey">&nbsp; &nbsp; &nbsp; <i> Posted by: </i><strong> <%=un %> </strong><i> at </i><%=date %></font></td>
    </tr>
    <tr>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    </tr>
 <%
	  }
	}	
%>
 
 </table>


</div>
</body>
</html>