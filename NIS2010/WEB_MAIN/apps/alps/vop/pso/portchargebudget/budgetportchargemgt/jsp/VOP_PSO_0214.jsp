<%
/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : VOP_PSO_0214.jsp
 *@FileTitle : Invoice Summary Detail
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.09.15
 *@LastModifier : 진마리아
 *@LastVersion : 1.0
 * 2009.12.09
 * 1.0 Creation
 * 
 * History
 * 2010.09.15 진마리아 CHM-201005696-01 지점및 지역 본부에서 Port charge inovice summary 수정 변경
 * 										1) CSR I/F Inquiry와 동일한 기능은 CSR I/F Inquiry화면에 invocie No.로 조회하는 기능 추가하여 Port charge inovice summary 메뉴에서는 해당 기능을 삭제
 *										2) 지역본부및 office별, Port별 S/P No.로 발생한 Actual invoice를 조회하기 위한 조건 추가및 Grid내 칼럼 추가
 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.event.VopPso0214Event"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>
<%@ page import="org.apache.log4j.Logger"%>

<%
	VopPso0214Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String strUsr_Ofc_cd = "";

	String strPortCd = "";
//	String strCsrNo = "";
//	String strInvNo = "";
//	String strStatus = "";
	String strVvd = "";
	String strAcctCd = "";
	String strVndrSeq = "";
	String strIssCtyCd = "";
	String strSoSeq = "";

	Logger log = Logger.getLogger("com.hanjin.apps.PortChargeBudget.BudgetPortChargeMgt");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_Ofc_cd = account.getOfc_cd();

		event = (VopPso0214Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		strPortCd = StringUtil.xssFilter(request.getParameter("port_cd"));
		strVvd  = StringUtil.xssFilter(request.getParameter("vvd"));
		strAcctCd  = StringUtil.xssFilter(request.getParameter("acct_cd"));
		strVndrSeq  = StringUtil.xssFilter(request.getParameter("vndr_seq"));
		strIssCtyCd  = StringUtil.xssFilter(request.getParameter("iss_cty_cd"));
		strSoSeq  = StringUtil.xssFilter(request.getParameter("so_seq"));

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Invoice Summary Detail</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body class="popup_bg" onLoad="setupPage();">
<form name="form" onKeyDown="ComKeyEnter()">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows">
<input type="hidden" name="sXml"> 
<input type="hidden" name="iss_cty_cd" value="<%=strIssCtyCd%>"> 
<input type="hidden" name="so_seq" value="<%=strSoSeq%>"> 
<table width="100%" class="popup" cellpadding="10" border="0">
	<tr>
		<td class="top"></td>
	</tr>
	<tr>
		<td valign="top"><!-- : ( Title ) (S) -->
		<table width="100%" border="0">
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Invoice Summary Detail</td>
			</tr>
		</table>

		<table class="search" id="mainTable">
			<tr>
				<td class="bg">

					<table class="search" border="0" width="100%">
						<tr class="h23">
							<td width="">Terminal Code
								&nbsp;<input name="port_cd" type="text" style="width: 70; margin-left: -2px; text-align: center;" class="input2" value="<%=strPortCd%>" readonly>
								&nbsp;&nbsp;VVD
								&nbsp;<input name="vvd" type="text" style="width: 150; margin-left: -2px; text-align: center;" class="input2" value="<%=strVvd%>" readonly>
								&nbsp;&nbsp;Account Code
								&nbsp;<input name="acct_cd" type="text" style="width: 150; margin-left: -2px; text-align: center;" class="input2" value="<%=strAcctCd%>" readonly>
								&nbsp;&nbsp;S/P No.
								&nbsp;<input name="vndr_seq" type="text" style="width: 155; margin-left: -2px; text-align: center;" class="input2" value="<%=strVndrSeq%>" readonly>
							</td>
						</tr>
					</table>
					<table class="line_bluedot"><tr><td></td></tr></table>
					<table width="100%" id="mainTable">
						<tr>
							<td width="100%"><script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td align="right">
				<table width="100%" class="button">
					<tr>
						<td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0"
									class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btn_DownExcel">Down Excel</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
<table class="height_5"><tr><td></td></tr></table>

		</td>
	</tr>
</table>
<!--biz page (E)-->



<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup"><!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0"
			cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
			<tr>
				<td class="btn3_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_close">Close</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		<!--Button (E) --></td>
	</tr>
</table>
<!-- : ( Button : pop ) (E) --> <!-- 개발자 작업  끝 --></form>
</body>
</html>
