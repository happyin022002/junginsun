
<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : esm_bkg_0477.jsp
	 *@FileTitle : ESM_BKG-0477
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.06.03
	 *@LastModifier : 김승민
	 *@LastVersion : 1.0
	 * 2009.06.03 김승민
	 * 1.0 Creation
	 * History :
     * 2010.12.17 이수진 [CHM-201007493] SEA-NACCS DOR User ID 표시 추가 및 검색 기능 개선 요청		 
	 *           작업내용 : User ID에 영대/영소/숫자/_ 만 입력 가능하도록 수정 
	 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="java.util.Date"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page
	import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page
	import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page
	import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page
	import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.japan.event.EsmBkg0477Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0477Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	//int rowCount = 0; //DB ResultSet 리스트의 건수

	//String successFlag = "";
	//String codeList = "";
	//String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String toDate = "";
	//Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.ManifestListDownload");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		Date to = new Date();
		toDate = DateTime.getDateString();
		toDate = toDate.replace(".","-");
		
		event = (EsmBkg0477Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		//GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>ESM_BKG-0477</title>
<meta http-eqEsmv="Content-Type" content="text/html; charset=UTF-8">
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

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows"> 
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
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
	<!--Page Title, Historical (E)-->
	
	<!--Button (S) -->
		
    <!--Button (E) -->
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="60">MSG TYPE</td>
					<td width="160" style="padding-left:1"><select style="width:79;" class="input1" name="jp_snd_log_id">
						<option value="" selected>ALL</option>
						<option value="CMF01">CMF01</option>
						<option value="CMF02">CMF02</option>
						<option value="DMF">DMF</option>
						<option value="DOR">DOR</option>
						<option value="MFR">MFR</option>
						<option value="VTX01">VTX01</option>
						<option value="BKR">BKR</option>
						<option value="BKC">BKC</option>
						
						</select></td>
					<td width="63">VVD</td>
					<td width="150"><input type="text" style="width:78;" value="" class="input" dataformat="uppernum" name="vvd_cd" maxlength="9" style="ime-mode:disabled"></td>
					<td><input type="checkbox" value="" class="trans" name="date_check" checked>&nbsp;&nbsp;Send Date</td>
				</tr>
				<tr class="h23">
					<td width="">OFFICE</td>
					<td width=""><input type="text" style="width:78;" value="" name="ofc_cd" maxlength="6" dataformat="upper" class="input" style="ime-mode:disabled"></td>
					<td width="">USER  ID</td>
					<td width=""><input type="text" style="width:78;" value="" name="usr_id" maxlength="20" dataformat="num3" class="input" maxlength="20" style="ime-mode:disabled"></td>
					<td><input type="text" style="width:80;" value="<%=toDate%>" maxlength="10" dataformat="ymd" class="input" name="start_snd_dt" caption="Send Date" cofield="end_snd_dt">&nbsp;<input type="text" style="width:50;" value="00:00" name="start_snd_dt2" class="input" dataformat="hm" maxlength="5">&nbsp;~&nbsp;<input type="text" style="width:80;" value="<%=toDate%>" maxlength="10" name="end_snd_dt" dataformat="ymd" class="input" caption="Send Date" cofield="start_snd_dt">&nbsp;<input type="text" style="width:50;" value="23:59" name="end_snd_dt2" class="input" dataformat="hm" maxlength="5">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar"></td>
				</tr>
		</table> 
		<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
		<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>			
			<!-- Grid (E) -->
			
				</td></tr>
		</table>
		
		<table width="100%" border="0" cellpadding="0" cellspacing="0"> 
			<tr class="h23">
			<td width="50%">
			<!--Button (S) -->
		<table class="search" border="0" style="width:100%;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>

					</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	
		</td>
		<td>
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_view">View Send File</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_resend">Resend</td>
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
			
			</td></tr>
		</table>
	<!-- Grid BG Box  (S) -->
	<!--biz page (E)-->
	<table class="height_10"><tr><td colspan="8"></td></tr></table>
	</td></tr>
		</table>

</form>
</body>
</html>