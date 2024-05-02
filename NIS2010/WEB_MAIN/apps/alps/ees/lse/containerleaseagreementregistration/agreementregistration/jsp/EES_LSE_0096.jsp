<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_lse_0096.jsp
*@FileTitle : Lease Agreement Version Up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.02
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.06.02 노정용
* 1.0 Creation
=========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.event.EesLse0096Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EesLse0096Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.ContainerLeaseAgreementRegistration.AgreementRegistration");
	
	String strAgmtCtyCd  = "";
	String strAgmtSeq    = "";
	String strAgmtVerSeq = "";
	String strOrgEffDt   = "";
	String strOrgExpDt   = "";	
	String strNewEffDt   = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
		event = (EesLse0096Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		strAgmtCtyCd  = (String)eventResponse.getCustomData("agmt_cty_cd");
		strAgmtSeq    = JSPUtil.getLPAD((String)eventResponse.getCustomData("agmt_seq"),6, "0");
		strAgmtVerSeq = (String)eventResponse.getCustomData("agmt_ver_seq");
		strOrgEffDt   = (String)eventResponse.getCustomData("eff_dt");
		strOrgExpDt   = (String)eventResponse.getCustomData("exp_dt");
		strNewEffDt   = DateTime.getFormatDate(DateTime.addDays(JSPUtil.replace(strOrgExpDt,"-",""), 1),"yyyyMMdd", "yyyy-MM-dd");
	
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Agreement No. Selection</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<!-- OUTER - POPUP (S)tart -->
<table width="500" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Lease Agreement Version-Up</td></tr>
		</table>
		<!-- : ( Title ) (E) -->

		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:100%;">
					<tr class="h23">
						<td width="150">AGMT Ver.</td>
						<td width="">
							<input type="text" !name="agmt_cty_cd"  caption="AGMT Ver." style="width:35;text-align:center;" class="input2" value="<%= strAgmtCtyCd %>"  !maxlength="8" !dataformat="ymd" !cofield="exp_dt" readonly>
							<input type="text" !name="agmt_seq"     caption="AGMT Ver." style="width:55;text-align:center;" class="input2" value="<%= strAgmtSeq %>"    !maxlength="8" !dataformat="ymd" !cofield="eff_dt" readonly>
							<input type="text" !name="agmt_ver_seq" caption="AGMT Ver." style="width:25;text-align:center;" class="input2" value="<%= strAgmtVerSeq %>" !maxlength="8" !dataformat="ymd" !cofield="eff_dt" readonly>
						</td>
					</tr>
					<tr class="h23">
						<td width="150">Effective Date</td>
						<td width="">
							<input type="text" name="eff_dt" caption="Effective Date" style="width:75;text-align:center;" class="input2" value="<%= strOrgEffDt %>" maxlength="8" dataformat="ymd" !cofield="exp_dt" readonly>
							~
							<input type="text" name="exp_dt" caption="Effective Date" style="width:75;text-align:center;" class="input2" value="<%= strOrgExpDt %>" maxlength="8" dataformat="ymd" !cofield="eff_dt" readonly>
						</td>
					</tr>
				</table>				
				<table class="line_bluedot" style="width:100%;"><tr><td colspan="6"></td></tr></table>
				<table class="search" border="0" style="width:100%;"> 
					<tr class="h23">
						<td width="150">New AGMT Ver.</td>
						<td width="">
							<input type="text" !name="agmt_cty_cd"  caption="AGMT Ver." style="width:35;text-align:center;" class="input2" value="<%= strAgmtCtyCd %>"  !maxlength="8" !dataformat="ymd" !cofield="exp_dt" readonly>
							<input type="text" !name="agmt_seq"     caption="AGMT Ver." style="width:55;text-align:center;" class="input2" value="<%= strAgmtSeq %>"    !maxlength="8" !dataformat="ymd" !cofield="eff_dt" readonly>
							<input type="text" !name="agmt_ver_seq" caption="AGMT Ver." style="width:25;text-align:center;" class="input2" value="<%= Integer.parseInt(strAgmtVerSeq)+1 %>" !maxlength="8" !dataformat="ymd" !cofield="eff_dt" readonly>
						</td>
					</tr>
					<tr class="h23">
						<td width="150">New Effective Date</td>
						<td width="">
							<input type="text" name="new_eff_dt" caption="Effective Date" style="width:75;text-align:center;" class="input2" value="<%= strNewEffDt %>" maxlength="8" dataformat="ymd" !cofield="new_exp_dt" readonly>
							~
							<input type="text" name="new_exp_dt" caption="Effective Date" style="width:75;text-align:center;" class="input1" value="" maxlength="8" dataformat="ymd" !cofield="new_eff_dt">
							<img class="cursor" src="img/btns_calendar.gif" name="btns_calendar1" width="19" height="20" border="0" align="absmiddle" dataformat="ymd">
						</td>
					</tr> 
				</table>
				<!--  biz_1   (E) -->
			</td></tr>
		</table>
		<!--biz page (E)-->

<table class="height_10"><tr><td></td></tr></table>

<!-- : ( Button : pop ) (S) -->
<table width="500" class="sbutton">
<tr><td height="71" class="popup">
    	<!--Button (S) -->	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr>
			<td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_OK">OK</td>
					<td class="btn1_right">
				</tr></table></td>
			<td class="btn1_line"></td>
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
					<td class="btn1_right">
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