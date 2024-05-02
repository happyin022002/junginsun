<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_FMS_0016.jsp
*@FileTitle  : Charterer's Expenses
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/17
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event.EsmFms0016Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmFms0016Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error from Server
	String strErrMsg = "";						//Error Message

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.TimeCharterInOutAccounting.TCharterIOInvoice");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmFms0016Event)request.getAttribute("Event");
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
<input type="hidden" name="curr_cd" id="curr_cd" />
<input type="hidden" name="rev_yrmon" id="rev_yrmon" />
 
<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" type="button" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
		--><button class="btn_normal" type="button" name="btn_new" id="btn_new" >New</button><!--
		--><button class="btn_normal" type="button" name="btn_save" id="btn_save" >Save</button><!--
		--><button class="btn_normal" type="button" name="btn_savetofile" id="btn_savetofile" >Down Excel</button><!--
		--></div>
	<!-- opus_design_btn (E) -->

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
				<col width="85px" />				
				<col width="235px" />				
				<col width="108px" />				
				<col width="150px" />				
				<col width="90px" />
				<col width="129px" />					
				<col width="*" />				
		   </colgroup> 
		   <tbody>
	   			<tr class="h23">
					<th>Vessel Code</th><!-- width:122; -->
					<td><input type="text" onchange="vsl_cd_change()" style="width:54px;text-align:center;ime-mode:disabled" class="input1" dataformat="engup" maxlength="4" name="vsl_cd" id="vsl_cd" required caption="Vessel Code"><!-- 
					 --><button type="button" name="btn_vslpop" id="btn_vslpop"  class="input_seach_btn"></button><!-- 
					  --><input type="text" style="width:133px;" class="input2" name="vsl_eng_nm" id="vsl_eng_nm" readonly></td> 
					<th>Contract No.</th>
					<td><input type="text" style="width:120px;text-align:center;" class="input1" name="flet_ctrt_no" required caption="Contract No." readonly><!-- 
					 --><button type="button" name="contract_no" id="contract_no"  class="input_seach_btn"></button></td>
					<th>Contract type</th>
					<td><input type="text" style="width:54px;" class="input2" name="flet_ctrt_tp_cd" id="flet_ctrt_tp_cd" alt="" border="0" align="absmiddle" readonly></td>
					<td></td></tr>
				<tr class="h23">
					<th>Owner Code</th><!-- width:175; -->
					<td colspan="3"><input type="text" style="width:40px;" class="input2" name="cust_cnt_cd" id="cust_cnt_cd" readonly><!-- 
					 --><input type="text" style="width:75px;text-align:center;" class="input2" name="cust_seq" id="cust_seq" readonly><!-- 
					 --><input type="text" style="width:375px;" class="input2" name="vndr_lgl_eng_nm"  id="vndr_lgl_eng_nm" readonly></td> 
					<th>Owner Name</th>
					<td colspan="2"><input type="text" style="width:248px;" class="input2" name="ownr_nm" id="ownr_nm" readonly></td>
				</tr>
		   		<tr>
					<th>Invoice Date</th>
					<td><input type="text" style="width:82px;text-align:center;" class="input" name="from_chtr_inv_dt" id="from_chtr_inv_dt" dataformat="ymd"><!-- 
					 --><button type="button" name="from_inv_dt" id="from_inv_dt"  class="calendar ir"></button><!-- 
					  -->~ <!-- 
					   --><input type="text" style="width:80px;text-align:center;" class="input" name="to_chtr_inv_dt" id="to_chtr_inv_dt" dataformat="ymd"><!-- 
					    --><button type="button" name="to_inv_dt" id="to_inv_dt"  class="calendar ir"></button></td>
					<th>Charterer / Owner</th>
					<td><select style="width:85px;" class="input1" name="chtr_pay_rcv_cd" id="chtr_pay_rcv_cd" onchange="setDataClear(this.value);">
							<option value="P" selected>Charterer</option>
							<option value="R">Owner</option>
						</select></td>
                    <th>Item Name</th>
					<td><input type="text" style="width:248px;" class="input2" name="acct_itm_nm" id="acct_itm_nm" readonly><!-- 
					 --><input type="hidden" style="width:160px;" class="input2" name="acct_cd" id="acct_cd"><!-- 
					  --><input type="hidden" style="width:160px;" class="input2" name="acct_itm_seq"  id="acct_itm_seq"><!-- 
					   --><button type="button" name="item_name" id="item_name"  class="input_seach_btn"></button><!-- 
					    --><input type="checkbox" name="chkItemName" id="chkItemName" class="trans" checked onclick="setItemNameClear();" disabled></td>
		   		</tr>
		   </tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn_sdms" id="btn_sdms" type="button">SDMS</button><!--
			--><button class="btn_normal" name="btn_add" id="btn_add" type="button">Row Add</button><!--
			--><button class="btn_normal" name="btn_del" id="btn_del" type="button">Row Del</button><!--
			--></div>
		<!-- opus_design_btn (E) -->
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" style="display:none;">
		<script type="text/javascript">ComSheetObject('sheet2');</script>	
	</div>
	<!-- opus_design_grid(E) -->
</div> 

<div class="wrap_result">
	<!-- opus_design_data(S) -->
	<div class="opus_design_data">
		<table>
			<colgroup>
				<col width="265" />				
				<col width="90" />				
				<col width="147" />										
				<col width="*" />				
		   </colgroup>  
			<tr id="totalAmount" style="display:none;">
				<td width="100px"></td>
				<td valign="absmiddle">Total Amount</td>
				<td id="totalAmount1" valign="top" width="100px"></td>
				<td id="totalAmount2" valign="top" width="100px"></td>
			</tr>
		</table>
	</div>
<!-- opus_design_data(E) -->
		
</div>	
</form>