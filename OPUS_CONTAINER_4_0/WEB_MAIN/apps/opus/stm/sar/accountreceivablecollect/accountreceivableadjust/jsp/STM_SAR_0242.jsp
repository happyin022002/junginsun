<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAR_0242.jsp
*@FileTitle  : Offset AP Search Popup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/06
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.event.StmSar0242Event"%>
<%@ page import="com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.AROfficeListVO"%>
<%@ page import="org.apache.log4j.Logger" %>


<%

    StmSar0242Event event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	
	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.clt.apps.opus.stm.sar.accountreceivablecollect.AccountReceivableCollectSC");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
		event = (StmSar0242Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
				
	} catch(Exception ex) {
		log.error("err " + ex.toString(), ex);
		//out.println(e.toString());
	}
	
	// required parameter
	String ofcCd = JSPUtil.getParameter(request, "ofc_cd", "");
	String ots_cd = JSPUtil.getParameter(request, "ots_cd", "");
	String rep_ots_ofc_cd = JSPUtil.getParameter(request, "rep_ots_ofc_cd", "");

	
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
<input type="hidden" name="f_cmd" id="f_cmd"> 
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="offst_curr_cd" id="offst_curr_cd" value="<%=event.getOffsetAPPopupListVO().getOffstCurrCd()%>">
<input type="hidden" name="ots_cd" id="ots_cd"  value="<%=ots_cd%>" />
<input type="hidden" name="rep_ots_ofc_cd"  id="rep_ots_ofc_cd"  value="<%=rep_ots_ofc_cd%>" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><span>Offset AP Search</span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn"><!-- 
		 --><button type="button" id="btn_searchlist" name="btn_searchlist" class="btn_accent">Retrieve</button><!--
		--><button type="button" id="btn_OK" name="btn_OK" class="btn_normal">Select</button><!--
		--><button type="button" id="btn_Close" name="btn_Close" class="btn_normal">Close</button><!--
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
				<col width="60"/>
				<col width="540"/>
				<col width="60"/>
				<col width="*" />				
			</colgroup> 
			<tr>
             	<th>Vendor</th>
                <td><input id="vndr_no" style="width:100px;text-align:center;ime-mode:disabled" class="input" name="vndr_no" maxlength="6" dataformat="num" type="text" /><button class="input_seach_btn" name="btns_vndr_popup" id="btns_vndr_popup" type="button"></button><input id="vndr_lgl_eng_nm" style="width:350px;" readonly="readonly" class="input2" name="vndr_lgl_eng_nm" maxlength="200" type="text" /></td>
                <th>Office</th>
                <td><input id="ofc_cd" style="width:105px;" name="ofc_cd" maxlength="6" dataformat="engup" readonly="readonly" class="input2" value="<%=ofcCd%>" type="text" /> </td>
             </tr>
		</table>
		<table>
			<colgroup>
				<col width="150"/>
				<col width="*" />				
			</colgroup> 
	       <tr>
	         <td colspan="2"><h3>Invoice No.</h3></td>
	       </tr>
	       <tr>
	         <td><input id="inv_no" style="width:150px;" class="input" name="inv_no" maxlength="50" dataformat="engup" type="text" /><!-- 
	          --><input id="inv_no" style="width:150px;" class="input" name="inv_no" maxlength="50" dataformat="engup" type="text" /><!-- 
	          --><input id="inv_no" style="width:150px;" class="input" name="inv_no" maxlength="50" dataformat="engup" type="text" /><!-- 
	          --><input id="inv_no" style="width:150px;" class="input" name="inv_no" maxlength="50" dataformat="engup" type="text" /><!-- 
	          --><input id="inv_no" style="width:150px;" class="input" name="inv_no" maxlength="50" dataformat="engup" type="text" /></td>
	       </tr>
	       <tr>
	         <td><input id="inv_no" style="width:150px;" class="input" name="inv_no" maxlength="50" dataformat="engup" type="text" /><!-- 
	          --><input id="inv_no" style="width:150px;" class="input" name="inv_no" maxlength="50" dataformat="engup" type="text" /><!-- 
	          --><input id="inv_no" style="width:150px;" class="input" name="inv_no" maxlength="50" dataformat="engup" type="text" /><!-- 
	          --><input id="inv_no" style="width:150px;" class="input" name="inv_no" maxlength="50" dataformat="engup" type="text" /><!-- 
	          --><input id="inv_no" style="width:150px;" class="input" name="inv_no" maxlength="50" dataformat="engup" type="text" /></td>
	       </tr>
		</table>
		 <table>
		 <colgroup>
				<col width="80"/>
				<col width="490"/>
				<col width="80"/>
				<col width="*" />				
			</colgroup>
            <tr>
              <th>Invoice Date</th>
              <td ><input id="inv_dt_fm" style="width:80px;" class="input" name="inv_dt_fm" dataformat="ymd" type="text" /><button class="calendar ir" name="btns_calendar_fm" id="btns_calendar_fm" type="button"></button><span class="dash">~</span><input id="inv_dt_to" style="width:80px;" class="input" name="inv_dt_to" dataformat="ymd" type="text" /><button class="calendar ir" name="btns_calendar_to" id="btns_calendar_to" type="button"></button></td>
              <th>Offset Amount</th>
              <td><input id="inv_amt" style="text-align:right;width:110px;" readonly="readonly" class="input2" name="inv_amt" type="text" /> </td>
             </tr>
         </table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">

	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="mainTable" name="mainTable">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
	
</div>

</form>
<%@include file="/bizcommon/include/common_opus.jsp"%>
