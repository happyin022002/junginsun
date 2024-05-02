<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1132.jsp
*@FileTitle : C.OFC & C.REP PopUp
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.11
*@LastModifier : JSY
*@LastVersion : 1.0
* 2011.10.11 JSY
* 1.0 Creation
* 2011.10.20 정선용 [CHM-201113441-01] BKG 화면의 C.OFC 및 C.REP SELECT POPUP 추가 요청
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg1132Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1132Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.GeneralBookingConduct.GeneralBookingSearch");
	
	String bkgNo = "";	
	String scNo = "";	
	String calllFunc = "";
	String ctrtRepCd = "";
	String sXml = "";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg1132Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		bkgNo  = JSPUtil.getParameter(request, "bkg_no");
		scNo  = JSPUtil.getParameter(request, "sc_no");
		calllFunc  = JSPUtil.getParameter(request, "func");
		ctrtRepCd  = JSPUtil.getParameter(request, "ctrt_rep_cd");
		sXml  = JSPUtil.getParameter(request, "sXml");

		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>C.OFC & C.REP</title>
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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="bkg_no" value="<%=bkgNo%>">
<input type="hidden" name="sc_no" value="<%=scNo%>">
<input type="hidden" name="ctrt_rep_cd" value="<%=ctrtRepCd%>">
<input type="hidden" name="calllFunc" value="<%=calllFunc%>">
<input type="hidden" name="sXml" value="<%=sXml%>">
<!-- 개발자 작업	-->
<!-- OUTER - POPUP (S)tart -->
<table width="500" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;C.OFC & C.REP Pop-Up</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
			<table class="search"> 
       		<tr><td class="bg">
			<!--  
			<table class="search" border="0" style="width:560;"> 
				<tr class="h23">
					<td width="150">S/C No</td> 
					<td width=""><input type="text" name="sc_no" style="width:70;" class="input2" value="<%=scNo %>" readonly></td>
				</tr>
				<tr class="h23">
					<td width="">Commodity Code</td> 
					<td width=""><input type="text" name="cmdt_cd" style="width:70;" class="input" value="" style="ime-mode:disabled"  maxlength=6 dataformat="int"></td>
				</tr>
				<tr class="h23">
					<td width="">Commodity Description</td> 
					<td width=""><input type="text" name="cmdt_nm" style="width:100%" dataformat='etc' class="input" value="" maxlength=30></td>
				</tr></table>
			-->
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
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>