<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>PLM Translator</title>


<link href="resources/css/navigation.css" rel="stylesheet"
	type="text/css" />
<script src="resources/js/navigation.js" type="text/javascript"></script>

<link rel="stylesheet" href="resources/css/screen.css" type="text/css">
<link rel="stylesheet" href="resources/css/site.css" type="text/css">
<body style="padding: 20px 20px;">

</head>
<body>
	<div class="page">
		<tiles:insertAttribute name="header" />
		<div class="content">
			<tiles:insertAttribute name="menu" />
			<tiles:insertAttribute name="body" />
		</div>
		<tiles:insertAttribute name="footer" />
	</div>
</body>
</html>