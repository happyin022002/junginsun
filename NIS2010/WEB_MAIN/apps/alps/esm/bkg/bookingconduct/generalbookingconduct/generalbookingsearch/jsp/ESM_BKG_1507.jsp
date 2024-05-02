<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1507.jsp
*@FileTitle : Allocation Stand by Reason
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.13
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2014.01.13 문동선
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg1507Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1507Event event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.GeneralBookingConduct.GeneralBookingSearch");

	String bkgNo 			= "";	
	String popupMsgFlg		= "";
	String alocPopFlg       = "";
	String beforeAlocStsCd  = "";
	
	// esm_bkg_0229_01 용
	String autoNotification = "";
	String docTpCd = "";
	String bkgCntcPsonEml ="";
	String siCntcPsonEml = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg1507Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		bkgNo  	    = JSPUtil.getParameter(request, "bkg_no");			
		popupMsgFlg = JSPUtil.getParameter(request, "popup_msg_flg");		
		alocPopFlg  = JSPUtil.getParameter(request, "aloc_pop_flg");			
		beforeAlocStsCd = JSPUtil.getParameter(request, "before_aloc_sts_cd");		
		
		autoNotification = JSPUtil.getNull(JSPUtil.getParameter(request, "auto_notification"));			
		docTpCd          = JSPUtil.getNull(JSPUtil.getParameter(request, "doc_tp_cd"));		
		bkgCntcPsonEml   = JSPUtil.getNull(JSPUtil.getParameter(request, "bkg_cntc_pson_eml"));			
		siCntcPsonEml    = JSPUtil.getNull(JSPUtil.getParameter(request, "si_cntc_pson_eml"));	
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Standby Reason</title>
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

<body class="popup_bg" onLoad="setupPage();" onBeforeUnload="manualCaseCheck();" >
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="bkg_no" value="<%=bkgNo%>">
<input type="hidden" name="popup_msg_flg" value="<%=popupMsgFlg%>">
<input type="hidden" name="aloc_svc_cd" value="">
<input type="hidden" name="bkg_aloc_tp_cd" value="">
<input type="hidden" name="aloc_pop_flg" value="<%=alocPopFlg%>">
<input type="hidden" name="before_aloc_sts_cd" value="<%=beforeAlocStsCd%>">

<input type="hidden" name="auto_notification" value="<%=autoNotification%>">
<input type="hidden" name="doc_tp_cd" value="<%=docTpCd%>">
<input type="hidden" name="bkg_cntc_pson_eml" value="<%=bkgCntcPsonEml%>">
<input type="hidden" name="si_cntc_pson_eml" value="<%=siCntcPsonEml%>">

<!-- 개발자 작업	-->
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Standby Reason</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
			<table class="search" style="width:740"> 
       		<tr><td class="bg" >
			
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Trunk VVD BKG Status vs. Allocation</td></tr>
				</table>
			
				<!-- : ( Grid ) (S) -->
					<table width="100%" class="search"  id="mainTable"> 
						<tr>
							<td width="720px">
							<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table> 
				<!-- : ( Grid ) (E) -->	
			
				<table class="search" border="0">
				<tr><td class="height_5"></td></tr>
				<tr><td class="title_h"></td>
					<td class="title_s">T/S VVD BKG Status vs. Allocation</td></tr>
				</table>
			
				<!-- : ( Grid ) (S) -->
					<table width="100%" class="search"  id="mainTable"> 
						<tr>
							<td width="500px">
							<script language="javascript">ComSheetObject('sheet2');</script>
							</td>
						</tr>
					</table> 				
				<!-- : ( Grid ) (E) -->	
			
				<table class="search" border="0">
				<tr><td class="height_5"></td></tr>
				<tr><td class="title_h"></td>
					<td class="title_s">EQ & Commodity Restriction</td></tr>
				</table>
			
				<!-- : ( Grid ) (S) -->
					<table width="100%" class="search"  id="mainTable"> 
						<tr>
							<td width="420px">
							<script language="javascript">ComSheetObject('sheet3');</script>
							</td>
						</tr>
					</table> 				
				<!-- : ( Grid ) (E) -->	
				
				<table class="search" border="0">
				<tr><td class="height_5"></td></tr>
				<tr><td class="title_h"></td>
					<td class="title_s">Customer Constraint</td></tr>
				</table>
			
				<!-- : ( Grid ) (S) -->
					<table width="100%" class="search"  id="mainTable"> 
						<tr>
							<td width="720px">
							<script language="javascript">ComSheetObject('sheet4');</script>
							</td>
						</tr>
					</table> 				
				<!-- : ( Grid ) (E) -->	
				
				
				<table class="search" border="0">
				<tr class="h23">
					<td width="200"></td>
					<td>How would you like to proceed?&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>Firm(F)&nbsp;<input type="radio" name="aloc_sts_cd" value="F"  class="trans" tapindex=1>&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>Standby(S)&nbsp;<input type="radio" name="aloc_sts_cd" value="S"  class="trans" tapindex=2></td>
					<td>: Standby Notice&nbsp;<input type="checkbox" name="standby_ntc_flg" style="border-style:none" value="Y">
				</tr>
				</table>
				<table class="search" border="0">
				<tr class="sm">
					<td width="200"></td>
					<td>(Remark : In case of standby status, please tick standby notice box for customer notification.)</td>
				</tr>
				</table>
		    <!-- : ( Button : Grid ) (E) -->	
			
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
<table class="height_5"><tr></tr></table>
</td></tr>
</table> 

	
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
			    <tr>
					<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_ok">OK</td>
						<td class="btn1_right"></td>
					</tr></table></td>
					
					<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Close">Close</td>
						<td class="btn1_right"></td>
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