<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%! String ue;%>
<%
      ue = (String)request.getAttribute("UserExists");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SignUp</title>

<style type="text/css">

body
{
	font-family:Arial, Helvetica, sans-serif;
}
.container
{
	margin: auto;
    width: 24%;
    border:3px solid #8AC007;
    padding: 40px;
}
input[type="submit"]
{
    padding: 5px;
    font-size:15px;
}
</style>
</head>
<script>
    function myFunction() {
    	var uname = document.getElementById("u").value;
        var pass1 = document.getElementById("p").value;
        var pass2 = document.getElementById("p1").value;
        
        if (uname == "") {
        	alert("Please Enter Username");
        	return false;
        }
        else if (uname == " ") {
        	alert("Username cannot have spaces");
        	return false;
        }
        else if (pass1 == "" || pass1 == " ") {
        	alert("Please Enter Password");
        	return false;
        }
        else if (pass2 == "" || pass2 == " ") {
        	alert("Please Enter Confirm Password");
        	return false;
        }
        else if (pass1 != pass2) {
            alert("Passwords Do not match...!!!");
            return false; 
        }
            else if (ue==null)
      		{
        		alert("User Already Exists..");
        		return false;
       	 	}          	

            //document.getElementById("p").style.borderColor = "#E34234";
            //document.getElementById("p1").style.borderColor = "#E34234";
        
   	}
</script>

<body>
<div class="container" align="center">

<table style="width:65%;">

<tr>
	<h2>Register New User</h2>
</tr>

<div id="errr" style="display:none;color:red;"></div>
<form id="fm" action="LoginServlet?var=signup" method="post" onsubmit="return myFunction();">

<tr>
		<td align="right" valign="top"><b>Username </b> </td>	
		<td><input id="u" type="text" name="un" placeholder="Enter Username"/><br/><br/></td>
</tr>
<tr>	
		<td align="right" valign="top"><b>Password </b> <br/></td>
		<td><input id="p" type="password" name="pw" placeholder="Enter Password"/><br/><br/></td>
</tr>
<tr>
		<td align="right" valign="top"><b>Retype-Password </b>  </td>
		<td><input id="p1" type="password" name="cpw" placeholder="Enter Confirm Password"/><br/><br/></td>
</tr>
<tr>
		<td></td>
		<td><input type="submit" value="Submit"/><br/><br/></td>
</tr>

<tr>
	<td align="center" valign="top"><Strong>Already User?</Strong> 
	<td><a style="text-decoration:none;color:blue;" href="login.jsp"><u>Login</u></a></h4><br/><br/></td>
</tr>
<tr>
<td align="center"><Strong>Home Page?</Strong>
<td><a style="text-decoration:none;color:blue;" href="index.jsp"><u> Click here</u></a></h4></td>
</tr>

</form>
</table>

</div>
</body>
</html>