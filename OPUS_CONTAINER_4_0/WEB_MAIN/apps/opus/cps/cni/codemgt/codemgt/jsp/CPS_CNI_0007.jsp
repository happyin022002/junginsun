<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : cps_cni_0007.jsp
*@FileTitle  : [CPS_CNI_0007] Office Code Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/11
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@page import="com.clt.apps.opus.cps.cni.codemgt.codemgt.event.CpsCni0007Event"%>
<%
	CpsCni0007Event event = null;
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

        event = (CpsCni0007Event) request.getAttribute("Event");
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
%>

<%@page import="com.clt.framework.component.util.StringUtil"%><html>

<script type="text/javascript">
function setupPage(){
	var errMessage = "<%=strErrMsg%>";
	if (errMessage.length >= 1) {
		showErrMessage(errMessage);
	} // end if
	loadPage();
}
</script>

<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><span>Office Code Table</span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn1_Retrieve" id="btn1_Retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn1_New" id="btn1_New" type="button">New</button><!--
		--><button class="btn_normal" name="btn1_Close" id="btn1_Close" type="button">Close</button><!--
		--></div>
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
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="80" />							
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
					<th>Office Code</th>
					<td><input type="text" dataformat="engup" style="width:100px;ime-mode:disabled" class="input1" id="ofc_cd" name="ofc_cd" value="" maxlength="6" onKeyPress="ComKeyOnlyAlphabet('uppernum')" onKeyDown="ComKeyEnter('search')"></td>
				</tr>
		   </tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn2_Select" id="btn2_Select" type="button">Select</button>
		</div>
		<!-- opus_design_btn (E) -->
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>