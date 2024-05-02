<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_SCE_0103.jsp
*@FileTitle : ESD_SCE_0103
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.28
*@LastModifier : 신한성
*@LastVersion : 1.0
* 2009.07.28 신한성
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
<%@ page import="com.hanjin.apps.alps.esd.sce.common.popup.event.CommonPopUpManageEvent"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	CommonPopUpManageEvent  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.common.popup");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (CommonPopUpManageEvent)request.getAttribute("Event");
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
<title>ESD_SCE_0103</title>
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

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input    type="hidden" name="f_cmd">
<input    type="hidden" name="f_slt_idx" value="0">

<!-- OUTER - POPUP (S)tart -->
<table width="800" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
			<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;VVD Inquiry</td></tr>
		</table>
		<!-- : ( Title ) (E) -->

		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
				<tr><td class="btn1_bg">

						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_new">New</td><td class="btn1_right"></td></tr></table></td>
							<!-- Repeat Pattern -->

						</tr></table>

				</td></tr>
		</table>
		<!-- TABLE '#D' : ( Button : Main ) (E) -->



		<!-- TABLE '#D' : ( Search Options : Speed ) (S) -->
     	<table class="search">
       	<tr><td class="bg">


				<table class="search" border="0" style="width:100%">
						<tr class="h23">
							<td width="65">ETA / ETD</td>
							<td width="78">
								<select name="seletad" style="width:74;" onchange="selectVSLEVNT(this.value)">
								<option value="ETA" selected>ETA</option>
								<option value="ETD">ETD</option>
								</select>
							</td>
							<td width="">
								<input name="sdate" type="text" class="input" style="width:70; text-transform:uppercase;" dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)"  >&nbsp;~
								<input name="edate" type="text" class="input" style="width:70; text-transform:uppercase;" dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)"  >
								<img name="btn_bkg_calendar" class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">

							  <!-- <input name="sdate" type="text" style="width:100" value="" align="absmiddle">
							  <img class="cursor" src="/hanjin/img/alps/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar1">
							  &nbsp;~&nbsp;
							  <input name="edate" type="text" style="width:100" value="" align="absmiddle">&nbsp;
                              					<img class="cursor" src="/hanjin/img/enis/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar2"> -->
							</td>
						</tr>
					</table>
					<table class="search" border="0" style="width:100%">
						<tr class="h23">
						<td width="65">Lane</td>
						<td width="170"><input name="sellane" type="text" style="width:74" value="" onKeyUp="ComChkObjValid(this, 'eng', true, 3); this.value = this.value.toUpperCase();" ></td>
						<td width="30">POL</td>
						<td width="170"><input name="selpol" type="text" style="width:87" value="" onKeyUp="ComChkObjValid(this, 'eng', true, 5); this.value = this.value.toUpperCase();"></td>
						<td width="30">POD</td>
						<td width="160"><input name="selpod" type="text" style="width:79" value="" onKeyUp="ComChkObjValid(this, 'eng', true, 5); this.value = this.value.toUpperCase();" ></td>
						<td width="30">VVD</td>
						<td width=""><input name="selvvd" type="text" style="width:94; text-transform:uppercase;"  value="" onKeyUp="ComChkObjValid(this, 'eng_num', true, 9);" onBlur="ComChkObjValid(this, 'eng_num', true, 9); " ></td>
					</tr>
					</table>


					<table class="height_10"><tr><td></td></tr></table>

				<!-- : ( Speed ) (S) -->
				<table border="0" style="width:100%; background-color:white;" class="grid2"  id="mainTable">
				<tr>
					<td>
                      <script language="javascript">ComSheetObject('sheet');</script>
                    </td>
                 </tr>
				 </table>
				<!-- : ( Speed ) (E) -->

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options : Speed ) (E) -->




</td></tr>
</table>
<!-- OUTER - POPUP (E)nd -->



<table class="height_10"><tr><td></td></tr></table>


<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton">
		<tr><td height="71" class="popup">

			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
	       		<tr><td class="btn3_bg">
			    <table border="0" cellpadding="0" cellspacing="0">
			    <tr>

					<!-- Repeat Pattern -->
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_apply" id="btn_apply">Ok</td><td class="btn1_right"></td></tr></table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
					<!-- Repeat Pattern -->

				</tr>
			</table>

		</td></tr>
</table>
<!-- : ( Button : Sub ) (E) -->

<!-- 개발자 작업	-->


<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
