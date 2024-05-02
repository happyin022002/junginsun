<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAP_0021.jsp
*@FileTitle  : Account Information Popup  
*@author     : CLT
*@version    : 1.0
*@since      : 2014/
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>

<%
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	String req_acct_type = "";					//req_acct_type
	String rep_line_type = "";
	String req_company = "";
	String req_region = "";
	String req_center = "";
	String req_account = "";
	String req_intercom = "";
	String req_vvd = "";
	String req_vvd_type = "";
	try {
		rep_line_type = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("lineType")));
		req_acct_type = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("account_type")));
		req_company = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("company")));
		req_region = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("region")));
		req_center = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("center")));
		req_account = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("account")));
		req_intercom = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("intercom")));
		req_vvd = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("vvd")));
		req_vvd_type = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("vvdType")));
		if (req_company.equals("")) req_company = "01";
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	} catch(Exception e) {
		out.println(e.toString());
	}
%>
	
	<script type="text/javascript">
		function setupPage(){
			var errMessage = "<%=strErrMsg%>";
			if (errMessage.length >= 1) {
				ComShowMessage(errMessage);
			} // end if
			loadPage();
		}
	</script>
	
	<form name="form">
	<input type="hidden" name="f_cmd" id="f_cmd" />
	<input type="hidden" name="reqComCode" value="<%=req_company %>" id="reqComCode" />
	<input type="hidden" name="reqAccType" value="<%=req_acct_type %>" id="reqAccType" />
	<input type="hidden" name="reqLineType" value="<%=rep_line_type %>" id="reqLineType" />
	<input type="hidden" name="reqvvdtype" value="<%=req_vvd_type %>" id="reqvvdtype" />
	<div class="layer_popup_title">
		<!-- page_title_area(S) -->
		<div class="page_title_area clear">
			<!-- page_title(S) -->
			<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
			<h2 class="page_title">
				<span>Account Information</span>
			</h2>
			<!-- page_title(E) -->
			<!-- opus_design_btn (S) -->
			<div class="opus_design_btn">
				<button class="btn_accent" name="btn_ok" id="btn_ok" type="button">OK</button><!--
				--><button class="btn_normal" name="btn_new" id="btn_new" type="button">New</button><!--
				--><button class="btn_normal" name="btn_close" id="btn_close" type="button">Close</button><!--
				--></div>
			<!-- opus_design_btn (E) -->
		</div>
		<!-- page_title_area(E) -->
	</div>
	<div class="layer_popup_contents">
		<div class="wrap_search">
			<!-- opus_design_inquiry(S) -->
			<div class="opus_design_inquiry wFit">
				<table>
					<tbody>
						<colgroup>
							<col width="100" />
							<col width="*" />
						</colgroup>
						<tr>
							<th>Company</th>
							<td><input type="text" style="width:90px;" class="input1" name="liab_coa_co_cd" maxlength="2" dataformat="engup" value="<%=req_company%>" required="" caption="Company" id="liab_coa_co_cd" /><button type="button" id="btns_co_srh" name="btns_co_srh" class="input_seach_btn"></button><input type="text" style="width:150px;" class="input2" name="liab_coa_co_nm" readonly id="liab_coa_co_nm" /> </td>
						</tr> 
						<tr>
							<th>Region</th>
							<td><input type="text" style="width:90px;" class="input1" name="liab_coa_rgn_cd" maxlength="2" dataformat="engup" value="<%=req_region%>" required="" caption="Region" id="liab_coa_rgn_cd" /><button type="button" id="btns_rgn_srh" name="btns_rgn_srh" class="input_seach_btn"></button><input type="text" style="width:150px;" class="input2" name="liab_coa_rgn_nm" readonly id="liab_coa_rgn_nm" /> </td>
						</tr> 
						<tr>
							<th>Center</th>
							<td><input type="text" style="width:90px;" class="input1" name="liab_coa_ctr_cd" maxlength="6" dataformat="engup" value="<%=req_center%>" required="" caption="Center" id="liab_coa_ctr_cd" /><button type="button" id="btns_ctr_srh" name="btns_ctr_srh" class="input_seach_btn"></button><input type="text" style="width:150px;" class="input2" name="liab_coa_ctr_nm" readonly id="liab_coa_ctr_nm" /> </td>
						</tr> 
						<tr>
							<th>Account</th>
							<td><input type="text" style="width:90px;" class="input1" name="liab_coa_acct_no" maxlength="6" dataformat="engup" value="<%=req_account%>" required="" caption="Account" id="liab_coa_acct_no" /><button type="button" id="btns_acct_srh" name="btns_acct_srh" class="input_seach_btn"></button><input type="text" style="width:150px;" class="input2" name="liab_coa_acct_nm" readonly id="liab_coa_acct_nm" /> </td>
						</tr> 
						<tr>
							<th>Inter Company</th>
							<td><input type="text" style="width:90px;" class="input1" name="liab_coa_inter_co_cd" maxlength="2" dataformat="engup" value="<%=req_intercom%>" required="" caption="Inter Company" id="liab_coa_inter_co_cd" /><button type="button" id="btns_inter_co_srh" name="btns_inter_co_srh" class="input_seach_btn"></button><input type="text" style="width:150px;" class="input2" name="liab_coa_inter_co_nm" readonly id="liab_coa_inter_co_nm" /> </td>
						</tr>	
						<tr>
							<th title="Vessel Voyage Direction">VVD</th>
							<td><input type="text" style="width:90px;" class="input1" name="liab_coa_vvd_cd" maxlength="10" dataformat="engup" value="<%=req_vvd%>" required="" caption="VVD" id="liab_coa_vvd_cd" /><button type="button" id="btns_vvd_srh" name="btns_vvd_srh" class="input_seach_btn"></button><input type="text" style="width:150px;" class="input2" name="liab_coa_vvd_nm" readonly id="liab_coa_vvd_nm" /> </td>
						</tr>				
					</tbody>
				</table>
			</div>
			<!-- opus_design_inquiry(E) -->
		</div>	
		<div class="wrap_result" style="display: none;">
			<div class="opus_design_grid">
				<script type="text/javascript">ComSheetObject('sheet1');</script>
			</div>
		</div>	
	</div>
	</form>
	