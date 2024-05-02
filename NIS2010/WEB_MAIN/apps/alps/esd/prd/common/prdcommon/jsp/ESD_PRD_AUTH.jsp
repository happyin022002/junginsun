<%
String retCRUD = "";
retCRUD = (String)event.getAttribute("crud");
%>
<script language="javascript">
var CRUD = "<%=retCRUD %>";
</script>