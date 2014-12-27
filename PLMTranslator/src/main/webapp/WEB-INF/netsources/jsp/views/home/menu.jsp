<!DOCTYPE link PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link href="resources/css/w2ui-1.4.2.css" rel="stylesheet"
	type="text/css" />
	<script src="resources/js/jquery-2.1.1.min.js" type="text/javascript"></script>
<script src="resources/js/w2ui-1.4.2.js" type="text/javascript"></script>

<body>

<body>

<div id="sidebar" style="height: 300px; width: 200px;"></div>

<script type="text/javascript">
$(function () {
    $('#sidebar').w2sidebar({
        name: 'sidebar',
        nodes: [ 
            { id: 'level-1', text: 'Level 1', img: 'icon-folder', expanded: true, group: true,
              nodes: [ { id: 'level-1-1', text: 'Level 1.1', icon: 'fa-home' },
                       { id: 'level-1-2', text: 'Level 1.2', icon: 'fa-star' },
                       { id: 'level-1-3', text: 'Level 1.3', icon: 'fa-star-empty' }
                     ]
            },
            { id: 'level-2', text: 'Level 2', img: 'icon-folder', expanded: true, group: true,
              nodes: [ { id: 'level-2-1', text: 'Level 2.1', img: 'icon-folder', count: 3,
                           nodes: [
                           { id: 'level-2-1-1', text: 'Level 2.1.1', icon: 'fa-star-empty' },
                           { id: 'level-2-1-2', text: 'Level 2.1.2', icon: 'fa-star-empty', count: 67 },
                           { id: 'level-2-1-3', text: 'Level 2.1.3', icon: 'fa-star-empty' }
                       ]},
                       { id: 'level-2-2', text: 'Level 2.2', icon: 'fa-star-empty' },
                       { id: 'level-2-3', text: 'Level 2.3', icon: 'fa-star-empty' }
                     ]
            }
        ]
    });
});
</script>

</body>
</body>
</html>