<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_2103.jsp
*@FileTitle  : Lease Agreement Detail
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/15
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.event.EesCgm2103Event"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesCgm2103Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.ChassisMgsetAgreementInvoice.ChassisMgsetAgreement");
	
	String agmtNo = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesCgm2103Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		agmtNo = StringUtil.xssFilter(request.getParameter("agmt_no"));

	}catch(Exception e) {
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
<input type="hidden" name="pagerows" id="pagerows" />
<!-- Form Hidden -->
<input type="hidden" name="action_flag" id="action_flag" />
<input type="hidden" name="intg_cd_id" id="intg_cd_id" />
<input type="hidden" name="ofc_cd" id="ofc_cd" />
<input type="hidden" name="eq_knd_cd" id="eq_knd_cd" />
<input type="hidden" name="agmt_ofc_cty_cd" id="agmt_ofc_cty_cd" />
<input type="hidden" name="agmt_seq" id="agmt_seq" />
<input type="hidden" name="lst_ver_flg" id="lst_ver_flg" />
<!--  Previous Data -->
<input type="hidden" name="pre_eff_dt" id="pre_eff_dt" />
<input type="hidden" name="pre_exp_dt" id="pre_exp_dt" />
<!-- developer working -->
<!-- page_title_area(S) -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Lease Agreement Detailed</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
		    <button class="btn_accent" type="button" name="btn_Close" id="btn_Close">Close</button>
		</div>
		<!-- opus_design_btn (E) -->
	</div>
</div>
<!-- page_title_area(E) -->	
<!-- opus_design_inquiry(S) -->
<div class="layer_popup_contents">
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table> 
	            <colgroup>
	                <col width="110">
	                <col width="100">
	                <col width="110">
	                <col width="70">
	                <col width="86">
	                <col width="100">
	                <col width="160">
	                <col width="*">
	            </colgroup>
	            <tbody>
					<tr>
						<th>Agreement No.</th>
						<td><input type="text" name="agmt_no" readonly style="width:80px;" class="input2" value="<%=agmtNo %>" id="agmt_no" /></td>
						<th>Version</th>
						<td><script type="text/javascript">ComComboObject('agmt_ver_no', 1, 60, 1, 0, 0, false);</script></td>
						<th>Ref. No.</th>
						<td><input type="text" name="agmt_ref_no" readonly style="width:80px;" class="input2" value="" id="agmt_ref_no" /></td>
						<th>Agreement Office</th>
						<td><input type="text" name="agmt_iss_ofc_cd" readonly style="width:58px;" class="input2" value="" id="agmt_iss_ofc_cd" /></td>
					</tr>
				</tbody>
			</table>
			<table> 
	            <colgroup>
	                <col width="110">
	                <col width="100">
	                <col width="110">
	                <col width="180">
	                <col width="120">
	                <col width="*">
	            </colgroup>
	            <tbody>
					<tr>
						<th>Lease Term</th>
						<td><input type="text" name="agmt_lstm_cd" readonly style="width:50px;" class="input2" value="" id="agmt_lstm_cd" /></td>
						<th>Agreement Date</th>
						<td><input type="text" name="agmt_dt" readonly style="width:105px;" class="input2" value="" id="agmt_dt" /></td>
						<th>Agreement Eff. Date</th>
						<td>
							<input type="text" name="agmt_eff_dt" readonly style="width:80px;" class="input2" value="" id="agmt_eff_dt" /><span class="dash">~</span><!-- 
							--><input type="text" name="agmt_exp_dt" readonly style="width:80px;" class="input2" value="" id="agmt_exp_dt" />
						</td>
					</tr>
				</tbody>
			</table>
			<table> 
	            <colgroup>
	                <col width="55">
	                <col width="475">
	                <col width="90">
	                <col width="*">
	            </colgroup>
	            <tbody>
					<tr>
						<th>Lessor</th>
						<td>
						    <input type="text" name="vndr_seq" readonly style="width:51px;" class="input2" value="" id="vndr_seq" /><!-- 
						 --><input type="text" name="vndr_lgl_eng_nm" readonly style="width:365px;" class="input2" value="" id="vndr_lgl_eng_nm" /> 
						</td>
						<th>Rate Eff. Date</th>
						<td>
							<input type="text" name="eff_dt" readonly style="width:80px;" class="input2" value="" id="eff_dt" /><span class="dash">~</span><!-- 
							 --><input type="text" name="exp_dt" readonly style="width:80px;" class="input2" value="" id="exp_dt" />
						</td>
					</tr>
				</tbody>
			</table>
			<table> 
	            <colgroup>
	                <col width="110">
	                <col width="115">
	                <col width="190">
	                <col width="84">
	                <col width="120">
	                <col width="*">
	            </colgroup>
	            <tbody>
					<tr>
						<th>Payment Term</th>
						<td><input type="text" name="pay_term_dys" readonly style="width:50px;" class="input2" value="" id="pay_term_dys" />days</td>
						<th>On-hire Handling Charge</th>
						<td><input type="text" name="onh_hndl_rt_amt" readonly style="width:60px;text-align:right;" class="input2" value="" id="onh_hndl_rt_amt" /> </td>
						<th>Off-hire Handling Charge</th>
						<td><input type="text" name="offh_hndl_rt_amt" readonly style="width:57px;text-align:right;" class="input2" value="" id="offh_hndl_rt_amt" /> </td>
					</tr>
				</tbody>
			</table>
			<table> 
	            <colgroup>
	                <col width="110">
	                <col width="*">
	            </colgroup>
	            <tbody>
					<tr>
					<th>Old AGMT No.</th>
					<td><input type="text" name="old_agmt_no" id="old_agmt_no" readonly  style="width:150px;" class="input2" value = "" dataformat="engup" otherchar="-_"></td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
	<div class="wrap_result" >	
		<div class="opus_design_tab">
			<script type="text/javascript">ComTabObject('tab1')</script>
		</div>
		<div class="opus_design_grid" name="tabLayer" id="tabLayer">
			<script type="text/javascript">ComSheetObject('t3sheet1');</script>
		</div>

		<div class="opus_design_grid" name="tabLayer" id="tabLayer"  style="display:none;">
			<div class="opus_design_inquiry">
				<table> 
		            <colgroup>
		                <col width="130">
		                <col width="160">
		                <col width="120">
		                <col width="160">
		                <col width="90">
		                <col width="*">
		            </colgroup>
		            <tbody>
						<tr>
							<th>Monthly Depreciation</th>
							<td><input type="text" name="mon_dpc_rt_amt" readonly style="width:100px;text-align:right;ime-mode:disabled" class="input2" value="" id="mon_dpc_rt_amt" />% </td>
							<th>Max. Depreciation</th>
							<td><input type="text" name="max_dpc_rt_amt" readonly style="width:100px;text-align:right;ime-mode:disabled" class="input2" value="" id="max_dpc_rt_amt" />% </td>
							<th>Initial Factor</th>
							<td><input type="text" name="init_dpc_rt_amt" readonly style="width:100px;text-align:right;ime-mode:disabled" class="input2" value="" id="init_dpc_rt_amt" />% </td>
						</tr> 
					</tbody>
				</table>
				<table class="line_bluedot"><tr><td></td></tr></table>
				<script type="text/javascript">ComSheetObject('t3sheet2');</script>

			</div>
		</div>
		<div class="opus_design_grid" name="tabLayer" id="tabLayer"  style="display:none;">
			<script type="text/javascript">ComSheetObject('t3sheet3');</script>
		</div>
		<div class="opus_design_grid" name="tabLayer" id="tabLayer" style="display:none;">
	      <table class="search">
	    	  <tr class="" align="center">
	    	  	<td><textarea name="diff_rmk" id="diff_rmk" style="width: 100%; height: 130px; ime-mode:disabled" readonly></textarea></td>
	     	 </tr>
	      </table>
		</div>	


		<!-- hidden handling (S)-->
		<div class="opus_design_grid" id="mainTable" style="display:none;">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<!-- hidden handling (E)-->
	</div>
</div>	
</form>