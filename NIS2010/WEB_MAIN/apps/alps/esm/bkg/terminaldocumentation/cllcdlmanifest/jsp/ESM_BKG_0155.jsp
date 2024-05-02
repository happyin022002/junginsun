<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0155.jsp
*@FileTitle : ESM_BKG_0155
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.07.10 김승민
* 1.0 Creation
* 2015.02.09 이한나 [CHM-201533845] CLL/CDL 메뉴에 Calling sequence 추가
* 2015.04.20 신영재 소스보안 결함 수정
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.event.EsmBkg0155Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>

<%
	EsmBkg0155Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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
	String inPolTs			= "";
	String inPolSplitNo     = "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.TerminalDocumentation.CLLCDLManifest");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		inListType =StringUtil.xssFilter(request.getParameter("inListType"))==null?"":StringUtil.xssFilter(request.getParameter("inListType"));
		inVvdCd = StringUtil.xssFilter(request.getParameter("inVvdCd"))==null?"":StringUtil.xssFilter(request.getParameter("inVvdCd"));
		inPolCd = StringUtil.xssFilter(request.getParameter("inPolCd"))==null?"":StringUtil.xssFilter(request.getParameter("inPolCd"));
		inPolTs = StringUtil.xssFilter(request.getParameter("inPolTs"))==null?"":StringUtil.xssFilter(request.getParameter("inPolTs"));
		inPolSplitNo = StringUtil.xssFilter(request.getParameter("inPolSplitNo"))==null?"":StringUtil.xssFilter(request.getParameter("inPolSplitNo"));

		event = (EsmBkg0155Event)request.getAttribute("Event");
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
<title>ESM_BKG_0155</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		//alert("test");
		loadPage();
	}
</script>
</head>

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="inListType" value="<%=inListType %>">
<input type="hidden" name="popBkgNo">
<input type="hidden" name="in_pol_split_no" value="<%=inPolSplitNo %>">
<input type="hidden" name="local_type" value="">
<input type="hidden" name="ts_type" value="">
<table width="100%" class="popup" cellpadding="10" border="0"> 
	<tr><td class="top"></td></tr>
	<tr>
		<td valign="top">
			<table width="100%" border="0">
			<tr><td height="79" class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;CLL for EDI</td></tr>
			</table>		
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				
				<tr class="h23">
					<td width="60">VVD</td>
					<td width="130">&nbsp;&nbsp;<input type="text" style="width:80;" class="input" name="in_vvd_cd" dataformat="uppernum" maxlength="9" value="<%=inVvdCd %>" style="ime-mode:disabled"></td>
					<td width="30">POL</td>
					<td width="130"><input type="text" style="width:80;" class="input" name="in_pol_cd" maxlength="5" dataformat="upper" value="<%=inPolCd %>" style="ime-mode:disabled"></td>
					<td width="30">ETA</td>
					<td width="150"><input type="text" style="width:110;" class="input2" name="eta_dt" value="" readonly></td>
					<td width="30">ETD</td>
					<td width="150"><input type="text" style="width:110;" class="input2" name="etd_dt" value="" readonly></td>
					<td width="65">Local T/S</td>
					<td width="70">
					<select name="in_local_ts">
					<option value="" <%if(inPolTs.equals("")){%>selected<%}%>>ALL</option>
					<option value="T" <%if(inPolTs.equals("T")){%>selected<%}%>>T/S</option>
					<option value="L" <%if(inPolTs.equals("L")){%>selected<%}%>>Local</option>
					</select>
					<!--input type="text" style="width:30;" class="input" name="in_local_ts" dataformat="upper" maxlength="1" value="<%=inPolTs %>" style="ime-mode:disabled"--></td>
					<td width="50">User ID</td>
					<td width=""><input type="text" style="width:100;" class="input2" name="upd_usr_id" value="<%=strUsr_id%>" readonly></td>
					</tr> 
				</table>	
				
				<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				
				<tr class="h23">
				
			
				<td>
							<table border="0" style="" class="search_sm2"> 
								<tr class="h23">
								<td width="100">Transmission&nbsp;: </td>
								<td width="50">Local</td>
					   	 		<td width="160"class="stm"><input type="radio" name="local_t" value=""class="trans"  checked >All&nbsp;&nbsp;<input type="radio" value="" name="local_t"  class="trans" >Only VGM</td>
					   	 		<td width="30">&nbsp;&nbsp;TS</td>
					   	 		<td width="160"class="stm"><input type="radio" name="ts_t" value=""class="trans"  checked>All&nbsp;&nbsp;<input type="radio" value="" name="ts_t"  class="trans" >Only VGM</td>
					   	 		</tr>
								
							</table>
							</td>
				
										
				<!--  biz_1   (E) -->
			
		</td></tr></table>
		<table class="height_8"><tr><td></td></tr></table>	
		<table class="search" id="mainTable"> 
       		<tr><td class="bg" width=100%>	
			
			
			<!-- Grid  (S) -->
				<table width="100%" class="search" > 
						<tr>
							<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
				</table> 
			<!-- Grid (E) -->			
			<table class="search" border="0" style="width:979;"> 
				<tr  class="h23">
				<td>
			
			<table class="search" border="0" style="width:600;"> 
				<tr  class="h23">
				<td width="60">Total</td>
				<td width="40" class="stm">CNTR</td>
				<td width="120"><input type="text" style="width:80;text-align:right" class="input" name="cntr" value="" readonly></td>
				<td width="30" class="stm">BKG</td>
				<td width="120"><input type="text" style="width:80;text-align:right" class="input" name="bkg" value="" readonly></td>
				<td width="30" class="stm">TEU</td>
				<td width="120"><input type="text" style="width:80;text-align:right" class="input" name="teu" value="" readonly></td>
				<td width="30" class="stm">FEU</td>
				<td width=""><input type="text" style="width:80;text-align:right" class="input" name="feu" value="" readonly></td>
			</tr></table>
			</td>
			<td>
			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_rowadd">Row&nbsp;Add</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>

					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_delete">Row&nbsp;Delete</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
			</td></tr>
		</table>
		</td></tr>
		</table>
		<!--biz page (E)-->

	

	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_edi">EDI</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_loadingConfirm">Loading Confirm</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downExcel">Down Excel</td>
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
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
			
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       		<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    	<tr>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td>
										<td class="btn1" name="btn_Close" onClick="self.close()">Close</td>
										<td class="btn1_right"></td>
									</tr>
								</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>	
</body>
</html>