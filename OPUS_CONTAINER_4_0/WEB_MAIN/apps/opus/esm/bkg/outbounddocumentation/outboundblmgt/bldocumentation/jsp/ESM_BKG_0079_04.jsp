<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0079_04.jsp
*@FileTitle  : Container Information - Creation
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
<%@ page import="com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event.EsmBkg007904Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List" %>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO" %>
<%@ page import="com.clt.apps.opus.esm.bkg.common.*" %>

<%
	EsmBkg007904Event  event = null;			//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from the server	
	String strErrMsg = "";						//error messege
	int rowCount	 = 0;						//the number of DB ResultSet List

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.OutboundBLMgt.BLDocumentation");

	// search Init
	String bkgNo      = "";
	String blNo       = "";
	String scrnAuth   = "";

	//List<BkgComboVO> frt_terms = null;
	List<BkgComboVO> wgt_units = null;
	List<BkgComboVO> meas_units = null;

	try {

	   	SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg007904Event)request.getAttribute("Event");
		bkgNo      = event.getBkgNo();
		blNo       = event.getBlNo();
		scrnAuth   = (String)event.getAttribute("SCRN_AUTH");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//  extract additional data obtained from the server during Initial loading ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        //frt_terms = (List<BkgComboVO>) eventResponse.getCustomData("frt_terms");
        wgt_units = (List<BkgComboVO>) eventResponse.getCustomData("wgt_units");
        meas_units = (List<BkgComboVO>) eventResponse.getCustomData("meas_units");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>



