<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0911.jsp
*@FileTitle  : Service Order Creation screen - Chassis or Genset
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/04
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.trs.chassisgensetsomanage.chassisgensetsomanage.event.EsdTrs0014Event"%>

<%
	EsdTrs0014Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error occurred on the server
	DBRowSet rowSet	  = null;							   //DB ResultSet
	String strErrMsg = "";								 //Error message
	int rowCount	 = 0;								  //List the number of DB ResultSet

	try {

		event = (EsdTrs0014Event)request.getAttribute("Event");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
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
<form name="form" >
<input	type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="iPage" id="iPage">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><span>Chassis & Genset File Import</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
    <div class="opus_design_btn">
		   <button type="button" class="btn_accent"  name="btn_close" id="btn_close">Close</button>
    </div>
	 <!-- opus_design_btn(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="mainTable" >	
		<div class="opus_design_btn">
			<button class="btn_normal" type="button"  id="btng_fileimport" name="btng_fileimport">File Import</button><!-- 
		 --><button class="btn_normal" type="button"  id="btng_delete" name="btng_delete">Delete</button><!-- 
		 --><button class="btn_normal" type="button"  id="btng_verify" name="btng_verify">Verify</button><!-- 
		 --><button class="btn_normal" type="button"  id="btng_apply" name="btng_apply" >Apply</button>
		</div>			
		 <script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>