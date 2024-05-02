<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_2035.jsp
*@FileTitle  : Payable Invoice Creation
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
<%@ page import="com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event.EesCgm2035Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.io.HttpUtil"%>

<%
	EesCgm2035Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String ofc_cd  			= "";
	Logger log = Logger.getLogger("com.clt.apps.ChassisMgsetAgreementInvoice.ChassisMgsetInvoice");
	String xml = HttpUtil.makeXML(request,response);

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		ofc_cd = account.getOfc_cd();

		event = (EesCgm2035Event)request.getAttribute("Event");
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
		document.form.ofc_cd.value = "<%=ofc_cd%>";
		loadPage();
	}
</script>

<form name="form2">
<input type="hidden" name="sXml" value="<%=xml.replace(" \"","'") %>" id="sXml" />
</form>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="eq_knd_cd" value="G" id="eq_knd_cd" />
<input type="hidden" name="ofc_cd" id="ofc_cd" />
<input type="hidden" name="intg_cd_id" id="intg_cd_id" />

<input type="hidden" name="pay_inv_seq" id="pay_inv_seq" />
<input type="hidden" name="local_date" id="local_date" />
<input type="hidden" name="chss_mgst_inv_knd_cd" value="LS" id="chss_mgst_inv_knd_cd" />
<input type="hidden" name="inv_eff_dt" id="inv_eff_dt" />
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!--  
	--><button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--  
	--><button type="button" class="btn_normal" name="btn_New"  	id="btn_New">New</button><!--  
	--><button type="button" class="btn_normal" name="btn_Save" 	id="btn_Save">Invoice Confirm</button><!--  
	--><button type="button" class="btn_normal" name="btn_Cancel" 	id="btn_Cancel">Cancel</button><!--  
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
				<col width="40px">
				<col width="120px">
				<col width="40px">
				<col width="120px">
				<col width="40px">
				<col width="120px">
				<col width="70px">
				<col width="*">
			</colgroup> 
			<tr>
				<th>Cost Office</th>
				<td><input type="text" name="cost_ofc_cd" dataformat="engup" maxlength="6" style="width:60px;ime-mode:disabled;text-align:center" class="input1" value="" id="cost_ofc_cd" /><!--  
				--><button type="button" id="btns_office" name="btns_office" class="input_seach_btn"></button></td>
				<th>Cost Month</th>
				<td><input type="text" name="cost_yrmon" dataformat="ym" maxlength="7" style="width:60px;ime-mode:disabled;text-align:center" class="input1" value="" id="cost_yrmon" /><!--  
				--><button type="button" id="btns_cost_yrmon" name="btns_cost_yrmon" class="calendar ir"></button></td>
				<th>S. Provider</th>
				<td><script type="text/javascript">ComComboObject('vndr_seq', 1, 300, 0, 0, 0, false);</script></td>
				<th>Option</th>
				<td><script type="text/javascript">ComComboObject('chss_mgst_inv_sts_cd', 1, 95, 0, 0, 0, false);</script></td>
			</tr> 
		</table>	
	</div>
</div>
<div class="wrap_result">
	<div class="opus_design_inquiry">
		<table>
			<colgroup>
				<col width="60px">
				<col width="*">
			</colgroup>
			<tr>
				<th class="title_design">Main</th>
				<td>&nbsp;</td>
			</tr>
		</table>
	</div>
	<div class="opus_design_grid" id="mainTable">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<div class="opus_design_inquiry">
		<table>
			<colgroup>
				<col width="60px">
				<col width="*">
			</colgroup>
			<tr>
				<th class="title_design">Detail</th>
				<td>&nbsp;</td>
			</tr>
		</table>
	</div>
	<div class="opus_design_grid" id="mainTable">
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
	<div class="opus_design_data">
		<table>
			<colgroup>
				<col width="80px">
				<col width="130px">
				<col width="80px">
				<col width="130px">
				<col width="80px">
				<col width="*">
			</colgroup>
			<tr>
				<th>Issue Date</th>
				<td><input type="text" name="inv_iss_dt" dataformat="ymd" maxlength="10" style="width:80px;ime-mode:disabled" class="input1" value="" id="inv_iss_dt" /><!--  
				--><button type="button" id="btns_inv_iss_dt" name="btns_inv_iss_dt" class="calendar ir"></button></td>
				<th>RCV Date</th>
				<td><input type="text" name="inv_rcv_dt" dataformat="ymd" maxlength="10" style="width:80px;ime-mode:disabled" class="input1" value="" id="inv_rcv_dt" /><!--  
				--><button type="button" id="btns_inv_rcv_dt" name="btns_inv_rcv_dt" class="calendar ir"></button></td>
				<th>Pay Term</th>
				<td><input name="gen_pay_term_cd" type="text" readonly style="width:80px;" class="input2" value="" id="gen_pay_term_cd" /></td>
			</tr> 
		</table>
	</div>
	<div class="opus_design_grid" style="display: none">
		<script type="text/javascript">ComSheetObject('sheet3');</script>
	</div>
</div>
</form>