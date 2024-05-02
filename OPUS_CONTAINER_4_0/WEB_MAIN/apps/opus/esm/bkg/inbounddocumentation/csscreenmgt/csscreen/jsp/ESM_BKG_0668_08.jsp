<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0668_08.jsp
*@FileTitle : In-bound C/S Screen US
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.event.EsmBkg066808Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg066808Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.CsScreenMgtSC.CsScreenBC");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmBkg066808Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script language="javascript">
	var strUsr_id    = "<%=strUsr_id%>";

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if

		loadPage();
	}
</script>
</head>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">


<input type='hidden' name ='bl_no' value = "">
<input type='hidden' name ='bkg_no' value = "<%=JSPUtil.getNull(request.getParameter("bkg_no"))%>">
<div class="wrap_result" >
		
		<div class="layout_wrap">
			<div class="layout_vertical_2 mar_rgt_8" style="width:992px">
				<div class="opus_design_grid" >
					<div class="grid_option_leftBreakLine"><h3 class="title_design"> S/O Status per Container</h3> </div>
					<script type="text/javascript">ComSheetObject('t5sheet1');</script>
				</div>
			</div>
			<div class="layout_vertical_2" style="width:256px">
				<div class="opus_design_grid" >
					<div class="grid_option_leftBreakLine"><h3>&nbsp;</h3></div>
					<script type="text/javascript">ComSheetObject('t5sheet2');</script>
				</div>
			</div>
		</div>
		
		
		<div class="opus_design_grid" >
			<div class="grid_option_leftBreakLine"><h3 class="title_design">W/O Detail(s) per Container</h3> </div>
			<script type="text/javascript">ComSheetObject('t5sheet3');</script>
			<script type="text/javascript">ComSheetObject('t5sheet4');</script>
		</div>


</div>

</form>
