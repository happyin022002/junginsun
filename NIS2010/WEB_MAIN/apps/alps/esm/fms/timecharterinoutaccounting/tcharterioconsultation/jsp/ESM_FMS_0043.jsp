<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_FMS_0043.jsp
*@FileTitle : Slip Correction - Master
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.07
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.08.07 정윤태
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
<%@ page import="com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.event.EsmFms0043Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmFms0043Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmFms0043Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

	}catch(Exception e) {
		log.error(e.getMessage(),e);
	}
%>

<html>
<head>
<title>Slip Correction - Master</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<body  onLoad="setupPage();"> 

<form name="form"> 
<input type="hidden" name="f_cmd">
<input type="hidden" name="usr_id" value="<%=strUsr_id%>">
<input type="hidden" name="slip_apro_flg" value="N">
						   
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;<span id="title"></span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->
	
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Slip Correction Head</td></tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="320">
					<table class="search_sm2" border="0" style="width:270;"> 
							<tr class="h23">
								<td width="84">&nbsp;Condition</td>
								<td width="" class="noinput1"><input type="radio" value="E" class="trans" name="condition" checked>Effective &nbsp;&nbsp;&nbsp;<input type="radio" value="C" name="condition" class="trans">CSR Date </td>
							</tr>
						</table>
					</td>
					<td width="90">Effective Date </td>
					<td width="280"><input type="text" style="width:80;text-align:center;" class="input1" name="from_eff_dt" maxlength="8" dataformat="ymd">&nbsp;<img class="cursor" src="img/btns_calendar.gif" name="from_ef_dt" width="19" height="20" border="0" align="absmiddle">&nbsp;~&nbsp;<input type="text" style="width:80;text-align:center;" class="input1" name="to_eff_dt" maxlength="8" dataformat="ymd">&nbsp;<img class="cursor" src="img/btns_calendar.gif" name="to_ef_dt" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="60">CSR Date</td>
					<td width="260"><input type="text" style="width:80;text-align:center;" class="input2" name="from_cre_dt" maxlength="8" dataformat="ymd">&nbsp;<img class="cursor" src="img/btns_calendar.gif" name="from_cr_dt" width="19" height="20" border="0" align="absmiddle">&nbsp;~&nbsp;<input type="text" style="width:80;text-align:center;" class="input2" name="to_cre_dt" maxlength="8" dataformat="ymd">&nbsp;<img class="cursor" src="img/btns_calendar.gif" name="to_cr_dt" width="19" height="20" border="0" align="absmiddle"></td>
				</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="85">Vessel Code</td>
					<td width="260"><input type="text" style="width:56;text-align:center;" class="input" maxlength="4" name="vsl_cd" style="ime-mode:disabled">&nbsp;<img class="cursor" src="img/btns_search.gif" name="btn_vslpop" width="19" height="20" alt="" border="0" align="absmiddle">&nbsp;<input type="text" style="width:150;" class="input2" name="vsl_eng_nm" readonly></td>
					<td width="59">CSR No.</td>
					<td width=""><input type="text" style="width:224;" class="input" name="csr_no" maxlength="22" style="ime-mode:disabled"></td>
				</tr>
				</table>
				
				<!--  biz_1   (E) -->
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
				<!--  biz_2  (S) -->
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s"> Correction Result List</td></tr>
				</table>
				<!-- Grid  (S) -->
				
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table> 				

						<!-- Grid (E) -->
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			
			<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">  CSR Head Information</td></tr>
				</table>
			
			
			
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="90">Request Term </td>
					<td width="180"><input type="text" style="width:120;text-align:center;" class="input2" name="request_team" readonly></td>
					<td width="90">CSR Date</td>
					<td width="200"><input type="text" style="width:80;text-align:center;" class="input2" name="csr_dt" readonly></td>
					<td width="90">Request Date</td>
					<td width=""><input type="text" style="width:80;text-align:center;" class="input2" name="rqst_dt" readonly></td>
				</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="90">Produced By  </td>
					<td width="180"><input type="text" style="width:120;text-align:center;" class="input2" name="produced_by" readonly></td>
					<td width="90">CSR Desc</td>
					<td width=""><input type="text" style="width:370;" class="input" name="csr_desc"></td>
				</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="90">Owner Code</td>
					<td width="180"><input type="text" style="width:120;text-align:center;" class="input2" name="ownr_cd" readonly></td>
					<td width="90">Owner Name</td>
					<td width=""><input type="text" style="width:370;" class="input2" name="ownr_nm" readonly></td>
				</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="90">Currency </td>
					<td width="180"><input type="text" style="width:120;text-align:center;" class="input2" name="csr_curr_cd" readonly></td>
					<td width="90">CSR Amount</td>
					<td width="150"><input type="text" style="width:130;text-align:right" class="input2" name="csr_amt" readonly></td>
					<td width="90">Evidence Type</td>
					<td width=""><input type="text" style="width:130;text-align:center;" class="input2" name="evid_tp" readonly></td>
				</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="270"> 
						<table class="search_sm2" border="0" style="width:213;"> 
							<tr class="h23">
								<td width="80">Deduction</td>
								<td width="" class="stm"><input type="radio" class="trans" name="deduction" disabled>Yes &nbsp;&nbsp;&nbsp;<input type="radio" class="trans" name="deduction" disabled>No </td>
							</tr>
						</table>
					
					</td>
					<td width="90">RQST Amount</td>
					<td width="150"><input type="text" style="width:130;text-align:right" class="input2" name="rqst_amt" readonly></td>
					<td width="90">Deducted Amt</td>
					<td width=""><input type="text" style="width:130;text-align:right" class="input2" name="diff_desc" readonly></td>
				</tr>
				</table>
				<table style="height:2;"><tr><td colspan="8"></td></tr></table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="270"> 
						<table class="search_sm2" border="0" style="width:213;"> 
							<tr class="h23">
								<td width="80">Cancel MK</td>
								<td width="" class="stm"><input type="radio" class="trans" name="cxl_flg" disabled>Yes &nbsp;&nbsp;&nbsp;<input type="radio" class="trans" name="cxl_flg" disabled>No </td>
							</tr>
						</table>
					
					</td>
					<td width="90">Cancel Remark</td>
					<td width=""><input type="text" style="width:370;" class="input2" name="cxl_desc" readonly><input type="hidden" name="slp_no"><input type="hidden" name="vsl_code"><input type="hidden" name="vsl_eng_name"><input type="hidden" name="sel_row"></td>
				</tr>
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
					<td class="btn1" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_slip">Slip Detail</td>
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