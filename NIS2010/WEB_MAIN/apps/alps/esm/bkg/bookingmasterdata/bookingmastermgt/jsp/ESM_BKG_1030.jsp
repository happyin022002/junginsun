<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1030.jsp
*@FileTitle : booking master
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.30
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.07.30 강동윤
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg1030Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1030Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String screenName		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.BookingMasterData.BookingMasterMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg1030Event)request.getAttribute("Event");
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
<title>booking master</title>
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

<input type="hidden" name="chk_cust_cd">
<input type="hidden" name="chk_cust_seq">

<!-- OUTER - POPUP (S)tart -->
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
       		
       			
			<table width="100%" class="search">
			<tr class="h23">
				<td width="95">Customer Code</td>
				<td width="135"><input type="text" name="cust_grp_id" style="width:18;" class="input" value="" dataformat="engup" maxlength="1">&nbsp;<input type="text" name="cust_cnt_cd" style="width:25;" class="input" value="" dataformat="engup" maxlength="2">&nbsp;<input type="text" name="cust_seq" style="width:50;" class="input" value="" dataformat="int" maxlength="6">
				</td>
				<td width="50">S/C  No.</td>
				<td width="115">
					<input type="text" name="sc_no" style="width:80;" class="input" value="" dataformat="engupnum" maxlength="9">&nbsp;
				</td>
				<td width="50">RFA No.</td>
				<td width="130">
					<input type="text" name="rfa_no" style="width:100;" class="input" value="" dataformat="engupnum" maxlength="11">&nbsp;
				</td>
				<td width="68">SVC Scope</td>
				<td width="70"><input type="text" name="svc_scp_cd" style="width:32;" class="input" value="" dataformat="engup" maxlength="3"></td>
				<td width="35">Origin</td>
				<td width="85"><input type="text" name="por_cd" style="width:50;" class="input" value="" dataformat="engup" maxlength="5"></td>
				<td width="75">Destination</td>
				<td width=""><input type="text" name="pod_cd" style="width:50;" class="input" value="" dataformat="engup" maxlength="5"></td>
			
			</tr>
			</table>
		
			
			<table class="height_8"><tr><td></td></tr></table>
			<!-- : ( Grid ) (S) -->
			<table width="100%"  id="mainTable"> 
			<tr>
				<td width="100%">
				<script language="javascript">ComSheetObject('sheet1');</script>
				</td>
			</tr>
			</table>
			<!-- : ( Grid ) (E) -->	
			<% if (screenName.indexOf("Q") < 0){ %>	
			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td><input type="text" name="copy_idx" style="width:30;text-align:center" class="input" value="1" dataformat="int" maxlength="3">&nbsp;</td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Copy">Row Copy</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Add">Row Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Delete">Row Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>						
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
			<% } %>		
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
</td></tr>
</table> 

<table class="height_5"><tr><td></td></tr></table>
	
	
<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<% if (screenName.indexOf("Q") < 0){ %>	
				<td class="btn1_line"></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<% } %>
			</table>
		</td></tr>
		</table>
    	<!--Button (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>