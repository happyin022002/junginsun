<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAR_2002.jsp
*@FileTitle  : Receipt Inquiry(Detail)
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
<%@ page import="com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.event.StmSar2002Event"%> 
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.bizcommon.util.BizComUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.OfficeCodeMgr"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>

<%
	StmSar2002Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	
	int rowCount	 = 0;						//DB ResultSet Count of list
	String pageRows  	    = "1000";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc		= "";
	List<String> rhqOfcList = null;
	Logger log = Logger.getLogger("com.clt.apps.opus.stm.sar.accountreceivablecollect.AccountReceivableCollectSC");

	String sysCurrdate = JSPUtil.getKST("yyyy-MM-dd");
	String sysStartDate = JSPUtil.getKST("yyyy-MM") + "-01";

	String rct_ofc_cd = StringUtil.xssFilter(request.getParameter("rct_ofc_cd"));
	if(rct_ofc_cd == null){
		rct_ofc_cd = "";
	}
	
	String call_yn = StringUtil.xssFilter(request.getParameter("call_yn"));
	if(call_yn == null){
		call_yn = "N";
	}
	
	String rct_no = StringUtil.xssFilter(request.getParameter("rct_no"));
	if(rct_no == null){
		rct_no = "";
	}
	
	String req_rct_dt = StringUtil.xssFilter(request.getParameter("req_rct_dt"));
	if(req_rct_dt == null){
		req_rct_dt = "";
	}

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();

		event = (StmSar2002Event)request.getAttribute("Event");
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

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.lengupth >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows"  id="pagerows" value="<%=pageRows%>">
<input type="hidden" name="iPage"> 
<input type="hidden" name="ofc_cd" value="<%=rct_ofc_cd%>" id="ofc_cd" />
<input type="hidden" name="cust_cnt_cd" id="cust_cnt_cd" />
<input type="hidden" name="cust_seq" id="cust_seq" />
<input type="hidden" name="bank_ctrl_cd" id="bank_ctrl_cd" />
<input type="hidden" name="bank_acct_seq" id="bank_acct_seq" />
<input type="hidden" name="selOfcCds" id="selOfcCds" />
<input type="hidden" name="rct_ofc_cd" id="rct_ofc_cd" />
<input type="hidden" name="rct_dt_fm" value="" id="rct_dt_fm" />
<input type="hidden" name="rct_dt_to" value="" id="rct_dt_to" />
<input type="hidden" name="rct_dps_dt_fm" value="" id="rct_dps_dt_fm" />
<input type="hidden" name="rct_dps_dt_to" value="" id="rct_dps_dt_to" />
<input type="hidden" name="call_yn" value="<%=call_yn%>" id="call_yn" />
<input type="hidden" name="req_rct_dt" value="<%=req_rct_dt%>" id="req_rct_dt" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_new" id="btn_new" type="button">New</button><!--
		--><button class="btn_normal" name="btn_downexcel" id="btn_downexcel" type="button">Down Excel</button><!--
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
	<div class="opus_design_inquiry">
		<table>
			<colgroup>
				<col width="70" />				
				<col width="170" />				
				<col width="70" />				
				<col width="283" />				
				<col width="90" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
		   			<th>Date Type</th>
	                <td><select name="rct_dt_tp_cd" id="rct_dt_tp_cd" class="input1" style="width:100px;" >
	                   	 <option  value="RECEIPT">Receipt </option>
	                   	 <option  value="DEPOSIT">Deposit</option>
	                  </select></td>                  
	
	                <th>Date</th>
	                <td><input type="text" style="width:80px;" class="input1" name="cond_dt_fm" dataformat="ymd" maxlengupth="8" cofield="cond_dt_to" caption="Start Date" id="cond_dt_fm" /><!-- 
	                 --><button type="button" id="btns_calendar3" name="btns_calendar3" class="calendar ir"></button>~&nbsp;<!-- 
	                  --><input type="text" style="width:80px;" class="input1" name="cond_dt_to" dataformat="ymd" maxlengupth="8" cofield="cond_dt_fm" caption="End Date" id="cond_dt_to" /><!-- 
	                   --><button type="button" id="btns_calendar4" name="btns_calendar4" class="calendar ir"></button></td>
	                <th>Office</th>
					<td> 
	                  <input type="text" style="width:100px;" class="input1" name="rct_ofc_cd1" readonly="" tabindex="-1" id="rct_ofc_cd1" /><!-- 
	                   --><button type="button" id="btn_multi_office_popup" name="btn_multi_office_popup" class="input_seach_btn"></button>
	                </td>             
		   		</tr>
		   </tbody>
		</table>
		<div class="line_bluedot"></div>
		<table>
			<colgroup>
				<col width="70" />				
				<col width="190" />				
				<col width="70" />				
				<col width="258" />				
				<col width="90" />
				<col width="180" />				
				<col width="104" />	
				<col width="*" />					
		   </colgroup> 
		   <tbody>
		   		<tr>
		   			<th>Type 1</th>
	                <td><select name="rct_sts_cd" id="rct_sts_cd" class="input" style="width:100px;">
	                    <option value="ALL">All </option>
	                    <option value="RECEIPT">Receipt</option>
	                    <option value="CANCEL">Cancel</option>
	                  </select></td>
	                <th>Type 2</th>
	                <td><select name="rct_unpay_sts_flg" id="rct_unpay_sts_flg" class="input" style="width:160px;">
	                    <option value="ALL">All</option>
	                    <option value="UNAPP">Unapplied/Unidentified</option>
	                  </select></td>
	                <th>Customer</th>
	                <td colspan="3"><input type="text" style="width:30px;" class="input" name="rct_cust_cnt_cd" maxlength="2" dataformat="engup" id="rct_cust_cnt_cd" /><input type="text" style="width:65px;" class="input" name="rct_cust_seq" dataformat="num" maxlength="6"  id="rct_cust_seq" /><!-- 
	                 --><button type="button" id="btns_cust_info" name="btns_cust_info" class="input_seach_btn"></button><!-- 
	                 --><input type="text" style="width:207px;" class="input2" name="cust_nm" id="cust_nm" readonly tabindex="-1"><!--
	                 --><button type="button" id="btns_cust" name="btns_cust" class="input_seach_btn"></button></td>
		   		</tr>
		   		<tr>
		   			<th>Bound</th>
	                <td><select name="io_bnd_cd" id="io_bnd_cd" class="input" style="width:100px;">
	                    <option value="ALL">All </option>
	                    <option value="I">Inbound </option>
	                    <option value="O">Outbound</option>
	                  </select></td>
	                <th>Bank</th>
	                <td><input type="text" style="width:180px;" class="input" name="bank_acct_name" readonly="" tabindex="-1" id="bank_acct_name" /><!-- 
	                	 --><button type="button" id="btns_bank" name="btns_bank" class="input_seach_btn"></button>
	                </td>
	                <th>Cancel Reason</th>
	                <td><script type="text/javascript">ComComboObject('rct_cxl_rsn_cd', 2, 100, 1, 0);</script></td>
	                <th>ASA No</th>
	                <td><input type="text" style="width:120px;" class="input" name="asa_no" value="" dataformat="engup" id="asa_no" /> </td>
	              </tr>
		   		<tr>
		   			<th>B/L No</th>
	                <td><input type="text" style="width:100px;" class="input" name="bl_no" value="" dataformat="engup" id="bl_no" /> </td>
	                <th>Booking No</th>
	                <td><input type="text" style="width:100px;" class="input" name="bkg_no" value="" dataformat="engup" id="bkg_no" /> </td>
	                <th>Invoice No</th>
	                <td><input type="text" style="width:100px;" class="input" name="inv_no" value="" dataformat="engup" id="inv_no" /> </td>
					<th>Receipt Type</th>
	                <td><script type="text/javascript">ComComboObject('rct_tp_cd', 1, 100, 1, 0);</script></td>
		   		</tr>
				<tr>
					<th>Cheque No</th>
	                <td><input type="text" style="width:140px;" class="input" name="chq_no" value="" dataformat="engup" id="chq_no" /> </td>
	                <th>Receipt No</th>
	                <td><input type="text" style="width:150px;" class="input" name="rct_no" value="<%=rct_no%>" dataformat="engup" id="rct_no" /> </td>
	                <th>User ID</th>
	                <td><input type="text" style="width:100px;" class="input" name="usr_id" value="" auth="R" id="usr_id" /><button type="button" id="btns_search_usrid" name="btns_search_usrid" class="input_seach_btn"></button></td>
	              	<th>OTS Office</th>
	                <td><input type="text" style="width:100px;" class="input" name="ots_ofc_cd" value="" dataformat="enguponly" id="ots_ofc_cd" /> </td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" 
		<%if(call_yn.equals("Y")){ 
			out.print("style='height:350px;'"); 
		}%> 
	>
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
</div>

</form>

<%@include file="/bizcommon/include/common_opus.jsp"%>