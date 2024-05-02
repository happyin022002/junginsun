<%
/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ui_pri_0001_01.jsp
 *@FileTitle : Sales Guideline Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.16
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.04.16 박성수
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
<%@ page import="com.hanjin.apps.alps.esm.pri.scguideline.scsalesguideline.event.EsmPri000101Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
    EsmPri000101Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.hanjin.apps.SCGuideline.SCGuidelineMain");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmPri000101Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

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
<title>Guideline Creation</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		
		loadPage();
	}

</script>
</head>

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- 개발자 작업	-->
<input type="hidden" name="svc_scp_cd">
<input type="hidden" name="gline_seq">
<table class="search">
	<tr>
		<td class="bg"><!--Button (S) -->
		<table width="100%" border="0" class="button" cellpadding="0"
			cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
			<tr>
				<td class="btn1_bg">

				<table border="0" cellpadding="0" cellspacing="0">
					<tr>

						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_retrieve">Retrieve</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>

						<td class="btn1_line"></td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_save">Save</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
					</tr>
				</table>

				</td>
			</tr>
		</table>
		<!--Button (E) -->

		<table class="height_10">
			<tr>
				<td></td>
			</tr>
		</table>


		<!-- : ( Grid ) (S) -->
		<table width="100%" id="mainTable">
			<tr>
				<td width="100%"><script language="javascript">ComSheetObject('sheet1');</script>
				</td>
			<tr>
		</table>
		<!-- : ( Grid ) (E) --> <!--  Button_Sub (S) -->
		<table width="100%" class="button">
			<tr>
				<td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<td>
					<table width="100%" border="0" cellpadding="0" cellspacing="0"
						class="button">
						<tr>
							<td class="btn2_left"></td>
							<td class="btn2" name="btn_rowadd" suppressWait="Y">Row&nbsp;Add</td>
							<td class="btn2_right"></td>
						</tr>
					</table>
					</td>
					<td>
					<table width="100%" border="0" cellpadding="0" cellspacing="0"
						class="button">
						<tr>
							<td class="btn2_left"></td>
							<td class="btn2" name="btn_rowcopy" suppressWait="Y">Row&nbsp;Copy</td>
							<td class="btn2_right"></td>
						</tr>
					</table>
					</td>
					<td>
					<table width="100%" border="0" cellpadding="0" cellspacing="0"
						class="button">
						<tr>
							<td class="btn2_left"></td>
							<td class="btn2" name="btn_delete" suppressWait="Y">Delete</td>
							<td class="btn2_right"></td>
						</tr>
					</table>
					</td>
				</table>
				</td>
			</tr>
		</table>
		<!-- Button_Sub (E) -->
	
		<table class="height_10"><tr><td></td></tr></table>

		<table class="grid2" border="0" style="width: 100%;">
			<tr class="h23">
				<td width="90" class="tr_head2" align="center">Content</td>
				<td><textarea name="ref_ctnt" caption="Content" maxlength="4000" style="width:100%;height:130;"></textarea></td>
			</tr>
		</table>


		</td>
	</tr>
</table>


<!-- 개발자 작업  끝 --></form>
</body>
</html>