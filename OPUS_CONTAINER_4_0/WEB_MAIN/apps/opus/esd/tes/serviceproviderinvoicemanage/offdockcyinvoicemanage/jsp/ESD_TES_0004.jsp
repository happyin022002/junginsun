<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESD_TES_004.jsp
*@FileTitle  : Off-dock CY Invoice Management
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/28
=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%
	Exception serverException   = null;			//Server Exception
	String strErrMsg = "";						//Error Message
	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}	
	String userId = "";
	String ofc_cd = "";
	String inv_no="";
	String vndr_seq="";
	inv_no = JSPUtil.getNull(request.getParameter("inv_no"));
	vndr_seq = JSPUtil.getNull(request.getParameter("vndr_seq"));
    SignOnUserAccount account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    userId = account.getUsr_id()!=null&&!account.getUsr_id().equals("")?account.getUsr_id():"";
    ofc_cd = account.getOfc_cd()!=null&&!account.getOfc_cd().equals("")?account.getOfc_cd():""; //test? ?..
	/** 2009-10-15 : [PJM-200900072]  INVOICE Inquiry conditions - retrieving in case of sucessful Inquiry page    **/
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
	<%= JSPUtil.getIBCodeCombo("tml_trns_mod_cd", "01", "CD00965", 0, "")%>
	var inv_no = "<%=JSPUtil.getNull(inv_no)%>";
	var vndr_seq = '<%=JSPUtil.getNull(vndr_seq)%>';
	var inv_ofc_cd = '<%=JSPUtil.getNull(ofc_cd)%>';
    function setupPage(){
	    var errMessage = "<%=strErrMsg%>";
	    if (errMessage.length >= 1) {
	    	ComShowMessage(errMessage);
	    }
		loadPage();
	}
</script>

<!--//
tabindex A, AREA, BUTTON, INPUT, OBJECT, SELECT, TEXTAREA Etc. can be applied
//-->
<form name="form">
<input type="text" style="display:none"  name="f_cmd" id="f_cmd" />
<input type="text" style="display:none"  name="f_cmd_rjct" id="f_cmd_rjct" />
<input type="text" style="display:none"  name="iPage" id="iPage" />
<input type="text" style="display:none"  name="DB_DATE" value="" id="DB_DATE" />

<input type="text" style="display:none"  name="tml_so_ofc_cty_cd" value="" id="tml_so_ofc_cty_cd" />
<input type="text" style="display:none"  name="tml_so_seq" value="" id="tml_so_seq" />
<input type="text" style="display:none"  name="tml_agmt_ofc_cty_cd" value="" id="tml_agmt_ofc_cty_cd" />
<input type="text" style="display:none"  name="tml_agmt_seq" value="" id="tml_agmt_seq" />
<input type="text" style="display:none"  name="tml_agmt_ver_no" value="" id="tml_agmt_ver_no" />
<input type="text" style="display:none"  name="vrfy_rslt_ind_cd" value="" id="vrfy_rslt_ind_cd" />

<input type="text" style="display:none" 	name="mdl_cd"		value="TES"> 

<!-- special character, characterSet problem. //-->
<input type="text" style="display:none"  name="inv_no_tmp" value="<%=JSPUtil.getNull(inv_no)%>" id="inv_no_tmp" />

<!----------------------------------------------------------------------
	# yd_chr_inv_tp_cd : yard to retrieve the value for the code
	1. Marine Terminal Invoice = 'MT'
	2. On-dock Rail Charge Invoice = 'ON'
	3. Off-dock CY Invoice(Terminal) = 'OT'
	4. Off-dock CY Invoice(Storage) = 'OS'
	5. Storage Invoice = 'ST'
------------------------------------------------------------------------>
<input type="text" style="display:none"  name="yd_chr_inv_tp_cd" value="" id="yd_chr_inv_tp_cd" />
<input type="text" style="display:none"  name="calcTerminalComboItems" value="" id="calcTerminalComboItems" />
<input type="text" style="display:none"  name="calcStorageComboItems" value="" id="calcStorageComboItems" />

<input type="text" style="display:none"  name="tml_inv_tp_cd" value="OF" id="tml_inv_tp_cd" />
<input type="text" style="display:none"  name="tml_cost_grp_cd" value="" id="tml_cost_grp_cd" />
<input type="text" style="display:none"  name="tml_calc_ind_cd" value="" id="tml_calc_ind_cd" />
<input type="text" style="display:none"  name="sto_dys_ind_cd" value="" id="sto_dys_ind_cd" />

