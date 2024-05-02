<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : 
*@FileTitle  : 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/19
=========================================================*/
%>
<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0079_02c.jsp
*@FileTitle  : TRO(Transportation Request Order) for Inland Haulage
*@author     : CLT
*@version    : 1.0
*@since      : 
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.framework.core.view.template.Screen"%>
<%@ page import="com.clt.framework.core.controller.util.WebKeys"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.event.EsmBkg007902cEvent"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg007902cEvent  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";				//error message


    String bkgNo   = "";	
    String ioBndCd = ""; 
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

        event = (EsmBkg007902cEvent)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		if (event != null) {
		    bkgNo   = event.getBkgNo(); 
		    ioBndCd = event.getBoundCd(); 
		}	
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<style type="text/css">
.input2_2		{  height: 20px; border: #7896B1 1px solid; font-family: Tahoma,Arial,dotum,gulim; font-size: 12px; color: #606060; text-indent: 2px;  background-color:#E8E7EC; font-weight:bold;}
.mar_top_6 {margin-top:6px!important}
.thirdTb tbody tr th, .thirdTb tbody tr td {
	text-align: center;
}
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

<!-- checking the hidden below : 0317 -->
<input type="hidden" name="io_bnd_cd" value="<%=ioBndCd%>" id="io_bnd_cd" />
<input type="hidden" name="conti_cd" value="" id="conti_cd" />
<input type="hidden" name="oldBkgNo" value="" id="oldBkgNo" />
<input type="hidden" name="oldBlNo" value="" id="oldBlNo" />
<input type="hidden" name="eml" value="" id="eml" />
<input type="hidden" name="fax_no" value="" id="fax_no" />
<input type="hidden" name="pcInqFlag" value="N" id="pcInqFlag" />
<input type="hidden" name="routeModifyFlag" value="N" id="routeModifyFlag" />
<input type="hidden" name="bdrFlag" value="" id="bdrFlag" />
<input type="hidden" name="obDoorArrDt" value="" id="obDoorArrDt" />
<input type="hidden" name="ibDoorArrDt" value="" id="ibDoorArrDt" />
<input type="hidden" name="curr_tro_seq" value="" id="curr_tro_seq" />
<input type="hidden" name="curr_tro_sub_seq" value="" id="curr_tro_sub_seq" />
<input type="hidden" name="ca_flg" value="" id="ca_flg" />
<input type="hidden" name="f_del_flg" value="" id="f_del_flg" />
<input type="hidden" name="post_flg" value="" id="post_flg" />
<input type="hidden" name="max_tro_seq_old" value="0" id="max_tro_seq_old" />
<input type="hidden" name="eur_trns_tp_cd" value="" id="eur_trns_tp_cd" />
<!-- header : default setting --> 
<input type="hidden" name="por_nod_cd" value="" id="por_nod_cd" />
<input type="hidden" name="return_cy" value="" id="return_cy" />
<input type="hidden" name="pickup_cy" value="" id="pickup_cy" />
<input type="hidden" name="cmdt_cd" value="" id="cmdt_cd" />
<input type="hidden" name="cmdt_nm" value="" id="cmdt_nm" />
<input type="hidden" name="bkg_rep_cmdt_cd" value="" id="bkg_rep_cmdt_cd" />
<input type="hidden" name="bkg_rep_cmdt_nm" value="" id="bkg_rep_cmdt_nm" />
<input type="hidden" name="act_wgt" value="" id="act_wgt" />
<input type="hidden" name="wgt_ut_cd" value="" id="wgt_ut_cd" />
<input type="hidden" name="fd_grd_flg" value="" id="fd_grd_flg" />
<input type="hidden" name="spcl_hide_flg" value="" id="spcl_hide_flg" />
<input type="hidden" name="etb_dt" value="" id="etb_dt" />
<input type="hidden" name="rtn_dt" value="" id="rtn_dt" />
<input type="hidden" name="rtn_dt_hhmi" value="" id="rtn_dt_hhmi" />
<input type="hidden" name="pkup_dt" value="" id="pkup_dt" />
<input type="hidden" name="pkup_dt_hhmi" value="" id="pkup_dt_hhmi" />
<input type="hidden" class="noinput" name="modify_flag" value="N" id="modify_flag" />
<input type="hidden" name="isInquiry" value="<%=isInquiry%>" id="isInquiry" />
<input type="hidden" name="rep_zn_cd" id="rep_zn_cd" />

<input type="hidden" name="cntr_prt_flg" style="width:104px;" value="" id="cntr_prt_flg" />
<input type="hidden" name="t1_doc_flg" style="width:104px;" value="" id="t1_doc_flg" />
<input type="hidden" name="cstms_clr_no" style="width:104px;" value="" id="cstms_clr_no" />
<input type="hidden" name="all_in_rt_cd" style="width:104px;" value="" id="all_in_rt_cd" />
<input type="hidden" name="curr_cd" style="width:104px;" value="" id="curr_cd" />
<input type="hidden" name="trns_rev_amt" style="width:104px;" value="" id="trns_rev_amt" />
<input type="hidden" name="cxl_flg" style="width:104px;" value="" id="cxl_flg" />
<input type="hidden" name="vat_flg" style="width:104px;" value="" id="vat_flg" />
<input type="hidden" name="tro_sub_seq" style="width:25px;" value="" id="tro_sub_seq" />
<input type="hidden" name="cntr_tpsz_cd_old" style="width:25px;" value="" id="cntr_tpsz_cd_old" />
<input type="hidden" name="hlg_tp_cd_old" style="width:25px;" value="" id="hlg_tp_cd_old" />
<input type="hidden" name="new_row_flg" style="width:104px;" value="" id="new_row_flg" />
<input type="hidden" name="non_trns_rev_amt" style="width:104px;" value="" id="non_trns_rev_amt" />
<input type="hidden" name="add_rev_amt" style="width:104px;" value="" id="add_rev_amt" />
<input type="hidden" name="add_rev_chg_cd" style="width:104px;" value="" id="add_rev_chg_cd" />
<input type="hidden" name="flex_hgt_flg" style="width:104px;" value="" id="flex_hgt_flg" />

<!-- page_title_area(S) -->
<div class="opus_design_btn opus_design_normal2">
	<button class="btn_accent" name="btn_t2cRetrieve" id="btn_t2cRetrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_t2cSave" id="btn_t2cSave" type="button">Save All</button><!--
		--><button class="btn_normal" name="btn_t2cSaveSeq" id="btn_t2cSaveSeq" type="button">Save</button><!--
		--><button class="btn_normal" name="btn_t2cConfirm" id="btn_t2cConfirm" type="button">Confirm</button><!--
		--><button class="btn_normal" name="btn_t2cCancelFrustrate" id="btn_t2cCancelFrustrate" type="button">Cancel / Frustrate</button><!--
		--><button class="btn_normal" name="btn_t2cTROCopy" id="btn_t2cTROCopy" type="button">TRO Copy</button><!--
		--><button class="btn_normal" name="btn_t2cTRONotice" id="btn_t2cTRONotice" type="button">TRO Notice</button><!--
		--><button class="btn_normal" name="btn_t2cAddCNTR" id="btn_t2cAddCNTR" type="button">Add CNTR</button><!--
		--><button class="btn_normal" name="btn_t2cCopyCNTR" id="btn_t2cCopyCNTR" type="button">Copy CNTR</button><!--
		--><input type="text" name="tro_copy_cnt" value="" style="width:25px; height:24px; font-size:8pt; text-align:center;margin-right:0!important" class="input mar_left_4" maxlength="2" dataformat="num" tabindex="-1" id="tro_copy_cnt" /><!--
		--></div>
</div>
<!-- page_title_area(E) -->

<span class="clear"></span>

<div class="wrap_search coupled_btn_normal2">
	<div class="opus_design_inquiry wFit">
		  <table>
		    <tbody>
		      <tr>
		        <th width="54">BKG No.</th>
		        <td width="150"><input type="text" name="bkg_no" style="width:115px;" value="<%=bkgNo%>" class="input" maxlength="13" dataformat="engup" tabindex="2" id="bkg_no" />
							<!--
							--><button type="button" class="btn_down_list" id="btn_splitPop" name="btn_splitPop"></button>
		        </td>
		        <th width="60">B/L No.</th>
			    <td><input type="text" name="bl_no" style="width:115px;" value="" class="input" maxlength="13" dataformat="engup" tabindex="4" id="bl_no" /></td>
							<!--input type="text" name="bl_tp_cd"  style="width:30;" value="" class="input2" maxlength="1" style="ime-mode:disabled" dataformat="uppernum" readonly--></td>
			  </tr>
		    </tbody>
		  </table>
	</div>
</div>

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<div class="layout_wrap">
			<div class="layout_flex_fixed floatR" style="width:400px">
				<h3 class="title_design">Total Volume</h3>
				<div class="opus_design_grid">
					<script type="text/javascript">ComSheetObject('t2csheet5');</script>
				</div>
			</div>
			<div class="layout_flex_flex" style="padding-right:408px">
				<table>
					<colgroup>			
						<col width="70" />
						<col width="160" />
						<col width="60" />
						<col width="220" />
						<col width="*" />
				   </colgroup> 
				   <tbody>
				   		<tr>
				   			<th>Bound</th>
							<td><input type="text" name="io_bnd_cd_disp" value="" style="width:41px;color:#6666ff;" class="input2" readonly tabindex="-1" id="io_bnd_cd_disp" /></td>
							<th>Status</th>
							<td><input type="text" name="bkg_sts_cd" style="width:28px;" value="" class="input2" readonly tabindex="-1" id="bkg_sts_cd" /></td>
							<td></td>
				   		</tr>
				   </tbody>
				</table>
				<table>
					<colgroup>
						<col width="70" />
						<col width="160" />
						<col width="60" />
						<col width="220" />	
						<col width="120" />	
						<col width="140" />
						<col width="*" />
					</colgroup>
					<tbody>
						<tr>
							<th>T/VVD</th>
							<td><input type="text" name="vsl_cd" style="width:50px;" value="" class="input2" readonly tabindex="-1" id="vsl_cd" /><!--
							--><input type="text" name="skd_voy_no" style="width:50px;" value="" class="input2" readonly="" tabindex="-1" id="skd_voy_no" /><!--
							--><input type="text" name="skd_dir_cd" style="width:36px;" value="" class="input2" readonly="" tabindex="-1" id="skd_dir_cd" /></td>
							<th>Route</th>
							<td><input type="text" name="por_cd" style="width:55px;" value="" class="input2" readonly tabindex="-1" id="por_cd" /><!--
							--><input type="text" name="pol_code" style="width:55px;" value="" class="input2" readonly="" tabindex="-1" id="pol_code" /><!--
							--><input type="text" name="pod_cd" style="width:55px;" value="" class="input2" readonly="" tabindex="-1" id="pod_cd" /><!--
							--><input type="text" name="del_cd" style="width:55px;" value="" class="input2" readonly="" tabindex="-1" id="del_cd" /></td>
							<th name="cyHeader" id="cyHeader">Return CY</th>
							<td><input type="text" name="cy1" style="width:60px;margin-left:1px" value="" class="input2" readonly tabindex="-1" id="cy1" /><!--
							--><input type="text" name="cy2" style="width:30px;" value="" class="input2" readonly="" tabindex="-1" id="cy2" /></td>
							<td></td>
						</tr>
					</tbody>
				</table>
				<table>
					<colgroup>
						<col width="90" />
						<col width="60" />
						<col width="100" />
						<col width="110" />
						<col width="95" />
						<col width="30" />
						<col width="140" />
						<col width="*" />
					</colgroup>
					<tbody>
						<tr>
							<td><input type="checkbox" name="dcgo_flg" class="trans mar_top_6" disabled tabindex="-1" id="dcgo_flg" /><!--
							--><button class="btn_etc mar_left_4" name="btn_Danger" id="btn_Danger" type="button">Danger</button></td>
							<td><input type="checkbox" name="hcdg" value="" class="trans" disabled="true" tabindex="-1" id="hcdg" /><!--
							--><label for="hcdg">HCDG</label></td>
							<td><input type="checkbox" name="rc_flag" class="trans mar_top_6" disabled id="rc_flag" /><!--
							--><button class="btn_etc mar_left_4" name="btn_Reefer" id="btn_Reefer" type="button">Reefer</button></td>
							<td><input type="checkbox" name="awk_cgo_flg" class="trans mar_top_6" disabled tabindex="-1" id="awk_cgo_flg" /><!--
							--><button class="btn_etc mar_left_4" name="btn_Awkward" id="btn_Awkward" type="button">Awkward</button></td>
							<th>Cargo Type</th>
							<td><input type="text" name="bkg_cgo_tp_cd" value="" style="width:23px;" class="input2" readonly="" tabindex="-1" id="bkg_cgo_tp_cd" /></td>
							<th>Receiving Term</th>
							<td><input type="text" name="term" style="width:28px;" class="input2" readonly tabindex="-1" id="term" /></td>
						</tr>
					</tbody>
				</table>
				<table>
					<colgroup>
						<col width="70" />
						<col width="*" />
					</colgroup>
					<tbody>
						<tr>
							<th>Customer</th>
							<td><input type="text" name="cust_cnt_cd" style="width:30px;" value="" class="input2" readonly tabindex="-1" id="cust_cnt_cd" /><!--
							--><input type="text" name="cust_seq" style="width:70px;" value="" class="input2" readonly="" tabindex="-1" id="cust_seq" /><!--
							--><input type="text" name="cust_nm" style="width:481px;" value="" class="input2" readonly="" tabindex="-1" id="cust_nm" /></td>
						</tr>
					</tbody>
				</table>
			</div>			
		</div>
		<table class="line_bluedot"><tr><td></td></tr></table>
		<table>
			<colgroup>
				<col width="73">
				<col width="100">
				<col width="40">
				<col width="60">
				<col width="70">
				<col width="130">
				<col width="60">
				<col width="90">
				<col width="70">
				<col width="80">
				<col width="60">
				<col width="90">
				<col width="60">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>CNTR Seq.</th>
					<td><!-- TRO seq : combo output Start ---------
					--><script type="text/javascript">ComComboObject('tro_seq', 1, 50, 1);</script><!-- TRO seq : combo output End-----------
					---><input type="text" name="tro_seq_maxcnt" style="width:30px;" class="input2" readonly="" tabindex="-1" id="tro_seq_maxcnt" /></td>
					<th>Sub</th>
					<td><input type="text" name="rqst_sub_seq" value="" style="width:40px;" class="input" tabindex="10" id="rqst_sub_seq" /></td>
					<th>CNTR No.</th>
					<td><input type="text" style="width:95px;" name="cntr_no" class="input" maxlength="11" dataformat="engup" tabindex="12" id="cntr_no" /><!--
					--><button type="button" id="btns_t2cSearchCntrNo" name="btns_t2cSearchCntrNo" class="input_seach_btn"></button></td>
					<th>TP/SZ</th>
					<td><input type="text" name="cntr_tpsz_cd" value="" style="width:28px;" class="input1" maxlength="2" dataformat="engup" tabindex="14" id="cntr_tpsz_cd" /><!--
					--><button type="button" id="btn_t2cMulti" name="btn_t2cMulti" class="btn_etc">Multi</button></td>
					<th>D/G Seq.</th>
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
<!-- 			<colgroup> -->
<!-- 				<col width="80" /> -->
<!-- 				<col width="100" /> -->
<!-- 				<col width="100" /> -->
<!-- 				<col width="190" /> -->
<!-- 				<col width="70" /> -->
<!-- 				<col width="130" /> -->
<!-- 				<col width="70" /> -->
<!-- 				<col width="170" /> -->
<!-- 				<col width="80" /> -->
<!-- 				<col width="*" /> -->
<!-- 			</colgroup> -->
			<tbody>
				<tr>
					<th>Haulage</th>
					<td> 
						<!-- Haulage : combo output Start ----------->
						<script type="text/javascript">ComComboObject('hlg_tp_cd', 1, 50, 1);</script>
						<!-- Haulage  : combo output End--------------> 
					</td>
					<th>Cargo Weight</th>
					<td><input type="text" name="cgo_wgt" style="width:105px;text-align:right" value="" class="input1" dataformat="float" tabindex="16" id="cgo_wgt" /><!--
					--><input type="text" name="cgo_wgt_tp" style="width:40px;" value="KG" class="input2" readonly="" tabindex="-1" id="cgo_wgt_tp" /></td>
					<th>P/Up CY</th>
					<td><input type="text" name="cntr_pkup_yd_cd" style="width:71px;" value="" class="input" maxlength="7" dataformat="engup" tabindex="18" id="cntr_pkup_yd_cd" /></td>
					<th>Return CY</th>
					<td><input type="text" name="cntr_rtn_yd_cd" style="width:70px;" value="" class="input1" maxlength="7" dataformat="engup" tabindex="20" id="cntr_rtn_yd_cd" /></td>
					<th>Return Date</th>
					<td><input type="text" name="cntr_rtn_dt" style="width:85px;" value="" class="input1" maxlength="10" dataformat="ymd" caption="Return Date" tabindex="22" id="cntr_rtn_dt" /><!--
					--><button type="button" id="btns_calendar" name="btns_calendar" class="calendar ir"></button><!--
					--><input type="text" name="cntr_rtn_dt_hhmi" style="width:46px;" value="" class="input1" maxlength="5" dataformat="hm" caption="Return Date(hour)" tabindex="24" id="cntr_rtn_dt_hhmi" /></td>
					<th width = "90">Comm. Office</th>
					<td><input type="text" name="comm_ofc_cd" style="width:70px;" value="" class="input" maxlength="5" dataformat="engup" tabindex="20" id="comm_ofc_cd" /></td>

				</tr>
				<tr>
					<th>Commodity</th>
					<td><input type="text" name="tro_cmdt_cd" style="width:60px;" value="" class="input1" maxlength="6" dataformat="num" tabindex="26" id="tro_cmdt_cd" /></td>
					<th>Rep. Commodity</th>
					<td><input type="text" name="rep_cmdt_cd" style="width:50px;" value="" class="input1" maxlength="4" dataformat="num" tabindex="28" id="rep_cmdt_cd" /><!--
					--><input type="text" name="rep_cmdt_nm" style="width:93px;" value="" class="input1" maxlength="4000" tabindex="30" id="rep_cmdt_nm"/><!--
					--><button type="button" id="btns_repCommodity" name="btns_repCommodity" class="input_seach_btn"></button></td>
					<th>Mode</th>
					<td> 
						<!-- TransMode : combo output Start ----------->
						<script type="text/javascript">ComComboObject('bkg_trsp_mzd_cd', 2, 90, 1, 0, 1);</script>
						<!-- TransMode  : combo output End--------------> 
					</td>
					<th>P/Up Date</th>
					<td><input type="text" name="cntr_pkup_dt" style="width:85px;" value="" class="input" maxlength="10" dataformat="ymd" caption="P/Up Date" tabindex="32" id="cntr_pkup_dt" /><!--
					--><button type="button" id="btns_calendar_2" name="btns_calendar_2" class="calendar ir"></button><!--
					--><input type="text" name="cntr_pkup_dt_hhmi" style="width:46px;" value="" class="input" maxlength="5" dataformat="hm" caption="P/Up Date(hour)" tabindex="34" id="cntr_pkup_dt_hhmi" />
					<th><span name="canceled" id="canceled" tabindex="-1">P/Up Date</span></th>
					<td><button type="button" class="btn_etc" id="btn_t2cT1Revenue" name="btn_t2cT1Revenue">T1 Revenue</button></td>
				</tr>
			</tbody>
		</table>
		<div class="layout_wrap sm mar_top_8">
			<div class="layout_vertical_2" style="width:50%">
				<table>
					<colgroup>
						<col width="" />
					</colgroup>
					<tbody>
						<tr>
							<th>Type</th>
							<td>
								<!-- Door Type : combo output Start ----------->
								<script type="text/javascript">ComComboObject('dor_addr_tp_cd', 1, 78, 1);</script>
								<!-- Door Type : combo output End-------------->
						   </td>
							<th>Location/Zone</th>
							<td><input type="text" name="dor_loc_cd" caption="Locaction Code" style="width:55px;" class="input1" maxlength="5" dataformat="engup" fullfill="" tabindex="36" id="dor_loc_cd" /><!--
							--><input type="text" name="zn_cd" style="width:25px;" class="input1" maxlength="2" tabindex="38" id="zn_cd" /><!--
							--><button type="button" id="btns_popLocation" name="btns_popLocation" class="input_seach_btn"></button></td>
						</tr>
					</tbody>
				</table>
				<table class="grid2 wAuto" style="width:500px">
					<tr>
						<th><b>Company</b></th>
						<td  id="td_dor_addr_1" name="td_dor_addr_1" ><input type="text" name="dor_addr_1" style="width:450px;" value="" class="input1" maxlength="50" tabindex="50" id="dor_addr_1" /></td>
						<td style="border: none !important;background: transparent !important"><button type="button" id="btns_Address" name="btns_Address" class="input_seach_btn"></button></td>
					</tr>
					<tr>
					    <th rowspan="3"><b>Address</b></th>
						<td  id="td_dor_addr_2" name="td_dor_addr_2" ><input type="text" name="dor_addr_2" style="width:450px;" value="" class="input1" maxlength="50" tabindex="52" id="dor_addr_2" /></td>
					</tr>
					<tr>
						<td  id="td_dor_addr_3" name="td_dor_addr_3" ><input type="text" name="dor_addr_3" style="width:450px;" value="" class="input" maxlength="50" tabindex="54" id="dor_addr_3" /></td>
					</tr>
					<tr>
						<td  id="td_dor_addr_4" name="td_dor_addr_4" ><input type="text" name="dor_addr_4" style="width:450px;" value="" class="input" maxlength="50" tabindex="56" id="dor_addr_4" /></td>
					</tr>
				</table>
			</div>
			
			<div class="layout_vertical_4 pad_left_8" style="width:30%">
				<table>
					<colgroup>
						<col width="60">
						<col width="110">
						<col width="30">
						<col width="*">
					</colgroup>
					<tbody>
						<tr>
							<th>Load Ref.</th>
							<td><input type="text" name="lod_ref_no" style="width:100px;" value="" class="input" maxlength="50" tabindex="40" id="lod_ref_no" /></td>
							<th>Zip</th>
							<td><input type="text" name="dor_pst_no" style="width:100px;" value="" class="input1" caption="Zip" maxlength="10" dataformat="engup" tabindex="42" id="dor_pst_no" otherchar=" &amp;-,." /></td>
						</tr>
					</tbody>
				</table>
				<table>
					<colgroup>
						<col width="100" />
						<col width="*" />
					</colgroup>
					<tbody>
						<tr>
							<th>Door Arrival Date</th>
							<td><input type="text" name="arr_dt" style="width:85px;" value="" class="input1" maxlength="10" dataformat="ymd" caption="Door Arrival Date" tabindex="58" id="arr_dt" /><!--
							--><button type="button" id="btns_calendar_3" name="btns_calendar_3" class="calendar ir"></button><!--
							--><input type="text" name="arr_dt_hhmi" style="width:45px;" value="" class="input1" maxlength="5" dataformat="hm" caption="Door Arrival Date(hour)" tabindex="60" id="arr_dt_hhmi" /></td>
						</tr>
					</tbody>
				</table>
				
				<table class="grid2 wAuto">
					<colgroup>
						<col width="100" />
						<col width="*" />
					</colgroup>
					<tr>
						<th><b>Contact Name</b></th>
						<td><input type="text" name="cntc_pson_nm" style="width:205px;" value="" class="input" maxlength="50" dataformat="engup" tabindex="62" id="cntc_pson_nm" otherchar=" &amp;-,." /></td>
					</tr>
					<tr>
						<th><b>Tel.</b></th>
						<td><input type="text" name="cntc_phn_no" style="width:205px;" value="" class="input" maxlength="20" dataformat="num" otherchar="-" tabindex="64" id="cntc_phn_no" /></td>
					</tr>
					<tr>
						<th><b>E-Mail</b></th>
						<td><input type="text" name="cntc_eml" style="width:205px;" value="" class="input" maxlength="200" tabindex="66" id="cntc_eml" /></td>
					</tr>
				</table> 
			</div>
			<div class="layout_vertical_4" style="width:20%">
				<div class="layout_wrap">
					<div class="layout_vertical_3">
						<table class="thirdTb">
							<colgroup>
								<col width="*">
							</colgroup>
							<tbody>
								<tr>
									<th>Multi Stop</th>
								</tr>
								<tr>
									<td><button class="btn_etc" name="btn_t2cAdd" id="btn_t2cAdd" type="button">Add</button></td>
								</tr>
								<tr>
									<td><button class="btn_etc" name="btn_t2cDelete" id="btn_t2cDelete" type="button">Delete</button></td>
								</tr>
								<tr>
									<td>
										<input type="text" name="tro_sub_seq_currcnt" style="width:25px;text-align:right" value="" class="input2" readonly="" tabindex="-1" id="tro_sub_seq_currcnt" /><!--
										--><span class="dash">of</span><!--
										--><input type="text" name="tro_sub_seq_maxcnt" style="width:25px;text-align:right" value="" class="input2" readonly="" tabindex="-1" id="tro_sub_seq_maxcnt" />
									</td>
								</tr>
								<tr>
									<td><button class="btn_etc" name="btn_t2cPrevious" id="btn_t2cPrevious" type="button">Previous</button><!--
									--><button class="btn_etc" name="btn_t2cNext" id="btn_t2cNext" type="button">Next</button></td>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="layout_vertical_3"></div>
					<div class="layout_vertical_3"></div>
				</div>
			</div>
		</div>
		<table class="grid2 sm" style="width:100%">
			<tr>
				<th><b>Special<br>Instruction</b></th>
				<td><textarea name="spcl_instr_rmk" id="spcl_instr_rmk" cols="173" maxlength="4000" tabindex="70" style="resize:none"></textarea></td>
			</tr>
		</table>
		<table>
			<colgroup>
				<col width="120">
				<col width="180">
				<col width="70">
				<col width="160">
				<col width="40">
				<col width="130">
				<col width="40">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>TRO Confirmation </th>
					<td><input type="text" name="cfm_flg" style="width:160px;" value="" class="input2" readonly tabindex="-1" id="cfm_flg" /></td>
					<th>Date/Time</th>
					<td><input type="text" name="cfm_dt" style="width:120px" value="" class="input2" readonly tabindex="-1" id="cfm_dt" /></td>
					<th>Office</th>
					<td><input type="text" name="cfm_ofc_cd" style="width:100px" value="" class="input2" readonly tabindex="-1" id="cfm_ofc_cd" /></td>
					<th>User</th>
					<td><input type="text" name="cfm_usr_id" id="cfm_usr_id" style="width:135px" value="" class="input2" readonly onMouseOver="drs(document.form.cfm_usr_nm.value); return true;" onMouseOut="nd(); return true;" tabindex=-1><!--
					--><input type="hidden" name="cfm_usr_nm" style="width:100px" value="" class="input2" readonly="" tabindex="-1" id="cfm_usr_nm" /></td>
				</tr>
				<tr>
					<th>S/O No.</th>
					<td><input type="text" name="so_no" style="width:160px;" value="" class="input2" readonly tabindex="-1" id="so_no" /></td>
					<th>Date/Time</th>
					<td><input type="text" name="so_dt" style="width:120px" value="" class="input2" readonly tabindex="-1" id="so_dt" /></td>
					<th>Office</th>
					<td><input type="text" name="so_ofc_cd" style="width:100px" value="" class="input2" readonly tabindex="-1" id="so_ofc_cd" /></td>
					<th>User</th>
					<td><input    type="text" name="so_usr_id" style="width:135px" value="" class="input2" readonly onMouseOver="drs(document.form.so_usr_nm.value); return true;" onMouseOut="nd(); return true;" tabindex=-1><!--
					--><input type="hidden" name="so_usr_nm" style="width:100px" value="" class="input2" readonly="" tabindex="-1" id="so_usr_nm" /></td>
				</tr>
			</tbody>
		</table> 
	</div>
	<!-- opus_design_inquiry(E) -->
</div>


<div class="opus_design_grid" style="display:none">
	<!-- hidden grid : Start ---------------------->
	<script type="text/javascript">ComSheetObject('t2csheet2');</script>
	<script type="text/javascript">ComSheetObject('t2csheet3');</script>
	<script type="text/javascript">ComSheetObject('t2csheet4');</script>
	<script type="text/javascript">ComSheetObject('t2cmsgsheet1');</script>
	<!-- hidden grid : End ------------------------>
</div>

<div id="layList" name="layList" style="position:absolute;z-index:999;display:none" CELLPADDING="5" CELLSPACING="0" BORDER="0"/>
<IFRAME id="ifrm" name="ifrm" src="apps/opus/esm/bkg/bookingcommon/bookingutil/jsp/esm_booking_split_no.html"  frameborder="0" marginHeight="0" marginWidth="0" width="115" height="82"  style="position:absolute;border:1 #e9e9e9 solid" CELLSPACING="0" scrolling="no"/>

<!--20090805 for help------------>
<DIV ID='overDiv' STYLE='position:absolute; z-index:90; width:350; visibility:hidden' tabindex=-1></DIV>
<!------------------------------->

<script type="text/javascript">
	//start of help---------------------------->
	  var x = 0;
	  var y = 0;
	  var snow = 0;
	  var sw = 0;
	  var cnt = 0;
	  var dir = 1;
	  var offsetx = -80; //3;
	  var offsety = 10; //-20;
	  var width  = 40;
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
</form>
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
              String currTroSeq    = (event.getCurrTroSeq()   ==null)?"":event.getCurrTroSeq();
              String currTroSubSeq = (event.getCurrTroSubSeq()==null)?"":event.getCurrTroSubSeq();
        %>
              eval("curr_tro_seq").value     = "<%=currTroSeq%>";
              eval("curr_tro_sub_seq").value = "<%=currTroSubSeq%>";
        <%   
          }
        %>
      }
-->
</script>