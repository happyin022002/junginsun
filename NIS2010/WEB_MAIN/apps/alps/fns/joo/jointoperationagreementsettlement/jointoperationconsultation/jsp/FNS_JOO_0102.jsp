<%
/*=========================================================
 *Copyright(c) 2011 CyberLogitec
 *@FileName : fns_joo_0102.jsp
 *@FileTitle : 기 정산된 데이타가 존재하는 경우 Double Click시 History 조회 POP UP화면
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.02.09
 *@LastModifier : 이영두
 *@LastVersion : 1.0
 * 2015.02.09 이영두
 * 1.0 Creation
 =========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.event.FnsJoo0102Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	FnsJoo0102Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";

	String acct_yrmon = "";
	String jo_crr_cd = "";
	String r_vvd = "";
	String e_vvd = "";
	String rlane_cd = "";
	String jo_stl_itm_cd = "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.JointOperationAgreementSettlement.JointOperationConsultation");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (FnsJoo0102Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		acct_yrmon = StringUtil.xssFilter(request.getParameter("acct_yrmon"));
		jo_crr_cd = StringUtil.xssFilter(request.getParameter("jo_crr_cd"));
		r_vvd = StringUtil.xssFilter(request.getParameter("r_vvd"));
		e_vvd = StringUtil.xssFilter(request.getParameter("e_vvd"));
		rlane_cd = StringUtil.xssFilter(request.getParameter("rlane_cd"));
		jo_stl_itm_cd = StringUtil.xssFilter(request.getParameter("jo_stl_itm_cd"));
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>VVD ITEM DUP DEDAIL</title>
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

<body class="popup_bg"  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="acct_yrmon" value="<%=acct_yrmon%>">
<input type="hidden" name="jo_crr_cd" value="<%=jo_crr_cd%>">
<input type="hidden" name="r_vvd" value="<%=r_vvd%>">
<input type="hidden" name="e_vvd" value="<%=e_vvd%>">
<input type="hidden" name="rlane_cd" value="<%=rlane_cd%>">
<input type="hidden" name="jo_stl_itm_cd" value="<%=jo_stl_itm_cd%>">

<!-- OUTER - POPUP (S)tart -->

<table width="100%" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;VVD ITEM DUP DEDAIL</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
	
	
		<!--biz page (S)-->
		<table class="search" id="mainTable">
       		<tr><td class="bg">


			<!-- Grid  (S) -->
				<table width="100%" class="search"  id="mainTable">
					<tr>
						<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
			<!-- Grid (E) -->
			</td></tr>
		</table>
		<!--biz page (E)-->
<table class="height_5"><tr><td colspan="8"></td></tr></table>

</td></tr></table>
	
		


<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

    	<!--Button (S) -->	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       		<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
		    	<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Downexcel">Down&nbsp;Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
		    	<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
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

</form>
</body>
</html>