<%
/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : COM_SEC_0004.jsp
*@FileTitle : ALPS Role Authority Approval Monitoring
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.17 
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.syscommon.management.alps.role.event.ComSec0004Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	ComSec0004Event event = null;
	Exception serverException = null;    // 서버에서 발생한 에러
	String strErrMsg = "";               // 에러메세지
	int rowCount = 0;                    // DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String strUsr_Auth		= "";
	String strSubSysCd		= "";
	String strSpSubSysCd    = "";
	Logger log = Logger.getLogger("com.hanjin.syscommon.management.alps.Role");

	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_Auth = account.getUsr_auth_tp_cd();
		event = (ComSec0004Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		strSubSysCd = eventResponse.getETCData("sub_sys_cd");
		strSpSubSysCd = eventResponse.getETCData("sp_sub_sys_cd");

	} catch(Exception e) {
		out.println(e.toString());
	}

	String dateTo = JSPUtil.getKST("yyyy-MM-dd");
	String dateFm = DateTime.addDays(dateTo, -10, "yyyy-MM-dd");
	String rqst_ofc_cd = "";
	String rqst_usr_id = "";
	String usr_role_cd = "";
	String apsts_cd = "";

%>
<html>
<head>
<title>ALPS Role Authority Approval Monitoring</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	var subSysCd = "<%=strSubSysCd%>";
	var spSubSysCd = "<%=strSpSubSysCd%>";
	var strUsr_Auth = "<%=strUsr_Auth%>";
	function setupPage(){
	var errMessage = "<%=strErrMsg%>";
	if (errMessage.length >= 1) {
		ComShowMessage(errMessage);
	} // end if
		loadPage();
	}
</script>
</head>

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업 -->


<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding:2px 0px 0px 5px;">
	<tr>
		<td valign="top">


			<!-- Page Title, Historical (S) -->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
			<!-- Page Title, Historical (E) -->


		<!-- biz page (S) -->
		<table class="search" id="mainTable">
       		<tr><td class="bg">

				<!--  biz_1  (S) -->
				<table width="100%" class="search" border="0">
				<tr class="h23">
					<td>Office Code</td>
					<td><input name="rqst_ofc_cd" type="text" style="ime-mode:disabled; width:100;" class="input" dataformat="engup" maxlength="7" onKeyPress="javascript:ComKeyOnlyAlphabet('uppernum');">&nbsp;<img class="cursor" src="img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_ofc_popup"></td>
					
					<%
					if( strUsr_Auth == null || strUsr_Auth.equals("E") || strUsr_Auth.equals("R") )
					{
					%>
					<td>User ID</td>
					<td><input name="rqst_usr_id" type="text" style="width:100;" class="input2" value="<%=strUsr_id%>" readonly></td>
					<%
					}else {
					%>
					<td>User ID</td>
					<td><input name="rqst_usr_id" type="text" style="width:100;" class="input" value="<%=rqst_usr_id%>"></td>
					<%
					}
					%>
					<td>Date</td>
					<td>
						<input type="text" name="date_fm" dataformat="ymd" style="width:80;text-align:center;" value="<%=dateFm%>" maxlength="8" size="10">&nbsp;~&nbsp;
						<input type="text" name="date_to" dataformat="ymd" style="width:80;text-align:center;" value="<%=dateTo%>" maxlength="8" size="10">&nbsp;
						<img class="cursor" name="btn_calendar" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">		
					</td>
				</tr>
				<tr class="h23">
					<td>Module</td>
					<td>
						<script language="javascript">ComComboObject('subSys', 1, 120, 1);</script>
					</td>
					<td>Role</td>
					<td><input name="usr_role_cd" value="<%=usr_role_cd%>" type="text" style="ime-mode:disabled; width:100;" class="input" dataformat="engup" maxlength="5" onKeyPress="javascript:ComKeyOnlyAlphabet('uppernum');" value="<%=usr_role_cd%>">&nbsp;<img class="cursor" src="img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_role_popup"></td>
					<td>Status</td>
					<td><select name="apsts_cd" style="width:100;" class="input1" value="<%=apsts_cd%>">
						<option value="" selected>All</option>
						<option value="P">Requested</option>
						<option value="C">Approved</option>
						<option value="R">Rejected</option>
						</select>
					</td>
				</tr>
				</table>
				<!--  biz_1   (E) -->

				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>

				<!-- Grid (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- Grid (E) -->
		</td></tr></table>
		<!-- biz page (E) -->


			<!-- Button (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding:5px 0px 10px 0px;">
				<tr>
					<td class="btn1_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>							
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left">
											<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
											<td class="btn1_right">
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_new">New</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1"  name="btn_DownExcel">Excel Down</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<!-- Button (E) -->


		</td>
	</tr>
</table>


<!-- 개발자 작업 끝 -->
</form>
</body>
</html>