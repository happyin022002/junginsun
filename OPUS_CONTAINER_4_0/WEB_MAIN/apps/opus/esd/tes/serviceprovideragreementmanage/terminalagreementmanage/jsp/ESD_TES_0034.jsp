<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESD_TES_0034.js
*@FileTitle  : AGMT Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/23
=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.event.EsdTes0034Event"%>
<%
	EsdTes0034Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;

	String strErrMsg			= "";
	int rowCount	 			= 0;

	String userId				= "";
	String ofc_cd				= "";

	String tml_agmt_crr_flg 	= "";
	String tml_agmt_ofc_cty_cd 	= "";
	String tml_agmt_ver_no 		= "";

	String yd_cd 				= "";
	String yd_cd_name 			= "";
	String vndr_seq 			= "";
	String vndr_seq_name 		= "";
	String eff_fm_dt 			= "";
	String eff_to_dt 			= "";
	String auto_xtd_flg 		= "";
	String ctrt_ofc_cd 			= "";
	String cre_usr_id 			= "";
	String cre_dt 				= "";
	String upd_usr_id 			= "";
	String upd_dt 				= "";
	String inquiryFlg 			= "";

	String referer = JSPUtil.getNull(request.getHeader("REFERER"));

	if(referer.equals("ESD_TES_0039.do"))
	{
 		tml_agmt_crr_flg  = "Y";
	}

	tml_agmt_ofc_cty_cd	= JSPUtil.getParameter(request, "tml_agmt_ofc_cty_cd".trim(), "");
	tml_agmt_ver_no		= JSPUtil.getParameter(request, "tml_agmt_ver_no 	".trim(), "");
	inquiryFlg			= JSPUtil.getParameter(request, "inquiryFlg 		".trim(), "");
	yd_cd				= JSPUtil.getParameter(request, "yd_cd 				".trim(), "");
	yd_cd_name			= JSPUtil.getParameter(request, "yd_cd_name         ".trim(), "");
	vndr_seq			= JSPUtil.getParameter(request, "vndr_seq 			".trim(), "");
	vndr_seq_name		= JSPUtil.getParameter(request, "vndr_seq_name      ".trim(), "");
	eff_fm_dt			= JSPUtil.getParameter(request, "eff_fm_dt 		    ".trim(), "");
	eff_to_dt			= JSPUtil.getParameter(request, "eff_to_dt 		    ".trim(), "");
	auto_xtd_flg		= JSPUtil.getParameter(request, "auto_xtd_flg 	    ".trim(), "");
	ctrt_ofc_cd			= JSPUtil.getParameter(request, "ctrt_ofc_cd 	    ".trim(), "");
	cre_usr_id			= JSPUtil.getParameter(request, "cre_usr_id 		".trim(), "");
	cre_dt				= JSPUtil.getParameter(request, "cre_dt 			".trim(), "");
	upd_usr_id			= JSPUtil.getParameter(request, "upd_usr_id 		".trim(), "");
	upd_dt				= JSPUtil.getParameter(request, "upd_dt 			".trim(), "");

	try {

		SignOnUserAccount account	= (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		userId	= account.getUsr_id();
		ofc_cd	= account.getOfc_cd();

		event = (EsdTes0034Event)request.getAttribute("Event");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
		} // end else
	}catch(Exception e) {
		out.println(e.toString());
	}

	String actionVolUOMBox 	= JSPUtil.getCodeCombo("tml_agmt_vol_ut_cd", "01", "onChange='selectVolUOM();'", "CD00177", 0, "1::");
	String actionBoundBox 	= JSPUtil.getCodeCombo("io_bnd_cd", "01", "", "CD00890", 0, "1::");
	String actionIOBox 		= JSPUtil.getCodeCombo("ioc_cd", "01", "", "CD00887", 0, "1::");
	String srAgmtTypeBox 	= JSPUtil.getCodeCombo("tml_sto_agmt_tp_cd", "01", "", "CD00169", 0, "");
	//System.out.println("srAgmtTypeBox>>>"+srAgmtTypeBox);
%>


<script type="text/javascript">
	<%= JSPUtil.getIBCodeCombo("vol_ut_cd", "01", "CD00177", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("io_bnd_cd", "01", "CD00890", 0, "1::")%>
	<%= JSPUtil.getIBCodeCombo("ioc_cd", "01", "CD00887", 0, "1::")%>
	<%= JSPUtil.getIBCodeCombo("thc_tp_cd", "01", "CD00161", 2, "1::")%>
	<%= JSPUtil.getIBCodeCombo("tml_sto_agmt_tp_cd_cd", "01", "CD00169", 0, "")%>
	var agmt_no = '<%=JSPUtil.getNull(tml_agmt_ofc_cty_cd)%>';
	var agmt_ver_no = '<%=JSPUtil.getNull(tml_agmt_ver_no)%>';

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		initFormValue();
		initFormDisabled();
		loadPage();

	<%if(!tml_agmt_ofc_cty_cd.equals("") && !tml_agmt_ver_no.equals("")){%>
	//		detailRetrieve('<%=tml_agmt_ofc_cty_cd%>','<%=tml_agmt_ver_no%>');
	<%}%>
	}
</script>



