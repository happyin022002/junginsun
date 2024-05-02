<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_AGT_044.jsp
*@FileTitle : 대리점 Vendor List Inquiry (Pop-up)
*Open Issues :
*Change history :
*@LastModifyDate : 2007-04-18
*@LastModifier : Sang-Jun Kwon
*@LastVersion : 1.0
* 2006-11-30 Sang-Jun Kwon
* 1.0 최초 생성
* 2009-08-22 Ho-Jin Lee : Alps 전환 수정
=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.agt.agtagreement.agtofficeagreementinfo.event.EsmAgt0001Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
EsmAgt0001Event  event = null;					//PDTO(Data Transfer Object including Parameters)
Exception serverException   = null;				//서버에서 발생한 에러
String strErrMsg = "";						//에러메세지
int rowCount	 = 0;							//DB ResultSet 리스트의 건수

String successFlag = "";
String codeList  = "";
String pageRows  = "100";

String strUsr_id		= "";
String strUsr_nm		= "";
String strUsr_ofc_cd = "";
Logger log = Logger.getLogger("com.hanjin.apps.AGTAgreement.AGTOfficeAgreementInfo");

try {
	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	strUsr_id =	account.getUsr_id();
	strUsr_nm = account.getUsr_nm();
	strUsr_ofc_cd = account.getOfc_cd();
	
	event = (EsmAgt0001Event)request.getAttribute("Event");
	serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

	if (serverException != null) {
		strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
	}
		GeneralEventResponse eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
//		if (eventResponse != null) {
//			rowSet = eventResponse.getRs();
//			if(rowSet != null){
//				 rowCount = rowSet.getRowCount();
//			} // end if
//		} // end if
	
}catch(Exception e) {
	out.println(e.toString());
}
%>
<html>
<head>
<title>Vendor List Inquiry</title>
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
<body onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<!-- OUTER - POPUP (S)tart -->
<table width="780" class="popup" cellpadding="10" border="0">
	<tr>
		<td class="top"></td>
	</tr>
	<tr>
		<td valign="top">
			<!-- : ( Title ) (S) -->
			<table width="100%" border="0">
				<tr>
					<td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp; Agent Vendor List</td>
				</tr>
			</table>
			<!-- : ( Title ) (E) -->

			<!-- TABLE '#D' : ( Search Options : Speed ) (S) -->
			<table class="search">
				<tr>
					<td class="bg">
						<table class="search" border="0">
							<tr class="h23">
								<td width="90">Country Code</td>
								<td>
									<input type="text" name="vndr_cnt_cd" style="width:30;ime-mode:disabled;" class="input1" onKeyPress="ComKeyOnlyAlphabet('upper')" maxlength="2">&nbsp;<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="cnt_btn">
								&nbsp;</td>
								<td width="75">Office Code</td>
								<td>
									<input type="text" name="s_agmt_ofc_cd" style="width:50;ime-mode:disabled;" onKeyPress="ComKeyOnlyAlphabet('upper')" maxlength="5">&nbsp;<a href="javascript:openWindowOffice(document.form);" class="purple"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
								</td>
								<td width="100">&nbsp;&nbsp;Agreement No</td>
								<td>
									<input type="text" name="s_agmt_ofc_cty_cd" style="width:30;ime-mode:disabled;" onKeyPress="ComKeyOnlyAlphabet('upper')" maxlength="3">&nbsp;<input type="text" name="s_agn_agmt_seq" style="width:50;ime-mode:disabled;" onKeyPress="ComKeyOnlyAlphabet('upper')" maxlength="6">
								&nbsp;</td>
								<td width="120">Agreement Status</td>
								<td>
									<select name="s_agmt_sts" style="width:107;" >
                                    	<option value="0" selected>ALL</option>
                                    	<option value="1">Currently Effective</option>
                                    	<option value="2">Expired</option>
                                    	<option value="3">Deleted</option>
                                    	<option value="4">No Agreement</option>
									</select>
								</td>
							</tr>
						</table>
						<!-- : ( Speed ) (S) -->
						<table width="100%" id="mainTable">
							<tr>
								<td><script language="javascript">ComSheetObject('sheet1');</script></td>
							</tr>
						</table>
						<!-- : ( Speed ) (E) -->
						<!--  Button_Sub (S) -->
				<table width="100%" class="button" >
			       	<tr><td class="btn2_bg" >
					<table border="0" cellpadding="0" cellspacing="0" align="left">
					<tr >
						<!-- Repeat Pattern -->
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td><td class="btn2" id="btn_retrieve" name="btn_retrieve">Retrieve</td><td class="btn2_right"></td></tr></table></td>
					</tr></table>
				</td></tr>
				</table>
		    	<!-- Button_Sub (E) -->
					</td>
				</tr>
			</table>
			<!-- TABLE '#D' : ( Search Options : Speed ) (E) -->
		</td>
	</tr>
</table>
<!-- OUTER - POPUP (E)nd -->
<table class="height_5">
	<tr>
		<td></td>
	</tr>
</table>
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup">
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
    	 	  	<tr>
    	 	  		<td class="btn3_bg">
		    			<table border="0" cellpadding="0" cellspacing="0" align="left">
		    				<tr>
								<!-- Repeat Pattern -->
								<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td><td class="btn1" name="btn_ok" id="btn_ok">OK</td><td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td class="btn1_line"></td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<!-- Repeat Pattern -->
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<!-- : ( Button : pop ) (E) -->
</form>
</body>
</html>
<%@include file="../../../common/include/common.jsp"%>