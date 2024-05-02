<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_scg_0024.jsp
*@FileTitle : Systematic Inspection Filtering Text
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.25
*@LastModifier : 김도현
*@LastVersion : 1.0
* 2015.06.24 김도현
* 1.0 Creation

*history
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.event.VopScg0024Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopScg0024Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	Logger log = Logger.getLogger("com.hanjin.apps.CargoLoadingApproval.OwnDangerousCargoApproval");

	try {
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
<title>Booking Description of Goods Detail</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		
		var openerObj = window.dialogArguments;
		document.getElementById('content').innerHTML = openerObj.document.form.content.value;
		
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr>
		<td valign="top">
			<table class="search">
		       	<tr>
		       		<td width="" id='content'></td>
				</tr>
			</table>
		</td>
	</tr>
</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>