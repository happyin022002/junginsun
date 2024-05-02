<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_PRI_0008.jsp
*@FileTitle  : Standard Note Conversion Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/16
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.scguideline.scbasicstandardnoteguideline.event.EsmPri0008Event"%>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri0008Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;         //error from server
	String strErrMsg = ""; //error message
	int rowCount = 0; //count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	String effDt = "";
	String expDt = "";
	String svcScpCd = "";
	String noteHdrSeq = "";
	String prcCtrtTpCd = "";
	String noteConvMapgId = "";
	
	String[] ruleApplChgTpCd = null;	//TYPE
	String[] rtApplTpCd = null;		    //APLICATION
	String[] bkgPrcCgoTpCd = null;    	//CARGO TYPE
	String[] rtOpCd = null;    			//CAL.
	String[] payTermCd = null;    		//PAY TERM
	String[] bkgUsaSvcModCd = null;    	//US SVC MODE
	String[] bkgRcvTermCd = null;    	//RECEIVING TERM
	String[] bkgDeTermCd = null;    	//DELIVERY TERM
	String[] convPrcCgoTpCd = null;    	//CARGO TYPE(in S/C)
	
	String[] bkgRatUtCd = null;			//PER TYPE
	String[] currCd = null;				//CURRENCY
	String[] convRatUtCd = null;		//PER TYPE( IN S/C)
	String[] bkgScgGrpCmdtCd = null;	//GRI Commodity
	String[] ruleCd = null;				//NOTE CONVERSION RULE CODE 
	String[] chargeCd = null;    		//SCOPE CHARGE CODE LIST

	
	Logger log = Logger.getLogger("com.clt.apps.SCGuideline.SCBasicStandardNoteGuideline");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmPri0008Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		 
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		//PARAM
		effDt = JSPUtil.getNull(request.getParameter("eff_dt"));
		expDt = JSPUtil.getNull(request.getParameter("exp_dt"));
		svcScpCd = JSPUtil.getNull(request.getParameter("svc_scp_cd"));
		noteHdrSeq = JSPUtil.getNull(request.getParameter("note_hdr_seq"));
		prcCtrtTpCd = JSPUtil.getNull(request.getParameter("prc_ctrt_tp_cd"));
		noteConvMapgId = JSPUtil.getNull(request.getParameter("note_conv_mapg_id"));
		
		//COMMBO LIST
		ruleApplChgTpCd = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("RULE_APPL_CHG_TP_CD"), false);
        rtApplTpCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("RT_APPL_TP_CD"), false);
        bkgPrcCgoTpCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("BKG_PRC_CGO_TP_CD"), false);       
        rtOpCd 			= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("RT_OP_CD"));      
        payTermCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("PAY_TERM_CD"), false);   
        bkgUsaSvcModCd	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("BKG_USA_SVC_MOD_CD"), false);
        bkgRcvTermCd	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("BKG_RCV_TERM_CD"), false);
        bkgDeTermCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("BKG_DE_TERM_CD"), false);  
        convPrcCgoTpCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("CONV_PRC_CGO_TP_CD"), false); 
        
        bkgRatUtCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("BKG_RAT_UT_CD"), false);      
        currCd 			= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("CURR_CD"), false);   
        convRatUtCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("CONV_RAT_UT_CD"), false);      
        bkgScgGrpCmdtCd = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("BKG_SCG_GRP_CMDT_CD"), false);       
        ruleCd 			= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("RULE_CD"));       
        chargeCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("CHARGE_CD"));
 
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script language="javascript">
	var ruleApplChgTpCdComboValue = " |<%=ruleApplChgTpCd[0]%>";
    var ruleApplChgTpCdComboText = " |<%=ruleApplChgTpCd[1]%>";
    
	var rtApplTpCdComboValue = " |<%=rtApplTpCd[0]%>";
    var rtApplTpCdComboText = " |<%=rtApplTpCd[1]%>";

    var bkgPrcCgoTpCdComboValue = " |<%=bkgPrcCgoTpCd[0]%>";
    var bkgPrcCgoTpCdComboText = " |<%=bkgPrcCgoTpCd[1]%>";
        
    var rtOpCdComboValue = "<%=rtOpCd[0]%>";   
    var rtOpCdComboText = "<%=rtOpCd[1]%>";

    var payTermCdComboValue = " |<%=payTermCd[0]%>";   
    var payTermCdComboText = " |<%=payTermCd[1]%>";
    
    var bkgUsaSvcModCdComboValue = " |<%=bkgUsaSvcModCd[0]%>";   
    var bkgUsaSvcModCdComboText = " |<%=bkgUsaSvcModCd[1]%>";
    
    var bkgRcvTermCdComboValue = " |<%=bkgRcvTermCd[0]%>";   
    var bkgRcvTermCdComboText = " |<%=bkgRcvTermCd[1]%>";
    
    var bkgDeTermCdComboValue = " |<%=bkgDeTermCd[0]%>";   
    var bkgDeTermCdComboText = " |<%=bkgDeTermCd[1]%>";
    
    var convPrcCgoTpCdComboValue = " |<%=convPrcCgoTpCd[0]%>";   
    var convPrcCgoTpCdComboText = " |<%=convPrcCgoTpCd[1]%>";
    
    var bkgRatUtCdComboValue = " |<%=bkgRatUtCd[0]%>";   
    var bkgRatUtCdComboText = " |<%=bkgRatUtCd[1]%>";
    
    var currCdComboValue = "<%=currCd[0]%>";   
    var currCdComboText = "<%=currCd[1]%>";
    
    var convRatUtCdComboValue = " |<%=convRatUtCd[0]%>";   
    var convRatUtCdComboText = " |<%=convRatUtCd[1]%>";
    
    var bkgScgGrpCmdtCdComboValue = " |<%=bkgScgGrpCmdtCd[0]%>";   
    var bkgScgGrpCmdtCdComboText = " |<%=bkgScgGrpCmdtCd[1]%>";
        
    var chargeRuleCdComboValue = " |<%=(chargeCd[0].length()>0)? ruleCd[0]+"|"+chargeCd[0]:ruleCd[0]%>";   
    var chargeRuleCdComboText = " |<%=(chargeCd[0].length()>0)? ruleCd[1]+"|"+chargeCd[1]:ruleCd[1]%>";  
    
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
  
