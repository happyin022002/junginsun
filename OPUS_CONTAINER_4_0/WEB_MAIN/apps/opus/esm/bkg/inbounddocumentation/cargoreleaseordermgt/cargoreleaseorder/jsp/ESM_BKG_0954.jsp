<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0954.jsp
*@FileTitle  : 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/08
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0954Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg0954Event event     = null;         //PDTO(Data Transfer Object including Parameters)
    Exception serverException = null;         //error from server
    String strErrMsg = "";                    //error message
    int rowCount     = 0;                     //count of DB resultSET list

    String successFlag = "";
    String codeList    = "";
    String pageRows    = "100";

    String strUsr_id   = "";
    String strUsr_nm   = "";

    Logger log = Logger.getLogger("com.clt.apps.InboundBLMgt.FullReleaseOrder");
    SignOnUserAccount account= null;
    try {
        account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();

        event = (EsmBkg0954Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<script type="text/javascript">
    function setupPage(date){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            showErrMessage(errMessage);
        } // end if
        loadPage('<%=DateTime.getTimeStampString2()%>', '<%=account.getUsr_id()%>');
    }
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="h_rmk" id="h_rmk" />
<input type="hidden" name="bkg_no" value="<%=JSPUtil.getNull(request.getParameter("bkg_no")) %>" id="bkg_no" />
<input type="hidden" name="remark" value="<%=JSPUtil.getNull(request.getParameter("remark")) %>" id="remark" />
<input type="hidden" name="evnt_dt" value="<%=JSPUtil.getNull(request.getParameter("evnt_dt")) %>" id="evnt_dt" />
<input type="hidden" name="evnt_usr_id" value="<%=JSPUtil.getNull(request.getParameter("evnt_usr_id")) %>" id="evnt_usr_id" />

<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Cargo Release Order Auto Pop-up Remark</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
	    	<a id="id_save"><button class="btn_accent" type="button" name="btn1_Save" id="btn1_Save">Save</button></a><!--
			--><button class="btn_normal" type="button"  name="btn1_Close" id="btn1_Close">Close</button>
		</div>
		<!-- opus_design_btn (E) -->
	</div>
	<!-- page_title_area(E) -->
</div>

<div class="layer_popup_contents">		     
	<div class="wrap_result">
		<!-- opus_design_grid (S) -->
		<div class="opus_design_grid" id="mainTable">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<!-- opus_design_grid (E) -->
	</div>
</div>	
</form>