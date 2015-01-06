
<%@page import="java.util.List"%>
<%@page import="com.plm.conn.model.QueueService"%>
<div class="w2ui-field w2ui-span3">
	<label>List:</label>
	<div>
		<input type="list" id="plmNames_list" onchange="renderMappingTable()">
		<span class="legend">Select the PLM to edit the list of
			types.</span>
	</div>
</div>

<div id="mappingGrid" style="width: 100%; height: 400px;"></div>

<script type="text/javascript">

var  gridName = 'mappingGrid'; 

function renderMappingTable(){ 

var obj = $('#plmNames_list').data('selected');
var selected_plm = obj.text;

       var gridObj = $('#mappingGrid');       
       var  searches=null;
        
        var toolbar = {
		items : [ {
			id : 'config/addObjectType',
			type : 'button',
			caption : 'Add New Type',
			icon : 'icon-cog-1'
		}, {
			id : 'config/deleteObjectType',
			type : 'button',
			caption : 'Remove',
			icon : 'w2ui-icon-cross'
		},{
			id : 'config/saveObjectType',
			type : 'button',
			caption : 'Save',
			icon : 'w2ui-icon-check'
		} ]};
        var header ='Mapping Table';
        var show = { header : true,
			toolbar : true,
			footer : true,
			lineNumbers : true,
			selectColumn : true };
        var sortData = [ { field: 'recid', direction: 'asc' } ];
        var columnGroups= [            
            { caption: 'Windchill Information', span: 2 },           
            { caption: selected_plm+' Information', span: 2 }
        ];
        
        var columns = [ 
            { field: 'plm1TypeId', caption: 'Object Type', size: '25%', sortable: true, resizable: true },
            { field: 'plm1AttributeId', caption: 'Attribute ID', size: '25%', sortable: true, resizable: true },            
            { field: 'plm2TypeId', caption: 'Object Type', size: '25%', sortable: true, resizable: true },
            { field: 'plm2AttributeId', caption: 'Attribute ID', size: '25%', sortable: true, resizable: true },
        ];        
       
   var event = this;  
   event.target = 'config/attributemapping.list?selected_plm='+selected_plm;   
   renderGridWithGroupColumns(gridObj, gridName, event, header, columns, searches, show, toolbar, columnGroups);
   }

$(function () {

$('#plmNames_list').w2field('list', {
			//items : plmlist,
			required : true,
			url : 'config/mappingPlm.list',
			minLength : 0
		});

		var grid = w2ui[gridName];
		if (typeof grid !== 'undefined') {
			grid.destroy();
		}
		
});
</script>