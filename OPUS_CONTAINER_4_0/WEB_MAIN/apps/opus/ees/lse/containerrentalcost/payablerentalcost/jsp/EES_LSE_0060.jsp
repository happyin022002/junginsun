<%
/*=========================================================

*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
p*@FileName   : EES_LSE_0060.js
*@FileTitle  : EQ Payable Charge Summary 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/20

=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.lse.containerrentalcost.payablerentalcost.event.EesLse0060Event"%>
<%@ page import="com.clt.apps.opus.ees.lse.lsecommon.LSEUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EesLse0060Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.ContainerRentalCost.PayableRentalCost");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesLse0060Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//getting data from server when load the initial screen
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
<script type="text/javascript" src="/opuscntr/rpt/script/common_rd.js"></script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="tysz" id="tysz" />
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!--  
	--><button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--  
	--><button type="button" class="btn_normal" name="btn_New"  	id="btn_New">New</button><!--
	--></div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<div class="wrap_search">
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="90">
				<col width="485">
				<col width="100">
				<col width="*">
			</colgroup>
			<tr>
				<th>Kind of Report</th>
				<td><select style="width:178px;" name="report_type" id="report_type" class="input1"><!--  
				--><option value="rp_0060" selected>By Lessor & TP/SZ</option><!--  
				--><option value="rp_0061" >By TP/SZ & Month</option><!--  
				--><option value="rp_0062" >By Charge Type & TP/SZ</option><!--  
				--><option value="rp_0063" >By Lease Term & Month</option><!--  
				--><option value="rp_0064" >By Lessor & Month</option><!--  
				--><option value="rp_0065" >Summary Payable Charge</option></select></td>
				<th>Period</th>
			   <td id="fixLayer1" style="position:absolute; visibility:hidden;"><!-- 
			   -->
			   <!--  
				--><select style="width:120px;" name="search_tp" class="input1"><!--  
				--><option value="Cost" selected>Cost Month</option><!--  
				<option value="Revenue" >Revenue Month</option>  
				--><option value="Payment" >Payment Month</option></select><!-- 
			    --><input type="text" name="period_stdt" id="period_stdt" style="width:60px;ime-mode:disabled;text-align:center;" value="" class="input1"  maxlength="6" dataformat="ym" ><!--  
			   --><button type="button" class="calendar ir" name="btns_calendar2" id="btns_calendar2"></button>~&nbsp;<!--  
			   --><input type="text" name="period_eddt" id="period_eddt" style="width:60px;ime-mode:disabled;text-align:center" value="" class="input1" maxlength="6" dataformat="ym" ><!--  
			   --><button type="button" class="calendar ir" name="btns_calendar3" id="btns_calendar3"></button><!--  
			   --><input type="hidden" name="temp_text1" id="temp_text1" style="width:0px" value="" ></td>
			   <td id="fixLayer2" style="position:absolute; visibility:hidden;"><input type="text" name="period_year" id="period_year" style="width:40px" value="" class="input1"  maxlength="4" dataformat="yyyy" ><!--  
			   --><button type="button" class="calendar ir" name="btns_calendar1" id="btns_calendar1"></button><!--  
			   --><input type="hidden" name="temp_text2" id="temp_text2" style="width:0px;" value="" ></td>
			</tr>
			<tr><!-- company -->
				<th>&nbsp;</th>
				<th>&nbsp;</th>
				<th>Payable Amount</th>
				<td><select style="width:120px;" name="payable" class="input"><!--  
				--><option value="T" selected>COM Amount</option><!--  
				-->	<option value="S" >Invoice Amount</option><!--  
				--></select></td>
			</tr>
		</table>
	</div>
	<table class="line_bluedot"><tr><td></td></tr></table>
	<div class="opus_design_inquiry wFit">			
		<table>
			<colgroup>
				<col width="90">
				<col width="485">
				<col width="100">			
				<col width="*">
			</colgroup>
			<tr>
			    <th>AGMT No.</th>
			    <td><input type="text" style="width:74px;text-align:center" name="agmt_cty_cd" class="input2" value="HHO" maxlength="3" readonly="" id="agmt_cty_cd" /><!--  
			    --><input type="text" style="width:87px;text-align:center" name="agmt_seq" class="input" value="" maxlength="6" dataformat="num" id="agmt_seq" /><!--  
			    --><button type="button" id="btns_search3" name="btns_search3" class="input_seach_btn"></button><!--  
			    --><input type="text" name="contract_no" style="width:243px;" class="input2" readonly="" id="contract_no" /></td>
			    <th>Lease Term</th>
			    <td><script type="text/javascript" >ComComboObject('combo1', 1, 185, 1 );</script><input type="hidden" name="lstm_cd" value="" id="lstm_cd" /></td>
			</tr>	
			<tr>
			    <th>Lessor</th>
			    <td><input type="text" style="width:74px;text-align:center" name="vndr_seq" value="" class="input" dataformat="num" maxlength="6" id="vndr_seq" /><!--  
			    --><button type="button" id="btns_search2" name="btns_search2" class="input_seach_btn"></button><!--  
			    --><input type="text" name="abbr_nm" style="width:58px;" class="input2" readonly="" id="abbr_nm" /><!--  
			    --><input type="text" name="vndr_nm" style="width:271px;" class="input2" readonly="" id="vndr_nm" /></td>
			    <th>TP/SZ</th>
			    <td><script type="text/javascript" >ComComboObject('combo2', 1, 185, 1 );</script><input type="hidden" name="cntr_tpsz_cd" value="" id="cntr_tpsz_cd" />
			    </td>
			</tr>					
			<tr>
			    <th>Location</th>
			    <td><select name="loc_tp" dataformat="engup"><!--  
			    --><option value="" selected>ALL</option><!--  
			    --><option value="R">RCC</option><!--  
			    --><option value="L">LCC</option><!--  
			    --><option value="S">SCC</option><!--  
			    --><option value="C">Country</option></select><!--  
			    --><input type="text" style="width:87px;text-align:center" name="loc_cd" value="" class="input" dataformat="engup" maxlength="5" fullfill="" id="loc_cd" /><!--  
			    --><button type="button" id="btns_search1" name="btns_search1" class="input_seach_btn"></button>	
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style="font-weight:bold">Lease Payment Type&nbsp;<script type="text/javascript" >ComComboObject('lse_pay_tp_cd', 2, 74, 1 );</script><input type="hidden" name="lse_pay_tp_cd" value="" id="lse_pay_tp_cd" /></span></td>
                <th>Charge Type</th>
			    <td><script type="text/javascript" >ComComboObject('combo3', 1, 185, 1 );</script><input type="hidden" name="charge_type_cd" value="" id="charge_type_cd" /></td>
			</tr>			
		</table>
	</div>
</div>
<div class="wrap_result bg">
	<div class="opus_design_grid" id="mainTable">
		<div class="opus_design_btn"><!--  
		--><button type="button" class="btn_accent" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button><!--  
		--><button type="button" class="btn_normal" name="btn_print"  	id="btn_print">Print</button><!--
		--></div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
</form>