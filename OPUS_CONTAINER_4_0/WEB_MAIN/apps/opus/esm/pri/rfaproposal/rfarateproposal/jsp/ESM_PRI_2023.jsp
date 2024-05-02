<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_2023.jsp
*@FileTitle  : RFA Proposal Creation - Rate (Commodity)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/28
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
<%@ page import="com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.event.EsmPri2023Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
    EsmPri2023Event event = null; //PDTO(Data Transfer Object including Parameters)
    Exception serverException = null; //error from server
    String strErrMsg = ""; //error message
    int rowCount = 0; //count of DB resultSET list

    String successFlag = "";
    String codeList = "";
    String pageRows = "100";

    String strUsr_id = "";
    String strUsr_nm = "";
    Logger log = Logger.getLogger("com.clt.apps.RFAProposal.RFARateProposal");

    try {
        SignOnUserAccount account = (SignOnUserAccount) session
                .getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();

        event = (EsmPri2023Event) request.getAttribute("Event");
        serverException = (Exception) request
                .getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

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
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<!-- developer job -->
<input type="hidden" name="prop_no" id="prop_no" value="<%=StringUtil.xssFilter(request.getParameter("prop_no"))%>">
<input type="hidden" name="amdt_seq" id="amdt_seq" value="<%=StringUtil.xssFilter(request.getParameter("amdt_seq"))%>">
<input type="hidden" name="svc_scp_cd" id="svc_scp_cd" value="<%=StringUtil.xssFilter(request.getParameter("svc_scp_cd"))%>">
<input type="hidden" name="pre_amdt_seq" id="pre_amdt_seq" value="<%=StringUtil.xssFilter(request.getParameter("pre_amdt_seq"))%>">
<input type="hidden" name="prc_prop_sts_cd" id="prc_prop_sts_cd" value="<%=StringUtil.xssFilter(request.getParameter("prc_prop_sts_cd"))%>">
<input type="hidden" name="eff_dt" id="eff_dt" value="<%=StringUtil.xssFilter(request.getParameter("eff_dt"))%>">
<input type="hidden" name="exp_dt" id="exp_dt" value="<%=StringUtil.xssFilter(request.getParameter("exp_dt"))%>">
<input type="hidden" name="pre_exp_dt" id="pre_exp_dt" value="<%=StringUtil.xssFilter(request.getParameter("pre_exp_dt"))%>">
<input type="hidden" name="is_req_usr" id="is_req_usr" value="<%=StringUtil.xssFilter(request.getParameter("is_req_usr"))%>">
<input type="hidden" name="is_apro_usr" id="is_apro_usr" value="<%=StringUtil.xssFilter(request.getParameter("is_apro_usr"))%>">
<input type="hidden" name="dur_dup_flg" id="dur_dup_flg" value="<%=StringUtil.xssFilter(request.getParameter("dur_dup_flg"))%>">
<input type="hidden" name="cmdt_hdr_seq" id="cmdt_hdr_seq" value="<%=StringUtil.xssFilter(request.getParameter("cmdt_hdr_seq"))%>">

<div class="layer_popup_title">

	<!-- page_title_area(S) -->
	<div class="page_title_area clear">

		<!-- page_title(S) -->
		<h2 class="page_title"><span>RFA Proposal Creation - Rate (Commodity)</span></h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button type="button" id="btn_ok" name="btn_ok" class="btn_accent">OK</button>
			<button type="button" id="btn_close" name="btn_close" class="btn_normal">Close</button>
		</div>
		<!-- opus_design_btn (E) -->
		
	</div>
	<!-- page_title_area(E) -->

</div>


<div class="layer_popup_contents">

	<div class="wrap_result">

		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">	
		
			<!-- opus_design_btn (S) -->
			<div class="opus_design_btn">
				<button type="button" id="btn_add" name="btn_add" class="btn_accent">Row Add</button><!--
				--><button type="button" id="btn_delete" name="btn_delete" class="btn_normal">Delete</button><!--
				--><button type="button" id="btn_amend" name="btn_amend" class="btn_normal">Amend</button><!--
				--><button type="button" id="btn_amendcancel" name="btn_amendcancel" class="btn_normal">Amend Cancel</button><!--
				--><button type="button" id="btn_accept" name="btn_accept" class="btn_normal">Accept</button><!--
				--><button type="button" id="btn_acceptcancel" name="btn_acceptcancel" class="btn_normal">Accept Cancel</button><!--
			--></div>
			<!-- opus_design_btn (E) -->	
			
			<script type="text/javascript">ComSheetObject('sheet1');</script>		
		</div>
		<!-- opus_design_grid(E) -->
	</div>
</div>
</form>