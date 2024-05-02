<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_2019_01.jsp
*@FileTitle  : RFA Proposal Inquiry - Special Note 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/28
=========================================================
*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.rfaproposal.rfanoteproposal.event.EsmPri201901Event"%>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri201901Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error from Server
	String strErrMsg = "";						//Error Message
	int rowCount	 = 0;						//Number of DB ResultSet List
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String[] srcInfoCd = null;		    //SOURCE
	String[] prcProgStsCd = null;		//STATUS
	String[] rtApplTpCd = null;		    //APLICATION
	String[] payTermCd = null;    		//PAY TERM
	String[] bkgHngrBarTpCd = null;    	//BAR TYPE
	String[] bkgCnlTzCd = null;    		//CANAL
	String[] bkgEsvcTpCd = null;    	//B/I
	Logger log = Logger.getLogger("com.clt.apps.SCProposal.SCNoteProposal");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EsmPri201901Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		// Adding Logic extracting data from server when loading initial window ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		//COMMBO LIST
		srcInfoCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("SRC_INFO_CD"), false);
		prcProgStsCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("PRC_PROG_STS_CD"), false);
        rtApplTpCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("RT_APPL_TP_CD"), false);
        payTermCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("PAY_TERM_CD"), false);      
        bkgHngrBarTpCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("BKG_HNGR_BAR_TP_CD"), false);  
        bkgCnlTzCd 	    = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("BKG_CNL_TZ_CD"), false);
        bkgEsvcTpCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("BKG_ESVC_TP_CD"), false);  
	} catch(Exception e) {
		out.println(e.toString());
	}
%>


<script type="text/javascript">
	var srcInfoCdComboValue = "<%=srcInfoCd[0]%>";
    var srcInfoCdComboText = "<%=srcInfoCd[1]%>";
    var prcProgStsCdComboValue = "<%=prcProgStsCd[0]%>";
    var prcProgStsCdComboText = "<%=prcProgStsCd[1]%>";
	var rtApplTpCdComboValue = " |<%=rtApplTpCd[0]%>";
    var rtApplTpCdComboText = " |<%=rtApplTpCd[1]%>";
    var payTermCdComboValue = " |<%=payTermCd[0]%>";   
    var payTermCdComboText = " |<%=payTermCd[1]%>";
    var bkgHngrBarTpCdComboValue = " |<%=bkgHngrBarTpCd[0]%>";   
    var bkgHngrBarTpCdComboText = " |<%=bkgHngrBarTpCd[1]%>";
    var bkgCnlTzCdComboValue = " |<%=bkgCnlTzCd[0]%>";   
    var bkgCnlTzCdComboText = " |<%=bkgCnlTzCd[1]%>";
    var bkgEsvcTpCdComboValue = " |<%=bkgEsvcTpCd[0]%>";   
    var bkgEsvcTpCdComboText = " |<%=bkgEsvcTpCd[1]%>";
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="pagerows" name="pagerows" type="hidden" />
<input id="prop_no" name="prop_no" type="hidden" />
<input id="amdt_seq" name="amdt_seq" type="hidden" />
<input id="svc_scp_cd" name="svc_scp_cd" type="hidden" />
<input id="cd" name="cd" type="hidden" />
<input id="note_seq" name="note_seq" type="hidden" />
<input id="note_ctnt_seq" name="note_ctnt_seq" type="hidden" />
<input id="note_conv_mapg_id" name="note_conv_mapg_id" type="hidden" />
<input id="note_tp_cd" name="note_tp_cd" value="P" type="hidden" />

	<!-- opus_design_grid(S) -->
	     <div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
	    </div>
	<!-- opus_design_grid(E) -->
	
	<!-- opus_design_grid(S) -->
	     <div class="opus_design_grid">
			<br/>
			<script type="text/javascript">ComSheetObject('sheet2');</script>
	    </div>
	    
	    <div class="opus_design_grid">
	    	<table class="line_bluedot"><tr><td></td></tr></table>
	    </div>
	<!-- opus_design_grid(E) -->
	
	<!-- opus_design_grid(S) -->
		<h3 class="title_design">Conversion</h3>		
	     <div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet3');</script>
	    </div>
	<!-- opus_design_grid(E) -->
</form>