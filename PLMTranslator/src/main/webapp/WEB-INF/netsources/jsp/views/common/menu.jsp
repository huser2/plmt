<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>



<div id="menu">
	<ul id="navigation">
		<li><spring:url value="/home" var="homeUrl" htmlEscape="true" />
			<a href="${homeUrl}">Home</a></li>
		<li><spring:url value="/qManagement" var="qManagementUrl"
				htmlEscape="true" /> <a href="${qManagementUrl}">Queues</a>
			<ul>
				<li><spring:url value="/qmanager/queues" var="queuesUrl"
						htmlEscape="true" /> <a href="${queuesUrl}">Queues</a></li>
			</ul></li>
	</ul>
</div>

