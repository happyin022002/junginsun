<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_SCG_1022.jsp
*@FileTitle  : Dangerous CGO Application Details for Partner Lines
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/17
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.event.VopScg1022Event"%>
<%@ page import="org.apache.log4j.Logger" %>


<%
	VopScg1022Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows111  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.CargoLoadingApproval.PartnerLinesDangerousCargoApproval");

	String pop_mode       = "";

	String rgn_shp_opr_cd = "";
	String cgo_opr_cd 	  = "";
	String bkg_ref_no	  = "";
	String prnr_cgo_rqst_seq = "";
	String vsl_cd         = "";
	String skd_voy_no     = "";
	String skd_dir_cd     = "";
	String crr_cd         = "";
	String spcl_cgo_rqst_seq = "";
	String slan_cd           = "";
	String pol_cd            = "";
	String eta_dt            = "";
	String pod_cd            = "";

	String spcl_cntr_seq     = "";
	String spcl_cgo_seq      = "";
	String pId               = "";
	
	//String cfrFlg			 = "";
	
	String mode2 = "";
	String creDt = "";
	
	String auth_sts_cd = "";
	String spcl_cgo_auth_rjct_cd = "";
	String spcl_cgo_auth_rmk = "";
	String src_tp_cd = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopScg1022Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// add logic data extracting from server when loading initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		pop_mode          = request.getParameter("mode")==null?"":request.getParameter("mode");

		rgn_shp_opr_cd    = request.getParameter("rgn_shp_opr_cd"   )==null?"":request.getParameter("rgn_shp_opr_cd"   );
		cgo_opr_cd 	 	  = request.getParameter("cgo_opr_cd" 	    )==null?"":request.getParameter("cgo_opr_cd"       );
		bkg_ref_no	      = request.getParameter("bkg_ref_no" 	    )==null?"":request.getParameter("bkg_ref_no" 	   );
		prnr_cgo_rqst_seq = request.getParameter("prnr_cgo_rqst_seq")==null?"":request.getParameter("prnr_cgo_rqst_seq");
		vsl_cd            = request.getParameter("vsl_cd"           )==null?"":request.getParameter("vsl_cd"           );
		skd_voy_no        = request.getParameter("skd_voy_no"       )==null?"":request.getParameter("skd_voy_no"       );
		skd_dir_cd        = request.getParameter("skd_dir_cd"       )==null?"":request.getParameter("skd_dir_cd"       );
		crr_cd            = request.getParameter("crr_cd"           )==null?"":request.getParameter("crr_cd"           );
		spcl_cgo_rqst_seq = request.getParameter("spcl_cgo_rqst_seq")==null?"":request.getParameter("spcl_cgo_rqst_seq");
		slan_cd           = request.getParameter("slan_cd"          )==null?"":request.getParameter("slan_cd"          );
		pol_cd            = request.getParameter("pol_cd"           )==null?"":request.getParameter("pol_cd"           );
		pol_cd            = pol_cd + (request.getParameter("pol_clpt_ind_seq" )==null?"":request.getParameter("pol_clpt_ind_seq" ));
		eta_dt            = request.getParameter("eta_dt"           )==null?"":request.getParameter("eta_dt"           );
		pod_cd            = request.getParameter("pod_cd"           )==null?"":request.getParameter("pod_cd"           );
		pod_cd            = pod_cd + (request.getParameter("pod_clpt_ind_seq" )==null?"":request.getParameter("pod_clpt_ind_seq" ));

		spcl_cntr_seq     = request.getParameter("spcl_cntr_seq"    )==null?"":request.getParameter("spcl_cntr_seq"    );
		spcl_cgo_seq      = request.getParameter("spcl_cgo_seq"     )==null?"":request.getParameter("spcl_cgo_seq"     );
		pId               = request.getParameter("PID"     )==null?"":request.getParameter("PID"     );
		//cfrFlg			  = "Y".equals(request.getParameter("cfr_flg"))?"T":"F";	//2014-12-05 HDS
		mode2			  = request.getParameter("mode2"     )==null?"":request.getParameter("mode2"     );
		
		auth_sts_cd       = "R";	//request.getParameter("auth_sts_cd")==null?"":request.getParameter("auth_sts_cd");
		
		spcl_cgo_auth_rjct_cd = "";//request.getParameter("spcl_cgo_auth_rjct_cd")==null?"":request.getParameter("spcl_cgo_auth_rjct_cd");
		spcl_cgo_auth_rmk = "";//request.getParameter("spcl_cgo_auth_rmk")==null?"":request.getParameter("spcl_cgo_auth_rmk");
		
		src_tp_cd         = request.getParameter("src_tp_cd");
		if(src_tp_cd == null ||"".equals(src_tp_cd)) {
			src_tp_cd = "MNL";
		}
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	//initial retrieve condition
	var preConds = {
		pop_mode          : "<%=StringUtil.xssFilter(pop_mode)%>",
		rgn_shp_opr_cd    : "<%=StringUtil.xssFilter(rgn_shp_opr_cd)%>",
		cgo_opr_cd        : "<%=StringUtil.xssFilter(cgo_opr_cd)%>",
		bkg_ref_no        : "<%=StringUtil.xssFilter(bkg_ref_no)%>",
		prnr_cgo_rqst_seq : "<%=StringUtil.xssFilter(prnr_cgo_rqst_seq)%>",
		vsl_cd            : "<%=StringUtil.xssFilter(vsl_cd)%>",
		skd_voy_no        : "<%=StringUtil.xssFilter(skd_voy_no)%>",
		skd_dir_cd        : "<%=StringUtil.xssFilter(skd_dir_cd)%>",
		crr_cd            : "<%=StringUtil.xssFilter(crr_cd)%>",
		spcl_cgo_rqst_seq : "<%=StringUtil.xssFilter(spcl_cgo_rqst_seq)%>",
		slan_cd           : "<%=StringUtil.xssFilter(slan_cd)%>",
		pol_cd            : "<%=StringUtil.xssFilter(pol_cd)%>",
		eta_dt            : "<%=StringUtil.xssFilter(eta_dt)%>",
		pod_cd            : "<%=StringUtil.xssFilter(pod_cd)%>",
		spcl_cntr_seq     : "<%=StringUtil.xssFilter(spcl_cntr_seq)%>",
		spcl_cgo_seq      : "<%=StringUtil.xssFilter(spcl_cgo_seq)%>",
		pId               : "<%=StringUtil.xssFilter(pId)%>",
		userId            : "<%=StringUtil.xssFilter(strUsr_id)%>",
		mode2			  : "<%=StringUtil.xssFilter(mode2)%>",
		auth_sts_cd	      : "<%=StringUtil.xssFilter(auth_sts_cd)%>",
		spcl_cgo_auth_rjct_cd	: "<%=StringUtil.xssFilter(spcl_cgo_auth_rjct_cd)%>",
		spcl_cgo_auth_rmk		: "<%=StringUtil.xssFilter(spcl_cgo_auth_rmk)%>",
		src_tp_cd				: "<%=StringUtil.xssFilter(src_tp_cd)%>"
	}
	var user_id = '<%=strUsr_id%>';
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
<input type="hidden" name="ibflag" value="I" id="ibflag" />
<input type="hidden" name="dg_flg" value="Y" id="dg_flg" />
<input type="hidden" name="awk_flg" value="N" id="awk_flg" />
<input type="hidden" name="pre_chk_flg" value="N" id="pre_chk_flg" />
<input type="hidden" name="org_cgo_opr_cd" id="org_cgo_opr_cd" />
<input type="hidden" name="org_bkg_ref_no" id="org_bkg_ref_no" />
<input type="hidden" name="org_vsl_cd" id="org_vsl_cd" />
<input type="hidden" name="org_skd_voy_no" id="org_skd_voy_no" />
<input type="hidden" name="org_skd_dir_cd" idw="org_skd_dir_cd" />
<input type="hidden" name="org_crr_cd" id="org_crr_cd" />
<input type="hidden" name="org_slan_cd" id="org_slan_cd" />
<input type="hidden" name="out_n1st_imdg_pck_qty" required caption="Package Q'ty &amp; Type" id="out_n1st_imdg_pck_qty" />
<input type="hidden" name="out_n1st_imdg_pck_cd" required caption="Package Q'ty &amp; Type" id="out_n1st_imdg_pck_cd" />
<input type="hidden" name="out_n1st_imdg_pck_desc" id="out_n1st_imdg_pck_desc" />
<input type="hidden" name="out_n2nd_imdg_pck_qty" id="out_n2nd_imdg_pck_qty" />
<input type="hidden" name="out_n2nd_imdg_pck_cd" id="out_n2nd_imdg_pck_cd" />
<input type="hidden" name="out_n2nd_imdg_pck_desc" id="out_n2nd_imdg_pck_desc" />
<input type="hidden" name="intmd_n1st_imdg_pck_qty" id="intmd_n1st_imdg_pck_qty" />
<input type="hidden" name="intmd_n1st_imdg_pck_cd" id="intmd_n1st_imdg_pck_cd" />
<input type="hidden" name="intmd_n1st_imdg_pck_desc" id="intmd_n1st_imdg_pck_desc" />
<input type="hidden" name="intmd_n2nd_imdg_pck_qty" id="intmd_n2nd_imdg_pck_qty" />
<input type="hidden" name="intmd_n2nd_imdg_pck_cd" id="intmd_n2nd_imdg_pck_cd" />
<input type="hidden" name="intmd_n2nd_imdg_pck_desc" id="intmd_n2nd_imdg_pck_desc" />
<input type="hidden" name="in_n1st_imdg_pck_qty" id="in_n1st_imdg_pck_qty" />
<input type="hidden" name="in_n1st_imdg_pck_cd" id="in_n1st_imdg_pck_cd" />
<input type="hidden" name="in_n1st_imdg_pck_desc" id="in_n1st_imdg_pck_desc" />
<input type="hidden" name="in_n2nd_imdg_pck_qty" id="in_n2nd_imdg_pck_qty" />
<input type="hidden" name="in_n2nd_imdg_pck_cd" id="in_n2nd_imdg_pck_cd" />
<input type="hidden" name="in_n2nd_imdg_pck_desc" id="in_n2nd_imdg_pck_desc" />
<input type="hidden" name="max_in_pck_qty" caption="Package Q'ty &amp; Type" id="max_in_pck_qty" />
<input type="hidden" name="max_in_pck_tp_cd" caption="Package Q'ty &amp; Type" id="max_in_pck_tp_cd" />
<input type="hidden" name="hcdg_pck_rstr_desc" id="hcdg_pck_rstr_desc" />
<input type="hidden" name="hcdg_intmd_bc_rstr_desc" id="hcdg_intmd_bc_rstr_desc" />
<input type="hidden" name="hcdg_tnk_rstr_desc" id="hcdg_tnk_rstr_desc" />
<input type="hidden" name="imdg_lmt_qty" id="imdg_lmt_qty" />
<input type="hidden" name="imdg_lmt_qty_meas_ut_cd" id="imdg_lmt_qty_meas_ut_cd" />
<input type="hidden" name="imdg_expt_qty_cd" id="imdg_expt_qty_cd" />
<!-- 2016-09-28 Lmited/Excepted Qty & Description -->
<input type="hidden" name="imdg_lmt_qty_desc" id="imdg_lmt_qty_desc" />
<input type="hidden" name="imdg_expt_qty_desc" id="imdg_expt_qty_desc" />
<!-- 2016-09-28 Lmited/Excepted Qty & Description -->
<input type="hidden" name="imdg_spcl_provi_no" id="imdg_spcl_provi_no" />
<input type="hidden" name="hcdg_flg" id="hcdg_flg" />
<input type="hidden" name="imdg_subs_rsk_lbl_rmk" id="imdg_subs_rsk_lbl_rmk" />
<input type="hidden" name="eta_dt"  id="eta_dt" />

