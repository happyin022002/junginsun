<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0079_05.jsp
*@FileTitle  : Customer Information
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
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.framework.core.controller.util.WebKeys"%>
<%@ page import="com.clt.framework.core.view.template.Screen"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.event.EsmBkg007905Event"%>
<%@ page import="org.apache.log4j.Logger" %>
 
<%
		EsmBkg007905Event  event = null;					//PDTO(Data Transfer Object including Parameters)
		Exception serverException   = null;			//error from server
		String strErrMsg = "";				//error message

		String strUsr_id		= "";
		String strUsr_nm		= "";
		Logger log = Logger.getLogger("com.clt.apps.GeneralBookingConduct.GeneralBookingReceipt");
		String bkgNo = "";
		String isInquiry = "N";		
		try {
		   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
				strUsr_id =	account.getUsr_id();
				strUsr_nm = account.getUsr_nm();


				event = (EsmBkg007905Event)request.getAttribute("Event");
				serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

				if (serverException != null) {
						strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
				}
				
				bkgNo  = JSPUtil.getParameter(request, "bkg_no");
				Screen screen = (Screen) request.getAttribute(WebKeys.CURRENT_SCREEN);
				if (screen.getName().indexOf("Q") >= 0){
						isInquiry = "Y";
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
						ComShowMessage(errMessage);
				} // end if
				loadPage();
		}
</script>

<form name="form" onKeyDown="ComKeyEnter('search')">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="isInquiry" value="<%=isInquiry%>" id="isInquiry" />
<input type="hidden" name="modify_flag" id="modify_flag" />
<input type="hidden" name="ca_flg" id="ca_flg" />
<input type="hidden" name="same_as_flag" id="same_as_flag" />
<input type="hidden" name="old_bkg_no" value="<%=bkgNo%>" id="old_bkg_no" />
<input type="hidden" name="old_bl_no" id="old_bl_no" />
<input type="hidden" name="org_bl_no" id="org_bl_no" />
<input type="hidden" name="bl_tp_cd" id="bl_tp_cd" />
<input type="hidden" name="bl_no_tp" id="bl_no_tp" />
<input type="hidden" name="bdr_flg" id="bdr_flg" />
<input type="hidden" name="bkg_sts_cd" id="bkg_sts_cd" />
<input type="hidden" name="order_found_flag" id="order_found_flag" />
<input type="hidden" name="frob_flag" id="frob_flag" />
<input type="hidden" name="ca_manifest_flag" id="ca_manifest_flag" />
<input type="hidden" name="sc_no" id="sc_no" />
<input type="hidden" name="rfa_no" id="rfa_no" />
<input type="hidden" name="svc_scp_cd" id="svc_scp_cd" />
<input type="hidden" name="appl_dt" id="appl_dt" />
<input type="hidden" name="sh_mdm_address" id="sh_mdm_address" />
<input type="hidden" name="cn_mdm_address" id="cn_mdm_address" />
<input type="hidden" name="nf_mdm_address" id="nf_mdm_address" />
<input type="hidden" name="ff_mdm_address" id="ff_mdm_address" />
<input type="hidden" name="an_mdm_address" id="an_mdm_address" />
<input type="hidden" name="sam_cnee_ntfy_flg" id="sam_cnee_ntfy_flg" />
<input type="hidden" name="ca_exist_flg" id="ca_exist_flg" />
<input type="hidden" name="nl_flag" id="nl_flag" />
<input type="hidden" name="old_act_cust_cd" id="old_act_cust_cd" />

	
<!-- opus_design_btn(S) -->
<div class="opus_design_btn opus_design_normal2">
	<button type="button" class="btn_normal2" name="btn_t5retrieve" id="btn_t5retrieve">Retrieve</button><!--  
--><button type="button" class="btn_normal2" name="btn_t7New" id="btn_t7New">New</button><!--
--><button type="button" class="btn_normal2" name="btn_t7Save" id="btn_t7Save">Save</button><!--
--><button type="button" class="btn_normal2" name="btn_t7CustomerCodeRqst" id="btn_t7CustomerCodeRqst">CUSTOMER CODE RQST</button>
</div>
<!-- opus_design_btn(E) -->	 

