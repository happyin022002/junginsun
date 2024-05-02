<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SCO_0050.jsp
*@FileTitle  : Ledger Code Combination 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/
=========================================================
*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.FormCommand"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%-- <%@ page import="com.clt.apps.opus.stm.sco.statementcommon.statementcommon.event.StmSco0050Event"%> --%>
<%@ page import="org.apache.log4j.Logger" %>


<%
//     StmSco0050Event event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;			//Error occurred from server
	String strErrMsg = "";						//Error Message

	String strUsr_id = "";
	String strUsr_nm = "";

	String companyCd      = "";
	String regionCd       = "";
	String centerCd       = "";
	String accountCd      = "";
	String interCompanyCd = "";
	String vvdCd          = "";

	Logger log = Logger.getLogger("com.clt.apps.opus.stm.sco.statementcommon.StatementCommonSC");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

// 		event = (StmSco0050Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		companyCd      = JSPUtil.getNull(request.getParameter("f_company"));
		regionCd       = JSPUtil.getNull(request.getParameter("f_region"));
		centerCd       = JSPUtil.getNull(request.getParameter("f_center"));
		accountCd      = JSPUtil.getNull(request.getParameter("f_account"));
		interCompanyCd = JSPUtil.getNull(request.getParameter("f_inter_company"));
		vvdCd          = JSPUtil.getNull(request.getParameter("f_vvd"));

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}		     	

        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch(Exception ex) {
		log.error("err " + ex.toString(), ex);
		//out.println(e.toString());
	}

%>

<link href="../css/opus_contents.css" rel="stylesheet" type="text/css">
<link href="../css/opus_menu.css" rel="stylesheet" type="text/css">

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<script type="text/javascript">

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}	
</script>

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
		<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_new" id="btn_new" type="button">New</button><!--
		--><button class="btn_normal" name="btn_save" id="btn_save" type="button">Save</button><!--
		--><button class="btn_normal" name="btn_DownExcel" id="btn_DownExcel" type="button">Down Excel</button><!--
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
	<div class="opus_design_inquiry wFit">
		<table>
			<tbody>
				<colgroup>
					<col width="50">
					<col width="80">
					<col width="40">
					<col width="80">
					<col width="40">
					<col width="130">
					<col width="40">
					<col width="130">
					<col width="80">
					<col width="80">
					<col width="30">
					<col width="130">
					<col width="*">
				</colgroup>
				<tr>
	                  <th>Company</th>
	                  <td><input type="text" style="width:30px;" class="input1" name="f_company" required="" value="<%=companyCd%>" maxlength="2" caption="Company" id="f_company" /><button type="button" id="btns_search_company" name="btns_search_company" class="input_seach_btn"></button></td>
	                  <th>Region</th>
	                  <td><input type="text" style="width:30px;" class="input1" name="f_region" required="" value="<%=regionCd%>" maxlength="2" caption="Region" id="f_region" /><button type="button" id="btns_search_region" name="btns_search_region" class="input_seach_btn"></button></td>
	                  <th>Center</th>
	                  <td><input type="text" style="width:80px;" class="input1" name="f_center" required="" value="<%=centerCd%>" maxlength="6" caption="Center" id="f_center" /><button type="button" id="btns_search_center" name="btns_search_center" class="input_seach_btn"></button></td>
	                  <th>Account</th>
	                  <td><input type="text" style="width:80px;" class="input" name="f_account" value="<%=accountCd%>" maxlength="6" id="f_account" /><button type="button" id="btns_search_account" name="btns_search_account" class="input_seach_btn"></button></td>
	                  <th>Inter Company</th>
	                  <td><input type="text" style="width:30px;" class="input" name="f_inter_company" value="<%=interCompanyCd%>" maxlength="2" id="f_inter_company" /><button type="button" id="btns_search_inter_company" name="btns_search_inter_company" class="input_seach_btn"></button></td>
	                  <th title="Vessel Voyage Direction">VVD</th>
	                  <td><input type="text" style="width:80px;" class="input" name="f_vvd" dataformat="engup" value="<%=vvdCd%>" maxlength="10" id="f_vvd" /><button type="button" id="btns_search_vvd" name="btns_search_vvd" class="input_seach_btn"></button></td>
	                  <td></td>
           	   </tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>


<div class="wrap_result">
	<div class="opus_design_grid">
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_RowAdd" id="btn_DownExcel">Row Add</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_RowDelete" id="btn_RowDelete">Row Delete</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>	
</form>