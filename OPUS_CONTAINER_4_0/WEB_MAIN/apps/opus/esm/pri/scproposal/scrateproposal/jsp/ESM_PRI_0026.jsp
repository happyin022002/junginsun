<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0026.jsp
*@FileTitle  : S/C Proposal General/Special Rate - Commodity
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/14
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
<%@ page import="com.clt.apps.opus.esm.pri.scproposal.scrateproposal.event.EsmPri0026Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
    EsmPri0026Event event = null; //PDTO(Data Transfer Object including Parameters)
    Exception serverException = null; //error from server
    String strErrMsg = ""; //error message
    int rowCount = 0; //count of DB resultSET list

    String successFlag = "";
    String codeList = "";
    String pageRows = "100";

    String strUsr_id = "";
    String strUsr_nm = "";
    Logger log = Logger.getLogger("com.clt.apps.SCProposal.SCRateProposal");

    try {
        SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();

        event = (EsmPri0026Event) request.getAttribute("Event");
        serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        
    } catch (Exception e) {
        out.println(e.toString());
    }
%>
<script language="javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            showErrMessage(errMessage);
        } // end if
        
        loadPage();
    }

</script>

<form name="form">
<input type="hidden" id="f_cmd"  name="f_cmd">
<input type="hidden" id="pagerows"  name="pagerows">

<input type="hidden" id="prop_no"         name="prop_no" value="<%=StringUtil.xssFilter(request.getParameter("prop_no"))%>">
<input type="hidden" id="amdt_seq"        name="amdt_seq" value="<%=StringUtil.xssFilter(request.getParameter("amdt_seq"))%>">
<input type="hidden" id="svc_scp_cd"      name="svc_scp_cd" value="<%=StringUtil.xssFilter(request.getParameter("svc_scp_cd"))%>">
<input type="hidden" id="pre_amdt_seq"    name="pre_amdt_seq" value="<%=StringUtil.xssFilter(request.getParameter("pre_amdt_seq"))%>">
<input type="hidden" id="prc_prop_sts_cd" name="prc_prop_sts_cd" value="<%=StringUtil.xssFilter(request.getParameter("prc_prop_sts_cd"))%>">
<input type="hidden" id="eff_dt" 			name="eff_dt" value="<%=StringUtil.xssFilter(request.getParameter("eff_dt"))%>">
<input type="hidden" id="exp_dt"			name="exp_dt" value="<%=StringUtil.xssFilter(request.getParameter("exp_dt"))%>">
<input type="hidden" id="pre_exp_dt" 		name="pre_exp_dt" value="<%=StringUtil.xssFilter(request.getParameter("pre_exp_dt"))%>">
<input type="hidden" id="is_req_usr"		name="is_req_usr" value="<%=StringUtil.xssFilter(request.getParameter("is_req_usr"))%>">
<input type="hidden" id="is_apro_usr"		name="is_apro_usr" value="<%=StringUtil.xssFilter(request.getParameter("is_apro_usr"))%>">
<input type="hidden" id="dur_dup_flg"		name="dur_dup_flg" value="<%=StringUtil.xssFilter(request.getParameter("dur_dup_flg"))%>">
<input type="hidden" id="gen_spcl_rt_tp_cd" name="gen_spcl_rt_tp_cd" value="<%=StringUtil.xssFilter(request.getParameter("gen_spcl_rt_tp_cd"))%>">
<input type="hidden" id="cmdt_hdr_seq" 	name="cmdt_hdr_seq" value="<%=StringUtil.xssFilter(request.getParameter("cmdt_hdr_seq"))%>">
<input type="hidden" id="lgcy_if_flg"		name="lgcy_if_flg" value="<%=StringUtil.xssFilter(request.getParameter("lgcy_if_flg"))%>">

<div class="layer_popup_title">
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><span>Rate Creation - Commodity</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_ok" 	id="btn_ok">OK</button>
		<button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
	</div>
	<!-- opus_design_btn(E) -->
</div>
<!-- page_title_area(E) -->
</div>

<div class="layer_popup_contents">	
	<!-- opus_design_grid(S) -->	
	<div class="wrap_result">
		<div class="opus_design_grid clear" id="mainTable" >
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_add" 	id="btn_add" suppressWait="Y">Row Add</button>
				<button type="button" class="btn_normal" name="btn_delete" id="btn_delete" suppressWait="Y">Delete</button>
				<button type="button" class="btn_normal" name="btn_amend" id="btn_amend" suppressWait="Y">Amend</button>
				<button type="button" class="btn_normal" name="btn_amendcancel" id="btn_amendcancel">Amend Cancel</button>
				<button type="button" class="btn_normal" name="btn_accept" id="btn_accept">Accept</button>
				<button type="button" class="btn_normal" name="btn_acceptcancel" id="btn_acceptcancel">Accept Cancel</button>
			</div>
				<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>