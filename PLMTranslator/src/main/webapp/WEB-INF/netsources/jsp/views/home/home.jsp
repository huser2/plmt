<%@page import="com.plm.conn.jms.ApplicationContextProvider"%>
<%@page import="com.plm.conn.obj.CompletedJobsDao"%>
<%@page import="java.net.InetAddress"%>
<%@page import="org.apache.activemq.command.MessageId"%>
<%@page import="com.plm.conn.obj.Queue"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<%

CompletedJobsDao obj = ApplicationContextProvider.getApplicationContext().getBean(CompletedJobsDao.class);

try{
out.print(obj.getDataSource().getConnection().getMetaData().getIdentifierQuoteString());
}catch(Exception e){
	e.printStackTrace();
}

%>

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">



		<div class="body">
		
			<table border="0">
				<tr>
					<td>Server Host Name</td>
					<td><b>${hostName}</b></td>
				</tr>
				<tr>
					<td>Server IP Address</td>
					<td><b>${ipAddress}</b></td>
				</tr>
				<tr>
					<td>Listening for (TCP) connections at</td>
					<td><b>${tcpBrokerURL}</b></td>
				</tr>
				<tr>
					<td>Listening for (STOMP) connections at</td>
					<td><b>${stompBrokerURL}</b></td>
				</tr>
				
			</table>
		</div>



	</tiles:putAttribute>
</tiles:insertDefinition>