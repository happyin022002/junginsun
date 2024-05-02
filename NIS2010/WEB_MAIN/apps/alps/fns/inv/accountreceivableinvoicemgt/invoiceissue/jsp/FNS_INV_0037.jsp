
<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : FNS_INV_0037.jsp
	 *@FileTitle : (S.China)Invoice Issue (Email)
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.09.24
	 *@LastModifier : 정휘택
	 *@LastVersion : 1.0
	 * 2009.09.24 정휘택
	 * 1.0 Creation
	 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.event.FnsInv0037Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	FnsInv0037Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String strUsr_eml = "";
	Logger log = Logger
			.getLogger("com.hanjin.apps.AccountReceivableInvoiceMgt.InvoiceIssue");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_eml = account.getUsr_eml();

		event = (FnsInv0037Event) request.getAttribute("Event");
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

	String subject = "";
	String fileKey = "";
	String content = "";

	fileKey = StringUtil.xssFilter(request.getParameter("fileKey"));

	String issueGubn = "";
	issueGubn = StringUtil.xssFilter(request.getParameter("issueGubn"));
%>
<html>
<head>
<title>(S.China)Invoice Issue (Email)</title>
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

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
    <input type="hidden" name="f_cmd"> 
    <input type="hidden" name="pagerows"> 
    <input type="hidden" name="invs">
	<input type="hidden" name="f_inv"> 
	<input type="hidden" name="t_inv"> 
	<input type="hidden" name="flag"> 
	<input type="hidden" name="copy_cnt"> 
	<input type="hidden" name="iss_ofc_cd"> 
	<input type="hidden" name="user_nm" value="<%=strUsr_nm%>"> 
	<input type="hidden" name="from" value="<%=strUsr_eml%>"> 
	<input type="hidden" name="recipient" value=""> 
	<input type="hidden" name="carbonCopy"> 
	<input type="hidden" name="blindCarbonCopy"> 
	<input type="hidden" name="subject" value=""> 
	<input type="hidden" name="content" value=""> 
	<input type="hidden" name="argument"> 
	<input type="hidden" name="template"> 
	<input type="hidden" name="attach"> 
	<input type="hidden" name="send_flag"> 
	<input type="hidden" name="inv_no"> 
	<input type="hidden" name="inv_iss_rmk"> 
	<input type="hidden" name="cust_eml">
    <input type="hidden" name="cust_fax_no"> 
    <input type="hidden" name="if_no"> 
    <input type="hidden" name="cre_usr_id" value="<%=strUsr_id%>"> 
    <input type="hidden" name="issue_gubn" value="<%=issueGubn%>"> 
    <input type="hidden" name="state">
    <input type="hidden" name="rd_name"> 
    <input type="hidden" name="com_mrdPath"> 
    <input type="hidden" name="com_mrdArguments"> 
    <input type="hidden" name="issueCnt"> 
    <input type="hidden" name="name_flag"> 
    <input type="hidden" name="title_flag"> 
    <input type="hidden" name="print_nm">
    <input type="hidden" name="send_flag2">

<!-- 개발자 작업	-->

