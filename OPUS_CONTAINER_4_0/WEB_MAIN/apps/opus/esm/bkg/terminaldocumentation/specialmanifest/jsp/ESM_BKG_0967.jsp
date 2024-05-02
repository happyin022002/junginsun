<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0967.jsp
*@FileTitle  : ESM_BKG_0967
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/14
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.event.EsmBkg0967Event"%>

<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0967Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//DB ResultSet List count
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	String strCnt_cd		= "";
	Logger log = Logger.getLogger("com.clt.apps.TerminalDocumentation.SpecialManifest");
	
	String callGubun = "";
	String dType = "";
	String vvdCd = "";
	String portCd = "";
	String blNo = "";
	String cntrNo = "";
	String cntrCgoSeq = "";
	String berthCd = "";
	String berthNm = "";
	String bkgNo = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		strCnt_cd = account.getCnt_cd();
	   
		event = (EsmBkg0967Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		callGubun 	= (StringUtil.xssFilter(request.getParameter("callGubun")) == null) ? "" : StringUtil.xssFilter(request.getParameter("callGubun"));
		dType 		= (StringUtil.xssFilter(request.getParameter("d_type")) == null) ? "" : StringUtil.xssFilter(request.getParameter("d_type"));
		vvdCd 		= (StringUtil.xssFilter(request.getParameter("vvd_cd")) == null) ? "" : StringUtil.xssFilter(request.getParameter("vvd_cd"));
		portCd 		= (StringUtil.xssFilter(request.getParameter("port_cd")) == null) ? "" : StringUtil.xssFilter(request.getParameter("port_cd"));
		blNo 		= (StringUtil.xssFilter(request.getParameter("bl_no")) == null) ? "" : StringUtil.xssFilter(request.getParameter("bl_no"));
		cntrNo 		= (StringUtil.xssFilter(request.getParameter("cntr_no")) == null) ? "false" : StringUtil.xssFilter(request.getParameter("cntr_no"));
		cntrCgoSeq 	= (StringUtil.xssFilter(request.getParameter("cntr_cgo_seq")) == null) ? "false" : StringUtil.xssFilter(request.getParameter("cntr_cgo_seq"));
		berthCd 	= (StringUtil.xssFilter(request.getParameter("berth_cd")) == null) ? "" : StringUtil.xssFilter(request.getParameter("berth_cd"));
		berthNm 	= (StringUtil.xssFilter(request.getParameter("berth_nm")) == null) ? "" : StringUtil.xssFilter(request.getParameter("berth_nm"));
		bkgNo 		= (StringUtil.xssFilter(request.getParameter("bkg_no")) == null) ? "" : StringUtil.xssFilter(request.getParameter("bkg_no"));
		
		if("".equals(callGubun)) {
//			if(strOfc_cd.startsWith("ANR")) {
//				callGubun = "ESM_BKG_0965";
//			} else {
				callGubun = "ESM_BKG_0966";
//			}
		}
		
	}catch(Exception e) {
		out.println(e.toString());
	}

