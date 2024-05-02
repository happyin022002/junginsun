<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : VOP_VSK_0228.jsp
*@FileTitle : Lane Registration
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/13
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.event.VopVsk0228Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk0228Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB ResultSet list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.vesselschedulemasterdata.vesselschedulemasterdata");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopVsk0228Event)request.getAttribute("Event");
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

	    loadPage();
    }

</script>

<form name="form">
<input type="hidden" name="f_cmd">

<input type="hidden" name="tmp_vsl_slan_cd" id="tmp_vsl_slan_cd">
<input type="hidden" name="tmp_vsl_slan_nm" id="tmp_vsl_slan_nm">
<input type="hidden" name="usr_id" value="<%=strUsr_id%>" id="usr_id"> 


<!-- popup_title_area(S) -->
 <div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>&nbsp;Lane Registration  </span></h2>
		<!-- page_title(E) -->
			
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_RowAdd" id="btn_RowAdd">Row&nbsp;Add</button><!--
	        --><button type="button" class="btn_normal" name="btn_Delete" id="btn_Delete">Row&nbsp;Delete</button><!--
	   		--><button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button><!--
	    	--><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->	
	</div>
	<!-- page_title_area(E) -->
</div>
<!-- popup_title_area(E) -->

<!-- popup_contens_area(S) -->
<div class="layer_popup_contents" style="overflow:hidden;">
	 <div class="wrap_result">
		 <div class="opus_design_grid">
		 	<script type="text/javascript">ComSheetObject('sheet1');</script>
		 </div>	
  </div>
</div>
	
</form>			
