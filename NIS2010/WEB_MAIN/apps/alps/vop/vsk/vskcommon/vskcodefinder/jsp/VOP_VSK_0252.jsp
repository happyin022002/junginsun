<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0252.jsp
*@FileTitle : Other(s) Code Help
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.23
*@LastModifier : 정명훈
*@LastVersion : 1.0
* 2009.07.23 정명훈
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
<%@ page import="com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.event.VopVsk0252Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk0252Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.VSKCommon.VSKCodeFinder");
	
	String codeType = null;
	String codeValue = null;

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopVsk0252Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		codeType = request.getParameter("code_type");
		codeType = codeType==null?"":codeType;
		
		codeValue = JSPUtil.replaceForHTML(request.getParameter("code_value"));
		codeValue = codeValue==null?"":codeValue;
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Other(s) Code Help</title>
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

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Other(s) Code Inquiry </td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 			
		<table class="search"> 
       		<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table width="100%" class="search"> 
				<tr class="h23">
					<td width="65">Code Type</td>
					<td colspan="3" style="padding-left:2"><select style="width:210;" name="grd_nm" tabIndex="1">
						<option value="CD00717" <%="CD00717".equals(codeType)?"selected":"" %>>Lane Service Type</option>
						<option value="CD01827" <%="CD00827".equals(codeType)?"selected":"" %>>Voyage Type</option>
						<option value="CD01819" <%="CD01819".equals(codeType)?"selected":"" %>>Phase In/Out Reason</option>
						<option value="CD01830" <%="CD01830".equals(codeType)?"selected":"" %>>Delay Reason</option>
						<option value="CD0XXXX" <%="CD0XXXX".equals(codeType)?"selected":"" %>>Owner(Carrier)</option>
						</select></td>
				</tr>
				</table> 
				<table width="100%" class="search"> 
				<tr class="h23">
					<td width="65">Code</td>
					<td width="140" style="padding-left:2"><input type="text" style="width:100;ime-mode:disabled;text-align:left" class="input" name="code" id="code" maxlength="" dataformat="engup"  value="<%=codeValue%>"  tabIndex="2"></td>
					<td width="70">Code Name</td>
					<td width=""><input type="text" style="width:100%;ime-mode:disabled;text-align:left" class="input" name="name" maxlength="50" dataformat="engup" tabIndex="3"></td>

				</tr>
				</table> 
				<!--  biz_1   (E) -->
				<!-- : ( Grid ) (S) -->
					<table width="100%"  id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table>
				<!-- : ( Grid ) (E) -->	
			
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
				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right">
				</tr></table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Ok">OK</td>
					<td class="btn1_right">
				</tr></table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
					<td class="btn1_right">
				</tr></table></td>
			</tr>
			</table></td>
		</tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
<%@include file="/bizcommon/include/common_alps.jsp" %>