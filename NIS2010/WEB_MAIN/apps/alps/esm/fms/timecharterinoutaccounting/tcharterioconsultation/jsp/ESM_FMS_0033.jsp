<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_fms_0033.jsp
*@FileTitle : Reverse CSR for Sublet
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.08.03 최우석
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
<%@ page import="com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.event.EsmFms0033Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmFms0033Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	//int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	//String successFlag = "";
	//String codeList  = "";
	//String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	String strOfc_nm		= "";
	String cost_ofc_cd      = "";
	String inv_sub_sys_cd   = "FMS";
	
	Logger log = Logger.getLogger("com.hanjin.apps.TimeCharterInOutAccounting.tcharterioconsultation");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		strOfc_nm = account.getOfc_eng_nm();
		cost_ofc_cd = account.getOfc_cd();

		event = (EsmFms0033Event)request.getAttribute("Event");
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
<title>Reverse CSR for Sublet</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
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

<input type="hidden" name="slp_tp_cd" value="20">
<input type="hidden" name="slp_func_cd" value="T">
<input type="hidden" name="rqst_amt">
<input type="hidden" name="flet_ctrt_no">
<input type="hidden" name="search_type">
<input type="hidden" name="csr_type" value="AR">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
<tr><td>
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
					<td class="title_s">CSR Master</td></tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="">
						<table class="search_sm2" border="0" style="width:290;"> 
							<tr class="h23">
								<td width="97">&nbsp;Condition</td>
								<td width="" class="noinput1"><input type="radio" name="btn_condition" value="" class="trans" checked>Invoice No. &nbsp;&nbsp;&nbsp;<input type="radio" name="btn_condition" value="" class="trans">VVD No. </td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="100">&nbsp;&nbsp;Invoice No.</td>
					<td width="260"><input type="text" name="to_inv_no" style="width:103;text-align:center;ime-mode:disabled" class="input1" maxlength="12" value="" required fullfill caption="Invoice No.">&nbsp;<img src="img/btns_search.gif" name="btn_invNo" width="19" height="20" alt="" border="0" align="absmiddle" style="cursor:hand;"></td>
					<td width="80">VVD</td>
					<td width="100"><input type="text" style="width:100;text-align:center;ime-mode:disabled" name="vvd_cd" class="input1" maxlength="10" value="" required fullfill caption="VVD"></td>
					<td width="50">&nbsp;</td>
					<td width="64" align="left">&nbsp;&nbsp;Currency</td>
					<td align="left">&nbsp;<input type="text" name="csr_curr_cd" maxlength="3" style="width:40;text-align:center;ime-mode:disabled" class="input1" value="USD" maxlength="3" required fullfill caption="Currency"></td>
				</tr>
			</table>
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="100">&nbsp;&nbsp;Requested By</td>
					<td width="100"><input type="text" name="slp_ofc_cd" value="<%=strOfc_cd%>" style="width:60;text-align:center;" class="input2" value="" caption="Requested By" readonly></td>
					<td width="60">CSR Date</td>
					<td width="100"><input type="text" name="slp_iss_dt" style="width:80;text-align:center;" class="input2" value="" readonly caption="CSR Date"></td>
					<td width="80">Provided By</td>
					<td width="150"><input type="text" name="prov_by" value="<%=strUsr_nm%>" style="width:150;text-align:center;" class="input2" value="" caption="Provided By" readonly></td>
					<td width="60">&nbsp;&nbsp;CSR No.</td>
					<td width="">&nbsp;&nbsp;<input type="text" name="csr_no" style="width:160;" class="input2" value="" caption="CSR No." readonly></td>
				</tr>
			</table>
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="100">&nbsp;&nbsp;Eff Date</td>
					<td width=""><input type="text" name="eff_dt" maxlength="8" dataformat="ymd" required fullfill caption="Eff Date" style="width:70;ime-mode:disabled;" class="input1" value="">&nbsp;<img src="img/btns_calendar.gif" name="btn_effDt" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
				</tr>
			</table>
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="100">&nbsp;&nbsp;Description</td>
					<td width="" align="left"><input type="text" name="csr_desc" style="width:488;" class="input2" value="" caption="Description" readonly></td>
				</tr>
			<tr class="h23">
					<td width="160">&nbsp;&nbsp;Approval Step</td>
					<td width="" colspan="7"><input type="text" style="width:690" class="input2" name="apro_step" readOnly value="<%=com.hanjin.bizcommon.approval.util.ApprovalUtil.getApprovalRoute(cost_ofc_cd, inv_sub_sys_cd) %>" >&nbsp;<img class="cursor" src="img/alps/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"  name='apro_step_btn'>
					</td>
					</tr> 	
			</table>
			<!--  biz_1   (E) -->
			<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
			<!--  biz_2  (S) -->
			<table class="search" border="0">
				<tr><td class="title_h"></td>
				<td class="title_s"> Slip Detail</td></tr>
			</table>
			<!-- Grid  (S) -->
			<table width="100%"  id="mainTable" > 
				<tr>
					<td width="100%">
					<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table>
			<!-- Grid (E) -->
			<table class="line_bluedot"><tr><td colspan="6">
				</td></tr>
			</table>
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="610"></td>
					<td width="90">Total Amount</td>
					<td><input type="text" name="csr_amt" style="width:100;text-align:right;" class="tr_head3" value="0" readonly></td>
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
						<tr id="btn_retrieve"><td class="btn1_left"></td>
						<td class="btn1" name="btn_Retrieve">Retrieve</td>
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
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_slip">Slip Inquiry</td>
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

<!------- Print용 Hidden RD Object Start -------->
<table width="100%" id="rdTable"> 
	<tr>
		<td width="100%">
			<script language="javascript">comRdObject('Rd');</script>
		</td>
	</tr>
</table>
<!------- Print용 Hidden RD Object End -------->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>