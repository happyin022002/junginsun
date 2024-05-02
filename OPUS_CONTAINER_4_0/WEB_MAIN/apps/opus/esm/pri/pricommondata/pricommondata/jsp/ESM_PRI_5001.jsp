<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_5001.jsp
*@FileTitle  : BKG Term Mapping Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/02
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.pricommondata.pricommondata.event.EsmPri5001Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="com.clt.framework.component.common.AbstractValueObject"%>
<%@ page import="java.util.List"%>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr" %>

<%
	EsmPri5001Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	String[] repSvcScpCd 		= null;
	String[] prcCtrtTpCd		= null;
	String[] orgDestTpCd		= null;
	String[] bkgRcvDeTermCd		= null;
	String[] ctrtRcvDeTermCd	= null;
	
	
	Logger log = Logger.getLogger("com.clt.apps.PRICommonData.PRICommonData");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmPri5001Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		repSvcScpCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("repSvcScpCd"),true);
		prcCtrtTpCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("prcCtrtTpCd"),false,"|","\t","getCode","getName");
		orgDestTpCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("orgDestTpCd"),false,"|","\t","getCode","getName");
		bkgRcvDeTermCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("bkgRcvDeTermCd"),false,"|","\t","getCode","getName");
		ctrtRcvDeTermCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("ctrtRcvDeTermCd"),false,"|","\t","getCode","getName");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript">
<%=ConstantMgr.getCompanyCodeToJS()%>
	var repSvcScpCdComboValue = " |<%=repSvcScpCd[0]%>";  
    var repSvcScpCdComboText = " |<%=repSvcScpCd[1]%>";
    var prcCtrtTpCdComboValue = " |<%=prcCtrtTpCd[0]%>";  
    var prcCtrtTpCdComboText = " |<%=prcCtrtTpCd[1]%>";
    var orgDestTpCdComboValue = " |<%=orgDestTpCd[0]%>";  
    var orgDestTpCdComboText = " |<%=orgDestTpCd[1]%>";
    var bkgRcvDeTermCdComboValue = " |<%=bkgRcvDeTermCd[0]%>";  
    var bkgRcvDeTermCdComboText = " |<%=bkgRcvDeTermCd[1]%>";
    var ctrtRcvDeTermCdComboValue = " |*|<%=ctrtRcvDeTermCd[0]%>";  
    var ctrtRcvDeTermCdComboText = " |*|<%=ctrtRcvDeTermCd[1]%>";

    var repSvcScpCdValue = " |<%=repSvcScpCd[0]%>";  
    var repSvcScpCdText = " |<%=repSvcScpCd[1]%>";
    var prcCtrtTpCdValue = " |<%=prcCtrtTpCd[0]%>";  
    var prcCtrtTpCdText = " |<%=prcCtrtTpCd[1]%>";
    var orgDestTpCdValue = " |<%=orgDestTpCd[0]%>";  
    var orgDestTpCdText = " |<%=orgDestTpCd[1]%>";
    var bkgRcvDeTermCdValue = " |<%=bkgRcvDeTermCd[0]%>";  
    var bkgRcvDeTermCdText = " |<%=bkgRcvDeTermCd[1]%>";
    var ctrtRcvDeTermCdValue = " |*|<%=ctrtRcvDeTermCd[0]%>";  
    var ctrtRcvDeTermCdText = " |*|<%=ctrtRcvDeTermCd[1]%>";




	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<!-- developer working	-->
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button>
	</div>
	<!-- opus_design_btn(E) -->
	
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
	<!-- Content -->
		<button type="button" class="btn_normal" name="btn_rowadd" id="btn_rowadd">Row Add</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_delete" id="btn_delete">Row Delete</button>
	</div>
	<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
</form>
