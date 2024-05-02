<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec All Rights Reserved
*@FileName : esm_bkg_0976.jsp
*@FileTitle : RemarkTemplate
*@author : CLT
*@version : 1.0
*@since : 2014.04.22
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.event.EsmBkg0976Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0976Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			// error from server
	String strErrMsg = "";						// error message
	int rowCount	 = 0;						// count of DB resultSET list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.BookingMasterData.UserSetupMgt");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmBkg0976Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>


<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- 제목 -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Remark Template</span></h2>
		
		<div class="opus_design_btn">		
		   <button type="button" class="btn_normal" name="btn_RowAdd">Row Add</button><!--  
		   --><button type="button" class="btn_normal" name="btn_Delete">Delete</button><!--
		   --><button type="button" class="btn_normal" name="btn_Save">Save</button><!--
		   --><button type="button" class="btn_normal" name="btn_Select">Select</button><!--
		   --><button type="button" class="btn_normal" name="btn_Close">Close</button>
   		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<!-- 시트영역 -->
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">	
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->
	</div>
	<!-- 시트영역 -->
</div>
</form>
