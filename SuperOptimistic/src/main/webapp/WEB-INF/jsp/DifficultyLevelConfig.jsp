<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Untitled Document</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body style="
    background-color: #FFF; layer-background-color:#003366;
    height: 738px;
">
<%@ include file="/DisplayActHierarchy.jsp"%>
<form:form id="form1" name="form1" method="post" commandName="Screen" action="/GameGenerator/submitDiffConfigLevel.htm">
<div style="padding-left: 671px;  border-color:#ff9900;">
  <div class="Title">Game Configuration</div>
  <div>&nbsp;</div>
  <div class="BoldText">Configuration of Screens </div>
  <div>&nbsp;</div>
  <div class="NormalText">  
  	<table width="" border="0">
	  <tr>
		<td>What difficulty level should the game be ?</td>
		<td><label>
		<form:select path="difficultySetting" class="NormalText">
		    <form:option value = "easy" selected="selected">Easy</form:option>
		    <form:option value = "medium" >Medium</form:option>
		    <form:option value = "difficult" >Difficult</form:option>
	      </form:select>		  
		</label></td>
	  </tr>
	</table>
  </div>
  <div>&nbsp;</div>
  <form:hidden path="screenId" id="screenId"/>
  <div>
    <input type="submit" name="Next" value="Next" class="button" />
  </div>
  </div>
</form:form>
</body>
</html>
