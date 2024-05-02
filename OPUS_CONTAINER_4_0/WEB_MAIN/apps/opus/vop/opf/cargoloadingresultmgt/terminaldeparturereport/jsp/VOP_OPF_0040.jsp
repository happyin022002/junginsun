﻿<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : vop_opf_0040.jsp
*@FileTitle  : TDR Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/25
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.event.VopOpf0040Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopOpf0040Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOpenerReson	= "";
	Logger log = Logger.getLogger("com.clt.apps.CargoLoadingResultMgt.TerminalDepartureReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopOpf0040Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		strOpenerReson = request.getParameter("shift_rsn");

		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>


<script language="javascript">

    function setupPage(){  

	    loadPage();
    }

</script>



<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="shift_rsn" value="<%=StringUtil.xssFilter(strOpenerReson)%>">

<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Restow Reason Code Help</span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_OK" id="btn_OK">OK</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_result">
		<div class="layout_wrap">
		    <div class="layout_vertical_2" style="width:50%;padding-right:20px">
					<script language="javascript">ComSheetObject('sheet1');</script> 
			</div>
			<div class="layout_vertical_2" style="right:0;left:auto;width:50%">
				<div class="opus_design_grid">
					<script language="javascript">ComSheetObject('sheet2');</script>
				</div>
			</div>
			<div id="sheetHelp5" style="display:none">				
			<script type="text/javascript">ComSheetObject('dummy');</script>
			</div>	
		</div>
	</div>
</div>
<!-- popup_contens_area(E) -->

</form>