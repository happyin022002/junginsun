<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0079_08.jsp
*@FileTitle  : Freight & Charge
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/28
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.core.view.template.Screen"%>
<%@ page import="com.clt.framework.core.controller.DefaultViewAdapter"%>
<%@ page import="com.clt.framework.core.controller.util.WebKeys"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.event.EsmBkg007908Event"%>
<%
		EsmBkg007908Event event = null; //PDTO(Data Transfer Object including Parameters)
		Exception serverException   = null;			//serverException
		String strErrMsg = "";						//error massage
		int rowCount	 = 0;						//DB ResultSet list count

		String successFlag = "";
		String codeList = "";
		String pageRows = "100";

		String strUsr_id = "";
		String strUsr_nm = "";
		Logger log = Logger.getLogger("com.clt.apps.BlRating.BlRating");
		String sXml = null;
		String rTerm = "";
		String dTerm = "";
		String isInquiry = "N";	
		
		try {
				SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
				strUsr_id = account.getUsr_id();
				strUsr_nm = account.getUsr_nm();
				event = (EsmBkg007908Event) request.getAttribute("Event");
				serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
				if (serverException != null) {
						strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
				}
				Screen screen = (Screen) request.getAttribute(WebKeys.CURRENT_SCREEN);
				//inquiry mode
				if (screen.getName().indexOf("Q") >= 0){
						isInquiry = "Y";
				} else {
						isInquiry = "N";			
				}
				//when open screen, get data in server..
				GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
				  rTerm =  (String)eventResponse.getCustomData("rTerm");
				  dTerm =  (String)eventResponse.getCustomData("dTerm");
				DefaultViewAdapter adapter = new DefaultViewAdapter();
				sXml = adapter.makeXML(request, response);		
				
		} catch (Exception e) {
				out.println(e.toString());
		}
%>

<script type="text/javascript">
	function setupPage(){
		showControl('covered_id_b', false);
		showControl('covered_id_c', false);
		showControl('covered_id_m', false);
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
				ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<style type="text/css">
	.covered_id_m, .covered_id_c, .covered_id_b {
		display:none;
	}
</style>

<form name="frm">
<input type="hidden" name="sXml" id="sXml" value="<%=JSPUtil.replace(sXml, "\"", "&quot;")%>">
</form>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
	<!-- Developer Work	-->
<input type="hidden" name="bkg_no" value="<%=JSPUtil.getParameter(request, "bkg_no")%>" id="bkg_no" />
<input type="hidden" name="bl_no" value="<%=JSPUtil.getParameter(request, "bl_no")%>" id="bl_no" />
<input type="hidden" name="application_date" value="<%=JSPUtil.getParameter(request, "application_date")%>" id="application_date" />

<input type="hidden" name="frm_t10sheet1_rmark_yn" value="" id="frm_t10sheet1_rmark_yn" />
<input type="hidden" name="frm_t10sheet1_rfa_yn" value="" id="frm_t10sheet1_rfa_yn" />
<input type="hidden" name="sc_no" value="" id="sc_no" />
<input type="hidden" name="caflag" value="" id="caflag" />
<input type="hidden" name="autoRate" value="N" id="autoRate" />
<input type="hidden" name="removeAll" value="N" id="removeAll" />
<input type="hidden" name="bdrflag" value="" id="bdrflag" />
<input type="hidden" name="rOfc_cd" value="" id="rOfc_cd" />
<input type="hidden" name="sc_available" value="" id="sc_available" />
<input type="hidden" name="rfa_available" value="" id="rfa_available" />
<input type="hidden" name="taa_available" value="" id="taa_available" />

<input type="hidden" name="frm_t10sheet1_bkg_sts_cd" value="" id="frm_t10sheet1_bkg_sts_cd" />
<input type="hidden" name="frm_t10sheet1_bkg_rt_whf_expt_cd" value="" id="frm_t10sheet1_bkg_rt_whf_expt_cd" />
<input type="hidden" name="frm_t10sheet1_bkg_svc_scp_cd" value="" id="frm_t10sheet1_bkg_svc_scp_cd" />
<input type="hidden" name="flex_hgt_flg" id="flex_hgt_flg" />
<input type="hidden" name="frm_rcv_term_cd" value="<%=rTerm%>" id="frm_rcv_term_cd" />
<input type="hidden" name="frm_de_term_cd" value="<%=dTerm%>" id="frm_de_term_cd" />
<input type="hidden" class="noinput" name="modify_flag" value="N" id="modify_flag" />

