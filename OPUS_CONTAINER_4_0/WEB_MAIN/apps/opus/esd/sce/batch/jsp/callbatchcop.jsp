<%@ page contentType="text/html;charset=euc-kr"%>
<%@ page import="com.clt.apps.opus.esd.sce.batch.rtrmanage.event.RTRManageEvent" %>   
<%@ page import="com.clt.apps.opus.esd.sce.batch.rtrmanage.event.RTRManageEventResponse" %>  
<%@ page import="com.clt.framework.core.layer.event.EventResponse" %>  
<%@ page import="com.clt.apps.opus.esd.sce.batch.rtrmanage.RTRManageBSC" %>  
              
<html>
<script language="javascript">

function onCallCop(){
		document.form1.action = "callbatchcop_s.jsp";
		alert("submit callbatchcop_s");
		document.form1.submit();
}
function onCallCop_2(){
		document.form2.action = "callbatchcop_t.jsp";
		alert("submit callbatchcop_t");
		document.form2.submit();
}
function onCallCop_3(){
		document.form3.action = "callbatchcop_u.jsp";
		alert("submit callbatchcop_u");
		document.form3.submit();
}

</script>
	<body>
		<form name="form1" >
			<table>
			<tr>
			        <td>
			            Call COP Batch : 
			        </td>
					<td>
						<input type="button" class="form" name="process1" value="process" onclick="javascript:onCallCop()">
					</td>
			</tr>
			</table>
		</form>
		<form name="form2" >
			<table>
			<tr>
			        <td>
			            Call Actual Receive Batch : 
			        </td>
					<td>
						<input type="button" class="form" name="process1" value="process" onclick="javascript:onCallCop_2()">
					</td>
			</tr>
			</table>
		</form>
		<form name="form3" >
			<table>
			<tr>
			        <td>
			            Call RTR Batch : 
			        </td>
					<td>
						<input name="so_mapg_sts_cd" type="text" size="02" value = "00"> 
					</td>
					<td>
						<input type="button" class="form" name="process1" value="process" onclick="javascript:onCallCop_3()">
					</td>
			</tr>
			</table>
		</form>
	</body>
</html>