<input type="text" style="display:none"  name="cost_calc_mode" value="" id="cost_calc_mode" />
<input type="text" style="display:none"  name="dup_chk_mode" value="" id="dup_chk_mode" />
<input type="text" style="display:none"  name="confirm_mode" value="" id="confirm_mode" />
<input type="text" style="display:none"  name="dtl_by_pool_only_mode" value="" id="dtl_by_pool_only_mode" />
<input type="text" style="display:none"  name="dtl_by_eq_only_mode" value="" id="dtl_by_eq_only_mode" />

<input type="text" style="display:none"  name="tmp_common_code" value="" id="tmp_common_code" />

<input type="text" style="display:none"  name="agmtCurrCd" value="" id="agmtCurrCd" />
<input type="text" style="display:none"  name="agmtSts" value="" id="agmtSts" />

<input type="text" style="display:none"  name="is_valid_err_inv_no" value="" id="is_valid_err_inv_no" />
<input type="text" style="display:none"  name="whld_tax_amt_mode" value="" id="whld_tax_amt_mode" />

<input type="text" style="display:none"  name="curr_cd_tmp" value="" id="curr_cd_tmp" />

<input type="text" style="display:none"  name="eq_no" value="" id="eq_no" />
<input type="text" style="display:none"  name="tmp_eq_tpsz_cd" value="" id="tmp_eq_tpsz_cd" />
<input type="text" style="display:none"  name="calcOffEqComboItems" value="" id="calcOffEqComboItems" />

<input type="text" style="display:none" 	name="agmt_ftr_inv_tp_cd" value=""> 
<input type="text" style="display:none" 	name="cost_cd_ftr_rmk" value=""> 
<input type="text" style="display:none" 	name="ofc_cd" value="<%=ofc_cd%>">

<!--	2009-10-15 : [PJM-200900072]  INVOICE Inquiry conditions - retrieving in case of sucessful Inquiry page    -->
<!--	Invoice previous values ( 2009-10-15 )	-->
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

<!-- 20150507 cost calc 때문에 추가함 -->
<input type="text" style="display:none"  name="org_tml_odck_flg" value="" id="org_tml_odck_flg" />
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
		</div>
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
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

<!-- opus_design_inquiry(S) -->
<div class="wrap_search_tab">
	<div class="opus_design_inquiry wFit">
		<table>
			<tbody>
				<colgroup>
					<col width="75"/>
					<col width="120"/>
					<col width="75"/>
					<col width="120"/>
					<col width="70"/>
					<col width="120"/>
					<col width="70"/>
					<col width="100"/>
					<col width="68"/>
					<col width="*"/>
			    </colgroup>
				<tr>
					<th>S/P Code</th>
					<td><input class="input" type="text" name="vndr_seq" id="vndr_seq" value='' tabindex='1' maxlength="6" style="width:80px;" onKeyUp='tes_isNum(this);' onKeyDown='tes_isNum(this); tes_chkInput(this);' onBlur='this.value=tes_lpad(this.value,this.maxLength,"0"); validateVndrSeq();'><!-- 
						 --><button type="button" class="input_seach_btn" name="btn_vndr" id="btn_vndr"></button><input type="text" style="display:none"  name="vndr_seq_hidden" id="vndr_seq_hidden" value=''><input type="text" style="display:none"  name="is_valid_vndr_seq" id="is_valid_vndr_seq" value=''></td>
					<th>S/P Name</th>
					<td><input class="input" type="text" style="width:115px;" value=""  name ="vndr_seq_nm" id="vndr_seq_nm" valid="1"></td>
					<th>INV NO</th>
					<td><input class="input1" type="text" value='' readonly name="inv_no" id="inv_no" tabindex='2' maxlength="30" style="width:90px;" onKeyUp='isApNum2(this);'  onKeyPress='tes_enterCheck("retrieve");' onKeyDown='tes_chkInput(this);'   onBlur='validateInvDupChk();'></td>
										<input type="text" style="display:none"  name="inv_no_hidden" value=''>
									  	<input type="text" style="display:none"  name="is_dup_inv_no" value=''>
					<th>Error INV NO</th>
					<td><input class="input" type="text" name="err_inv_no" id="err_inv_no" maxlength="30" style="width:85px;" onKeyDown='tes_chkInput(this);' onBlur='validateErrInvNo();' readonly></td>
					<th>Off /On</th>
					<td>	<select class="input" name="tml_odck_flg" id="tml_odck_flg"  onChange="tmlOdckFlgChange();" style="width:87px;"> 
							<option value="N">Off Dock </option>
							<option value="Y">On Dock</option>
							</select>
					</td>					
				</tr>
			</tbody>
		</table>
	</div>
