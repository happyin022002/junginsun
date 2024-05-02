<%
/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : VOP_VSK_0080.jsp
*@FileTitle : Notification for Vessel Schedule Change
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.15
*@LastModifier : 정상기
*@LastVersion : 1.0
* 2013.07.15 정상기
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
<%@ page import="com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.schedulenotificationmanagement.event.VopVsk0080Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%

	VopVsk0080Event  	event 			= null;					//PDTO(Data Transfer Object including Parameters)
	Exception 			serverException	= null;			//서버에서 발생한 에러
	String 				strErrMsg 		= "";						//에러메세지
	int 				rowCount	 	= 0;						//DB ResultSet 리스트의 건수

	String 				successFlag 	= "";
	String 				codeList  		= "";
	String 				pageRows  		= "100";

	String 				strUsr_id		= "";
	String 				strUsr_nm		= "";
	Logger 				log 			= Logger.getLogger("com.hanjin.apps.VesselOperationSupportMgt.SHATideInformationMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopVsk0080Event)request.getAttribute("Event");
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
<title>SHA Tide Information Creation</title>
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
<input type="hidden" name="max_day">
<input type="hidden" name="login_usr_id" value="<%=strUsr_id%>">
<input type="hidden" name="vsl_slan_cd">
<input type="hidden" name="slan_cd">
<input type="hidden" name="loc_cd">

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
		<table class="search" id="mainTable"> 
       		<tr><td class="bg" style="height:504" valign="top">	
			
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="70">Lane Code</td>
					<td width="100"><input type="text" name="lane_cd"  style="width:35;text-align:center;ime-mode:disabled;" class="input" value="" maxlength="3" onfocus="this.select();">&nbsp;<img class="cursor" name="btn_lane_cd" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
									
					<td width="55">Port</td>
					<td width="200"><input type="text" name="port_cd" style="width:50;text-align:center;ime-mode:disabled;" class="input" value="" maxlength="5" onfocus="this.select();">&nbsp;<img class="cursor" name="btn_port" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>

					<td width="500"></td>

					<!-- td width="90">Updated Date</td-->
					<!-- td width="500"><input type="text" name="upd_dt" style="right" class="input2" readOnly>
									&nbsp;
									<input type="text" name="upd_usr_id" style="width:80;" class="input2" readOnly></td-->						
				</tr> 
				</table>				
				<!--  biz_1   (E) -->
			<table class="line_bluedot"><tr><td></td></tr></table>	
	
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
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_RowAdd">Row Add </td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>

					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_RowDelete">Row Delete</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
				
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->		

			</td></tr>

		</table>
		<!--biz page (E)-->

		<!-- Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left">
					<td class="btn1" name="btn_Retrieve" id="btn_retrieve">Retrieve</td>
					<td class="btn1_right">
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>		
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
					
			</tr>
			</table></td>
				
			</tr>
			</table>
			<!-- Button (E) -->
		</td></tr>
		</table>
	

	<table class="height_10"><tr><td colspan="8"></td></tr></table>
	

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>