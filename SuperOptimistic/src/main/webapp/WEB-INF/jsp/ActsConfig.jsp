<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Untitled Document</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="scripts/jquery-1.6.2.min.js"></script>
<script language="javascript">
$(document).ready(function(){
	$("#next").click( function()
        {
			var e = document.getElementById("noOfActs");
			var noOfActsValue = e.options[e.selectedIndex].value;
			if(noOfActsValue == '0')
			{
				alert("Please select atleast one act!!");
			}
			else
			{
				var answer = confirm ("Do you want to submit the changes?");
				if (answer)
				{
					document.form1.action = "/GameGenerator/submitActsInfo.htm";
			    	document.form1.method = "POST";
			    	document.form1.submit();
				}				
			}
        }
     );
	 
});
	
</script>

</head>

<body>
<form:form id="form1" name="form1" commandName="GameGeneratorInfo">
  <div class="Title">Game Configuration</div>
  <div>&nbsp;</div>
  <div class="BoldText">Configuration of Acts </div>
  <div>&nbsp;</div>
  <div class="NormalText">  
  	<table width="" border="0">
	  <tr>
		<td>How many acts do you want in the game?</td>
		<td><label>
		  <form:select path="noOfActs" class="NormalText">
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
  <div>
    <input type="button" name="next" id="next" value="Next" class="button" />
  </div>
</form:form>
</body>
</html>
