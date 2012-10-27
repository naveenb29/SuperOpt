<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Untitled Document</title>
<script type="text/javascript" src="scripts/jquery-1.6.2.min.js"></script>
<link href="css/style.css" rel="stylesheet" type="text/css" />

<script language="javascript">
	$("#next").click( function()
        {
			var actIdValue = document.getElementById("actId").value;
		//	alert("actIdValue : "+actIdValue);
			document.form1.action = "/GameGenerator/submitScenesInfo.htm?selectedActId="+actIdValue;
	    	document.form1.method = "POST";
	    	document.form1.submit();
        }
     );

</script>

</head>

<body style="
    background-color: #FFF; layer-background-color:#003366;
    height: 738px;
">
<%@ include file="/DisplayActHierarchy.jsp"%>
<form:form id="form1" name="form1" commandName="Act" action="/GameGenerator/submitScenesInfo.htm">
<div style="padding-left: 671px;  border-color:#ff9900;">
  <div class="Title">Game Configuration</div>
  <div>&nbsp;</div>
  <div class="BoldText">Configuration of Scenes</div>
  <div>&nbsp;</div>
  <div class="NormalText">  
  	<table width="" border="0">
	  <tr>
		<td>How many scenes do you want in this act?</td>
		<td><label>
		  <form:select path="noOfScenes" class="NormalText">
		    <form:option value="0" selected="selected">0</form:option>
		    <form:option value="1">1</form:option>
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
  <div>
  	
  	<form:hidden path="actId" id="actId"/>
    <input type="submit" id="next" name="Next" value="Next" class="button" />
  </div>
  </div>
</form:form>
</body>
</html>
