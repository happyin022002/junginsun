<%
/*=========================================================

*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ees_lse_0004.jsp
*@FileTitle  : Agreement List
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
<%@ page import="com.clt.apps.opus.ees.lse.containerleaseagreementregistration.agreementregistration.event.EesLse0004Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EesLse0004Event event           = null;		//PDTO(Data Transfer Object including Parameters)
	Exception       serverException = null;		//error from server
	String          strErrMsg       = "";		//error message

	String successFlag = "";
	String codeList    = "";
	String pageRows    = "100";

	String strUsr_id     = "";
	String strUsr_nm     = "";
	String strCntrTpSzCd = "";
	String strCurYear    = "";
	String strCurMonth   = "";
	String strCurDay	 = "";
	Logger log = Logger.getLogger("com.clt.apps.containerleasemgt.leaseplan");

	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		strCurYear  = ""+DateTime.getYear();
		strCurMonth = ""+DateTime.getMonth(); //JSPUtil.getLPAD(""+DateTime.getMonth(), 2, "0");
		strCurDay   = ""+DateTime.getDay();

		event           = (EesLse0004Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		strCntrTpSzCd = (String)eventResponse.getCustomData("cntr_tpsz_cd");
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
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

<input type="hidden" name="org_cntr_tpsz_cd" value="<%= strCntrTpSzCd %>" id="org_cntr_tpsz_cd" />
<input type="hidden" name="cur_year" value="<%= strCurYear %>" id="cur_year" />
<input type="hidden" name="cur_month" value="<%= strCurMonth %>" id="cur_month" />
<input type="hidden" name="cur_day" value="<%= strCurDay %>" id="cur_day" />
<input type="hidden" name="all_lstm_cd" value="" id="all_lstm_cd" />
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
				<col width="100">
				<col width="300">
				<col width="50">
				<col width="*">
			</colgroup>
			<tr>
				<th>Expired Date</th>
				<td><!--  
				--><input type="text" name="exp_from_dt" caption="From Expired Date" style="width:75px;text-align:center;" class="input1" value="" dataformat="ymd" cofield="exp_to_dt" required="" id="exp_from_dt" /> ~ <!--  
				--><input type="text" name="exp_to_dt" caption="To Expired Date" style="width:75px;text-align:center;" class="input1" value="" dataformat="ymd" cofield="exp_from_dt" required="" id="exp_to_dt" /><!--  
				--><button type="button" id="btns_calendar1" name="btns_calendar1" class="calendar ir"></button></td>
				<th>Lessor</th>
				<td><!--  
				--><input type="text" name="vndr_seq" caption="Lessor" style="width:55px;text-align:center;" class="input" value="" dataformat="num" maxlength="6" id="vndr_seq" /><!--  
				--><button type="button" id="btns_search" name="btns_search" class="input_seach_btn"></button><!--  
				--><input type="text" name="vndr_nm" caption="Lessor" style="width:200px;" class="input2" value="" readonly="" id="vndr_nm" />
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style="font-weight:bold">Lease Payment Type&nbsp;<script type="text/javascript" >ComComboObject('lse_pay_tp_cd', 2, 70, 1 );</script><input type="hidden" name="lse_pay_tp_cd" value="" id="lse_pay_tp_cd" /></span></td>
				</td>
			</tr>
			<tr>
				<th>Lease Term</th>
				<td><script type="text/javascript">ComComboObject('lstm_cd', 1, 200, 0, 1);</script></td>
				<th>Office</th>
				<td><!--  
				--><input type="text" name="ofc_cd" caption="Office" style="width:55px;text-align:center;" class="input" value="" dataformat="engup" maxlength="5" id="ofc_cd" /><!--  
				--><button type="button" id="btns_search1" name="btns_search1" class="input_seach_btn"></button></tr>
		</table>
	</div>
</div>
<div class="wrap_result">
	<div class="opus_design_grid">
		<div class="opus_design_btn"><!--  
		--><button type="button" class="btn_accent" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button><!--  
	--></div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div> 
</div>
</form>