<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_1022.jsp
*@FileTitle  : Lease Agreement Detail
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/06
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.event.EesCgm1022Event"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesCgm1022Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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


		event = (EesCgm1022Event)request.getAttribute("Event");
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
<!-- developer working -->
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

<!-- page_title_area(S) -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Lease Agreement Detail</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn"><!-- 
			 --><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->
	</div>
</div>
<!-- page_title_area(E) -->
<!-- opus_design_inquiry(S) -->
<div class="layer_popup_contents">
	<div class= "wrap_search_tab">
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
		            <col width="90">
		            <col width="90">
		            <col width="110">
		            <col width="50">
		            <col width="180">
		            <col width="130">
		            <col width="50">
		            <col width="100">
		            <col width="100">
		            <col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th>Agreement No.</th>
						<td><input type="text" name="agmt_no" id="agmt_no" readonly maxlength="9" style="width:80px;" class="input2" value="<%=agmtNo%>"></td>
						<th>Version</th>
						<td><script type="text/javascript">ComComboObject('agmt_ver_no', 1, 46, 1, 0, 0, false);</script></td>
						<th>Reference No.</th>
						<td><input type="text" name="agmt_ref_no" id="agmt_ref_no" readonly style="width:90px;" class="input2" value=""></td>
						<th>Currency</th>
						<td><input type="text" name="curr_cd" id="curr_cd" readonly style="width:60px;" class="input2" value=""></td>
						<th>Agreement Office</th>
						<td><input type="text" name="agmt_iss_ofc_cd" id="agmt_iss_ofc_cd" readonly style="width:60px;" class="input2" value=""></td>
					</tr>
				</tbody>
			</table>
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			<table>
				<colgroup>
		            <col width="90">
		            <col width="55">
		            <col width="140">
		            <col width="50">
		            <col width="150">
		            <col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th>Lease Term</th>
						<td><input type="text" name="agmt_lstm_cd" id="agmt_lstm_cd" readonly style="width:40px;" class="input2" value=""></td>
						<th>Agreement Date</th>
						<td><input type="text" name="agmt_dt" id="agmt_dt" readonly style="width:80px;" class="input2" value=""></td>
						<th>Agreement Eff. Date</th>
						<td>
							<input type="text" name="agmt_eff_dt" id="agmt_eff_dt" readonly style="width:80px;" class="input2" value="">~ <!-- 
							 --><input type="text" name="agmt_exp_dt" id="agmt_exp_dt"  readonly style="width:80px;ime-mode:disabled" class="input2" value="">
						</td>
					</tr>
				</tbody>
			</table>
			<table>
				<colgroup>
		            <col width="90">
		            <col width="280">
		            <col width="150">
		            <col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th>Lessor</th>
						<td>
							<input type="text" name="vndr_seq" id="vndr_seq" readonly style="width:68px;" class="input2" value=""><!-- 
							 --><input type="text" name="vndr_lgl_eng_nm" id="vndr_lgl_eng_nm" readonly style="width:203px;" class="input2" value="">
						</td>
						<th>Rate Eff. Date</th>
						<td>
							<input type="text" name="eff_dt" id="eff_dt" readonly style="width:80px;" class="input2" value="">~ <!-- 
							 --><input type="text" name="exp_dt" id="exp_dt"  readonly style="width:80px;ime-mode:disabled" class="input2" value=""></td>
						<td><table class="search" border="0" id="poolLayer" style="visibility:hidden">
							<tr>
					  			<th align="right"> Pool</th>
				   				<td><input type="text" name="chss_pool_cd" id="chss_pool_cd" readonly style="width:80px;" class="input2" value=""></td>
				   			</tr>				
						</table>
						</td>
						
						
					</tr> 
				</tbody>
			</table>
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			<!-- layout_wrap(S) -->
			<div class="layout_wrap">
		  	  <div class="layout_vertical_2">
					<h3 class="title_design">Rental Rate Type</h3>
					<table class="mar_btm_12">
						<colgroup>
				            <col width="70">
				            <col width="120">
				            <col width="130">
				            <col width="*">
						</colgroup>
						<tbody>
							<tr>
								<th>
									<input type="radio" name="eq_rntl_tp_cd" id="radio_eq_rntl_tp_cd1" disabled value="" class="trans" checked><label for="radio_eq_rntl_tp_cd1">Fixed</label>
								</th>
								<th>
									<input type="radio" name="eq_rntl_tp_cd" id="radio_eq_rntl_tp_cd2" disabled value="" class="trans"><label for="radio_eq_rntl_tp_cd2">Tier(Unit/Day)</label>
								</th>
								<th>
									<input type="radio" name="eq_rntl_tp_cd" id="radio_eq_rntl_tp_cd3" disabled value="" class="trans"><label for="radio_eq_rntl_tp_cd3">Tier(Used Days)</label>
								</th>
								<td></td>
							</tr> 
						</tbody>
					</table>
					<table>
						<colgroup>
				            <col width="10">
				            <col width="*">
						</colgroup>
						<tbody>
							<tr>
								<td></td>
								<td>Payment Term <input type="text" name="pay_term_dys" id="pay_term_dys" readonly style="width:30px;" class="input2" value="">&nbsp;Days</td>
							</tr> 
						</tbody>
					</table>
				</div>
				<div class="layout_vertical_2">
					<h3 class="title_design">Damage Protection Plan(USD)</h3>
					<table>
						<colgroup>
				            <col width="80">
				            <col width="100">
				            <col width="*">
						</colgroup>
						<tbody>
							<tr>
								<th><input type="radio" name="dpp_tp_cd" id="radio_dpp_tp_cd1" disabled value="" class="trans" checked><label for="radio_dpp_tp_cd1">General DPP</label></th>
								<td></td>
								<td>Rate &nbsp;<input type="text" name="dpp_rt_amt" id="dpp_rt_amt" readonly style="width:60px;text-align:right;" class="input2" value=""></td>
							</tr> 
						</tbody>
					</table>
					<table>
						<colgroup>
				            <col width="130">
				            <col width="*">
						</colgroup>
						<tbody>
							<tr>
								<td></td>
								<td>Coverage Amount &nbsp;<input type="text" name="dpp_cvrg_amt" id="dpp_cvrg_amt" readonly style="width:60px;text-align:right;" class="input2" value=""></td>
							</tr>
						</tbody>
					</table>
					<table>
						<colgroup>
				            <col width="80">
				            <col width="10">
				            <col width="*">
						</colgroup>
						<tbody>
							<tr>
								<th><input type="radio" name="dpp_tp_cd" id="radio_dpp_tp_cd2" disabled value="" class="trans"><label for="radio_dpp_tp_cd2">Lumpsum DPP</label></th>
								<td></td>
								<td>Lumpsum Amount &nbsp;<input type="text" name="lmsm_amt" id="lmsm_amt" readonly style="width:60px;text-align:right;" class="input2" value=""></td>
							</tr>  
						</tbody>
					</table>
				</div>
			</div>
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			<table>
				<colgroup>
		            <col width="50">
		            <col width="140">
		            <col width="70">
		            <col width="70">
		            <col width="120">
		            <col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th>On-hire Handling Charge</th>
						<td><input type="text" name="onh_hndl_rt_amt" id="onh_hndl_rt_amt" readonly style="width:60px;text-align:right;" class="input2" value=""></td>
						<th>Off-hire Handling Charge</th>
						<td><input type="text" name="offh_hndl_rt_amt" id="offh_hndl_rt_amt" readonly style="width:60px;text-align:right;" class="input2" value=""></td>
						<th>Old Agreement No.</th>
						<td><input type="text" name="old_agmt_no" id="old_agmt_no" style="width:100px;" class="input2" value="" dataformat="engup" disabled></td>
					
					</tr>
				</tbody>
			</table>
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			<h3 class="title_design">Drop Off Limit</h3>
			<!-- layout_wrap(S) -->
			<div class="layout_wrap">
		  		  <div class="layout_vertical_2">
						<table>
							<colgroup>
					            <col width="50">
					            <col width="20">
					            <col width="90">
					            <col width="*">
							</colgroup>
							<tbody>
								<tr>
									<th>Period</th>
									<td></td>
									<td>
										<input type="radio" name="drp_off_lmt_prd_cd" id="drp_off_lmt_prd_cd1" disabled value="" class="trans" checked><label for="radio_drp_off_lmt_prd_cd1">Per Month</label>
									</td>
									<td>
										<input type="radio" name="drp_off_lmt_prd_cd" id="drp_off_lmt_prd_cd2" disabled value="" class="trans"><label for="radio_drp_off_lmt_prd_cd2">Per Year</label>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="layout_vertical_2">
						<table>
							<colgroup>
					            <col width="120">
					            <col width="80">
					            <col width="*">
							</colgroup>
							<tbody>
								<tr>
									<td>
										<input type="radio" name="drp_off_lmt_tp_cd" id="radio_drp_off_lmt_tp_cd1" disabled value="" class="trans" checked><label for="radio_drp_off_lmt_tp_cd1">Fixed Quantity</label>
									</td>
									<td>
										<input type="radio" name="drp_off_lmt_tp_cd" id="radio_drp_off_lmt_tp_cd2" disabled value="" class="trans"><label for="radio_drp_off_lmt_tp_cd2">Guaranted Portion</label>
									</td>
									<td>
										<div id="qtyLayer">
											<input type="text" name="drp_off_lmt_qty" id="drp_off_lmt_qty" readonly style="width:80px;text-align:right;ime-mode:disabled" class="input2" value="">
										</div>
										<div id="rtoLayer" style="display:none">
											<input type="text" name="drp_off_lmt_rto" id="drp_off_lmt_rto" readonly style="width:80px;text-align:right;ime-mode:disabled" class="input2" value="">% 
										</div>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
		</div>
	</div>
	<!-- opus_design_inquiry(E) -->
	
	<div class="wrap_result">
		<div class="opus_design_tab">
			<script type="text/javascript">ComTabObject('tab1')</script>
		</div>
		<div id="tabLayer">
			<!-- opus_design_grid(S) -->
			<div class="opus_design_grid"  id="t3sheetLayer1" >	
				 <script type="text/javascript">ComSheetObject('t3sheet1');</script>
			</div>
			<!-- opus_design_grid(E) -->
			<!-- opus_design_grid(S) -->
			<div class="opus_design_grid"  id="t3sheetLayer2" style="display:none">	
				 <script type="text/javascript">ComSheetObject('t3sheet2');</script>
			</div>
			<!-- opus_design_grid(E) -->
			<!-- opus_design_grid(S) -->
			<div class="opus_design_grid"  id="t3sheetLayer3" style="display:none">	
				 <script type="text/javascript">ComSheetObject('t3sheet3');</script>
			</div>
			<!-- opus_design_grid(E) -->
		</div>
		<div id="tabLayer" style="display:none">
			<!-- opus_design_inquiry(S) -->
			<div class="opus_design_inquiry wFit">
				<table> 
					<colgroup>
			            <col width="50">
			            <col width="140">
			            <col width="70">
			            <col width="50">
			            <col width="140">
			            <col width="*">
					</colgroup>
					<tbody>
						<tr>
							<th>Monthly Depreciation</th>
							<td><input type="text" name="mon_dpc_rt_amt" id="mon_dpc_rt_amt" readonly style="width:80px;text-align:right;" class="input2" value="">% </td>
							<th>Max. Depreciation</th>
							<td><input type="text" name="max_dpc_rt_amt" id="max_dpc_rt_amt" readonly style="width:80px;text-align:right;" class="input2" value="">% </td>
							<th>Initial Factor</th>
							<td><input type="text" name="init_dpc_rt_amt" id="init_dpc_rt_amt" readonly style="width:80px;text-align:right;" class="input2" value="">% </td>
						</tr>  
					</tbody>
				</table>
			</div>
			<!-- opus_design_grid(S) -->
			<div class="opus_design_grid" id="mainTable" >	
				<script type="text/javascript">ComSheetObject('t1sheet1');</script>
			</div>
			<!-- opus_design_grid(E) -->
		</div>
		<div id="tabLayer" style="display:none">
				<h3 class="title_design">Surcharge for Registration</h3>
				<!-- opus_design_grid(S) -->
				<div class="opus_design_grid" id="mainTable" >	
					<script type="text/javascript">ComSheetObject('t2sheet1');</script>
				</div>
				<!-- opus_design_grid(E) -->
		</div>
		<div id="tabLayer" style="display:none">
				<!-- opus_design_inquiry(S) -->
			<div class="opus_design_inquiry wFit">
				<table> 
					<tr>
						<td><textarea name="diff_rmk"  id="diff_rmk" readonly style="width:100%;height:100px;resize:none"></textarea></td>
					</tr>
				</table>
			</div>
		</div>
		<div id="hiddenLayer" style="display:none">
			<script type="text/javascript">ComSheetObject('sheet');</script>  
		</div>
	</div>
</div>				
</form>