
<%@page import="org.json.JSONArray"%>
<%@page import="org.json.JSONObject"%>
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

	debugger;
var obj = $('#plmNames_list').data('selected');
var selected_plm = obj.text;

var plmTypes = $.getValues('config/plmtype.mappingtable.list?selected_plm='+selected_plm);
var plmAttributes = $.getValues('config/plmattribute.mappingtable.list?selected_plm='+selected_plm);

var wncTypes = $.getValues('config/plmtype.mappingtable.list?selected_plm=Windchill');
var wncAttributes = $.getValues('config/plmattribute.mappingtable.list?selected_plm=Windchill');


       var gridObj = $('#mappingGrid');       
       var  searches=null;
        
        var toolbar = {
		items : [ {
			id : 'config/createNewMapping',
			type : 'button',
			caption : 'Add New Mapping',
			icon : 'icon-cog-1'
		}, {
			id : 'config/deleteNewMapping',
			type : 'button',
			caption : 'Remove',
			icon : 'w2ui-icon-cross'
		},{
			id : 'config/saveNewMapping',
			type : 'button',
			caption : 'Save',
			icon : 'w2ui-icon-check'
		} ],
		onClick : function(event) {
			if (event.target == 'config/createNewMapping') {
                    w2ui[gridName].add({ recid: w2ui[gridName].records.length + 1 });                
              }
			
			 if (event.target == 'config/saveNewMapping') {
	            	var grid = w2ui[gridName];
	            	   var changed = grid.getChanges();            	   
	          
	            	   var changeList = $.makeArray();	
	            	   var obj = $('#plmNames_list').data('selected');
	            	   var selected_plm = obj.text;
						for (var i = 0; i < changed.length; i++) {											
							var row = changed[i];	
							var ret = {};
							Object.keys(row).forEach(function(key) {
								if(row[key].text !=='undefined'){
									ret[key] = row[key].text;
									//ret['plmName'] = selected_plm;
								}								
						    },row);
							ret['id']=i;
							changeList.push(ret);
						}
						
						debugger;
						changeList  = JSON.stringify(changeList);
						var postData = '{"attributes":'+changeList+'}';
						console.log("object ...."+postData);
						
	                   $.post(event.target, postData, function() {
							w2alert('Saved');
							grid.reload();
						});                
	            }
	            if (event.target == 'config/deleteNewMapping') {
	            		var grid = w2ui[gridName];
	            	   var changed = grid.getChanges();            	   
	          
	            	   var changeList = $.makeArray();	
	            	   var obj = $('#plmNames_list').data('selected');
	            	   var selected_plm = obj.text;
						for (var i = 0; i < changed.length; i++) {											
							var row = changed[i];	
							var ret = {};
							Object.keys(row).forEach(function(key) {
								if(row[key].text !=='undefined'){
									ret[key] = row[key].text;
									//ret['plmName'] = selected_plm;									
								}								
						    },row);
							//ret['id']=i;
							changeList.push(ret);
						}
						
						debugger;
						changeList  = JSON.stringify(changeList);
						var postData = '{"attributes":'+changeList+'}';
						console.log("object ...."+postData);
	                    $.post(event.target, postData, function() {
							w2alert('Deleted');
							grid.reload();
						});                
	            }
	            
            }
        };
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
        
       //  plmTypes = ['teset','uyikkl','olklll'];
        
        var columns = [ 
            { field: 'plm1TypeName', caption: 'Object Type', size: '25%', sortable: true, resizable: true,
            	editable: { type: 'list', items: plmTypes,showAll: true},
                render: function (record, index, col_index) {  
                	debugger;
                    var html = this.getCellValue(index, col_index);
                    var text = (typeof html ==='object')? html.text:html;
                    return text;
                }
            },
            { field: 'plm1AttributeName', caption: 'Attribute ID', size: '25%', sortable: true, resizable: true, 
            	editable: { type: 'list', items: plmAttributes,showAll: true},
                render: function (record, index, col_index) {                   	
                    var html = this.getCellValue(index, col_index);
                    var text = (typeof html ==='object')? html.text:html;
                    return text;
                }
			},            
            { field: 'plm2TypeName', caption: 'Object Type', size: '25%', sortable: true, resizable: true,
            	editable: { type: 'list', items: wncTypes,showAll: true},
                render: function (record, index, col_index) {               	
                    var html = this.getCellValue(index, col_index);
                    var text = (typeof html ==='object')? html.text:html;
                    return text;
                }
            },
            { field: 'plm2AttributeName', caption: 'Attribute ID', size: '25%', sortable: true, resizable: true,
            	editable: { type: 'list', items: wncAttributes,showAll: true},
                render: function (record, index, col_index) {               	
                    var html = this.getCellValue(index, col_index);
                    var text = (typeof html ==='object')? html.text:html;
                    return text;
                }
            },
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