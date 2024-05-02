<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ui_bkg_0892.jsp
*@FileTitle : Container No Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.24
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.04.24 김영출
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event.EsmBkg0892Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg0892Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.outboundblmgt.bldocumentation");


	String bkgVvd    = "";
	String bkgOfcCd  = "";
	String bkgPol    = "";
	String bkgPod    = "";
	String cfmFlg    = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0892Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");


		bkgVvd    = event.getBkgVvd();
		bkgOfcCd  = event.getBkgOfcCd();
		bkgPol    = event.getBkgPol();
		bkgPod    = event.getBkgPod();
		cfmFlg    = event.getCfmFlg();

	}catch(Exception e) {
		out.println(e.toString());
	}

%>
<html>
<head>
<title>Container No Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">



<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
		//
		callback_func = '<%=JSPUtil.getParameter(request, "func", "")%>';
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->

<!-- OUTER - POPUP (S)tart -->
<table width="400" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;C/M Container No Inquiry</td></tr>
		</table>
		<!--table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table-->
		<!-- : ( Title ) (E) -->

		<!-- : ( Search Options ) (S) -->

		<table class="search">
   		<tr><td class="bg">

			<table class="search" border="0" style="width:100%;">
				<tr class="h23">
					<td width="40">T/VVD</td>
					<td width="100"><input type="text" name="bkg_vvd" style="ime-mode:disabled;width:80;" dataformat="engupnum" class="input1" value="<%=bkgVvd%>"></td>
					<td width="65">BKG Office</td>
					<td width=""><input type="text" name="bkg_ofc_cd" style="ime-mode:disabled;width:50;" dataformat="engupnum" class="input1" value="<%=bkgOfcCd%>"></td>
				</tr>
			</table>
			<table class="search" border="0" style="width:100%;">
				<tr class="h23">
					<td width="40">POL</td>
					<td width="100"><input type="text" name="bkg_pol" style="ime-mode:disabled;width:50;" dataformat="engupnum" class="input1" value="<%=bkgPol%>"></td>
					<td width="65">POD</td>
					<td width="67"><input type="text" name="bkg_pod" style="ime-mode:disabled;width:50;" dataformat="engupnum" class="input" value="<%=bkgPod%>"></td>
					<td width="30">C/M</td>
					<td width=""><select name="cfm_flg" style="width:50;" class="input">
						<option value="A">All</option>
						<option value="Y">Yes</option>
						<option value="N" selected>No</option>
						</select></td>
				</tr>
			</table>
				<!-- : ( Grid ) (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- : ( Grid ) (E) -->
		    <!-- : ( Button : Grid ) (E) -->

			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
</td></tr>
</table>

<table class="height_5"><tr><td></td></tr></table>

<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right">
				</tr></table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Select">Select</td>
					<td class="btn1_right">
				</tr></table></td>
				<td class="btn1_line">
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
					<td class="btn1_right">
				</tr></table></td>
			</tr>
		</table></td></tr>
	</table>
    <!--Button (E) -->

	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>