<input type="hidden" name="frm_t10sheet1_hngr_flg" value="" id="frm_t10sheet1_hngr_flg" />
<input type="hidden" name="frm_t10sheet1_rc_flg" value="" id="frm_t10sheet1_rc_flg" />
<input type="hidden" name="frm_t10sheet1_rt_bl_tp_cd_old" value="" id="frm_t10sheet1_rt_bl_tp_cd_old" />
<input type="hidden" name="isInquiry" value="<%=isInquiry%>" id="isInquiry" />
<input type="hidden" name="page_type" value="ESM_BKG_0079_08" id="page_type" />
<input type="hidden" name="oblIssFlg" value="N" id="oblIssFlg" />

<input type="hidden" name="frm_t10sheet1_rt_aply_dt_bak" id="frm_t10sheet1_rt_aply_dt_bak" />
<input type="hidden" name="multi_cgo" id="multi_cgo" />
<input type="hidden" name="frm_t10sheet1_doc_loc_cd" value="" id="frm_t10sheet1_doc_loc_cd" />


<!-- opus_design_btn(S) -->
<div class="opus_design_btn opus_design_normal2">
	 <button type="button" class="btn_normal2" name="btn_t10retrieve" 		id="btn_t10retrieve">Retrieve</button><!-- 
	 --><button type="button" class="btn_normal2" name="btn_t10save" 			id="btn_t10save">Save</button><!--	
	 --><button type="button" class="btn_normal2" name="btn_t10cntr_rate" 		id="btn_t10cntr_rate">CNTR Rate</button><!--			
	 --><button type="button" class="btn_normal2" name="btn_t10auto_rating" 		id="btn_t10auto_rating">Auto-Rating</button><!--			
	 --><button type="button" class="btn_normal2" name="btn_t10exchange_rating" 	id="btn_t10exchange_rating">Exchange Rate</button><!--		
	 --><button type="button" class="btn_normal2" name="btn_t10clear" 			id="btn_t10clear">Clear</button><!--
	 --><button type="button" class="btn_normal2" name="btn_t10remark" 			id="btn_t10remark">Remark(s)</button><!--		
	 --><button type="button" class="btn_normal2" name="btn_t10self" 			id="btn_t10self">Self Audit</button><!--		
	 --><button type="button" class="btn_normal2" name="btn_t10tpb_link" 		id="btn_t10tpb_link">TPB Link</button>	
</div>
<!-- opus_design_btn(E) -->


<!-- wrap_search (S) -->
<div class="wrap_search coupled_btn_normal2">
	<div class="opus_design_inquiry wFit"> 
		<table> 
        	<colgroup id="colGr">
        		<col width="103" />
        		<col width="140" />
        		<col width="70" />
        		<col />
        	</colgroup>
			<tbody>
				<tr>
					<th>BKG No.</th>
					<td>
						<input type="text" style="width: 105px;" class="input1" dataformat="engup" maxlength="13" name="frm_t10sheet1_bkg_no" value="<%=JSPUtil.getParameter(request, "bkg_no")%>" id="frm_t10sheet1_bkg_no" /><!--
											 --><button type="button" class="btn_down_list" name="btn_splitPop" id="btn_splitPop"></button>
					</td>
					<th>B/L No.</th>
					<td>
						<input type="text" style="width: 105px;" dataformat="engup" maxlength="13" name="frm_t10sheet1_bl_no" value="" class="input" id="frm_t10sheet1_bl_no" />
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<!-- wrap_search (E) -->



