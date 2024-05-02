<%
/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESM_PRI_0002_005.jsp
 *@FileTitle  : S/C GOH Guideline Inquiry
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/06/10
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.scguideline.scgohchargeguideline.event.EsmPri000205Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.code.CodeUtil"%>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.clt.framework.component.util.code.CodeUtil"%>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%
	EsmPri000205Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.SCGuideline.SCGOHChargeGuideline");
	String[] currCd = null;
	String[] perCd = null;
	String[] barCd = null;
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmPri000205Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
				
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        currCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("currCd"), false);
        perCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("perCd"), false);
        barCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("barCd"), false ,"|","\t","getCode","getName");
	}catch(Exception e) {
		out.println(e.toString());
	}
	

	
%>

<script type="text/javascript">
	var currCdComboValue = " |<%=currCd[0]%>";
    var currCdComboText = " |<%=currCd[1]%>";
    var perCdComboValue = " |<%=perCd[0]%>";
    var perCdComboText = " |<%=perCd[1]%>";
    var barCdComboValue = " |<%=barCd[0]%>";
    var barCdComboText = " |<%=barCd[1]%>";
    
	function setupPage(){	
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />

<input type="hidden" name="svc_scp_cd" value="" id="svc_scp_cd" />
<input type="hidden" name="gline_seq" value="" id="gline_seq" />
<input type="hidden" name="cd" id="cd" />

<!-- opus_design_grid(S) -->
<div class="opus_design_title clear">
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_downexcel" 	id="btn_downexcel">Down Excel</button>
	</div>
	<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
<!-- opus_design_grid(E) -->
</form>