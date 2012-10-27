<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>User Profile Configuration</title>
<script type="text/javascript" src="scripts/jquery-1.6.2.min.js"></script>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="javascript">

window.onload = function()
{
	enableNameSubCategory('name');
};

function enableNameSubCategory(radioGroupName){
	
	var choice = $('input:radio[name='+radioGroupName+']:checked').val();	
	
	if((choice == "true") )
	{
	document.getElementById('fullname').style.display="BLOCK";
	document.getElementById('nickname').style.display="BLOCK";
	document.getElementById('spacer1').style.display="BLOCK";
	document.getElementById('spacer2').style.display="BLOCK";
	}
	else
	{
	document.getElementById('fullname').style.display="none";
	document.getElementById('nickname').style.display="none";
	document.getElementById('spacer1').style.display="none";
	document.getElementById('spacer2').style.display="none";
	
	document.getElementById("fullName2").checked = true;
	document.getElementById("nickName2").checked = true;
	}
	
}


function submitProfiConfig() 
{

	var count = 0;
	$(':radio:checked').each(function(){
		   var value = $(this).val();
		   if(value == 'true')
		   {
			  count = 1;
		   }
		});
	  
	if(count == 1)
	{
		document.form1.action = "/GameGenerator/configureProfile.htm";
		document.form1.method = "post";
		document.form1.submit();
	}
	else
	{
		alert("Please select alteast one option!!");
	}
}


</script>
</head>

<body>
<form:form id="form1" name="form1" commandName="UserProfileConfiguration" method="post" style="width: 60%">
  <div class="Title">User Profile Configuration</div>
  <div>&nbsp;</div>
  <div class="BoldText">Select the options that you want the user to enter. </div>
  <div>&nbsp;</div>
  <div class="NormalText">
  	<table width="" border="0">
	  <tr>
		<td>Should the user enter his Name?</td>
		<td> <label>
			<form:radiobutton path="name" value="true" onclick="enableNameSubCategory('name')" />
			Yes</label>     
		  <label>
			<form:radiobutton path="name" value="false" onclick="enableNameSubCategory('name')"/>
			No</label></td>
	  </tr>
	</table>
  </div>   
  <div id="spacer1" style="display:none">&nbsp;</div>
  <div id="fullname" class="NormalText" style="display:none">
  	<table width="" border="0">
	  <tr>
		<td style="padding-left: 45px;">Should the user enter his Full Name?</td>
		<td> <label>
			<form:radiobutton path="fullName" value="true" />
			Yes</label>     
		  <label>
			<form:radiobutton path="fullName" value="false" />
			No</label></td>
	  </tr>
	</table>
  </div>
  <div id="spacer2" style="display:none">&nbsp;</div>
  <div id="nickname" class="NormalText" style="display:none">  
  	<table width="" border="0">
	  <tr>
		<td style="padding-left: 45px;">Should the user enter his nick name?</td>
		<td> <label>
			<form:radiobutton path="nickName" value="true" />
			Yes</label>     
		  <label>
			<form:radiobutton path="nickName" value="false" />
			No</label></td>
	  </tr>
	</table>
  </div>
  <div>&nbsp;</div>
  <div class="NormalText">  
  	<table width="" border="0">
	  <tr>
		<td>Should the user select a profile picture?</td>
		<td> <label>
			<form:radiobutton path="profilePicture" value="true" />
			Yes</label>     
		  <label>
			<form:radiobutton path="profilePicture" value="false" />
			No</label></td>
	  </tr>
	</table>
  </div>
  <div>&nbsp;</div>
  <div class="NormalText">  
  	<table width="" border="0">
	  <tr>
		<td>Should the user enter his age group?</td>
		<td> <label>
			<form:radiobutton path="age" value="true" />
			Yes</label>     
		  <label>
			<form:radiobutton path="age" value="false" />
			No</label></td>
	  </tr>
	</table>
  </div>
  <div>&nbsp;</div>
  <div class="NormalText">  
  	<table width="" border="0">
	  <tr>
		<td>Should the user enter his country?</td>
		<td> <label>
			<form:radiobutton path="country" value="true" />
			Yes</label>     
		  <label>
			<form:radiobutton path="country" value="false" />
			No</label></td>
	  </tr>
	</table>
  </div>
  <div>&nbsp;</div>
  <div class="NormalText">  
  	<table width="" border="0">
	  <tr>
		<td>Should the user enter his language preference?</td>
		<td> <label>
			<form:radiobutton path="languagePreference" value="true" />
			Yes</label>     
		  <label>
			<form:radiobutton path="languagePreference" value="false" />
			No</label></td>
	  </tr>
	</table>
  </div>
  <div>&nbsp;</div>
  <div>
    <input type="button" name="Next" value="Next" class="button" onclick="submitProfiConfig();" />
  </div>
</form:form>
</body>
</html>