<!-- wrap_search (S) -->
<div class="wrap_search coupled_btn_normal2">
	<div class="opus_design_inquiry wFit"> 
		<table> 
			<colgroup>
				<col width="55" />
				<col width="180" />
				<col width="55" />
				<col />
			</colgroup> 
			<tbody>
				<tr>
					<th>BKG No.</th>
					<td><input type="text" name="bkg_no" maxlength="13" style="width:115px;text-transform:uppercase;" class="input" value="" dataformat="engup"  tabindex="1" id="bkg_no" /><!--
					--><button type="button" class="btn_down_list" name="btn_splitPop" id="btn_splitPop"></button></td>
					<th>B/L No.</th>
					<td>
						<input type="text" name="bl_no" id="bl_no" maxlength="13" style="float:left;width:115px;text-transform:uppercase" dataformat="engup"  tabindex="2" id="bl_no" />
						<div style="display:none;float:left" id="org_bl">
							<button type="button" class="btn_down_list" name="btn_OrgBlPop" id="btn_OrgBlPop"></button>
						</div>
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
	<div class="opus_design_inquiry wFit"> 
		<table>
			<colgroup>
				<col width="55" />
				<col width="260" />
				<col width="90" />
				<col width="90" />
				<col />
			</colgroup> 
			<tbody>
				<tr>		
					<th>Route</th>
					<td><input type="text" name="por_cd" style="width:55px;" class="input2" value="" readonly="" id="por_cd" /><!--
						--><input type="text" name="pol_cd" style="width:55px;" class="input2" value="" readonly="" id="pol_cd" /><!--
						--><input type="text" name="pod_cd" style="width:55px;" class="input2" value="" readonly="" id="pod_cd" /><!--
						--><input type="text" name="del_cd" style="width:55px;" class="input2" value="" readonly="" id="del_cd" />
					</td>
					<th>A/Customer</th>
					<td><input type="text" name="agmt_act_cnt_cd" style="width:33px;text-transform:uppercase;" class="input" value="" maxlength="2" dataformat="engup"  readonly id="agmt_act_cnt_cd" /><input type="text" name="agmt_act_cust_seq" style="width:50px;" class="input" value="" maxlength="6" dataformat="num" readonly="" id="agmt_act_cust_seq" /><button type="button" id="btn_t7Sa0190" name="btn_t7Sa0190" class="input_seach_btn"></button></td>
					<td><div id="del_btn"><button type="button" class="btn_etc" name="btn_t7Delete" id="btn_t7Delete">Del</button></div></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(1) (E) -->
	
	
	<!-- opus_design_inquiry(2) (S) -->
	<div class="opus_design_inquiry"> 
			<div class="layout_wrap" style="height: 231px">
			    <div class="layout_flex_fixed" style="width:600px; height: 231px">
			    
					<div class="opus_design_inquiry sm mar_btm_none" style="height: 231px"><table>
					    	<colgroup>
								<col width="100" />
								<col/>
							</colgroup> 
							<tbody>
								<tr>
									<th>Shipper</th>
									<td>
										<input type="text" name="sh_cust_cnt_cd" style="width:30px;ime-mode:disabled;text-transform:uppercase;" class="input1" value="" maxlength=2   dataformat="engup"  tabindex=11><!--
										--><button type="button" name="btn_t7Sh0192" id="btn_t7Sh0192" class="input_seach_btn"></button><!--
										--><input type="text" name="sh_cust_seq" id="sh_cust_seq" style="width:58px;" class="input1" value="" maxlength=6   dataformat="num" tabindex=12 ><!--
										--><button type="button" class="btn_down_list" name="btn_t7ShMdmCustNm" id="btn_t7ShMdmCustNm"></button><!--
										--><input type="text" name="sh_cust_lgl_eng_nm" style="width:191px;" class="input2" value="" readonly><!--
										--><input type="text" style="width:25px;" class="input2" value="" readonly name="sh_cust_tp"><!--
										--><script type="text/javascript" >ComComboObject('kr_cstms_cust_tp_cd', 1, 90, 1, 0, 0)</script>
									</td>
								</tr>
							</tbody>
						</table>	  
						<table class="line_bluedot"><tr><td></td></tr></table>  
						<table> 
							<colgroup>
								<col width="100" />
								<col width="345" />
								<col/>
							</colgroup> 
							<tbody>
								<tr>
									<th>Name</th>
									<td><textarea cols="35" rows="2" style="width:345px; resize:none; font-family:Courier New; font-size:15px; text-indent:0px;overflow-y:scroll;overflow-x:hidden;line-height: 20px;word-break:break-all;" class="textarea_img2" wrap="hard" dataformat="engup" otherchar="<%=getSpecialChars()%>" onpaste="javascript:mousePaste(this)" onblur="javascript:validateCols('2','35',this, 'Shipper');"  name="sh_cust_nm" id="sh_cust_nm"  tabindex="13"></textarea> </td>
									<th style="text-align: left"><button type="button" class="btn_etc" style="width:110px;" name="btn_sh_cust_nm_detail" id="btn_sh_cust_nm_detail"><label id="btn_sh_cust_nm_detail_lbl">Original E-S/I</label></button><br><label id ="sh_ovflw_chk_flg_lbl" for="sh_ovflw_chk_flg">Cleared <input type="checkbox" name="sh_ovflw_chk_flg" id="sh_ovflw_chk_flg" value="Y"></label></th>
									
								</tr>
								<tr>
									<th>Address<br>Print <input type="checkbox" class="trans" name="sh_addr_prn_flg" value="Y" id="sh_addr_prn_flg" /></th>
									<td><textarea cols="35" rows="3" style="width:345px; resize:none;font-family:Courier New; font-size:15px; text-indent:0px;overflow-y:scroll;overflow-x:hidden;line-height: 20px;word-break:break-all" class="textarea_img3" wrap="hard" dataformat="engup" otherchar="<%=getSpecialChars()%>" onpaste="javascript:mousePaste(this)" onblur="javascript:validateCols('3','35',this, 'Shipper');" name="sh_cust_addr" id="sh_cust_addr" tabindex="14"></textarea></td>
								</tr>
							</tbody>
						</table>
						<table>
							<colgroup>
								<col width="100" />
								<col width="180" />
								<col width="65" />
								<col width="60" />
								<col width="60" />
								<col />
							</colgroup> 
							<tbody>
								<tr>
									<th>City / State</th>
									<td><input type="text" name="sh_cust_cty_nm" style="width:125px;text-transform:uppercase;" class="input" value="" tabindex="47" dataformat="exceptengdn" otherchar=" "  maxlength="30" id="sh_cust_cty_nm" /><input type="text" name="sh_cust_ste_cd" style="width:30px;text-transform:uppercase;" class="input" value="" tabindex="16" maxlength="3" dataformat="engup"  id="sh_cust_ste_cd" /></td>
									<th>Country</th>
									<td><input type="text" name="sh_cstms_decl_cnt_cd" style="width:30px;text-transform:uppercase;" class="input" value="" tabindex="49" maxlength="2" dataformat="engup"  id="sh_cstms_decl_cnt_cd" /></td>
									<th>ZIP Code</th>
									<!-- allow to input characters
									<td><input type="text" name="sh_cust_zip_id" style="width:74px;" class="input" value="" tabindex="50" dataformat="num" otherchar="-" maxlength="10" id="sh_cust_zip_id" /><button type="button" id="btn_t7ShZipCode" name="btn_t7ShZipCode" class="input_seach_btn"></button></td>
									 -->
									<td><input type="text" name="sh_cust_zip_id" style="width:74px;" class="input" value="" tabindex="50" dataformat="engup" otherchar="-\s" maxlength="10" id="sh_cust_zip_id" /><button type="button" id="btn_t7ShZipCode" name="btn_t7ShZipCode" class="input_seach_btn"></button></td>
								</tr>
							</tbody>
						</table>
						<table> 
						<colgroup>
								<col width="100" />
								<col width="180" />
								<col width="65" />
								<col />
							</colgroup> 
							<tbody>
								<tr>
									<th>Street / P.O.Box</th>
									<td><input type="text" name="sh_eur_cstms_st_nm" style="width:159px;text-transform:uppercase;" class="input" value="" tabindex="19" dataformat="exceptengdn"  maxlength="50" id="sh_eur_cstms_st_nm" /> </td>
									<th>EORI #</th>
									<td><input type="text" name="sh_eori_no" style="width:223px;text-transform:uppercase;" class="input" value="" tabindex="20" maxlength="20" dataformat="engup"  id="sh_eori_no" /> </td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
				
				
			    <div class="layout_flex_flex" style="padding-left:608px">
					<div class="opus_design_inquiry sm mar_btm_none" style="height: 231px">
						<table>
							<colgroup>
									<col width="120" />
									<col width="347" />
									<col width="50" />
									<col />
							</colgroup> 
							<tbody>
								<tr>
									<th>F/Forwarder</th>
									<td><input type="text" style="width:30px;text-transform:uppercase;" class="input" value="" name="ff_cust_cnt_cd" maxlength="2" dataformat="engup"  tabindex="61" id="ff_cust_cnt_cd" /><!--
										--><button type="button" id="btn_t7Ff0192" name="btn_t7Ff0192" class="input_seach_btn"></button /><!--
										--><input type="text" style="width:58px;" class="input" value="" name="ff_cust_seq" id="ff_cust_seq" maxlength="6" dataformat="num" tabindex="62" /><!--
										--><button type="button" class="btn_down_list" name="btn_t7FfMdmCustNm" id="btn_t7FfMdmCustNm"></button><!--
										--><input type="text" style="width:140px;" class="input2" value="" name="ff_cust_lgl_eng_nm" readonly="" id="ff_cust_lgl_eng_nm" /><!--
										--><input type="text" style="width:25px;" class="input2" value="" readonly="" name="ff_cust_tp" id="ff_cust_tp" /></td>
									<th>FMC No.</th>
									<td><input type="text" name="fmc_cd" maxlength="100" style="width:65px;" class="input" value="" tabindex="63" id="fmc_cd" /></td>
								</tr>
							</tbody>
						</table>
						<table class="line_bluedot"><tr><td></td></tr></table>  
						<table>
							<colgroup>
								<col width="120" />
								<col width="345" />
								<col />
							</colgroup> 
							<tbody>
								<tr>
									<th>Name &amp; Address<br>Print <input type="checkbox" class="trans" name="ff_addr_prn_flg" value="Y" id="ff_addr_prn_flg" /> </th>
									<td><textarea cols="35" rows="5" style="width:345px; resize:none;font-family:Courier New;font-size:15px;text-indent:0px;overflow-y:scroll;line-height: 20px;word-break:break-all" class="textarea_img5" wrap="hard" dataformat="engup" otherchar="<%=getSpecialChars()%>" onpaste="javascript:mousePaste(this)" onblur="javascript:validateCols('5','35',this, 'F/Forwarder');" name="ff_cust_nm" id="ff_cust_nm"tabindex="64"></textarea>
									</td>
									<th style="text-align: left"><button type="button" class="btn_etc" style="width:110px;" name="btn_ff_cust_nm_detail" id="btn_ff_cust_nm_detail"><label id="btn_ff_cust_nm_detail_lbl">Original E-S/I</label></button><br><label id ="ff_ovflw_chk_flg_lbl" for="ff_ovflw_chk_flg">Cleared <input type="checkbox" name="ff_ovflw_chk_flg" id="ff_ovflw_chk_flg" value="Y"><br><br><br><br></label></th>
								</tr>
								<tr  style="height:65px">
								  <th></th>
								  <td></td>
								</tr> 
							</tbody>
						</table>						
					</div>	
			    </div>		
			</div>
	</div>
	<!-- opus_design_inquiry(2) (E) -->
			
			
			
	<!-- opus_design_inquiry(3) (S) -->
	<div class="opus_design_inquiry"> 
			<div class="layout_wrap"  style="height: 260px">
			
			    <div class="layout_flex_fixed" style="width:600px; height: 260px">
					<div class="opus_design_inquiry sm mar_btm_none" style="height: 260px">
				    	<table>
				    		<colgroup>
									<col width="100" />
									<col width="345" />
									<col width="50" />
									<col />
							</colgroup> 
					    	<tbody>
								<tr>
									<th>Consignee</th>
									<td><input type="text" name="cn_cust_cnt_cd" id="cn_cust_cnt_cd" style="width:30px;ime-mode:disabled;text-transform:uppercase;" class="input1" value="" maxlength=2  dataformat="engup"  tabindex=21><!--
										--><button type="button" name="btn_t7Cn0192" id="btn_t7Cn0192" class="input_seach_btn"></button><!--
										--><input type="text" name="cn_cust_seq" id="cn_cust_seq" style="width:58px;" class="input1" value="" maxlength=6   dataformat="num" tabindex=22 ><!--
										--><button type="button" class="btn_down_list" name="btn_t7CnMdmCustNm" id="btn_t7CnMdmCustNm"></button><!--
										--><input type="text" name="cn_cust_lgl_eng_nm" id="cn_cust_lgl_eng_nm" style="width:162px;" class="input2" value="" readonly><!--
										--><input type="text" style="width:25px;" class="input2" value="" readonly name="cn_cust_tp" id="cn_cust_tp"></td>
									<th>B/L Type</th>
									<td><select style="width:75px;" class="input" name="cust_to_ord_flg" id="cust_to_ord_flg">
											<option value="Y">Order</option>
											<option value="N">Straight</option>
										</select>
									</td>
								</tr>
							</tbody>
						</table>
						<table class="line_bluedot"><tr><td></td></tr></table>  
						<table> 
							<colgroup>
								<col width="100" />
								<col width="345" />
								<col/>
							</colgroup> 
							<tbody>
								<tr>
									<th>Name</th>
									<td><textarea cols="35" rows="2" style="width:345px; resize:none;font-family:Courier New; font-size:15px; text-indent:0px;overflow-y:scroll;overflow-x:hidden;line-height: 20px;word-break:break-all;" class="textarea_img2" wrap="hard" dataformat="engup" otherchar="<%=getSpecialChars()%>"  onpaste="javascript:mousePaste(this)" onblur="javascript:validateCols('2','35',this, 'Consignee');" name="cn_cust_nm" id="cn_cust_nm" tabindex="23"></textarea></td>
									<th style="text-align: left"><button type="button" class="btn_etc" style="width:110px;" name="btn_cn_cust_nm_detail" id="btn_cn_cust_nm_detail"><label id="btn_cn_cust_nm_detail_lbl">Original E-S/I</label></button><br><label id ="cn_ovflw_chk_flg_lbl" for="cn_ovflw_chk_flg">Cleared <input type="checkbox" name="cn_ovflw_chk_flg" id="cn_ovflw_chk_flg" value="Y"></label></th>
								</tr>
								<tr>
									<th>Address<br>Print <input type="checkbox" class="trans" name="cn_addr_prn_flg" value="Y" id="cn_addr_prn_flg" /> </th>
									<td><textarea cols="35" rows="3" style="width:345px; resize:none; font-family:Courier New; font-size:15px; text-indent:0px;overflow-y:scroll;overflow-x:hidden;line-height: 20px;word-break:break-all" class="textarea_img3" wrap="hard" dataformat="engup" otherchar="<%=getSpecialChars()%>"  onpaste="javascript:mousePaste(this)" onblur="javascript:validateCols('3','35',this, 'Consignee');" name="cn_cust_addr" id="cn_cust_addr" tabindex="24"></textarea></td>
								</tr>
							</tbody>
						</table>
						<table> 
							<colgroup>
								<col width="100" />
								<col width="180" />
								<col width="65" />
								<col width="60" />
								<col width="60" />
								<col />
							</colgroup> 
							<tbody>
								<tr>
									<th>City / State</th>
									<td><input type="text" name="cn_cust_cty_nm" style="width:125px;text-transform:uppercase;" class="input" value="" tabindex="47" dataformat="exceptengdn"  maxlength="30" id="cn_cust_cty_nm" /><input type="text" name="cn_cust_ste_cd" style="width:30px;text-transform:uppercase;" class="input" value="" tabindex="28" maxlength="3" dataformat="engup"  id="cn_cust_ste_cd" /></td>
									<th>Country</th>
									<td><input type="text" name="cn_cstms_decl_cnt_cd" style="width:30px;text-transform:uppercase;" class="input" value="" tabindex="49" maxlength="2" dataformat="engup"  id="cn_cstms_decl_cnt_cd" /></td>
									<th>ZIP Code</th>
									<!-- allow to input characters
									<td><input type="text" name="cn_cust_zip_id" style="width:74px;" class="input" value="" tabindex="50" dataformat="num" otherchar="-" maxlength="10" id="cn_cust_zip_id" /><button type="button" id="btn_t7CnZipCode" name="btn_t7CnZipCode" class="input_seach_btn"></button></td>
									-->
									<td><input type="text" name="cn_cust_zip_id" style="width:74px;" class="input" value="" tabindex="50" dataformat="engup" otherchar="-\s" maxlength="10" id="cn_cust_zip_id" /><button type="button" id="btn_t7CnZipCode" name="btn_t7CnZipCode" class="input_seach_btn"></button></td>
								</tr>
							</tbody>
						</table>
						<table> 
							<colgroup>
								<col width="100" />
								<col width="180" />
								<col width="65" />
								<col />
							</colgroup> 
							<tbody>
								<tr>
									<th>Street / P.O.Box</th>
									<td><input type="text" name="cn_eur_cstms_st_nm" style="width:159px;text-transform:uppercase;" class="input" value="" tabindex="31" dataformat="exceptengdn"  maxlength="50" id="cn_eur_cstms_st_nm" /> </td>
									<th>EORI #</th>
									<td><input type="text" name="cn_eori_no" style="width:223px;text-transform:uppercase;" class="input" value="" tabindex="32" maxlength="20" dataformat="engup"  id="cn_eori_no" /> </td>
								</tr>
								<tr>
									<th>Fax</th>
									<td><input type="text" name="cn_cust_fax_no" style="width:159px;" class="input" value="" maxlength="20" dataformat="num" otherchar="-" tabindex="25" id="cn_cust_fax_no" /> </td>
									<th>E-mail</th>
									<td><input type="text" name="cn_cust_eml" style="width:223px;" class="input" value="" maxlength="200" tabindex="26" id="cn_cust_eml" /> </td>
								</tr>
							</tbody>
						</table>	
					</div>
				</div>
				
				
			    <div class="layout_flex_flex" style="padding-left:608px">
					<div class="opus_design_inquiry sm mar_btm_none" style="height: 260px">
						<table>
							<colgroup>
								<col width="120" />
								<col />
							</colgroup> 
							<tbody>
								<tr>
						 			<th>A/Notify</th>
									<td><input type="text" style="width:30px;text-transform:uppercase;" class="input" value="" name="an_cust_cnt_cd" maxlength="2" dataformat="engup"  tabindex="71" id="an_cust_cnt_cd" /><!--
										--><button type="button" id="btn_t7An0192" name="btn_t7An0192" class="input_seach_btn"></button /><!--
										--><input type="text" style="width:58px;" class="input" value="" name="an_cust_seq" id="an_cust_seq" maxlength="6" dataformat="num" tabindex="72" id="an_cust_seq" /><!--
										--><button type="button" class="btn_down_list" name="btn_t7AnMdmCustNm" id="btn_t7AnMdmCustNm"></button><!--
										--><input type="text" style="width:191px;" class="input2" value="" name="an_cust_lgl_eng_nm" readonly="" id="an_cust_lgl_eng_nm" /><!--
										--><input type="text" style="width:25px;" class="input2" value="" readonly="" name="an_cust_tp" id="an_cust_tp" />
									</td>
								</tr>
							</tbody>
						</table>	
						<table class="line_bluedot"><tr><td></td></tr></table>  	
						<table> 
							<colgroup>
								<col width="120" />
								<col width="345" />
								<col />
							</colgroup> 
							<tbody>
								<tr>
									<th>Name &amp; Address<br>Print <input type="checkbox" class="trans" name="an_addr_prn_flg" value="Y" id="an_addr_prn_flg" /> </th>
									<td><textarea cols="35" rows="5" style="width:345px; resize:none;font-family:Courier New; font-size:15px; text-indent:0px;overflow-y:scroll;overflow-x:hidden;line-height: 20px;word-break:break-all" class="textarea_img5" wrap="hard" dataformat="engup" otherchar="<%=getSpecialChars()%>" onpaste="javascript:mousePaste(this)" onblur="javascript:validateCols('5','35',this, 'A/Notify');" name="an_cust_nm" id="an_cust_nm"tabindex="73"></textarea></td>
									<th style="text-align: left"><button type="button" class="btn_etc" style="width:110px;" name="btn_an_cust_nm_detail" id="btn_an_cust_nm_detail"><label id="btn_an_cust_nm_detail_lbl">Original E-S/I</label></button><br><label id ="an_ovflw_chk_flg_lbl" for="an_ovflw_chk_flg">Cleared <input type="checkbox" name="an_ovflw_chk_flg" id="an_ovflw_chk_flg" value="Y"><br><br><br><br></label></th>
								</tr>
							</tbody>
						</table>	
						<table>
							<colgroup>
								<col width="120" />
								<col width="100" />
								<col />
							</colgroup> 
							<tbody>
								<tr>
									<th>Fax</th>
									<td><input type="text" class="input" value="" name="an_cust_fax_no" maxlength="20" dataformat="num" otherchar="-" tabindex="74" id="an_cust_fax_no" /> </td>
									<th>E-mail</th>
									<td><input type="text" class="input" style="width:220px;""value="" name="an_cust_eml" maxlength="200" tabindex="75" id="an_cust_eml" /> </td>
								</tr>
							</tbody>						
						</table>
						<table>
							<colgroup>
								<col width="120" />
								<col />
							</colgroup> 
							<tbody>
								<tr  style="height:67px">
								  <th></th>
								  <td></td>
								</tr> 
							</tbody>
						</table>								
	
					</div>	
			    </div>		
			</div>
	</div>
	<!-- opus_design_inquiry(3) (E) -->
	
				
			
	
	<!-- opus_design_inquiry(4) (S) -->
	<div class="opus_design_inquiry"> 
			<div class="layout_wrap" style="height: 260px">
			
			    <div class="layout_flex_fixed" style="width:600px; height: 260px">
					<div class="opus_design_inquiry sm mar_btm_none" style="height: 260px">
			    		<table>
			    			<colgroup>
									<col width="100" />
									<col />
							</colgroup> 
				    		<tbody>
								<tr>
					 				<th>Notify</th>  
									<td><input type="text" style="width:30px;text-transform:uppercase;" class="input" value="" name="nf_cust_cnt_cd" maxlength="2" dataformat="engup"  tabindex="41" id="nf_cust_cnt_cd" /><!--
										--><button type="button" id="btn_t7Nf0192" name="btn_t7Nf0192" class="input_seach_btn"></button /><!--
										--><input type="text" style="width:58px;" class="input" value="" name="nf_cust_seq" id="nf_cust_seq" maxlength="6" dataformat="num" tabindex="42" id="nf_cust_seq" /><!--
										--><button type="button" class="btn_down_list" name="btn_t7NfMdmCustNm" id="btn_t7NfMdmCustNm"></button><!--
										--><input type="text" style="width:162px;" class="input2" value="" name="nf_cust_lgl_eng_nm" readonly="" id="nf_cust_lgl_eng_nm" /><!--
										--><input type="text" style="width:25px;" class="input2" value="" readonly="" name="nf_cust_tp" id="nf_cust_tp" />
									</td>
									<td></td>
								</tr>
							</tbody>
						</table>
						<table class="line_bluedot"><tr><td></td></tr></table>  
						<table> 
						<colgroup>
								<col width="100" />
								<col width="345" />
								<col />
							</colgroup> 
							<tbody>
								<tr>
									<th>Name</th>
									<td><textarea cols="35" rows="2" style="width:345px; resize:none; font-family:Courier New; font-size:15px; text-indent:0px;overflow-y:scroll;overflow-x:hidden;line-height: 20px;word-break:break-all" class="textarea_img2" wrap="hard" dataformat="engup" otherchar="<%=getSpecialChars()%>" onpaste="javascript:mousePaste(this)" onblur="javascript:validateCols('2','35',this, 'Notify');" name="nf_cust_nm" id="nf_cust_nm"tabindex="43"></textarea></td>
									<th style="text-align: left"><button type="button" class="btn_etc" style="width:110px;" name="btn_nf_cust_nm_detail" id="btn_nf_cust_nm_detail"><label id="btn_nf_cust_nm_detail_lbl">Original E-S/I</label></button><br><label id ="nf_ovflw_chk_flg_lbl" for="nf_ovflw_chk_flg">Cleared <input type="checkbox" name="nf_ovflw_chk_flg" id="nf_ovflw_chk_flg" value="Y"></label></th>
								</tr>
								<tr>
									<th>Address<br>Print <input type="checkbox" class="trans" name="nf_addr_prn_flg" value="Y" id="nf_addr_prn_flg" /><br/>Same as<br/>CNEE <input type="checkbox" value="" class="trans" name="sam_cnee_copy_flg" id="sam_cnee_copy_flg" /> </th>
									<td><textarea cols="35" rows="3" style="width:345px; resize:none; font-family:Courier New; font-size:15px; text-indent:0px;overflow-y:scroll;overflow-x:hidden;line-height: 20px;word-break:break-all" class="textarea_img3" wrap="hard" dataformat="engup" otherchar="<%=getSpecialChars()%>" onpaste="javascript:mousePaste(this)" onblur="javascript:validateCols('3','35',this, 'Notify');" name="nf_cust_addr" id="nf_cust_addr" tabindex="44"></textarea></td>
								</tr>
							</tbody>
						</table>
						<table> 
							<colgroup>
								<col width="100" />
								<col width="180" />
								<col width="65" />
								<col width="60" />
								<col width="60" />
								<col />
							</colgroup> 
							<tbody>
								<tr>
									<th>City / State</th>
									<td><input type="text" style="width:125px;text-transform:uppercase;" class="input" value="" name="nf_cust_cty_nm" tabindex="47" dataformat="exceptengdn"  maxlength="30" id="nf_cust_cty_nm" /><input type="text" style="width:30px;text-transform:uppercase;" class="input" value="" name="nf_cust_ste_cd" tabindex="48" maxlength="3" dataformat="engup"  id="nf_cust_ste_cd" /> </td>
									<th>Country</th>
									<td><input type="text" style="width:30px;text-transform:uppercase;" class="input" value="" name="nf_cstms_decl_cnt_cd" tabindex="49" maxlength="2" dataformat="engup"  id="nf_cstms_decl_cnt_cd" /> </td>
									<th>ZIP Code</th>
									<!-- allow to input characters
									<td><input type="text" style="width:74px;" class="input" value="" name="nf_cust_zip_id" tabindex="50" dataformat="num" otherchar="-" maxlength="10" id="nf_cust_zip_id" /><button type="button" id="btn_t7NfZipCode" name="btn_t7NfZipCode" class="input_seach_btn"></button /></td>
									-->
									<td><input type="text" style="width:74px;" class="input" value="" name="nf_cust_zip_id" tabindex="50" dataformat="engup" otherchar="-\s" maxlength="10" id="nf_cust_zip_id" /><button type="button" id="btn_t7NfZipCode" name="btn_t7NfZipCode" class="input_seach_btn"></button /></td>
								</tr>
							</tbody>
						</table>
						<table> 
							<colgroup>
								<col width="100" />
								<col width="180" />
								<col width="65" />
								<col />
							</colgroup> 
							<tbody>
								<tr>
									<th>Street / P.O.Box</th>
									<td><input type="text" name="nf_eur_cstms_st_nm" style="width:159px;text-transform:uppercase;" class="input" value="" tabindex="51" dataformat="exceptengdn"  maxlength="20" id="nf_eur_cstms_st_nm" /> </td>
									<th>EORI #</th>
									<td><input type="text" name="nf_eori_no" style="width:223px;text-transform:uppercase;" class="input" value="" tabindex="52" maxlength="20" dataformat="engup"  id="nf_eori_no" /> </td>
								</tr>
								<tr>
									<th>Fax</th>
									<td><input type="text" style="width:159px;" class="input" value="" name="nf_cust_fax_no" maxlength="20" dataformat="num" otherchar="-" tabindex="45" id="nf_cust_fax_no" /> </td>
									<th>E-mail</th>
									<td><input type="text" style="width:223px;" class="input" value="" name="nf_cust_eml" maxlength="200" tabindex="46" id="nf_cust_eml" /> </td>
								</tr>
								</tbody>
						</table>						
					</div>
				</div>
				
			    <div class="layout_flex_flex" style="padding-left:608px">
					<div class="opus_design_inquiry sm mar_btm_none" style="height: 260px">
						<table>
							<colgroup>
								<col width="123" />
								<col />
							</colgroup>
							<tbody>
								<tr>
						 			<th>Export Ref.</th>	
						 			<td style="height:25px"></td>	
						 			<td style="height:25px"></td>
								</tr>
							</tbody>
						</table>
						<table class="line_bluedot"><tr><td></td></tr></table>  			
						<table>
							<colgroup>
								<col width="123" />
								<col width="345" />
								<col />
							</colgroup>  
							<tbody>
								<tr>
									<th>Print <input type="checkbox" class="trans" name="ex_addr_prn_flg" value="Y" tabindex="81" id="ex_addr_prn_flg" /> </th>
									<td><textarea cols="35" rows="3" style="width:345px; resize:none; font-family:Courier New; font-size:15px; text-indent:0px;overflow-y:scroll;overflow-x:hidden;line-height: 20px;word-break:break-all" class="textarea_img3" wrap="hard" dataformat="engup" otherchar="<%=getSpecialChars()%>" onpaste="javascript:mousePaste(this)" onblur="javascript:validateCols('5','35',this, 'Export Ref.');" name="ex_cust_nm" id="ex_cust_nm" tabindex="82"></textarea></td>
									<th style="text-align: left"><button type="button" class="btn_etc" style="width:110px;" name="btn_ex_cust_nm_detail" id="btn_ex_cust_nm_detail"><label id="btn_ex_cust_nm_detail_lbl">Original E-S/I</label></button><label id ="ex_ovflw_chk_flg_lbl"  for = "ex_ovflw_chk_flg"><br>Cleared <input type="checkbox" name="ex_ovflw_chk_flg" id="ex_ovflw_chk_flg" value="Y"><br><br></label></th>
									</tr>
							</tbdcy>
						</table>
						<table>
							<colgroup>
								<col width="123" />
								<col width="200" />
								<col width="40" />
								<col />
							</colgroup>  
							<tbody>
								<tr>
									<th>Forwarder's Ref. No.</th>
									<td><input type="text" style="width:100px;" class="input" value="" name="ff_ref_no" tabindex="83" id="ff_ref_no" /><!--
										--><button type="button" class="btn_plus" name="btn_t7FwRefNo" id="btn_t7FwRefNo"></button><!--
										--><button type="button" id="btn_t7ExRef" name="btn_t7ExRef" class="input_seach_btn"></button></td>
									<th>EDI Ref.</th>
									<td><input type="text" style="width:30px;text-transform:uppercase;" class="input" value="" name="ex_cust_cnt_cd" maxlength="2" dataformat="engup"  tabindex="84" id="ex_cust_cnt_cd" /><!--
										--><input type="text" style="width:58px;" class="input" value="" name="ex_cust_seq" maxlength="6" dataformat="num" tabindex="85" id="ex_cust_seq" /><!--
										--><button type="button" id="btn_t7Ex0192" name="btn_t7Ex0192" class="input_seach_btn"></button></td>
								</tr>
							</tbidy>
						</table>
						<table>
							<colgroup>
								<col width="123" />
								<col width="200" />
								<col width="40" />
								<col />
							</colgroup>  
							<tbody>
								<tr>
									<th>Country of Origin</th>
									<td colspan="3"><input type="text" style="width:373px;text-transform:uppercase;" class="input" value="" name="org_cnt_nm" dataformat="exceptengdn"  tabindex="86" maxlength="35" id="org_cnt_nm" /> </td>
								</tr>
								<tr>
									<th></th>
									<td colspan="3" style="height:74px"></td>
								</tr>
							</tbody>
						</table>															
					</div>	
			    </div>	
			    	
			</div>
	</div>
	<!-- opus_design_inquiry(4) (E) -->
	
	
	
</div>
<!-- wrap_result (E) -->





<div class="wrap_result">
	<div class="opus_design_grid" >
		<script type="text/javascript">ComSheetObject('t7sheet1');</script>
	</div>
	<div class="opus_design_grid" style="Display :none">
		<script type="text/javascript">ComSheetObject('t7sheet2');</script>
	</div>
</div>
<div id="layList" name="layList" style="position:absolute;z-index:999;display:none" CELLPADDING=5 CELLSPACING=0 BORDER=0/>
<div id="orgBlNo" style="position:absolute;left:0;top:0;width:0;height:0;"></div>  
<IFRAME id="ifrm" name="ifrm" src="apps/opus/esm/bkg/bookingcommon/bookingutil/jsp/esm_booking_split_no.html"  frameborder=0 marginHeight=0 marginWidth=0 width=115 height=82  style="position:absolute;border:1 #e9e9e9 solid" CELLSPACING=0 scrolling="no"/>
</form>

<%!

	public String getSpecialChars() {
		return " ~!@#$%^&*()`_+-={}|[]\\\"\\':;,./?"; 
	}
		
%>
