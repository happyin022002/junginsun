<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ui_bkg_0063.jsp
*@FileTitle : ACI_Vessel Information
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.04.24 정재엽
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>	
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.event.EsmBkg0063Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0063Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.ManifestListDownload");
	
	String vvd   = (request.getParameter("vvd") == null)? "":request.getParameter("vvd");
	String ssrNo = (request.getParameter("ssr_no")== null)?"":request.getParameter("ssr_no");
	String pod   = (request.getParameter("pod")== null)?"":request.getParameter("pod");
	String popup   = (request.getParameter("popup")== null)?"":request.getParameter("popup");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0063Event)request.getAttribute("Event");
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
<title>B/L List for CUSCAR</title>
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

<body  onLoad="setupPage();">
<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="frm_attr_ctnt2">
<input type="hidden" name="in_pod" value="<%=pod %>">
<input type="hidden" name="popup" value="<%=popup %>">
<!-- 개발자 작업	-->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	
	
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		
			<tr><td class="history"><div id="navi"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation" ></span></div></td></tr>
			<% if( "y".equals( popup ) ){ %>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;B/L List for CUSCAR</td></tr>
			<% }else{ %>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title">&nbsp;B/L List for CUSCAR</span></td></tr>
			<% } %>	
				
	</table>
	<!--Page Title, Historical (E)-->

	
	<!--Button (S) -->
		
    <!--Button (E) -->
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">

				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="30">VVD</td>
					<td width="125"><input type="text" style="width:100;text-align:center;;ime-mode:disabled" name="vvd" class="input1" align="middle" maxlength="9" dataformat="ennum" value="<%=vvd %>"></td>
					<td width="50">SSR No.</td>
					<td width="120"><input type="text" style="width:100;text-align:center;;ime-mode:disabled" name="ssr_no" class="input" align="middle" maxlength="7" dataformat="int" value="<%=ssrNo %>"></td>
					<td width="30">POL</td>
					<td width="100"><input type="text" style="width:80;ime-mode: disabled" name="pol_cd" class="input" align="middle" fullfill maxlength="5" dataformat="ennum"></td>
					<td width="30">POD</td>
					<td width="120"><script language="JavaScript">ComComboObject("pod", 1, 110);</script></td>
					<td width="60">VSL Name</td>
					<td width="150"><input type="text" style="width:80%;text-align:center;" name="vsl_name" class="input2" align="middle" maxlength="50" dataformat="ennum" readonly="readonly"></td>
					<td width="26">ETA</td>
					<td width=""><input type="text" style="width:100%;text-align:center;" name="eta" class="input2" maxlength="10" dataformat="ymd" readonly="readonly"></td>
				</tr>
				
				</table>
				
				
				</td></tr>
			</table>
			<table class="height_8"><tr><td></td></tr></table>
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
				<!-- Grid (E) -->
			
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>	
			
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>			
				<!-- Grid (E) -->
				<script language="javascript">ComSheetObject('sheet0');</script>
				<script language="javascript">ComSheetObject('sheet3');</script>
				<script language="javascript">ComSheetObject('sheet4');</script>
		</td></tr>
		</table>
				
	
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>				
				<td><table border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>	
				<td class="btn1_line"></td>
				<td><table border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downexcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>	
				
				<td><table border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_cuscar">CUSCAR</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>	
				<td><table border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_view">B/L View</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>	
				<td><table border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_transfer">CUSCAR Transmit</td>
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

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>