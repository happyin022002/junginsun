<%--
/*****
 * =========================================================
  *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TES_0001GS.jsp
*@FileTitle  :  Marine Terminal Invoice Save & Confirm - Verification
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/23 
 
 * =========================================================
 *****/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event.EsdTes0001Event" %>
<%
	EsdTes0001Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	//EsdTes0001EventResponse eventResponse = null;	//RDTO(Data Transfer Object including DB ResultSet)
	Exception serverException   = null;				//Server Exception
	DBRowSet rowSet	  = null;						//DB ResultSet
	String strErrMsg = "";							//Error Message
	int rowCount	 = 0;							//DB ResultSet Count
	String userId = "";
	String ofcCd = "";


	String inv_no="";
	String vndr_seq="";
	String	successFlg	= "";
	inv_no = JSPUtil.getNull(request.getParameter("inv_no"));
	vndr_seq = JSPUtil.getNull(request.getParameter("vndr_seq"));


	try {
	   SignOnUserAccount account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   userId = account.getUsr_id()!=null&&!account.getUsr_id().equals("")?account.getUsr_id():"";
	   ofcCd = account.getOfc_cd()!=null&&!account.getOfc_cd().equals("")?account.getOfc_cd():"";

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
			
	   //userAuth=account.getAuth();
		event = (EsdTes0001Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}

	String pre_cond_inv_no 				= request.getParameter("pre_cond_inv_no")!=null&&!request.getParameter("pre_cond_inv_no").trim().equals("")?request.getParameter("pre_cond_inv_no"):"";
	String pre_cond_inv_date_type 		= request.getParameter("pre_cond_inv_date_type")!=null&&!request.getParameter("pre_cond_inv_date_type").trim().equals("")?request.getParameter("pre_cond_inv_date_type"):"";
	String pre_cond_fm_prd_dt 			= request.getParameter("pre_cond_fm_prd_dt")!=null&&!request.getParameter("pre_cond_fm_prd_dt").trim().equals("")?request.getParameter("pre_cond_fm_prd_dt"):"";
	String pre_cond_to_prd_dt 			= request.getParameter("pre_cond_to_prd_dt")!=null&&!request.getParameter("pre_cond_to_prd_dt").trim().equals("")?request.getParameter("pre_cond_to_prd_dt"):"";
	String pre_cond_yd_cd 				= request.getParameter("pre_cond_yd_cd")!=null&&!request.getParameter("pre_cond_yd_cd").trim().equals("")?request.getParameter("pre_cond_yd_cd"):"";
	String pre_cond_vndr_seq 			= request.getParameter("pre_cond_vndr_seq")!=null&&!request.getParameter("pre_cond_vndr_seq").trim().equals("")?request.getParameter("pre_cond_vndr_seq"):"";
	String pre_cond_cost_ofc_cd 		= request.getParameter("pre_cond_cost_ofc_cd")!=null&&!request.getParameter("pre_cond_cost_ofc_cd").trim().equals("")?request.getParameter("pre_cond_cost_ofc_cd"):"";
	String pre_cond_inv_ofc_cd 			= request.getParameter("pre_cond_inv_ofc_cd")!=null&&!request.getParameter("pre_cond_inv_ofc_cd").trim().equals("")?request.getParameter("pre_cond_inv_ofc_cd"):"";
	String pre_cond_tml_inv_sts_cd 		= request.getParameter("pre_cond_tml_inv_sts_cd")!=null&&!request.getParameter("pre_cond_tml_inv_sts_cd").trim().equals("")?request.getParameter("pre_cond_tml_inv_sts_cd"):"";
	String pre_cond_csr_no 				= request.getParameter("pre_cond_csr_no")!=null&&!request.getParameter("pre_cond_csr_no").trim().equals("")?request.getParameter("pre_cond_csr_no"):"";
	String pre_cond_csr_status 			= request.getParameter("pre_cond_csr_status")!=null&&!request.getParameter("pre_cond_csr_status").trim().equals("")?request.getParameter("pre_cond_csr_status"):"";
	String pre_cond_tml_inv_rjct_sts_cd = request.getParameter("pre_cond_tml_inv_rjct_sts_cd")!=null&&!request.getParameter("pre_cond_tml_inv_rjct_sts_cd").trim().equals("")?request.getParameter("pre_cond_tml_inv_rjct_sts_cd"):"";

%>
<script type="text/javascript">
	<%= JSPUtil.getIBCodeCombo("vol_tr_ut_cd"	, "01", "CD00177", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("io_bnd_cd"		, "01", "CD00592", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("ioc_cd"			, "01", "CD00887", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("dcgo_clss_cd"	, "01", "CD00167", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("tml_wrk_dy_cd"	, "01", "CD00168", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("cntr_sty_cd"	, "01", "CD00136", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("locl_ts_ind_cd" , "01", "CD00889", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("tml_trns_mod_cd", "01", "CD00965", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("lc_trns_mod_cd" , "01", "CD00967", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("ts_trns_mod_cd" , "01", "CD00968", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("dscr_ind_cd"    , "01", "CD00823", 0, "")%>
	var inv_no = '<%=JSPUtil.getNull(inv_no)%>';
	var vndr_seq = '<%=JSPUtil.getNull(vndr_seq)%>';
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if

		loadPage();
	}
</script>
<form method="post" name="form">
<!----------------------------------------------------------------------
	# yd_chr_inv_tp_cd : Inquiry code value ​​for yard
	1. Marine Terminal Invoice = 'MT'
	2. On-dock Rail Charge Invoice = 'ON'
	3. Off-dock CY Invoice(Terminal) = 'OT'
	4. Off-dock CY Invoice(Storage) = 'OS'
	5. Storage Invoice = 'ST'
------------------------------------------------------------------------>
<input type="text" style="display:none"	name="f_cmd" id="f_cmd">
<input type="text" style="display:none"  	name="iPage" id="iPage">
<input type="text" style="display:none" 	name="tml_so_ofc_cty_cd" id="tml_so_ofc_cty_cd"		value="">
<input type="text" style="display:none" 	name="tml_so_seq" id="tml_so_seq"				value="">
<input type="text" style="display:none" 	name="temp_val"	 id="temp_val"				value="">
<input type="text" style="display:none" 	name="vvd_val_arr" id="vvd_val_arr"				value="">
<input type="text" style="display:none" 	name="tml_inv_tp_cd" id="tml_inv_tp_cd"			value="TM">
<input type="text" style="display:none" 	name="temp_lgs_cost_cd"	 id="temp_lgs_cost_cd"		value="">
<input type="text" style="display:none" 	name="agmtCurrCd" id="agmtCurrCd"				value="">
<input type="text" style="display:none" 	name="agmtSts" id="agmtSts"					value="">
<input type="text" style="display:none" 	name="laneCode" id="laneCode"					value=""> 
<input type="text" style="display:none" 	name="subTrade" id="subTrade"					value="">
<input type="text" style="display:none" 	name="delete_mode" id="delete_mode"				value="">
<input type="text" style="display:none" 	name="cost_calc_mode" id="cost_calc_mode"			value="R"> <!--cost calculation mode (R : calc list read, N: New Calculation ) -->
<input type="text" style="display:none" 	name="yd_chr_inv_tp_cd"	 id="yd_chr_inv_tp_cd"			value="">
<input type="text" style="display:none" 	name="calcTerminalComboItems"  id="calcTerminalComboItems" 	value="">
<input type="text" style="display:none" 	name="cntrTpszComboItems" id="cntrTpszComboItems"		value="">
<input type="text" style="display:none" 	name="laneComboItems" id="laneComboItems"			value="">
<input type="text" style="display:none" 	name="carrComboItems" id="carrComboItems"			value="">
<input type="text" style="display:none" 	name="tmp_common_code" id="tmp_common_code"			value="">
<!--<input type="text" style="display:none" 	name="tml_so_dtl_seq"			value="">-->
<input type="text" style="display:none" 	name="is_valid_err_inv_no" id="is_valid_err_inv_no"		value="">
<input type="text" style="display:none" 	name="tmp_cost_cd" id="tmp_cost_cd"				value="">
<input type="text" style="display:none" 	name="curr_cd_tmp" id="curr_cd_tmp" 				value="">
<input type="text" style="display:none"  	name="whld_tax_amt_mode"  id="whld_tax_amt_mode"		value="">
<input type="text" style="display:none"  	name="tmp_dtl_seq"  id="tmp_dtl_seq" 				value="">
<input type="text" style="display:none"  	name="tmp_if_amt" id="tmp_if_amt" 				value="">
<input type="text" style="display:none"  	name="tmp_calc_vol_qty" id="tmp_calc_vol_qty"			value="">
<input type="text" style="display:none"  	name="tmp_rvis_vol_qty" id="tmp_rvis_vol_qty"			value="">
<input type="text" style="display:none"  	name="tmp_ctrt_rt" 	 id="tmp_ctrt_rt"			value="">
<input type="text" style="display:none"  	name="tmp_inv_xch_rt" 	id="tmp_inv_xch_rt"		value="">
<input type="text" style="display:none" 	name="is_valid_cost_ofc_cd" id="is_valid_cost_ofc_cd"		value="">
<input type="text" style="display:none" 	name="reverify_yn"	id="reverify_yn"			value="">
<input type="text" style="display:none" 	name="manual_lgs_cost_cd" id="manual_lgs_cost_cd"		value="">
<input type="text" style="display:none" 	name="calc_cost_grp_cd"	id="calc_cost_grp_cd"		value="MT">
<input type="text" style="display:none" 	name="bound_lgs_cost_cd" id="bound_lgs_cost_cd"		value="">
<input type="text" style="display:none" 	name="costCalcFlg"	id="costCalcFlg"			value="">
<input type="text" style="display:none" 	name="rtro_tml_inv_flg_old"	id="rtro_tml_inv_flg_old"	value=""> 
<input type="text" style="display:none" 	name="mdl_cd"		value="TES"> 

<input type="text" style="display:none" 	name="agmt_ftr_inv_tp_cd" value="MT"> 
<input type="text" style="display:none" 	name="cost_cd_ftr_rmk" value=""> 
<input type="text" style="display:none" 	name="ofc_cd" value="<%=ofcCd%>"> 
<input type="text" style="display:none" 	name="call_yd_ind_seq" value=""> 


<!-- special character, characterSet problem. //-->
<input type="text" style="display:none"  name="inv_no_tmp" id="inv_no_tmp" value= "<%=JSPUtil.getNull(inv_no)%>">

<input name="pre_cond_inv_no" id="pre_cond_inv_no" type="text" style="display:none"  value="<%=JSPUtil.getNull(pre_cond_inv_no)%>">
<input name="pre_cond_inv_date_type" id="pre_cond_inv_date_type" type="text" style="display:none"  value="<%=JSPUtil.getNull(pre_cond_inv_date_type)%>">
<input name="pre_cond_fm_prd_dt" id="pre_cond_fm_prd_dt" type="text" style="display:none"  value="<%=JSPUtil.getNull(pre_cond_fm_prd_dt)%>">
<input name="pre_cond_to_prd_dt" id="pre_cond_to_prd_dt" type="text" style="display:none"  value="<%=JSPUtil.getNull(pre_cond_to_prd_dt)%>">
<input name="pre_cond_yd_cd" id="pre_cond_yd_cd" type="text" style="display:none"  value="<%=JSPUtil.getNull(pre_cond_yd_cd)%>">
<input name="pre_cond_vndr_seq" id="pre_cond_vndr_seq" type="text" style="display:none"  value="<%=JSPUtil.getNull(pre_cond_vndr_seq)%>">
<input name="pre_cond_cost_ofc_cd" id="pre_cond_cost_ofc_cd" type="text" style="display:none"  value="<%=JSPUtil.getNull(pre_cond_cost_ofc_cd)%>">
<input name="pre_cond_inv_ofc_cd" id="pre_cond_inv_ofc_cd" type="text" style="display:none"  value="<%=JSPUtil.getNull(pre_cond_inv_ofc_cd)%>">
<input name="pre_cond_tml_inv_sts_cd" id="pre_cond_tml_inv_sts_cd" type="text" style="display:none"  value="<%=JSPUtil.getNull(pre_cond_tml_inv_sts_cd)%>">
<input name="pre_cond_csr_no" id="pre_cond_csr_no" type="text" style="display:none"  value="<%=JSPUtil.getNull(pre_cond_csr_no)%>">
<input name="pre_cond_csr_status" id="pre_cond_csr_status" type="text" style="display:none"  value="<%=JSPUtil.getNull(pre_cond_csr_status)%>">
<input name="pre_cond_tml_inv_rjct_sts_cd" id="pre_cond_tml_inv_rjct_sts_cd" type="text" style="display:none"  value="<%=JSPUtil.getNull(pre_cond_tml_inv_rjct_sts_cd)%>">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<div id="PreInquiryCondLayer01" style="display:none">
				<button type="button" class="btn_accent" name="btn_pre_inquiry_cond" id="btn_pre_inquiry_cond">To Inv. Summary</button>
			</div><!-- 
			 --><button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_new2" id="btn_new2">New2</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button>				
		</div>
		<!-- opus_design_btn(E) -->
	
	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>

<!-- page_title_area(E) -->


<!-- wrap_search(S) -->  
<div class="wrap_search_tab">
<!-- opus_design_inquiry (S) -->
<div class="opus_design_inquiry">

	<table>
		<colgroup>
			<col width="90">
			<col width="100">
			<col width="80">
			<col width="100">
			<col width="80">
			<col width="100">
			<col width="100">
			<col width="130">
			<col width="*">
		</colgroup>
		<tr>			
			<th>S/P Code</th>
			<td>
				<input type="text" style="width:68px;background-color:#CCFFFD;" name="vndr_seq" value='' valid="1" title="VNDR Code" value='' maxlength=6 tabindex='1' onKeyUp='tes_isNum(this);' onKeyDown='tes_isNum(this); tes_chkInput(this);' onBlur='validateVndrSeq();'><!-- 
				 --><button type="button" name="btn_vndr" id="btn_vndr" class="input_seach_btn"></button><!-- 
				  --><input type="text" style="display:none"  name="vndr_seq_hidden" id="vndr_seq_hidden" value=''><!-- 
				   --><input type="text" style="display:none"  name="is_valid_vndr_seq" id="is_valid_vndr_seq" value=''><!-- 
				    --></td>
   			<th>S/P Name</th>
			<td><input type="text" style="width:115px" value=""  name ="vndr_seq_nm" id="vndr_seq_nm" valid="1" class="input2" readOnly ></td>
			<th>INV NO</th>
			<td><input class="input1" type="text" style="width:90px;background-color:#CCFFFD;" name="inv_no"  id="inv_no"  value='' maxlength=30 valid="1" tabindex='2' title= "Inv. No."  onKeyUp='isApNum2(this);' onKeyDown='tes_chkInput(this);' onKeyPress='enterCheck("retrieveEvent");' onBlur='validateInvDupChk();'></td>
										<input type="text" style="display:none"  name="inv_no_hidden" value=''>
									  	<input type="text" style="display:none"  name="is_dup_inv_no" value=''>
			<th>Error INV NO</th>
			<td><input class="input3" type="text" style="width:93px;" name="err_inv_no" id="err_inv_no" maxlength="30" onKeyDown='tes_chkInput(this);' onBlur='validateErrInvNo();'></td>
			<td><b><label for="rtro_tml_inv_flg">Retroactive INV </label></b><input type="checkbox" name="rtro_tml_inv_flg" id="rtro_tml_inv_flg" value="Y" class="trans"></td>
		</tr>
	</table>
</div>
<!-- opus_design_inquiry (E) -->

<!-- layout_wrap(S) -->
<div class="layout_wrap wFit">
	<!-- layout_vertical_2(S) -->
	<div class="layout_vertical_2 mar_rgt_8" style="width: 49%">
		<!--Content-->
		<!-- opus_design_inquiry (S) -->
		<div class="opus_design_inquiry">
			<!-- : ( Week ) (S) -->
			<table>	
				<colgroup>
					<col width="90">
					<col width="100">
					<col width="80">
					<col width="*">
				</colgroup>		
				<tr>
					<th>Yard Code</th>
					<td style='width:170px'><input class="input1" type="text" style="width:68px" name="yd_cd" valid="1" title= "Yard Code"  maxlength=7  onKeyUp='tes_isApNum(this);upper(this);' onBlur='getYardName();'><!-- 
					 --><button type="button" name="btn_yard" id="btn_yard" class="input_seach_btn"></button><!-- 
					  --><input type="text" style="display:none"  name="yd_cd_hidden"  id="yd_cd_hidden" value=''><!-- 
					   --><input type="text" style="display:none"  name="is_valid_yd_cd" id="is_valid_yd_cd" value=''><!-- 
					    --><input type="text" style="display:none"  name="yd_chr_cd" id="yd_chr_cd" value=''><!-- 
					     --><input type="text" style="display:none"  name="yd_fcty_tp_mrn_tml_flg" id="yd_fcty_tp_mrn_tml_flg" value=''><!-- 
					      --><input type="text" style="display:none"  name="yd_fcty_tp_cy_flg" id="yd_fcty_tp_cy_flg" value=''><!-- 
					       --><input type="text" style="display:none"  name="yd_fcty_tp_cfs_flg" id="yd_fcty_tp_cfs_flg" value=''><!-- 
					        --><input type="text" style="display:none"  name="yd_fcty_tp_rail_rmp_flg" id="yd_fcty_tp_rail_rmp_flg" value=''><!-- 
					         --><input type="text" style="display:none"  name="yd_oshp_cd" id="yd_oshp_cd" value=''></td>
					<th>Yard Name</th>
					<td><input type="text" style="width:105px" name="yd_nm" id="yd_nm" class="input2"  readOnly ></td>
				</tr>
				<tr>
					<th>Cost OFC</th>
					<td><input class="input1" type="text" style="width:68px" name="cost_ofc_cd"  id="cost_ofc_cd"  value='' maxlength=6  onKeyUp='tes_isApNum(this);upper(this);' onBlur='validateCostOFC();' readOnly ><!-- 					 
					  --><button type="button" name="btn_cost_ofc" id="btn_cost_ofc" class="input_seach_btn"></button><!-- 
			   			--><input type="text" style="display:none"  name="cost_ofc_hidden" id="cost_ofc_hidden" value=''><!-- 
					   --><input type="text" style="display:none"  name="is_valid_cost_ofc" id="is_valid_cost_ofc" value=''></td>
					<th>INV OFC</th>
					<td><input type="text" style="width:105px" name ="inv_ofc_cd" id="inv_ofc_cd" valid="1" title= "Inv. OFC" class="input1" value="<%=ofcCd%>" readOnly ></td>
				</tr>
				<tr>
					<th>Currency</th>
					<td><script type="text/javascript">ComComboObject('curr_cd', 1, 91, 1, 1)</script></td>
					<th>ACC VOL</th>
					<td><input type="text" style="width:77px;text-align:right;" name="pay_vol_qty"  onKeyUp='ComChkObjValid(this);ComIsNumber(this,",");'><!-- 					 
					  --><button type="button" name="btns_accumulate" id="btns_accumulate"  class="input_seach_btn"></button><!-- 
					  --><input type="text" style="display:none"  name="accm_seq" id="accm_seq" value=''><!-- 
					   --><input type="text" style="display:none"  name="revisedVol_sum" id="revisedVol_sum" value=''><!-- 
					    --><input type="text" style="display:none"  name="revisedVol_minus" id="revisedVol_minus" value=''><!-- 
					     --><input type="text" style="display:none"  name="pay_vol_qty_org" id="pay_vol_qty_org" value=''>
					</td>											
				</tr>
				<tr>
					<th>Hold</th>
					<td><input type="checkbox" name="hld_flg" id="hld_flg" value="Y" class="trans">
								<button type="button" style="width:82px;" class="btn_etc" name="btns_remarks" id="btns_remarks">Remarks</button>
								<input type="text" style="display:none"  name="hld_rmk" id="hld_rmk" maxlength="500" value="" />
					</td>
					
					<th>AGMT COST CD</th>
					<td><script type="text/javascript">ComComboObject('agmt_lgs_cost_cd', 2, 91, 1, 1)</script></td>					
				</tr>
			</table>	
		</div>
		<!-- opus_design_inquiry (E) -->
	</div>
     <!-- layout_vertical_2(E) -->
     
     
     <!-- layout_vertical_2(S) -->
	<div class="layout_vertical_2" style="width: 50%">
		<!--Content-->
		<!-- opus_design_inquiry (S) -->
		<div class="opus_design_inquiry">
			<table>
				<tr>
					<th>INV AMT</th>
					<td><input class="input1" type="text" style="width:105px;text-align:right;" name="ttl_inv_amt" id="ttl_inv_amt" maxlength=20 valid="1" title= "Inv. AMT" onKeyUp='tes_isMon(this,"Y",this.form.curr_cd.Code);' onKeyDown='tes_chkInput(this); tes_isMon(this,"Y",this.form.curr_cd.Code);' onBlur="tes_chkAmtFmtObj(this,this.form.curr_cd.Code); set_total_amount();"  /></td>
					<th>TAX</th>
					<td><input type="text" style="width:105px;text-align:right;" name="vat_amt" id="vat_amt" valid="1" title= "V.A.T" maxlength=20  onKeyUp='tes_isMon(this,"Y",this.form.curr_cd.Code);' onKeyDown='tes_chkInput(this); tes_isMon(this,"Y",this.form.curr_cd.Code);' onBlur="tes_chkAmtFmtObj(this,this.form.curr_cd.Code); set_total_amount();" ></td></tr>
				<tr>
					<th>W.H.T</th>
					<td><input type="text" style="width:105px;text-align:right;" name="whld_tax_amt" id="whld_tax_amt" maxlength=20 style="width:92;text-align:right;" dataformat="float" pointcount="2"  onKeyUp='tes_isMon(this,"Y",this.form.curr_cd.Code);' onKeyDown='tes_chkInput(this); tes_isMon(this,"Y",this.form.curr_cd.Code);' onBlur="tes_chkAmtFmtObj(this,this.form.curr_cd.Code);set_total_amount();"></td>
					<th>Total AMT</th>
					<td><input class="input2" type="text" style="width:105px;" name="total_amt" id="total_amt" maxlength=20 style="width:92;text-align:right;" readonly></td></tr>
				<tr>
					<th>Issued DT</th>
					<td><input class="input1" type="text" style="width:77px" name="iss_dt" id="iss_dt" valid="1" title= "Issue Date" maxlength=10 onKeyUp='tes_isNumD(this,"Y");' onKeyDown='tes_isNumD(this,"Y");' onBlur="validDate(this);"><!-- 
					 --><button type="button" name="btns_calendar1" id="btns_calendar1"  class="calendar ir"></button></td>					 
					<th>Received DT</th>
					<td><input class="input1" type="text" style="width:77px" name="rcv_dt"  id="rcv_dt"  valid="1" title= "RCV Date" maxlength=10  onKeyUp='tes_isNumD(this,"Y");' onKeyDown='tes_isNumD(this,"Y");' onBlur="validDate(this);" ><!-- 
					 --><button type="button" name="btns_calendar2" id="btns_calendar2"  class="calendar ir"></button></td></tr>					 
				<tr>
					<th>INV STS</th>
					<td><input type="text" style="width:105px" name="tml_inv_sts_nm"  id="tml_inv_sts_nm"  value="" class="input2" readonly ><input type="text" style="display:none"    name="tml_inv_sts_cd" value=""></td>										
					<th>Reject STS</th>
					<td><input type="text" style="width:105px" name="tml_inv_rjct_sts_nm" id="tml_inv_rjct_sts_nm"  valid="1" title= "Reject STS" maxlength=2 value=""  class="input2" readonly ><input type="text" style="display:none"  name="tml_inv_rjct_sts_cd"  valid="1" title= "Reject STS"  value=""  class="noinput1" readonly ><input type="text" style="display:none"  name="inv_rjct_rmk" maxlength=500 value=""></td>
				</tr>
				</table>		
		</div>
		<!-- opus_design_inquiry (E) -->
	</div>
     <!-- layout_vertical_2(E) -->
</div>
<!-- layout_wrap(E) -->

<!-- opus_design_inquiry (S) -->
<div class="opus_design_inquiry">
	<table>
		<colgroup>
			<col width="85">
			<col width="100">
			<col width="67">
			<col width="150">
			<col width="150">
			<col width="*">
		</colgroup>
		<tr>
			<th>VVD/BND</th>
			<td><input type="text" style="width:80px" name="vvd"  id="vvd" title= "VVD" value="" title="VVD" maxlength=9  onKeyUp='tes_isApNum(this);upper(this);' onKeyDown='tes_isApNum(this);upper(this);' onBlur='getAtbDt(this);'><!-- 
			 --><input type="text" style="display:none"  name="vvd_no_hidden" id="vvd_no_hidden" value=''><!-- 
			  --><input type="text" style="display:none"  name="is_valid_vvd_no" id="is_valid_vvd_no" value='Y'><!-- 
			   --><input type="text" style="display:none"  name="vvd_type" id="vvd_type" value=''><!-- 
			    --><select style="width:50px;"  value="0" name="io_bnd_cd" id="io_bnd_cd" onChange='getAtbDt(this);'><!-- 
			     --><option value="O" selected>O</option><!-- 
			      --><option value="I">I</option><!-- 
			       --></select><button type="button" class="btn_plus" name="btng_plus" id="btng_plus"></button><button type="button" name="btng_minus" id="btng_minus" class="btn_minus"></button></td>	       	
			<th>ATB</th>
			<td class="stm"><script type="text/javascript">ComComboObject('atb_dt', 1, 91, 1, 1)</script>
								<!--<input class="input2" type="text" style="width:75px" name="atb_dt"  id="atb_dt" title= "ATB_DT" readonly >-->
								<button type="button" name="btng_back" id="btng_back" class="btn_left"></button><button type="button" class="btn_right" name="btng_next" id="btng_next"></button>
								<input class="input2" type="text" style="width:35px;text-align:center;" name="page" value="" readOnly ></td>
			<th>CALC AMT(VVD/TTL)</th>
			<td><input class="input2" type="text" style="width:95px;text-align:right;" name="vvd_inv_amt" id="vvd_inv_amt" value="" readOnly >/&nbsp;<input class="input2" type="text" style="width:95;text-align:right;" name="tot_inv_amt" value="" readOnly ></td>			
		</tr>
	</table>
</div>
<!-- opus_design_inquiry (E) -->
</div>

<!-- opus_tab_btn(S) -->
<div class="wrap_result">
<div class="opus_design_tab sm">
	<script type="text/javascript">ComTabObject('tab1')</script>
</div>
<!-- opus_tab_btn(E) -->

<!-- UI_ESD_TES_001 : THIS IS 1st TAB -->
	<div id="tabLayer" style="display:inline">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<div class="opus_design_btn">
				<!-- Content -->
				<button type="button" class="btn_normal" name="t1btng_clear" id="t1btng_clear">List Clear</button><!-- 
				 --><button type="button" class="btn_normal" name="t1btng_todiscrepancy" id="t1btng_todiscrepancy">To Discrepancy</button><!--
				 --><!-- <button type="button" class="btn_normal" name="t1btng_db_check" id="t1btng_db_check">DB Check</button> --><!-- 
				 --><button type="button" class="btn_normal" name="t1btng_getcntr" id="t1btng_getcntr">Get CNTR List</button><!-- 
				 --><button type="button" class="btn_normal" name="t1btng_save" id="t1btng_save">Save</button><!-- 
				 --><button type="button" class="btn_normal" name="t1btng_downexcel" id="t1btng_downexcel">Down Excel</button><!-- 
			     --><button type="button" class="btn_normal" name="t1btng_costcalc" id="t1btng_costcalc">Cost Calc.</button>
			</div>						
			<script type="text/javascript">ComSheetObject('t1sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->
		<div id="SearchLayer01" style="display:inline">
			<table class="line_bluedot"><tr><td></td></tr></table>
		</div>
		<div class="opus_design_data">
			<table class="sbutton">
			    <tr><td align="right"><button type="button" id="maxi" name="maxi" class="btn_up" onClick="reSize();"></button></td></tr>
			</table>
		</div>
		<!-- opus_design_data(S) -->
		<div class="opus_design_data wFit">
			<div id="SearchLayer02" style="display:inline">
			<table class="mar_btm_4 grid2">
				<tr>
					<th>Total</th>
					<td><input class="input2" type="text" name="sht_01_ttl" id="sht_01_ttl" style="width:80px;text-align:right;" readOnly disabled></td>
					<th>Full</th>
					<td><input class="input2" type="text" name="sht_01_full" id="sht_01_full" style="width:80px;text-align:right;" readOnly disabled></td>
					<th>Empty</th>
					<td><input class="input2" type="text" name="sht_01_mt" id="sht_01_mt" style="width:80px;text-align:right;" readOnly disabled></td>
					<th>TS(Same Yard)</th>
					<td><input class="input2" type="text" name="sht_01_ts_same_yard" id="sht_01_ts_same_yard" style="width:80px;text-align:right;" readOnly disabled></td></tr>
			</table>
			<table class="grid2">
				<tr>
					<th>D2 </th><td width="40"><input class="input2" type="text" name="sht_01_D2" id="sht_01_D2" style="width:32px;text-align:right;" readOnly disabled></td>
					<th>D4 </th><td width="40" style="padding-bottom: 3px;"><input class="input2" type="text" name="sht_01_D4" id="sht_01_D4" style="width:32px;text-align:right;" readOnly disabled></td>
					<th>D5 </th><td width="40"><input class="input2" type="text" name="sht_01_D5" id="sht_01_D5" style="width:32px;text-align:right;" readOnly disabled></td>
					<th>D7 </th><td width="40"><input class="input2" type="text" name="sht_01_D7" id="sht_01_D7" style="width:32px;text-align:right;" readOnly disabled></td>
					<th>D8 </th><td width="40"><input class="input2" type="text" name="sht_01_D8" id="sht_01_D8" style="width:32px;text-align:right;" readOnly disabled></td>
					<th>D9 </th><td width="40"><input class="input2" type="text" name="sht_01_D9" id="sht_01_D9" style="width:32px;text-align:right;" readOnly disabled></td>
					
					<!-- 
					<th>DW </th><td width="40"><input class="input2" type="text" name="sht_01_DW"  id="sht_01_DW" style="width:32px;text-align:right;" readOnly disabled></td>
					<th>DX </th><td width="40"><input class="input2" type="text" name="sht_01_DX" id="sht_01_DX" style="width:32px;text-align:right;" readOnly disabled></td>
					 -->
					 
					<th>R2 </th><td width="40"><input class="input2" type="text" name="sht_01_R2"  id="sht_01_R2" style="width:32px;text-align:right;" readOnly disabled></td>
					<th>R4 </th><td width="40"><input class="input2" type="text" name="sht_01_R4"id="sht_01_R4" style="width:32px;text-align:right;" readOnly disabled></td>
					<th>R5 </th><td width="40"><input class="input2" type="text" name="sht_01_R5" id="sht_01_R5" style="width:32px;text-align:right;" readOnly disabled></td>
					<th>F2 </th><td width="40"><input class="input2" type="text" name="sht_01_F2" id="sht_01_F2" style="width:32px;text-align:right;" readOnly disabled></td>
					<th>F4 </th><td width="40"><input class="input2" type="text" name="sht_01_F4" id="sht_01_F4" style="width:32px;text-align:right;" readOnly disabled></td>
					<th>F5 </th><td width="40"><input class="input2" type="text" name="sht_01_F5" id="sht_01_F5" style="width:32px;text-align:right;" readOnly disabled></td></tr>
				<tr>
					<th>O2</th><td><input class="input2" type="text" name="sht_01_O2" id="sht_01_O2" style="width:32px;text-align:right;" readOnly disabled></td>
					<th>O4</th><td><input class="input2" type="text" name="sht_01_O4" id="sht_01_O4" style="width:32px;text-align:right;" readOnly disabled></td>
					<th>S2</th><td><input class="input2" type="text" name="sht_01_S2" id="sht_01_S2" style="width:32px;text-align:right;" readOnly disabled></td>
					<th>S4</th><td><input class="input2" type="text" name="sht_01_S4" id="sht_01_S4" style="width:32px;text-align:right;" readOnly disabled></td>
					<th>T2</th><td><input class="input2" type="text" name="sht_01_T2" id="sht_01_T2" style="width:32px;text-align:right;" readOnly disabled></td>
					<th>T4</th><td><input class="input2" type="text" name="sht_01_T4" id="sht_01_T4" style="width:32px;text-align:right;" readOnly disabled></td>
					<th>A2</th><td><input class="input2" type="text" name="sht_01_A2" id="sht_01_A2" style="width:32px;text-align:right;" readOnly disabled></td>
					<th>A4</th><td><input class="input2" type="text" name="sht_01_A4" id="sht_01_A4" style="width:32px;text-align:right;" readOnly disabled></td>
					<th>P2</th><td><input class="input2" type="text" name="sht_01_P2" id="sht_01_P2" style="width:32px;text-align:right;" readOnly disabled></td>
					<th>P4</th><td><input class="input2" type="text" name="sht_01_P4"  id="sht_01_P4"  style="width:32px;text-align:right;" readOnly disabled></td>
					<th>Z2</th><td><input class="input2" type="text" name="sht_01_Z2" id="sht_01_Z2" style="width:32px;text-align:right;" readOnly disabled></td>
					<th>Z4</th><td><input class="input2" type="text" name="sht_01_Z4" id="sht_01_Z4" style="width:32px;text-align:right;" readOnly disabled></td>
			   </tr>
			</table>
			</div>
		</div>
		<!-- opus_design_data(E) -->				
	</div>
<!-- UI_ESD_TES_001 : THIS IS 2st TAB -->	

	<div id="tabLayer" style="display:none">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" id="mainTable">
			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn" >
				<!-- Content -->
				<button type="button" class="btn_normal" name="t2btng_reverify" id="t2btng_reverify">Re-Verify</button><!-- 
				--><button type="button" class="btn_normal" name="t2btng_clear" id="t2btng_clear">List Clear</button><!-- 
				--><button type="button" class="btn_normal" name="t2btng_verification" id="t2btng_verification">To Verification</button><!-- 
				--><button type="button" class="btn_normal" name="t2btng_reject" id="t2btng_reject">Reject</button><!-- 
			    --><button type="button" class="btn_normal" name="t2btng_downexcel" id="t2btng_downexcel">Down Excel</button><!-- 
			    --><button type="button" class="btn_normal" name="t2btng_print" id="t2btng_print" style="display:none;">Print</button>
			</div>
			
			
			<script type="text/javascript">ComSheetObject('t2sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->
		
	</div>
	
		<div id="tabLayer" style="display:none">
			<div class="opus_design_grid" id="mainTable">
			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn">
				<!-- Content -->
							
				<button type="button" class="btn_normal" name="t3btng_costCal" id="t3btng_costCal">Semi-Auto Calc.</button>
				<button type="button" class="btn_normal" name="t3btng_clear" id="t3btng_clear">List Clear</button><!-- 
				--><button type="button" class="btn_normal" name="t3btng_rowadd" id="t3btng_rowadd">Row Add</button><!-- 
				--><button type="button" class="btn_normal" name="t3btng_rowdel" id="t3btng_rowdel">Delete</button><!-- 
				--><button type="button" class="btn_normal" name="t3btng_save" id="t3btng_save">Save</button><!-- 
			    --><button type="button" class="btn_normal" name="t3btng_totalamount" id="t3btng_totalamount">Total Amount</button><!-- 
			    --><button type="button" class="btn_normal" name="t3btng_confirm" id="t3btng_confirm">Confirm</button>
			</div>
			<!-- opus_design_grid(S) -->
			
				<script type="text/javascript">ComSheetObject('t3sheet1');</script>
			</div>
			<!-- opus_design_grid(E) -->
			
		</div>
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" id="hidden_sheets1" style="display:none;">
			<script type="text/javascript">ComSheetObject('main_hidden');</script>
		</div>
		<!-- opus_design_grid(E) -->
		
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" id="hidden_sheets3" style="display:none;">
			<script type="text/javascript">ComSheetObject('vvd_hidden');</script>
		</div>
		<!-- opus_design_grid(E) -->
		
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" id="hidden_sheets4" style="display:none;">
			<script type="text/javascript">ComSheetObject('accm_hidden');</script>
		</div>
		<!-- opus_design_grid(E) -->
		
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" id="hidden_sheets6" style="display:none;">
			<script type="text/javascript">ComSheetObject('rvis_hidden');</script>
		</div>
		<!-- opus_design_grid(E) -->
		
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" id="hidden_sheets7" style="display:none;">
			<script type="text/javascript">ComSheetObject('n3rd_hidden');</script>
		</div>
		<!-- opus_design_grid(E) -->
		
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" id="hidden_sheets8" style="display:none;">
			<script type="text/javascript">ComSheetObject('amt_hidden');</script>
		</div>
		<!-- opus_design_grid(E) -->
		
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" id="hidden_sheets9" style="display:none;">
			<script type="text/javascript">ComSheetObject('etc_hidden');</script>
		</div>
		<!-- opus_design_grid(E) -->
		
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" id="hidden_sheets10" style="display:none;">
			<script type="text/javascript">ComSheetObject('total_hidden');</script>
		</div>
		<!-- opus_design_grid(E) -->
		
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" id="hidden_sheets11" style="display:none;">
			<script type="text/javascript">ComSheetObject('vvd_check_hidden');</script>
		</div>
		<!-- opus_design_grid(E) -->
</div>
</form>