
<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : fns_inv_0034_02.jsp
	 *@FileTitle : Invoice Issue (Email)
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.07.06
	 *@LastModifier : 정휘택
	 *@LastVersion : 1.0
	 * 2009.07.06 정휘택
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
<%@ page import="com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.event.FnsInv003402Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="com.hanjin.framework.core.config.SiteConfigFactory"%>

<%
	FnsInv003402Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String strUsr_eml = "";
	String loginOfcCd = "";
	Logger log = Logger
			.getLogger("com.hanjin.apps.AccountReceivableInvoiceMgt.InvoiceIssue");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_eml = account.getUsr_eml();
		loginOfcCd = account.getOfc_cd();

		event = (FnsInv003402Event) request.getAttribute("Event");
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
	String issOfcCd = "";
	issueGubn = StringUtil.xssFilter(request.getParameter("issueGubn"));
	issOfcCd = StringUtil.xssFilter(request.getParameter("issOfcCd"));
 
%>
<html>
<head>
<title>Invoice Issue (Email)</title>
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

<body CLASS="POPUP_BG" onLoad="setupPage();">
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
    <input type="hidden" name="login_ofc_cd" value="<%=loginOfcCd%>">
    <input type="hidden" name="print_nm">
    <input type="hidden" name="send_flag2">
    <input type="hidden" name="logo_gb">
    <input type="hidden" name="iss_lehbb">
    <input type="hidden" name="sydbb_exrate_type">
    
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
					align="absmiddle">&nbsp;Invoice Issue (Email)</td>
			</tr>
		</table>
		<!-- : ( Title ) (E) --> <!--biz page (S)-->
		<table class="search">
			<tr>
				<td class="bg">
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="629"></td>
						<td width="350" align="right">
						
						<table class="search_sm" border="0" style="width: 580;">
							<tr class="h23">
								<td width="80">Send By</td>			
				
								<td width="70" class="stm"><input type="radio" value="P"
									name="send_type" class="trans" checked onClick="sendTypeChk();">Paper</td>
								<td width="70" class="stm"><input type="radio" value="E"
									name="send_type" class="trans" onClick="sendTypeChk();">E-mail</td>
								<td width="60" class="stm"><input type="radio" value="F"
									name="send_type" class="trans" onClick="sendTypeChk();">Fax</td>
								<td width="100" class="stm"><input type="radio" value="PE"
									name="send_type" class="trans" onClick="sendTypeChk();">Paper+E-mail</td>
								<td width="" class="stm"><input type="radio" value="PE2"
									name="send_type" class="trans" onClick="sendTypeChk();">Paper(Original)+E-mail(Copy)
								</td>
	
							</tr>
							<tr class="h23">
								<td width="80" id="layer1" style="display: none"></td>
								<td class="stm" colspan="5" id="layer2" style="display: none">
									<input type="checkbox" value="P" name="logo_gb1" class="trans" onClick="logoGbChk();">COPIE CERTIFIEE CONFORME A L'ORIGINAL
									&nbsp;&nbsp;&nbsp;<input type="checkbox" value="P" name="logo_gb2" class="trans" checked onClick="logoGbChk();">COPIE
								</td>
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
		<table border="0ddddd" cellpadding="0" cellspacing="0">
			<tr>
				<!-- 
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				-->
				
				<% if(issOfcCd.equals("ANRSO")){ %>
				<td>
				<table width="99" border="0" cellpadding="0" cellspacing="0"class="button">
					<tr>
						<td class="btn1_left"></td>
						<td class="btn1" name="btn_oldPreview">Old Preview</td>
						<td class="btn1_right"></td>
					</tr>
				</table>
				</td>
				<td>
				<table  width="85" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr>
						<td class="btn1_left"></td>
						<td class="btn1" name="btn_oldSend">Old Send</td>
						<td class="btn1_right"></td>
					</tr>
				</table>
				</td>
				<% } %>
				<td>
				<table width="85" border="0" cellpadding="0" cellspacing="0"
					class="button">
					<tr>
						<td class="btn1_left"></td>
						<td class="btn1" name="btn_preview">Preview</td>
						<td class="btn1_right"></td>
					</tr>
				</table>
				</td>
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
				<td class="btn1_line"></td>
				<td>
				<table width="0" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td class="btn1_left"></td>
						<td class="btn1" name="btn_close"><input type="button"
							name="downbtn" style="border-width: 0px; background: spacer.gif"
							onclick="form2.submit();"></td>
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

<form name="form2" action="/hanjin/FileDownload" method="post"
	target="_new"><input type="hidden" name="key" size="55">
</form>

</body>
</html>