<!-- wrap_result (S) -->
<div class="wrap_result coupled_btn_normal2">
		
		<!-- opus_design_inquiry(1) (S) -->
		<div class="opus_design_inquiry mar_btm_none wFit">

					        <table>
					        	<colgroup>
					        		<col width="103" />
					        		<col width="100" />
					        		<col width="40" />
					        		<col width="40" />
					        		<col width="90" />
					        		<col width="140" />
					        		<col width="60" />
					        		<col width="52" />
					        		<col width="95" />
					        		<col width="80" />
					        		<col width="100" />
					        		<col width="97" />
					        		<col width="45" />
					        		<col />
					        	</colgroup>
					        	<tbody>
					        		<tr>
						        		<th>Application Date</th>
										<td colspan="3">
											<input type="text" style="width: 105px;" name="frm_t10sheet1_rt_aply_dt" value="" class="input1" maxlength="10" dataformat="ymd" id="frm_t10sheet1_rt_aply_dt" /><!--  
											--><button type="button" id="btn_t10search_date" name="btn_t10search_date" class="btn_etc">Retrieve</button>
										</td>
										<th>Audit Status</th>
										<td>
											<input type="text" style="width: 25px;" name="frm_t10sheet1_aud_sts_cd" value="" class="input2" readonly id="frm_t10sheet1_aud_sts_cd" />
										</td>	
					        		</tr>
					        		<tr>
					        			<th>Bill Type</th>
										<td>
											<script type="text/javascript">ComComboObject('rt_bl_tp_cd', 2, 40, 1)</script>
											 <input type="hidden" name="frm_t10sheet1_rt_bl_tp_cd" value="" id="frm_t10sheet1_rt_bl_tp_cd" />
										</td>
										<th id="covered_name"></th>
										<td>
											<!--  MASTER -->
											<input type="hidden" name="covered_name_m" value="" id="covered_name_m" /><!-- 
											 --><button type="button" class="input_seach_btn covered_id_m" name="pop_covered" id="pop_covered"></button><!-- 
											--><input type="text" style="width: 120px; display: none;" name="covered_name_c" value="" dataformat="engup" maxlength="13" class="covered_id_c input" id="covered_name_c" /><!-- 
											 --><input type="hidden" name="frm_t10sheet1_mst_cvrd_bl" value="" id="frm_t10sheet1_mst_cvrd_bl" /><!-- 
											 --><input type="text" style="width: 40px;" name="inrAuth1" value="COBIZ" class="covered_id_b input2" readonly id="inrAuth1" /><!-- 
											 --><input type="text" style="width: 20px;" name="inrAuth2" value="" dataformat="engup" maxlength="2" class="covered_id_b input" id="inrAuth2" /><!-- 
											 --><input type="text" style="width: 20px;" name="inrAuth3" value="" dataformat="num" maxlength="2" class="covered_id_b input" id="inrAuth3" /><!-- 
											 --><input type="text" style="width: 20px;" name="inrAuth4" value="INR/" class="covered_id_b input2" readonly id="inrAuth4" /><!-- 
											 --><input type="text" style="width: 20px;" name="inrAuth5" value="" dataformat="engup" maxlength="1" class="covered_id_b input" id="inrAuth5" /><!-- 
											 --><input type="text" style="width: 40px;" name="inrAuth6" value="" dataformat="num" maxlength="4" class="covered_id_b input" id="inrAuth6" /><!-- 
											 --><input type="hidden" name="frm_t10sheet1_cobiz_auth_no" value="" id="frm_t10sheet1_cobiz_auth_no" />
										</td>
										<th>FRT Term</th>
										<td>
											<script type="text/javascript">ComComboObject('frt_term_cd', 2, 40, 1)</script><!-- 
											 --><input type="hidden" name="frm_t10sheet1_frt_term_cd" value="" id="frm_t10sheet1_frt_term_cd" />
										</td>
						        		<th>Route</th>
										<td colspan="3">
											<input type="text" style="width: 50px;" name="frm_t10sheet1_por_cd" value="" class="input2" readonly id="frm_t10sheet1_por_cd" /><!--  
											--><input type="text" style="width: 50px;" name="frm_t10sheet1_pol_cd" value="" class="input2" readonly id="frm_t10sheet1_pol_cd" /><!--  
											--><input type="text" style="width: 50px;" name="frm_t10sheet1_pod_cd" value="" class="input2" readonly id="frm_t10sheet1_pod_cd" /><!--  
											--><input type="text" style="width: 50px;" name="frm_t10sheet1_del_cd" value="" class="input2" readonly id="frm_t10sheet1_del_cd" />
										</td>
										<th>Pre</th>
										<td>
											<input type="text" style="width: 68px;" name="frm_t10sheet1_pre_rly_port_cd" value="" class="input2" readonly id="frm_t10sheet1_pre_rly_port_cd" /> 
										</td>
										<th>Post</th>
										<td>
											<input type="text" style="width: 68px;" name="frm_t10sheet1_pst_rly_port_cd" value="" class="input2" readonly id="frm_t10sheet1_pst_rly_port_cd" /> 
										</td>
					        		</tr>
					        		<tr>
										<th>Weight</th>
										<td colspan="3">
											<input type="text" style="width: 103px;text-align:right;" name="frm_t10sheet1_act_wgt" value="" class="input2" readonly id="frm_t10sheet1_act_wgt" /><!--  
											--><input type="text" style="width: 35px;" name="frm_t10sheet1_wgt_ut_cd" value="" class="input2" readonly id="frm_t10sheet1_wgt_ut_cd" /> 
										</td>
										<th>Measure</th>
										<td>
											<input type="text" style="width: 80px;text-align:right;" name="frm_t10sheet1_meas_qty" value="" class="input2" readonly id="frm_t10sheet1_meas_qty" /><!--  
											--><input type="text" style="width: 35px;" name="frm_t10sheet1_meas_ut_cd" value="" class="input2" readonly id="frm_t10sheet1_meas_ut_cd" />
										</td>
										<th>Special</th>
										<td>
											<input type="text" style="width: 30px;" name="frm_t10sheet1_special" value="" class="input2" readonly id="frm_t10sheet1_special" /> 
										</td>	
						        		<th>R/D Term</th>
										<td>
											<input type="text" style="width: 30px;" name="frm_t10sheet1_rcv_term_cd" value="" class="input2" readonly id="frm_t10sheet1_rcv_term_cd" /><!--  
											--><input type="text" style="width: 30px;" name="frm_t10sheet1_de_term_cd" value="" class="input2" readonly id="frm_t10sheet1_de_term_cd" />
										</td>
										<th>Service Scope</th>
										<td colspan="3">
											<select style="width: 210px;" name ="svc_scp_cd" class="input2" readonly></select><!--  
											--><input type="hidden" name="frm_t10sheet1_svc_scp_cd" id="frm_t10sheet1_svc_scp_cd" />
										</td>
					        		</tr>
				        		</tbody>
			        		</table>


					
		</div>
		<table class="line_bluedot"><tr><td></td></tr></table>
		<!-- opus_design_inquiry(1) (E) -->
			
		
		
		<!-- opus_design_inquiry(2) (E) -->
		<div class="opus_design_inquiry mar_btm_none wFit">
		
						<table>
				        	<colgroup>
				        		<col width="103" />
				        		<col width="270" />
				        		<col width="100" />
				        		<col width="58" />
				        		<col width="65" />
				        		<col width="172" />
				        		<col width="75" />
				        		<col width="172" />
				        		<col width="75" />
				        		<col/>
				        	</colgroup>
				        	<tbody>
				        		<tr>
				        			<th>Customs Desc</th>
									<td>
										<input type="text" style="width: 250px;" name="frm_t10sheet1_cstms_desc" value="" class="input2" readonly id="frm_t10sheet1_cstms_desc" />
									</td>
									<th>Rep. CMDT</th>
									<td colspan="3">
										<input type="text" style="width: 47px; text-align: center;" value="" class="input2" name="frm_t10sheet1_rep_cmdt_cd" readonly id="frm_t10sheet1_rep_cmdt_cd" /><!--  
										--><input type="text" style="width: 220px;" value="" class="input2" name="frm_t10sheet1_rep_cmdt_nm" readonly id="frm_t10sheet1_rep_cmdt_nm" />
									</td>
									<th>CMDT</th>
									<td colspan="3">
										<input type="text" style="width: 50px; text-align: center;" value="" class="input2" name="frm_t10sheet1_cmdt_cd" readonly id="frm_t10sheet1_cmdt_cd" /><!--  
										--><input type="text" style="width: 216px;" value="" class="input2" name="frm_t10sheet1_cmdt_nm" readonly id="frm_t10sheet1_cmdt_nm" />
									</td>
				        		</tr>
				        		<tr>
				        			<th>S/C No.</th>
									<td>
										<input type="text" style="width: 90px;" name="frm_t10sheet1_sc_no1" value="" dataformat="engup" maxlength="9" class="input" id="frm_t10sheet1_sc_no1" /><!--  
										--><input type="text" style="width: 25px;" value="" class="input2" readonly /><!--  
										--><button type="button" class="input_seach_btn" name="pop_sc_no" id="pop_sc_no"></button><!--  
										--><button type="button" class="btn_etc" name="btn_t10note" id="btn_t10note">Note</button><!--  
										--><input type="hidden" name="frm_t10sheet1_sc_no2" id="frm_t10sheet1_sc_no2" />
									</td>
									<th>Break Down</th>
									<td>
										<input type="checkbox" class="trans" name="brk_dwn_flg" value="" id="brk_dwn_flg" /><!--  
										--><input type="hidden" name="frm_t10sheet1_brk_dwn_flg" id="frm_t10sheet1_brk_dwn_flg" />
									</td>
									<th>RFA No.</th>
									<td>
										<input type="text" style="width: 90px;" name="frm_t10sheet1_rfa_no" value="" dataformat="engup" maxlength="11" class="input" id="frm_t10sheet1_rfa_no" /><!--  
										--><input type="text" style="width: 25px;" name="frm_t10sheet1_sp_prop_sts_cd" value="" class="input2" readonly id="frm_t10sheet1_sp_prop_sts_cd" /><!--  
										--><button type="button" class="input_seach_btn" name="pop_rfa_no" id="pop_rfa_no"></button>
									</td>
									<th>TAA No.</th>
									<td>
										<input type="text" style="width: 110px;" name="frm_t10sheet1_taa_no" value="" dataformat="engup" maxlength="10" class="input" id="frm_t10sheet1_taa_no" /><!--  
										--><input type="text" style="width: 25px;" value="" class="input2" readonly /><!--  
										--><button type="button" class="input_seach_btn" name="pop_tta_no" id="pop_tta_no"></button>
									</td>
									<th>Declared Cargo Value</th>
									<td>
										<input type="text" style="width: 103px;text-align:right;" name="frm_t10sheet1_decl_cgo_chg_amt" id="frm_t10sheet1_decl_cgo_chg_amt" value="" dataformat="engup" otherchar="<%=getSpecialChars()%>" onpaste="javascript:mousePaste(this)" class="input"  /><!--
										--><input type="text" style="width: 35px;" value="" id="frm_t10sheet1_decl_cgo_curr_cd" name="frm_t10sheet1_decl_cgo_curr_cd" class="input2" readonly /><!--  
										--><button type="button" class="input_seach_btn" name="pop_del_cgo_curr_cd" id="pop_del_cgo_curr_cd"></button>
									</td>
				        		</tr>
			        		</tbody>
			       		</table>
					
					
		</div>
		<table class="line_bluedot"><tr><td></td></tr></table>
		<!-- opus_design_inquiry(2) (E) -->
	
	
		<!-- opus_design_grid (S) -->
		<div class="opus_design_grid mar_btm_none">
			<div class="opus_design_btn">
				<button type="button" class="btn_normal" name="btn_t10add" id="btn_t10add">Row Add</button>
				<button type="button" class="btn_normal" name="btn_t10del" id="btn_t10del">Row Delete</button>
				<button type="button" class="btn_normal" name="btn_t10merge" id="btn_t10merge">Merge</button>
				<button type="button" class="btn_normal" name="btn_t10surcharge_Inquiry" id="btn_t10surcharge_Inquiry">Surcharge Inquiry</button>
				<button type="button" class="btn_normal" name="btn_t10whf" id="btn_t10whf">WHF exemption</button>
				<button type="button" class="btn_normal" name="btn_t10doc" id="btn_t10doc">DOC Adjustment</button>
				<button type="button" class="btn_normal" name="btn_t10caf" id="btn_t10caf">CAF Adjustment</button>
				<button type="button" class="btn_normal" name="btn_t10bkg_qty" id="btn_t10bkg_qty">Vol. detail</button>
			</div>
			
			<script type="text/javascript">ComSheetObject('t10sheet1');</script>
			<script type="text/javascript">ComSheetObject('t10sheet2');</script>
			<script type="text/javascript">ComSheetObject('t10sheet3');</script>
			<script type="text/javascript">ComSheetObject('t10sheet4');</script>
			<script type="text/javascript">ComSheetObject('t10sheet5');</script>
			<script type="text/javascript">ComSheetObject('t10sheet6');</script>
			<script type="text/javascript">ComSheetObject('t10sheet7');</script>	
			<script type="text/javascript">ComSheetObject('t10sheet8');</script>	
		</div>
		<table class="line_bluedot"><tr><td></td></tr></table>
		<!-- opus_design_grid (E) -->
		
		
		<!-- opus_design_inquiry(3) (S) -->
		<div class="opus_design_inquiry">
		
				<!-- layout_wrap (S) -->
				<div class="layout_wrap">
						<div class="layout_vertical_4 pad_rgt_8">
							<div class="opus_design_inquiry">
								<table class="grid_2">
									<thead>
										<tr>
											<th colspan="2">Prepaid</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<th width="50">Total</th>
											<td class='input2' id="TOTAL_PPD">
											</td>
										</tr>					
										<tr>
											<th>At</th>
											<td>
												<input type="text" style="width: 80px;ime-mode:disabled" class="input" name="frm_p_t10sheet3_ofc_cd" value="" dataformat="engup" maxlength="6"><!--  
												--><input type="text" style="width: 50px;ime-mode:disabled" class="input" name="frm_p_t10sheet3_cnt_cd" value="" dataformat="engup" maxlength="2"><!--  
												--><input type="text" style="width: 80px;ime-mode:disabled" class="input" name="frm_p_t10sheet3_cust_seq" value="" dataformat="num" maxlength="6"><!--  
												--><button type="button" class="input_seach_btn" name="pop_prepaid" id="pop_prepaid"></button><!--  
												--><input type="hidden" name="frm_p_t10sheet3_ofc_cd_enable"><!--  
												--><input type="hidden" name="frm_p_t10sheet3_cust_seq_enable"/>
											</td>
										</tr>
									</tbody>
								</table>
			 				</div>
						</div>
						<div class="layout_vertical_4 pad_rgt_8">
							<div class="opus_design_inquiry">
								<table class="grid_2">
									<thead>
										<tr>
											<th colspan="2">Collect</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<th width="50">Total</th>
											<td class='input2' id="TOTAL_CCT"></td>
										</tr>
										<tr>
											<th>At</th>
											<td>
												<input type="text" style="width: 80px;ime-mode:disabled" class="input" name="frm_c_t10sheet3_ofc_cd" value="" dataformat="engup" maxlength="6"><!--  
												--><input type="text" style="width: 50px;ime-mode:disabled" class="input" name="frm_c_t10sheet3_cnt_cd" value=""  dataformat="engup" maxlength="2"><!--  
												--><input type="text" style="width: 80px;ime-mode:disabled" class="input" name="frm_c_t10sheet3_cust_seq" value=""  dataformat="num" maxlength="6"><!--  
												--><button type="button" class="input_seach_btn" name="pop_collect" id="pop_collect"></button><!--  
												--><input type="hidden" name="frm_c_t10sheet3_ofc_cd_enable"><!--  
												--><input type="hidden" name="frm_c_t10sheet3_cust_seq_enable">
											</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<div class="layout_vertical_4 pad_rgt_8">
							<div class="opus_design_inquiry">
								<table class="grid_2">
									<thead>
										<tr>
											<th colspan="2">3rd Party - PPD</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<th width="50">Total</th>
											<td class='input2' id="TOTAL_3rdPPD"></td>
										</tr>					
										<tr>
											<th>At</th>
											<td class="noinput"><select name='select_3rdPPD' style="width: 100%;"></select></td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<div class="layout_vertical_4">
							<div class="opus_design_inquiry">
								<table class="grid_2">
									<thead>
										<tr>
											<th colspan="2">3rd Party - CCT</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<th width="50">Total</th>
											<td class='input2' id="TOTAL_3rdCCT"></td>
										</tr>
										<tr>
											<th>At</th>
											<td class="noinput"><select name='select_3rdCCT' style="width: 100%;"></select></td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
				</div>
				<!-- layout_wrap (E) -->
			
		</div>
		<!-- opus_design_inquiry(3) (E) -->
	
	
</div>
<!-- wrap_result (E) --> 
				
				
				
<!--biz page - BOTTOM (E)--> <!-- Developer Work End -->
<div id="layList" name="layList" style="position:absolute;z-index:999;display:none" CELLPADDING=5 CELLSPACING=0 BORDER=0/>
<IFRAME id="ifrm" name="ifrm" src="apps/opus/esm/bkg/bookingcommon/bookingutil/jsp/esm_booking_split_no.html"  frameborder=0 marginHeight=0 marginWidth=0 width=115 height=82  style="position:absolute;border:1 #e9e9e9 solid" CELLSPACING=0 scrolling="no"/>
</form>

<%!

	public String getSpecialChars() {
		return " ~!@#$%^&*()`_+-={}|[]\\\"\\':;,./?"; 
	}
		
%>