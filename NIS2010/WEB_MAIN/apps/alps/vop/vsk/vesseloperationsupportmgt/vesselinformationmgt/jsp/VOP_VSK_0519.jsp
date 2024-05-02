<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VOP_VSK_0502.js
*@FileTitle : Vessel Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.13
*@LastModifier : 임예지
*@LastVersion : 1.0
* 2014.10.13 임예지
* 1.0 Creation
* 
* History
* 2014.10.13 임예지 CHM-201430615 Vessel Particular Summary 화면 개발
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.event.VopVsk0519Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.Date" %>
<%
	VopVsk0519Event  	event 				= null;		//PDTO(Data Transfer Object including Parameters)
	Exception 			serverException   	= null;		//서버에서 발생한 에러
	String 				strErrMsg 			= "";		//에러메세지
	int 				rowCount	 		= 0;		//DB ResultSet 리스트의 건수

	String 				successFlag 		= "";
	String 				codeList  			= "";
	//String 				pageRows  			= "100";

	String 				strUsr_id			= "";
	String 				strUsr_nm			= "";
	Logger 				log 				= Logger.getLogger("com.hanjin.apps.VesselOperationSupportMgt.vesselinformationmgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (VopVsk0519Event)request.getAttribute("Event");
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
<title>VOSI Update Monitoring</title>
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

<input type="hidden" name="vsl_type2" value="">
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
		<table class="search" id="mainTable"> 
       		<tr><td class="bg" style="height:505" valign="top">	
			
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="75">Ship Type</td>
					<td width="120"><script language="javascript">ComComboObject('vsl_type', 1, 80, 1);</script></td>
					<td width="80">Vessel Code</td>
					<td width="120" class="stm"><input type="text" style="width:50;text-align:center;ime-mode:disabled;" name="vsl_cd" maxlength="4" tabindex="2" >&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_search2"></td>
					<td width="50">Period</td>
					<td width="">
						<input type="text" name="fm_date" dataformat="ymd" style="width:75;text-align:center;" value="" maxlength="8" size="10">&nbsp;~&nbsp;
						<input type="text" name="to_date" dataformat="ymd" style="width:75;text-align:center;" value="" maxlength="8" size="10">&nbsp;
						<img class="cursor" name="btn_period" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
					</td>
				</tr>  
				</table>	
				<table class="search" border="0" style="width:979;height:6;"><tr><td></td></tr></table> 
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="75">Using Type</td>
					<td width="120"><script language="javascript">ComComboObject('vsl_svc_tp_cd', 1, 80, 1);</script></td>
					<td width="80">Lane Code</td>
					<td width="120" class="stm"><input type="text" style="width:50;text-align:center;ime-mode:disabled;" class="input" value="" name="vsl_slan_cd" maxlength="3" tabindex="1">&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_search1"></td>
					<td width="52">Owner</td>					
					<td width="110"><script language="javascript">ComComboObject('vsl_own_ind_cd', 1, 80, 1);</script></td>
					<td width="80">Carrier Code</td>					
					<td width="120"><input type="text" name="crr_cd" style="width:60;text-align:center;" class="input"  style="ime-mode:disabled" maxlength="5" caption="Port Code">&nbsp;<img src="img/btns_search.gif" width="19" height="20" name="btns_search4" alt="" border="0" align="absmiddle" class="cursor"></td>
					<td width="40">Class</td>					
					<td width=""><script language="javascript">ComComboObject('cntr_vsl_clss_capa', 1, 80, 1);</script></td>
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
			<!-- <table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_Monitoring_Port">Monitoring Port</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>	
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_Excel">Down Excel</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>			
						
					</tr></table>
			</td></tr>
			</table>-->
	    	<!-- Button_Sub (E) -->
						
			</td></tr>
		</table>
		<!--biz page (E)-->




		<!-- TAB [ Gang Structure ] (E) -->
		<!-- <div id="tabLayer" style="display:none">
			<table class="search" id="mainTable"> 
       		<tr><td class="bg">			
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t10sheet1');</script>
						</td>
					</tr>
				</table>
			</td></tr>
			</table>
		</div> -->
		<!-- TAB [ Gang Structure ] (E) -->
		
			

		<!-- Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:6;,padding-bottom:0;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left">
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right">
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Excel">Download</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Viewoption">View Option</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table></td>
		</tr>
		</table></td>
		<!-- Button (E) -->
				
	</tr>
	</table>
			

	<table class="height_10"><tr><td colspan="8"></td></tr></table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>