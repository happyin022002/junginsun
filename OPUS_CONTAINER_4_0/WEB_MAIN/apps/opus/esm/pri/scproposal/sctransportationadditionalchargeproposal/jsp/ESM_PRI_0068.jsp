<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_PRI_0068.jsp
*@FileTitle  : S/C Proposal Origin/Destination IHC - Excel Import
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/25
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.scproposal.sctransportationadditionalchargeproposal.event.EsmPri0068Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="com.clt.framework.component.common.AbstractValueObject"%>
<%@ page import="java.util.List"%>
<%@ page import="com.clt.framework.core.config.SiteConfigFactory"%>

<%
	EsmPri0068Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String[] prcTrspModCd	= null;
	String[] ratUtCd		= null;
	String[] currCd			= null;
	String[] prcCgoTpCd		= null;
	String[] srcInfoCd		= null;
	String[] prcProgStsCd	= null;
	String templateKey      = null;
	
	Logger log = Logger.getLogger("com.clt.apps.SCProposal.SCTransportationAdditionalChargeProposal");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmPri0068Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		prcTrspModCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("prcTrspModCd"), false,"|","\t","getCode","getName");
		ratUtCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("ratUtCd"),false,"|","\t");
		currCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("currCd"),false,"|","\t");
		prcCgoTpCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("prcCgoTpCd"), true,"|","\t","getCode","getName");
		srcInfoCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("srcInfoCd"), false,"|","\t","getCode","getName");
		prcProgStsCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("prcProgStsCd"), false,"|","\t","getCode","getName");
		// Excel Template File Key
        templateKey = (String)eventResponse.getCustomData("templateKey");
        
	}catch(Exception e) {
		out.println(e.toString());
	}
	

	String propNo = JSPUtil.getNull(request.getParameter("prop_no"));
	String svcScpCd	= JSPUtil.getNull(request.getParameter("svc_scp_cd"));
	String amdtSeq = JSPUtil.getNull(request.getParameter("amdt_seq"));
	String orgDestTpCd = JSPUtil.getNull(request.getParameter("org_dest_tp_cd"));
	String effDt = JSPUtil.getNull(request.getParameter("eff_dt"));
	//Excel template
    String excelTemp = "";
    if("O".equals(orgDestTpCd)) {
        excelTemp = "dkpcfj_20100205111924498.xls";
    } else if("D".equals(orgDestTpCd)) {
        excelTemp = "cjhrow_20100205111924495.xls";
    }
%>
<script language="javascript">
	var prcTrspModCdValue = " |<%=prcTrspModCd[0]%>";
	var prcTrspModCdText = " |<%=prcTrspModCd[1]%>";
	var ratUtCdValue = " |<%=ratUtCd[0]%>";
	var ratUtCdText = " |<%=ratUtCd[1]%>";
	var currCdValue = "|<%=currCd[0]%>";
	var currCdText = "|<%=currCd[1]%>";
	var prcCgoTpCdValue = " |<%=prcCgoTpCd[0]%>";
	var prcCgoTpCdText = " |<%=prcCgoTpCd[1]%>";
	var srcInfoCdValue = "|<%=srcInfoCd[0]%>";
	var srcInfoCdText = "|<%=srcInfoCd[1]%>";
	var PrcProgStsCdValue = "|<%=prcProgStsCd[0]%>";
	var PrcProgStsCdText = "|<%=prcProgStsCd[1]%>";
	
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="cd" id="cd" />
<input type="hidden" name="prop_no" value="<%= propNo %>" id="prop_no" />
<input type="hidden" name="amdt_seq" value="<%= amdtSeq %>" id="amdt_seq" />
<input type="hidden" name="svc_scp_cd" value="<%= svcScpCd %>" id="svc_scp_cd" />
<input type="hidden" name="add_chg_tp_cd" value="I" id="add_chg_tp_cd" />
<input type="hidden" name="org_dest_tp_cd" value="<%= orgDestTpCd %>" id="org_dest_tp_cd" />
<input type="hidden" name="eff_dt" value="<%= effDt %>" id="eff_dt" />
<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title"><span>S/C Proposal Origin/Destination IHC - Excel Import</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_template" 	id="btn_template">Template</button>
			<button type="button" class="btn_normal" name="btn_openfile" 	id="btn_openfile">Open File</button>
			<button type="button" class="btn_normal" name="btn_check" 		id="btn_check">Check</button>
			<button type="button" class="btn_normal" name="btn_save" 		id="btn_save">Save</button>
			<button type="button" class="btn_normal" name="btn_close" 		id="btn_close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->
		<!-- page_location(S) -->
		<div class="location">
			<span id="navigation"></span>
		</div>
		<!-- page_location(E) -->
	</div>
	<!-- page_title_area(E) -->
</div>
<div class="layer_popup_contents">
	<!-- opus_design_grid(S) -->
	<div class="wrap_result">
		<div class="opus_design_grid clear" >
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<div class="opus_design_grid clear" >
			<div id="hiddenSheetLayer" style="display: none ">
				<script type="text/javascript">ComSheetObject('sheet2');</script>
				<script type="text/javascript">ComSheetObject('sheet3');</script>
				<script type="text/javascript">ComSheetObject('sheet4');</script>
				<script type="text/javascript">ComSheetObject('sheet5');</script>
			</div>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>
<form name="downform" action="/opuscntr/FileDownload" method="post" target="downifm">
    <input type="hidden" name="<%=SiteConfigFactory.get("COM.FILE.DOWNLOAD.KEY") %>" value="<%=templateKey%>">
</form>
<iframe name="downifm" id="downifm" style="display:none;"></iframe>
</body>
</html>