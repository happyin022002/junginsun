<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ess_mnr_0145.jsp
*@FileTitle  : EQ Component Code Grouping by Location
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/14
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.event.EesMnr0002Event"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="org.apache.log4j.Logger" %>

<%  
    //Receiving data from parent screen
    String eqCmpoCd	  	= "";
    String eqCmpoNm	  	= "";
    String eqCmpoDesc	= "";
    String strMnrOfficeLevel = "";
    if(request.getParameter("eqCmpoCd")!=null) {
    	eqCmpoCd 	= StringUtil.xssFilter(request.getParameter("eqCmpoCd"));
    	eqCmpoNm 	= StringUtil.xssFilter(request.getParameter("eqCmpoNm"));
    	eqCmpoDesc	= StringUtil.xssFilter(request.getParameter("eqCmpoDesc"));
    	strMnrOfficeLevel = StringUtil.xssFilter(request.getParameter("strMnrOfficeLevel"));
    }

	EesMnr0002Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Occurred error from server
	String strErrMsg = "";						//Error message

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strAccess_System		= "";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strAccess_System = account.getAccess_system();

		event = (EesMnr0002Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
    var strMnrOfficeLevel = "<%=strMnrOfficeLevel.trim() %>";
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<!-- Developer's task	-->

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><span>EQ Component Grouping by Location & Damage Type</span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_Save" id="btn_Save" type="button">Save</button><!-- 
		 --><button class="btn_normal" name="btn_Close" id="btn_Close" type="button">Close</button>
	</div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="80" />							
				<col width="70" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
		   			<th>Component Code</th>
					<td><input type="text" name="eq_cmpo_cd" style="width:60px;text-align:center;" class="input2" value="<%= eqCmpoCd%>" readonly id="eq_cmpo_cd" /> </td>
					<td><input type="text" name="eq_cmpo_desc" style="width:450px;" class="input2" value="<%= eqCmpoNm%>" readonly id="eq_cmpo_desc" /> </td>
		   		</tr>
		   </tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">

 <!-- layout_wrap(S) -->
    <div class="layout_vertical_2" style="width:34%;">
        <!-- opus_design_grid(S) -->
        <div class="opus_design_grid">
        	<h3 class="title_design mar_top_4">Grouping By Location</h3>
            <script type="text/javascript">ComSheetObject('sheet1');</script>
        </div>
        <!-- opus_design_grid(e) -->
    </div>
    
    <div class="layout_vertical_2" style="width:33%;">
        <!-- opus_design_grid(S) -->
        <div class="opus_design_grid" style="padding-left:10px;">
        	<h3 class="title_design mar_top_4">Grouping By Damage Type</h3>
            <script type="text/javascript">ComSheetObject('sheet2');</script>
        </div>
        <!-- opus_design_grid(e) -->
    </div>
    
    <div class="layout_vertical_2" style="width:33%;">
        <!-- opus_design_grid(S) -->
        <div class="opus_design_grid" style="padding-left:10px;">
        	<h3 class="title_design mar_top_4">Grouping By Repair Type</h3>
            <script type="text/javascript">ComSheetObject('sheet3');</script>
        </div>
        <!-- opus_design_grid(e) -->
    </div>

<!-- layout_wrap(e) -->
	
</div>

</form>
