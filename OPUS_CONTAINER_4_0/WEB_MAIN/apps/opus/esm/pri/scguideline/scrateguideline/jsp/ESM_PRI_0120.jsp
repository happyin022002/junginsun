<%  
/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_PRI_0120.jsp
 *@FileTitle : Rate Creation - Excel Import(Vertical)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier :
 *@LastVersion :
 =========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.config.SiteConfigFactory"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.scguideline.scrateguideline.event.EsmPri0120Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>
<%
    EsmPri0120Event event = null; //PDTO(Data Transfer Object including Parameters)
    Exception serverException = null; //error from server
    String strErrMsg = ""; //error message
    int rowCount = 0; //count of DB resultSET list

    String successFlag = "";
    String codeList = "";
    String pageRows = "100";

    String strUsr_id = "";
    String strUsr_nm = "";
    String templateKey = null;
    String[] perCds = null;
    String[] cargoTpCds = null;
    String[] termOrgCds = null;
    String[] termDestCds = null;
    String[] transMdCds = null;
    Logger log = Logger.getLogger("com.clt.apps.SCGuideline.SCRateGuideline");

    try {
        SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();

        event = (EsmPri0120Event) request.getAttribute("Event");
        serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        // Service Scope Combo Data 
        perCds = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("perCd"));
        // Cargo Type Combo Data 
        cargoTpCds = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("cargoTpCd"),true ,"|","\t","getCode","getName");
        // Term Origin Combo Data 
        termOrgCds = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("termOrgCd"),false ,"|","\t","getCode","getName");
        // Term Destination Combo Data 
        termDestCds = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("termDestCd"),false ,"|","\t","getCode","getName");
        // Transmode Combo Data 
        transMdCds = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("transMdCd"),false ,"|","\t","getCode","getName");
        // Excel Template File Key
        templateKey = (String)eventResponse.getCustomData("templateKey");
    } catch (Exception e) {
        out.println(e.toString());
    }
%>

<script language="javascript">
    var perComboValue = " |<%=perCds[0]%>";
    var perComboText = " |<%=perCds[1]%>";

    var cargoTpComboValue = " |<%=cargoTpCds[0]%>";
    var cargoTpComboText = " |<%=cargoTpCds[1]%>";

    var termOrgComboValue = " |<%=termOrgCds[0]%>";
    var termOrgComboText = " |<%=termOrgCds[1]%>";

    var termDestComboValue = " |<%=termDestCds[0]%>";
    var termDestComboText = " |<%=termDestCds[1]%>";

    var transMdComboValue = " |<%=transMdCds[0]%>";
    var transMdComboText = " |<%=transMdCds[1]%>";

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
<!-- developer performance -->
<input type="hidden" name="gline_seq" value="<%=StringUtil.xssFilter(request.getParameter("gline_seq"))%>">
<input type="hidden" name="svc_scp_cd" value="<%=StringUtil.xssFilter(request.getParameter("svc_scp_cd"))%>">
<input type="hidden" name="prc_cust_tp_cd" value="<%=StringUtil.xssFilter(request.getParameter("prc_cust_tp_cd"))%>">
<input type="hidden" name="eff_dt" value="<%=StringUtil.xssFilter(request.getParameter("eff_dt"))%>">
<input type="hidden" name="exp_dt" value="<%=StringUtil.xssFilter(request.getParameter("exp_dt"))%>">
<input type="hidden" name="prc_prop_sts_cd" value="<%=StringUtil.xssFilter(request.getParameter("prc_prop_sts_cd"))%>">
<input type="hidden" name="pre_exp_dt" value="<%=StringUtil.xssFilter(request.getParameter("pre_exp_dt"))%>">
<input type="hidden" name="is_req_usr" value="<%=StringUtil.xssFilter(request.getParameter("is_req_usr"))%>">
<input type="hidden" name="is_apro_usr" value="<%=StringUtil.xssFilter(request.getParameter("is_apro_usr"))%>">
<input type="hidden" name="gen_spcl_rt_tp_cd" value="<%=StringUtil.xssFilter(request.getParameter("gen_spcl_rt_tp_cd"))%>">

<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Rate Creation - Excel Import (Vertical)</span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_Template" id="btn_Template">Template</button>
			<button type="button" class="btn_normal" name="btn_openfile" id="btn_openfile">Open File</button>
			<button type="button" class="btn_normal" name="btn_check" id="btn_check">Check</button>
			<button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button>
			<button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">

	<div class="wrap_result">
		<div class="opus_design_grid" >
			<script language="javascript">ComSheetObject('sheet1');</script>
		</div>
		<div class="opus_design_grid" style="display:none;">
			<script language="javascript">ComSheetObject('sheet2');</script>
		</div>
	</div>
</div>
</form>
<form name="downform" action="/opuscntr/FileDownload" method="post" target="downifm">
<input type="hidden" name="<%=SiteConfigFactory.get("COM.FILE.DOWNLOAD.KEY") %>" value="<%=templateKey%>">
</form>
<iframe name="downifm" style="display:none;"></iframe>