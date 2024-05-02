<%
/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EES_EQR_1050.jsp
*@FileTitle : Empty ROB Bkg VVD List
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.07
*@LastModifier : 
*@LastVersion : 1.0
* 2013.03.07 
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.event.EesEqr1050Event"%>
<%@ page import="com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.vo.EesEqr1050ConditionVO" %>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EesEqr1050Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";								 //에러메세지
	int rowCount	 = 0;								  //DB ResultSet 리스트의 건수

    String bkgno = "";
    String vvd   = "";
    String polcd = "";
    String podcd = "";

	try {

		event = (EesEqr1050Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		EesEqr1050ConditionVO conditionVO = event.getEesEqr1050ConditionVO();
		
		bkgno	= conditionVO.getBkgNo();

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}

%>
<html>
<head>
<title>MTY ROB VVD Detail</title>
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
<input  type="hidden" name="bkg_no" value="<%=bkgno%>">

<!-- OUTER - POPUP (S)tart -->
<table width="645" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/opuscntr/img/icon_title_dot.gif" align="absmiddle">&nbsp;MTY ROB VVD Detail</td></tr>
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