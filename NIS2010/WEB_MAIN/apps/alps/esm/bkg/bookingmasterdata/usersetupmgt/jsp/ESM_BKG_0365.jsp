<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ui_bkg_0365.jsp
*@FileTitle : Mark & Description Template
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.04.27 김영출
* 1.0 Creation
* 2011.09.02 변종건 [CHM-201111165-01] [BKG] BL Data Input Cross-check 기능 추가 보완-Sailing Date 및  Multi-VVD Base 검색 조건 추가
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.event.EsmBkg0365Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg0365Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd        = "";
	Logger log = Logger.getLogger("com.hanjin.apps.bookingmaterdata.usersetupmgt");

	String returnObj = "";
	String tmpltTpCd = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (EsmBkg0365Event)request.getAttribute("Event");
		returnObj = event.getReturnObject();
		tmpltTpCd = event.getTmpltTpCd();
		tmpltTpCd = (tmpltTpCd==null || "".equals(tmpltTpCd)) ? "M" : tmpltTpCd;

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		//e.printStackTrace();
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Mark & Description Template</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">



<script language="javascript">
	cur_usr_id = '<%=strUsr_id%>';
	cur_ofc_cd = '<%=strOfc_cd%>';
	returnObject = null;
	
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();

<%
	if(returnObj!=null && returnObj.length()>0){
%>
		returnObject = opener.document.form.<%=returnObj%>;
<%
	}
%>
	}
</script>
</head>

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="tmplt_tp_cd" value="<%=tmpltTpCd%>">
<input type="hidden" name="bkg_no" value="<%=event.getBkgNo()%>">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; Mark & Description Template</td></tr>
		</table>
		<!--table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table-->
		<!-- : ( Title ) (E) -->

		<!-- : ( Search Options ) (S) -->
		<!--biz page (S)-->

		<!--  biz page    (E) -->
		<table class="height_8"><tr><td></td></tr></table>

			<table class="search">
       		<tr><td class="bg">


				<table class="search" border="0">
				<tr class="h23">
					<td width="80"><input type="radio" name="marks_type" value="M" class="trans"  <%if("M".equals(tmpltTpCd)) out.print("checked");%>>&nbsp;&nbsp;Marks</td>
					<td width="110"><input type="radio" name="marks_type" value="D" class="trans"  <%if("D".equals(tmpltTpCd)) out.print("checked");%>>&nbsp;&nbsp;Description</td>
					<td width="200"><input type="radio" name="marks_type" value="T" class="trans"  <%if("T".equals(tmpltTpCd)) out.print("checked");%>>&nbsp;&nbsp;Total PKG/CNTR in Word</td>
					<td width=""><input type="radio" name="marks_type" value="V" class="trans"  <%if("V".equals(tmpltTpCd)) out.print("checked");%>>&nbsp;&nbsp;Multi VVD</td>
					<td align="right"><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_office">Office</td>
					<td class="btn2_right"></td>
					</tr>
				</table></td>
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
				<table>
					<tr>
						<td><span id="vvd_note"><%if("V".equals(tmpltTpCd)){%> Note : When VVDs are entered, use "",(comma)"" in between VVDs as a delimiter <%}%></span></td>
					</tr>
				</table>
				
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->

<table class="height_5"><tr><td></td></tr></table>
</td></tr>
</table>

<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>

				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_rowAdd">Row Add</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_delete">Delete</td>
					<td class="btn1_right"></td>
				</tr></table></td>

				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_select">Select</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right"></td>
				</tr></table>
				</td>
			</tr>
		</table>

	</td></tr>
</table>
    <!--Button (E) -->

	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>