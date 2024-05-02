<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ui_bkg_0015.jsp
*@FileTitle : ACI_Vessel Information
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.24
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2009.04.24 김민정
* 1.0 Creation
*--------------------------------------------------------
* History
* 2012.03.05 민정호 [CHM-201216207] CANADA CUSTOMS VESSEL ARRIVAL 전송 메뉴 보완 (A6)
* 2013.04.25 김보배 [CHM-201324023] [BKG] ACI - Vessel Arrival Transmit (A6) 화면 및 로직 보완
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.event.EsmBkg0015Event"%><%@ page import="org.apache.log4j.Logger" %>
<%
	EsmBkg0015Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.ManifestListDownload");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0015Event)request.getAttribute("Event");
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
<title>Canada ACI: Vessel Arrival Manifest (A6)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="frm_attr_ctnt2">
<input type="hidden" name="frm_act_arr_dt">


<!-- 개발자 작업	-->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr>
		<td valign="top">

<!--Page Title, Historical (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
</table>
<!--Page Title, Historical (E)-->

<!--biz page (S)-->

<table class="search" id="mainTable">
	<tr>
		<td class="bg"> 
			<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="40">&nbsp;&nbsp;VVD</td>
					<td width="160"><input type="text" style="width:90;ime-mode:disabled" class="input1" 
						required dataformat="eng" name="vvd_cd" minlength="9" maxlength="9" caption="VVD"></td>
					<td width="30">POD</td>
					<td width=""><input type="text" style="width:90;ime-mode:disabled" class="input1"
						required dataformat="engupnum" name="pod_cd" minlength="5" maxlength="5" caption="POD"></td>
				</tr>
			</table>

			<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
			
			<table border="0" style="width:850; background-color:white;" class="grid2"> 
				<tr class="h23">
					<td width="80" class="tr2_head">Carrier Code</td>
					<td width="100" class="noinput2"><input type="text" style="width:100%;text-align:center" class="noinput2" readOnly="true" name="frm_crr_cd"></td>
					<td width="90" class="tr2_head">Arrival Date</td>
					<td width="100" align="center"><input type="text" style="width:100%;text-align:center"  maxlength="10"
						class="noinput" name="frm_vps_eta_dt" dataformat="ymd" caption="Arrival Date"></td>
					<td width="120" class="tr2_head">Actual Arrival Date</td>
					<td width="100" align="center"><input type="text" style="width:100%;text-align:center"  maxlength="10"
						class="noinput" name="frm_act_arr_da" dataformat="ymd" caption="Actual Arrival Date"></td>
					<td width="60" align="center"><input type="text" style="width:100%;text-align:center"  maxlength="5"
						class="noinput" name="frm_act_arr_tm" dataformat="hm" caption="Actual Arrival Time"></td>
					<td width="40" class="tr2_head">CRN</td>
					<td width="100" align="center" class="noinput2">
						<input type="text" style="width:100%;text-align:center;ime-mode:disabled" maxlength="20"
						class="noinput2" name="frm_cvy_ref_no" dataformat="eng" caption="CRN" readonly="readonly"></td>
				</tr>
				<tr class="h23"> 
					<td width="80" class="tr2_head">CREW</td>
					<td width="100" class="noinput" align="center">
						<input type="text" style="width:100%;text-align:center;" maxlength="3"
						class="noinput" name="frm_crw_knt" caption="CREW" caption="CREW" dataformat="int"></td>	
					<td width="80" class="tr2_head">Passenger</td>
					<td width="100" class="noinput" align="center">
						<input type="text" style="width:100%;text-align:center;" maxlength="5" class="noinput" name="frm_pasg_cnt" caption="Passenger" dataformat="int"></td>						
					<td width="" class="tr2_head">Captain Name</td>
					<td width="" colspan="7" align="center">
						<input type="text" style="width:340;text-align:center" class="noinput" name="frm_cap_nm" dataformat="engupspace" caption="Captain Name" maxlength="300"></td>
						
				</tr>
			</table> 
			<div style="font-size:11px;padding:5px">* CREW,Passenger is not saved(EDI-send Only).</div>
			
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			
			<table border="0" style="width:230; background-color:white;" class="grid2"> 
				<tr class="h23">
					<td width="90" class="tr2_head">Total WGT</td>
					<td width="130" class="noinput2"><input type="text" style="width:100%;text-align:right" class="noinput2" readOnly="true" name="frm_cgo_wgt"></td>
				</tr>
			</table>
			
			<table class="height_5"><tr><td></td></tr></table>
			
			<table border="0" style="width:700; background-color:white;" class="grid2">
				<tr class="h23">
					<td width="90" class="tr2_head">TEU Full</td>
					<td width="130" class="noinput2"><input type="text" style="width:100%;text-align:right" class="noinput2" readOnly="true" name="frm_teu_ful"></td>
					<td width="90" class="tr2_head">FEU Full</td>
					<td width="130"class="noinput2"><input type="text" style="width:100%;text-align:right" class="noinput2" readOnly="true" name="frm_feu_ful"></td>
					<td width="90" class="tr2_head">OTH Full</td>
					<td width=""class="noinput2"><input type="text" style="width:100%;text-align:right" class="noinput2" readOnly="true" name="frm_oth_ful"></td>
				</tr>
				<tr class="h23">
					<td width="" class="tr2_head">TEU Empty</td>
					<td width=""class="noinput2"><input type="text" style="width:100%;text-align:right" class="noinput2" readOnly="true" name="frm_teu_mty"></td>
					<td width="" class="tr2_head">FEU Empty</td>
					<td width=""class="noinput2"><input type="text" style="width:100%;text-align:right" class="noinput2" readOnly="true" name="frm_feu_mty"></td>
					<td width="" class="tr2_head">OTH Empty</td>
					<td width=""class="noinput2"><input type="text" style="width:100%;text-align:right" class="noinput2" readOnly="true" name="frm_oth_mty"></td>
				</tr>
			</table>
		</td>
	</tr>
</table>

<div style="display:none">
<script language="javascript">ComSheetObject('sheet1');</script>
</div>

<!--Button (S) -->
<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
	<tr>
		<td class="btn">
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
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_save">Save</td>
							<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</td>
		<td class="btn1_bg">
    		<table border="0" cellpadding="0" cellspacing="0">
    			<tr>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_transmit">Transmit A6</td>
							<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_arr_transmit"> Actual Arrival Transmission</td>
							<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_delete">Delete A6</td>
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

<!-- 본문끝 -->
		</td>
	</tr>
</table>
<!-- 본문끝 -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>