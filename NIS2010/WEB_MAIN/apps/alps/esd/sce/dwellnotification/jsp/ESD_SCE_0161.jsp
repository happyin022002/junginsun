<%--
/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESD_SCE_0161.jsp
*@FileTitle : SCEM - Candidate Inquiry by Dwell Type -96hrs Terminal Dwell
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.15
*@LastModifier : 채창호
*@LastVersion : 1.3
* 2011.07.06 채창호
* 1.0 최초 생성
*----------------------------------------------------------
* History

=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.net.URLEncoder"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.dwellnotification.event.EsdSce0160Event" %>
<%@ page import="com.hanjin.apps.alps.esd.sce.common.util.basic.CodeUtilBCImpl" %>
<%@ page import="com.hanjin.apps.alps.esd.sce.common.util.basic.CodeUtilBC" %>
<%@ page import="org.apache.log4j.Logger" %>
<%
EsdSce0160Event  event = null;				//PDTO(Data Transfer Object including Parameters)
Exception serverException   = null;			//서버에서 발생한 에러
String strErrMsg = "";								 //에러메세지
int rowCount	 = 0;								  //DB ResultSet 리스트의 건수

SignOnUserAccount account= null;
try {

   account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);

	event = (EsdSce0160Event)request.getAttribute("Event");

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
<title>96 hrs TMNL Dwell</title>
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
<form name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="search_dt">
<input type="hidden" name="sc_no">
<input type="hidden" name="sc_no2">
<input type="hidden" name="pod_cd">
<input type="hidden" name="rail_dest">
<input type="hidden" name="vvd">
<input type="hidden" name="rail_so_flg">
<input type="hidden" name="bkg_no">
<input type="hidden" name="bl_no">
<input type="hidden" name="cntr_no">
<input type="hidden" name="sent">
<input type="hidden" name="cust_cd">
<input type="hidden" name="del_cd">
<input type="hidden" name="dwll_tm_tp_cd" value ="T96">
<!-- Outer Table (S)-->
<table width="100%"  id="mainTable"> 
	<tr>
		<td width="100%">
			<script language="javascript">ComSheetObject('sheet1');</script>
		</td>
	</tr>
</table> 
</form>
</body>
</html>
<%@include file="/bizcommon/include/common_alps.jsp"%>
