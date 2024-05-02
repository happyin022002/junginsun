<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TES_0064.jsp
*@FileTitle  : On-Dock Rail Charge Invoice Creation & Correction 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/17
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.event.EsdTes0064Event"%>
<%
	EsdTes0064Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Server Exceptioon
	DBRowSet rowSet	  = null;					//DB ResultSet
	String strErrMsg = "";						//Error Message
	int rowCount	 = 0;						//DB ResultSet Count
	String userId = "";
	String ofcCd = "";

	String inv_no="";
	String vndr_seq="";
	inv_no = JSPUtil.getNull(request.getParameter("inv_no"));
	vndr_seq = JSPUtil.getNull(request.getParameter("vndr_seq"));

	try {
	   SignOnUserAccount account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);

	   userId = account.getUsr_id()!=null&&!account.getUsr_id().equals("")?account.getUsr_id():"";
	   ofcCd = account.getOfc_cd()!=null&&!account.getOfc_cd().equals("")?account.getOfc_cd():"KRXXXX"; //test용 값..
	   //userAuth=account.getAuth();

		event = (EsdTes0064Event)request.getAttribute("Event");
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

<script  type="text/javascript">
	<%= JSPUtil.getIBCodeCombo("vol_tr_ut_cd"	, "01", "CD00177", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("io_bnd_cd"		, "01", "CD00592", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("ioc_cd"			, "01", "CD00887", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("dcgo_clss_cd"	, "01", "CD00167", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("tml_wrk_dy_cd"	, "01", "CD00168", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("cntr_sty_cd"	, "01", "CD00136", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("locl_ts_ind_cd" , "01", "CD00889", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("dscr_ind_cd"    , "01", "CD20037", 0, "")%>
	
	var inv_no = "<%=JSPUtil.getNull(inv_no)%>";
	var vndr_seq = "<%=JSPUtil.getNull(vndr_seq)%>";
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form method="post" name="form" onSubmit="return false;">
<input type="text" style="display:none" 	name="f_cmd" id="f_cmd">
<input type="text" style="display:none" 	name="iPage" id="iPage">
<input type="text" style="display:none" 	name="tml_so_ofc_cty_cd" id="tml_so_ofc_cty_cd"	value="">
<input type="text" style="display:none" 	name="tml_so_seq" id="tml_so_seq"			value="">
<input type="text" style="display:none" 	name="vrfy_rslt_ind_cd" id="vrfy_rslt_ind_cd" 	value="">
<input type="text" style="display:none" 	name="temp_val" id="temp_val"				value="">
<input type="text" style="display:none" 	name="tml_inv_tp_cd" id="tml_inv_tp_cd"		value="ON">
<input type="text" style="display:none" 	name="max_wrk_dt" id="max_wrk_dt"			value="">
<input type="text" style="display:none" 	name="min_wrk_dt" id="min_wrk_dt"			value="">
<input type="text" style="display:none" 	name="agmtCurrCd" id="agmtCurrCd"			value="">
<input type="text" style="display:none" 	name="tmp_common_code" id="tmp_common_code"		value="">
<input type="text" style="display:none" 	name="is_valid_err_inv_no" id="is_valid_err_inv_no"	value="">
<input type="text" style="display:none" 	name="curr_cd_tmp" id="curr_cd_tmp"			value="">
<input type="text" style="display:none"  	name="whld_tax_amt_mode" id="whld_tax_amt_mode" 	value="">
<input type="text" style="display:none"  	name="is_valid_cost_ofc_cd" id="is_valid_cost_ofc_cd" value=''>
<input type="text" style="display:none" 	name="cost_calc_mode" id="cost_calc_mode"		value="R"> <!--cost calculation mode (R : 기존저장된 calc list read, N: New Calculation ) -->
<input type="text" style="display:none" 	name="mdl_cd"		value="TES"> 
<input type="text" style="display:none" 	name="ofc_cd" value="<%=ofcCd%>">

<!----------------------------------------------------------------------
	# yd_chr_inv_tp_cd : Inquiry code value ​​for yard
	1. Marine Terminal Invoice = 'TM'
	2. On-dock Rail Charge Invoice = 'ON'
	3. Off-dock CY Invoice(Terminal) = 'OT'
	4. Off-dock CY Invoice(Storage) = 'OS'
	5. Storage Invoice = 'ST'
------------------------------------------------------------------------>
<input type="text" style="display:none"  name="yd_chr_inv_tp_cd" id="yd_chr_inv_tp_cd" value="">
<input type="text" style="display:none"  name="calcOnDockComboItems" id="calcOnDockComboItems" value="">
<input type="text" style="display:none"  name="cntrTpszComboItems" id="cntrTpszComboItems"  value="">
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
<input type="text" style="display:none" 	name="rtro_tml_inv_flg_old" id="rtro_tml_inv_flg_old" value=""> 
<input type="text" style="display:none"  name="inv_rjct_rmk" id="inv_rjct_rmk" value="">
<input type="text" style="display:none"  name="hld_rmk" id="hld_rmk"  value="">

<!-- special character, characterSet problem. //-->
<input type="text" style="display:none"  name="inv_no_tmp" id="inv_no_tmp" value= "<%=JSPUtil.getNull(inv_no)%>">

<input type="text" style="display:none" 	name="agmt_ftr_inv_tp_cd" value="ON"> 
<input type="text" style="display:none" 	name="cost_cd_ftr_rmk" value=""> 


<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<div id="PreInquiryCondLayer01" style="display:none">
			<button type="button" class="btn_accent" name="btn_pre_inquiry_cond" id="btn_pre_inquiry_cond">To Inv. Summary</button>
		</div>
		<button type="button" class="btn_accent" name="btn_retrieve" 		id="btn_retrieve">Retrieve</button><!-- 
		--><button type="button" class="btn_normal" name="btn_new" 			id="btn_new">New</button><!--		
		--><button type="button" class="btn_normal" name="btn_new2" 			id="btn_new2">New2</button><!--		
		--><button type="button" class="btn_normal" name="btn_save" 			id="btn_save">Save</button>			
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
	
</div>
<!-- page_title_area(E) -->

<!-- opus_design_inquiry(S) -->
<div class="wrap_search_tab">
	<div class="opus_design_inquiry">	
			<table>	
				<tbody>
				<colgroup>
					<col width="68" />
					<col width="150" />
					<col width="60" />
					<col width="160" />
					<col width="60" />
					<col width="150" />
					<col width="55" />
					<col width="150" />
					<col width="55" />
					<col width="*" />
				</colgroup>	
				<tr>
					<th>S/P Code</th>
					<td><input class="input1" type="text" style="width:68px;" name="vndr_seq" valid="1" title="VNDR Code" value="" tabindex="1" maxlength="6"  dataformat="num" onKeyDown='tes_chkInput(this);' onblur="validateVndrSeq();" id="vndr_seq" /><button type="button" id="btn_vndr" name="btn_vndr" class="input_seach_btn"></button><input type="text" style="display:none"  name="vndr_seq_hidden" value="" id="vndr_seq_hidden" /><input type="text" style="display:none"  name="is_valid_vndr_seq" value="" id="is_valid_vndr_seq" /></td>
					<th>S/P Name</th>
					<td><input type="text" style="width:115px;" value="" name="vndr_seq_nm" valid="1" class="input2" readonly id="vndr_seq_nm" /> </td>
					<th>Invoice NO</th>
					<td><input class="input1" type="text" style="width:90px;" name="inv_no" valid="1" title="Inv. No." tabindex="2"  id="inv_no"  onKeyUp='isApNum2(this);' onKeyDown='tes_chkInput(this);' onBlur='validateInvDupChk();' /> </td>
										<input type="text" style="display:none"  name="inv_no_hidden" value=''>
									  	<input type="text" style="display:none"  name="is_dup_inv_no" value=''>					
					<th>Error INV NO&nbsp;</th>
					<td><input type="text" name="err_inv_no" style="width:93px;" maxlength="30" onblur="validateErrInvNo();" id="err_inv_no" /> </td>
					<th><label for="rtro_tml_inv_flg">Retroactive INV</label></th>
					<td><input type="checkbox" name="rtro_tml_inv_flg" value="Y" class="trans" id="rtro_tml_inv_flg" /> </td>
				</tr>	
				</tbody>		
			</table>
	</div>
	<!-- opus_design_inquiry(E) -->
<div class="line_bluedot"></div>
	<div class="opus_design_inquiry wFit">
		<div class="layout_wrap">
		    <div class="layout_vertical_2"  style="width:430px !important;">
	    		<div class="opus_design_data">		
				    <table>
				    	<tbody>
						<colgroup>
							<col width="70" />
							<col width="100" />
							<col width="100" />
							<col width="*" />
						</colgroup>	
				    	<tr>
							<th>Yard Code</th>
							<td><input class="input1" type="text" style="width:68px;" name="yd_cd" valid="1" title="Yard Code" maxlength="7" onblur="getYardName();" id="yd_cd" dataformat="engup"/><!--  
								 --><input type="text" style="display:none"  name="yd_cd_hidden" value="" id="yd_cd_hidden" /><!-- 
								 --><input type="text" style="display:none"  name="is_valid_yd_cd" value="" id="is_valid_yd_cd" /><!-- 
								 --><input type="text" style="display:none"  name="yd_chr_cd" value="" id="yd_chr_cd" /><!-- 
								 --><input type="text" style="display:none"  name="yd_fcty_tp_mrn_tml_flg" value="" id="yd_fcty_tp_mrn_tml_flg" /><!-- 
								 --><input type="text" style="display:none"  name="yd_fcty_tp_cy_flg" value="" id="yd_fcty_tp_cy_flg" /><!-- 
								 --><input type="text" style="display:none"  name="yd_fcty_tp_cfs_flg" value="" id="yd_fcty_tp_cfs_flg" /><!-- 
								 --><input type="text" style="display:none"  name="yd_fcty_tp_rail_rmp_flg" value="" id="yd_fcty_tp_rail_rmp_flg" /><!-- 
								 --><input type="text" style="display:none"  name="yd_oshp_cd" value="" id="yd_oshp_cd" /><!--  
								 --><button type="button" name="btn_yard" id="btn_yard" class="input_seach_btn"></button></td>
							<th>Yard Name</th>
							<td><input class="input2" type="text" style="width:100px;" name="yd_nm" readonly id="yd_nm" /> </td>
						</tr>
						<tr>
							<th>Cost OFC</th>
							<td><!-- 
								 --><input class="input1" type="text" style="width:68px;" name="cost_ofc_cd" value="" maxlength="6" title="COST OFC"   onKeyUp='tes_isApNum(this);upper(this);' onblur="validateCostOFC();" id="cost_ofc_cd" /><!-- 
								 --><button type="button" id="btn_cost_ofc" name="btn_cost_ofc" class="input_seach_btn"></button><!-- 
								 --><input type="text" style="display:none"  name="cost_ofc_hidden" value="" id="cost_ofc_hidden" /><!-- 
								 --><input type="text" style="display:none"  name="is_valid_cost_ofc" value="" id="is_valid_cost_ofc" /><!-- 
							 --></td>
							<th>INV OFC</th>
							<td><input class="input2" type="text" style="width:100px;" name="inv_ofc_cd" valid="1" title="Inv. OFC" value="<%=ofcCd%>" readonly id="inv_ofc_cd" /> </td>
						</tr>
						<tr>
							<th>Currency</th>
							<td><script type="text/javascript">ComComboObject('curr_cd', 1, 91, 1, 1)</script></td>
							<th><label for="hld_flg">Hold</label></th>				
						    <td><input type="checkbox" value="" class="trans" name="hld_flg" id="hld_flg" />&nbsp;&nbsp;&nbsp;&nbsp;<button type="button" class="btn_etc" name="btns_remarks" id="btns_remarks">Remarks</button></td>
						</tr>
						<tr>
							<th>Work DT</th>
							<td><input class="input1" type="text" style="width:75px;" name="wrk_dt" valid="1" title="Working Date" maxlength="10" onkeyup="tes_isNumD(this,'Y');" onkeydown="tes_isNumD(this,&quot;Y&quot;);" onblur="validDate(this);" id="wrk_dt" /><button type="button" id="btns_calendar3" name="btns_calendar3" class="calendar ir"></button></td>
							<th>AGMT COST CD</th>
							<td><script type="text/javascript">ComComboObject('agmt_lgs_cost_cd', 2, 91, 1, 1)</script></td>
						</tr>
						
						<tbody>
					</table>
				</div>	
		    </div>
	    	<div class="layout_vertical_2">
    			<div class="opus_design_data" style="height:116px">		
			       	<table>
			       		<tbody>
						<colgroup>
							<col width="80" />
							<col width="130" />
							<col width="105" />
							<col width="*" />
						</colgroup>	
						<tr>
							<th>INV AMT</th>
							<td><input class="input1" type="text" style="width:105px;text-align:right;" name="ttl_inv_amt"  id="ttl_inv_amt" maxlength=20 valid="1" title="Inv. AMT" onKeyUp='tes_isMon(this,"Y",this.form.curr_cd.Code);' onKeyDown='tes_chkInput(this); tes_isMon(this,"Y",this.form.curr_cd.Code);' onBlur="tes_chkAmtFmtObj(this,this.form.curr_cd.Code); set_total_amount();" /> </td>
							<th>TAX</th>
							<td><input type="text" style="width:105px;text-align:right;" name="vat_amt" title="V.A.T" id="vat_amt" maxlength=20 onKeyUp='tes_isMon(this,"Y",this.form.curr_cd.Code);' onKeyDown='tes_chkInput(this); tes_isMon(this,"Y",this.form.curr_cd.Code);' onBlur="tes_chkAmtFmtObj(this,this.form.curr_cd.Code); set_total_amount();" /> </td>
						</tr>
						<tr>
							<th>W.H.T</th>
							<td><input type="text" name="whld_tax_amt" style="width:105px;text-align:right;"  id="whld_tax_amt" maxlength=20 onKeyUp='tes_isMon(this,"Y",this.form.curr_cd.Code);' onKeyDown='tes_chkInput(this); tes_isMon(this,"Y",this.form.curr_cd.Code);' onBlur="tes_chkAmtFmtObj(this,this.form.curr_cd.Code); set_total_amount();" /> </td>
							<th>Total AMT</th>
							<td><input type="text" name="total_amt" style="width:105px;"  onblur="tes_chkAmtFmtObj(this,this.form.curr_cd.Code);" id="total_amt" /> </td>
						</tr>
						<tr>
							<th>Issued DT</th>
							<td><input class="input1" type="text" style="width:75px;" name="iss_dt" valid="1" title="Issue Date" maxlength="10" onkeyup="tes_isNumD(this,'Y');" onkeydown="tes_isNumD(this,&quot;Y&quot;);" onblur="validDate(this);" id="iss_dt" /><button type="button" id="btns_calendar1" name="btns_calendar1" class="calendar ir"></button></td>
							<th>Received DT</th>
							<td><input class="input1" type="text" style="width:75px;" name="rcv_dt" valid="1" title="RCV Date" maxlength="10" onkeyup="tes_isNumD(this,'Y');" onkeydown="tes_isNumD(this,&quot;Y&quot;);" onblur="validDate(this);" id="rcv_dt" /><button type="button" id="btns_calendar2" name="btns_calendar2" class="calendar ir"></button></td>
						</tr>
						<tr>
							<th>INV STS</th>
							<td><input class="input2" type="text" style="width:105px;" name="tml_inv_sts_nm" value="" readonly id="tml_inv_sts_nm" /><input type="text" style="display:none"  name="tml_inv_sts_cd" value="R" id="tml_inv_sts_cd" /> </td>
							<th>Reject STS</th>
							<td><input class="input2" type="text" style="width:105px;" name="tml_inv_rjct_sts_nm" title="Reject STS" maxlength="2" value="" readonly id="tml_inv_rjct_sts_nm" /><input type="text" style="display:none"  name="tml_inv_rjct_sts_cd" value="NL" id="tml_inv_rjct_sts_cd" /></td>
						</tr>
						</tbody>
					</table>
				</div>
		    </div>
		</div>
	</div>
	<div class="line_bluedot"></div>
	<div class="opus_design_inquiry">		
   		<div class="opus_design_data">		
		    <table>
		    	<tbody>
				<colgroup>
					<col width="626" />
					<col width="120" />
					<col width="*" />
				</colgroup>
	  			<tr>
	  				<td></td>
					<th>Calculated AMT</th>
					<td><input type="text" style="width:150px;text-align:right;" value="" name="tot_inv_amt"  readOnly></td>
					</tr>				
			</table>
		</div>		
	</div>
</div>
	
<!-- opus_design_inquiry(E) -->

<div class="wrap_result">
	<!-- opus_tab_btn(S) -->
	<div class="opus_design_tab sm">
		<script type="text/javascript">ComTabObject('tab1')</script>
	</div>
	<!-- opus_tab_btn(E) -->
	<div id="tabLayer">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear" >
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="t1btng_clear" 		id="t1btng_clear">List Clear</button><!--
			--><button type="button" class="btn_normal" name="btng_todiscrepancy1" 			id="btng_todiscrepancy1">To Discrepancy</button><!--		
			--><button type="button" class="btn_normal" name="btng_fileimport1" 			id="btng_fileimport1">File Import</button><!--		
			--><button type="button" class="btn_normal" name="btng_save1" 			id="btng_save1">Save</button><!--			
			--><button type="button" class="btn_normal" name="t1btng_downexcel" 			id="t1btng_downexcel">Down Excel</button><!--			
			--><button type="button" class="btn_normal" name="btng_costcalc1" 			id="btng_costcalc1">Cost Calc.</button>			
		</div>
		<!-- opus_design_btn(E) -->
		
		<script type="text/javascript">ComSheetObject('t1sheet1');</script>
		<div id="SearchLayer01" style="display:inline">	
		</div>
		<div class="opus_design_inquiry">			
			<table>			   
				<tr>
					<td style="float:right" colspan="14">
					<button type="button" id="up_down" class="btn_up" onClick="reSize();"></button>
					<!-- <img class="cursor" src="/opuscntr/img/bu_next01.gif" width="20px" height="11px" border="0" onClick="reSize();"> -->
					</td>
				</tr>
			</table>			
		</div>
		<div class="opus_design_inquiry wFit">
			<div id="SearchLayer02" style="display:inline">
				<table class="grid2">
					<colgroup>
						<col width="70"/>
						<col width="150"/>
						<col width="70"/>
						<col width="150"/>
						<col width="70"/>
						<col width="*"/>
					</colgroup>
					<tr>
						<th>Total</th>
						<td><input class="input2" type="text"  name="container_tot" style="width:80px;text-align:right;" readOnly disabled></td>
						<th>Full</th>
						<td><input class="input2" type="text" name="full" style="width:80px;text-align:right;" readOnly disabled></td>
						<th>Empty</th>
						<td><input class="input2" type="text" name="empty" style="width:80px;text-align:right;" readOnly disabled></td>

					</tr>		
				</table>
				<table class="grid2">			
					<tbody>
					<colgroup>
						<col width="10" />
						<col width="10" />
						<col width="10" />
						<col width="10" />
						<col width="10" />
						<col width="10" />
						<col width="10" />
						<col width="10" />
						<col width="10" />
						<col width="10" />
						<col width="10" />
						<col width="10" />
						<col width="10" />
						<col width="10" />
						<col width="10" />
						<col width="10" />
						<col width="10" />
						<col width="10" />
						<col width="10" />
						<col width="10" />
						<col width="10" />
						<col width="10" />
						<col width="10" />
						<col width="10" />
						<col width="10" />
						<col width="10" />
						<col width="10" />
						<col width="10" />
						<col width="10" />
						<col width="10" />
						<col width="10" />
						<col width="*" />
					</colgroup>			
					<tr>
						<th>D2 </th><td><input class="input2" type="text" name="size_d2" style="width:32px;text-align:right;" readOnly disabled ></td>
						<th>D4 </th><td><input class="input2" type="text" name="size_d4" style="width:32px;text-align:right;" readOnly disabled ></td>
						<th>D5 </th><td><input class="input2" type="text" name="size_d5" style="width:32px;text-align:right;" readOnly disabled ></td>
						<th>D7 </th><td><input class="input2" type="text" name="size_d7" style="width:32px;text-align:right;" readOnly disabled ></td>
						<th>D8 </th><td><input class="input2" type="text" name="size_d8" style="width:32px;text-align:right;" readOnly disabled ></td>
						<th>D9 </th><td><input class="input2" type="text" name="size_d9" style="width:32px;text-align:right;" readOnly disabled ></td>
						<!-- 
						<th>DW </th><td><input class="input2" type="text" name="size_dw" style="width:32px;text-align:right;" readOnly disabled ></td>
						<th>DX </th><td><input class="input2" type="text" name="size_dx" style="width:32px;text-align:right;" readOnly disabled ></td>
						 -->
						<th>R2 </th><td><input class="input2" type="text" name="size_r2" style="width:32px;text-align:right;" readOnly disabled ></td>
						<th>R4 </th><td><input class="input2" type="text" name="size_r4" style="width:32px;text-align:right;" readOnly disabled ></td>
						<th>R5 </th><td><input class="input2" type="text" name="size_r5" style="width:32px;text-align:right;" readOnly disabled ></td>
						<th>F2 </th><td><input class="input2" type="text" name="size_f2" style="width:32px;text-align:right;" readOnly disabled ></td>
						<th>F4 </th><td><input class="input2" type="text" name="size_f4" style="width:32px;text-align:right;" readOnly disabled ></td>
						<th>F5 </th><td><input class="input2" type="text" name="size_f5" style="width:32px;text-align:right;" readOnly disabled ></td>
					</tr>
					<tr>
						<th>O2</th><td><input class="input2" type="text" name="size_o2" style="width:32px;text-align:right;" readOnly disabled></td>
						<th>O4</th><td><input class="input2" type="text" name="size_o4" style="width:32px;text-align:right;" readOnly disabled></td>
						<th>S2</th><td><input class="input2" type="text" name="size_s2" style="width:32px;text-align:right;" readOnly disabled></td>
						<th>S4</th><td><input class="input2" type="text" name="size_s4" style="width:32px;text-align:right;" readOnly disabled></td>
						<th>T2</th><td><input class="input2" type="text" name="size_t2" style="width:32px;text-align:right;" readOnly disabled></td>
						<th>T4</th><td><input class="input2" type="text" name="size_t4" style="width:32px;text-align:right;" readOnly disabled></td>
						<th>A2</th><td><input class="input2" type="text" name="size_a2" style="width:32px;text-align:right;" readOnly disabled></td>
						<th>A4</th><td><input class="input2" type="text" name="size_a4" style="width:32px;text-align:right;" readOnly disabled></td>
						<th>P2</th><td><input class="input2" type="text" name="size_p2" style="width:32px;text-align:right;" readOnly disabled></td>
						<th>P4</th><td><input class="input2" type="text" name="size_p4" style="width:32px;text-align:right;" readOnly disabled></td>
						<th>Z2</th><td><input class="input2" type="text" name="size_z2" style="width:32px;text-align:right;" readOnly disabled></td>
						<th>Z4</th><td colspan="1"><input class="input2" type="text" name="size_z4" style="width:32px;text-align:right;" readOnly disabled></td>						
					</tr>	
					</tbody>	
				</table>
			</div>
		</div>		
	</div>
	<!-- opus_design_grid(E) -->
	</div>
	<div id="tabLayer">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear">
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="t2btng_clear" 		id="t2btng_clear">List Clear</button><!--  
			--><button type="button" class="btn_normal" name="t2btng_verification" 	id="t2btng_verification">To Verification</button><!-- 
			--><button type="button" class="btn_normal" name="t2btng_reject" 		id="t2btng_reject">Reject</button><!-- 
			--><button type="button" class="btn_normal" name="t2btng_downexcel" 	id="t2btng_downexcel">Down Excel</button><!-- 
			--><button type="button" class="btn_normal" name="t2btng_print" 		id="t2btng_print">Print</button>			
		</div>
		<!-- opus_design_btn(E) -->
		<script type="text/javascript">ComSheetObject('t2sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
	</div>
	<div id="tabLayer">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear">
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="t3btng_costCal" 		id="t3btng_costCal">Semi-Auto Calc.</button>
			<button type="button" class="btn_accent" name="t3btng_clear" 		id="t3btng_clear">List Clear</button><!-- 
			--><button type="button" class="btn_normal" name="t3btng_rowadd" 		id="t3btng_rowadd">Row Add</button><!-- 		
			--><button type="button" class="btn_normal" name="t3btng_rowdel" 		id="t3btng_rowdel">Delete</button><!-- 		
			--><button type="button" class="btn_normal" name="btng_save3" 			id="btng_save3">Save</button><!-- 			
			--><button type="button" class="btn_normal" name="btng_totalamount3" 	id="btng_totalamount3">Total Amount</button><!-- 			
			--><button type="button" class="btn_normal" name="btng_confirm3" 		id="btng_confirm3">Confirm</button>		
		</div>
		<!-- opus_design_btn(E) -->
		<script type="text/javascript">ComSheetObject('t3sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear" name="tabLayer" id="tabLayer">
		<!-- opus_design_btn(S) -->	
		<script type="text/javascript">ComSheetObject('main_hidden');</script>
	</div>
	<!-- opus_design_grid(E) -->
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear" name="tabLayer" id="tabLayer">
		<script type="text/javascript">ComSheetObject('hidden_sheets4_etc');</script>
	</div>
	<!-- opus_design_grid(E) -->
	</div>
</div>
</form>