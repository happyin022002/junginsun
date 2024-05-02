<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_fms_0068.jsp
*@FileTitle : Revenue Port Management
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.15
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.07.15 최우석
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
<%@ page import="com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.event.EsmFms0068Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmFms0068Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	//int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	//String successFlag = "";
	//String codeList  = "";
	//String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.TimeCharterInOutAccounting.tcharterioconsultation");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmFms0068Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		//GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Revenue Port Management</title>
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
<input type="hidden" name="search_type">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;<span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->

		<!--biz page (S)-->
		<table class="search"> 
       		<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0">
					<tr><td class="title_h"></td>
					<td class="title_s">Revenue Port Management - Master</td></tr>
				</table>
				
				<table class="search_sm2" border="0" style="width:400;"> 
					<tr class="">
						<td width="92"><strong>Revenue Port</strong></td>   
						<td class="noinput1"><input type="radio" name="btn_rPort" value="" class="trans" checked>Inquiry&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="btn_rPort" value="" class="trans" >Creation</td>
					</tr>
				</table>
				
				<table class="height_2"><tr><td colspan="8"></td></tr></table>
				
				<table class="search_sm2" border="0" style="width:400;"> 
					<tr class="">
						<td width="92"><strong>Condition</strong></td>   
						<td class="noinput1"><input type="radio" name="btn_condition" value="" class="trans" checked>Service&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="btn_condition" value="" class="trans" >Revenue</td>
					</tr>
				</table>
				
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="95">&nbsp;&nbsp;Service Lane</td>   
						<td width="140"><input type="text" name="slan_cd" maxlength="3" style="width:60;;text-align:center;ime-mode:disabled;" required fullfill dataformat="engup" class="input" value="" caption="Service Lane">&nbsp;<img src="img/btns_search.gif" name="btn_slanpop" width="19" height="20" alt="" border="0" align="absmiddle" style="cursor:hand"></td>
						<td width="95">Revenue Lane</td>    
						<td width=""><input type="text" name="rlane_cd" maxlength="5" style="width:60;;text-align:center;ime-mode:disabled;" required fullfill dataformat="engup" class="input" value="" caption="Revenue Lane"></td> 
					</tr>
				</table>
				
				<!--  biz_1   (E) -->
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
				<!--  biz_2  (S) -->
				<table class="search" border="0">
					<tr><td class="title_h"></td>
					<td class="title_s">Revenue Port Management - Grid</td></tr>
				</table>
				
				<!-- Grid  (S) -->
				<table width="100%" class="search"  id="mainTable"> 
					<tr>
						<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table> 					 
				<!-- Grid (E) -->
				
				<!--  Grid_button (S) -->
				<table width="100%" class="button"> 
	       			<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn_add">Row&nbsp;Add</td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn_ins">Row&nbsp;Ins</td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn_del">Row&nbsp;Del</td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>
						</table>
					</td></tr>
				</table>
	    		<!-- Grid_button (E) -->
						
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
							<tr id="retrive"><td class="btn1_left"></td>
							<td class="btn1" name="btn_retrive">Retrieve</td>
							<td class="btn1_right"></td>
							</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_new">New</td>
							<td class="btn1_right"></td>
							</tr>
						</table></td>
						<td class="btn1_line"></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_save">Save</td>
							<td class="btn1_right"></td>
							</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_savetofile">Down&nbsp;Excel</td>
							<td class="btn1_right"></td>
							</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_deleteAll">Delete&nbsp;All</td>
							<td class="btn1_right"></td>
							</tr>
						</table></td>
						<td class="btn1_line"></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr id="revInterface">
								
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_revInterface">Revenue&nbsp;Port&nbsp;From&nbsp;ERP</td>
								<td class="btn1_right"></td>
							</tr>
						</table></td>
					</tr>
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