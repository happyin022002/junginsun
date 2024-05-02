<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0021.jsp
*@FileTitle : VSL SKD Inquiry by Port
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.16
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2009.06.25 Jung Jinwoo
* 1.0 Creation
*
* History
* 2011.04.11 진마리아 CHM-201109577-01 Delete Vessel Code에 대한 조회 로직 보완
* 2012.07.10 이혜민   CHM-201218616-01 Port SKD Inquiry 에 PFS 대비 지연 시간 컬럼 추가, short cut 기능 및 조회 기능 추가
* 2012.08.16 이혜민   CHM-201219190-01 Port SKD inquiry group registration 추가
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0021Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk0021Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.VSKCommon.VSKCodeFinder");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (VopVsk0021Event)request.getAttribute("Event");
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

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="loc_cd">
<input type="hidden" name="country_cd">
<input type="hidden" name="usr_id" value="<%=strUsr_id%>">
<input type="hidden" name="use_pgm_nm" value="VOP_VSK_0021">
<input type="hidden" name="use_pgm_desc" value="Port SKD inquiry">

<!-- <input type="hidden" name="fm_dt">
<input type="hidden" name="to_dt">  -->
<input type="hidden" name="inc_del_vsl" value="Y">
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
					<td width="350">
					<table border="0" style="width:350;"><tr class="h23">
					<td width="" align="right">
						<table border="0" style="width:150;" class="search_sm2"> 
						<tr class="h23"><td>
							<input type="radio" name="wm_cd" value="M" class="trans" checked="checked" onClick="wm_change(0);">Month 
							<input type="radio" name="wm_cd" value="W" class="trans" onClick="wm_change(1);">Week </td>	
						</tr>
						</table>
					</td>
					<td class='sm'> 
						<div id='div_month' style='display:none;border:solid 0;width:260;height:16'>
						<table><tr class="h23">
						<td width="55" align="right">Month&nbsp;</td>
						<td><input type="text" name="fm_dt" dataformat="ymd" style="width:75;text-align:center;ime-mode:disabled;" class="input1" value="" maxlength="8" size="10">&nbsp;<img class="cursor" name="btn_period1" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">&nbsp;~&nbsp;<input type="text" name="to_dt" dataformat="ymd" style="width:75;text-align:center;" class="input1" value="" maxlength="8" size="10">&nbsp;<img class="cursor" name="btn_period2" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>
						</tr></table>
						</div>
						<div id='div_week' style='display:inline;border:solid 0;width:260;height:16'>
						<table><tr class="h23">
						<td width="55" align="right">Week&nbsp;</td>
						<td><input type="text" name="fm_wk" dataformat="yw" style="width:75;text-align:center;ime-mode:disabled;" class="input1" value="" maxlength="6" size="10">&nbsp;~&nbsp;<input type="text" name="to_wk" dataformat="yw" style="width:75;text-align:center;" class="input1" value="" maxlength="6" size="10"> <!-- &nbsp;<img class="cursor" name="btn_period2" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"> --></td>
						</tr></table>
						</div>
					</tr></table>
					</td>
					<td width="75">CTRL H/Q</td>
					<td width="190"><script language="javascript">ComComboObject('vskd_port_rhq_cd',1,80,1,0);</script>&nbsp;<script language="javascript">ComComboObject('vop_port_ctrl_ofc_cd',1,90,1,0);</script></td>
					<td width="40"></td>
					<td width="55">Port</td>
					<td width="180"><input type="text" name="vps_port_cd" style="width:50;text-align:center;ime-mode:disabled;" class="input" value="" maxlength="5" onfocus="this.select();">&nbsp;<img class="cursor" name="btn_port" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">&nbsp;<script language="javascript">ComComboObject('tml_cd',2,80,1,0);</script></td>
				</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="190" align="left" >
					<table border="0" style="width:190;"><tr class="h23">
					<td width="">
						<table border="0" style="width:180;" class="search_sm2"> 
						<tr class="h23"><td><input type="radio" name="type_cd" value="" class="trans" checked="checked">All <input type="radio" name="type_cd" value="T" class="trans">Trunk <input type="radio" name="type_cd" value="O" class="trans">Feeder </td>	
						</tr>
						</table>
					</td></tr></table></td>
					<td width="170" align="left" >
					<table border="0" style="width:170;"><tr class="h23">
					<td width="">
						<table border="0" style="width:160;" class="search_sm2"> 
						<tr class="h23"><td><input type="radio" name="et_type" value="ETA" class="trans" checked="checked">ETA <input type="radio" name="et_type" value="ETB" class="trans">ETB <input type="radio" name="et_type" value="ETD" class="trans">ETD </td>	
						</tr>
						</table>
					</td></tr></table></td>
					<td width="75">Vessel Code</td>
					<td width="90"><input type="text" name="vsl_cd" style="width:35;text-align:center;ime-mode:disabled;" class="input" value="" maxlength="4" onfocus="this.select();">&nbsp;<img class="cursor" name="btn_vsl_cd" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="70">Lane Code</td>
					<td width="80"><input type="text" name="vsl_slan_cd" style="width:35;text-align:center;ime-mode:disabled;" value="" maxlength="3" onfocus="this.select();">&nbsp;<img class="cursor" name="btn_lane_cd" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="70">OPR Code</td>
					<td width="80"><input type="text" style="width:35;ime-mode:disabled;text-align:center" name="carrier_cd" class="input" maxlength="3" dataformat="engup" value="" onfocus="this.select();">&nbsp;<img src="img/btns_search.gif" name="btn_carrier_cd" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
					<td width="45">Group</td>
					<td width="80"><script language="javascript">ComComboObject('usr_def_grp_nm',1,55,1,0);</script></td>
				</tr>
				</table>
				<!--  biz_1   (E) -->
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
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
					<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table>
				</td>
				<td class="btn1_line"></td>
				<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_GroupRegister">Group Registration</td>
						<td class="btn1_right"></td>
						</tr>
					</table>
				</td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downexcel">Down Excel</td>
					<td class="btn1_right">					</td>
					</tr>
				</table>
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
