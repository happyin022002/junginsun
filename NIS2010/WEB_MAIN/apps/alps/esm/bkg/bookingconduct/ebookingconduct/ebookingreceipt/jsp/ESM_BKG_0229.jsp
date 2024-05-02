<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0229.jsp
*@FileTitle : e-Booking & SI Process Top
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.15
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.06.15 전용진
* 1.0 Creation
===============================================================================
 History
 2010.09.13 이일민 [CHM-201005276-01] ALPS-[BKG/DOC]주요UI버턴-단축키 기능개발
 2011.10.04 정선용 [CHM-201112445] SI Automation System 구축 
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.net.URLEncoder"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg0229Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<% 
	EsmBkg0229Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.hanjin.apps.EBookingConduct.EBookingReceipt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0229Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>e-Booking & SI Process Top</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body onLoad="setupPage();" style="padding-left: 5;width:100%;overflow-x:hidden;overflow-y:hidden">
<div id="loadingBar" style="LEFT:expression((document.body.clientWidth/2)-100); TOP:expression((document.body.clientHeight/2)-70); POSITION:absolute; z-index:1">
<img src="img/loding.gif"></div>
<div id="divBody" style="display:none">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="sender_id" value="<%=StringUtil.xssFilter(request.getParameter("sender_id"))%>">
<input type="hidden" name="rqst_no" value="<%=StringUtil.xssFilter(request.getParameter("rqst_no"))%>">
<input type="hidden" name="rqst_seq" value="<%=StringUtil.xssFilter(request.getParameter("rqst_seq"))%>">
<input type="hidden" name="bkg_no" value="<%=StringUtil.xssFilter(request.getParameter("bkg_no"))%>">
<input type="hidden" name="fax_log_ref_no" value="<%=StringUtil.xssFilter(request.getParameter("fax_log_ref_no"))%>">
<input type="hidden" name="sr_knd_cd" value="<%=StringUtil.xssFilter(request.getParameter("sr_knd_cd"))%>">
<input type="hidden" name="tmplt_par_rto" value="<%=StringUtil.xssFilter(request.getParameter("tmplt_par_rto"))%>">
<input type="hidden" name="xter_rqst_via_cd" value="<%= StringUtil.xssFilter(request.getParameter("xter_rqst_via_cd"))%>">
<input type="hidden" name="ca_no">

<input type="hidden" name="tabload1"  value="NOT LOAD">
<input type="hidden" name="tabload2"  value="NOT LOAD">
<input type="hidden" name="tabload3"  value="NOT LOAD">
<input type="hidden" name="tabload4"  value="NOT LOAD">
<input type="hidden" name="tabload5"  value="NOT LOAD">
<input type="hidden" name="tabload6"  value="NOT LOAD">
<input type="hidden" name="tabload7"  value="NOT LOAD">
<input type="hidden" name="tabload8"  value="NOT LOAD">
<input type="hidden" name="tabload9"  value="NOT LOAD">
<input type="hidden" name="tabload10" value="NOT LOAD">
<input type="hidden" name="tabload11" value="NOT LOAD">
<input type="hidden" name="tabload12" value="NOT LOAD">
<input type="hidden" name="mndTabCancel" value="N">
<input type="hidden" name="containerTabCancel" value="N">
<input type="hidden" name="reeferTabCancel" value="N">
<input type="hidden" name="dangerTabCancel" value="N">
<input type="hidden" name="awkwardTabCancel" value="N">
<input type="hidden" name="breakBulkTabCancel" value="N">
<input type="hidden" name="loadFinish"  value="N">
<%String param="?bkg_no="+URLEncoder.encode(StringUtil.xssFilter(request.getParameter("bkg_no")))+"&rqst_no="+URLEncoder.encode(StringUtil.xssFilter(request.getParameter("rqst_no")))+"&rqst_seq="+URLEncoder.encode(StringUtil.xssFilter(request.getParameter("rqst_seq")))+"&sender_id="+URLEncoder.encode(StringUtil.xssFilter(request.getParameter("sender_id")))+"&xter_rqst_via_cd="+URLEncoder.encode(StringUtil.xssFilter(request.getParameter("xter_rqst_via_cd")));%>
<input type="hidden" name="param_data" value="<%=param%>">
<input type="hidden" name="com_mrdTitle" value="e-Booking &amp; SI Preview">
<input type="hidden" name="com_mrdBodyTitle" value="e-Booking &amp; SI Preview">
<input type="hidden" name="com_mrdPath">
<input type="hidden" name="com_mrdArguments">
<input type="hidden" name="com_zoomIn" value="3">

<!-- Groupmail시 반영될 Hidden --> 
<input type="hidden" name="gw_subject">
<input type="hidden" name="gw_contents">
<input type="hidden" name="gw_template" value="ESM_BKG_COMM_01T.html">
<input type="hidden" name="gw_args" value="reqcontents;">

