<%
/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : VOP_SCG_0070.jsp
 *@FileTitle : Segregation Group - Creation
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
<%@ page import="com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg0070Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopScg0070Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.SpecialCargoMasterDataMgt.SpecialCargoMasterDataMgt");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (VopScg0070Event)request.getAttribute("Event");
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
<input type="hidden" name="imdg_segr_grp_no">
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn1_Retrieve" 		id="btn1_Retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn1_Save" 			id="btn1_Save">Save</button>			
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
	
</div>
<!-- page_title_area(E) -->

<!-- wrap_result(S) -->
<div class="wrap_result">
<!-- layout_wrap(S) -->
<div class="layout_wrap">
<!-- layout_vertical_2(S) -->
<div class="layout_vertical_2" style="width:50%">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" >
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn2_Row_Add" 		id="btn2_Row_Add">Row Add</button><!-- 
			 --><button type="button" class="btn_normal" name="btn2_Row_Insert" 			id="btn2_Row_Insert">Row Insert</button><!-- 
			 --><button type="button" class="btn_normal" name="btn2_Row_Copy" 			id="btn2_Row_Copy">Row Copy</button><!-- 
			 --><button type="button" class="btn_normal" name="btn2_Row_Delete" 			id="btn2_Row_Delete">Row Delete</button>			
		</div>
		<!-- opus_design_btn(E) -->
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>
<!-- layout_vertical_2(E) -->

<!-- layout_vertical_2(S) -->
<div class="layout_vertical_2" style="width:48%; float:right;">
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
	<table><tr><td>
	<h3 class="title_design" id="subTitle">Heavy metals and their salts (including their organometallic compounds)</h3></td>
		<!-- opus_design_btn(S) -->
		<td><div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn2_Row_Add2" 		id="btn2_Row_Add2">Row Add</button><!-- 
			 --><button type="button" class="btn_normal" name="btn2_Row_Insert2" 			id="btn2_Row_Insert2">Row Insert</button><!--  
			 --><button type="button" class="btn_normal" name="btn2_Row_Delete2" 			id="btn2_Row_Delete2">Row Delete</button>			
		</div>
	</td></tr></table>
		<!-- opus_design_btn(E) -->
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>
<!-- layout_vertical_2(E) -->
</div>
<!-- layout_wrap(E) -->
</div>
<!-- wrap_result(E) -->
</form>