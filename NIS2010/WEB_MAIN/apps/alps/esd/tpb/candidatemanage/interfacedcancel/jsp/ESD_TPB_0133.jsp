<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TPB_0133.jsp
*@FileTitle : InterfacedCancel
*Open Issues :
*Change history :
*@LastModifyDate : 2009-09-16 
*@LastModifier : 변종건
*@LastVersion : 1.1
* 2009-03-16 O Wan-Ki 			1.0 	최초 생성
* 2009-09-16 Jong-Geon Byeon	1.1 	ALPS Migration
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.tpb.candidatemanage.interfacedcancel.event.EsdTpb0133Event"%>
<%@ page import="com.hanjin.apps.alps.esd.tpb.common.TPBUtils"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdTpb0133Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.CandidateManage.InterfacedCancel");
	
	String ofc_cd = "";
	String rhq_cd = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		ofc_cd = account.getOfc_cd();
	
		event = (EsdTpb0133Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
	strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
	
	String n3pty_no_strs = JSPUtil.getNull(request.getParameter("n3pty_no"));
	String s_n3pty_no_strs_link = JSPUtil.getNull(request.getParameter("s_n3pty_no_strs_link"));

	String[] officeInfo = TPBUtils.getHandleOfficeLevel( ofc_cd, true ); // 0:Office Level / 1:Office Code / 2:R.HQ Code / 3:HO Code
	String ofc_lvl = JSPUtil.getNull( officeInfo[0] ); // Office Level
	rhq_cd = JSPUtil.getNull( officeInfo[2] );  // R.HQ Code
%>
<html>
<head>
<title>InterfacedCancel</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<script language="javascript">
	function setupPage() {
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

<input type="hidden" name="s_office_level" value="<%=ofc_lvl%>">
<input type="hidden" name="s_rhq_cd_for_rhq" value="<%=rhq_cd%>">
<input type="hidden" name="s_ofc_cd_for_rhq" value="<%=ofc_cd%>">
<input type="hidden" name="s_usr_ofc_cd" value="<%=ofc_cd%>">
<input type="hidden" name="s_isNoticeOnly" value="0">
<input type="hidden" name="s_n3pty_no_strs">
<input type="hidden" name="s_n3pty_no_strs_link" value="<%=s_n3pty_no_strs_link%>">

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>


				<!-- ______________________________________________ Start Page Navigation & Title -->
				<!-- | -->
				<!-- | -->	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
							<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
							<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
						</table>
				<!-- |______________________________________________ End Page Navigation & Title -->






					<!-- TABLE '#D' : ( Button : Main ) (S) -->
					<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
						<tr><td class="btn1_bg">

								<table border="0" cellpadding="0" cellspacing="0">
								<tr>
									<!-- Repeat Pattern -->
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn1_left"></td><td class="btn1" name="btn_tonontpb" id="btn_tonontpb">TO Non-TPB</td><td class="btn1_right"></td></tr></table></td>
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn1_left"></td><td class="btn1" name="btn_eliminate" id="btn_eliminate">Eliminate</td><td class="btn1_right"></td></tr></table></td>
									<td width="30"></td>
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>


									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
									<!-- Repeat Pattern -->

								</tr></table>

						</td></tr>
					</table>
				   	<!-- TABLE '#D' : ( Button : Main ) (E) -->







					<!-- TABLE '#D' : ( Search Options ) (S) -->
				   	<table class="search">
				       	<tr>
				       		<td class="bg">

								<!-- Hierarchy Office (S) -->
								<table class="search_in" border="0" width="100%">
									<tr class="h23">
										<td width="40"><img class="nostar">RHQ</td>
										<td width="200">
											<select style="width:110;" name="s_if_rhq_cd" caption="RHQ">
												<option value="" selected>ALL</option>
											</select>
										</td>
										<td width="97"><img class="nostar">Control Office</td>
										<td width="200">
											<select style="width:110;" name="s_if_ctrl_cd" caption="Control Office">
											<option value="" selected>ALL</option>
											</select>

										</td>
										<td width="48"><img class="nostar">Office</td>
										<td>
											<select style="width:110;" name="s_if_ofc_cd">
												<option value="" selected>ALL</option>
											</select>
										</td>
									</tr>
								</table>
								<!-- Hierarchy Office (E) -->

							</td>
						</tr>
					</table>
					<!-- TABLE '#D' : ( Search Options ) (E) -->







					<table class="height_10"><tr><td></td></tr></table>





					<!-- TABLE '#D' : ( Grid ) (S) -->
				   	<table class="search">
			     		<tr>
			     			<td class="bg">

								<table class="height_5"><tr><td></td></tr></table>

								<!-- : ( POR ) (S) -->
								<table width="100%" id="mainTable">
									<tr>
						              	<td><script language="javascript">ComSheetObject('sheet1');</script></td>
						            </tr>
								</table>
								<!-- : ( POR ) (E) -->

							</td>
						</tr>
					</table>
					<!-- TABLE '#D' : ( Grid ) (E) -->




</td></tr>
</table>
<!-- Outer Table (E)-->



</form>
</body>
</html>
