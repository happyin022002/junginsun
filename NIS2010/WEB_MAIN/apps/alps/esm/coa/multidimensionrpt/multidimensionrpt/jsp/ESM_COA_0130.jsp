<%
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_COA_0130.jsp
*@FileTitle : ReportViewManagement
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.23
*@LastModifier : 박수훈
*@LastVersion : 1.0
* 2009.07.23 박수훈
* 1.0 Creation
* =========================================================
* History
* 2010.12.01 김기종 Ticket ID:CHM-201006305-01 COA Architecture 위배사항 수정 
* 2015.07.07 이윤정 [CHM-201536740] COA 내 화면의 조회 기능 (Retrieve, Down Excel)을 뺀 나머지 버튼들을 비활성화 요청 CSR
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.coa.multidimensionrpt.multidimensionrpt.event.EsmCoa0130Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	
	EsmCoa0130Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.MultiDimensionRPT.MultiDimensionRPT");

	
	String profitView = "";
	String office     = "";
	String profitLvl  = "";
	
	
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmCoa0130Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>ReportViewManagement</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
	
    function setupPage(){
	    loadPage();
    }
</script>
</head>

<body  onLoad="setupPage();">
<form name="form" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- OUTER - POPUP (S)tart -->
<table width="800" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr>
    <td valign="top">


			<!-- : ( Title ) (S) -->
			<table width="100%" border="0">
			<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp; Report View Management</td></tr>
			</table>
			<!-- : ( Title ) (E) -->


			<!-- : ( Search Options ) (S) -->
	     	<table class="search">
	       	<tr><td class="bg">

					<!-- : ( Grid ) (S) -->
						<table width="100%" id="mainTable">
	                        <tr><td>
	                             <script language="javascript">ComSheetObject('sheet1');</script>
	                        </td></tr>
			            </table>
					<!-- : ( Grid ) (E) -->

				</td></tr>
			</table>
			<!-- : ( Search Options ) (E) -->


    </td>
</tr>
</table>
<!-- OUTER - POPUP (E)nd -->

<table class="height_5"><tr><td></td></tr></table>


<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>

				<!-- Repeat Pattern -->
				<!--
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_Save" id="btn_Save">Save</td><td class="btn1_right"></td></tr></table></td>

				<td class="btn1_line"></td>
				-->
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_Close" id="btn_Close">Close</td><td class="btn1_right"></td></tr></table></td>
				<!-- Repeat Pattern -->

			</tr>
			</table>
		</td></tr>
		</table>
	</td></tr>	
</table>
<!-- : ( Button : pop ) (E) -->

</form>
</body>
</html>