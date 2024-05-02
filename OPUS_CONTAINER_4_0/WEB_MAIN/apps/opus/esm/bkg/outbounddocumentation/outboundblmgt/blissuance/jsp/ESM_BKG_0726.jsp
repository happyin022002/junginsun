<%
/*=========================================================
* **Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0726.jsp
*@FileTitle  : Group Update for B/L Issue And Onboard Date
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkg0726Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0726Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from the server	
	String strErrMsg = "";						//error messege
	int rowCount	 = 0;						//the number of DB ResultSet List

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_id		= "";
	Logger log = Logger.getLogger("com.clt.apps.OutboundBLMgt.BLIssuance");
	
	String tVvd = "";
	String polCd = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_id = account.getOfc_cd();


		event = (EsmBkg0726Event)request.getAttribute("Event");
		tVvd = event.getTVvd();
		polCd = event.getPolCd();
		
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// extract additional data obtained from the server during Initial loading ..
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

<form name="form" onKeyDown="ComKeyEnter('search')">
<input type="hidden" name="f_cmd" 		id="f_cmd">
<input type="hidden" name="pagerows" 	id="pagerows">
<input type="hidden" name="chkd_iss" 	id="chkd_iss">
<input type="hidden" name="strUsr_id" 	id="strUsr_id" value=<%=strUsr_id%>>
<input type="hidden" name="strOfc_id" 	id="strOfc_id" value=<%=strOfc_id%>>
<!-- BACKEND JOB -->
<input type="hidden" name="backendjob_key" id="backendjob_key">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>

	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	
	<div class="opus_design_btn">
		<button type="button" 		class="btn_accent" name="btn_Retrieve" 		id="btn_Retrieve">Retrieve</button><!-- 
		 --><button type="button" 		class="btn_normal" name="btn_New" 			id="btn_New">New</button><!-- 
		 --><button type="button" 		class="btn_normal" name="btn_Save"  		id="btn_Save">Save</button><!-- 
		 <button type="button" 		class="btn_normal" name="btn_SaveIssue" 	id="btn_SaveIssue">Save & Issue</button>
		 --><button type="button" 		class="btn_normal" name="btn_Issue" 	id="btn_Issue">Issue</button><!-- 
		 --><button type="button" 		class="btn_normal" name="btn_DownExcel" 	id="btn_DownExcel">Down Excel</button><!-- 
		--><button type="button" 		class="btn_normal" name="btn_AdjustDate" 	id="btn_AdjustDate">Adjust Date</button>
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->
<div class="wrap_search">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry">
	<table>
		<tbody>
			<colgroup>
				<col width="70">
				<col width="120">
				<col width="70">
				<col width="120">
				<col width="75">
				<col width="120">
				<col width="90">
				<col width="*">
		    </colgroup>
			<tr>
				<th>1st  VVD</th>
				<td><input type="text" name="vvd" 			id="vvd"  		class="input1" 	style="ime-mode:disabled;width:90px;" maxlength='9' value="<%=tVvd%>" dataformat="engup"></td>
				<th title="Port of Loading">POL</th>
				<td><input type="text" name="pol_cd" 		id="pol_cd" 	class="input1" 	style="ime-mode:disabled;width:50px;" maxlength='5' value="<%=polCd%>" dataformat="engup"></td> 
				<th>ETA</th>
				<td><input type="text" name="act_arr_dt" 	id="act_arr_dt" class="input2" 	style="ime-mode:disabled;width:90px;" readOnly ></td>
				<th>ETD</th>
				<td><input type="text" name="act_dep_dt" 	id="act_dep_dt" class="input2" 	style="ime-mode:disabled;width:90px;" readOnly ></td>
			</tr>
			</tbody>
		</table>
		<table>
		<tbody>
			<colgroup>
				<col width="70">
				<col width="120">
				<col width="70">
				<col width="120">
				<col width="75">
				<col width="120">
				<col width="90">
				<col width="120">
				<col width="50">
				<col width="120">
				<col width="*">
		    </colgroup>
			<tr>
				<th>BKG OFC</th>
				<td><input type="text" name="bkg_ofc_cd" 	id="bkg_ofc_cd" class="input" 	style="ime-mode:disabled;width:90px;" dataformat="enguponly"></td>
				<th>B/L Issue</th>
				<td>
					<select name="obl_iss_flg" id="obl_iss_flg" style="width:50px;">
					<option value="N" selected>N</option>
					<option value="Y">Y</option>
					<option value="A">All</option>
					</select>
				</td> 
				<th>B/L Release</th>
				<td>
					<select name="obl_rlse_flg" id="obl_rlse_flg" style="width:50px;">
					<option value="N" selected>N</option>
					<option value="Y">Y</option>
					<option value="A">All</option>
					</select></td> 
				<th>Shipper Code</th>
				<td><input type="text" name="shipper_cd" 	id="shipper_cd" class="input" 	style="ime-mode:disabled;width:90px;" dataformat="engup" maxlength='8'></td>
				<th>L. REP</th>
				<td><input type="text" name="ob_srep_cd" 	id="ob_srep_cd" class="input" 	style="ime-mode:disabled;width:90px;" dataformat="engup"></td>
				<td></td>
			</tr>
		</tbody>
	</table>
</div>
<!-- opus_design_inquiry(E) -->
</div>
<div class="wrap_result">
<!-- opus_design_grid(S) -->	
<div class="opus_design_grid">
	<script type="text/javascript">ComSheetObject('sheet1');</script>		
</div>
</div>
<!-- opus_design_grid(E) -->

</form>