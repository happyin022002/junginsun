<%
	/*=========================================================
	 *Copyright(c) 2011 CyberLogitec
	 *@FileName : fns_joo_0090.jsp
	 *@FileTitle : Ratio POP UP화면
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2012.06.21
	 *@LastModifier : Kim, Sanggeun
	 *@LastVersion : 1.0
	 * 2012.06.21 Kim, Sanggeun
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
<%@ page import="com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event.FnsJoo0090Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	FnsJoo0090Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";

	String vvd = "";
	String slaneCd = "";
	String skdDirCd = "";
	String preFr = "";
	String preTo = "";
	String oprCd = "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.JointOperationAgreementSettlement.JointOperationConsultation");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (FnsJoo0090Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		vvd    	= request.getParameter("vvd")    == null ? ""  : StringUtil.xssFilter(request.getParameter("vvd"));
		slaneCd   = request.getParameter("slane_cd")    == null ? ""  : StringUtil.xssFilter(request.getParameter("slane_cd"));
		skdDirCd = request.getParameter("skd_dir_cd")    == null ? ""  : StringUtil.xssFilter(request.getParameter("skd_dir_cd"));
		preFr    	= request.getParameter("pre_fr")    == null ? ""  : StringUtil.xssFilter(request.getParameter("pre_fr"));
		preTo     = request.getParameter("pre_to")    == null ? ""  : StringUtil.xssFilter(request.getParameter("pre_to"));
		oprCd     = request.getParameter("opr_cd")    == null ? ""  : StringUtil.xssFilter(request.getParameter("opr_cd"));		

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
<title>Sub-Allocation and Ratio</title>
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
<input type="hidden" name="pagerows"><!-- OUTER - POPUP (S)tart -->
<input type="hidden" name="vvd" value="<%=vvd%>">
<input type="hidden" name="skd_dir_cd" value="<%=skdDirCd%>">
<input type="hidden" name="pre_fr" value="<%=preFr%>">
<input type="hidden" name="pre_to" value="<%=preTo%>">
<input type="hidden" name="opr_cd" value="<%=oprCd%>">
<table width="100%" class="popup" cellpadding="10" border="0">
	<tr>
		<td class="top"></td>
	</tr>
	<tr>
		<td valign="top"><!-- : ( Title ) (S) -->
		<table width="100%" border="0">
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Sub-Allocation and Ratio</td>
			</tr>
		</table>
		<!-- : ( Title ) (E) --> <!-- : ( Search Options ) (S) --> <!--biz page (S)-->
		<table class="search">
			<tr>
				<td class="bg">
				<table class="search" border="0" style="width: 797;">
					<tr class="h23">
						<td width="35">Lane</td>
						<td width=""><input type="text" style="width:50;text-align:center;ime-mode:disabled" class="input" required dataformat="uppernum"  maxlength="3" name="slane_cd" value="<%=slaneCd%>" disabled></td>
					</tr>
				</table>
				</td>
			</tr>
		</table>

		<table class="height_10">
			<tr>
				<td></td>
			</tr>
		</table>

		<!-- Tab BG Box  (S) -->
		<table class="search">
			<tr>
				<td class="bg"><!-- : ( Grid ) (S) -->
				<table width="100%" id="mainTable" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td width="100%"><!--시트--> <script language="javascript">ComSheetObject('sheet1');</script></td>
					</tr>
					<tr>
						<td valign="top" width="100%">Ref.) In case the additional slot is 0.25, the ratio is input as 2.25.</td>
					</tr>
					<tr><td height="3"></td></tr>
				</table>
				<!-- : ( Grid ) (E) --> <!-- Grid  (S) --> <!-- Grid (E) --></td>
			</tr>
		</table>
		<!-- Tab BG Box  (S) --> <!-- : ( Button : pop ) (S) -->
		<table width="100%" class="button">
			<tr>
				<td class="btn1_bg">
				<table border="0" cellpadding="0" cellspacing="0">					
					<td>
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_save">Save</td>
							<td class="btn1_right"></td>
						</tr>
					</table>
					</td>
				</table>
				</td>
			</tr>
		</table>
		</td>
	</tr>
</table>

<!--table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup">
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
			<tr>
				<td class="btn3_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td width="72">
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
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
		</td>
	</tr>
</table-->
<!-- : ( Button : pop ) (E) --> <!-- 개발자 작업  끝 --></form>
</body>
</html>