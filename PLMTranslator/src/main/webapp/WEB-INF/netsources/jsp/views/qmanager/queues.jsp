<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page import="java.util.Set"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="com.plm.conn.jms.ApplicationContextProvider"%>
<%@page import="javax.jms.Session"%>
<%@page import="com.plm.conn.beans.ActiveMQBrowser"%>
<%@taglib uri="http://displaytag.sf.net" prefix="displayTable"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<link rel="stylesheet" href="resources/css/displaytag.css"
	type="text/css">

<%
	ApplicationContext context = ApplicationContextProvider
			.getApplicationContext();
	ActiveMQBrowser browser = (ActiveMQBrowser) context
			.getBean("queueBrowser");
	Set qsession = browser.getBrowserConnection()
			.getDestinationSource().getTemporaryQueues();
	out.print("q qty........."+browser.getBrowserConnection().getDestinationSource()
			.getTemporaryQueues());
%>

<html>

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">



		<form action="login" method="post">
			<input type="text" name="username"> <input type="password"
				name="password"> <input type="submit">
		</form>


		</body>
</html>




</tiles:putAttribute>
</tiles:insertDefinition>