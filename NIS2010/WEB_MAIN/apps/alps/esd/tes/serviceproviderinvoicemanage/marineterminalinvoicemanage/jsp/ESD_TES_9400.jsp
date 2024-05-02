<%--
/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESD_TES_9400.jsp
*@FileTitle : Get Container List Pop Up
*Open Issues :
*Change history :
*@LastModifyDate : 2011-08-10
*@LastModifier : 박정일
*@LastVersion : 1.0
* 2006-10-18 박정일
* 1.0 최초 생성
* 2011.08.10 박정일 [CHM-201112119-1] [TES] MR Invoice 입력시 FIO 조건 CNTR verification 결과 보완 요청 
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%
	String tml_so_ofc_cty_cd	= request.getParameter("tml_so_ofc_cty_cd")!=null&&!request.getParameter("tml_so_ofc_cty_cd").equals("")?request.getParameter("tml_so_ofc_cty_cd"):"";
	String tml_so_seq			= request.getParameter("tml_so_seq")!=null&&!request.getParameter("tml_so_seq").equals("")?request.getParameter("tml_so_seq"):"";
	String vvd			= request.getParameter("vvd")!=null&&!request.getParameter("vvd").equals("")?request.getParameter("vvd"):"";
    String io_bnd_cd	= request.getParameter("io_bnd_cd")!=null&&!request.getParameter("io_bnd_cd").equals("")?request.getParameter("io_bnd_cd"):"";
	
%>
<html>
<head>
<title>Welcome to ALPS!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	var tml_so_ofc_cty_cd = '<%=tml_so_ofc_cty_cd%>'
	var tml_so_seq = '<%=tml_so_seq%>'
	var vvd = '<%=vvd%>'
	var io_bnd_cd = '<%=io_bnd_cd%>'

    function setupPage(){
		loadPage();
	}
</script>
</head>

<body onload="javascript:setupPage();">

<form name="form">
<input name='f_cmd' type='hidden'>
<input type="hidden" name="tml_so_ofc_cty_cd" value="<%=tml_so_ofc_cty_cd%>">
<input type="hidden" name="tml_so_seq" value="<%=tml_so_seq%>">
<input type="hidden" name="vvd" value="<%=vvd%>">
<input type="hidden" name="io_bnd_cd" value="<%=io_bnd_cd%>">

<!-- OUTER - POPUP (S)tart -->
<table width="250" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
	<tr><td valign="top">

			<!-- : ( Title ) (S) -->
			<table width="100%" border="0">
			<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle"> INFORMATION</td></tr>
			 
			</table>
			<!-- : ( Title ) (E) -->

			<!-- TABLE '#D' : ( Button : Main ) (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
					<tr><td class="btn1_bg">
				 
					</td></tr>
					</table>
						 The verified list includes FI/FO terms.
						 Please review whether it must be paid or rejected. <BR>  <BR> 
						 
						 <div style="display:none">
			<table class="search">
			<tr><td class="bg">
				 
				</td></tr>
			</table>
		</div>
	</td></tr>
</table>

<table class="height_10"><tr><td></td></tr></table>


<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton">
	<tr><td height="100" class="popup">
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;">
			<tr><td class="btn3_bg">
			<table border="0" cellpadding="0" cellspacing="0">
			<tr>
				<!-- Repeat Pattern -->
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_pay" id="btn_pay">Pay</td><td class="btn1_right"></td></tr></table></td>
				<!-- Repeat Pattern -->
				<!-- Repeat Pattern -->
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_discrepancy" id="btn_discrepancy">Reject</td><td class="btn1_right"></td></tr></table></td>
				<!-- Repeat Pattern -->
			</tr>
		</table>
	</td></tr>
</table>
</form>


</body>
</html>

<div style="display:none">
<table width="100%" id="mainTable">
	<script language="javascript">ComSheetObject('sheet');</script>
</table>
</div>
