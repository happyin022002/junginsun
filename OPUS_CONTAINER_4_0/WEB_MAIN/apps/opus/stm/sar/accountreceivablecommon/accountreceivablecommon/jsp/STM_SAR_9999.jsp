<%--
=========================================================
*Copyright(c) 2015 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAR_9999.jsp
*@FileTitle  : batch & Interface Execute
*@author     : CLT
*@version    : 1.0
*@since      : 2015/01/14
=========================================================
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.event.StmSar9999Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	StmSar9999Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			// Errors from server.
	String strErrMsg = "";						// Error message.
	int rowCount	 = 0;						// DB ResultSet list count
 
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String loginOfcCd = "";
	Logger log = Logger.getLogger("com.clt.apps.opus.stm.sar.accountreceivablecommon.AccountReceivableCommonSC");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		loginOfcCd = account.getOfc_cd();

		event = (StmSar9999Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
 		 
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// Get data from server. ..
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

<form name="form" id="form">
<div style="display:none;"><script type="text/javascript">ComSheetObject('sheet1');</script></div>
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button">Batch & Interface Execute</button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_normal" name="btn_new" id="btn_new" type="button">New</button>
	</div>
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
				<col width="200" />				
				<col width="100" />				
				<col width="100" />				
				<col width="100" />				
				<col width="200" />				
				<col width="*" />	 			
		   </colgroup> 
		   <tbody>
		         <tr>
		             <th style="text-align:left;" >1. R3OP02 – Create Exchange Rate</th>
		             <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td> 
		             <th>Exchange Rate YM</th> 
		             <td><input name="rate_ym" type="text" style="width:60px;" class="input" value="" dataformat="ym" maxlength="6" id="rate_ym" /><!-- 
		              --><button type="button" id="btnRateYm" name="btnRateYm" class="calendar ir"></button><td> 
		          	 <td><button class="btn_normal" name="btn_save_r3op02" id="btn_save_r3op02" type="button">Execute</button></td>
		          	 <td></td>
		         </tr>
		          <tr>
		             <th style="text-align:left;">2. OPR301 – Invoice</th>
		             <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td> 
		             <th>Interface No</th>
		             <td><input name="if_no" dataformat="engup" type="text" class="input" style="width:530px;" value="" id="if_no" otherchar="," /><!-- 
		              --><td> 
		          	 <td><button class="btn_normal" name="btn_save_invoice" id="btn_save_invoice" type="button">Execute</button></td>
		          	 <td><button class="btn_normal" name="btn_save_invoice_t" id="btn_save_invoice_t" type="button">Execute Batch</button></td>
		         </tr>
		         <tr>
		             <th style="text-align:left;">3. OPR301 – Adjustment</th>
		             <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td> 
		             <th>Adjustment No</th>
		             <td><input name="adj_no" dataformat="engup" type="text" class="input" style="width:130px;" value="" id="adj_no" /><!-- 
		              --><td> 
		          	 <td><button class="btn_normal" name="btn_save_adjustment" id="btn_save_adjustment" type="button">Execute</button></td>
		          	 <td><button class="btn_normal" name="btn_save_adjustment_t" id="btn_save_adjustment_t" type="button">Execute Batch</button></td>
		         </tr>	
		         <tr>
		             <th style="text-align:left;">4. OPR301 – Offset</th>
		             <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td> 
		             <th>Offset No</th>
		             <td><input name="offset_no" dataformat="engup" type="text" class="input" style="width:130px;" value="" id="offset_no" /><!-- 
		              --><td> 
		          	 <td><button class="btn_normal" name="btn_save_offset" id="btn_save_offset" type="button">Execute</button></td>
		          	 <td><button class="btn_normal" name="btn_save_offset_t" id="btn_save_offset_t" type="button">Execute Batch</button></td>
		         </tr>	
		         <tr>
		             <th style="text-align:left;">5. OPR301 – Receipt</th>
		             <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td> 
		             <th>Receipt No</th>
		             <td><input name="receipt_no" dataformat="engup" type="text" class="input" style="width:130px;" value="" id="receipt_no" /><!-- 
		              --><td> 
		          	 <td><button class="btn_normal" name="btn_save_receipt" id="btn_save_receipt" type="button">Execute</button></td>
		          	 <td><button class="btn_normal" name="btn_save_receipt_t" id="btn_save_receipt" type="button">Execute Batch</button></td>
		         </tr>  
		         <tr>
		             <th style="text-align:left;">6. OPR301 – Receipt ASA</th>
		             <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td> 
		             <th>ASA No</th>
		             <td><input name="asa_no" dataformat="engup" type="text" class="input" style="width:130px;" value="" id="asa_no" /><!-- 
		              --><td>  
		          	 <td><button class="btn_normal" name="btn_save_asa" id="btn_save_asa" type="button">Execute</button></td>
		          	 <td><button class="btn_normal" name="btn_save_asa_t" id="btn_save_asa" type="button">Execute Batch</button></td>
		         </tr>  		 		   		
		         <tr>
		             <th style="text-align:left;">7. ZeroBalance – By RHQ,OFFICE</th>
		             <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td> 
		             <th>RHQ</th>
		             <TD colspan=2>
		             <input name="ar_hd_qtr_ofc_cd" dataformat="engup" type="text" class="input" style="width:50px;" value="" id="ar_hd_qtr_ofc_cd" /> 
		          	 <B>Office</B>&nbsp;<input name="ofc_cd" dataformat="engup" otherchar="," type="text" class="input" style="width:300px;" value="" id="ofc_cd" /></td> 
		          	<!--  <td>&nbsp;</td>   -->
		          	 <td><button class="btn_normal" name="btn_zb_t" id="btn_zb_t" type="button">Execute Batch</button></td>
		         </tr>   		 		   		
		         <tr>
		             <th style="text-align:left;">8. Miss Revenue VVD Batch</th>
		             <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td> 
		             <th>From Missing Date</th>
		             <TD colspan=2>
		             <input name="miss_dt" type="text" style="width:80px;" class="input1" value="<%=JSPUtil.getKST("yyyy-MM-dd")%>" dataformat="ymd" maxlength="8" id="miss_dt" readonly/><!-- 
		              --><button type="button" id="btnMissYmd" name="btnMissYmd" class="calendar ir"></button>
		          	 <B>Missing Service Lane</B>&nbsp;<input name="miss_slan" dataformat="engup" otherchar="," type="text" class="input" style="width:100px;" value="" id="miss_slan" maxlength="3" /> 
		          	 <B>Missing VVD</B>&nbsp;<input name="miss_vvd" dataformat="engup" otherchar="," type="text" class="input" style="width:100px;" value="" id="miss_vvd" maxlength="9" /></td> 
		          	<!--  <td>&nbsp;</td>   -->
		          	 <td><button class="btn_normal" name="btn_miss_vvd_t" id="btn_miss_vvd_t" type="button">Execute Batch</button></td>
		         </tr>   		 		   		
		         <tr>
		             <th style="text-align:left;">9. Migration Revenue VVD Batch</th>
		             <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td> 
		             <th>From Migration Date</th>
		             <TD colspan=2>
		             <input name="mig_dt" type="text" style="width:80px;" class="input1" value="<%=JSPUtil.getKST("yyyy-MM-dd")%>" dataformat="ymd" maxlength="8" id="mig_dt" readonly/><!-- 
		              --><button type="button" id="btnMigYmd" name="btnMigYmd" class="calendar ir"></button>
		          	 <B>Migration VVD</B>&nbsp;<input name="mig_vvd" dataformat="engup" otherchar="," type="text" class="input" style="width:100px;" value="" id="mig_vvd" maxlength="9" /></td> 
		          	<!--  <td>&nbsp;</td>   -->
		          	 <td><button class="btn_normal" name="btn_mig_vvd_t" id="btn_mig_vvd_t" type="button">Execute Batch</button></td>
		         </tr>  
		         <tr>
		             <th style="text-align:left;">10. FMS/JOO Interface</th>
		             <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td> 
		             <th>Interface No</th>
		             <td><input name="ots_if_no" dataformat="engup" type="text" class="input" style="width:130px;" value="" id="ots_if_no" /><!-- 
		              --><td> 
		          	 <td><button class="btn_normal" name="btn_save_if" id="btn_save_if" type="button">Execute</button></td>
		         </tr> 		 		   		
		   </tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
</form>
<%@include file="/bizcommon/include/common_alps.jsp"%>