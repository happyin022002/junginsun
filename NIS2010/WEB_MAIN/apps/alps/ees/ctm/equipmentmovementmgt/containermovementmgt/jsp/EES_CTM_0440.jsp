<%--
/*=========================================================
 * Copyright(c) 2009 CyberLogitec
 * @FileName : ees_ctm_0440.jsp
 * @FileTitle : VL/VD correction by VVD
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2009.06.02
 * @LastModifier :
 * @LastVersion : 1.0
 * 2009.06.02 1.0 Creation
 * 2016.03.30 김상현 [CHM-201640816] Correction Reason 기능 추가1
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.event.EesCtm0440Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesCtm0440Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.EquipmentMovementMgt.IManifestListDownload");

	String strEnddate = DateTime.getFormatDate(new java.util.Date(), "yyyy-MM-dd");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EesCtm0440Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	} catch(Exception e) {
		out.println(e.toString());
	}

	// 2016.03.30 김상현 [CHM-201640816] Correction Reason 기능 추가1
	//  - Manual 수정시 Correction reason 항목 필수 입력하도록 수정
	// Corr Reason
    String cnmvCorrRsn = JSPUtil.getIBCodeCombo("", "", "CD03488", 0, "");
	String cnmvCorrRsnCode = "";
	String cnmvCorrRsnValue = "";

	if (cnmvCorrRsn != null && cnmvCorrRsn.length() > 0) {
		cnmvCorrRsnCode = cnmvCorrRsn.substring(cnmvCorrRsn.indexOf("Code = \"") + 8, cnmvCorrRsn.lastIndexOf("\""));
		cnmvCorrRsnValue = cnmvCorrRsn.substring(cnmvCorrRsn.indexOf("Text = \"") + 8, cnmvCorrRsn.indexOf("\";"));
	}
%>
<html>

<head>
	<title>VL/VD correction by VVD</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<script type="text/javascript">
		var cnmvCorrRsnCode = "<%=cnmvCorrRsnCode %>";
		var cnmvCorrRsnValue = "<%=cnmvCorrRsnValue %>";

		function setupPage() {
			var errMessage = "<%=strErrMsg %>";
			if (errMessage.length >= 1) {
				ComShowMessage(errMessage);
			}
			loadPage();
		}
	</script>
</head>

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
<tr><td valign="top">

      <!-- Page Title, Historical (S) -->
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
      </table>
      <!-- Page Title, Historical (E) -->


	<!--biz page (S)-->
		<table class="search">
       	<tr><td class="bg" style="height:515" valign="top">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="40">Status</td>
					<td width="90">&nbsp;<select style="width:50;" tabindex="1"  class="input" name="p_status">
						<option value="VL" selected>VL</option>
						<option value="VD">VD</option>
						</select></td>
					<td width="30">Yard</td>
					<td width="60" style="padding-top:1;"><input type="text" style="width:55;text-align:center;" class="input1" tabindex="2" maxlength="5" name="p_yard1"></td>
					<td width="80"><script language="javascript">ComComboObject('p_yard2', 2, 50 , 0, '', 2, 0, 3)</script></td>
					<td width="70">Event Date</td>
					<td width="130"><input type="text" style="width:75;" class="input1" tabindex="4"  maxlength="10" name="p_date0" value="<%=strEnddate%>">&nbsp;<img src="./img/btns_calendar.gif" width="19" height="20" id="btn_Calendar1" name="btn_Calendar1" border="0" align="absmiddle" class="cursor"></td>
					<td width="60">VVD Code</td>
					<td width="110"><input type="text" style="width:80;" class="input1" tabindex="5"  maxlength="9" name="p_vvdcd"></td>
					<td width="35">Type</td>
					<td>&nbsp;<select style="width:60;" class="input" tabindex="6" name="p_type">
						<option value="" selected>All</option>
						<option value="F">Full</option>
						<option value="P">Empty</option>
						</select></td></tr>

				</table>


				<table class="height_8"><tr><td colspan="8"></td></tr></table>


				<!-- Grid  (S) -->

				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>

				<!-- Grid (E) -->

					<!--  Button_Sub (S) -->
			<table width="100%" class="button">
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_delete">Row&nbsp;Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				</tr>
			</table>
				</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
				<!--  biz_2   (E) -->


				<!--  biz_3  (E) -->
				</td></tr>
			</table>
	<!--biz page (E)-->
	</td></tr>
		</table>

	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;">
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left">
					<td class="btn1" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right">
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left">
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right">
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_update">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
</td></tr>
</table>
	<script language="javascript">ComUploadObject('upload', '<%=session.getId() %>');</script>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>