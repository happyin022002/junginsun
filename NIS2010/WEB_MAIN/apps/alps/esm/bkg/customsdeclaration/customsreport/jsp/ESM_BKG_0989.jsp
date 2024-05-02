<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	String msgLocTpId = request.getParameter("msg_loc_tp_id");
	String snd_dt     = request.getParameter("snd_dt");
	String ofc_cd     = request.getParameter("ofc_cd");
	String mf_snd_seq     = request.getParameter("mf_snd_seq");
	
	if (msgLocTpId==null) msgLocTpId = "";
	if (snd_dt==null) snd_dt = "";
	if (ofc_cd==null) ofc_cd = "";
	if (mf_snd_seq==null) mf_snd_seq = "";
%>
<html>
<head>
<title>Welcome to Alps!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
    function setupPage()
    {  
	    loadPage();
    }
</script>
</head>
<body class="popup_bg" onLoad="setupPage();"> 

<form name="form"> 
<input type="hidden" name="p_search_option" value="">
<input type="hidden" name="f_cmd" value="">
<input type="hidden" name="msg_log_tp_id" value="<%=msgLocTpId%>">
<input type="hidden" name="snd_dt" value="<%=snd_dt%>">
<input type="hidden" name="ofc_cd" value="<%=ofc_cd%>">
<input type="hidden" name="mf_snd_seq" value="<%=mf_snd_seq%>">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="notitle">&nbsp;Transmission History to Korea Customs Send File</span></td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
			<table class="search"> 
       		<tr><td class="bg">
				<table class="grid2" border="0" style="width:100%;"> 
				<tr>
					<td width="" class="tr2_head" align="center">Send  File</td></tr>
				<tr class="h23">
					<td><textarea style="width:100%;" rows="25" name="msgTxt">Ready...</textarea><script language="javascript">ComSheetObject('sheet1');</script></td></tr>
			</table>
		    <!-- : ( Button : Grid ) (E) -->	
			
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->

<table class="height_5"><tr><td></td></tr></table>
</td></tr>
</table> 
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
					<td class="btn1_right"></td>
				</tr></table></td>
			</tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table></td></tr></table>
<!-- : ( Button : pop ) (E) -->
</form>			
</body>
</html>