<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="loop_value" id="loop_value" />
<input type="hidden" name="tml_agmt_tp_cd" id="tml_agmt_tp_cd" />
<input type="hidden" name="lgs_cost_cd" id="lgs_cost_cd" />
<input type="hidden" name="tml_agmt_vol_ut_cd" id="tml_agmt_vol_ut_cd" />
<input type="hidden" name="io_bnd_cd" id="io_bnd_cd" />
<input type="hidden" name="curr_cd" id="curr_cd" />
<input type="hidden" name="select_tab" id="select_tab" />
<input type="hidden" name="sheet_prefix" id="sheet_prefix" />
<input type="hidden" name="regAgmtFlg" id="regAgmtFlg" />
<input type="hidden" name="regAgmtHDRFlg" id="regAgmtHDRFlg" />
<input type="hidden" name="initFormDTLFlg" id="initFormDTLFlg" />
<input type="hidden" name="agmtHDRCreAdjFlg" id="agmtHDRCreAdjFlg" />
<input type="hidden" name="command_h" id="command_h" />
<input type="hidden" name="is_valid_yd_cd" id="is_valid_yd_cd" />
<input type="hidden" name="yd_cd_hidden" id="yd_cd_hidden" />
<input type="hidden" name="yd_cd_deltflg" id="yd_cd_deltflg" />
<input type="hidden" name="is_valid_vndr_seq" id="is_valid_vndr_seq" />
<input type="hidden" name="vndr_seq_hidden" id="vndr_seq_hidden" />
<input type="hidden" name="input_list_verify_flg" id="input_list_verify_flg" />
<input type="hidden" name="thrpFlg" id="thrpFlg" />
<input type="hidden" name="vfsArray" id="vfsArray" />
<input type="hidden" name="fileImportFlg" id="fileImportFlg" />
<input type="hidden" name="lane_cdString" id="lane_cdString" />
<input type="hidden" name="copy_tml_agmt_ofc_cty_cd" id="copy_tml_agmt_ofc_cty_cd" />
<input type="hidden" name="agmt_confirm_flg" id="agmt_confirm_flg" />
<input type="hidden" name="cre_usr_id"id="cre_usr_id" value="<%=userId%>" class="not">
<input type="hidden" name="upd_usr_id" id="upd_usr_id" value="<%=userId%>" class="not">
<input type="hidden" name="inquiryFlg" id="inquiryFlg" value="<%=inquiryFlg%>" class="not">
<input type="hidden" name="pop_cost_cd" id="pop_cost_cd" />
<input type="hidden" name="pop_sheetObj" id="pop_sheetObj" />
<input type="hidden" name="pop_row" id="pop_row" />
<input type="hidden" name="pop_agmt_rmk" id="pop_agmt_rmk" />
<input type="hidden" name="pop_mode" id="pop_mode" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
		--><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!--
		--><button type="button" class="btn_normal" name="btn_delete" id="btn_delete">Delete</button><!--
		--><button type="button" class="btn_normal" name="btn_volcaam" id="btn_volcaam">Vol.Acc.M</button>
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->
<!-- opus_design_inquiry(S) -->
<div class="wrap_search_tab">
	<div class="opus_design_inquiry ">
			<table class="wFit">
				<tbody>
					<colgroup>
						<col width="100px"/>
						<col width="270px"/>
						<col width="120px"/>
						<col width="250px"/>
						<col width="120px"/>												
						<col width="*"/>
				    </colgroup>
					<tr class="h23">
						<th>Agreement No.</th>
						<td><input type="text" name="tml_agmt_ofc_cty_cd" id="tml_agmt_ofc_cty_cd" maxlength="8" style="width:200px" class="input1" value="" onKeyUp='isApNum2(this);' onKeyDown='chkInput(this);' readOnly></td>
						<th>Agreement Version</th>
						<td><input type="text" name="tml_agmt_ver_no" id="tml_agmt_ver_no" style="width:180px" class="input1" readOnly></td>
						<th>Version Status</th>
						<td><input type="text" name="tml_agmt_sts_cd" id="tml_agmt_sts_cd" style="width:70px" class="input2" readOnly></td>						
					</tr>
				</tbody>
			</table>			

       <div class="line_bluedot"></div>
  
			<table class="wFit">
				<tbody>
					<colgroup>
						<col width="100px"/>
						<col width="330px"/>
						<col width="120px"/>
						<col width="80px"/>
						<col width="140px"/>
						<col width="*"/>
				    </colgroup>
					<tr>
						<th>Yard</th>
						<td><!-- 
						--><input class="input1" type="text" name="yd_cd" value="" maxlength="7" style="width:70px;" onkeyup="isApNum2(this);" onkeydown="chkInput(this);" onblur="getYardName();" id="yd_cd" /><!-- 
						--><button type="button" class="input_seach_btn" name="btn_yard" id="btn_yard"></button><!-- 
						--><input class="input1" type="text" name="yd_cd_name" style="width:203px;" readonly id="yd_cd_name" /><!-- 
						--></td>
						<th>Service Provider</th>
						<td colspan="3"><input class="input1" type="text" name="vndr_seq" value="" maxlength="6" style="width:80px;" onkeyup="isNum(this);" onkeydown="chkInput(this);" onblur="validateVendorCode();" id="vndr_seq" /><!-- 
						--><button type="button" class="input_seach_btn" name="btn_vndr" id="btn_vndr"></button><!-- 
						--><input class="input1" type="text" name="vndr_seq_name" style="width:201px;" readonly id="vndr_seq_name" /><!-- 
						--></td>
					</tr>
					<tr>
						<th>Contract Office</th>
						<td><input class="input1" type="text" name="ctrt_ofc_cd" id="ctrt_ofc_cd" value="<%=ofc_cd%>" maxlength="6" style="width:92px" onKeyUp='isApNum2(this);' onKeyDown='chkInput(this);' readOnly></td>
						<th>Creation Office</th>
						<td><input class="input1" type="text" name="cre_ofc_cd"  id="cre_ofc_cd" value="<%=ofc_cd%>" maxlength="6" style="width:92px" readonly></td>
						<th>Effective Date </th>
						<td><!-- 
						--><input class="input1" type="text" style="width:80px" name="eff_fm_dt" id="eff_fm_dt" value="" maxlength="10" onKeyUp='isNum1(this);tes_isNumD(this,"Y");tes_moveFocus(this, this.form.eff_to_dt, 10);' onKeyDown='chkInput(this);'><!-- 
						--><button type="button" class="calendar ir" name="btns_calendar1" id="btns_calendar1"></button><!-- 
						-->~&nbsp;<input class="input1" type="text" style="width:80px" name="eff_to_dt" id="eff_to_dt" value="" maxlength="10" onKeyUp='isNum1(this);tes_isNumD(this,"Y");' onKeyDown='chkInput(this);' onBlur='validateDateObj(this);'><!-- 
						--><button type="button" class="calendar ir" name="btns_calendar2" id="btns_calendar2"></button><!-- 
						--></td>
					</tr>
					
					<tr>
						<th>Auto Extention</th>
						<td class="sm"><!-- 
						--><input type="radio" name="auto_xtd_flg" id="auto_xtd_flg" value="Y" > Yes    <!-- 
						--><input type="radio" name="auto_xtd_flg" id="auto_xtd_flg" value="N" > No
						</td>
						<th>Amend</th>
						<td><!-- 
						--><input type="radio" name="amend_flg" id="amend_flg" value="Y" class="trans" disabled> Yes  <!-- 
						--><input type="radio" name="amend_flg" id="amend_flg" value="N" class="trans" disabled> No <!-- 
						--></td>
						<th>Remark</th>
						<td><input type="text" name="agmt_rmk" id="agmt_rmk" style="width:245px" value="" ></td>
					</tr>
				</tbody>
			</table>

	</div>
</div>
<!-- opus_design_inquiry(E) -->

