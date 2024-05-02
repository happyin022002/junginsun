<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0067.jsp
*@FileTitle  : Guideline Arbitrary - Excel Import
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/27
=========================================================
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.scguideline.scarbitrarychargeguideline.event.EsmPri0067Event"%>
<%@ page import="com.clt.apps.opus.esm.pri.scguideline.scarbitrarychargeguideline.vo.RsltPriSgArbKeyVO" %>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="com.clt.framework.core.config.SiteConfigFactory"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri0067Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;         //error from server
	String strErrMsg = ""; //error message
	int rowCount = 0; //count of DB resultSET list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	//Parameter passed from parent window
	String svcScpCd		= "";
	String glineSeq		= "";
	String orgDestTpCd		= "";
	
	String[] prcTrspModCd = null;
	String[] rcvDeTermCd = null;
	String[] ratUtCd = null;
	String[] prcCgoTpCd = null;
	String[] currCd = null;	
	
	String templateKey = null;
		
	Logger log = Logger.getLogger("com.clt.apps.SCGuideline.SCArbitraryChargeGuideline");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmPri0067Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		// Parameter that passed from parent window
		RsltPriSgArbKeyVO rsltPriSgArbKeyVO = event.getRsltPriSgArbKeyVO();		
		if(rsltPriSgArbKeyVO != null) {
			glineSeq = rsltPriSgArbKeyVO.getGlineSeq();
			svcScpCd = rsltPriSgArbKeyVO.getSvcScpCd();
			orgDestTpCd = rsltPriSgArbKeyVO.getOrgDestTpCd();
		}

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		 
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
				
		prcTrspModCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("PRC_TRSP_MOD_CD"), false);
		rcvDeTermCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("RCV_DE_TERM_CD"), false);
		ratUtCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("RAT_UT_CD"), false);
		prcCgoTpCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("PRC_CGO_TP_CD"),false);
		currCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("CURR_CD"), false);
	    
		// Excel Template File Key
	    templateKey = (String)eventResponse.getCustomData("templateKey");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script language="javascript">
	var prcTrspModCdComboValue = " |<%=prcTrspModCd[0]%>";  
    var prcTrspModCdComboText = " |<%=prcTrspModCd[1]%>";
	var rcvDeTermCdComboValue = " |<%=rcvDeTermCd[0]%>";
	var rcvDeTermCdComboText = " |<%=rcvDeTermCd[1]%>";
	var ratUtCdComboValue = " |<%=ratUtCd[0]%>"; 
	var ratUtCdComboText = " |<%=ratUtCd[1]%>";
	var prcCgoTpCdComboValue = " |<%=prcCgoTpCd[0]%>"; 
	var prcCgoTpCdComboText = " |<%=prcCgoTpCd[1]%>";
	var currCdComboValue = " |<%=currCd[0]%>"; 
	var currCdComboText = " |<%=currCd[1]%>";
	
<!--	ComDebug(prcTrspModCdComboValue);-->
<!--	ComDebug(prcTrspModCdComboText);-->
<!--	ComDebug(rcvDeTermCdComboValue);-->
<!--	ComDebug(ratUtCdComboValue);-->
<!--	ComDebug(ratUtCdComboText);-->
<!--	ComDebug(prcCgoTpCdComboValue);-->
<!--	ComDebug(prcCgoTpCdComboText);-->
<!--	ComDebug(currCdComboValue);-->
<!--	ComDebug(currCdComboText);-->
	
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

<input type="hidden" name="svc_scp_cd" value="<%=svcScpCd %>">
<input type="hidden" name="gline_seq" value="<%=glineSeq %>">
<input type="hidden" name="org_dest_tp_cd" value="<%=orgDestTpCd %>">
<input type="hidden" name="cd" >

<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Guideline Origin/Destination Arbitrary - Excel Import</span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_Template" id="btn_Template">Template</button><!--
			--><button type="button" class="btn_normal" name="btn_file" id="btn_file">Open File</button><!--
			--><button type="button" class="btn_normal" name="btn_check" id="btn_check">Check</button><!--
			--><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!--
			--><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
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
<!-- popup_contens_area(E) -->
</form>
<form name="downform" action="/opuscntr/FileDownload" method="post" target="downifm">
<input type="hidden" name="<%=SiteConfigFactory.get("COM.FILE.DOWNLOAD.KEY") %>" value="<%=templateKey%>">
</form>
<iframe name="downifm" style="display:none;"></iframe>