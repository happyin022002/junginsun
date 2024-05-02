<%
/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CPS_GEM_0033.jsp
*@FileTitle : Consultation Slip
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.17
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.17 
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
<%@ page import="com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.event.CpsGem0033Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	CpsGem0033Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String ofc_cd ="";
	String usrAuthTpCd = "";
	String csr_no = JSPUtil.getParameter(request,"subs_csr_no".trim(),"");
	Logger log = Logger.getLogger("com.hanjin.apps.GEMConsultationSlip.GEMConsultationSlip");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
        ofc_cd    = account.getOfc_cd();
        usrAuthTpCd = account.getUsr_auth_tp_cd();
        
		event = (CpsGem0033Event)request.getAttribute("Event");
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
<title>Consultation Slip</title>
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
<input type="hidden" name="ofc_cd" value="<%=ofc_cd%>">
<input type="hidden" name="usd_locl_xch_rt">
<input type="hidden" name="usr_auth_tp_cd" value="<%=usrAuthTpCd%>">
<input type="hidden" name="auth_flg">
<input type="hidden" name="subs_ofc_cd">
<input type="hidden" name="hpln_yr">
<input type="hidden" name="hpln_mon">
<input type="hidden" name="save_flg">
<input type="hidden" name="expense_text">
<input type="hidden" name="csrNo" value= "<%=csr_no%>">
<!-- 개발자 작업	-->

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>

		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
     		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->

		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
				<tr><td class="btn1_bg">

						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_new">New</td><td class="btn1_right"></td></tr></table></td>
							
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_save" id="btn_save">Save</td><td class="btn1_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_gw" id="btn_gw">Submit to GW</td><td class="btn1_right"></td></tr></table>
								</td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_cancel" id="btn_cancel">Delete</td><td class="btn1_right"></td></tr></table>
								</td>
							<!-- Repeat Pattern -->

						</tr></table>

				</td></tr>
		</table>
    	<!-- TABLE '#D' : ( Button : Main ) (E) -->

	 	<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<!-- : ( Year ) (S) -->
				<table class="search_in" border="0">
				<tr class="h23">
					<td width="80">Input date</td>
					<td width="150">
						<input type="text" style="width:70;ime-mode:disabled;" name="inp_dt" class="input1" value="" maxlength="10">
					</td>
					<td width="80">Invoice Date</td>
					<td width="150">
						<input type="text" style="width:70;ime-mode:disabled" name="inv_dt" class="input1" maxlength="12" dataformat="ymd"> <img class="cursor" name="btns_calendar1" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" >
					</td>
					<td width="100"> Date</td>
					<td width="100">
						<input type="text" style="width:80;ime-mode:disabled;" name="apro_dt" value="" maxlength="12" onKeyPress="ComKeyOnlyAlphabet('upper');">
					</td>
					<td width="80">CSR No</td>
					<td width="">
						<input type="text" style="width:120;ime-mode:disabled;" name="subs_csr_no" value="" maxlength="50">&nbsp;<img src="img/btns_search.gif" name="btns_popup" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
					</td>
				</tr>
				<tr class="h23">
					<td >Pay To</td>
					<td colspan="3">
						<input name="pay_vndr_nm" type="text" style="width:250;text-align:left;" class="input1" value=""  required>
					</td>
				
					<td>INV Currency</td>
					<td>
					<script language="javascript" >ComComboObject('inv_curr_cd', 1, 80, 1 ,1);</script>
					</td>
					<td>INV Amount</td>
					<td>
						<input type="text" style="width:80;ime-mode:disabled;" name="inv_locl_ttl_amt" value="" class="input1"  dataformat="float" maxlength="12">
					</td>
				</tr>
				<tr class="h23">
					<td>Type</td>
					   <td colspan="3"><input type="radio" value="S" name="expn_div_cd" onclick="onChagnetypeCd()" class="trans"  checked>Salary&Allowance
                                &nbsp;<input type="radio" name="expn_div_cd" value="W" onclick="onChagnetypeCd()" class="trans">Welfare
                                &nbsp;<input type="radio" name="expn_div_cd" value="E" onclick="onChagnetypeCd()" class="trans">Enterainment
                                &nbsp;<input type="radio" name="expn_div_cd" value="M" onclick="onChagnetypeCd()"  class="trans">Management&Other
                                </td>
					<td>Status</td>					
					<td>
						<input type="text" style="width:80;ime-mode:disabled;" name="apro_rslt_cd" value="">
					</td>
					<td>USD Amount</td>					
					<td>
						<input type="text" style="width:80;ime-mode:disabled;" name="inv_usd_ttl_amt" value="">
					</td>
				</tr>
				</table>
				<!-- : ( Year ) (E) -->
			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->
		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

			<!-- : ( grid ) (S) -->
			<table  border="0" class="search">
				<tr><td>
					<table width="100%" id="mainTable">
						<tr><td>
							 <script language="javascript">ComSheetObject('sheet1');</script>
						</td></tr>
					</table>
				</td></tr>
			</table>
			<!-- : ( grid ) (E) -->
					 <!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="Row_Add">Row Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="Delete">Row Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td></tr>
						
				</table>
			</td></tr>
			</table>
			</td></tr>
			
		</table>
		
		<!-- TABLE '#D' : ( Search Options ) (E) -->
</td></tr>
</table>
<!-- Outer Table (E)-->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>