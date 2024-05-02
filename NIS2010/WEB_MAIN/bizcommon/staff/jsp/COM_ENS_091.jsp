<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : COM_ENS_091.jsp
*@FileTitle : VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-31
*@LastModifier : Hyung Choon_Roh
*@LastVersion : 1.0
* 2006-10-31 Hyung Choon_Roh
* 1.0 최초 생성
=========================================================*/ 
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.bizcommon.staff.event.ComEns091Event"%>
<%
	ComEns091Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";								 //에러메세지
	String main_page = "";
	try {
		
		event = (ComEns091Event)request.getAttribute("Event");
		
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		main_page = JSPUtil.getParameter(request, "main_page".trim(), "");
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		if(event.getOfc_cd().equals("")){
			event.setOfc_cd(account.getOfc_cd());
		}
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Staff</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        
		// 탭을 사용하는 화면인 경우 추가한다.
        // InitTab();
        loadPage(<%=main_page%>);
    }
</script>
</head>
<!-- 
showErrMessage를 써주지 않으면 에러 발생시 처리가 불가합니다.
그리고 지금은 showErrMessage()으로 되어있지만 추후에 고객님이 변덕을 일으켜서 웹페이지를 호출하라고 할경우를 
대비해서 직접 showErrMessage() 하지 마시고 꼭 showErrMessage를 써주십시오. 한방에 바꾸게요. 표준을 안따르면 나중에 후회합니다.  
-->


<!-- OUTER - POPUP (S)tart -->
<%if(main_page.equals("true")){ %>
<body onload="javascript:setupPage();">
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->
		
<%} else { %>
<body class="popup_bg" onload="javascript:setupPage();">
<table width="100%" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->	
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Staff Inquiry</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
<%} %>

<form name="form" onkeyup="ComKeyEnter('lengthnextfocus');">
<input	type="hidden" name="f_cmd">
		
		<!-- TABLE '#D' : ( Search Options : Scenario ID ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">


				<!-- : ( Scenario ID ) (S) -->
				<table class="search" border="0" style="width:735;">
				<tr class="h23">
					<td width="10%">Office Code</td>
					<td width="10%">
						<input type="text" name="ofc_cd" style="width:80%;ime-mode:disabled" dataformat="engup">
					</td>
					<td width="8%">User Code</td>
					<td width="11%"><input type="text" name="user_cd" style="width:80%">
					<td width="8%">User Name</td>
					<td width="42%"><input type="text" name="user_nm" style="width:340;"></td></tr>


				</table>
				<!-- : ( Scenario ID ) (E) -->

			
		<table class="line_bluedot"><tr><td></td></tr></table>
		
				<table width="100%" class="search">
				<tr><td width="300" valign="top">
						<table style="height:21"><tr><td></td></tr></table>
						<table class="search" width="300" height="100%">
							<tr><td>
								<script language="javascript">ComSheetObject('sheetDept');</script>
							</td></tr>
						</table>
					</td>
					<td width="15"></td>
					<td width="420" valign="top">
						<!-- : ( Grid ) (S) -->
						
					<table width="100%" id="mainTable">
                        <tr><td style="padding-top:6">
                             <script language="javascript">ComSheetObject('sheetUser');</script>
                        </td></tr>
		            </table>

							<!-- : ( Grid ) (E) -->
					<table width="100%" class="button"> 
			       		<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<td width="100"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn2_Down_Excel">Down Excel</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
					</table>
				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
</td></tr>
</table> 
<table class="height_5"><tr><td></td></tr></table>

</td></tr>
</table>
<!-- OUTER - POPUP (E)nd -->

<%if(!main_page.equals("true")){ %>
<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton">
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
<%}else{ %>
<!--Button (S) -->
<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
     	<tr><td class="btn1_bg">

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
		</tr>
	</table>
</td></tr>
</table>
<%} %>
</form>
</body>
</html>

<SCRIPT LANGUAGE="javascript">
<!--
	  
	  /* 
		ibSheet 를 제외한 폼 입력값(?) 유저가 입력한 정보를 event를 통해서 다시 넘겨받아 화면에 뿌려주는 부분입니다. 
	  */
	  with(document.form)
	  {
		<%
		if(event != null){ 
			   String ofc_cd   =event.getOfc_cd();
			   String user_cd   =event.getUser_cd();
			   String user_nm   =event.getUser_nm();
		%>
		eval("ofc_cd" ).value = "<%= ofc_cd	 %>";
		eval("user_cd" ).value = "<%= user_cd	 %>";
		eval("user_nm" ).value = "<%= user_nm	 %>";
		<% } %>
	   }
-->
</SCRIPT>
<%@include file="../../include/common_alps.jsp"%>