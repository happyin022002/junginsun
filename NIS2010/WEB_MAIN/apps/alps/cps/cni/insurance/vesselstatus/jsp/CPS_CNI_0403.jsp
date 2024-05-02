<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CPS_CNI_0403.jsp
*@FileTitle : Vessel Entry Status
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.10.12 윤세영
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.cps.cni.insurance.vesselstatus.event.CpsCni0403Event"%>
<%@ page import="com.hanjin.apps.alps.cps.cni.common.CniUtil"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	CpsCni0403Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.Insurance.DryWetClaim");
	String strTodate        = DateTime.getDateString().substring(0,4)+"-"+DateTime.getDateString().substring(5,7)+"-"+DateTime.getDateString().substring(8,10);
	SignOnUserAccount account = null;

	try {
	   	account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (CpsCni0403Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		//GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
	
    // 사용자 roles
    String roles = CniUtil.getRoles(account);
    String area =  CniUtil.getAreaInfo(account);
    String ofcCd = account.getOfc_cd(); 
    
    //roles = "CNI52";	
%>
<html>
<head>
<title>Vessel Entry Status</title>
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
<input type="hidden" name="usr_id"				value="<%=strUsr_id			%>" >
<input type="hidden" name="insur_period">
<input type="hidden" name="insur_tp_cd">
<input type="hidden" name="insur_cvrg_cd">
<input type="hidden" name="insur_vsl_tp_cd">
<input type="hidden" name="insur_vsl_oshp_cd">

<input type="hidden" name="com_mrdPath">
<input type="hidden" name="com_mrdArguments">
<input type="hidden" name="com_mrdTitle" value="">
<input type="hidden" name="com_mrdBodyTitle" value="Entry Status">
<input type="hidden" name="com_mrdDisableToolbar">

<input type="hidden" name="usr_roles" value="<%=roles%>">
<input type="hidden" name="usr_area" value="<%=area%>">
<input type="hidden" name="usr_office" value="<%=ofcCd%>">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	
		<!--Page Title, Historical (S)-->
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
        </table>
		<!--Page Title, Historical (E)-->
	
	
		<!--Button (S) -->
		
    	<!--Button (E) -->
		
		<!--biz page (S)-->
		
<table class="search" id="mainTable"> 
			
    <tr><td class="bg">	
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="50">Period</td>
				<td width="330"><script language="javascript">ComComboObject("combo_insur_period", 2, 90, 1, 1, 0, true);</script>
						&nbsp;<input type="text" name="insur_eff_dt" class="input1" style="width:75;text-align:center;ime-mode:disabled;" maxlength="8" dataformat="ymd" fullfill value="<%=strTodate.substring(0,4)+"-01-01"			%>" caption="Period(From)">&nbsp;<img name="cal_insur_eff_dt" src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"> ~&nbsp;<input name="insur_exp_dt" class="input1" type="text" style="width:75;text-align:center;ime-mode:disabled;" maxlength="8" dataformat="ymd" fullfill value="<%=strTodate%>" caption="Period(To)">&nbsp;<img name="cal_insur_exp_dt" src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
				<td width="42">TOI</td>
				<td width="88"><script language="javascript">ComComboObject("combo_insur_tp_cd", 2, 60, 1, 0, 0, true);</script></option>
						</select></td>
				<td width="135">Coverage&nbsp;</td>
				<td width="100"><script language="javascript">ComComboObject("combo_insur_cvrg_cd", 2, 60, 1, 0, 0, true);</script></td>
				<td width="61">Insurer</td><input type="hidden" name="insur_clm_pty_no">
				<td width=""><input type="text" name="insur_clm_pty_nm" style="width:133;" value="" dataformat="eng" class="input">&nbsp;<img name="pop_insur_clm_pty_nm" src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
			</tr>
			</table> 
			
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="95">Name of Vessel</td>
				<td width="285"><input type="text" name="vsl_eng_nm" style="width:263;" maxlength="50" caption="Name of Vessel" style="ime-mode:disabled" class="input"></td>
				<td width="40">Code</td>
				<td width="90"><input type="text" name="vsl_cd" style="width:60;text-align:center;" maxlength="4" dataformat="engup" caption="Code of Vessel" style="ime-mode:disabled" value="" class="input"></td>
				<td width="135">Type of Vessel(TOV)</td>
				<td width="100"><script language="javascript">ComComboObject("combo_insur_vsl_tp_cd", 2, 60, 1, 0, 0, true);</script></option>
						</select></td>
				<td width="160">Type of Ownership(TOO)</td>
				<td width=""><script language="javascript">ComComboObject("combo_insur_vsl_oshp_cd", 2, 60, 1, 0, 0, true);</script></td>
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
		
		<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Row_Add">Row&nbsp;Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Row_Insert">Row Insert</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Row_Copy">Row Copy</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Row_Delete">Row&nbsp;Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_DownExcel">Down Excel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_LoadExcel">Load Excel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
	</td>
	</tr></table> 
		
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
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Print">Print</td>
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