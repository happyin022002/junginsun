<%/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : roleinquiry.jsp
*@FileTitle : Role Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.01
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.syscommon.management.alps.role.event.ComSys008Event"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>
<%@ page import="com.hanjin.syscommon.common.util.OrganizationUtil"%>

<%
	ComSys008Event  event = null;
	GeneralEventResponse eventResponse = null;
	DBRowSet rowSet	  = null;
	int rowCount	 = 0;
	Exception serverException   = null;			//서버에서 발생한 에러
	
	String strErrMsg = "";								 //에러메세지
	String strErrCode = "";
	String usr_role_cd = (request.getParameter("usr_role_cd").equals(null))? "":request.getParameter("usr_role_cd");
	String usr_role_nm = "";


	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);

		event = (ComSys008Event)request.getAttribute("Event");		
		
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
		    ErrorHandler errHndlr = new ErrorHandler(serverException);
				strErrMsg = errHndlr.loadPopupMessage();
				strErrCode = errHndlr.getCode();
		}else{
			eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
			if (eventResponse != null) {
				rowSet = eventResponse.getRs();
				if(rowSet != null){
					 rowCount = rowSet.getRowCount();
				} // end if
			} // end if
		}// end else
	}catch(Exception e) {
	    out.println(e.getMessage());
	}
%>

<%@page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%><html>
<head>
<title>Role Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
<!-- 
showErrMessage를 써주지 않으면 에러 발생시 처리가 불가합니다.
그리고 지금은 showErrMessage()으로 되어있지만 추후에 고객님이 변덕을 일으켜서 웹페이지를 호출하라고 할경우를 
대비해서 직접 showErrMessage() 하지 마시고 꼭 showErrMessage를 써주십시오. 한방에 바꾸게요. 표준을 안따르면 나중에 후회합니다.  
-->


<body class="popup_bg" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form name="form" onKeyDown="ComKeyEnter()">
<input type="hidden" name="f_cmd">

<table width="100%" class="popup" cellpadding="10"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="img/icon_title_dot.gif" align="absmiddle"> Role Inquiry</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- TABLE '#D' : ( Search Options : Scenario ID ) (S) -->
		<table class="search"> 
			<tr>
				<td class="bg">



				<!-- : ( Scenario ID ) (S) -->
				<table class="search" border="0" style="width:100%"> 
				<tr class="h23">
					<td width="90">Role Code</td>
					<td width="100"><input type="text" name="usr_role_cd" value="<%=usr_role_cd%>" style="width:50;ime-mode:disabled" maxlength="5" dataformat="engup" onKeyPress="javascript:ComKeyOnlyAlphabet('uppernum');"></td>
					<td width="80">Role Name</td>
					<td width=""><input type="text" name="usr_role_nm" value="<%=usr_role_nm%>" style="width:270"></td>					
				</tr>
				</table>
				<!-- : ( Scenario ID ) (E) -->
				
			
		<!-- TABLE '#D' : ( Search Options : Scenario ID ) (E) --> 	

	

		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
		
			
			<!-- : ( Grid ) (S) -->
			<!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' , 
				 'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->
	
				<table width="100%" id="mainTable">
                    <tr><td>
                    	<script language="javascript">ComSheetObject('sheet1');</script>
                	</td></tr>
		        </table>

				<table width="100%" class="button"> 
		       		<tr><td class="btn2_bg">
					<table border="0" cellpadding="0" cellspacing="0">
							<td width="100">
							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr>
									<td class="btn2_left"></td>
									<td class="btn2" name="btn2_Down_Excel">Down Excel</td>
									<td class="btn2_right"></td>
								</tr>
							</table>
							</td>
					</table>
			<!-- : ( Grid ) (E) -->
					</td></tr>			
				</table>
		
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
		<table class="height_5"><tr><td></td></tr></table>

		</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options : Scenario ID ) (E) -->

</td></tr></table>
		

<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="search">
<tr><td height="71" class="popup">

			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_New">New</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_OK">OK</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					
					<td class="btn1_line"></td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_Close">Close</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					
				</tr>
				</table>
			</td>
			</tr>
		</table>

	</td></tr>
</table>
<!-- : ( Button : Sub ) (E) -->

</form>
</body>
</html>

 <%@include file="../../../../../bizcommon/include/common_alps.jsp"%>