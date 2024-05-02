<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1041.jsp
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.31
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2009.04.24 김민정
* 1.0 Creation
=========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.event.EsmBkg1041Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	String sVvd = (request.getParameter("vvd")==null) ? "" : request.getParameter("vvd");
	String sBound = (request.getParameter("bound")==null) ? "" : request.getParameter("bound");
	String sCrrCd = (request.getParameter("crr_cd")==null) ? "" : request.getParameter("crr_cd");
	// Inbound / Outbound 메뉴가 다르기 때문
	String sPgmNo = (request.getParameter("pgmNo")==null) ? "" : request.getParameter("pgmNo");
	if ("".equals(sBound)) {
		if (sPgmNo.length() == 12) {
			sBound = "I";
		} else {
			sBound = "O";
		}
	}
%>
<html>
<head>
<title>US Wharfage Setup (OAK)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		<%if (!"".equals(sVvd)) { %>
			loadPage(true);
		<% } else { %>
			loadPage(false);
		<% } %>
	}
</script>
</head>
<body  onLoad="setupPage();">
<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<%@include file="/apps/alps/esm/bkg/bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp" %> 

<!--biz page (S)-->
<table class="search"> 
	<tr>
		<td class="bg">
			<!--  biz_1  (S) -->
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="30">VVD</td>
					<td width="190">
						<input type="text" style="width:100;ime-mode:disabled" class="input1" required
							name="vvd" caption="VVD" maxlength="9" dataformat="eng" minlength="9" value="<%=sVvd%>"></td>
					<td width="50">Operator</td>
					<td width="130"><input type="text" style="width:50;" class="input2" ReadOnly name="crr_cd" value="<%=sCrrCd%>"></td>
					<td width="33">Port</td>
					<td width="150">
						<input type="text" style="width:100;" class="input2" name="port" value="USOAK" readOnly></td>
					<td width="43">Bound</td>
					<td width="">
						<select style="width:100;" class="input1" name="bound">
						<option value="I" <%if("I".equals(sBound)) out.println("selected");%>>IMPORT</option>
						<option value="O" <%if("O".equals(sBound)) out.println("selected");%>>EXPORT</option>
						</select></td>
				</tr>
			</table>
			<!--  biz_1   (E) -->
			<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>	
			<!-- Grid  (S) -->
			<table width="100%"  id="mainTable">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table>
<div style="display:none">
<script language="javascript">ComSheetObject('sheet2');</script>
</div>
			<table width="100%" class="button">
				<tr>
					<td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_RowAdd">Row&nbsp;Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_RowDelete">Row&nbsp;Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						</tr></table>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>

<!--Button (S) -->
<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;">
	<tr>
		<td class="btn1_bg">
    		<table border="0" cellpadding="0" cellspacing="0">
    			<tr>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
							<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td class="btn1_line"></td>
					<td>
						<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_Save">Save</td>
							<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_WHFSend">WHF Send</td>
							<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_excel">Down Excel</td>
							<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<!--Button (E) -->
		</td>
	</tr>
</table>

<%@include file="/apps/alps/esm/bkg/bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_BOTTOM.jsp" %>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>