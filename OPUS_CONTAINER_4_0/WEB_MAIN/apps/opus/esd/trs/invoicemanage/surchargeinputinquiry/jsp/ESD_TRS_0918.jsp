<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0918.jsp
*@FileTitle  : surcharge managing
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/21
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.trs.invoicemanage.surchargeinputinquiry.event.EsdTrs0918Event"%>
<%@ page import="com.clt.bizcommon.util.BizComUtil"%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>

<%
	EsdTrs0918Event  event = null;	
	Exception serverException   = null;
	DBRowSet rowSet	  = null;
	String strErrMsg = "";
	int rowCount	 = 0;								  

	try {
		event = (EsdTrs0918Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}

	String unique_cd			= JSPUtil.getNull(request.getParameter("unique_cd"));
	String open_mode			= JSPUtil.getNull(request.getParameter("open_mode")); //input/modify/search/multiple
	String step_cd				= JSPUtil.getNull(request.getParameter("step_cd"));
	String ofc_cty_cd			= JSPUtil.getNull(request.getParameter("ofc_cty_cd"));
	String so_seq				= JSPUtil.getNull(request.getParameter("so_seq"));
	String main_row				= JSPUtil.getNull(request.getParameter("main_row"));
	String rate					= JSPUtil.getNull(request.getParameter("rate"));
	String cal_logic			= JSPUtil.getNull(request.getParameter("cal_logic")); 
	String sheet_arr_no			= JSPUtil.getNull(request.getParameter("sheet_arr_no"));//surcharge sheet array no
	String curr_cd				= JSPUtil.getNull(request.getParameter("curr_cd"));
	String inv_etc_add_amt		= JSPUtil.getNull(request.getParameter("inv_etc_add_amt"));

    // 2014.12.11    Hyungwook Choi
    String vndr_seq             = JSPUtil.getNull(request.getParameter("vndr_seq"));
    String trsp_crr_mod_cd      = JSPUtil.getNull(request.getParameter("trsp_crr_mod_cd"));
    String trsp_cost_dtl_mod_cd = JSPUtil.getNull(request.getParameter("trsp_cost_dtl_mod_cd"));
    String cgo_tp_cd            = JSPUtil.getNull(request.getParameter("cgo_tp_cd"));
    String trsp_bnd_cd          = JSPUtil.getNull(request.getParameter("trsp_bnd_cd"));
    String fm_nod_cd            = JSPUtil.getNull(request.getParameter("fm_nod_cd"));
    String via_nod_cd           = JSPUtil.getNull(request.getParameter("via_nod_cd"));
    String dor_nod_cd           = JSPUtil.getNull(request.getParameter("dor_nod_cd"));
    String to_nod_cd            = JSPUtil.getNull(request.getParameter("to_nod_cd"));
    String cre_dt               = JSPUtil.getNull(request.getParameter("cre_dt"));
    String eq_knd_cd            = JSPUtil.getNull(request.getParameter("eq_knd_cd"));
    String eq_tpsz_cd           = JSPUtil.getNull(request.getParameter("eq_tpsz_cd"));
    String po_fuel_scg_rt       = JSPUtil.getNull(request.getParameter("po_fuel_scg_rt"));
    String scg_ind_cd           = JSPUtil.getNull(request.getParameter("scg_ind_cd"));

//	String chasis_type_size		= BizComUtil.getCodeCombo("chasis_type_size", "", " disabled ", "CHASSIS", 1, "0::"); 
//	String chasis_drayage_type_size = BizComUtil.getCodeCombo("chasis_drayage_type_size", "", " disabled ", "CHASSIS", 1, "0::"); 
	String getset_tp_sz			= BizComUtil.getCodeCombo("getset_tp_sz", "", " disabled ", "GENSET", 1, "0::"); 

	String multi_ofc_cty_cdStr	= "";
	String multi_so_seqStr		= "";
	String multi_cgo_tp_cdStr	= "";
	String check_rowStr			= "";

	if(cgo_tp_cd != null && cgo_tp_cd.equals("F")) cgo_tp_cd = "C";
	else cgo_tp_cd = "M";
	
	// Fuel Surcharge Code 변환
	// S + C|M + FU + RD|TD|WD|RT|WR|WT
	if (trsp_crr_mod_cd == "RW") {
		trsp_crr_mod_cd = "WR";
	} else if (trsp_crr_mod_cd == "TW") {
		trsp_crr_mod_cd = "WT";
	} else if (trsp_crr_mod_cd == "TR") {
		trsp_crr_mod_cd = "RT";
	}
	
	// 2015.07.13 CHAN WOO PARK
	// Fuel Surcharge 적용
	String fuel_scg_cd = "S" + cgo_tp_cd + "FU" + trsp_crr_mod_cd;
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
<%
	if("multiple".equals(open_mode)){
		multi_ofc_cty_cdStr		= request.getParameter("multi_ofc_cty_cd");
		multi_so_seqStr			= request.getParameter("multi_so_seq");
		multi_cgo_tp_cdStr		= request.getParameter("multi_cgo_tp_cd");
		check_rowStr			= request.getParameter("check_row");

%>
	var multi_ofc_cty_cdStr		= '<%=StringUtil.xssFilter(multi_ofc_cty_cdStr)%>';
	var multi_ofc_cty_cdArray	= multi_ofc_cty_cdStr.split('|');
	var multi_so_seqStr			= '<%=StringUtil.xssFilter(multi_so_seqStr)%>';
	var multi_so_seqArray		= multi_so_seqStr.split('|');
	var multi_cgo_tp_cdStr		= '<%=StringUtil.xssFilter(multi_cgo_tp_cdStr)%>';
	var multi_cgo_tp_cdArray	= multi_cgo_tp_cdStr.split('|');
	var check_rowStr			= '<%=StringUtil.xssFilter(check_rowStr)%>';
	var check_rowArray			= check_rowStr.split('|');

<%
	}
%>

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
<input type="hidden" name="iPage" id="iPage" />
<input type='hidden' name='curr_cd' id='curr_cd' value='<%=StringUtil.xssFilter(curr_cd)%>'>
<input type='hidden' name='unique_cd' id='unique_cd' value='<%=StringUtil.xssFilter(unique_cd)%>'>
<input type='hidden' name='open_mode' id='open_mode' value='<%=StringUtil.xssFilter(open_mode)%>'>
<input type='hidden' name='step_cd' id='step_cd' value='<%=StringUtil.xssFilter(step_cd)%>'>
<input type='hidden' name='ofc_cty_cd' id='ofc_cty_cd' value='<%=StringUtil.xssFilter(ofc_cty_cd)%>'>
<input type='hidden' name='so_seq' id='so_seq' value='<%=StringUtil.xssFilter(so_seq)%>'>
<input type='hidden' name='main_row' id='main_row' value='<%=StringUtil.xssFilter(main_row)%>'>
<input type='hidden' name='rate' id='rate' value='<%=StringUtil.xssFilter(rate)%>'>
<input type='hidden' name='cal_logic' id='cal_logic' value='<%=StringUtil.xssFilter(cal_logic)%>'>
<input type='hidden' name='sheet_arr_no' id='sheet_arr_no' value='<%=StringUtil.xssFilter(sheet_arr_no)%>'>
<input type='hidden' name='inv_etc_add_amt' id='inv_etc_add_amt' value='<%=StringUtil.xssFilter(inv_etc_add_amt)%>'>
<input type='hidden' name='prefix' id='prefix' value='surcharge_'>

<!-- 2014.12.11    Hyungwook Choi -->
<input type="hidden" name="vndr_seq"             id="vndr_seq"             value='<%=StringUtil.xssFilter(vndr_seq)%>'/>
<input type="hidden" name="trsp_crr_mod_cd"      id="trsp_crr_mod_cd"      value='<%=StringUtil.xssFilter(trsp_crr_mod_cd)%>'/>
<input type="hidden" name="trsp_cost_dtl_mod_cd" id="trsp_cost_dtl_mod_cd" value='<%=StringUtil.xssFilter(trsp_cost_dtl_mod_cd)%>'/>
<input type="hidden" name="cgo_tp_cd"            id="cgo_tp_cd"            value='<%=StringUtil.xssFilter(cgo_tp_cd)%>'/>
<input type="hidden" name="trsp_bnd_cd"          id="trsp_bnd_cd"          value='<%=StringUtil.xssFilter(trsp_bnd_cd)%>'/>
<input type="hidden" name="fm_nod_cd"            id="fm_nod_cd"            value='<%=StringUtil.xssFilter(fm_nod_cd)%>'/>
<input type="hidden" name="via_nod_cd"           id="via_nod_cd"           value='<%=StringUtil.xssFilter(via_nod_cd)%>'/>
<input type="hidden" name="dor_nod_cd"           id="dor_nod_cd"           value='<%=StringUtil.xssFilter(dor_nod_cd)%>'/>
<input type="hidden" name="to_nod_cd"            id="to_nod_cd"            value='<%=StringUtil.xssFilter(to_nod_cd)%>'/>
<input type="hidden" name="cre_dt"               id="cre_dt"               value='<%=StringUtil.xssFilter(cre_dt)%>'/>
<input type="hidden" name="eq_knd_cd"            id="eq_knd_cd"            value='<%=StringUtil.xssFilter(eq_knd_cd)%>'/>
<input type="hidden" name="eq_tpsz_cd"           id="eq_tpsz_cd"           value='<%=StringUtil.xssFilter(eq_tpsz_cd)%>'/>
<input type="hidden" name="po_fuel_scg_rt"       id="po_fuel_scg_rt"       value='<%=StringUtil.xssFilter(po_fuel_scg_rt)%>'/>
<input type="hidden" name="fuel_scg_cd"          id="fuel_scg_cd"          value='<%=StringUtil.xssFilter(fuel_scg_cd)%>'/>
<input type="hidden" name="scg_ind_cd"           id="scg_ind_cd"           value='<%=StringUtil.xssFilter(scg_ind_cd)%>' />

<!-- page_title_area(S) -->
<div class="layer_popup_title">
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><span>Surcharge</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_save"  id="btn_save" style="display:none;">Save</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
</div>
</div>
<!-- page_title_area(E) -->
<div class="layer_popup_contents">
<div class="wrap_search">
	<!-- layout_wrap(S) -->
	<div class="layout_wrap">
		<!-- layout_vertical_2(S) -->
		<div class="layout_vertical_2 mar_rgt_4" style="width: 440px;">
			<div class="opus_design_inquiry wFit" >
				<table>
					<colgroup>
						<col width="160">
						<col width="10">
						<col width="75">
						<col width="30">
						<col width="75">
						<col width="5">
						<col width="*">
				   </colgroup>
				<tbody>
						<tr>
							<th colspan="7" style="text-align:center;">Surcharge Kind<hr></th>
						</tr> 
						<tr id='SCALAL_01'>
							<th><input name="SCALAL_chk" type="checkbox" onClick='setCheckedForm(this)' class="trans">&nbsp;ADDLAB</th>
							<td></td>
							<td><input name="SCALAL_txt" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" onchange="getSumTotalAmount(this)" disabled id="SCALAL_txt" /> </td>
							<td></td>
							<td><input name="SCALAL_txt2" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" disabled id="SCALAL_txt2" /> </td>
							<td></td>
							<td>
								<input name="SCALAL_txt3" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" onchange="getSumTotalAmount(this)" disabled id="SCALAL_txt3" />
								<input name="SCALAL_txt4" type="hidden" maxlength="11" class="input2" style="width:75px; text-align:right" disabled id="SCALAL_txt4" />
							</td>
						</tr>
						<tr id='SCLWAL_01'>
							<th><input name="SCLWAL_chk" type="checkbox" onClick='setCheckedForm(this)' class="trans">&nbsp;BARGLW</th>
							<td></td>
							<td><input name="SCLWAL_txt" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" onchange="getSumTotalAmount(this)" disabled id="SCLWAL_txt" /> </td>
							<td></td>
							<td><input name="SCLWAL_txt2" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" disabled id="SCLWAL_txt2" /> </td>
							<td></td>
							<td>
								<input name="SCLWAL_txt3" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" onchange="getSumTotalAmount(this)" disabled id="SCLWAL_txt3" />
								<input name="SCLWAL_txt4" type="hidden" maxlength="11" class="input2" style="width:75px; text-align:right" disabled id="SCLWAL_txt4" /> 
							</td>
						</tr>
						<tr id='SCCDAL_01'>
							<th><input name="SCCDAL_chk" type="checkbox" onClick='setCheckedForm(this)' class="trans">&nbsp;DRYAGE</th>
							<td></td>
							<td><input name="SCCDAL_txt" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" onchange="getSumTotalAmount(this)" disabled id="SCCDAL_txt" /> </td>
							<td></td>
							<td><input name="SCCDAL_txt2" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" disabled id="SCCDAL_txt2" /> </td>
							<td></td>
							<td>
								<input name="SCCDAL_txt3" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" onchange="getSumTotalAmount(this)" disabled id="SCCDAL_txt3" /> 
								<input name="SCCDAL_txt4" type="hidden" maxlength="11" class="input2" style="width:75px; text-align:right" disabled id="SCCDAL_txt4" />
							</td>
						</tr>
						<tr id='SCDPAL_01'>
							<th><input name="SCDPAL_chk" type="checkbox" onClick='setCheckedForm(this)' class="trans">&nbsp;DRP&amp;PU</th>
							<td></td>
							<td><input name="SCDPAL_txt" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" onchange="getSumTotalAmount(this)" disabled id="SCDPAL_txt" /> </td>
							<td></td>
							<td><input name="SCDPAL_txt2" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" disabled id="SCDPAL_txt2" /> </td>
							<td></td>
							<td>
								<input name="SCDPAL_txt3" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" onchange="getSumTotalAmount(this)" disabled id="SCDPAL_txt3" />
								<input name="SCDPAL_txt4" type="hidden" maxlength="11" class="input2" style="width:75px; text-align:right" disabled id="SCDPAL_txt4" /> 
							</td>
						</tr>
						<tr id='SCDRAL_01'>
							<th><input name="SCDRAL_chk" type="checkbox" onClick='setCheckedForm(this)' class="trans">&nbsp;DRYRUN</th>
							<td></td>
							<td><input name="SCDRAL_txt" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" onchange="getSumTotalAmount(this)" disabled id="SCDRAL_txt" /> </td>
							<td></td>
							<td><input name="SCDRAL_txt2" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" disabled id="SCDRAL_txt2" /> </td>
							<td></td>
							<td>
								<input name="SCDRAL_txt3" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" onchange="getSumTotalAmount(this)" disabled id="SCDRAL_txt3" />
								<input name="SCDRAL_txt4" type="hidden" maxlength="11" class="input2" style="width:75px; text-align:right" disabled id="SCDRAL_txt4" /> 
							</td>
						</tr>
						<tr id='SCFRAL_01'>
							<th><input name="SCFRAL_chk" type="checkbox" onClick='setCheckedForm(this)' class="trans">&nbsp;FERRY</th>
							<td></td>
							<td><input name="SCFRAL_txt" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" onchange="getSumTotalAmount(this)" disabled id="SCFRAL_txt" /> </td>
							<td></td>
							<td><input name="SCFRAL_txt2" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" disabled id="SCFRAL_txt2" /> </td>
							<td></td>
							<td>
								<input name="SCFRAL_txt3" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" onchange="getSumTotalAmount(this)" disabled id="SCFRAL_txt3" />
								<input name="SCFRAL_txt4" type="hidden" maxlength="11" class="input2" style="width:75px; text-align:right" disabled id="SCFRAL_txt4" /> 
							</td>
						</tr>
						<tr id='SCFIAL_01'>
							<th><input name="SCFIAL_chk" type="checkbox" onClick='setCheckedForm(this)' class="trans">&nbsp;FINE</th>
							<td></td>
							<td><input name="SCFIAL_txt" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" onchange="getSumTotalAmount(this)" disabled id="SCFIAL_txt" /> </td>
							<td></td>
							<td><input name="SCFIAL_txt2" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" disabled id="SCFIAL_txt2" /> </td>
							<td></td>
							<td>
								<input name="SCFIAL_txt3" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" onchange="getSumTotalAmount(this)" disabled id="SCFIAL_txt3" />
								<input name="SCFIAL_txt4" type="hidden" maxlength="11" class="input2" style="width:75px; text-align:right" disabled id="SCFIAL_txt4" /> 
							</td>
						</tr>
						<tr id='SCFGAL_01'>
							<th><input name="SCFGAL_chk" type="checkbox" onClick='setCheckedForm(this)' class="trans">&nbsp;FUMGTE</th>
							<td></td>
							<td><input name="SCFGAL_txt" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" onchange="getSumTotalAmount(this)" disabled id="SCFGAL_txt" /> </td>
							<td></td>
							<td><input name="SCFGAL_txt2" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" disabled id="SCFGAL_txt2" /> </td>
							<td></td>
							<td>
								<input name="SCFGAL_txt3" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" onchange="getSumTotalAmount(this)" disabled id="SCFGAL_txt3" />
								<input name="SCFGAL_txt4" type="hidden" maxlength="11" class="input2" style="width:75px; text-align:right" disabled id="SCFGAL_txt4" /> 
							</td>
						</tr>
						<tr id='SCGNAL_01'>
							<th><input name="SCGNAL_chk" type="checkbox" onClick='setCheckedForm(this)' class="trans">&nbsp;GENSET</th>
							<td></td>
							<td><input name="SCGNAL_txt" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" onchange="getSumTotalAmount(this)" disabled id="SCGNAL_txt" /> </td>
							<td></td>
							<td><input name="SCGNAL_txt2" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" disabled id="SCGNAL_txt2" /> </td>
							<td></td>
							<td>
								<input name="SCGNAL_txt3" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" onchange="getSumTotalAmount(this)" disabled id="SCGNAL_txt3" />
								<input name="SCGNAL_txt4" type="hidden" maxlength="11" class="input2" style="width:75px; text-align:right" disabled id="SCGNAL_txt4" /> 
							</td>
						</tr>
						<tr  id='SCHZAL_01'>
							<th><input name="SCHZAL_chk" type="checkbox" onClick='setCheckedForm(this)' class="trans">&nbsp;HAZMAT</th>
							<td></td>
							<td><input name="SCHZAL_txt" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" onchange="getSumTotalAmount(this)" disabled id="SCHZAL_txt" /> </td>
							<td></td>
							<td><input name="SCHZAL_txt2" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" disabled id="SCHZAL_txt2" /> </td>
							<td></td>
							<td>
								<input name="SCHZAL_txt3" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" onchange="getSumTotalAmount(this)" disabled id="SCHZAL_txt3" /> 
								<input name="SCHZAL_txt4" type="hidden" maxlength="11" class="input2" style="width:75px; text-align:right" disabled id="SCHZAL_txt4" />
							</td>
						</tr>
						<tr  id='SCINAL_01'>
							<th><input name="SCINAL_chk" type="checkbox" onClick='setCheckedForm(this)' class="trans">&nbsp;INSPCT</th>
							<td></td>
							<td><input name="SCINAL_txt" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" onchange="getSumTotalAmount(this)" disabled id="SCINAL_txt" /> </td>
							<td></td>
							<td><input name="SCINAL_txt2" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" disabled id="SCINAL_txt2" /> </td>
							<td></td>
							<td>
								<input name="SCINAL_txt3" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" onchange="getSumTotalAmount(this)" disabled id="SCINAL_txt3" /> 
								<input name="SCINAL_txt4" type="hidden" maxlength="11" class="input2" style="width:75px; text-align:right" disabled id="SCINAL_txt4" />
							</td>
						</tr>
						<tr id='SCLFAL_01'>
							<th><input name="SCLFAL_chk" type="checkbox" onClick='setCheckedForm(this)' class="trans">&nbsp;LIFTNG</th>
							<td></td>
							<td><input name="SCLFAL_txt" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" onchange="getSumTotalAmount(this)" disabled id="SCLFAL_txt" /> </td>
							<td></td>
							<td><input name="SCLFAL_txt2" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" disabled id="SCLFAL_txt2" /> </td>
							<td></td>
							<td>
								<input name="SCLFAL_txt3" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" onchange="getSumTotalAmount(this)" disabled id="SCLFAL_txt3" />
								<input name="SCLFAL_txt4" type="hidden" maxlength="11" class="input2" style="width:75px; text-align:right" disabled id="SCLFAL_txt4" /> 
							</td>
						</tr>
						<tr id='SCMDAL_01'>
							<th><input name="SCMDAL_chk" type="checkbox" onClick='setCheckedForm(this)' class="trans">&nbsp;MULTID</th>
							<td></td>
							<td><input name="SCMDAL_txt" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" onchange="getSumTotalAmount(this)" disabled id="SCMDAL_txt" /> </td>
							<td></td>
							<td><input name="SCMDAL_txt2" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" disabled id="SCMDAL_txt2" /> </td>
							<td></td>
							<td>
								<input name="SCMDAL_txt3" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" onchange="getSumTotalAmount(this)" disabled id="SCMDAL_txt3" /> 
								<input name="SCMDAL_txt4" type="hidden" maxlength="11" class="input2" style="width:75px; text-align:right" disabled id="SCMDAL_txt4" />
							</td>
						</tr>
						<tr id='SCOSAL_01'>
							<th><input name="SCOSAL_chk" type="checkbox" onClick='setCheckedForm(this)' class="trans">&nbsp;OVR-SZ</th>
							<td></td>
							<td><input name="SCOSAL_txt" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" onchange="getSumTotalAmount(this)" disabled id="SCOSAL_txt" /> </td>
							<td></td>
							<td><input name="SCOSAL_txt2" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" disabled id="SCOSAL_txt2" /> </td>
							<td></td>
							<td>
								<input name="SCOSAL_txt3" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" onchange="getSumTotalAmount(this)" disabled id="SCOSAL_txt3" />
								<input name="SCOSAL_txt4" type="hidden" maxlength="11" class="input2" style="width:75px; text-align:right" disabled id="SCOSAL_txt4" /> 
							</td>
						</tr>
						<tr id='SCOWAL_01'>
							<th><input name="SCOWAL_chk" type="checkbox" onClick='setCheckedForm(this)' class="trans">&nbsp;OVR-WT</th>
							<td></td>
							<td><input name="SCOWAL_txt" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" onchange="getSumTotalAmount(this)" disabled id="SCOWAL_txt" /> </td>
							<td></td>
							<td><input name="SCOWAL_txt2" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" disabled id="SCOWAL_txt2" /> </td>
							<td></td>
							<td>
								<input name="SCOWAL_txt3" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" onchange="getSumTotalAmount(this)" disabled id="SCOWAL_txt3" /> 
								<input name="SCOWAL_txt4" type="hidden" maxlength="11" class="input2" style="width:75px; text-align:right" disabled id="SCOWAL_txt4" />
							</td>
						</tr>
						<tr  id='SCPPAL_01'>
							<th><input name="SCPPAL_chk" type="checkbox" onClick='setCheckedForm(this)' class="trans">&nbsp;PREPUL</th>
							<td></td>
							<td><input name="SCPPAL_txt" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" onchange="getSumTotalAmount(this)" disabled id="SCPPAL_txt" /> </td>
							<td></td>
							<td><input name="SCPPAL_txt2" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" disabled id="SCPPAL_txt2" /> </td>
							<td></td>
							<td>
								<input name="SCPPAL_txt3" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" onchange="getSumTotalAmount(this)" disabled id="SCPPAL_txt3" /> 
								<input name="SCPPAL_txt4" type="hidden" maxlength="11" class="input2" style="width:75px; text-align:right" disabled id="SCPPAL_txt4" />
							</td>
						</tr>
						<tr id='SCRCAL_01'>
							<th><input name="SCRCAL_chk" type="checkbox" onClick='setCheckedForm(this)' class="trans">&nbsp;REDIRC</th>
							<td></td>
							<td><input name="SCRCAL_txt" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" onchange="getSumTotalAmount(this)" disabled id="SCRCAL_txt" /> </td>
							<td></td>
							<td><input name="SCRCAL_txt2" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" disabled id="SCRCAL_txt2" /> </td>
							<td></td>
							<td>
								<input name="SCRCAL_txt3" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" onchange="getSumTotalAmount(this)" disabled id="SCRCAL_txt3" /> 
								<input name="SCRCAL_txt4" type="hidden" maxlength="11" class="input2" style="width:75px; text-align:right" disabled id="SCRCAL_txt4" />
							</td>
						</tr>
						<tr id='SCSSAL_01'>
							<th><input name="SCSSAL_chk" type="checkbox" onClick='setCheckedForm(this)' class="trans">&nbsp;SCALES</th>
							<td></td>
							<td><input name="SCSSAL_txt" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" onchange="getSumTotalAmount(this)" disabled id="SCSSAL_txt" /> </td>
							<td></td>
							<td><input name="SCSSAL_txt2" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" disabled id="SCSSAL_txt2" /> </td>
							<td></td>
							<td>
								<input name="SCSSAL_txt3" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" onchange="getSumTotalAmount(this)" disabled id="SCSSAL_txt3" /> 
								<input name="SCSSAL_txt4" type="hidden" maxlength="11" class="input2" style="width:75px; text-align:right" disabled id="SCSSAL_txt4" />
							</td>
						</tr>
						<tr  id='SCSRAL_01'>
							<th><input name="SCSRAL_chk" type="checkbox" onClick='setCheckedForm(this)' class="trans">&nbsp;STORAG</th>
							<td></td>
							<td><input name="SCSRAL_txt" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" onchange="getSumTotalAmount(this)" disabled id="SCSRAL_txt" /> </td>
							<td></td>
							<td><input name="SCSRAL_txt2" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" disabled id="SCSRAL_txt2" /> </td>
							<td></td>
							<td>
								<input name="SCSRAL_txt3" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" onchange="getSumTotalAmount(this)" disabled id="SCSRAL_txt3" /> 
								<input name="SCSRAL_txt4" type="hidden" maxlength="11" class="input2" style="width:75px; text-align:right" disabled id="SCSRAL_txt4" />
							</td>
						</tr>
						<tr  id='SCSTAL_01'>
							<th><input name="SCSTAL_chk" type="checkbox" onClick='setCheckedForm(this)' class="trans">&nbsp;S-TURN</th>
							<td></td>
							<td><input name="SCSTAL_txt" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" onchange="getSumTotalAmount(this)" disabled id="SCSTAL_txt" /> </td>
							<td></td>
							<td><input name="SCSTAL_txt2" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" disabled id="SCSTAL_txt2" /> </td>
							<td></td>
							<td>
								<input name="SCSTAL_txt3" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" onchange="getSumTotalAmount(this)" disabled id="SCSTAL_txt3" /> 
								<input name="SCSTAL_txt4" type="hidden" maxlength="11" class="input2" style="width:75px; text-align:right" disabled id="SCSTAL_txt4" />
							</td>
						</tr>
						<tr id='SCSNAL_01'>
							<th><input name="SCSNAL_chk" type="checkbox" onClick='setCheckedForm(this)' class="trans">&nbsp;SUNDAY</th>
							<td></td>
							<td><input name="SCSNAL_txt" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" onchange="getSumTotalAmount(this)" disabled id="SCSNAL_txt" /> </td>
							<td></td>
							<td><input name="SCSNAL_txt2" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" disabled id="SCSNAL_txt2" /> </td>
							<td></td>
							<td>
								<input name="SCSNAL_txt3" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" onchange="getSumTotalAmount(this)" disabled id="SCSNAL_txt3" /> 
								<input name="SCSNAL_txt4" type="hidden" maxlength="11" class="input2" style="width:75px; text-align:right" disabled id="SCSNAL_txt4" />
							</td>
						</tr>
						<tr id='SCSFAL_01'>
							<th><input name="SCSFAL_chk" type="checkbox" onClick='setCheckedForm(this)' class="trans">&nbsp;SWING</th>
							<td></td>
							<td><input name="SCSFAL_txt" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" onchange="getSumTotalAmount(this)" disabled id="SCSFAL_txt" /> </td>
							<td></td>
							<td><input name="SCSFAL_txt2" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" disabled id="SCSFAL_txt2" /> </td>
							<td></td>
							<td>
								<input name="SCSFAL_txt3" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" onchange="getSumTotalAmount(this)" disabled id="SCSFAL_txt3" /> 
								<input name="SCSFAL_txt4" type="hidden" maxlength="11" class="input2" style="width:75px; text-align:right" disabled id="SCSFAL_txt4" />
							</td>
						</tr>
						<tr id='SCTDAL_01'>
							<th><input name="SCTDAL_chk" type="checkbox" onClick='setCheckedForm(this)' class="trans">&nbsp;TDOC</th>
							<td></td>
							<td><input name="SCTDAL_txt" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" onchange="getSumTotalAmount(this)" disabled id="SCTDAL_txt" /> </td>
							<td></td>
							<td><input name="SCTDAL_txt2" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" disabled id="SCTDAL_txt2" /> </td>
							<td></td>
							<td>
								<input name="SCTDAL_txt3" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" onchange="getSumTotalAmount(this)" disabled id="SCTDAL_txt3" /> 
								<input name="SCTDAL_txt4" type="hidden" maxlength="11" class="input2" style="width:75px; text-align:right" disabled id="SCTDAL_txt4" />
							</td>
						</tr>
						<tr id='SCTLAL_01'>
							<th><input name="SCTLAL_chk" type="checkbox" onClick='setCheckedForm(this)' class="trans">&nbsp;TOLL</th>
							<td></td>
							<td><input name="SCTLAL_txt" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" onchange="getSumTotalAmount(this)" disabled id="SCTLAL_txt" /> </td>
							<td></td>
							<td><input name="SCTLAL_txt2" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" disabled id="SCTLAL_txt2" /> </td>
							<td></td>
							<td>
								<input name="SCTLAL_txt3" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" onchange="getSumTotalAmount(this)" disabled id="SCTLAL_txt3" /> 
								<input name="SCTLAL_txt4" type="hidden" maxlength="11" class="input2" style="width:75px; text-align:right" disabled id="SCTLAL_txt4" />
							</td>
						</tr>
						<tr id='SCWTAL_01'>
							<th><input name="SCWTAL_chk" type="checkbox" onClick='setCheckedForm(this)' class="trans">&nbsp;WAITNG</th>
							<td></td>
							<td><input name="SCWTAL_txt" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" onchange="getSumTotalAmount(this)" disabled id="SCWTAL_txt" /> </td>
							<td></td>
							<td><input name="SCWTAL_txt2" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" disabled id="SCWTAL_txt2" /> </td>
							<td></td>
							<td>
								<input name="SCWTAL_txt3" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" onchange="getSumTotalAmount(this)" disabled id="SCWTAL_txt3" /> 
								<input name="SCWTAL_txt4" type="hidden" maxlength="11" class="input2" style="width:75px; text-align:right" disabled id="SCWTAL_txt4" />
							</td>
						</tr>
						<tr id='SCENAL_01'>
							<th><input name="SCENAL_chk" type="checkbox" onClick='setCheckedForm(this)' class="trans">&nbsp;ENSF</th>
							<td></td>
							<td><input name="SCENAL_txt" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" onchange="getSumTotalAmount(this)" disabled id="SCENAL_txt" /> </td>
							<td></td>
							<td><input name="SCENAL_txt2" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" disabled id="SCENAL_txt2" /> </td>
							<td></td>
							<td>
								<input name="SCENAL_txt3" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" onchange="getSumTotalAmount(this)" disabled id="SCENAL_txt3" /> 
								<input name="SCENAL_txt4" type="hidden" maxlength="11" class="input2" style="width:75px; text-align:right" disabled id="SCENAL_txt4" />
							</td>
						</tr>
						<tr id='SCOTAL_01'>
							<th valign="top"><input name="SCOTAL_chk" type="checkbox" onClick='setCheckedForm(this)' class="trans">&nbsp;OTHER</th>
							<td></td>
							<td valign="top"><input name="SCOTAL_txt" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" onchange="getSumTotalAmount(this)" disabled id="SCOTAL_txt" /> </td>
							<td></td>
							<td colspan="3">
								<script type="text/javascript">ComSheetObject('sheet4');</script>
								<!-- 
								<input name="SCOTAL_txt3" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" onchange="getSumTotalAmount(this)" disabled id="SCOTAL_txt3" /> 
								<input name="SCOTAL_txt4" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" disabled id="SCOTAL_txt4" />
								-->
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		
		<!-- layout_vertical_2(S) -->
		<div class="layout_vertical_2" style="width: 440px;">
			<div class="opus_design_inquiry wFit" >
				<table >
					<colgroup>				            
						<col width="140">
						<col width="100">
						<col width="40">
						<col width="*">
					</colgroup>
					<tbody>
						<tr>
							<th colspan="4" style="text-align:center;">Supplemental Information<hr></th>
						</tr>
						<tr id='SCALAL_02' height="29px">
							<td></td>
							<td></td>
						</tr>
						<tr id='SCLWAL_02'  height="29px">
							<td></td>
							<td></td>
						</tr>
						<tr id='SCCDAL_02'>
							<th>Chassis No.</th>
							<td><input name="chss_no" type="text" maxlength="11" class="input2" style="width:100px;" dataformat="engup" disabled id="chss_no" /> </td>
							<th>Incurred Date</th>
							<td>
								<input name="incur_dt" type="text" class="input2" style="width:100px;" onblur="checkIncurredDate(this)" disabled maxlength="8" id="incur_dt" /><!-- 
								--><button type="button" id="btns_calendar2" name="btns_calendar2" class="calendar ir"></button> 
							</td>
						</tr>
						<tr id='SCDPAL_02' height="29px">
							<td></td>
							<td></td>
						</tr>
					</tbody>
				</table>
				<table >
					<colgroup>				            
						<col width="140">
						<col width="50">
						<col width="50">
						<col width="*">
					</colgroup>
					<tbody>
						<tr id='SCDRAL_02' height="29px">
							<th>Reliable Party</th>
							<td><input type="radio" class="trans" name='reliable_party' id='reliable_party' value='CO' disabled>&nbsp;NYK</td>
							<td></td>
							<td><input type="radio" class="trans" name='reliable_party' id='reliable_party' value='CS' disabled>&nbsp;Customer</td>
						</tr>
						<tr id='SCFRAL_02'  height="29px">
							<td></td>
							<td></td>
						</tr>
					</tbody>
				</table>
				<table>
					<colgroup>				            
						<col width="140">
						<col width="*">
					</colgroup>
					<tbody>
						<tr id='SCFIAL_02'>
							<th>Cause </th>
							<td><input name="cause" id="cause" type="text" class="input2" style="width:100%;" disabled></td>
						</tr>
						<tr id='SCFGAL_02' height="29px">
							<th>Cost</th>
							<td>
								<input type="radio" class="trans" name='cost_rdo'  id='cost_rdo' value='FE' disabled>&nbsp;FUMGTE + Extra Drayage&nbsp;&nbsp;
								<input type="radio" class="trans" name='cost_rdo' id='cost_rdo' value='ED' disabled>&nbsp;Drayage Only </td>
						</tr>
						<tr id='SCGNAL_02' height="29px">
							<th>Gen-Set Type / Size </th>
							<td>
								<%=getset_tp_sz%>
							</td>
						</tr>
						<tr id='SCLWAL_02'  height="26px">
							<td></td>
							<td></td>
						</tr>
					</tbody>
				</table>
				<table >
					<colgroup>				            
						<col width="140">
						<col width="80">
						<col width="50">
						<col width="*">
					</colgroup>
					<tbody>
						<tr height="29px">
						<td></td>
							<td id='SCINAL_02'>
								<input type="radio" class="trans" name='reefer_rdo' id='reefer_rdo' value='RP' disabled>&nbsp;Reefer PTI 
							</td>
							<td></td>
							<td>
								<input type="radio" class="trans" name='reefer_rdo' id='reefer_rdo' value='CS' disabled>&nbsp;Customs 
							</td>
						</tr>
					</tbody>
				</table>
				<table>
					<colgroup>				            
						<col width="140">
						<col width="200">
						<col width="40">
						<col width="*">
					</colgroup>
					<tbody>
						<tr id='SCLFAL_02'>
							<th>Number Of Lifting </th>
							<td><input name="number_lifting" id="number_lifting" type="text" class="input2" style="width:100px;" maxlength="5" dataformat="num" disabled>Lift(s)</td>
							<th>Cause </th>
							<td><input name="number_cause" id="number_cause" type="text" class="input2" style="width:100%;" disabled></td>
						</tr>
						<tr id='SCMDAL_02'>
							<th>Stop Location </th>
							<td>
								<input name="stop_loc" id="stop_loc" type="text" class="input2" style="width:100px;" name='stop_loc' onBlur='getComboList(this)' onKeyup='enterCheck(this)' maxlength=5 disabled><!-- 
								 --><script type="text/javascript">ComComboObject('stop_yard', 1, 60, 0);</script><!--
								 --><button class="input_seach_btn" type="button"  name="btns_stop_loc" id="btns_stop_loc"></button>
							</td>
						</tr>
						<tr id='SCOSAL_02' height="29px">
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
					</tbody>
				</table>
				<table>
					<colgroup>				            
						<col width="140">
						<col width="*">
					</colgroup>
					<tbody>
						<tr id='SCOWAL_02'>
							<th>Gross Weight </th>
							<td>
								<input name="gross_weight" id="gross_weight" type="text" class="input2" style="width:100px;" maxlength="15" dataformat="num" disabled> Ibs
							</td>
						</tr>
					</tbody>
				</table>
				<table >
					<colgroup>				            
						<col width="140">
						<col width="*">
					</colgroup>
					<tbody>
						<tr id='SCPPAL_02'>
							<th>Incurred Date </th>
							<td>
								<input name="incurred_date" id="incurred_date" type="text" class="input2" style="width:100px;" onBlur='checkIncurredDate(this)' maxlength="8" dataformat="num" disabled><!--
								--><button type="button"  name="btns_calendar" id="btns_calendar" class="calendar ir"></button>
							</td>
						</tr>
						<tr id='SCRCAL_02' height="29px">
							<td></td>
							<td></td>
						</tr>
					</tbody>
				</table>
				<table >
					<colgroup>				            
						<col width="140">
						<col width="*">
					</colgroup>
					<tbody>
						<tr id='SCSSAL_02'>
							<th>Scale Stop Place </th>
							<td>
								<input name="scale_loc" id="scale_loc"  type="text" class="input2" style="width:100px;"  onBlur='getComboList(this)'  maxlength=5 disabled><!--
								--><script type="text/javascript">ComComboObject('scale_yard', 1, 60, 0);</script><!--
								--><button class="input_seach_btn" type="button"  name="btns_scale_loc" id="btns_scale_loc"></button>
							</td>
						</tr>
						<tr id='SCSRAL_02'>
							<td></td>
							<td><input name="days" id="days" type="text" class="input2" style="width:100px;" dataformat="num" maxlength="5" disabled>Day (s)  </td>
						</tr>
					</tbody>
				</table>
				<table >
					<colgroup>				            
						<col width="140">
						<col width="*">
					</colgroup>
					<tbody>
						<tr  id='SCSTAL_02'>
							<th>Outbound Booking No. </th>
							<td><input name="outbound_booking_no" id="outbound_booking_no" type="text" class="input2" style="width:100%;" dataformat="engup" maxlength="13" disabled></td>
						</tr>
						<tr  id='SCSNAL_02' height="29px">
							<td></td>
							<td></td>
						</tr>
						<tr  id='SCSFAL_02' height="29px">
							<td></td>
							<td></td>
						</tr>
						<tr  id='SCTDAL_02' height="29px">
							<td></td>
							<td></td>
						</tr>
						<tr  id='SCTLAL_02' height="29px">
							<td></td>
							<td></td>
						</tr>
					</tbody>
				</table>
				<table >
					<colgroup>				            
						<col width="140">
						<col width="*">
					</colgroup>
					<tbody>
						<tr id='SCWTAL_02'>
							<th>Waiting Hour </th>
							<td><input name="waiting_hour" id="waiting_hour" type="text" class="input2" style="width:100px;" maxlength="6" dataformat="pointnum" pointcount="1" disabled>Hour (s) </td>
						</tr>
						<tr  id='SCTLAL_02' height="29px">
							<td></td>
							<td></td>
						</tr>
						<tr id='SCOTAL_02'>
							<th>Remarks</th>
							<td><input name="remarks" id="remarks" type="text" class="input2" style="width:100%;" disabled></td>
						</tr>
					</tbody>
				</table>
			</div>
			<!-- opus_design_inquiry(E) -->
		</div>
		
		<table class="line_bluedot"><tr><td colspan="4"></td></tr></table>
		
		<table style="width: 700px">
			<colgroup>				            
				<col width="150">
				<col width="10">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th align="right" class="trans" style="padding-right: 5px">Additional</th>
					<td></td>
					<td><input name="surcharge_add" id="surcharge_add" type="text" maxlength=13 class="input2" style="width:75px; text-align:right" disabled></td>
				</tr>
				<tr>
					<th align="right" class="trans" style="padding-right: 5px"><input name="<%=fuel_scg_cd%>_chk" type="checkbox" onClick='setCheckedForm(this)' class="trans" disabled="disabled">&nbsp;FUEL</th>
					<td></td>
					<td><input name="<%=fuel_scg_cd%>_txt" type="text" maxlength="11" class="input2" style="width:75px; text-align:right" onchange="getSumTotalAmount(this)" disabled id="<%=fuel_scg_cd%>_txt" /></td>
				</tr>
				<tr>
					<th align="right" class="trans" style="padding-right: 5px">Surcharge Total Amount</th>
					<td></td>
					<td><input name="surcharge_total" id="surcharge_total" type="text" maxlength=13 class="input2" style="width:75px; text-align:right" disabled></td>
				</tr>
			</tbody>
		</table>
		
	</div>
</div>
<!-- wrap_result(S) -->
<div class="wrap_result" style="display: none;">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="mainTable" >
		 <script type="text/javascript">ComSheetObject('sheet1');</script>
		 <script type="text/javascript">ComSheetObject('sheet2');</script>
 		 <script type="text/javascript">ComSheetObject('sheet3');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</div>
<!-- wrap_result(E) -->
</form>