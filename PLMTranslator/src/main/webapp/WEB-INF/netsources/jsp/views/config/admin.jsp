<%@page import="org.json.JSONObject"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="com.plm.conn.model.QueueService"%>


<div id="admin_tabs" style="width: 100%;"></div>
<div id="myGrid" style="height: 300px; padding: 10px;"></div>

<script type="text/javascript">
	$(function() {
		var gridID = $('#myGrid');
		var connectUrl = 'config/connect';
		var mapAttrsUrl = 'config/mapAttrs';
		var manageAttrsUrl = 'config/manageAttrs';
		var manageTypesUrl = 'config/manageTypes';
		var gridName='myGrid';

		var connectTblAddons = {
			header : true,
			toolbar : true,
			footer : true,
			lineNumbers : true,
			selectColumn : true,
		};

		var toolbar = {
			items : [ {
				id : 'config/addConnection',
				type : 'button',
				caption : 'New Connection',
				icon : 'icon-plus'
			}, {
				id : 'config/deleteConnection',
				type : 'button',
				caption : 'Delete',
				icon : 'w2ui-icon-cross'
			} ],
			onClick : function(event) {
				if (event.target == 'config/addConnection') {
					var plmList = [ 'Enovia', 'Team Center' ];
					if (!w2ui.foo) {
						$()
								.w2form(
										{
											name : 'foo',
											url : 'config/addConnection',
											style : 'border: 0px; background-color: transparent;',
											formHTML : '<div class="w2ui-page page-0">'
													+ '    <div class="w2ui-field">'
													+ '        <label>Windchill Host Name:</label>'
													+ '        <div>'
													+ '           <input name="wncHostname" type="text" maxlength="100" style="width: 250px"/>'
													+ '        </div>'
													+ '    </div>'
													+ '    <div class="w2ui-field">'
													+ '        <label>Windchill IP Address:</label>'
													+ '        <div>'
													+ '            <input name="wncIpaddress" type="text" maxlength="100" style="width: 250px"/>'
													+ '        </div>'
													+ '    </div>'
													+ '    <div class="w2ui-field">'
													+ '        <label>Select PLM application:</label>'
													+ '        <div>'
													+ '            <input name="plm" type="list" style="width: 250px"/>'
													+ '        </div>'
													+ '    </div>'
													+ '    <div class="w2ui-field">'
													+ '        <label>PLM Host Name:</label>'
													+ '        <div>'
													+ '           <input name="plmHostname" type="text" maxlength="100" style="width: 250px"/>'
													+ '        </div>'
													+ '    </div>'
													+ '    <div class="w2ui-field">'
													+ '        <label>PLM IP Address:</label>'
													+ '        <div>'
													+ '            <input name="plmIpaddress" type="text" maxlength="100" style="width: 250px"/>'
													+ '        </div>'
													+ '    </div>'
													+ '<div class="w2ui-buttons">'
													+ '    <button class="btn" name="reset">Reset</button>'
													+ '    <button class="btn" name="save">Save</button>'
													+ '</div>',
											fields : [
													{
														field : 'wncHostname',
														type : 'text',
														required : true
													},
													{
														field : 'wncIpaddress',
														type : 'text',
														required : true
													},
													{
														field : 'plm',
														type : 'list',
														required : true,
														options : {
															items : [ 'Enovia',
																	'Team Center' ]
														}
													}, {
														field : 'plmHostname',
														type : 'text',
														required : true
													}, {
														field : 'plmIpaddress',
														type : 'text',
														required : true
													},

											],
											onSubmit : function(event) {
												event.postData = event.postData.record;
												var jsonString = JSON
														.stringify(event.postData);
												var json = jQuery
														.parseJSON(jsonString);
												var retJson = {};

												$
														.each(
																json,
																function(idx,
																		obj) {

																	if (typeof obj === 'object') {
																		obj = obj.text;
																	}
																	retJson[idx] = obj;
																});

												event.postData = retJson;
											},
											actions : {
												"save" : function() {
													this.validate();
													this
															.save(function(data) {

																if (data.status == 'success') {
																	var grid = w2ui[gridName];
																	grid
																			.reload();
																	//w2ui.foo
																	//		.clear();
																	w2popup
																			.close();
																} else {
																	w2popup
																			.close();

																}
															});
												},
												"reset" : function() {
													this.clear();
												},
											}
										});
					}

					$()
							.w2popup(
									'open',
									{
										title : 'Connection Details',
										body : '<div id="form" style="width: 100%; height: 100%;"></div>',
										style : 'padding: 15px 0px 0px 0px',
										width : 500,
										height : 500,
										showMax : true,
										onToggle : function(event) {
											$(w2ui.foo.box).hide();
											event.onComplete = function() {
												$(w2ui.foo.box).show();
												w2ui.foo.resize();
											}
										},
										onOpen : function(event) {
											event.onComplete = function() {
												// specifying an onOpen handler instead is equivalent to specifying an onBeforeOpen handler, which would make this code execute too early and hence not deliver.
												$('#w2ui-popup #form')
														.w2render('foo');
											}
										}
									});

				}

				if (event.target == 'config/deleteConnection') {
					var grid = w2ui[gridName];
					var sel = grid.getSelection();
					var delList = {};
					for (var i = 0; i < sel.length; i++) {
						var selected = grid.get(i);
						delList[i] = selected.plm;
					}
					console.log('delete clicked:' + selected.plm);
					$.post(event.target, delList, function() {
						w2alert('Deleted');
						grid.reload();
					});

				}
			}
		};

		var connectHeader = 'List of Connections';
		failedColumns = [ {
			field : 'wncHostname',
			caption : 'Windchill Host Name',
			size : '30%'
		}, {
			field : 'wncIpaddress',
			caption : 'Windchill IP Address',
			size : '40%'
		}, {
			field : 'wncStatus',
			caption : 'Status',
			size : '30%'
		}, {
			field : 'plm',
			caption : 'PLM',
			size : '30%'
		}, {
			field : 'plmHostname',
			caption : 'Host Name',
			size : '30%'
		}, {
			field : 'plmIpaddress',
			caption : 'IP Address',
			size : '40%'
		}, {
			field : 'plmStatus',
			caption : 'Status',
			size : '30%'
		} ];

		//create tabs
		$('#admin_tabs').w2tabs(
				{
					name : 'admin_tabs',
					active : connectUrl,
					tabs : [ {
						id : connectUrl,
						caption : 'Connections'
					}, {
						id : manageTypesUrl,
						caption : 'Types'
					},{
						id : manageAttrsUrl,
						caption : 'Attributes'
					}, {
						id : mapAttrsUrl,
						caption : 'Map Attributes'
					} ],
					onClick : function(event) {
						
						var grid = w2ui[gridName];
						if (typeof grid !== 'undefined') {
							grid.destroy();
						}
						if (event.target == connectUrl) {
							renderGrid(gridID,gridName,event, connectHeader,
									failedColumns, null, connectTblAddons,
									toolbar);
						}
						//manage attributes
						if(event.target==manageAttrsUrl){
							renderPage(gridID,event);
						}
						
						//map attributes
						if(event.target==manageTypesUrl){
							renderPage(gridID,event);
						}
						
						//map attributes
						if(event.target==mapAttrsUrl){
							renderPage(gridID,event);
						}
						
					},
					onRender : function(event) {
						event.target = connectUrl;
						renderGrid(gridID,gridName, event, connectHeader, failedColumns,
								null, connectTblAddons, toolbar);

					}

				});

	});
</script>