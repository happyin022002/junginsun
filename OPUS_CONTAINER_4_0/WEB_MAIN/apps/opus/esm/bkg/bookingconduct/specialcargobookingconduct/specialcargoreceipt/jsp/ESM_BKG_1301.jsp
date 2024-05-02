<%/*=========================================================
*Copyright(c) 2015 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1301.jsp
*@FileTitle  : DOT References
*@author     : CLT
*@version    : 1.0
*@since      : 2015/11/17
=========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.event.EsmBkg1301Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1301Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.SpecialCargoBookingConduct.SpecialCargoReceipt");
	String dot_exp_no			= "";
	String dot_spcl_apro_no		= "";
	String dot_auth_no			= "";
	String pop_type				= "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		dot_exp_no		= JSPUtil.getParameter(request, "dot_exp_no");
		dot_spcl_apro_no= JSPUtil.getParameter(request, "dot_spcl_apro_no");
		dot_auth_no		= JSPUtil.getParameter(request, "dot_auth_no");
		pop_type		= JSPUtil.getParameter(request, "pop_type");


		event = (EsmBkg1301Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
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
<input type="hidden" name="dot_exp_no" id="dot_exp_no" value="<%=dot_exp_no%>"/>
<input type="hidden" name="dot_spcl_apro_no" id="dot_spcl_apro_no" value="<%=dot_spcl_apro_no%>"/>
<input type="hidden" name="dot_auth_no" id="dot_auth_no" value="<%=dot_auth_no%>"/>
<input type="hidden" name="pop_type" id="pop_type" value="<%=pop_type%>"/>

<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>DOT References:</span></h2>
		
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn_ok" id="btn_ok" type="button">OK</button><!--
			--><button class="btn_normal" name="btn_close" id="btn_close" type="button">Close</button><!--
			--></div>
	</div>
</div>

<div class="wrap_result">
<!-- opus_design_grid(S) -->
<div>	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
</div>
<!-- opus_design_grid(E) -->

</form>
