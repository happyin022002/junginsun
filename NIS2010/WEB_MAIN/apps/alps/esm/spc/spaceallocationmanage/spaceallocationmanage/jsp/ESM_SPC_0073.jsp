<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESM_SPC_0073.jsp
*@FileTitle :  Customer/Commodity Info
*Open Issues : ESM_BKG_0190 copy하여 생성 
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 신자영
* 2014.12.09 신자영
* 1.0 Creation
* 2014.12.08 [CHM-201433097] Control Option - A/C 및 CDMT추가 건 상세
* 2015.05.27 SPC-BKG 연동 - ESM_SPC_0115에서 호출시 로직 추가
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.event.EsmSpc0073Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmSpc0073Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	boolean bBtn_Disabled = true;

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmSpc0073Event) request.getAttribute("Event");
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
  String svc_scp_cd = JSPUtil.getNull(request.getParameter("svc_scp_cd")); 
  String app_dt     = JSPUtil.getNull(request.getParameter("app_dt")); 
  String sc_no      = JSPUtil.getNull(request.getParameter("sc_no")); 
  String rfa_no     = JSPUtil.getNull(request.getParameter("rfa_no")); 
  String bkg_no     = JSPUtil.getNull(request.getParameter("bkg_no")); 
  String type       = JSPUtil.getNull(request.getParameter("type")); 
  //Arie ESM_SPC_0115에서 사용하기 위해 추가
  String pgmNo = JSPUtil.getNull(request.getParameter("pgmNo"));
  String actAcctCmdt = JSPUtil.getNull(request.getParameter("actAcctCmdt")); 
%>
<html>
<head>
<title>Customer/Commodity Info</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        // InitTab();
        loadPage();
    }
</script>
</head>
<!-- 
showErrMessage를 써주지 않으면 에러 발생시 처리가 불가합니다.
그리고 지금은 showErrMessage()으로 되어있지만 추후에 고객님이 변덕을 일으켜서 웹페이지를 호출하라고 할경우를 
대비해서 직접 showErrMessage() 하지 마시고 꼭 showErrMessage를 써주십시오. 한방에 바꾸게요. 표준을 안따르면 나중에 후회합니다.  
-->

<body class="popup_bg" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="svc_scp_cd" value="<%=svc_scp_cd%>">
<input type="hidden" name="type" value="<%=type%>">
<input type="hidden" name="pgmNo" value="<%=pgmNo%>">
<input type="hidden" name="actAcctCmdt" value="<%=actAcctCmdt%>">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="./img/icon_title_dot.gif" align="absmiddle">&nbsp;Customer/Commodity Information</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
			<table class="search"> 
       		<tr><td class="bg">
			
				<table class="search" border="0" style="width:100%;"> 
					<tr class="h23">
						<td width="50">RFA No.</td>
						<td width="110">
								<input type="input" name="rfa_no"  style="width:100;" value="<%=rfa_no%>" maxlength="11" class="input1" onkeypress="eventKeyChangeChar(UPPER_CASE);"><!-- AAR09P0002 --><!-- 2009-01-01 -->
						</td>
						<td width="50">S/C No.</td>
						<td width="110">
								<input type="input" name="sc_no"  style="width:100;" value="<%=sc_no%>" maxlength="9" class="input1" onkeypress="eventKeyChangeChar(UPPER_CASE);"><!-- HAM090003 --> 
						</td>
						<td width="100">Applicable Date</td>
						<td width="170">
						<input type="text" style="width:80;" class="input" value="<%=app_dt%>" name="app_dt" maxlength='8' dataformat='ymd' style="ime-mode:disabled">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_app_dt"></td> 
					    </td>
						<!--
						<td width="50">BKG No.</td>
						<td width="110">
						    <input type="input" name="bkg_no" style="width:100;" value="<%=bkg_no%>" readonly class="input2">
						</td>
						<td width="50">Duration</td>
						<td width=""><input type="text" style="width:80;" class="input2" value="" disabled name="from_dt">&nbsp;~&nbsp;
						             <input type="text" style="width:80;" class="input2" value="" disabled name="to_dt">
	          			</td>
	          			-->
					</tr>
					</table>
					
				<table class="search" border="0" style="width:100%;">
				<tr><td height='5'></td></tr>
				<tr class="h23">					
					<td width="50">Name</td>
					<td width="110"><input type="text" style="width:100;" class="input" value="" name="cust_lgl_eng_nm" maxlength='20' style="ime-mode:disabled" onkeypress="eventKeyChangeChar(UPPER_CASE);"></td> 
				    <td width="50"></td>
					<td width="110"></td>
					<td width="100"></td>
					<td width="170"></td>
				</tr>
			</table>
				
				<!-- : ( Grid ) (S) -->
					<table width="100%"  id="mainTable">
						<tr>
							<td width="100%" style='padding-top:10px'>
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table>
				<!-- : ( Grid ) (E) -->	
		    <!-- : ( Button : Grid ) (E) -->	
			
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
<table class="height_5"><tr><td></td></tr></table>
</td></tr>
</table> 

	
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve" >Retrieve</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Select">Select</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
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
			

</form>
</body>
</html>
 <%@include file="/bizcommon/include/common_alps.jsp"%>
