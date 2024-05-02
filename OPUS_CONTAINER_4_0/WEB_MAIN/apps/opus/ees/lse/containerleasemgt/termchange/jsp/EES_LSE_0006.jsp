<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_LSE_0006.js
*@FileTitle  : Term Change Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/16
=========================================================*/
%>


<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.lse.containerleasemgt.termchange.event.EesLse0006Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesLse0006Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	Logger log = Logger.getLogger("com.clt.apps.opus.ees.lse.containerleasemgt.termchange");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();


		event = (EesLse0006Event)request.getAttribute("Event");
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

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="pagerows" id="pagerows" />
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!--  
	--><button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--  
	--><button type="button" class="btn_normal" name="btn_new"  	id="btn_new">New</button><!--  
	--><button type="button" class="btn_normal" name="btn_downexcel" 	id="btn_downexcel">Down Excel</button><!--  
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
			<colgroup id="view1"  style="display: ;">
				<col width="40">
				<col width="60">
				<col width="80">
				<col width="60">
				<col width="40">
				<col width="60">
				<col width="80">
				<col width="40">
				<col width="90">
				<col width="*">
			</colgroup>
			<colgroup id="view2"  style="display: none;">
				<col width="40">
				<col width="60">
				<col width="80">
				<col width="40">
				<col width="90">
				<col width="*">
			</colgroup>
			<tr>
				<th class="sm">Status</th>
				<td class="sm"><input type="radio" name="sts_flag" value="B" class="trans" id="sts_flag" />Before</td>
				<td class="sm"><input type="radio" name="sts_flag" value="A" class="trans" checked id="sts_flag" />After</td>
				<td>&nbsp;</td>
				<td>
				<select name="dcond_tp" style="margin-right:1px" >
					<option value="01" selected>AGMT No.</option>
					<option value="02">Lessor</option>
				</select></td>
				<td class="div_dcond1"><input type="text" name="agmt_cty_cd" caption="AGMT No." style="width:40px;text-align:center;" class="input2" value="HHO" readonly id="agmt_cty_cd" /><input type="text" caption="Current AGMT No." name="agmt_seq1" style="width:55px;ime-mode:disabled;text-align:right;" class="input1" value="" maxlength="6" dataformat="num" id="agmt_seq1" /><button type="button" id="btns_search" name="btns_search" class="input_seach_btn"></button></td>
				<th class="div_dcond1">Term</th>
				<td class="div_dcond1"><input type="text" name="lstm_cd1" caption="Lease Term" style="width:35px;text-align:center;" class="input2" value="" readonly id="lstm_cd1" /></td>
				<th class="div_dcond1">Lessor</th>
				<td class="div_dcond1"><input type="text" name="vndr_seq1" caption="Lessor" style="width:50px;text-align:center;" class="input2" value="" readonly id="vndr_seq1" /><input type="text" name="vndr_nm1" caption="Lessor" style="width:290px;" class="input2" value="" readonly id="vndr_nm1" /></td>
				<td class="div_dcond2" style="display: none;"><input type="text" name="vndr_seq2" caption="Lessor" style="width:50px;text-align:center;ime-mode:disabled;" class="input1" value="" maxlength="6" dataformat="num" id="vndr_seq2" />  <button type="button" id="btns_search2" name="btns_search2" class="input_seach_btn"></button><input type="text" name="vndr_nm2" caption="Lessor" style="width:320px;" class="input2" value="" readonly id="vndr_nm2" /> </td>
			</tr>
		</table>
	</div>
</div>
<div class="wrap_result">
	<div class="opus_design_grid" id="mainTable">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<div class="opus_design_grid" id="mainTable" style="display: none">
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
</div>

</form>