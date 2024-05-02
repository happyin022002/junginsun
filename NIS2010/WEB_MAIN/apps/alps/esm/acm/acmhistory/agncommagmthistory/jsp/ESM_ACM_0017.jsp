<%
/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : ESM_ACM_0017.jsp
 *@FileTitle : Special Compensation CSR Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.05.15
 *@LastModifier : 김영오
 *@LastVersion : 1.0
 * 2012.05.04 김영오
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
<%@ page import="com.hanjin.apps.alps.esm.acm.acmhistory.agncommagmthistory.event.EsmAcm0017Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmAcm0017Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String strOfc_cd = "";
	String aproStep = "";
	String inv_sub_sys_cd = "";
	Logger log = Logger.getLogger("com.hanjin.apps.ACMRequest.AGNCommRequest");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		event = (EsmAcm0017Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		aproStep = com.hanjin.bizcommon.approval.util.ApprovalUtil.getApprovalRoute(strOfc_cd, "ACM");
		inv_sub_sys_cd = JSPUtil.getParameter(request,"inv_sub_sys_cd".trim(), "");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Agent Commission Agreement History</title>
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

<body onLoad="setupPage();">
<form name="form"><input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="ap_ofc_cd">
<input type="hidden" name="agmt_his_no">
<input type="hidden" name="agn_agmt_no">

<!-- 개발자 작업 -->
<input type="hidden" name="login_ofc" value="<%=strOfc_cd%>">
	<!-- 로그인 한 사용자의 ofc_cd -->
<input type="hidden" name="aproSeqKey" value="<%=com.hanjin.bizcommon.approval.util.ApprovalUtil.getApprovalRoute1(strOfc_cd, inv_sub_sys_cd)%>">


<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding: 2px 0px 0px 5px; border: 0px #ff0000 solid; width: 1002px">
	<tr>
		<td valign="top"><!-- Page Title, Historical (S) -->

		<table width="100%" border="0" cellpadding="0" cellspacing="0"
			class="title">
			<tr>
				<td class="history">
					<img src="img/icon_history_dot.gif" align="absmiddle">
					<span id="navigation"></span>
				</td>
			</tr>
			<tr>
				<td class="title">
					<img src="img/icon_title_dot.gif" align="absmiddle">
					<span id="title"></span>
				</td>
			</tr>
		</table>
		<!-- Page Title, Historical (E) --> <!-- Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding: 5px 0px 10px 0px;">
			<tr>
				<td class="btn1_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_retrieve">Retrieve</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		<!-- Button (E) --> <!-- biz page (S) -->
		<table class="search">
			<tr>
				<td class="bg" valign="top"><!-- biz_1 (S) -->
				<table width="100%" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td align="left" valign="top">
						<table width="979" cellpadding="0" cellspacing="0" border="0">
							<tr class="h23">
								<td align="left">RHQ&nbsp;
									<select name="rhq_cd_disp" style="width: 100; display: none;" tabindex="1"></select>
									<input name="rhq_cd" type="text" class="input2" style="width: 100; text-align: center;" tabindex="1" readOnly>
								</td>
								<td align="left">Office&nbsp;
									<select name="ar_ofc_cd" required caption="Office" class="input1" style="width: 100;" tabindex="2">
									</select>
								</td>
								<td align="left">Sub Office&nbsp; <select name="agn_cd" required caption="Sub Office" class="input1" style="width: 100;" tabindex="3"></select></td>
								<td align="right">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								</td>
							</tr>
						</table>
						</td>
					</tr>
				</table>

				<table class="line_bluedot">
					<tr>
						<td></td>
					</tr>
				</table>

				<table class="search">
					<tr>
						<td class="bg" valign="top"><img src="img/ico_hystory.gif"
							align="absmiddle" width="8" height="9" border="0">Agreement List <!-- biz_2 (S) -->
						<!-- Grid (S) -->
						<table width="100%" id="mainTable">
							<tr>
								<td width="100%"><script language="javascript">ComSheetObject("sheet1");</script></td>
							</tr>
						</table>
						<!-- Grid (E) --> <!-- biz_2 (E) -->

						<table width="100%" class="search">
							<tr>
								<td class="gray_tit"><img src="img/ico_hystory.gif"
									align="absmiddle" width="8" height="9" border="0">Master History</td>
							</tr>
						</table>
						<table width="100%" id="mainTable">
							<tr>
								<td><script language="javascript">ComSheetObject('sheet2');</script></td>
							</tr>
						</table>

						<table width="100%" class="search">
							<tr>
								<td class="gray_tit"><img src="img/ico_hystory.gif"
									align="absmiddle" width="8" height="9" border="0">Detail(Compensation) History</td>
							</tr>
						</table>
						<table width="100%" id="mainTable">
							<tr>
								<td><script language="javascript">ComSheetObject('sheet3');</script></td>
							</tr>
						</table>

						</td>
					</tr>
				</table>
				<!-- biz page (E) --></td>
			</tr>
		</table>

		</td>
	</tr>
</table>

		<!-- 개발자 작업 끝 -->
</form>
</body>
</html>
