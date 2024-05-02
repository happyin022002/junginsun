<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_5009.jsp
*@FileTitle : ESM_BKG_5009
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.07
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.08.07 김도완
* 1.0 Creation
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>

<%@ page import="org.apache.log4j.Logger" %>

<%
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
    String strCnt_cd        = "";
	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");

	String jpMsgTpCd = "";
	String userId = "";
	String errorCheck = "";
	String dateCheck = "";
	String inVvdCd = "";
	String inPodCd = "";
	String startRcvDt = "";
	String startRcvDt2 = "";
	String endRcvDt = "";
	String endRcvDt2 = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
        strCnt_cd = account.getCnt_cd();
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
			
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Welcome to OPUS!</title>
<script language="javascript" src="/opuscntr/rpt/script/common_rd.js"></script>
<script language="javascript">
    var strCntCd = "<%=strCnt_cd%>";
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} 
		loadPage();
	}
</script>
</head>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>US AMS: Transmission Status Cross-Check</span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_print" id="btn_print">Print</button><!--
			--><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_result">
		<div class="opus_design_RD"> 
			<script language="javascript">rdViewerObject('report1');</script>
	    </div>
	</div>
</div>

</form>			

		