<div class="wrap_result">
	<!-- opus_tab_btn(S) -->
	<div class="opus_design_tab sm">
		<script type="text/javascript">ComTabObject('tab1')</script>
	</div>
	<!-- opus_tab_btn(E) -->
	<div id="tabLayer" style="display:inline">
		<!-- opus_design_inquiry(S) -->
			<div class="opus_design_inquiry">
				<div class="opus_design_data" >
					<table  style="width:930px">
						<tbody>
							<colgroup>
								<col width="90px"/>
								<col width="150px"/>
								<col width="80px"/>
								<col width="150px"/>
								<col width="80px"/>
								<col width="150px"/>								
								<col width="*"/>
							</colgroup>
							<tr class="h23">
								<th>Cost Code</td>
								<td><script type="text/javascript">ComComboObject('lgs_cost_cd_t',1, 90 , 0)</script></td>
								<th>F/M</td>
								<td>
										<select name="tml_cntr_sty_cd" id="tml_cntr_sty_cd">
											<option value=""></option>
											<option value="S">Same</option>
											<option value="F">F</option>
											<option value="M">M</option>
										</select>								
								</td>								
								<th>Auto Calc.</th>
								<td><!-- 
								--><input type="radio" name="auto_calc_flg" id="auto_calc_flg" value="Y" class="trans" disabled>Yes<!-- 
								--><input type="radio" name="auto_calc_flg" id="auto_calc_flg" value="N" class="trans" disabled>No</td>
								<td><!-- 
								--><div class="opus_design_btn"><!-- 
								--><button type="button" class="btn_etc" name="t1btng_registertpcc" 	id="t1btng_registertpcc">Register TP CC</button><!-- 
								--><button type="button" class="btn_etc" name="t1btng_save" 	id="t1btng_save">Save</button>
									</div><!-- 
								--></td>
							</tr>
							<tr>
								<th>Vol. UOM</th>
								<td><%=actionVolUOMBox%></td>
								<th>Currency</th>
								<td colspan="4"><script type="text/javascript">ComComboObject('curr_cd_t',1, 90 , 0 )</script></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>

	<!-- opus_design_inquiry(E) -->

    <!-- layout_wrap(S) -->
		<div class="opus_design_inquiry wFit">
			<div class="layout_wrap">
				<div class="layout_vertical_2" style="width:35%;overflow:hidden">
					   <!-- opus_design_inquiry(S) -->
						<div class="opus_design_data sm mar_top_8 mar_btm_8 mar_rgt_8" style="height:340px">
							<table>
								<tbody>
									<colgroup>
										<col width="90px"/>
										<col width="*"/>
									</colgroup>
									<tr class="h23">
										<th>Bound</th>
										<td><%=actionBoundBox%></td>
									</tr>
									<tr class="h23">
										<th>IPC/Ocean</th>
										<td><%=actionIOBox%></td>
									</tr>	
									</tbody></table>						
									
							<div id="modeLayer" style="display:inline">
								<table>
									<tbody>
										<colgroup>
											<col width="90px"/>
											<col width="*"/>
										</colgroup>
										<tr class="h23">	 		
											<th>Mode</th>
											<td>
												<select name=""><option value="" selected>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option></select>
											</td>
										<tr>
									</tbody>
								</table>
							</div>	
							<div id="modeLayer" style="display:none">
								<table>
									<tbody>
										<colgroup>
											<col width="90px"/>
											<col width="*"/>
										</colgroup>	
										<tr class="h23">						
											<th>Mode</th>
											<td>
												<select name="tml_trns_mod_cd" id="tml_trns_mod_cd">
													<option value=""></option>
													<option value="S">Same</option>
													<option value="T">Truck</option>
													<option value="R">Rail</option>
													<option value="B">Barge</option>
													<option value="F">Feeder</option>
													<option value="V">Mother</option>
													<option value="O">Other</option>
												</select>
											</td>	
										</tr>
									</tbody>
								</table>			
							</div>
							<div id="modeLayer" style="display:none">
								<table class="search" border="0">
								<tr class="h23">
									<td width="81"  valign="middle">Mode</td>
									<td colspan="2"><select name="tml_trns_mod_cd">
									<option value=""></option>
									<option value="S">Same</option>
									<option value="T">Truck</option>
									<option value="R">Rail</option>
									<option value="B">Barge</option>
									<option value="F">Feeder</option>
									<option value="V">Mother</option>
									<option value="O">Other</option>
									</select></td>
								</tr>
								</table>
							</div>								
						<table  class="sm">
							<tbody>
								<colgroup>
									<col width="90px"/>
									<col width="*"/>
								</colgroup>
								<tr>
									<th rowspan="2">Applied Date</th>
									<td><input name="tml_dy_aply_tp_cd"id="tml_dy_aply_tp_cd" type="radio" value="S" class="trans" onclick="javascript:selectAplySame();"> <b>Same</b><br><input type="radio" name="tml_dy_aply_tp_cd" value="P" class="trans" onclick="javascript:selectAplySep();"> <b>Separate</b></td>
								</tr>
								<tr>
									<td><input type="checkbox" name="wkdy_flg" id="wkdy_flg" value="Y" class="trans"><b>WD</b>&nbsp;
										<input type="checkbox" name="sat_flg" id="sat_flg" value="Y" class="trans"><b>SA</b>&nbsp;
										<input type="checkbox" name="sun_flg" id="sun_flg" value="Y" class="trans"><b>SU</b>&nbsp;
										<input type="checkbox" name="hol_flg" id="hol_flg" value="Y" class="trans"><b>HO</b></td>
								</tr>
							</tbody>
						 </table>
						 
						 <table>
							<tbody>
								<colgroup>
									<col width="80px"/>
									<col width="100px"/>
									<col width="80px"/>
									<col width="*"/>
								</colgroup>
								<tr class="h23">
									<th>Lane</th>
									<td><script type="text/javascript">ComComboObject('lane_cd',1, 90 , 0 )</script></td>
									<th>Sub Trade</th>
									<td>
									<select name="sub_trd_cd" width="">
									<option value=""></option>
									<option value="S">Same</option>
									<option value="O">Other</option>
									</select>
									</td>									
								</tr>
							</tbody>
						 </table>
						
						 <table  class="sm">
							<tbody>
								<colgroup>
									<col width="90px"/>
									<col width="*"/>
								</colgroup>
								<tr>
									<th rowspan="2">DG Class</th>
									<td><input type="radio" name="dcgo_aply_tp_cd" id="dcgo_aply_tp_cd" value="N" class="trans" onclick="javascript:selectDGNone('');"><b>None</b><br>
										<input type="radio" name="dcgo_aply_tp_cd" id="dcgo_aply_tp_cd" value="A" class="trans" onclick="javascript:selectDGSame('');"><b>Same</b> &nbsp;&nbsp;&nbsp;&nbsp;<font style="font-size: 9px;"><input type="radio" name="dcgo_same" value="Y" class="trans" disabled onclick="javascript:same_dg('')">DG&nbsp;&nbsp;<input type="radio" name="dcgo_same" value="N" class="trans" disabled onclick="javascript:same_nodg('')">NODG</font><br>
										<input type="radio" name="dcgo_aply_tp_cd" id="dcgo_aply_tp_cd" value="S" class="trans" onclick="javascript:selectDGSep('');"><b>Separate</b>
									</td>
								</tr>
								<tr>
									<td><input type="checkbox" name="dcgo_n1st_clss_flg" id="dcgo_n1st_clss_flg" value="Y" class="trans"><b>1</b>&nbsp;
									<input type="checkbox" name="dcgo_n2nd_clss_flg" id="dcgo_n2nd_clss_flg" value="Y" class="trans"><b>2</b>&nbsp;
									<input type="checkbox" name="dcgo_n3rd_clss_flg" id="dcgo_n3rd_clss_flg" value="Y" class="trans"><b>3</b>&nbsp;
									<input type="checkbox" name="dcgo_n4th_clss_flg" id="dcgo_n4th_clss_flg" value="Y" class="trans"><b>4</b>&nbsp;
									<input type="checkbox" name="dcgo_n5th_clss_flg" id="dcgo_n5th_clss_flg" value="Y" class="trans"><b>5</b><br>
									<input type="checkbox" name="dcgo_n6th_clss_flg" id="dcgo_n6th_clss_flg" value="Y" class="trans"><b>6</b>&nbsp;
									<input type="checkbox" name="dcgo_n7th_clss_flg" id="dcgo_n7th_clss_flg" value="Y" class="trans"><b>7</b>&nbsp;
									<input type="checkbox" name="dcgo_n8th_clss_flg" id="dcgo_n8th_clss_flg" value="Y" class="trans"><b>8</b>&nbsp;
									<input type="checkbox" name="dcgo_n9th_clss_flg" id="dcgo_n9th_clss_flg" value="Y" class="trans"><b>9</b>&nbsp;
									<input type="checkbox" name="dcgo_none_clss_flg" id="dcgo_none_clss_flg" value="Y" class="trans"><b>No</b></td>
								</tr>
							</tbody>
						 </table>
						</div>
					</div>  
					<div class="layout_vertical_2" style="width:35%;overflow:hidden">
					   <!-- opus_design_grid(S) -->
						 <div class="opus_design_data sm mar_top_8 mar_btm_8 mar_rgt_8" style="height:340px">
						<div class="opus_design_grid">
							<table>
								<tbody>
									<colgroup>
										<col width="1px"/>
										<col width="25px"/>
										<col width="*"/>
									</colgroup>
									<tr class="h23">
										<th>No of Volume Tier</th>
										<td><input name="cnt1" id="cnt1" type="text" style="text-align:center;width:25px" class="input"  value="1"></td>
										<td><div class="opus_design_btn">
											<button type="button" class="btn_normal" name="t1btng_retreive1" 	id="t1btng_retreive1">Add</button>
											</div>
										</td>
									</tr>
								</tbody>
							</table>
							<script type="text/javascript">ComSheetObject('t1sheet1');</script>
						</div>
					  <!-- opus_design_grid(E) -->
					  
					   <!-- opus_design_grid(S) -->
						<div class="opus_design_grid" style="display:none;">
							<table>
								<tbody>
									<colgroup>
										<col width="1px"/>
										<col width="25px"/>
										<col width="*"/>
									</colgroup>
									<tr class="h23">
										<th>No of Overtime Shift</th>
										<td><input name="cnt2"  id="cnt2" type="text" style="text-align:center;width:25px" class="input"  value="3"></td>
										<td><div class="opus_design_btn">
											<button type="button" class="btn_normal" name="t1btng_retreive2" 	id="t1btng_retreive2">Search2</button>
											</div> </td>
									</tr>
								</tbody>
							</table>
							<script type="text/javascript">ComSheetObject('t1sheet2');</script>
						</div>
					  <!-- opus_design_grid(E) -->
					</div>
					</div>
					
					
					<div class="layout_vertical_2" style="width:30%;overflow:hidden">
					 <!-- opus_design_inquiry(S) -->
					   <div class="opus_design_data sm mar_top_8 mar_btm_8 mar_rgt_8" style="height:340px">
					        <h3 id="tr_title1" class="title_design">Terminal Handling Charge</h3>
							<table>
								<tbody>
									<colgroup>
										<col width="100px"/>
										<col width="50px"/>
										<col width="50px"/>
										<col width="*"/>
									</colgroup>

									<tr class="sm">
										<td colspan="4">
											<input type="radio" name="thc_tp_cd" id="thc_tp_cd" value="T" class="trans" onClick="checkTHC(1)"><b>Throughput(Both)</b><br>
											<input type="radio" name="thc_tp_cd_flg" id="thc_tp_cd_flg" value="S" class="trans" onClick="checkTHC(2)">&nbsp;<b>Separate</b>
											<input type="radio" name="thc_tp_cd" id="thc_tp_cd" value="G" class="trans">Gate I/O
											<input type="radio" name="thc_tp_cd" id="thc_tp_cd" value="L" class="trans">Lift On/Off</td>
									</tr>
									<tr>
										<td colspan="4"><h3 id="tr_title1" class="title_design">Same Rate Apply to</h3></td>
									</tr>
									<tr class="grid2">
											<th rowspan="3">CNTR<br>Type / Size</th>
											<td colspan="3">
												<input type="radio" name="cntr_ts" id="cntr_ts" value="A" class="trans" onclick="javascript:selectTSAll(0)">&nbsp;<b>All</b><br>
												<input type="radio" name="cntr_ts" id="cntr_ts" value="TS" class="trans" onclick="javascript:selectTS(0)">&nbsp;<b>By Type / Size</b></td>
									</tr>
									<tr class="grid2">
											<th>Type</th>
											<td colspan="2"><script type="text/javascript">ComComboObject('cntr_type_t',1, 90 , 0 )</script></td>
									</tr>
									<tr class="grid2">
											<th>Size</th>
											<td colspan="2"><script type="text/javascript">ComComboObject('cntr_size_t',1, 90 , 0 )</script></td>
									</tr>
									<tr style="height:40px">
											<th>Rate </th>
											<td colspan="3"><input id="agmt_rate" name="agmt_rate" type="text" style="text-align:center;width:70px;" " class="input" maxlength="18" onKeyUp='tes_isMon(this,"Y");' onKeyDown='chkInput(this); tes_isMon(this,"Y");' onBlur="tes_chkAmtFmtObj(this);"></td>
									</tr>
							</tbody>
						</table>
							<table>
								<tbody>
								<colgroup>
										<col width="300px"/>
										<col width="50px"/>
										<col width="*"/>
									</colgroup>
									<tr>
										<!-- Repeat Pattern -->
										<td> 
										<div class="opus_design_btn">
												<button type="button" class="btn_etc" name="t1btng_agmtcopy" 	id="t1btng_agmtcopy">AGMT Copy</button>
										</div></td>
										<td> 
										<div class="opus_design_btn">
											<button type="button" class="btn_etc" name="t1btng_new"  		id="t1btng_new">New</button>		
										</div></td>
										<td> 
										<div class="opus_design_btn">
												<button type="button" class="btn_etc" name="t1btng_apply" 		id="t1btng_apply">Apply</button>
										</div></td>
										<!-- Repeat Pattern -->
									</tr>
								</tbody>
							</table>
						</div>
					  <!-- opus_design_inquiry(E) -->
					</div>
				</div>
			<!-- layout_wrap(E) -->
			</div>
	</div>

	<div id="tabLayer" style="display:none">
		<div class="opus_design_grid">
			<div class="opus_design_btn">
				<button type="button" class="btn_normal" name="t2btng_new" 	id="t2btng_new">New</button>
				<button type="button" class="btn_normal" name="t2btng_rowadd" 	id="t2btng_rowadd">Row Add</button>
				<button type="button" class="btn_normal" name="t2btng_delete" 	id="t2btng_delete">Delete</button>
				<button type="button" class="btn_normal" name="t2btng_save" 	id="t2btng_save">Save</button>
				<button type="button" class="btn_normal" name="t2btng_downexcel" 	id="t2btng_downexcel">Down Excel</button>
				<button type="button" class="btn_normal" name="t2btng_loadexcel" 	id="t2btng_loadexcel">Load Excel</button>
				<button type="button" class="btn_normal" name="t2btng_verify" 	id="t2btng_verify">Verify</button>
				<button type="button" class="btn_normal" name="t2btng_registeragree" 	id="t2btng_registeragree">Register Agreement</button>
			</div>
			<script type="text/javascript">ComSheetObject('t2sheet1');</script>
		</div>
	</div>

