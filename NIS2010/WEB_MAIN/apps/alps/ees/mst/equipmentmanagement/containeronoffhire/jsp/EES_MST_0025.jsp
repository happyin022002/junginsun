
<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : EES_MST_0025.jsp
	 *@FileTitle : Container Status Creation-LST and FND
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.07.30
	 *@LastModifier : 민정호
	 *@LastVersion : 1.0
	 * 2009.07.30 민정호
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
<%@ page import="com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.event.EesMst0025Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EesMst0025Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String strOfc_cd = "";	
	Logger log = Logger
			.getLogger("com.hanjin.apps.EquipmentManagement.ContainerOnOffhire");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();				

		event = (EesMst0025Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request
				.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title><span id="title"></span></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		strOfcCd = "<%=strOfc_cd%>";		
		loadPage();
	}
</script>
</head>
<body onLoad="setupPage();">
<form name="form"><input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows"> 
<!-- 개발자 작업	-->
<input type="hidden" name="input_cntr_sts_evnt_dt">
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top: 2; padding-left: 5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr>
			<td class="history"><img src="img/icon_history_dot.gif"
				align="absmiddle"><span id="navigation"></span>
			</td>
		</tr>
		<tr>
			<td class="title"><img src="img/icon_title_dot.gif"
				align="absmiddle"><span id="title"></span></td>
		</tr>
	</table>
	<!--Page Title, Historical (E)-->
	<!--biz page (S)-->
	<!-- Grid BG Box  (S) -->
	<table class="search" id="mainTable">
		<tr><td class="bg">
			<table class="search" border="0" style="width: 979;">
				<tr class="h23">
					<td width="80">Status Code</td>
					<td width="210"><select style="width: 70;text-align:center;" class="input1" name="input_cntr_sts_cd">
					<% if (strOfc_cd.equals("SELCON")){ %>
						<option value="LST" selected>&nbsp&nbsp&nbspLST</option>
						<option value="FND">&nbsp&nbsp&nbspFND</option>
					<% } else {%>
						<option value="LST" selected>&nbsp&nbsp&nbspLST</option>
					<% }%>		
					</select></td>
					<td width="35">Date</td>
					<td width="170"><input type="text" style="width: 80"
						class="input1" dataformat="ymd" name="input_cntr_sts_evnt_dt2" style="ime-mode:disabled" maxlength="10" style="text-align:center">&nbsp;<img
						class="cursor" src="img/btns_calendar.gif" width="19" height="20"
						border="0" align="absmiddle" name="btns_calendar1"></td>
					<td width="37">Yard</td>
					<td width=""><input type="text" style="width:104" class="input1" dataformat="engup" name="input_onh_yd_cd" style="ime-mode:disabled" maxlength="7" style="text-align:center">&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="ComOpenPopupWithTarget1">&nbsp;<input type="text" style="width:225" class="input2" ReadOnly value="" name="yd_cd_nm" style="ime-mode:disabled"></td>					
				</tr>
			</table>
			</td>
		</tr>
	</table>
	<table class="height_8"><tr><td></td></tr></table>				
	<table class="search" id="mainTable">
		<tr>
			<td class="bg" style="height:455;" valign="top">
			<!-- Grid  (S) -->
			<table width="100%" id="mainTable">
				<tr>
					<td width="100%"><script language="javascript">ComSheetObject('sheet1');</script>
					<div style="display: none;"><script language="javascript">ComSheetObject('sheet2');</script></div>
					</td>
				</tr>
			</table>
			<!-- Grid (E) --> <!--  Button_Sub (S) -->
			<table width="100%" class="button">
				<tr>
					<td class="btn2_bg">
					<table border="0" cellpadding="0" cellspacing="0">
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_master">&nbsp;&nbsp;&nbsp;Master&nbsp;&nbsp;&nbsp;</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>						
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn2_left"></td>
								<td class="btn2" name="btn_add">Row Add</td>
								<td class="btn2_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn2_left"></td>
								<td class="btn2" name="btn_delete">Delete</td>
								<td class="btn2_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn2_left"></td>
								<td class="btn2" name="btn_downexcel">Format Down</td>
								<td class="btn2_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn2_left"></td>
								<td class="btn2" name="btn_loadexcel">Load Excel</td>
								<td class="btn2_right"></td>
							</tr>
						</table>
						</td>
					</table>
					</td>
				</tr>
			</table>
			<!-- Button_Sub (E) --></td>
		</tr>
	</table>
	<!-- Grid BG Box  (S) -->
	<!--biz page (E)-->
	<!--Button (S) -->
	<table width="100%" class="button" border="0" cellpadding="0"
		cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
		<tr>
			<td class="btn1_bg">
			<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td>
					<table width="100%" border="0" cellpadding="0" cellspacing="0"
						class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_retrieve">Retrieve</td>
							<td class="btn1_right"></td>
						</tr>
					</table>
					</td>
					<td>
					<table width="72" border="0" cellpadding="0" cellspacing="0"
						class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_new">New</td>
							<td class="btn1_right"></td>
						</tr>
					</table>
					</td>
					<td class="btn1_line"></td>
					<td>
					<table width="72" border="0" cellpadding="0" cellspacing="0"
						class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_save">Save</td>
							<td class="btn1_right"></td>
						</tr>
					</table>
					</td>
				</tr>
			</table>
			</td>
		</tr>
	</table>
	<!--Button (E) -->
	</td>
	</tr>
</table>
<!-- 개발자 작업  끝 --></form>
</body>
</html>