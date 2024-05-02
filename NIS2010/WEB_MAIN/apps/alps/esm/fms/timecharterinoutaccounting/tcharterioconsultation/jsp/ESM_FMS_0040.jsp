<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_fms_0040.jsp
*@FileTitle : Manual Slip
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.08.17 최우석
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
<%@ page import="com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.event.EsmFms0040Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmFms0040Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	//int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	//String successFlag = "";
	//String codeList  = "";
	//String pageRows  = "100";

	String strUsr_id			= "";
	String strUsr_nm		= "";
	String strOfc_cd			= "";
	String strOfc_nm		= "";
	String inv_sub_sys_cd = "FMS";
	String cost_ofc_cd      = "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.TimeCharterInOutAccounting.tcharterioconsultation");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		strOfc_nm = account.getOfc_eng_nm();
		cost_ofc_cd = account.getOfc_cd();

		event = (EsmFms0040Event)request.getAttribute("Event");
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
<title>Manual Slip</title>
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

<input type="hidden" name="slp_tp_cd" value="07">
<input type="hidden" name="csr_amt">
<input type="hidden" name="rqst_amt">
<input type="hidden" name="csr_type" value="AP">
<input type="hidden" name="evid_tp_cd_val">
<!-- 2010.01.27 Approval Step -->
<input type="hidden"   name="aproSeqKey">
<!-- Report Designer 에 필요한 Input Box -->
<input type="hidden"   name="com_mrdPath" value="">
<input type="hidden"   name="com_mrdArguments" value="">
<input type="hidden"   name="com_mrdTitle" value="Manual Slip">
<input type="hidden"   name="com_mrdBodyTitle" value="Manual Slip">

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
				<td width="90">Requested By</td>
				<td width="90">&nbsp;<input type="text" name="slp_ofc_cd" value="<%=strOfc_cd%>" style="width:60;text-align:center;" class="input2" value="" caption="Requested By" readonly></td>
				<td width="60">CSR Date</td>
				<td width="100"><input type="text" name="slp_iss_dt" style="width:80;text-align:center;" class="input2" value="" readonly caption="CSR Date"></td>
				<td width="80">Provided By</td>
				<td width="150"><input type="text" name="prov_by" value="<%=strUsr_nm%>" style="width:120;text-align:center;" class="input2" value="" caption="Provided By" readonly></td>
				<td width="75">CSR No.</td>
				<td width="">&nbsp;<input type="text" name="csr_no" style="width:150;" class="input2" value="" caption="CSR No." readonly></td>
			</tr>
			</table>
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="90">Description</td>
				<td width="480">&nbsp;<input type="text" name="csr_desc" style="width:448;" class="input1" value="" required caption="Description" maxlength="50"></td>
				<td width="75">Slip Type</td>
				<td width="">&nbsp;<select style="width:150;" class="input1" name="slp_func_cd"></select></td>
			</tr>
			</table>
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="90">Evidence Type</td>
				<td width="480">&nbsp;<select name="evid_tp_cd" style="width:80;" class="input1" onchange="setButton(this.value);"></select></td>
				<td width="75">Request DT</td>
				<td width="130">&nbsp;<input type="text" name="rqst_dt" dataformat="ymd" required fullfill caption="Request DT" maxlength="8" style="width:70;ime-mode:disabled;" class="input1">&nbsp;<img src="img/btns_calendar.gif" name="btn_rqstDt" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
				<td width="80">Effective DT</td>
				<td width="">&nbsp;<input type="text" name="eff_dt" dataformat="ymd" required fullfill caption="Eff Date" maxlength="8" style="width:70;ime-mode:disabled;" class="input1">&nbsp;<img src="img/btns_calendar.gif" name="btn_effDt" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
			</tr>
			</table>
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="90">Vendor Code</td>
				<td width="480">&nbsp;<input type="text" name="vndr_seq" style="width:80;text-align:center;ime-mode:disabled" class="input1" dataformat="int" required caption="Vendor Code" maxlength="6">&nbsp;<img src="img/btns_search.gif" name="btn_vndrSeq" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">&nbsp;<input type="text" name="vndr_nm" style="width:340;" class="input2" readonly></td>
				<td width="75">Currency</td>
				<td width="">&nbsp;<input type="text" name="csr_curr_cd" maxlength="3" style="width:40;text-align:center;ime-mode:disabled" class="input1" value="USD" maxlength="3" required fullfill caption="Currency"></td>
			</tr>
			</table>
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
				<td width="90">Approval Step</td>
					<td width="" colspan="6"><input type="text" style="width:690" class="input2" name="apro_step" readOnly value="<%=com.hanjin.bizcommon.approval.util.ApprovalUtil.getApprovalRoute(cost_ofc_cd, inv_sub_sys_cd) %>" >&nbsp;<img class="cursor" src="img/alps/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"  name='apro_step_btn'>
					</td>
			</tr>
			</table>
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="90"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_Brokerage">Brokerage</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
				<!--<td width="70"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_Execute">Execute</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
				<td width="">&nbsp;</td>-->
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
			<!-- Grid  (S) -->
					<table width="100%" id="mainTable" style="display:none;"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet2');</script>
							</td>
						</tr>
					</table>
				<!-- Grid (E) -->
				
				<!-- Grid  (S) -->
					<table width="100%" id="mainTable" style="display:none;"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet3');</script>
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
						<td class="btn2" name="btn_RowAdd">Row&nbsp;Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_RowDel">Row&nbsp;Del</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->

			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="590"></td>
					<td width="90">Total Amount</td>
					<td width="160"><input type="text" style="width:50;" class="tr_head3" value=" DR" readonly>&nbsp;<input type="text" name="dr" style="width:100;text-align:right;" class="tr_head3" value="0" readonly></td>
					<td ><input type="text" style="width:50;" class="tr_head3" value=" Diff" readonly>&nbsp;<input type="text" name="diff" style="width:100;text-align:right;" class="tr_head3" value="0" readonly></td>
				</tr>
				<tr class="h23">
					<td width="590"></td>
					<td width="90"> </td>
					<td width="160"></td>
					<td ><input type="text" style="width:50;" class="tr_head3" value=" Balance" readonly>&nbsp;<input type="text" name="balance" style="width:100;text-align:right;" class="tr_head3" value="0" readonly></td>
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
				<!--<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>-->
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr id="btnSave" style="display:''"><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr id="btnTaxEvidence" style="display:''"><td class="btn1_left"></td>
					<td class="btn1" name="btn_TaxEvidence">Tax Evidence</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_SlipInquiry">Slip Inquiry</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_preview">Preview</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Print">Print</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<!--<td class="btn1_line"></td>-->
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