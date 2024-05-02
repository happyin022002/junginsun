<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0214.jsp
*@FileTitle  : Reefer Spare Part Inquiry_Pop Up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/13
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.generalmanage.reefersparepartmgt.event.EesMnr0214Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0214Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Occurred error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//Row count of retrieved database data

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String rhqOfcCd         = "";
	String currOfcCd       = "";
	String currOfcEngNm     = "";
	Logger log = Logger.getLogger("com.clt.apps.opus.ees.mnr.generalmanage.reefersparepartmgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id         =	account.getUsr_id();
		strUsr_nm       = account.getUsr_nm(); 
		rhqOfcCd        = account.getRhq_ofc_cd();
		currOfcCd       = account.getOfc_cd();
		currOfcEngNm = account.getOfc_eng_nm();
		
		event = (EesMnr0214Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//Extracting retrieved data from server on load screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
    var currOfcCd = '<%=currOfcCd %>';
    var rhqOfcCd  = '<%=rhqOfcCd %>';
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
<input type="hidden" name="f_gubuns" id="f_gubuns" />
<input type="hidden" name="spr_prt_no" value="" id="spr_prt_no" />
<input type="hidden" name="spr_tp_cd" value="" id="spr_tp_cd" />
<input type="hidden" name="agmt_ofc_cty_cd" value="" id="agmt_ofc_cty_cd" />
<input type="hidden" name="agmt_seq" value="" id="agmt_seq" />
<input type="hidden" name="agmt_ver_no" value="" id="agmt_ver_no" />
<input type="hidden" name="cost_ofc_cd" value="" id="cost_ofc_cd" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><span>Reefer Spare Part Inquiry</span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_new" id="btn_new" type="button">New</button><!--
		--><button class="btn_normal" name="btn_ok" id="btn_ok" type="button">OK</button><!--
		--><button class="btn_normal" name="btn_close" id="btn_close" type="button">Close</button>
	</div>
	<!-- opus_design_btn (E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table style="width:680px;">
			<colgroup>
				<col width="60">
				<col width="110">
				<col width="70">
				<col width="*">
			</colgroup>
			<tbody>
				<tr class="h23">
					<th>Unit Type</th>
					<td><script type="text/javascript">ComComboObject('combo_spr_ut_tp_nm',2, 100 , 1, 0,0,false,1);</script><!--  
						--><input type="hidden" name="spr_ut_tp_nm" id="spr_ut_tp_nm"></td>
					<th>Supply To</th>
					<td><input type="text" name="spr_prt_spl_tp_nm" id="spr_prt_spl_tp_nm" style="width:100px;" class="input2"><!--  
						--><input type="hidden" name="spr_prt_spl_tp_cd" id="spr_prt_spl_tp_cd"></td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="opus_design_inquiry"><table class="line_bluedot"><tr><td colspan="6"></td></tr></table></div>
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
<%@include file="/bizcommon/include/common_opus.jsp" %>
