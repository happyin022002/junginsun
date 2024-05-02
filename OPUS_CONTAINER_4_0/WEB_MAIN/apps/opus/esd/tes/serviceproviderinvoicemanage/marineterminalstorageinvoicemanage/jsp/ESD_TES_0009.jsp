<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TES_009.jsp
*@FileTitle  :  Marine Terminal Storage Invoice Creation & Correction
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/06
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.event.EsdTes0009Event"%>
<%@ page import="com.clt.apps.opus.esd.tes.common.tescommon.util.TESUtil"%>
<%
	String strErrMsg = "";				//Error Message

	String userId = "";
	String ofc_cd = "";

	String inv_no="";
	String vndr_seq="";
	inv_no = JSPUtil.getNull(request.getParameter("inv_no"));
	vndr_seq = JSPUtil.getNull(request.getParameter("vndr_seq"));

   SignOnUserAccount account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
   userId = account.getUsr_id()!=null&&!account.getUsr_id().equals("")?account.getUsr_id():"";
   ofc_cd = account.getOfc_cd()!=null&&!account.getOfc_cd().equals("")?account.getOfc_cd():"";

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
	<%= JSPUtil.getIBCodeCombo("cntr_sty_cd"	, "01", "CD00136", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("dcgo_clss_cd"	, "01", "CD00167", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("dscr_ind_cd"    , "01", "CD20038", 0, "")%>
	var inv_no = "<%=JSPUtil.getNull(inv_no)%>";
	var vndr_seq = "<%=JSPUtil.getNull(vndr_seq)%>";
	var inv_ofc_cd = "<%=JSPUtil.getNull(ofc_cd)%>";
	function setupPage(){

		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		}
		loadPage();
	}
</script>
<form method="post" name="form" onSubmit="return false;">
<input type="text" style="display:none"  name="f_cmd" id="f_cmd" />
<input type="text" style="display:none"  name="iPage" id="iPage" />
<input type="text" style="display:none"  name="f_cmd_rjct" id="f_cmd_rjct" />
<input type="text" style="display:none"  name="DB_DATE" value="" id="DB_DATE" />

<input type="text" style="display:none"  name="tml_so_ofc_cty_cd" value="" id="tml_so_ofc_cty_cd" />
<input type="text" style="display:none"  name="tml_so_seq" value="" id="tml_so_seq" />
<input type="text" style="display:none"  name="tml_agmt_ofc_cty_cd" value="" id="tml_agmt_ofc_cty_cd" />
<input type="text" style="display:none"  name="tml_agmt_seq" value="" id="tml_agmt_seq" />
<input type="text" style="display:none"  name="tml_agmt_ver_no" value="" id="tml_agmt_ver_no" />
<input type="text" style="display:none"  name="vrfy_rslt_ind_cd" value="" id="vrfy_rslt_ind_cd" />

<!----------------------------------------------------------------------
	# yd_chr_inv_tp_cd : Inquiry code value ​​for yard
	1. Marine Terminal Invoice = 'MT'
	2. On-dock Rail Charge Invoice = 'ON'
	3. Off-dock CY Invoice(Terminal) = 'OT'
	4. Off-dock CY Invoice(Storage) = 'OS'
	5. Storage Invoice = 'ST'
	6. Storage EQ(Chassis) Invoice = 'SE'
	7. Off-dock CY Invoice(Storage MG Set) = 'OE'
------------------------------------------------------------------------>
<input type="text" style="display:none"  name="yd_chr_inv_tp_cd" value="" id="yd_chr_inv_tp_cd" />
<input type="text" style="display:none"  name="calcStorageComboItems" value="" id="calcStorageComboItems" />
<input type="text" style="display:none"  name="calcStorageEqComboItems" value="" id="calcStorageEqComboItems" />

<input type="text" style="display:none"  name="tml_inv_tp_cd" value="ST" id="tml_inv_tp_cd" />
<input type="text" style="display:none"  name="tml_cost_grp_cd" value="" id="tml_cost_grp_cd" />
<input type="text" style="display:none"  name="tml_calc_ind_cd" value="" id="tml_calc_ind_cd" />
<input type="text" style="display:none"  name="sto_dys_ind_cd" value="" id="sto_dys_ind_cd" />

<input type="text" style="display:none"  name="cost_calc_mode" value="" id="cost_calc_mode" />
<input type="text" style="display:none"  name="dup_chk_mode" value="" id="dup_chk_mode" />
<input type="text" style="display:none"  name="confirm_mode" value="" id="confirm_mode" />
<input type="text" style="display:none"  name="dtl_by_day_only_mode" value="" id="dtl_by_day_only_mode" />
<input type="text" style="display:none"  name="dtl_by_pool_only_mode" value="" id="dtl_by_pool_only_mode" />
<input type="text" style="display:none"  name="dtl_by_eq_only_mode" value="" id="dtl_by_eq_only_mode" />

<input type="text" style="display:none"  name="tmp_common_code" value="" id="tmp_common_code" />

<input type="text" style="display:none"  name="agmtCurrCd" value="" id="agmtCurrCd" />
<input type="text" style="display:none"  name="agmtSts" value="" id="agmtSts" />

<input type="text" style="display:none"  name="is_valid_err_inv_no" value="" id="is_valid_err_inv_no" />
<input type="text" style="display:none"  name="whld_tax_amt_mode" value="" id="whld_tax_amt_mode" />

<input type="text" style="display:none"  name="curr_cd_tmp" value="" id="curr_cd_tmp" />
<input type="text" style="display:none" 	name="mdl_cd"		value="TES"> 

<input type="text" style="display:none"  name="eq_no" value="" id="eq_no" />
<input type="text" style="display:none"  name="tmp_eq_tpsz_cd" value="" id="tmp_eq_tpsz_cd" />

<input type="text" style="display:none" 	name="agmt_ftr_inv_tp_cd" value="ST"> 
<input type="text" style="display:none" 	name="cost_cd_ftr_rmk" value=""> 
<input type="text" style="display:none" 	name="ofc_cd" value="<%=ofc_cd%>">

<!--// eBilling - E //-->

<!-- special character, characterSet problem. //-->
<input type="text" style="display:none"  name="inv_no_tmp" value="<%=JSPUtil.getNull(inv_no)%>" id="inv_no_tmp" />

<input name="pre_cond_inv_no" type="text" style="display:none"  value="<%=JSPUtil.getNull(pre_cond_inv_no)%>" id="pre_cond_inv_no" />
<input name="pre_cond_inv_date_type" type="text" style="display:none"  value="<%=JSPUtil.getNull(pre_cond_inv_date_type)%>" id="pre_cond_inv_date_type" />
<input name="pre_cond_fm_prd_dt" type="text" style="display:none"  value="<%=JSPUtil.getNull(pre_cond_fm_prd_dt)%>" id="pre_cond_fm_prd_dt" />
<input name="pre_cond_to_prd_dt" type="text" style="display:none"  value="<%=JSPUtil.getNull(pre_cond_to_prd_dt)%>" id="pre_cond_to_prd_dt" />
<input name="pre_cond_yd_cd" type="text" style="display:none"  value="<%=JSPUtil.getNull(pre_cond_yd_cd)%>" id="pre_cond_yd_cd" />
<input name="pre_cond_vndr_seq" type="text" style="display:none"  value="<%=JSPUtil.getNull(pre_cond_vndr_seq)%>" id="pre_cond_vndr_seq" />
<input name="pre_cond_cost_ofc_cd" type="text" style="display:none"  value="<%=JSPUtil.getNull(pre_cond_cost_ofc_cd)%>" id="pre_cond_cost_ofc_cd" />
<input name="pre_cond_inv_ofc_cd" type="text" style="display:none"  value="<%=JSPUtil.getNull(pre_cond_inv_ofc_cd)%>" id="pre_cond_inv_ofc_cd" />
<input name="pre_cond_tml_inv_sts_cd" type="text" style="display:none"  value="<%=JSPUtil.getNull(pre_cond_tml_inv_sts_cd)%>" id="pre_cond_tml_inv_sts_cd" />
<input name="pre_cond_csr_no" type="text" style="display:none"  value="<%=JSPUtil.getNull(pre_cond_csr_no)%>" id="pre_cond_csr_no" />
<input name="pre_cond_csr_status" type="text" style="display:none"  value="<%=JSPUtil.getNull(pre_cond_csr_status)%>" id="pre_cond_csr_status" />
<input name="pre_cond_tml_inv_rjct_sts_cd" type="text" style="display:none"  value="<%=JSPUtil.getNull(pre_cond_tml_inv_rjct_sts_cd)%>" id="pre_cond_tml_inv_rjct_sts_cd" />


<!-- page_title_area(S) -->
<div class="page_title_area clear">
<!-- page_title(S) -->
<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
<!-- page_title(E) -->
<!-- opus_design_btn(S) -->
<div class="opus_design_btn">
<div id="PreInquiryCondLayer01" style="display:none"><button type="button" class="btn_accent" name="btn_pre_inquiry_cond" id="btn_pre_inquiry_cond">To Inv. Summary</button></div><!--
 --> <button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
 --> <button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
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
		<!-- : ( Week ) (S) -->
		<table>
		<colgroup>
			<col width="68">
			<col width="260">
			<col width="50">
			<col width="135">
			<col width="50">
			<col width="200">
			<col width="50">
			<col width="*">
		</colgroup>
		<tr class="h23">			
			<th><!-- img class="nostar" -->S/P Code</th>
			<td><input class="input1" type="text" name="vndr_seq" value="" tabindex='1' value='' maxlength=6 style="width:68px" onKeyUp='tes_isNum(this);' onKeyDown='tes_isNum(this); tes_chkInput(this);' onBlur='this.value=tes_lpad(this.value,this.maxLength,"0"); validateVndrSeq();'><!-- 
			 --><button type="button" name="btn_vndr" id="btn_vndr" class="input_seach_btn"></button><!-- 
			  --><input type="text" style="display:none"  name="vndr_seq_hidden" value=''><!-- 
			   --><input type="text" style="display:none"  name="is_valid_vndr_seq" value=''></td>
			<th><!-- img class="nostar" -->S/P Name</th>
			<td><input class="input2" type="text" style="width:115px" value=""  name ="vndr_seq_nm" valid="1" class="input2" readOnly ></td>
			<th><!-- img class="nostar" -->INV NO</th>
			<td><input class="input1" type="text" name="inv_no" value="" tabindex='2' maxlength="30" style="width:90px" onKeyUp='isApNum2(this);' onKeyPress='tes_enterCheck("retrieve");' onKeyDown='tes_chkInput(this);'  onBlur='validateInvDupChk();'></td>
										<input type="text" style="display:none"  name="inv_no_hidden" value=''>
									  	<input type="text" style="display:none"  name="is_dup_inv_no" value=''>
			<th>Error INV NO</th>
			<td><input type="text" name="err_inv_no" maxlength="30" style="width:85px" onKeyDown='tes_chkInput(this);' onBlur='validateErrInvNo();'></td>
		</tr>
		</table>
		<!-- : ( Week ) (E) -->
				
	</div>
	<!-- opus_design_inquiry (E) -->
	<!-- wrap_search(E) -->  
	<div class="line_bluedot"></div>
	<!-- wrap_search(S) -->  
	<!-- layout_wrap(S) -->
	<div class="layout_wrap wFit" style="width: 80%">
		<!-- layout_vertical_2(S) -->
			<div class="layout_vertical_2" style="width: 50%">
				<!--Content-->
				<!-- opus_design_inquiry (S) -->
				<div class="opus_design_inquiry">
					<!-- : ( Week ) (S) -->
						<table>
						<tbody>
						<colgroup>
							<col width="68">
							<col width="260">
							<col width="50">
							<col width="*">
						</colgroup>
						<tr>
							<th><!-- img class="nostar" -->Yard Code</th>
							<td><input class="input1" type="text" name="yd_cd" value='' maxlength=7 style="width:67px" onKeyUp='tes_isApNum(this); this.value=this.value.toUpperCase();' onKeyDown='tes_chkInput(this); this.value=this.value.toUpperCase();' onBlur='getYardName();'><!-- 
							 --><button type="button" name="btn_yard" id="btn_yard"  class="input_seach_btn"></button><!-- 
							  --><input type="text" style="display:none"  name="yd_cd_hidden" value=''><input type="text" style="display:none"  name="is_valid_yd_cd" value=''><input type="text" style="display:none"  name="yd_chr_cd" value=''><input type="text" style="display:none"  name="yd_fcty_tp_mrn_tml_flg" value=''><input type="text" style="display:none"  name="yd_fcty_tp_cy_flg" value=''><input type="text" style="display:none"  name="yd_fcty_tp_cfs_flg" value=''><input type="text" style="display:none"  name="yd_fcty_tp_rail_rmp_flg" value=''><input type="text" style="display:none"  name="yd_oshp_cd" value=''>
							</td>
							<th><!-- img class="nostar" -->Yard Name</th>
							<td><input class="input2" type="text" name="yd_nm" class="input2" style="width:92px" readonly></td></tr>
						<tr>
							<th><!-- img class="nostar" -->Cost OFC</th>
							<td><input class="input1" type="text" name="cost_ofc_cd" value='' maxlength=6 style="width:67px" onKeyUp='tes_isApNum(this); this.value=this.value.toUpperCase();' onKeyDown='tes_chkInput(this); this.value=this.value.toUpperCase();' onBlur='validateCostOFC();' readonly><!-- 
							 --><button type="button" name="btn_cost_ofc_cd" id="btn_cost_ofc_cd"  class="input_seach_btn"></button><input type="text" style="display:none"  name="cost_ofc_cd_hidden" value=''><input type="text" style="display:none"  name="is_valid_cost_ofc_cd" value=''></td>
							<th><!-- img class="nostar" -->INV OFC</th>
							<td><input class="input2" type="text" name="inv_ofc_cd" maxlength=6 style="width:92px" class="input2" value="<%=ofc_cd%>" readonly></td>
							</tr>
						<tr>
							<th><!-- img class="nostar" -->Currency</th>
							<td><script type="text/javascript">ComComboObject('curr_cd', 1, 92, 1, 1)</script></td>
							<th><!-- img class="nostar" --><label for="hld_flg">Hold</label></th>					
							<td><input type="checkbox" name="hld_flg" id="hld_flg" value="" class="trans" onClick='setHldRmk();'> 
								<button type="button" class="btn_etc" name="btns_remarks" id="btns_remarks">Remarks</button>
								<input type="text" style="display:none"  name="hld_rmk" id="hld_rmk" maxlength="500" value="">
							</td>													
						<tr>
							<th><!-- img class="nostar" -->Period</th>
							<td><input class="input1" type="text" name="fm_prd_dt" style="width:67px" value="" maxlength=10 onKeyUp='tes_isNumD(this,"Y"); tes_moveFocus(this,this.form.to_prd_dt,10);' onKeyDown='tes_chkInput(this); tes_isNumD(this,"Y");' onBlur='if(validateDateObj(this)){period_ChkMod();}'><!--  
								--><button type="button" name="btns_calendar1" id="btns_calendar1"  class="calendar ir"></button><!-- 
							 	--><span class="dash">~</span><!-- 
							  	--><input class="input1" type="text" name="to_prd_dt" style="width:68px" value="" maxlength=10 onKeyUp='tes_isNumD(this,"Y");' onKeyDown='tes_chkInput(this); tes_isNumD(this,"Y");' onBlur='if(validateDateObj(this)){period_ChkMod();}'><!--  
							  	--><button type="button" name="btns_calendar2" id="btns_calendar2"  class="calendar ir"></button>
							</td>
							
							<th>AGMT COST CD</th>
							<td><script type="text/javascript">ComComboObject('agmt_lgs_cost_cd', 2, 91, 1, 1)</script></td>									
									
						</tr>
					</tbody>
				</table>
						<!-- : ( Week ) (E) -->
				</div>
		</div>	
		
		
				<!-- layout_vertical_2(S) -->
				<div class="layout_vertical_2" style="width: 50%">
					<!-- opus_design_inquiry (S) -->
					<div class="opus_design_inquiry">
								<!-- : ( Week ) (S) -->
						<table class="search" border="0" width="100%">
						<tbody>
							<colgroup>
								<col width="68">
								<col width="260">
								<col width="50">
								<col width="*">
							</colgroup>
							<tr>
								<th><!-- img class="nostar" -->INV AMT</th>
								<td><input class="input1" type="text" name="ttl_inv_amt" maxlength=14 style="width:105px;text-align:right;" valid="1" desc="Inv. AMT" onKeyUp='tes_isMon(this,"Y",this.form.curr_cd.Code);' onKeyDown='tes_chkInput(this); tes_isMon(this,"Y",this.form.curr_cd.Code);' onBlur="tes_chkAmtFmtObj(this,this.form.curr_cd.Code); set_total_amount();" /></td>
								<th><!-- img class="nostar" -->TAX</th>
								<td><input type="text" name="vat_amt" maxlength=14 style="width:105px;text-align:right;" desc="V.A.T" onKeyUp='tes_isMon(this,"Y",this.form.curr_cd.Code);' onKeyDown='tes_chkInput(this); tes_isMon(this,"Y",this.form.curr_cd.Code);' onBlur="tes_chkAmtFmtObj(this,this.form.curr_cd.Code); set_total_amount();" /></td></tr>
							<tr>
								<th><!-- img class="nostar" -->W.H.T</th>
								<td><input type="text" name="whld_tax_amt" maxlength=20 style="width:105px;text-align:right;" onKeyUp='tes_isMon(this,"Y",this.form.curr_cd.Code);' onKeyDown='tes_chkInput(this); tes_isMon(this,"Y",this.form.curr_cd.Code);' onBlur="tes_chkAmtFmtObj(this,this.form.curr_cd.Code); set_total_amount();" /></td>
								<th><!-- img class="nostar" -->Total AMT</th>
								<td><input class="input2" type="text" name="total_amt" maxlength=22 style="width:105px;text-align:right;" readonly></td></tr>
							<tr>
								<th><!-- img class="nostar" -->Issued DT</th>
								<td><input class="input1" type="text" style="width:75px" maxlength=10 name="iss_dt" onKeyUp='tes_isNumD(this,"Y");' onKeyDown='tes_chkInput(this); tes_isNumD(this,"Y");' onBlur='validateDateObj2(this);'><!-- 
								 --><button type="button" name="btns_calendar3" id="btns_calendar3"  class="calendar ir"></button></td>							
								<th><!-- img class="nostar" -->Received DT</th>
								<td><input class="input1" type="text" style="width:75px" maxlength=10 name="rcv_dt" onKeyUp='tes_isNumD(this,"Y");' onKeyDown='tes_chkInput(this); tes_isNumD(this,"Y");' onBlur='validateDateObj2(this);'><!-- 
								 --><button type="button" name="btns_calendar4" id="btns_calendar4"  class="calendar ir"></button></td>
						 	</tr>
							<tr>
								<th><!-- img class="nostar" -->INV STS</th>
								<td><input class="input2" type="text" name="tml_inv_sts_cd2" maxlength=2 value="" style="width:105px" class="input2" readonly><input type="text" style="display:none"  name="tml_inv_sts_cd" maxlength=2 value=""></td>
								<th><!-- img class="nostar" -->Reject STS</th>
								<td><input class="input2" type="text" name="tml_inv_rjct_sts_cd" maxlength=2 value="NL" style="width:105px" class="input2" readonly><input type="text" style="display:none"  name="inv_rjct_rmk" value=""></td></tr>
						</tbody>
						</table>
						<!-- : ( Week ) (E) -->
					</div>
				</div>	
	</div>
     <!-- layout_vertical_2(E) -->
     
<!-- layout_wrap(E) -->

<div class="line_bluedot"></div>

<!-- opus_design_inquiry (S) -->
<div class="opus_design_inquiry sm" style="width:330px;">
	<table>
		<colgroup>
			<col width="68px">
			<col width="*">
		</colgroup>
		<tr>
			<th style="text-align:center;"><strong>Cost Calc. Method</strong></th>
			<td> <strong>Storage(Day)</strong>    <input type="radio" name="StorageFD" id="StorageFD1" value="GIO" class="trans" onClick="setCalcCostCond();"><label for="StorageFD1">GIO</label>     <!--  
				--><input type="radio" name="StorageFD" id="StorageFD2" value="Date" class="trans" onClick="setCalcCostCond();"> <label for="StorageFD2">Date</label></td>
		</tr>
	</table>
</div>
<!-- opus_design_inquiry (E) -->
</div>
<!-- wrap_search(E) -->  

<div class="wrap_result">
	<!-- opus_tab_btn(S) -->
	<div class="opus_design_tab sm">
		<script type="text/javascript"> ComTabObject ('tab1')</script>
	</div>
	<!-- opus_tab_btn(E) -->


	<!-- UI_ESD_TES_009 : THIS IS 1st TAB -->
	<div id="tabLayer" style="display:inline">
		<div class="opus_design_grid" id="mainTable">
			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn">
			<!-- Content -->
				<button type="button" class="btn_normal" name="t1btng_listclear" id="t1btng_listclear">List Clear</button><!-- 
				 --><button type="button" class="btn_normal" name="t1btng_fileimport" id="t1btng_fileimport">File Import</button><!-- 
				  --><button type="button" class="btn_normal" name="t1btng_save" id="t1btng_save">Save</button><!-- 
				  --><button type="button" class="btn_normal" name="t1btng_downexcel" id="t1btng_downexcel">Down Excel</button><!-- 
				  --><button type="button" class="btn_normal" name="t1btng_todiscrepancy" id="t1btng_todiscrepancy">To Discrepancy</button><!-- 
				  --><button type="button" class="btn_normal" name="t1btng_costcalc" id="t1btng_costcalc">Cost Calc.</button>
			</div>
			<!-- opus_design_btn(e) -->
			
			<script type="text/javascript">ComSheetObject('t1sheet1');</script>
		</div>
		<!-- opus_design_data(S) -->
		<div class="opus_design_inquiry">
			<div id="SearchLayer01" style="display:inline">
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			</div>
			<table class="sbutton">
			    <tr>
					<td class="bt" style="float:right"><button type="button" class="btn_up" onClick="reSize();" id="btn_resize" name="btn_resize"></button></td>
				</tr>
			</table>
			<div id="SearchLayer02" style="display:inline">
				<table style="margin-bottom: 3px" class="grid2 wFit">
					<tr class="h23">
						<th width="4%">Total</th>
						<td width="15%"><input type="text" name='sht_01_ttl_box' value='' style="width:80" class="input2" readonly></td>
						<th width="3%">Full</th>
						<td width="14%"><input type="text" name='sht_01_full' value='' style="width:80" class="input2" readonly></td>
						<th width="3%">Empty</th>
						<td width="15%"><input type="text" name='sht_01_mt' style="width:80" class="input2" readonly></td>
						<!--td width="7%">TS(BKG)</td>
						<td width="14%"><input type="text" name='sht_01_ts_bkg' style="width:80" class="input2" readonly></td-->
						<th width="13%">TS(Same Yard)</th>
						<td><input type="text" name='sht_01_ts_same_yard' style="width:80" class="input2" readonly></td></tr>
				</table>
				<table class="grid2 wFit">
					<tr class="h23">
						<th width="18">D2 </th><td style="padding-bottom: 2px;" width="40"><input type="text" name="sht_01_D2" style="width:32px" class="input2" readonly></td>
						<th width="18">D4 </th><td width="40"><input type="text" name="sht_01_D4" style="width:32px" class="input2" readonly></td>
						<th width="18">D5 </th><td width="40"><input type="text" name="sht_01_D5" style="width:32px" class="input2" readonly></td>
						<th width="18">D7 </th><td width="40"><input type="text" name="sht_01_D7" style="width:32px" class="input2" readonly></td>
						<th width="18">D8 </th><td width="40"><input type="text" name="sht_01_D8" style="width:32px" class="input2" readonly></td>
						<th width="18">D9 </th><td width="40"><input type="text" name="sht_01_D9" style="width:32px" class="input2" readonly></td>
						<!-- 
						<th width="18">DW </th><td width="40"><input type="text" name="sht_01_DW" style="width:32px" class="input2" readonly></td>
						<th width="18">DX </th><td width="40"><input type="text" name="sht_01_DX" style="width:32px" class="input2" readonly></td>
						 -->
						<th width="18">R2 </th><td width="40"><input type="text" name="sht_01_R2" style="width:32px" class="input2" readonly></td>
						<th width="18">R4 </th><td width="40"><input type="text" name="sht_01_R4" style="width:32px" class="input2" readonly></td>
						<th width="18">R5 </th><td width="40"><input type="text" name="sht_01_R5" style="width:32px" class="input2" readonly></td>
						<th width="18">F2 </th><td width="40"><input type="text" name="sht_01_F2" style="width:32px" class="input2" readonly></td>
						<th width="18">F4 </th><td width="40"><input type="text" name="sht_01_F4" style="width:32px" class="input2" readonly></td>
						<th width="18">F5 </th><td width="40"><input type="text" name="sht_01_F5" style="width:32px" class="input2" readonly></td></tr>
					<tr class="h23">
						<th>O2</th><td><input type="text" name="sht_01_O2" style="width:32px" class="input2" readonly></td>
						<th>O4</th><td><input type="text" name="sht_01_O4" style="width:32px" class="input2" readonly></td>
						<th>S2</th><td><input type="text" name="sht_01_S2" style="width:32px" class="input2" readonly></td>
						<th>S4</th><td><input type="text" name="sht_01_S4" style="width:32px" class="input2" readonly></td>
						<th>T2</th><td><input type="text" name="sht_01_T2" style="width:32px" class="input2" readonly></td>
						<th>T4</th><td><input type="text" name="sht_01_T4" style="width:32px" class="input2" readonly></td>
						<th>A2</th><td><input type="text" name="sht_01_A2" style="width:32px" class="input2" readonly></td>
						<th>A4</th><td><input type="text" name="sht_01_A4" style="width:32px" class="input2" readonly></td>
						<th>P2</th><td><input type="text" name="sht_01_P2" style="width:32px" class="input2" readonly></td>
						<th>P4</th><td><input type="text" name="sht_01_P4" style="width:32px" class="input2" readonly></td>
						<th>Z2</th><td><input type="text" name="sht_01_Z2" style="width:32px" class="input2" readonly></td>
						<th>Z4</th><td><input type="text" name="sht_01_Z4" style="width:32px" class="input2" readonly></td>
						</tr>
				</table>
			</div>
		</div>
		<!-- opus_design_data(E) -->
	</div>
	
	<!-- UI_ESD_TES_010 : THIS IS 2st TAB -->
	<div id="tabLayer" style="display:none">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" id="mainTable">
			<!-- opus_design_btn(S) -->
				<div class="opus_design_btn">
				<!-- Content -->
					<button type="button" class="btn_normal" name="t2btng_listclear" id="t2btng_listclear">List Clear</button><!-- 
					 --><button type="button" class="btn_normal" name="t2btng_print" id="t2btng_print">Print</button><!-- 
					  --><button type="button" class="btn_normal" name="t2btng_downexcel" id="t2btng_downexcel">Down Excel</button><!-- 
					  --><button type="button" class="btn_normal" name="t2btng_verification" id="t2btng_verification">To Verification</button><!-- 
					  --><button type="button" class="btn_normal" name="t2btng_reject" id="t2btng_reject">Reject</button>
				</div>
				<!-- opus_design_btn(e) -->
			<script type="text/javascript">ComSheetObject('t2sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->
	</div>
	<!-- End Tab Layer -->

	<!-- UI_ESD_TES_011 : THIS IS 3st TAB -->
	<div id="tabLayer" style="display:none;">
		<div style="position:absolute;">			
			<table>
				<tr class="h23">
					<td align="right"><b>Calculated AMT</b>&nbsp;&nbsp;<input type="text" name='t3sht_tot_inv_amt' class="input2" style="width:150px;text-align:right;" readonly></td></tr>
			</table>
		</div>
		<div class="opus_design_grid" id="mainTable">
			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn" style="height:32px">
				<button type="button" class="btn_normal" name="t3btng_costCal" id="t3btng_costCal">Semi-Auto Calc.</button>
				<button type="button" class="btn_normal" name="t3btng_listclear" id="t3btng_listclear">List Clear</button><!-- 
				 --><button type="button" class="btn_normal" name="t3btng_rowadd" id="t3btng_rowadd">Row Add</button><!-- 
				  --><button type="button" class="btn_normal" name="t3btng_rowdel" id="t3btng_rowdel">Delete</button><!-- 
				  --><button type="button" class="btn_normal" name="t3btng_save" id="t3btng_save">Save</button><!-- 
				  --><button type="button" class="btn_normal" name="t3btng_totalamount" id="t3btng_totalamount">Total Amount</button><!-- 
				  --><button type="button" class="btn_normal" name="t3btng_confirm" id="t3btng_confirm">Confirm</button>
			</div>
			<!-- opus_design_btn(e) -->
			<script type="text/javascript">ComSheetObject('t3sheet1');</script>
		</div>
	</div>
	<!-- End Tab -->

	<div id="tabLayer" style="display:none;;">
		<div class="" style="position:absolute;">			
			<table>
				<tr class="h23">
					<td align="right"><b>Calculated AMT</b>&nbsp;&nbsp;<input type="text" name='t4sht_tot_inv_amt' class="input2" style="width:150px;text-align:right;" readonly></td></tr>
			</table>
		</div>
		<div class="opus_design_grid"  id="mainTable">
			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn" style="height:32px">
			<!-- Content -->
				<button type="button" class="btn_normal" name="t4btng_listclear" id="t4btng_listclear">List Clear</button><!-- 
				 --><button type="button" class="btn_normal" name="t4btng_rowadd" id="t4btng_rowadd">Row Add</button><!-- 
				  --><button type="button" class="btn_normal" name="t4btng_rowdel" id="t4btng_rowdel">Delete</button><!-- 
				  --><button type="button" class="btn_normal" name="t4btng_save" id="t4btng_save">Save</button><!-- 
				  --><button type="button" class="btn_normal" name="t4btng_totalamount" id="t4btng_totalamount">Total Amount</button><!-- 
				   --><button type="button" class="btn_normal" name="t4btng_reject" id="t4btng_reject">Reject</button><!-- 
				    --><button type="button" class="btn_normal" name="t4btng_confirm" id="t4btng_confirm">Confirm</button>
			</div>
			<!-- opus_design_btn(E) -->
			<script type="text/javascript">ComSheetObject('t4sheet1');</script>
		</div>
	</div>
<!-- End Tab -->

<div id="main_hidden_sheets" style="display:none">
<!--// HIDDEN SHEET : Temporary header Information //-->
main_hidden_sheets - sheet[4]
<script type="text/javascript">ComSheetObject('main_hidden');</script>
</div>
<!--br><br-->
<div id="rjct_hidden_sheets" style="display:none; width:50%">
<!--// HIDDEN SHEET : Temporary reject rsult //-->
rjct_hidden_sheets - sheet[5]
<script type="text/javascript">ComSheetObject('rjct_hidden');</script>
</div>
<!--br><br-->
<div id="conf_hidden_sheets" style="display:none; width:50%">
<!--// HIDDEN SHEET : Temporary confirm result //-->
conf_hidden_sheets - sheet[6]
<script type="text/javascript">ComSheetObject('conf_hidden');</script>
</div>
<!--br><br-->
<div id="dupchk_hidden_sheets" style="display:none;">
<!--// HIDDEN SHEET : Temporary confirm result //-->
dupchk_hidden_sheets - sheet[7]
<script type="text/javascript">ComSheetObject('dupchk_hidden');</script>
</div>
	<!-- UI_ESD_TES_011 : THIS IS 5rd TAB -->
	<div id="tabLayer" style="display:none;">
		<div style="position:absolute;">			
			<table>
				<tr class="h23">
					<td align="right"><b>Calculated AMT</b>&nbsp;&nbsp;<input type="text" name='t5sht_tot_inv_amt' class="input2" style="width:150px;text-align:right;" readonly></td></tr>
			</table>
		</div>
		<div class="opus_design_grid" id="mainTable">
			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn" style="height:32px">
				<button type="button" class="btn_normal" name="t5btng_costCal" id="t5btng_costCal">Semi-Auto Calc.</button>
				<button type="button" class="btn_normal" name="t5btng_listclear" id="t5btng_listclear">List Clear</button><!-- 
				 --><button type="button" class="btn_normal" name="t5btng_rowadd" id="t5btng_rowadd">Row Add</button><!-- 
				  --><button type="button" class="btn_normal" name="t5btng_rowdel" id="t5btng_rowdel">Delete</button><!-- 
				  --><button type="button" class="btn_normal" name="t5btng_save" id="t5btng_save">Save</button><!-- 
				  --><button type="button" class="btn_normal" name="t5btng_totalamount" id="t5btng_totalamount">Total Amount</button><!-- 
				  --><button type="button" class="btn_normal" name="t5btng_confirm" id="t5btng_confirm">Confirm</button>
			</div>
			<!-- opus_design_btn(e) -->
			<script type="text/javascript">ComSheetObject('t5sheet1');</script>
		</div>
	</div>
</div>



<script>

	<%//=TESUtil.getCodeValue("DBdate", "TEST1818", "", "", "CntrTPSZCDList", "AutoTESTmlSoCostCDList", "", "", "", "")%>

</script>
</form>
