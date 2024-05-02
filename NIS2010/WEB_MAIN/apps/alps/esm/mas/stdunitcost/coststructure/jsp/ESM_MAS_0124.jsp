<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_MAS_0124.jsp
*@FileTitle : So Cost Code Column hide
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.31
*@LastModifier : 임옥영
*@LastVersion : 1.0
* 2009.07.31 임옥영
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.event.EsmMas0124Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	Logger log = Logger.getLogger("com.hanjin.apps.StdUnitCost.CostStructure");

	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	} catch(Exception e) {
		log.debug(e.toString());
		out.println(e.toString());
	}
%>

<html>
<head>
<title>So Cost Code Column hide</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		setDataFromParentHeader();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">

<!-- OUTER - POPUP (S)tart -->
<table width="300" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp; So Cost Code Column hide</td></tr>
		</table>
		<!-- : ( Title ) (E) -->

		<!--1 Start-->
		<!-- : ( Search Options ) (S) -->
		<table class="search" align="center" >
			<tr><td class="bg">


			<!-- UI_ESS_EQR_010 : THIS IS 1st TAB -->
			<!-- : ( Level Group ) (E) -->
			<table width="100%" id="mainTable">
				<tr><td>
					 <script language="javascript">ComSheetObject('sheet1');</script>
				</td></tr>
			</table>

			<!-- : ( Level Group ) (E) -->
		</td></tr>
		</table>
		<!-- : ( Search Options ) (E) -->
<!--1 End-->

</td></tr>
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
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
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