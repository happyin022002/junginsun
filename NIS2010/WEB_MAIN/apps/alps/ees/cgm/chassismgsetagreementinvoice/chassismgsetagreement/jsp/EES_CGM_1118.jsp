<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_1118.jsp
*@FileTitle : Lease Term Change Summary Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.30
*@LastModifier : 김창식
*@LastVersion : 1.0
* 2009.06.30 김창식
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
<%@ page import="com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.event.EesCgm1118Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@page import="com.hanjin.framework.component.util.io.HttpUtil"%>
<%
	EesCgm1118Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.ChassisMgsetAgreementInvoice.ChassisMgsetAgreement");
	String xml = HttpUtil.makeXML(request,response);
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EesCgm1118Event)request.getAttribute("Event");
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
<title>Lease Term Change Summary Inquiry</title>
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
<form name="form2">
<input type="hidden" name="sXml" value="<%=xml.replace("\"","'")%>">
</form>
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->

<input type="hidden" name="intg_cd_id">
<input type="hidden" name="eq_knd_cd">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	
	<tr><td valign="top">
	
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->
	
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="90">Change Office</td>
					<td width="230"><input type="text" name="sts_evnt_ofc_cd" dataformat="engup" style="width:150;ime-mode:disabled" class="input" value=""><!--img name="btns_office1" src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"-->&nbsp;<img name="btns_office2" src="img/btns_multisearch.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
					<td width="95">Change Period</td>
					<td width="270"><input type="text" name="sts_evnt_dt_fr" dataformat="ymd" maxlength="8" style="width:75;text-align:center;ime-mode:disabled" class="input1" value="">&nbsp;&nbsp;~&nbsp;&nbsp;<input type="text" name="sts_evnt_dt_to" dataformat="ymd" maxlength="8" style="width:75;text-align:center;ime-mode:disabled" class="input1" value="">&nbsp;<img name="btns_sts_evnt_dt" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>
					<td colspan="2" style="padding-bottom:4;">
						
						<!--table border="0" style="width:265;" class="search_sm2"> 
						<tr class="h23">
							<td align="center" style="font-size:12;">
								<input type="radio" name="viewflg" class="trans" checked>&nbsp;Summary&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="radio" name="viewflg" class="trans">&nbsp;List Only</td></tr>
						</table-->
					
					</td>
				</tr> 
				<tr class="h23">
					<td>Lessor</td>
					<td><input type="text" name="vndr_seq" dataformat="eng" style="width:150;ime-mode:disabled" class="input" value=""><!--img name="btns_vndr1" src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"-->&nbsp;<img name="btns_vndr2" src="img/btns_multisearch.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
					<td>Old Term</td>
					<td style="padding-left:2;">
						<script language="javascript">ComComboObject('old_agmt_lstm_cd', 1, 199, 0, 0, 0, false);</script>&nbsp;<!--input type="text" name="old_agmt_lstm_cd_text" style="width:145" class="input" value=""--></td>
					<td width="65">New Term</td>
					<td style="padding-left:2;">
						<script language="javascript">ComComboObject('new_agmt_lstm_cd', 1, 199, 0, 0, 0, false);</script>&nbsp;<!--input type="text" name="new_agmt_lstm_cd_text" style="width:145" class="input" value=""--></td>
				</tr> 
				</table>				
				<!--  biz_1   (E) -->
			
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
		
			<!-- Grid  (S) -->
			<div id="viewLayer1" style="display:block">
			<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table>
			</div>
			<div id="viewLayer2" style="display:none">
			<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet2');</script>
					</td>
				</tr>
			</table>
			</div>
			<!-- Grid (E) -->	
			
			</td></tr>
		</table>
		<!--biz page (E)-->


		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;"> 
       	<tr><td class="btn1_bg">
		
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_loadexcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td></tr>
			</table>
		</td></tr>
		</table>
    	<!--Button (E) -->
		
	
	</td></tr>
		</table>
	

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>