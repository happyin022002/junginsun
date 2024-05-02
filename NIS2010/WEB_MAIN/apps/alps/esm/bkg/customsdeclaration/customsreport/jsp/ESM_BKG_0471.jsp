
<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : esm_bkg_0471.jsp
	 *@FileTitle : ESM_BKG-0471 
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

<%@ page contentType = "text/html; charset=UTF-8"%>
<%@ page import = "com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import = "java.util.Date"%>
<%@ page import = "com.hanjin.framework.component.util.DateTime"%>
<%@ page import = "com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import = "com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import = "com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import = "com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import = "com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.japan.event.EsmBkg0471Event"%>
<%@ page import = "org.apache.log4j.Logger"%>

<%
	EsmBkg0471Event event = null; //PDTO(Data Transfer Object including Parameters)
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

		event = (EsmBkg0471Event) request.getAttribute("Event");
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
<title>ESM_BKG-0471</title>
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

<input type="hidden" name="jp_msg_tp_cd">
<input type="hidden" size="200" name="com_mrdPath" value="apps/alps/esm/bkg/customsdeclaration/customsreport/report/ESM_BKG_0881.mrd">
<input type="hidden" size="200" name="com_mrdArguments" value="">
<input type="hidden" size="200" name="com_mrdTitle" value="Receive History from SEA_NACCS_Print">
<input type="hidden" size="200" name="com_mrdBodyTitle" value="<span style=&quot;color:red&quot;>Receive History from SEA_NACCS_Print</span>">


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
					<td width="70">MSG TYPE</td>
					<td width="210"><select name="disp_jp_msg_tp_cd1" class="input1" style="width:95px;">
							<option value="" selected>ALL</option>
							<option value="ACL01">ACL01</option>
							<option value="CMF01">CMF01</option>
							<option value="CMF02">CMF02</option>
							<option value="DMF">DMF</option>
							<option value="DOR">DOR</option>
							<option value="MFR">MFR</option>
							<option value="VTX01">VTX01</option>
							<option value="BKR">BKR</option>
							<option value="BKC">BKC</option>
							<option value="BKC-REPLY">BKC-STA076</option>
						</select><select name="disp_jp_msg_tp_cd2" class="input1" style="width:95px; display:none;">
							<option value="" selected>ALL</option>
							<option value="SAS111">SAS111</option>
							<option value="SAS108">SAS108</option>
							<option value="SAMR">SAMR</option>
							<option value="SCMR">SCMR</option>
							<option value="SATD">SATD</option>
						</select>
						<input type="checkbox" value="JP24" class="trans" name="jp24_check">&nbsp;JP24</td>
					<td width="60">USER ID</td>
					<td width="120"><input type="text" style="width:80;" value="" dataformat="num3" name="usr_id" class="input" maxlength="20" style="ime-mode:disabled"></td>
					<td width="180" rowspan="2">
						<table class="search_sm2" border="0" style="width:80%;">
							<tr class="h23">
								<td width="85">&nbsp;&nbsp;MFR ERROR</td>

							</tr>
							<tr><td class="sm"><input type="radio" value="A" class="trans" id="errorCheck1" name="error_check" checked disabled>&nbsp;&nbsp;ALL&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" value="E" class="trans" name="error_check" id="errorCheck2" disabled>&nbsp;&nbsp;ERROR</td></tr>
						</table>
					</td>
					<td><input type="checkbox" value="" class="trans" name="date_check" checked>&nbsp;&nbsp;Receive Date</td>
				</tr>

				<tr class="h23">
					<td colspan="5" >VVD&nbsp;&nbsp;&nbsp; <input type="text" style="width:80;" value="" dataformat="uppernum" name="in_vvd_cd" class="input" maxlength="9" style="ime-mode:disabled">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;POD&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" style="width:80;" value="" dataformat="upper" name="in_pod_cd" class="input" maxlength="5" style="ime-mode:disabled">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;BKG No.&nbsp;&nbsp;&nbsp;<input type="text" style="width:80;" value="" name="bkg_no" class="input2" dataformat="uppernum"  maxlength="13" style="ime-mode:disabled" readOnly></td>
					<td><input type="text" style="width:80;" value="<%=toDate%>" maxlength="10" dataformat="ymd" class="input" name="start_rcv_dt" caption="Receive Date" cofield="end_rcv_dt">&nbsp;<input type="text" style="width:50;" value="00:00" name="start_rcv_dt2" class="input" maxlength="5" dataformat="hm">&nbsp;~&nbsp;<input type="text" style="width:80;" value="<%=toDate%>" name="end_rcv_dt" maxlength="10" dataformat="ymd" class="input" caption="Receive Date" cofield="start_rcv_dt">&nbsp;<input type="text" style="width:50;" value="23:59" name="end_rcv_dt2" class="input" maxlength="5" dataformat="hm">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar"></td>
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
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_view">View Receive File</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_mfr">MFR</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_print">Print</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	<!-- Grid BG Box  (S) -->
	<!--biz page (E)-->
	</td></tr>
		</table>
</form>
</body>
</html>