<input type="hidden" name="cd">
<input type="hidden" name="svc_scp_cd" value="<%=svcScpCd%>">
<input type="hidden" name="eff_dt" value="<%=effDt%>">
<input type="hidden" name="exp_dt" value="<%=expDt%>">
<input type="hidden" name="note_hdr_seq" value="<%=noteHdrSeq%>">
<input type="hidden" name="prc_ctrt_tp_cd" value="<%=prcCtrtTpCd%>">
<input type="hidden" name="note_conv_mapg_id" value="<%=noteConvMapgId%>">

<!-- OUTER - POPUP (S)tart -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Standard Note Conversion Creation</span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--  -->
			<button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!--  -->
			<button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
	</div>
</div>
	
<div class="layer_popup_contents">
	<div class="wrap_search">
		<div class="opus_design_inquiry wFit">
			<table class="search" border="0">
				<tr class="h23">
					<td>
					<textarea name="note_ctnt" class="input2" style="width:784px; height:100px;word-break:break-all;" readonly="true"><%=JSPUtil.getNull(request.getParameter("note_ctnt"))%></textarea></td>
				</tr>
			</table>
		</div>
	</div>
	<div class="wrap_result">
		<div class="opus_design_grid" >
			<div class="opus_design_grid">				
				<!-- opus_grid_btn(S) -->
				<div class="opus_design_btn">
					<button type="button" class="btn_normal" name="btn_copy" id="btn_copy">Copy</button>
					<button type="button" class="btn_normal" name="btn_paste" id="btn_paste">Paste</button>
					<button type="button" class="btn_normal" name=btn_rowadd id="btn_rowadd">Row Add</button>
					<button type="button" class="btn_normal" name="btn_rowcopy" id="btn_rowcopy">Row Copy</button>
					<button type="button" class="btn_normal" name="btn_delete" id="btn_delete">Delete</button>
				</div>
				<!-- opus_grid_btn(E) -->
			</div>
			<script language="javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
</div>
		
</form>