<table width="100%" class="popup" border="0" cellpadding="10"
	cellspacing="0" style="padding-top: 2; padding-left: 5;">
	<tr>
		<td class="top"></td>
	</tr>
	<tr>
		<td valign="top"><!-- : ( Title ) (S) -->
		<table width="100%" border="0">
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif"
					align="absmiddle">&nbsp;(S.China)Invoice Issue (Email)</td>
			</tr>
		</table>
		<!-- : ( Title ) (E) --> <!--biz page (S)-->
		<table class="search">
			<tr>
				<td class="bg"><!-- biz_1  (S) -->

				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="280">
						<table class="search_sm" border="0" style="width: 270;">
							<tr class="h23">
								<td width="100">Customer Name</td>
								<td width="70" class="stm"><input type="radio" value=""
									name="name_type" class="trans">Chinese</td>
								<td width="70" class="stm"><input type="radio" value=""
									name="name_type" class="trans" checked>English</td>
							</tr>
						</table>
						</td>
						<td width="280">
						<table class="search_sm" border="0" style="width: 270;">
							<tr class="h23">
								<td width="50">Title</td>
								<td width="70" class="stm"><input type="radio" value=""
									name="title_type" class="trans" checked>MCO</td>
								<td width="70" class="stm"><input type="radio" value=""
									name="title_type" class="trans" >CEPA</td>
								<td width="70" class="stm"><input type="radio" value=""
									name="title_type" class="trans" disabled>ASM</td>
								<td width="70" class="stm"><input type="radio" value=""
									name="title_type" class="trans">HSBC</td>
							</tr>
						</table>
						</td>
						<td width="400" align="right">
						<table class="search_sm" border="0" style="width: 390;">
							<tr class="h23">
								<td width="80">Send By</td>
								<td width="70" class="stm"><input type="radio" value=""
									name="send_type" class="trans" checked>Paper</td>
								<td width="70" class="stm"><input type="radio" value=""
									name="send_type" class="trans">E-mail</td>
								<td width="60" class="stm"><input type="radio" value=""
									name="send_type" class="trans">Fax</td>
								<td width="" class="stm"><input type="radio" value=""
									name="send_type" class="trans">Paper+E-mail</td>
							</tr>
						</table>
						</td>
						<td width="30" align="right">
						<table class="" border="0" style="width: 19;">
							<tr class="">
								<td width="19"><img src="img/btns_help.gif"
									onMouseover="showHelp();" onMouseout="hideHelp()"
									; align="absmiddle"></td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				<table class="height_8">
					<tr>
						<td></td>
					</tr>
				</table>

				<!--grid   (S)-->
				<table width="100%" id="mainTable">
					<tr>
						<td width="100%"><script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!--grid   (E)--></td>
			</tr>
		</table>
		<table class="height_5">
			<tr>
				<td></td>
			</tr>
		</table>
		</td>
	</tr>
</table>
<!-- Tab BG Box(E) --> <!--biz page (E)--> <!--Button (S) -->
<table width="100%" class="sbutton" border="0" cellpadding="0"
	cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
	<tr>
		<td class="popup">
		<table border="0" cellpadding="0" cellspacing="0">
			<tr>
				<!-- 
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				-->
				<td>
				<table width="100%" border="0" cellpadding="0" cellspacing="0"
					class="button">
					<tr>
						<td class="btn1_left"></td>
						<td class="btn1" name="btn_preview">Preview</td>
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
						<td class="btn1" name="btn_send">Send</td>
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
						<td class="btn1" name="btn_close">Close</td>
						<td class="btn1_right"></td>
					</tr>
				</table>
				</td>
			</tr>
		</table>

		<!--Button (E) --></td>
	</tr>
</table>
<!------- FileUpload Object Start -------->
<table width="100%">
	<tr>
		<td width="100%"><script language="javascript">ComUploadObject('upload1', '<=session.getId()%>');</script>
		</td>
	</tr>
</table>
<!------- FileUpload Object End --------> <!------- Print용 Hidden RD Object Start -------->
<table width="100%" id="rdTable">
	<tr>
		<td width="100%"><script language="javascript">comRdObject('Rd1');</script>
		</td>
	</tr>
</table>
<!------- Print용 Hidden RD Object End --------> <!------- Print용 Hidden RD Object Start -------->
<table width="100%" id="rdTable">
	<tr>
		<td width="100%"><script language="javascript">comRdObject('Rd2');</script>
		</td>
	</tr>
</table>
<!------- Print용 Hidden RD Object End -------->

<div id="help_layer"
	style="position: absolute; visibility: hidden; border: 1px solid black; font-family: Arial; font-size: 12px; color: #3e3e3e; font-weight: normal; layer-background-color: lightyellow; background-color: lightyellow; padding: 1px"></div>

<!-- 개발자 작업  끝 --></form>
</body>
</html>