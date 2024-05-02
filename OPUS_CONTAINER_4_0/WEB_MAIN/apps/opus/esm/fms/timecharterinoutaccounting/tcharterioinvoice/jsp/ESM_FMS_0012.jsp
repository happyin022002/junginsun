<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_FMS_0012.jsp
*@FileTitle  : Prepayments
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/18
=========================================================
--%>

<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	Exception serverException = null;			//Error from Server
	String strErrMsg = "";	
	
	String usrId = "";
	String strUsr_nm		= "";
	String strOfc_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.TimeCharterInOutAccounting.TCharterIOInvoice");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   	usrId = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_nm = account.getOfc_eng_nm();
	   	
	   	serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
	}catch(Exception e) {
		log.error(e.getMessage(),e);
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
<input type="hidden" name="ibflag" id="ibflag" />
<input type="hidden" name="inv_seq" id="inv_seq" />
<input type="hidden" name="ppay_hir_no" id="ppay_hir_no" />
<input type="hidden" name="ori_eff_dt" id="ori_eff_dt" />
<input type="hidden" name="ori_exp_dt" id="ori_exp_dt" />
<input type="hidden" name="ori_inv_usd_dys" id="ori_inv_usd_dys" />
<input type="hidden" name="flet_ctrt_tp_gb" id="flet_ctrt_tp_gb" />
<input type="hidden" name="usr_id" id="usr_id" value="<%=usrId%>">
<!-- for print -->
<input type="hidden" name="usr_nm" id="usr_nm" value="<%=strUsr_nm%>" >
<input type="hidden" name="ofc_nm" id="ofc_nm" value="<%=strOfc_nm%>">
<input type="hidden" name="hire_no" id="hire_no">
<input type="hidden" name="chk_pay_hir_no" id="chk_pay_hir_no">
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		 <button type="button" class="btn_normal" name="btn_execute" id="btn_execute">Execute</button><!-- 
		  --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
		  --><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!-- 
		  --><button type="button" class="btn_normal" name="btn_delete2" id="btn_delete2">Delete</button><!-- 
		   --><button style="display:none" type="button" class="btn_normal" name="btn_invoice" id="btn_invoice">Hire&nbsp;Invoice</button>
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->
<div class= "wrap_search">
<!-- opus_design_inquiry (S) -->
<div class= "opus_design_inquiry wFit">
	<table class="search_in">	
		<tbody>
		<colgroup>
			<col width="80px"/>
			<col width="*"/>
		</colgroup>
			<tr height="30px">
				<th>Condition</th>
				<td><input type="radio" class="trans" name="condition" value="C" checked onClick="setHireNo('C');"><!-- 
					 --><label for="radio_snc_sc">Creation</label><!-- 
					 --><input type="radio" class="trans" name="condition" value="I" onClick="setHireNo('I');"><!-- 
					 --><label for="radio_snc_sc">Inquiry</label></td>
		 	</tr>	
		</tbody>
	</table>
	<table>	
		<tbody>
		<colgroup>
			<col width="80px"/>
			<col width="250px"/>
			<col width="90px"/>
			<col width="150px"/>
			<col width="165px"/>
			<col width="130px"/>
			<col width="10px"/>
			<col width="10px"/>
			<col width="*">
		</colgroup>
			<tr>
				<th>Vessel Code</th>
				<td><input type="text" style="width:54px;text-align:center;" class="input1" maxlength="4" name="vsl_cd" required caption="Vessel Code" id="vsl_cd" dataformat="engup"/><button type="button" id="btn_vslpop" name="btn_vslpop" class="input_seach_btn"></button><input type="text" style="width:162px;" class="input2" name="vsl_eng_nm" readonly id="vsl_eng_nm" /> </td>
				<th>Contract No.</th>
				<td><input type="text" style="width:120px; text-align:center;" class="input1" maxlength="15" name="flet_ctrt_no" caption="Contract No." readonly id="flet_ctrt_no" /><button type="button" id="contract_no" name="contract_no" class="input_seach_btn"></button></td>
				<th>Contract TP</th>
				<td><input type="text" style="width:70px;text-align:center;" class="input2" name="flet_ctrt_tp_cd" readonly id="flet_ctrt_tp_cd" /> </td>
				<td></td>
				<th>Hire No.</th>
				<td id="c_ppay_hir_no" style="display:;"><input type="text" style="width:45px;text-align:center;" class="input1" maxlength="5" name="pay_hir_no" id="pay_hir_no" dataformat="int" readonly="readonly"></td>
				<td id="i_ppay_hir_no" style="display:none;"><script type="text/javascript">ComComboObject('pay_hir_no2', 1, 47, 2);</script></td>
		 </tr>	
		</tbody>
	</table>
	<table>
		<tbody>
			<colgroup>
				<col width="80px"/>
				<col width="500px"/>
				<col width="165px"/>
				<col width="*"/>
			</colgroup>																		
		 <tr>
				<th>Owner Code</th>
				<td><input type="text" style="width:30px;text-align:center;" class="input2" name="cust_cnt_cd" readonly id="cust_cnt_cd" /><!-- 
				 --><input type="text" style="width:67px;text-align:center;" class="input2" name="cust_seq" readonly id="cust_seq" /><!-- 
				 --><input type="text" style="width:390px;" class="input2" name="vndr_lgl_eng_nm" readonly id="vndr_lgl_eng_nm" /></td>
				<th>Owner Name</th>
				<td><input type="text" style="width:333px;" class="input2" name="ownr_nm" readonly id="ownr_nm" /></td>
		</tr>
		</tbody>
	</table>
	<table>
		<tbody>
			<colgroup>
				<col width="80px"/>
				<col width="502px"/>
				<col width="165px"/>
				<col width="130px"/>
				<col width="10px"/>
				<col width="*" />
			</colgroup>		
		 <tr>
				<th>Duration</th>
				<td><input type="text" style="width:75px;text-align:center;" class="input" name="eff_dt" dataformat="ymd" id="eff_dt"/><!-- 
				 --><input type="text" style="width:50px;text-align:center;" class="input" name="from_time" maxlength="4" dataformat="hm" id="from_time" /><!-- 
				 --><button type="button" id="ef_dt" name="ef_dt" class="calendar ir"></button>~&nbsp;<!-- 
				 --><input type="text" style="width:75px;text-align:center;" class="input" name="exp_dt" dataformat="ymd" id="exp_dt" /><!-- 
				 --><input type="text" style="width:50px;text-align:center;" class="input" name="to_time" maxlength="4" dataformat="hm" id="to_time" /><!-- 
				 --><button type="button" id="ex_dt" name="ex_dt" class="calendar ir"></button><!-- 
				 --><input type="text" style="width:60px;text-align:right" class="input2" name="inv_usd_dys" readonly id="inv_usd_dys" />&nbsp;Days</td>
				<th>Address Comm.</th>
				<td><input type="text" style="width:45px;text-align:right;" class="input2" name="acmm_rt_amt" dataformat="float" maxlength="6" pointcount="2" caption="Address Comm." readonly id="acmm_rt_amt" />  %&nbsp;<!-- 
				 --><input type="checkbox" value="N" class="trans" name="acmm_flg" id="acmm_flg" /> </td>
				<th>Brokerage</th>
				<td><input type="text" style="width:45px;text-align:right;" class="input2" name="flet_brog_rt_amt" dataformat="float" maxlength="6" pointcount="2" caption="Brokerage" readonly id="flet_brog_rt_amt" />  %&nbsp;<!-- 
				 --><input type="checkbox" value="N" class="trans" name="brog_flg" id="brog_flg" /> </td>
		</tr>
		</tbody>
	</table>
	</div>
	<table class="line_bluedot"><tr><td height="10"></td></tr></table>
	<div class= "opus_design_inquiry wFit">
	<h3 style="margin-bottom:0" class="title_design">Hire Information</h3>
	<table>
		<tbody>
			<colgroup>
				<col width="42px"/>
				<col width="*" />
			</colgroup>
              <tr>
                  <th>Hire</th>
                  <td><input type="text" style="width:76px;text-align:center;" class="input2" name="hir_eff_dt" readonly id="hir_eff_dt" /><input type="text" style="width:45px;text-align:center;" class="input2" name="hir_eff_dt_time" readonly id="hir_eff_dt_time" /> ~ <input type="text" style="width:76px;text-align:center;" class="input2" name="hir_exp_dt" readonly id="hir_exp_dt" /><input type="text" style="width:45px;text-align:center;" class="input2" name="hir_exp_dt_time" readonly id="hir_exp_dt_time" /><label></label><input type="text" style="width:40px;text-align:center;" class="input2" name="hir_hir_curr_n1st_cd" readonly id="hir_hir_curr_n1st_cd" /><input type="text" style="width:95px;text-align:right;" class="input2" name="hir_hir_rt_n1st_amt" readonly id="hir_hir_rt_n1st_amt" /><label></label><input type="text" style="width:40px;text-align:center;" class="input2" name="hir_hir_curr_n2nd_cd" readonly id="hir_hir_curr_n2nd_cd" /><input type="text" style="width:110px;text-align:right;" class="input2" name="hir_hir_rt_n2nd_amt" readonly id="hir_hir_rt_n2nd_amt" /> 
				  </td>
			 </tr>
		</tbody>
</table>
</div>
</div>
</div>
<div class="wrap_result">
<!-- opus_design_inquiry(E) -->
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear" style="width: 100%">
		<h3 style="margin-bottom:5px" class="title_design">Other Lumpsum information</h3>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	
	<table class="line_bluedot"><tr><td></td></tr></table>
	
	<div class="opus_design_grid clear" style="width: 100%">
		<div class="opus_design_btn">
			  <button type="button" class="btn_normal" name="btn_delete" id="btn_delete">Row Del</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
</div>
<div class="wrap_result">
	<!-- opus_design_data(S) -->
	<div class="opus_design_data" align="right">
		<table style="width:100%; text-align:right;">
			<colgroup>
				<col width="500px" />				
				<col width="150px" />				
				<col width="120px" />			
				<col width="120px" />				
		   </colgroup>  
			<tr id="totalAmount" style="display:none;">
				<td></td>
				<td valign="middle" align="right">Total (except brokerage)</td>
				<td id="totalAmount1" valign="middle" width="120px"></td>
				<td id="totalAmount2" valign="middle" width="120px"></td>
			</tr>
		</table>
	</div>
<!-- opus_design_data(E) -->
		
</div>
</form>
