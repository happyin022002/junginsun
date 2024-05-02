<%
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_COA_0112.jsp
*@FileTitle : VVD Status
*Open Issues :
*Change history : 2006.11.06 박은주 최초 생성
                : 2009.09.08 박수훈 New FrameWork 적용
*@LastModifyDate : 2009.09.08
*@LastModifier : 박수훈
*@LastVersion : 1.0
* =======================================================
* History : 
* 2010.12.15 김기종 Ticket ID:CHM-201006305-01 COA Architecture 위배사항 수정
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.event.EsmCoa0112Event"%>
<%@ page import="org.apache.log4j.Logger" %>


<%
	EsmCoa0112Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	//sheet1에서 사용하는 변수
	String f_cost_yr = JSPUtil.getNullNoTrim(request.getParameter("f_cost_yr"));
	String f_cost_fm_mon = JSPUtil.getNullNoTrim(request.getParameter("f_cost_fm_mon"));
	
	Logger log = Logger.getLogger("com.hanjin.apps.WeeklyPFMC.WeeklyCM");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmCoa0112Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}


	}catch(Exception e) {
		log.error("Exception : " + e.toString());
	}
%>
<html>
<head>
<title>VVD Status</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		setRetrieveAction();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="f_cost_yr"     value="<%=f_cost_yr%>">
<input type="hidden" name="f_cost_fm_mon" value="<%=f_cost_fm_mon%>">

<!-- OUTER - POPUP (S)tart -->
<table class="popup" cellpadding="10" border="0" style="width:800;">
	<tr><td class="top"></td></tr>
	<tr>
		<td valign="top">


			<!-- : ( Title ) (S) -->
			<table width="100%" border="0">
			<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp; VVD Status ( <%=f_cost_yr%>.<%=f_cost_fm_mon%> ) </td></tr>
			</table>
			<!-- : ( Title ) (E) -->


			<!-- : ( Search Options ) (S) -->
			<table class="search">
				<tr>
					<td class="bg">


						<!-- : ( Grid ) (S) -->
						<table width="100%" id="mainTable">
							<tr>
								<td>
								<script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table>
						<!-- : ( Grid ) (E) -->

						<table border="0">
						<tr><td class="sm"><img src="img/icon_history_dot.gif" align="absmiddle">&nbsp;&nbsp;<b>STATUS Reference</b><br></td></tr>
						<tr><td class="sm" style="padding:1,10;">AR Only : on the side of AR System only.<br></td></tr>
						<tr><td class="sm" style="padding:1,10;">BOTH : both AR and COA System.<br></td></tr>
						<tr><td class="sm" style="padding:1,10;">COA Only : on the side of COA System only.<br></td></tr>
						</table>


					</td>
				</tr>
			</table>
			<!-- : ( Search Options ) (E) -->
		</td>
	</tr>
</table>
<!-- OUTER - POPUP (E)nd -->


<table class="height_5"><tr><td></td></tr></table>


<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>

				<!-- Repeat Pattern -->
 <!-- 
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_Save" id="btn_Save">Save</td><td class="btn1_right"></td></tr></table></td>

				<td class="btn1_line"></td>
 -->
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_Close" id="btn_Close">Close</td><td class="btn1_right"></td></tr></table></td>
				<!-- Repeat Pattern -->

			</tr>
		</table>

	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

</form>
</body>
</html>