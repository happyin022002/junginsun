<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_SCG_3005.JSP
*@FileTitle  : UN No. Help
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/11
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.scg.dangerouscargorestriction.portrestriction.event.VopScg3005Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopScg3005Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "102";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.DangerousCargoRestriction.PortRestriction");
    String imdg_un_no = "";
    String imdg_un_no_seq = "";    
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopScg3005Event)request.getAttribute("Event");
		imdg_un_no      = event.getAttribute("imdg_un_no")==null?"":event.getAttribute("imdg_un_no").toString();
		imdg_un_no_seq  = event.getAttribute("imdg_un_no_seq")==null?"":event.getAttribute("imdg_un_no_seq").toString();		
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// add logic data extracting from server when loading initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript"">
	$(".header_fixed").css("display","none");
	$(".btn_gnb_hide").css("display","none");
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
<input type="hidden" name="pagerows" value="<%=pageRows%>">
<input type="hidden" name="imdg_un_no" value="<%=imdg_un_no%>">
<input type="hidden" name="imdg_un_no_seq" value="">
<div class="layer_popup_title">
<div class="page_title_area clear">
	<h2 class="page_title"><span>UN No. Help</span></h2>
	
	<div class="opus_design_btn">
		<button type="button" class="btn_normal" name="btn_ok" id="btn_ok">Ok</button><!--
		--><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
	</div>
</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_result">
		<div class="opus_design_grid" >
			<div class="opus_design_grid">
				<b>Amdt No.</b>&nbsp;&nbsp;<script>ComComboObject('imdg_amdt_no', 1, 60, 1);</script>
				<input type="hidden" name="crte_imdg_un_no" id="crte_imdg_un_no" />
			</div>
			<div class="opus_design_grid">
				<script type="text/javascript">ComSheetObject('sheet1');</script>
			</div>
		</div>
	</div>
</div>
<!-- popup_contens_area(E) -->

</form>