<div id="tabLayer" style="display:none">
		<!-- opus_design_inquiry(S) -->

			<div class="opus_design_inquiry wFit">
				<div class="opus_design_data mar_top_8 mar_btm_8" style="width:700px">
			<table>
				<tbody>
					<colgroup>
						<col width="90px"/>
						<col width="140px"/>
						<col width="110px"/>
						<col width="200px"/>
						<col width="110px"/>
						<col width="60px"/>
						<col width="*"/>
			    	</colgroup>
					<tr class="h23">
						<th>Cost Code</th>
						<td><script type="text/javascript">ComComboObject('lgs_cost_cd_s',1, 90 , 0 )</script></td>
						<th>F/M</th>
						<td>
								<select name="sto_tml_cntr_sty_cd" id="sto_tml_cntr_sty_cd" style="width:90px">
									<option value=""></option>
									<option value="S">Same</option>
									<option value="F">F</option>
									<option value="M">M</option>
								</select>								
						</td>	
						<th>SR AGMT Type</th>
						<td><%=srAgmtTypeBox%></td>
						
						<td>
							<div class="opus_design_btn">
								<button type="button" class="btn_etc" name="t3btng_save" 	id="t3btng_save">Save</button>
							</div>	
						</td>
					</tr>
					<tr class="h23">
						<th>Commence Time</th>
						<td><input name="cmnc_hrmnt" id="cmnc_hrmnt" type="text" maxlength="5"  style="text-align:center;width:90px" class="input"  value="" onKeyUp='tes_cmnctime(this,"Y");' onKeyDown='chkInput(this);' onBlur="isValidHHMM(this)"></td>
		    			<th>Vol. UOM</th>
		    			<td><%=actionVolUOMBox%></td>
		    			<th>Currency</th>
			    		<td colspan="2"><script type="text/javascript">ComComboObject('curr_cd_s',1, 90 , 0 )</script></td>
		    		</tr>
				</tbody>
			</table>
		</div>
		</div>
	<!-- opus_design_inquiry(E) -->
	
