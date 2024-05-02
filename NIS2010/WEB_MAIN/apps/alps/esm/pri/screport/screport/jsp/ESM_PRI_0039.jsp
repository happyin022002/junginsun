<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0039.jsp
*@FileTitle : Proposal Amendment Draft Print
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.25
*@LastModifier : 변영주
*@LastVersion : 1.0
* 2009.06.25 변영주
* 1.0 Creation
*=========================================================
* History :
* 2015.06.16 최성환 [CHM-201536349] S/C 다운로드 보안 강화 (다운로드 버튼 접근 제한)
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.screport.screport.event.EsmPri0039Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri0039Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.SCReport.SCReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();

		event = (EsmPri0039Event)request.getAttribute("Event");
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
<title>Proposal Amendment Draft Print</title>
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
<input type="hidden" name="cd_tp">
<input type="hidden" name="cd1">
<input type="hidden" name="cd2">
<input type="hidden" name="eff_dt">
<input type="hidden" name="exp_dt">
<input type="hidden" name="in_usr_id" value="<%=strUsr_id%>">
<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->	
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
		
				<table class="search_sm2" border="0" style="width:450;"> 
				<tr class="h23">
					<td width="70">&nbsp;Print By</td>
				    <td width="" class="stm">
						  <input type="radio" value="1" name="ret_tp_rdo" class="trans" checked>S/C No.&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" value="2" name="ret_tp_rdo" class="trans">Proposal No.&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" value="3" name="ret_tp_rdo" class="trans" >Authorizer&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" value="4" name="ret_tp_rdo" class="trans" >Sales&nbsp;Rep.
					</td>
				</tr>
				</table> 
				
<!--TAB  (S) -->
<div id="SearchLayer" style="display:inline">				
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="60">&nbsp;&nbsp;S/C No.</td>
					<td width="140"><input type="text" style="width:100;" name="sc_no" maxlength="9" dataformat="engup" class="input1"></td>
					<td width="55">AMD No.</td>
					<td width="100"><input type="text" style="width:50;" name="amdt_seq" readonly=true class="input2"></td> 
					<td width="55">Duration</td>
					<td width="180"><input type="text" style="width:75;" name="sc_dur_eff_dt" maxlength="10" dataformat="ymd" readonly=true class="input2">&nbsp;~&nbsp;
									<input type="text" style="width:75;" name="sc_dur_exp_dt" maxlength="10" dataformat="ymd" readonly=true class="input2"></td>
					<td><table width="75" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_retrieve1">Retrieve</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
				</tr>
				</table>
				<!--  biz_1   (E) -->
</div>
<!--TAB  (E) --> 				
				
				

<!--TAB  (S) -->
<div id="SearchLayer" style="display:none">				
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="85">&nbsp;&nbsp;Proposal No.</td>
					<td width="115"><input type="text" style="width:80;" name="prop_no" maxlength="10" dataformat="engup" class="input1"></td>
					<td width="55">Duration</td>
					<td width="180"><input type="text" style="width:75;" name="prop_dur_eff_dt" maxlength="10" dataformat="ymd" readonly=true class="input2">&nbsp;~&nbsp;
									<input type="text" style="width:75;" name="prop_dur_exp_dt" maxlength="10" dataformat="ymd" readonly=true class="input2"></td>
					<td ALIGN="left"><table width="75" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_retrieve2">Retrieve</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
				</tr>
				</table>
				<!--  biz_1   (E) -->
</div>
<!--TAB  (E) --> 				
				
				
				
<!--TAB  (S) -->
<div id="SearchLayer" style="display:none">					
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="105">&nbsp;&nbsp;Approval Office</td>
					<td width="95"><input type="text" style="width:58;" name="apro_ofc_cd" readonly=true class="input2" value="<%=strUsr_ofc%>"></td>
					<td width="55">Auth by</td>
					<td width="140"><input type="text" style="width:100;" name="apro_usr_nm" readonly=true class="input2" value="<%=strUsr_nm%>"></td>
					<td width="65">Filed Date</td>
					<td width="230"><input type="text" style="width:75;" name="auth_dur_eff_dt" maxlength="10" dataformat="ymd" class="input1" >&nbsp;<img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btns_calendar1" class="cursor">&nbsp;~&nbsp;
									<input type="text" style="width:75;" name="auth_dur_exp_dt" maxlength="10" dataformat="ymd" class="input1" >&nbsp;<img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btns_calendar2" class="cursor"></td>
					<td><table width="75" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_retrieve3">Retrieve</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
				</tr>
				</table>
				<!--  biz_1   (E) -->
</div>
<!--TAB  (E) --> 

				
				
<!--TAB  (S) -->
<div id="SearchLayer" style="display:none">					
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="105">&nbsp;&nbsp;Request Office</td>
					<td width="95"><input type="text" style="width:58;" name="prop_ofc_cd" readonly=true class="input2" value="<%=strUsr_ofc%>"></td>
					<td width="65">Sales Rep.</td>
					<td width="200"><script language="javascript">ComComboObject('prop_srep_cd', 2, 70, 0, 1, 0, false);</script>&nbsp;<input type="text" style="width:80;" name="prop_srep_nm" readonly=true class="input2"></td>
					<td width="90">Creation Date</td>
					<td width="230"><input type="text" style="width:75;" name="srep_dur_eff_dt" maxlength="10" dataformat="ymd" class="input1" >&nbsp;<img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btns_calendar3" >&nbsp;~&nbsp;
									<input type="text" style="width:75;" name="srep_dur_exp_dt" maxlength="10" dataformat="ymd" class="input1" >&nbsp;<img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btns_calendar4"></td>
					<td><table width="75" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_retrieve4">Retrieve</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
				</tr>
				</table>
				<!--  biz_1   (E) -->
</div>
<!--TAB  (E) -->			

				<table class="line_bluedot"><tr><td></tr></table>
				<!--  biz_2  (S) -->
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table> 				
				<!-- Grid (E) -->
	
	
		</td></tr>
		</table>
	<!--biz page (E)-->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td>
		    	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
		    		<tr>
<!--		    		
		    		<td class="btn1_left"></td>
		    		<td class="btn1" name="btn_open2">Open(Draft)</td>
		    		<td class="btn1_right">
-->		    		
		    		<td class="btn1_left"></td>
		    		<td class="btn1" name="btn_open">Open</td>
		    		<td class="btn1_right">		    		
		    		</td>
		    		</tr>
		    	</table>
			</td></tr>
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