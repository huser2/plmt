<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>



<div id="menu">
	<ul id="navigation">
		<li><spring:url value="/home" var="homeUrl" htmlEscape="true" />
			<a href="${homeUrl}">Home</a>
			<ul>
				<li><spring:url value="/homeUpdates" var="homeUpdates"
						htmlEscape="true" /> <a href="${homeUpdates}">Updates</a>
				<li><spring:url value="/homeMySettings" var="homeMySettings"
						htmlEscape="true" /> <a href="${homeMySettings}">My Settings</a>
			</ul></li>
		<li><spring:url value="/qManagement" var="qManagementUrl"
				htmlEscape="true" /> <a href="${qManagementUrl}">Queues</a>
			<ul>
				<li><spring:url value="/qmanager/queues" var="queuesUrl"
						htmlEscape="true" /> <a href="${queuesUrl}">Queues</a></li>
			</ul></li>
		<li><spring:url value="/appSettings" var="settingsUrl"
				htmlEscape="true" /> <a href="${settingsUrl}">Settings</a>


			<ul>
				<li><spring:url value="/settings/qprops" var="qPropsUrl"
						htmlEscape="true" /> <a href="${qPropsUrl}">Configure Queues</a>
				</li>

			</ul></li>
	</ul>
</div>

