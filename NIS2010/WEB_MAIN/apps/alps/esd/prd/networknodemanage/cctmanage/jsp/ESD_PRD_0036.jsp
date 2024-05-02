<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_PRD_0036.jsp
*@FileTitle : Yard별 CCT
*Open Issues :
*Change history :
*@LastModifyDate : 2009-02-16
*@LastModifier : sun yong jeong
*@LastVersion : 1.0
* 2009-06-08 sun yong jeong
* 1.0 최초 생성
* CSR: N200903040130 20090608 e-NIS CCT MGMT by Yard UI 수정 관련 PRD SKD Logic 보완
=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse" %>
<%@ page import="com.hanjin.apps.alps.esd.prd.networknodemanage.cctmanage.event.EsdPrd0036Event"%>

<%@ page import="java.util.List" %>
<%
	GeneralEventResponse eventResponse = null;	//RDTO(Data Transfer Object including DB ResultSet)
	Exception serverException   = null;			//서버에서 발생한 에러
    List list = null;
	String strErrMsg = "";								 //에러메세지
//	int rowCount	 = 0;								  //DB ResultSet 리스트의 건수
	String locCd ="";
	String mode = "";
	EsdPrd0036Event  event = null;				//PDTO(Data Transfer Object including Parameters)

	try {

	   //userId=account.getUsr_id();
	   //userAuth=account.getAuth();
		event = (EsdPrd0036Event)request.getAttribute("Event");
	    mode = JSPUtil.getNull(request.getParameter("mode"));
	    locCd = JSPUtil.getNull(request.getParameter("loc_cd"));
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
			eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
			if (eventResponse != null) {
				list = eventResponse.getRsVoList();
			} // end if
		} // end else
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<%@include file="/apps/alps/esd/prd/common/prdcommon/jsp/ESD_PRD_AUTH.jsp"%>
<html>
<head>
<title>Yard별 CCT</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	<%-- JSPUtil.getIBCodeCombo("cct_day", "01", "CD00131", 0,  "000010::|900010: :OneDayBeforeETB" )--%>
	<%= JSPUtil.getIBCodeCombo("cct_day", "01", "CD00131", 0,  "000010::" )%>
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		locCd = "<%=locCd%>";
		mode = "<%=mode%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if

		loadPage();
	}
</script>
</head>
<body onload="javascript:setupPage();">
<form method="post" name="form">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->


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
							<td class="btn1_line"></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_save" id="btn_save">Save</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_loadexcel" id="btn_loadexcel">Load Excel</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>

							<!-- Repeat Pattern -->

						</tr></table>

				</td></tr>
		</table>
		<!-- TABLE '#D' : ( Button : Main ) (E) -->



		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="65"><img class="nostar">Country</td>
							<td width="140"><input name="country_code" type="text" style="width:30" maxlength="2" value="" dataformat="engup">
								<img class="cursor" src="/hanjin/img/button/btns_search.gif" name="btn_cnt"  width="19" height="20" border="0" align="absmiddle"></td>
							<td width="60">Location</td>
							<td width="170"><input name="location_code" type="text" style="width:60" maxlength="5" value="<%=locCd%>" dataformat="engup">
								<img class="cursor" src="/hanjin/img/button/btns_search.gif" name="loc_btn" width="19" height="20" border="0" align="absmiddle"></td>
							<td width="35">Yard</td>
							<td width="190"><input name="yard_code" type="text" style="width:70" maxlength="7" value="" dataformat="engup">
								<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="node_btn"></td>
							<td width="35">Lane</td>
							<td width="170"><input name="lane_code" type="text" style="width:60" maxlength="3" value="" dataformat="engup">
								<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_slan" ></td>
							<td width="50">Status</td>
							<td width=""><select name="status_code" style="width:60">
								<option value="ALL" selected>All</option>
								<option value="N" >Live</option>
								<option value="Y" >Delete</option>
								</select></td>
					</tr>
					</table>
				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Grid BG Box ) (S) -->
		<table class="search" border="0">
			<tr><td class="bg">
					<table width="100%" id="mainTable">
						<tr>
							<td>
	                             <script type="text/javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table>


					<!-- Button : Sub (S) -->
					<table width="100%" class="button">
				       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>

							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" name="btng_rowadd" id="btng_rowadd">Row Add</td><td class="btn2_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" name="btng_rowcopy">Row Copy</td><td class="btn2_right"></td></tr></table></td>
							<!-- Repeat Pattern -->


						</tr></table>
					</td></tr>
					</table>
					<!-- Button : Sub (E) -->
				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Grid BG Box ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>

    </td></tr>
</table>
<!-- Outer Table (E)-->

</form>
</body>
</html>
