<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CPS_CNI_0302.jsp
*@FileTitle : Status
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
<%@ page import="com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.event.CpsCni0302Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	CpsCni0302Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.DryWetClaim.DryWetClaim");
	String strTodate        = DateTime.getDateString().substring(0,4)+"-"+DateTime.getDateString().substring(5,7)+"-"+DateTime.getDateString().substring(8,10);

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (CpsCni0302Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		//GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>DW Claim Main</title>
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
<input type="hidden" name="dw_clm_tp_cd">
<input type="hidden" name="dw_clm_sts_cd">
<input type="hidden" name="inci_plc_tp_cd">
<input type="hidden" name="dw_co_cd">
<input type="hidden" name="dw_clm_att_def_tp_cd">
<input type="hidden" name="date_type">

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
				<td width="62">Period</td>
				<td width="70"><script language="javascript">ComComboObject("combo_date_type", 2, 65, 1, 1, 0, true);</script></td>
				<td width="246"><input type="text" name="from_dt" style="width:75;ime-mode:disabled;text-align:center" required maxlength="8" dataformat="ymd" fullfill value="<%=strTodate.substring(0,4)+"-01-01"			%>" class="input1" caption="Period(From Date)">&nbsp;<img src="img/btns_calendar.gif" name="cal_from_dt" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">&nbsp;~&nbsp;<input type="text" name="to_dt" style="width:75;ime-mode:disabled;text-align:center" required maxlength="8" dataformat="ymd" fullfill value="<%=strTodate%>" class="input1" caption="Period(To Date)">&nbsp;<img src="img/btns_calendar.gif" name="cal_to_dt" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
				<td width="30" title="Type of Case">TOC</td>
				<td width="95"><script language="javascript">ComComboObject("combo_dw_clm_tp_cd", 2, 70, 1, 0, 0, true);</script></td>
				<td width="47">Status </td>
				<td width=""><script language="javascript">ComComboObject("combo_dw_clm_sts_cd", 2, 110, 1, 0, 1, true);</script></td>
				<td width="30" title="Type of Handling">TOH</td>
				<td width="92"><script language="javascript">ComComboObject("combo_dw_clm_att_def_tp_cd", 2, 70, 1, 0, 0, true);</script></td>
				<td width="62">Company</td>
				<td width="90"><script language="javascript">ComComboObject("combo_dw_co_cd", 2, 73, 1, 0, 0, true);</script></td>
				</tr>
			</table> 
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="60">Case No.</td>
				<td width="98"><input type="text" name="dw_clm_no" style="width:90;" maxlength="11" dataformat="eng" fullfill caption="Case No." style="ime-mode:disabled" value=""></td>
				<td width="33">HOFC</td>
				<td width="94"><input type="text" name="hdlr_ofc_cd" style="width:88;ime-mode:disabled" value="" maxlength="6" caption="HOFC"></td>
				<td width="48">Handler</td>
				<td width="120"><input type="text" name="hdlr_usr_id" style="width:90;ime-mode:disabled" value="" maxlength="20" caption="Handler">&nbsp;<img src="img/btns_search.gif" name="pop_hdlr_usr_id" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
				<td width="55">R. Office </td>
				<td width=""><input type="text" name="cre_ofc_cd" style="width:75;ime-mode:disabled" value="" maxlength="6" dataformat="eng" caption="R. Office">&nbsp;<img src="img/btns_search.gif" name="pop_cre_ofc_cd" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
				<td width="70">R. Handler</td>
				<td width="120"><input type="text" name="cre_usr_id" style="width:90;ime-mode:disabled" value="" maxlength="20" caption="R. Handler">&nbsp;<img src="img/btns_search.gif" name="pop_cre_usr_id" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
				<td width="48">Insurer</td>
				<td width="137"><input type="hidden" name="insur_clm_pty_no">
				<input type="text" name="insur_clm_pty_nm" dataformat="eng" style="width:107;" value="">&nbsp;<img src="img/btns_search.gif" name="pop_insur_clm_pty_nm" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
				</tr>
				</table> 
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="60">Vessel</td>
				<td width=""><input type="text" name="dw_clm_ref_vvd_no" style="width:90;text-align:center;" class="input" value="" maxlength="10" dataformat="eng" caption="VVD" style="ime-mode:disabled">&nbsp;<img src="img/btns_search.gif" name="pop_dw_clm_ref_vvd_no" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
				<input type="text" name="vsl_eng_nm" style="width:201;" class="input" value="" maxlength="50" caption="VVD Name" style="ime-mode:disabled"></td>
				<td width="25" title="Place of Incident">POI</td>
				<td width="141"><script language="javascript">ComComboObject("combo_inci_plc_tp_cd", 2, 98, 1, 0, 0, true);</script></td>
				<td width="78">Liable Party</td>
				<td width="320"><input type="hidden" name="labl_pty_clm_pty_no">
				<input type="text" name="labl_pty_clm_pty_nm" dataformat="eng" style="width:280;" value="">&nbsp;<img src="img/btns_search.gif" name="pop_labl_pty_clm_pty_nm" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
			</tr>
			<tr class="h23">
				<td>Claimant </td>
				<td colspan="3"><input type="hidden" name="clmt_clm_pty_no"></div>
				<input type="text" name="clmt_clm_pty_nm" dataformat="eng" style="width:295;" value="">&nbsp;<img src="img/btns_search.gif" name="pop_clmt_clm_pty_nm" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
				<td>Defendant</td>
				<td><input type="hidden" name="deft_clm_pty_no">
				<input type="text" name="deft_clm_pty_nm" dataformat="eng" style="width:280;" value="">&nbsp;<img src="img/btns_search.gif" name="pop_deft_clm_pty_nm" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
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
					<td class="btn1" name="btn_DownExcel">Down Excel</td>
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