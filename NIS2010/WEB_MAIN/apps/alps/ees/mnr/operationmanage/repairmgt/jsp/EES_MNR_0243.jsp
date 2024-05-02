<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0243.jsp
*@FileTitle : EDI & Excel Estimate Upload
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.23
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2010.08.23 장준우
* 1.0 Creation
--------------------------------------------------------
* History
* 2011.12.12 김상수 [CHM-201115107-01] MNR Repair SPP Upload 기능 Verify Result 기능 강화
*                                      - Excel Upload 직후 MST에서 EQ No 존재유무 확인 로직 추가
*                                      - Error 발생시 사용자 메세지 팝업창 수정
*                                      - Confirm시 Fail일때, 원인내용 표기
* 2012.06.15 신혜정 [CHM-201218436] [Calculation] 버튼 기능 추가*                       
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.event.EesMnr0243Event"%>
<%@ page import="com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.EstimateUploadGRPVO"%>
<%@ page import="com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.vo.InterfaceGRPVO"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0243Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd        = "";
	Logger log = Logger.getLogger("com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt");

	//호출 화면 구분
	String reqUi = ((request.getParameter("req_ui")==null )?"":request.getParameter("req_ui"));

	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (EesMnr0243Event)request.getAttribute("Event");
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
<title>EDI & Excel Estimate Upload</title>
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

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="req_ui" value="<%=reqUi%>">

<!-- Calculation 위한 셋팅값 -->
<input type="hidden" name="agmt_ofc_cty_cd">    
<input type="hidden" name="agmt_seq">          
<input type="hidden" name="agmt_ver_no">
<input type="hidden" name="eq_knd_cd"><!-- EQ Type -->
<input type="hidden" name="eq_tpsz_cd">
<input type="hidden" name="trf_no">

<!-- 개발자 작업	-->
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">

<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;EDI & Excel Estimate Upload</td></tr>
		</table>
		<!-- : ( Title ) (E) -->

		<!--biz page (S)-->
		<table class="search" id="mainTable">
       		<tr><td class="bg">

				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:100%;">
				<tr class="h23">
					<td width="325">
						<table class="search_sm2" border="0" style="width:230;">
							<tr>
								<td width="85">&nbsp;<strong>EDI Type</strong></td>
								<td>
									<input type="radio" name="edi_tp" value="E" class="trans" checked disabled="true">Excel&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="radio" name="edi_tp" value="T" class="trans" disabled="true">Text&nbsp;&nbsp;&nbsp;</td>
							</tr>
						</table>
					</td>
					<td width="60">Vendor</td>
					<td width="">
						<select name="vndr_seq" style="width:62" class="input2" disabled="true">
							<option value=""></option>
							<option value="A">A</option>
							<option value="B">B</option>
							<option value="C">C</option>
							<option value="D">D</option>
	                    </select>
					</td>
				</tr>
				</table>
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				<!--  biz_1   (E) -->

				<!-- Grid  (S) -->
					<table width="100%"  id="sheetTable">
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
								<div style="display:none">
								<script language="javascript">ComSheetObject('sheet2');</script>
								</div>
							</td>
						</tr>
					</table>
				<!-- Grid (E) -->

				<table width="100%" class="button">
				<!--
		       	<tr><td class="btn2_bg">
					<table border="0" cellpadding="0" cellspacing="0">
					<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Check">Verify</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						</tr></table>
				</td></tr>
				-->
				</table>

			</td></tr>
		</table>
		<!--biz page (E)-->

		<table class="height_5"><tr><td></td></tr></table>
</td></tr></table>

<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
    	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       	<tr>
			<td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_loadExcel">Load Excel</td>
						<td class="btn1_right">
					</tr></table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><img class="cursor" src="img/btn_file.gif" width="17" height="18" border="0" align="absmiddle" name="btns_DownFile" alt="Load Excel Templet File DownLoad!">&nbsp;&nbsp;&nbsp;
					</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_calc">Calculation</td>
						<td class="btn1_right">
					</tr></table></td>
				<td class="btn1_line"></td>					
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Save">Confirm</td>
						<td class="btn1_right">
					</tr></table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_close">Close</td>
						<td class="btn1_right">
					</tr></table></td>
				</tr>
		</table></td>
			</tr>
		</table>
    	<!--Button (E) -->
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
<%@include file="/bizcommon/include/common_alps.jsp" %>