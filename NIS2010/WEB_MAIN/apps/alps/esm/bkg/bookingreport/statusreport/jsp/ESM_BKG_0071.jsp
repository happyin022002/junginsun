
<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : esm_bkg_0071.jsp
	 *@FileTitle : BDR Status Inquiry
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.05.13
	 *@LastModifier : 김경섭
	 *@LastVersion : 1.0
	 * 2009.05.13 김경섭
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.event.EsmBkg0071Event"%>	
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0071Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	boolean bBtn_Disabled = true;
	Logger log = Logger
			.getLogger("com.hanjin.apps.CustomsDeclaration.CndManifestListDownload");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0071Event) request.getAttribute("Event");
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
<title>Welcome to alps!</title>
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

<body onLoad="setupPage();">
<!--DIV ID='debugdiv'></DIV-->
<form name="form">
	<input type="hidden" name="f_cmd"> 
	<input type="hidden" name="pagerows"> 
	<input type="hidden" name="ch_usr_id">
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
		<!--Page Title, Historical (E)--> <!-- : ( Search Options ) (S) -->

			<table class="search"> 
       	<tr><td class="bg">

					<!--  biz_1  (S) -->
					<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="43">VVD</td>
						<td width="170"><input type="text" style="width:100" value="" class="input1" name="vvd_cd" maxlength='9' required fullfill  dataformat='engupnum' style="ime-mode:disabled"></td>
						<td width="25">POL</td>
						<td width="170"><input type="text" style="width:89" value="" class="input" name="pol_cd" maxlength='5' dataformat='engup' style="ime-mode:disabled"></td>
						<td width="25">POD</td>
						<td width="170"><input type="text" style="width:100" value="" class="input" name="pod_cd" maxlength='5' dataformat='engup' style="ime-mode:disabled"></td>
						<td width="30">Lane</td>
						<td width="210">
					   <!-- comboid, iColCnt, iWidth , iStyle, iCss, iShowCol, iEdit, iTab --> 
							<script language="javascript">ComComboObject('slan_cd', 1, 67, 0);</script>
							
						<!--<select style="width:67;" name="slan_cd">
							<option value="" ></option>
							</select>&nbsp;
							-->
							&nbsp;
							Dir<span style="width:3px"></span>
							<script language="javascript">ComComboObject('skd_dir_cd', 1, 57, 1 );</script>
							<!--<select style="width:57;" name="skd_dir_cd">
								<option value="" ></option>
								<option value="0" >E</option>
								<option value="1">W</option>
							</select>
							--></td>
						<td width="66">BDR Date</td>
						<td width="80"><input type="text" style="width:100%" value="" class="input" name="bdr_dt"  maxlength='10' dataformat="ymd" ></td>
						<td width="">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_bdrdate"></td>
					</tr>
					<tr class="h23">
						<td width="">Period</td>
						<td width="" style="padding-left:2" colspan="7">
						<select style="width:101;"  name="period_type">
							<option value=""></option>
							<option value="POL/ETD" >POL/ETD</option>
							<option value="POD/ETA">POD/ETA</option>
							</select>&nbsp;
								<input type="text" style="width:80" value="" class="input"  name="from_dt"  maxlength='10' dataformat="ymd" >
								&nbsp;~&nbsp;
							  <input type="text" style="width:80" value="" class="input"  name="to_dt"  maxlength='10' dataformat="ymd" >
							  <img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_period"></td>
						<td width="66">Runtime</td>
						<td width="" colspan='2'><input type="text" style="width:100%" value="" class="input2" name="runtime" readonly></td>							
					</tr>
					</table>
				
				</td></tr>
			</table>

			<table class="height_8"><tr><td></td></tr></table>
			
		<table class="search">
			<tr>
				<td class="bg">

					<!-- : ( Grid ) (S) -->
					<table width="100%" id="mainTable">
						<tr>
							<td width="100%"><script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<!-- : ( Search Options ) (E) --></td>
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
				<table width="" border="0" cellpadding="0" cellspacing="0"
					class="button">
					<tr>
						<td class="btn1_left"></td>
						<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
						<td class="btn1_right"></td>
					</tr>
				</table>
				</td>
				<td>
				<table width="" border="0" cellpadding="0" cellspacing="0"
					class="button">
					<tr>
						<td class="btn1_left"></td>
						<td class="btn1" name="btn_BKGList">BKG List	</td>
						<td class="btn1_right"></td>
					</tr>
				</table>
				</td>
				<td class="btn1_line"></td>
				<td>
				<table width="" border="0" cellpadding="0" cellspacing="0"
					class="button">
					<tr>
						<td class="btn1_left"></td>
						<td class="btn1" name="btn_DownExcel">Down Excel</td>
						<td class="btn1_right"></td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		</td>
	</tr>
</table>
<!--Button (E) --> <!--biz page (E)-->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>