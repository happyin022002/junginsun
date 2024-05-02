<%
/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : CPS_CNI_0048.jsp
 *@FileTitle : CSR Manager
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/06/17
 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@page import="com.clt.apps.opus.cps.cni.claiminvoice.paymentinvoice.event.CpsCni0048Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	CpsCni0048Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String ofc_cd  			= ""; 
	String cnt_cd 	 		= "";
	String inv_sub_sys_cd = "";
	
	inv_sub_sys_cd 			= JSPUtil.getParameter(request, "INV_SUB_SYS_CD".trim(), "");
	
	Logger log = Logger.getLogger("com.clt.apps.ConsultationSlipRequestMgt.ConsultationSlipRequestMgt");
	String xml = HttpUtil.makeXML(request,response);
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	    ofc_cd	  = account.getOfc_cd();
	    cnt_cd 	  = account.getCnt_cd();
	    
		event = (CpsCni0048Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
	strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
	
	String readonly_yn = null;
	String csr_no = null;
	readonly_yn = JSPUtil.getParameter(request,"readonly_yn".trim(),"");
	csr_no		= JSPUtil.getParameter(request,"csr_no".trim(),"");
%>


<%@page import="com.clt.framework.component.util.io.HttpUtil"%><html>
<script type="text/javascript">
	var cnt_cd = "<%=cnt_cd%>";	
	var readonly_yn = "<%=readonly_yn%>";	
	var ofc_cd = "<%=ofc_cd%>";	
	
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<!-- 개발자 작업	-->
<form name="form">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="csr_no">
<input type="hidden" name="inv_sub_sys_cd" value="<%=inv_sub_sys_cd%>">
<input type="hidden" name="aproSeqKey">
<input type="hidden" name="apro_step" value="<%=com.clt.bizcommon.approval.util.ApprovalUtil.getApprovalRoute(ofc_cd, inv_sub_sys_cd) %>">
<input type="hidden" name="clm_area_cd">
<input type="hidden" name="sXml" value="<%=xml%>">
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btng_retrieve" 		id="btng_retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btng_new" 			id="btng_new">New</button><!-- 
		 --><button type="button" class="btn_normal" name="btng_print" 			id="btng_print">Down Excel</button><!-- 
<!-- <button type="button" class="btn_normal" name="btng_viewapprovalstep" 			id="btng_viewapprovalstep">View&nbsp;Approval&nbsp;Step</button> -->
		 <button type="button" class="btn_normal" name="btng_csrformat" 			id="btng_csrformat">CSR&nbsp;Format</button><!-- 
		 --><button type="button" class="btn_normal" name="btng_invoicelistinquiry" 			id="btng_invoicelistinquiry">Invoice&nbsp;List&nbsp;Inquiry</button>			
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
	
</div>
<!-- page_title_area(E) -->
<!-- wrap_search(S) -->
<div class="wrap_search">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry wFit">
	<table>
		<tbody>
			<colgroup>
				<col width="60">
				<col width="10">
				<col width="125">
				<col width="160">
				<col width="50">
				<col width="20">
				<col width="*">
			</colgroup>
			<tr>
			    <th>Area</th>
                <td><script language="javascript">ComComboObject("combo1", 2, 67, 1);</script></td>
				<th>Invoice Office</th>
				<td><input name="ofc_cd" type="text" maxlength="6" style="width:60px;text-align:center;center;ime-mode:disabled;" dataformat="engup" value="<%=ofc_cd%>"></td>
				
				<th>Date</th>
				<td>
				<select style="width:144px;" name='dt_status'><option value="AR">Approval Requested</option><option value="AV">Approved or Disapproved</option><option value="IU">I/F Status Updated</option></select>
				</td>
			    <td><input type="text" style="width:75;text-align:center;ime-mode:disabled" dataformat="ymd" maxlength='10' class="input"  name="fm_eff_dt" value="">&nbsp;~&nbsp;<input type="text" style="width:75;text-align:center;ime-mode:disabled"  maxlength='10' dataformat="ymd" class="input" name="to_eff_dt" value="" ><button type="button" id="btns_Calendar2" name="btns_Calendar2" class="calendar ir"></button>
		   		</td>
		   	</tr>
		   	<tr>
				<th>I/F Status</th>
				<td><select style="width:124px;" name='if_status'><option value="AL" selected>All</option><option value="AR">Approval Requested</option><option value="SD">Sending</option><option value="DA">Disapproved</option><option value="IE">I/F Error</option><option value="RJ">A/P Rejected</option><option value="SC">I/F Success</option><option value="SP">Paid</option></select></td>
				<th>CSR No.</th>
				<td><input name="search_csr_no" id="search_csr_no" type="text" dataformat="engup" maxlength="20" style="width:200;ime-mode:disabled;" value="<%=csr_no%>"  onBlur='this.value=this.value.trim();'></td>				
				<!--  biz_1   (E) -->
			</tr>
		</tbody>
	</table>
</div>
<!-- opus_design_inquiry(E) -->
</div>
<!-- wrap_search(E) -->

<!-- wrap_result(S) -->
<div class="wrap_result">
<!-- opus_design_grid(S) -->
<div class="opus_design_grid">
	<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
<!-- opus_design_grid(E) -->
<!-- opus_design_grid(S) -->
<div class="opus_design_grid" style="display:none">
	<script type="text/javascript">ComSheetObject('sheet2');</script>
</div>
<!-- opus_design_grid(E) -->
<!-- opus_design_grid(S) -->
<div class="opus_design_grid" style="display:none">
	<script type="text/javascript">ComSheetObject('sheet3');</script>
</div>
<!-- opus_design_grid(E) -->
</div>
<!-- wrap_result(E) -->
					  
</form>


