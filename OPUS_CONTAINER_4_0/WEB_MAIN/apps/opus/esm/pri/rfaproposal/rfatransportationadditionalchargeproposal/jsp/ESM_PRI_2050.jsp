<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_PRI_2050.jsp
*@FileTitle  : RFA Proposal Creation - Arbitrary[Load Excel]
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/25
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.event.EsmPri2050Event"%>
<%@ page import="com.clt.apps.opus.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.vo.RsltPriRpScpArbKeyVO" %>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="com.clt.framework.core.config.SiteConfigFactory"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri2050Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";

	String svcScpCd		= "";
	String propNo		= "";
	String amdtSeq		= "";
	String orgDestTpCd	= "";
	String addChgTpCd	= "";
	String n1stCmncDt	= "";
	
	//COMBO CODE
	String[] rcvDeTermCd = null;    	//TERM
	String[] prcTrspModCd = null;    	//TRANS. MODE
	String[] prcCgoTpCd = null;    		//CARGO TYPE
	String[] ratUtCd = null;			//PER TYPE
	String[] currCd = null;				//CURRENCY
	String[] custDefCd = null;			//ACTUAL CUSTOMER
	
	String templateKey = null;
		
	Logger log = Logger.getLogger("com.clt.apps.RFAProposal.RFATransportationAdditionalChargeProposal");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmPri2050Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		
		RsltPriRpScpArbKeyVO rsltPriRpScpArbKeyVO = event.getRsltPriRpScpArbKeyVO();		
		if(rsltPriRpScpArbKeyVO != null) {
			propNo = rsltPriRpScpArbKeyVO.getPropNo();
			amdtSeq = rsltPriRpScpArbKeyVO.getAmdtSeq();
			svcScpCd = rsltPriRpScpArbKeyVO.getSvcScpCd();
			orgDestTpCd = rsltPriRpScpArbKeyVO.getOrgDestTpCd();
			addChgTpCd = rsltPriRpScpArbKeyVO.getAddChgTpCd();
			n1stCmncDt = rsltPriRpScpArbKeyVO.getN1stCmncDt();
		}
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		//COMMBO LIST
        rcvDeTermCd			= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("RCV_DE_TERM_CD"), false);
        prcTrspModCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("PRC_TRSP_MOD_CD"), false);
        prcCgoTpCd 			= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("PRC_CGO_TP_CD"),false);
        ratUtCd 			= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("RAT_UT_CD"), false);      
        currCd 				= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("CURR_CD"), false);       
        custDefCd 			= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("CUST_DEF_CD"));  
     	
        // Excel Template File Key
        templateKey = (String)eventResponse.getCustomData("templateKey");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script language="javascript">
    var rcvDeTermCdComboValue = " |<%=rcvDeTermCd[0]%>";   
    var rcvDeTermCdComboText = " |<%=rcvDeTermCd[1]%>";
    
    var prcTrspModCdComboValue = " |<%=prcTrspModCd[0]%>";   
    var prcTrspModCdComboText = " |<%=prcTrspModCd[1]%>";
    
    var prcCgoTpCdComboValue = " |<%=prcCgoTpCd[0]%>";
    var prcCgoTpCdComboText = " |<%=prcCgoTpCd[1]%>";
       
    var ratUtCdComboValue = " |<%=ratUtCd[0]%>";   
    var ratUtCdComboText = " |<%=ratUtCd[1]%>";
    
    var currCdComboValue = "<%=currCd[0]%>";   
    var currCdComboText = "<%=currCd[1]%>";
     
    var custDefCdComboValue = " |<%=custDefCd[0]%>";   
    var custDefCdComboText = " |<%=custDefCd[1]%>";
    
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- developer performance	-->
<input type="hidden" name="svc_scp_cd" value="<%=svcScpCd %>">
<input type="hidden" name="prop_no" value="<%=propNo %>">
<input type="hidden" name="amdt_seq" value="<%=amdtSeq %>">
<input type="hidden" name="add_chg_tp_cd" value="<%=addChgTpCd %>">
<input type="hidden" name="org_dest_tp_cd" value="<%=orgDestTpCd %>">
<input type="hidden" name="n1st_cmnc_dt" value="<%=n1stCmncDt %>">
<input type="hidden" name="cd" >

<!-- OUTER - POPUP (S)tart -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>RFA Proposal Creation - Arbitrary [Load Excel]</span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_Template" id="btn_Template">Template</button><!--  -->
			<button type="button" class="btn_normal" name="btn_file" id="btn_file">Open File</button><!--  -->
			<button type="button" class="btn_normal" name="btn_check" id="btn_check">Check</button><!--  -->
			<button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!--  -->
			<button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_result">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
<div style="display:block;">
	<table id="mainTable"> 
		<tr>
			<td>
				<script type="text/javascript">ComSheetObject('sheet2');</script>
				<script type="text/javascript">ComSheetObject('sheet3');</script>
			</td>
		</tr>
	</table>
	</div>	
</form>

<form name="downform" action="/opuscntr/FileDownload" method="post" target="downifm">
<input type="hidden" name="<%=SiteConfigFactory.get("COM.FILE.DOWNLOAD.KEY") %>" value="<%=templateKey%>">
</form>
<iframe name="downifm" style="display:none;"></iframe>
