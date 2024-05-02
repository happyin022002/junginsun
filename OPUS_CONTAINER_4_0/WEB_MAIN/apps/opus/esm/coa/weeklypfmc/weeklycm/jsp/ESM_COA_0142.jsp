<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0142.jsp
*@FileTitle  : VVD Check List
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/05
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.io.HttpUtil"%> 
<%
	Exception serverException   = null;			//Error from server
	String strErrMsg = "";						//Error message
    String xml = "";
	Logger log = Logger.getLogger("com.clt.apps.WeeklyPFMC.WeeklyCM");
	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
        xml = HttpUtil.makeXML(request,response); 
        xml = xml.replaceAll("\"", "'");

	} catch(Exception e) {
		log.error("Exception : " + e.toString());
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
<input type="hidden" name="sXml" value="<%=xml%>" id="sXml" />

<input type="hidden" id="f_chkprd" name="f_chkprd" value="<%= request.getParameter("f_chkprd")==null?"W":request.getParameter("f_chkprd") %>">
<input type="hidden" id="f_year"   name="f_year"   value="<%= request.getParameter("f_year")==null?"2007":request.getParameter("f_year") %>">
<input type="hidden" id="f_fm_mon" name="f_fm_mon" value="<%= JSPUtil.getNull(request.getParameter("f_fm_mon")) %>">
<input type="hidden" id="f_to_mon" name="f_to_mon" value="<%= JSPUtil.getNull(request.getParameter("f_to_mon")) %>">
<input type="hidden" id="f_fm_wk"  name="f_fm_wk"  value="<%= request.getParameter("f_fm_wk")==null?"23":request.getParameter("f_fm_wk") %>">
<input type="hidden" id="f_to_wk"  name="f_to_wk"  value="<%= request.getParameter("f_to_wk")==null?"23":request.getParameter("f_to_wk") %>">

<input type="hidden" id="f_trd_cd" name="f_trd_cd" value="<%= JSPUtil.getNull(request.getParameter("f_seltrade")) %>">
<input type="hidden" id="f_rlane_cd" name="f_rlane_cd" value="<%= JSPUtil.getNull(request.getParameter("f_selrlane")) %>">
<input type="hidden" id="f_slane_cd" name="f_slane_cd" value="<%= JSPUtil.getNull(request.getParameter("f_selslane")) %>">
<input type="hidden" id="f_seldir" name="f_seldir" value="<%= JSPUtil.getNull(request.getParameter("f_seldir")) %>">
<input type="hidden" id="f_ioc_cd" name="f_ioc_cd" value="<%= JSPUtil.getNull(request.getParameter("f_selioc")) %>">
<input type="hidden" id="f_vsl_cd" name="f_vsl_cd" value="<%= JSPUtil.getNull(request.getParameter("f_vsl_cd")) %>">
<input type="hidden" id="f_skd_voy_no" name="f_skd_voy_no" value="<%= JSPUtil.getNull(request.getParameter("f_skd_voy_no")) %>">
<input type="hidden" id="f_dir_cd" name="f_dir_cd" value="<%= JSPUtil.getNull(request.getParameter("f_dir_cd")) %>">
<div class="layer_popup_contents">
	<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title"><span>VVD Check List</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_Save" 	id="btn_Save">Save</button><!--
			--><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
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
	<div class="wrap_result" style="overflow:hidden">
		<div class="opus_design_grid clear" id="mainTable" >
				<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>