<script type="text/javascript">
	function setupPage(){
		// Global variables
		cur_usr_id = "<%=strUsr_id%>";
		scrnAuth = "<%=scrnAuth%>";
	    rcv_term_str = "Y|D|S|T|I";
	    del_term_str = "Y|D|S|T|O";
	    seal_knd_str = " |M|E";
	    seal_pty_tp_str = " |SH|CA|AA|CU|AB|AC|TO";

		// init screen
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>


<form name="form" onKeyDown="ComKeyEnter('search')">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">

<input type="hidden" name="dirty_flag" id="dirty_flag">
<input type="hidden" name="bdr_flg" id="bdr_flg">
<input type="hidden" name="corr_flg" id="corr_flg">
<input type="hidden" name="ca_exist_flg" id="ca_exist_flg">
<input type="hidden" name="fnl_cfm_flg" id="fnl_cfm_flg">
<input type="hidden" name="modify_fnl_cfm_flg" id="modify_fnl_cfm_flg">
<input type="hidden" name="cn_flg" id="cn_flg">
<input type="hidden" name="not_updated_flg" id="not_updated_flg">
<input type="hidden" name="flex_hgt_flg" id="flex_hgt_flg">
<input type="hidden" name="obl_iss_flg" id="obl_iss_flg">
<input type="hidden" name="bl_tp_cd" id="bl_tp_cd">
<input type="hidden" name="not_crd_flg" id="not_crd_flg">
<input type="hidden" name="cn_dir_flg" id="cn_dir_flg">
<input type="hidden" name="shp_flg" id="shp_flg">
<input type="hidden" name="ucr_flg" id="ucr_flg">
<!-- RD Param Start -->
<input type="hidden" name="com_mrdPath" id="com_mrdPath">
<input type="hidden" name="com_mrdArguments" id="com_mrdArguments">
<input type="hidden" name="com_mrdDisableToolbar" id="com_mrdDisableToolbar">
<input type="hidden" name="com_mrdTitle" id="com_mrdTitle">
<input type="hidden" name="com_mrdBodyTitle" id="com_mrdBodyTitle">
<!-- RD Param End -->
<input type="hidden" name="mlt_shp_flg" id="mlt_shp_flg"><!-- multiShipment flag : 'Y'/'N' -->


<!-- opus_design_btn(S) -->
<div class="opus_design_btn opus_design_normal2">
	<button type="button" class="btn_normal2" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--  
	--><button type="button" class="btn_normal2" name="btn_t6save" id="btn_t6save">Save</button><!--
	--><button type="button" class="btn_normal2" name="btn_t6cntrconfirm" id="btn_t6cntrconfirm">Container Confirmation</button><!--
	--><button type="button" class="btn_normal2" name="btn_t6cntrrelease" id="btn_t6cntrrelease">Cancel Confirmation</button><!--

	--><button type="button" class="btn_normal2" name="btn_t6cntrhist" id="btn_t6cntrhist">CNTR History</button><!--
	--><button type="button" class="btn_normal2" name="btn_t6notupdated" id="btn_t6notupdated">Not Updated CNTR</button><!--
	--><button type="button" class="btn_normal2" name="btn_t6downexcel" id="btn_t6downexcel">Down Excel</button><!--
	--><button type="button" class="btn_normal2" name="btn_t6print" id="btn_t6print">Print</button>
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
					<td>
						<input type="text" id="bkg_no" name="bkg_no" style="ime-mode:disabled;text-transform:uppercase;width:120px;" dataformat="engup"  class="input1" value="<%=bkgNo%>" maxlength="13" /><!--  
						--><button type="button" class="btn_down_list" name="btn_splitPop" id="btn_splitPop"></button>
					</td>
					<th>B/L No.</th>
					<td><input type="text" name="bl_no" style="ime-mode:disabled;text-transform:uppercase;;width:120px;" dataformat="engup"  class="input" value="<%=blNo%>" id="bl_no" maxlength="13" /> </td>
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
				<col width="55"/>
				<col width="50"/>
				<col width="85"/>
				<col />
			</colgroup>	
			<tbody>
				<tr>
					<th>BKG STS</th>
					<td><input type="text" name="bkg_sts_cd" style="ime-mode:disabled;text-transform:uppercase;width:30px;" dataformat="engup"  class="input2" readonly="" id="bkg_sts_cd" /> </td>
					<th>Cargo Type</th>
					<td><input type="text" name="bkg_cgo_tp_cd" style="ime-mode:disabled;text-transform:uppercase;width:30px;" dataformat="engup"  class="input2" readonly="" id="bkg_cgo_tp_cd" /> </td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(1) (E) -->
	<table class="line_bluedot" border="0" ><tr><td></td></tr></table>
		
		
	<!-- opus_design_inquiry(2) (S) -->
	<div class="opus_design_inquiry wFit mar_btm_none"> 
		<table> 
			<colgroup>
				<col width="55"/>
				<col width="130"/>
				<col width="50"/>
				<col width="300"/>
				<col width="70"/>
				<col width="100"/>
				<col />
			</colgroup>	
			<tbody>
				<tr>
					<th>T/VVD</th>
					<td><input type="text" name="t_vvd" size="14" class="input2" readonly="" id="t_vvd" /> </td>
					<th>Route</th>
					<td><input type="text" name="por_cd" style="ime-mode:disabled;text-transform:uppercase;width:65px;" dataformat="engup"  class="input2" readonly="" id="por_cd" /><input type="text" name="pol_cd" style="ime-mode:disabled;text-transform:uppercase;;width:65px;" dataformat="engup"  class="input2" readonly="" id="pol_cd" /><input type="text" name="pod_cd" style="ime-mode:disabled;text-transform:uppercase;;width:65px;" dataformat="engup"  class="input2" readonly="" id="pod_cd" /><input type="text" name="del_cd" style="ime-mode:disabled;text-transform:uppercase;;width:65px;" dataformat="engup"  class="input2" readonly="" id="del_cd" />
					<th>R/D Term</th>
					<td><input type="text" name="rcv_term_cd" style="ime-mode:disabled;text-transform:uppercase;;width:30px;" dataformat="engup"  class="input2" readonly="" id="rcv_term_cd" /><input type="text" name="de_term_cd" style="ime-mode:disabled;text-transform:uppercase;width:30px;" dataformat="engup"  class="input2" readonly="" id="de_term_cd" />
					<td class="btn2_left"><button type="button" class="btn_etc" name="btn_VarianceDtl" id="btn_VarianceDtl">Vol. Difference</button></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(2) (E) -->
		
	<!-- opus_design_inquiry(3) (S) -->
	<div class="opus_design_inquiry mar_btm_none"> 
		<div class="layout_wrap">
		 	<div class="layout_flex_flex" style="padding-right:658px;">
	 			<div class="opus_design_grid">
	 				<script type="text/javascript">ComSheetObject('t6sheet1');</script>
	 			</div>
		 	</div>
		 	
		 	<div class="layout_flex_fixed floatR pad_left_8" style="width:150px;">
		 		<table class="grid_2"> 
		 			<tbody>
						<tr><th style="height:24px">Weight</th></tr>
						<tr><td class="noinput">
							<%=HTMLUtil.getComboString("bkg_wgt_ut_cd", "width:98%;", "input", "", wgt_units)%></td>
						</tr>
						<tr><th style="height:24px">Measure</th></tr>
						<tr><td class="noinput">
							<%=HTMLUtil.getComboString("bkg_meas_ut_cd", "width:98%;", "input", "", meas_units)%></td>
						</tr>
					</tbody>
				</table>
		 	</div>
		 	
		 	<div class="layout_flex_fixed floatR" style="width:500px;">	 	
		 		<table class="grid_2">
					<tr>
						<th width="12%">Total</th>
						<th width="12%">Quantity</th>
						<th width="12%">Package</th>
						<th width="12%">Weight</th>
						<td width="12%" id="wgt_ut_cd" name="wgt_ut_cd" class="input2" readOnly></td>
						<th width="12%">Measure</th>
						<td width="12%" id="meas_ut_cd" class="input2" readOnly></td>
					</tr>
					<tr><th>Booking</th>
						<td align="right" id="bkg_qty" class="input2" readOnly></td>
						<td align="right" id="bkg_pck_qty" class="input2" readOnly></td>
						<td colspan="2" align="right" id="bkg_act_wgt" class="input2" readOnly></td>
						<td colspan="2" align="right" id="bkg_meas_qty" class="input2" readOnly></td>
					</tr>
					<tr><th>Container</th>
						<td align="right" id="cntr_qty" class="input2" readOnly></td>
						<td align="right" id="cntr_pck_qty" class="input2" readOnly></td>
						<td colspan="2" align="right" id="cntr_act_wgt" class="input2" readOnly></td>
						<td colspan="2" align="right" id="cntr_meas_qty" class="input2" readOnly></td>
					</tr>
					<tr><th>Variance</th>
						<td align="right" id="var_qty"  class="input2"></td>
						<td align="right" id="var_pck_qty" class="input2"></td>
						<td colspan="2" align="right" id="var_act_wgt" class="input2"></td>
						<td colspan="2" align="right" id="var_meas_qty" class="input2"></td>
					</tr>
				</table>
		 	</div>
		 	
		</div>
	</div>
	<!-- opus_design_inquiry(3) (E) -->
	<table class="line_bluedot"><tr><td></td></tr></table>
	
	
	
	<!-- opus_design_grid (S) -->
	<div class="opus_design_grid">
	  	<div class="grid_option_left">
            <table> 
          		<tbody>
           			<tr>
            			<th width="100">Final Confirm</th>
            			<td width="280"><input type="text" name="evnt_usr_id" style="ime-mode:disabled;width:100px;" class="input2" readOnly><!-- 
							--><input type="text" name="evnt_dt" style="ime-mode:disabled;width:120px;" class="input2" readOnly></td>
						<th width="130">Cargo Receiving Date</th>
						<td><input type="text" name="cgo_rcv_dt" style="ime-mode:disabled;width:120px;" class="input2" readOnly></td>
          			</tr>
         		</tbody>
         	</table>
  		</div>
  		
  		<div class="opus_design_btn">
  		   <button type="button" class="btn_normal" name="btn_t6gridmultishp" id="btn_t6gridmultishp">Multi-Shipment</button>
		   <button type="button" class="btn_normal" name="btn_t6gridcntrirr" id="btn_t6gridcntrirr">CRD P/Up</button>
		   <button type="button" class="btn_normal" name="btn_t6gridadd" id="btn_t6gridadd">Row Add</button>
		   <button type="button" class="btn_normal" name="btn_t6griddel" id="btn_t6griddel">Row Delete</button>
		   <button type="button" class="btn_normal" name="btn_t6gridmove" id="btn_t6gridmove">Copy & Move</button>
		   <button type="button" class="btn_normal btn_up" name="btn_t6sequp" id="btn_t6sequp"><!-- <img src="img/btn_2_left_up.gif" name="btn_t6sequp" width="17" height="19" alt="" border="0"> --></button>
		   <button type="button" class="btn_normal btn_down" name="btn_t6seqdown" id="btn_t6seqdown"><!-- <img src="img/btn_2_left_down.gif" name="btn_t6seqdown" width="17" height="19" alt="" border="0"> --></button>
  		</div>
	 		<script type="text/javascript">ComSheetObject('t6sheet2');</script>
			<script type="text/javascript">ComSheetObject('t6sheet3');</script>
			<script type="text/javascript">ComSheetObject('t6sheet4');</script>
			<script type="text/javascript">ComSheetObject('t6sheet5');</script>
  	</div>
	<!-- opus_design_grid (E) -->
	  	
	  	
</div>
<!-- wrap_result (E) -->


<div id="layList" name="layList" style="position:absolute;z-index:999;display:none" CELLPADDING=5 CELLSPACING=0 BORDER=0/>
<IFRAME id="ifrm" name="ifrm" src="apps/opus/esm/bkg/bookingcommon/bookingutil/jsp/esm_booking_split_no.html"  frameborder=0 marginHeight=0 marginWidth=0 width=115 height=82  style="position:absolute;border:1 #e9e9e9 solid" CELLSPACING=0 scrolling="no"/>
</form>