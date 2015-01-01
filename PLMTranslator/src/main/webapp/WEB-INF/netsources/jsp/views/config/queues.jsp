

<%@page import="com.plm.conn.model.QueueService"%>
<div id="queue_tabs" style="width: 100%;"></div>
<div id="myGrid" style="height: 450px; padding: 10px;"></div>

<%
	
%>

<script type="text/javascript">
	$(function() {
		var gridID = $('#myGrid');
		var completedUrl = 'config/completed.list';
		var failedUrl = 'config/failed.list';

		var completedHeader = 'List of Completed Queues';
		var failedHeader = 'List of Failed Queues';
		var columns = '';

		var searches = [ {
			field : 'msgidSeq',
			caption : 'Message ID',
			type : 'text'
		}, {
			field : 'expiration',
			caption : 'Expiration',
			type : 'text'
		}, {
			field : 'completedId',
			caption : 'Completed ID',
			type : 'text'
		}, {
			field : 'failedId',
			caption : 'Completed ID',
			type : 'text'
		}, ];

		completedColumns = [ {
			field : 'msgidSeq',
			caption : 'Message ID',
			size : '30%'
		}, {
			field : 'expiration',
			caption : 'Expiration',
			size : '30%'
		}, {
			field : 'completedId',
			caption : 'Completed ID',
			size : '40%'
		}, {
			field : 'priority',
			caption : 'Priority',
			size : '120px'
		}, ];

		failedColumns = [ {
			field : 'msgidSeq',
			caption : 'Message ID',
			size : '30%'
		}, {
			field : 'expiration',
			caption : 'Expiration',
			size : '30%'
		}, {
			field : 'failedId',
			caption : 'Failed ID',
			size : '40%'
		}, {
			field : 'priority',
			caption : 'Priority',
			size : '120px'
		}, ];


		var tbladdons =  {
			header : true,
			toolbar : true,
			footer : true,
			lineNumbers : true
		};
		//create tabs
		$('#queue_tabs').w2tabs({
			name : 'queue_tabs',
			active : completedUrl,
			tabs : [ {
				id : completedUrl,
				caption : 'Completed'
			}, {
				id : failedUrl,
				caption : 'Failed'
			} ],
			onClick : function(event) {
				if (event.target == completedUrl) {
					header = completedHeader;
					columns = completedColumns;
				}
				if (event.target == failedUrl) {
					header = failedHeader;
					columns = failedColumns;
				}

				renderGrid(gridID, event, header, columns,searches,tbladdons,null);
			},
			onRender : function(event) {
				event.target = completedUrl;
				renderGrid(gridID, event, completedHeader, completedColumns,searches,tbladdons,null);
			}

		});

	});
</script>
