<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_PRD_0032.jsp
*@FileTitle : OceanRoute Auto Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-26
*@LastModifier : kimyoungchul
*@LastVersion : 1.0
* 2006-09-26 kimyoungchul 
* 1.0 최초 생성
* 2011.09.19 변종건 [CHM-201113069-01] Ocean Route Management상의 Auto & Multi Creation 화면 관련 변경사항
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.event.EsdPrd0032Event"%>

<%
	EsdPrd0032Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	DBRowSet rowSet	  = null;							   //DB ResultSet
	String strErrMsg = "";								 //에러메세지
	int rowCount	 = 0;								  //DB ResultSet 리스트의 건수
	//String successFlag = "";
	//String codeList  = "";
	//String pageRows  = "100";

	try {

	   //SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   //userId=account.getUsr_id();
	   //userAuth=account.getAuth();



		event = (EsdPrd0032Event)request.getAttribute("Event");

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
<title>Ocean Route Creation - Auto Creation</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();

//		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);

	}
</script>
</head>


<body onload="javascript:setupPage();">
<form method="post" name="form">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="pol_port_cd" value="<%=event.getSearchOceanRouteAutoCreationVO().getPolPortCd()%>">
<input type="hidden" name="pod_port_cd" value="<%=event.getSearchOceanRouteAutoCreationVO().getPodPortCd()%>">
<input type="hidden" name="tnk_lane_cd" value="<%=event.getSearchOceanRouteAutoCreationVO().getTnkLaneCd()%>">
<!-- OUTER - POPUP (S)tart -->
<table width="1000" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;Ocean Route Creation - Auto Creation</td></tr>
		</table>
		<!-- : ( Title ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>
		<table class="search">
			<tr>
				<td class="bg">
					<!-- : ( Grid ) (S) -->
                    <table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet1');</script>
                        </td></tr>
                    </table>
					<!-- : ( Grid ) (E) -->
					<!-- Button : Sub (S) -->
					<table width="100%" class="button">
				       	<tr>
				       		<td class="btn2_bg">
								<table border="0" cellpadding="0" cellspacing="0">
									<tr>
										<!-- Repeat Pattern -->
										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td><td class="btn2" name="btng_toggle" id="btng_toggle">Toggle</td><td class="btn2_right"></td></tr></table></td>
										<!-- Repeat Pattern -->
									</tr>
								</table>
							</td>
						</tr>
					</table>
					<!-- Button : Sub (E) -->

					</td>
				</tr>
			</table></td>

	</tr>

</table>
<table class="height_10"><tr><td></td></tr></table>
<table width="100%" class="sbutton">
	<tr><td height="71" class="popup">
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       		<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<!-- Repeat Pattern -->
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_ok" id="btn_ok">Ok</td><td class="btn1_right"></td></tr></table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
				<!-- Repeat Pattern -->
			</tr>
			</table>
			</td></tr>
		</table>
	</td></tr>
</table>
<!-- OUTER - POPUP (E)nd -->
</form>
</body>
</html>
