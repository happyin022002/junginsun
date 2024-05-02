<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_vsk_0221.jsp
*@FileTitle : Port Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.10
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.05.12 유혁
* 1.0 Creation
*
* History
* 2011.10.10 진마리아 CHM-201112898-01 Port Code Inquiry 조회 조건 추가 - Conti, Sconti, lat, long, period 등
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.event.VopVsk0221Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk0221Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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
	   
	   
		event = (VopVsk0221Event)request.getAttribute("Event");
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
<title>Port Code Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
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
<input type="hidden" name="tmp_cnt_cd">

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
					<td width="108">Country Code</td>
					<td width="200"><input type="text" name="cnt_cd" style="width:30;text-align:Center;ime-mode:disabled" maxlength=2 class="input" tabindex='1' value="">&nbsp;<img class="cursor" src="img/btns_search.gif" name="btns_popup" id=btns_popup" width="19" height="20" border="0" align="absmiddle">&nbsp;<input type="text" name="cnt_nm" style="width:125;" class="input2" readonly></td>
					<td width="65">Port Code</td>
					<td width="105"><input type="text" name="loc_cd" maxlength=5 style="width:60;text-align:Center;ime-mode:disabled" class="input" tabindex="3"></td>
					<td width="75">Port Name</td>
					<td width="202"><input type="text" name="loc_nm" style="width:180;ime-mode:disabled" class="input" tabindex="4"></td>
					<td width=""><table border="0" style="224" class="search_sm2"> 
						<tr class="h23"><td>
						<input type="radio" value="A" class="trans" name="vsl_svc_tp_cd" tabindex="3" checked> All &nbsp;&nbsp;<input type="radio" name="vsl_svc_tp_cd" value="T" class="trans"> Trunk&nbsp;&nbsp;<input type="radio" name="vsl_svc_tp_cd" value="F" class="trans"> Feeder </td>	
						</tr>
					</table></td>
				</tr>
			</table>
			<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="70">LAT</td>
					<td width="55"><input type="text" name="fm_loc_lat" style="width:50;" dataformat="float" class="input" value="" maxlength="6" pointcount="2"></td>
					<td width="50">
						<select name="fm_lat_ut_cd" style="width:40;">
							<option></option>
							<option value="N">N</option>
							<option value="S">S</option>
						</select>
					</td> 
					<td width="20"><input type="text" style="width:10;text-align:center;background-color:#f3f2f8;border:0px" value="~" readonly tabindex="-1"></td>
					<td width="55"><input type="text" name="to_loc_lat" style="width:50;" dataformat="float" class="input" value="" maxlength="6" pointcount="2"></td>
					<td width="58">
						<select name="to_lat_ut_cd" style="width:40;">
							<option></option>
							<option value="N">N</option>
							<option value="S">S</option>
						</select>
					</td>
					
					<td width="64">Long</td>
					<td width="55"><input type="text" name="fm_loc_lon" style="width:50;" dataformat="float" class="input" value="" maxlength="6" pointcount="2"></td>
					<td width="50">
						<select name="fm_lon_ut_cd" style="width:40;">
							<option></option>
							<option value="W">W</option>
							<option value="E">E</option>
						</select>
					</td>
					<td width="20"><input type="text" style="width:10;text-align:center;background-color:#f3f2f8;border:0px" value="~" readonly tabindex="-1"></td>
					<td width="55"><input type="text" name="to_loc_lon" style="width:50;" dataformat="float" caption="999.99" class="input" value="" maxlength="6" pointcount="2"></td>
					<td width="71">
						<select name="to_lon_ut_cd" style="width:40;">
							<option></option>
							<option value="W">W</option>
							<option value="E">E</option>
						</select>
					</td>
					<td width="50">Period</td>
					<td width="240">
						<input type="text" name="fm_dt" style="width:80;text-align:center;" class="input" dataformat="ymd" caption="시작일" tabindex="4" maxlength="8" size="10" cofield="to_dt">
						<img class="cursor" name="btns_calendar_s" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
						<input type="text" style="width:15;text-align:center;background-color:#f3f2f8;border:0px" value="~" readonly tabindex="-1">
						<input type="text" name="to_dt" style="width:80;text-align:center;" class="input" dataformat="ymd" caption="종료일" tabindex="4" maxlength="8" size="10" cofield="fm_dt">
						<img class="cursor" name="btns_calendar_e" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
					</td>
					<td width="66"></td>
				</tr>
			</table>
			<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="70">VOSI RHQ</td>
					<td width="105">
						<div id="div1">
						<select name="vskd_port_rhq_cd" tabindex="2" style="width:80;"> 
							<option value="ALL">ALL</option>
						</select>
						</div>
					</td>
					<td width="65">EU Port</td>
					<td width="69">
						<select name="eu_port" style="width:50;">
							<option value="ALL">ALL</option>
							<option value="Y">Y</option>
							<option value="N">N</option>
						</select>
					</td>
					<td width="63">Conti</td>
					<td width="129">
						<div id="div1">
						<select name="conti_cd" tabindex="2" style="width:75;"> 
						</select>
						</div>
					</td>
					<td width="75">Sub Conti</td>
					<td width="162">
						<div id="div1">
						<select name="sconti_cd" tabindex="2" style="width:152;"> 
						</select>
						</div>
					</td>
					<td width="115">Monitoring Port</td>
					<td width="60">
						<select name="vop_port_mntr_flg" style="width:50;">
							<option></option>
							<option value="Y">Y</option>
							<option value="N">N</option>
						</select>
					</td>
					<td width="66"></td>
					
				</tr>
			</table>

			
			<table class="line_bluedot"><tr><td></td></tr></table>

			<!-- Grid  (S) -->
			<table width="100%" class="search"  id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table> 						
			<!-- Grid (E) -->

		</td></tr></table>
	<!--biz page (E)-->
	
	
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve" tabindex='5'>Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr></table>
				</td>
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