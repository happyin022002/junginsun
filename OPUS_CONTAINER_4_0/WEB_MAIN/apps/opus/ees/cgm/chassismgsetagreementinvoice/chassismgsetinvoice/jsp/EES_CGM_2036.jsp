<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_2036.jsp
*@FileTitle  : Invoice Inquiry
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
<%@ page import="com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event.EesCgm2036Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesCgm2036Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String ofc_cd              = "";

	Logger log = Logger.getLogger("com.clt.apps.ChassisMgsetAgreementInvoice.ChassisMgsetInvoice");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		ofc_cd = account.getOfc_cd();

		event = (EesCgm2036Event)request.getAttribute("Event");
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
			ComShowMessage(errMessage);
		} // end if

		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<!-- developer working -->
<input type="hidden" name="eq_knd_cd" value="G" id="eq_knd_cd" />
<input type="hidden" name="ofc_cd" value="<%=ofc_cd %>" id="ofc_cd" />
<input type="hidden" name="intg_cd_id" id="intg_cd_id" />
<input type="hidden" name="usr_id" value="<%=strUsr_id %>" id="usr_id" />
<input type="hidden" name="pay_inv_seq" id="pay_inv_seq" />
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
				<col width="50px">
				<col width="390px">
				<col width="50px">
				<col width="50px">
				<col width="130px">
				<col width="*">
			</colgroup> 
			<tr>
				<th>Invoice Date</th>
				<td><!--  
				--><script type="text/javascript">ComComboObject('cost_yrmon', 1, 110, 1, 1, 0, true);</script><!--  
				--><input type="text" name="inv_fm_date" dataformat="ymd" maxlength='10' style="width:80px;text-align:center" class="input1" value=""><!--  
				--><button type="button" class="calendar ir" name="btns_Calendar1" id="btns_Calendar1"></button><!--  
				-->~ <input type="text" name="inv_to_date" dataformat="ymd" maxlength='10' style="width:80px;text-align:center" class="input1" value=""><!--  
				--><button type="button" class="calendar ir" name="btns_Calendar2" id="btns_Calendar2"></button></td>
				<th>Invoice Office</th>
				<td><input type="text" name="cost_ofc_cd" style="width:60px;text-align:center;ime-mode:disabled" dataformat="engup" maxlength="6" value="" id="cost_ofc_cd" /><!--  
				--><button type="button" id="btns_office" name="btns_office" class="input_seach_btn"></button></td>
				<th>Creation User ID</th>
				<td><input type="text" name="cre_usr_id" style="width:90px;text-align:center" maxlength="20" value="<%=strUsr_id %>" id="cre_usr_id" /> </td>
			</tr> 
		</table>
		<table>
			<colgroup>
				<col width="74px">
				<col width="*">
			</colgroup> 
			<tr>
                <th>S. Provider</th>
				<td><input type="text" name="vndr_seq" dataformat="num" style="width:60px;text-align:center" class="input" value="" id="vndr_seq" /><!--  
				--><button type="button" id="btns_vndr" name="btns_vndr" class="input_seach_btn"></button><!--  
				--><input type="text" name="vndr_nm" style="width:340px;" class="input2" value="" id="vndr_nm" /></td>
			</tr> 
		</table>
		<table>
			<colgroup>
				<col width="50px">
				<col width="130px">
				<col width="410px">
				<col width="50px">
				<col width="*">
			</colgroup>
			<tr>
				<th>INV/CSR No.</th>
				<td class="sm"><!--  
				--><input type="radio" name="inv_csr_no_chk" value="inv_no" class="trans" id="inv_csr_no_chk" /> Invoice <!--  
				--> <input type="radio" name="inv_csr_no_chk" value="csr_no" class="trans" id="inv_csr_no_chk" /> CSR</td>
				<td class="sm"><input type="text" name="inv_csr_no" style="width:300px;ime-mode:disabled" dataformat="engupetc" maxlength="300" class="input" value="" id="inv_csr_no" /></td>
				<th>Status</th>
				<td><script type="text/javascript">ComComboObject('inv_status', 2, 200, 1, 0, 1, true);</script></td>
			</tr> 
		</table>
	</div>
</div>
<div class="wrap_result">
	<div class="opus_design_grid" id="mainTable">
		<h3 class="title_design">Main</h3>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
	<div class="opus_design_grid" id="mainTable">
		<h3 class="title_design">Detail</h3>
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
</div>
</form>