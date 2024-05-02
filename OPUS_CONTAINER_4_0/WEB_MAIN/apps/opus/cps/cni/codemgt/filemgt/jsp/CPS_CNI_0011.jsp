<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : CPS_CNI_0011.js
*@FileTitle  : File Upload
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/14
     =========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@page import="com.clt.apps.opus.cps.cni.codemgt.filemgt.event.CpsCni0011Event"%>
<%
	CpsCni0011Event event = null;
    Exception serverException = null;
    String strErrMsg = "";
    int rowCount = 0; 

    String successFlag = "";
    String codeList = "";
    String pageRows = "100";

    String userId = "";
    String userName = "";
    String userOffice = "";
    String userArea = "";
    
    Logger log = Logger.getLogger("com.clt.apps.opus.cps.cni.codemgt.CodeMgtSC");
    
    
    try
    {
        SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        userId = account.getUsr_id();
        userName = account.getUsr_nm();
        userOffice = account.getOfc_cd();
        
        event = (CpsCni0011Event) request.getAttribute("Event");
        serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null)
        {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

    }
    catch (Exception e)
    {
        out.println(e.toString());
    }
    
    
    // ----------------------------------------------------------------
    // 해당 초기 파라미터 설정
    // ----------------------------------------------------------------    
    // clm_file_tp_cd  (UI번호(4) + fileupload 일련번호  000501 , 000502)   
    String clmFileTpCd = JSPUtil.getParameter(request , "clm_file_tp_cd" , "");
    String cgoClmRefNo  = JSPUtil.getParameter(request , "cgo_clm_ref_no" , "");
%>


<%@page import="com.clt.apps.opus.cps.gem.common.GemUtil"%>
<%@page import="com.clt.framework.component.util.StringUtil"%><html>

<script type="text/javascript">
	function setupPage(year){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		
		loadPage(year);
	}
</script>
<script type="text/javascript" src="/opuscntr/rpt/script/common_rd.js"></script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />

<!-- 개발자 작업 -->
<input type="hidden" name="clm_file_tp_cd" value="<%=clmFileTpCd%>" id="clm_file_tp_cd" />
<input type="hidden" name="cgo_clm_ref_no" value="<%=cgoClmRefNo%>" id="cgo_clm_ref_no" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><span>File Upload</span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn1_Close" id="btn1_Close" type="button">Close</button>
	</div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn2_Row_Add" id="btn2_Row_Add" type="button">Row Add</button>
			<button class="btn_accent" name="btn2_Row_Delete" id="btn2_Row_Delete" type="button">Row Delete</button>
			<button class="btn_accent" name="btn2_Save" id="btn2_Save" type="button">Save</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>
<div style="display:none">
	<script language="javascript">ComUploadObject('upload1', '<=session.getId()%>');</script>
</div>
<form name="form1" method="post">
</form>
