<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TES_9210.jsp
*@FileTitle : Terminal Invoice Holding Remark
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.07.20 yOng hO lEE
* 1.0 Creation
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%
	String param_name = null;
	java.util.Enumeration enums = request.getParameterNames();
	while (enums.hasMoreElements()){
		param_name = (String)enums.nextElement();
	}

	String hld_rmk_inp_nm = request.getParameter("hld_rmk_inp_nm")!=null&&!request.getParameter("hld_rmk_inp_nm").equals("")?request.getParameter("hld_rmk_inp_nm"):"";
	String isZZ = request.getParameter("isZZ")!=null&&!request.getParameter("isZZ").equals("")?request.getParameter("isZZ"):"";
%>
<html>
<head>
<title>Welcome to ALPS!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	var hld_rmk_inp_nm = "<%=hld_rmk_inp_nm%>";
	var isZZ  = "<%=isZZ%>";
	function setupPage(){
		loadPage();
	}
</script>
</head>

<body onload="setupPage();">
<form method="post" name="form" onSubmit="return false;">
<!-- OUTER - POPUP (S)tart -->
<table width="300" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;Invoice Holding Remark</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		<!-- TABLE '#D' : ( Search Options : Speed ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<table class="search" border="0" style="width:262;">
					<tr class="h23">
						<td width="20%">Remark</td>
						<td>
							<%if(isZZ==null || isZZ.trim().equals("")){ %>
							<input type="text" name='hld_rmk' value='' maxlength=1000 style="width:200" onKeyDown='tes_chkInput(this);' onBlur='tes_chkInput(this);'></td></tr>
							<%} else{ %>
							<input type="text" name='hld_rmk' value='' maxlength=1000 style="width:200" readonly></td></tr>
							<%} %>
				</table>

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options : Speed ) (E) -->

</td></tr>
</table>
<!-- OUTER - POPUP (E)nd -->



<table class="height_10"><tr><td></td></tr></table>


<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton">
		<tr><td height="71" class="popup">

			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
	       		<tr><td class="btn3_bg">
			    <table border="0" cellpadding="0" cellspacing="0">
			    <tr>

					<!-- Repeat Pattern -->
					<% if (isZZ==null || isZZ.trim().equals("")){ %>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_save" id="btn_save">Save</td><td class="btn1_right"></td></tr></table></td>
					<% }%>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
					<!-- Repeat Pattern -->

				</tr>
			</table>

		</td></tr>
</table>
<!-- : ( Button : Sub ) (E) -->

</form>

</body>
</html>