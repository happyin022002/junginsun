<%--
/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESD_TRS_0044.jsp
*@FileTitle : W/O 발행화면 - Appt.Deli. Excel Import 팝업 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2011-02-10
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2011-01-27 민정호
* 1.0 최초 생성
* 1.1 2011.02.10 민정호 [CHM-201108602] [TRS]미주지역 Appt./Deli. time update 기능 추가
=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.event.EsdTrs0024Event"%>
<%@ page import="java.util.StringTokenizer"%>
<%@ page import="java.util.ArrayList"%>
<%!
	private ArrayList splitStr(String src, String delim)
	{
		if(src == null || src.equals("")) return null;
		ArrayList returnV = new ArrayList();

		StringTokenizer st = new StringTokenizer(src, delim);
		String tempNo = null;

		while (st.hasMoreTokens()) {
			tempNo = st.nextToken();
			returnV.add(tempNo);
		}

		if (returnV.size() == 0) returnV.add(src);
		return returnV;
	}
%>
<%
	EsdTrs0024Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";								 //에러메세지
	int rowCount	 = 0;								  //DB ResultSet 리스트의 건수

	try {

		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		event = (EsdTrs0024Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>ApptDeliExcelImportPopup</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
    function setupPage(ck){
        var errMessage = "";
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

<!-- OUTER - POPUP (S)tart -->
<body class="popup_bg" onload="javascript:setupPage();">
<form name="form" onkeyup="ComKeyEnter('lengthnextfocus');">
<input type="hidden" name="f_cmd"> 

<table width="100%" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Appt./Deli. Excel Import</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options : Scenario ID ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">
				<!-- : ( Scenario ID ) (S) -->
				<!-- : ( Scenario ID ) (E) -->			
		<!-- TABLE '#D' : ( Search Options : Scenario ID ) (E) -->				
			<!-- : ( Grid ) (S) -->
			<table width="100%" id="mainTable" border="0">
			<tr>
				<td><script language="javascript">ComSheetObject('sheet');</script>
				</td>
			</tr>
		</table>					
<!-- : ( Grid ) (E) -->
<!--  Button_Sub (S) -->
<!-- Button_Sub (E) -->
				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
<table class="height_5"><tr><td></td></tr></table>
<!-- OUTER - POPUP (E)nd -->
</td></tr>
</table>
<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_FileImport" id="btn_FileImport">File Import</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_Verify">Verify</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_Apply">Apply</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					
					<td class="btn1_line"></td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_Close">Close</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					
				</tr>
				</table>
			</td>
			</tr>
		</table>
	</td></tr>
</table>
<!-- : ( Button : Sub ) (E) -->
</form>
</body>
</html>
<!-- body 끝 -->