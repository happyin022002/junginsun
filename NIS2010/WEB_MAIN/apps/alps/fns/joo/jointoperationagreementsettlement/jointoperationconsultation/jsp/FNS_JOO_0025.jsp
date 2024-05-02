<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_joo_0025.jsp
*@FileTitle : CSR Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.19
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.06.19 박희동
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
<%@ page import="com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.event.FnsJoo0025Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsJoo0025Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.JointOperationAgreementSettlement.JointOperationConsultation");

	String sysdate = JSPUtil.getKST("yyyy-MM-dd");
	String ofcList = "";
	String ofcCd  = "";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (FnsJoo0025Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		ofcList = eventResponse.getETCData("ofc_list");
		ofcCd   = eventResponse.getETCData("ofc_cd");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>CSR Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
var gOfcCd = "<%=ofcCd%>";
var gSysDate = "<%=sysdate%>";
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage("<%=ofcList%>");
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="save_csr_no">
<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
<!--Page Title, Historical (S)-->   
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">   
        <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>   
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>   
    </table>   
<!--Page Title, Historical (E)-->  	
	
	
	<table class="search"> 
      	<tr><td class="bg">
			<!--  biz_1  (S) -->
			<table class="search" border="0" style="width:797;"> 
			<tr class="h23">
				<td width="440" colspan="4">
				<table class="search_sm2" border="0" style="width:410;">
						<tr class="h23">
							<td width="">&nbsp;<input type="radio" value="0" name="gubun" class="trans" checked>&nbsp;&nbsp;Iss.DT&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" value="1" name="gubun" class="trans" >&nbsp;&nbsp;Eff.DT&nbsp;&nbsp;&nbsp;<input type="text" style="width:80" value="<%=sysdate%>" name="fr_dt" dataformat="ymd" maxlength="10" class="input1">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btnCalFr">&nbsp;~&nbsp;<input type="text" style="width:80" value="<%=sysdate%>" name="to_dt" dataformat="ymd" maxlength="10" class="input1">&nbsp;<img class="cursor" name="btnCalTo" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>
						</tr>
						</table></td>
				<td width="44">Team</td>
				<td width="100"><script language="javascript">ComComboObject('slp_ofc_cd',2,80,0,1);</script></td>
				<td width="55">CSR No.</td>
				<td width=""><input type="text" style="width:170" class="input" name="csr_no" maxlength="20" dataformat="engup"></td>
			</tr>
			<tr class="h23">
				<td>Carrier</td>
				<td><script language="javascript">ComComboObject('crr_cd',1,80,0,0);</script></td>
				<td>Rev/Exp</td>
				<td>
					<select name="re_divr_cd" id="re_divr_cd" class="input">
						<option value="">All</option>
						<option value="R">Revenue</option>
						<option value="E">Expense</option>
					</select>
				</td>
				<td colspan="4"></td>
			</tr>
			</table>
		</td></tr>
	</table>
	<table class="height_8"><tr><td></td></tr></table>
	<!--  biz_1  (E) -->
	
	<table class="search"> 
       	<tr><td class="bg">
			<!-- Grid  (S) -->
			<table width="100%"  id="mainTable" border="0" cellpadding="0" cellspacing="0"> 
				<tr>
					<td width="100%">
					<!--시트-->
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table>
			<!-- Grid  (E) -->
		</td></tr>
	</table>
	<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve" id="btn_retrieve" auth="R">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new" id="btn_new" auth="R">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save" id="btn_save" auth="R">CSR Cancel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downexcel" id="btn_downexcel" auth="P">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_csr" id="btn_csr" auth="P">CSR Detail</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
		</tr>
		</table>
    <!--Button (E) -->
	</td></tr>
</table>
	</td></tr>
</table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>