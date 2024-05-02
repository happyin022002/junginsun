<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_6002.jsp
*@FileTitle : Remark by VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.14
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2009.08.14 박광석
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%> 
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.eqr.cntrcodconfirm.emptycodadjustment.event.EesEqr1054Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesEqr1054Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	String xml = "";
//	Logger log = Logger.getLogger("com.hanjin.apps.cntrcodconfirm.emptycodadjustment");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesEqr1054Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		xml = HttpUtil.makeXML(request,response);

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html> 
<head>
<title>Remark by VVD</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">

	function setupPage(){
		
		document.form.vessel_remark.value = ComGetEtcData(document.form.xml.value, "vesselremark");
		
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
	//	loadPage();
	}
</script>
</head>

<body class="popup_bg"  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows" >
<input type="hidden" name="div"  value="S">
<input type="hidden" name="xml"  value="<%=xml%>">
<input type="hidden" name="row" value="<%=JSPUtil.getParameter(request, "row")%>">
<input type="hidden" name="weekdivision" value="<%=JSPUtil.getParameter(request, "weekdivision")%>">
<input type="hidden" name="vvd" value="<%=event.getEmptyCODVVDVO().getVvd()%>">
<!-- 개발자 작업	-->

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Remark by VVD
</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
		<table class="search"> 
       		<tr><td class="bg">
       		
       		<table class="search" border="0" style="width:100%;"> 
		<tr class="h23">
       		<td width="100%"><input type="text" style="width:200" value="WK:<%=event.getEmptyCODVVDVO().getWeek()%>,   <%=event.getEmptyCODVVDVO().getLane()%>/ <%=event.getEmptyCODVVDVO().getVvd()%>" class="input2"></td>
       		</tr>
		</table> 
       		
        	<table border="0" style="width:100%; background-color:white;" class="grid2"> 
				<tr class="tr2_head">
				<td>Vessel Schedule Remark</td></tr>
				<td><textarea style="width:100%" rows="5" class="textarea" name="vessel_remark"  disabled></textarea></td>
				</tr>
			</table> 
       		<table border="0" style="width:100%; background-color:white;" class="grid2"> 
				<tr class="tr2_head">
				<td>Note</td></tr>
				<td><textarea style="width:100%" rows="7" class="textarea" name="remark"><%=event.getEmptyCODVVDVO().getRemark()%></textarea></td>
				</tr>
			</table> 
       		
       		
       		
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
		    <tr><td width="72"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
			</tr>
			</table>
		</td>
			<td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td width="72"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_delete">Delete</td>
					<td class="btn1_right"></td>
			</tr>
			</table>		
		</td><td class="btn1_line"></td>
				<td width="72"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right"></td>
			</tr>
			</table>
		</td></tr>
		</table>
		</td></tr>
		</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>