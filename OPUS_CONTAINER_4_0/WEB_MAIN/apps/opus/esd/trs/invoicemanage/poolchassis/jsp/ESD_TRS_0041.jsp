<%--
 =========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0041.jsp
*@FileTitle  : Pool Chassis reposition cost Process
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
<%@ page import="com.clt.apps.opus.esd.trs.invoicemanage.poolchassis.event.EsdTrs0041Event"%>
<%

	EsdTrs0041Event  event = null;
	Exception serverException   = null;
	DBRowSet rowSet	  = null;
	String strErrMsg = "";
	int rowCount	 = 0;
	String selCurr ="";
	selCurr  = BizComUtil.getCodeCombo("inv_curr_cd","USD","style=width:90 onchange=checkCurr(this.value)","CURR",2,"0::ALL");
	String userId = "";
	String ofcId = "";
	String currentYearMonth = DateTime.getFormatString("yyyyMM");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   	userId=account.getUsr_id();
	   	ofcId=account.getOfc_cd();
		event = (EsdTrs0041Event)request.getAttribute("Event");
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
		}
		loadPage();
	}
</script>

<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="insflag" value="true" >
<input type="hidden" name="paymt_sp_cd">
<input type="hidden" name="trsp_inv_aud_sts_cd">
<input type="hidden" name="hidden_chss_pool_cd">
<input type="hidden" name="rgst_no">

<!-- Called by Pop-up from Inquiry(ESD_TRS_0030) -->
<input type="hidden" name="inv_no_param" value="<%=inv_no%>" id="inv_no_param" />
<input type="hidden" name="inv_vndr_seq_param" value="<%=inv_vndr_seq%>" id="inv_vndr_seq_param" />
<input type="hidden" name="inv_vndr_nm_param" value="<%=inv_vndr_nm%>" id="inv_vndr_nm_param" />
<input type="hidden" name="mode_param" value="<%=mode%>" id="mode_param" />

<!-- page_title_area(S) -->
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
	<div class="page_title_area clear">
		
		<!-- page_title(S) -->
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->		
		
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
			<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
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
	<div class="opus_design_inquiry wFit" id="showMin">
	    <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <table>
	        <colgroup>
	            <col width="80px" />
	            <col width="105px" />
	            <col width="" />
	        </colgroup>
	        <tbody>
				<tr>
					<th>Cost Month</th>
					<td><input type="text" style="width:90px;"value="<%=currentYearMonth%>" name="pool_chss_cost_yrmon" onKeyUp='isYearMonth(this);' onKeyDown='isYearMonth(this);' onBlur="chkYearMonth(this);"></td>
					<td></td>
				</tr>
			</tbody>
		</table>
		
		<table>
	        <colgroup>
	            <col width="80px" />
	            <col width="92px" />
	            <col width="187px" />
	            <col width="340px" />
	            <col width="" />
	        </colgroup>
	        <tbody>
				<tr>
					<th>Pool Name</th>
					<td>
					<script type="text/javascript">ComComboObject('chss_pool_cd',2, 90 , 0 ,0)</script><!-- 
					--><input type="text" name='chss_pool_nm' ReadOnly style="width:270px;"></td>
					<th>Payment Service Provider</th>
					<td><input name="paymt_sp" type="text" style="width:111px;" ReadOnly class="input2"><input name="paymt_sp_nm" type="text" style="width:234px;" ReadOnly class="input2"></td>
					<td></td>
				</tr>
			</tbody>
		</table>
		
		<table>
	        <colgroup>
	            <col width="80px" />
	            <col width="394px" />
	            <col width="164px" />
	            <col width="148px" />
	            <col width="90px" />
	            <col width="130px" />
	            <col width="" />
	        </colgroup>
	        <tbody>
				<tr>
					<th>Invoice No.</th>
					<td><input type="text" style="width:90px;" value="" name="inv_no" dataformat="engupetc" maxlength="20"></td>
					<th>Receive Date</th>
					<td><input type="text" style="width:80px;" value="" name="inv_rcv_dt" dataformat="ymd"><button type="button" class="calendar ir" name="btns_calendar1" id="btns_calendar1"></button></td>
				    <th>Issue Date</th>
					<td><input type="text" style="width:80px;" value="" name="inv_iss_dt" dataformat="ymd"><button type="button" class="calendar ir" name="btns_calendar2" id="btns_calendar2"></button></td>
					<td></td>
				</tr>
			</tbody>
		</table>
		
		
		<table>
	        <colgroup>
	            <col width="80px" />
	            <col width="158px" />
	            <col width="105px" />
	            <col width="130px" />
	            <col width="165px" />
	            <col width="148px" />
	            <col width="90px" />
	            <col width="80px" />
	            <col width="" />
	        </colgroup>
	        <tbody>
				<tr>
					<th>Currency</th>
					<td><%=selCurr%></td>
					<th>Invoice Amount</th>
					<td><input type="text" style="width:101px;text-align:right;" maxlength="14" name="inv_bzc_amt" value="0.00" ReadOnly class="input2"></td>
					<th>Tax Amount</th>
					<td><input type="text" style="width:80px;text-align:right;" name="inv_vat_amt" value="0.00" ReadOnly class="input2"></td>
					<th>Total Amount</th>
					<td><input type="text" style="width:80px;text-align:right;" value="0.00" name="inv_ttl_amt"  ReadOnly class="input2"></td>
					<td></td>
				</tr>
			</tbody>
		</table>
		
		<table>
	        <colgroup>
	            <col width="145px" />
	            <col width="329px" />
	            <col width="164px" />
	            <col width="319px" />
	            <col width="" />
	        </colgroup>
	        <tbody>
				<tr>
					<th>Invoice Creation Office</th>
					<td><input type="text" style="width:299px;" value="<%=ofcId%>" name="ofc_cd" ReadOnly class="input2"></td>
					<th>Invoice Creation User ID</th>
					<td><input type="text" style="width:318px;" value="<%=userId%>" name="usr_id" ReadOnly class="input2"></td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>	
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" >
		
		<!-- opus_grid_btn(S) -->
			<div class="opus_design_btn"><!-- 
				 --><button type="button" class="btn_normal" name="btng_rowadd" id="btng_rowadd" <%if(mode.equals("search")) {%>disabled='disabled'<%}%>>Row Add</button><!-- 
				--><button type="button" class="btn_normal" name="btng_save" id="btng_save" <%if(mode.equals("search")) {%>disabled='disabled'<%}%>>Save</button><!-- 
				--><button type="button" class="btn_normal" name="btng_invconfirm" id="btng_invconfirm" <%if(mode.equals("search")) {%>disabled='disabled'<%}%>>Invoice Confirm</button><!-- 
				--><button type="button" class="btn_normal" name="btng_invconfrimcancel" id="btng_invconfrimcancel" <%if(mode.equals("search")) {%>disabled='disabled'<%}%>>Invoice Confirm Cancel</button><!-- 
				--><button type="button" class="btn_normal" name="btng_invoicedelete" id="btng_invoicedelete" <%if(mode.equals("search")) {%>disabled='disabled'<%}%>>Invoice Delete</button><!-- 
			--></div>
			<!-- opus_grid_btn(E) -->
			
		<script type="text/javascript">ComSheetObject('sheet1');</script>
		
		<!-- opus_grid_design_btn(E) -->
	</div>
	<!-- opus_design_grid(E) -->
</div>
<div class="header_fixed"></div>
<% if("false".equals(mainPage)){  %>
</div>
<% } %>
</form>
