<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAP_0220.jsp
*@FileTitle  : Create Accounting Entries
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/05
=========================================================
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.event.StmSap0340Event"%>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.OfficeCodeMgr"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List"%>
<%@ page import="com.clt.bizcommon.util.BizComUtil"%>

<%
	StmSap0340Event  event = null;
    Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//DB ResultSet Count of list

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc		= "";
	List<String> rhqOfcList = null;
	Logger log = Logger.getLogger("com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();
		
		event = (StmSap0340Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// in loading page, Get data from server
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
	} catch(Exception e) {
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
<input type="hidden" name="functional_currency" value="" id="functional_currency" />
<input type="hidden" name="f_curr_prcs" value="" id="f_curr_prcs" />
<input type="hidden" name="capture_period" value="" id="capture_period" />
<input type="hidden" name="backendjob_key" id="backendjob_key" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel" >Down Excel</button>
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<div class= "wrap_search">
<!-- opus_design_inquiry(S) -->
	<div class= "opus_design_inquiry wFit">
	<table>
		<colgroup>
			<col width="30">
			<col width="140">
			<col width="100">
			<col width="320">
			<col width="50">
			<col width="*">
		</colgroup>
		<tbody>
			<tr>
                <th style = "text-align:left">Office</th>
                <td><input type="text" style="width:80px;" class="input" name="ofc_cd" dataformat="engup" id="ofc_cd" /><button type="button" id="btn_ofc_cd" name="btn_ofc_cd" class="input_seach_btn"></button></td>
                <th style = "text-align:left">Supplier</th>
                <td><input type="text" style="width:80px;" class="input" name="vndr_no" id="vndr_no" /><button type="button" id="btn_vndr_no" name="btn_vndr_no" class="input_seach_btn"></button><input type="text" style="width:300px;" class="input2" name="vndr_lgl_eng_nm" readonly="" id="vndr_lgl_eng_nm" /></td>
                <th style = "text-align:left">Currency</th>
                <td style="font-weight:normal;"><script type="text/javascript">ComComboObject('unstl_curr_cd', 1, 70, 0, 0,0,false,1);</script></td>
            </tr>
            <tr>
                <th style = "text-align:left">By Date</th>
                <td><input type="text" class="input" style="width:80px;" name="gl_dt" id="gl_dt" dataformat="ymd" maxlength="10" /><button type="button" id="btn_gl_dt" name="btn_gl_dt" class="calendar ir"></button></td>
                <th style = "text-align:left">Unsettled Account</th>
                <td><input type="text" style="width:80px;" class="input" name="coa_acct_cd" id="coa_acct_cd" /><button type="button" id="btn_acct_cd" name="btn_acct_cd" class="input_seach_btn"></button><input type="text" style="width:300px;" class="input2" name="coa_acct_nm" readonly="" id="coa_acct_nm" /></td>                           
            </tr>
		</tbody>
	</table>
 </div>
</div>                   
<!-- opus_design_inquiry(E) -->
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div>	
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid clear">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
	<div class= "opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="10" />
				<col width="100" />
				<col width="100" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
	                <th>Capture Period</th>
	                <td><input type="text" style="width:80px;" required="" caption="Capture Period" value="" name="unstl_yrmon" dataformat="ym" maxlength="6" class="input1" id="unstl_yrmon" /><button type="button" id="btns_calMm" name="btns_calMm" class="calendar ir"></button></td>
	            	<td><button type="button" class="btn_etc" id="btn_capture" name="btn_capture">Capture</button></td>
	           		<td></td>
	            </tr>
			</tbody>
		</table>
 	</div>
</div>
<!-- opus_design_grid(E) -->                                      
 </form>