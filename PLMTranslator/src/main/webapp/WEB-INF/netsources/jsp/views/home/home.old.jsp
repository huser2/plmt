
<%@ include file="../common/begin.jspf"%>
<script src="resources/js/plmt.js" type="text/javascript"></script>

<link href="resources/css/navigation.css" rel="stylesheet"
	type="text/css" />
<script src="resources/js/navigation.js" type="text/javascript"></script>

<h3>PLM Translator</h3>

<div id="navigationDiv">
	<ul id="navigation">
		<li><a href="home">Home</a>
			<ul>
				<li><a id="homeUpdates" href="home?updates"
					onclick="processRequest(this);return false;">Updates</a></li>
				<li><a id="homeMySettings" href="home?mySettings"
					onclick="processRequest(this);return false;">My Settings</a></li>
			</ul></li>
		<!--  li><a href="mdm">Multi Data Migrator</a>
			<ul>
				<li><a href="mdm?properties">Properties</a></li>
				<li><a href="mdm?appConnector">Application Connector</a></li>
				<li><a href="mdm?export">Export Settings</a></li>
			</ul></li -->
		<li><a href="odt">Online Data Transfer</a>
			<ul>
				<li><a href="odt?queues">Queues</a></li>
				<li><a href="odt?completedJobs">Completed Jobs</a></li>
			</ul></li>

		<li><a href="qManagement">Queue Management</a>
			<ul>
				<li><a id="qmanager/queues" href="qmanager?queues"
					onclick="processRequest(this);return false;">Queues</a></li>
				<li><a id="qmanager/topics" href="qmanager?topics"
					onclick="processRequest(this);return false;">Topics</a></li>
			</ul></li>

		<li><a href="appSettings">Settings</a>
		<ul>
				<li><a id="settings/qprops" href="settings?qprops"
					onclick="processRequest(this);return false;">Configure Queues</a></li>
				
			</ul>
		</li>
	</ul>
</div>

<div id="loadSelectedPage" style="padding: 50px 0px;"></div>

<%@ include file="../common/end.jspf"%>
