<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ui_bkg_0551.jsp
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.event.EsmBkg0551Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0551Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";

	String vvd   = "";
	String ssrNo = "";
	String pod   = "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.ManifestListDownload");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0551Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		vvd   = (request.getParameter("vvd") == null)? "":request.getParameter("vvd");
		ssrNo = (request.getParameter("ssr_no")== null)?"":request.getParameter("ssr_no");
		pod   = (request.getParameter("pod")== null)?"":request.getParameter("pod");
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
	
%>
<html>
<head>
<title>Ancs ACI: Vessel Arrival Manifest (A6)</title>
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
<input type="hidden" name="chk_down">

<!-- 개발자 작업	-->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	
	<tr><td valign="top">
	
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->
		
		<!-- 1 (S) -->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			

				<!--  biz_1 (S) -->
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="100">Call Date (ETA)</td>
						<td width="245" class="sm">
						<input type="text"
							style="width: 75; ime-mode: disabled" class="input1" value=""
							dataformat="ymd" maxlength="10" name="s_vps_eta_dt" dataformat="eng" caption="ETA" cofield="e_vps_eta_dt" >
						&nbsp;~&nbsp; <input type="text"
							style="width: 75; ime-mode: disabled" class="input1" value=""
							dataformat="ymd" maxlength="10" name="e_vps_eta_dt" dataformat="eng" caption="ETA" cofield="s_vps_eta_dt">
						<img src="img/btns_calendar.gif" width="19" height="20" alt=""
							border="0" align="absmiddle" class="cursor" name="btn_calendar">
						</td>
						
						<td width="30">VVD</td>
						<td width="135"><input type="text" style="width:100;ime-mode:disabled" name="vvd" maxlength="9" dataformat="ennum" class="input" value="<%=vvd %>"></td>
						<td width="30">SSR</td>
						<td width="115"><input type="text" style="width:80;ime-mode:disabled"  name="svc_rqst_no" maxlength="6" dataformat="uppernum" class="input" value="<%=ssrNo %>"></td>
						<td width="48">Status</td>
						<td width="135"><select style="width:100;" class="input1" name="msg_sts_cd">
									<option value="L" selected="selected">All</option>
									<option value="N" >Initial</option>
									<option value="A">Accepted</option>
									</select></td>
						<td width="35">DNLD</td>
						<td align="right"><select style="width:100;" class="input1" name="bkg_count">
									<option value="A" selected="selected">All</option>
									<option value="N">Uncompleted</option>
									<option value="F">Completed</option>
									</select></td></tr>
				</table>
				<!--  biz_1   (E) -->		
					
			
		</td></tr></table>
		<!-- 1 (E) -->

		<!-- 2 (S) -->
		<table class="height_8"><tr><td></td></tr></table>	
		<table class="search" id="mainTable"> 
   		<tr><td class="bg">	
			
			
			<!-- Grid_1 (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
			<!-- Grid_1 (E) -->		
			


			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			
			<!-- Grid 2, VVD - frame (S) -->
			<table class="search">
			<tr><td width="80%" style="padding-right:20" valign="top">
			
				<!-- Grid_2 (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>
				<!-- Grid_2 (E) -->	

			</td>
			<td width="20%" valign="top">
			
				<!-- VVD (S) -->
				<table border="0" style="width:100%; background-color:#E8E7EC;" class="grid2"> 
				<tr><td class="tr2_head" style=" background-color:rgb(201,202,235);" width="40%">VVD</td>
					<td><input type="text"
							style="width: 100%; text-align: left" class="noinput2"
							readOnly="true" name="vvd1"></td></tr>
				<tr><td class="tr2_head" style=" background-color:rgb(201,202,235);">POL</td>
					<td><input type="text"
							style="width: 100%; text-align: left" class="noinput2"
							readOnly="true" name="pol1"></td></tr>
				</table>
				<!-- VVD (E) -->
			
			</td></tr>
			</table>
			<!-- Grid 2, VVD - frame (E) -->
			
			</td></tr>
		</table>
		<!-- 2 (E) -->

		
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;"> 
       	<tr><td class="btn1_bg">
		
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_BLList">B/L List</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_SSRView">SSR View</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Download">Download</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_addLane">Add Lane</td>
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