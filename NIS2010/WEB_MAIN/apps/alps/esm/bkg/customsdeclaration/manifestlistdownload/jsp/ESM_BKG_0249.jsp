<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0249.jsp
*@FileTitle : CndManifestListDownload
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.29
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2009.04.29 김민정
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.event.EsmBkg0249Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%
	EsmBkg0249Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	boolean bUsr_ofc = false;
	Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.CndManifestListDownload");

	try
	{
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0249Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null)
		{
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}
	catch (Exception e)
	{
		out.println(e.toString());
	}
%>
<html>
<head>
<title>ETL & CRN Inquiry</title>
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

<body onLoad="setupPage();">
<form name="form"><input type="hidden" name="f_cmd"> <input
	type="hidden" name="pagerows"> <!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	style="padding-top: 2; padding-left: 5;">
	<tr>
		<td valign="top"><!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0"
			class="title">
			<tr>
				<td class="history"><img src="img/icon_history_dot.gif"
					align="absmiddle"><span id="navigation"></span></td>
			</tr>
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif"
					align="absmiddle"><span id="title"></span></td>
			</tr>
		</table>
		<!--Page Title, Historical (E)--> <!--biz page (S)-->
		<table class="search">
			<tr>
				<td class="bg">
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="35">VVD</td>
						<td width="140"><input type="text"
							style="width: 80; ime-mode: disabled" dataformat="eng"
							class="input" name="vvd_cd" maxlength="9" caption="VVD"></td>
						<td width="30">POL</td>
						<td width="140"><input type="text"
							style="width: 80; ime-mode: disabled" maxlength="5" class="input"
							dataformat="engupnum" name="pol_cd" maxlength="5" caption="POL"></td>
						<td width="50">POD</td>
						<td width="140"><input type="text"
							style="width: 80; ime-mode: disabled" class="input1"
							dataformat="engupnum" name="vps_port_cd" maxlength="5" caption="POD"></td>
						<td width="35">ETA</td>
						<td width=""><input type="text"
							style="width: 85; ime-mode: disabled" class="input" maxlength="10"
							dataformat="ymd" maxlength="10" name="s_vps_eta_dt" caption="ETA" cofield="e_vps_eta_dt">
						&nbsp;~&nbsp; <input type="text"
							style="width: 85; ime-mode: disabled" class="input" maxlength="10"
							dataformat="ymd" maxlength="10" name="e_vps_eta_dt" caption="ETA" cofield="s_vps_eta_dt">
						<img src="img/btns_calendar.gif" width="19" height="20" alt=""
							border="0" align="absmiddle" class="cursor" name="btn_calendar">
						</td>
					</tr>
					<tr class="h23">
						<td width="">LANE</td>
						<td width="" colspan="3"><input type="text"
							style="width: 80; ime-mode: disabled" class="input" 
							dataformat="eng" name="slan_cd" maxlength="3" caption="LANE"></td>
						<td width="50">Operator</td>
						<td width=""><input type="text" style="width: 80;" class="input" 
							dataformat="engup" name="crr_cd" maxlength="4" caption="Operator"></td>
						<td width="">CRN</td>
						<td width=""><input type="text"
							style="width: 234; ime-mode: disabled" dataformat="eng"
							class="input" name="cvy_ref_no" maxlength="20" caption="CRN"></td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		<table class="height_8">
			<tr>
				<td></td>
			</tr>
		</table>

		<!-- Grid BG Box  (S) -->
		<table class="search" id="mainTable">
			<tr>
				<td class="bg">
				<table width="100%" id="mainTable">
					<tr>
						<td width="100%"><script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		<!-- Grid (E) --> <!-- 본문끝 --></td>
	</tr>
</table>
<!-- 본문끝 --> <!--Button (S) -->
<table width="100%" class="button" border="0" cellpadding="0"
	cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
	<tr>
		<td class="btn1_bg">
		<table border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td>
				<table width="100%" border="0" cellpadding="0" cellspacing="0"
					class="button">
					<tr>
						<td class="btn1_left"></td>
						<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
						<td class="btn1_right"></td>
					</tr>
				</table>
				</td>
				<td>
				<table width="72" border="0" cellpadding="0" cellspacing="0"
					class="button">
					<tr>
						<td class="btn1_left"></td>
						<td class="btn1" name="btn_new">New</td>
						<td class="btn1_right"></td>
					</tr>
				</table>
				</td>
				<td class="btn1_line"></td>
				<td>
				<table width="100%" border="0" cellpadding="0" cellspacing="0"
					class="button">
					<tr>
						<td class="btn1_left"></td>
						<td class="btn1" name="btn_downexcel">Down Excel</td>
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
<!-- 개발자 작업  끝 --></form>
</body>
</html>