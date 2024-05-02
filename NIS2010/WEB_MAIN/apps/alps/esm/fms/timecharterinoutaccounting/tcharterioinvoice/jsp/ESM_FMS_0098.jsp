<%
/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ESM_FMS_0098.jsp
*@FileTitle : Slip Approval
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.29
*@LastModifier : 채창호
*@LastVersion : 1.0
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
<%@ page import="com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event.EsmFms0098Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmFms0098Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지 

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String cost_ofc_cd      = "";
	String inv_sub_sys_cd = "FMS";
	Logger log = Logger.getLogger("com.hanjin.apps.TimeCharterInOutAccounting.TCharterIOConsultation");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		cost_ofc_cd = account.getOfc_cd();


		event = (EsmFms0098Event)request.getAttribute("Event");
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
<title>Slip Approval</title>
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
<input type="hidden" name="csr_no"> 
<input type="hidden" name="csr_type">
	

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
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="120">Cancellation Month</td>
					<td width="230"><input value="" type="text" style="width:80;text-align:center;" class="input1" name="from_eff_dt" fullfill maxlength="6" dataformat="ym">&nbsp;<img class="cursor" src="img/btns_calendar.gif" name="from_ef_dt" width="19" height="20" border="0" align="absmiddle">&nbsp;~&nbsp;<input value="" type="text" style="width:80;text-align:center;" class="input1" name="to_eff_dt" maxlength="6" dataformat="ym">&nbsp;<img class="cursor" src="img/btns_calendar.gif" name="to_ef_dt" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="85">Vessel Code</td>
					<td width="260"><input type="text" style="width:56;text-align:center;" class="input" maxlength="4" name="vsl_cd" style="ime-mode:disabled" fullfill caption="Vessel Code">&nbsp;<img class="cursor" src="img/btns_search.gif" name="btn_vslpop" width="19" height="20" alt="" border="0" align="absmiddle">&nbsp;<input type="text" style="width:150;" class="input2" name="vsl_eng_nm" readonly></td>
					<td width="60">Supplier</td>
					<td width="120"><input value="<%=cost_ofc_cd%>" type="text" style="width:100;text-align:center;" class="input2" name="supplier_cd" maxlength="22"  readOnly></td>
					<td width="60"></td>
					<td width=""></td>
				</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
				    <td width="59">CSR No.</td>
					<td width="150"><input value="" type="text" style="width:140;" class="input" name="origin_csr_no" maxlength="24" style="ime-mode:disabled"></td>
					<td width="120">Matching CSR No.</td>
					<td width="150"><input value="" type="text" style="width:140;" class="input" name="match_csr_no" maxlength="24" style="ime-mode:disabled"></td>
					<td width="59">Transaction</td>
					<td width="110"><select name="transact_cd" style="width:50">
							<option value="N" selected>No</option>
							<option value="Y">Yes</option>
					      </select></td>
					<td width="80">New CSR No.</td>
					<td width="150"><input value="" type="text" style="width:150;" class="input2" name="new_csr_no" maxlength="24" style="ime-mode:disabled" readOnly></td>
				</tr>
				</table>
				
				<!--  biz_1   (E) -->
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
				<!--  biz_2  (S) -->
				<!-- Grid  (S) -->
				
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t1sheet1');</script>
						</td>
					</tr>
				</table> 
			
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="160">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Approval Step</td>
						<td width="" colspan="7">
						 	<input type="text" style="width:690" class="input2" name="apro_step" readOnly value="<%=com.hanjin.bizcommon.approval.util.ApprovalUtil.getApprovalRoute(cost_ofc_cd, inv_sub_sys_cd) %>" >
							&nbsp;<img class="cursor" src="img/alps/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"  name="apro_step_btn">
						</td>
					</tr> 
				</table>
				<table width="100%">
				<tr>
						<td width="100%">&nbsp;</td>
			    </td>
			 	</table>
								
	<!-- Grid (E) -->
	<!--biz page (E)-->
	 
    <!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
       		 <table border="0" cellpadding="0" cellspacing="0"><tr>
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
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Creation</td>
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
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_excel">Down Excel</td>
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