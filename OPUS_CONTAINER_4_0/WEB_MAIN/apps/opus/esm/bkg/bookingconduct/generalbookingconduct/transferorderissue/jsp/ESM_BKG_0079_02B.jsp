<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0079_02B.jsp
*@FileTitle  : TRO(Transportation Request Order) for Inland Haulage
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
<%@ page import="com.clt.framework.core.view.template.Screen"%>
<%@ page import="com.clt.framework.core.controller.util.WebKeys"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.event.EsmBkg007902bEvent"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg007902bEvent  event = null;			//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;			//error from server
	String strErrMsg = "";				//error message


    String bkgNo = "";	
	Logger log = Logger.getLogger("com.clt.apps.GeneralBookingConduct.TransferOrderIssue");
	String isInquiry = "N";	
	Screen screen = (Screen) request.getAttribute(WebKeys.CURRENT_SCREEN);
	//inquiry mode
	if (screen.getName().indexOf("Q") >= 0){
		isInquiry = "Y";
	} else {
		isInquiry = "N";			
	}
	try {

		event = (EsmBkg007902bEvent)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		if (event != null) {
		    bkgNo = event.getBkgNo();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<style type="text/css">
.input2_2		{  height: 20px; border: #7896B1 1px solid; font-family: Tahoma,Arial,dotum,gulim; font-size: 12px; color: #606060; text-indent: 2px;  background-color:#E8E7EC; font-weight:bold;}
 .mar_top_6 {margin-top:6px!important} 
</style>

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

<input type="hidden" name="io_bnd_cd" value="O" id="io_bnd_cd" />
<input type="hidden" name="rtn_tro_flg" value="N" id="rtn_tro_flg" />
<input type="hidden" name="conti_cd" value="" id="conti_cd" />
<input type="hidden" name="oldBkgNo" value="" id="oldBkgNo" />
<input type="hidden" name="oldBlNo" value="" id="oldBlNo" />
<input type="hidden" name="pcInqFlag" value="N" id="pcInqFlag" />
<input type="hidden" name="routeModifyFlag" value="N" id="routeModifyFlag" />
<input type="hidden" name="ca_flg" value="" id="ca_flg" />
<input type="hidden" name="f_del_flg" value="" id="f_del_flg" />
<input type="hidden" name="post_flg" value="" id="post_flg" />
<input type="hidden" name="max_tro_seq_old" value="0" id="max_tro_seq_old" />
<input type="hidden" name="max_tro_seq_rtn_old" value="0" id="max_tro_seq_rtn_old" />
<input type="hidden" name="cfm_sys_date" value="" id="cfm_sys_date" />
<!-- Booking Header : hidden information -->
<input type="hidden" name="por_nod_cd" value="" id="por_nod_cd" />
<input type="hidden" name="pickup_cy1" value="" id="pickup_cy1" />
<input type="hidden" name="pickup_cy2" value="" id="pickup_cy2" />
<input type="hidden" name="dor_arr_dt" value="" id="dor_arr_dt" />
<input type="hidden" name="dor_arr_dt_hhmi" value="" id="dor_arr_dt_hhmi" />
<input type="hidden" name="pkup_dt"         value="" id="pkup_dt" />
<input type="hidden" name="pkup_dt_hhmi"    value="" id="pkup_dt_hhmi" />
<input type="hidden" name="cmdt_nm" value="" id="cmdt_nm" />
<input type="hidden" name="etb_dt" value="" id="etb_dt" />
<input type="hidden" name="curr_rtn_tro_flg" value="" id="curr_rtn_tro_flg" />
<input type="hidden" name="curr_tro_seq" value="" id="curr_tro_seq" />
<input type="hidden" name="curr_mod_cd" value="" id="curr_mod_cd" />
<input type="hidden" name="cfm_flg_old" value="N" id="cfm_flg_old" />
<input type="hidden" name="cxl_flg_old" value="N" id="cxl_flg_old" />
<input type="hidden" name="t2_cxl_flg_old" value="N" id="t2_cxl_flg_old" />
<input type="hidden" name="fd_grd_flg" value="" id="fd_grd_flg" />
<input type="hidden" name="spcl_hide_flg" value="" id="spcl_hide_flg" />
<input type="hidden" class="noinput" name="modify_flag" value="N" id="modify_flag" />
<input type="hidden" name="isInquiry" value="<%=isInquiry%>" id="isInquiry" />
<input type="hidden" name="flatfile" style="width:770;" value=""><!-- hidden : request_receive -->

<!-- page_title_area(S) -->
<div class="opus_design_btn opus_design_normal2">
		<button class="btn_accent" name="btn_t2bRetrieve" id="btn_t2bRetrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_t2bSaveSeq" id="btn_t2bSaveSeq" type="button">Save</button><!--
		--><button class="btn_normal" name="btn_t2bCancelSeq" id="btn_t2bCancelSeq" type="button">Cancel</button><!--
		--><button class="btn_normal" name="btn_t2bAddSeq" id="btn_t2bAddSeq" type="button">Add Seq.</button><!--
		--><button class="btn_normal" name="btn_t2bCopySeq" id="btn_t2bCopySeq" type="button">Copy Seq.</button><!--
		--><button class="btn_normal" name="btn_t2bTROCopy" id="btn_t2bTROCopy" type="button">TRO Copy</button><!--
		--><button class="btn_normal" name="btn_t2bSave" id="btn_t2bSave" type="button">Save All</button><!--
		--><button class="btn_normal" name="btn_t2bCancelAll" id="btn_t2bCancelAll" type="button">Cancel All</button><!--
		--></div>
	<!-- opus_design_btn (E) -->
</div>
<!-- page_title_area(E) -->

<span class="clear"></span>

<div class="wrap_search coupled_btn_normal2">
	<div class="opus_design_inquiry wFit">
		  <table>
		    <tbody>
		      <tr>
		        <th width="54">BKG No.</th>
				<td width="150"><input type="text" name="bkg_no" style="width:115px;" value="<%=bkgNo%>" class="input" maxlength="13" dataformat="engup" tabindex="1" id="bkg_no" /><!--
							--><button type="button" class="btn_down_list" id="btn_splitPop" name="btn_splitPop"></button></td>
		        <th width="60">B/L No.</th>
			    <td><input type="text" name="bl_no" style="width:115px;" value="" class="input" maxlength="13" dataformat="engup" tabindex="2" id="bl_no" /></td>
			  </tr>
		    </tbody>
		  </table>
	</div>
</div>

<div class="wrap_search_tab">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<div class="layout_wrap">
			<div class="layout_flex_fixed floatR" style="width:500px">
				<h3 class="title_design">Total Volume</h3>
				<div class="opus_design_grid">
					<script type="text/javascript">ComSheetObject('t2bsheet5');</script>
				</div>
			</div>
			<div class="layout_flex_flex" style="padding-right:508px">
				<table>
					<colgroup>
						<col width="50" />
						<col width="180" />
						<col width="60" />
						<col width="*" />
					</colgroup>
				   <tbody>
				   		<tr>
							<th>Status</th>
							<td><input type="text" name="bkg_sts_cd" style="width:32px;" value="" class="input2" readonly tabindex="-1" id="bkg_sts_cd" /></td>
							<th>Commodity</th>
							<td><input type="text" name="cmdt_cd" id="cmdt_cd" style="width:60px;" value="" class="input2" readonly onMouseOver="drs(document.form.cmdt_nm.value); return true;" onMouseOut="nd(); return true;" tabindex=-1></td>
				   		</tr>
				   </tbody>
				</table>
				<table>
					<colgroup>
						<col width="50" />
						<col width="180" />
						<col width="60" />
						<col width="*" />
					</colgroup>
					<tbody>
						<tr>
							<th>T/VVD</th>
							<td><input type="text" name="vsl_cd" style="width:50px;" value="" class="input2" readonly tabindex="-1" id="vsl_cd" /><!--
							--><input type="text" name="skd_voy_no" style="width:50px;" value="" class="input2" readonly tabindex="-1" id="skd_voy_no" /><!--
							--><input type="text" name="skd_dir_cd" style="width:36px;" value="" class="input2" readonly tabindex="-1" id="skd_dir_cd" />
							</td>
							<th>Route</th>
							<td><input type="text" name="por_cd" style="width:50px;" value="" class="input2" readonly tabindex="-1" id="por_cd" /><!--
							--><input type="text" name="pol_code" style="width:50px;" value="" class="input2" readonly tabindex="-1" id="pol_code" /><!--
							--><input type="text" name="pod_cd" style="width:50px;" value="" class="input2" readonly tabindex="-1" id="pod_cd" /><!--
							--><input type="text" name="del_cd" style="width:50px;" value="" class="input2" readonly tabindex="-1" id="del_cd" /></td>
							<!--td>Return CY</td-->
							<td style="display:none"><input type="hidden" name="return_cy1" style="width:60px;" value="" class="input2" readonly tabindex="-1" id="return_cy1" /><!--
							--><input type="hidden" name="return_cy2" style="width:30px;" value="" class="input2" readonly tabindex="-1" id="return_cy2" /></td>
						</tr>
					</tbody>
				</table>
				<table>
					<colgroup>
						<col width="90" />
						<col width="90" />
						<col width="100" />
						<col width="110" />
						<col width="110" />
						<col width="120" />
						<col width="*" />
					</colgroup>
					<tbody>
						<tr>
							<td><input type="checkbox" name="dcgo_flg" class="trans mar_top_6" disabled tabindex="-1" id="dcgo_flg" /><!--
							--><button class="btn_etc mar_left_4" name="btn_Danger" id="btn_Danger" type="button">Danger</button></td>
							<td><input type="checkbox" name="rc_flag" class="trans mar_top_6" disabled id="rc_flag" /><!--
							--><button class="btn_etc mar_left_4" name="btn_Reefer" id="btn_Reefer" type="button">Reefer</button></td>
							<td><input type="checkbox" name="awk_cgo_flg" class="trans mar_top_6" disabled tabindex="-1" id="awk_cgo_flg" /><!--
							--><button class="btn_etc mar_left_4" name="btn_Awkward" id="btn_Awkward" type="button">Awkward</button></td>
							<td><input type="checkbox" name="bb_cgo_flg" class="trans mar_top_6" disabled tabindex="-1" id="bb_cgo_flg" /><!--
							--><button class="btn_etc mar_left_4" name="btn_Bulk" id="btn_Bulk" type="button">Break Bulk</button></td>
							<td><input type="checkbox" name="rd_cgo_flg" class="trans mar_top_6" disabled tabindex="-1" id="rd_cgo_flg" /><!--
							--><button class="btn_etc mar_left_4" name="btn_RDry" id="btn_RDry" type="button">Reefer/Dry</button></td>
							<th>Receiving Term</th>
							<td><input type="text" name="term" style="width:28px;" class="input2" readonly tabindex="-1" id="term" /></td>
						</tr>
					</tbody>
				</table>
				<table>
					<colgroup>
						<col width="50" />
						<col width="*" />
					</colgroup>
					<tbody>
						<tr>
							<th>Shipper</th>
							<td><input type="text" name="cust_cnt_cd" style="width:30px;" value="" class="input2" readonly tabindex="-1" id="cust_cnt_cd" /><!--
							--><input type="text" name="cust_seq" style="width:70px;" value="" class="input2" readonly tabindex="-1" id="cust_seq" /><!--
							--><input type="text" name="cust_nm" style="width:490px;" value="" class="input2" readonly tabindex="-1" id="cust_nm" /></td>
						</tr>
					</tbody>
				</table>	
			</div>			
		</div>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_tab (S) -->
	<div class="opus_design_tab">
		<script type="text/javascript">ComTabObject('tab3')</script>
	</div>
	<!-- opus_design_tab (E) -->
	
	<!--TAB TRO/B + General (S) -->
	<div id="tabLayer_trob" style="display:inline">
		<div class="opus_design_inquiry">
			<table>
				<colgroup>
					<col width="100">				
					<col width="110">				
					<col width="100">				
					<col width="50">				
					<col width="50">				
					<col width="50">				
					<col width="60">				
					<col width="*">				
			   </colgroup>
			   <tbody>
			   		<tr>
			   			<th>Seq.</th>
						<td><!-- TRO seq : combo output Start ----------->
							<!--select name="tro_seq" id="tro_seq" style="width:46;"></select
							--><script type="text/javascript">ComComboObject('tro_seq', 1, 46, 1);</script><!--
							--><!-- TRO seq : combo output End--------------><!--
							--><input type="text" name="tro_seq_maxcnt" style="width:30px;" class="input2" readonly="" tabindex="-1" id="tro_seq_maxcnt" />
						<th>Receiving Term</th>
						<td><input type="text" name="rcv_term_cd" style="width:30px;" class="input2" readonly="" tabindex="-1" id="rcv_term_cd" /></td>
						<th>S/O</th>
						<td><input type="text" name="so_flg" style="width:25px;" value="" class="input2" readonly tabindex="-1" id="so_flg" /></td>
						<!-- td width="100">Request Result</td -->
						<td style="display:none"><input type="hidden" name="ack_sts_cd" style="width:62px;" value="" class="input2" readonly tabindex="-1" id="ack_sts_cd" /></td>
						<!-- td width="88">Request Date</td -->
						<td style="display:none"><input type="hidden" name="rqst_dt" style="width:120px;" class="input2" readonly tabindex="-1" id="rqst_dt" /></td>
						<th><label for="ownr_trk_flg">S/TRK</label></th>
						<td><input type="checkbox" name="ownr_trk_flg" class="trans" tabindex="-1" id="ownr_trk_flg" /></td>
			   		</tr>
			   </tbody>
			</table>
			<table>
				<colgroup>
					<col width="100">				
					<col width="450">				
					<col width="50">				
					<col width="80">				
					<col width="50">				
					<col width="80">				
					<col width="60">				
					<col width="*">				
			   </colgroup>
			   <tbody>
			   		<tr>
			   			<th>Actual Customer</th>
						<td><input type="text" name="act_shpr_cnt_cd" style="width:40px;" class="input" maxlength="2" dataformat="engup" tabindex="4" id="act_shpr_cnt_cd" /><!--
						--><input type="text" name="act_shpr_seq" style="width:60px;" class="input" maxlength="6" dataformat="num" tabindex="5" id="act_shpr_seq" /><!--
						--><input type="text" name="act_shpr_nm" style="width:300px;" class="input1" maxlength="50" dataformat="engup" tabindex="6" id="act_shpr_nm" otherchar=" &*-./"/><!--
						--><button type="button" id="btns_popActCust" name="btns_popActCust" class="input_seach_btn"></button></td>
						<th>DG Seq.</th> 
						<td>
					        <!-- D/G seq : combo output Start ----------->
							<script type="text/javascript">ComComboObject('dcgo_seq', 2, 70, 1);</script>
							<!-- D/G seq : combo output End-------------->	
						</td>
						<th>R/F Seq.</th>
						<td>
					        <!-- R/F seq : combo output Start ----------->
							<script type="text/javascript">ComComboObject('rc_seq', 2, 70, 1);</script>
							<!-- R/F seq : combo output End-------------->
						</td>
						<th>A/K Seq.</th>
						<td>
					        <!-- A/K Seq : combo output Start ----------->
							<script type="text/javascript">ComComboObject('awk_cgo_seq', 1, 70, 1);</script>
							<!-- A/K Seq  : combo output End--------------> 
						</td>
			   		</tr>
			   </tbody>
			</table>
			<table>
				<colgroup>
					<col width="100" />				
					<col width="140" />				
					<col width="70" />				
					<col width="130" />				
					<col width="80" />				
					<col width="130" />				
					<col width="100" />				
					<col width="120" />			
					<col width="140" />			
					<col width="*" />				
			   </colgroup> 
			   <tbody>
			   		<tr>
						<th>Location</th>
						<td><input type="text" name="dor_loc_cd" caption="Locaction Code" style="width:63px;" class="input" maxlength="5" dataformat="engup" fullfill="" tabindex="10" id="dor_loc_cd" /><!--
						--><input type="text" name="zn_cd" style="width:30px;" class="input" maxlength="2" tabindex="11" id="zn_cd" style="ime-mode:disabled;text-transform:uppercase;" dataformat="engup" /><!--
						--><button type="button" id="btns_popLocation" name="btns_popLocation" class="input_seach_btn"></button></td>
						<th>Zip</th>
						<td><input type="text" name="dor_pst_no" style="width:55px;" class="input" caption="Zip" maxlength="12" dataformat="engup" value="" tabindex="12" id="dor_pst_no" otherchar=" &*-./" /></td>
						<th>BIZ Ref.No.</th>
						<td><input type="text" name="biz_rgst_no" style="width:120px;" value="" class="input" maxlength="20" tabindex="14" id="biz_rgst_no" /></td>
						<th><label for="cfm_flg">Confirm</label><input type="checkbox" name="cfm_flg" class="trans" tabindex="16" id="cfm_flg" /></th>
						<th>Confirm Date</th>
						<td><input type="text" name="cfm_dt" style="width:100%;" class="input2" readonly tabindex="-1" id="cfm_dt" /></td>
						<td></td>
					</tr>
					<tr>
						<th>Contact</th>
						<td><input type="text" name="cntc_pson_nm" style="width:126px;" class="input" maxlength="50" dataformat="engup" tabindex="18" id="cntc_pson_nm" otherchar=" &*-./" /></td>
						<th>Tel.</th>
						<td><input type="text" name="cntc_phn_no" style="width:120px;" class="input1" maxlength="20" dataformat="num" otherchar="-" tabindex="20" id="cntc_phn_no" /></td>
						<th>Fax</th>
						<td><input type="text" name="cntc_fax_no" style="width:120px;" value=" " class="input" maxlength="20" dataformat="num" otherchar="-" tabindex="22" id="cntc_fax_no" /></td>
						<th><label for="cxl_flg">Cancel</label><input type="checkbox" name="cxl_flg" class="trans" disabled tabindex="-1" id="cxl_flg" /></th>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<th>Cell Phone</th>
						<td><input type="text" name="cntc_mphn_no" style="width:126px;" class="input" maxlength="20" dataformat="num" otherchar="-" tabindex="24" id="cntc_mphn_no" /></td>
						<th>Address</th>
						<td colspan="6"><input type="text" name="act_shpr_addr" style="width:100%" class="input" maxlength="500" tabindex="26" id="act_shpr_addr" /></td>
						<td></td>
					</tr>
					<tr>
						<th>Remark(s)</th>
						<td colspan="8"><textarea name="diff_rmk" id="diff_rmk" style="width:100%; height:46px;resize:none" maxlength="1000" tabindex="28"></textarea></td>
						<td></td>
					</tr>
			   </tbody>
			</table>
		</div>
		
		<div class="opus_design_grid">
			<!-- opus_design_btn (S) -->
			<div class="opus_design_btn">
				<button class="btn_accent" name="btn_t2bAdd" id="btn_t2bAdd" type="button">Row Add</button><!--
				--><button class="btn_normal" name="btn_t2bDelete" id="btn_t2bDelete" type="button">Row Delete</button><!--
				--><input type="text" name="tro_copy_cnt" style="width:20px; height:25px; font-size:8pt; text-align:center;" class="input mar_left_4 mar_rgt_4" maxlength="2" dataformat="num" id="tro_copy_cnt" /><!--
				--><button class="btn_normal" name="btn_t2bCopy" id="btn_t2bCopy" type="button">Row Copy</button><!--
				--></div>
			<!-- opus_design_btn (E) -->
			<script type="text/javascript">ComSheetObject('t2bsheet1');</script>
		</div>
	</div>
	<!--TAB TRO/B + General (E) -->
	
	<!--TAB TRO/B + Return (S) -->
	<div id="tabLayer_trob" style="display:none">
		<div class="opus_design_inquiry">
			<table>
				<colgroup>
					<col width="100">				
					<col width="110">				
					<col width="100">				
					<col width="50">				
					<col width="50">				
					<col width="50">				
					<col width="60">				
					<col width="*">				
			   </colgroup>
			   <tbody>
			   		<tr>
			   			<th>Seq.</th>
						<td><!-- TRO seq : combo output Start ---------
                        --><script type="text/javascript">ComComboObject('t2_tro_seq', 1, 46, 1);</script><!-- TRO seq : combo output End------------
						--><input type="text" name="t2_tro_seq_maxcnt" style="width:30px;" class="input2" readonly="" tabindex="-1" id="t2_tro_seq_maxcnt" />
						<th>Receiving Term</th>
						<td>
							<input type="text" name="t2_rcv_term_cd" style="width:30px;" class="input2" readonly="" tabindex="-1" id="t2_rcv_term_cd" />
						<th>S/O</th>
						<td><input type="text" name="t2_so_flg" style="width:25px;" value="" class="input2" readonly tabindex="-1" id="t2_so_flg" /> </td>
						<!-- td width="100">Request Result</td -->
						<td style="display:none"><input type="hidden" name="t2_ack_sts_cd" style="width:72px;" value="" class="input2" readonly tabindex="-1" id="t2_ack_sts_cd" /> </td>
						<!-- td width="88">Request Date</td -->
						<td style="display:none"><input type="hidden" name="t2_rqst_dt" style="width:137px;" class="input2" readonly tabindex="-1" id="t2_rqst_dt" /> </td>
						<th><label for="t2_ownr_trk_flg">S/TRK</label></th>
						<td><input type="checkbox" name="t2_ownr_trk_flg" value="true" class="trans" tabindex="-1" id="t2_ownr_trk_flg" /> </td>
			   		</tr>
			   </tbody>
			</table>
			<table>
				<colgroup>
					<col width="100">				
					<col width="*">				
			   </colgroup>
			   <tbody>
			   		<tr>
			   			<th>Actual Customer</th>
						<td><input type="text" name="t2_act_shpr_cnt_cd" style="width:40px;" class="input" maxlength="2" dataformat="engup" tabindex="50" id="t2_act_shpr_cnt_cd" /><!--
						--><input type="text" name="t2_act_shpr_seq" style="width:60px;" class="input" maxlength="6" dataformat="num" tabindex="52" id="t2_act_shpr_seq" /><!--
						--><input type="text" name="t2_act_shpr_nm" style="width:310px;" class="input1" maxlength="50" dataformat="engup" tabindex="54" id="t2_act_shpr_nm" otherchar=" &*-./" /><!--
						--><button type="button" id="t2_btns_popActCust" name="t2_btns_popActCust" class="input_seach_btn"></button></td>
			   		</tr>
			   </tbody>
			</table>
			<table>
				<colgroup>
					<col width="100" />				
					<col width="140" />				
					<col width="70" />				
					<col width="130" />				
					<col width="80" />				
					<col width="130" />				
					<col width="100" />				
					<col width="*" />				
			   </colgroup> 
			   <tbody>
			   		<tr>
						<th>Location</th>
						<td><input type="text" name="t2_dor_loc_cd" caption="Locaction Code" style="width:63px;ime-mode:disabled;text-transform:uppercase;" class="input" maxlength="5" dataformat="engup" fullfill="" value="" tabindex="56" id="t2_dor_loc_cd" /><!--
						--><input type="text" name="t2_zn_cd" style="width:30px;ime-mode:disabled;text-transform:uppercase;" class="input" dataformat="engup"  maxlength="2" value="" tabindex="58" id="t2_zn_cd" /><!--
						--><button type="button" id="t2_btns_popLocation" name="t2_btns_popLocation" class="input_seach_btn"></button>
						<th>Zip</th>
						<td><input type="text" name="t2_dor_pst_no" style="width:55px;" class="input" caption="Zip" maxlength="12" dataformat="engup" value="" tabindex="60" id="t2_dor_pst_no" otherchar=" &*-./" /> </td>
						<th>BIZ Ref.No.</th>
						<td><input type="text" name="t2_biz_rgst_no" style="width:125px;" value="" class="input" maxlength="20" tabindex="62" id="t2_biz_rgst_no" /> </td>
						<th><label for="t2_cxl_flg">Cancel</label><input type="checkbox" name="t2_cxl_flg" class="trans" disabled="true" tabindex="-1" id="t2_cxl_flg" /></th>
						<td></td>
					</tr>
					<tr>
						<th>Contact</th>
						<td><input type="text" name="t2_cntc_pson_nm" style="width:126px;" class="input" maxlength="50" dataformat="engup" tabindex="64" id="t2_cntc_pson_nm" /> </td>
						<th>Tel.</th>
						<td><input type="text" name="t2_cntc_phn_no" style="width:120px;" class="input" maxlength="20" dataformat="num" otherchar="-"value="" tabindex="66" id="t2_cntc_phn_no" /> </td>
						<th>Fax</th>
						<td><input type="text" name="t2_cntc_fax_no" style="width:125px;" value="" class="input" maxlength="20" dataformat="num" otherchar="-" tabindex="68" id="t2_cntc_fax_no" /> </td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<th>Cell Phone</th>
						<td><input type="text" name="t2_cntc_mphn_no" style="width:126px;" class="input" maxlength="20" dataformat="num" otherchar="-" value="" tabindex="70" id="t2_cntc_mphn_no" /> </td>
						<th>Address</th>
						<td colspan="4"><input type="text" name="t2_act_shpr_addr" style="width:100%;" class="input" maxlength="500" value="" tabindex="72" id="t2_act_shpr_addr" /> </td>
						<td></td>
					</tr>
					<tr>
						<th>Remark(s)</th>
						<td colspan="6"><textarea name="t2_diff_rmk" style="width:100%; height:46px;resize:none" maxlength="1000" tabindex="74"></textarea></td>
						<td></td>
					</tr>
			   </tbody>
			</table>
		</div>
		
		<div class="opus_design_grid">
			<!-- opus_design_btn (S) -->
			<div class="opus_design_btn">
				<button class="btn_accent" name="t2_btn_t2bAdd" id="t2_btn_t2bAdd" type="button">Row Add</button><!--
				--><button class="btn_normal" name="t2_btn_t2bDelete" id="t2_btn_t2bDelete" type="button">Row Delete</button><!--
				--><input type="text" name="t2_tro_copy_cnt" style="width:20px; height:25px; font-size:8pt; text-align:center;" class="input mar_left_4 mar_rgt_4" maxlength="2" dataformat="num" id="t2_tro_copy_cnt" /><!--
				--><button class="btn_normal" name="t2_btn_t2bCopy" id="t2_btn_t2bCopy" type="button">Row Copy</button><!--
				--></div>
			<!-- opus_design_btn (E) -->
			<script type="text/javascript">ComSheetObject('t2bsheet1_b');</script>
		</div>
	</div>
	<!--TAB TRO/B + Return (E) -->
</div>
<!-- hidden grid : Start ---------------------->
<div class="opus_design_grid" style="display:none">
	<!-- booking header / master all : hidden -->
	<script type="text/javascript">ComSheetObject('t2bsheet2');</script>
	<!-- detail all : hidden -->
	<script type="text/javascript">ComSheetObject('t2bsheet3');</script>
	<!-- tro_dg_seq all : hidden -->
	<script type="text/javascript">ComSheetObject('t2bsheet4');</script>
	<!-- booking header / master all : hidden_rtncago -->
	<script type="text/javascript">ComSheetObject('t2bsheet2_b');</script>
	<!-- detail all : hidden_rtncago -->
	<script type="text/javascript">ComSheetObject('t2bsheet3_b');</script>
	<!-- request : hidden -->
	<script type="text/javascript">ComSheetObject('h1sheet1');</script>
</div>
<!-- hidden grid : End ------------------------>
<div id="layList" name="layList" style="position:absolute;z-index:999;display:none" CELLPADDING="5" CELLSPACING="0" BORDER="0"/>
<IFRAME id="ifrm" name="ifrm" src="apps/opus/esm/bkg/bookingcommon/bookingutil/jsp/esm_booking_split_no.html"  frameborder="0" marginHeight="0" marginWidth="0" width="115" height="82"  style="position:absolute;border:1 #e9e9e9 solid" CELLSPACING="0" scrolling="no"/>
<!--20090526 for help------------->
<div id='overDiv' style='position:absolute; z-index:90; width:350; visibility:hidden' tabindex=-1>
</div>
<!------------------------------->
</form>
<script type="text/javascript">
	//start of help---------------------------->
	  var x = 0;
	  var y = 0;
	  var snow = 0;
	  var sw = 0;
	  var cnt = 0;
	  var dir = 1;
	  var offsetx = -150; //3;
	  var offsety = 10; //-20;
	  var width  = 50;
	  var height = 70;

	  over = overDiv.style;
	  document.onmousemove = mouseMove;

	  function drs(text, title) { dts(1,text); }

	  function nd() {
	    if ( cnt >= 1 ) { sw = 0 };
	    if ( sw == 0 ) { snow = 0; hideObject(over); }
	    else { cnt++; }
	  }

	  function dts(d,text) {
		if (text=="")
		{
	        return false;
		}
	    txt = "<TABLE WIDTH=200 STYLE=\"border:1 #e9e9e9 solid\" CELLPADDING=5 CELLSPACING=0 BORDER=0><TR><TD BGCOLOR=#ffffff><font STYLE=\"font-size:11px;color:#333399\">"+text+"</font></TD></TR></TABLE>"; 
	    layerWrite(txt);
	    dir = d;
	    disp();
	  }

	  function disp() {
	    if (snow == 0) {
	      if (dir == 2) { moveTo(over,x+offsetx-(width/2),y+offsety); } // Center
	      if (dir == 1) { moveTo(over,x+offsetx,y+offsety); }           // Right
	      if (dir == 0) { moveTo(over,x-offsetx-width,y+offsety); }     // Left
	      showObject(over);
	      snow = 1;
	    }
	  }

	  function mouseMove(e) {
	    x=event.x + document.body.scrollLeft+10
	    y=event.y + document.body.scrollTop
	    if (x+width-document.body.scrollLeft > document.body.clientWidth)  x=x-width-25;
	    if (y+height-document.body.scrollTop > document.body.clientHeight) y=y-height;

	    if (snow) {
	      if (dir == 2) { moveTo(over,x+offsetx-(width/2),y+offsety); } // Center
	      if (dir == 1) { moveTo(over,x+offsetx,y+offsety); }           // Right
	      if (dir == 0) { moveTo(over,x-offsetx-width,y+offsety); }     // Left
	    }
	  }

	  function cClick() { hideObject(over); sw=0; }
	  function layerWrite(txt) { document.all["overDiv"].innerHTML = txt }
	  function showObject(obj) { obj.visibility = "visible" }
	  function hideObject(obj) { obj.visibility = "hidden" }
	  function moveTo(obj,xL,yL) { obj.left = xL; obj.top = yL; }
	//<-------------------------------end of help
</script>		
<script type="text/javascript">
<!--
      /* 
       * showing the information  which user input by event on the screen 
       */
      with(document.form)
      {
        <%
          if(event != null) 
          {               
              String currRtnTroFg = event.getCurrRtnTroFlg();
              String currTroSeq   = event.getCurrTroSeq();
              if (bkgNo.length() > 0) {
        %>    
                  eval("curr_rtn_tro_flg").value = nullToBlank("<%=currRtnTroFg%>");
                  eval("curr_tro_seq").value     = nullToBlank("<%=currTroSeq%>");
        <% 
              } 
          } 
        %>
      }
-->
</script>