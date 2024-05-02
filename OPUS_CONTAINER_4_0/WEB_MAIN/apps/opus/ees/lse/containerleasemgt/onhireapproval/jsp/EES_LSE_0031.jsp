<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ees_lse_0031.jsp
*@FileTitle  : On Hire Approval inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/18
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.lse.containerleasemgt.onhireapproval.event.EesLse0031Event"%>
<%@ page import="com.clt.apps.opus.ees.lse.lsecommon.LseCommonSC"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesLse0031Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc       = "";
	Logger log = Logger.getLogger("com.clt.apps.ContainerLeaseMgt.OnhireApproval");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc= account.getOfc_cd();


		event = (EesLse0031Event)request.getAttribute("Event");
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
//var arrTpSz=new Array("d2","d4","d5","d7","r2","r5","r9","o2","s2","o4","o5","s4","f2","f4","a4","f5","r7","p2","p4","t2","t4","d3","dx","r4","d9","r8","c4","c2","a2");
<%=LseCommonSC.getTpSz()%>
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
<input type="hidden" name="tysz" id="tysz">
<input type="hidden" name="usr_ofc_cd"  value="<%=strUsr_ofc%>" id="usr_ofc_cd"  >
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!--  
	--><button type="button" class="btn_accent" name="Retrieve" id="Retrieve">Retrieve</button><!--  
	--><button type="button" class="btn_normal" name="btn_New"  	id="btn_New">New</button><!--  
	--></div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<div class="wrap_search bg">
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="30">
				<col width="50">
				<col width="100">
				<col width="120">
				<col width="140">
				<col width="60">
				<col width="120">
				<col width="50">
				<col width="140">
				<col width="*">
			</colgroup>
			<tr>
				<th>Type</th>
				<td class="sm pad_left_4"><input type="radio" name="type_chk" value="O" class="trans" checked id="type_chk" />On-Hire&nbsp;&nbsp;<input type="radio" name="type_chk" value="L" class="trans" id="type_chk" />Lease Out</td>
				<th>LOC</th>
				<td><input type="text" name="loc_cd" id="loc_cd" style="width:105px;ime-mode:disabled"  value="" class="input" dataformat="engup" maxlength="5" fullfill><!--
				--><input type="hidden" name="loc_tp" id="loc_tp" value="LOC" class="trans"><!--
				--><button type="button" name="btns_search1" id="btns_search1" class="input_seach_btn"></button></td>
				<th>Lease Term</th>
				<td><script type="text/javascript" >ComComboObject('lstm_cd', 1, 100, 1 ,0);</script></td>
				<!--<th>Period</th>
				<td><input type="text" name="period_stdt" id="period_stdt" style="width:60px;ime-mode:disabled" value="" class="input"  maxlength="6" dataformat="ym" >
				<button type="button" class="calendar ir" name="btns_calendar1" id="btns_calendar1"></button>&nbsp;~&nbsp;
				<input type="text" name="period_eddt" id="period_eddt" style="width:60px;ime-mode:disabled" value="" class="input" maxlength="6" dataformat="ym" >
				<button type="button" class="calendar ir" name="btns_calendar2" id="btns_calendar2"></button></td> -->
			    <th>Auth No.</th>
				<td><input type="text" caption="Auth No." name="cntr_onh_auth_no" id="cntr_onh_auth_no" style="width:190px;" class="input" value="" maxlength="20"><input type="hidden" name="cntr_onh_auth" id="cntr_onh_auth" maxlength="15" style="width:0" value="" class="input1" ></td>
			</tr>
			 <tr>
				<th></th>
				<td></td>
				<th>AGMT No.</th>
				<td><input type="text" name="agmt_cty_cd" caption="AGMT No." style="width:40px;text-align:center;" class="input" value="HHO" readonly id="agmt_cty_cd" /><input type="text" caption="AGMT No." name="agmt_seq" style="width:60px;text-align:right;" class="input" value="" maxlength="6" dataformat="num" id="agmt_seq" /><button type="button" id="btns_search2" name="btns_search2" class="input_seach_btn"></button></td>
				<th>TP/SZ</th>
				<td><script type="text/javascript" >ComComboObject('tpsz_cd', 1, 100, 1 , 0 );</script></td>
			    <th>Lessor/Lessee</th>
				<td><!--  
				--><input type="text" name="vndr_seq" caption="Lessor" style="width:55px;text-align:center;" class="input" value="" dataformat="num" maxlength="6" id="vndr_seq" /><!--  
				--><button type="button" id="btns_search" name="btns_search" class="input_seach_btn"></button><!--  
				--><input type="text" name="vndr_nm" caption="Lessor" style="width:150px;" class="input2" value="" readonly="" id="vndr_nm" /></td>
				<th></th>
				<td></td>
			</tr> 
		</table>
	</div>

</div>
<div class="wrap_result">
	<table>
		<colgroup>
			<col width="140">
			<col width="*">
		</colgroup>
		<tr>
			<th class="title_design">Term & Condition</th>
		</tr>
		<tr>
			<th>TP/SZ</th>
                <td><input type="text" name="cntr_tpsz_cd" id="cntr_tpsz_cd" style="width:250px" value="" class="input2" readonly></td>
                <th style="display:none;">Pick Up Period</th>
                <td colspan="2" style="display:none;"><input type="text" name="pkup_fm_dt" caption="Effective Date" style="width:75px;text-align:center;" class="input2" value="" dataformat="ymd" id="pkup_fm_dt" />~&nbsp;
                <input type="text" name="pkup_due_dt" style="width:75px;text-align:center;" class="input2" value="" dataformat="ymd" id="pkup_due_dt" /> 
                </td>
		</tr>
	</table> 
	<div class="opus_design_inquiry wFit">
		<table> 
			<colgroup>
				<col width="40">
				<col width="300">
				<col width="100">
				<col width="80">
				<col width="*">
			</colgroup>
			<tr>
				
			</tr> 
		</table>
	</div>
	<div class="opus_design_grid" id="mainTable">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<div class="opus_design_data">
		<table class="grid_2">
			<colgroup>
				<col width="90">
				<col width="*">
			</colgroup> 
			<tr>
				<th>Remark(s)</th>
				<td><textarea style="width:100%;height:80px;resize:none;" name="apro_rmk" id="apro_rmk"></textarea></td>
			</tr> 
		</table>
	</div>
</div>

</form>