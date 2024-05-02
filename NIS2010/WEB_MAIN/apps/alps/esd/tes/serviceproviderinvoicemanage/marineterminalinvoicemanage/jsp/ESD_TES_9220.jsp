<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_9220.jsp
*@FileTitle : Get Container List Pop Up
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-08
*@LastModifier : parkyeonjin
*@LastVersion : 1.0
* 2006-11-08 parkyeonjin
* 1.0 최초 생성
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event.EsdTes9220Event"%>
<%

	Exception serverException   = null;			//서버에서 발생한 에러
	DBRowSet rowSet	  = null;							   //DB ResultSet
	String strErrMsg = "";								 //에러메세지
	int rowCount	 = 0;								  //DB ResultSet 리스트의 건수

	try {
	   //SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   //userId=account.getUsr_id();
	   //userAuth=account.getAuth();

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{

		} // end else
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Accumulate Vol List Pop Up</title>
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

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="vndr_seq">
<input type="hidden" name="yd_cd">

<table width="500" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="480" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/ico_t1.gif" width="20" height="12">Accumulate Vol. Period Selection</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		<!-- TABLE '#D' : ( Button : Main ) (S) 
		<table width="100%" class="button">
			<tr>
				<td class="align">
				    <table class="button">
					    <tr><td><img class="cursor" src="/hanjin/img/button/btn_save.gif" width="66" height="20" border="0" name="btn_save"></td>
						</tr>
					</table></td>
			</tr>
		</table>-->
		<!-- TABLE '#D' : ( Button : Main ) (E) -->
		

		<!-- : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg_a">

				<!-- : ( Node / Link ) (S) -->
						<table width="100%" id="mainTable">
							  <tr><td>
							 <script language="javascript">ComSheetObject('sheet1');</script>
							  </td></tr>
						</table>
				<!-- : ( Node / Link ) (E) -->


			</td></tr>
		</table>
		<!-- : ( Search Options ) (E) -->



</td></tr>
</table>
<!-- OUTER - POPUP (E)nd -->



<table class="height_10"><tr><td></td></tr></table>

	<!-- : ( Button : Sub ) (S) -->
		<table width="100%" class="button">
				       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>

							<!-- Repeat Pattern -->
							<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn2_left"></td><td class="btn2" name="btn_save" id="btn_save">Save</td>
								<td class="btn2_right"></td>
							</tr>
							</table>
							</td>
							
							<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn2_left"></td><td class="btn2" name="btn_ok" id="btn_ok">Ok</td>
								<td class="btn2_right"></td>
							</tr>
							</table>
							</td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" name="btn_close" id="btn_close">Close</td>
							<td class="btn2_right"></td></tr></table></td>
							<!-- Repeat Pattern -->

						</tr></table>
					</td></tr>
				</table>
  	<!-- : ( Button : Sub ) (E) -->


</form>
</body>
</html>

