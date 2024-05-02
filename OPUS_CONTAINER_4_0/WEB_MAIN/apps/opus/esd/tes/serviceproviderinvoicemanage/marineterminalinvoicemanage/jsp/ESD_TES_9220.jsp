<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TES_9220.jsp
*@FileTitle  : Get Container List Pop Up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/27
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event.EsdTes9220Event"%>
<%

	Exception serverException   = null;			//Server Exception
	DBRowSet rowSet	  = null;					//DB ResultSet
	String strErrMsg = "";						//Error Message
	int rowCount	 = 0;						//DB ResultSet Count

	try {
	   //SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   //userId=account.getUsr_id();
	   //userAuth=account.getAuth();

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{

		} // end else
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
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="vndr_seq" id="vndr_seq" />
<input type="hidden" name="yd_cd" id="yd_cd" />

<!-- layer_popup_title(S) -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title">Accumulate Vol. Period Selection</h2>
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_save" id="btn_save">Save</button><!--
		 --><button type="button" class="btn_normal" name="btn_oK" id="btn_oK">OK</button><!--
   		 --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
	</div>
</div>
<!-- layer_popup_contents(S) -->
<div class="layer_popup_contents">
	<div class="wrap_result" >
		<div class="opus_design_grid">		
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
</div>
</form>