<!-- opus_design_inquiry(E) -->

<div class="line_bluedot"></div>

<!-- layout_wrap(S) -->
	<div class="opus_design_inquiry wFit">
		<div class="layout_wrap">
		    <div class="layout_vertical_2" style="width:40%">
		        <!-- opus_design_inquiry(S) -->
		        <div class="opus_design_data mar_top_8 mar_btm_8 mar_rgt_8" style="height:110px">
		           <table>
					<tbody>
						<colgroup>
							<col width="73"/>
							<col width="170"/>
							<col width="75"/>					
							<col width="*"/>
					    </colgroup>
						<tr>
							<th>Yard Code</th>
							<td>
								<input class="input" type="text" name="yd_cd" id="yd_cd" value='' maxlength=7 style="width:80px" onKeyUp='tes_isApNum(this); this.value=this.value.toUpperCase();' onKeyDown='tes_chkInput(this);' onBlur='getYardName(); this.value=this.value.toUpperCase();'><button type="button" class="input_seach_btn" name="btn_yard" id="btn_yard"></button><!-- 
								 --><input type="text" style="display:none"  name="yd_cd_hidden" value="" id="yd_cd_hidden" /><!-- 
								 --><input type="text" style="display:none"  name="is_valid_yd_cd" value="" id="is_valid_yd_cd" /><!-- 
								 --><input type="text" style="display:none"  name="yd_chr_cd" value="" id="yd_chr_cd" /><!-- 
								 --><input type="text" style="display:none"  name="yd_fcty_tp_mrn_tml_flg" value="" id="yd_fcty_tp_mrn_tml_flg" /><!-- 
								 --><input type="text" style="display:none"  name="yd_fcty_tp_cy_flg" value="" id="yd_fcty_tp_cy_flg" /><!-- 
								 --><input type="text" style="display:none"  name="yd_fcty_tp_cfs_flg" value="" id="yd_fcty_tp_cfs_flg" /><!-- 
								 --><input type="text" style="display:none"  name="yd_fcty_tp_rail_rmp_flg" value="" id="yd_fcty_tp_rail_rmp_flg" /><!-- 
								 --><input type="text" style="display:none"  name="yd_oshp_cd" value="" id="yd_oshp_cd" />
							</td>
							<th>Yard Name</th>
							<td><input class="input" type="text" name="yd_nm" style="width:92px;" readonly id="yd_nm" /></td>
						</tr>
						<tr>
							<th>Cost OFC</th>
							<td><input class="input" type="text" name="cost_ofc_cd" id="cost_ofc_cd" value='' maxlength=6 style="width:80px" onKeyUp='tes_isApNum(this); this.value=this.value.toUpperCase();' onKeyDown='tes_chkInput(this); this.value=this.value.toUpperCase();' onBlur='validateCostOFC();' readonly><button type="button" name="btn_cost_ofc_cd" id="btn_cost_ofc_cd" class="input_seach_btn"></button><input type="text" style="display:none"  name="cost_ofc_cd_hidden" id="cost_ofc_cd_hidden" value=''><input type="text" style="display:none"  id="is_valid_cost_ofc_cd" name="is_valid_cost_ofc_cd" value=''></td>
							<th>INV OFC</th>
							<td><input class="input" type="text" name="inv_ofc_cd" id="inv_ofc_cd" maxlength=6 style="width:92px" class="input" value="<%=ofc_cd%>" readonly></td>
						</tr>
						<tr>
							<th>Currency</th>
							<td><script type="text/javascript">ComComboObject('curr_cd', 1, 105, 1, 1)</script></td>
							<th><label for="hld_flg">Hold</label></th>
							<td style="vertical-align:middle;"><input type="checkbox" name="hld_flg" id="hld_flg" value="" class="trans" onClick='setHldRmk();'>&nbsp;<!-- 
								--><button type="button" class="btn_etc" name="btns_remarks" 		id="btns_remarks">Remarks</button><!--  
								--><input type="text" style="display:none"  name="hld_rmk" id="hld_rmk" maxlength="500" value="">
							</td>
						</tr>
						<tr>
							<th>Period</th>
							<td><input class="input" type="text" name="fm_prd_dt" id="fm_prd_dt" style="width:70px" value="" maxlength=10 onKeyUp='tes_isNumD(this,"Y"); tes_moveFocus(this,this.form.to_prd_dt,10);' onKeyDown='tes_chkInput(this); tes_isNumD(this,"Y");' onBlur='if(validateDateObj(this)){period_ChkMod();}'><button type="button" id="btns_calendar1" name="btns_calendar1" class="calendar ir"></button><span class="dash">~</span><input class="input" type="text" name="to_prd_dt" id="to_prd_dt" style="width:70px" value="" maxlength=10 onKeyUp='tes_isNumD(this,"Y");' onKeyDown='tes_chkInput(this); tes_isNumD(this,"Y");' onBlur='if(validateDateObj(this)){period_ChkMod();}'><button type="button" class="calendar ir" name="btns_calendar2" id="btns_calendar2"></button></td>
							
							<th>AGMT COST CD</th>
							<td><script type="text/javascript">ComComboObject('agmt_lgs_cost_cd', 2, 91, 1, 1)</script></td>									
						</tr>
					</tbody>
				</table>
		        </div>
		        <!-- opus_design_inquiry(E) -->
		    </div>
		    <div class="layout_vertical_2" style="width:50%">
		        <!-- opus_design_inquiry(S) -->
				<div class="opus_design_data mar_top_8" style="height:110px">
					<table>
						<tbody>
							<colgroup>
								<col width="75"/>
								<col width="170"/>
								<col width="75"/>					
								<col width="*"/>
							</colgroup>
							<tr>
								<th>INV AMT</th>
								<td><input class="input" type="text" id="ttl_inv_amt" name="ttl_inv_amt" maxlength=14 style="width:108px;text-align:right;" onKeyUp='tes_isMon(this,"Y",this.form.curr_cd.Code);' onKeyDown='tes_chkInput(this); tes_isMon(this,"Y",this.form.curr_cd.Code);' onBlur="tes_chkAmtFmtObj(this,this.form.curr_cd.Code); set_total_amount();"></td>
								<th>TAX</th>
								<td><input class="input" type="text" id="vat_amt" name="vat_amt" maxlength=14 style="width:108px;text-align:right;" onKeyUp='tes_isMon(this,"Y",this.form.curr_cd.Code);' onKeyDown='tes_chkInput(this); tes_isMon(this,"Y",this.form.curr_cd.Code);' onBlur="tes_chkAmtFmtObj(this,this.form.curr_cd.Code); set_total_amount();"></td>
							</tr>
							<tr>
								<th>W.H.T</th>
								<td><input class="input" type="text" id="whld_tax_amt" name="whld_tax_amt" maxlength=20 style="width:108px;text-align:right;" onKeyUp='tes_isMon(this,"Y",this.form.curr_cd.Code);' onKeyDown='tes_chkInput(this); tes_isMon(this,"Y",this.form.curr_cd.Code);' onBlur="tes_chkAmtFmtObj(this,this.form.curr_cd.Code); set_total_amount();" readonly></td>
								<th>Total AMT</th>
								<td><input class="input" type="text" id="total_amt" name="total_amt" maxlength=22 style="width:108px;text-align:right;" readonly></td>
							</tr>
							<tr>
								<th>Issued DT</th>
								<td><input class="input" type="text" style="width:80px" maxlength=10 name="iss_dt" id="iss_dt" onKeyUp='tes_isNumD(this,"Y");' onKeyDown='tes_chkInput(this); tes_isNumD(this,"Y");' onBlur='validateDateObj2(this);'><button type="button" class="calendar ir"  name="btns_calendar3"  id="btns_calendar3"></button></td>
								<th>Received DT</th>
								<td><input class="input" type="text" style="width:80px" maxlength=10 id="rcv_dt" name="rcv_dt" onKeyUp='tes_isNumD(this,"Y");' onKeyDown='tes_chkInput(this); tes_isNumD(this,"Y");' onBlur='validateDateObj2(this);'><button type="button" class="calendar ir"  name="btns_calendar4" id="btns_calendar4"></button></td>
							</tr>
							<tr>
								<th>INV STS</th>
								<td><input class="input" type="text" id="tml_inv_sts_cd2" name="tml_inv_sts_cd2" maxlength=2 value="" style="width:108px" class="input" readonly><input type="text" style="display:none"  name="tml_inv_sts_cd" id="tml_inv_sts_cd" maxlength=2 value=""></td>
								<th>Reject STS</th>
								<td><input class="input" type="text" name="tml_inv_rjct_sts_cd" id="tml_inv_rjct_sts_cd" maxlength=2 value="NL" style="width:108px" class="input" readonly><input type="text" style="display:none"  name="inv_rjct_rmk" id="inv_rjct_rmk" value=""></td>
							</tr>
						</tbody>
					</table>
		        </div>
		        <!-- opus_design_inquiry(E) -->
		    </div>
		</div>
	</div>
