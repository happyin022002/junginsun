<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0706.jsp
*@FileTitle : Mark And Description for C/M
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.16
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.06.16 김영출
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event.EsmBkg0706Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg0706Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.OutboundBLMgt.BLDocumentationBL");

	String mkDesc = "";
	String gdsDesc = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0706Event)request.getAttribute("Event");
		mkDesc = event.getMkDesc();
		gdsDesc = event.getGdsDesc();
		
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
<title>Mark And Description for C/M</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">



<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		//
		callback_func = '<%=JSPUtil.getParameter(request, "func", "")%>';
		//
		//if(!opener) opener = window.dialogArguments;
		//document.form.cntr_mf_mk_desc.value = opener.sheetObjects[1].CellValue(opener.sheetObjects[1].SelectRow, "cntr_mf_mk_desc");
		//document.form.cntr_mf_gds_desc.value = opener.sheetObjects[1].CellValue(opener.sheetObjects[1].SelectRow, "cntr_mf_gds_desc");
		//alert(opener.sheetObjects[1].CellValue(opener.sheetObjects[1].SelectRow, "cntr_mf_mk_desc"));
	}
</script>
</head>

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->


<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">

	<!-- : ( Title ) (S) -->
	<table width="100%" border="0">
	<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Mark & Description for C/M</td></tr>
	</table>
	<!-- : ( Title ) (E) -->
	
	<!-- : ( Search Options ) (S) -->
	<!--biz page (S)-->
	
	<!--  biz page    (E) -->
	<table class="height_8"><tr><td></td></tr></table>	
		
		<table width="100%" class="search"> 
		<tr><td class="bg">
		
			
			<table width="100%" class="grid2" border="0">
			<tr class="h23">
				<td class="tr2_head">Description for Customs</td>
			</tr>
			<tr class="h23">
				<td width=""><textarea name="cntr_mf_gds_desc" style="ime-mode:disabled;width:100%;height:50px;"><%=gdsDesc%></textarea></td>
			</tr>
			</table>
			
			<table class="height_2"><tr><td></td></tr></table>
			<table class="grid2" border="0" width="100%">
			<tr class="h23">
				<td class="tr2_head">Marks & Numbers</td>
			</tr>
			<tr class="h23">
				<td width=""><textarea name="cntr_mf_mk_desc" style="ime-mode:disabled;width:100%;height:160px;"><%=mkDesc%></textarea></td>
			</tr>
			</table>

		</td></tr>
	</table>
<!-- : ( Search Options ) (E) -->
		</td></tr>
	</table>
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

    	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;">
       	<tr><td class="btn3_bg">
       	
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
			<tr><td class="btn1_left"></td>
			<td class="btn1" name="btn_OK">OK</td>
			<td class="btn1_right"></td>	
		</tr></table></td>
		<td class="btn1_line"></td>
		<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
			<tr><td class="btn1_left"></td>
			<td class="btn1" name="btn_Close">Close</td>
			<td class="btn1_right"></td>	
		</tr></table></td>		
	</tr></table>
</td></tr>
</table></td>		
	</tr></table>
<!--Button (E) -->
</td>		
	</tr></table>

<table class="height_5"><tr><td></td></tr></table>
</td></tr>
</table> 
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>