<!-- layout_wrap(S) -->
		<div class="opus_design_inquiry wFit"  id="srLayer" style="display:inline">
			<div class="layout_wrap">
				<div class="layout_vertical_2" style="width:35%;overflow:hidden">
			   <!-- opus_design_inquiry(S) -->
				<div class="opus_design_data sm mar_top_8 mar_btm_8 mar_rgt_8" style="height:370px">		
					 <div>
						<table>
							<tbody>
							<colgroup>
								<col width="90px"/>
								<col width="*"/>
							</colgroup>
							<tr class="h23">
								<td colspan="2"><input type="radio" name="storage_gb"  id="storage_gb" value="FD" class="trans" onclick="freeDays();"><b>Free Days<b></td>
							</tr>
							<tr class="h23">
									<th>Bound</th>
									<td><%=actionBoundBox%></td>
								</tr>
							</tbody>
						</table>
						
						
						<table>
							<tbody>
							<colgroup>
								
								<col width="90px"/>
								<col width="*"/>
							</colgroup>
							<tr class="sm">
								<th rowspan="2">DG Class</th>
								<td>
									<input type="radio" name="dcgo_aply_tp_cd_FD" id="dcgo_aply_tp_cd_FD" value="N" class="trans" onclick="javascript:selectDGNone('_FD');"><b>None</b><br>
									<input type="radio" name="dcgo_aply_tp_cd_FD" id="dcgo_aply_tp_cd_FD" value="A" class="trans" onclick="javascript:selectDGSame('_FD');"><b>Same</b> &nbsp;&nbsp;&nbsp;&nbsp;
									<font style="font-size: 9px;"><input type="radio" name="dcgo_same_FD" id="dcgo_same_FD" value="Y" class="trans" disabled onclick="javascript:same_dg('_FD')">DG&nbsp;&nbsp;
									<input type="radio" name="dcgo_same_FD" id="dcgo_same_FD" value="N" class="trans" disabled onclick="javascript:same_nodg('_FD')">NODG</font><br>
									<input type="radio" name="dcgo_aply_tp_cd_FD" id="dcgo_aply_tp_cd_FD" value="S" class="trans" onclick="javascript:selectDGSep('_FD');"><b>Separate</b>
								</td>
							</tr>
							<tr class="sm">
									<td>
										<input type="checkbox" name="dcgo_n1st_clss_flg_FD" id="dcgo_n1st_clss_flg_FD" value="Y" class="trans"><b>1</b>&nbsp;
										<input type="checkbox" name="dcgo_n2nd_clss_flg_FD" id="dcgo_n2nd_clss_flg_FD" value="Y" class="trans"><b>2</b>&nbsp;
										<input type="checkbox" name="dcgo_n3rd_clss_flg_FD" id="dcgo_n3rd_clss_flg_FD" value="Y" class="trans"><b>3</b>&nbsp;
										<input type="checkbox" name="dcgo_n4th_clss_flg_FD" id="dcgo_n4th_clss_flg_FD" value="Y" class="trans"><b>4</b>&nbsp;
										<input type="checkbox" name="dcgo_n5th_clss_flg_FD" id="dcgo_n5th_clss_flg_FD" value="Y" class="trans"><b>5</b><br>
										<input type="checkbox" name="dcgo_n6th_clss_flg_FD" id="dcgo_n6th_clss_flg_FD" value="Y" class="trans"><b>6</b>&nbsp;
										<input type="checkbox" name="dcgo_n7th_clss_flg_FD" id="dcgo_n7th_clss_flg_FD" value="Y" class="trans"><b>7</b>&nbsp;
										<input type="checkbox" name="dcgo_n8th_clss_flg_FD" id="dcgo_n8th_clss_flg_FD" value="Y" class="trans"><b>8</b>&nbsp;
										<input type="checkbox" name="dcgo_n9th_clss_flg_FD" id="dcgo_n9th_clss_flg_FD" value="Y" class="trans"><b>9</b>&nbsp;
										<input type="checkbox" name="dcgo_none_clss_flg_FD" id="dcgo_none_clss_flg_FD" value="Y" class="trans"><b>No</b>
									</td>
							</tr>
							<tr class="h23"><td colspan="2"></td></tr>
							<tr class="h23">
									<th class="sm"></th>
									<td class="sm">
										<input type="checkbox" name="sat_flg_FD" id="sat_flg_FD" value="Y" class="trans"><b>SA</b>&nbsp;
										<input type="checkbox" name="sun_flg_FD" id="sun_flg_FD" value="Y" class="trans"><b>SU</b>&nbsp;
										<input type="checkbox" name="hol_flg_FD" id="hol_flg_FD" value="Y" class="trans"><b>HO</b>
									</td>
							</tr>
							<tr class="h23">
									<th>Days</th>
									<td><input name="ft_dys" type="text" maxlength="3" style="text-align:center;" class="input" style="width:170" value="" onKeyUp='isNum(this);' onKeyDown='chkInput(this);isNum(this);'></td>
							</tr>
							</tbody>
						</table>
					</div>   
			
				</div>
			</div>
			
			<div class="layout_vertical_2" style="width:35%;overflow:hidden">
			   <!-- opus_design_grid(S) -->
				<div class="opus_design_data sm mar_top_8 mar_btm_8 mar_rgt_8" style="height:370px">
					<div class="opus_design_grid">
					<table>
						<tbody>
							<colgroup>
								<col width="100px"/>
								<col width="180px"/>
								<col width="*"/>
							</colgroup>
							<tr class="h23">
								<td colspan="3"><input type="radio"  name="storage_gb" id="storage_gb" value="R" class="trans" onclick="rate();"><b>Rate</b></td>
							</tr>
							<tr class="sm">
								<th rowspan="2" >DG Class</th>
								<td colspan="2">
									<input type="radio" name="dcgo_aply_tp_cd_R" id="dcgo_aply_tp_cd_R" value="N" class="trans" onclick="javascript:selectDGNone('_R');"><b>None</b><br>
									<input type="radio" name="dcgo_aply_tp_cd_R" id="dcgo_aply_tp_cd_R" value="A" class="trans" onclick="javascript:selectDGSame('_R');"><b>Same</b>&nbsp;&nbsp;&nbsp;&nbsp;
									<font style="font-size: 9px;"><input type="radio" id="dcgo_same_R" name="dcgo_same_R" value="Y" class="trans" disabled onclick="javascript:same_dg('_R')">DG&nbsp;&nbsp;
									<input type="radio" name="dcgo_same_R"  id="dcgo_same_R" value="N" class="trans" disabled onclick="javascript:same_nodg('_R')">NODG</font><br>
									<input type="radio" name="dcgo_aply_tp_cd_R" id="dcgo_aply_tp_cd_R" value="S" class="trans" onclick="javascript:selectDGSep('_R');"><b>Separate</b>
								</td>
							</tr>
							<tr class="sm">
								<td colspan="2">
									<input type="checkbox" name="dcgo_n1st_clss_flg_R" id="dcgo_n1st_clss_flg_R" value="Y" class="trans"><b>1</b>&nbsp;
									<input type="checkbox" name="dcgo_n2nd_clss_flg_R" id="dcgo_n2nd_clss_flg_R" value="Y" class="trans"><b>2</b>&nbsp;
									<input type="checkbox" name="dcgo_n3rd_clss_flg_R" id="dcgo_n3rd_clss_flg_R" value="Y" class="trans"><b>3</b>&nbsp;
									<input type="checkbox" name="dcgo_n4th_clss_flg_R" id="dcgo_n4th_clss_flg_R" value="Y" class="trans"><b>4</b>&nbsp;
									<input type="checkbox" name="dcgo_n5th_clss_flg_R" id="dcgo_n5th_clss_flg_R" value="Y" class="trans"><b>5</b><br>
									<input type="checkbox" name="dcgo_n6th_clss_flg_R" id="dcgo_n6th_clss_flg_R" value="Y" class="trans"><b>6</b>&nbsp;
									<input type="checkbox" name="dcgo_n7th_clss_flg_R" id="dcgo_n7th_clss_flg_R" value="Y" class="trans"><b>7</b>&nbsp;
									<input type="checkbox" name="dcgo_n8th_clss_flg_R" id="dcgo_n8th_clss_flg_R" value="Y" class="trans"><b>8</b>&nbsp;
									<input type="checkbox" name="dcgo_n9th_clss_flg_R" id="dcgo_n9th_clss_flg_R" value="Y" class="trans"><b>9</b>&nbsp;
									<input type="checkbox" name="dcgo_none_clss_flg_R" id="dcgo_none_clss_flg_R" value="Y" class="trans"><b>No</b>
								</td>
							</tr>
							
							<tr class="h23">
									<th>No of Tier Days</th>
									<td><input name="cnt3" id="cnt3" type="text" style="text-align:center;width:30px" class="input" value="0"></td>
									<td>
										<div class="opus_design_btn">
											<button type="button" class="btn_normal" name="t3btng_retreive" 	id="t3btng_retreive">Retrieve</button>
										</div>
									</td>
								</tr>
						</tbody>
					</table>
					<script type="text/javascript">ComSheetObject('t3sheet1');</script>
					<table>
						<tbody>
							<colgroup>
								<col width="1px"/>
								<col width="*"/>
							</colgroup>
							<tr class="h23">
								<th style="height:35px">Rate</th>
								<td><input name="agmt_ut_rt" id="agmt_ut_rt"  maxlength="18" type="text" style="text-align:center;width:170px" class="input"  value="" onKeyUp='tes_isMon(this,"Y");' onKeyDown='chkInput(this); tes_isMon(this,"Y");' onBlur="tes_chkAmtFmtObj(this);"></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
	  <!-- opus_design_grid(E) -->
		</div>
  
    
    
    <div class="layout_vertical_2" style="width:30%;overflow:hidden">
     <!-- opus_design_inquiry(S) -->
      <div class="opus_design_data sm mar_top_8 mar_btm_8 mar_rgt_8" style="height:370px">
			<table>
				<tbody>
					<colgroup>
						<col width="100px"/>
						<col width="50px"/>
						<col width="50px"/>
						<col width="*"/>
			    	</colgroup>
			    	<tr class="h23">
						<th>Bound</th>
						<td colspan="3"><%=actionBoundBox%></td>
					</tr>
			    	<tr class="h23">
						<td colspan="4"><h3 id="tr_title1" class="title_design">Same Rate & Date Apply to</h3></td>
					</tr>
			    	<tr class="grid2">
							<th rowspan="3">CNTR<br>Type / Size</th>
							<td colspan="3">
								<input type="radio" name="cntr_ts" id="cntr_ts" value="A" class="trans" onclick="javascript:selectTSAll(1)"><b>All</b><br>
								<input type="radio" name="cntr_ts" id="cntr_ts" value="TS" class="trans" onclick="javascript:selectTS(1)"><b>By Type / Size</b>
							</td>
					</tr>
			    	<tr class="grid2">
							<th>Type</th>
							<td colspan="2"><script type="text/javascript">ComComboObject('cntr_type_s',1, 90 , 0 )</script></td>
					</tr>
			    	<tr class="grid2">
							<th>Size</th>
							<td colspan="2"><script type="text/javascript">ComComboObject('cntr_size_s',1, 90 , 0 )</script></td>
					</tr>
				</tbody>
			</table>
			
			<table>
			<tbody>
				<colgroup>
						<col width="300px"/>
						<col width="50px"/>
						<col width="*"/>
			    	</colgroup>
					<tr>
						<!-- Repeat Pattern -->
						<td> 
						<div class="opus_design_btn">
							<button type="button" class="btn_etc" name="t3btng_agmtcopy" 	id="t3btng_agmtcopy">AGMT Copy</button>
						</div>
						</td>
						<td> 
						<div class="opus_design_btn">
							<button type="button" class="btn_etc" name="t3btng_new1"  		id="t3btng_new1">New</button>
						</div>
						</td>
						<td> 
						<div class="opus_design_btn">
							<button type="button" class="btn_etc" name="t3btng_apply1" 		id="t3btng_apply1">Apply</button>
						</div>
						</td>
						<!-- Repeat Pattern -->
					</tr>
				</tbody>
			</table>
		</div>
	  <!-- opus_design_inquiry(E) -->
    </div>
