<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_SCG_0015.jsp
*@FileTitle  : Dangerous CGO Application Details for Own BKG
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/15
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.event.VopScg0015Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopScg0015Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strBkgNo 	= request.getParameter("bkg_no");
	String strVvdCd 	= request.getParameter("vvd_cd");
	String strCntrSeq 	= request.getParameter("dg_cntr_seq");
	String strCgoSeq 	= request.getParameter("cntr_cgo_seq");
	String strRqstSeq 	= request.getParameter("spcl_cgo_apro_rqst_seq");
	String strRow 		= request.getParameter("row");
	String strScgFlg	= request.getParameter("scg_flg");
	String strType		= request.getParameter("type");
	String strDcgoSeq		= request.getParameter("dcgo_seq");
	
	
	String cfrFlg		= "Y".equals(request.getParameter("cfr_flg"))?"T":"F";	//2014-12-05 HDS
	Logger log = Logger.getLogger("com.clt.apps.CargoLoadingApproval.OwnDangerousCargoApproval");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopScg0015Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// add logic data extracting from server when loading initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>


<script type="text/javascript">
<%=ConstantMgr.getCompanyCodeToJS()%>
var preConds = {
	 user_id : '<%=strUsr_id%>'
	}
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if

		var toDay = new Date();
	    var year  = toDay.getUTCFullYear();
	    var month = toDay.getUTCMonth() + 1;
	    var day   = toDay.getUTCDate();
	    var hours = toDay.getUTCHours();
	    var minutes = toDay.getUTCMinutes();
	    if(month < 10) month = '0' + month;
	    if(day < 10) day = '0' + day;
	    if(hours < 10) hours = '0' + hours;
	    if(minutes < 10) minutes = '0' + minutes;
	    //var toDays = year + '-' + month + '-' + day + ' ' + hours + ':' + minutes;
	    var toDays = year + '-' + month + '-' + day;
		document.form.auth_usr_id.value = '<%=strUsr_id%>';
		document.form.vvd_cd.value = '<%=StringUtil.xssFilter(strVvdCd)%>';
		document.form.auth_dt.value = toDays;
		
		loadPage();
	}
</script>

<%-- <body class="popup_bg" onLoad="setupPage();"> --%>
<form name="form">
<input type="hidden" name="ltd_qty" id="ltd_qty" />
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="dg_cntr_seq" value="<%=StringUtil.xssFilter(strCntrSeq) %>" id="dg_cntr_seq" />
<input type="hidden" name="spcl_cgo_apro_rqst_seq" value="<%=StringUtil.xssFilter(strRqstSeq) %>" id="spcl_cgo_apro_rqst_seq" />
<input type="hidden" name="row" value="<%=StringUtil.xssFilter(strRow) %>" id="row" />
<input type="hidden" name="scg_flg" value="<%=StringUtil.xssFilter(strScgFlg) %>" id="scg_flg" />
<input type="hidden" name="type" value="<%=StringUtil.xssFilter(strType) %>" id="type" />
<input type="hidden" name="dcgo_seq" value="<%=StringUtil.xssFilter(strDcgoSeq) %>" id="dcgo_seq" />

<input type="hidden" name="vsl_cd" id="vsl_cd" />
<input type="hidden" name="temp_seq" id="temp_seq" />
<input type="hidden" name="temp_cntr_no" id="temp_cntr_no" />
<input type="hidden" name="cntr_no" id="cntr_no" />
<input type="hidden" name="cntr_tpsz_cd" id="cntr_tpsz_cd" />

