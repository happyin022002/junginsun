<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1187.jsp
*@FileTitle : VERMAS Transmit to Terminal
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.30
*@LastModifier : 
*@LastVersion : 1.0
* 
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event.EsmBkg1187Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO" %>
<%@ page import="com.hanjin.apps.alps.esm.bkg.common.*" %>

<%
	EsmBkg1187Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.OutboundBLMgt.BLDocumentation");
	String usrCntCd = null;
	List<BkgComboVO> bkg_sts_cd = null;
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg1187Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		bkg_sts_cd = (List<BkgComboVO>) eventResponse.getCustomData("bkg_sts_cd");
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Booking EDI Transmit to Terminal</title>
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
					<td width="70">BKG Date</td>
					<td width="260"><input type="text" style="width:75" maxlength="10" class="input1" name="bkg_from_dt" caption="BKG DT" dataformat="ymd">&nbsp;&nbsp;~&nbsp;&nbsp;<input type="text" style="width:75" maxlength="10" class="input1" name="bkg_to_dt" caption="BKG DT" dataformat="ymd">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar"></td>
					<td width="60">BKG OFC</td>
					<td width="60"><input type="text" name="bkg_ofc_cd" style="width:45;" maxlength="6" dataformat="engup" class="input" value=""></td> 
					<td width="80">BKG Status</td>
					<td width="97"><%=HTMLUtil.getComboString("bkg_sts_cd", "width:70;", "", "","","All", bkg_sts_cd)%></td>
					<td width="127">EDI Send Status</td>
					<td width="67">
						<select style="width:45;" name="edi_send_sts_cd">
						<option value="0" selected>All</option>
						<option value="Y">Yes</option>
						<option value="N">No</option>
						</select>
					</td>
					<td width="158"></td>
					<td width=""></td>
				</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="60">VVD</td>
					<td width="125"><input type="text" name="vvd" style="width:85" maxlength="9" dataformat="engup" class="input1" value="" caption="VVD"></td>
					<td width="40">POL</td>
					<td width="130"><input type="text" name="pol_cd" style="width:65;" maxlength="5" dataformat="engup" class="input1" value="" caption="POL">&nbsp;<input type="text" name="pol_yd_cd" maxlength="2" dataformat="engup" style="width:25;" value="" class="input1"></td>
					<td width="35">Lane</td>
					<td width="83"><input type="text" name="slan_cd" style="width:45;" maxlength="3" dataformat="engup" class="input" value=""></td>
					<td width="55">BKG No.</td>
					<td width="132"><input type="text" name="bkg_no" style="width:100;" maxlength="13" dataformat="engup" class="input1" value="" caption="BKG NO"></td>
					<td width="65">BKG Staff</td>
					<td width="254"><input type="text" name="bkg_staff" style="width:75;" maxlength="20" dataformat="engnum" class="input" value=""></td>
					<td width=""></td>
				</tr>
				</table>
		</td></tr>
	</table>

	<table class="height_8"><tr><td colspan="8"></td></tr></table>

	<table class="search"> 
       	<tr><td class="bg">

				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table> 
				<!-- Grid  (E) -->

				

				<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td width="75"></td>
						<td width="78"></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_EDITransmit">EDI Transmit</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_CheckAll">Check All</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_UncheckAll">Uncheck All</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
				</td></tr>
			</table>
	<!-- Grid BG Box  (E) -->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_DownExcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	<!--biz page (E)-->
	
	</td></tr>
		</table>
</form>
</body>
</html>
