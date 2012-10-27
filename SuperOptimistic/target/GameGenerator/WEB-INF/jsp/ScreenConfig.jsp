<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Untitled Document</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="scripts/jquery-1.6.2.min.js"></script>
</head>
<script type="text/javascript">

$(document).ready(function(){
	
	$("input:radio[name=screenTypeConfig]").click(function() {
		//alert("heello : "+$(this).val());
	    var value = $(this).val();
	    if(value == 'difficultylevel')
	    {
	    	document.form1.action = "/GameGenerator/getDiffConfigLevel.htm";
	    	document.form1.method = "GET";
	    	document.form1.submit();
	    }
	    else if(value == 'numberofquestions')
	    {	    	
	    	document.form1.action = "/GameGenerator/getQuestionCountConfig.htm";
	    	document.form1.method = "GET";
	    	document.form1.submit();
	    }
	    else
	    {
	    	
	    }
	});
 
 
  });
	
</script>
<body style="
    background-color: #FFF; layer-background-color:#003366;
    height: 738px;
">
<%@ include file="/DisplayActHierarchy.jsp"%>
<form:form id="form1" name="form1" method="post" commandName="Screen" action="">
<div style="padding-left: 671px;">
  <div class="Title">Screen Configuration</div>
  <div>&nbsp;</div>
  <div class="BoldText">What do you want to configure in this screen?</div>
  <div>&nbsp;</div>
  <div class="NormalText">  
  	<table width="" border="0">
	   <tr>
        <td><label class="NormalText">
          <input type="radio" name="screenTypeConfig"  value="difficultylevel" />
          Difficulty Level </label></td>
      </tr>
      <tr>
        <td><label class="NormalText">
          <input type="radio" name="screenTypeConfig"  value="numberofquestions" />
          Select number of questions? </label></td>
      </tr>
      <tr>
        <td><label class="NormalText">
          <input type="radio" name="screenTypeConfig"  value="choosequestions" />
          Select list of questions </label></td>
      </tr>
	</table>
  </div>
  <div>&nbsp;</div>
  <div>
 <form:hidden path="screenId" id="screenId"/>
    <input type="button" name="next" value="Next" id="next" class="button" />
  </div>
  </div>
</form:form>
</body>
</html>
