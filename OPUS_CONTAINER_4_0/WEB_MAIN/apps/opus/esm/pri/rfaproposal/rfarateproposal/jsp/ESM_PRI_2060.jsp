<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_PRI_2060.jsp
*@FileTitle  : RFA Proposal Creation - Rate [Load Excel] (H Type)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/16
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
<%@ page import="com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.event.EsmPri2060Event"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="com.clt.framework.core.config.SiteConfigFactory"%>

<%
    EsmPri2060Event event = null; //PDTO(Data Transfer Object including Parameters)
    Exception serverException = null; //Error from Server
    String strErrMsg = ""; //Error Message
    int rowCount = 0; //Number of DB ResultSet List

    String successFlag = "";
    String codeList = "";
    String pageRows = "100";

    String strUsr_id = "";
    String strUsr_nm = "";
    Logger log = Logger.getLogger("com.clt.apps.RFAProposal.RFARateProposal");
    String templateKey = null;
    String[] bkgPrcCgoTpCd = null;    	//CARGO TYPE

    try {
        SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();

        event = (EsmPri2060Event) request.getAttribute("Event");
        serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        
        templateKey = (String)eventResponse.getCustomData("TEMPLATE_KEY");
        bkgPrcCgoTpCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("BKG_PRC_CGO_TP_CD"), false); 
        
    } catch (Exception e) {
        out.println(e.toString());
    }
%>

<script language="javascript">

var bkgPrcCgoTpCdComboValue = " |<%=bkgPrcCgoTpCd[0]%>";
var bkgPrcCgoTpCdComboText = " |<%=bkgPrcCgoTpCd[1]%>";

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

<input type="hidden" name="prop_no" value="<%=StringUtil.xssFilter(request.getParameter("prop_no"))%>">
<input type="hidden" name="amdt_seq" value="<%=StringUtil.xssFilter(request.getParameter("amdt_seq"))%>">
<input type="hidden" name="svc_scp_cd" value="<%=StringUtil.xssFilter(request.getParameter("svc_scp_cd"))%>">
<input type="hidden" name="pre_amdt_seq" value="<%=StringUtil.xssFilter(request.getParameter("pre_amdt_seq"))%>">
<input type="hidden" name="prc_prop_sts_cd" value="<%=StringUtil.xssFilter(request.getParameter("prc_prop_sts_cd"))%>">
<input type="hidden" name="eff_dt" value="<%=StringUtil.xssFilter(request.getParameter("eff_dt"))%>">
<input type="hidden" name="exp_dt" value="<%=StringUtil.xssFilter(request.getParameter("exp_dt"))%>">
<input type="hidden" name="pre_exp_dt" value="<%=StringUtil.xssFilter(request.getParameter("pre_exp_dt"))%>">
<input type="hidden" name="is_req_usr" value="<%=StringUtil.xssFilter(request.getParameter("is_req_usr"))%>">
<input type="hidden" name="is_apro_usr" value="<%=StringUtil.xssFilter(request.getParameter("is_apro_usr"))%>">
<input type="hidden" name="dur_dup_flg" value="<%=StringUtil.xssFilter(request.getParameter("dur_dup_flg"))%>">
<input type="hidden" name="prc_ctrt_cust_tp_cd" value="<%=StringUtil.xssFilter(request.getParameter("s_prc_ctrt_cust_tp_cd"))%>">
<input type="hidden" name="backendjob_key" id="backendjob_key" />

<!-- OUTER - POPUP (S)tart -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>RFA Proposal Creation - Rate [Load Excel] (H Type)</span></h2>
		
		<div class="opus_design_btn">
			  <button type="button" class="btn_normal" name="btn_template" id="btn_template">Template</button><!-- 
			  --><button type="button" class="btn_normal" name="btn_openfile" id="btn_openfile">Open File</button><!-- 
			  --><button type="button" class="btn_normal" name="btn_check" id="btn_check">Check</button><!-- 
			  --><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!-- 
			  --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_result">
		<div class="opus_design_grid" id="mainTable">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		
		<div class="opus_design_grid" id="mainTable" style="display:none;">
			<script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>
	</div>
</div>

</form>

<form name="downform" action="/opuscntr/FileDownload" method="post">
<input type="hidden" name="<%=SiteConfigFactory.get("COM.FILE.DOWNLOAD.KEY") %>" value="<%=templateKey%>">
</form>