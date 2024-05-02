<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0046.jsp
*@FileTitle : Lane Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.11
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.06.02 유혁
* 1.0 Creation
* 
* History
* 2011.10.11 진마리아 CHM-201112822-01 Lane Code inquiry내 trade 및 Sub trade, SKD 로 lane Code 정보를 조회 가능하도록 로직 수정
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.event.VopVsk0046Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk0046Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.vskcommon.vskcodefinder");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopVsk0046Event)request.getAttribute("Event");
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
<title>Lane Code Inquiry</title>
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
<!-- 개발자 작업	-->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;padding-right:5;">
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
				<!--  biz_1  (S) -->
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="70">Lane Code</td>
					<td width="80"><input type="text" style="width:50;ime-mode:disabled;text-align:center" class="input" name="vsl_slan_cd" tabindex="1" maxlength="3"><!-- &nbsp;<img class="cursor" src="img/btns_search.gif" name="btn_pop" width="19" height="20" border="0" align="absmiddle"> --></td>
					<td width="70">Lane Name</td>
					<td width="120"><input type="text" style="width:100;ime-mode:disabled;" class="input" name="vsl_slan_nm" tabindex="2" maxlength="50"></td>
					<td width="45">Trade</td>
					<td width="110" style="padding-left:2">
					<select name="trd_cd" style="width:50;text-align:center;" class="input"> 
					</select></td>
					<td width="65">Sub-Trade</td>
					<td width="110" style="padding-left:2">
					<select name="sub_trd_cd" style="width:50;text-align:center;" class="input">
					</select></td>
					<td width=""><table border="0" style="width:220;" class="search_sm2"> 
						<tr class="h23"><td>
						<input type="radio" value="A" class="trans" name="fdr_div_cd" tabindex="3" checked> All &nbsp;&nbsp;<input type="radio" name="fdr_div_cd" value="TRUNK" class="trans"> Trunk&nbsp;&nbsp;<input type="radio" name="fdr_div_cd" value="O" class="trans"> Off-lane </td>	
						</tr>
					</table></td>
				</tr>

				<tr class="h23">
				<td width="65">Service Type</td>
				<td width="80">
					<select name="vsl_svc_tp_cd" style="width:50;text-align:center;" class="input"> 
						<!-- <option value="ALL">ALL</option> -->
					</select>
				</td>
				 
				<td colspan="4"></td>
				<td width="75">Period</td>
				<td colspan="2" width="">
					<input type="text" name="fm_dt" dataformat="ym" caption="시작년월" maxlength="8" size="10" cofield="fm_dt" style="width:80;text-align:center;" class="input" value="">&nbsp;<img src="img/btns_calendar.gif" name="btns_calendar_s" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">&nbsp;~&nbsp;
					<input type="text" name="to_dt" dataformat="ym"  caption="종료년월" maxlength="8" size="10" cofield="to_dt" style="width:80;text-align:center;" class="input" value="">&nbsp;<img src="img/btns_calendar.gif" name="btns_calendar_e" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
				</td>
				
				</tr>
				
				</table>
				<!--  biz_1   (E) -->
				<table class="line_bluedot"><tr><td></td></tr></table>
				<!--  biz_2  (S) -->
				
				<!-- Grid  (S) -->
					<table width="100%" id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table>
						<!-- Grid (E) -->
						
				<!--  biz_2   (E) -->
				
				
				</td></tr>
			</table>
	
	<!--biz page (E)-->
	
	
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve" tabindex="4">Retrieve</td>
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