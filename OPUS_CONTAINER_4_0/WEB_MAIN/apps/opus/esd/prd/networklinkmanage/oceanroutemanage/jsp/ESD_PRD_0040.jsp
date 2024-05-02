<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_PRD_0040.jsp
*@FileTitle  :  OceanRoute Manual Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/01
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.prd.networklinkmanage.oceanroutemanage.event.EsdPrd0040Event"%>
<%
	EsdPrd0040Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	
	Exception serverException   = null;			//error from server
	DBRowSet rowSet	  = null;							   //DB ResultSet
	String strErrMsg = "";								 //error message
	int rowCount	 = 0;								  //count of DB resultSET list
	
	try {

	   //SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   //userId=account.getUsr_id();
	   //userAuth=account.getAuth();

		event = (EsdPrd0040Event)request.getAttribute("Event");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}

%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		
		loadPage();
	}
</script>
<form method="post" name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="ori_loc" value="<%=JSPUtil.getNull(event.getSearchOceanLaneVO().getOriLoc()) %>" id="ori_loc" />
<input type="hidden" name="dest_loc" value="<%=JSPUtil.getNull(event.getSearchOceanLaneVO().getDestLoc()) %>" id="dest_loc" />
<input type="hidden" name="lane" value="<%=JSPUtil.getNull(event.getSearchOceanLaneVO().getLane()) %>" id="lane" />
<input type="hidden" name="gubun" value="<%=JSPUtil.getNull(event.getGubun()) %>" id="gubun" />
<input type="hidden" name="sTsPort" value="<%=JSPUtil.getNull(event.getSTsPort()) %>" id="sTsPort" />
<input type="hidden" name="isLastPod" value="<%=JSPUtil.getNull(event.getIsLastPod()) %>" id="isLastPod" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><span>Ocean Route Creation - Manual Creation</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
    <div class="opus_design_btn">
		    <button type="button" class="btn_accent" name="btn_ok" id="btn_ok">Ok</button><!-- 
    	     --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
    </div>
	 <!-- opus_design_btn(E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	<!-- opus_design_grid(E) -->
</div>
</form>