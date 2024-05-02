<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_OPF_0207.jsp
*@FileTitle : COD Tariff Registration
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.29
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.07.29 김종옥
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
<%@ page import="com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.event.VopOpf0207Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>

<%
	VopOpf0207Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strIsPop			= StringUtil.xssFilter(request.getParameter("isPop"));

	Logger log = Logger.getLogger("com.hanjin.apps.ChangeOfDestinationMgt.ChangeOfDestinationMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopOpf0207Event)request.getAttribute("Event");
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
<title>COD Tariff Registration</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
    var sUserId = "<%=strUsr_id%>";
   
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
<input type="hidden" name="isPop" value="<%=strIsPop%>">
<!-- 개발자 작업	-->
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	<!-- : ( Title ) (S) -->
	<table width="100%" border="0">
	<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;COD Tariff Registration
	</td></tr>
	</table>
	<!-- : ( Title ) (E) -->
	
	<!-- : ( Search Options ) (S) -->
	<div id="tabLayer" style="display:none;">
	<!-- div id="tabLayer" -->
		<table class="search" id="mainTable"> 
	      	<tr><td class="bg">	
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
			<!-- Grid (E) -->			
			
			</td></tr>
		</table>
		<!--biz page (E)-->
	</div>
	
	<!-- TAB [ Gang Structure ] (E) -->
	<!-- div id="tabLayer" style="display:none" -->
	<div id="tabLayer">
		<table class="search" id="mainTable"> 
	      	<tr><td class="bg">	
			<!-- Grid  (S) -->
				<table width="100%" id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>
			<!-- Grid (E) -->			
			
			</td></tr>
		</table>
		<!--biz page (E)-->
	</div>
		<!-- table class="search"> 
   		<tr><td class="bg">
			<table width="100%" class="grid2"> 
			<tr class="tr2_head">
				<td width="100" rowspan="2">Region</td>
				<td width="" colspan="4">COD MIN. Tariff</td>
			</tr>
			<tr class="tr2_head2">
				<td width="100">20Ft</td>
				<td width="100">40Ft</td>
				<td width="100">Inter Port</td>
				<td width="100">Per B/L</td>
			</tr>	
			<tr>
				<td width="" class="tr2_head2">Asia</td>
				<td><input type="text" style="width:100%;text-align:right" class="noinput" name="A2" maxlength="5" dataformat="numonly" style="ime-mode:disabled" required fullfill></td>
				<td><input type="text" style="width:100%;text-align:right" class="noinput" name="A4" maxlength="5" dataformat="numonly" style="ime-mode:disabled" required fullfill></td>
				<td><input type="text" style="width:100%;text-align:right" class="noinput" name="AI" maxlength="5" dataformat="numonly" style="ime-mode:disabled" required fullfill></td>
				<td class="input2"></td>
			</tr>
			<tr>
				<td width="" class="tr2_head2">Europe</td>
				<td><input type="text" style="width:100%;text-align:right" class="noinput" name="E2" maxlength="5" dataformat="numonly" style="ime-mode:disabled" required fullfill></td>
				<td><input type="text" style="width:100%;text-align:right" class="noinput" name="E4" maxlength="5" dataformat="numonly" style="ime-mode:disabled" required fullfill></td>
				<td><input type="text" style="width:100%;text-align:right" class="noinput" name="EI" maxlength="5" dataformat="numonly" style="ime-mode:disabled" required fullfill></td>
				<td class="input2"></td>
			</tr>
			<tr>
				<td width="" class="tr2_head2">USA</td>
				<td class="input2"></td>
				<td class="input2"></td>
				<td class="input2"></td>
				<td><input type="text" style="width:100%;text-align:right" class="noinput" name="MP" maxlength="5" dataformat="numonly" style="ime-mode:disabled" required fullfill></td>
			</tr>
			</table> 
		</td></tr>
	</table-->
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
<% if(!strIsPop.equals("R")){ %>	    
		<td width="">
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
			<tr>
				<td class="btn1_left"></td>
				<td class="btn1" name="btn_ok">OK</td>
				<td class="btn1_right"></td>
			</tr>
			</table>
		</td>	
		<td class="btn1_line"></td>
<%} %>		
		
		<td width="">
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
			<tr>
				<td class="btn1_left"></td>
				<td class="btn1" name="btn_close">Close</td>
				<td class="btn1_right"></td>
			</tr>
			</table>
		</td></tr>
	</table>
   <!--Button (E) -->
</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
	</td></tr>
</table>	

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>