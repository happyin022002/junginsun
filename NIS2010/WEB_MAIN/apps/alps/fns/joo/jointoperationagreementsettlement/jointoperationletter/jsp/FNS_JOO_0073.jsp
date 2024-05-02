<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_joo_0073.jsp
*@FileTitle : MCS & Invoice Mail Address Select POP-UP
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2009.06.11 함대성
* 1.0 Creation
=========================================================*/%>
 
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.event.FnsJoo0073Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsJoo0073Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	String joCrrCd = StringUtil.xssFilter(request.getParameter("joCrrCd"));	//상위화면(0062화면)이 차후 개발시 joCrrCd를 넘겨주고 아래 하드코딩부분 제거 
	if(joCrrCd == null){
		joCrrCd = "";   //joCrrCd = "COS"; 
	}
	
	Logger log = Logger.getLogger("com.hanjin.apps.JointOperationAgreementSettlement.JointOperationLetter");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (FnsJoo0073Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
	strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
	
	// Popup 모드 (1: function 호출형, 2: target 세팅형)
	String pop_mode2 = request.getParameter("pop_mode");	
	if(pop_mode2 == null || pop_mode2.equals(""))
		pop_mode2 = "1";

	// 호출할 부모창의 스크립트 메소드 (pop_mode가 1(function 호출형) 인 경우)
	String func2  = request.getParameter("func");

	// 값을 세팅할 부모창의 Object목록 (pop_mode가 2(target 세팅형) 인 경우)
	String targetObjList2 = request.getParameter("targetObjList");
	
	// Multi Sheet인 경우, 데이터를 가져올 Sheet 정보
	String sheet2 = request.getParameter("sheet");	
	
	// Multi Sheet인 경우, Sheet의 Index 정보
	String sheetIdx2 = request.getParameter("sheetIdx");
	
	// Sheet에서 팝업 호출시, Target이 되는 Cell의 row/col 정보
	String row2 = request.getParameter("row");
	String col2 = request.getParameter("col");
%>
<html>
<head>
<title>MCS & Invoice Mail Address Select POP-UP</title>
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
<input type="hidden" name="joCrrCd" value="<%=joCrrCd%>">
<!-- 개발자 작업	-->

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;MCS & Invoice Mail Address Select</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
			<table class="search"> 
       		<tr><td class="bg">
			
			
				<!-- : ( Grid ) (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- : ( Grid ) (E) -->	
		
			
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
				<td><table width=72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_OK">OK</td>
					<td class="btn1_right">
				</tr></table></td>
				<td class="btn1_line">
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
					<td class="btn1_right">
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