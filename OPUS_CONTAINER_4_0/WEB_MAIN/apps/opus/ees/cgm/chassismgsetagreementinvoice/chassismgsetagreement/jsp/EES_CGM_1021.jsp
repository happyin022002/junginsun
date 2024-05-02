<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_1021.jsp
*@FileTitle  : Lease Agreement List Inquiry
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
<%@ page import="com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.event.EesCgm1021Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@page import="com.clt.framework.component.util.io.HttpUtil"%>
<%
	EesCgm1021Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id   = "";
	String strUsr_nm   = "";
	String strOfc_id   = "";

	Logger log = Logger.getLogger("com.clt.apps.ChassisMgsetAgreementInvoice.ChassisMgsetAgreement");
	String xml = HttpUtil.makeXML(request,response);
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_id = account.getOfc_cd();

		event = (EesCgm1021Event)request.getAttribute("Event");
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

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form2">
<input type="hidden" name="sXml" value="<%=xml.replace(" \"","'") %>" id="sXml" />
</form>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<!--  Office Code Validation 체크를 위한 정의 -->
<input type="hidden" name="ofc_cd" value="" id="ofc_cd" />
<!-- Form Hidden -->
<input type="hidden" name="intg_cd_id" value="" id="intg_cd_id" />
<input type="hidden" name="eq_knd_cd" value="Z" id="eq_knd_cd" />
<input type="hidden" name="eff_flag" value="" id="eff_flag" />
<input type="hidden" name="agmt_no" value="" id="agmt_no" />
<input type="hidden" name="s_usr_id" value="<%=strUsr_id %>" id="s_usr_id" />
<input type="hidden" name="s_ofc_id" value="<%=strOfc_id %>" id="s_ofc_id" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_New" id="btn_New" type="button">New</button><!--
		--><button class="btn_normal" name="btn_VersionDetails" id="btn_VersionDetails" type="button">Version&nbsp;Details</button><!--
		--><button class="btn_normal" name="btn_DownExcel" id="btn_DownExcel" type="button">Down&nbsp;Excel</button><!--
		--><button class="btn_normal" name="btn_Print" id="btn_Print" type="button">Print</button><!--
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
				<col width="75"/>
				<col width="60"/>
				<col width="35"/>
				<col width="60"/>
				<col width="100"/>
				<col width="150"/>
				<col width="*"/>							
		   	</colgroup> 
			<tr>
				<th>Office</th>
				<td><input type="text" name="agmt_iss_ofc_cd" dataformat="engup" maxlength="6" style="width:78px;text-align:center;ime-mode:disabled" class="input" value="" id="agmt_iss_ofc_cd" /><button type="button" id="ComOpenPopupWithTarget1" name="ComOpenPopupWithTarget1" class="input_seach_btn"></button></td>
				<td></td>
				<th class="sm">Effective</th>
				<td class="sm"><input name="eff_flag_yes" id="eff_flag_yes" type="radio" value="" class="trans" /><!--
					--><label for="eff_flag_yes">Yes</label><!--
					--><input name="eff_flag_no" type="radio" value="" class="trans" id="eff_flag_no" /><!-- 
					--><label for="eff_flag_no">No</label><!--
					--><input name="eff_flag_all" type="radio" value="" class="trans" checked="" id="eff_flag_all" /><!--
					--><label for="eff_flag_all">All</label></td>
				<th>Agreement Date</th>
				<td><input name="agmt_dt_fr" type="text" dataformat="ymd" maxlength="10" style="width:78px;text-align:center;ime-mode:disabled" class="input" value="" id="agmt_dt_fr" />~&nbsp;<input type="text" name="agmt_dt_to" dataformat="ymd" maxlength="10" style="width:78px;text-align:center;ime-mode:disabled" class="input" value="" id="agmt_dt_to" /><button type="button" id="btns_Calendar" name="btns_Calendar" class="calendar ir"></button></td>
			</tr>
		</table>
		<table>
			<colgroup>
				<col width="75"/>
				<col width="100"/>
				<col width="92"/>
				<col width="*"/>							
		   	</colgroup> 
			<tr>
				<th>Lease Term</th>
				<td><script type="text/javascript">ComComboObject('agmt_lstm_cd', 1, 78, 0, 0, 0, false);</script></td>
				<th>Lessor</th> 
				<td><input type="text" name="vndr_seq" dataformat="num" style="width:105px;ime-mode:disabled" class="input" value="" id="vndr_seq" /><input type="text" name="vndr_lgl_eng_nm" style="width:365px;ime-mode:disabled" class="input2" value="" readonly id="vndr_lgl_eng_nm" /><button type="button" id="ComOpenPopupWithTarget2" name="ComOpenPopupWithTarget2" class="multiple_inq ir"></button></td>
			</tr>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">		
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>