</div>
<!-- layout_wrap(E) -->
</div>



<div class="opus_design_inquiry wFit"  id="srLayer" style="display:none;">
	<div class="layout_wrap">
	<div class="layout_vertical_2" style="width:800px;overflow:hidden">
   <!-- opus_design_inquiry(S) -->
	<div class="opus_design_data sm mar_top_8 mar_btm_8 mar_rgt_8">	
		
			<table>
				<tbody>
					<tr>
						<td width=150><b>Free Pool & Rate</b></td>
						<td width=100></td>
						<td></td>
						<td colsapn="3"></td>
					</tr>
					<tr>
						<td colsapn="6"></td>
					</tr>
					<tr>
			    			<td width="250" colspan=2> <b>Cal. Period</b> &nbsp;&nbsp;&nbsp;<input type="radio" name="fp_calc_prd_cd" id="fp_calc_prd_cd" value="D" class="trans"><b>Daily</b>&nbsp;<input type="radio" name="fp_calc_prd_cd" id="fp_calc_prd_cd" value="M" class="trans"><b>Monthly</b></td>
							<td width="50"><b>FP TEU</b></td>
							<td width="100"><input name="fp_teu_qty" id="fp_teu_qty" type="text" maxlength="6" style="text-align:center;width:80px" class="input"  value="" onKeyUp='isNum(this);' onKeyDown='chkInput(this);isNum(this);'></td>
							<td width="30"><b>Rate</b></td>
							<td width="*"><input name="agmt_ut_rt_fp" id="agmt_ut_rt_fp" maxlength="18" type="text" style="text-align:center;width:80px" class="input"  value="" onKeyUp='tes_isMon(this,"Y");' onKeyDown='chkInput(this); tes_isMon(this,"Y");' onBlur="tes_chkAmtFmtObj(this);"></td>
					</tr>
					<td colsapn="6"></td>
				</tbody>
			</table>
			
			<table>
			<tbody>
					<colgroup>
						<col width="700px"/>
						<col width="50px"/>
						<col width="*"/>
			    	</colgroup>
					<tr>
						<!-- Repeat Pattern -->
						<td> 
						<div class="opus_design_btn">
							<button type="button" class="btn_etc" name="t3btng_agmtcopy2"  id="t3btng_agmtcopy2">AGMT Copy</button>
						</div>
						</td>
						<td> 
						<div class="opus_design_btn">
							<button type="button" class="btn_etc" name="t3btng_new2"  	id="t3btng_new2">New</button>
						</div>
						</td>
						<td> 
						<div class="opus_design_btn">
							<button type="button" class="btn_etc" name="t3btng_apply2" 	 id="t3btng_apply2">Apply</button>
						</div>
						</td>
						<!-- Repeat Pattern -->
					</tr>
				</tbody>
			</table>			
		</div>	
		</div>	
    	</div>
