<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0024.jsp
*@FileTitle : Canal Transit List
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.09
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2009.09.09 유혁
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
<%@ page import="com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0024Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk0024Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	Logger log = Logger.getLogger("com.hanjin.apps.scheduleplanningoperation.vesselschedulemgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);

		event = (VopVsk0024Event)request.getAttribute("Event");
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
<title>Canal Transit List</title>
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

<input type="hidden" name="start_date">
<input type="hidden" name="end_date">
<input type="hidden" name="bkg_sts">
<input type="hidden" name="yd_cd">
<input type="hidden" name="vsl_cd">
<input type="hidden" name="skd_voy_no">
<input type="hidden" name="skd_dir_cd">
<input type="hidden" name="scg_car_tier">
<input type="hidden" name="vps_etb_dt"> 
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
				<!--  biz_1  (S) -->
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="40">Month </td>
					<!-- 
					<td width="230"><input name="start_date" type="text" caption="시작일" dataformat="ymd" style="width:80;text-align:center;" class="input1" maxlength="8" size="10" cofield="end_date"><input type="text" style="width:15;text-align:center;background-color:#f3f2f8;border:0px" value="~" readonly tabindex="-1">
						<input name="end_date" type="text" caption="종료일" dataformat="ymd" style="width:80;text-align:center;" class="input1" maxlength="8" size="10" cofield="start_date">&nbsp;<img src="img/btns_calendar.gif" name="btn_cal" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
					 -->
					 <td width="100">
					 	<input name="start_month" type="text" dataformat="ym" style="width:60;text-align:center;" class="input1" maxlength="6" size="7">&nbsp;<img src="img/btns_calendar.gif" name="btn_cal1" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
					 	<!--input type="text" style="width:15;text-align:center;background-color:#f3f2f8;border:0px" value="~" readonly tabindex="-1"-->
					 	<input name="end_month" type="hidden"> <!--&nbsp;<img src="img/btns_calendar.gif" name="btn_cal2" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"-->
					 </td>
					<td width="30">Port</td>   
					<td width="100"><select name="port_cd" style="width:70;" class="input1">
						<option value="EGSUZ">EGSUZ</option>
						<option value="PAPAC">PAPAC</option></select></td>
					<td width="70">Lane Code</td>   
					<td width="90"><input type="text" name="vsl_slan_cd" style="width:40;text-align:center;ime-mode:disabled" class="input">&nbsp;<img class="cursor" src="img/btns_search.gif" name="btns_search" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="140">Canal Service Provider</td>
					<td width="">&nbsp;<script language="javascript">ComComboObject('vndr_seq',1,80,1);</script></td>
						 
					<!--td width="100">Limit Surcharge</td>   
					<td width=""><select style="width:40;" name="surcharge" class="input">
						<option></option>
						<option value="Y">Y</option>
						<option value="N">N</option></select></td-->
				
				</tr>
				</table>
				
			<table class="line_bluedot"><tr><td></td></tr></table>
     	
				<!--  grid  (S) -->
				
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>				
				
				<!--  grid   (E) -->
			
				<!--biz page (E)-->
	</td>
			</tr>
			</table>
	
	
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
		    	<td>
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" id="btn_Retrieve" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td>
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" id="btn_Save" name="btn_Save">Save</td>
					<td class="btn1_right"></td></tr>
				</table></td>
				<td class="btn1_line"></td>
				<td>
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_S/PRegistration">S/P Registration</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td>
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_TLCreation">T/L Creation</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<!--  td>
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_TBCreation">T/B Creation</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td-->
				</tr>
			</table>
		</td></tr>
		</table>	
    <!--Button (E) -->
	</td></tr>
</table>
</form>
</body>
</html>