<input type="hidden" name="in_imdg_pck_cd1" id="in_imdg_pck_cd1" />
<input type="hidden" name="in_imdg_pck_cd2" id="in_imdg_pck_cd2" />
<input type="hidden" name="in_imdg_pck_qty1" id="in_imdg_pck_qty1" />
<input type="hidden" name="in_imdg_pck_qty2" id="in_imdg_pck_qty2" />
<input type="hidden" name="in_imdg_pck_desc1" id="in_imdg_pck_desc1" />
<input type="hidden" name="in_imdg_pck_desc2" id="in_imdg_pck_desc2" />
<input type="hidden" name="out_imdg_pck_cd1" id="out_imdg_pck_cd1" />
<input type="hidden" name="out_imdg_pck_cd2" id="out_imdg_pck_cd2" />
<input type="hidden" name="out_imdg_pck_qty1" id="out_imdg_pck_qty1" />
<input type="hidden" name="out_imdg_pck_qty2" id="out_imdg_pck_qty2" />
<input type="hidden" name="out_imdg_pck_desc1" id="out_imdg_pck_desc1" />
<input type="hidden" name="out_imdg_pck_desc2" id="out_imdg_pck_desc2" />
<input type="hidden" name="intmd_imdg_pck_cd1" id="intmd_imdg_pck_cd1" />
<input type="hidden" name="intmd_imdg_pck_cd2" id="intmd_imdg_pck_cd2" />
<input type="hidden" name="intmd_imdg_pck_qty1" id="intmd_imdg_pck_qty1" />
<input type="hidden" name="intmd_imdg_pck_qty2" id="intmd_imdg_pck_qty2" />
<input type="hidden" name="intmd_imdg_pck_desc1" id="intmd_imdg_pck_desc1" />
<input type="hidden" name="intmd_imdg_pck_desc2" id="intmd_imdg_pck_desc2" />
<input type="hidden" name="max_in_pck_qty" id="max_in_pck_qty" />
<input type="hidden" name="max_in_pck_tp_cd" id="max_in_pck_tp_cd" />
<input type="hidden" name="hcdg_intmd_bc_rstr_desc" id="hcdg_intmd_bc_rstr_desc" />
<input type="hidden" name="hcdg_pck_rstr_desc" id="hcdg_pck_rstr_desc" />
<input type="hidden" name="hcdg_tnk_rstr_desc" id="hcdg_tnk_rstr_desc" />

<input type="hidden" name="imdg_expt_qty_cd" id="imdg_expt_qty_cd" />
<input type="hidden" name="imdg_expt_qty_desc" id="imdg_expt_qty_desc" />

<input type="hidden" name="ems_no" id="ems_no" />
<input type="hidden" name="emer_rspn_gid_no" maxlength="3" id="emer_rspn_gid_no" />
<input type="hidden" name="emer_rspn_gid_chr_no" id="emer_rspn_gid_chr_no" />
<input type="hidden" name="ctrl_temp_ctnt" id="ctrl_temp_ctnt" />
<input type="hidden" name="emer_temp_ctnt" id="emer_temp_ctnt" />
<input type="hidden" name="title_id" value="dg" id="title_id" />

<input type="hidden" name="clod_flg" id="clod_flg" />
<input type="hidden" name="rc_flg" id="rc_flg" />
<input type="hidden" name="awk_cgo_flg" id="awk_cgo_flg" />
<input type="hidden" name="bb_cgo_flg" id="bb_cgo_flg" />
<input type="hidden" name="hcdg_flg" id="hcdg_flg" />
<input type="hidden" name="meas_qty" id="meas_qty" />
<input type="hidden" name="hcdg_dpnd_qty_flg" id="hcdg_dpnd_qty_flg" />
<input type="hidden" name="spcl_rqst_flg" id="spcl_rqst_flg" />

<input type="hidden" name="temp_grs_wgt" id="temp_grs_wgt" />
<input type="hidden" name="temp_net_wgt" id="temp_net_wgt" />


<input type="hidden" name="bkg_por_cd" id="bkg_por_cd" />
<input type="hidden" name="bkg_por_yd_cd" id="bkg_por_yd_cd" />
<input type="hidden" name="bkg_del_cd" id="bkg_del_cd" />
<input type="hidden" name="bkg_del_yd_cd" id="bkg_del_yd_cd" />
<input type="hidden" name="org_trns_mod_cd" id="org_trns_mod_cd" />
<input type="hidden" name="dest_trns_mod_cd" id="dest_trns_mod_cd" />

<input type="hidden" name="bkg_pol_cd" id="bkg_pol_cd" />
<input type="hidden" name="bkg_pol_yd_cd" id="bkg_pol_yd_cd" />
<input type="hidden" name="bkg_pod_cd" id="bkg_pod_cd" />
<input type="hidden" name="bkg_pod_yd_cd" id="bkg_pod_yd_cd" />

<input type="hidden" name="mailYn" value="N" id="mailYn" />

<input type="hidden" name="imdg_lmt_qty" id="imdg_lmt_qty" />

<input type="hidden" name="imdg_lmt_qty_meas_ut_cd" id="imdg_lmt_qty_meas_ut_cd" />

<input type="hidden" name="ltd_qty" id="ltd_qty" />
<input type="hidden" name="imdg_lmt_qty_desc" id="imdg_lmt_qty_desc" />

<input type="hidden" name="imdg_subs_rsk_lbl_rmk" id="imdg_subs_rsk_lbl_rmk" />

<input type="hidden" name="itm_sts_cd" id="itm_sts_cd" />
<input type="hidden" name="imdg_amdt_no" id="imdg_amdt_no" />

