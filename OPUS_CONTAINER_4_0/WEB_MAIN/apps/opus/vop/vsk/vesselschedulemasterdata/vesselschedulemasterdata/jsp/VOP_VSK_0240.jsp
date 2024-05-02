<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_VSK_0240.jsp
*@FileTitle  : Service Provider Group Registration (Pop-up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/21
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.event.VopVsk0240Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk0240Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB ResultSet list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.VesselScheduleMasterData.VesselScheduleMasterData");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopVsk0240Event)request.getAttribute("Event");
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
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="vndr_seq" id="vndr_seq" />
<input type="hidden" name="eventNav" id="eventNav" />
<input type="hidden" name="delFlg" id="delFlg" />
<!-- page_title_area(S) -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><span>Service Provider Group Registration</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_close" 	id="btn_close">Close</button><!--  
		--></div>
		<!-- opus_design_btn(E) -->
	
		<!-- page_location(S) -->
		<div class="location">
			<!-- location 내용 동적생성 (별도 코딩 불필요) -->
			<span id="navigation"></span>
		</div>
	</div>
</div>
<!-- page_title_area(E) -->

<div class="layer_popup_contents">
	<div class="wrap_result">
	<div class="opus_design_grid">
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_add" 	id="btn_add">Row Add</button><!--  
		--><button type="button" class="btn_normal" name="btn_del"  	id="btn_del">Row Delete</button><!-- 
		 --></div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" 	id="btn_retrieve">Retrieve</button><!--  
	--><button type="button" class="btn_normal" name="btn_save"  		id="btn_save">Save</button><!-- 
	--><button type="button" class="btn_normal" name="btn_new"  		id="btn_new">New</button><!-- 
	 --></div>
	 	    
	    <div class="layout_vertical_2" style="width:39%;">
	        <!-- opus_design_grid(S) -->	       
	        <div class="opus_design_grid">
	            <script type="text/javascript">ComSheetObject('sheet2');</script>
	        </div>
	        <!-- opus_design_grid(E) -->
	    </div>
	    
	    <div class="layout_vertical_2 align_center mar_left_8" style="width:4%;padding-top:100px;">
	    	  <button type="button" class="btn_right" name="btn_rAdd" 	id="btn_rAdd"></button><!-- 
	    	   --><br><!-- 
	    	   --><br><!-- 
	    	    --><button type="button" class="btn_left" name="btn_rDel" 	id="btn_rDel"></button>
	    </div>
	    	    
	    <div class="layout_vertical_2" style="width:56%;">
	        <!-- opus_design_grid(S) -->
	        <div class="opus_design_grid">	        	
	            <script type="text/javascript">ComSheetObject('sheet3');</script>
	        </div>
	        <!-- opus_design_grid(E) -->
	    </div>
	
</div>
<!-- layout_wrap(E) -->
</div>
</form>