<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_PRD_0035.jsp
*@FileTitle : OceanRoute Manual Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-25
*@LastModifier : kimyoungchul
*@LastVersion : 1.0
* 2006-09-25 kimyoungchul
* 1.0 최초 생성
* CSR : CHM-201005409-01 : OCEAN ROUTE CREATION시, Dummy Ocean Route 생성 방지를 위한 Validation 추가요청.
* 2011.09.19 변종건 [CHM-201113069-01] Ocean Route Management상의 Auto & Multi Creation 화면 관련 변경사항
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
<%@ page import="com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.event.EsdPrd0035Event"%>
<%
	EsdPrd0035Event  event = null;				//PDTO(Data Transfer Object including Parameters)

	Exception serverException   = null;			//서버에서 발생한 에러
	DBRowSet rowSet	  = null;							   //DB ResultSet
	String strErrMsg = "";								 //에러메세지
	int rowCount	 = 0;								  //DB ResultSet 리스트의 건수
	//String successFlag = "";
	//String codeList  = "";
	//String pageRows  = "100";

	try {
		event = (EsdPrd0035Event)request.getAttribute("Event");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
 
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}

	/****************************************************
	*  Local Variable
	*****************************************************/
	
	//String pol_cont_cd =  event.getString("pol_cont_cd");
	
	//String pod_cont_cd =  event.getString("pod_cont_cd");
	String pol_cont_cd = JSPUtil.getNull(event.getPolContCd());
	String pod_cont_cd = JSPUtil.getNull(event.getPodContCd());
	

%>
<%@include file="/apps/alps/esd/prd/common/prdcommon/jsp/ESD_PRD_AUTH.jsp"%>
<html>
<head>
<title>Ocean Route Creation - Manual Creation</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	function setupPage(){
		
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
			
		}
		
		loadPage();
	
	}
</script>
<script language="javascript">
 //parent화면 의 권한을 가져온다.
 //CHM-201005409-01 의거 추가 
var CRUD = "<%=JSPUtil.getParameter(request, "CRUD", "R")%>";
var OCN_FLG = "<%=JSPUtil.getParameter(request, "OCN_FLG", "")%>";
</script>
</head>


<body  onload="javascript:setupPage();">
<form method="post" name="form">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="pol_cont_cd"   value="<%=pol_cont_cd%>">
<input type="hidden" name="pod_cont_cd"   value="<%=pod_cont_cd%>">
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
				                     <script type="text/javascript">ComSheetObject('sheet1');</script>
				              </td></tr>
					</table>
					<!-- Grid : Week (E) -->

					<!-- Button : Sub (S) -->
					<table width="100%" class="button">
				       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td width="">Allow Exception <input name="expt_flag" type="checkbox" class="trans"  value="Y" unchecked  onClick="checkExptFlag()"> </td>
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" name="btng_rowadd" id="btng_rowadd">Row Add</td><td class="btn2_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" name="btng_rowcopy" id="btng_rowcopy">Row Copy</td><td class="btn2_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" name="btng_rowdel" id="btng_rowdel">Row Del</td><td class="btn2_right"></td></tr></table></td>
							<!-- Repeat Pattern -->


						</tr></table>
					</td></tr>
					</table>
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
	</td></tr>
</table>
</form>
</body>
</html>
