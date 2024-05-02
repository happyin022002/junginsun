<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAR_1009.jsp
*@FileTitle  : Payment Request Letter History
*@author     : CLT
*@version    : 1.0
*@since      : 2014/11/19
=========================================================
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.event.StmSar1009Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.StringUtil" %>

<%
	StmSar1009Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			// Errors from server.
	String strErrMsg = "";						// Error message.

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String loginOfcCd = "";
	Logger log = Logger.getLogger("com.clt.apps.opus.stm.sar.accountreceivableoutstanding.AccountReceivableOutstandingSC");

	String cust_cnt_cd = StringUtil.xssFilter(request.getParameter("cust_cnt_cd"));
	if(cust_cnt_cd == null){
		cust_cnt_cd = "";
	}
	
	String cust_seq = StringUtil.xssFilter(request.getParameter("cust_seq"));
	if(cust_seq == null){
		cust_seq = "";
	}
	
	String r_type = StringUtil.xssFilter(request.getParameter("r_type"));
	if(r_type == null){
		r_type = "O";
	}
	
	String ar_ofc_cd = StringUtil.xssFilter(request.getParameter("ar_ofc_cd"));
	if(ar_ofc_cd == null){
		ar_ofc_cd = "";
	}
	
	String cust_nm = StringUtil.xssFilter(request.getParameter("cust_nm"));
	if(cust_nm == null){
		cust_nm = "";
	}
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		loginOfcCd = account.getOfc_cd();

		event = (StmSar1009Event)request.getAttribute("Event");
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

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- OUTER - POPUP (S)tart -->
<input type="hidden" name="ar_ofc_cd" value="<%=ar_ofc_cd%>" id="ar_ofc_cd" />
<input type="hidden" name="rec_r_type" value="<%=r_type%>" id="rec_r_type" /> 
<input type="hidden" name="cust_cd" id="cust_cd" />

<!-- popup_title_area(S) -->
 <div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Payment Request Letter History</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
			--><!-- <button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button> --><!-- 
			--><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->	
	</div>
	<!-- page_title_area(E) -->
</div>
<!-- popup_title_area(E) -->
<!-- popup_contens_area(S) -->
<div class="layer_popup_contents">
	<div class="wrap_search">
		<!-- inquiry_area(S) -->
		<div class="opus_design_inquiry wFit">   <!-- no TAB  -->
			<table> 
				<colgroup>
					<col width="180" />
					<col width="40" />
					<col width="120" />
					<col width="60" />
					<col width="*" />
				</colgroup>
				<tbody> 
					<tr>
						<td align="center"><input type="radio" name="r_type" id="r_type" value="O" class="trans" checked onclick="change_event_radio1();"><B><label for="r_type_1">Standard</label></B>
		                    <input type="radio" name="r_type" id="r_type" value="C" class="trans" onclick="change_event_radio2();"><B><label for="r_type_2">Ad Hoc</label></B></td>
		               <th>Control Office</th>
		               <td><script type="text/javascript">ComComboObject('agn_ofc_cd', 1, 90, 1, 1);</script></td>
		               <th id="search1">Customer</th>
		               <td id="search2">
		               		<input type="text" style="width:30px;" class="input1" name="cust_cnt_cd" maxlength="2" dataformat="engup" id="cust_cnt_cd" value="<%=cust_cnt_cd%>"/>
		               		<input type="text" style="width:62px;" class="input1" name="cust_seq" maxlength="6" dataformat="num" id="cust_seq" value="<%=cust_seq%>"/>
		               		<button type="button" id="btn_pop_credit_cust" name="btn_pop_credit_cust" class="input_seach_btn"></button> 
		               		<input type="text" style="width:330px;" class="input2" name="cust_nm" readonly="" tabindex="-1" id="cust_nm" value="<%=cust_nm%>"/>
		               		<button type="button" id="btn_pop_cust_cd" name="btn_pop_cust_cd" class="input_seach_btn"></button> 	
		               	</td>
					   <td></td>  
					</tr> 
					<tr >
						<td colspan="5" align="left">&nbsp;&nbsp;&nbsp;<B>Send Date</B>&nbsp;&nbsp;&nbsp;<input name="send_dt_fm" type="text" style="width:80px;" class="input1" value="" dataformat="ymd" maxlength="8" id="send_dt_fm" /><!-- 
		              --><button type="button" id="btnCalduedtFm" name="btnCalduedtFm" class="calendar ir"></button>- <!-- 
		              --><input name="send_dt_to" type="text" style="width:80px;" class="input1" value="" dataformat="ymd" maxlength="8" id="send_dt_to" /><!-- 
		              --><button type="button" id="btnCalduedtTo" name="btnCalduedtTo" class="calendar ir"></button></td>
		                <td></td> 
					</tr>
				</tbody>
			</table>
		</div> 
	</div>
	<!-- inquiry_area(E) -->
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" >
			<script type="text/javascript">ComSheetObject('sheet1');</script>
			<!-- opus_grid_design_btn(E) -->
		</div>
		<!-- opus_design_grid(E) -->
	</div>
	<!-- popup_contens_area(E) -->
</div>
</form>