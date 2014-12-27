
<%@page import="org.json.JSONArray"%>
<%@page import="com.plm.conn.beans.Person"%>
<%@page import="org.json.JSONObject"%>
<%

Person p = new Person();
p.setAge("23");
p.setName("ram");
p.setCity("madras");
p.setId("12121");
p.setSex("male");

Person p1 = new Person();
p1.setAge("23");
p1.setName("ram");
p1.setCity("madras");
p1.setId("12121");
p1.setSex("male");


JSONObject json = new JSONObject(p);
JSONArray arr = new JSONArray();
arr.put(json);
json = new JSONObject(p1);
arr.put(json);
out.print(arr);
 %>
 
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

