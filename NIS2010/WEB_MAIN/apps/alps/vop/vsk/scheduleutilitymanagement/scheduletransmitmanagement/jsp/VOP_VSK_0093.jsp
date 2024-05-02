<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0093.js
*@FileTitle : Auto TLX/FAX vs Actual arrival monitoring
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.05
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.12.05 진마리아
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.scheduletransmitmanagement.event.VopVsk0093Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk0093Event event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
//	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.scheduleutilitymanagement.scheduletransmitmanagement");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (VopVsk0093Event)request.getAttribute("Event");
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
<title>Auto TLX/FAX vs Actual arrival monitoring</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">

    function setupPage(){  

	    loadPage();
    }

</script>
</head>

<body  onLoad="setupPage();"> 

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="country_cd">
<input type="hidden" name="pagerows" value="500">
<input type="hidden" name="page_no" value="1">
<input type="hidden" name="trsm_purp_cd" value="STW">

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
					<td width="35">ETA</td>
					<td width="230">
						<input type="text" name="fm_eta_dt" dataformat="ymd" style="width:75;text-align:center;" class="input1" value="" maxlength="8" size="10">
						&nbsp;~&nbsp;
						<input type="text" name="to_eta_dt" dataformat="ymd" style="width:75;text-align:center;" class="input1" value="" maxlength="8" size="10">&nbsp;
						<img class="cursor" name="btn_period" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
					</td>
					<td width="70">CTRL H/Q</td>
					<td width="200"><script language="javascript">ComComboObject('vskd_port_rhq_cd',1,80,1,0);</script>&nbsp;<script language="javascript">ComComboObject('vop_port_ctrl_ofc_cd',1,90,1,0);</script></td>
					<td width="35">Port</td>
					<td width="190"><input type="text" name="vps_port_cd" style="width:50;text-align:center;ime-mode:disabled;" class="input" value="" maxlength="5" onfocus="this.select();">&nbsp;<img class="cursor" name="btn_vps_port_cd" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">&nbsp;<script language="javascript">ComComboObject('tml_cd',2,80,1,0);</script></td>
					<td width="85">Last Sending</td>
					<td width="129"><input name="lst_flg" style="border:none;" type="checkbox" value="Y"></td>
				</tr>
				</table>
				
				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="70">Lane Code</td>
					<td width="114"><input type="text" style="width:50;ime-mode:disabled;text-align:center" class="input" name="slan_cd" value="" maxlength="3" tabindex="1">&nbsp;<img class="cursor" src="img/btns_search.gif" name="btn_slan_cd" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="35">VVD</td>   
					<td width="166"><input type="text" name="vsl_cd" style="width:40;text-align:center;ime-mode:disabled;" maxlength="4" onfocus="this.select();">&nbsp;<input type="text" name="skd_voy_no" style="width:40;text-align:center;ime-mode:disabled;" maxlength="4" onfocus="this.select();">&nbsp;<input type="text" name="skd_dir_cd" style="width:25;text-align:center;ime-mode:disabled;" maxlength="1" onfocus="this.select();">&nbsp;<img class="cursor" name="btn_vvd_search" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="35">OPR</td>
					<td width="90"><input type="text" style="width:40;ime-mode:disabled;text-align:center" class="input2" name="act_crr_cd" value="SML" maxlength="3" tabindex="1" readonly></td>
					<td width="62">Send via</td>
					<td width="80">
						<select name="trsm_mzd_cd" style="width:60;" class="input">
						<option value="" selected>ALL</option>
						<option value="TLX">TELEX</option>
						<option value="FAX">FAX</option>
						</select>
					</td>
					<td width="332"></td>
				</tr>
				</table>
				
				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="100">Difference over </td>
					<td width="39"><input type="text" style="width:30;ime-mode:disabled;text-align:center" class="input" name="dif_over_arr_dt" value="" tabindex="1"></td>
					<td width="350">hours (Actual Berthing - TLX Notice) </td>
					<td width="490"></td>
				</tr>
				</table>

				<!--  biz_1   (E) -->
				<table class="line_bluedot"><tr><td></td></tr></table>
				<!--  biz_2  (S) -->
				
				<!-- Grid  (S) -->
					<table width="100%" id="mainTable"> 
						<tr>
							<td width="100%">
								<!--시트-->
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table> 
				<!-- Grid (E) -->
						
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
					<td class="btn1" name="btn_New" id="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DownExcel" id="btn_DownExcel">Down Excel</td>
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

</form>			
</body>
</html>