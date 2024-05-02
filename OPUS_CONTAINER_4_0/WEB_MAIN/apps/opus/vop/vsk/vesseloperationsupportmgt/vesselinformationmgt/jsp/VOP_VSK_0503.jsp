<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_VSK_0503.jsp
*@FileTitle  : Vessel Information inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/10
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.event.VopVsk0503Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk0503Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB ResultSet list
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.VesselOperationSupportMgt.VesselInformationMgt");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (VopVsk0503Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
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
<input type="hidden" name="pagerows" id="pagerows" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" 		id="btn_Retrieve">Retrieve</button><!--  
		--><button type="button" class="btn_normal" name="btn_New"  		id="btn_New">New</button><!--  
		--><button type="button" class="btn_normal" name="btn_Excel" 		id="btn_Excel">Down Excel</button>
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->

<div class="wrap_search_tab">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry">
	<table>
		<colgroup>
			<col width="80">
			<col width="320">
			<col width="35">
			<col width="280">
			<col width="110">
			<col width="*">
	    </colgroup>
		<tbody>
			<tr>
				<th>Vessel Code</th>
				<td><input type="text" style="width:60px;text-align:center;" class="input1" name="vsl_cd" id="vsl_cd" dataformat="engup" style="ime-mode:disabled" maxlength="4" caption="Vessel Code"><button type="button" class="input_seach_btn" name="btn_vsl_cd" id="btn_vsl_cd"></button><input type="text" style="width:230px;" class="input2" name="vsl_eng_nm" id="vsl_eng_nm" readOnly></td>
				<th>Year </th>
				<td><input type="hidden" name="nowYear" id="nowYear" style="width:50px;" class="input2" value="<%=DateTime.getYear()%>"><script type="text/javascript">ComComboObject('year', 1, 80, 1);</script>
				<th>Updated Date</th>
				<td><input type="text" name="upd_dt" id="upd_dt" style="width:115px;text-align:center;" class="input2" readOnly><input type="text" name="upd_usr_id" id="upd_usr_id" style="width:80px;" class="input2" readOnly></td>
			</tr>
		</tbody>
	</table>
</div>
<!-- opus_design_inquiry(E) -->
</div>
<div class="wrap_result">
<!-- opus_tab_btn(S) -->
<div class="opus_design_tab">
	<script type="text/javascript">ComTabObject('tab1')</script>
</div>
<!-- opus_tab_btn(E) -->

<!-- layout_wrap(S) -->
<div class="layout_wrap" name="tabLayer" id="tabLayer" style="display:inline;">
     <!-- opus_design_grid(S) -->
     <div class="opus_design_grid" id="tabLayer22" style="display:none;">
