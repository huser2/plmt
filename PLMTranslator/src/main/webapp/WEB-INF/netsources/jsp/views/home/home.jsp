<!DOCTYPE link PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link href="resources/css/w2ui-1.4.2.css" rel="stylesheet"
	type="text/css" />
<script src="resources/js/jquery-2.1.1.min.js" type="text/javascript"></script>
<link href="resources/css/fontello.css" rel="stylesheet" type="text/css" />
<link href="resources/css/plmt.css" rel="stylesheet" type="text/css" />

<script src="resources/js/w2ui-1.4.2.min.js" type="text/javascript"></script>
<script src="resources/js/plmt.js" type="text/javascript"></script>

<body>
	<div id="layout" style="width: 100%; height: 95%;"></div>

	<script type="text/javascript">
		$(function() {

			//create layout
			var layoutDiv = $('#layout');
			createLayout(layoutDiv);

			// then define the sidebar
			createMenu();

		});
	</script>

</body>
</html>