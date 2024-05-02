<%-- 
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_PRD_0006.jsp
*@FileTitle : Route List 정보조회 
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-22
*@LastModifier : jungsunyong
*@LastVersion : 1.0
* 2006-09-22 jungsunyong
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
<%@ page import="com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.event.EsdPrd0006Event"%>

<%
	EsdPrd0006Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	
	Exception serverException   = null;			//서버에서 발생한 에러
	DBRowSet rowSet	  = null;							   //DB ResultSet
	String strErrMsg = "";								 //에러메세지
	int rowCount	 = 0;								  //DB ResultSet 리스트의 건수
	

	try {

	   //SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   //userId=account.getUsr_id();
	   //userAuth=account.getAuth(); 
	   
	   

		event = (EsdPrd0006Event)request.getAttribute("Event");

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
<title>Route List 정보조회 </title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if

		loadPage();
	}
</script>
</head>


<body onload="javascript:setupPage();">
<form method="post" name="form" >
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="r_inbound" value="<%=JSPUtil.getNull(event.getInlandRouteSelCreVO().getRInbound()) %>">
<input type="hidden" name="nod_tp1" value="<%=JSPUtil.getNull(event.getInlandRouteSelCreVO().getNodTp1()) %>">
<input type="hidden" name="nod_tp2" value="<%=JSPUtil.getNull(event.getInlandRouteSelCreVO().getNodTp2()) %>">

<!-- OUTER - POPUP (S)tart -->
<table width="800" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;Route List Inquiry</td></tr>
		</table>
		<!-- : ( Title ) (E) -->

		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
				<tr><td class="btn1_bg">

						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_new">New</td><td class="btn1_right"></td></tr></table></td>
							<!-- Repeat Pattern -->

						</tr></table>

				</td></tr>
		</table>
    	<!-- TABLE '#D' : ( Button : Main ) (E) -->



		<!-- : ( Search Options ) (S) -->
		<table class="search">
			<tr><td class="bg">

				<table class="search" border="0">
						<tr class="h23">
							<td width="7%"><img class="nostar">Origin</td>
							<td width="23%"><input class="input1" name="i_org_cd" maxlength="7" type="text" style="width:130" value=""  dataformat="engup"> <!-- onChange="validateLocation(this.value,1);" --></td>
							<td width="12%"><img class="nostar">Destination</td>
							<td width="25%"><input class="input1" name="i_dest_cd" maxlength="7" type="text" style="width:130" value="" dataformat="engup"> <!-- onChange="validateLocation(this.value,2);" --></td>
							<td width="33%"></td>
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
					<!-- : ( Grid ) (S) -->
					<table width="100%" id="mainTable">
				              <tr><td>
				                     <script type="text/javascript">ComSheetObject('sheet1');</script>
				              </td></tr>
					</table>
					<!-- : ( Grid ) (E) -->

					</td>
				</tr>
			</table></td>
</tr>
</table>
<!-- OUTER - POPUP (E)nd -->



<table class="height_10"><tr><td></td></tr></table>


<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton">
		<tr><td height="71" class="popup">

		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;padding-bottom:10;">
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
<!-- : ( Button : Sub ) (E) -->
</form>
</body>
</html>

<script type="text/javascript">
<!--

	  /*
		ibSheet 를 제외한 폼 입력값(?) 유저가 입력한 정보를 event를 통해서 다시 넘겨받아 화면에 뿌려주는 부분입니다.
	  */
	  with(document.form)
	  {
		<%
		if(event != null){
			   String org_cd   =event.getInlandRouteSelCreVO().getIOrgCd();
			   String dest_cd   =event.getInlandRouteSelCreVO().getIDestCd();
			   String rInbound   =event.getInlandRouteSelCreVO().getRInbound();
			   String nod_tp1   =event.getInlandRouteSelCreVO().getNodTp1();
			   String nod_tp2   =event.getInlandRouteSelCreVO().getNodTp2();
		%>
		eval("i_org_cd" ).value = "<%=JSPUtil.getNull(org_cd)%>";
		eval("i_dest_cd" ).value = "<%=JSPUtil.getNull(dest_cd)%>";
		eval("r_inbound" ).value = "<%=JSPUtil.getNull(rInbound)%>";
		eval("nod_tp1" ).value = "<%=JSPUtil.getNull(nod_tp1)%>";
		eval("nod_tp2" ).value = "<%=JSPUtil.getNull(nod_tp2)%>";
		<% } %>
	   }
-->
</script>