<input name="crr_cd" type="hidden" id="crr_cd" />
<input name="slan_cd" type="hidden" id="slan_cd" />
<input id="temp_grs_wgt" name="temp_grs_wgt" type="hidden" />
<input id="temp_net_wgt" name="temp_net_wgt" type="hidden" />
<input id="requestChk" name="requestChk" type="hidden" />

<input id="edi_unmap_dtl_cd" name="edi_unmap_dtl_cd" type="hidden" />
<input id="unmap_cntr_tpsz_cd" name="unmap_cntr_tpsz_cd" type="hidden" />
<!-- page_title_area(S) -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
	   	<!-- page_title(S) -->
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><span>Dangerous CGO Application Details for Partner Lines</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn"><!-- 
			 --><!--<button type="button" class="btn_accent" name="btn1_New"            id="btn1_New">New</button>--><!-- 
			 --><button type="button" class="btn_normal" name="btn1_Retrieve"       id="btn1_Retrieve">Retrieve</button>
			 	<button type="button" class="btn_normal" name="btn1_Save" 	        id="btn1_Save">Save</button><!-- 
			 --><button type="button" class="btn_normal" name="btn1_Request" 	    id="btn1_Request">Request</button><!-- 
			 --><button type="button" class="btn_normal" name="btn3_Request_Cancel" id="btn3_Request_Cancel">Request Cancel</button><!-- 
			 --><button type="button" class="btn_normal" name="btn1_Mail" 	        id="btn1_Mail">Mail</button><!-- 
			 --><%if("VOP_SCG_5001".equals(StringUtil.xssFilter(pId))) { %><button type="button" class="btn_normal" name="btn1_OK" id="btn1_Close">OK</button><%}%><!-- 
			 --><button type="button" class="btn_normal" name="btn1_Close" 	        id="btn1_Close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->
			<span id="navigation"></span>
		</div>
		<!-- page_location(E) -->		
	</div>
