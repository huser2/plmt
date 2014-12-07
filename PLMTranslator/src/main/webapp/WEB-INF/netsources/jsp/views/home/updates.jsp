<%@page import="com.plm.conn.jms.receivers.MessageReceiver"%>
<%@page import="com.plm.conn.jms.ApplicationContextProvider"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="org.springframework.boot.SpringApplication"%>
<%@page import="org.springframework.context.ConfigurableApplicationContext"%>
<%@page import="com.plm.conn.jms.senders.MessageSender"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.plm.conn.beans.Person"%>
<%@page import="java.util.List"%>

<%@taglib uri="http://displaytag.sf.net" prefix="displayTable"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<link rel="stylesheet" href="resources/css/displaytag.css"
	type="text/css">
<%
	// Launch the application
	/* ApplicationContext context = ApplicationContextProvider.getApplicationContext();
	out.print(context);
	MessageSender sender = (MessageSender) context.getBean("messageSender");
	MessageReceiver rec =(MessageReceiver) context.getBean("messageListener");
	Map<String,String> message = new HashMap<String,String>();
	message.put("Hello", "Rakesh");
	message.put("country", "Singapore");
	message.put("state", "Singapore");
	message.put("city", "Singapore");

	sender.send(message);*/

	//out.println("Message Send to Jms Queue:- " + message);	
	//out.print("receiver >>>>>"+rec);
	%>

<displayTable:table name="test" class="its">
	<displayTable:column property="id" title="Id" />
	<displayTable:column property="name" title="Name" />
	<displayTable:column property="description" title="Desc" />
	<displayTable:column property="email" title="Email" />
	<displayTable:column property="status" title="Status" />

</displayTable:table>