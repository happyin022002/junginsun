<%--
/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ESD_SPE_1023.jsp
*@FileTitle : Evaluator Inquiry Choice
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.04
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.03.04 백형인
* 1.0 Creation
=========================================================*/ 
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.spe.common.popup.event.EsdSpe1023Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>
<%
	EsdSpe1023Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";								 //에러메세지
	
	Logger log = Logger.getLogger("com.hanjin.apps.Common.Popup");
	String rhq_cd           = StringUtil.xssFilter(request.getParameter("RHQ_CD"))        !=null&&!StringUtil.xssFilter(request.getParameter("RHQ_CD")).equals("")        ?StringUtil.xssFilter(request.getParameter("RHQ_CD")):"";
	String eg_ofc_cd        = StringUtil.xssFilter(request.getParameter("EG_OFC_CD"))     !=null&&!StringUtil.xssFilter(request.getParameter("EG_OFC_CD")).equals("")     ?StringUtil.xssFilter(request.getParameter("EG_OFC_CD")):"";		
	try {
		
		event = (EsdSpe1023Event)request.getAttribute("Event");
		
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		
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
        loadPage();
    }
</script>
</head>
<!-- 
showErrMessage를 써주지 않으면 에러 발생시 처리가 불가합니다.
그리고 지금은 showErrMessage()으로 되어있지만 추후에 고객님이 변덕을 일으켜서 웹페이지를 호출하라고 할경우를 
대비해서 직접 showErrMessage() 하지 마시고 꼭 showErrMessage를 써주십시오. 한방에 바꾸게요. 표준을 안따르면 나중에 후회합니다.  
-->


<!-- OUTER - POPUP (S)tart -->

<body class="popup_bg" onload="javascript:setupPage();">
<table width="100%" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->	
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Evaluator Inquiry Choice</td></tr>
		</table>
		<!-- : ( Title ) (E) -->


<form name="form" onkeyup="ComKeyEnter('lengthnextfocus');">
<input	type="hidden" name="f_cmd">
<input	type="hidden" name="efpt_ofc_cd" value = "<%=rhq_cd%>" >
<input	type="hidden" name="eg_ofc_cd"  value = "<%= eg_ofc_cd%>" >
		
		<!-- TABLE '#D' : ( Search Options : Scenario ID ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">


				<!-- : ( Scenario ID ) (S) -->
				<table class="search" border="0" style="width:735;">
				<tr class="h23">
					<td width="10%">Office Code</td>
					<td width="10%">
						<input type="text" name="ofc_cd" style="width:80%;ime-mode:disabled" dataformat="engup" >
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

<!--Button (S) -->
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
</form>
</body>
</html>

<%@include file="/bizcommon/include/common_alps.jsp"%>