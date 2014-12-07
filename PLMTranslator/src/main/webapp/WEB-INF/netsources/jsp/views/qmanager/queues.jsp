
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
<html>
<%

ApplicationContext context  = ApplicationContextProvider.getApplicationContext();
ActiveMQBrowser browser  =  (ActiveMQBrowser)context.getBean("queueBrowser");
Set qsession = browser.getBrowserConnection().getDestinationSource().getTemporaryQueues();
out.print(browser.getBrowserConnection().getDestinationSource().getTemporaryQueues());
%>

</html>