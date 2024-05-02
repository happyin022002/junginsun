<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESD_TRS_0802.jsp
*@FileTitle  : TRS STCC Manage
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
<%@ page import="com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.event.EsdTrs0802Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdTrs0802Event  event = null;
	Exception serverException   = null;
	String strErrMsg = "";
	int rowCount	 = 0;

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	int rowSize = 3000 ;
	String expt_tp_idx = JSPUtil.getNull(request.getParameter("expt_tp_selected_idx"));
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EsdTrs0802Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		}
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="frm_intg_cd_id">
<input type="hidden" name="frm_intg_cd_val_ctnt">

<!-- page_title_area(S) -->
<div class="page_title_area clear ">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button>
	</h2>
	<!-- page_title(E) -->

	    <!-- opus_design_btn(S) -->
	    <div class="opus_design_btn">
	        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
			<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
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
<div class="opus_design_inquiry">	
	<table class="search">
		<tbody>
		<colgroup>
            <col width="10" />
            <col width="200px" />
            <col width="100px" />
            <col width="200px" />
            <col width="150px" />
            <col width="200px" />
            <col width="" />
        </colgroup>
		<tr>
			<th>STCC</th>
			<td><input type="text" style="width:100px; ime-mode:disabled" name="frm_stcc_cd" class="input" maxlength="7" id="frm_stcc_cd" dataformat="engup" /></td>
			<th>STCC SEQ</th>
			<td><input type="text" style="width:100px; ime-mode:disabled" name="frm_stcc_seq" class="input" maxlength="3" id="frm_stcc_seq" dataformat="num" /></td>
			<th>UN No.</th>
			<td><input type="text" style="width:100px; ime-mode:disabled" name="frm_un_cmdt_cd" class="input" maxlength="4" id="frm_un_cmdt_cd" dataformat="engup" /></td>
			<td></td>
		</tr>
		</tbody>
	</table>
</div>
<!-- opus_design_inquiry(E) -->
</div>
<!-- wrap_search(E) -->
<!-- wrap_result(S) -->
<div class="wrap_result">
<!-- opus_design_grid(S) -->
<div class="opus_design_grid" id="mainTable" >	
	<!-- opus_design_btn(S) -->
    <div class="opus_design_btn">
		<button type="button" class="btn_normal" name="btn_RowAdd" id="btn_RowAdd">Row Add</button>
		<button type="button" class="btn_normal" name="btn_RowDel" id="btn_RowDel">Row Delete</button>															
    </div>
	<script language="javascript">ComSheetObject('sheet1');</script>
</div>
<!-- opus_design_grid(E) --> 
</div>
<!-- wrap_result(E) -->
<div class="header_fixed"></div>
</form>
