<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : ees_cgm_1008.jsp
	 *@FileTitle : Chassis On-Hire Creation
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.06.26
	 *@LastModifier : 박의수
	 *@LastVersion : 1.0
	 * 2009.06.26 박의수
	 * 1.0 Creation
	 =========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event.EesCgm1008Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EesCgm1008Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String form_day         = "";
	String form_hs          = "";
	Logger log = Logger.getLogger("com.hanjin.apps.ChassisMgsetMgt.ChassisMgsetOnOffhire");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		
		form_day  = DateTime.getDateString().replace(".","-");  
		form_hs   = DateTime.getShortTimeString();
		form_hs   = form_hs.substring(0,2) + ":" + form_hs.substring(2,4);

		event = (EesCgm1008Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Chassis On-Hire Creation</title>
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

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="cre_id" value="<%=strUsr_id %>">
<input type="hidden" name="form_day" value="<%=form_day %>">
<!-- 개발자 작업	-->

<input type="hidden" class="input2" style="width:40;text-align:center"  name="eq_knd_cd" value="Z">
<input type="hidden" class="input2" style="width:80;text-align:center"  name="vndr_seq">
<input type="hidden" class="input2" style="width:80;text-align:center"  name="agmt_no">
<input type="hidden" class="input2" style="width:80;text-align:center"  name="eq_no">
<input type="hidden" class="input2" style="width:80;text-align:center"  name="chss_veh_id_no_tmp">
<input type="hidden" class="input2" style="width:80;text-align:center"  name="chss_tit_no_tmp">
<input type="hidden" class="input2" style="width:80;text-align:center"  name="chss_als_no_tmp">
<input type="hidden" class="input2" style="width:80;text-align:center"  name="n2nd_chss_als_no_tmp">
<input type="hidden" class="input2" style="width:50;text-align:center"  name="own_lse" value="O">
<input type="hidden" name="ofc_cd">
<input type="hidden" name="yd_cd">
<input type="hidden" name="agmt_ver_no">
<input type="hidden" name="loc_cd">
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top: 2; padding-left: 5;">
	<tr>
		<td valign="top">
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->
		<table class="search" id="mainTable">
			<tr>
				<td class="bg">
				<table class="search" border="0" style="width:979;">
					<tr class="h23">
						<td width="170">
						<table class="search_sm2" border="0" style="width:150;">
							<tr class="h23">
								<td width="">
									<input type="radio" class="trans" name="ownleas" onclick="chk('O')" value="O"checked>&nbsp;OWN&nbsp;&nbsp;
									<input type="radio" class="trans" name="ownleas" onclick="chk('L')"value="L">&nbsp;Leased
								</td>
							</tr>
						</table>
						</td>
						<td width="40">Office</td>
						<td width="100">
							<input type="text" style="width:55;ime-mode:disabled" class="input1" dataformat="enghi" maxlength="6" name="onh_ofc_cd">
							<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" id="btn_popup" name="ComOpenPopupWithTargetOffice">
						</td>
						<td width="90">On-hire Date</td>
						<td width="182">
							<input type="text" style="width:80;ime-mode:disabled" class="input1" name="onh_dt" dataformat="ymd" maxlength="8">
							<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_Calendar_a">
							<input type="text" style="width:47;text-align:center;ime-mode:disabled" class="input1" name="onh_dt_hm" dataformat="hm" maxlength="4" value="00:00">
						</td>
						<td width="80">On-hire Yard</td>
						<td width="">
							<input type="text" style="width:70;ime-mode:disabled" class="input1" dataformat="engup" maxlength="7" name="onh_yd_cd">
							<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" id="btn_popup" name="ComOpenPopupWithTargetYard">
						</td>
					</tr>
				</table>
				<table class="search" border="0" style="width:979;">
					<tr class="h23">
						<td width="100">Agreement No.</td>
						<td width="210">
							<input type="text" style="width:80;ime-mode:disabled" class="input1" dataformat="engup" maxlength="10" name="agreement_no" maxlength="9">
							<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" id="btn_popup" name="ComOpenPopupWithTargetAgree">
						</td>
						<td width="90">Reference No.</td>
						<td width="182">
							<input type="text" style="width:154;" class="input2" readonly name="agmt_ref_no">
						</td>
						<td width="80">Lease Term</td>
						<td width="">
							<input type="text" style="width:40;" class="input2" readonly name="agmt_lstm_cd">
						</td>
					</tr>
					<tr class="h23">
						<td width="">Lessor</td>
						<td width="" colspan="5">
							<input type="text" style="width:454;" class="input2" readonly name="vndr_lgl_eng_nm">
						</td>
					</tr>
				</table>
				<table class="line_bluedot" border="0">
					<tr>
						<td colspan="6"></td>
					</tr>
				</table>
					<!-- Grid  (S) -->
						<table width="100%" id="mainTable">
							<tr>
								<td width="100%"><script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table>
					<!-- Grid (E) -->
				<!--  Button_Sub (S) -->
				<table width="100%" class="button">
					<tr>
						<td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btn_rowadd">Row&nbsp;Add</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btn_delete">Row Delete</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btn_excel">Load Excel</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td>
										<td class="btn2" name="btn_downexcel">Down Excel</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				<!-- Button_Sub (E) -->
				</td>
			</tr>
		</table>
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;, padding-bottom:0;">
			<tr>
				<td class="btn1_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
						<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_new">New</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td class="btn1_line"></td>
						<td>
						<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_verify">Verify</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_confirm">On-Hire Confirm</td>
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

<!-- 개발자 작업  끝 -->

</form>
</body>
</html>
