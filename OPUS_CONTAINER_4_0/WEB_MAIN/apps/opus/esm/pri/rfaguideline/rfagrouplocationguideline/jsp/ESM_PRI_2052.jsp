<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_2052.jsp
*@FileTitle  : RFA Guideline Creation - Location Group [Load Excel]
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/15
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
<%@ page import="com.clt.apps.opus.esm.pri.rfaguideline.rfagrouplocationguideline.event.EsmPri2052Event"%>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="com.clt.framework.core.config.SiteConfigFactory"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri2052Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String[] orgDestTpCd = null;	//ORI/DEST
	
	String templateKey = null;
	
	Logger log = Logger.getLogger("com.clt.apps.RFAGuideline.RFAGroupLocationGuideline");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmPri2052Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		//COMMBO LIST
		orgDestTpCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("ORG_DEST_TP_CD"), false);
	    // Excel Template File Key
	    templateKey = (String)eventResponse.getCustomData("templateKey");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
	var orgDestTpCdComboValue = "<%=orgDestTpCd[0]%>";
    var orgDestTpCdComboText = "<%=orgDestTpCd[1]%>";
    
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
<input type="hidden" name="svc_scp_cd" value="<%=StringUtil.xssFilter(request.getParameter("svc_scp_cd"))%>" id="svc_scp_cd" />
<input type="hidden" name="gline_seq" value="<%=StringUtil.xssFilter(request.getParameter("gline_seq"))%>" 	id="gline_seq" />
<input type="hidden" name="cd" id="cd" />
<div class="layer_popup_title">
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><span >RFA Guideline Creation - Location Group [Load Excel]</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_normal" name="btn_Template" 	id="btn_Template">Template</button>
		<button type="button" class="btn_normal" name="btn_file" 		id="btn_file">Open File</button>
		<button type="button" class="btn_normal" name="btn_save" 		id="btn_save">Save</button>
		<button type="button" class="btn_normal" name="btn_check" 		id="btn_check">Check</button>
		<button type="button" class="btn_normal" name="btn_close" 		id="btn_close">Close</button> 
	 </div>
	<!-- opus_design_btn(E) -->
</div>
</div>
<div class="layer_popup_contents">
<!-- page_title_area(E) -->
<div class="wrap_result">
	<div class="opus_design_gird" >		
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	
	<div style="display:none;">
		<div class="opus_design_gird" >
			<script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>
	</div>
	
	<div style="display:none;">
		<div class="opus_design_gird" >
			<script type="text/javascript">ComSheetObject('sheet3');</script>
		</div>
	</div>
</div>
</div>
</form>
<form name="downform" action="/opuscntr/FileDownload" method="post" target="downifm">
	<input type="hidden" name="<%=SiteConfigFactory.get("COM.FILE.DOWNLOAD.KEY") %>" value="<%=templateKey%>">
</form>
<iframe name="downifm" style="display:none;"></iframe>
</body>