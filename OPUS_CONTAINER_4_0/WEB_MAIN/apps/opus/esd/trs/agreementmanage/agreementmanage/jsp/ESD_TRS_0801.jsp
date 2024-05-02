<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESD_TRS_0801.jsp
*@FileTitle  : TRS AGMT EQ TP RULE Manage
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/26
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0801Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdTrs0801Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error On Server Side
	String strErrMsg = "";						//Error Message
	int rowCount	 = 0;						//DB ResultSet List Count

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.opus.esd.sce.copreport");
	int rowSize = 3000 ;

	String expt_tp_idx = JSPUtil.getNull(request.getParameter("expt_tp_selected_idx"));
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EsdTrs0801Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
<%= JSPUtil.getIBCodeCombo("cb_trspAgmtRuleTpCd", "", "CD02178", 0, "")%>
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="frm_intg_cd_id">
<input type="hidden" name="frm_intg_cd_val_ctnt">

	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		
		<!-- page_title(S) -->
	    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->
	
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn"><!--
		--><button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!--
		--><button type="button" class="btn_normal" name="btn_exceldown" id="btn_exceldown">Down Excel</button><!--
		--><button type="button" class="btn_normal" name="btn_excelup" id="btn_excelup">Load Excel</button>
		</div>
		<!-- opus_design_btn(E) -->
	
	   	<!-- page_location(S) -->
	   	<div class="location">
			<!-- location 내용 동적생성 (별도 코딩 불필요) -->
	        <span id="navigation"></span>
	   	</div>
	   	<!-- page_location(E) -->
	</div>
	<!-- page_title_area(E) -->
	
	<!-- wrap_search(S) -->
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<!--  MiniLayer (S) -->
		<table>
			<colgroup>
	            <col width="150" />
	            <col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<th>TRSP AGMT RULE Type Code</th>
					<td><input type="text" style="width:100px; ime-mode:disabled" name="frm_trsp_agmt_rule_tp_cd" id="frm_trsp_agmt_rule_tp_cd" class="input" dataformat="enguponly" maxlength="2"></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<!-- wrap_result(S) -->
<div class="wrap_result">				
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="mainTable">
		<!-- opus_grid_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_RowAdd" id="btn_RowAdd">Row Add</button>
			<button type="button" class="btn_normal" name="btn_RowDel" id="btn_RowDel">Row Delete</button>			
		</div>
		<!-- opus_grid_btn(E) -->
		<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <script type="text/javascript">ComSheetObject('sheet1');</script>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<!-- opus_design_grid(E) -->
</div>
<div class="header_fixed"></div>
</form>