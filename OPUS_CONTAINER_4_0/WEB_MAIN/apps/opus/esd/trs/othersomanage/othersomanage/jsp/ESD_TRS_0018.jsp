﻿<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0018.jsp
*@FileTitle  : Other SO Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/04
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.bizcommon.util.BizComUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.trs.othersomanage.othersomanage.event.EsdTrs0018Event"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>

<%
	EsdTrs0018Event  event 		= null;			
	Exception serverException   = null;			
	String strErrMsg 			= "";			
	SignOnUserAccount account = null;

	try {

		event = (EsdTrs0018Event)request.getAttribute("Event");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);

	}catch(Exception e) {
		out.println(e.toString());
	}
	String costModeCd   = JSPUtil.getCodeCombo("trs_cost_md_cd", "01", "style='width:140' OnChange='resetSearchCondition(this)'", "CD00744", 0, "000020::");
	String transModeCd  = JSPUtil.getCodeCombo("trs_md_cd", "01", "style='width:74px' OnChange='resetSearchCondition(this)'", "CD00283", 0, "000010::");
	String cagoTpCd  = JSPUtil.getCodeCombo("trs_cago_tp_cd", "01", "style='width:70px' disabled", "CD00748", 0, "000010::");
	String wgtCd  = JSPUtil.getCodeCombo("trs_wgt_cd", "01", "style='width:67px' ", "CD00775", 0, "000010::");
	String bndCd  = JSPUtil.getCodeCombo("trs_bnd_cd", "01", "style='width:125px' ", "CD00591", 0, "000010::");
	String cntCd  = JSPUtil.getCodeCombo("trs_cnt_cd", "01", "style='width:70px' ", "CD00919", 0, "000010::");
%>

<script type="text/javascript">

	<%=BizComUtil.getIBCodeCombo("default_curr", "01", "CURR", 1, "")%>

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		setKindEnabled();
	}
</script>

<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="TRSP_SO_VNDR_NO" id="TRSP_SO_VNDR_NO" />
<input type="hidden" name="TRSP_SO_TP_CD" id="TRSP_SO_TP_CD" />
<input type="hidden" name="TRSP_SO_STS_CD" id="TRSP_SO_STS_CD" />
<input type="hidden" name="TRSP_EQ_KND_CD" id="TRSP_EQ_KND_CD" />
<input type="hidden" name="TRSP_SO_EQ_KIND" id="TRSP_SO_EQ_KIND" />
<input type="hidden" name="EQ_TPSZ_CD" id="EQ_TPSZ_CD" />
<input type="hidden" name="INPUT_CUST_CD">
<input type="hidden" name="INPUT_CUST_NM">
<input type="hidden" name="TRSP_SO_COST_MONTH" id="TRSP_SO_COST_MONTH" />
<input type="hidden" name="FORM_CRE_USR_ID" value="<%=account.getUsr_id()%>" id="FORM_CRE_USR_ID" />
<input type="hidden" name="FORM_USR_OFC_CD" value="<%=account.getOfc_cd()%>" id="FORM_USR_OFC_CD" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><button type="button" class="btn_normal" name="btn_add" id="btn_add">Add</button><!--
	 --><button type="button" class="btn_normal" name="btn_reset" id="btn_reset">Reset</button><!--
	 --><button type="button" class="btn_normal" name="btn_minimize" id="btn_minimize">Minimize</button>
	</div>
	<!-- opus_design_btn(E) -->
	
	<!-- page_location(S) -->
	<div class="location">
	<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->

