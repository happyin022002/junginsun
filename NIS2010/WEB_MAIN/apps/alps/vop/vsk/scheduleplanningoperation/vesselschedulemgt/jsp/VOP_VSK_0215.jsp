<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_vsk_0215.jsp
*@FileTitle : Add Call Information (Pop-Up)
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.14
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.06.05 유혁
* 1.0 Creation
* 
* History
* 2011.03.14 진마리아 CHM-201109291-01 Location Code(숫자포함)의 Validation 체크로직 수정
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0215Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk0215Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.scheduleplanningoperation.vesselschedulemgt");
	
	String hiddenTurn = "";
	String hiddenEta = "";
	String showYard = "";
	String portCd = "";
	String srcYdCd = "";
	
	String posFlg = "";		//position(Before, After) Disabled Flag

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopVsk0215Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		hiddenTurn = JSPUtil.replaceForHTML(request.getParameter("hiddenTurn"));
		hiddenEta = JSPUtil.replaceForHTML(request.getParameter("hiddenEta"));
		showYard = JSPUtil.replaceForHTML(request.getParameter("showYard"));
		
		// Long Range SKD Creation에서 이미 Add된 Port에 다시 Add Calling을 한 경우 portCd, srcYdCd는 그 값이 존재한다.
		portCd = JSPUtil.replaceForHTML(request.getParameter("portCd"));
		portCd = portCd==null?"":portCd.trim();
		srcYdCd = JSPUtil.replaceForHTML(request.getParameter("ydCd"));
		
		// srcYdCd가 7자리이면 마지막 2자리를 사용하고, 2자리이면 그냥 사용한다.
		srcYdCd = srcYdCd==null?"":srcYdCd.trim().length()==7?srcYdCd.substring(5, 7):srcYdCd.length()==2?srcYdCd:"";
		
		posFlg = JSPUtil.replaceForHTML(request.getParameter("pos_flg"));
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Add Call Information (Pop-Up)</title>
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
<input type="hidden" name="pos_flg" value="<%=posFlg %>">
<%
	if("Y".equals(hiddenEta)){
%>
<!-- 
<input type="hidden" name="eta_day">
<input type="hidden" name="eta_time">
 -->
<%} %>
<input type="hidden" name="showYard" value="<%=showYard%>">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Add Call Information  </td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 			
			<table class="search"> 
       		<tr><td class="bg" height="220" valign="top">
				<!--  biz_1  (S) -->
				
				
				<!--  biz_1   (E) -->
				<table width="100%" class="search"> 
				<tr class="h23">
					<td width="100" style="text-align:center">Port</td>
					<td>
					<%
						if("".equals(portCd)){
					%>
					&nbsp;<input type='text' name="port_cd" dataformat="uppernum" maxlength="5" style="width:50;ime-mode:disabled;text-align:center" class="input1" tabindex="1">&nbsp;<img class="cursor" src="img/btns_search.gif" name="btn_search1" width="19" height="20" border="0" align="absmiddle">
						<%if("Y".equals(showYard)){ %>
						&nbsp;<script language="javascript">ComComboObject('yd_cd',2,45,1,0);</script><input type="hidden" name="yard_cd" value="<%=srcYdCd%>">
						<%}else{%>
							<input type="hidden" name="yard_cd" value="">
						<%} %>
					<%}else{ %>
					&nbsp;<input type='text' name="port_cd" value="<%=portCd%>" style="width:50;ime-mode:disabled;text-align:center" class="noinput" tabindex="1" readonly>
						<%if("Y".equals(showYard)){ %>
							<%if("".equals(srcYdCd)){%>
							&nbsp;<script language="javascript">ComComboObject('yd_cd',2,45,1,0);</script><input type="hidden" name="yard_cd" value="<%=srcYdCd%>">
							<%}else{ %>
							&nbsp;<input type="text" value="<%=srcYdCd%>" style="width:30;ime-mode:disabled;text-align:center" class="noinput" tabindex="2" readonly><input type="hidden" name="yard_cd" value="<%=portCd + srcYdCd%>">
							<%} %>
						<%}else{ %>
							<input type="hidden" name="yard_cd" value="">
						<%} %>
					<%}%>
				</td></tr>
				<%
					if(!"Y".equals(hiddenEta)){
				%>
				<tr class="h23">
					<td width="100" style="text-align:center">ETA</td>
					<td>&nbsp;<input type="text" name="eta_day" style="width:80;text-align:center;" maxlength="8" dataformat="ymd" class="input" tabindex="3">
					<img class="cursor" name="eta_btn_cal" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">&nbsp
					<input type="text" name="eta_time" maxlength="4" dataformat="hm" style="width:40;text-align:center;" class="input1" value="00:00" tabindex="4">
					&nbsp;<input type="text" style="width:80" class="noinput2" value="(YYYYMMDD)"  tabindex="-1" readonly>
					</td></tr>
				<%} %>
				<tr class="h23">
					<td width="100" style="text-align:center">ETB</td>
					<td>&nbsp;<input type="text" name="etb_day" style="width:80;text-align:center;" maxlength="8" dataformat="ymd" class="input" tabindex="5">
					<img class="cursor" name="etb_btn_cal" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">&nbsp
					<input type="text" name="etb_time" maxlength="4" dataformat="hm" style="width:40;text-align:center;" class="input1" value="00:00" tabindex="6">
					&nbsp;<input type="text" style="width:80" class="noinput2" value="(YYYYMMDD)"  tabindex="-1" readonly>
					</td></tr>
				<tr class="h23">
					<td width="100" style="text-align:center">ETD</td>
					<td>&nbsp;<input type="text" name="etd_day" style="width:80;text-align:center;" maxlength="8" dataformat="ymd" class="input" tabindex="7">
					<img class="cursor" name="etd_btn_cal" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">&nbsp
					<input type="text" name="etd_time" maxlength="4" dataformat="hm" style="width:40;text-align:center;" class="input1" value="00:00" tabindex="8">
					&nbsp;<input type="text" style="width:80" class="noinput2" value="(YYYYMMDD)"  tabindex="-1" readonly>
					</td></tr>
				<%
					if("Y".equals(hiddenTurn)){
				%>
				<tr class="h23"><td colspan="2"></td></tr>
				<%}else{ %>
				<tr class="h23">
					<td width="100" style="text-align:center">Turn</td>
					<td>&nbsp;<select name="turn_ind" style="width:100;" class="input" tabindex="9">
						<option value="0" >Y</option>
						<option value="1" selected>N</option>
						</select></td></tr>
				<%}%>
				<%
					if("".equals(portCd)){
				%>
					<tr class="h23">
					<td width="100" style="text-align:center">Position</td>
					<td>&nbsp;<input type="radio" name="position" value="before" class="trans">Before&nbsp;<input type="radio" name="position" class="trans" value="after" checked>After
					</td>
					</tr>
				<%}else{ %>
					<tr class="h23">
					<td width="100" style="text-align:center"></td>
					<td>&nbsp;</td>
					</tr>
				<%} %>
				</table> 

			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->

<table class="height_5"><tr><td height="5"></td></tr></table>
</td></tr>
</table> 
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_ok">OK</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<td class="btn1_line"></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right"></td>
				</tr></table></td>
			</tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

<!-- 거래 처리용 시트 -->
<!-- Grid  (S) -->
<table width="100%" id="mainTable"> 
	<tr>
		<td width="100%">
			<script language="javascript">ComSheetObject('sheet1');</script>
		</td>
	</tr>
</table>
<!-- Grid (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
<%@include file="/bizcommon/include/common_alps.jsp" %>