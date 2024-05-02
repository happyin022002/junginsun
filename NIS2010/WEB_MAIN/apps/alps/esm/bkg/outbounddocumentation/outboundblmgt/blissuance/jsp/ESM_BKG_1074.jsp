
<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : ESM_BKG_0649.jsp
	 *@FileTitle : Cancel Issue Release
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.07.20
	 *@LastModifier : 이진서
	 *@LastVersion : 1.0
	 * 2009.07.20 이진서
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkg1074Event"%>

<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg1074Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String strOfc_cd = "";
	Logger log = Logger.getLogger("com.hanjin.apps.OutboundBLMgt.BLIssuance");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		event = (EsmBkg1074Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Internet O.B/L Print Authorize</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" type="text/javascript" src="/hanjin/syscommon/common/fckeditor/ckeditor.js"></script>

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
<input type="hidden" name="strUsr_id" value="<%=strUsr_id%>"> 
<input type="hidden" name="strOfc_cd" value="<%=strOfc_cd%>"> 
<!-- 개발자 작업	--> 
<!-- OUTER - POPUP (S)tart -->
<input type="hidden" name="bkg_no" value='<%=JSPUtil.getParameter(request, "bkg_no")%>'> 
<input type="hidden" name="bl_no" value='<%=JSPUtil.getParameter(request, "bl_no")%>'>
<table width="800" class="popup" cellpadding="10" border="0">
	<tr>
		<td class="top"></td>
	</tr>
	<tr>
		<td valign="top"><!-- : ( Title ) (S) -->
		<table width="100%" border="0">
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Internet O.B/L Print Authorize</td>
			</tr>
		</table>
		<!-- : ( Title ) (E) --> <!--biz page (S)-->
		<table class="search" id="mainTable">
			<tr>
				<td class="bg"><!--  biz_1  (S) -->
				<table border="0" style="width: 100%;">
				<tr><td>
				<table class="grid2" border="0" style="width: 440;">
					<tr>
						<td class="tr2_head" width="60">SHPR</td>
						<td width="90" class="input2"><input type="text" style="width: 80;" class="noinput2"  name="shpr_cd" value="" readonly></td>
						<td width="250" class="input2"><input type="text" style="width: 250;" class="noinput2" name="shpr_nm" value="" readonly></td>
						<td width="" class="input2"><img name="pop_shpr" src="img/btns_search.gif" width="19" height="20" alt="" border="0" class="cursor"></td>
					</tr>
					<tr>
						<td class="tr2_head" width="">FWDR</td>
						<td width="" class="input2"><input type="text" style="width: 80;" class="noinput2" name="fwdr_cd" value="" readonly></td>
						<td width="" class="input2"><input type="text" style="width: 250;" class="noinput2" name="fwdr_nm" value="" readonly></td>
						<td width="" class="input2"><img name="pop_fwdr" src="img/btns_search.gif" width="19" height="20" alt="" border="0" class="cursor"></td>
					</tr>
				</table>
				</td>
				<td style="padding-top: 30;">
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr>
						<td class="btn2_left"></td>
						<td class="btn2" name="btn_Authorize" style="color: black">Authorize</td>
						<td class="btn2_right"></td>
					</tr>
				</table>
				</td>
				<td style="padding-top: 30;">
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr>
						<td class="btn2_left"></td>
						<td class="btn2" name="btn_Email" style="color: black">E-mail</td>
						<td class="btn2_right"></td>
					</tr>
				</table>
				</td>
				
				</tr>
				</table>
				<table class="line_bluedot">
					<tr>
						<td colspan="6"></td>
					</tr>
				</table>
				<table class="grid2" border="0" style="width: 100%;">
					<tr>
						<td class="tr2_head" width="60">To</td>
						<td width=""><input type="text" style="width: 100%;" class="noinput" name="email_to" value=""></td>
					</tr>
				</table>
				<table class="height_8">
					<tr>
						<td></td>
					</tr>
				</table>
				<table class="grid2" border="0" style="width: 100%;">
					<tr>
						<td class="tr2_head" width="60">Subject</td>
						<td width="" class=""><input type="text" style="width: 100%;" class="noinput" name="email_subject"  value=" SM Line B/L Print Ready Notice (B/L No. : <%=JSPUtil.getParameter(request, "bl_no")%> )"></td>
					</tr>
					<tr>
						<td class="tr2_head" width="60">Contents</td>
						<td width="" class="">
							<textarea class="ckeditor" name="email_contents">
Dear Customer,
<br>
<br>
<br>
Your below Bill of Lading is / are ready to be printed on SM Line Website.
<br>
<br>
B/L Number
<br>
-----------------------
<br>
<%=JSPUtil.getParameter(request, "bl_no")%>
<br>
<br>
In order to print out the Bill of Lading, please access
<br>
<br>
<br>
<font color="blue"><u><a href="https://smlines.com/hanjin/CUP_HOM_3221.do?redir=Y&mnuId=CEN&sessLocale=en&prntMnuId=CEN&ctgId=CEN">https://smlines.com/hanjin/CUP_HOM_3221.do?redir=Y&mnuId=CEN&sessLocale=en&prntMnuId=CEN&ctgId=CEN.</a></u></font>
<br>
<br>
<br>
After logging in the Website, it is required to <u><b>log-in once again with your Website O B/L printing access ID/PW.</b></u>
<br>
<br>
Also, it is <u><b>requested to change the password after the initial log-in,</b></u> to prevent any possible accidents.
<br>
<br>
If you have forgotten the password after changing, click ‘Forget Password’ and you will be able to receive a 
<br>
temporary password by inserting the e-mail address that you have registered in SM Line Website.
<br>
<br>
It is needed to change the password again to your unique one after accessing the Web O B/L printing service site.
<br>
Always pay keen attention of your Website O B/L printing ID/PW and make sure not to share/release it to others.
<br>
<br>
Thank you.
							</textarea>
						</td>
					</tr>
				</table>

				<!--  biz_1   (E) --></td>
			</tr>
		</table>
		<!--biz page (E)--></td>
	</tr>
</table>

<table class="height_5">
	<tr>
		<td></td>
	</tr>
</table>

<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup"><!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
			<tr>
				<td class="btn3_bg">
				
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td class="btn3_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td>
								<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
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
				
				</td>
			</tr>
		</table>				
		</td>
	</tr>
</table>					

<!-- : ( Button : pop ) (E) --> <!-- 개발자 작업  끝 -->
</form>
<div style="display: none"><script language="javascript">ComSheetObject('sheet1');</script></div>
</body>
</html>