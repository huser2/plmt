<style>
.w2ui-field input {
	width: 200px;
}

.w2ui-field>div>span {
	margin-left: 0px;
}
</style>


<%
%>
<div class="w2ui-field w2ui-span3">
	<label>List:</label>
	<div>
		<input type="list" id="plmNames_list" onchange="loadAttributeList()">
		<span class="legend">Select the PLM to edit the list of
			Attributes.</span>
	</div>
</div>

<div id="attributesGrid" style="width: 100%; height: 500px;"></div>

<script type="text/javascript">
	var gridID = $('#attributesGrid');
	var gridName = 'attributesGrid';
	var header = "List of Attributes";
	var columns = [ {
		field : 'attributeId',
		caption : 'Attribute ID',
		size : '30%',
		editable:{type:'text'}
	}, {
		field : 'attributeName',
		caption : 'Attribute Name',
		size : '30%',
		editable:{type:'text'}
	} ];

	var tblAddons = {		
			header : true,
			toolbar : true,
			footer : true,
			lineNumbers : true,
			selectColumn : true,
	};

	var toolbar = {
		items : [ {
			id : 'config/addAttribute',
			type : 'button',
			caption : 'Add New Attribute',
			icon : 'icon-cog-1'
		}, {
			id : 'config/deleteAttribute',
			type : 'button',
			caption : 'Remove',
			icon : 'w2ui-icon-cross'
		},{
			id : 'config/saveAttribute',
			type : 'button',
			caption : 'Save',
			icon : 'w2ui-icon-check'
		} ],
		onClick : function(event) {
			if (event.target == 'config/addAttribute') {
                    w2ui[gridName].add({ recid: w2ui[gridName].records.length + 1 });                
            }
            if (event.target == 'config/saveAttribute') {
            	var grid = w2ui[gridName];
            	   var changed = grid.getChanges();            	   
            	   
            	   var list = $.makeArray();
            	   
            	   var obj = $('#plmNames_list').data('selected');
            	   var selected_plm = obj.text;
					for (var i = 0; i < changed.length; i++) {
						var changeList = {};					
						var row = changed[i];						
						changeList['attributeId'] = row.attributeId;
						changeList['attributeName'] = row.attributeId;
						changeList['plmName'] = selected_plm;
						list.push(changeList);						
					}
					
					list  = JSON.stringify(list);
					var postData = '{"attributes":'+list+'}';
					console.log("object ...."+postData);
					
                   $.post(event.target, postData, function() {
						w2alert('Saved');
						grid.reload();
					});                
            }
            if (event.target == 'config/deleteAttribute') {
            		var grid = w2ui[gridName];
					var sel = grid.getSelection();
					
					var list =$.makeArray();
					
					for (var del = 0; del < sel.length; del++) {
						var delList = {};
						var row = grid.get(del);
						delList['attributeId'] = row.attributeId;
						delList['attributeName'] = row.attributeId;
						delList['plmName'] = row.plmName;
						delList['id'] = row.id;
						list.push(delList);
					}
					
					list  = JSON.stringify(list);
					var postData = '{"attributes":'+list+'}';
					console.log("object ...."+postData);
					
                    $.post(event.target, postData, function() {
						w2alert('Deleted');
						grid.reload();
					});                
            }
            
		}
	}

	function loadAttributeList() {
		var obj = $('#plmNames_list').data('selected');

		var grid = w2ui['attributesGrid'];
		if (typeof grid !== 'undefined') {
			grid.destroy();
		}
		var selected_plm = obj.text;			
		this.target='config/plmattributes.list?selected_plm='+selected_plm;	
			
		renderGrid(gridID, gridName, this, header + ' for ' + selected_plm,
				columns, null, tblAddons, toolbar);
	}

	$(function() {
		//var plmlist = [ 'Windchill', 'Team Center', 'Enovia' ];
		$('#plmNames_list').w2field('list', {
			//items : plmlist,
			required : true,
			url : 'config/plm.list',
			minLength : 0

		});

		var grid = w2ui[gridName];
		if (typeof grid !== 'undefined') {
			grid.destroy();
		}

	});
</script>