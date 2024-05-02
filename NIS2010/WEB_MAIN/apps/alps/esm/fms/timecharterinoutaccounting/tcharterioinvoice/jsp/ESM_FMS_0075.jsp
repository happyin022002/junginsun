<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_fms_0075.jsp
*@FileTitle : E-mail / Print - window
*@LastModifyDate : 2009.05.21
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.05.21 최우석
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
<%@ page import="com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event.EsmFms0075Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmFms0075Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	//int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	//String successFlag = "";
	//String codeList  = "";
	//String pageRows  = "100";
	
	String strUsr_id	= "";
	String strUsr_nm	= "";
	
	String pgm_id		= request.getParameter("pgm_id")==null?"":request.getParameter("pgm_id");
	String vsl_nm		= request.getParameter("vsl_eng_nm")==null?"":request.getParameter("vsl_eng_nm");

	String csr_no		= request.getParameter("csr_no")==null?"":request.getParameter("csr_no");
	String subject		= "";
	
	if(pgm_id.equalsIgnoreCase("esm_fms_0012")) {
		if(vsl_nm != null) {
			subject = "Hire invoice(" + vsl_nm + ")";
		}
		else {
			subject = "Hire invoice";
		}
		//subject = "Hire invoice";
	} else {	// 0021, 0041
		if(vsl_nm == null) {
			subject = "Hire Statement";
		} else {
			subject = "Hire Statement(" + vsl_nm + ")";
		}
		//subject = "Hire Statement";
	}

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	
		event = (EsmFms0075Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
	
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
	//	GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>E-mail / Print - window</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
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
<!-- 개발자 작업	-->

<input type="hidden" name="usr_id"	value="<%=strUsr_id%>" >
<input type="hidden" name="pgm_id" value="<%=pgm_id%>">
<input type="hidden" name="subject" value="<%=subject%>">
<input type="hidden" name="file_path" value="">
<input type="hidden" name="csr_no" value="<%=csr_no%>">

<input type="hidden" name="vsl_nm" value="<%=vsl_nm%>">
<!-- Report Designer 에 필요한 Input Box -->
<input type="hidden"   name="com_mrdPath" value="">
<input type="hidden"   name="com_mrdArguments" value="">
<input type="hidden"   name="com_mrdTitle" value="Hire Statement">
<input type="hidden"   name="com_mrdBodyTitle" value="Hire Statement">

<!-- OUTER - POPUP (S)tart -->
<table width="500" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;E-Mail / Print Selection
</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
			<table class="search"> 
       		<tr><td class="bg">
				<table class="search" border="0">
					<tr><td class="title_s" style="text-align:center">Select Your Format Type to retrieve the Hire Invoice / Statement</td></tr>
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
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_email">E-mail Type</td>
					<td class="btn1_right"></td>
				</tr></table></td>		
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_preview">Preview</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>	
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_print">Print</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_tofile">Print to File</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right"></td>
				</tr>
				</table></td>
			</tr>
			</table>
    <!--Button (E) -->
	
		</td></tr>
	</table>
</td></tr></table>
<!-- : ( Button : pop ) (E) -->

<!------- FileUpload Object Start -------->
<table width="100%"> 
	<tr>
		<td width="100%">
			<script language="javascript">ComUploadObject('upload1', '<=session.getId()%>');</script>
		</td>
	</tr>
</table>
<!------- FileUpload Object End -------->

<!------- Print용 Hidden RD Object Start -------->
<table width="100%"  id="rdTable"> 
	<tr>
		<td width="100%">
			<script language="javascript">comRdObject('Rd');</script>
		</td>
	</tr>
</table>
<!------- Print용 Hidden RD Object End -------->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>