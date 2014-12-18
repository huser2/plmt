<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>



<div id="menu">
	<ul id="navigation">
		<li><spring:url value="/home" var="homeUrl" htmlEscape="true" />
			<a href="${homeUrl}">Home</a></li>
			
		<li><spring:url value="/config" var="configUrl"
				htmlEscape="true" /> <a href="${configUrl}">Config</a>
			<ul>
				<li><spring:url value="/config/queues" var="queuesUrl"
						htmlEscape="true" /> <a href="${queuesUrl}">Queues</a></li>
			
				<li><spring:url value="/config/properties" var="propertyUrl"
						htmlEscape="true" /> <a href="${propertyUrl}">Properties</a></li>
			
				<li><spring:url value="/config/attributes" var="attributesUrl"
						htmlEscape="true" /> <a href="${attributesUrl}">Attributes</a></li>
						
				<li><spring:url value="/config/mappings" var="attributesUrl"
						htmlEscape="true" /> <a href="${attributesUrl}">Mappings</a></li>
			</ul>
			
			
		</li>
	</ul>
</div>