</div>


</div>
	<div name="tabLayer" id="tabLayer" style="display:none;">
		<div class="opus_design_grid">
			<div class="opus_design_btn">
				<button type="button" class="btn_normal" name="t4btng_new" 	id="t4btng_new">New</button>
				<button type="button" class="btn_normal" name="t4btng_rowadd" 	id="t4btng_rowadd">Row Add</button>
				<button type="button" class="btn_normal" name="t4btng_delete" 	id="t4btng_delete">Delete</button>
				<button type="button" class="btn_normal" name="t4btng_save" 	id="t4btng_save">Save</button>
				<button type="button" class="btn_normal" name="t4btng_downexcel" 	id="t4btng_downexcel">Down Excel</button>
				<button type="button" class="btn_normal" name="t4btng_loadexcel" 	id="t4btng_loadexcel">Load Excel</button>
				<button type="button" class="btn_normal" name="t4btng_verify" 	id="t4btng_verify">Verify</button>
				<button type="button" class="btn_normal" name="t4btng_registeragree" 	id="t4btng_registeragree">Register Agreement</button>
			</div>
			<script type="text/javascript">ComSheetObject('t4sheet1');</script>
		</div>
	</div>
	
	
	
	<DIV style="display:none">
	<table class="height_5"><tr><td></td></tr></table>
	<table width="100%" id="mainTable">
		<tr><td>
			<script type="text/javascript">ComSheetObject('t1sheet3');</script>
		</td></tr>
	</table>
	<table class="height_10"><tr><td></td></tr></table>
	
	<table class="height_5"><tr><td></td></tr></table>
	<--  sheetObjects[6] ( t1sheet4 ) -->
	<table width="100%" id="mainTable">
		<tr><td>
			<script type="text/javascript">ComSheetObject('t1sheet4');</script>
		</td></tr>
	</table>
	<table class="height_10"><tr><td></td></tr></table>
	
	<table width="100%" id="mainTable">
		<tr><td>
			<script type="text/javascript">ComSheetObject('t1sheet5');</script>
		</td></tr>
	</table>
	</DIV>
	
	<div name="tabLayer" id="tabLayer" style="display:none;">
		<div class="opus_design_grid">
			<div class="opus_design_btn">
				<button type="button" class="btn_normal" name="t5btng_new" 	id="t5btng_new">New</button>
				<button type="button" class="btn_normal" name="t5btng_rowadd" 	id="t5btng_rowadd">Row Add</button>
				<button type="button" class="btn_normal" name="t5btng_delete" 	id="t5btng_delete">Delete</button>
				<button type="button" class="btn_normal" name="t5btng_save" 	id="t5btng_save">Save</button>
				<button type="button" class="btn_normal" name="t5btng_downexcel" 	id="t5btng_downexcel">Down Excel</button>
				<button type="button" class="btn_normal" name="t5btng_loadexcel" 	id="t5btng_loadexcel">Load Excel</button>
				<button type="button" class="btn_normal" name="t5btng_verify" 	id="t5btng_verify">Verify</button>
				<button type="button" class="btn_normal" name="t5btng_registeragree" 	id="t5btng_registeragree">Register Agreement</button>
			</div>
			<script type="text/javascript">ComSheetObject('t5sheet1');</script>
		</div>
	</div>	
	
