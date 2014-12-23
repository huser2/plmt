

<%@taglib uri="http://displaytag.sf.net" prefix="displayTable"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<link rel="stylesheet" href="resources/css/displaytag.css"
	type="text/css">
	


<%
	Object s = request.getAttribute("failedList");
	//out.print(s);
%>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<div class="body">

			<displayTable:table name="failedList" class="its" sort="list" pagesize="12" export="true">
				<displayTable:column property="failedId" title="Id" sortable="true" headerClass="sortable" />
				<displayTable:column property="expiration" title="Name" sortable="true" headerClass="sortable" />
				<displayTable:column property="msgidProd" title="Desc" sortable="true" headerClass="sortable" />
				<displayTable:column property="failedDate" title="Email" sortable="true" headerClass="sortable" />
				<displayTable:column property="msgidProd" title="Status" sortable="true" headerClass="sortable" />
			</displayTable:table>
			
				<displayTable:table name="completedList" class="its" sort="list" pagesize="12" export="true" >
				<displayTable:column property="completedId" title="Id" sortable="true" headerClass="sortable" />
				<displayTable:column property="expiration" title="Name" sortable="true" headerClass="sortable" />
				<displayTable:column property="msgidProd" title="Desc" sortable="true" headerClass="sortable" />
				<displayTable:column property="completedDate" title="Email" sortable="true" headerClass="sortable" />
				<displayTable:column property="msgidProd" title="Status" sortable="true" headerClass="sortable" />
			</displayTable:table>		


		</div>


	</tiles:putAttribute>
</tiles:insertDefinition>