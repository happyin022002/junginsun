<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0079.jsp
*@FileTitle  : BKG Creation Main
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.core.controller.util.WebKeys"%>
<%@ page import="com.clt.framework.core.view.template.Screen"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.event.EsmBkg0079Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.core.controller.DefaultViewAdapter"%>

<%
    EsmBkg0079Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id	= "";
	String strUsr_nm	= "";
	String strUsr_ofc   = "";
	String sXml 		= "";
	Logger log = Logger.getLogger("com.clt.apps.GeneralBookingConduct.GeneralBookingReceipt");
	
	String bkgNo   = "";
	String blNo   = "";
	String isPop   = "";
	String openTab = "";
	String troTab  = "";
	String shortcutTab = "";
	String isInquiry = "N";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();

		event = (EsmBkg0079Event)request.getAttribute("Event");

		bkgNo   = JSPUtil.getParameter(request, "bkg_no");
		blNo   = JSPUtil.getParameter(request, "bl_no");
		isPop   = JSPUtil.getParameter(request, "isPop");
		openTab = JSPUtil.getParameter(request, "openTab");
		troTab  = JSPUtil.getParameter(request, "tro_tab");
		shortcutTab = JSPUtil.getParameter(request, "shortcutTab");

		Screen screen = (Screen) request.getAttribute(WebKeys.CURRENT_SCREEN);
		if (screen.getName().indexOf("Q") >= 0){
			isInquiry = "Y";
		}
		
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		if(!"Y".equals(isPop)){
			DefaultViewAdapter adapter = new DefaultViewAdapter();
			sXml = adapter.makeXML(request, response);	
		}
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
		
        $('<button type="button" class="btn_normal" name="btn_History" id="btn_History" style="display:none">History</button>').appendTo("#btnArea");
        $('<button type="button" class="btn_normal" name="btn_BLPreview" id="btn_BLPreview" style="display:none">B/L Preview</button>').appendTo("#btnArea");
        $('<button type="button" class="btn_normal" name="btn_CAIssue" id="btn_CAIssue" style="display:none">C/A Issue</button>').appendTo("#btnArea");
        $('<button type="button" class="btn_normal" name="btn_CAReason"	id="btn_CAReason" style="display:none">C/A Reason</button>').appendTo("#btnArea");
        $('<button type="button" class="btn_normal" name="btn_CACancel" id="btn_CACancel" style="display:none">C/A Cancel</button>').appendTo("#btnArea");
        $('<button type="button" class="btn_normal" name="btn_CAConfirm" id="btn_CAConfirm" style="display:none">C/A Confirm</button>').appendTo("#btnArea");
        $('<button type="button" class="btn_normal" name="btn_CAInquiry" id="btn_CAInquiry" style="display:none">C/A Inquiry</button>').appendTo("#btnArea");
        
        $('#btn_CAInquiry').after($('#btn_Close'));
        
        <%if("Y".equals(isInquiry)){ %>
        	document.getElementById("title").innerHTML = "Booking Inquiry";
        <%} %>
        
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="sXml" 			value="<%=JSPUtil.replace(sXml, "\"", "&quot;")%>">
<input type="hidden" name="openTab"         value="<%=openTab%>">
<input type="hidden" name="troTab"          value="<%=troTab%>">
<input type="hidden" name="isPop"           value="<%=isPop%>">
<input type="hidden" name="bkg_no"          value="<%=bkgNo%>" style="width:80;">
<input type="hidden" name="bl_no"           value="<%=blNo %>"           style="width:30;">
<input type="hidden" name="usr_id"          value="<%=strUsr_id%>">
<input type="hidden" name="usr_nm"          value="<%=strUsr_nm%>">
<input type="hidden" name="usr_ofc"         value="<%=strUsr_ofc%>">
<input type="hidden" name="ca_flg"          value="N" style="width:30;">
<input type="hidden" name="bdr_flg"         value="N" style="width:30;">
<input type="hidden" name="ca_exist_flg"    value="N" style="width:30;"><!-- CA data exists or not  -->
<input type="hidden" name="ca_rsn_cd"       value=""  style="width:30;"><!-- CA ReasonCd : init -->
<input type="hidden" name="ca_remark"       value=""  style="width:30;"><!-- CA Remark   : init  -->
<input type="hidden" name="isInquiry"       value="<%=isInquiry%>">
<input type="hidden" name="shortcutTab"     value="<%=shortcutTab%>">
<!-- Groupmail Hidden --> 
<input type="hidden" name="gw_subject">
<input type="hidden" name="gw_contents">
<input type="hidden" name="gw_template" value="ESM_BKG_COMM_01T.html">
<input type="hidden" name="gw_args" value="reqcontents;">
<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp"%>

	<%if(!mainPage.equals("true")){%><div class="layer_popup_contents"><%}%>


	<div class="wrap_result wrap_result_tab">
		<!-- opus_design_tab(S) -->
		<div class="opus_design_tab sm" style="margin-bottom:0!important;">
			<script >ComTabObject('tab1')</script>
		</div>
		<!-- opus_design_tab(E) -->
		
		<!-- tabLayer(S) -->
		<div id="tabLayer" style="display: none">
		<iframe name="t1frame" id="t1frame" style="width:100%;height:610px;" scrolling="no" onload="return setForceFocus()"></iframe></div><!-- //BKG Creation -->
		<div id="tabLayer" style="display: none">
		<iframe name="t2frame" id="t2frame" style="width:100%;height:630px;" scrolling="no" ></iframe></div><!-- //TRO/O - 기타 -->
		<div id="tabLayer" style="display: none">
		<iframe name="t3frame" id="t3frame" style="width:100%;height:610px;" scrolling="no" ></iframe></div><!-- //CNTR -->
		<div id="tabLayer" style="display: none">
		<iframe name="t4frame" id="t4frame" style="width:100%;height:930px;" scrolling="no" ></iframe></div><!-- //Customer -->
		<div id="tabLayer" style="display: none">
		<iframe name="t5frame" id="t5frame" style="width:100%;height:610px;" scrolling="no" ></iframe></div><!-- //M&D -->
		<div id="tabLayer" style="display: none">
		<iframe name="t6frame" id="t6frame" style="width:100%;height:590px;" scrolling="no" ></iframe></div><!-- //C/M -->
		<div id="tabLayer" style="display: none">
		<iframe name="t7frame" id="t7frame" style="width:100%;height:620px;" scrolling="no" ></iframe></div><!-- //Charge -->
		<div id="tabLayer" style="display: none">
		<iframe name="t8frame" id="t8frame" style="width:100%;height:720px;" scrolling="no" ></iframe></div><!-- //B/L Issue -->
		<div id="tabLayer" style="display: none">
		<iframe name="t9frame" id="t9frame" style="width:100%;height:750px;" scrolling="no" ></iframe></div><!-- //House B/L -->
		<div id="tabLayer" style="display: none">
		<iframe name="t10frame" id="t10frame" style="width:100%;height:640px;" scrolling="no" ></iframe></div><!-- //TRO/O - KOR -->
		<div id="tabLayer" style="display: none">
		<iframe name="t11frame" id="t11frame" style="width:100%;height:640px;" scrolling="no" ></iframe></div><!-- //TRO/O - EUR -->
		<div id="tabLayer" style="display: none">
		<iframe name="t12frame" id="t12frame" style="width:100%;height:640px;" scrolling="no" ></iframe></div><!-- //TRO/I - EUR -->
		<!-- tabLayer(E) -->
	</div>
		
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid mar_btm_none">
		<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
			<script type="text/javascript">ComSheetObject('h1sheet1');</script>
		<!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<!-- opus_design_grid(E) -->

<%if(!mainPage.equals("true")){	%></div><%}%>
		
</form>
