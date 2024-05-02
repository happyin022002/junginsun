<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0723.jsp
*@FileTitle : ESM_BKG_0723
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.07.10 김승민
* 1.0 Creation
* ------------------------------------------------------
* History
* 2012.08.17 김보배 [CHM-201219430] [BKG] COPRAR (Pre-S/O) EDI 보완건
* 2015.02.09 이한나 [CHM-201533845] CLL/CDL 메뉴에 Calling sequence 추가
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.event.EsmBkg0723Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0723Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String inListType		= "";
	String inVvdCd			= "";
	String inPolCd			= "";
	String inPodCd			= "";
	String allPol			= "";
	String bkgCgoTpCd			= "";
	String inPolSplitNo		= "";
	String inPodSplitNo     = "";
		
	Logger log = Logger.getLogger("com.hanjin.apps.TerminalDocumentation.CLLCDLManifest");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		inListType = request.getParameter("inListType")==null?"":request.getParameter("inListType");
		allPol = request.getParameter("allPol")==null?"":request.getParameter("allPol");
		inVvdCd = request.getParameter("inVvdCd")==null?"":request.getParameter("inVvdCd");
		inPolCd = request.getParameter("inPolCd")==null?"":request.getParameter("inPolCd");
		inPodCd = request.getParameter("inPodCd")==null?"":request.getParameter("inPodCd");
		bkgCgoTpCd = request.getParameter("inBkgCgoTpCd")==null?"":request.getParameter("inBkgCgoTpCd");
		
		inPolSplitNo = request.getParameter("inPolSplitNo")==null?"":request.getParameter("inPolSplitNo");
		inPodSplitNo = request.getParameter("inPodSplitNo")==null?"":request.getParameter("inPodSplitNo");

		event = (EsmBkg0723Event)request.getAttribute("Event");
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
<title>ESM_BKG_0723</title>
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

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="in_vvd_cd" value="<%=inVvdCd %>">
<input type="hidden" name="in_pol_cd" value="<%=inPolCd %>">
<input type="hidden" name="in_pod_cd" value="<%=inPodCd %>">
<input type="hidden" name="in_pod_split_no" value="<%=inPodSplitNo %>">
<input type="hidden" name="in_pol_split_no" value="<%=inPolSplitNo %>">

<input type="hidden" name="allPol" value="<%=allPol %>">
<input type="hidden" name="bkg_cgo_tp_cd" value="<%=bkgCgoTpCd %>">
<input type="hidden" name="port_cd" value="">
<input type="hidden" name="in_list_type" value="<%=inListType %>">
<input type="hidden" name="in_rcv_id">
<input type="hidden" name="in_snd_id">
<input type="hidden" name="in_yd_cd">
<input type="hidden" name="in_dest_svr_cd">
<input type="hidden" name="in_area_id">
<input type="hidden" name="in_vvd_flg">
<input type="hidden" name="in_bl_flg">
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"> CLL/CDL for EDI</span></td></tr>
		</table>	
		<!-- : ( Title ) (E) -->
		
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
			
				<!--  biz_1 (S) -->
				<table class="search" border="0" style="width:100%;"> 
					<tr class="h23">
						<td width="120">List Type</td>
						<td><input type="text" class="input2" name="in_list_type_view" style="width:184;" value="<%if(inListType.equals("L")){%>Loading List<%}else{%>Discharging List<%}%>" readonly></td></tr>
					<tr class="h23">						
						<td>VVD</td>
						<td><input type="text" class="input2" name="in_vvd_cd_view" style="width:184;" value="<%=inVvdCd %>" readonly></td></tr>
					<tr class="h23">
						<td><%if(inListType.equals("L")){%>POL<%}else{%>POD<%}%></td>
						<td><input type="text" class="input2" name="in_port_cd" style="width:184;" value="<%if(inListType.equals("L")){%><%=inPolCd%><%}else{%><%=inPodCd%><%}%>" readonly></td></tr>
					<tr class="h23">
						<td>Terminal VVD</td>
						<td><input type="text" class="input" name="in_terminal_vvd_cd" style="width:184;" maxlength="7" value="" dataformat="uppernum" style="ime-mode:disabled"></td></tr>
					<tr class="h23">
						<td>EDI Message Type</td>
						<td>
							<select style="width:100;" name="in_edi_msg_func">
							<option value="ORIGINAL" selected>Original</option>
							<option value="REPLACE">Replace</option>
							<option value="CANCEL">Cancel</option>
							<option value="CHANGE">Change</option>
							<option value="ADDITION">Addition</option>
							</select></td></tr>
				</table>
				<!--  biz_1   (E) -->	
				
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
		<!--biz page (E)--> 
<table class="height_5"><tr><td></td></tr></table>
</td></tr></table>


	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

    	<!--Button (S) -->	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="70" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_OK">OK</td>
					<td class="btn1_right">
				</tr></table></td>	
			<td class="btn1_line"></td>
			<td><table width="70" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
					<td class="btn1_right">
				</tr></table></td>
			</tr>
		</table></td>
			</tr>
		</table>
    	<!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
				<table width="100%"  id="mainTable" style="display:none"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>
</form>
</body>
</html>