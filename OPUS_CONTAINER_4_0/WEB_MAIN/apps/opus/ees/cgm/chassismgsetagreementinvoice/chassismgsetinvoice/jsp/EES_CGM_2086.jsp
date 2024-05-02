<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_2086.jsp
*@FileTitle  : Agreement Matching
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event.EesCgm2086Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesCgm2086Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.ChassisMgsetAgreementInvoice.ChassisMgsetInvoice");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EesCgm2086Event)request.getAttribute("Event");
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
<script language="javascript">
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
<input type="hidden" name ="eq_knd_cd" value="Z">

<input type="hidden" name="agmt_ofc_cty_cd">
<input type="hidden" name="agmt_seq">

	<div class="page_title_area clear">
	    
	    <h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	         
	    <div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_retrieve">Retrieve</button>
			<button type="button" class="btn_normal" name="btn_Save"   id="btn_detail">Save</button>
	    </div>
	    
	    <div class="location">
	        <span id="navigation"></span>
	    </div>
	</div>

	<div class="wrap_result">
		<div class="opus_design_grid">
			<div class="opus_design_btn">
			    <button type="button" class="btn_normal" name="btn_Add" id="btn_add">Row Add</button>
			    <button type="button" class="btn_normal" name="btn_Delete" id="btn_delete">Row Delete</button>
			</div>
				<script language="javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>

</form>