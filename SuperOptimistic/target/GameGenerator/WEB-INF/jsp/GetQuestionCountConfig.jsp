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
<form:form id="form1" name="form1" method="post" commandName="Screen" action="/GameGenerator/submitQuestionCountConfig.htm">
<div style="padding-left: 671px;  border-color:#ff9900;">
  <div class="Title">Screen Configuration</div>
  <div>&nbsp;</div>
  <div class="BoldText">Random Selection of Questions  </div>
  <div>&nbsp;</div>
  <div class="NormalText">  
  	<table width="" border="0">
	  <tr>
		<td>How many questions do you want in this screen?</td>
		<td><label>
		  <form:select path="noOfQuestions" class="NormalText">
		    <form:option value="2" selected="selected">2</form:option>
		    <form:option value="3">3</form:option>
		    <form:option value="4">4</form:option>
		    <form:option value="5">5</form:option>	
		    <form:option value="6">6</form:option>			   
	      </form:select>
		</label></td>
	  </tr>
	</table>
  </div>
  <div>&nbsp;</div>
  <div class="NormalText">  
  	<table width="" border="0">
	  <tr>
		<td>Select where you want the question to appear on the screen</td>
		<td>&nbsp;</td>
	  </tr>
	</table>
  </div>
  <div>&nbsp;</div>
  <div>
    <table id="screenmap" width="500" class="ScreenMap">
      <tr>
        <td><label class="NormalText">
          <form:radiobutton path="questionLocation" type="radio"  value="UL" />
          Upstage Left </label></td>
        <td><label class="NormalText">
         <form:radiobutton path="questionLocation" type="radio"  value="UC" />
          Upstage Center </label></td>
        <td><label class="NormalText">
         <form:radiobutton path="questionLocation" type="radio"  value="UR" />
          Upstage Right </label></td>
      </tr>
      <tr>
        <td><label class="NormalText">
           <form:radiobutton path="questionLocation" type="radio"  value="CL" />
          Centerstage Left </label></td>
        <td><label class="NormalText">
          <form:radiobutton path="questionLocation" type="radio"  value="CC" />
          Centerstage Center </label></td>
        <td><label class="NormalText">
          <form:radiobutton path="questionLocation" type="radio"  value="CR" />
          Centerstage Right </label></td>
      </tr>
      <tr>
        <td><label class="NormalText">
          <form:radiobutton path="questionLocation" type="radio"  value="DL" />
          Downstage Left </label></td>
        <td><label class="NormalText">
           <form:radiobutton path="questionLocation" type="radio"  value="DC" />
          Downstage Center </label></td>
        <td><label class="NormalText">
          <form:radiobutton path="questionLocation" type="radio"  value="DR" />
          Downstage Right </label></td>
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
