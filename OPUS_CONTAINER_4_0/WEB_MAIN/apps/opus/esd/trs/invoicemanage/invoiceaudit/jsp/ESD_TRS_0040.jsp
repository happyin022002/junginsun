<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0040.jsp
*@FileTitle  : Currency Change Popup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.bizcommon.util.BizComUtil"%>
<%@ page import="com.clt.apps.opus.esd.trs.invoicemanage.invoiceaudit.event.EsdTrs0040Event"%>
<%
	EsdTrs0040Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			
	DBRowSet rowSet	  = null;							   //DB ResultSet
	String strErrMsg = "";								
	int rowCount	 = 0;								  
	String selCurr ="";
	selCurr  = BizComUtil.getCodeCombo("inv_curr_cd","01","style=width:80 class=input onchange=checkCurr(this.value)","CURR",2,"0::ALL");

	String userId = "";
	String ofcId = "";
	try {

	   SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   userId=account.getUsr_id();
	   ofcId=account.getOfc_cd();

		event = (EsdTrs0040Event)request.getAttribute("Event");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
	String inv_no = JSPUtil.getNull(request.getParameter("inv_no"));
	String inv_vndr_seq = JSPUtil.getNull(request.getParameter("inv_vndr_seq"));
	String inv_vndr_nm = JSPUtil.getNull(request.getParameter("inv_vndr_nm"));
	String mode = JSPUtil.getNull(request.getParameter("mode"));
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

<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="usr_id" value="<%=userId%>" >
<input type="hidden" name="ofc_cd" value="<%=ofcId%>">
<input type="hidden" name="hid_provider">
<input type="hidden" name="hid_svc_provider">
<input type='hidden' name='TRSP_SO_VNDR_NO'>
<input type="hidden" name="insflag" value="true" >

<!-- Called by Pop-up from Inquiry(ESD_TRS_0030) -->
<input type="hidden" name="inv_no_param" value="<%=inv_no%>" id="inv_no_param" />
<input type="hidden" name="inv_vndr_seq_param" value="<%=inv_vndr_seq%>" id="inv_vndr_seq_param" />
<input type="hidden" name="inv_vndr_nm_param" value="<%=inv_vndr_nm%>" id="inv_vndr_nm_param" />
<input type="hidden" name="mode_param" value="<%=mode%>" id="mode_param" />


<!-- page(S) -->
<%String mainPage = JSPUtil.getNull(request.getParameter("mainPage"));%>
<% if("false".equals(mainPage)){  %>
<div class="layer_popup_title">
        <!-- page_title_area(S) -->
        <div class="page_title_area clear">
        
               <!-- page_title(S) -->
               <h2 class="page_title"><span id="title"></span></h2>
               <!-- page_title(E) -->
               
               <!-- opus_design_btn(S) -->
               <div class="opus_design_btn">
               		<button type="button" class="btn_normal" name="btn_minimize"         id="btn_minimize">Minimize</button>                  
               </div>
               <!-- opus_design_btn(E) -->
        </div>
		<!-- page_title_area(E) -->
</div>
<div class="layer_popup_contents">
<%}else{ %>
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	
	<!-- page_title(S) -->
    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_normal" name="btn_apply" id="btn_apply">Apply</button><!--
		 --><button type="button" class="btn_normal" name="btn_reset" id="btn_reset">Reset</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_minimize" id="btn_minimize">Minimize</button>
	</div>
	<!-- opus_design_btn(E) -->

   	<!-- page_location(S) -->
   	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
        <span id="navigation"></span>
   	</div>
   	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->
<%} %>


<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit" id="showMin" style="display:inline">
		<!--  MiniLayer (S) -->
		<table>
			<colgroup>
	            <col width="70" />
	            <col width="75" />
	            <col width="335" />
	            <col width="270" />
	            <col width="" />
			</colgroup>
			<tbody>
				<tr class="h23"> 
	                <th>W/O S/P</th>
					<td>
						<input class="input" type='text' name='combo_svc_provider' id="combo_svc_provider" style="width:140px;" onChange='getVendorSeq();'>
						<input type="text" name='svc_provider' id="svc_provider" readonly style="width:207px;">
						<button type="button" class="input_seach_btn" name="btng_provider"></button>
					</td>
					<th>Payment Service Provider</th>
					<td>
						<input name="paymt_sp_cd" type="hidden"><script type="text/javascript">ComComboObject('paymt_sp_combo', 1, 80);</script>
						<input name="paymt_sp_nm" id="paymt_sp_nm" readonly type="text" class="input" style="width:269px;" >
					</td>
					<td></td>
	           	</tr>
			</tbody>
		</table>
		
		<table>
			<colgroup>
	            <col width="70" />
	            <col width="171" />
	            <col width="100" />
	            <col width="361" />
	            <col width="90" />
	            <col width="90" />
	            <col width="" />
			</colgroup>
			<tbody>
				<tr class="h23"> 
	                <th>Invoice No.</th>
					<td><input class="input" type="text" style="width:140px;" value="" name="inv_no" dataformat="engupetc" maxlength="20"></td>
					<th>Issue Date</th>
					<td><input class="input" type="text" style="width:80px;" value="" id="inv_iss_dt" name="inv_iss_dt" dataformat="ymd"><button type="button" class="calendar" name="btns_calendar2"></button></td>
					<th>Receive Date</th>
					<td><input class="input" type="text" style="width:80px;" value="" id="inv_rcv_dt" name="inv_rcv_dt" dataformat="ymd"><button type="button" class="calendar" name="btns_calendar1"></button></td>
					<td></td>
	           	</tr>
	           	
			</tbody>
		</table>
		
		<table class="mar_btm_8">
			<colgroup>
	            <col width="70" />
	            <col width="189" />
	            <col width="111" />
	            <col width="120" />
	            <col width="90" />
	            <col width="118" />
	            <col width="94" />
	            <col width="101" />
	            <col width="152" />
	            <col width="90" />
	            <col width="" />
			</colgroup>
			<tbody>
				<tr class="h23"> 
	                <th>Currency</th>
					<td><%=selCurr%></td>
					<th>Invoice Amount</th>
					<td><input type="text" style="width:80px; text-align:right;" maxlength="14" name="inv_bzc_amt" value="0.00" onKeyUp="isMon(this,'Y');" onKeyDown="chkInput(this); isMon(this,'Y');" onBlur="chkAmtFmtObj(this); sumAmt();"></td>
					<th>V.A.T Amount</th>
					<td><input type="text" style="width:80px; text-align:right;" name="inv_vat_amt" value="0.00"  onKeyUp='isMon(this,"Y");' onKeyDown='chkInput(this); isMon(this,"Y");' onBlur="chkAmtFmtObj(this); sumAmt();"></td>
					<th>W.H.T Amount</th>
					<td><input type="text" style="width:80px; text-align:right;" name="inv_whld_tax_amt" value="0.00"  onKeyUp='isMon(this,"Y");' onKeyDown='chkInput(this); isMon(this,"Y");' onBlur="chkAmtFmtObj(this);sumAmt();"></td>
					<th>Total Amount</th>
					<td><input type="text" style="width:100px; text-align:right;" value="0.00" name="inv_ttl_amt"></td>
					<td></td>
	           	</tr>
	           	
			</tbody>
		</table>
		<!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" >
		
		<!-- opus_grid_btn(S) -->
			<div class="opus_design_btn">
				<button type="button" class="btn_normal" name="btng_invoicefileimport" id="btng_invoicefileimport" <%if(mode.equals("search")) {%>disabled='disabled'<%}%>>Invoice File Import</button>
				<button type="button" class="btn_normal" name="btng_rowadd" id="btng_rowadd" <%if(mode.equals("search")) {%>disabled='disabled'<%}%>>Row Add</button>
				<button type="button" class="btn_normal" name="btng_delete" id="btng_delete" <%if(mode.equals("search")) {%>disabled='disabled'<%}%>>Delete</button>
				<button type="button" class="btn_normal" name="btng_confirm" id="btng_confirm" <%if(mode.equals("search")) {%>disabled='disabled'<%}%>>Confirm</button>
			</div>
			<!-- opus_grid_btn(E) -->
			
		<script type="text/javascript">ComSheetObject('sheet1');</script>
		
		<!-- opus_grid_design_btn(E) -->
	</div>
	<!-- opus_design_grid(E) -->
	<div style="display:none">
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
</div>
<div class="header_fixed"></div>
<% if("false".equals(mainPage)){  %>
</div>
<% } %>


<script type="text/javascript">
	<%=JSPUtil.getIBCodeCombo("trsp_cost_dtl_mod_cd", "01", "CD00958", 0, " |")%>
	<%=JSPUtil.getIBCodeCombo("trsp_crr_mod_cd", "01", "CD00283", 0, " |")%>
	<%=BizComUtil.getIBCodeCombo("eq_tpsz", "01", "CNTRTPSZ", 0, " |")%> 
	<%=BizComUtil.getIBCodeCombo("ch_tpsz", "01", "CHASSIS", 0, " |")%> 
	<%=BizComUtil.getIBCodeCombo("gn_tpsz", "01", "GENSET", 0, " |")%> 

</script>

</form>