<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1014.jsp
*@FileTitle : ESM_BKG_1014
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.07.10 김승민
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.event.EsmBkg0930Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0930Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String inCllType ="";
	Logger log = Logger.getLogger("com.hanjin.apps.TerminalDocumentation.CLLCDLManifest");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   	inCllType = request.getParameter("inCllType")==null?"":request.getParameter("inCllType");
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0930Event)request.getAttribute("Event");
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
<title>ESM_BKG_1014</title>
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
<input type="hidden" name="inCllType" value="<%=inCllType%>">
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"> (Korea)Container Loading List(CLL)</span></td></tr>
		</table>	
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
			<table class="search"> 
       		<tr><td class="bg">
				<table class="search" border="0" style="width:284;"> 
				<tr class="h23">
					<td width="50">Rows </td>
					<td width="150"><input type="text" style="width:90;" dataformat="num" name="start_index" class="input1" value="" style="ime-mode:disabled"></td>
					<td width="40">~</td>
					<td width=""><input type="text" style="width:90;" dataformat="num" name="end_index"  class="input1" value="" style="ime-mode:disabled"></td>
				</tr>
				<tr class="h23">
					<td width="">TS  </td>
					<td width="">
					<select name="ts" style="width:90">
					<option value=""></option>
					<option value="TT">TT</option>
					<option value="TS">TS</option>
					</select>
					<!--input type="text" style="width:90;" id="ts" name="ts" dataformat="engup" maxlength="2" class="input" value=""--></td>
					<td width="">POD  </td>
					<td width=""><input type="text" style="width:90;" name="pod" dataformat="engup" maxlength="5" class="input" value="" style="ime-mode:disabled"></td>
				
				</tr>
				<tr class="h23">
					<td width="">MLB  </td>
					<td width=""><input type="text" style="width:90;" name="mlb" dataformat="uppernum" maxlength="3" class="input" value="" style="ime-mode:disabled"></td>
					<td width="">YD  </td>
					<td width=""><input type="text" style="width:90;" name="yd" dataformat="uppernum" maxlength="2" class="input" value="" style="ime-mode:disabled"></td>
				
				</tr>
				</table>
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
		    <tr><td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Ok">OK</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<td class="btn1_line"></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
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