<div id="MiniLayer" style="display:inline">
<!-- wrap_search(S) -->  
<div class="wrap_search">
<!-- opus_design_inquiry (S) -->
<div class="opus_design_inquiry wFit">
	<table>
		<colgroup>
			<col width="100">
			<col width="180">
			<col width="100">
			<col width="185">
			<col width="50">
			<col width="128">
			<col width="50">
			<col width="*">
		</colgroup>
		<tr>
			<th>Quantity</th>
			<td><input type="text" style="width:70px;" name="otherso_qty" onChange="checkNumber(this, true);" maxlength="4" dataformat="engup"></td>
			<th>Cost Mode</th>
			<td><%=costModeCd%></td>
			<th>Trans Mode</th>
			<td><%=transModeCd%></td>
			<th>Bound</th>
			<td><%=bndCd%></td>
		</tr>
		<tr>
			<th>Cargo Type</th>
			<td><%=cagoTpCd%></td>
			<th>Weight</th>
			<td><input type="text" style="width:74px" name='cntr_wgt' id='cntr_wgt' dataformat="engup"><%=wgtCd%></td>
			<th>Commodity Code</th>
			<td colspan="3"><input type="text"  name='commodity_cd' id='commodity_cd'  style="width:74px" onChange='getTextCmdtCd(sheetObjects[0], document.form, this.value)' onKeyup='enterCheck(this)' dataformat="engup"><!-- 
			 --><input type="text" style="width:280px;" name='commodity_nm' id='commodity_nm' readOnly><!-- 
			  --><button type="button" name="btng_commodity" id="btng_commodity"  class="input_seach_btn"></button></td>
		</tr>
		<tr>
			<th>NYK / CNT</th>
			<td><%=cntCd%></td>
			<th>Customer Code</th>
			<td colspan="3"><input type="text" style="width:74px" name='input_cust_cd' id='input_cust_cd' onChange='getTextCustCd(sheetObjects[0], document.form, this.value)' onBlur='value_upper(this)'  onKeyup='enterCheck(this)' dataformat="engup"><!-- 
			 --><input type="text" style="width:283px;" name='input_cust_nm' id='input_cust_nm' readOnly><!-- 
			  --><button type="button" name="btng_customer" id="btng_customer"  class="input_seach_btn"></button></td>
			<th>Cost Month</th>
			<td><input type="text" style="width:90px" name='trsp_otr_cost_mon_dt' id='trsp_otr_cost_mon_dt' onBlur="BlurDate(this)" maxlength=6 dataformat="engup"><font color="red"><strong>(YYYYMM)</strong></font></td>
		</tr>
		<tr>
			<th>From</th>
			<td><input name="search_fm_loc" id="search_fm_loc" type="text" style="width:70px;" maxlength="5" onFocus='fun_Focus(this)' onChange="getComboList(this, document.search_fm_yard, 'F');" onBlur="" dataformat="engup"><!-- 
			 --><script type="text/javascript">ComComboObject('search_fm_yard', 1, 45, 0);</script><!-- 
			 --><button type="button" name="btn_fm_node" id="btn_fm_node"  class="input_seach_btn"></button>			 			
			</td>
			<th>Via</th>
			<td><input name="search_via_loc" type="text" style="width:74px;" maxlength="5" onFocus='fun_Focus(this)' onChange="getComboList(this, document.form.search_via_yard, 'V');" onBlur="" dataformat="engup"><!-- 
			 --><script type="text/javascript">ComComboObject('search_via_yard', 1, 45, 0);</script><!-- 
			 --><button type="button" name="btn_via_node" id="btn_via_node"  class="input_seach_btn"></button></td>
			<th>To</th>
			<td><input name="search_to_loc" type="text" style="width:74px;" maxlength="5" onFocus='fun_Focus(this)' onChange="getComboList(this, document.form.search_to_yard, 'T');"  onBlur="" dataformat="engup"><script type="text/javascript">ComComboObject('search_to_yard', 1, 50, 0);</script><!-- 
			 --><button type="button" name="btn_to_node" id="btn_to_node"  class="input_seach_btn"></button></td>
			<th>Door</th>
			<td><input name="search_dr_loc" type="text" style="width:69px;" maxlength="5" onFocus='fun_Focus(this)' onChange="getComboList(this, document.form.search_door_yard, 'D');"  onBlur="" dataformat="engup"><script type="text/javascript">ComComboObject('search_dr_yard', 1, 52, 0);</script><!-- 
			 --><button type="button" name="btn_dr_node" id="btn_dr_node"  class="input_seach_btn"></button></td>
		</tr>
		<tr>
			<th>Actual Customer</th>
			<td colspan="3"><input type="text" style="width:355px;" name='search_act_cust' dataformat="engup"><!-- 
			 --><button type="button" name="btn_act_cus" id="btn_act_cus"  class="input_seach_btn"></button></td>			
			<th>Door Delivery Address</th>
			<td colspan="3"><input type="text" style="width:362px;" name='door_delv_addr' id='door_delv_addr'><!-- 
			 --><input type="hidden" name='act_cust_addr_seq' id='act_cust_addr_seq'><!-- 
			  --><input type="hidden" name='fctry_nm' id='fctry_nm'><!-- 
			   --><input type="hidden" name='cntc_pson_nm' id='cntc_pson_nm'><!-- 
			    --><input type="hidden" name='cntc_pson_phn_no' id='cntc_pson_phn_no'><!-- 
			     --><input type="hidden" name='cntc_pson_fax_no' id='cntc_pson_fax_no'>
			</td>
		</tr>		
		<tr>
			<th>Service Provider</th>
			<td colspan="3">
				<input type='text' name='combo_svc_provider'  style="width:70px;" onChange='getTextVendorSeq(sheetObjects[0], document.form, this.value)' onKeyup='enterCheck(this)' dataformat="num" maxlength="6"><!-- 
				 --><input type="text" style="width:280px;" name='svc_provider' readOnly class="input2"><!-- 
				  --><button type="button" name="btng_provider" id="btng_provider"  class="input_seach_btn"></button></td>				 
			<th>Reason</th>
			<td colspan="3"><input type="text" style="width:100px;" name='otherso_reason' id='otherso_reason'></td>
		</tr>
	</table>
