<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Untitled Document</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="scripts/jquery-1.6.2.min.js"></script>
<script language="javascript">

function submitExistingProfilePage()
{
	   var selectedCharacters = '';	
	   $(":checkbox:checked").each(
            function() {
               //alert( $(this).val());
               selectedCharacters += $(this).val();
               selectedCharacters += ":";
            }
        );
	
	document.form1.action = "/GameGenerator/selectProfile.htm?selectedProfiles="+selectedCharacters;
	document.form1.method = "post";
	document.form1.submit();
}

$(document).ready(function() {
	
  setTimeout(selectDefaultCheckboxes,500);
});

function selectDefaultCheckboxes()
{
	var selPlayChar = $('#selectedPlayerChars').val();
	if(selPlayChar)
	{
		selPlayChar = selPlayChar.replace("[","");
		selPlayChar = selPlayChar.replace("]","");
		 var selPlayCharacter = selPlayChar.split(',');
		// alert(selPlayCharacter);
		for ( var i = 0; i < selPlayCharacter.length; i++) {		
			$(selPlayCharacter[i]).prop("checked",true); 
		} 
		
	}
	
}

</script>

</head>

<body>
<form id="form1" name="form1" >
  <div class="Title">Select a profile </div>
  <div>&nbsp;</div>
  <div class="BoldText">Select a list of existing profile options that the user can select from. </div>
  <div>&nbsp;</div>
  
  <c:forEach var="type" items="${sessionScope.playerCharacters}">
	  <div class="NormalText">
	    <input type="checkbox" name="existingProfile" value="${type.key}" id="${type.key}"/>
	    ${type.key}
	    <!-- <img alt="characterName" src='file:///C:/Users/Meyy/Downloads/GameAssetRepository/GameAssetRepository/Office,%20Classroom/Visual/Characters/Player%20Characters/Cat/LEvil.png'/> -->
	  </div>
	  <div>&nbsp;</div>
	 
  </c:forEach>
  <div>&nbsp;</div>
  <input type="hidden" id="selectedPlayerChars" value="${sessionScope.selectedPlayerCharacters}"/>
  <div>
    <input type="button" name="Next" value="Next" class="button" onclick="submitExistingProfilePage();" />
  </div>
</form>
</body>
</html>
