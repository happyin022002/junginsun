<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SAM_0002.js
*@FileTitle  : Customer Information
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/20
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.event.EsmSam0002Event""%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSam0002Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String pCustCd = "";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.BookingReport.StatusReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();


		event = (EsmSam0002Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		pCustCd = JSPUtil.getNull(request.getParameter("cust_cd"));
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
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
<!-- 개발자 작업	-->  

<input type="hidden" name="vsl_cd" id="vsl_cd" />
<input type="hidden" name="skd_voy_no" id="skd_voy_no" />
<input type="hidden" name="skd_dir_cd" id="skd_dir_cd" />
<input type="hidden" name="tab_item" id="tab_item" />
<input type="hidden" name="pol_yd_cd" id="pol_yd_cd" />
<input type="hidden" name="pod_yd_cd" id="pod_yd_cd" />
<input type="hidden" name="master_tot" id="master_tot" />
<input type="hidden" name="houser_tot" id="houser_tot" />
<input type="hidden" name="chk_srep_cd" id="chk_srep_cd" />
<input type="hidden" name="chk_cmdt_cd" id="chk_cmdt_cd" />
<input type="hidden" value=<%=strOfc_cd%> name="usr_ofc_cd" id="usr_ofc_cd" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_new" id="btn_new" type="button">New</button><!--
		--><button class="btn_normal" name="btn_Save" id="btn_Save" type="button">Save</button>
	</div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search_tab">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table class="search">
			<tbody>
				<colgroup>
					<col width="110px">
					<col width="*">
				</colgroup>
				<tr class="h23">
	                <th class="tr2_head">Customer Code</th>
	                <td><input type="text" style="width:110px;" class="input1" name="cust_cd" id="cust_cd" value="<%=pCustCd%>" maxlength="8" dataformat="engup">
	                <input type="text" name="cust_hidden" id="cust_hidden" style="display: none;"> <!-- Enter 조회를 위해 포커스를 맞출 hidden 텍스트 박스를 생성 -->
	               <button type="button" id="btn_search" name="btn_search" class="input_seach_btn"></button></td>
              	</tr>
			</tbody>
		</table>
	</div>
	<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
	<div class="opus_design_inquiry wFit">
		<table class="search">
			<tbody>
				<colgroup>
					<col width="110px">
					<col width="80px">
					<col width="88px">	
					<col width="120px">
					<col width="130px">
					<col width="*">
				</colgroup>
				<tr class="h23">
	                <th class="tr2_head">Customer</th>
	                <td colspan="3"><input type="text" style="width:367px;" class="input2" name="cust_lgl_eng_nm" id="cust_lgl_eng_nm" value="" readonly></td>	
	                <th class="tr2_head">Responsible Office</th>
	                <td><input type="text" style="width:100px;" class="input2" name="ofc_cd" id="ofc_cd" value=" " readonly>
	                  	<input type="text" style="width:197px;" class="input2" name="ofc_eng_nm" id="ofc_eng_nm" value=" " readonly></td>
              	</tr>
              	<tr class="h23">
	                <th class="tr2_head">Status</th>
	                <td colspan="3">
						<script type="text/javascript">ComComboObject('cust_sts_cd', 1, 110, 1, 0 ,0 ,false)</script></td>	 	                
	                <th class="tr2_head">Sales Rep. Code</th>
	                <td><input type="text" style="width:100px;" class="input2"  name="srep_cd" id="srep_cd" value=" " readonly>
	                  	<input type="text" style="width:197px;" class="input2"  name="srep_nm" id="srep_nm" value=" " readonly></td>
           	    </tr>
           	    <tr class="h23">
	                <th class="tr2_head">Type</th>
	                <td>
	                	<script type="text/javascript">ComComboObject('cntr_cust_tp_cd', 1, 110, 1, 0 ,0 ,false)</script></td>	                
	                <th class="tr2_head">Firm/Private</th>
	                <td>
	                	<script type="text/javascript">ComComboObject('indiv_corp_div_cd', 1, 142, 1, 0 ,0 ,false)</script></td>   	                      
	                <th class="tr2_head">Location</th>
	                <td><input type="text" style="width:100px;" class="input2"  name="loc_cd" id="loc_cd" value=" " readonly>&nbsp;&nbsp;<strong>C-TPAT SVI #</strong>&nbsp;&nbsp;<input type="text" style="width:109px;" class="input2" name="cts_no" id="cts_no" value=" " readonly></td>
                </tr>
                <tr class="h23">
	                <th class="tr2_head">Phone </th>
	                <td colspan="3"><input type="text" style="width:110px;" class="input2"  name="intl_phn_no" id="intl_phn_no" maxlength="4" dataformat="num" value=" " readonly>
	                  				<input type="text" style="width:250px;" class="input2" name="phn_no" id="phn_no" value=" " maxlength="20" dataformat="num" readonly></td>
	                <th class="tr2_head">Tax Payer ID</th>
	                <td><input type="text" style="width:305px;" class="input" name="cust_rgst_no" id="cust_rgst_no" value=" "></td>
             	</tr>
             	<tr class="h23">
	                <th class="tr2_head">Fax </th>
	                <td colspan="3"><input type="text" style="width:110px;" class="input" name="intl_fax_no" id="intl_fax_no" maxlength="4" dataformat="num" value=" ">
	                  				<input type="text" style="width:250px;" class="input" name="fax_no" id="fax_no" maxlength="20" dataformat="num" value=" "></td>
	                <th class="tr2_head">E-mail</th>
	                <td><input type="text" style="width:305px;" class="input" name="cust_eml" id="cust_eml" value=""></td>
	            </tr>
	            <tr class="h23">
	                <th class="tr2_head">Address</th>
	                <td colspan="3"><input type="text" style="width:368px;" class="input" name="bzet_addr" id="bzet_addr" value=" "></td>
	                <th class="tr2_head">GCM  Account</th>
	                <td><input type="checkbox" name="key_acct_flg" id="checkbox" class="trans" OnClick="onChangeCheckBox()"></td>
              	</tr>
              	<tr class="h23">
	                <th class="tr2_head">Group  Customer</th>
	                <td colspan="3"><input type="text" style="width:110px;" class="input2" name="cust_grp_id" id="cust_grp_id" value=" " readonly>
	                  				<input type="text" style="width:250px;" class="input2" name="cust_grp_nm" id="cust_grp_nm" value=" " readonly></td>
	                <th class="tr2_head">Multi Trade Account&#13;</th>
	                <td><input type="checkbox" name="mlt_trd_acct_flg" id="checkbox" class="trans" OnClick="onChangeCheckBox()"></td>
              	</tr>
              	<tr class="h23">
	                <th class="tr2_head">Creator User ID&#13;</th>
	                <td colspan="6"><input type="text" style="width:110px;" class="input2" readonly name="cre_usr_id" id="cre_usr_id" value=" " >                
	                  				<input type="text" style="width:110px;" class="input2" readonly name="usr_nm" id="usr_nm" value=" " >                
	                  				<input type="text" style="width:133px;" class="input2" readonly name="cre_ofc_cd" id="cre_ofc_cd" value=" " ></td>
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
	<div class="opus_design_grid"">
		<div class="opus_design_btn" id="sButtonTable" style="margin-bottom:-10px">
			<button class="btn_normal" name="btn_RowAdd" id="btn_RowAdd" type="button">Row ADD</button><!-- 
			 --><button class="btn_normal" name="btn_Delete" id="btn_Delete" type="button">Row DEL</button><!-- 
			 --><button class="btn_normal" name="btn_TabSave" id="btn_TabSave" type="button">SAVE</button>
			<!-- <button class="btn_normal" name="btn_Delete" id="btn_Delete" type="button">Row ADD</button>
			<button class="btn_normal" name="btn_Save" id="btn_Save" type="button">Row DEL</button>
			<button class="btn_normal" name="btn_TabSave" id="btn_TabSave" type="button">SAVE</button> -->
		</div>
	</div>
	
	<div class="opus_design_grid"">
		<div class="opus_design_btn opus_design_normal2"  id="sButtonTable2">
				<button class="btn_normal2" name="btn2_TabSave" id="btn2_TabSave" type="button">SAVE</button>
		</div>
	</div>
		
	
	<!-- opus_design_grid(S) -->	
	<div class="opus_design_grid clear" style="display:inline;" name="tabLayer" id="tabLayer">
		<script type="text/javascript">ComSheetObject('t1sheet1');</script>
	</div>
		
	<div class="opus_design_grid clear" style="display:none;" name="tabLayer" id="tabLayer">
		<script type="text/javascript">ComSheetObject('t2sheet1');</script>
	</div>
		
	<div class="opus_design_grid clear" style="display:none;" name="tabLayer" id="tabLayer">
		<script type="text/javascript">ComSheetObject('t3sheet1');</script>
	</div>
	
	<div class="opus_design_grid clear" style="display:none;" name="tabLayer" id="tabLayer">
		<script type="text/javascript">ComSheetObject('t4sheet1');</script>
	</div>
	
	<div class="opus_design_grid clear" style="display:none;" name="tabLayer" id="tabLayer">
		<script type="text/javascript">ComSheetObject('t5sheet1');</script>
	</div>
	
	<div class="opus_design_grid clear" style="display:none;" name="tabLayer" id="tabLayer">
		<div class="opus_design_data">
			<!-- layout_wrap(S) -->
			<div class="layout_wrap">
			    <div class="layout_vertical_2" style="width:535px;">
			        <table class="search">
						<tbody>
							<colgroup>
								<col width="150px">
								<col width="340px">
								<col width="50px">
								<col width="150px">
								<col width="*">
							</colgroup>
							<tr class="h23">
								<th class="tr_head">NVOCC Information</th>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
						</tbody>
					</table>
					<table class="grid2" style="width:510px;">
						<tbody>
							<colgroup>
								<col width="110px">
								<col width="140px">
								<col width="110px">
								<col width="140px">
							</colgroup>
							<tr class="h23">
								<th class="tr2_head2" align = "center">SCAC</th>
								<td><input type="text" style="width:130px;" class="input" name="nvocc_co_scac_cd" id="nvocc_co_scac_cd" value=" " ></td>
								<th class="tr2_head2" align = "center">License#</th>
								<td><input type="text" style="width:130px;" class="input" name="nvocc_lic_no" id="nvocc_lic_no" value=" "></td>
							</tr>
							<tr class="h23">
								<th class="tr2_head2" align = "center">Bond#</th>
								<td><input type="text" style="width:130px;" class="input" name="nvocc_bd_no" id="nvocc_bd_no" value=" "></td>
								<th class="tr2_head2" align = "center">Bond Amount</th>
								<td><input type="text" style="width:130px;" class="input" name="nvocc_bd_amt" id="nvocc_bd_amt" value=" " dataformat="int" maxlength="25"></td>
							</tr>
							<tr class="h23">
								<th class="tr2_head2" align = "center">Eff.Date(From)</th>
								<td><input type="text" style="width:100px;" class="input" name="nvocc_bd_st_eff_dt" id="nvocc_bd_st_eff_dt" value=" " dataformat="ymd" readonly>
									 <!-- <img class="cursor" src="img/button/btns_calendar.gif" alt="" width="19" height="20" align="absmiddle" name="btn_cal1_fr"> -->
									 <button type="button" class="calendar" name="btn_cal1_fr" id="btn_cal1_fr"></button></td>
								<th class="tr2_head2" align = "center">Eff.Date(To)</th>
								<td><input type="text" style="width:100px;" class="input" name="nvocc_bd_end_eff_dt" value=" " dataformat="ymd" readonly>
									 <!-- <img class="cursor" src="img/button/btns_calendar.gif" alt="" width="19" height="20" align="absmiddle" name="btn_cal1_to"> -->
									 <button type="button" class="calendar" name="btn_cal1_to" id="btn_cal1_to"></button></td>
							</tr>
							
						</tbody>
					</table>
			    </div>
			    <div class="layout_vertical_2" style="width:535px;">
			        <table class="search" >
						<tbody>
							<colgroup>
								<col width="150px">
								<col width="340px">
								<col width="50px">
								<col width="150px">
								<col width="340px">
							</colgroup>
							<tr class="h23">
								<th class="tr_head">Credit Information</th>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
						</tbody>
					</table>
					<table class="grid2" style="width:550px;">
						<tbody>
							<colgroup>
								<col width="110px">
								<col width="140px">
								<col width="150px">
								<col width="140px">
							</colgroup>
							<tr class="h23">
								<th class="tr2_head2" align = "center">Credit Amount</th>
								<td><input type="text" style="width:130px;"  class="input" name="cr_amt" id="cr_amt" value=" " ></td>
								<th class="tr2_head2" align = "center">Credit Control Office</th>
								<td><input type="text" style="width:130px;" class="input" name="cr_clt_ofc_cd" id="cr_clt_ofc_cd" value=" "></td>
							</tr>
							<tr class="h23">
								<th class="tr2_head2" align = "center">I/B Credit Days</th>
								<td><input type="text" style="width:130px;" class="input" name="ib_cr_term_dys" id="ib_cr_term_dys" value=" "></td>
								<th class="tr2_head2" align = "center">O/B Credit Days</th>
								<td><input type="text" style="width:130px;" class="input" name="ob_cr_term_dys" id="ob_cr_term_dys" value=" "></td>
							</tr>
							<tr class="h23">
								<th class="tr2_head2" align = "center">B/L Count</th>
								<td><input type="text" style="width:130px;"  class="input2" name="1" id="1" value=" " readonly></td>
								<th class="tr2_head2" align = "center">Current OTS AMT</th>
								<td><input type="text" style="width:130px;" class="input2" name="2" id="2" value=" " readonly></td>
							</tr>
						</tbody>
					</table>
			    </div>
			</div>
			<!-- layout_wrap(E) -->
		</div>
		<div class="opus_design_data">
			<table class="search" style="width:1085px;">
				<tbody>
					<colgroup>
						<col width="120px">
						<col width="80px">
						<col width="150px">
						<col width="140px">
						<col width="150px">
						<col width="450px">
					</colgroup>
					<tr class="h23">
						<th class="tr_head">More Information</th>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>             
	     		    </tr>
				</tbody>
			</table>
			<table class="grid2" style="width:1085px;">
				<tbody>
					<colgroup>
						<col width="140px">
						<col width="80px">
						<col width="150px">
						<col width="140px">
						<col width="150px">
						<col width="*">
					</colgroup>
					<!-- <tr class="h23">
						<th class="tr_head">More Information</th>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>             
      				</tr> -->
					<tr class="h23">
						<th class="tr2_head2" align = "center">Industry Type1</th>
						<td colspan="3"><input type="text" style="width:360px;" class="input" name="indus_tp_n1st_desc" id="indus_tp_n1st_desc" value=" " ></td>
						<th class="tr2_head2" align = "center">Major Trade</th>
						<td><script type="text/javascript">ComComboObject('mjr_n1st_trd_cd', 2, 200, 1, 0 ,0 ,false)</script>
							<script type="text/javascript">ComComboObject('mjr_n2nd_trd_cd', 2, 200, 1, 0 ,0 ,false)</script>
						</td>					
					</tr>
					<tr class="h23">
						<th class="tr2_head2" align = "center">Industry Type2</th>
						<td colspan="3"><input type="text" style="width:360px;" class="input" name="indus_tp_n2nd_desc" id="indus_tp_n2nd_desc" value=" " ></td>
						<th class="tr2_head2" align = "center">Rep CMDT</th>
						<td><input type="text" style="width:80px;" class="input" name="prf_n1st_rep_cmdt_cd" id="prf_n1st_rep_cmdt_cd" value=" " maxlength="4" readonly>
							 <input type="text" style="width:291px;" class="input2" name="prf_n1st_cmdt_grp_dtl" id="prf_n1st_cmdt_grp_dtl" value=" " readonly>
						     <!-- <img class="cursor" src="img/button/btns_search.gif" alt="" width="19" height="20" align="absmiddle" name="btn_commodity1"> -->
						     <button type="button" class="input_seach_btn" name="btn_commodity1" id="btn_commodity1"></button></td>
					</tr>
					<tr class="h23">
						<th class="tr2_head2" align = "center">Customer Competitor</th>
						<td colspan="3"><input type="text" style="width:360px;"  class="input" name="cmpt_desc" id="cmpt_desc" value=" " OnDblClick="kkk()"></td>
						<th class="tr2_head2" align = "center">Rep CMDT</th>
						<td><input type="text" style="width:80px;" class="input" name="prf_n2nd_rep_cmdt_cd" id="prf_n2nd_rep_cmdt_cd" value=" " maxlength="4" readonly>
							 <input type="text" style="width:291px;" class="input2" name="prf_n2nd_cmdt_grp_dtl" id="prf_n2nd_cmdt_grp_dtl" value=" " readonly>
							 <!-- <img class="cursor" src="img/button/btns_search.gif" alt="" width="19" height="20" align="absmiddle" name="btn_commodity2"> -->
							 <button type="button" class="input_seach_btn" name="btn_commodity2" id="btn_commodity2"></button></td>
					</tr>
					<tr>
						<th class="tr2_head2" align = "center">Delivery Req</th>
						<td colspan="3"><input type="text" style="width:360px;"  class="input" name="spcl_req_desc" id="spcl_req_desc" value=" " ></td>	
						<th rowspan="2" class="tr2_head2" align = "center">Customer Remark</th>
						<td rowspan="2">
							<div>
								<textarea name="cust_rmk" id="cust_rmk" class="input2" style="text-indent: 0px;width:410px; height:45px; font-family:Lucida Console; overflow-y:scroll;resize:none;"></textarea>
							</div>
						</td>
					</tr>
					<tr class="h23">
						<th class="tr2_head2" align = "center">Equipment</th>
						<td> 
							<select name="prf_cntr_tpsz_cd" id="prf_cntr_tpsz_cd" style="width:70px;">
								<option value="" selected></option>
								<option value="D2">D2</option>
								<option value="D4">D4</option>
								<option value="D5">D5</option>
								<option value="R2">R2</option>
							</select>
						</td> 
						<th class="tr2_head2" align = "center">Yearly Volumn(TEU)</th>
						<td><input type="text" style="width:130px;"  class="input" name="yry_vol_qty" id="yry_vol_qty" value=" " dataformat="int" maxlength="6" ></td>
					</tr>
					<tr>
						<th class="tr2_head2" align = "center">Manage SLA</th>
						<td colspan="3"><input type="checkbox" name="cust_sla_flg" id="checkbox" class="trans" OnClick="onChangeCheckBox()"></td>	
						<th rowspan="2" class="tr2_head2" align = "center">Booking Alert Reason</th>
						<td rowspan="2">
							<div>
								<textarea name="bkg_alt_rsn" id="bkg_alt_rsn" class="input2" style="text-indent: 0px;width:410px; height:45px; font-family:Lucida Console; overflow-y:scroll;resize:none;"></textarea>
							</div>
						</td>
					</tr>
					<tr class="h23">
						<th class="tr2_head2" align = "center">URL</th>
						<td colspan="3"><input type="text" style="width:360px;"  class="input" name="cust_url" id="cust_url" value=" " ></td>
					</tr>
					<tr class="h23">
						<th class="tr2_head2" align = "center">Msg to Booking Staff</th>
						<td colspan="3"><input type="text" style="width:360px;"  class="input" name="bkg_alt_msg" id="bkg_alt_msg" value=" " ></td>
						<th class="tr2_head2" align = "center">Booking Alert Period</th>
						<td ><input type="text" style="width:136px;" class="input" name="bkg_alt_fm_dt" id="bkg_alt_fm_dt" value=" " dataformat="ymd" readonly>
							<!-- <img class="cursor" src="img/button/btns_calendar.gif" alt="" width="19" height="20" align="absmiddle" name="btn_cal2_fr"> -->
							<button type="button" class="calendar" name="btn_cal2_fr" id="btn_cal2_fr"></button>~
							<input type="text" style="width:136;" class="input" name="bkg_alt_to_dt" value=" " dataformat="ymd" readonly>
							<!-- <img class="cursor" src="img/button/btns_calendar.gif" alt="" width="19" height="20" align="absmiddle" name="btn_cal2_to"> -->
							<button type="button" class="calendar" name="btn_cal2_to" id="btn_cal2_to"></button>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('t6sheet1');</script>
		</div>
	</div>

	<div class="opus_design_grid clear" style="display:none;" name="tabLayer" id="tabLayer">
		<script type="text/javascript">ComSheetObject('t7sheet1');</script>
	</div>
</div>
<!-- opus_design_grid(E) -->	    	
</form>