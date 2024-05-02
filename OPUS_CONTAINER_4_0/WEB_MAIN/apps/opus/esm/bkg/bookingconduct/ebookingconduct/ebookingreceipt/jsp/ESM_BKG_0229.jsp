<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_BKG_0229.jsp
*@FileTitle  : e-Booking & SI Process Top
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/07
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.net.URLEncoder"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg0229Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0229Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from the server
	String strErrMsg = "";						//error messege
	int rowCount	 = 0;						//the number of DB ResultSet List

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String param = "";
	Logger log = Logger.getLogger("com.clt.apps.EBookingConduct.EBookingReceipt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0229Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// extract additional data obtained from the server during Initial loading ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		param = "?bkg_no=";
		if (null!=request.getParameter("bkg_no")) {
			param += URLEncoder.encode(request.getParameter("bkg_no"));
		}
		param += "&rqst_no=";
		if (null!=request.getParameter("rqst_no")) {
			param += URLEncoder.encode(request.getParameter("rqst_no"));
		}
		param += "&rqst_seq=";
		if (null!=request.getParameter("rqst_seq")) {
			param += URLEncoder.encode(request.getParameter("rqst_seq"));
		}
		param += "&sender_id=";
		if (null!=request.getParameter("sender_id")) {
			param += URLEncoder.encode(request.getParameter("sender_id"));
		}
		param += "&doc_tp_cd=";
		if (null!=request.getParameter("doc_tp_cd")) {
			param += URLEncoder.encode(request.getParameter("doc_tp_cd"));
		}

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
	//ComOpenWait(true);
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<style type="text/css">
	body{ overflow-x:hidden;overflow-y:hidden; }
</style>
<form name="form" id="divBody">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="sender_id" id="sender_id" value="<%=StringUtil.xssFilter(request.getParameter("sender_id"))%>">
<input type="hidden" name="rqst_no" id="rqst_no" value="<%=StringUtil.xssFilter(request.getParameter("rqst_no"))%>">
<input type="hidden" name="rqst_seq" id="rqst_seq" value="<%=StringUtil.xssFilter(request.getParameter("rqst_seq"))%>">
<input type="hidden" name="bkg_no" id="bkg_no" value="<%=StringUtil.xssFilter(request.getParameter("bkg_no"))%>">
<input type="hidden" name="tabload1" value="NOT LOAD" id="tabload1" />
<input type="hidden" name="tabload2" value="NOT LOAD" id="tabload2" />
<input type="hidden" name="tabload3" value="NOT LOAD" id="tabload3" />
<input type="hidden" name="tabload4" value="NOT LOAD" id="tabload4" />
<input type="hidden" name="tabload5" value="NOT LOAD" id="tabload5" />
<input type="hidden" name="tabload6" value="NOT LOAD" id="tabload6" />
<input type="hidden" name="tabload7" value="NOT LOAD" id="tabload7" />
<input type="hidden" name="tabload8" value="NOT LOAD" id="tabload8" />
<input type="hidden" name="tabload9" value="NOT LOAD" id="tabload9" />
<input type="hidden" name="tabload10" value="NOT LOAD" id="tabload10" />
<input type="hidden" name="tabload11" value="NOT LOAD" id="tabload11" />
<input type="hidden" name="doc_tp_cd" value="<%=StringUtil.xssFilter(request.getParameter("doc_tp_cd"))%>" id="doc_tp_cd" />
<input type="hidden" name="mndTabCancel" value="N" id="mndTabCancel" />
<input type="hidden" name="containerTabCancel" value="N" id="containerTabCancel" />
<input type="hidden" name="reeferTabCancel" value="N" id="reeferTabCancel" />
<input type="hidden" name="dangerTabCancel" value="N" id="dangerTabCancel" />
<input type="hidden" name="awkwardTabCancel" value="N" id="awkwardTabCancel" />
<input type="hidden" name="loadFinish" value="N" id="loadFinish" />
<input type="hidden" name="param_data" id="param_data" value="<%=param%>">
<input type="hidden" name="com_mrdTitle" value="e-Booking &amp; SI Preview" id="com_mrdTitle" />
<input type="hidden" name="com_mrdBodyTitle" value="e-Booking &amp; SI Preview" id="com_mrdBodyTitle" />
<input type="hidden" name="com_mrdPath" id="com_mrdPath" />
<input type="hidden" name="com_mrdArguments" id="com_mrdArguments" />
<input type="hidden" name="com_zoomIn" value="3" id="com_zoomIn" />
<!-- Hidden when using Groupmail  --> 
<input type="hidden" name="gw_subject" id="gw_subject" />
<input type="hidden" name="gw_contents" id="gw_contents" />
<input type="hidden" name="gw_template" value="ESM_BKG_COMM_01T.html" id="gw_template" />
<input type="hidden" name="gw_args" value="reqcontents;" id="gw_args" />

<input type="hidden" name="t1load" value="Y" id="t1load" />
<input type="hidden" name="t2load" value="N" id="t2load" />
<input type="hidden" name="t3load" value="N" id="t3load" />
<input type="hidden" name="t4load" value="N" id="t4load" />
<input type="hidden" name="t5load" value="N" id="t5load" />
<input type="hidden" name="t6load" value="N" id="t6load" />
<input type="hidden" name="t7load" value="N" id="t7load" />
<input type="hidden" name="t8load" value="N" id="t8load" />
<input type="hidden" name="t9load" value="N" id="t9load" />
<input type="hidden" name="t10load" value="N" id="t10load" />
<input type="hidden" name="t11load" value="N" id="t11load" />
<input type="hidden" name="message" value="" id="message" />

<!-- page_title_area(S) -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<div class="opus_design_btn">
	        <!-- opus_design_btn(S) -->
			<button type="button" class="btn_normal" name="btn_xmlview" id="btn_xmlview">XML View</button><!--
			--><button type="button" class="btn_accent" name="btn_copyoption" id="btn_copyoption">Copy Option</button><!--
			--><button type="button" class="btn_normal" name="btn_preview" id="btn_preview">Preview</button><!--
			--><button type="button" class="btn_normal" name="btn_previewprint" id="btn_previewprint">Preview Print</button><!--
			--><button type="button" class="btn_normal" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
			--><button type="button" class="btn_normal" name="btn_opusupload" id="btn_opusupload">Upload</button><!--
			--><button type="button" class="btn_normal" name="btn_reject" id="btn_reject">Reject</button><!--
			--><button type="button" class="btn_normal" name="btn_pending" id="btn_pending">Pending</button><!--
			--><button type="button" class="btn_normal" name="btn_reinstate" id="btn_reinstate">Reinstate</button>
			 <!-- opus_design_btn(E) -->
		</div>		
	</div>	
</div>
<!-- page_title_area(E) -->

<!-- layer_popup_contents(S) -->
<div class="layer_popup_contents">
    	<div class="wrap_result">
    		<!-- opus_design_tab(S) -->
    		<div class="opus_design_tab sm">
    			<script type="text/javascript">ComTabObject('tab1')</script>
    		</div>
    		<!-- opus_design_tab(E) -->
    		<div id="tabLayer">
    			<iframe name="t1frame" id="t1frame" frameborder="0" scrolling="no" width="100%" height="750px" src="ESM_BKG_0229_01.do<%=param%>" onload="frame1_OnLoad();"></iframe>
    		</div>
    		<div id="tabLayer" style="position:absolute;top:-9000px;">
    			<iframe name="t2frame" id="t2frame" frameborder="0" scrolling="yes" width="100%" height="1400px" src="" onload="frame_OnLoad();"></iframe>
    		</div>
    		<div id="tabLayer" style="position:absolute;top:-9000px;">
    			<iframe name="t3frame" id="t3frame" frameborder="0" scrolling="yes" width="100%" height="600px" src="" onload="frame_OnLoad();"></iframe>
    		</div>
    		<div id="tabLayer" style="position:absolute;top:-9000px;">
    			<iframe name="t4frame" id="t4frame" frameborder="0" scrolling="no" width="100%" height="600px" src="" onload="frame_OnLoad();"></iframe>
    		</div>
    		<div id="tabLayer" style="position:absolute;top:-9000px;">
    			<iframe name="t5frame" id="t5frame" frameborder="0" scrolling="no" width="100%" height="600px" src="" onload="frame_OnLoad();"></iframe>
    		</div>
    		<div id="tabLayer" style="position:absolute;top:-9000px;">
    			<iframe name="t6frame" id="t6frame" frameborder="0" scrolling="yes" width="100%" height="600px" src="" onload="frame_OnLoad();"></iframe>
    		</div>
    		<div id="tabLayer" style="position:absolute;top:-9000px;">
    			<iframe name="t7frame" id="t7frame" frameborder="0" scrolling="yes" width="100%" height="600px" src="" onload="frame_OnLoad();"></iframe>
    		</div>
    		<div id="tabLayer" style="position:absolute;top:-9000px;">
    			<iframe name="t8frame" id="t8frame" frameborder="0" scrolling="yes" width="100%" height="600px" src="" onload="frame_OnLoad();"></iframe>
    		</div>
    		<div id="tabLayer" style="position:absolute;top:-9000px;">
    			<iframe name="t9frame" id="t9frame" frameborder="0" scrolling="yes" width="100%" height="600px" src="" onload="frame_OnLoad();"></iframe>
    		</div>
    		<div id="tabLayer" style="position:absolute;top:-9000px;">
    			<iframe name="t10frame" id="t10frame" frameborder="0" scrolling="yes" width="100%" height="600px" src="" onload="frame_OnLoad();"></iframe>
    		</div>
    		<div id="tabLayer" style="position:absolute;top:-9000px;">
    			<iframe name="t11frame" id="t11frame" frameborder="0" scrolling="no" width="100%" height="600px" src="" onload="frame_OnLoad();"></iframe>
    		</div>
            <!-- opus_design_grid(S) -->
            <div class="wrap_result" style="display:none">
            	<div class="opus_design_grid clear" id="rdTable" name="mainTable">
            		<script type="text/javascript">ComSheetObject('sheet1');</script>
            	</div>
            </div>
            <!-- opus_design_grid(E) -->
	   </div>
</div>	
<!-- layer_popup_contents(E) -->
</form>