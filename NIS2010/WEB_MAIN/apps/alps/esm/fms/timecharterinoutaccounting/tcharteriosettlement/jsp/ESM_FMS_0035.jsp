<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_FMS_0035.jsp
*@FileTitle : Prepayments Settlement
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.22
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.07.22 윤세영
* 1.0 Creation
*
* 2014.07.25 민정호 CHM-20430993 [Develop-FMS-JOO]비용 전표 상신용 Approval 구축
* 10만불 이상 금액에 대해서 CEO 결재 승인 기능 추가
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriosettlement.event.EsmFms0035Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmFms0035Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String strUsr_id			= "";
	String strUsr_nm		= "";
	String strOfc_cd			= "";
	String strOfc_nm		= "";
	String cost_ofc_cd      = "";
	String inv_sub_sys_cd = "FMS";
	
	Logger log = Logger.getLogger("com.hanjin.apps.TimeCharterInOutAccounting.TCharterIOSettlement");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		strOfc_nm = account.getOfc_eng_nm();
		cost_ofc_cd = account.getOfc_cd();

		event = (EsmFms0035Event)request.getAttribute("Event");
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
<title>Prepayments Settlement</title>
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

<input type="hidden" name="slp_tp_cd" value="07">
<input type="hidden" name="slp_func_cd" value="S">
<input type="hidden" name="slp_desc">
<input type="hidden" name="org_slip_no">
<input type="hidden" name="ctr_cd">
<input type="hidden" name="slp_loc_cd">
<input type="hidden" name="acct_cd">
<input type="hidden" name="slp_amt">
<input type="hidden" name="org_slp_tp_cd">
<input type="hidden" name="org_slp_func_cd">
<input type="hidden" name="org_slp_ofc_cd">
<input type="hidden" name="org_slp_iss_dt">
<input type="hidden" name="org_slp_ser_no">
<input type="hidden" name="org_slp_seq_no">
<input type="hidden" name="vvd_exp_dt">
<input type="hidden" name="vvd_eff_dt">
<input type="hidden" name="ppay_hir_no">
<input type="hidden" name="inv_seq">
<input type="hidden" name="aproSeqKey">
<!-- 개발자 작업	-->

<input type="hidden" name="csr_type" value="AP">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
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
					
					<td width="90">Vessel Code</td>
					<!--  2010.11.24 이상민 vsl_cd dataformat="engup" 삭제 -->
					<td width="255"><input type="text" value="" style="width:56;text-align:center;" class="input1" value="" maxlength="4" name="vsl_cd" required fullfill caption="Vessel Code" style="ime-mode:disabled">&nbsp;<img src="img/btns_search.gif" name="btn_vslpop" class="cursor" width="19" height="20" alt="" border="0" align="absmiddle">&nbsp;<input type="text" style="width:150;" class="input2" name="vsl_eng_nm" value="" readonly></td>
					<td width="79">Contract No.</td>
					<td width="195"><input type="text" value="" style="width:120;text-align:center;" name="flet_ctrt_no" required caption="Contract No." readonly class="input1" value="">&nbsp;<img src="img/btns_search.gif" name="btn_ctrtpop" class="cursor" width="19" height="20" alt="" border="0" align="absmiddle"></td>
					<td width="90">Contract Type </td>
					<td width="85"><input type="text" style="width:80;" class="input2" value="" name="flet_ctrt_tp_cd" alt="" border="0" align="absmiddle" readonly></td>
					<td width="60">Currency</td>
					<td width=""><input type="text" name="csr_curr_cd" value="USD" style="width:56;text-align:center;ime-mode:disabled" class="input1" maxlength="3"dataformat="engup"  required fullfill caption="Currency"></td>
				</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					
					<td width="90">Requested by</td>
					<td width="85"><input type="text" name="slp_ofc_cd" value="<%=strOfc_cd%>" style="width:55;text-align:center;" class="input2" readonly></td>
					<td width="60">CSR Date</td>
					<td width="110"><input type="text" value="" name="slp_iss_dt" style="width:80;text-align:center;" class="input2" readonly></td>
					<td width="78">Provided By </td>
					<td width="197"><input type="text" value="<%=strUsr_nm%>" name="prov_by" style="width:150;text-align:center;" class="input2" readonly></td>
					<td width="90">CSR No.</td>
					<td width=""><input type="text" style="width:201;" class="input2" value="" name="csr_no" readonly></td>
				</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					
					<td width="90">Description</td>
					<td width="530"><input type="text" style="width:483;" class="input1" value="" name="csr_desc" maxlength="100"></td>
					<td width="90">Effective Date</td>
					<td width=""><input type="text" style="width:80;text-align:center;ime-mode:disabled;" class="input1" value="" name="eff_dt" maxlength="8" dataformat="ymd" required fullfill caption="Effective Date">&nbsp;<img class="cursor" name="eff_dt_cal" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>
				</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">					
					<td width="90">Owner Code</td>
					<td width=""><input type="text" style="width:78;" class="input2" value="" name="vndr_seq" readonly>&nbsp;<input type="text" style="width:401;" class="input2" value="" name="vndr_nm" readonly></td>
				</tr>
				<tr class="h23">
					<td width="160">Approval Step</td>
					<td width="" colspan="7"><input type="text" style="width:690" class="input2" name="apro_step" readOnly value="<%=com.hanjin.bizcommon.approval.util.ApprovalUtil.getApprovalRoute(cost_ofc_cd, inv_sub_sys_cd) %>" >&nbsp;<img class="cursor" src="img/alps/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"  name='apro_step_btn'>
					</td>
					</tr> 
				</table>			
				<!--  biz_1   (E) -->
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
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
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td align="right">Total Amount&nbsp;<input type="text" style="width:50;text-align:center" class="tr_head3" value="DR">&nbsp;<input type="text" name="dr_amt" style="width:100;text-align:right;" class="tr_head3" value="0">&nbsp;&nbsp;<input type="text" style="width:50;text-align:center" class="tr_head3" value="CR">&nbsp;<input type="text" name="cr_amt" style="width:100;text-align:right;" class="tr_head3" value="0"></td>
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
					<td class="btn1" name="btn_retrieve">Prepayment Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_slipInquiry">Slip Inquiry</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_print">Print</td>
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