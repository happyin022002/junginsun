<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0988.jsp
*@FileTitle : booking report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.06.11 강동윤
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0988Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0988Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String title			= "";
	String text			= "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.BookingReport.PerformanceReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
				
		title 		= JSPUtil.getNull(request.getParameter("title"));
		text		= JSPUtil.getNull(request.getParameter("text"));
		
		if (text == null || text.equals("")) text = "";

		event = (EsmBkg0988Event)request.getAttribute("Event");
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
<title><%= title %></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		
		//loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->

<input type="hidden" name="sr_no" value="<%= title %>">
<input type="hidden" name="sr_knd_cd" value="U">

<!-- OUTER - POPUP (S)tart -->
<table width="530" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;<%= title %></td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
			<table class="search"> 
       		<tr><td class="bg">
       				<table class="search" border="0">
		
				</table>
				<!-- : ( Grid ) (S) -->
				<table width="100%" class="grid"> 
				<tr>
					 <td align="center"><textarea name="text2" style="width:100%;height:170" class="input1" wrap=hard><%=text %></textarea></td> 
					</tr>
				</table> 
				<!-- : ( Grid ) (E) -->	
		    <!-- : ( Button : Grid ) (E) -->	
			
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
</td></tr>
</table> 

<table class="height_5"><tr><td></td></tr></table>
	
			<!-- Grid  (S) -->
				<table width="0"  id="mainTable"> 
					<tr>
						<td width="0">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>			
			<!-- Grid (E) -->
				
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
				<!-- <td class="btn1_line"></td> -->
				<td><table width="0" align ="center" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close" onClick="self.close()">Close</td>
					<td class="btn1_right"></td>
				</tr></table></td>

		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>