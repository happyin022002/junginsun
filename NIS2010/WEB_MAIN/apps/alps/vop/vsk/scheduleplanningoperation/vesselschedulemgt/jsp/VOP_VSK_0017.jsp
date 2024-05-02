<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0017.jsp
*@FileTitle : Daily Berth Window
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.20
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.06.17 유혁
* 1.0 Creation
*
* History
* 2011.04.20 CHM-201110283-01 진마리아 Daily Berth Window 로직 변경 요청
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0017Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk0017Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";

	String strUsr_id = "";
	String strUsr_nm = "";
	String eml = "";
	Logger log = Logger.getLogger("com.hanjin.apps.scheduleplanningoperation.vesselschedulemgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		eml = account.getUsr_eml();

		event = (VopVsk0017Event)request.getAttribute("Event");
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
<title>Daily Berth Window Updated by Port</title>
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
<input type="hidden" name="pagerows" value="500">
<input type="hidden" name="page_no" value="1">
<input type="hidden" name="loc_cd">
<input type="hidden" name="gw_subject">
<input type="hidden" name="gw_contents">
<input type="hidden" name="usrInfo">

<input type="hidden" name="com_subject">
<input type="hidden" name="com_content">
<input type="hidden" name="com_from" value="<%=eml%>">
<!-- 개발자 작업	-->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;padding-right:5">
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
					<td width="45">Period</td>
					<td width="240">
						<input type="text" name="fm_dt" dataformat="ymd" style="width:75;text-align:center;" class="input1" value="" maxlength="8" size="10">
						&nbsp;&nbsp;~&nbsp;&nbsp;
						<input type="text" name="to_dt" dataformat="ymd" style="width:75;text-align:center;" class="input1" value="" maxlength="8" size="10">&nbsp;
						<img class="cursor" name="btn_period" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
					</td>
					<td width="30">Port</td>
					<td width="160"><input type="text" name="vps_port_cd" style="width:50;text-align:center;ime-mode:disabled;" class="input1" value="" maxlength="5" onfocus="this.select();">&nbsp;<img class="cursor" name="btn_port" src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle">&nbsp;<script language="javascript">ComComboObject('yd_cd',2,70,1,0);</script></td>
					
					<td width="60">Direction</td>  
					<td width="50"><script language="javascript">ComComboObject('skd_dir_cd',1,50,1,0);</script></td>
					<!-- 
					<td width="70">Lane Code</td>
					 -->
					<td><script language="javascript">ComComboObject('lane_grp',1,60,1,0);</script>&nbsp;
						<div id="div_lane" style="display:inline"><input type="text" name="slan_cd" style="width:60;text-align:center;ime-mode:disabled;" class="input" value="" maxlength="3" onfocus="this.select();">&nbsp;<img class="cursor" name="btn_lane" src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle"></div>
						<div id="div_grp" style="display:none"><script language="javascript">ComComboObject('lane_grp_nm',1,70,1,0);</script></div>
					</td> 
					<td align="right">
						<table class="search_sm2" border="0" style="width:190;"> 
							<tr class="h23">
								<td><input type="radio" name="vsl_svc_tp_cd" value="" class="trans" checked="checked">All &nbsp;<input type="radio" name="vsl_svc_tp_cd" value="T" class="trans">Trunk&nbsp;<input type="radio" name="vsl_svc_tp_cd" value="O" class="trans"> Off-line</td>
							</tr>
						</table>
					</td>
				</tr>
				</table>
				<!--  biz_1   (E) -->
				<table class="line_bluedot"><tr><td></td></tr></table>
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
						<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn2_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_downexcel">Down Excel</td>
					<td class="btn2_right"></td>
					</tr>
				</table></td>
				
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
				<!--  biz_2   (E) -->
				</td></tr>
			</table>
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
				<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
				<td class="btn1_right"></td></tr>
			</table></td>
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_save">Save</td>
				<td class="btn1_right"></td></tr>
			</table></td>
			<td class="btn1_line"></td>
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_group">Group Registration</td>
				<td class="btn1_right"></td></tr>
			</table></td>
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_send_gwmail">Send GW Mail</td>
				<td class="btn1_right"></td></tr>
			</table></td>
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_send_mail">Send Mail</td>
				<td class="btn1_right"></td></tr>
			</table></td>
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_send_edi">Send EDI</td>
				<td class="btn1_right"></td></tr>
			</table></td>
			
		</tr>
		</table>
	</td></tr>
	</table>
   <!--Button (E) -->

</form>
</body>
</html>