</div>
</form>

<script type="text/javascript">
    document.form.tml_sto_agmt_tp_cd.onchange = processChange;
</script>


<Script type="text/javascript">
function t1sheet1_OnChange(sheetObj, Row, Col, Value){
	sheetObj.SetCellValue(Row,3, sheetObj.GetCellValue(Row,3).toUpperCase());

	if(sheetObj.GetCellValue(Row,3)!="MAX"){

		if(!ComIsNumber(sheetObj.GetCellValue(Row,3))){
			//ComShowMessage("숫자와 MAX만 입력 가능합니다. 다시 확인하세요.");
		}
	}
}
</Script>
<!-- <Script type="text/javascript" for="t1sheet1" event="OnChange(Row,Col,Value)">
	CellValue(Row,3) = CellValue(Row,3).toUpperCase();

	if(CellValue(Row,3)!="MAX"){

		if(!ComIsNumber(CellValue(Row,3))){
			//ComShowMessage("숫자와 MAX만 입력 가능합니다. 다시 확인하세요.");
		}
	}
</Script> -->

<Script type="text/javascript">

</Script>
<!-- <Script type="text/javascript" for="t3sheet1" event="OnChange(Row,Col,Value)">
	CellValue(Row,3) = CellValue(Row,3).toUpperCase();
	if(CellValue(Row,3) != "MAX"){

		if(!ComIsNumber(CellValue(Row,3))){
			//ComShowMessage("숫자와 MAX만 입력 가능합니다. 다시 확인하세요.");
		}
	}
</Script> -->
<Script type="text/javascript">

</Script>
  <!-- <Script type="text/javascript" for="t2sheet1" event="OnChange(Row,Col,Value)">
  var total_rate = "";
   		for(i= 32 ;i< 57;i++){
   			total_rate  = total_rate+"#"+sheetObjects[2].CellValue(Row, i);
   		}

      if (Col >31 || Col < 57){
          CellValue2(Row,"3ts_rt") = total_rate;
          }

      if(Col==29){
	 		  CellValue(Row,"3to_tr_vol_val") = CellValue(Row,"3to_tr_vol_val").toUpperCase();
	 		  if(CellValue(Row,"3to_tr_vol_val")!="MAX"){
	 		  		if(!ComIsNumber(CellValue(Row,"3to_tr_vol_val"))){
								//ComShowMessage("숫자와 MAX만 입력 가능합니다. 다시 확인하세요.");
								CellValue2(Row,"3to_tr_vol_val")="";
	 		  		}
	 		  }
 			}

 			if(CellValue(Row,"3curr_cd")== "KRW" || CellValue(Row,"3curr_cd")=="JPY"){
 					currRateModRow('terminal',Row, dfInteger);
 			}else{
 					currRateModRow('terminal',Row, dfFloat);
 			}
 			/**
 		  if(Col==2){
 		   		if(sheetObjects[2].CellValue(Row, Col)=="TPNDFL" || sheetObjects[2].CellValue(Row, Col)=="SVLDFL" || sheetObjects[2].CellValue(Row, Col)=="TMNDFL"){
 		   				CellComboItem(Row, "3tml_trns_mod_cd", "Same|Truck|Rail|Barge", "S|T|R|B");
 		   		}else if(sheetObjects[2].CellValue(Row, Col)=="TPNDTS" || sheetObjects[2].CellValue(Row, Col)=="SVLDTS" || sheetObjects[2].CellValue(Row, Col)=="TMNDFL"){
 		   				CellComboItem(Row, "3tml_trns_mod_cd", "Same|Feeder|Vessel", "S|F|V");
 		   		}else{
 		   				CellComboItem(Row, "3tml_trns_mod_cd", "", "");
 		   		}
 		  }
 		   **/
  </Script> --><!--

  <Script type="text/javascript" for="t4sheet1" event="OnChange(Row,Col,Value)">
   		var total_rate = "";
   		var daysTotalRate = 0;
   		var rateTotalRate = 0;

   		if(sheetObjects[4].CellValue(Row, "5ft_dys")=="F"){
	   		for(i= 42 ;i< 67;i++){
	   			total_rate  = total_rate+"#"+sheetObjects[4].CellValue(Row, i);
	   			daysTotalRate = parseInt(sheetObjects[4].CellValue(Row, i))+daysTotalRate;
	   		}

	      if (Col >41 || Col < 67){
	          CellValue2(Row,"5ts_rt") = total_rate;
	      }
	    }

   		if(sheetObjects[4].CellValue(Row, "5ft_dys")=="" || sheetObjects[4].CellValue(Row, "5ft_dys")==undefined){
	   		for(i= 67 ;i< 92;i++){
	   			total_rate  = total_rate+"#"+sheetObjects[4].CellValue(Row, i);
	   			rateTotalRate = parseInt(sheetObjects[4].CellValue(Row, i))+rateTotalRate;
	   		}

	      if (Col >66 || Col < 92){
	          CellValue2(Row,"5ts_rt") = total_rate;
	      }
	    }

 			if(CellValue(Row,"5curr_cd")=="KRW" || CellValue(Row,"5curr_cd")=="JPY" ){
 					currRateModRow('storage',Row, dfInteger);
 			}else{
 					currRateModRow('storage',Row, dfFloat);
 			}

	    if(Col==39){
		 		  CellValue(Row,"5to_tr_dys") = CellValue(Row,"5to_tr_dys").toUpperCase();
		 		  if(CellValue(Row,"5to_tr_dys")!="MAX"){
		 		  		if(!ComIsNumber(CellValue(Row,"5to_tr_vol_val"))){
									//ComShowMessage("숫자와 MAX만 입력 가능합니다. 다시 확인하세요.");
									CellValue2(Row,"5to_tr_dys")="";
		 		  		}
		 		  }
 			}
  </Script>

-->
