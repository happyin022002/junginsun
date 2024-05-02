<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0753.jsp
*@FileTitle  : bookingReport
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/07
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
<%@ page import="com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.event.EsmBkg0895Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0895Event  event = null;					
	Exception serverException   = null;			
	String strErrMsg = "";						
	int rowCount	 = 0;						
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String rptId			= "";
	String bkgRptKndCd		= "";
	String editYn			= "";

	Logger log = Logger.getLogger("com.clt.apps.BookingCommon.BookingUtil");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		rptId 		= StringUtil.xssFilter(request.getParameter("rpt_id"));
		bkgRptKndCd = StringUtil.xssFilter(request.getParameter("bkg_rpt_knd_cd"));
		editYn		= StringUtil.xssFilter(request.getParameter("edit_yn"));
		//editYn		= "N";
		if (rptId == null){
			rptId 		= "SELHO00011";
			bkgRptKndCd = "V";
		}

		event = (EsmBkg0895Event)request.getAttribute("Event");
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

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="rpt_id" value="<%= rptId %>" id="rpt_id" />
<input type="hidden" name="bkg_rpt_knd_cd" value="<%= bkgRptKndCd %>" id="bkg_rpt_knd_cd" />
<input type="hidden" name="edit_yn" value="<%= editYn %>" id="edit_yn" />

<div class="layer_popup_title">
	<div class="page_title_area clear">
	
		<h2 class="page_title"><span>Report Item Option</span></h2>
		
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn_OK" id="btn_OK" type="button">Save</button><!--
			--><button class="btn_normal" name="btn_Close" id="btn_Close" type="button">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_result">
		<div class="layout_wrap">
		    <div class="layout_vertical_3" style="width:45%">
		        <div class="opus_design_grid">
		            <script type="text/javascript">ComSheetObject('sheet1');</script>
		        </div>
		    </div>
		    <div class="layout_vertical_3" style="width:10%">
		    	<div class="opus_design_inquiry" style="padding-top:200px; text-align:center;">  
			       	<table>
						<tr><td><button type="button" class="btn_etc" name="btns_add" id="btns_add">Add</button></td></tr>
						<tr><td></td></tr>
						<tr><td><button type="button" class="btn_etc" name="btns_del" id="btns_del">Del</button></td></tr>
						<tr><td></td></tr>
						<tr><td><button type="button" class="btn_up" name="btns_up" id="btns_up"></button></td></tr>
						<tr><td></td></tr>
						<tr><td><button type="button" class="btn_down" name="btns_down" id="btns_down"></button></td></tr>
					</table>
				</div>
		    </div>
		    <div class="layout_vertical_3" style="width:45%">
		        <div class="opus_design_grid">
		            <script type="text/javascript">ComSheetObject('sheet2');</script>
		        </div>
		    </div>
		</div>
	</div>
</div>
</form>
