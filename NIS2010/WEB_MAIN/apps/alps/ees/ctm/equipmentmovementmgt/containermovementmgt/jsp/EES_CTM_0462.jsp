<%--
 - Copyright(c) 2010 CyberLogitec
 - @FileName : EES_CTM_0462.jsp
 - @FileTitle : Auto-created Status Inquiry
 - Open Issues :
 - Change history :
 - @LastModifyDate : 2010.01.27
 - @LastModifier :
 - @LastVersion : 1.0
 - 2010.01.27 1.0 Creation.
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.event.EesCtm0462Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesCtm0462Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.EquipmentMovementMgtSC.ContainerMovementMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesCtm0462Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
	strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}

	// Corr Reason
    String cnmvCorrRsn = JSPUtil.getIBCodeCombo("", "", "CD03488", 0, "");
    StringBuffer cnmvCorrRsnCode = new StringBuffer();
    StringBuffer cnmvCorrRsnValue = new StringBuffer();

	if (cnmvCorrRsn != null && cnmvCorrRsn.length() > 0) {
		String rsnCodeStr = cnmvCorrRsn.substring(cnmvCorrRsn.indexOf("Code = \"") + 8, cnmvCorrRsn.lastIndexOf("\""));
		String rsnValueStr = cnmvCorrRsn.substring(cnmvCorrRsn.indexOf("Text = \"") + 8, cnmvCorrRsn.indexOf("\";"));
		String rsnCodes[] = rsnCodeStr.split("[|]");
		String rsnValues[] = rsnValueStr.split("[|]");

		for (int i=0; i<rsnCodes.length; i++) {
			if ("A".equals(rsnCodes[i].substring(0, 1))) {
				cnmvCorrRsnCode.append(rsnCodes[i]);
				cnmvCorrRsnCode.append("|");
				cnmvCorrRsnValue.append(rsnValues[i]);
				cnmvCorrRsnValue.append("|");
			}
		}
	}
%>
<html>
<head>
<title>Auto-created Status Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript">
	var cnmvCorrRsnCode = "<%=cnmvCorrRsnCode.toString().substring(0, cnmvCorrRsnCode.toString().length() - 1) %>";
	var cnmvCorrRsnValue = "<%=cnmvCorrRsnValue.toString().substring(0, cnmvCorrRsnValue.toString().length() - 1) %>";

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="backendjob_key">
<input type="hidden" name="sts_cd">


<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--top menu (S)-->
		<!--top menu (E)-->
	</td></tr>
	<tr><td valign="top">

      <!-- Page Title, Historical (S) -->
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
      </table>
      <!-- Page Title, Historical (E) -->
	<!--biz page (S)-->
		<table class="search">
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="90">Event Date</td>
					<td width="260"><input type="text" tabindex="1" style="width:80;text-align:center;" class="input1" name="p_date1">&nbsp;~&nbsp;<input type="text" style="width:80;text-align:center;" tabindex="2" class="input1" name="p_date2">&nbsp;<img src="./img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_Calendar"></td>
					<td width="250"><input type="radio" class="trans" border="0" checked name="loc_type" value="1">LCC<input type="radio" name="loc_type" value="2" class="trans" border="0">Location &nbsp;<input type="text" style="width:70;text-align:center;" tabindex="3" class="input1" name="loc_cd" maxlength="7"></td>
					<td width="60">Modified</td>
					<td width="70"><select style="width:60;"class="input" name="cre_tp_cd">
						<option value="A" selected>N</option>
						<option value="N">Y</option>
						</select></td>
					<td width="45">Status</td>
					<td>
					<script language="javascript">ComComboObject("stsCombo", 2, 70, 1, 0, 0, 0, 18)</script>
					</td>
				</tr>

				</table>
				<!--  biz_1   (E) -->


				<table class="line_bluedot"><tr><td></td></tr></table>

				<!--  biz_2  (S) -->

				<!-- Grid  (S) -->
						<table width="100%"  id="mainTable">
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table>
				<!-- Grid (E) -->



				<!--  biz_2   (E) -->
				</td></tr>
			</table>

	<!--biz page (E)-->


	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left">
					<td class="btn1" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right">
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				  <tr><td class="btn1_left"></td>
				  <td class="btn1" name="btn_eachcntr">History</td>
				  <td class="btn1_right"></td>
				  </tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DownExcel">Down Excel</td>
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
<!-- Copyright (S) -->
<!-- Copyright(E)-->

<!-- 개발자 작업  끝 -->
	<script language="javascript">ComUploadObject('upload', '<%=session.getId() %>');</script>
</form>
</body>
</html>