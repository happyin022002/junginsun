<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_OPF_0033.jsp
*@FileTitle  : COD Approve Main Screen 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/19
=========================================================
*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.opf.changeofdestinationmgt.changeofdestinationmgt.event.VopOpf0033Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	VopOpf0033Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String rso              = "";
	Logger log = Logger.getLogger("com.clt.apps.ChangeOfDestinationMgt.ChangeOfDestinationMgt");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (VopOpf0033Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		rso = eventResponse.getETCData("rso");
	} catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage('<%=rso%>');
	}
</script>

<form name="form">
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="pagerows" name="pagerows" type="hidden" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn (S) --> 
	<div class="opus_design_btn">
		<button type="button" id="btn_Retrieve" name="btn_Retrieve" class="btn_accent">Retrieve</button><!--
		--><button type="button" id="btn_New" name="btn_New" class="btn_normal">New</button><!--
		--><button type="button" id="btn_Detail" name="btn_Detail" class="btn_normal">Application Detail</button><!--
		--><button type="button" id="btn_History" name="btn_History" class="btn_normal">COD History</button><!--
		--><button type="button" id="btn_Tariff" name="btn_Tariff" class="btn_normal">COD Tariff Inquiry</button><!--
		--></div>
	<!-- opus_design_btn (E) -->
	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->


<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry  wFit">
		<table>
			<tbody>
				<colgroup>
					<col width="75" />
					<col width="120" />
					<col width="50" />
					<col width="170" />  
					<col width="50" />
					<col width="130" />
					<col width="50" />
					<col width="150" />
					<col width="*" />
				</colgroup>
				<tr>
					<th>RSO</th>
					<td><script type="text/javascript">ComComboObject('rso', 2, 85, 1, 1);</script></td>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input name="vsl_cd" id="vsl_cd"  fullfill type="text" style="width:55px;" class="input" value="" caption="Vessel Code" maxlength="4" dataformat="engup" style="ime-mode: disabled"><input name="skd_voy_no" id="skd_voy_no" fullfill type="text" style="width: 40px;" class="input" value="" caption="Schedule Voyage Number" maxlength="4" dataformat="num" style="ime-mode: disabled"><input name="skd_dir_cd" id="skd_dir_cd" fullfill type="text" style="width:20px;ime-mode :disabled;" class="input" value="" caption="Schedule Direction Code" maxlength="1" dataformat="engup"><button type="button" class="input_seach_btn" name="btn_VVDpop"  id="btn_VVDpop" ></button></td>
					<th>BKG No.</th>
					<td><input id="bkg_no" name="bkg_no"  style="width: 100px;" class="input" value="" caption="Booking Number" dataformat="engup" type="text" /></td><!--fullfill=""  maxlength="12" --> 
					<th>Auth Result</th>
					<td><script type="text/javascript">ComComboObject('cod_sts_cd', 2, 200, 1);</script></td>
					<td></td>
				</tr>
				<tr>
					<th>Lane Code</th>
					<td><input id="slan_cd" name="slan_cd" caption="Lane Code" style="width: 55px; ime-mode:disabled;" class="input" maxlength="3" dataformat="engup" fullfill="" type="text" /><button class="input_seach_btn" name="btn_slan_cd_pop" id="btn_slan_cd_pop" type="button"></button></td>
					<th>COD RSN</th>
					<td><script type="text/javascript">ComComboObject('cod_rqst_rsn_cd', 2, 107, 1);</script></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<div class="opus_design_grid" style="display: none;">
			<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
</div>
</form>