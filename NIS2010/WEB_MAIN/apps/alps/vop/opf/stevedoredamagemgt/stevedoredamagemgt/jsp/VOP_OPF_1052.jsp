<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_opf_1052.jsp
*@FileTitle : Supporting Upload
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.25
*@LastModifier : 이선영
*@LastVersion : 1.0
* 2009.06.25 이선영
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
<%@ page import="com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.event.VopOpf1052Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>

<%
	VopOpf1052Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.StevedoreDamageMgt.StevedoreDamageMgt");
	
	String func = "";
	
	String pageId = "";
	String stvDmgProcCd = "";
	String stvDmgAtchFileTpCd = "";
	String vslCd = "";
	String stvDmgNo = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		
		func = StringUtil.xssFilter(request.getParameter("func"));
		
		pageId =  StringUtil.xssFilter(request.getParameter("pageId"));
		stvDmgNo = StringUtil.xssFilter(request.getParameter("stvDmgNo"));
		stvDmgProcCd = StringUtil.xssFilter(request.getParameter("stvDmgProcCd"));
		stvDmgAtchFileTpCd = StringUtil.xssFilter(request.getParameter("stvDmgAtchFileTpCd"));
		vslCd = StringUtil.xssFilter(request.getParameter("vslCd"));


		event = (VopOpf1052Event)request.getAttribute("Event");
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
<title>Supporting Upload</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage('<%=pageId%>','<%=stvDmgNo%>','<%=strUsr_id%>','<%=stvDmgProcCd%>','<%=stvDmgAtchFileTpCd%>','<%=vslCd%>');
	}
	
	/**
     * 파일 선택하기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     **/
	function returnPopupData(sheetObj){
		//opener = window.dialogArguments;
		opener.<%=func%>(sheetObj, '<%=stvDmgAtchFileTpCd%>', '<%=stvDmgProcCd%>');
	}
</script>
</head>

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="stvDmgAtchFileTpCd" value="<%=stvDmgAtchFileTpCd %>">
<input type="hidden" name="stvDmgProcCd" value="<%=stvDmgProcCd %>">
<!-- 개발자 작업	-->

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;  Supporting Upload</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!--biz page (S)-->
		<!-- 1 (S) -->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			
				<!-- Grid - 1 (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table> 
				<!-- Grid - 1 (E) -->	

				<!--  Button_Sub (S) -->
				<table width="100%" class="button"> 
		       	<tr><td class="btn2_bg">
					<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
						<input type="button" style="border-width:0px;background:spacer.gif" name="downbtn" onclick="doAction('down')">
						</td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_FileAdd">File Add</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
						<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_Delete">Delete</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
						
						</tr></table>
				</td></tr>
				</table>
		    	<!-- Button_Sub (E) -->
				
		</td></tr></table>		
		<table class="height_5"><tr><td></td></tr></table>	
		<!-- 1 (E) -->
		<!--biz page (E)--> 

</td></tr></table>

<!--table class="height_5"><tr><td></td></tr></table-->
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

    	<!--Button (S) -->	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
		    	<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Ok">Ok</td>
					<td class="btn1_right"></td>
					</tr></table></td>
				<td class="btn1_line"></td>
		    	<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
					<td class="btn1_right"></td>
					</tr></table></td>
			</tr>
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