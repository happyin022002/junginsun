<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0775.jsp
*@FileTitle : Booking Status Report Result Print
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.10
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.09.10 김경섭
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
<%@ page import="org.apache.log4j.Logger" %>

<%
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.BookingReport.StatusReport");

	String rfn = JSPUtil.getParameter(request,"rfn","");
	String rp = JSPUtil.getParameter(request,"rp","");
	String rv = JSPUtil.getParameter(request,"rv","");
	String mrd = JSPUtil.getParameter(request,"mrd","");
	String title = JSPUtil.getParameter(request,"rd_title","");
	String rpost = JSPUtil.getParameter(request,"rpost","");
	String print_type = JSPUtil.getParameter(request,"print_type","");
%>
<html>
<head>
<title><%=title %></title>
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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="rfn" value="<%=rfn%>">
<input type="hidden" name="rpost" value="<%=rpost%>">
<input type="hidden" name="rp" value="<%=rp%>">
<input type="hidden" name="rv" value="<%=rv%>">
<input type="hidden" name="mrd" value="<%=mrd%>">
<input type="hidden" name="print_type" value="<%=print_type%>">
<!-- 개발자 작업	-->

<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
	<tr><td valign="top">
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; <%=title %></td></tr>
		</table>
		<!-- : ( Title ) (E) -->
</td></tr>
</table>		
<script language="javascript">comRdObject('Rdviewer');</script>

<!-- 개발자 작업  끝 -->
</form>


</body>
</html>
