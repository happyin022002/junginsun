<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0975.jsp
*@FileTitle : S/O History 조회하는 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2011-06-28
*@LastModifier : eunju Son
*@LastVersion : 1.0
* 2011-06-28 eunju Son
* 1.0 최초 생성
* 2011.06.28 손은주 [CHM-201111573-01]	[TRS] S/O history function 추가 요청

=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.trs.soinquiry.soinquiry.event.EsdTrs0019Event"%>
<%
	EsdTrs0019Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	DBRowSet rowSet	  = null;							   //DB ResultSet
	String strErrMsg = "";								 //에러메세지
	int rowCount	 = 0;								  //DB ResultSet 리스트의 건수
	String soNo = "";
	SignOnUserAccount account= null;

	try {

	   soNo = request.getParameter("so_no")==null?"":request.getParameter("so_no");
	   account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);

		event = (EsdTrs0019Event)request.getAttribute("Event");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
			} // end if
		// end else
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>S/O Inquiry - S/O History</title>
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


<body onLoad="setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="sonumber" value="<%=soNo %>">


<!-- OUTER - POPUP (S)tart -->
<table width="930" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp; S/O History</td></tr>
		</table>
		<!-- : ( Title ) (E) -->


		<!-- TABLE '#D' : ( Search Options ) (E) -->
		<!-- : ( Search Options ) (S) -->
		<table class="search">
			<tr><td class="bg">

				<!-- : ( Grid ) (S) -->
				<table width="100%" id="mainTable">
			              <tr><td><script language="javascript">ComSheetObject('sheet1');</script></td></tr>
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

<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>

				<!-- Repeat Pattern -->
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
				<!-- Repeat Pattern -->

			</tr>
		</table>

	</td></tr>
</table>
<!-- : ( Button : Sub ) (E) -->


</form>

</body>
</html>
