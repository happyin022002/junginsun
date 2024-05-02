<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0071.jsp
*@FileTitle : SKD Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.29
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2009.09.29 최윤성
* 1.0 Creation
* 2016.05.12 이혜민 CHM-201640880 T/S History 개발 요청
* 2016.07.14 이혜민 CHM-201642304 T/S Plan & Guide 기능 Logic 수정 
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.event.EsmSpc0071Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSpc0071Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String orgUiId			= "";
	String targetColume		= "";
	String polCd		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.SpaceAllocationManage.SpaceAllocationManage");

	try {
		orgUiId 		= JSPUtil.getNull(request.getParameter("ui_id"));
		targetColume	= JSPUtil.getNull(request.getParameter("targetColume"));
		polCd			= JSPUtil.getNull(request.getParameter("pol_cd"));

	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmSpc0071Event)request.getAttribute("Event");
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
<title>SKD Inquiry</title>
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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="org_ui_id" value="<%=orgUiId%>">
<input type="hidden" name="targetColume" value="<%=targetColume%>"> <!-- 대상 팝업 컬럼 명  -->
<input type="hidden" name="pol_cd" value="<%=polCd%>">

<!-- 개발자 작업	-->
<table width="690" class="popup" cellpadding="10">
<tr><td valign="top">


		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;VVD SKD Inquiry</td></tr>
		</table>
		<!-- : ( Title ) (E) -->

		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
				<tr><td class="btn1_bg">

						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->

							<td><div id="retrieve_div" style="display:inline"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></div></td>
							<td><div id="new_div" style="display:inline"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_new">New</td><td class="btn1_right"></td></tr></table></div></td>
							
							<!-- Repeat Pattern -->

						</tr></table>

				</td></tr>
		</table>

		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
		<table class="search"  width="100%"  border="0">
			<tr>
				<td class="bg">
					<!-- : ( Scenario ID ) (S) -->
					<table class="search" border="0" style="width:590;"> 
					<tr class="h23">
						<td width="5%">VVD</td>
						<td><input type="text" name="vvd" style="width:100" onKeyUp="javascript:upper(this);"></td>
						
						</tr>
					</table>
					<!-- : ( Scenario ID ) (E) -->
					
					<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
					
					<!-- : ( Grid ) (S) -->
					<!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' ,
				 		'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->
					<table width="700" id="mainTable" border="0">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet1');</script>
                        </td></tr>
		            </table>
					<!-- : ( Grid ) (E) -->
				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->

</td></tr>
</table>
<!-- OUTER - POPUP (E)nd -->

<table class="height_10"><tr><td></td></tr></table>


<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton">
	<tr><td height="71" class="popup">
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
				<tr><td class="btn3_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<!-- Repeat Pattern -->
								<td><div id="apply_div" style="display:inline"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_apply" id="btn_apply">Apply</td><td class="btn1_right"></td></tr></table></div></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr>
								</table></td>
								<!-- Repeat Pattern -->
							</tr>
						</table>
				</td></tr>
			</table>
	</td></tr>
</table>
<!-- : ( Button : Sub ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
<script>
	<%if(event != null){%>
	var formObj = document.form;
	formObj.vvd.value = "<%=event.getConditionVO().getVvd()%>";
	<%}%>
</script>