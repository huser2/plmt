
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
		<input type="list" id="plmNames_list" onchange="loadAttributeList()">
		<span class="legend">Select the PLM to edit the list of
			Attributes.</span>
	</div>
</div>

<div id="attributesGrid" style="width: 100%; height: 350px;"></div>

<script type="text/javascript">
	var gridID = $('#attributesGrid');
	var header = "List of Attributes";
	var columns = [ {
		field : 'wncHostname',
		caption : 'Attribute ID',
		size : '30%'
	}, {
		field : 'wncHostname',
		caption : 'Attribute Name',
		size : '30%'
	} ];

	var tblAddons = {
		header : true,
		toolbar : true,
		footer : true,
		lineNumbers : true,
		selectColumn : true,
	};
	var toolbar = true;
	var gridName='';

	function loadAttributeList() {
		var obj = $('#plmNames_list').data('selected');

		var grid = w2ui['attributesGrid'];
		if (typeof grid !== 'undefined') {
			grid.destroy();
		}
		var selected_plm = obj.text;
		renderGrid(gridID,gridName, this, header + ' for ' + selected_plm, columns,
				null, tblAddons, toolbar);
	}

	$(function() {
		var plmlist = [ 'Windchill', 'Team Center', 'Enovia' ];
		$('#plmNames_list').w2field('list', {
			//items : plmlist,
			required : true,
			url : 'config/plm.list'

		});

		var grid = w2ui['attributesGrid'];
		if (typeof grid !== 'undefined') {
			grid.destroy();
		}

	});
</script>