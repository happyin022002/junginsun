<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0751.jsp
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.event.EsmBkg0750Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	String sVvd = (request.getParameter("vvd")==null) ? "" : request.getParameter("vvd");
	String sBound = (request.getParameter("bound")==null) ? "" : request.getParameter("bound");
	String sTypeRail = (request.getParameter("type_rail")==null) ? "" : request.getParameter("type_rail");
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
<title>US WharFage Ration Setup (LGB)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		loadPage();
	}
</script>
</head>
<body  onLoad="setupPage();">
<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<%@include file="/apps/alps/esm/bkg/bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp" %> 

<table width="480" class="search" id="mainTable">
    			<tr>
    				<td class="bg">
			<table class="search" border="0" style="width:480;">
				<tr class="h23">
					<td width="55">Port</td>
					<td width=""><input type="text" style="width:100;" class="input2" value="USLGB" ReadOnly name="port"></td>
					<td width="45">Bound</td>
					<td width="">
						<select style="width:80;" class="input1" name="bound">
						<option value="I" <%if("I".equals(sBound)) out.println("selected");%>>IMPORT</option>
						<option value="O" <%if("O".equals(sBound)) out.println("selected");%>>EXPORT</option>
						</select></td>
				</tr>
			</table>
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			<table width="480"  id="mainTable">
				<tr>
					<td align="right">[UNIT : $]</td>
				</tr>
				<tr><td width="100%">
					<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<!--Button (S) -->
<table width="100%" class="button" border="0" cellpadding="0" cellspacing="1" style="padding-top:5;,padding-bottom:0;">
	<tr>
		<td class="btn1_bg">
			<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td class="btn1_line"></td>
			    	<td>
						<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Save">Save</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
		</td>
	</tr>
</table>

<%@include file="/apps/alps/esm/bkg/bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_BOTTOM.jsp" %> 

</form>
</body>
</html>