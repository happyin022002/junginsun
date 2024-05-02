<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0462.jsp
*@FileTitle : ESM_BKG-0462
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
	import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.event.EsmBkg0462Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0462Event event = null; //PDTO(Data Transfer Object including Parameters)
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

		event = (EsmBkg0462Event) request.getAttribute("Event");
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
<title>ESM_BKG-0462</title>
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
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	style="padding-top: 2; padding-left: 5;">
	<tr>
		<td valign="top"><!--Page Title, Historical (S)-->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
			<!--Page Title, Historical (E)-->
 <!--Button (S) --> <!--Button (E) -->
		<!--biz page (S)-->
		<table class="search">
			<tr>
				<td class="bg"><!--  biz_1  (S) -->
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="30">VVD</td>
						<td width="100"><input type="text" style="width: 80"
							class="input1" value="" maxlength="9" dataformat="uppernum" name="in_vvd_cd" style="ime-mode:disabled"></td>
						<td width="30">POD</td>
						<td width="100"><input type="text" style="width: 45"
							class="input1" value="" name="in_pod_cd" maxlength="5" dataformat="upper" style="ime-mode:disabled"></td>
						<td width="30">POL</td> 
						<td width="100"><input type="text" style="width: 45"
							class="input" value="" name="in_pol_cd" maxlength="5" dataformat="upper" style="ime-mode:disabled"></td>
						<td width="60">B/L Type</td>
						<td width="">&nbsp;<select style="width: 80;" name="in_bl_type">
							<option value="0" selected>ALL</option>
							<option value="1">Local</option>
							<option value="2">T/S</option>
						</select></td>
					</tr>
				</table>

				<!--  biz_1   (E) -->
				<table class="line_bluedot">
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
				<!-- Grid (E) --> <!--  biz_2  (S) -->
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="110">Total B/L Count :</td>
						<td width=""><input type="text"
							style="width: 80; text-align: right" class="input2" value="" name="totalCount"></td>
					</tr>
				</table>

				<!--  biz_2   (E) --></td>
			</tr>
		</table>
		<table class="height_8">
			<tr>
				<td></td>
			</tr>
		</table>


		<!-- Tab ) (S) -->
		<table class="tab" border="0" cellpadding="0" cellspacing="0"
			width=100%>
			<tr>
				<td width="100%"><script language="javascript">ComTabObject('tab1')</script>
				<!-- img src="/img/sub_tab.gif" alt="" width="998" height="23" border="0" -->
				</td>
			</tr>
		</table>
		<!-- Tab ) (E) --> <!--TAB B/L List (S) -->
		<div id="tabLayer" style="display: inline"><!-- Tab BG Box ) (S) -->
		<table class="search">
			<tr>
				<td class="bg"><!-- Grid  (S) -->
				<table width="100%" id="mainTable">
					<tr>
						<td width="100%"><script language="javascript">ComSheetObject('t1sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- Grid (E) --></td>
			</tr>
		</table>
		</div>
		<!--TAB B/L List (E) --> <!--TAB  (S) -->
		<div id="tabLayer" style="display: none">
		<table class="search">
			<tr>
				<td class="bg"><!-- Grid  (S) -->
				<table width="100%" id="mainTable">
					<tr>
						<td width="100%"><script language="javascript">ComSheetObject('t2sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- Grid (E) --></td>
			</tr>
		</table>
		</div>
		<!--TAB  (E) --> <!--Button (S) -->
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
						<table width="" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_datadl">Data D/L</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td class="btn1_line"></td>
						<td>
						<table width="" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_print">Print</td>
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
<!-- Grid BG Box  (S) --> <!--biz page (E)-->
<table class="height_10">
	<tr>
		<td colspan="8"></td>
	</tr>
</table>
</td>
</tr>
</table>
				<table width="100%" id="mainTable" style="display:none">
					<tr>
						<td width="100%"><script language="javascript">ComSheetObject('sheet2');</script>
						</td>
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
<!-- Copyright(E)--></form>
</body>
</html>




