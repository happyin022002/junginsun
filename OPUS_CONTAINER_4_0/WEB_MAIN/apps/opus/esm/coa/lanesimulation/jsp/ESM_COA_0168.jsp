<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_168.jsp
*@FileTitle  : Creation (Variant Change)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/14
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.apps.opus.esm.coa.lanesimulation.event.EsmCoa0168Event"%>
<%
	EsmCoa0168Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	GeneralEventResponse eventResponse = null;	//RDTO(Data Transfer Object including DB ResultSet)
	Exception serverException	= null;				//서버에서 발생한 에러
	String strErrMsg = "";							//에러메세지

	String f_sim_no = "";
	String f_sim_dt = "";
	String f_dept_cd = "";
	String f_usr_id = "";
	int f_reportMasterCount = 0;

	//f_dept_cd, f_sim_dt, f_sim_no, f_usr_id


	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		event = (EsmCoa0168Event)request.getAttribute("Event");

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
			eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
			if (eventResponse != null) {
				f_sim_no = JSPUtil.getNull(request.getParameter("f_sim_no"));
				f_sim_dt = JSPUtil.getNull(request.getParameter("f_sim_dt"));
				f_dept_cd = JSPUtil.getNull(request.getParameter("f_dept_cd"));
				f_usr_id = JSPUtil.getNull(request.getParameter("f_usr_id"));
				f_reportMasterCount = Integer.parseInt(eventResponse.getETCData("cnt"));
			} // end if
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
		setRetrieveAction();
	}
</script>

<form method="post" name="form" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="f_sim_no" value="<%= f_sim_no %>" id="f_sim_no" />
<input type="hidden" name="f_sim_dt" value="<%= f_sim_dt %>" id="f_sim_dt" />
<input type="hidden" name="f_dept_cd" value="<%= f_dept_cd %>" id="f_dept_cd" />
<input type="hidden" name="f_usr_id" value="<%= f_usr_id %>" id="f_usr_id" />
<input type="hidden" name="f_reportMasterCount" value="<%= f_reportMasterCount %>" id="f_reportMasterCount" />
<div class="layer_popup_contents">
	<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title"><span>Creation (Variant Change)</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_creation" 	id="btn_creation">Creation</button><!--
			--><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button><!--
		--></div>
		<!-- opus_design_btn(E) -->
		<!-- page_location(S) -->
		<div class="location">
			<span id="navigation"></span>
		</div>
		<!-- page_location(E) -->
	</div>
	<!-- page_title_area(E) -->
	</div>
	
	<!-- opus_design_grid(S) -->	
	<div class="wrap_result">
		<div class="opus_design_grid clear" id="mainTable" >
				<script type="text/javascript">ComSheetObject('sheet');</script>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>