<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAP_0030.jsp
*@FileTitle  : Invoice Slip
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/05
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.event.StmSap0030Event"%>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.OfficeCodeMgr"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="java.util.List"%>
<%@ page import="com.clt.bizcommon.util.BizComUtil"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>

<%
    StmSap0030Event event = null;			//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;		//서버에서 발생한 에러
	String strErrMsg = ""; 		  			//에러메세지
	int rowCount	 = 0;					//DB ResultSet Count of list

	String strUsr_id    = "";
	String strUsr_nm    = "";
	String strUsr_ofc   = "";
	
	String popMode  = "";
	String popOfcCd = "";
	String popInvDt = "";
	String popInvNo = "";

	Logger log = Logger.getLogger("com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice");

	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id  = account.getUsr_id();
		strUsr_nm  = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();

		event = (StmSap0030Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		
	} catch(Exception ex) {
		log.error("err " + ex.toString(), ex);
	}
	
	popMode  = (JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("pop_mode"))).equals(""))? "N" : "Y";
	popOfcCd = (JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("ofc_cd"))).equals(""))? "" : StringUtil.xssFilter(request.getParameter("ofc_cd"));
	popInvDt = (JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("inv_dt"))).equals(""))? "" : StringUtil.xssFilter(request.getParameter("inv_dt"));
	popInvNo = (JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("inv_no"))).equals(""))? "" : StringUtil.xssFilter(request.getParameter("inv_no"));
	

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
<% if (popMode.equals("Y")) { %>

      <!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button">Invoice Slip Inquiry</button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_print" id="btn_print" type="button">Print</button><!--
		--><button class="btn_normal" name="btn_close" id="btn_close" type="button">Close</button><!--
		--></div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->
      
<% } else { %>
<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_new" id="btn_new" type="button">New</button><!--
		--><button class="btn_normal" name="btn_print" id="btn_print" type="button">Print</button><!--
		--></div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->
	        
<% } %>		        

<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="hid_inv_seq" id="hid_inv_seq" />
<input type="hidden" name="hid_inv_curr_cd" id="hid_inv_curr_cd" />
<!-- Input Box for Report Designer -->
<input type="hidden" name="com_mrdPath" value="" id="com_mrdPath" />
<input type="hidden" name="com_mrdArguments" value="" id="com_mrdArguments" />
<input type="hidden" name="com_mrdTitle" value="Invoice Slip" id="com_mrdTitle" />
<input type="hidden" name="com_mrdBodyTitle" value="Invoice Slip" id="com_mrdBodyTitle" />
<input type="hidden" name="com_mrdSaveDialogFileExt" value="ppt" id="com_mrdSaveDialogFileExt" />
<input type="hidden" name="com_mrdSaveDialogFileExtLimit" value="xls@pdf@doc@ppt" id="com_mrdSaveDialogFileExtLimit" />
<input type="hidden" name="com_mrdSaveDialogFileName" value="Invoice Slip" id="com_mrdSaveDialogFileName" />
<input type="hidden" name="com_mrdSaveDialogDir" value="" id="com_mrdSaveDialogDir" />
<input type="hidden" name="pop_mode"   value="<%=popMode%>"  id="pop_mode" />
<input type="hidden" name="pop_ofc_cd" value="<%=popOfcCd%>" id="pop_ofc_cd" />
<input type="hidden" name="pop_inv_dt" value="<%=popInvDt%>" id="pop_inv_dt" />
<input type="hidden" name="pop_inv_no" value="<%=popInvNo%>" id="pop_inv_no" />
	        
