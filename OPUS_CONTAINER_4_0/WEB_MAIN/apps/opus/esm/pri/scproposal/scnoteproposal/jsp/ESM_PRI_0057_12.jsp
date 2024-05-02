<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0057_12.jsp
*@FileTitle : Amendment History Inquiry - Special Note
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
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.scproposal.scnoteproposal.event.EsmPri005712Event"%>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri005712Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";

	String[] noteClssCd = null;		//NOTE CLASSIFICATION CODE
	String[] srcInfoCd = null;		//SOURCE
	String[] prcProgStsCd = null;	//STATUS
	
	Logger log = Logger.getLogger("com.clt.apps.SCProposal.SCNoteProposal");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmPri005712Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		//COMMBO LIST
		noteClssCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("NOTE_CLSS_CD"), false);
		srcInfoCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("SRC_INFO_CD"), false);
		prcProgStsCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("PRC_PROG_STS_CD"), false);
       	
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>S/C Proposal Special Note Creation</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	var srcInfoCdComboValue = "<%=srcInfoCd[0]%>";
    var srcInfoCdComboText = "<%=srcInfoCd[1]%>";
    
    var prcProgStsCdComboValue = "<%=prcProgStsCd[0]%>";
    var prcProgStsCdComboText = "<%=prcProgStsCd[1]%>";

	var noteClssCdComboValue = " |<%=noteClssCd[0]%>";
    var noteClssCdComboText = " |<%=noteClssCd[1]%>";

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body>
<form name="form">
<input type="hidden" name="f_cmd" 						id="f_cmd">
<input type="hidden" name="pagerows" 					id="pagerows">
<input type="hidden" name="prop_no" 					id="prop_no">
<input type="hidden" name="amdt_seq" 					id="amdt_seq">
<input type="hidden" name="svc_scp_cd" 					id="svc_scp_cd">
<input type="hidden" name="con_chk" 					id="con_chk">
<input type="hidden" name="cd" 							id="cd">
<input type="hidden" name="note_seq" 					id="note_seq">
<input type="hidden" name="note_tp_cd" value="P" 		id="note_tp_cd">
<input type="hidden" name="lgcy_if_flg" 				id="lgcy_if_flg">

<input type="hidden" name="master_del_chk" value="N" 	id="master_del_chk">

<!-- opus_design_grid(S) -->
<div class="opus_design_grid" name="mainTable" id="mainTable">
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" 	id="btn_retrieve">Retrieve</button>
	</div>
	<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
<div class="opus_design_grid" name="mainTable" id="mainTable">
	<script type="text/javascript">ComSheetObject('sheet2');</script>
</div>
<!-- opus_design_grid(E) -->
</form>
</body>
</html>