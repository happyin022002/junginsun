<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0164.jsp
*@FileTitle : Disposal Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.28
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2009.09.28  함형석
* 1.0 Creation
* --------------------------------------------------------
* History
* 2011.08.30 나상보 [CHM-201113102] ALPS MNR-Disposal-Disposal Inquiry화면에 조회 Status 추가 개발 요청
* --------------------------------------------------------
* 2011.10.17 허철용 [CHM-201113979-01] 조회조건 입력필드중 Disposal No, Invoice No, EQ No 입력필드 Length 조정
* 2012.01.04 신혜정 [CHM-201217048] not pick up 된 장비 List 조회 팝업 추가
*                                   - [Not Pick-up CNTR] 버튼 추가
*                                   - 멀티 선택에 대한 not pick up 장비 list 팝업 조회
* 2012.06.04 신혜정 [CHM-201218271-01] 조회조건에 Regional HQ, Office 항목 추가
* 2012.08.31 김창헌 [CHM-201219415-01] Disposal Request가 Reject된 List 현황 관리
* 									- Delete(Reject) 버튼 및 관련 기능 추가
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.event.EesMnr0164Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0164Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	String strRhq_ofc_cd 	= "";
	String strOfc_org_cd 	= "";

	Logger log = Logger.getLogger("com.hanjin.apps.OperationManage.DisposalMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	    strOfc_cd = account.getOfc_cd();
	    strRhq_ofc_cd = account.getRhq_ofc_cd();
	    strOfc_org_cd = account.getOfc_org_cd();

		event = (EesMnr0164Event)request.getAttribute("Event");
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
<title><span id="title"></span></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!--MNR 공용 사용  -->
<script language="javascript">
var currOfcCd = '<%=strOfc_cd %>';
var rhqOfcCd  = '<%=strRhq_ofc_cd %>';

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<script language="javascript">ComSheetObject('sheet1');</script>
<script language="javascript">ComUploadObject('upload1', '<=session.getId()%>');</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- App Office를 구하기 위한 -->
<input type="hidden" name="rhq_cd" value="<%=strRhq_ofc_cd%>">
<input type="hidden" name="mnr_grp_tp_cd" value="DSP">
<input type="hidden" name="file_seq" value="">
<input type="hidden" name="disp_eml_flg" value="N">
<input type="hidden" name="disp_search_type" value="">
<input type="hidden" name="self_ofc_cd" value="<%=strOfc_cd%>">
<input type="hidden" name="rqst_ofc_cd" value="">
<input type="hidden" name="rqst_usr_id" value="">
<input type="hidden" name="in_disp_tp_cd" value="ALL">


<!-- 개발자 작업	-->
<!-- OUTER - POPUP (S)tart -->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		    <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->


		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;">
       	<tr><td class="btn1_bg">

		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td></tr>
			</table>
		</td></tr>
		</table>
    	<!--Button (E) -->

	<!--biz page (S)-->
		<table class="search" id="mainTable">
       		<tr><td class="bg">

				<!--  biz_1  (S) -->
				<table class="search_" border="0" style="width:979;">
							<tr class="h23">
								<td width="50">Date</td>
								<td width="315"><script language="javascript">ComComboObject('input_date_type_code', 1, 100, 1, 1,0,false,0);</script>&nbsp;
									<input name="in_apro_st_dt" type="text" style="width:75" dataformat="ymd" cofield="in_apro_end_dt">&nbsp;~&nbsp;
									<input name="in_apro_end_dt" type="text" style="width:75" dataformat="ymd" cofield="in_apro_st_dt">&nbsp;<img name="btn_period" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>
								<td width="85">Disposal No.</td>
								<td width="185"><input name="disp_no_list" type="text" style="width:150" value="" dataformat="engup">&nbsp;<img name="btn_t1_req_multy" class="cursor" src="img/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle"></td>
								<td width="85">EQ No.</td>
								<td colspan=3><input name="eq_no_list" type="text" style="width:150" value="" dataformat="engup">&nbsp;<img name="btn_t2_req_multy" class="cursor" src="img/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle"></td>
							</tr>
							<tr class="h23">
								<td width="50">Status</td>
								<td width="315"><script language="javascript">ComComboObject('input_status_type_code', 2, 188, 1, 0,0,false,2);</script>&nbsp;</td>
								<td width="85">Invoice No.</td>
								<td width="185"><input name="inv_no_list" type="text" style="width:150" value="" dataformat="engup">&nbsp;<img name="btn_t3_req_multy" class="cursor" src="img/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle"></td>
								<td width="85">Req. RHQ</td>
								<td width="80"><script language="javascript">ComComboObject('ar_hd_qtr_ofc_cd', 2, 70, 0, 0);</script></td>
								<td width="50">Office</td>
								<td><script language="javascript">ComComboObject('ofc_cd', 2, 70, 0, 0);</script></td><!-- rqst_ofc_cd -->
							</tr>
				</table>

				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>

				<!-- Grid  1(S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>
				<!-- Grid  1(E) -->

				<!--  Button_Sub (S) -->
				<table width="100%" class="button">
		       	<tr><td class="btn2_bg">
					<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td width="" id="btn_DeleteReject" style='display:none'><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_DeleteReject">Delete(Reject)</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
											
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_NotPickup">Not Pick-up CNTR</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
											
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Detail">Detail Info</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>

						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_DownExcel">Down Excel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
				</td></tr>
				</table>
		    	<!-- Button_Sub (E) -->

				<!--  biz_1   (E) -->

		<table class="height_8"><tr><td></td></tr></table>

		</td></tr>
		</table>
		<!--biz page (E)-->
	</td></tr>
</table>
</form>
</html>