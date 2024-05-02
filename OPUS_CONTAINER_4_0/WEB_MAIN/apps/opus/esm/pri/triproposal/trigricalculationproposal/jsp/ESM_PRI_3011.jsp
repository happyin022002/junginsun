<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_3011.jsp
*@FileTitle  : TRI GRI Calculation - Commodity Select 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/
=========================================================
*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.triproposal.trigricalculationproposal.event.EsmPri3011Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
    EsmPri3011Event event = null; //PDTO(Data Transfer Object including Parameters)
    Exception serverException = null; //error from server
    String strErrMsg = ""; //error message
    int rowCount = 0; //count of DB resultSET list

    String successFlag = "";
    String codeList = "";
    String pageRows = "100";

    String strUsr_id = "";
    String strUsr_nm = "";
    Logger log = Logger.getLogger("com.clt.apps.TRIProposal.TRIGRICalculationProposal");

    try {
        SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();

        event = (EsmPri3011Event) request.getAttribute("Event");
        serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

    } catch (Exception e) {
        out.println(e.toString());
    }
%>

<script type="text/javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            //showErrMessage(errMessage);
        } // end if

        loadPage();
    }

</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<!-- developer performance -->
<input type="hidden" name="trf_pfx_cd" value="<%=StringUtil.xssFilter(request.getParameter("trf_pfx_cd")) %>" id="trf_pfx_cd" />
<input type="hidden" name="trf_no" value="<%=StringUtil.xssFilter(request.getParameter("trf_no")) %>" id="trf_no" />
<input type="hidden" name="gri_grp_seq" value="<%=StringUtil.xssFilter(request.getParameter("gri_grp_seq")) %>" id="gri_grp_seq" />
<input type="hidden" name="gri_appl_flg" value="<%=StringUtil.xssFilter(request.getParameter("gri_appl_flg")) %>" id="gri_appl_flg" />
<input type="hidden" name="is_req_usr" value="<%=StringUtil.xssFilter(request.getParameter("is_req_usr")) %>" id="is_req_usr" />
<input type="hidden" name="is_apro_usr" value="<%=StringUtil.xssFilter(request.getParameter("is_apro_usr")) %>" id="is_apro_usr" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><span>TRI GRI Calculation - Commodity Select</span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_ok" 	id="btn_ok">OK</button>
		<button type="button" class="btn_normal" name="btn_close" 	id="btn_close">Close</button>
	</div>
	<!-- opus_design_btn(E) -->	
	
</div>
<!-- page_title_area(E) -->

<div class="wrap_result">
	<div class="opus_design_grid">
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_add" 	id="btn_add">Row Add</button>
			<button type="button" class="btn_normal" name="btn_delete" 	id="btn_delete">Delete</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>

</form>