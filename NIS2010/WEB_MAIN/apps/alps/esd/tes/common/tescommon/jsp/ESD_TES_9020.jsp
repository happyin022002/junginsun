<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TES_9020.jsp
*@FileTitle : Terminal Invoice Reject Reason
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

	String rjct_sts_inp_nm = request.getParameter("rjct_sts_inp_nm")!=null&&!request.getParameter("rjct_sts_inp_nm").equals("")?request.getParameter("rjct_sts_inp_nm"):"";
	String rjct_fn_nm	= request.getParameter("rjct_fn_nm")!=null&&!request.getParameter("rjct_fn_nm").equals("")?request.getParameter("rjct_fn_nm"):"";
%>
<html>
<head>
<title>Welcome to alps!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
var rjct_sts_inp_nm = "<%=rjct_sts_inp_nm%>";
var rjct_fn_nm = "<%=rjct_fn_nm%>";
</script>
</head> 

<body>
<form name="form">

<!-- OUTER - POPUP (S)tart -->
<table width="300" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;Reject Reason</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		<!-- TABLE '#D' : ( Search Options : Speed ) (S) -->
     	<table class="search">
       	<tr><td class="bg">
				<table class="search" border="0" style="width:262;">
					<tr class="h23">
						<td width="20%">Reason</td>
						<td>
							<select name="inv_rjct_rmk" style="width:200;">
								<option value="AD" selected>Amount Discrepancy</option>
								<option value="VD">VVD Discrepancy</option>
								<option value="CD">CNTR No. Discrepancy</option>
								<option value="PD">Period Discrepancy</option>
								<option value="DB">Double Billing</option>
								<option value="3P">3rd Party CNTR</option>
							</select>
						</td>
					</tr>
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
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_save" id="btn_save">Save</td><td class="btn1_right"></td></tr></table></td>
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