<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_PRD_0040.jsp
*@FileTitle : OceanRoute Manual Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-25
*@LastModifier : kimyoungchul
*@LastVersion : 1.0
* 2006-09-25 kimyoungchul
* 1.0 최초 생성
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.event.EsdPrd0040Event"%>
<%
	EsdPrd0040Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	
	Exception serverException   = null;			//서버에서 발생한 에러
	DBRowSet rowSet	  = null;							   //DB ResultSet
	String strErrMsg = "";								 //에러메세지
	int rowCount	 = 0;								  //DB ResultSet 리스트의 건수
	
	try {

	   //SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   //userId=account.getUsr_id();
	   //userAuth=account.getAuth();

		event = (EsdPrd0040Event)request.getAttribute("Event");

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
<title>OceanRoute Manual Creation</title>
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


<body  onload="javascript:setupPage();">
<form method="post" name="form">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage" >
<input type="hidden" name="ori_loc" value="<%=JSPUtil.getNull(event.getSearchOceanLaneVO().getOriLoc()) %>" >
<input type="hidden" name="dest_loc" value="<%=JSPUtil.getNull(event.getSearchOceanLaneVO().getDestLoc()) %>" >
<input type="hidden" name="lane" value="<%=JSPUtil.getNull(event.getSearchOceanLaneVO().getLane()) %>" >
<input type="hidden" name="gubun" value="<%=JSPUtil.getNull(event.getGubun()) %>" >
<input type="hidden" name="sTsPort" value="<%=JSPUtil.getNull(event.getSTsPort()) %>" >
<input type="hidden" name="isLastPod" value="<%=JSPUtil.getNull(event.getIsLastPod()) %>" >

<!-- OUTER - POPUP (S)tart -->
<table width="800" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">


		<!-- ####### PART 'D' ::: 'RIGHT' FRAME (START) ####### -->

		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;Ocean Route Creation - Manual Creation</td></tr>
		</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->


		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Grid BG Box ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg">

					<table class="height_10"><tr><td></td></tr></table>

					<!-- Grid : Week (S) -->
					<!-- 'HEAD1-BGCOLOR : 192 235 163' , 'HEAD2-BGCOLOR : 231 250 249' , 'BORDER : 90 138 158' , 'HEAD1-FONT : 0 83 116' , 'DATA GRID BG (2 colors) : 255 255 255, 249 249 249 ' -->
					<table width="100%" id="mainTable">
				              <tr><td>
				                     <script language="javascript">ComSheetObject('sheet1');</script>
				              </td></tr>
					</table>
					<!-- Grid : Week (E) -->

					<!-- Button : Sub (S) -->

					<!-- Button : Sub (E) -->
				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Grid BG Box ) (E) -->

		<!-- ####### TABLE '#D' ::: 'RIGHT' FRAME (END) ####### -->

</td></tr>
</table>
<!-- OUTER FRAME : "to make sum of components' HEIGHTS 100%" (E)nd -->

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
</form>
</body>
</html>