<!-- layout_wrap(E) -->

<div class="line_bluedot"></div>

<!-- opus_design_inquiry(S) -->

	<div class="opus_design_inquiry wFit sm">		
		<table >
			<tbody>
				<colgroup>
					<col width="170"/>
					<col width="250"/>
					<col width="180"/>	
					<col width="*"/>
				</colgroup>
				<tr>
					<th style="text-align:center;"><strong>Cost Group</strong></th>
					<th style="text-align:left;"> <strong><label for="TMNL">TMNL</label></strong> <input type="checkbox" name="TMNL" id="TMNL" value="" class="trans" onClick="setRadioOptionEnable(); setCalcCostCond();" checked><!--  
						-->       <strong><label for="StorageDay">Storage Day</label></strong> <!--  
						--><input type="checkbox" id="StorageDay" name="StorageDay" value="" class="trans" onClick="setRadioOptionEnable(); setCalcCostCond();" checked></th>
        			<th style="text-align:center;"><strong>Cost Calc. Method</strong></th>
        			<th style="text-align:left;"> 
        			<strong><label for="CostCalcMethod1">TP(Gate Out Base)</label></strong> <input type="radio" name="CostCalcMethod" id="CostCalcMethod1" value="TP" class="trans" onClick="setCalcCostCond();">
        			<strong><label for="CostCalcMethod2">Separate & Date</label></strong> <input type="radio" name="CostCalcMethod" id="CostCalcMethod2" value="SP" class="trans" onClick="setCalcCostCond();">
        			<strong><label for="CostCalcMethod3">Gates</label></strong> <input type="radio" name="CostCalcMethod" id="CostCalcMethod3" value="GP" class="trans" onClick="setCalcCostCond();"></th>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->
