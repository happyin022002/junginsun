<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_opf_0053.jsp
*@FileTitle : Stevedore Damage Update
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.02
*@LastModifier : 이선영
*@LastVersion : 1.0
* 2009.06.02 이선영
* 1.0 Creation
* 2010.10.26 이윤정 [CHM-201006565-01] SDMS Creation 및 inquiry &update 화면 변경
* 2012.02.03 김민아 [CHM-201215702-01] [VOP-OPF] SDMS No. 정의 및 칼럼 정리 : SDMS No. 보완 및 Report No. 제거
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.event.VopOpf0053Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.Date"%>
<%
	VopOpf0053Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.StevedoreDamageMgt.StevedoreDamageMgt");
	
	String[] arrUsrAuth = null;
	String popUpOpen	= "N";	// popUp Open 권한 체크
	int i_cnt 		= 0;
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id  =	account.getUsr_id();
		strUsr_nm  = account.getUsr_nm();

		event = (VopOpf0053Event)request.getAttribute("Event");
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
<title>Stevedore Damage Update</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<script language="javascript">
	var today = "<%=DateTime.getFormatDate(new Date(),"yyyyMMdd")%>";
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
<!-- 
<input type="hidden" name="popUpOpen" value="<%=popUpOpen %>">--><!-- popUp Open  권한 코드 -->
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
       		<tr><td class="bg" style="height:514" valign="top">
			
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="65">Vessel</td>
					<td width="130"><input type="text" style="width:70;ime-mode:disabled;" class="input" maxlength="4" name="vvd_cd">&nbsp;<img src="img/btns_search.gif" name="vvd_cd_pop" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
					<td width="80">SDMS No.</td>
					<td width="140"><input type="text" name="stv_dmg_no_prefix" maxlength="4" fullfill style="width:40;ime-mode:disabled;text-align:center;" class="input">
						 <input type="text" style="width:60;ime-mode:disabled;" maxlength="7" class="input" name="stv_dmg_no_suffix">
					</td>
					<td width="110">The Day Elapse</td>
					<td width="110"><input type="text" style="width:70;" class="input" maxlength="8" dataformat="int" name="elapse_day">
					</td>
					<td width="78">Period</td>
					<td class="sm" align="right">From&nbsp;<input type="text" style="width:80;" maxlength="8" class="input1" dataformat="ymd" name="stv_dmg_evnt_dt_from" value="2010-01-01" caption="Period From" required>&nbsp;&nbsp;~&nbsp;&nbsp;To&nbsp;<input type="text" style="width:80;" maxlength="8" class="input1" dataformat="ymd" name="stv_dmg_evnt_dt_to" value="<%=DateTime.getFormatDate(new Date(),"yyyyMMdd")%>" caption="Period To" required>&nbsp;<img src="img/btns_calendar.gif" name="cal_stv_dmg_evnt_dt_to" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				</tr> 
				</table>				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="65">Port</td>
					<td width="130"><input type="text" style="width:70;ime-mode:disabled;" class="input" maxlength="5" name="vps_port_cd">&nbsp;<img src="img/btns_search.gif" name="vps_port_cd_pop" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
					<td width="80">Lane</td>
					<td width="359"><input type="text" style="width:80;ime-mode:disabled;" class="input" maxlength="3" name="slan_cd">&nbsp;<img src="img/btns_search.gif" name="slan_cd_pop" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
					<td width="106" style="padding-left:1">Vessel Category</td>
					<td><script language="javascript">ComComboObject('vsl_type_cd',1,196,1,0,0);</script></td>
				</tr> 
				</table>				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="67">Process</td>
					<td width="568" style="padding-top:4;">
					
						<table border="0" style="width:480;" class="search_sm2"> 
							<tr height="18">
								<td width="120" align="center" valign="top">Damage</td>
								<td width="120" align="center" valign="top">Repair</td>
								<td width="120" align="center" valign="top">Compensation</td>
								<td width="120" align="center" valign="top">Settlement</td></tr>
							<tr><td align="center"><script language="javascript">ComComboObject('stv_dmg_req_cate_cd',1,100,1,0,0);</script></td>
								<td align="center"><script language="javascript">ComComboObject('stv_dmg_rpr_proc_sts_cd',1,100,1,0,0);</script></td>
								<td align="center"><script language="javascript">ComComboObject('stv_dmg_cmpn_proc_sts_cd',1,100,1,0,0);</script></td>
								<td align="center"><script language="javascript">ComComboObject('stv_dmg_stl_proc_sts_cd',1,100,1,0,0);</script></td></tr>
						</table>	
					
					</td>
					<td width="104" valign="top">Claim Amount</td>
					<td class="sm" valign="top"><input type="text" name="cmpn_cost_usd_amt" caption="Claim Amount" style="width:196;" class="input" maxlength="11" maxnum="99999999" dataformat="float" pointcount="2">&nbsp;&nbsp;(USD)</td>
				</tr> 
				</table>	
				<table class="line_bluedot"><tr><td></td></tr></table>				
				<!-- input type="text" name="noname" style="width:0;" -->
				<!--  biz_1   (E) -->
			
				
			
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
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_DownExcel">Down Excel</td>
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
       	<tr>
			<td class="btn1_bg">
			    <table border="0" cellpadding="0" cellspacing="0">
			    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
						<td class="btn1_right"></td>
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
						<tr><td class="btn1_left">
							<td class="btn1" name="btn_Open">Open</td>
							<td class="btn1_right"></tr>
						</table>
					</td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left">
							<td class="btn1" name="btn_History">History</td>
							<td class="btn1_right"></tr>
						</table>
					</td>
				</tr>
				</table>
			</td></tr>
			</table>
			<!-- Button (E) -->
	
	
	</td></tr>
		</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>