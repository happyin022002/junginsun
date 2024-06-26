<%
/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESD_TES_2009.jsp
*@FileTitle : Irregular Report Designer
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.31
*@LastModifier : Kim Yong Jin
*@LastVersion : 1.0
* 2011.03.31 Kim Yong Jin
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
<%@ page import="com.hanjin.apps.alps.esd.tes.guaranteemanage.irregularmanage.event.EsdTes2009Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
String irr_no = JSPUtil.getNull(request.getParameter("irr_no"));
Exception serverException   = null;			//서버에서 발생한 에러
String strErrMsg = "";								 //에러메세지
try {
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
<title>Irregular Report Preview</title>
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
<input type="hidden" name="irr_no" value="<%=irr_no %>">
<!-- 개발자 작업	-->

<input type="hidden" name="iPage">
<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>

		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) >
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		< TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->


		<!-- TABLE '#D' : ( Button : Main ) (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
		       	<tr><td class="btn1_bg">

					<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<!-- Repeat Pattern -->

						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td><td class="btn1" id="btn_print" name="btn_print">Print</td><td class="btn1_right"></td></tr></table></td>
					</tr></table>
				</td></tr>
			</table>
    	<!-- TABLE '#D' : ( Button : Main ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Grid ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<table class="search"><tr><td class="height_10"></td></tr></table>

				<!-- TABLE '#E' : ( Graph BG ) (S) -->
		     	<table class="search" border="0" style="width:100%;">
		       	<tr>
		       		<td class="bg_b2" style="padding:0;" height="600"><script language="javascript">comRdObject('Rdviewer1');</script></td>
				</tr>
				</table>
				<!-- TABLE '#E' : ( Graph BG ) (E) -->

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Grid ) (E) -->

    </td></tr>
</table>
<!-- Outer Table (E)-->
<div id="div_sheet" style="display:none;">
<table width="100%" id="hiddenTable">
    <tr><td>
         <script language="javascript">ComSheetObject('sheet');</script>
    </td></tr>
</table>
</div>
</form>
</body>
</html>