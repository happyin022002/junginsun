<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0018.jsp
*@FileTitle : VSL SKD Delete & Closing
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.13
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.07.22 유혁
* 1.0 Creation
*
* History
* 2011.04.13 진마리아 CHM-201109577-01 Delete Vessel Code에 대한 조회 로직 보완
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0018Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk0018Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd = ""; 
	String strUsrAuthTpCd = "";
	String availActivate = "";

	Logger log = Logger.getLogger("com.hanjin.apps.scheduleplanningoperation.vesselschedulemgt");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();	   
		strUsrAuthTpCd = account.getUsr_auth_tp_cd();
		
		// Super User && CLTCO && PUSCOV 권한 부여 - #Mod 2010.07.26 by sj
		if ("S".equals(strUsrAuthTpCd) || "CLTCO".equals(strOfc_cd) || "PUSMOV".equals(strOfc_cd)) {
			availActivate = "Y";
		}
		
		event = (VopVsk0018Event)request.getAttribute("Event");
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
<title>VSL SKD Delete & Closing</title>
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

<input type="hidden" name="vvdList">
<input type="hidden" name="tmp_vsl_slan_cd" value="">
<input type="hidden" name="tmp_vsl_cd" value="">
<input type="hidden" name="availActivate" value="<%=availActivate %>">

<%// 화면이 Feeder 용인 경우 vsl_svc_tp_cd는 "F", 그렇지 않은 경우는 "T" 이다.%>
<input type="hidden" name="vsl_svc_tp_cd" value="">
<input type="hidden" name="slan_stnd_flg" value="Y">

<input type="hidden" name="inc_del_vsl" value="Y">

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
					<td width="100" class="stm"><input type="text" style="width:37;text-align:center;ime-mode:disabled;" class="input" value="" name="vsl_slan_cd" maxlength="3" tabindex="1">&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_search1"></td>
					<td width="80">Vessel Code</td>
					<td width="120" class="stm"><input type="text" style="width:60;text-align:center;ime-mode:disabled;" name="vsl_cd" maxlength="4" tabindex="2">&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_search2"></td>
					<td width="50">Status</td>
					<td width="90" class="stm"><select name="skd_sts_cd" style="width:60" tabindex="3">
						<option value="">All</option>
						<option value="ACT" selected>Active</option>
						<option value="RDY">Ready</option>
						<option value="CLO">Closed</option>
					</select></td>
					<td width="">
						Period&nbsp;
						<input type="text" name="fm_dt" dataformat="ymd" style="width:75;text-align:center;" class="input1" value="" maxlength="8" size="10">
						&nbsp;~&nbsp;
						<input type="text" name="to_dt" dataformat="ymd" style="width:75;text-align:center;" class="input1" value="" maxlength="8" size="10">
						<img class="cursor" name="btn_period" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
					</td>
					<td>
						<input type="radio" name="lane_tp_cd" value="" class="trans" checked="checked"> All 
						<input type="radio" name="lane_tp_cd" value="T" class="trans">Trunk 
						<input type="radio" name="lane_tp_cd" value="O" class="trans">Off-lane 
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
						<!--  Button_Sub (S) -->
			
	    	<!-- Button_Sub (E) -->
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
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
				<td class="btn1_line"></td> 
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Delete">Delete</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td> 
				
				<!--  <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_SkdHolding">SKD&nbsp;Holding</td>
					<td class="btn1_right"></td>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_SkdOpen">SKD&nbsp;Open</td>
					<td class="btn1_right"></td>
				</table></td> -->
				<% if ("Y".equals(availActivate)) {%>
				<!--Super User Or Office Code("CLTCO")일 경우만 SKD Activate 버튼 활성화됨-->
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_SkdActivate">SKD&nbsp;Activate</td>
					<td class="btn1_right"></td>
				</table></td>
				<%}%>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_BookingList">Booking&nbsp;List</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		
		</td></tr>
		</table>
	<!--Button (E) -->
</td>
</tr>
</table>
    

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>