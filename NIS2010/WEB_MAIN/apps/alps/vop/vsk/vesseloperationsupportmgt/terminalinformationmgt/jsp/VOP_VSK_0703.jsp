<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_vsk_0203.jsp
*@FileTitle : Berth window input 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.01
*@LastModifier : 장석현
*@LastVersion : 1.0
* 2009.06.01 장석현
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
<%@ page import="com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.event.VopVsk0703Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk0703Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String enableForm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.VesselOperationSupportMgt.TerminalInformationMgt");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
		event = (VopVsk0703Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		enableForm = JSPUtil.replaceForHTML(request.getParameter("enableForm"));

		if(enableForm == null)
			enableForm = "";
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Berth window input </title>
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
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="enableForm" value="<%=enableForm%>">

<!-- 개발자 작업	-->



<!-- OUTER - POPUP (S)tart -->
<table width="500" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Berth window input </td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
			<table class="search"> 
       			<tr><td class="bg">
				
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Berth Window Input Information</td></tr>
				</table>
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="50">Port</td> 
					<td width="180"><input type="text" style="width:99;text-align:center;" class="input2" value="" name="loc_cd" readonly></td>
					<td width="80">TMNL Code</td> 
					<td width=""><input type="text" style="width:100;text-align:center;" class="input2" value="" name="yd_cd" readonly></td>
				</tr>
				<tr class="h23">
					<td width="">Bound</td> 
					<td width=""><input type="text" style="width:99;text-align:center;" class="input2" value=""  name="skd_dir_cd" readonly></td>
					<td width="">Carrier Code</td> 
					<td width=""><input type="text" style="width:100;text-align:center;" class="input2" value="" name="crr_cd" readonly></td>
				</tr>
				<tr class="h23">
					<td width="">ETB</td> 
					<td colspan="3" style="padding-left:2">
					<script language="javascript">ComComboObject('etb_dy_cd');</script>
					&nbsp;<input type="text" style="width:60;text-align:center;" class="input" value="" name="etb_tm_hrmnt" dataformat="int" required caption="etb_hour" maxlength="2"></td>
				</tr>
				<tr class="h23">
					<td width="">ETD</td> 
					<td colspan="3" style="padding-left:2"><script language="javascript">ComComboObject('etd_dy_cd');</script>&nbsp;<input type="text" style="width:60;text-align:center;" class="input" value="" name="etd_tm_hrmnt" required dataformat="int" caption="etb_hour" maxlength="2"></td>
				</tr>
				</table>
		<!-- : ( Search Options ) (E) -->
			</td></tr>
		</table> 
	</td></tr>
</table> 
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       		<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
<%
	if(enableForm.equals("Y")){
%>
			<td width="72"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_ok">OK</td>
					<td class="btn1_right"></td>
			</tr></table></td>
			<td class="btn1_line"></td>	
<%
	}
%>
			<td width="72"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right"></td>
			</tr></table></td>
			</tr>
		</table></td></tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
			
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>