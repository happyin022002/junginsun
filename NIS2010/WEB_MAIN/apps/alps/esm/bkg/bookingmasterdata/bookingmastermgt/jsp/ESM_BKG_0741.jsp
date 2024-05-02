<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0741.jsp
*@FileTitle : booking master data
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.16
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.06.16 강동윤
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
<%@ page import="com.hanjin.framework.core.controller.util.WebKeys"%>
<%@ page import="com.hanjin.framework.core.view.template.Screen"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg0741Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0741Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	String screenName		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.BookingMasterData.BookingProcessMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (EsmBkg0741Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		log.debug("====================================");
		Screen screen = (Screen) request.getAttribute(WebKeys.CURRENT_SCREEN);
		screenName = screen.getName();
		log.debug("====================================");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>booking master data</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if		
		
		ComSetObjValue(document.form.screenName,"<%=screenName%>");
		loadPage();
	}
	
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="screenName">
<!-- 개발자 작업	-->
<input type="hidden" name="chk_op">
<input type="hidden" name="ofc_cd">
<input type="hidden" name="ofc_ty">
<input type="hidden" name="por_cd">
<input type="hidden" name="bkg_ofc_cd">

<input type="hidden" name="check_ofc_flag" value="N">
<input type="hidden" name="check_por_flag" value="N">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		 <%@include file="../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TITLE.jsp"%>
		<!-- : ( Title ) (E) -->
		
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			<table class="search_sm2" border="0" style="width:479;"> 
			<tr class="h23">
				<td><input type="radio" name="cho_page" class="trans" checked onClick="javascript:changeOP('doc')">&nbsp;Doc Performance &nbsp;&nbsp;&nbsp;<input type="radio" name="cho_page" class="trans" onClick="javascript:changeOP('hand')">&nbsp;e-Service Handling Office</td>
			</tr>
			</table>
			<table class="height_5"><tr><td></td></tr></table>
			<table class="search_sm2" border="0" style="width:479;"> 
			<tr class="h23">
				<td>
					<span id="office_0">
					<input type="radio" name="cho_ofc_0" value="0" class="trans">&nbsp;H/OFC &nbsp;&nbsp;&nbsp;
					<input type="radio" name="cho_ofc_0" value="1" class="trans">&nbsp;GSO &nbsp;&nbsp;&nbsp;
					<input type="radio" name="cho_ofc_0" value="2" class="trans">&nbsp;Region &nbsp;&nbsp;&nbsp;
					<input type="radio" name="cho_ofc_0" value="3" class="trans">&nbsp;Controlled OFC&nbsp;&nbsp;
					<input type="text" name="ofc_cd_0" style="width:100;" dataformat="engup" maxlength="6" mixlength="5">
					</span>
					<span id="office_1">
					<input type="radio" name="cho_ofc_1" value="0" class="trans">&nbsp;B/OFC &nbsp;&nbsp;&nbsp;
					<input type="radio" name="cho_ofc_1" value="1" class="trans">&nbsp;POR &nbsp;&nbsp;&nbsp;
					<input type="radio" name="cho_ofc_1" value="2" class="trans">&nbsp;GSO &nbsp;&nbsp;&nbsp;
					<input type="radio" name="cho_ofc_1" value="3" class="trans">&nbsp;Region&nbsp;&nbsp;					
					<input type="text" name="ofc_cd_1" style="width:100;" dataformat="engup" maxlength="6" mixlength="5">
					</span>
				</td>
			</tr>
			</table> 
			<table class="height_5"><tr><td></td></tr></table>
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table> 
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table> 				
				<!-- Grid (E) -->	
			<% if (screenName.indexOf("Q") < 0){ %>	
				<!--  Button_Sub (S) -->
				<table width="100%" class="button"> 
		       	<tr><td class="btn2_bg">
					<table border="0" cellpadding="0" cellspacing="0">
					<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_add">Row Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_delete">Row Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_celladd">Controlled OFC Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					
						</tr></table>
				</td></tr>
				</table>
		    	<!-- Button_Sub (E) -->
			<%} %>
		</td></tr></table>
		<!--biz page (E)--> 

</td></tr></table>

<table class="height_5"><tr><td></td></tr></table>
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

    	<!--Button (S) -->	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right">
				</tr></table></td>	
				<% if (screenName.indexOf("Q") < 0){ %>			
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right">
				</tr></table></td>		
				<%} %>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_excel">Down Excel</td>
					<td class="btn1_right">
				</tr></table></td>		
				<!-- 
				<td class="btn1_line"></td>		
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right">
					 </td>-->
				</tr></table>
			</tr>
		</table></td>
			</tr>
		</table>
    	<!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
<%@include file="../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_CLOSE.jsp"%>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>