<div class="wrap_result">
<!-- opus_tab_btn(S) -->
	<div class="opus_design_tab">
		<script type="text/javascript">ComTabObject('tab1')</script>
	</div>
	<!-- opus_tab_btn(E) -->
	<div name="tabLayer" id="tabLayer" style="display:inline;">
		<div class="opus_design_grid">
			<div class="opus_design_btn"><!-- 
				 --><button type="button" class="btn_normal" name="t1btng_listclear" 	id="t1btng_listclear">List Clear</button><!-- 
				 --><button type="button" class="btn_normal" name="t1btng_fileimport" 	id="t1btng_fileimport">File Import</button><!-- 
				 --><button type="button" class="btn_normal" name="t1btng_save" 		id="t1btng_save">Save</button><!-- 
				 --><button type="button" class="btn_normal" name="t1btng_downexcel" 	id="t1btng_downexcel">Down Excel</button><!-- 
				 --><button type="button" class="btn_normal" name="t1btng_todiscrepancy" 	id="t1btng_todiscrepancy">To Discrepancy</button><!-- 
				 --><button type="button" class="btn_normal" name="t1btng_costcalc" 	id="t1btng_costcalc">Cost Calc.</button>
			</div>
			<script type="text/javascript">ComSheetObject('t1sheet1');</script>
		</div>
		<table class="sbutton">
			<colgroup>
				<col width="*">
				<col width="20">
			</colgroup>
		    <tr>
		    	<td>&nbsp;</td>
		    	<td><button type="button" name="btnhide" id="btnhide" onClick="showSummary();" class="btn_up"></button></td>
			</tr>
		</table>
		<div id="SearchLayer01" style="display:inline">
			<table class="line_bluedot">
				<tr><td></td></tr>
			</table>
		</div>
		<div id="SearchLayer02" style="display:inline">
			<!-- opus_design_inquiry(S) -->
			<div class="opus_design_inquiry wFit">
				<table class="grid2">
					<tbody>
					<colgroup>
						<col width="30">
						<col width="160">
						<col width="30">
						<col width="160">
						<col width="30">
						<col width="160">
						<col width="60">
						<col width="*">
					</colgroup>
					<tr>
						<th>Total</th>
						<td><input type="text" name='sht_01_ttl_box' id='sht_01_ttl_box' value='' style="width:80px" class="input" readonly></td>
						<th>Full</th>
						<td><input type="text" name='sht_01_full' id='sht_01_full' value='' style="width:80px" class="input" readonly></td>
						<th>Empty</th>
						<td><input type="text" name='sht_01_mt' id='sht_01_mt' style="width:80px" class="input" readonly></td>
						<th>TS(Same Yard)</th>
						<td><input type="text" name='sht_01_ts_same_yard' id='sht_01_ts_same_yard' style="width:80px" class="input" readonly></td>
					</tr>
				</table>
				<table class="grid2">
					<colgroup>
						<col width="30">
						<col width="40">
						<col width="30">
						<col width="40">
						<col width="30">
						<col width="40">
						<col width="30">
						<col width="40">
						<col width="30">
						<col width="40">
						<col width="30">
						<col width="40">
						<col width="30">
						<col width="40">
						<col width="30">
						<col width="40">
						<col width="30">
						<col width="40">
						<col width="30">
						<col width="40">
						<col width="30">
						<col width="40">
						<col width="30">
						<col width="40">
						<col width="30">
						<col width="40">
						<col width="30">
						<col width="*">
					</colgroup>
					<tr>
						<th>D2 </th>
						<td><input type="text" name="sht_01_D2" style="width:32px;" class="input" readonly="" id="sht_01_D2" /> </td>
						<th>D4 </th>
						<td><input type="text" name="sht_01_D4" style="width:32px;" class="input" readonly="" id="sht_01_D4" /> </td>
						<th>D5 </th>
						<td><input type="text" name="sht_01_D5" style="width:32px;" class="input" readonly="" id="sht_01_D5" /> </td>
						<th>D7 </th>
						<td><input type="text" name="sht_01_D7" style="width:32px;" class="input" readonly="" id="sht_01_D7" /> </td>
						<th>D8 </th>
						<td><input type="text" name="sht_01_D8" style="width:32px;" class="input" readonly="" id="sht_01_D8" /> </td>
						<th>D9 </th>
						<td><input type="text" name="sht_01_D9" style="width:32px;" class="input" readonly="" id="sht_01_D9" /> </td>
						<!-- 
						<th>DW </th>
						<td><input type="text" name="sht_01_DW" style="width:32px;" class="input" readonly="" id="sht_01_DW" /> </td>
						<th>DX </th>
						<td><input type="text" name="sht_01_DX" style="width:32px;" class="input" readonly="" id="sht_01_DX" /> </td>
						 -->
						<th>R2 </th>
						<td><input type="text" name="sht_01_R2" style="width:32px;" class="input" readonly="" id="sht_01_R2" /> </td>
						<th>R4 </th>
						<td><input type="text" name="sht_01_R4" style="width:32px;" class="input" readonly="" id="sht_01_R4" /> </td>
						<th>R5 </th>
						<td><input type="text" name="sht_01_R5" style="width:32px;" class="input" readonly="" id="sht_01_R5" /> </td>
						<th>F2 </th>
						<td><input type="text" name="sht_01_F2" style="width:32px;" class="input" readonly="" id="sht_01_F2" /> </td>
						<th>F4 </th>
						<td><input type="text" name="sht_01_F4" style="width:32px;" class="input" readonly="" id="sht_01_F4" /> </td>
						<th>F5 </th>
						<td><input type="text" name="sht_01_F5" style="width:32px;" class="input" readonly="" id="sht_01_F5" /> </td>	
					</tr>
					<tr>
						<th>O2</th>
						<td><input type="text" name="sht_01_O2" style="width:32px;" class="input" readonly="" id="sht_01_O2" /> </td>
						<th>O4</th>
						<td><input type="text" name="sht_01_O4" style="width:32px;" class="input" readonly="" id="sht_01_O4" /> </td>
						<th>S2</th>
						<td><input type="text" name="sht_01_S2" style="width:32px;" class="input" readonly="" id="sht_01_S2" /> </td>
						<th>S4</th>
						<td><input type="text" name="sht_01_S4" style="width:32px;" class="input" readonly="" id="sht_01_S4" /> </td>
						<th>T2</th>
						<td><input type="text" name="sht_01_T2" style="width:32px;" class="input" readonly="" id="sht_01_T2" /> </td>
						<th>T4</th>
						<td><input type="text" name="sht_01_T4" style="width:32px;" class="input" readonly="" id="sht_01_T4" /> </td>
						<th>A2</th>
						<td><input type="text" name="sht_01_A2" style="width:32px;" class="input" readonly="" id="sht_01_A2" /> </td>
						<th>A4</th>
						<td><input type="text" name="sht_01_A4" style="width:32px;" class="input" readonly="" id="sht_01_A4" /> </td>
						<th>P2</th>
						<td><input type="text" name="sht_01_P2" style="width:32px;" class="input" readonly="" id="sht_01_P2" /> </td>
						<th>P4</th>
						<td><input type="text" name="sht_01_P4" style="width:32px;" class="input" readonly="" id="sht_01_P4" /> </td>
						<th>Z2</th>
						<td><input type="text" name="sht_01_Z2" style="width:32px;" class="input" readonly="" id="sht_01_Z2" /> </td>
						<th>Z4</th>
						<td><input type="text" name="sht_01_Z4" style="width:32px;" class="input" readonly="" id="sht_01_Z4" /> </td>
						
					</tr>
				</table>
			</div>
		<!-- opus_design_inquiry(E) -->
		</div>
	</div>