</div>

<div class="layer_popup_contents" style="overflow:hidden;">
	<!-- page_title_area(E) -->
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="50">
				<col width="200">
				<col width="80">
				<col width="180">
				<col width="100">
				<col width="150">
				<col width="100">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>RSO</th>
					<td><input name="rgn_shp_opr_cd" type="text" style="width:40px;" class="input2" value="" caption="RSO" readonly id="rgn_shp_opr_cd" /></td>
					<th>BKG Company</th>
					<td><input name="cgo_opr_cd" id="cgo_opr_cd" type="text" style="width:40px;" class="input1" value="" caption="BKG Company" maxlength="4" dataformat="enguponly" required /><!--  
						--><button type="button" id="btn_Carrier" name="btn_Carrier" class="input_seach_btn"></button></td>
					<th>BKG Reference No</th>
					<td><input name="bkg_ref_no" type="text" style="width:145px;" class="input1" value="" caption="BKG Reference No." maxlength="30" required id="bkg_ref_no" /><input name="prnr_cgo_rqst_seq" type="hidden" value="" id="prnr_cgo_rqst_seq" /></td>
				  <% if("VOP_SCG_0022".equals(pId)) {%>
				    <th>Approval</th>
					<td><input id="spcl_cgo_auth_cd" name="spcl_cgo_auth_cd" style="width: 20px;" class="input1" value="" readonly type="text" /><button class="input_seach_btn" name="btn_approval" id="btn_approval" type="button"></button></td>
				  <% } else { %>
				    <td colspan="2"></td>
				  <% } %>
				</tr>
				<tr>
					<th>VVD CD</th>
					<td><input name="vsl_cd" type="text" style="width:55px;" class="input1" value="" fullfill="" caption="Vessel Code" maxlength="4" dataformat="engup" required id="vsl_cd" /><!--  
						--><input name="skd_voy_no" type="text" style="width:40px;" class="input1" value="" fullfill="" caption="Schedule Voyage Number" maxlength="4" dataformat="num" required id="skd_voy_no" /><!--  
						--><input name="skd_dir_cd" type="text" style="width:20px;" class="input1" value="" fullfill="" caption="Schedule Direction Code" maxlength="1" dataformat="enguponly" required id="skd_dir_cd" /><!--  
						--><button type="button" id="btn_VVDpop" name="btn_VVDpop" class="input_seach_btn"></button><!-- 
						--><input name="spcl_cgo_rqst_seq" type="hidden" id="spcl_cgo_rqst_seq" />
					</td>
					<th title="Port of Loading">POL</th>
					<td>
						<script type="text/javascript">ComComboObject('pol_cd', 2, 102, 1, 1);</script><!-- 
						 -->
					     <input name="unmap_pol_cd" id="unmap_pol_cd" type="text" style="width:100px;display:none" class="input2" value="" readonly />
					</td>
					<th title="Port of Discharging">POD</th>
					<td>
						<script type="text/javascript">ComComboObject('pod_cd', 2, 102, 1, 1);</script>
					     <input name="unmap_pod_cd" id="unmap_pod_cd" type="text" style="width:100px;display:none" class="input2" value="" readonly />
					</td>
				</tr>
			</tbody>
		</table>
	</div>
