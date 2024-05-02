<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_1017.jsp
*@FileTitle  : 분실 또는 되찾은 Chassis Status를 Creation 하는 화면
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/10
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event.EesCgm1017Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesCgm1017Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd        = "";
	String form_day         = "";
	Logger log = Logger.getLogger("com.clt.apps.ChassisMgsetMgt.ChassisMgsetOnOffhire");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		form_day  = DateTime.getDateString().replace(".","");  

		event = (EesCgm1017Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<head>
<title>Lost/Found Chassis Creation</title>


<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form"  >
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="yd_cd" id="yd_cd" />
<input type="hidden" name="aciac_div_cd" id="aciac_div_cd" />
<input type="hidden" name="loc_cd" id="loc_cd" />
<input type="hidden" name="form_day" value="<%=form_day %>" id="form_day" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_new" 		id="btn_new">New</button>
		<button type="button" class="btn_normal" name="btn_save" 			id="btn_save">Save</button>		
	</div>
	<!-- opus_design_btn(E) -->

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
				<col width="100" />
				<col width="200" />
				<col width="80" />
				<col width="*" />
		   </colgroup> 
		   <tbody>
			   	<tr>
			   		<th>Chassis No.</th>
					<td><input name="eq_no" type="text" dataformat="engup" onkeypress="keychk();" style="width:100px;ime-mode:disabled" class="input1" value="" maxlength="10" id="eq_no" /> </td>
					<th>Office</th>
					<td width=""><input name="ofc_cd" type="text" style="width:60;text-align:center;"class="input2"   readonly="readonly" value="<%=strOfc_cd%>"></td>
			   	</tr>
		   </tbody>
		</table>
		<table class="line_bluedot"><tr><td></td></tr></table>	
		<table>
			<colgroup>
				<col width="100" />
				<col width="200" />
				<col width="80" />
				<col width="100" />
				<col width="80" />
				<col width="*" />
		   </colgroup> 
		   <tbody>
			   	<tr>
			   		<th>Type/Size</th>
					<td><input type="text" name="eq_tpsz_cd" style="width:60px;text-align:center;" class="input2" value="" readonly="readonly" id="eq_tpsz_cd" /></td>
					<th>Lease Term</th>
					<td><input type="text" name="agmt_lstm_cd" style="width:60px;text-align:center;" class="input2" value="" readonly="readonly" id="agmt_lstm_cd" /></td>
					<th>Lessor</th>
					<td><input type="text" style="width:60px;text-align:center;" name="vndr_seq" class="input2" value="" readonly="readonly" id="vndr_seq" /><input type="text" style="width:250px;" name="vndr_lgl_eng_nm" class="input2" value="" readonly="readonly" id="vndr_lgl_eng_nm" /></td>
			   	</tr>
		   </tbody>
		</table>
		<table>
			<colgroup>
				<col width="100" />
				<col width="200" />
				<col width="120" />
				<col width="*" />
		   </colgroup> 
		   <tbody>
			   	<tr>
			   		<th>Current Status</th>
					<td><input type="text" name="eq_aset_sts_cd" style="width:60px;text-align:center;" class="input2" value="" readonly="readonly" id="eq_aset_sts_cd" /><input type="text" name="sts_evnt_dt" style="width:120px;text-align:center;;text-align:center;" class="input2" readonly="readonly" size="10" id="sts_evnt_dt" /></td>
					<th>Current Movement Status</th>
					<td><input type="text" name="chss_mvmt_sts_cd" style="width:40px;text-align:center;;text-align:center;" class="input2" value="" readonly="readonly" id="chss_mvmt_sts_cd" /><input type="text" name="mvmt_dt" style="width:120px;text-align:center;;text-align:center;" class="input2" readonly="readonly" size="10" id="mvmt_dt" /></td>
			   	</tr>
		   </tbody>
		</table>
		<table class="line_bluedot"><tr><td></td></tr></table>	
		<table>
			<colgroup>
				<col width="60" />
				<col width="80" />
				<col width="150" />
				<col width="80" />
				<col width="120" />
				<col width="*" />
		   </colgroup> 
		   <tbody>
			   	<tr class="sm">
					<td><input type="radio" value="L" name="yardChk" onclick="javascript:yard_Chk()" disabled class="trans" readonly="readonly" checked id="yardChk" /> <strong>Lost</strong></td>
					<td>Lost Date</td>
					<td><input type="text" name="l_evnt_dt" maxlength="10" style="width:80px;text-align:center;ime-mode:disabled" dataformat="ymd" class="input1" id="l_evnt_dt" /><button type="button" id="btns_Calendar1" name="btns_Calendar1" class="calendar ir"></button><input type="text" style="width:60px;text-align:center;ime-mode:disabled" class="input1" dataformat="hm" name="l_evnt_dt_hm" maxlength="4" id="l_evnt_dt_hm" /></td>
					<td>Lost Yard</td>
					<td><input type="text" dataformat="engup" maxlength="7" style="width:75px;text-align:center;ime-mode:disabled" class="input1" readonly="readonly" name="l_evnt_yd_cd" value="" id="l_evnt_yd_cd" /><button type="button" id="ComOpenPopupWithTargetYard1" name="ComOpenPopupWithTargetYard1" class="input_seach_btn"></button></td>
					<td></td>
				</tr>
				<tr class="sm">
					<td><input type="radio" value="F" class="trans" onclick="javascript:yard_Chk()" disabled name="yardChk" id="yardChk" /> <strong>Found</strong></td>
					<td>Found Date</td>
					<td><input type="text" style="width:80px;text-align:center;ime-mode:disabled" dataformat="ymd" maxlength="10" name="f_evnt_dt" class="input1" value="" id="f_evnt_dt" /><button type="button" id="btns_Calendar2" name="btns_Calendar2" class="calendar ir"></button><input type="text" style="width:60px;text-align:center;ime-mode:disabled" class="input1" dataformat="hm" name="f_evnt_dt_hm" maxlength="4" id="f_evnt_dt_hm" /></td>
					<td>Found Yard</td>
					<td><input type="text" dataformat="engup" maxlength="7" style="width:75px;text-align:center;ime-mode:disabled" class="input1" value="" readonly="readonly" name="f_evnt_yd_cd" id="f_evnt_yd_cd" /><button type="button" id="ComOpenPopupWithTargetYard2" name="ComOpenPopupWithTargetYard2" class="input_seach_btn"></button></td>
					<td></td>
				</tr>
		   </tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="tabLayer" name="tabLayer" style="dislay:none">
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
</div>


</form>