<div id="tabLayer" style="display:none">
	<div class="opus_design_grid">
		<div class="opus_design_btn"><!-- 
			 --><button type="button" class="btn_normal" name="t2btng_listclear" 	id="t2btng_listclear">List Clear</button><!-- 
			 --><button type="button" class="btn_normal" name="t2btng_print" 	id="t2btng_print" style="display:none;">Print</button><!-- 
			 --><button type="button" class="btn_normal" name="t2btng_downexcel" 	id="t2btng_downexcel">Down Excel</button><!-- 
			 --><button type="button" class="btn_normal" name="t2btng_verification" 	id="t2btng_verification">To Verification</button><!-- 
			 --><button type="button" class="btn_normal" name="t2btng_reject" 	id="t2btng_reject">Reject</button>
		</div>
		<script type="text/javascript">ComSheetObject('t2sheet1');</script>
	</div>
</div>

<div id="tabLayer" style="display:none;">
	<div class="" style="position:absolute;">
		<table class="search_in" border="0">
				<tr>
					<th align="right">Calculated AMT&nbsp;<input type="text" name='t3sht_tot_inv_amt' class="input" style="width:150;text-align:right;" readonly></th>
				</tr>
		</table>
	</div>
	<div class="opus_design_grid">
		<div class="opus_design_btn" style="height:32px"><!-- 
			 -->
			 <button type="button" class="btn_normal" name="t3btng_costCal" 	id="t3btng_costCal">Semi-Auto Calc.</button>
			 <button type="button" class="btn_normal" name="t3btng_clear" 	id="t3btng_clear">List Clear</button><!-- 
			 --><button type="button" class="btn_normal" name="t3btng_rowadd" 	id="t3btng_rowadd">Row Add</button><!-- 
			 --><button type="button" class="btn_normal" name="t3btng_rowdel" 	id="t3btng_rowdel">Delete</button><!-- 
			 --><button type="button" class="btn_normal" name="t3btng_save" 	id="t3btng_save">Save</button><!-- 
			 --><button type="button" class="btn_normal" name="t3btng_totalamount" 	id="t3btng_totalamount">Total Amount</button><!-- 
			 --><button type="button" class="btn_normal" name="t3btng_confirm" 	id="t3btng_confirm">Confirm</button>
		</div>
		<script type="text/javascript">ComSheetObject('t3sheet1');</script>
	</div>
