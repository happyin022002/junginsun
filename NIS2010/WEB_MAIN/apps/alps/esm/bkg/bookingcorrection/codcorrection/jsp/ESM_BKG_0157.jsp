<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0157.jsp
*@FileTitle : COD Status Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.23
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.07.23 최영희
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.event.EsmBkg0157Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0157Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_nm        = "";
 
	Logger log = Logger.getLogger("com.hanjin.apps.BookingCorrection.CODCorrection");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
        strOfc_nm = account.getOfc_cd(); //getOfc_cd(),getOfc_eng_nm(),getOfc_krn_nm()

		event = (EsmBkg0157Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        
		 
        
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>COD Status Inquiry</title>
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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->

	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">

				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="70">&nbsp;&nbsp;Duration</td>
					<td width="250"><input type="text" style="width:80;" class="input1"   dataformat="ymd" name="dur_from">&nbsp;&nbsp;~&nbsp&nbsp;<input type="text" style="width:80;" class="input1"  dataformat="ymd" name="dur_to">&nbsp;<img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="btn_Duration"></td>
							
					<td width="70">BKG Office</td>
					<td width="90"><input type="text" style="width:70;" class="input1" value="<%=strOfc_nm%>" name="bkg_ofc_cd" maxlength="6" dataformat="engup" ></td>
					<td width="30">POL</td>
					<td width="80"><input type="text" style="width:60;" class="input" value="" name="pol_cd" maxlength="5" dataformat="engup"></td>
					<td width="30">T/VVD</td>
					<td width="110"><input type="text" style="width:90;" class="input" value="" name="vvd" maxlength="9" dataformat="engup"></td>
					<td width="50">BKG No.</td>
					<td><input type="text" style="width:110;" class="input" value="" name="bkg_no" maxlength="13" dataformat="engup"></td>
				</tr>
				</table>
				<table class="height_2"><tr><td></td></tr></table>
				<table class="search_sm" border="0" style="width:979;"> 
				<tr>
					<td><input type="radio" value="A" class="trans" checked name="cod_sts_cd">&nbsp;<strong>All</strong>
					<input type="radio" value="R" class="trans" name="cod_sts_cd"><strong>&nbsp;R</strong>&nbsp;(Request)
					<input type="radio" value="W" class="trans" name="cod_sts_cd"><strong>&nbsp;W</strong>&nbsp;(Waiting for Partner’s Confirmation)
					<input type="radio" value="Y" class="trans" name="cod_sts_cd"><strong>&nbsp;Y</strong>&nbsp;(Approved)
					<input type="radio" value="N" class="trans" name="cod_sts_cd"><strong>&nbsp;N</strong>&nbsp;(Rejected)
					<input type="radio" value="C" class="trans" name="cod_sts_cd"><strong>&nbsp;C</strong>&nbsp;(Cancel COD)
					<input type="radio" value="F" class="trans" name="cod_sts_cd"><strong>&nbsp;F</strong>&nbsp;(Booking Confirm)
					<input type="radio" value="M" class="trans" name="cod_sts_cd"><strong>&nbsp;M</strong>&nbsp;(Manual)
					</td>
				</tr>
				</table>
				<!--  biz_1   (E) -->
				</td></tr>
			</table>
			<table class="height_8"><tr><td></td></tr></table>
		<!-- Grid BG Box  (S) -->
     	<table class="search" id="mainTable">
       	<tr><td class="bg">
			
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
	<!-- Grid BG Box  (S) -->
	<!--biz page (E)-->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					<td class="btn1_line"></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DownExcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_CodInquiry">COD Inquiry</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	</td></tr>
		</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>