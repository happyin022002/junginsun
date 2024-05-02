<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ui_bkg_0125.jsp
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.event.EsmBkg0129Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0129Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.wharfagemgt.wharfagedecmgt");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0129Event)request.getAttribute("Event");
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
<title>Wharfage Cargo Classification - B/L Check</title>
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

<body class="popup_bg" onLoad="setupPage();">
<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="frm_attr_ctnt2">

<!-- 개발자 작업	-->
<%
	String vvd       = (request.getParameter("vvd") == null)? "":request.getParameter("vvd");
	String portCd      = (request.getParameter("port_cd") == null)? "":request.getParameter("port_cd");
	String whfBndCd  = (request.getParameter("whf_bnd_cd") == null)? "":request.getParameter("whf_bnd_cd");
	String mrnNo     = (request.getParameter("mrn_no") == null)? "":request.getParameter("mrn_no");
%>
<input type="hidden" name="whf_bnd_cd" value= <%=whfBndCd %>>


<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td valign="top">
	
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">Wharfage Cargo Classification - Diff Check</td></tr>
		</table>
		<!--Page Title, Historical (E)-->
	
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
			
			<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="50">VVD</td>
					<td width="115"><input type="text" style="width:100;" class="input2" name="vvd" dataformat="ennum" maxlength="9" value="<%=vvd %>" readonly="readonly"></td>
					<td width="40">Port</td>
					<td width="70"><input type="text" style="width:80;" class="input2" name="port_cd" dataformat="engupnum" maxlength="5" value="<%=portCd %>" readonly="readonly"></td>
					<td width="30">Diff</td>
				    <td width="50">
					<select style="width:80;" class="input1" name="diff" onchange="searcgBySelect()">
						<option value="A" selected>ALL</option>
					<!-- 	<option value="M">Match</option> -->
						<option value="W">Only WHF</option>
						<option value="B">Only BKG</option>
					<%-- 	<option value="OO" <%if("O".equals(sBound)) out.println("selected");%>>OO – Outbound Export </option>
						<option value="ON">ON – Outbound</option>
						<option value="OT">OT – Outbound T/S</option>
						<option value="OM">OM – Outbound MT</option> --%>
					</select>
				</td>
				</tr> 
				<tr class="h23">
					<td>MRN No</td>
					<td><input type="text" style="width:100;" class="input2" name="mrn_no" dataformat="ennum" maxlength="11" value="<%=mrnNo %>" readonly="readonly"></td>
					<td>Bound</td>
<%-- 					<td><input type="text" style="width:50;" class="input2" name="whf_bnd_cd" dataformat="engup" maxlength="2" value="<%=whfBndCd %>" readonly="readonly"></td> --%>
					<td>
					
					     <input type="text" style="width:140;" class="input2" name="temp_whf_bnd_cd" dataformat="engup" maxlength="2" 
					     value="<%
					            if("II".equals(whfBndCd)) out.println("II - Inbound Import");
					            if("IN".equals(whfBndCd)) out.println("IN - Inbound");
					            if("IT".equals(whfBndCd)) out.println("II - Inbound Import");
					            if("IM".equals(whfBndCd)) out.println("IM - Inbound MT");
					            if("OO".equals(whfBndCd)) out.println("OO - Outbound Export");
					            if("ON".equals(whfBndCd)) out.println("ON - Outbound");
					            if("OT".equals(whfBndCd)) out.println("OT - Outbound T/S");
					            if("OM".equals(whfBndCd)) out.println("OM - Outbound MT");
					            %>" readonly="readonly">
						<%-- <select style="width:140;" class="input2" name="whf_bnd_cd" >
							<option value="II"<%if("II".equals(whfBndCd)) out.println("selected");%>>II - Inbound Import</option>
							<option value="IN"<%if("IN".equals(whfBndCd)) out.println("selected");%>>IN - Inbound </option>
							<option value="IT"<%if("IT".equals(whfBndCd)) out.println("selected");%>>IT - Inbound T/S</option>
							<option value="IM"<%if("IM".equals(whfBndCd)) out.println("selected");%>>IM - Inbound MT</option>
							<option value="OO"<%if("OO".equals(whfBndCd)) out.println("selected");%>>OO - Outbound Export </option>
							<option value="ON"<%if("ON".equals(whfBndCd)) out.println("selected");%>>ON - Outbound</option>
							<option value="OT"<%if("OT".equals(whfBndCd)) out.println("selected");%>>OT - Outbound T/S</option>
							<option value="OM"<%if("OM".equals(whfBndCd)) out.println("selected");%>>OM - Outbound MT</option>
						</select> --%>
					
					</td>
				</tr> 
				<tr><td height="3"></td></tr>
			</table>
				
				
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
       	<tr>
			<td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
		    <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>	
				</tr></table></td>
		   <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save" id="btn_save">Save</td>
					<td class="btn1_right"></td>	
				</tr></table></td>
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downexcel">Down Excel</td>
					<td class="btn1_right">
				</tr></table></td></td>	
			<td class="btn1_line"></td>
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right"></td>	
				</tr></table></td>				
			</tr>
		</table></td>				
			</tr>
		</table>
    	<!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
	

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>