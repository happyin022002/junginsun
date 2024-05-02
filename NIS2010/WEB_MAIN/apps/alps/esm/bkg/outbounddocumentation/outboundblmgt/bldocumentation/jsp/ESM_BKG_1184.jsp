<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1184
*@FileTitle : e-VGM Upload Monitoring
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.20
*@LastModifier : 조창우
*@LastVersion : 1.0
* 2016.04.20 조창우
* 1.0 Creation
===============================================================================
 History
 *
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.core.controller.util.WebKeys"%>
<%@ page import="com.hanjin.framework.core.view.template.Screen"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event.EsmBkg1184Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO" %>
<%@ page import="com.hanjin.apps.alps.esm.bkg.common.*" %>
<%@ page import="com.hanjin.framework.core.controller.DefaultViewAdapter"%>

<%
	EsmBkg1184Event  event = null;			//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String sXml				= "";
	Logger log = Logger.getLogger("com.hanjin.apps.OutboundBLMgt.BLDocumentation");

	// search Init
	String bkgOfcCd      = "";
	String vslCd       = "";
	String skdVoyNo       = "";
	String skdDirCd       = "";
	String polCd       = "";
	String scrnAuth   = "";

	//List<BkgComboVO> frt_terms = null;
	List<BkgComboVO> wgt_units = null;
	List<BkgComboVO> meas_units = null;

	try {

	   	SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg1184Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		Screen screen = (Screen) request.getAttribute(WebKeys.CURRENT_SCREEN);

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		DefaultViewAdapter adapter = new DefaultViewAdapter();
		sXml = adapter.makeXML(request, response);
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>e-VGM Upload Monitoring</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<body onLoad="setupPage();">

	<form name="form">
		<input type="hidden" name="f_cmd">
		<input type="hidden" name="pagerows" value="<%=pageRows%>">
		<input type="hidden" name="sXml" value="<%=sXml %>">
		<input type="hidden" name="page_no" value="1">		
		<input type="hidden" name="key">  <!-- BackEndJob -->

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
	<tr><td valign="top">

		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		
		<!-- TABLE '#D' : ( Button : Main ) (E) -->

		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search" id="mainTable">
		<tr>
			<td class="bg">
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="77">BKG No.</td>
					<td width="145"><input type="text" name="bkg_no" style="ime-mode:disabled;width:100;" maxlength="13" dataformat="engupnum" value="" class="input1">&nbsp;<img onClick="openAddPaste('bkg_no')" class="cursor" src="img/button/btng_plus.gif" width="19" height="20" border="0" align="absmiddle" name=""></td>
					<td width="30">VVD</td>
					<td width="120"><input type="text" name="f_vvd" style="ime-mode:disabled;width:100;" maxlength="9" dataformat="engupnum" value="" class="input"></td>
					
					<td width="95">Upload Status</td>	
					<td width="80" style="padding-left:0">
						<select style="width:75;" name="vgm_upld_sts_cd">
							<option value="" selected>All</option>
							<option value="N">N-New</option>
							<option value="F">F-Firm</option>
							<option value="R">R-Reject</option>
						</select></td>	
					
					<td width="285"></td>
					<td width="148"></td>
				</tr>
				</table>

				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="77">CNTR No.</td>
					<td width="145"><input type="text" name="cntr_no" style="ime-mode:disabled;width:100;" maxlength="11" dataformat="engupnum" value="" class="input">&nbsp;<img onClick="openAddPaste('cntr_no')" class="cursor" src="img/button/btng_plus.gif" width="19" height="20" border="0" align="absmiddle" name=""></td>
					<td width="30">POL</td>
					<td width="120"><input type="text" name="pol_cd" style="width:70;" maxlength="5" dataformat="etc" value="" class="input"></td>
					<td width="95">BKG Office</td>
					<td width="100"><input type="text" name="bkg_ofc_cd" style="width:75;" maxlength="6" dataformat="etc" value="" class="input"></td>
					<td width="90">Request Date</td>
					<td width="220"><input type="text" style="width:75" maxlength="10" class="input1" name="rqst_from_dt" dataformat="ymd">&nbsp;&nbsp;~&nbsp;&nbsp;
					<input type="text" style="width:75" maxlength="10" class="input1" name="rqst_to_dt" dataformat="ymd">&nbsp;
					<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_calendar">
					</td>
					<td width="103"></td>
				</tr>
				</table>
			</td>
		</tr>
		</table>
		
		
		</td></tr></table>
		<table class="height_8"><tr><td></td></tr></table>	
		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg">
					<!-- TABLE '#D' : ( Grid ) (S) -->
					<!-- 'HEAD1-BGCOLOR : 192 235 163' , 'HEAD2-BGCOLOR : 231 250 249' , 'BORDER : 90 138 158' , 'HEAD1-FONT : 0 83 116' , 'DATA GRID BG (2 colors) : 255 255 255, 249 249 249 ' -->
					<table width="100%" id="mainTable">
					<tr><td>
					   <script language="javascript">ComSheetObject('t2sheet1');</script>
					</td></tr>
					
					</table>
					
					<!-- TABLE '#D' : ( Grid ) (E) --></td>
			</tr>
		</table>
		<table class="height_8"><tr><td></td></tr></table>
		
		<table width="100%" class="button" border="0">
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_history">History</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_upload">Manual Upload</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>		
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DownExcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>	
			</tr>
			</table>
		</td></tr>
		</table>
<!-- OUTER - (E)nd -->
	</form>
</body>
</html>