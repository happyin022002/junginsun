<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0095.jsp
*@FileTitle : Import Modelship
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.22
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2013.01.22 진마리아
* 1.0 Creation
* 2013.01.22 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
* 2014.01.03 진마리아 [SRM-201341166] Yield Group의 확대
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.event.EsmSpc0095Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%

	EsmSpc0095Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	String trade = null;
	String costYrwk = null;
	String verSeq = null;
	String onlyRead = null;
	String popYn = null;
	
	Logger log = Logger.getLogger("com.hanjin.apps.modelmanage.modelmanage");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		
		trade = JSPUtil.getParameter(request, "trade", "");
		costYrwk = JSPUtil.getParameter(request, "cost_yrwk", "");
		verSeq = JSPUtil.getParameter(request, "ver_seq", "");
		onlyRead = JSPUtil.getParameter(request, "only_read", "");
		popYn = JSPUtil.getParameter(request, "pop_yn", "");
		
		trade = trade==null?"":trade;
		popYn = popYn==""?"N":popYn;

		event = (EsmSpc0095Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

	}catch(Exception e) {
		out.println(e.toString());
	}
	
	String ofc_cd	 = event.getSignOnUserAccount().getOfc_cd();
	String ofc_tp_cd = "";
%>

<html>
<head>
<title>Import Modelship</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="pop_yn" value="<%=popYn%>">
<input type="hidden" name="only_read" value="<%=onlyRead%>">
<!-- 개발자 작업	-->
<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>

		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
     <%if("Y".equals(popYn)){ %>
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Import Target ACCT(SMP)</td></tr>
		</table>
	<%}else{%>
     	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
	<%}%>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->

		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
			<tr><td class="btn1_bg">
					<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td><td class="btn1" name="btn_add" id="btn_add">Acct. Add</td><td class="btn1_right"></td></tr></table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td><td class="btn1" name="btn_save" id="btn_save">Save</td><td class="btn1_right"></td></tr></table></td>

						<td class="btn1_line"></td>

						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td><td class="btn1" name="btn_upload" id="btn_upload">Upload</td><td class="btn1_right"></td></tr></table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td><td class="btn1" name="btn_template_down" id="btn_template_down">Template Down</td><td class="btn1_right"></td></tr></table></td>
<%if("Y".equals(popYn)){ %>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
<%}%>
					</tr></table>

			</td></tr>
		</table>

    	<!-- TABLE '#D' : ( Button : Main ) (E) -->
	 	<!-- TABLE '#D' : ( Search Options ) (S) -->

		<table width="100%" class="search" id="searchCondition">
			<tr><td class="bg">
				<table class="search" border="0">
					<tr class="h23">
						<td width="70"><img class="nostar">Trade</td>
	<%if("Y".equals(popYn)){ %>
						<td width="130"><input type="text" name="trade" class="input2" style="width:80;text-align:center" value="<%=trade%>" readonly="readonly"></td>
						<td width="70"><img class="nostar">Season</td>
						<td width="140"><input type="text" name="cost_yrwk" class="input2" style="width:80;text-align:center" value="<%=costYrwk%>" readonly="readonly"></td>
						<td width="70"><img class="nostar">Version</td>
						<td width="100"><input type="text" name="ver_seq" class="input2" style="width:80;text-align:center" value="<%=verSeq%>" readonly="readonly"></td>
	<%}else{%>
						<td width="130" style="padding-left:2" >
							<script language="JavaScript">ComComboObject("trade", 2, 105, 1, 1);</script>
						</td>
						<td width="380"></td>
	<%}%>
						<td width="" align="center" >
							<table cellpadding="0" cellspacing="0">
								<tr><td width="130"><div align="left"><b><label for="" id="ctrl_cd_desc"></label></b></div></td></tr>
							</table>
						</td>
					</tr>
				</table>
			</td></tr>
		</table>

		<table class="height_10"><tr><td></td></tr></table>
		
		<!-- TABLE '#D' : ( Tab ) (S) -->
     	<table class="search">
       	<tr><td class="bg">
				<!-- <table class="height_5"><tr><td></td></tr></table> -->
					<table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet1');</script>
                        </td></tr>
		            </table>
					<table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet2');</script>
                        </td></tr>
		            </table>
			</td></tr>
		</table>

</td></tr>
</table>
<!-- Outer Table (E)-->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
<%@include file="/bizcommon/include/common_alps.jsp"%>