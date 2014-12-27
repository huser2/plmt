/**
 * 
 */


	function processRequest(request) {
		var xmlhttp;
		if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp = new XMLHttpRequest();
		} else {// code for IE6, IE5
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				w2ui['plmt_layout'].content('main',xmlhttp.responseText);
				//document.getElementById("loadSelectedPage").innerHTML = xmlhttp.responseText;
			}
		}
		xmlhttp.open("GET", request.id, true);
		xmlhttp.send();
	}
	
	function createLayout(layoutDiv){
		var pstyle = 'border: 0px solid #dfdfdf; padding: 0px;';
		
		layoutDiv.w2layout({
	        name: 'plmt_layout',
	        panels: [
	            { type: 'top', size: 50, resizable: false, content:'',title:'PLMBridge'},
	            { type: 'left', size: 200, resizable: true,  content: '',title:'Navigator'},
	            { type: 'main', resizable: true,content:''}
	        ]
	    });		
	}
	
	function createMenu(menuDiv){
		w2ui['plmt_layout'].content('left', $().w2sidebar({
			name: 'plmt_sidebar',
			img: null,
			nodes: [ 
				{ id: 'home', text: 'Home', img: 'icon-cog-alt', expanded: true, group: true,
				nodes: [ { id: 'overview', text: 'System Overview', img: 'icon-angle-right'}
						 ]
				},
				{ id: 'config', text: 'Config', img: 'icon-cog-alt', expanded: true, group: true,
				  nodes: [ { id: 'config/queues', text: 'Queues', img: 'icon-angle-right'},
						   { id: 'config/messages', text: 'Messages', img: 'icon-angle-right' },
						   { id: 'config/properties', text: 'Properties', img: 'icon-angle-right' },
						   { id: 'config/attributes', text: 'Attributes', img: 'icon-angle-right' },
						   { id: 'config/mappings', text: 'Mappings', img: 'icon-angle-right' }
						 ]
				}
			],
			onClick: function(event){
			 	sideBarCallBack(event);
			 }
		}));
		
	}
	
	function sideBarCallBack(event){
			$.ajax({
		    url: event.target,
		        success: function(data){
		        var msgtabs = w2ui['plmt_tabs'];
		        if( typeof msgtabs !== 'undefined'){
		          msgtabs.destroy();
		         }
		       
		       // alert(data)
		            w2ui['plmt_layout'].content('main',data);
		        }
		   		 });			
	}