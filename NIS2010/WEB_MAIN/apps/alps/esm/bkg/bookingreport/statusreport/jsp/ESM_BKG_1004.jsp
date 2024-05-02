
<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : esm_bkg_1004.jsp
	 *@FileTitle : DPCS: PIC Change
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.05.13
	 *@LastModifier : 김경섭
	 *@LastVersion : 1.0
	 * 2009.05.13 김경섭
	 * 1.0 Creation
	 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page
	import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page
	import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.event.EsmBkg1004Event"%>	
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg1004Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	boolean bBtn_Disabled = true;
	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg1004Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request
				.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
	  String bkg_no   = JSPUtil.getParameter(request,"bkg_no"); 
	  String sr_no    = JSPUtil.getParameter(request,"sr_no"); 
	  String src_cd   = JSPUtil.getParameter(request,"src_cd"); 
	  String pic_id   = JSPUtil.getParameter(request,"pic_id"); 
%>
<html>
<head>
<title>DPCS: PIC Change</title>
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

<body class="popup_bg" onLoad="setupPage();">
<div id="debug"></div>
<form name="form">
	<input type="hidden" name="f_cmd"> 
	<input type="hidden" name="pagerows"> 
	<input type="hidden" name="bkg_no"        value="<%=bkg_no%>">
	<input type="hidden" name="src_cd"        value="<%=src_cd%>">
	<input type="hidden" name="sr_no"         value="<%=sr_no%>">
	<input type="hidden" name="before_usr_id" value="<%=pic_id %>" >
	<input type="hidden" name="usr_id"        value="<%=strUsr_id%>">
<!-- 개발자 작업	-->
<table width="100%" class="popup" cellpadding="10" border="0"> 
	<tr><td class="top"></td></tr>
	<tr>
		<td valign="top">
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0">
		<tr><td class="title"><img src="./img/icon_title_dot.gif" align="absmiddle">&nbsp;DPCS: PIC Change</td></tr>
		</table>
		<!--Page Title, Historical (E)--> <!-- : ( Search Options ) (S) -->

			<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">

				<table class="search" border="0" style="width: 100%;">
					<tr class="h23">
						<td width="65">Change ID</td>
						<td width=""><input type="text" style="width: 100" value=""	class="input" name="change_usr_id" readonly></td>
					</tr>
				</table>


				<!-- Grid  (S) -->
					<table width="100%"  id="mainTable">
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table>
					<!-- Grid (E) -->
			
				</td>
			</tr>
		</table>
	
<table class="height_5"><tr><td></td></tr></table>
		</td>
	</tr>
</table>
	
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

					<table width="100%" class="button" border="0" cellpadding="0"
						cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
						<tr>
							<td class="btn3_bg">
									<table border="0" cellpadding="0" cellspacing="0">
										<tr>
											<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0"
								class="button">
								<tr>
									<td class="btn1_left"></td>
									<td class="btn1" name="btn_select">Select</td>
									<td class="btn1_right"></td>
								</tr>
							</table>
							</td>
							<td id="div_bkg">
							<table width="100%" border="0" cellpadding="0" cellspacing="0"
								class="button">
								<tr>
									<td class="btn1_left"></td>
									<td class="btn1" name="btn_save">Save</td>
									<td class="btn1_right"></td>
								</tr>
							</table>
							</td>
							<td class="btn1_line"></td>
							<td id="div_fax">
							<table width="100%" border="0" cellpadding="0" cellspacing="0"
								class="button">
								<tr>
									<td class="btn1_left"></td>
									<td class="btn1" name="btn_close">Close</td>
									<td class="btn1_right"></td>
								</tr>
							</table>
							</td>
										</tr>
									</table>
							<!--Button (E) --></td>
						</tr>
					</table>
			</td>
		</tr>
	</table>					
		<!-- : ( Button : pop ) (E) -->


<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
<%@include file="/bizcommon/include/common_alps.jsp"%>