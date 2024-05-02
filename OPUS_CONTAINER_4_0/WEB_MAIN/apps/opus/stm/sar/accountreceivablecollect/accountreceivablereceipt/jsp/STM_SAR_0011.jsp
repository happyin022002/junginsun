<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : STM_SAR_0011.js
*@FileTitle  : Receipt Deposit Search Popup
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
<%@ page import="com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.event.StmSar0011Event"%>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.OfficeCodeMgr"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>

<%
	StmSar0011Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//DB ResultSet Count of list

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc		= "";
	List<String> rhqOfcList = null;
	Logger log = Logger.getLogger("com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt");
	
	String sysCurrdate = JSPUtil.getKST("yyyy-MM-dd");
	String sysStartDate = JSPUtil.getKST("yyyy-MM") + "-01";
	
	String rct_ofc_cd = StringUtil.xssFilter(request.getParameter("rct_ofc_cd"));
	if(rct_ofc_cd == null){
		rct_ofc_cd = "";
	}
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();
		
		event = (StmSar0011Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// in loading page, Get data from server
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script  type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="cust_cnt_cd" id="cust_cnt_cd" />
<input type="hidden" name="cust_seq" id="cust_seq" />
<input type="hidden" name="rct_curr_cd" id="rct_curr_cd" />
<div class="layer_popup_contents">
	<div class="layer_popup_title">
		<!-- page_title_area(S) -->
		<div class="page_title_area clear">
		   <!-- page_title(S) -->
			<h2 class="page_title"><span>Receipt Deposit Search</span></h2>
			<!-- page_title(E) -->
			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_Retrieve" 	id="btn_Retrieve">Retrieve</button><!--
				--><button type="button" class="btn_normal" name="btn_OK" 		id="btn_OK">Apply</button><!--
				--><button type="button" class="btn_normal" name="btn_Close"  		id="btn_Close">Close</button>	
			</div>
			<!-- opus_design_btn(E) -->
			<!-- page_location(S) -->
			<!-- <div class="location">
				<span id="navigation"></span>
			</div> -->
			<!-- page_location(E) -->
		</div>
		<!-- page_title_area(E) -->
	</div>
	<!-- opus_design_inquiry(S) -->
	<div class= "wrap_search">
		<div class= "opus_design_inquiry wFit">
			<table>
					<colgroup>
						<col width="80"/>
						<col width="290"/>
						<col width="80"/>
						<col width="120"/>
						<col width="130"/>
						<col width="*"/>
				    </colgroup>
				    <tbody>
					<tr>
					  <th>Customer</th>
                      <td colspan="3"><input type="text" style="width:30px;" class="input" name="rct_cust_cnt_cd" maxlength="2" dataformat="engup" id="rct_cust_cnt_cd" /><input type="text" style="width:62px;" class="input" name="rct_cust_seq" maxlength="6" dataformat="num" id="rct_cust_seq" /><button type="button" id="btns_cust" name="btns_cust" class="input_seach_btn"></button><input type="text" style="width:239px;" class="input2" name="cust_nm" readonly tabindex="-1" id="cust_nm" /> </td>
                      <th>Office</th>
                      <td><input type="text" style="width:80px;" class="input2" name="rct_ofc_cd" value="<%=rct_ofc_cd%>" readonly tabindex="-1" id="rct_ofc_cd" /> </td>
					</tr>
					<tr>
					  <th>Receipt Date</th>
                      <td><input type="text" style="width:80px;" class="input" name="rct_from_dt" dataformat="ymd" maxlength="8" cofield="rct_to_dt" caption="start date" id="rct_from_dt" /><button type="button" id="btns_calendar1" name="btns_calendar1" class="calendar ir"></button><span class="dash">~</span><input type="text" style="width:80px;" class="input" name="rct_to_dt" dataformat="ymd" maxlength="8" cofield="rct_from_dt" caption="end date" id="rct_to_dt" /><button type="button" id="btns_calendar2" name="btns_calendar2" class="calendar ir"></button></td>
                      <th>Receipt No</th>
                      <td><input type="text" style="width:150px;" class="input" name="rct_no" dataformat="engup" maxlength="20" id="rct_no" /> </td>
                      <th>Cheque No</th>
                      <td><input type="text" style="width:140px;" class="input" name="chq_no" dataformat="engup" maxlength="17" id="chq_no" /> </td>
					</tr>
					<tr>
					 <th>Receipt Amount</th>
                      <td><input type="text" style="width:120px;text-align:right" class="input" name="rct_from_amt" dataformat="float" maxlength="15" pointcount="3" maxnum="99999999999.999" id="rct_from_amt" />~&nbsp;<!-- 
                       --><input type="text" style="width:120px;text-align:right" class="input" name="rct_to_amt" dataformat="float" maxlength="15" pointcount="3" maxnum="99999999999.999" id="rct_to_amt" /></td>
                      <th>User ID</th>
                      <td><input type="text" style="width:100px;" class="input" name="cre_usr_id" maxlength="20" id="cre_usr_id" /><button type="button" id="btns_user" name="btns_user" class="input_seach_btn"></button></td>
                      <th>Currency</th>
                      <td><script type="text/javascript">ComComboObject('curr_cd', 1, 80, 1, 0);</script></td>
				</tr>		
				</tbody>
			</table>
		</div>
	</div>
	<!-- opus_design_inquiry(E) -->
	<!-- opus_design_grid(S) -->
	<div class="wrap_result">
		<div class="opus_design_grid clear" >
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>
<%@include file="/bizcommon/include/common_opus.jsp"%>