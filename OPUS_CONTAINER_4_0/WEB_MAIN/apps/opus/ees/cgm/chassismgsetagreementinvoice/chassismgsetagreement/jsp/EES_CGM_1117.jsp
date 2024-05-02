<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_1117.jsp
*@FileTitle  : Agreement No. Selection(Popup)
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
<%@ page import="com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.event.EesCgm1117Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@page import="com.clt.framework.component.util.io.HttpUtil"%>
<%
	EesCgm1117Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.ChassisMgsetAgreementInvoice.ChassisMgsetAgreement");
	String xml = HttpUtil.makeXML(request,response);
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesCgm1117Event)request.getAttribute("Event");
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
<input type="hidden" name="eq_knd_cd" value="" id="eq_knd_cd" />
<div class="layer_popup_contents">
	<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title"><span>Agreement No. Selection</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_Retrieve" 	id="btn_Retrieve">Retrieve</button><!--
			--><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button><!--
			--><button type="button" class="btn_normal" name="btn_OK" id="btn_OK">Ok</button><!--
			--><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button><!-- 
		--></div>
		<!-- opus_design_btn(E) -->
		<!-- page_location(S) -->
		<div class="location">
			<span id="navigation"></span>
		</div>
		<!-- page_location(E) -->
	</div>
	<!-- page_title_area(E) -->
	</div>
	
	<div class= "wrap_search">
		<div class= "opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="100" />
					<col width="150" />
					<col width="50" />
					<col width="155" />
					<col width="66" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<th>Agreement No.</th>
						<td><input type="text" name="agmt_ofc_cty_cd" dataformat="engup" maxlength="3" style="width:50px;ime-mode:disabled" class="input" value="" id="agmt_ofc_cty_cd" /><input type="text" name="agmt_seq" dataformat="num" maxlength="6" style="width:70px;ime-mode:disabled" class="input" value="" id="agmt_seq" /></td>
						<th>Office</th>
						<td><input type="text" name="agmt_iss_ofc_cd" dataformat="engup" maxlength="6" style="width:60px;text-align:center;ime-mode:disabled" class="input" value="" id="agmt_iss_ofc_cd" /><button type="button" id="ComOpenPopupWithTarget1" name="ComOpenPopupWithTarget1" class="input_seach_btn"></button></td>
						<th>Lease Term</th>
						<td width=""><script type="text/javascript">ComComboObject('agmt_lstm_cd', 1, 50, 0, 0, 0, false);</script></td>
						<th>Old AGMT No.</th>
						<td><input type="text" name="old_agmt_no" id="old_agmt_no"  style="width:75px;" value = "" dataformat="engup" otherchar="_-"></td>
					</tr> 
					<tr>
						<th>Reference No.</th>
						<td><input type="text" name="agmt_ref_no" dataformat="engup" maxlength="15" style="width:124px;ime-mode:disabled" class="input" value="" id="agmt_ref_no" /></td>
						<th>Lessor</th>
						<td colspan="3"><input type="text" name="vndr_seq" dataformat="num" style="width:60px;text-align:center;ime-mode:disabled" class="input" value="" id="vndr_seq" /><input type="text" name="vndr_lgl_eng_nm" style="width:220px;" class="input2" value="" readonly id="vndr_lgl_eng_nm" /><button type="button" id="ComOpenPopupWithTarget2" name="ComOpenPopupWithTarget2" class="input_seach_btn"></button></td>
					</tr> 
				</tbody>
			</table>
			
		</div>
	</div>		
	<!-- opus_design_grid(S) -->	
	<div class="wrap_result">
		<div class="opus_design_grid clear" id="mainTable" >
				<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
</div>
			
</form>
<%@include file="/bizcommon/include/common_opus.jsp"%>