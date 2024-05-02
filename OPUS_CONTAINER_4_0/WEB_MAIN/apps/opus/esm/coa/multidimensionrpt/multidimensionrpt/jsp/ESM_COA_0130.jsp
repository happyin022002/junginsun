<%
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_COA_0130.jsp
*@FileTitle : ReportViewManagement
*Open Issues :
*Change history :
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.coa.multidimensionrpt.multidimensionrpt.event.EsmCoa0130Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	
	EsmCoa0130Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//Count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.MultiDimensionRPT.MultiDimensionRPT");

	
	String profitView = "";
	String office     = "";
	String profitLvl  = "";
	
	
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmCoa0130Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

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
	
    function setupPage(){
	    loadPage();
    }
</script>

<form name="form" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

	<!-- popup_title_area(S) -->
	<div class="layer_popup_title">
		<!-- page_title_area(S) -->
		<div class="page_title_area clear">
			<!-- page_title(S) -->
			<h2 class="page_title"><span>Report View Management</span></h2>
			<!-- page_title(E) -->
					
			 <!-- opus_design_btn(S) -->
		    <div class="opus_design_btn">
		        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->				
		       	<button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button><!--
		       	--><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		    </div>
		    <!-- opus_design_btn(E) -->
		</div>
		<!-- page_title_area(E) -->
	</div>
	<!-- popup_title_area(E) -->	
	
	<div class="layer_popup_contents">
		<!-- wrap_result(S) -->
		<div class="wrap_result">
			<!-- opus_design_grid(S) -->
			<div class="opus_design_grid" id="mainTable">				
				<script type="text/javascript">ComSheetObject('sheet1');</script>
			</div>
			<!-- opus_design_grid(E) -->
		</div>
	</div>
</form>