</div>
<div id="tabLayer" style="display:none;">
	<div class="" style="position:absolute;">
		<table class="search_in" border="0">
				<tr>
					<th align="right">Calculated AMT&nbsp;<input type="text" name='t4sht_tot_inv_amt' class="input" style="width:150;text-align:right;" readonly></th>
				</tr>
		</table>
	</div>
	<div class="opus_design_grid">
		<div class="opus_design_btn" style="height:32px"><!-- 
			 --><button type="button" class="btn_normal" name="t4btng_costCal" 	id="t4btng_costCal">Semi-Auto Calc.</button>
			 	<button type="button" class="btn_normal" name="t4btng_listclear" 	id="t4btng_listclear">List Clear</button><!-- 
			 --><button type="button" class="btn_normal" name="t4btng_rowadd" 	id="t4btng_rowadd">Row Add</button><!-- 
			 --><button type="button" class="btn_normal" name="t4btng_rowdel" 	id="t4btng_rowdel">Delete</button><!-- 
			 --><button type="button" class="btn_normal" name="t4btng_save" 	id="t4btng_save">Save</button><!-- 
			 --><button type="button" class="btn_normal" name="t4btng_totalamount" 	id="t4btng_totalamount">Total Amount</button><!-- 
			 --><button type="button" class="btn_normal" name="t4btng_confirm" 	id="t4btng_confirm">Confirm</button>
		</div>
		<script type="text/javascript">ComSheetObject('t4sheet1');</script>
	</div>
