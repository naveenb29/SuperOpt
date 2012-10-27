<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Untitled Document</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">

	
	function skipProfileConfig() {
		alert("Profile Configuration skipped!!");
		document.form1.action = "/GameGenerator/userProfile.htm";
		document.form1.method = "GET";
		document.form1.submit();
	}
 

	
</script>
</head>

<body>
<form id="form1" name="form1" method="post" action="/GameGenerator/userProfile.htm">
  <div class="BoldText">Are you sure you want to skip creating a profile? </div>
  <div>&nbsp;</div>
  <div>
    <input type="button" name="Skip"  value="Skip" class="button" onclick="skipProfileConfig();" />
  </div>
</form>
</body>
</html>
