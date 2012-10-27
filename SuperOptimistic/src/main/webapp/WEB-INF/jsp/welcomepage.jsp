<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Untitled Document</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="scripts/jquery-1.6.2.min.js"></script>
<script type="text/javascript">

$(document).ready(function(){
	
	$("input:radio[name=gameCreation]").click(function() {
		//alert("heello : "+$(this).val());
	    var value = $(this).val();
	    if(value == 'GameConfig')
	    {
	    	document.form1.action = "/GameGenerator/configureActs.htm";
	    	document.form1.method = "GET";
	    	document.form1.submit();
	    }
	    else if(value == 'UserProfileConfig')
	    {
	    	document.form1.action = "/GameGenerator/userProfile.htm";
	    	document.form1.method = "GET";
	    	document.form1.submit();
	    }
	   
	});
 
 
  });
	
</script>
</head>

<body>

<form id="form1" name="form1" method="post" action="">
  <div class="Title">Welcome to the Game Generation Wizard </div>
  <div>&nbsp;</div>
  <div>
    <table width="">
      <tr>
        <td><label class="NormalText">
          <input type="radio" name="gameCreation" value="GameConfig" />
          Game Configuration </label></td>
      </tr>
      <tr>
        <td><label class="NormalText">
          <input type="radio" name="gameCreation" value="UserProfileConfig" />
          User Profile Configuration </label></td>
      </tr>
    </table>
  </div>
  <div>&nbsp;</div>
  <div>
  <!--   <input type="submit" name="Next" value="Next" class="button" /> -->
  </div>
  
</form>


</body>
</html>
