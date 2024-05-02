<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_JOO_0068.jsp
*@FileTitle : CSR Inquiry Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.12
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.08.12 박희동
* 1.0 Creation
=========================================================*/ 
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.event.FnsJoo0068Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsJoo0068Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.JointOperationAgreementSettlement.JointOperationConsultation");
	String cost_ofc_cd = "";
	String inv_sub_sys_cd = "JOO";

	String csrNo = "";
	String approvalStep = "";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		cost_ofc_cd = account.getOfc_cd();


		event = (FnsJoo0068Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		csrNo = request.getParameter("csrNo") == null ? "" : StringUtil.xssFilter(request.getParameter("csrNo"));
		//해당 CSR번호로 approval step을 조회하고 없으면 default 저장된 값을 조회한다.
		approvalStep = com.hanjin.bizcommon.approval.util.ApprovalUtil.getApprovalRouteByCsrNo(csrNo);
		if (approvalStep == null || "".equals(approvalStep)){
			approvalStep = com.hanjin.bizcommon.approval.util.ApprovalUtil.getApprovalRoute(cost_ofc_cd, inv_sub_sys_cd);
		}		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>CSR Inquiry Detail</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
var gOfcCd = "<%=cost_ofc_cd%>";

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="rvs_csr_flg">
<input type="hidden" name="rvs_cmb_flg">
<input type="hidden" name="evid_tp_cd">
<input type="hidden" name="clz_sts_cd">
<!-- Report Designer 에 필요한 Input Box -->
<input type="hidden"   name="com_mrdPath" value="">
<input type="hidden"   name="com_mrdArguments" value="">

<input type="hidden"   name="com_mrdBodyTitle"     value="CSR Inquiry Detail">   

<input type="hidden"   name="com_mrdSaveDialogFileExt" value="ppt">
<input type="hidden"   name="com_mrdSaveDialogFileExtLimit" value="xls@pdf@doc@ppt">
<input type="hidden"   name="com_mrdSaveDialogFileName" value="CSR Inquiry Detail">
<input type="hidden"   name="com_mrdSaveDialogDir" value="">
<!-- 2010.01.27 Approval Step -->
<input type="hidden"   name="aproSeqKey">
<!-- 개발자 작업	-->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;CSR Inquiry Detail</td></tr>
		</table>
		<!-- : ( Title ) (E) -->

	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="55">CSR No.</td>
					<td width="100"><input type="text" style="width:170" class="input2" name="csr_no" maxlength="20" dataformat="engup" value="<%=csrNo%>" readOnly></td>
					<td width="100">&nbsp;</td>
					<td width="55">&nbsp;</td>
					<td width="">&nbsp;</td>
				</tr> 
				</table>
				<!--  biz_1   (E) -->
				</td></tr>
			</table>
			<table class="height_10"><tr><td colspan="8"></td></tr></table>
			
			<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_2  (S) -->
			<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
				<td width="170">Issue Type</td>
				<td width="390" colspan="3"><input type="text" style="width:80" class="input2" value=" JO CSR" readOnly></td>
				<td width="120">AR/AP Off-set No.</td>
				<td width=""><input type="text" style="width:100" class="input2" name="csr_offst_no" readOnly></td>
				</tr> 
				<tr class="h23">
				<td width="">Issue Team</td>
				<td width="130"><input type="text" style="width:80" class="input2" name="slp_ofc_cd" readOnly></td>
				<td width="100">Issue Date</td>
				<td width="160"><input type="text" style="width:80" class="input2" name="slp_iss_dt" readOnly>&nbsp;<!--<img class="cursor" src="img/btns_calendar.gif" width="19" height="19" border="0" align="absmiddle">--></td>
				<td width="">Issuer</td>
				<td width=""><input type="text" style="width:100" class="input2" name="issuer" readOnly></td>
				</tr> 	
				<tr class="h23">
				<td width="">Description</td>
				<td width="" colspan="5"><input type="text" style="width:610" class="input2" name="csr_desc" readOnly></td>
				</tr> 
				<tr class="h23">
				<td width="170">Service Provider Customer</td>
				<td width="" colspan="5"><input type="text" style="width:80" class="input2" name="vndr_cust_seq" readOnly>&nbsp;<input type="text" style="width:526" class="input2" name="lgl_eng_nm" readOnly></td>
				</tr> 
				<tr class="h23">
				<td width="">Currency</td>
				<td width="" colspan="3"><input type="text" style="width:80" class="input2" name="csr_locl_curr_cd" readOnly></td>
				<td width="">Amount</td>
				<td width=""><input type="text" style="width:100;text-align:right;" class="input2" dataformat="float" name="csr_locl_amt" readOnly></td>
				</tr> 
				<tr class="h23">
				<td width="">Evidence Class</td>
				<td width="" colspan="3"><input type="text" style="width:80" class="input2" name="evid_tp_nm" readOnly></td>
				<td width="">Evidence Volume</td>
				<td width=""><input type="text" style="width:100" class="input2" name="evid_vol" value="1" readOnly></td>
				</tr>
			</table> 
			<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="230"><table class="search_sm2" border="0" style="width:195;"> 
							<tr class="h23">
								<td width="65">&nbsp;Approval</td>
								<td width="" class="stm"><input type="radio" value="Y" class="trans" name="apro_flg" disabled>&nbsp;Yes&nbsp;&nbsp;&nbsp;<input type="radio" value="N" class="trans" name="apro_flg" disabled>&nbsp;No</td>								
							</tr>
							</table> 
					</td>
					<td width="100">Eff. Date</td>
					<td width="158"><input type="text" style="width:80" class="input2" name="eff_dt" dataformat="ymd" readOnly>&nbsp;<!--<img class="cursor" src="img/btns_calendar.gif" width="19" height="19" border="0" align="absmiddle">--></td>
					<td width="117">DUE Date</td>
					<td width=""><input type="text" style="width:77" class="input2" name="rqst_dt" dataformat="ymd" readOnly>&nbsp;<!--<img class="cursor" src="img/btns_calendar.gif" width="19" height="19" border="0" align="absmiddle"> --></td>
				</tr> 	
				<tr class="h23">
				<td width=""><table class="search_sm2" border="0" style="width:195;"> 
							<tr class="h23">
								<td width="65">&nbsp;Cancel</td>
								<td width="" class="stm"><input type="radio" value="Y" class="trans" name="cxl_flg" disabled>&nbsp;Yes&nbsp;&nbsp;&nbsp;<input type="radio" value="N" class="trans" name="cxl_flg" disabled>&nbsp;No</td>
							</tr>
							</table> 
				</td>
				<td width="">Cancel Reason</td>
				<td width="" colspan="3"><input type="text" style="width:375" class="input2" name="cxl_desc" readOnly></td>
				</tr> 
				<tr class="h23">
					<td width="230"><table class="search_sm2" border="0" style="width:195;"> 
							<tr class="h23">
								<td width="65">&nbsp;Deduct</td>
								<td width="" class="stm"><input type="radio" value="Y" class="trans" name="ddct_flg" disabled>&nbsp;Yes&nbsp;&nbsp;&nbsp;<input type="radio" value="N" class="trans" name="ddct_flg" disabled>&nbsp;No</td>
							</tr>
							</table> 
					</td>
					<td width="100">Actual Request</td>
					<td width="158"><input type="text" style="width:100;text-align:right" class="input2" name="act_rqst_amt" dataformat="float" readOnly></td>
					<td width="117">Deduct Amount</td>
					<td width=""><input type="text" style="width:100;text-align:right" class="input2" name="ddct_locl_amt" dataformat="float" readOnly></td>
				</tr> 		
			</table>
			<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
				<td width="120">Deduct Description</td>
				<td width="" colspan="5"><input type="text" style="width:585" class="input2" name="ddct_desc" readOnly></td>
				</tr> 
			</table>
			<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
				<td width="120">Approval Step</td>
				<td width="" colspan="5"><input type="text" style="width:585" class="input2" name="apro_step" readOnly  value="<%=approvalStep%>">&nbsp;<img class="cursor" src="img/alps/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"  name='apro_step_btn'>
				</td>
				</tr> 
			</table>
				<!--  biz_2   (E) -->
			<!-- Grid  (S) -->
			<table width="100%"  id="mainTable" border="0" cellpadding="0" cellspacing="0"> 
				<tr>
					<td width="100%">
					<!--시트-->
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table>
			<!-- Grid  (E) -->
 
			
				</td></tr>
			</table>
	<!--biz page (E)-->
	<table class="height_5"><tr><td></td></tr></table>
	</td></tr>
</table>

<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="171" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
<!-- 		    
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_reverse" id="btn_reverse" auth="C">Reverse</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
 -->				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_evd" id="btn_evd" auth="U">Evidence</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_csr" id="btn_csr" auth="P">CSR Detail</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
				<td><table width="100" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_attach" id="btn_attach"  auth="C">Attachment</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="150" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_gwcl"  id="btn_gwcl"  auth="C">GW Contract Link</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
												
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_print" id="btn_print" auth="P">Print</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
				<td class="btn1_line"></td>
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close" id="btn_close" auth="R">Close</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td></tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table></td></tr>
</table>	
	
<%@include file="/bizcommon/include/common_nis2010.jsp"%>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>