%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		
		loadPage('<%=dType%>');
	}
	function endPage() {
		closePage();
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd" 		   id="f_cmd">
<input type="hidden" name="pagerows" 	   id="pagerows">
<input type="hidden" name="ofcCd" 		   id="ofcCd" value="<%=strOfc_cd %>">
<input type="hidden" name="call_gubun"     id="call_gubun" value="<%=callGubun%>">
<input type="hidden" name="d_type" 	       id="d_type" value="<%=dType%>">
<input type="hidden" name="vvd_cd"         id="vvd_cd" value="<%=vvdCd%>">
<input type="hidden" name="port_cd"        id="port_cd" value="<%=portCd%>">
<input type="hidden" name="bl_no"          id="bl_no" value="<%=blNo%>">
<input type="hidden" name="frm_bkg_no" 	   id="frm_bkg_no" value="<%=bkgNo%>">
<input type="hidden" name="p_cntr_no"      id="p_cntr_no" value="<%=cntrNo%>">
<input type="hidden" name="p_cntr_cgo_seq" id="p_cntr_cgo_seq" value="<%=cntrCgoSeq%>">
<input type="hidden" name="p_berth_cd"     id="p_berth_cd" value="<%=berthCd%>">
<input type="hidden" name="p_berth_nm"     id="p_berth_nm" value="<%=berthNm%>">
<input type="hidden" name="save_type"      id="save_type" value="">
<input type="hidden" name="gw_subject"     id="gw_subject"> 
<input type="hidden" name="gw_contents"    id="gw_contents">
<input type="hidden" name="gw_args"        id="gw_args" value="email;">
<input type="hidden" name="trans_type"     id="trans_type">
<input type="hidden" name="page_save_yn"   id="page_save_yn" value="N">
<input type="hidden" name="frm_pol_cd"     id="frm_pol_cd">
<input type="hidden" name="frm_pod_cd"     id="frm_pod_cd">
<input type="hidden" name="frm_anr_role_div_cd" id="frm_anr_role_div_cd">
<input type="hidden" name="frm_anr_fwrd_nm" id="frm_anr_fwrd_nm">
<input type="hidden" name="frm_svc_rqst_no" id="frm_svc_rqst_no">
<input type="hidden" name="frm_pck_qty"    id="frm_pck_qty">
<input type="hidden" name="frm_pck_tp_cd"  id="frm_pck_tp_cd">
<input type="hidden" name="frm_vsl_lodg_dt" id="frm_vsl_lodg_dt">
<input type="hidden" name="frm_crr_cd"      id="frm_crr_cd">
<input type="hidden" name="frm_cntr_no_old"      id="frm_cntr_no_old">
<input type="hidden" name="frm_emer_rspn_gid_no" id="frm_emer_rspn_gid_no">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title">
		<span>Dangerous Cargo Detail(s) Inquiry</span>
	</h2>
	<!-- page_title(E) -->	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!-- 
		--><button type="button" class="btn_accent" name="btn1_Retrieve"    id="btn1_Retrieve">    Search</button><!-- 
		--><button type="button" class="btn_normal" name="btn1_Save(CNTR)" id="btn1_Save(CNTR)"> Save (CNTR)</button><!-- 	
		--><button type="button" class="btn_normal" name="btn1_Save(BKG)"  id="btn1_Save(BKG)">  Save (BKG)</button><!-- 
		--><button type="button" class="btn_normal" name="btn_close"       id="btn_close">       Close</button><!-- 
	--></div>
	<!-- opus_design_btn(E) -->
	
	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
	<table>
		<colgroup>				
			<col width="75"/>
			<col width="50"/>
			<col width="30"/>
			<col width="50"/>
			<col width="50"/>
			<col width="30"/>
			<col width="50"/>
			<col width="120"/>
			<col width="30"/>
			<col width="50"/>
			<col width="*"/>
		</colgroup>	
			<tbody>
			<tr>
			<%
				if(callGubun.equals("ESM_BKG_0965")) {
			%>				
					<th>Declaration </th>
					<td>
						   <input type="checkbox" name="d_type1" id="d1" value="D" class="trans" disabled="true"><label for = "d1">Discharging</label><!--  
						--><input type="checkbox" name="d_type1" id="d2" value="T" class="trans" disabled="true"><label for = "d2">Transit</label><!--  
						--><input type="checkbox" name="d_type1" id="d3" value="L" class="trans" disabled="true"><label for = "d3">Loading</label><!--  
						--><input type="checkbox" name="d_type1" id="d4" value="P" class="trans" disabled="true"><label for = "d4">Pre-carriage</label><!--  
						--><input type="checkbox" name="d_type1" id="d5" value="O" class="trans" disabled="true"><label for = "d5">On-Carriage</label>
					</td>
			<%
				} else {
			%>				
					<th class ="sm">Declaration</th>
					<td class = "sm"><!-- 
						 --><input type="radio" value="D" class="trans" name="d_type1" id="d6" disabled="true"><label for = "d6">Import</label><!-- 
						 --><input type="radio" value="T" class="trans" name="d_type1" id="d7" disabled="true"><label for = "d7">Transit</label><!-- 
						 --><input type="radio" value="L" class="trans" name="d_type1" id="d8" disabled="true"><label for = "d8">Export</label>	
					</td>											
			<%
			}
			%>	
					<td></td>
					<th class ="sm">B/L No.</th>
						<td class ="sm"> <input type="text" style="width:100px;" class="input2" name="bl_no" id="bl_no" maxlength="12" value="<%=blNo%>" readOnly="true"></td>
					<td></td>
					<th class ="sm">Container No.</th>
					<td class ="sm"><script type="text/javascript">ComComboObject('cntr_list', 1, 110, 1);</script></td>
					<td ><button type="button" class="btn_left" name="btn1_back" id="btn1_back"></button><!--  
						--><button type="button" class="btn_right" name="btn1_next" id="btn1_next"></button>
					</td>
					<td><input type="text" style="width:50px;text-align:center" name="dis_cntr_cgo_seq" id="dis_cntr_cgo_seq" readOnly="true"><!--  
						--><input type="hidden" name="cntr_cgo_seq"><!--  
						--><input type="hidden" name="cntr_no">
					</td>
					<td></td>
					<th class ="sm">Cargo Operator</th>
					<td><input type="text" style="width:40px;" "name="frm_cgo_opr_cd" id="frm_cgo_opr_cd" class="input2" readOnly> </td>
			</tr>
		</tbody>
</table>
</div>
<table class="line_bluedot"><tr><td colspan="6"></td></tr> </table>
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry wFit">
	<table>
			<colgroup>
				<col width="75"/>
				<col width="50"/>
				<col width="170"/>
				<col width="*"/>
			</colgroup>	
				<tbody>
				<tr>
					<th>Sent Status</th> 
					<td><input type="text" style="width:180px; font-weight:bold;color: #ffffff;" class="input2" name="frm_ack_rcv_sts_cd" readOnly></td>
					<th>Acknowledge Remark(s)</th>
					<td><input type="text" style="width:400px;" class="input2" name="frm_cstms_err_msg" readOnly></td>
			   </tr>
		</tbody>
	</table>
</div>
<!-- ============================================================== -->
<!-- <td class="line_bluedot"><tr><td colspan="6"></td></tr> -->
<!-- =================================================== -->
<div class="opus_design_inquiry wFit">	
	<table class = "grid2">
		<colgroup>
			<col width="200"/>
			<col width="250"/>
			<col width="150"/>
			<col width="100"/>
			<col width="150"/>
			<col width="*"/>
	    </colgroup>
	    <tbody>
   		<tr>
      		<td style="text-align:center;" class = "sm">
      		<strong >Container No.</strong>
      		</td>
      		<td style="border: 1px solid #B8D6F6; text-align:left;"><input type="text" style="width:120px; ime-mode: disabled" class="input2" name="frm_cntr_no"  id="frm_cntr_no" readOnly><!--  
			--><input type="text" style="width:30px; ime-mode: disabled" class="input" name="frm_cntr_tpsz_cd" 	 id="frm_cntr_tpsz_cd"><!--  
			--><input type="text" style="width:40px; ime-mode: disabled" class="input2" name="frm_cntr_tpsz_iso_cd" id="frm_cntr_tpsz_iso_cd" readOnly>
			<td colspan="2" style="border: 1px solid #B8D6F6; text-align:center;" class = "sm"><strong>DG Ref. No.</strong></td>
			<td colspan="2" style="border: 1px solid #B8D6F6; text-align:left;"><input type="text" style="width:197px; ime-mode: disabled" name="frm_dcgo_ref_no" id="frm_dcgo_ref_no" class="input"></td>
 		</tr>
		<tr>
			<td style="border: 1px solid #B8D6F6; text-align:center;" class = "sm"><strong>Emergency Tel.</strong></td>
			<td style="border: 1px solid #B8D6F6; text-align:left;">
				<input type="text" style="width:197px; ime-mode: disabled" name="frm_emer_cntc_phn_no" id="frm_emer_cntc_phn_no" class="input" >
			<td colspan="2" style="border: 1px solid #B8D6F6; text-align:center;" class = "sm"><strong>PIC</strong></td>
			<td colspan="2" style="border: 1px solid #B8D6F6; text-align:left;">
				<input type="text" style="width:197px; ime-mode: disabled" name="frm_emer_cntc_pson_nm" id="frm_emer_cntc_pson_nm" class="input">
			</td>
		</tr>
		<tr>
			<td style="border: 1px solid #B8D6F6; text-align:center;" class = "sm"><strong>UN No.</strong></td>
			<td style="border: 1px solid #B8D6F6; text-align:left;"><input type="text" style="width:100px; ime-mode: disabled" name="frm_imdg_un_no" id="frm_imdg_un_no" class="input2" maxlength="4"><!--  
				--><input name="frm_imdg_un_no_seq" id="frm_imdg_un_no_seq"  	type="text" style="width:30px;" class="input2" value="" readonly><!--  
				--><input name="frm_imdg_comp_grp_cd" id="frm_imdg_comp_grp_cd"  type="text" style="width:30px;" class="input2" value="" readonly><!--  
				--><button type="button" class="input_seach_btn" name="btn_popup4" id="btn_popup4"></button>
			<td style="border: 1px solid #B8D6F6; text-align:center;" class = "sm"><strong>Marine Pollutant</strong></td>
			<td style="border: 1px solid #B8D6F6; text-align:left;">
				<select style="width:80px;" name="frm_eur_dcgo_mrn_polut_cd" id="frm_eur_dcgo_mrn_polut_cd">
				<option value="Y">Yes</option>
				<option value="N">No</option>
				</select>
			</td><td style="border: 1px solid #B8D6F6; text-align:center;" class = "sm"><strong>Limited quantity</strong></td>
			<td style="border: 1px solid #B8D6F6; text-align:left;">
				<select style="width:80px; ime-mode: disabled" name="frm_imdg_lmt_qty_flg" id="frm_imdg_lmt_qty_flg">
				<option value="Y">Yes</option>
				<option value="N" selected="true">No</option>
				</select>
			</td>
		</tr>
		<tr>
			<td style="border: 1px solid #B8D6F6; text-align:center;" class = "sm"><strong>Class</strong></td>
			<td style="border: 1px solid #B8D6F6; text-align:left;"><input type="text" style="width:197px; ime-mode: disabled" name="frm_imdg_clss_cd" id="frm_imdg_clss_cd" class="input" maxlength="3" dataformat="float"></td>
			<td colspan="2" style="border: 1px solid #B8D6F6; text-align:center;" class = "sm"><strong>High Consequence dangerous goods</strong></td>
			<td colspan="2" style="border: 1px solid #B8D6F6; text-align:left;" >
				<select style="width:200px;" name="frm_hcdg_flg" id="frm_hcdg_flg">
				<option value="Y">Yes</option>
				<option value="N" selected="true">No</option>
				</select>
			</td>
		</tr>
		<tr>
  			<td style="border: 1px solid #B8D6F6; text-align:center;" class = "sm"><strong>Net Explosive Weight / KG</strong></td>
			<td style="border: 1px solid #B8D6F6; text-align:left;"><input type="text" style="width:197px; ime-mode: disabled" name="frm_net_explo_wgt" id="frm_net_explo_wgt" class="input" maxlength="18" dataformat="singledFloat"></td>
			<td colspan="2" style="border: 1px solid #B8D6F6; text-align:center;" class = "sm"><strong>Outer Package Qty / Code</strong></td>
			<td colspan="2" style="border: 1px solid #B8D6F6; text-align:left;"><input type="text" style="width:100px; ime-mode: disabled" name="frm_out_imdg_pck_qty1" id="frm_out_imdg_pck_qty1" class="input" value="" dataformat="singledFloat"><!--  
				--><input type="text" style="width:100px; ime-mode: disabled" name="frm_out_imdg_pck_cd1"  id="frm_out_imdg_pck_cd1" class="input" maxlength="5">
			</td>
		</tr>
		<tr>
			<td style="border: 1px solid #B8D6F6; text-align:center;" class = "sm"><strong>Flash Point</strong></td>
			<td style="border: 1px solid #B8D6F6; text-align:left;"><input type="text" style="width:197px; ime-mode: disabled" name="frm_flsh_pnt_cdo_temp" id="frm_flsh_pnt_cdo_temp" class="input" maxlength="7" dataformat="singledFloat" caption="Flash Point"></td>
			<td colspan="2" style="border: 1px solid #B8D6F6; text-align:center;" class = "sm"><strong>Outer Package Description</strong></td>
			<td colspan="2" style="border: 1px solid #B8D6F6; text-align:left;"><input type="text" style="width:360px; ime-mode: disabled" name="frm_eur_outr_pck_desc" class="input" maxlength="500"></td>
		</tr>
		<tr>
			<td style="border: 1px solid #B8D6F6; text-align:center;" class = "sm"><strong>Packing Group</strong></td>
			<td style="border: 1px solid #B8D6F6; text-align:left;"><%=JSPUtil.getCodeCombo("frm_imdg_pck_grp_cd", "", " style='width:197px; ime-mode: disabled'", "CD20047", 0, "")%><script>ComAddBeginComboItem(form.frm_imdg_pck_grp_cd,"","")</script><script>ComSetObjValue(form.frm_imdg_pck_grp_cd,'' );</script></td>					
				<!-- <input type="text" style="width:197;" name="frm_imdg_pck_grp_cd" class="input">-->
			<td colspan="2" style="border: 1px solid #B8D6F6; text-align:center;" class = "sm"><strong>Inner Package Qty / Code</strong></td>
			<td colspan="2" style="border: 1px solid #B8D6F6; text-align:left;"><!-- 
			--><input type="text" style="width:100px; ime-mode: disabled" name="frm_in_imdg_pck_qty1" id="frm_in_imdg_pck_qty1" class="input" value="" dataformat="singledFloat"><!--  
			--><input type="text" style="width:100px; ime-mode: disabled" name="frm_in_imdg_pck_cd1" id="frm_in_imdg_pck_cd1" class="input" maxlength="5"></td>
		</tr>
		<tr>
			<td style="border: 1px solid #B8D6F6; text-align:center;" class = "sm"><strong>EMS No.</strong></td>
			<td style="border: 1px solid #B8D6F6; text-align:left;"><input type="text" style="width:197px; ime-mode: disabled" name="frm_ems_no" id="frm_ems_no" class="input" maxlength="14" ></td>
			<td colspan="2" style="border: 1px solid #B8D6F6; text-align:center;" class = "sm"><strong>Inner Package Description</strong></td>
			<td colspan="2" style="border: 1px solid #B8D6F6; text-align:left;"><input type="text" style="width:360px; ime-mode: disabled" name="frm_eur_inr_pck_desc" id="frm_eur_inr_pck_desc" class="input" maxlength="500"></td>
		</tr>
		<tr>
			<td style="border: 1px solid #B8D6F6; text-align:center;" class = "sm"><strong>Net Weight</strong></td>
			<td style="border: 1px solid #B8D6F6; text-align:left;"><input type="text" style="width:197px;ime-mode: disabled" name="frm_net_wgt" id="frm_net_wgt" class="input" maxlength="18" dataformat="singledFloat"></td>
			<td colspan="2" style="border: 1px solid #B8D6F6; text-align:center;" class = "sm"><strong>Mfag</strong></td>
			<td colspan="2" style="border: 1px solid #B8D6F6; text-align:left;"><input type="text" style="width:200px;ime-mode: disabled" name="frm_mfag_no" id="frm_mfag_no" class="input" maxlength="20"></td>
		</tr>
		<tr>
			<td style="border: 1px solid #B8D6F6; text-align:center;" class = "sm"><strong>Gross Weight</strong></td>
			<td style="border: 1px solid #B8D6F6; text-align:left;"><input type="text" style="width:197px;ime-mode: disabled" name="frm_grs_wgt" id="frm_grs_wgt" class="input" maxlength="18" dataformat="singledFloat"></td>
			<td colspan="2" style="border: 1px solid #B8D6F6; text-align:center;" class = "sm"><strong>Cell Position</strong></td>
			<td colspan="2" style="border: 1px solid #B8D6F6; text-align:left;"><input type="text" style="width:200px;ime-mode: disabled" name="frm_cell_psn_no" id="frm_cell_psn_no" class="input" dataformat="engup" maxlength="7" fullfill caption="Cell Position"></td>
		</tr>
		<tr>
			<td style="border: 1px solid #B8D6F6; text-align:center;" class = "sm"><strong>Package</strong></td>
			<td style="border: 1px solid #B8D6F6;width:100% text-align:center;" colspan="5"><input type="text" style="width:100%;ime-mode: disabled" name="frm_eur_pck_desc" class="input" maxlength="500"></td>
		</tr>
		<tr>
			<td style="border: 1px solid #B8D6F6; text-align:center;" class = "sm"><strong>Substance</strong></td>
			<td style="border: 1px solid #B8D6F6; text-align:center;" colspan="5"><input type="text" style="width:100%;ime-mode: disabled" name="frm_prp_shp_nm" id="frm_prp_shp_nm" class="input" maxlength="200"></td>
		</tr>
		<tr>
			<td style="border: 1px solid #B8D6F6; text-align:center;" class = "sm"><strong>Technical Name </strong></td>
			<td style="border: 1px solid #B8D6F6; text-align:center;" colspan="5"><input type="text" style="width:100%;ime-mode: disabled" name="frm_hzd_desc" id="frm_hzd_desc" class="input" maxlength="4000"></td>
		</tr>
		<%--
		<tr>
			<td style="border: 1px solid #B8D6F6; text-align:center;" class = "sm"><strong>Berth</strong></td>
			<td style="border: 1px solid #B8D6F6; text-align:left;" colspan="5"><input type="text" style="width:100px;ime-mode: disabled" name="frm_brth_yd_cd" id="frm_brth_yd_cd" class="input" dataformat="engup" maxlength="7" caption="Berth"><!--  
				--><input type="text" style="width:275px;ime-mode: disabled" name="frm_brth_yd_nm" id="frm_brth_yd_nm" class="input" maxlength="50"></td>
		</tr>
		--%>
		<tr>
			<td style="border: 1px solid #B8D6F6; text-align:center;" class = "sm"><strong>Extended Stay Permit</strong></td>
			<td style="border: 1px solid #B8D6F6; text-align:left;" colspan="5"><input type="text" style="width:70%;ime-mode: disabled" name="frm_xtd_stay_prmt_no" id="frm_xtd_stay_prmt_no" maxlength="50" class="input"></td>
		</tr>
		<tr>
			<td style="border: 1px solid #B8D6F6; text-align:center;" class = "sm"><strong>Additional Remark(s)</strong></td>
			<td style="border: 1px solid #B8D6F6; text-align:center;" colspan="5"><input type="text" style="width:100%;ime-mode: disabled" name="frm_diff_rmk" id="frm_diff_rmk" class="input" maxlength="500"></td>
		</tr>
		<%
			if(callGubun.equals("ESM_BKG_0965")) {
		%>
		<tr >
			<td style="border: 1px solid #B8D6F6; text-align:center;" class = "sm"><strong>Forwarder Name</strong></td>
			<td style="border: 1px solid #B8D6F6; text-align:left;" colspan="5"><input type="text" style="width:100px;ime-mode: disabled" name="frm_anr_fwrd_id" id="frm_anr_fwrd_id" class="input" dataformat="engup" maxlength="6" caption="Forwarder Code"><input type="text" style="width:200px;ime-mode: disabled" name="frm_fwrd_nm" id="frm_fwrd_nm" class="input" readOnly><button type="button" class="input_seach_btn" name="btn_popup1" id="btn_popup1"></button></td>
		</tr>
		<tr>
			<td style="border: 1px solid #B8D6F6; text-align:center;" class = "sm">
				<div id="layoutView1" style="width:100%;text-align:center; "><strong>On-Carriage Date<br> (YYYY-MM-DD)</strong></div></td>
			<td style="border: 1px solid #B8D6F6; text-align:left;" colspan="5"><input type="text" style="width:100px;text-align:center;" name="frm_crr_dt" class="input2" dataformat="ymd" maxlength="10" readonly caption="On-Carriage Date"></td>
		</tr>
			
		<tr>
			<td style="border: 1px solid #B8D6F6; text-align:center;" class = "sm"><strong>Belgian Codes for Type<br> of special UN numbers</strong></td>
			<td style="border: 1px solid #B8D6F6; text-align:left;" colspan="5"><!-- <select style="width:200;" name="frm_imdg_un_no_desc"> -->
			<%=JSPUtil.getCodeCombo("frm_anr_spcl_tp_id", "", " style='width:200px;'", "CD20026", 0, "")%>
			<script>
			ComAddBeginComboItem(form.frm_anr_spcl_tp_id,"","");
			form.frm_anr_spcl_tp_id[0].selected = true ;
			</script><!--   
			 --><button type="button" class="input_seach_btn" name="btn_popup2" id="btn_popup2"></button></td>
		</tr>
		<tr>
			<td style="border: 1px solid #B8D6F6; text-align:center;" class = "sm"><strong>Carriage Type </strong></td>
			<td><%=JSPUtil.getCodeCombo("frm_anr_crr_tp_cd", "", " style='width:200px;'", "CD20027", 0, "")%>
			<script>
			ComAddBeginComboItem(form.frm_anr_crr_tp_cd,"","");
			form.frm_anr_crr_tp_cd[0].selected = true ;
			</script></td>
			<td style="border: 1px solid #B8D6F6; text-align:center;" class = "sm"><strong>SSR for Feeder transshipment</strong></td>
			<td><input type="text" style="width:100%;ime-mode: disabled" name="frm_fdr_svc_rqst_no" id="frm_fdr_svc_rqst_no" class="input" dataformat="engup" maxlength="14" caption="SSR for Feeder transshipment"></td>
		</tr>
		<tr>
			<td style="border: 1px solid #B8D6F6; text-align:center;" class = "sm"><strong>Feeder VVD</strong></td>
			<td><input type="text" style="width:197px;ime-mode: disabled" name="frm_fdr_vvd_id" id="frm_fdr_vvd_id" class="input" dataformat="engup" maxlength="9" caption="Feeder VVD"></td>
			<!-- <td class="tr2_head">Feeder Name / Lloyd No</td> -->
			<td style="border: 1px solid #B8D6F6; text-align:center;" class = "sm"><div id="layoutView" style="width:100%;text-align:center;">Feeder Name / Lloyd No</div></td>
			<td><input type="text" style="width:62%;ime-mode: disabled" name="frm_fdr_vsl_nm" id="frm_fdr_vsl_nm" class="input" readOnly caption="Feeder Name" ><!--  
				--><input type="text" style="width:30%;ime-mode: disabled" name="frm_fdr_vsl_lloyd_no" id="frm_fdr_vsl_lloyd_no" class="input" readOnly maxlength="7" caption="Lloyd No"> 
				<div id="layoutView3" style="display:inline"><button type="button" class="input_seach_btn" name="btn_popup3" id="btn_popup3"></button></div>
			</td>
		</tr>
		<% } %>
		<tr>
			<td style="border: 1px solid #B8D6F6; text-align:center;" class = "sm"><strong>Sub Class 1/2/3/4</strong></td>
			<td colspan="5">
				<input type="text" style="width:100px; ime-mode: disabled" name="frm_imdg_subs_rsk_lbl_cd1" id="frm_imdg_subs_rsk_lbl_cd1" class="input" maxlength="3" dataformat="float">
				/ <input type="text" style="width:100px; ime-mode: disabled" name="frm_imdg_subs_rsk_lbl_cd2" id="frm_imdg_subs_rsk_lbl_cd2" class="input" maxlength="3" dataformat="float">
				/ <input type="text" style="width:100px; ime-mode: disabled" name="frm_imdg_subs_rsk_lbl_cd3" id="frm_imdg_subs_rsk_lbl_cd3" class="input" maxlength="3" dataformat="float">
				/ <input type="text" style="width:100px; ime-mode: disabled" name="frm_imdg_subs_rsk_lbl_cd4" id="frm_imdg_subs_rsk_lbl_cd4" class="input" maxlength="3" dataformat="float">
			</td>
		</tr>
		</table>
		<div style="display:none">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
</div>
</form>
