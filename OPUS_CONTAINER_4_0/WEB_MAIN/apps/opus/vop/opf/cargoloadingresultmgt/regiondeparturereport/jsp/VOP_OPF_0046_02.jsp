<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_OPF_0046_02.jsp
*@FileTitle  : RDR Creation ? Slot/WGT Util
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/17　
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.event.VopOpf004602Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopOpf004602Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.CargoLoadingResultMgt.RegionDepartureReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopOpf004602Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	function setupPage(){
		if (isInIframe()) {
			$('.header_fixed, .gnb_wrap').hide();
			$('.wrap, .gnb_wrap').css('padding-top', '0px');
		}
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
	
	function isInIframe() {
	    try {
	        return window.self !== window.top;
	    } catch (e) {
	        return true;
	    }
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />

<input type="hidden" name="vsl_cd" id="vsl_cd" />
<input type="hidden" name="voy_no" id="voy_no" />
<input type="hidden" name="dir_cd" id="dir_cd" />
<input type="hidden" name="region" id="region" />
<input type="hidden" name="port_cd" id="port_cd" />

<input type="hidden" name="crr_cd" id="crr_cd" />

	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="mainTable">
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn_Row_Add" id="btn_Row_Add" type="button">Row Add</button><!--
			--><button class="btn_normal" name="btn_Row_Insert" id="btn_Row_Insert" type="button">Row Insert</button><!--		
			--><button class="btn_normal" name="btn_Row_Copy" id="btn_Row_Copy" type="button">Row Copy</button><!--
			--><button class="btn_normal" name="btn_Row_Delete" id="btn_Row_Delete" type="button">Row Delete</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div> 
	<!-- opus_design_grid(E) -->     

</form>