</div>
<!-- opus_design_inquiry (E) -->
</div>
<!-- wrap_search(E) -->  
</div>
<!-- wrap_result(S) -->  
<div class="wrap_result" style="overflow:hidden">

<!-- opus_design_grid(S) -->
<div class="opus_design_grid" id="mainTable">
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn" >
	<!-- Content -->
		<button type="button" class="btn_normal" name="btng_fillineq" id="btng_fillineq">Fill In EQ No.</button><!-- 
		 --><!-- <button type="button" class="btn_normal" name="btng_rateapply" id="btng_rateapply">Rate Apply</button> --><!-- 
		  --><button type="button" class="btn_normal" name="btng_downexcel" id="btng_downexcel">Down Excel</button><!-- 
		   --><button type="button" class="btn_normal" name="btng_socreation" id="btng_socreation">S/O Creation</button>
		    <button type="button" class="btn_normal" name="btng_woissue" id="btng_woissue">W/O Issue</button>
	</div>
	<!-- opus_design_btn(e) -->
	<script type="text/javascript">ComSheetObject('sheet');</script>
	
	<script type="text/javascript">ComSheetObject('sheet1');</script>
	<script type="text/javascript">ComSheetObject('sheet2');</script>
	<script type="text/javascript">ComSheetObject('sheet3');</script>
	<script type="text/javascript">ComSheetObject('sheet4');</script>
	<!-- <script type="text/javascript">ComSheetObject('sheet5');</script> -->
</div>
<!-- opus_design_grid(E) -->

</div>
<!-- wrap_result(E) -->  





</form>

<form name='woForm' method='POST'>
	<input type='hidden' name='trsp_so_ofc_cty_cd'>
	<input type='hidden' name='trsp_so_seq'>
	<input type='hidden' name='eq_mode'>
	<input type="hidden" name="sysCommUiTitle" value="Issue">
	<input type="hidden" name="sysCommUiNavigation" value="Trans S/O > Work Order">
	<input type="hidden" name="pgmNo" value="">
	<input type="hidden" name="parentPgmNo" value="">
</form>