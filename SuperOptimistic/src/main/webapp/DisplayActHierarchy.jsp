<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<script type="text/javascript" src="scripts/_lib/jquery.js"></script>
	<script type="text/javascript" src="scripts/_lib/jquery.cookie.js"></script>
	<script type="text/javascript" src="scripts/_lib/jquery.hotkeys.js"></script>
	<script type="text/javascript" src="scripts/jquery.jstree.js"></script>
	<link type="text/css" rel="stylesheet" href="css/syntax/!style.css"/>
	<link type="text/css" rel="stylesheet" href="css/!style.css"/>

	<script type="text/javascript" src="scripts/!script.js"></script>
<script type="text/javascript">

$(document).ready(function() {
	
	var defaultItem = document.getElementById("defaultItem").value;
	if(defaultItem)
	{
		if(defaultItem != '')
		{
			document.getElementById(defaultItem).className = 'jstree-open';
		}
			
	}
	
	});

$(function () {
	$("#demo3").jstree({ "themes" : {
			   "theme" : "apple",
			   "url" : "themes/apple/style.css"
			  },
		"plugins" : ["themes","html_data","ui"] })
		// 1) if using the UI plugin bind to select_node
		.bind("select_node.jstree", function (event, data) { 
			// `data.rslt.obj` is the jquery extended node that was clicked
			var idValue = data.rslt.obj.attr("id");
			idValue = idValue.toLowerCase();
			//alert(idValue);
			document.getElementById("selElement").value = idValue;
			if(idValue.indexOf("screen") != -1)
			{
				document.form10.action = "/GameGenerator/getScreenConfig.htm";
	    		document.form10.method = "GET";
	    		document.form10.submit();
			}else if(idValue.indexOf("scene") != -1)
			{
				document.form10.action = "/GameGenerator/getScreenCountConfig.htm";
	    		document.form10.method = "GET";
	    		document.form10.submit();
			}
			else if(idValue.indexOf("act") != -1)
			{
				document.form10.action = "/GameGenerator/getSceneConfigForAct.htm";
	    		document.form10.method = "GET";
	    		document.form10.submit();
			}
			
		})
		// 2) if not using the UI plugin - the Anchor tags work as expected
		//    so if the anchor has a HREF attirbute - the page will be changed
		//    you can actually prevent the default, etc (normal jquery usage)
		.delegate("a", "click", function (event, data) { event.preventDefault(); })
});
</script>

<form:form id="form10" name="form10" commandName="GameGeneratorInfo" method="GET" action = "/GameGenerator/getSceneConfigForAct.htm">
<div id="description" style="
    width: 1533px;
    padding-top: 175px;
    padding-left: 346px;
">
<input type="hidden" value="${sessionScope.defaultItem}" id="defaultItem"/>

	<div id="demo3" class="demo" style="height:500px;">
		<ul>
			<c:forEach var="act" items="${sessionScope.GameGeneratorInfo.actList}">
				<li id="${act.actId}" class="${act.defaultStyle}">
					<a href="#">${act.actTitle}</a>
					<ul>
						<c:forEach var="scene" items="${act.sceneList}">
							<li id="${scene.sceneId}" class="${scene.defaultStyle}">
							<a href="#">${scene.sceneName}</a>
							<ul>
								<c:forEach var="screen" items="${scene.screenList}">
									<li id="${screen.screenId}" class="${screen.defaultStyle}">
										<a href="#">${screen.screenName}</a>
									</li>
								</c:forEach>
							</ul>
						</li>
						</c:forEach>					
					</ul>
				</li>
			
			</c:forEach>		
		</ul>
	</div>
	
	<form:hidden path="selElement" id="selElement"/>
	<a href="/GameGenerator/generateGameConfig.htm"><img src="images/GenerateXMLButton.png" alt="Generate Game XMl" style="padding-left: 500px;"></a>
</div>
</form:form>
