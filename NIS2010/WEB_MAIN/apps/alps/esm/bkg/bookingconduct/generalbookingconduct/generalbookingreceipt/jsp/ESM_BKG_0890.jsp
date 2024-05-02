<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0890.jsp
*@FileTitle : Cargo Detail Information
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.08.18 김병규
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.event.EsmBkg0890Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0890Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.GeneralBookingConduct.GeneralBookingReceipt");

	String bkgNo = "";
	String calllFunc = "";
	String caFlg = "";
	String callSheetIdx1 = "";	
	String callSheetIdx2 = "";
	String callTp = "";
	
	String dgFlg = "";
	String rcFlg = "";
	String awkCgoFlg = "";
	String bbCgoFlg = "";
	String hngrFlg = "";
	String eqSubstFlg = "";
	String socFlg = "";
	String mixedFlg = "";
	String autoFlg = "";	
	String rcvTermCd = "";
	String deTermCd = "";
	String bdrFlg="";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0890Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		bkgNo  = JSPUtil.getParameter(request, "bkg_no");
		caFlg  = JSPUtil.getParameter(request, "ca_flg");
		calllFunc  = JSPUtil.getParameter(request, "func");
		callSheetIdx1  = JSPUtil.getParameter(request, "callSheetIdx1");
		callSheetIdx2  = JSPUtil.getParameter(request, "callSheetIdx2");
		callTp  = JSPUtil.getParameter(request, "callTp");
		dgFlg  = JSPUtil.getParameter(request, "dcgo_flg");		
		rcFlg  = JSPUtil.getParameter(request, "rc_flg");		
		awkCgoFlg  = JSPUtil.getParameter(request, "awk_cgo_flg");		
		bbCgoFlg  = JSPUtil.getParameter(request, "bb_cgo_flg");		
		hngrFlg  = JSPUtil.getParameter(request, "hngr_flg");		
		eqSubstFlg  = JSPUtil.getParameter(request, "eq_subst_flg");		
		socFlg  = JSPUtil.getParameter(request, "soc_flg");		
		mixedFlg  = JSPUtil.getParameter(request, "mixed_flg");
		autoFlg  = JSPUtil.getParameter(request, "auto_flg");
		rcvTermCd  = JSPUtil.getParameter(request, "rcv_term_cd");	
		deTermCd  = JSPUtil.getParameter(request, "de_term_cd");	
		bdrFlg  = JSPUtil.getParameter(request, "bdr_flg");	

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Cargo Detail Information</title>
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

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="bkg_no" value="<%= bkgNo%>">
<input type="hidden" name="ca_flg" value="<%= caFlg%>">
<input type="hidden" name="bdr_flg" value="<%= bdrFlg%>">
<input type="hidden" name="func" value="<%=calllFunc%>">
<input type="hidden" name="callSheetIdx1" value="<%=callSheetIdx1%>">
<input type="hidden" name="callSheetIdx2" value="<%=callSheetIdx2%>">
<input type="hidden" name="callTp" value="<%=callTp%>">
<input type="hidden" name="dcgo_flg" value="<%=dgFlg%>">
<input type="hidden" name="rc_flg" value="<%=rcFlg%>">
<input type="hidden" name="awk_cgo_flg" value="<%=awkCgoFlg%>">
<input type="hidden" name="bb_cgo_flg" value="<%=bbCgoFlg%>">
<input type="hidden" name="hngr_flg" value="<%=hngrFlg%>">
<input type="hidden" name="eq_subst_flg" value="<%=eqSubstFlg%>">
<input type="hidden" name="soc_flg" value="<%=socFlg%>">
<input type="hidden" name="mixed_flg" value="<%=mixedFlg%>">
<input type="hidden" name="auto_flg" value="<%=autoFlg%>">
<input type="hidden" name="rcv_term_cd" value="<%=rcvTermCd%>">
<input type="hidden" name="de_term_cd" value="<%=deTermCd%>">
<!-- 개발자 작업	-->

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;EQ detail of Special Cargo Container</td></tr>
		</table>
		<!-- : ( Title ) (E) -->		
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table> 				
				<!-- Grid (E) -->	
			<!--  Button_Sub (S) -->
			<table width="100%" class="search"> 
	       	<tr><td>
				<table class="search_sm" border="0" width="350"><tr><td>				
						<td>
						<table class="search" border="0"> 
							<tr class="h23">
								<td width="70">Total Vol.</td>
								<td><input type="text" name="total_vol" style="width:100%;" class="input2" value="" readonly></td>
							</tr>
							<tr class="h23">
								<td width="70">BKG Vol.</td>
								<td><input type="text" name="bkg_vol" style="width:100%;" class="input2" value="" readonly></td>
							</tr>							
						</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
		</td></tr></table>
<table class="height_5"><tr><td></td></tr></table>
</td></tr></table>
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

    	<!--Button (S) -->	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td>
					<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Add">Add</td>
					<td class="btn1_right"></td>
					</tr></table></td>
					<td width="">
					<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Delete">Delete</td>
					<td class="btn1_right"></td>
					</tr>
					</table></td>				
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save">Ok</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<td class="btn1_line"></td>				
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
<table id="mainTable" width="50%">
	<tr>
		<td>
			<script language="javascript">ComSheetObject('sheet2');</script>
		</td>
	</tr>
</table>
</form>
</body>
</html>