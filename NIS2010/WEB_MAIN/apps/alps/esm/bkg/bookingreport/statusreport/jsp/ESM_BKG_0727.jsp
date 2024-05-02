<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0727.jsp
*@FileTitle : BDR Booking No Status - Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.14
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.08.14 김기종
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.event.EsmBkg0727Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0727Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.BookingReport.StatusReport");
	String vvd_cd		= "";
	String pol_cd		= "";
	String pod_cd			= "";
	String slan_cd			= "";
	String skd_dir_cd		= "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0727Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		vvd_cd		= JSPUtil.getParameter(request, "vvd_cd");
		pol_cd		= JSPUtil.getParameter(request, "pol_cd");
		pod_cd		= JSPUtil.getParameter(request, "pod_cd");
		slan_cd		= JSPUtil.getParameter(request, "slan_cd");
		skd_dir_cd	= JSPUtil.getParameter(request, "skd_dir_cd");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>BDR Booking No Status - Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="com_mrdPath">
<input type="hidden" name="com_mrdArguments">
<input type="hidden" name="com_mrdTitle" value="">
<input type="hidden" name="com_mrdDisableToolbar" value="">
<input type="hidden" name="com_mrdBodyTitle" value="<span style=&quot;color:red&quot;>BDR STATUS</span>">

<input type="hidden" name="vvd_cd" value="<%=vvd_cd%>">
<input type="hidden" name="pol_cd" value="<%=pol_cd%>">
<input type="hidden" name="pod_cd" value="<%=pod_cd%>">
<input type="hidden" name="slan_cd" value="<%=slan_cd%>">
<input type="hidden" name="skd_dir_cd" value="<%=skd_dir_cd%>">

<!-- 개발자 작업	-->

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;BDR Booking No Status - Inquiry</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
			<table class="search"> 
       		<tr><td class="bg">
				
				<!-- : ( Grid ) (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>				
				<!-- : ( Grid ) (E) -->	
				<table class="search" border="0" style="width:566;"> 
				<tr class="h23">
					<td width="55">TTL BKG</td>
					<td width="100"><input type="text" name="ttl_bkg" style="width:60;text-align:right" class="input2" value="0" readonly></td>
					<td width="55">TTL BDR</td>
					<td width="100"><input type="text" name="ttl_bdr" style="width:60;text-align:right" class="input2" value="0" readonly></td> 
					<td width="85">TTL Non BDR</td>
					<td><input type="text" name="non_bdr" style="width:60;text-align:right" class="input2" value="0" readonly></td> </tr>
				</table>
				<!-- : ( Button : Grid ) (S) -->
				
		    <!-- : ( Button : Grid ) (E) -->	
			
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->

<table class="height_5"><tr><td></td></tr></table>
</td></tr>
</table> 
	
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td width="72"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_print">Print</td>
					<td class="btn1_right"></td>
					</tr></table>
				</td>
				<td class="btn1_line"></td>
				<td width="72"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right"></td>
					</tr></table>
				</td></tr>
		</table>

	</td></tr>
</table>

	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
			

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
<%@include file="/bizcommon/include/common_alps.jsp"%>