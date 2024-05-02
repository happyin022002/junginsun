<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
        String filepath=request.getParameter("filepath");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FileViewer</title>
</head>
<body>
<script language="javascript" type="text/javascript" src="easyAjax.js"></script>
<script language="javascript" type="text/javascript" src="easyDOM.js"></script>
<script language="javascript" type="text/javascript" src="easyTools.js"></script>
<script language="javascript" type="text/javascript" src="logfileview.js"></script>

<script language="javascript">
window.onload = function(){
	readNextFile();
}
</script>

<form name="form1" method="post">	
<input type="hidden" name="readpos" value="0"/> 
<input type="hidden" name="lastflag" />
<input type="hidden" name="readbyte" value="20000"/> 
<input type="hidden" name="filepath" value="<%=filepath %>"/>
<input type="hidden" name="command" value="last"/>

<font color="blue"><b> FileName : <%=filepath %></b></font>
<div style="width:960px;height:390px;overflow-y:scroll;word-wrap:break-word;word-break:break-all;">
	<table width="950px" border="0" cellspacing="0" cellpadding="0" style="border:1px solid #dddddd; border-right:1px solid #E0E0E0;">
		<tr>
			<td id="cnts" style="word-wrap:break-word;word-break:break-all;"></td>
		</tr>	
	</table>
	<table id="temp">
	</table>
</div>
<font color="blue"><b>
Download : Last <input type="text" size=20 value="20000" name="dnldsize" /> bytes
</b></font>	
<input type="button" value="Next" name="next" onClick="readNextFile();" /> &nbsp;
<input type="button" value="Last" name="next" onClick="readLastFile();" /> &nbsp;
<input type="button" value="Clear Contents" name="clear" onClick="clearContents();" /> &nbsp;
<input type="button" value="DownLoad" name="download" onClick="downloadFile();" />
</form>
<iframe name="dnld" style="display:none;width:1px;height:1px;"></iframe>
</body>
</html>