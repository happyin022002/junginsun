
<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : fns_inv_0135.jsp
	 *@FileTitle : (SAOSC) Split Invoice Re-Issue
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.06.30
	 *@LastModifier : 정휘택
	 *@LastVersion : 1.0
	 * 2009.06.30 정휘택
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
<%@ page import="com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.event.FnsInv0135Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	FnsInv0135Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String loginOfcCd = "";
	Logger log = Logger
			.getLogger("com.hanjin.apps.AccountReceivableInvoiceMgt.InvoiceIssue");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		loginOfcCd = account.getOfc_cd();

		event = (FnsInv0135Event) request.getAttribute("Event");
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
<title>(SAOSC) Split Invoice Re-Issue</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
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
<form name="form">
    <input type="hidden" name="f_cmd"> 
    <input type="hidden" name="pagerows"> 
    <input type="hidden" name="pagetype" value="E"> 
    <input type="hidden" name="iss_ofc_cd"> 
    <input type="hidden" name="user_ofc" value="<%=loginOfcCd%>"> 
    <input type="hidden" name="user_id" value="<%=strUsr_id%>"> 
    <input type="hidden" name="user_nm" value="<%=strUsr_nm%>"> 
    <input type="hidden" name="inv_no">
    <input type="hidden" name="invs"> 
    <input type="hidden" name="r_invs"> 
    <input type="hidden" name="cmb_flg"> 
    <input type="hidden" name="if_no">
    <input type="hidden" name="r_ifnos">
    <input type="hidden" name="invs_email"> 
    <input type="hidden" name="flag"> 
    <input type="hidden" name="login_ofc_cd" value="<%=loginOfcCd%>"> 
    <input type="hidden" name="ar_ofc_cd2">    
    <input type="hidden" name="ots_smry_cd">
    <input type="hidden" name="print_nm">
    <input type="hidden" name="com_mrdPath"> 
    <input type="hidden" name="com_mrdArguments"> 
    <input type="hidden" name="prev_flg" value="N"> 
    <input type="hidden" name="goto_flg" value="N"> 
    
<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	style="padding-top: 2; padding-left: 5;">

	<tr>
		<td valign="top"><!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0"
			class="title">
			<tr>
				<td class="history"><img src="img/icon_history_dot.gif"
					align="absmiddle"><span id="navigation"></span></td>
			</tr>
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif"
					align="absmiddle"><span id="title"></span></td>
			</tr>
		</table>

		<!--Page Title, Historical (E)--> <!--biz page (S)-->
		<table class="search" id="mainTable">
			<tr>
				<td class="bg"><!--  biz_1  (S) -->
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="400">
						<table class="search_sm2" border="0" style="width: 345;">
							<tr class="h23">
								<td width="120">Select Option</td>
								<td width="275" rowspan="2">
								<table border="0" style="width: 190;" class="search">
									<tr class="h23">
										<td class="stm">&nbsp;&nbsp;&nbsp; <input type="radio"
											class="trans" value="S" name="sel_option"
											onclick="javascript:clickOption();" checked>&nbsp;Single&nbsp;&nbsp;&nbsp;&nbsp;
										<input type="radio" class="trans" value="M" name="sel_option"
											onclick="javascript:clickOption();">&nbsp;Multi&nbsp;&nbsp;&nbsp;&nbsp;</td>
									</tr>
								</table>
								</td>
							</tr>
						</table>
						</td>
						<td width="45">Office</td>
						<td><script language="javascript">ComComboObject('ar_ofc_cd', 1, 100, 1, 1);</script>
					</tr>
				</table>
				<table class="height_8">
					<tr>
						<td></td>
					</tr>
				</table>

				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="120">&nbsp;Multi Invoice No.</td>
						<td width="275" class="stm">From&nbsp;<input type="text"
							style="width: 80" class="input2" name="f_inv"
							style="ime-mode:disabled" maxlength="9" dataformat="engup"
							readOnly>&nbsp;&nbsp;&nbsp; To&nbsp;<input type="text"
							style="width: 80" class="input2" name="t_inv"
							style="ime-mode:disabled" maxlength="9" dataformat="engup"
							readOnly></td>
						<td style="color: #51AC2F;">&nbsp;Invoice Search <img
							id="btn_search" src="img/btns_search.gif" width="19" height="20"
							alt="" border="0" align="absmiddle" class="cursor"
							onclick="javascript:openInvPopUp();"></td>

					</tr>
				</table>
				<!--  biz_1   (E) -->

				<table class="line_bluedot">
					<tr>
						<td colspan="6"></td>
					</tr>
				</table>

				<table class="search" border="0" style="width: 120;" align="left">
					<tr class="h23">
						<td width="120">&nbsp;Single Invoice No.</td>
					</tr>
				</table>

				<!-- Grid  (S) -->

				<table width="800" id="mainTable">
					<tr>
						<td width="100%"><script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>

				<!-- Grid (E) --></td>
			</tr>
		</table>
		<!--biz page (E)--></td>
	</tr>
</table>

<!--Button (S) -->
<table width="100%" class="button" border="0" cellpadding="0"
	cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
	<tr>
		<td class="btn1_bg">
		<table border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td>
				<table width="72" border="0" cellpadding="0" cellspacing="0"
					class="button">
					<tr>
						<td class="btn1_left"></td>
						<td class="btn1" name="btn_new">New</td>
						<td class="btn1_right">
					</tr>
				</table>
				</td>
				<td class="btn1_line">
				<td id="btnPaper" width="135">
				<table width="125" border="0" cellpadding="0" cellspacing="0"
					class="button">
					<tr>
						<td class="btn1_left"></td>
						<td class="btn1" name="btn_paper">Paper Re-issue</td>
						<td class="btn1_right">
					</tr>
				</table>
				</td>
				<td>
				<table width="100%" border="0" cellpadding="0" cellspacing="0"
					class="search">
					<tr class="h23">
						<td>Number of copy invoice&nbsp;</td>
					</tr>
				</table>
				</td>
				<td width="30" align="left"><input type="text"
					style="width: 25; height: 20; font-size: 8pt; text-align: right;"
					class="input" value="" name="copy_cnt" dataformat="int"
					maxlength="3" style="ime-mode:disabled">&nbsp;&nbsp;&nbsp;
				</td>

				<td>
				<table width="100%" border="0" cellpadding="0" cellspacing="0"
					class="button">
					<tr>
						<td class="btn1_left"></td>
						<td class="btn1" name="btn_goto">Go to Send</td>
						<td class="btn1_right">
					</tr>
				</table>
				</td>
			</tr>
		</table>
		</td>
	</tr>
</table>

<!--Button (E) --> <!------- Print용 Hidden RD Object Start -------->
<table width="100%" id="rdTable">
	<tr>
		<td width="100%"><script language="javascript">comRdObject('Rd');</script>
		</td>
	</tr>
</table>
<!------- Print용 Hidden RD Object End --------> <!-- 개발자 작업  끝 --></form>
</body>
</html>