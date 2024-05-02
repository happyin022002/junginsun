<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0292_03.jsp
*@FileTitle : C/S Screen_S/O Info
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.23
*@LastModifier : 안진응
*@LastVersion : 1.0
* 2009.05.19 안진응
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.event.EsmBkg029203Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg029203Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.CsScreenMgtSC.CsScreenBC");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmBkg029203Event)request.getAttribute("Event");
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
<title>Inbound C/S Screen(S/O Info)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	var strUsr_id    = "<%=strUsr_id%>";

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- 개발자 작업	-->
<input type='hidden' name ='bl_no' value = "">
<input type='hidden' name ='bkg_no' value = "<%=JSPUtil.getNull(request.getParameter("bkg_no"))%>">
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;padding-left:0;">
<!--TAB S/O Info (S) -->
<div id="tabLayer" style="display:none">  

		<!-- Grid BG Box  (S) -->
     	<table class="search" id="mainTable"> 
       	<tr><td class="bg">
				
				<table class="search" border="0">
					<tr><td class="title_h"></td>
						<td class="title_s">S/O Status per Container</td></tr>
				</table>
			
				<!-- Grid_frame (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr><td width="750" valign="top">
						<!-- Grid_1  (S) -->
							<table width="100%"  id="mainTable">
								<tr>
									<td width="100%">
										<script language="javascript">ComSheetObject('t4sheet1');</script>
									</td>
								</tr>
							</table>
						
						<!-- Grid_1 (E) -->
					</td>
					<td width="19">&nbsp;</td>
					<td width="210" valign="top">
					
						<!-- Grid_2  (S) -->
							<table width="100%"  id="mainTable">
								<tr>
									<td width="100%">
										<script language="javascript">ComSheetObject('t4sheet2');</script>
									</td>
								</tr>
							</table>
						<!-- Grid_2 (E) -->
						
					</td>					
					</tr>
					</table>
					<!-- Grid_frame (E) -->
					
				
				<table class="height_10"><tr><td></td></tr></table>
				<table class="search" border="0">
					<tr><td class="title_h"></td>
						<td class="title_s">W/O Detail(s) per Container</td></tr>
				</table>
			
					<!-- Grid_3  (S) -->
					<table width="100%"  id="mainTable">
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('t4sheet3');</script>
								<script language="javascript">ComSheetObject('t4sheet4');</script>
							</td>
						</tr>
					</table>
					<!-- Grid_3 (E) -->
			
						
			</td></tr>
		</table>
	<!-- Grid BG Box  (S) -->
	
</div>
<!--TAB S/O Info (E) --> 
</table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>