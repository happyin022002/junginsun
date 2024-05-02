<%
/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EES_CGM_2026.jsp
 *@FileTitle : Lease Term Change
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2013.07.09
 *@LastModifier : 조경완
 *@LastVersion : 1.0
 *
 * 2009.06.22 김창식
 *     1.0 Creation
 *
 * 2010.08.06 김상수
 *    [CHM-201004960-01] Genset Ineventory Logic error 수정건
 *         : [EES_CGM_2026] 화면 권한(usr_role_cd)에 CGM01외에 CGM02의 Permission 추가 by 김상수
 * 2013.07.09 조경완 [CHM-201325340-01] Role Hard Coding 제거 및 대체 기능 개발
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.event.EesCgm2026Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.syscommon.common.util.UserRoleUtil" %>
<%@ page import="com.hanjin.syscommon.common.table.ComUsrRoleVO" %>

<%
	EesCgm2026Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String ofc_cd  			= "";
	String form_day			= "";
	String tRole = "Authenticated";

	Logger log = Logger.getLogger("com.hanjin.apps.ChassisMgsetAgreementInvoice.ChassisMgsetAgreement");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		ofc_cd = account.getOfc_cd();
		form_day  = DateTime.getDateString().replace(".","");

		event = (EesCgm2026Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Lease Term Change</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if

		document.form.ofc_cd.value = "<%=ofc_cd%>";
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->

<input type="hidden" name ="eq_knd_cd">
<input type="hidden" name="ofc_cd">

<input type="hidden" name="agmt_no">

<input type="hidden" name="old_agmt_ofc_cty_cd">
<input type="hidden" name="old_agmt_seq">
<input type="hidden" name="old_agmt_ver_no">

<input type="hidden" name="new_agmt_ofc_cty_cd">
<input type="hidden" name="new_agmt_seq">
<input type="hidden" name="new_agmt_ver_no">

<input type="hidden" name="eq_no">
<input type="hidden" name="form_day" value="<%=form_day %>">
<input type="hidden" name="trole" value="<%=tRole%>">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">

	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->

	<!--biz page (S)-->
		<table class="search">
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="100">Activity Date</td>
					<td width="180">&nbsp;<input type="text" name="sts_evnt_dt" dataformat="ymd" maxlength="8" style="width:80;ime-mode:disabled;text-align:center" class="input1" value="">&nbsp;<img name="btns_Calendar_activityDt" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="50">Office</td>
					<td><input type="text" style="width:87;text-align:center" name="sts_evnt_ofc_cd" dataformat="engup" maxlength="6" style="ime-mode:disabled" class="input1" value="">&nbsp;<img name="btns_office" class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
				</tr>
				</table>
				<!--  biz_1  (E) -->
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>

				<!--  biz_2  (S)  -->
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Current Status by Agreement</td></tr>
				</table>

				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="100">Agreement No.</td>
					<td width="180">&nbsp;<input type="text" name="old_agmt_no" dataformat="engup" maxlength="9" style="width:80;ime-mode:disabled" class="input" value="">&nbsp;<img name="btns_agmtno" class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="50">Ref. No.</td>
					<td><input type="text" name="old_agmt_ref_no" maxlength="15" readonly style="width:110;ime-mode:disabled" class="input2" value=""></td>
				</tr>
				<tr class="h23">
					<td width="100">Lease Term</td>
					<td width="180">&nbsp;<input type="text" name="old_agmt_lstm_cd" readonly style="width:35;ime-mode:disabled;text-align:center" class="input2" value=""></td>
					<td width="50">Lessor</td>
					<td><input type="text" name="old_vndr_seq" readonly style="width:110;" class="input2" value="">&nbsp;<input type="text" name="old_vndr_lgl_eng_nm" readonly style="width:280;" readonly class="input2" value=""></td>
				</tr>
				</table>

				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>

				<!--  biz_2  (S)  -->
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Current Status by M.G.Set</td></tr>
				</table>

				<!-- Grid  (S) -->
			<table width="100%"  id="mainTable">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table>
			<!-- Grid (E) -->
			<!--  Button_Sub (S) -->
			<table width="100%" class="button">
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
                        <tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_rowadd">Row Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_rowdelete">Row Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2" name="btn_Loadexcel">Load&nbsp;Excel</td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_downexcel">Down&nbsp;Excel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
				<!--  biz_2  (E)  -->

			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				<!--  biz_3  (S)  -->
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">After Status</td></tr>
				</table>
				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="100">Agreement No.</td>
					<td width="180"><input type="text" name="new_agmt_no" dataformat="engup" maxlength="9" style="width:80;ime-mode:disabled" class="input1" value="">&nbsp;<img name="btns_new_agmtno" class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="50">Ref. No.</td>
					<td><input type="text" name="new_agmt_ref_no" readonly style="width:110;" class="input2" value=""></td>
				</tr>
				<tr class="h23">
					<td width="100">Lease Term</td>
					<td width="180"><input type="text" name="new_agmt_lstm_cd" readonly style="width:35;" class="input2" value=""></td>
					<td width="50">Lessor</td>
					<td><input type="text" name="new_vndr_seq" readonly style="width:110;" class="input2" value="">&nbsp;<input type="text" name="new_vndr_lgl_eng_nm" readonly style="width:280;" class="input2" value=""></td>
				</tr>
				</table>
				<!--  biz_3  (E)  -->
			</td></tr>
		</table>


		</td></tr>
		</table>


	<!--biz page (E)-->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New" id="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save" id="btn_Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->

<!-- hidden 처리 (S)-->
<div style="display:none">
<script language="javascript">ComSheetObject('sheet2');</script>
</div>
<!-- hidden 처리 (E)-->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>