<script type="text/javascript">ComSheetObject('t1sheet1');</script>
     </div>
        <!-- opus_design_grid(E) -->
        <div class="opus_design_inquiry">
        <div class="layout_wrap">
        <div class="layout_flex_fixed pad_rgt_8" style="width:500px;">
			<h3 class="title_design">Basic 1</h3>
			<table class="sm">
					<colgroup>
						<col width="70">
						<col width="80">
						<col width="129">
						<col width="*">
				    </colgroup>
					<tbody>
					<tr><td colspan="4" style="height:5px"></td></tr>
					<tr>
						<th>Carrier</th>
						<td><input type="text" style="width:35px;text-align:center" class="input" name="crr_cd" id="crr_cd" readOnly><input type="text" style="width:145px;" class="input" name="crr_full_nm" id="crr_full_nm" readOnly></td>
						<th>Keel Laid DT</th>
						<td><input type="text" style="width:80px;text-align:center" class="input" name="vsl_kel_ly_dt" id="vsl_kel_ly_dt" readOnly></td>
					</tr>
					</tbody>
				</table>
				<table class="sm" >
					<colgroup>
						<col width="70">
						<col width="52">
						<col width="71">
						<col width="60">
						<col width="127">
						<col width="*">
				    </colgroup>
					<tbody>
					<tr>
						<th>Vessel TP</th>
						<td><input type="text" style="width:55px;text-align:center" class="input" name="vsl_type" id="vsl_type" readOnly></td>
						<th>Crew</th>
						<td><input type="text" style="width:52px;text-align:center" class="input" name="crw_knt" id="crw_knt" readOnly></td>
						<th>Built DT</th>
						<td><input type="text" style="width:80px;text-align:center" class="input" name="vsl_lnch_dt" id="vsl_lnch_dt" readOnly></td>
					</tr>
					</tbody>
				</table>
				<table class="sm" >
					<colgroup>
						<col width="70">
						<col width="80">
						<col width="128">
						<col width="*">
				    </colgroup>
					<tbody>
					<tr>
						<th>Ownership</th>
						<td><input type="text" style="width:185px;" class="input" name="vsl_own_ind_cd" id="vsl_own_ind_cd" readOnly></td>
						<th>Delivered DT</th>
						<td><input type="text" style="width:80px;text-align:center" class="input" name="vsl_de_dt" id="vsl_de_dt" readOnly></td>
					</tr>
					<tr>
						<th>New Bult</th>
						<td><input type="text" style="width:55px;text-align:center" class="input" name="vsl_bld_cd" id="vsl_bld_cd" readOnly></td>
						<th>Registered DT</th>
						<td><input type="text" style="width:80px;text-align:center" class="input" name="rgst_dt" id="rgst_dt" readOnly></td>
					</tr>
					<tr><td colspan="4" style="height:5px"></td></tr>
				</tbody>
			</table>
			</div>
			<div class="layout_vertical_2" style = "width: 550px">
			<h3 class="title_design">Basic 2</h3>
			<table class="sm">
					<colgroup>
						<col width="120">
						<col width="150">
						<col width="50">
						<col width="90">
				    </colgroup>
				    <tbody>
				    <tr><td colspan="2" style="height:5px"></td></tr>
					<tr>
						<th>Call Sign</th>
						<td><input type="text" style="width:60px;text-align:center" class="input" name="call_sgn_no" id="call_sgn_no" readOnly></td>
						<th>Official No.</th>
						<td><input type="text" style="width:100px;text-align:center" class="input" name="rgst_no" id="rgst_no" readOnly></td>
					</tr>
					<tr>
						<th>Flag</th>
						<td><input type="text" style="width:220px;" class="input" name="cnt_nm" id="cnt_nm" readOnly></td>
						<th>Hull No.</th>
						<td><input type="text" style="width:100px;text-align:center" class="input" name="vsl_hl_no" id="vsl_hl_no" readOnly></td>
					</tr>
					<tr>
						<th>Port of Registry</th>
						<td colspan="3"><input type="text" style="width:404px;" class="input" name="rgst_port_cd" id="rgst_port_cd" readOnly></td>
					</tr>
					<tr>
						<th>Class / No.</th>
						<td><input type="text" style="width:173px;" class="input" name="clss_no_rgst_area_nm" id="clss_no_rgst_area_nm" readOnly><input type="text" style="width:40px;text-align:center" class="input" name="vsl_clss_no" id="vsl_clss_no" readOnly></td>
						<th>P & I Club</th>
						<td><input type="text" style="width:100px;text-align:center" class="input" name="piclb_desc" id="piclb_desc" readOnly></td>
					</tr>
					<tr>
						<th>IMO No.(Lloyd Code)</th>
						<td><input type="text" style="width:80px;text-align:center" class="input" name="lloyd_no" readOnly></td>
						<th>Builder</th>
						<td><input type="text" style="width:100px;text-align:center" class="input" name="vsl_bldr_nm" id="vsl_bldr_nm" readOnly></td>
					</tr>
					<tr><td colspan="2" style="height:5px"></td></tr>
				</tbody>
			</table>
		</div>
		</div>
		<div class="layout_wrap pad_top_12">
	    <div class="layout_flex_fixed" style="width:500px">
	    	<div class="layout_flex_fixed pad_rgt_8" style="width:195px">
			<h3 class="title_design">CNTR Capacity</h3>
			<table class="sm">
				<colgroup>
				<col width="70">
				<col width="*">
		    	</colgroup>
		    	<tbody>
		    		<tr><td colspan="2" style="height:5px"></td></tr>
					<tr>
						<th>Design</th>
						<td><input type="text" style="width:60px;text-align:right" class="input" name="cntr_dzn_capa" id="cntr_dzn_capa" readOnly></td>
					</tr>
					<tr>
						<th>Operation</th>
						<td><input type="text" style="width:60px;text-align:right" class="input" name="cntr_op_capa" id="cntr_op_capa" readOnly></td>
					</tr>
					<tr>
						<th>Panama</th>
						<td width=""><input type="text" style="width:60px;text-align:right" class="input" name="cntr_pnm_capa" id="cntr_pnm_capa" readOnly></td>
					</tr>
					<tr>
						<th>VSL Class</th>
						<td width=""><input type="text" style="width:60px;text-align:right" class="input" name="cntr_vsl_clss_capa" id="cntr_vsl_clss_capa" readOnly></td>
					</tr>
					<tr><td colspan="2" style="height:5px"></td></tr>
				</tbody>
			</table>
	    	</div>
	    	<div class="layout_flex_fixed pad_rgt_8" style="width:305px">
			<h3 class="title_design">Communication</h3>
			<table class="sm">
			<colgroup>
				<col width="50">
				<col width="*">
		    </colgroup>
		    	<tbody>
		    		<tr><td colspan="2" style="height:5px"></td></tr>
					<tr>
						<th>TEL</th>
						<td><input type="text" style="width:225px" class="input" name="phn_no" id="phn_no" readOnly></td>
					</tr>
					<tr>
						<th>FAX</th>
						<td><input type="text" style="width:225px" class="input" name="fax_no" id="fax_no" readOnly></td>
					</tr>
					<tr>
						<th>TLX</th>
						<td><input type="text" style="width:225px" class="input" name="tlx_no" id="tlx_no" readOnly></td>
					</tr>
					<tr>
						<th>E-mail</th>
						<td><input type="text" style="width:225px" class="input" name="vsl_eml" id="vsl_eml" readOnly></td>
					</tr>
					<tr><td colspan="2" style="height:5px"></td></tr>
				</tbody>
			</table>
	    	</div>
	    </div>
    	<div class="layout_flex_fixed" style="width:550px">
    		<div class="layout_flex_fixed pad_rgt_8" style="width:305px">
			<h3 class="title_design">R/F Receptacle</h3>
			<table class="sm" >
			<colgroup>
				<col width="50">
				<col width="*">
		    </colgroup>
		    <tbody>
		    	<tr><td colspan="2" style="height:5px"></td></tr>
				<tr>
					<th>OPER</th>
					<td><input type="text" style="width:60px;text-align:right" class="input" name="rf_rcpt_knt" id="rf_rcpt_knt" readOnly></td>
				</tr>
				<tr>
					<th>MAX.</th>
					<td><input type="text" style="width:60px;text-align:right" class="input" name="rf_rcpt_max_knt" id="rf_rcpt_max_knt" readOnly></td>
				</tr>
				<tr><td colspan="2" style="height:5px"></td></tr>
			</tbody>
			</table>
			<br>
		<h3 class="title_design">Speed</h3>
		<table class="sm" >
			<colgroup>
				<col width="50">
				<col width="*">
		    </colgroup>
		    <tbody>
		    	<tr><td colspan="2" style="height:5px"></td></tr>
				<tr>
					<th>MIN.</th>
					<td class="stm"><input type="text" style="width:60px;text-align:right" class="input" name="ecn_spd" id="ecn_spd" readOnly><label for ="ecn_spd">Knots</label></td>
				</tr>
				<tr>
					<th>Service</th>
					<td class="stm"><input type="text" style="width:60px;text-align:right" class="input" name="vsl_svc_spd" id="vsl_svc_spd" readOnly><label for ="vsl_svc_spd">Knots</label></td>
				</tr>
				<tr>
					<th>MAX.</th>
					<td class="stm"><input type="text" style="width:60px;text-align:right" class="input" name="max_spd" id="max_spd" readOnly><label for ="vsl_svc_spd">Knots</label></td>
				</tr>
				<tr><td colspan="2" style="height:5px"></td></tr>
			</tbody>
		</table>
	    </div>
	    <div class="layout_flex_fixed" style="width:245px">
		<h3 class="title_design">Dimension</h3>
		<table class="sm">
			<colgroup>
				<col width="90">
				<col width="*">
		    </colgroup>
		    	<tbody>
		    		<tr><td colspan="2" style="height:5px"></td></tr>
					<tr>
						<th>L.O.A</th>
						<td class="stm"><input type="text" style="width:80px;text-align:right" class="input" name="loa_len" id="loa_len" readOnly><label>M</label></td>
					</tr>
					<tr>
						<th>L.B.P</th>
						<td class="stm"><input type="text" style="width:80px;text-align:right" class="input" name="lbp_len" id="lbp_len" readOnly><label>M</label></td>
					</tr>
					<tr>
						<th>Breadth</th>
						<td class="stm"><input type="text" style="width:80px;text-align:right" class="input" name="vsl_wdt" id="vsl_wdt" readOnly><label>M</label></td>
					</tr>
					<tr>
						<th>Depth</th>
						<td class="stm"><input type="text" style="width:80px;text-align:right" class="input" name="vsl_dpth" id="vsl_dpth" readOnly><label>M</label></td>
					</tr>
					<tr>
						<th>Height</th>
						<td class="stm"><input type="text" style="width:80px;text-align:right" class="input" name="vsl_hgt" id="vsl_hgt" readOnly><label>M</label></td>
					</tr>
					<tr>
						<th>Summer Draft</th>
						<td class="stm"><input type="text" style="width:80px;text-align:right" class="input" name="smr_drft_hgt" id="smr_drft_hgt" readOnly><label>M</label></td>
					</tr>
					<tr>
						<th>Freeboard</th>
						<td class="stm"><input type="text" style="width:80px;text-align:right" class="input" name="fbd_capa" id="fbd_capa" readOnly><label>M</label></td>
					</tr>
					<tr><td colspan="2" style="height:5px"></td></tr>
				</tbody>
			</table>
		</div>
	</div>
	</div>
