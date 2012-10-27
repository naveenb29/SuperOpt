<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Summary</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="scripts/jquery-1.6.2.min.js"></script>
<script type="text/javascript">


function editProfileConfig() {
	//alert("Edit Clicked");
	document.form1.action = "/GameGenerator/selectProfile.htm";
	document.form1.method = "GET";
	document.form1.submit();
}

function submitProfileConfig() {
	//alert("Submit Clicked");
	document.form1.action = "/GameGenerator/submitPlayerCharProfile.htm";
	document.form1.method = "POST";
	document.form1.submit();
}
	
</script>
</head>

<body>
<form id="form1" name="form1">
  <div class="Title">Profile Summary </div>
  <div>&nbsp;</div>
  <div class="BoldText">You selected the following player characters for profile configuration. Confirm? </div>
  
  <c:forEach var="playerCharacter" items="${sessionScope.selectedPlayerCharacters}">
  		 <div>&nbsp;</div>
  		 ${playerCharacter}
  </c:forEach>
  <div>&nbsp;</div>
  <div>
    <input type="button" name="submitButton" id="submitButton" value="Submit" class="button" onclick="submitProfileConfig();" />
<!--     <input type="button" name="editButton" id="editButton" value="Edit" class="button" onclick="editProfileConfig();"/> -->
  </div>
</form>
</body>
</html>