</div>


<div id="tabLayer" style="display:none;">
	<div class="" style="position:absolute;"">
		<table>
				<tr>
					<th align="right">Calculated AMT&nbsp;<input type="text" name='t5sht_tot_inv_amt' class="input" style="width:150;text-align:right;" readonly></th>
				</tr>
		</table>
	</div>
	<div class="opus_design_grid">
		<div class="opus_design_btn" style="height:32px">
			<button type="button" class="btn_normal" name="t5btng_listclear" 	id="t5btng_listclear">List Clear</button><!-- 
			 --><button type="button" class="btn_normal" name="t5btng_rowadd" 	id="t5btng_rowadd">Row Add</button><!-- 
			 --><button type="button" class="btn_normal" name="t5btng_rowdel" 	id="t5btng_rowdel">Delete</button><!-- 
			 --><button type="button" class="btn_normal" name="t5btng_save" 	id="t5btng_save">Save</button><!-- 
			 --><button type="button" class="btn_normal" name="t5btng_totalamount" 	id="t5btng_totalamount">Total Amount</button><!-- 
			 --><button type="button" class="btn_normal" name="t5btng_confirm" 	id="t5btng_confirm">Confirm</button>
		</div>
		<script type="text/javascript">ComSheetObject('t5sheet1');</script>
	</div>
</div>

<div id="main_hidden_sheets" style="display:none;">
<!--// HIDDEN SHEET : Temporary header data //-->
main_hidden_sheets : sheetObjects[5]
<script type="text/javascript">ComSheetObject('main_hidden');</script>
</div>
<!--br><br-->
<div id="rjct_hidden_sheets" style="display:none;">
<!--// HIDDEN SHEET : Temporary reject result //-->
rjct_hidden_sheets : sheetObjects[6]
<script type="text/javascript">ComSheetObject('rjct_hidden');</script>
</div>
<!--br><br-->
<div id="conf_hidden_sheets" style="display:none;">
<!--// HIDDEN SHEET : Temporary confirm result //-->
conf_hidden_sheets : sheetObjects[7]
<script type="text/javascript">ComSheetObject('conf_hidden');</script>
</div>
<!--br><br-->
<div id="dupchk_hidden_sheets" style="display:none;">
<!--// HIDDEN SHEET : Temporary dup result //-->
dupchk_hidden_sheets : sheetObjects[8]
<script type="text/javascript">ComSheetObject('dupchk_hidden');</script>
</div>
 
<div id="tabLayer" style="display:none;">
	<div class="" style="position:absolute;"">
		<table>
				<tr>
					<th align="right">Calculated AMT&nbsp;<input type="text" name='t6sht_tot_inv_amt' class="input" style="width:150;text-align:right;" readonly></th>
				</tr>
		</table>
	</div>
	<div class="opus_design_grid">
		<div class="opus_design_btn" style="height:32px">
			<button type="button" class="btn_normal" name="t6btng_costCal" 	id="t6btng_costCal">Semi-Auto Calc.</button>
			<button type="button" class="btn_normal" name="t6btng_listclear" 	id="t6btng_listclear">List Clear</button><!-- 
			 --><button type="button" class="btn_normal" name="t6btng_rowadd" 	id="t6btng_rowadd">Row Add</button><!-- 
			 --><button type="button" class="btn_normal" name="t6btng_rowdel" 	id="t6btng_rowdel">Delete</button><!-- 
			 --><button type="button" class="btn_normal" name="t6btng_save" 	id="t6btng_save">Save</button><!-- 
			 --><button type="button" class="btn_normal" name="t6btng_totalamount" 	id="t6btng_totalamount">Total Amount</button><!-- 
			 --><button type="button" class="btn_normal" name="t6btng_confirm" 	id="t6btng_confirm">Confirm</button>
		</div>
		<script type="text/javascript">ComSheetObject('t6sheet1');</script>
	</div>
</div>

</div>
</form>

				