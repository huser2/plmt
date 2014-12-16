
<%@page import="java.sql.ResultSet"%>
<%@page import="com.plm.conn.jms.ApplicationContextProvider"%>
<%@page import="com.plm.conn.obj.QueueDao"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<%
	QueueDao queue = ApplicationContextProvider.getApplicationContext()
			.getBean(QueueDao.class);
	out.print(queue.getQueueList());
	ResultSet rs = queue.getQueueList();
%>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">

		<div class="body">
		
		<h1>hoooooo</h1>
			<a href="topics.jsp">hello</a>


		</div>


	</tiles:putAttribute>
</tiles:insertDefinition>