<table class="popup" border="0" cellpadding="0" cellspacing="0" width="100%">
<tr>
	<td width="3"></td>
	<td>

		<!--Button (S) -->
		<table width="998" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
		    	<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;e- Booking & SI Upload</td>
		    	<td width="650"></td>
				<td id="btn_Si_Image"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Si_Image">SI Image</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td id="btn_Si_Text"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Si_Text">SI Text</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>				
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
   		<table class="tab" border="0" cellpadding="0" cellspacing="0" width="100%"> 
     		<tr><td width="100%">
			<script language="javascript">ComTabObject('tab1')</script>
			</td></tr>
		</table>
		<div id="tabLayer" style="display:none">
			<iframe name="t1frame" id="t1frame" frameborder="0" scrolling="no" width="100%" height="620" src="ESM_BKG_0229_01.do<%=param%>"   onload="frame1_OnLoad();hideLoadingImg();"></iframe>
		</div>
		<div id="tabLayer" style="display:none">
			<iframe name="t2frame" id="t2frame" frameborder="0" scrolling="yes" width="100%" height="620" src="" onload="frame_OnLoad();"></iframe>
		</div>
		<div id="tabLayer" style="display:none">
			<iframe name="t3frame" id="t3frame" frameborder="0" scrolling="yes" width="100%" height="620" src="" onload="frame_OnLoad();"></iframe>
		</div>
		<div id="tabLayer" style="display:none">
			<iframe name="t4frame" id="t4frame" frameborder="0" scrolling="no" width="100%" height="620" src="" onload="frame_OnLoad();"></iframe>
		</div>
		<div id="tabLayer" style="display:none">
			<iframe name="t5frame" id="t5frame" frameborder="0" scrolling="yes" width="100%" height="620" src="" onload="frame_OnLoad();"></iframe>
		</div>
		<div id="tabLayer" style="display:none">
			<iframe name="t6frame" id="t6frame" frameborder="0" scrolling="yes" width="100%" height="620" src="" onload="frame_OnLoad();"></iframe>
		</div>
		<div id="tabLayer" style="display:none">
			<iframe name="t7frame" id="t7frame" frameborder="0" scrolling="yes" width="100%" height="620" src="" onload="frame_OnLoad();"></iframe>
		</div>
		<div id="tabLayer" style="display:none">
			<iframe name="t8frame" id="t8frame" frameborder="0" scrolling="yes" width="100%" height="620" src="" onload="frame_OnLoad();"></iframe>
		</div>
		<div id="tabLayer" style="display:none">
			<iframe name="t9frame" id="t9frame" frameborder="0" scrolling="yes" width="100%" height="620" src="" onload="frame_OnLoad();"></iframe>
		</div>
		<div id="tabLayer" style="display:none">
			<iframe name="t12frame" id="t12frame" frameborder="0" scrolling="yes" width="100%" height="620" src="" onload="frame_OnLoad();"></iframe>
		</div>
		<div id="tabLayer" style="display:none">
			<iframe name="t10frame" id="t10frame" frameborder="0" scrolling="yes" width="100%" height="620" src="" onload="frame_OnLoad();"></iframe>
		</div>
		<div id="tabLayer" style="display:none">
			<iframe name="t11frame" id="t11frame" frameborder="0" scrolling="no" width="100%" height="620" src="" onload="frame_OnLoad();"></iframe>
		</div>
		<table><tr><td class="height_5"></td></tr></table>
		<!--Button (S) -->
		<table width="980" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg" style="text-align:left;">
       		<table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_copyoption">Copy Option</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_preview">Preview</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_previewprint">Preview&nbsp;Print</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>				
			</tr>
			</table>
       		</td>
       		<td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
		    	<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<%
				if(!strUsr_id.equals("CANSO04") && !strUsr_id.equals("CANSO05") && !strUsr_id.equals("CINDYPAN")){
				%>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_alpsupload" id="btn_alpsupload">Upload</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<%
				}
				%>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_websiaudit" id="btn_websiaudit">WEB S/I Audit</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_reject">Reject</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_pending">Pending</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_reinstate">Reinstate</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
		<!--Button (E) -->
		<!-- RD Object (S) -->
		<table width="100%" id="rdTable">
			<tr>
				<td width="100%"><script language="javascript">comRdObject('Rd');</script>
				</td>
			</tr>
		</table>
		<!-- RD Object (E) -->
		<!--Sheet (S) -->
		<table width="98%" id="mainTable">
			<tr>
				<td width="98%"><script language="javascript">ComSheetObject("sheet1");</script>
				</td>
			</tr>
		</table>
		<!--Sheet (E) -->
		<iframe name="hiddenFrame" style="visibility:hiddden" height="0" width="0"></iframe>
		<!--  Mark & Description 의 wrap -->
		<iframe id="descRequest" name="descRequest" src="about:blank" onload="descSend()" width="100%" height="200" width="0" height="0" style="display:none"></iframe>
</td></tr>
</table>		
</form>
</div>
</body>
</html>