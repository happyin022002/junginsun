<%
/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EES_EQR_1051.jsp
*@FileTitle : Empty Bkg Container List
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.07
*@LastModifier : 신용찬
*@LastVersion : 1.0
* 2013.08.07 신용찬
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
<%@ page import="com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.event.EesEqr1051Event"%>
<%@ page import="com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.vo.EesEqr1051ConditionVO" %>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EesEqr1051Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";								 //에러메세지
	int rowCount	 = 0;								  //DB ResultSet 리스트의 건수

    String bkgno = "";
    String vvd   = "";
    String polcd = "";
    String podcd = "";

	try {

		event = (EesEqr1051Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		EesEqr1051ConditionVO conditionVO = event.getEesEqr1051ConditionVO();
		
		bkgno	= conditionVO.getBkgno();
		vvd     = conditionVO.getVvd();
		polcd   = conditionVO.getPolcd();
		podcd   = conditionVO.getPodcd();

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}

%>
<html>
<head>
<title>Container Information</title>
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

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="setupPage();">
<form method="post" name="form">
<input  type="hidden" name="f_cmd">
<input  type="hidden" name="iPage">
<input  type="hidden" name="bkgno" value="<%=bkgno%>">
<input  type="hidden" name="vvd"   value="<%=vvd%>">
<input  type="hidden" name="polcd" value="<%=polcd%>">
<input  type="hidden" name="podcd" value="<%=podcd%>">

<!-- OUTER - POPUP (S)tart -->
<table width="800" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;Container Information</td></tr>
		</table>
		<!-- : ( Title ) (E) -->

		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
				<tr><td class="btn1_bg">

						<table border="0" cellpadding="0" cellspacing="0">
						<tr>						
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table>
							</td>


							<!-- Repeat Pattern -->

						</tr></table>

				</td></tr>
				</table>
    	<!-- TABLE '#D' : ( Button : Main ) (E) -->



		<!-- : ( Search Options ) (S) -->
		<table class="search">
			<tr><td class="bg">

				<!-- : ( Scenario ID ) (S) -->
				<table class="search" border="0" id="mainTable" style="width:100%;">
				<tr class="h23">
					<td width="200">Bkg No : <%=bkgno%></td>
					<td >VVD : <%=vvd%></td>

				</tr>		
				</table>

				</td>
			</tr>



		</table>
		<!-- : ( Search Options ) (E) -->


		<table class="height_10"><tr><td></td></tr></table>

		<table class="search">
			<tr>
				<td class="bg">

					<table class="search"><tr><td class="height_2"></td></tr></table>

					<!-- : ( Grid ) (S) -->
                    <table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet1');</script>
                        </td></tr>
                    </table>
					<!-- : ( Grid ) (E) -->

				</td>
			</tr>
		</table>
</td></tr>
</table>
<!-- OUTER - POPUP (E)nd -->


<table class="height_10"><tr><td></td></tr></table>


<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton">
		<tr><td height="71" class="popup">

			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
	       		<tr><td class="btn3_bg">
			    <table border="0" cellpadding="0" cellspacing="0">
			    <tr>

					<!-- Repeat Pattern -->
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close" onClick="javascript:closeWindow();">Close</td><td class="btn1_right"></td></tr></table></td>
					<!-- Repeat Pattern -->

				</tr>
			</table>

		</td></tr>
</table>

</form>
</body>
</html>