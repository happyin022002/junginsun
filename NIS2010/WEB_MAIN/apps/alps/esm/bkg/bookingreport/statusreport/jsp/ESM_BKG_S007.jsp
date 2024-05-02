
<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : esm_bkg_S007.jsp
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.event.EsmBkgS007Event"%>	
<%@ page import="org.apache.log4j.Logger"%>

<%
		EsmBkgS007Event event = null; //PDTO(Data Transfer Object including Parameters)
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

		event = (EsmBkgS007Event) request.getAttribute("Event");
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
						<td width="95">Booking Date</td>
						<td width="" >
						  <input type="text" style="width:80" value="" class="input1"  name="bkg_from_dt"  maxlength='10' dataformat="ymd" >
						 &nbsp;~&nbsp;
						  <input type="text" style="width:80" value="" class="input1"  name="bkg_to_dt"  maxlength='10' dataformat="ymd" >
						  <img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_bkg_date">
							
						</td>
						<td width=""></td>
					</tr>
					</table>
					<table class="search" border="0" style="width:979;">
						<tr class="h23">
						<td width="95" >RHQ</td>
						<td width="110" >
							<script language="javascript">ComComboObject('rhq_cd', 1, 70, 0,0,0);</script>
						</td>
						<td width="80">BKG Office</td>
						<td width="70">
							<input type="text"  name="bkg_ofc_cd"  style="width:50;" class="input" value=""  style="ime-mode:disabled" dataformat="engup" caption="Booking Office" maxlength="6"  ></td>
						<td width="60">Contract</td>
						<td width="60">
							<script language="javascript">ComComboObject('ctrt_cd', 1, 60, 0,0,0);</script>
						</td>
						<td width="110">
							<input type="text" style="width:90;" class="input" maxlength='20' dataformat='engupnum' name="ctrt_no" style="ime-mode:disabled" value="">
						</td>
						<td width="80" align="right">B/L No.</td>
	                    <td width="100"><input type="text" style="width:90;" class="input1" name="bl_no" caption="bl_no" maxlength="20" style="ime-mode:disabled" /></td>
	                    <td width="200"></td> 
						</tr>
					</table>
					<table class="search" border="0" style="width:979;">
						<tr class="h23">
						<td width="95">Shipper</td>
						<td width="32"><input type="text" style="width:32;" class="input" name="cust_cnt_cd" value=""  maxlength='2'  dataformat='engup' style="ime-mode:disabled"></td>
						<td width="200"><input type="text" style="width:55;" class="input" maxlength='6' dataformat='num' name="cust_seq" style="ime-mode:disabled"  value="" >&nbsp;
						<input type="text" style="width:120;" class="input"  maxlength='50' name="cust_nm" value="" dataformat='engup'></td>
						<td width="150">Reason of Roll Over</td>
						<td width="60">
						<script language="javascript">ComComboObject('roll_ovr_rsn_cd', 1, 200, 0,0,0);</script></td>
						<td width="300"></td> 
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