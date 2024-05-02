<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ESM_FMS_0069.jsp
*@FileTitle  : Item Detail Management 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/16
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.event.EsmFms0069Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmFms0069Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error from Server
	String strErrMsg = "";						//Error Message

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.TimeCharterInOutAccounting.TCharterIOBasicRegister");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmFms0069Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// Adding Logic extracting data from server when loading initial window ..
		//GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
	}catch(Exception e) {
		log.error("err " + e.toString(), e);
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
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" 	id="btn_retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_new" 		id="btn_new">New</button><!--
		--><button type="button" class="btn_normal" name="btn_save" 		id="btn_save">Save</button>
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->
<!-- opus_design_grid(S) -->
<div class="wrap_result" >
	<div class="opus_design_grid clear" style="width:100%">
		<div class="opus_design_btn" >
			<button type="button" class="btn_normal" name="btn_add" 	id="btn_add">Row Add</button><!--
			--><button type="button" class="btn_normal" name="btn_ins" 	id="btn_ins">Row Ins</button><!--
			--><button type="button" class="btn_normal" name="btn_del" 	id="btn_del">Row Del</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
<!-- opus_design_grid(E) -->
</form>