<!-- opus_design_inquiry(E) -->
</div>
 
<div class="wrap_result">
	<!-- layout_wrap(S) -->
	<div class="layout_wrap">
		<!-- layout_vertical_2(S) -->
		<div class="layout_vertical_2" style="width: 19%">
			<!-- opus_design_grid(S) -->
			<h3 class="title_design mar_btm_8">CNTR Seq.</h3>
			<div class="opus_design_grid">
				<!-- opus_design_btn(S) -->
				<div class="opus_design_btn"><!-- 
					 --><button type="button" class="btn_accent" name="btn2_Add"     id="btn2_Add">Add</button><!-- 
					 --><button type="button" class="btn_normal" name="btn2_Delete"  id="btn2_Delete">Delete</button><!-- 
					 --><button type="button" class="btn_normal" name="btn2_Copy" 	 id="btn2_Copy">Copy</button>
				</div>
				<!-- opus_design_btn(E) -->
				<script type="text/javascript">ComSheetObject('sheet1');</script>
			</div>

			<!-- opus_design_grid(S) -->
		</div>
		
	<!-- Container Info Sheet (S) -->
	<%--<div class="opus_design_grid" >
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>--%>  
	<!-- Container Info Sheet (E) -->		
		
	     <!-- layout_vertical_2(E) -->
	     <!-- layout_vertical_2(S) -->
		<div class="layout_vertical_2 mar_left_8" style="width: 79%;">
			<div class="opus_design_inquiry wFit sm">
				<table>
					<colgroup>
						<col width="70">
						<col width="60">
						<col width="70">
						<col width="140">
						<col width="70">
						<col width="*">
					</colgroup>
					<tbody>
						<tr>
							<th>Cargo Seq.</th>
							<td>
								<input name="cntr_cgo_seq_sum" id="cntr_cgo_seq_sum" type="text" style="width:30px;text-align:center;" class="input2" value="" readOnly><!--  
								--><script type="text/javascript">ComComboObject('spcl_cgo_seq', 1, 50, 1);</script>
							</td>
							<th>DG Ref No</th>
							<td><input name="dcgo_seq" type="hidden" id="dcgo_seq" value=""/><input name="dcgo_ref_no" type="text" style="width:140px;" class="input" value="" caption="DG Ref.No." dataformat="engup" maxlength="12"/><!--
							--></td>
							<td id="approved"></td>
							<th><button type="button" class="btn_etc" name="btn2_UN_Information" style="width: 105px" id="btn2_UN_Information">UN Information</button><!--  
							--><button type="button" class="btn_etc" name="btn2_Restrictions" style="width: 90px" id="btn2_Restrictions">Restrictions</button><!--  
							--><button type="button" class="btn_etc" name="btn2_Pre_Checking_Report" style="width: 140px" id="btn2_Pre_Checking_Report">Pre-Checking Report</button><!--
							--><button type="button" class="btn_etc" name="btn2_Package_Qty_Type" style="width: 100px;"	id="btn2_Package_Qty_Type">PKG Q'ty/Type</button></th>
						</tr>
					</tbody>
				</table>
				<table>
					<colgroup>
						<col width="70">
						<col width="50">
						<col width="60">
						<col width="80">
						<col width="*">
						<col width="90">
						<col width="130">
						<col width="80">
						<col width="70">
					</colgroup>
					<tbody>
						<tr>
							<th>IMO Class</th>
							<td><input name="imdg_clss_cd" type="text" style="width:27px;" class="input2" value="" readonly caption="IMO Class" id="imdg_clss_cd" /><!--  
								--><input name="imdg_comp_grp_cd" type="text" style="width:20px;" class="input2" value="" readonly caption="IMO Class" id="imdg_comp_grp_cd" />
							</td>
							<th>UN No.</th>
							<td><input name="imdg_un_no" type="text" style="width:40px;" class="input1" value="" caption="Un No." maxlength="4" dataformat="num" required id="imdg_un_no" /><!--  
								--><input name="imdg_un_no_seq" type="text" caption="Un No. Sequence" style="width: 35px; text-align:center;" class="input2" id="imdg_un_no_seq" readonly/><input name="imdg_amdt_no" type="hidden" id="imdg_amdt_no"/><!--  value="T" 
								--><button type="button" id="btn_Un_No" name="btn_Un_No" class="input_seach_btn"></button>
							</td>
							<td><input type="checkbox" name="cfr_flg" class="input2" id="cfr_flg" value="Y"  onclick="return false" /> <b>CFR</b></td>
							
							<th>Gross Weight</th>
							<td><input id="grs_wgt" name="grs_wgt" style="width: 90px; text-align:right;" class="input1" value="" pointcount="3" dataformat="float" maxlength="11" type="text" caption="Gross Weight" required/><!-- 
							 --><input style="width: 40px;text-align: center;" class="input2" value=" KGS" readonly type="text" /></td>
							<th>Net Weight</th>
							<td><input id="net_wgt" name="net_wgt" style="width: 90px; text-align:right;" class="input1" value="" pointcount="3" dataformat="float"  maxlength="11" type="text" caption="Net Weight" required/><!-- 
							 --><input style="width: 40px;text-align: center;" class="input2" value=" KGS" readonly type="text" /></td>			
							
							<%--
							<th>Gross Weight</th>
							<td><input name="grs_wgt" id="grs_wgt" type="text" style="width:75px;text-align:right;" class="input1" value="0.000" caption="Gross Weight" maxlength="15" size="15" dataformat="float" pointcount="3" required /><!--  
								--><input name="wgt_ut_cd" type="text" style="width:40px;" class="input2" value="KGS" maxlength="3" dataformat="engup" readonly id="wgt_ut_cd" />
							</td>
					   		<th>Net Weight</th>
							<td><input name="net_wgt" id="net_wgt" type="text" style="width:75px;text-align:right;" class="input1" value="0.000" caption="Net Weight" maxlength="15" size="15" dataformat="float" pointcount="3" required /><!--  
								--><input name="wgt_ut_cd2" type="text" style="width:40px;" class="input2" value="KGS" maxlength="3" dataformat="engup" readonly id="wgt_ut_cd2" />
							</td> --%>
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
							<th>Proper Shipping Name</th>
							<td><input name="prp_shp_nm" type="text" style="width:100%;" class="input1" value="" required caption="Proper Shipping Name" id="prp_shp_nm" /> </td>
						</tr>
						<tr>
							<th>Technical Name</th>
							<td><input name="hzd_desc" type="text" style="width:100%;" class="input" value="" caption="Technical Name" maxlength="4000" id="hzd_desc" /> </td>
						</tr>
					</tbody>
				</table>
				<table>
					<colgroup>
						<col width="70">
						<col width="150">
						<col width="80">
						<col width="80">
						<col width="120">
						<col width="60">
						<col width="110">
						<col width="*">
					</colgroup>
					<tbody>
						<tr>
						
						<!-- /*
							2015.04.06 Flash Point Minus 입력 가능하도록 수정 by Tae-Woong Kim
						     dataformat 을 num 에서 'singledfloat'로 변경
						     */   
						 -->
						
							<th>Flash Point</th>
						 	<td><input name="flsh_pnt_cdo_temp" type="text" style="width:54px;text-align:right;" class="input" value="" caption="Flash Point" maxlength="7" size="3"  dataformat="singledfloat" maxnum="99999.99"   id="flsh_pnt_cdo_temp" />℃</td>
							<th>Packing Group</th>
							<td><input name="imdg_pck_grp_cd" type="text" style="width:60px;" class="input2" value="" readonly id="imdg_pck_grp_cd" /></td>
							<th>PSA Group</th>
							<td><input name="psa_no" type="text" style="width:25px;" class="input2" value="" readonly id="psa_no" /><!--  
								--><input type="text" style="width:25px;" class="input2" value=" " readonly /></td>
							<th>Limited Q'ty</th>
							<td><script type="text/javascript">ComComboObject('imdg_lmt_qty_flg', 1, 45, 1, 1, 0, false);</script>
							<!--td><select style="width: 55px;" name="imdg_lmt_qty_flg" id="imdg_lmt_qty_flg" class="input1">
								<option value=""></option>
								<option value="Y">Y</option>
								<option value="N">N</option>
							</select--><!--  
							--><%-- <button type="button" class="btn_etc" name="btn2_HCDG" 	id="btn2_HCDG">HCDG</button> --%>
							<input type="text" name="hcdg_flag" style="width:45px;color:red;font-weight:bold" class="input2" readonly value="" id="hcdg_flag" /></td>
							</td>
						</tr>
						<tr>
							<th>Sub Label</th>
							<td><input name="n1st_imdg_subs_rsk_lbl_cd" type="text" style="width:25px;" class="input" value="" caption="Sub Label" maxlength="3" size="2" dataformat="float" pointcount="1" id="n1st_imdg_subs_rsk_lbl_cd" /><!--  
								--><input name="n2nd_imdg_subs_rsk_lbl_cd" type="text" style="width:25px;" class="input" value="" caption="Sub Label" maxlength="3" size="2" dataformat="float" pointcount="1" id="n2nd_imdg_subs_rsk_lbl_cd" /><!--  
								--><input name="n3rd_imdg_subs_rsk_lbl_cd" type="text" style="width:25px;" class="input" value="" caption="Sub Label" maxlength="3" size="2" dataformat="float" pointcount="1" id="n3rd_imdg_subs_rsk_lbl_cd" /><!--  
								--><input name="n4th_imdg_subs_rsk_lbl_cd" type="text" style="width:25px;" class="input" value="" caption="Sub Label" maxlength="3" size="2" dataformat="float" pointcount="1" id="n4th_imdg_subs_rsk_lbl_cd" />
							</td>
							<th>Cargo Status</th>
							<!-- td><script type="text/javascript">ComComboObject('dcgo_sts_cd', 1, 62, 1, 0, 0, false);</script></td-->
							<td><script type="text/javascript">ComComboObject('dcgo_sts_cd', 2, 60, 1)</script></td>
							<th>Marine Pollutant</th>
							<!-- td><select name="mrn_polut_flg" id="mrn_polut_flg" style="width: 55px;" class="input1"><option value="Y">Y</option><option value="N" >N</option></select></td-->
							<td><script type="text/javascript">ComComboObject('mrn_polut_flg', 1, 42, 1, 0, 0, false);</script></td>
							<th>Excepted Q'ty</th>
							<td><script type="text/javascript">ComComboObject('imdg_expt_qty_flg', 1, 45, 1, 1, 0, false);</script></td>
							<!-- td><select name="imdg_expt_qty_flg" style="width: 55px;"><option value=""></option><option value="Y">Y</option><option value="N">N</option></select></td-->
						</tr>
						<!-- Segregation/Residue -->
	       				<tr >
							<th>Segregation Group</th>
							<td colspan="3">
								<script type="text/javascript">ComComboObject('imdg_segr_grp_no', 2, 300, 1, 0, 1);</script>
							</td>
							<th>Segregation Groups</th>
							<td colspan="3"><input type="text" name="hcdg_tnk_rstr_desc1" readonly style="width:40px;text-align:center" class="input2" value="" id="frm_hcdg_tnk_rstr_desc1"/><!--
							--><input type="text" name="hcdg_tnk_rstr_desc2" readonly style="width:40px;text-align:center" class="input2" value="" id="frm_hcdg_tnk_rstr_desc2" /><!--
							--><input type="text" name="hcdg_tnk_rstr_desc3" readonly style="width:40px;text-align:center" class="input2" value="" id="frm_hcdg_tnk_rstr_desc3" /><!--
							--><input type="text" name="hcdg_tnk_rstr_desc4" readonly style="width:40px;text-align:center" class="input2" value="" id="frm_hcdg_tnk_rstr_desc4" /><!--
						    --></td>
						</tr>
						<!-- Segregation/Residue -->	
	       				<tr >
						<!--<th>Segregation Group</th>
							<td colspan="3">
								<script type="text/javascript">ComComboObject('imdg_segr_grp_no', 1, 300, 0, 2);</script>
							</td>
							 -->
							<th>Residue Last Contained</th>
							<td><script type="text/javascript">ComComboObject('rsd_flg', 1, 45, 1, 0, 0, false);</script></td>
							<%--<td><select name="rsd_flg" id="rsd_flg" style="width:40px;" class="input" ><option value=""></option><option value="Y">Y</option><option value="N">N</option></select> --%>
							<!--</td>-->
							<th></th>
							<td colspan="5"></td>
						</tr>

					</tbody>
				</table>
			</div>
			<!-- layout_wrap(S) -->
			<div class="layout_wrap">
				<!-- layout_vertical_2(S) -->
				<div class="layout_vertical_2" style="width: 100%">
					<div class="opus_design_data">
						<table class="grid_2">
							<colgroup>
								<col width="130">
								<col width="*">
							</colgroup>
							<tr>
								<th>Emergency Contact</th>
								<td><input name="emer_cntc_phn_no" type="text" style="width:100%;" class="noinput" value="" caption="Emergent Contact" maxlength="22" size="20" id="emer_cntc_phn_no" /></td>
							
								<th>Contact Person</th>
								<td><input name="emer_cntc_pson_nm" type="text" style="width:100%;" class="noinput" value="" caption="Contact Person" maxlength="100" id="emer_cntc_pson_nm" /></td>
							</tr>
						</table>
					</div>
				</div>
			     <!-- layout_vertical_2(E) -->
		     	<!-- layout_vertical_2(S) -->
				<div class="layout_vertical_2 mar_left_8" style="width: 100%">
					<div class="opus_design_inquiry wFit">
						<table>
							<colgroup>
								<col width="90">
								<col width="80">
								<col width="200">
								<col width="200">
								<col width="*">
							</colgroup>
							<tr>
								<th>Certificate Number</th>
								<td><input name="certi_no" type="text" style="width:100%;" class="input" value="" caption="Certificate Number" maxlength="15" size="15" id="certi_no" /></td>
								<th><button type="button" class="btn_etc" name="btn2_Other_Emergency_Information" 	id="btn2_Other_Emergency_Information">Other Emergency and Reefer Information</button></th>
								<td><input type="hidden" name="ems_no" id="ems_no" />
								    <input type="hidden" name="ctrl_temp_ctnt" id="ctrl_temp_ctnt" />
									<input type="hidden" name="emer_rspn_gid_no" id="emer_rspn_gid_no" />
									<input type="hidden" name="emer_rspn_gid_chr_no" id="emer_rspn_gid_chr_no" />
									<input type="hidden" name="emer_temp_ctnt" id="emer_temp_ctnt" />
								&nbsp;</td>
								<td><button type="button" class="btn_etc" name="btn1_Attach_File" id="btn1_Attach_File">Attach File</button><input type="text" name="attach_file_cnt" style="width:45px; text-align:center;" class="input" value="0" readonly id="attach_file_cnt" />&nbsp;(Files)</td>
							</tr>
							<tr>
								<th>Approval Ref. No.</th>
								<td colspan="4"><input name="apro_ref_no" type="text" style="width:130px;" class="input" value="" caption="Approval Ref. No." maxlength="30" dataformat="engup" id="apro_ref_no" readonly/></td>
							</tr>							
						</table>
					</div>
				</div>

			</div>
			<div class="layout_wrap">
				<!-- layout_vertical_2(S) -->
				<div class="layout_vertical_2" style="width: 60%">
					<div class="opus_design_data">
			   		<table style="width:400px;" class="grid_2">
   					<colgroup>
   						<col width="100" />
   						<col width="130" />
   						<col width="*" />
   					</colgroup>
					<tr>
						<th rowspan="2">Class 1 Only</th>
						<th>Consignee Detail</th>
						<td><input name="cnee_dtl_desc" type="text" caption="Consignee Detail" style="width:100%;" class="input"  value="" id="cnee_dtl_desc" /></td>
					</tr>
					<tr>
						<th>Net Explosive Weight</th>
						<td><input type="text" caption="Net Explosive Weight" name="net_explo_wgt" style="width:75%; text-align:right;" class="input" dataformat="num" value="" id="net_explo_wgt" /><input type="text" style="width:20%;" class="noinput2" readonly value="KGS" /></td>
					</tr>
				</table>
					</div>
				</div> 
		     	<!-- layout_vertical_2(E) -->
		     	<!-- layout_vertical_2(S) -->
				<div class="layout_vertical_2" style="width: 40%">
					<div class="opus_design_inquiry">
						<table>
							<colgroup>
								<col width="*">
								<col width="*">
							</colgroup>
							<tr>
								<th><button type="button" class="btn_etc" name="btn3_Row_Add" 	     id="btn3_Row_Add">Add</button><!--  
								 --><button type="button" class="btn_etc" name="btn3_Row_Copy" 	     id="btn3_Row_Copy">Copy</button><!--  
								 --><button type="button" class="btn_etc" name="btn3_Row_Delete"     id="btn3_Row_Delete">Delete</button><!--  
								 --></th>
							</tr>
						</table>
					</div>
				</div>
		     	<!-- layout_vertical_2(E) -->
		    </div>
			<!-- layout_wrap(E) -->
			
			<!-- layout_wrap(S) -->
			<div class="layout_wrap">
				<!-- layout_vertical_2(S) -->
				<div class="layout_vertical_2" style="width: 60%">
					<div class="opus_design_data">
						<table class="grid_2">
							<colgroup>
								<col width="70">
								<col width="430">
								<col width="*">
								<col width="430">
								<col width="430">
								<col width="430">
							</colgroup>
							<tr>
								<th>Remark</th>
								<td><textarea id="diff_rmk" name="diff_rmk" style="width:830px;height:30px;resize:none;ime-mode:disabled" class="input" ></textarea></td><%//dataformat="engup" %>
							</tr>
						</table>
					</div>
				</div> 
		     	<!-- layout_vertical_2(E) -->
		     	<!-- layout_vertical_2(S) -->
		    </div>
			<!-- layout_wrap(E) -->
		</div>
	     <!-- layout_vertical_2(E) -->
	</div>
