<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0014.jsp
*@FileTitle : Service Order 생성화면 - Chassis or Genset
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-04
*@LastModifier : poong
*@LastVersion : 1.0
* 2006-10-04 poong
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
<%@ page import="com.hanjin.apps.alps.esd.trs.chassisgensetsomanage.chassisgensetsomanage.event.EsdTrs0014Event"%>
<%
	EsdTrs0014Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	DBRowSet rowSet	  = null;							   //DB ResultSet
	String strErrMsg = "";								 //에러메세지
	int rowCount	 = 0;								  //DB ResultSet 리스트의 건수

	try {

		event = (EsdTrs0014Event)request.getAttribute("Event");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		} // end else
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Detail Input Pop up</title>
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

<!-- OUTER - POPUP (S)tart -->
<table width="500" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="480" border="0">
		<tr>
			<td height="79" class="title"><img src="/hanjin/img/ico_t1.gif" width="20" height="12">Container File Import</td>
		</tr>
		</table>
		<!-- : ( Title ) (E) -->

		<table class="height_15"><tr><td></td></tr></table>

		<!-- : ( Search Options ) (S) -->
		<table class="search">
			<tr><td class="bg_a">

					<!-- : ( Grid ) (S) -->


				<!-- : ( From Location ) (S) -->
					<table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet1');</script>
                        </td></tr>
		            </table>
				<!-- : ( From Location ) (E) -->


					<!-- : ( Grid ) (E) -->


					<!-- : ( Button_ Sub ) (S) -->
					<table width="100%" class="sbutton">
						<tr>
							<td class="align">
								<table class="sbutton">
									<tr>
										<td class="bt"><img class="cursor" src="/hanjin/img/button/btng_fileimport.gif" width="75" height="19" border="0" name="btng_fileimport"></td>
										<td class="bt"><img class="cursor" src="/hanjin/img/button/btng_delete.gif" width="65" height="19" border="0" name="btng_delete"></td>
										<td class="bt"><img class="cursor" src="/hanjin/img/button/btng_verify.gif" width="65" height="19" border="0" name="btng_verify"></td>
										</tr>
								</table></td>
						</tr>
					</table>
					<!-- : ( Button_ Sub ) (E) -->


				</td>
			</tr>
		</table>
		<!-- : ( Search Options ) (E) -->



</td></tr>
</table>
<!-- OUTER - POPUP (E)nd -->



<table class="height_5"><tr><td></td></tr></table>


<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

		<table class="sbutton">
			<td class="p_bt"><img class="cursor" src="/hanjin/img/button/btn_close.gif" width="66" height="20" border="0" name="btn_close"></td></tr>
		</table>

	</td></tr>
</table>
<!-- : ( Button : Sub ) (E) -->
</form>
</body>
</html>
