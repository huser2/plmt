
<%@page import="org.json.JSONArray"%>

 
<div style="padding:40px;">

	<table style="padding: 100px" class="overviewtbl">
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

