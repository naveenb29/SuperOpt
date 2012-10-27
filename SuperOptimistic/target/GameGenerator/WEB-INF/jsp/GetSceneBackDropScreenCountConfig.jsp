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
<form:form id="form1" name="form1" method="post" commandName="Scene" action="/GameGenerator/submitScreenCountConfig.htm">
<div style="padding-left: 671px;  border-color:#ff9900;">
  <div class="Title">Game Configuration</div>
  <div>&nbsp;</div>
  <div class="BoldText">Configuration of Screens </div>
  <div>&nbsp;</div>
  <div class="NormalText">  
  	<table width="" border="0">
	  <tr>
		<td>How many screens do you want in this scene?</td>
		<td><label>
		  <form:select path="noOfScreens" class="NormalText">
		  	<form:option value="0" selected="selected">0</form:option>
		    <form:option value="1" >1</form:option>
		    <form:option value="2">2</form:option>
		    <form:option value="3">3</form:option>
		    <form:option value="4">4</form:option>
		    <form:option value="5">5</form:option>
	      </form:select>
		</label></td>
	  </tr>
	</table>
  </div>
  <div>&nbsp;</div>
  <div class="NormalText">
  	<table width="" border="0">
	  <tr>
		<td>Specify what image you need as a backdrop for the scene</td>
		<td><label>
		  <form:select path="backdrop" class="NormalText">
		    <form:option value="Image1" selected="selected">Image 1</form:option>
		    <form:option value="Image2" >Image 2</form:option>
		    <form:option value="Image3" >Image 3</form:option>
		    <form:option value="Image4" >Image 4</form:option>
	      </form:select>
		</label></td>
	  </tr>
	</table>
  </div>
  	<form:hidden path="sceneId" id="sceneId"/>
  <div>&nbsp;</div>
  <div>
    <input type="submit" name="Next" value="Next" class="button" />
  </div>
  </div>
</form:form>
</body>
</html>