<!-- wrap_search(S) -->
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="70" />				
				<col width="100" />				
				<col width="70" />				
				<col width="100" />				
				<col width="100" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
					<th>Office</th>
                  	<td><input type="text" style="width:80px;" class="input" name="ofc_cd" maxlength="6" dataformat="engup" id="ofc_cd" /><button type="button" id="btns_search_ofc" name="btns_search_ofc" class="input_seach_btn"></button></td>
                    <th>Pay Group</th>
                    <td><input type="text" style="width:160px;" class="input" name="ap_pay_grp_lu_cd" maxlength="25" dataformat="engup" id="ap_pay_grp_lu_cd" /><button type="button" id="btns_search_paygroup" name="btns_search_paygroup" class="input_seach_btn"></button></td>
                    <th>CSR No</th>
                    <td><input type="text" style="width:160px;" class="input" name="inv_no" maxlength="20" dataformat="engup" id="inv_no" /><button type="button" id="btns_search_csrno" name="btns_search_csrno" class="input_seach_btn"></button></td>
		   		</tr>
		   		<tr>
		   			<th>Invoice Date</th>
                    <td><input type="text" style="width:80px;" value="" name="inv_dt_fr" dataformat="ymd" maxlength="10" class="input1" required caption="Inv Date" cofield="inv_dt_to" caption="start date" id="inv_dt_fr" /><button type="button" id="btns_calInvFr" name="btns_calInvFr" class="calendar ir"></button>~ <input type="text" style="width:80px;" value="" name="inv_dt_to" dataformat="ymd" maxlength="10" class="input1" required caption="Inv Date" cofield="inv_dt_fr" caption="end date" id="inv_dt_to" /><button type="button" id="btns_calInvTo" name="btns_calInvTo" class="calendar ir"></button></td>
                    <th>Source</th>
                    <td><input type="text" style="width:160px;" class="input" name="ap_inv_src_cd" maxlength="25" dataformat="engup" id="ap_inv_src_cd" /><button type="button" id="btns_search_source" name="btns_search_source" class="input_seach_btn"></button></td>
                    <th>Supplier Inv No</th>
                    <td><input type="text" style="width:185px;" class="input" name="vendor_inv_no" maxlength="30" id="vendor_inv_no" dataformat="engupetc"/> </td>
		   		</tr>
		   		<tr>
                   <th>GL Date</th>
                   <td><input type="text" style="width:80px;" class="input" name="gl_dt_fr" dataformat="ymd" maxlength="10"  cofield="gl_dt_to" caption="start date" id="gl_dt_fr" /><button type="button" id="btns_calGlFr" name="btns_calGlFr" class="calendar ir"></button>~ <input type="text" style="width:80px;" class="input" name="gl_dt_to" dataformat="ymd" maxlength="10" cofield="gl_dt_fr" caption="end date" id="gl_dt_to" /><button type="button" id="btns_calGlTo" name="btns_calGlTo" class="calendar ir"></button></td>
                   <th>Supplier</th>
                   <td><input type="text" style="width:70px;" class="input" name="vndr_no" maxlength="6" dataformat="engup" id="vndr_no" /><button type="button" id="btns_search_supplier" name="btns_search_supplier" class="input_seach_btn"></button><input type="text" style="width:200px;" class="input2" name="vndr_nm" maxlength="100" dataformat="engup" readonly id="vndr_nm" /> </td>
              	   <th>Currency</th>
               	   <td><script type="text/javascript">ComComboObject('inv_curr_cd', 1, 70, 0, 0, 0, false, 1);</script></td>
               </tr>
               <tr>
                    <th class="sm pad_lef_4">Approval</th>
                    <td class="sm" colspan="2"><span style="font-weight:normal"><!--
                    --><input type="radio" name="approval" id="approval1" value="T" class="trans" checked><label for="approval1">All</label><!--
                    --><input type="radio" name="approval" id="approval2" value="U" class="trans"><label for="approval2">Unapproved</label><!--
                    --><input type="radio" name="approval" id="approval3" value="A" class="trans"><label for="approval3">Approved</label><!--
                    --><input type="radio" name="approval" id="approval4" value="C" class="trans"><label for="approval4">Cancelled</label></span></td>
				</tr>
		   </tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<!-- wrap_search(E) -->            
<!-- wrap_result(S) -->
<% if ( popMode.equals("") ) {  %>
<div class="wrap_result">
<% }else{  %>
<div height="470" style="padding:12px">
<% }  %> 
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_data">
		<table class="grid_2 mar_btm_8" style="width:100%">
			<colgroup>
				<col width="150" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
					<th style="text-align:center">Description</th>
					<td><input type="text" style="width:100%;text-align:left" class="noinput" name="inv_desc" id="inv_desc" readonly></td>
				</tr>
		   </tbody>
	    </table>
	</div>
	<!-- opus_design_inquiry(E) -->
	<div class="opus_design_tab">
		<script type="text/javascript">ComTabObject('tab1');</script>
	</div>
	
	<!--TAB : Lines (S) -->
	<div id="tabLayer" style="display:inline">
          	<!-- opus_design_grid(S) -->
			<div class="opus_design_grid">
				<script type="text/javascript">ComSheetObject('sheet2');</script>		
			</div>
			<!-- opus_design_grid(E) -->
    </div>
    <!--TAB Lines (E) -->
	<!--TAB : Lines (S) -->
	<div id="tabLayer" style="display:none">
          	<!-- opus_design_grid(S) -->
			<div class="opus_design_grid">
				<script type="text/javascript">ComSheetObject('sheet3');</script>		
			</div>
			<!-- opus_design_grid(E) -->
    </div>
    <!--TAB Lines (E) -->
	
</div>
</form>
