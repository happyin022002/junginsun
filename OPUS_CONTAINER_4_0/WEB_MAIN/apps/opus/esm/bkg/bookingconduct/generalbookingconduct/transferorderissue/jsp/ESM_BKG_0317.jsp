<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : esm_bkg_0317.jsp
*@FileTitle  : TRO-T1 and Revenue Information
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/02
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.event.EsmBkg0317Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0317Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
/*	
	int rowCount	 = 0;						//count of DB resultSET list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
*/

	Logger log = Logger.getLogger("com.clt.apps.GeneralBookingConduct.TransferOrderIssue");
	
	try {	
/* 		
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   */ 
	
		event = (EsmBkg0317Event)request.getAttribute("Event");		
	   
		// get data from server when load page ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");


		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="term"      value="">
<input type="hidden" name="hlg_tp_cd" value="">
<input type="hidden" name="io_bnd_cd" value="">
<input type="hidden" name="cfm_flg"   value="">

<!-- OUTER - POPUP (S)tart -->

<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>TRO - T1 and Revenue Information</span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<div class="opus_design_inquiry wFit">
			<table> 
				<tr>
					<th>Booking No.</th>
					<td colspan="2"><input type="text" name="bkg_no" style="width:100;" class="input2" value="" readonly></td></tr> 
				<tr style="height:25px">
					<th width="120px">T1 Document</th>
					<td width="150px"class="sm"><input type="radio" name="t1_doc_flg" class="trans" value="Y">&nbsp;Yes&nbsp;&nbsp;&nbsp;&nbsp;
					    <input type="radio" name="t1_doc_flg" class="trans" value="N">&nbsp;No</td>
					    <td width="*"></td></tr> 
				<tr>
					<th>Customs CLR No.</th>
					<td colspan="2"><input type="text" name="cstms_clr_no" id="cstms_clr_no" style="width:144;" class="input" value="" maxlength="35" ></td></tr> 
				<tr style="height:25px">
					<th rowspan="3" valign="top" style="padding-top:4px">Manifested Rate</th>
					<td class="sm"><input type="radio" name="all_in_rt_cd" class="trans" value="Y">&nbsp;Yes&nbsp;</td>
					<td></td></tr> 
				<tr style="height:25px">
					<td class="sm"><input type="radio" name="all_in_rt_cd" class="trans" value="N">&nbsp;No&nbsp;</td>
					<td></td></tr>
                <tr style="height:25px">
					<td class="sm"><input type="checkbox" name="all_in_rt_cd" class="trans" value="A">&nbsp;Additional</td>
					<td></td></tr> 
				<tr>
					<th>Currency</th>
					<td  colspan="2"><input type="text" name="curr_cd" style="width:35;" class="input1" value="" maxlength="3" dataformat="engup" style="ime-mode:disabled"></td></tr> 
				<tr>
					<th>Manifested Revenue</th>
					<td   colspan="2"><input type="text"  style="width:144; text-align:right" class="input1" name="trns_rev_amt" caption="Manifested Revenue" value="" maxlength="14" pointcount="2" dataformat="float" ></td></tr>
				<tr>
					<th>Non-Manifested Revenue</th>
					<td  colspan="2"><input type="text" style="width:144; text-align:right" class="input1" name="non_trns_rev_amt" caption="Non-Manifested Revenue" value="" maxlength="14" pointcount="2" dataformat="float" ></td></tr> 
				<tr>
					<th>Additional Revenue</th>
					<td  colspan="2"><input type="text" style="width:144; text-align:right" class="input1" name="add_rev_amt" caption="Additional Revenue" value="" maxlength="14" pointcount="2" dataformat="float" ></td></tr>				
				<tr>
					<th>Additional Charge Code</th>
					<td  colspan="2"><input type="text" style="width:35;" class="input1" name="add_rev_chg_cd" value="" maxlength="3" dataformat="engup" style="ime-mode:disabled" ></td></tr>				
				<tr style="height:25px">
					<th>VAT</th>
					<td class="sm"><input type="radio" name="vat_flg" class="trans" value="Y">&nbsp;Yes&nbsp;&nbsp;&nbsp;&nbsp;
					    <input type="radio" name="vat_flg" class="trans" value="N">&nbsp;No</td>
					    <td></td></tr>
				<tr>
					<th>Canceled</th>
					<td  colspan="2"><input type="checkbox" name="cxl_flg" class="trans" value="" disabled=true></td></tr> 
			</table>
		</div>
		<script language="javascript">ComSheetObject('h1sheet1');</script>
	</div>
</div>
</form>


<SCRIPT LANGUAGE="javascript">
<!--
      with(document.form)
      {
        <%
        if(event != null){ 
            String bkgNo      = event.getBkgNo();
            String t1DocFlg   = event.getT1DocFlg();
            String cstmsClrNo = event.getCstmsClrNo();
            String allInRtFlg = event.getAllInRtFlg();
            String currCd     = event.getCurrCd();
            String trnsRevAmt = event.getTrnsRevAmt();  //.00
            String cxlFlg     = event.getCxlFlg();
            String vatFlg     = event.getVatFlg();
            String term       = event.getTerm();
            String hlgTpCd    = event.getHlgTpCd();
            String boundCd    = event.getIoBndCd();
            String cfmFlg     = event.getCfmFlg();
            String nonTrnsRevAmt  	= event.getNonTrnsRevAmt();
            String addRevAmt     	= event.getAddRevAmt();
            String addRevChgCd     	= event.getAddRevChgCd();
            
        %>    
            eval("bkg_no").value        = "<%=bkgNo%>";
            if ("<%=t1DocFlg%>" == "Y") {  
                eval("t1_doc_flg")[0].checked = true;
            } else {
                eval("t1_doc_flg")[1].checked = true;
            }  
            eval("cstms_clr_no").value  = "<%=cstmsClrNo%>";  
            if ("<%=allInRtFlg%>" == "Y") {  
                eval("all_in_rt_cd")[0].checked = true;
                eval("all_in_rt_cd")[2].checked = false;
            } else  if ("<%=allInRtFlg%>" == "N") {  
                eval("all_in_rt_cd")[1].checked = true;
                eval("all_in_rt_cd")[2].checked = false;
            } else if ("<%=allInRtFlg%>" == "A") {
                eval("all_in_rt_cd")[0].checked = true;
                eval("all_in_rt_cd")[2].checked = true;
            } else {
            	eval("all_in_rt_cd")[1].checked = true;
                eval("all_in_rt_cd")[2].checked = true;
            }
            
            
            eval("curr_cd").value       	   = "<%=currCd%>";  
            eval("add_rev_chg_cd").value       = "<%=addRevChgCd%>"; 
            
            if ("<%=trnsRevAmt%>".trim() == ".00") {
            	eval("trns_rev_amt").value  = changeComma_loc("", 0, 9, 2);
            } else {
            	eval("trns_rev_amt").value  = changeComma_loc("<%=trnsRevAmt%>", 0, 9, 2);
            }
            
            if ("<%=nonTrnsRevAmt%>".trim() == ".00") {
            	eval("non_trns_rev_amt").value  = changeComma_loc("", 0, 9, 2);
            } else {
            	eval("non_trns_rev_amt").value  = changeComma_loc("<%=nonTrnsRevAmt%>", 0, 9, 2);
            }
            if ("<%=addRevAmt%>".trim() == ".00") {
            	eval("add_rev_amt").value  = changeComma_loc("", 0, 9, 2);
            } else {
            	eval("add_rev_amt").value  = changeComma_loc("<%=addRevAmt%>", 0, 9, 2);
            }
            
            if ("<%=vatFlg%>" == "Y") {  
                eval("vat_flg")[0].checked = true;
            } else {
                eval("vat_flg")[1].checked = true;
            }
            
            if ("<%=cxlFlg%>" == "Y") {  
                eval("cxl_flg").checked = true;
            } else {
                eval("cxl_flg").checked = false;
            }  
            eval("term").value       = "<%=term%>";  
            eval("hlg_tp_cd").value  = "<%=hlgTpCd%>";
            eval("io_bnd_cd").value  = "<%=boundCd%>";    
            eval("cfm_flg").value    = "<%=cfmFlg%>";  
        <% } %>
       }
-->
</SCRIPT>
<%@include file="/bizcommon/include/common_opus.jsp"%>
