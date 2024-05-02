<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_3508.jsp
*@FileTitle  : Tariff Rule Summary Print
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/08
=========================================================*/
%>     
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.tariff.tariffrule.event.EsmPri3508Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri3508Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strTrfPfxCd		= "";
	String strTrfNo			= "";
	String strAmdtSeq		= "";
	String strTrfRuleNo		= "";
	
	Logger log = Logger.getLogger("com.clt.apps.Tariff.TariffRule");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmPri3508Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		strTrfPfxCd = JSPUtil.getNull(request.getParameter("trf_pfx_cd"));
		strTrfNo    = JSPUtil.getNull(request.getParameter("trf_no"));
		strAmdtSeq  = JSPUtil.getNull(request.getParameter("amdt_seq"));
		strTrfRuleNo  = JSPUtil.getNull(request.getParameter("trf_rule_no"));
				
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script language="javascript" src="/opuscntr/rpt/script/common_rd.js"></script>
<script language="javascript">
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
<input type="hidden" name="trf_pfx_cd" value="<%=strTrfPfxCd%>">
<input type="hidden" name="trf_no" value="<%=strTrfNo%>">
<input type="hidden" name="amdt_seq" value="<%=strAmdtSeq%>">
<input type="hidden" name="trf_rule_no" value="<%=strTrfRuleNo%>">

<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Tariff Rule Summary Print</span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_result">
		<div class="opus_design_RD"> 
			<script type="text/javascript">rdViewerObject('report1');</script>
    	</div>
    </div>
</div>
</form>