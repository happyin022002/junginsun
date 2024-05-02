<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_3014.jsp
*@FileTitle  : TRI Creation & Amendment - Publication
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/22
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.triproposal.triproposal.event.EsmPri3014Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
    EsmPri3014Event event = null; //PDTO(Data Transfer Object including Parameters)
    Exception serverException = null; //error from server
    String strErrMsg = ""; //error message
    int rowCount = 0; //count of DB resultSET list

    String successFlag = "";
    String codeList = "";
    String pageRows = "100";

    String strUsr_id = "";
    String strUsr_nm = "";
    Logger log = Logger.getLogger("com.clt.apps.TRIProposal.TRIRateProposal");

    try {
        SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();

        event = (EsmPri3014Event) request.getAttribute("Event");
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
            showErrMessage(errMessage);
        } // end if
        
        loadPage();
    }

</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="amdt_seq" value="<%=StringUtil.xssFilter(request.getParameter("amdt_seq")) %>" id="amdt_seq" />
<input type="hidden" name="prop_sts_cd" value="<%=StringUtil.xssFilter(request.getParameter("prop_sts_cd")) %>" id="prop_sts_cd" />
<input type="hidden" name="is_req_usr" value="<%=StringUtil.xssFilter(request.getParameter("is_req_usr")) %>" id="is_req_usr" />
<input type="hidden" name="is_apro_usr" value="<%=StringUtil.xssFilter(request.getParameter("is_apro_usr")) %>" id="is_apro_usr" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title">TRI Creation & Amendment - Publication</span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn1_Close" id="btn1_Close" type="button">Close</button>
	</div>
	<!-- opus_design_btn (E) -->
</div>
<!-- page_title_area(E) -->
<!-- wrap_result(S) -->
<div class="wrap_result">
<!-- opus_design_grid(S) -->
<div class="opus_design_grid"> 
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_send" id="btn_send" type="button">Send</button>
		<button class="btn_accent" name="btn_downexcel" id="btn_downexcel" type="button">Down Excel</button>
		<button class="btn_accent" name="btn_delete" id="btn_delete" type="button">Delete</button>
	</div>
	<!-- opus_design_btn (E) -->
	<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
<!-- opus_design_grid(E) -->
</div>
<!-- wrap_result(E) -->
<script type="text/javascript">ComUploadObject('upload1', '<%=session.getId()%>');</script>
</form>