<input id="erap_no" name="erap_no" type="hidden" />
<input id="erap_cntc_no" name="erap_cntc_no" type="hidden" />
<input id="erap_apro_ref_no" name="erap_apro_ref_no" type="hidden" />

<input id="dot_exp_no" name="dot_exp_no" type="hidden" />
<input id="dot_spcl_apro_no" name="dot_spcl_apro_no" type="hidden" />
<input id="dot_auth_no" name="dot_auth_no" type="hidden" />
<input id="isInquiry" name="isInquiry" value="N" type="hidden" />



<div class="layer_popup_title">
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><span>Dangerous CGO Application Details for Own BKG </span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_ApprovalDetails" 	id="btn_ApprovalDetails">Approval Details</button><!--
		--><button type="button" class="btn_normal" name="btn_attach" id="btn_attach">Attach File</button><!--
		--><button type="button" class="btn_normal" name="btn_Mail" id="btn_Mail">Mail</button><!--
		--><button type="button" class="btn_normal" name="btn_Prev" id="btn_Prev">Prev.</button><!--
		--><button type="button" class="btn_normal" name="btn_Next" id="btn_Next">Next</button><!--
		--><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button><!--
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
<div class="layer_popup_contents" >	
	<div class= "wrap_search">
		<!-- layout_wrap(S) -->
		<div class="layout_wrap">
		   <!-- layout_vertical_2(S) -->
		   <div class="layout_vertical_2 pad_rgt_4">
		   		<!-- opus_design_inquiry(S) -->
		        <div class="opus_design_inquiry" >
		        	<table> 
		        		<colgroup>
		        			<col width="50" />
		        			<col width="115" />
		        			<col width="50" />
		        			<col width="85" />
		        			<col width="40" />
		        			<col width="*" />
		        		</colgroup>
						<tr>
							<th>BKG No.</th>
							<td><input type="text" name="bkg_no" style="width:100px;" class="input2" readonly value="<%=StringUtil.xssFilter(strBkgNo) %>" id="bkg_no" /></td>
							<th>B/L No.</th>
							<td><input type="text" name="bl_no" style="width:100px;" class="input2" readonly value="" id="bl_no" /> </td>
						</tr>
						<tr>
							<th>VVD CD</th>
							<td><input type="text" name="vvd_cd" style="width:100px;" class="input2" readonly value="" id="vvd_cd" /></td>
							<th title="Port of Loading">POL</th>
							<td><input type="text" name="pol_cd" style="width:50px;" class="input2" readonly value="" id="pol_cd" /><input type="text" name="pol_nod_cd" style="width:25px;" class="input2" readonly value="" id="pol_nod_cd" /></td>
							<th title="Port of Discharging">POD</th>
							<td><input type="text" name="pod_cd" style="width:50px;" class="input2" readonly value="" id="pod_cd" /><input type="text" name="pod_nod_cd" style="width:25px;" class="input2" readonly value="" id="pod_nod_cd" /><!--
								--><button type="button" class="btn_etc" name="btn_RouteDetail" id="btn_RouteDetail" >Route Detail</button><!--
								--></td>
						</tr>
					</table>
		        </div>
		        <!-- opus_design_inquiry(E) -->
		   </div>
		   <!-- layout_vertical_2(E) -->
		   
		   <!-- layout_vertical_2(S) -->
		   <div class="layout_vertical_2">
		       <!-- opus_design_inquiry(S) -->
		       <div class="opus_design_inquiry">
		       		<table> 
		        		<colgroup>
		        			<col width="110" />
		        			<col width="230" />
		        			<col width="65" />
		        			<col width="*" />
		        		</colgroup>
						<tbody>
							<tr>
								<th>BKG.Staff</th>
								<td><input type="text" name="rqst_usr_nm" style="width:150px;" class="input2" readonly value="" id="rqst_usr_nm" /><!-- 
									 --><input type="text" name="rqst_usr_id" style="width:65px;" class="input2" readonly value="" id="rqst_usr_id" /></td>
								<th>BKG.Office</th>
								<td><input type="text" name="rqst_ofc_cd" style="width:50px;" class="input2" readonly value="" id="rqst_ofc_cd" /> </td>
							</tr>
						</tbody>
					</table>
					<table> 
		        		<colgroup>
		        			<col width="180" />
		        			<col width="*" />
		        		</colgroup>
						<tbody>
							<tr>
								<th>Requested Date (GMT)</th>
								<td colspan="3"><input type="text" name="rqst_gdt" style="width:111px;" class="input2" readonly value="" id="rqst_gdt" /> </td>
							</tr>
						</tbody>
					</table>	
					<table> 
		        		<colgroup>
		        			<col width="75" />
		        			<col width="140" />
		        			<col width="45" />
		        			<col width="*" />
		        		</colgroup>
						<tbody>
							<tr>
								<th>Tel.</th>
								<td><input type="text" name="rqst_usr_phn_no" style="width:120px;" class="input2" readonly value="" id="rqst_usr_phn_no" /> </td>
								<th>E-mail</th>
								<td><input type="text" name="rqst_usr_eml" style="width:195px;" class="input2" readonly value="" id="rqst_usr_eml" /> </td>
							</tr>
						</tbody>
					</table>
		       </div>
		       <!-- opus_design_inquiry(E) -->
		   </div>
		   <!-- layout_vertical_2(E) -->
		</div>
		<!-- layout_wrap(E) -->
		
		<table class="line_bluedot"><tr><td></td></tr></table>
	
		
	<!-- layout_wrap(S) -->
	<div class="layout_wrap">
	   <!-- layout_flex_fixed(S) -->
	   <div class="layout_flex_fixed" style="width:220px;"> <!-- setting : FIXED width(220px) -->
	       <!-- opus_design_grid(S) -->
	       <div class="opus_design_grid">
	           <script type="text/javascript">ComSheetObject('sheet1');</script>
	       </div>
	       <!-- opus_design_grid(E) -->
	       <!-- opus_design_grid(S) -->
	       <div class="opus_design_grid">
	       <!-- ::DG RailBilling 2015-12-02 :: -->
	       		<div class="opus_design_btn">
	       <button type="button" class="btn_normal" name="btn_declarant" id="btn_declarant" >Declarant</button>
	       		</div>
	       <script type="text/javascript">ComSheetObject('sheet2');</script>
	       </div>
	       <!-- opus_design_grid(E) -->
	       <!-- opus_design_grid(S) -->
	       <div class="opus_design_grid" style="display:none">
	           <script type="text/javascript">ComSheetObject('sheet3');</script>
	       </div>
	       <!-- opus_design_grid(E) -->
	       <!-- opus_design_grid(S) -->
	       <div class="opus_design_grid" style="display:none"><%//display:inline %>
	           <script type="text/javascript">ComSheetObject('sheet4');</script>
	       </div>
	       <!-- opus_design_grid(E) -->
	       <!-- opus_design_grid(S) -->
	       <div class="opus_design_grid" style="display:none">
	           <script type="text/javascript">ComSheetObject('sheet5');</script>
	       </div>
	       <!-- opus_design_grid(E) -->
	       <!-- opus_design_grid(S) -->
	       <div class="opus_design_grid" style="display:none">
	           <script type="text/javascript">ComSheetObject('sheet6');</script>
	       </div>
	       <!-- opus_design_grid(E) -->	  
	       <!-- opus_design_grid(S) -->
	       <div class="opus_design_grid" style="display:none">
	           <script type="text/javascript">ComSheetObject('sheet7');</script>
	       </div>
	       <!-- opus_design_grid(E) -->	     
	   </div>
	   <!-- layout_flex_fixed(E) -->
	   
	   <!-- layout_flex_flex(S) -->
	   <div class="layout_flex_flex" style="padding-left:228px;float:right;"> <!-- (fixed Width) + (padding 8px) = 408 -->
	       <!-- opus_design_inquiry(S) -->
	       <div class="opus_design_inquiry">
	       		<table>
	       			<colgroup>
	       				<col width="75" />
	       				<col width="100" />
	       				<col width="75" />
	       				<col width="100" />
	       				<col width="*" />
	       			</colgroup>
	       			<tbody>
	       				<tr>
							<th>Cargo Seq.</th>
							<td><select name="cntr_cgo_seq" id="cntr_cgo_seq" style="width:40px;" class="input" onchange="cntr_cgo_seq_OnChange()"></select>
									<input type="hidden" name="cntr_cgo_seq1" style="width:30px; text-align:center;" class="input2" readonly value="<%=StringUtil.xssFilter(strCgoSeq) %>" id="cntr_cgo_seq1" /><span class ="dash">/</span><!-- 
								 --><input type="text" name="cntr_cgo_seq_sum" style="width:30px; text-align:center;" class="input2" readonly value="" id="cntr_cgo_seq_sum" /></td>
							<th>DG Ref No</th>
							<td><input type="text" name="dcgo_ref_no" style="width:105px; text-align:center;" class="input2" readonly value="" id="dcgo_ref_no" /></td>
							<td>
								<div class="opus_design_btn">
									<button type="button" class="btn_etc" name="btn_UnInformation" 	id="btn_UnInformation">UN Information</button><!--
									--><button type="button" class="btn_etc" name="btn_Restrictions" id="btn_Restrictions">Restrictions</button><!--
									--><button type="button" class="btn_etc" name="btn_Pre-CheckingReport" id="btn_Pre-CheckingReport">Pre-Checking Report</button><!--
									--><button type="button" class="btn_etc" name="btn_PackageQtyType" id="btn_PackageQtyType">PKG Q'ty / Type</button><!--
								--></div>
							</td>
						</tr>	
	       			</tbody>
	       		</table>
	       		<table>
	       			<colgroup>
	       				<col width="50" />
	       				<col width="100" />
	       				<col width="70" />
	       				<col width="*" />
	       				<col width="90" />
	       				<col width="150" />
	       				<col width="80" />
	       				<col width="150" />
	       			</colgroup>
	       			<tbody>
	       				<tr>
							<th>UN No.</th>
							<td><input type="text" name="imdg_un_no" style="width:40px; text-align:center;" class="input2" readonly value="" id="imdg_un_no" /><!-- 
								--><input name="imdg_un_no_seq" type="text" style="width:40px; text-align:center;" class="input2" value="" id="imdg_un_no_seq" /><!-- 
								--><button type="button" id="btn_UnNo" name="btn_UnNo" class="input_seach_btn"></button></td>

							<td><input type="checkbox" name="cfr_flg" class="input2" value="<%=cfrFlg%>" id="cfr_flg" onclick="return(false)"/> CFR</td>
							
							<th>IMDG Class</th>
							<td><input type="text" name="imdg_clss_cd" style="width:30px; text-align:center;" class="input2" readonly value="" id="imdg_clss_cd" /><!-- 
								 --><input type="text" name="imdg_comp_grp_cd" style="width:20px; text-align:center;" class="input2" readonly value="" id="imdg_comp_grp_cd" /></td>
							<th>Gross Weight</th>
							<td><input type="text" name="grs_wgt" style="width:100px; text-align:right;" class="input2" readonly value="" id="grs_wgt" /> KGS</td>
							<th>Net Weight</th>
							<td><input type="text" name="net_wgt" style="width:100px; text-align:right;" class="input2" readonly value="" id="net_wgt" /> KGS</td>
						</tr>
	       			</tbody>
	       		</table>
	       		<table>
	       			<colgroup>
	       				<col width="150" />
	       				<col width="*" />
	       			</colgroup>
	       			<tbody>
	       				<tr>
							<th>Proper Shipping Name</th>
							<td><input type="text" name="prp_shp_nm" style="width:100%;" class="input2" readonly value="" id="prp_shp_nm" /> </td>
						</tr>
						<tr>
							<th>Technical Name</th>
							<td><input type="text" name="hzd_desc" style="width:100%;" class="input2" readonly value="" id="hzd_desc" /> </td>
						</tr>
	       			</tbody>
	       		</table>
	       		<table>
	       			<colgroup>
	       				<col width="75" />
	       				<col width="130" />
	       				<col width="95" />
	       				<col width="90" />
	       				<col width="75" />
	       				<col width="100" />
	       				<col width="80" />
	       				<col width="45" />
	       				<col width="*" />
	       			</colgroup>
	       			<tbody>
	       				<tr>
							<th>Flash Point</th>
							<td><input type="text" name="flsh_pnt_cdo_temp" style="width:50px; text-align:right;" class="input2" readonly value="" id="flsh_pnt_cdo_temp" /> °C</td>
							<th>Packing Group</th>
							<td><input type="text" name="imdg_pck_grp_cd" style="width:65px; text-align:center;" class="input2" readonly value="" id="imdg_pck_grp_cd" /></td>
							<th>PSA Group</th>
							<td><input type="text" name="psa_no" style="width:40px; text-align:center;" class="input2" readonly value="" id="psa_no" /><input type="text" style="width:40px;" class="input2" readonly value="" /></td>
							<th>Limited Q'ty</th>
							<td>
								<select name="imdg_lmt_qty_flg" id="imdg_lmt_qty_flg" style="width:40px;" class="input2" disabled>
									<option value=""></option>
									<option value="Y">Y</option>
									<option value="N">N</option>
								</select>
							</td>
							<td><input type="text" name="hcdg_flag" style="width:100%;color:red;font-weight:bold" class="input2" readonly value="" id="hcdg_flag" /> </td>
						</tr>
	       				<tr >
							<th>Sub Label</th>
							<td><input type="text" name="imdg_subs_rsk_lbl_cd1" style="width:25px;" class="input2" readonly value="" id="imdg_subs_rsk_lbl_cd1" /><!-- 
								 --><input type="text" name="imdg_subs_rsk_lbl_cd2" style="width:25px;" class="input2" readonly value="" id="imdg_subs_rsk_lbl_cd2" /><!-- 
								 --><input type="text" name="imdg_subs_rsk_lbl_cd3" style="width:25px;" class="input2" readonly value="" id="imdg_subs_rsk_lbl_cd3" /><!-- 
								 --><input type="text" name="imdg_subs_rsk_lbl_cd4" style="width:25px;" class="input2" readonly value="" id="imdg_subs_rsk_lbl_cd4" /><!-- 
							 --></td>
							<th>Cargo Status</th>
							<td>
								<select name="dcgo_sts_cd" id="dcgo_sts_cd" style="width:65px;" class="input2" disabled>
									<option value="" ></option>
									<option value="L">Liquid</option>
									<option value="G">GAS</option>
									<option value="P">PASTE</option>
									<option value="S">SOLID</option>
								</select>
							</td>
							<th>Marine Pollutant</th>
							<td>
								<select name="mrn_polut_flg" id="mrn_polut_flg" style="width:40px;" class="input2" >
									<option value="" disabled></option>
									<option value="Y" disabled>Y</option>
									<option value="N" disabled>N</option>
								</select>
							</td>
							<th>Excepted Q’ty</th>
							<td colspan="2">
								<select name="imdg_expt_qty_flg" id="imdg_expt_qty_flg" style="width:40px;" class="input2" disabled>
									<option value="Y">Y</option>
									<option value="N" selected>N</option>
								</select>
							</td>
						</tr>
						<!-- Residue Last Contained-->
	       				<tr >
							<td colspan="9">
								<table>
								<colgroup>
				       				<col width="75" />
				       				<col width="130" />
				       				<col width="95" />
				       				<col width="*" />
									<tr>
									<th>Residue Last Contained</th>							
									<td>
										<select name="rsd_flg" id="rsd_flg" style="width:40px;" class="input2" disabled>
											<option value=""></option>
											<option value="Y">Y</option>
											<option value="N">N</option>
										</select>
									</td>
									<th>Special Provisions</th>
									<td><!-- 
										 --><input type="text" name="frm_imdg_spcl_provi_no1" id="frm_imdg_spcl_provi_no1" caption="Special Provisions 1" dataformat="num" maxlength="3" style="width:33px;text-align:right;ime-mode:disabled;" class="input" value="" disabled /><!--
										--><button type="button" id="btn_imdg_spcl_provi_no1" name="btn_imdg_spcl_provi_no1" class="input_seach_btn"></button><!--
										--><input type="text" name="frm_imdg_spcl_provi_no2" id="frm_imdg_spcl_provi_no2" caption="Special Provisions 2" dataformat="num" maxlength="3" style="width:33px;text-align:right;ime-mode:disabled;" class="input" value="" disabled /><!--
										--><button type="button" id="btn_imdg_spcl_provi_no2" name="btn_imdg_spcl_provi_no2" class="input_seach_btn"></button><!--
										--><input type="text" name="frm_imdg_spcl_provi_no3" id="frm_imdg_spcl_provi_no3" caption="Special Provisions 3" dataformat="num" maxlength="3" style="width:33px;text-align:right;ime-mode:disabled;" class="input" value="" disabled /><!--
										--><button type="button" id="btn_imdg_spcl_provi_no3" name="btn_imdg_spcl_provi_no3" class="input_seach_btn"></button><!--
										--><input type="text" name="frm_imdg_spcl_provi_no4" id="frm_imdg_spcl_provi_no4" caption="Special Provisions 4" dataformat="num" maxlength="3" style="width:30px;text-align:right;ime-mode:disabled;" class="input" value="" disabled /><!--
										--><button type="button" id="btn_imdg_spcl_provi_no4" name="btn_imdg_spcl_provi_no4" class="input_seach_btn"></button><!--
										--><input type="text" name="frm_imdg_spcl_provi_no5" id="frm_imdg_spcl_provi_no5" caption="Special Provisions 5" dataformat="num" maxlength="3" style="width:40px;text-align:right;ime-mode:disabled;" class="input" value="" disabled /><!--
										--><button type="button" id="btn_imdg_spcl_provi_no5" name="btn_imdg_spcl_provi_no5" class="input_seach_btn"></button><!--
										--><input type="text" name="frm_imdg_spcl_provi_no6" id="frm_imdg_spcl_provi_no6" caption="Special Provisions 6" dataformat="num" maxlength="3" style="width:30px;text-align:right;ime-mode:disabled;" class="input" value="" disabled /><!--
										--><button type="button" id="btn_imdg_spcl_provi_no6" name="btn_imdg_spcl_provi_no6" class="input_seach_btn"></button><!--
										--><input type="text" name="frm_imdg_spcl_provi_no7" id="frm_imdg_spcl_provi_no7" caption="Special Provisions 7" dataformat="num" maxlength="3" style="width:30px;text-align:right;ime-mode:disabled;" class="input" value="" disabled /><!--
										--><button type="button" id="btn_imdg_spcl_provi_no7" name="btn_imdg_spcl_provi_no7" class="input_seach_btn"></button><!--
										--><input type="text" name="frm_imdg_spcl_provi_no8" id="frm_imdg_spcl_provi_no8" caption="Special Provisions 8" dataformat="num" maxlength="3" style="width:30px;text-align:right;ime-mode:disabled;" class="input" value="" disabled /><!--
										--><button type="button" id="btn_imdg_spcl_provi_no8" name="btn_imdg_spcl_provi_no8" class="input_seach_btn"></button><!-- 
									 --></td>
								 </tr>
								</table>
							</td>
														
						</tr>
						<!-- Residue Last Contained -->
						<!-- Segregation -->
	       				<tr >
							<th>Segregation Group</th>
							<td colspan="3">
								<script type="text/javascript">ComComboObject('imdg_segr_grp_no', 1, 300, 0, 2);</script>
							</td>
							<th>Segregation Groups </th>
							<td colspan="4"><input type="text" name="frm_hcdg_tnk_rstr_desc1" readonly style="width:40px;text-align:center" class="input2" value="" id="frm_hcdg_tnk_rstr_desc1"/>
								<input type="text" name="frm_hcdg_tnk_rstr_desc2" readonly style="width:40px;text-align:center" class="input2" value="" id="frm_hcdg_tnk_rstr_desc2" />
								<input type="text" name="frm_hcdg_tnk_rstr_desc3" readonly style="width:40px;text-align:center" class="input2" value="" id="frm_hcdg_tnk_rstr_desc3" />
								<input type="text" name="frm_hcdg_tnk_rstr_desc4" readonly style="width:40px;text-align:center" class="input2" value="" id="frm_hcdg_tnk_rstr_desc4" />
							</td>
						</tr>
						<!-- Segregation -->						
	       			</tbody>
	       		</table>
	       		<!-- layout_wrap(S) -->
				<div class="layout_wrap">
				   <!-- layout_flex_fixed(S) -->
				   <div class="layout_flex_fixed" style="width:410px;"> 
				   		<table class="grid_2"> 
				   			<colgroup>
				   				<col width="100" />
				   				<col width="*" />
				   			</colgroup>
							<tr>
								<th>Emergent Contact</th>
								<td><input type="text" name="emer_cntc_phn_no_ctnt" style="width:100%;" class="noinput2" readonly value="" id="emer_cntc_phn_no_ctnt" /> </td>
							</tr>
							<tr>
								<th>Contact Person</th>
								<td><input type="text" name="emer_cntc_pson_nm" style="width:100%;" class="noinput2" readonly value="" id="emer_cntc_pson_nm" /> </td>
							</tr>
						</table>
				   </div>
				   <!-- layout_flex_fixed(E) -->
				   <!-- layout_flex_flex(S) -->
				   <div class="layout_flex_flex" style="padding-left:418px ;">
				   		<table> 
				   			<colgroup>
				   				<col width="100" />
				   				<col width="*" />
				   			</colgroup>
							<tbody>
								<tr>
									<th> Certificate Number</th>
									<td><input type="text" name="certi_no" style="width:100%;" class="input2" readonly value="" id="certi_no" /> </td>
								</tr>
								<tr>
									<td colspan="2"><button type="button" class="btn_etc"  id="btn_OtherEmergencyInformation" name="btn_OtherEmergencyInformation" >Other Emergency and Reefer Information</button></td>
									<td><button type="button" class="btn_etc" id="btn_dot_info" name="btn_dot_info" style="width: 150px;">DOT References</button></td>
								</tr>
							</tbody>
						</table>
				   </div>
				   <!-- layout_flex_flex(E) -->
				</div>
			</div>
			<!-- layout_wrap(E) -->
       		<div class="wrap_result_tab" >
       			<script type="text/javascript">ComTabObject('tab1')</script>
       		</div>
       		
   			<div id="tabLayer" name="tabLayer" style="display:inline">
   				<table style="width:400px;" class="grid_2">
   					<colgroup>
   						<col width="100" />
   						<col width="130" />
   						<col width="*" />
   					</colgroup>
					<tr>
						<th rowspan="2">Class 1 Only</th>
						<th>Consignee Detail</th>
						<td><input name="cnee_dtl_desc" type="text" style="width:100%;" class="noinput2" readonly value="" id="cnee_dtl_desc" /></td>
					</tr>
					<tr>
						<th>Net Explosive Weight</th>
						<td><input type="text" name="net_explo_wgt" style="width:75%; text-align:right;" class="noinput2" readonly value="" id="net_explo_wgt" /><input type="text" style="width:20%;" class="noinput2" readonly value="KGS" /></td>
					</tr>
				</table>
   			</div>
  			
       		<div id="tabLayer" name="tabLayer" style="display:none">
       			<table style="width:400px; " class="grid_2"> 
       				<colgroup>
       					<col width="60" />
       					<col width="70" />
       					<col width="70" />
       					<col width="70" />
       					<col width="70" />
       					<col width="*" />
       				</colgroup>
					<tr>
						<td rowspan="3">Class 7<br>Only</td>
						<th colspan="5">Radio Active Commodities</th>
					</tr>
					<tr>
						<th>Schedule</th>
						<td  id="rada_skd_no" name="rada_skd_no" ></td>
						<th>Activity</th>
						<td><input type="text" name="rada_amt" style="width:60%; text-align:right;" class="noinput2" readonly value="" id="rada_amt" /></td>
						<td>
							<select name="rada_ut_cd" id="rada_ut_cd" style="width:60px;" class="input2" disabled >
								<option value=""></option>
								<option value="MBQ">MBQ</option>
								<option value="NBQ">NBQ</option>
								<option value="GBQ">GBQ</option>
								<option value="TBQ">TBQ</option>
							</select>
						</td>
					</tr>
					<tr>
						<th colspan="2"> Transportation Index</th>
						<td colspan="3"><input type="text" name="rada_trsp_no" style="width:100%; text-align:center;" class="noinput2" value="" maxlength="8" id="rada_trsp_no" /></td>
					</tr>
				</table>
       		</div>
       		 <table>
       		 	<colgroup>
       		 		<col width="70" />
       		 		<col width="*" />
       		 	</colgroup>
       		 	<tbody>
       		 		<tr>
						<th>Remark(s)</th>
						<td><input type="text" name="diff_rmk" style="width:90%;" class="input2" readonly value="" id="diff_rmk" />
							<button type="button" class="btn_etc" name ="btn2" id ="btn2">></button>
						</td>
					</tr>
       		 	</tbody>
       		 </table>
	       </div>
	   <!-- layout_flex_flex(E) -->
	</div>
	<!-- layout_wrap(E) -->
	</div>	
	<div class="wrap_search">
		<div class= "opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="100" />
					<col width="110" />
					<col width="100" />
					<col width="100" />
					<col width="100" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<th>Approval by</th>
						<td><input type="text" name="auth_usr_id" style="width:108px;" class="input" readonly value="" id="auth_usr_id" /> </td>
						<th>Date (GMT)</th>
						<td colspan="3"><input type="text" name="auth_dt" style="width:80px;" class="input" readonly value="" id="auth_dt" /> </td>
					</tr>
					<tr>
						<th>Approval</th>
						<td width=""><select name="spcl_cgo_auth_cd" id="spcl_cgo_auth_cd" style="width:108;" class="input1" style="font-weight:bold;" onchange="spcl_cgo_auth_cd_OnChange()" >
							<option value="Y" style="color:green;">Y</option>
							<option value="A" style="color:green;">Y(all)</option>
							<option value="N" style="color:red;">N</option>
							<option value="P" style="color:blue;">P</option>
							<option value="" style="color:orange;"></option>
							</select>
						</td>
						<th>RJT Code</th>
						<td width="100" style="padding-left:2;"> 
							<script type="text/javascript">ComComboObject('spcl_cgo_auth_rjct_cd', 2, 80, 0, 2);</script>
						</td>
						<th>Remark(s)</th>
						<td><input type="text" name="spcl_cgo_auth_rmk" style="width:100%;" class="input" value="" id="spcl_cgo_auth_rmk" /> </td>
					</tr>
					<tr>
						<th>Approval Ref. No.</th>
						<td colspan="5"><input type="text" name="apro_ref_no" style="width:378px;" class="input2" value="" maxlength="50" disabled="" id="apro_ref_no" /> </td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>		
</div>

</form>