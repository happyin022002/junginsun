<%--
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TRS_0927.jsp
*@FileTitle : Confirmation Message Send Popup
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.event.EsdTrs0028Event"%>
<%
	SignOnUserAccount account = null;
	EsdTrs0028Event  event = null;	
	Exception serverException   = null;
	DBRowSet rowSet	  = null;
	String strErrMsg = "";
	int rowCount	 = 0;
	String today = DateTime.getFormatString("yyMMdd");
	try {
		account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		event = (EsdTrs0028Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		}
		loadPage();
	}
	var user_name = "<%=account.getUsr_nm()%>";
</script>


<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="ctrl_ofc_cd" value="<%=account.getOfc_cd()%>">
<input type="hidden" name="ctrl_user_id" value="<%=account.getUsr_id()%>">
<input type="hidden" name="f_trsp_so_ofc_cty_cd" value="">
<input type="hidden" name="f_trsp_so_seq" value="">
<input type="hidden" name="current_time" value="<%=today%>">

	<div class="layer_popup_title">
		<div class="page_title_area clear">
			<!-- page_title(S) -->
			<h2 class="page_title"><span>Confirmation Message Send</span></h2>
			<!-- page_title(E) -->
			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_close" id="btn_close">Close</button><!-- 
			--></div>
			<!-- opus_design_btn(E) -->
		</div>
	</div>
	<div class="layer_popup_contents">
		<div class="wrap_result">
			<div class="opus_design_grid">
				<!-- opus_design_btn (S) -->
				<div class="opus_design_btn">
					<button class="btn_accent" type="button" name="btng_rowadd" id="btng_rowadd">Row Add</button><!--
					--><button class="btn_normal" type="button" name="btng_delete" id="btng_delete">Delete</button><!--
					--><button class="btn_normal" type="button" name="btng_send" id="btng_send">Send</button><!--
					--></div>
				<!-- opus_design_btn (E) -->
				<script type="text/javascript">ComSheetObject('sheet');</script>
			</div>
		</div>
	</div>
</form>