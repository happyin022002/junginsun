<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_1125.jsp
*@FileTitle  : Estimated Pool Chassis Expense(Co-Pool N/P)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/09
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event.EesCgm1125Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesCgm1125Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.ChassisMgsetAgreementInvoice.ChassisMgsetInvoice");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesCgm1125Event)request.getAttribute("Event");
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
<title>Estimated Pool Chassis Expense(Co-Pool N/P)</title>


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
<form name="form" >
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="chss_pool_tp_cd" value="CP" id="chss_pool_tp_cd" />
<input type="hidden" name="chss_pool_cd" id="chss_pool_cd" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_New" id="btn_New" type="button">New</button><!--
		--><button class="btn_normal" name="btn_Save" id="btn_Save" type="button">Save</button>
	</div>
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
	<div class="opus_design_inquiry">
		<table>
			<colgroup>
				<col width="50" />
				<col width="120" />
				<col width="70" />
				<col width="535" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<th>Year</th>
					<td><input type="text" style="width:60px;ime-mode:disabled" dataformat="yyyy" maxlength="4" class="input1" name="year" value="" id="year" /><button type="button" id="btns_Calendar" name="btns_Calendar" class="calendar ir"></button></td>
					<th class="sm">Pool Type</th>
					<td class="sm"><input type="radio" class="trans" name="chss_pool" onclick="javascript:title_chk(1)" checked id="chss_pool" /> Co-Pool <input type="radio" name="chss_pool" class="trans" onclick="javascript:title_chk(2)" id="chss_pool" />&nbsp;&nbsp;&nbsp;NP <script type="text/javascript">ComComboObject('chss_pool_co_cd', 1, 420, 1, 1, 1, true);</script></td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<table>
		<col width="100" />
		<col width="*" />
		<tbody>
			<tr>
				<td><h3 class="title_design" id="tabLayer" name="tabLayer">Co-Pool</h3><h3 class="title_design" id="tabLayer" name="tabLayer" style="display:none">NP</h3></td>
				<td style="text-align: right"><strong class="mar_rgt_4">Currency</strong><input type="text" style="width:50px;ime-mode:disabled;text-align:center" dataformat="eng"  name="curr_cd" id="curr_cd" class="input" value="USD" maxlength="3"></td>
			</tr>
		</tbody>
	</table>
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>

</form>