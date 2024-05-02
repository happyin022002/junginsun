<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0065.jsp
*@FileTitle  : S/C Prefix & Scope Mapping Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.primasterdata.scprefix.event.EsmPri0065Event"%>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.syscommon.common.table.PriScPfxVO"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="com.clt.framework.component.common.AbstractValueObject"%>
<%@ page import="java.util.List"%>
<%
	EsmPri0065Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.PRIMasterData.SCPrefix");
	
	String[] svcScpCds = null;
	String[] subContiCds = null;
	String[] scPfxCds = null;

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmPri0065Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
        	strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

        // Service Scope Combo Data 
        svcScpCds = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("SvcScpCombo"));

        // Sub-continent Combo Data 
        subContiCds = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("SubcontiCombo"));

        // S/C Prefix Combo Data 
        scPfxCds = PRIUtil.getValueObject2StringArray((List<PriScPfxVO>)eventResponse.getCustomData("ScPfxCombo"),true ,"|","\t","getScPfxCd","getScPfxDesc");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script language="javascript">
	var svcScpComboValue 		= "|"+ "<%=svcScpCds[0]%>";
	var svcScpComboText 		= "|"+ "<%=svcScpCds[1]%>";

	var subContiComboValue 		= "|"+ "<%=subContiCds[0]%>";
	var subContiComboText 		= "|"+ "<%=subContiCds[1]%>";

	var scPfxComboValue 		= "|"+ "<%=scPfxCds[0]%>";
	var scPfxComboText 			= "|"+ "<%=scPfxCds[1]%>";

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();		
		
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- page(S) -->
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	
	<!-- page_title(S) -->
    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button>
		<button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button>
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

<!-- layout_wrap(S) -->
<div class="wrap_result" >

<!-- opus_design_grid(S) -->
<div class="opus_design_grid">
	<!-- opus_grid_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_normal" name="btn_RowAdd" id="btn_RowAdd">Row&nbsp;Add</button>
		<button type="button" class="btn_normal" name="btn_Delete" id="btn_Delete">Delete</button>
	</div>
	<!-- opus_grid_btn(E) -->
	
	<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
    <script language="javascript">ComSheetObject('sheet1');</script>
    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
</div>
<!-- opus_design_grid(E) -->

<!-- opus_design_grid(S) -->
<div class="opus_design_grid" style="display:none;">
	<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
    <script language="javascript">ComSheetObject('sheet2');</script>
    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
</div>
<!-- opus_design_grid(E) -->
</div>
<!-- layout_wrap(E) -->


</form>