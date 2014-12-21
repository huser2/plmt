
<%@page import="com.plm.conn.model.Queue"%>
<%@page import="com.plm.conn.model.QueueService"%>
<%@page import="com.plm.conn.queue.QueueHelper"%>
<%@page import="com.plm.conn.jms.ApplicationContextProvider"%>
<%@page import="java.net.InetAddress"%>
<%@page import="org.apache.activemq.command.MessageId"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>


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