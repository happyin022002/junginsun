<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0018.jsp
*@FileTitle : ESM_BKG-0018
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.24
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.04.24 김승민
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page
	import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page
	import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page
	import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page
	import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.panama.event.EsmBkg0018Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0018Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	//int rowCount = 0; //DB ResultSet 리스트의 건수

	//String successFlag = "";
	//String codeList = "";
	//String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	//Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.ManifestListDownload");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0018Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		//GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>ESM_BKG-0018</title>
<meta http-eqEsmv="Content-Type" content="text/html; charset=UTF-8">
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
<form name="form">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="vsl_cd"> 
<input type="hidden" name="skd_voy_no"> 
<input type="hidden" name="skd_dir_cd"> 
<input type="hidden" name="pagerows"> <!-- 개발자 작업	-->
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
		<!--Page Title, Historical (E)--> <!--Button (S) --> <!--Button (E) -->

		<!--biz page (S)-->

		<table class="search" id="mainTable">
			<tr>
				<td class="bg">
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="25">VVD</td>
						<td width="150"><input type="text" style="width: 100;"
							 value="" name="vvdCd" class="input1" maxlength="9" dataformat="uppernum" reqEsmred style="ime-mode:disabled"></td>
						<td width="136">ETA at Panama Canal</td>
						<td width="310"><input type="text" style="width: 80;"
							 value="" name="vps_eta_start_dt" dataformat="ymd" maxlength="10" class="input1" caption="ETA at Panama Canal" cofield="vps_eta_end_dt" style="ime-mode:disabled">&nbsp;~&nbsp;<input
							type="text" style="width: 80;" value="" dataformat="ymd" maxlength="10" name="vps_eta_end_dt" class="input1" caption="ETA at Panama Canal" cofield="vps_eta_start_dt" style="ime-mode:disabled">&nbsp;<img
							class="cursor" src="img/btns_calendar.gif" width="19"
							height="20" border="0" align="absmiddle" name="btns_calendar"></td>
						<td width="26">Lane</td>
						<td width=""><input type="text" style="width: 40;"
							class="input" name="slan_cd" dataformat="upper" maxlength="3" value="" style="ime-mode:disabled"></td>
						<td width="65">Trans. STS</td>
						<td width="">
						<select name="trans_sts">
						<option value="">ALL</option>
						<option value="N">NO</option>
						<option value="Y">YES</option>
						</select>
						</td>
					</tr>
				</table>

 
				</td>
			</tr>
		</table>
		<!--biz page (E)-->
		<table class="height_8">
			<tr>
				<td></td>
			</tr>
		</table>
		<!-- Tab (S) --> <!-- Tab (E) --> <!--biz page (S)-->

		<table class="search" id="mainTable">
			<tr>
				<td class="bg"><!-- Grid  (S) -->
				<table width="100%" id="mainTable">
					<tr>
						<td width="100%"><script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- Grid (E) --> <!--  Button_Sub (S) --> <!-- Button_Sub (E) --></td>
			</tr>
		</table>
		<!--biz page (E)--> <!--Button (S) --> <!--Button (E) --> <!--Button (S) -->
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
								<td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td>
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
						<table width="72" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_save">Save</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_transmit">Go to Transmit</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		<!--Button (E) --></td>
	</tr>
</table>





<!-- Copyright (S) >
<table class="copy">
	<tr>
		<td class="familysite">&nbsp; <select name="sitelink"
			id="sitelink" class="select_family"
			onChange="javascript:go_sitelink(this);">
			<option selected>&nbsp;&nbsp; -- Family Site -- &nbsp;&nbsp;</option>
			<option value=""></option>
			<option value=""></option>
			<option value=""></option>
		</select></td>
		<td class="copy"><img src="img/img_bottom_logo.gif" width="460"
			height="16" alt="" border="0"></td>
	</tr>
</table>
<!-- Copyright(E)--> <!-- 개발자 작업  끝 --></form>
</body>
</html>