<%
/*========================================================= 
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_ctm_04.jsp
*@FileTitle : MVMT
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.12
*@LastModifier :
*@LastVersion : 1.0
* 2009.07.12
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
<%@ page import="com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.event.EesCtm0458Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesCtm0458Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
//	Logger log = Logger.getLogger("com.hanjin.apps.nis2010.ees.ctm.equipmentmovementmgt.containermovementmgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesCtm0458Event)request.getAttribute("Event");
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
<title>MVMT</title>
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
<input type="hidden" name="bkg_no" value='<%=request.getParameter("bkg_no")%>'>
<!-- 개발자 작업	-->

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="img/alps/ico_t1.gif" width="20" height="12">QTY Check</td></tr>
		</table>
		<!-- : ( Title ) (E) -->

		<!-- : ( Search Options ) (S) -->

			<table class="search">
       		<tr><td class="bg">
				<!-- : ( Grid ) (S) -->
					<table width="100%" class="search"  id="mainTable">
						<tr>
							<td width="100%">
							<script language="javascript">ComSheetObject('sheet');</script>
							</td>
						</tr>
					</table>
				<!-- : ( Grid ) (E) -->
		    <!-- : ( Button : Grid ) (E) -->

			</td></tr>
		</table>
<table class="height_5"><tr><td></td></tr></table>
<!-- : ( Search Options ) (E) -->
</td></tr>
</table>

<!-- : ( Button : pop ) (S) -->
<table width="100%" border="0" align="center" class="sbutton">
<tr><td height="71" class="popup" width="100%">
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       	<tr><td width="100%" >
		    <table border="0" cellpadding="0" cellspacing="0" align=center>
		    <tr><td align="center"><table  border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right"></td>
				</tr></table></td>
			</tr>
		</table></td>
			</tr>
		</table>
    <!--Button (E) -->

	</td></tr>
</table>


<!-- 개발자 작업  끝 -->
</form>
</body>
</html>