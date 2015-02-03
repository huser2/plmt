
<style>
.w2ui-field input {
	width: 200px;
}

.w2ui-field>div>span {
	margin-left: 0px;
}
</style>

<div class="w2ui-field w2ui-span3">
	<label>List:</label>
	<div>
		<input type="list" id="plmNames_list" onchange="loadTypeList()">
		<span class="legend">Select the PLM to edit the list of
			types.</span>
	</div>
</div>

<div id="typesGrid" style="width: 100%; height: 500px;"></div>

<script type="text/javascript">
	var gridID = $('#typesGrid');
	var gridName = 'typesGrid';
	var header = "List of types";
	var columns = [ {
		field : 'typeId',
		caption : 'Type ID',
		size : '30%',
		editable:{type:'text'}
	}, {
		field : 'typeName',
		caption : 'Type Name',
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
		} ],
		onClick : function(event) {
			if (event.target == 'config/addObjectType') {
                    w2ui[gridName].add({ recid: w2ui[gridName].records.length + 1 });                
            }
            if (event.target == 'config/saveObjectType') {
            	var grid = w2ui[gridName];
            	   var changed = grid.getChanges();            	   
            	   
            	   var list = $.makeArray();
            	   
            	   var obj = $('#plmNames_list').data('selected');
            	   var selected_plm = obj.text;
					for (var i = 0; i < changed.length; i++) {
						var changeList = {};					
						var row = changed[i];						
						changeList['typeId'] = row.typeId;
						changeList['typeName'] = row.typeName;
						changeList['plmName'] = selected_plm;
						list.push(changeList);						
					}
					
					list  = JSON.stringify(list);
					var postData = '{"types":'+list+'}';
					console.log("object ...."+postData);
					
                   $.post(event.target, postData, function() {
						w2alert('Saved');
						grid.reload();
					});                
            }
            if (event.target == 'config/deleteObjectType') {
            		var grid = w2ui[gridName];
					var sel = grid.getSelection();
					
					var list =$.makeArray();
					debugger;
					for (var del = 0; del < sel.length; del++) {
						var delList = {};
						var row = grid.get(sel[del]);
						delList['typeId'] = row.typeId;
						delList['typeName'] = row.typeName;
						delList['plmName'] = row.plmName;
						delList['id'] = row.id;
						list.push(delList);
					}
					
					list  = JSON.stringify(list);
					var postData = '{"types":'+list+'}';
					console.log("object ...."+postData);
					
                    $.post(event.target, postData, function() {
						w2alert('Deleted');
						grid.reload();
					});                
            }
            
		}
	}

	function loadTypeList() {
		var obj = $('#plmNames_list').data('selected');

		var grid = w2ui['typesGrid'];
		if (typeof grid !== 'undefined') {
			grid.destroy();
		}
		var selected_plm = obj.text;			
		this.target='config/plmtypes.list?selected_plm='+selected_plm;	
			
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