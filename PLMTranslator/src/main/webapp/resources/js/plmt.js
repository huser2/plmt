/**
 * 
 */

/* Get values for the parsed URL */

jQuery.extend({
	getValues : function(url) {
		var result = null;
		$.ajax({
			url : url,
			type : 'get',
			dataType : 'html',
			async : false,
			cache : false,
			success : function(data) {
				result = data;
			}
		});
		return result;
	}
});

function processRequest(request) {
	var xmlhttp;
	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp = new XMLHttpRequest();
	} else {// code for IE6, IE5
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			w2ui['plmt_layout'].content('main', xmlhttp.responseText);
			// document.getElementById("loadSelectedPage").innerHTML =
			// xmlhttp.responseText;
		}
	}
	xmlhttp.open("GET", request.id, true);
	xmlhttp.send();
}

function createLayout(layoutDiv) {
	var pstyle = 'border-style:initial; solid #dfdfdf; padding: 0px;';

	layoutDiv.w2layout({
		name : 'plmt_layout',
		panels : [ {
			type : 'top',
			size : 35,
			resizable : false,
			content : '',
			title : 'PLMBridge'
		}, {
			type : 'left',
			size : 200,
			resizable : true,
			content : '',
			title : 'Navigator'
		}, {
			type : 'main',
			resizable : true,
			style : pstyle,
			content : loadOverView()
		} ]
	});
}

function loadOverView() {
	$.ajax({
		url : 'overview',
		success : function(data) {
			var msgtabs = w2ui['queue_tabs'];
			if (typeof msgtabs !== 'undefined') {
				msgtabs.destroy();
			}
			w2ui['plmt_layout'].content('main', data);
		}
	});

}

function createMenu(menuDiv) {
	w2ui['plmt_layout'].content('left', $().w2sidebar({
		name : 'plmt_sidebar',
		img : null,
		nodes : [ {
			id : 'home',
			text : 'Home',
			img : 'icon-cog-alt',
			expanded : true,
			group : true,
			nodes : [ {
				id : 'overview',
				text : 'System Overview',
				img : 'icon-angle-right'
			} ]
		}, {
			id : 'config',
			text : 'Config',
			img : 'icon-cog-alt',
			expanded : true,
			group : true,
			nodes : [ {
				id : 'config/admin',
				text : 'System Administration',
				img : 'icon-angle-right'
			}, {
				id : 'config/queues',
				text : 'Queue Status',
				img : 'icon-angle-right'
			} ]
		} ],
		onClick : function(event) {
			sideBarCallBack(event);
		}
	}));

}

function sideBarCallBack(event) {
	$.ajax({
		url : event.target,
		success : function(data) {
			var qtabs = w2ui['queue_tabs'];
			var admintabs = w2ui['admin_tabs'];
			if (typeof qtabs !== 'undefined') {
				qtabs.destroy();
			}
			if (typeof admintabs !== 'undefined') {
				admintabs.destroy();
			}

			w2ui['plmt_layout'].content('main', data);
		}
	});
}

function renderGrid(gridObj, gridName, event, header, columns, searches, show,
		toolbar) {

	var grid = w2ui[gridName];
	if (typeof grid !== 'undefined') {
		grid.destroy();
	}

	gridObj.w2grid({
		name : gridName,
		header : header,
		searches : searches,
		show : show,
		url : event.target,
		columns : columns,
		toolbar : toolbar
	});

}

function renderGridWithGroupColumns(gridObj, gridName, event, header, columns,
		searches, show, toolbar, groups) {

	var grid = w2ui[gridName];
	if (typeof grid !== 'undefined') {
		grid.destroy();
	}

	gridObj.w2grid({
		name : gridName,
		header : header,
		searches : searches,
		show : show,
		url : event.target,
		columns : columns,
		toolbar : toolbar,
		columnGroups : groups
	});

}

// manage attributes page
function renderPage(gridId, event) {
	$(gridId).load(event.target, function() {
		console.log("Load was performed page:." + event.target);
	});
}