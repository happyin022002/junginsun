<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0133.jsp
*@FileTitle  : Cargo Release Order_E-D/O inquiry _Main
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/18
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr"%>
<%@ page import="com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0133Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0133Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
// 	Logger log = Logger.getLogger("com.clt.apps.InboundBLMgtSC.FullReleaseOrderBC");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0133Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>



<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />



<div class="layer_popup_title">
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><span>eDO Issue Application Inquiry</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_close" id="btn_close">Close</button><!--
	--></div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->
</div>
<div class="layer_popup_contents">	
	<div class= "wrap_search">
		<div class= "opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="60" />
					<col width="200" />
					<col width="30" />
					<col width="200" />
					<col width="60" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr class="h23">
						<td>MRN No.</td>
						<td><input type="text" style="width:120px" class="input2" value="<%=JSPUtil.getNull(request.getParameter("edo_rqst_no").substring(0, 11))%>" readonly></td>
						<td>MSN</td>
						<td><input type="text" style="width:100px" class="input2" value="<%=JSPUtil.getNull(request.getParameter("edo_rqst_no").substring(11))%>" readonly></td> 
						<td>승인 선사</td>
						<td><input type="text" style="width:100" class="input2" value="<%=ConstantMgr.getScacCode()%>" readonly></td>			
					</tr> 
				</tbody>
			</table>
			<table class="height_8"><tr><td></td></tr></table>
			<table class="grid_2 wAuto"> 
				<colgroup>
					<col width="150" />
					<col width="100" />
					<col width="200" />
					<col width="150" />
					<col width="200" />
				</colgroup>
				<tr>
					<th>Master B/L No</th> 
					<td colspan="2"><input type="text" name="bl_no" style="width:100%;" class="noinput2" value="" readonly id="bl_no" /> </td>
					<th>신청 일시</th> 
					<td><input type="text" name="edo_rct_dt" style="width:100%;" class="noinput2" value="" readonly id="edo_rct_dt" /> </td>
					</tr>

				<tr>
					<th>신청자</th>
					<td colspan="2"><input type="text" name="ms_pty_rgst_no" style="width:100%;" class="noinput2" value="" readonly id="ms_pty_rgst_no" /> </td>
					<th>승인 일시</th>
					<td><input type="text" name="edo_ack_dt_a" style="width:100%;" class="noinput2" value="" readonly id="edo_ack_dt_a" /> </td>
					</tr>

				<tr>
					<th>항차</th>
					<td colspan="2"><input type="text" name="skd_nm" style="width:100%;" class="noinput2" value="" readonly id="skd_nm" /> </td>
					<th>거부 일시</th>
					<td><input type="text" name="edo_ack_dt_r" style="width:100%;" class="noinput2" value="" readonly id="edo_ack_dt_r" /> </td>
				</tr>

				<tr>
					<th>입항일자</th>
					<td colspan="2"><input type="text" name="vsl_arr_dt" style="width:100%;" class="noinput2" value="" readonly id="vsl_arr_dt" /> </td>
					<th>USER ID </th>
					<td><input type="text" name="edo_ack_usr_id" style="width:100%;" class="noinput2" value="" readonly id="edo_ack_usr_id" /> </td>
				</tr>

				<tr>
					<th>접수지</th>
					<td><input type="text" name="edo_rct_loc_cd" style="width:100%;" class="noinput2" value="" readonly id="edo_rct_loc_cd" /></td>
					<td><input type="text" name="edo_rct_loc_nm" style="width:100%;" class="noinput2" value="" readonly id="edo_rct_loc_nm" /></td>
					<th>선박 명 </th>
					<td><input type="text" name="edo_vsl_nm" style="width:100%;" class="noinput2" value="" readonly id="edo_vsl_nm" /> </td>
				</tr>
				<tr>
					<td colspan="3"><input type="text" style="width:100%;" class="noinput2" value="" /></td>
					<th>발급희망일 </th>
					<td><input type="text" name="rqst_edo_iss_dt" style="width:100%;" class="noinput2" value="" readonly id="rqst_edo_iss_dt" /> </td>
					</tr>
				
			</table>
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			<h3 class="title_design">신청업체</h3>
			<table class="grid_2 wAuto"> 
				<colgroup>
					<col width="150" />
					<col width="300" />
					<col width="150" />
					<col width="200" />
				</colgroup>
				<tr>
					<th>상호</th>
					<td><input type="text" name="ms_pty_nm" style="width:100%;" class="noinput2" value="" readonly id="ms_pty_nm" /> </td>
					<th>담당자명</th>
					<td><input type="text" name="ms_pty_cntc_pson_nm" style="width:100%;" class="noinput2" value="" readonly id="ms_pty_cntc_pson_nm" /> </td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td><input type="text" name="ms_phn_no" style="width:100%;" class="noinput2" value="" readonly id="ms_phn_no" /> </td>
					<td colspan="2" rowspan="2"></td>
				</tr>
				<tr>
					<th>요청사항 </th>
					<td><input type="text" name="diff_rmk" style="width:100%;" class="noinput2" value="" readonly id="diff_rmk" /> </td>
				</tr>
			</table> 
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			<h3 class="title_design">실화주</h3>
			<table class="grid_2 wAuto"> 
				<colgroup>
					<col width="150" />
					<col width="300" />
					<col width="150" />
					<col width="200" />
				</colgroup>
				<tr>
					<th>상호</th>
					<td><input type="text" name="as_pty_nm" style="width:100%;" class="noinput2" value="" readonly id="as_pty_nm" /> </td>
					<th>사업자번호</th>
					<td><input type="text" name="as_pty_rgst_no" style="width:100%;" class="noinput2" value="" readonly id="as_pty_rgst_no" /> </td>
				</tr>
			</table> 
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			<h3 class="title_design">세금계산서 공급 받는자</h3>
			<table class="grid_2 wAuto"> 
				<colgroup>
					<col width="150" />
					<col width="300" />
					<col width="150" />
					<col width="200" />
				</colgroup>
				<tr>
					<th>상호</th>
					<td><input type="text" name="pr_pty_nm" style="width:100%;" class="noinput2" value="" readonly id="pr_pty_nm" /> </td>
					<th>사업자번호</th>
					<td><input type="text" name="pr_pty_rgst_no" style="width:100%;" class="noinput2" value="" readonly id="pr_pty_rgst_no" /> </td>
				</tr>
			</table> 
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			<h3 class="title_design">송금업체</h3>
			<table class="grid_2 wAuto"> 
				<colgroup>
					<col width="150" />
					<col width="300" />
					<col width="150" />
					<col width="100" />
					<col width="100" />
				</colgroup>
				<tr>
					<th> 상호 </th>
					<td><input type="text" name="payr_nm" style="width:100%;" class="noinput2" value="" readonly id="payr_nm" /> </td>
					<th>송금금액</th>
					<td><input type="text" name="pay_amt_ctnt" style="width:100%;text-align:right" class="noinput2" value="" readonly dataformat="float" pointcount="2" id="pay_amt_ctnt" /> </td>
					<td><input type="text" name="pay_curr_cd" style="width:100%;" class="noinput2" value="" readonly id="pay_curr_cd" /> </td>
				</tr>
				<tr>
					<th>입금은행</th>
					<td><input type="text" name="payr_bank_nm" style="width:100%;" class="noinput2" value="" readonly id="payr_bank_nm" /> </td>
					<th>계좌번호	</th>
					<td colspan="2"><input name="payr_bank_acct_no" type="text" style="width:100%;" class="noinput2" value="" readonly id="payr_bank_acct_no" /> </td>
				</tr>
			</table>
			<input type="hidden" name="frm_edo_rqst_no" value="<%=JSPUtil.getNull(request.getParameter("edo_rqst_no")) %>" id="frm_edo_rqst_no" />
			<input type="hidden" name="frm_edo_tp_cd" value="<%=JSPUtil.getNull(request.getParameter("edo_tp_cd")) %>" id="frm_edo_tp_cd" />
			<input type="hidden" name="frm_edo_rqst_seq_5jn" value="<%=JSPUtil.getNull(request.getParameter("edo_rqst_seq_5jn")) %>" id="frm_edo_rqst_seq_5jn" />
			<input type="hidden" name="frm_edo_rqst_seq_5jm" value="<%=JSPUtil.getNull(request.getParameter("edo_rqst_seq_5jm")) %>" id="frm_edo_rqst_seq_5jm" />
			<input type="hidden" name="frm_edo_rqst_seq_5jk" value="<%=JSPUtil.getNull(request.getParameter("edo_rqst_seq_5jk")) %>" id="frm_edo_rqst_seq_5jk" /> 
		</div>
	</div>
	<!-- opus_design_grid(S) -->	
	<div class="wrap_result">
		<div class="opus_design_grid clear" id="mainTable" >
			<script type="text/javascript">ComSheetObject('sheet1');</script>
			<script type="text/javascript">ComSheetObject('sheet2');</script>
			<script type="text/javascript">ComSheetObject('sheet3');</script>
		</div>
	</div>
	<!-- opus_design_grid(E) -->		
</div>

</form>


<%@include file="/bizcommon/include/common_opus.jsp"%>