<BR>
	<!-- layout_wrap(E) -->
		<div id="popLayer" style="display:none">
			<div class="opus_design_inquiry wFit">
				<table>
					 <colgroup>
					 	<col width="330">
						<col width="90">
						<col width="80">
						<col width="100">
						<col width="80">
						<col width="*">
					</colgroup>
					<tr>
						<th>Application Date</th>
						<td><input name="cre_dt" type="text" style="width:82px;" class="input" value="" id="cre_dt" dataformat="ymd" caption="Application Date" size="10" readonly="readonly"/><!--<button type="button" id="btn_calendar" name="btn_calendar" class="calendar ir"></button>--></td>
						<th>Approval by</th>
						<td><input name="auth_usr_id" type="text" style="width:100px;text-align:center;" class="input" value="" id="auth_usr_id" readonly="readonly" /> </td>
						<th>Date (GMT)</th>
						<td><input name="auth_dt" type="text" style="width:80px;text-align:center;" class="input" value="" id="auth_dt" dataformat="ymd" readonly="readonly"/></td>
					</tr>
					<tr>
						<th>Approval</th>
						<td>
					   		<select name="auth_sts_cd" id="auth_sts_cd" style="width:82px;font-weight: bold;" class="input1" onchange="auth_sts_cd_OnChange()" ><!-- 
					   		     --><option value=""></option><!-- 
					   		     --><option value="C">C</option><!-- 
								 --><option value="R" style="color:orange;">R</option><!-- 
								 --><option value="Y" style="color:green;">Y</option><!-- 
								 --><option value="A" style="color:green;">Y(all)</option><!-- 
								 --><option value="N" style="color:red;">N</option><!-- 
							     --><option value="P" style="color:blue;">P</option><!-- 										
							 --></select>
					    </td>
						<th>RJT Code</th>
						<td width="100" style="padding-left:2;"> 
							<script type="text/javascript">ComComboObject('spcl_cgo_auth_rjct_cd', 2, 100, 0, 2);</script>
						</td>
						<th>Remark(s)</th>
						<td><input type="text" name="spcl_cgo_auth_rmk" style="width:100%;" class="input" value="" id="spcl_cgo_auth_rmk" onchange="spcl_cgo_auth_rmk_OnChange()"/> </td>
					</tr>
				</table> 
			</div>
		</div>
	</div> 
	<!-- Container Info Sheet (S) -->
	
	<div class="opus_design_grid">
	<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
	
	<!-- Container Info Sheet (E) -->
	<!--IBUpload Component (S) -->
	<div style="display:none">
		<script type="text/javascript">ComUploadObject('upload1', '<=session.getId()%>');</script>
		<span id="progressPop"></span>
		<!-- iframe id="preCheckFrm" src="" frameborder="0" framespacing="0" leftmargin="0" marginheight="0" marginwidth="0" scrolling="no" topmargin="0" width="0" height="0"></iframe> -->
	</div> 
</div>
<!--IBUpload Component (E) -->
<!-- div id="uploadLayer" class="wrap_result" style="position:absolute; overflow:hidden; width:450px; height:0px; visibility:hidden;z-index:10000; background-color:#ffffff;  border-width:1px; border-color:black; border-style:solid;"-->
<div id="uploadLayer" class="wrap_result" style="position:absolute; width:450px; height:0px; visibility:hidden;z-index:10000; background-color:#ffffff;  border-width:1px; border-color:black; border-style:solid;">
		<div class="opus_design_grid">
			<div class="opus_design_btn">
				   <button type="button" class="btn_normal" name="btn_fileAdd" id="btn_fileAdd">File Add</button><!-- 
				--><button type="button" class="btn_normal" name="btn_fileDel" id="btn_fileDel">Delete</button><!-- 
				--><button type="button" class="btn_normal" name="btn_fileClose" id="btn_fileClose">Close</button>
			</div>
			<script type="text/javascript">ComSheetObject('sheet3');</script>
		</div>
</div>

	<div class="opus_design_grid">
	<script type="text/javascript">ComSheetObject('sheet4');</script>
	</div>

</form>