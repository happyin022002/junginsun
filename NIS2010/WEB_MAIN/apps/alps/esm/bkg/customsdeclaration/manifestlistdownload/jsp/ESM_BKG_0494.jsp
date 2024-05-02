<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ui_bkg_0494.jsp
*@FileTitle : ACI_Vessel Information
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.04.24 정재엽
* 1.0 Creation
* ------------------------------------------------------
* HISTORY 
* 2012.03.14 김경섭 [CHM-201216605] ANCS Main Menu 관련 ESM_BKG_0044,0494,0965,0970 화면의 POD조회 추가.
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>	
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.event.EsmBkg0494Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0494Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.ManifestListDownload");

	String vvd   = "";
	String ssrNo = "";
	String pod   = "";
	String popup = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0494Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		vvd   = (request.getParameter("vvd") == null)? "":request.getParameter("vvd");
		ssrNo = (request.getParameter("ssr_no")== null)?"":request.getParameter("ssr_no");
		pod   = (request.getParameter("pod")== null)?"":request.getParameter("pod");
		popup   = (request.getParameter("popup")== null)?"":request.getParameter("popup");
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
	
%>
<html>
<head>
<title>SSR View for CUSREP</title>
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
<input type="hidden" name="old_ssr_no">
<input type="hidden" name="pod" value="<%=pod %>">


<%
%>
<!-- 개발자 작업	-->
<input type="hidden" name="popup" value="<%=popup %>">

<%@include file="../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp" %>
	<!--Page Title, Historical (E)-->

	
	
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="80">&nbsp;&nbsp;VVD</td>
					<td width=""><input type="text" style="width:111;ime-mode:disabled" class="input1" maxlength="9" dataformat="ennum" name="vvd" value="<%=vvd %>"></td>
				</tr>
				</table>
				
				<table class="line_bluedot"><tr><td></td></tr></table>
				
				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="80">&nbsp;&nbsp;SSR No.</td>
					<td width="" colspan="5">
					<input type="text" style="width:111;ime-mode:disabled" class="input" maxlength="6" dataformat="ennum" name="frm_ssr_no" ></td>
				</tr>
				<tr class="h23">
					<td width="">&nbsp;&nbsp;Lloyd No.</td>
					<td width="200">
					<select style="width:47;" class="input2" name="frm_lloyd_type">
						<option value="L" selected="selected" >L</option>
						<option value="N" >N</option>
					</select>&nbsp;<input type="text" style="width:60;ime-mode:disabled" class="input" maxlength="20" dataformat="ennum" name="frm_lloyd_no"></td>
					<td width="120">VSL Flag / Name</td>
					<td width="" colspan="4">
						<input type="text" style="width:30;ime-mode:disabled" class="input" maxlength="2" dataformat="engup" name="frm_vsl_flag">&nbsp;<input type="text" style="width:125;ime-mode:disabled" class="input" maxlength="500" dataformat="ennum" name="frm_vsl_name">
					</td>
				</tr>
				<tr class="h23">
					<td width="">&nbsp;&nbsp;PRV Port</td>
					<td width=""><input type="text" style="width:111;ime-mode:disabled" class="input" maxlength="5" dataformat="engupnum" name="frm_prv_prot"></td>
					<td width="">Berth Code</td>
					<td style="padding-left:2;">
						<script language="javascript" >ComComboObject('slan_cd', 1, 150, 1)</script></td>
				</tr>
				<tr class="h23">
					<td width="">&nbsp;&nbsp;POD</td>
					<td width="" style='padding-left:2px'><script language="JavaScript">ComComboObject("frm_pod", 1, 110);</script>
					<!-- <input type="text" style="width:111;ime-mode:disabled" class="input2" name="frm_pod" maxlength="5" value='BEANR' readonly="readonly"> --></td>
					<td width="">Call Date (ETA)</td>
					<td width=""><input type="text" style="width:160;ime-mode:disabled" class="input" maxlength="10" dataformat="ymd" name="frm_eta_call_date"></td>
					<td width="120">DEM/DET Free Time</td>
					<td width=""><input type="text" style="width:100;ime-mode:disabled" class="input" maxlength="10" dataformat="ymd" name="frm_demdet_free_time"></td>
				</tr>
				</table>
				<table class="height_5"><tr><td></td></tr></table>
				<table border="0" style="width:979; background-color:white;" class="grid2"> 
				<tr>
				<td class="tr2_head" width="100">Remark(s)</td>
				<td>
				<textarea rows="6" style="width:100%;text-align:left;text-transform:uppercase;ime-mode:disabled" maxlength="4000"  name="frm_remark" >
				</textarea>
				</td>
				</tr></table>
				
				<table class="line_bluedot"><tr><td></td></tr></table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="110">&nbsp;&nbsp;CUSREP &nbsp;&nbsp;
					<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_cusrep">
					</td>
					<td width="140">Accept&nbsp;&nbsp;<img src="img/btng_icon_b.gif" width="13" height="13" alt="" border="0" name="anr_msg_sts_cd"></td>
					<td width="60">&nbsp;Last EDI</td>
					<td width="110"><input type="text" style="width:70;" class="input2" name="frm_last_edi" readonly="readonly"></td>
					<td width="100">User ID / Date</td>
					<td width="71"><input type="text" style="width:70;" class="input2" name="frm_user_id" readonly="readonly"></td>
					<td width=""><input type="text" style="width:110;" class="input2" name="frm_user_date" readonly="readonly"></td>
					<td></td>
				</tr></table>	
				<table class="line_bluedot"><tr><td></td></tr></table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23"><td width="707">
						<table class="search_sm" border="0" style="width:705;"> 
						<tr class="h23">
						<td width="103">&nbsp;&nbsp;Download </td>
						<td width="130" class="stm">BKG TTL / DNLD TTL</td>
						<td width="182">
						<input type="text" style="width:66;text-align:center" class="input2" name="frm_bkg_ttl" readonly="readonly">&nbsp;
						<input type="text" style="width:70;text-align:center" class="input2" name="frm_dnld_ttl" readonly="readonly"></td>
						<td width="" class="stm">Difference&nbsp;&nbsp;<input type="text" style="width:30;text-align:center" class="input2" name="frm_diff" readonly="readonly"></td>
						
				</tr>
				</table>	
				</td>
				<td width="" align="right">Transmit As&nbsp;&nbsp;
				<span id="trans_sel"></span>
				</td>
				</tr></table>	
				
				<!--  biz_1   (E) -->
				</td></tr>
			</table>
			
			
			
	<!--biz page (E)-->
	
<script language="javascript">ComSheetObject('sheet1');</script>
	
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve" >Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_transmission">CUSREP Transmit</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>

<%@include file="../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_CLOSE.jsp" %>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>