<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Untitled Document</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="scripts/jquery-1.6.2.min.js"></script>
</head>
<script type="text/javascript">

$(document).ready(function(){
	
	$("input:radio[name=profileCreation]").click(function() {
		//alert("heello : "+$(this).val());
	    var value = $(this).val();
	    if(value == 'CreateProfile')
	    {
	    	document.form1.action = "/GameGenerator/configureProfile.htm";
	    	document.form1.method = "GET";
	    	document.form1.submit();
	    }
	    else if(value == 'SelectProfile')
	    {
	    	document.form1.action = "/GameGenerator/selectProfile.htm";
	    	document.form1.method = "GET";
	    	document.form1.submit();
	    }
	    else
	    {
	    	document.form1.action = "/GameGenerator/noProfile.htm";
	    	document.form1.method = "GET";
	    	document.form1.submit();
	    }
	});
 
 
  });
	
</script>
<body>

<form id="form1" name="form1" method="post" action="">
  <div class="Title">Welcome to the Game Generation Wizard </div>
  <div>&nbsp;</div>
  <div>
    <table width="">
      <tr>
        <td><label class="NormalText">
          <input type="radio" name="profileCreation" value="CreateProfile" />
          Custom configure user profile creation </label></td>
      </tr>
      <tr>
        <td><label class="NormalText">
          <input type="radio" name="profileCreation"   value="SelectProfile" />
          Select pre existing profiles </label></td>
      </tr>
      <tr>
        <td><label class="NormalText">
          <input type="radio" name="profileCreation"  value="NoProfile" />
          Skip Profile creation </label></td>
      </tr>
    </table>
  </div>
  <div>&nbsp;</div>
  <div>
    <input type="submit" name="Next" value="Next" class="button" />
  </div>
  
</form>


</body>
</html>