</div>
</div>
<!-- layout_wrap(E) -->

<!-- opus_design_grid(S) -->	
<div class="opus_design_grid clear" style="display:none;" name="tabLayer" id="tabLayer">
	<div class="opus_design_inquiry">
		<table class="search">
			<colgroup>
				<col width="85">
				<col width="230">
				<col width="85">
				<col width="230">
				<col width="70">
				<col width="*">
		    </colgroup>
		    <tbody>
				<tr>
					<th>Displacement</th>
					<td class="stm"><input type="text" style="width:120px;text-align:right" class="input" name="dpl_capa" id="dpl_capa" readOnly><label>M/T</label></td>
					<th>Dead Weight</th>
					<td class="stm"><input type="text" style="width:120px;text-align:right" class="input" name="dwt_wgt" id="dwt_wgt" readOnly><label>M/T</label></td>
					<th>Light Ship</th>
					<td class="stm"><input type="text" style="width:120px;text-align:right" class="input" name="lgt_shp_tong_wgt" id="lgt_shp_tong_wgt" readOnly><label>M/T</label></td>
				</tr>
			</tbody>
		</table>
		<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
	</div>
	<div class="opus_design_inquiry">
		<table class="grid_2 wFit">
			<tr>
				<th class="sm" width="200px" style="font-weight: bold; text-align: center;">Tonnage Type</th>
				<th class="sm" width="200px" style="font-weight: bold; text-align: center;">International</th>
				<th class="sm" width="200px" style="font-weight: bold; text-align: center;">Panama</th>
				<th class="sm" width="200px" style="font-weight: bold; text-align: center;">Suez</th>
				<th class="sm" width="*" style="font-weight: bold; text-align: center;">ITC</th>   
			</tr>
			<tr align="right">
				<td class="sm" style="text-align: center;">Gross Ton</td>
				<td style="aling:center; padding:5px;"><input type="text" style="width:203px;text-align:right" class="noinput" name="grs_rgst_tong_wgt" id="grs_rgst_tong_wgt" readOnly><input type="text" style="width:30px;text-align:right" class="noinput" value="M/T" readOnly></td>
				<td style="aling:center; padding:5px;"><input type="text" style="width:203px;text-align:right" class="noinput" name="pnm_gt_wgt" id="pnm_gt_wgt" readOnly><input type="text" style="width:30px;text-align:right" class="noinput" value="M/T" readOnly></td>
				<td style="aling:center; padding:5px;"><input type="text" style="width:203px;text-align:right" class="noinput" name="suz_gt_wgt" id="suz_gt_wgt" readOnly><input type="text" style="width:30px;text-align:right" class="noinput" value="M/T" readOnly></td>
				<td style="aling:center; padding:5px;"><input type="text" style="width:100%;text-align:center" class="noinput" name="" id="" readOnly></td>
			</tr>
			<tr align="right">
				<td class="sm" style="text-align: center;">Net Ton</td>
				<td style="aling:center; padding:5px;"><input type="text" style="width:203px;text-align:right" class="noinput" name="net_rgst_tong_wgt" id="net_rgst_tong_wgt" readOnly><input type="text" style="width:30px;text-align:right" class="noinput" value="M/T" readOnly></td>
				<td style="aling:center; padding:5px;"><input type="text" style="width:203px;text-align:right" class="noinput" name="pnm_net_tong_wgt" id="pnm_net_tong_wgt" readOnly><input type="text" style="width:30px;text-align:right" class="noinput" value="M/T" readOnly></td>
				<td style="aling:center; padding:5px;"><input type="text" style="width:203px;text-align:right" class="noinput" name="suz_net_tong_wgt" id="suz_net_tong_wgt" readOnly><input type="text" style="width:30px;text-align:right" class="noinput" value="M/T" readOnly></td>
				<td style="aling:center; padding:5px;"><input type="text" style="width:100%;text-align:center" class="noinput" name="intl_tong_certi_flg" id="intl_tong_certi_flg" readOnly></td>
			</tr>			
		</table>
		<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
	</div>
	<div class="opus_design_inquiry">
		<table class="grid_2 wFit">
			<tr>
				<th class="sm" width="200px" style="font-weight: bold; text-align: center;">Capacity / Tank</th>
				<th class="sm" width="200px" style="font-weight: bold; text-align: center;">F.O (85%)</th>
				<td class="sm" width="200px" style="font-weight: bold; text-align: center;">D.O (85%)</td>
				<th class="sm" width="200px" style="font-weight: bold; text-align: center;">F.W (100%)</th> 
				<th class="sm" width="*" style="font-weight: bold; text-align: center;">Ballast (100%)</th>     
			</tr>
			<tr align="right">
				<td class="sm" style="text-align: center;">Tank Capacity (M/T)</td>
				<td style="aling:center; padding:5px;"><input type="text" style="width:203px;text-align:right" class="noinput" name="foil_capa" id="foil_capa" readOnly><input type="text" style="width:30px;text-align:right" class="noinput" value="M/T" readOnly></td>
				<td style="aling:center; padding:5px;"><input type="text" style="width:203px;text-align:right" class="noinput" name="doil_capa" id="doil_capa" readOnly><input type="text" style="width:30px;text-align:right" class="noinput" value="M/T" readOnly></td>
				<td style="aling:center; padding:5px;"><input type="text" style="width:203px;text-align:right" class="noinput" name="frsh_wtr_capa" id="frsh_wtr_capa" readOnly><input type="text" style="width:30px;text-align:right" class="noinput" value="M/T" readOnly></td>
				<td style="aling:center; padding:5px;"><input type="text" style="width:203px;text-align:right" class="noinput" name="blst_tnk_capa" id="blst_tnk_capa" readOnly><input type="text" style="width:30px;text-align:right" class="noinput" value="M/T" readOnly></td>
			</tr>
			<tr align="right">
				<td class="sm" style="text-align: center;">Consumption / Day (M/T)</td>
				<td style="aling:center; padding:5px;"><input type="text" style="width:203px;text-align:right" class="noinput" name="foil_csm" id="foil_csm" readOnly><input type="text" style="width:30px;text-align:right" class="noinput" value="M/T" readOnly></td>
				<td style="aling:center; padding:5px;"><input type="text" style="width:203px;text-align:right" class="noinput" name="doil_csm" id="doil_csm" readOnly><input type="text" style="width:30px;text-align:right" class="noinput" value="M/T" readOnly></td>
				<td style="aling:center; padding:5px;"><input type="text" style="width:203px;text-align:right" class="noinput" name="frsh_wtr_csm" id="frsh_wtr_csm" readOnly><input type="text" style="width:30px;text-align:right" class="noinput" value="M/T" readOnly></td>
				<td><input type="text" style="width:203px;text-align:right" class="noinput" value="" readOnly><input type="text" style="width:30px;text-align:right" class="noinput" value="M/T" readOnly></td>
			</tr>			
		</table>
		<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
	</div>
	<div class="opus_design_inquiry">
		<table class="grid_2 wFit">
			<tr>
				<td class="sm" width="200px" style="font-weight: bold; text-align: center;">Machine Type / Spec.</td>
				<td class="sm" width="40%" style="font-weight: bold; text-align: center;">Maker</td>
				<td class="sm" width="13%" style="font-weight: bold; text-align: center;">Type</td>
				<td class="sm" width="13%" style="font-weight: bold; text-align: center;">BHP</td> 
				<td class="sm" width="*" style="font-weight: bold; text-align: center;">RPM</td>     
			</tr>	
			<tr align="center">
				<td class="sm" style="text-align:center; padding:5px;">Main Engine</td>
				<td align="left" style="padding:5px;"><input type="text" style="width:100%;" class="noinput" name="mn_eng_mkr_nm" id="mn_eng_mkr_nm" readOnly></td>
				<td style="padding:5px;"><input type="text" style="width:100%;text-align:center" class="noinput" name="mn_eng_tp_desc" id="mn_eng_tp_desc" readOnly></td>
				<td style="padding:5px;"><input type="text" style="width:100%;text-align:right" class="noinput" name="mn_eng_bhp_pwr" id="mn_eng_bhp_pwr" readOnly></td>
				<td style="padding:5px;"><input type="text" style="width:100%;text-align:right" class="noinput" name="mn_eng_rpm_pwr" id="mn_eng_rpm_pwr" readOnly></td>
			</tr>					
			<tr align="center">
				<td class="sm" style="text-align:center; padding:5px;">Generator Engine</td>
				<td align="left" style="padding:5px;"><input type="text" style="width:100%;" class="noinput" name="gnr_mkr_nm" id="gnr_mkr_nm" readOnly></td>
				<td style="padding:5px;"><input type="text" style="width:100%;text-align:center" class="noinput" name="gnr_tp_desc" id="gnr_tp_desc" readOnly></td>
				<td style="padding:5px;"><input type="text" style="width:100%;text-align:right" class="noinput" name="gnr_bhp_pwr" id="gnr_bhp_pwr" readOnly></td>
				<td style="padding:5px;"><input type="text" style="width:100%;text-align:right" class="noinput" name="gnr_rpm_pwr" id="gnr_rpm_pwr" readOnly></td>
			</tr>				
			<tr align="center">
				<td class="sm" style="text-align:center; padding:5px;">Bow Thrust</td>
				<td align="left" style="padding:5px;"><input type="text" style="width:100%;" class="noinput" name="bwthst_mkr_nm" id="bwthst_mkr_nm" readOnly></td>
				<td style="padding:5px;"><input type="text" style="width:100%;text-align:center" class="noinput" name="bwthst_tp_desc" id="bwthst_tp_desc" readOnly></td>
				<td style="padding:5px;"><input type="text" style="width:100%;text-align:right" class="noinput" name="bwthst_bhp_pwr" id="bwthst_bhp_pwr" readOnly></td>
				<td style="padding:5px;"><input type="text" style="width:100%;text-align:right" class="noinput" name="bwthst_rpm_pwr" id="bwthst_rpm_pwr" readOnly></td>
			</tr>			
		</table>
	</div>
</div>
<div class="opus_design_grid">
	<!-- <script type="text/javascript">ComSheetObject('t10sheet1');</script> -->
</div>
</div>
<!-- opus_design_grid(E) -->
</form>