<%/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TPB_101.jsp
*@FileTitle : TPB Code Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.02
*@LastModifier : Jong-Geon Byeon
*@LastVersion : 1.1
* 2008.08.29 O Wan-Ki 			1.0 최초 생성
* 2009.07.02 Jong-Geon Byeon	1.1 ALPS Migration
* 2015.08.05 Kim Hyun Hwa[CHM-201537151]그룹사 표준 코드 시행 프로그램 수정 - SELCON를 SELOPB
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.tpb.masterdatamanage.codemanage.event.EsdTpb0101Event"%>
<%@ page import="com.hanjin.apps.alps.esd.tpb.common.TPBUtils" %>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdTpb0101Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.MasterDataManage.CodeManage");
	
	String userId = "";
	String ofc_cd = "";
	String rhq_cd = "";
	String ofc_lvl = "";
	
	StringBuffer codeSb = new StringBuffer();
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		
		ofc_cd = account.getOfc_cd();

		event = (EsdTpb0101Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		String[] officeInfo = TPBUtils.getHandleOfficeLevel( ofc_cd ); // 0:Office Level / 1:Office Code / 2:RHQ Code / 3:HO Code
		ofc_lvl = JSPUtil.getNull( officeInfo[0] ); // Office Level  
		rhq_cd  = JSPUtil.getNull( officeInfo[2] ); // RHQ Code  
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title><span id="title"></span></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<script language="javascript">
<%= JSPUtil.getIBCodeCombo("combo01", "01", "CD00904", 0, "")%>
<%= JSPUtil.getIBCodeCombo("combo02", "01", "CD00579", 0, "")%>
<%= JSPUtil.getIBCodeCombo("combo03", "01", "CD00581", 0, "")%>

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
<input type="hidden" name="iPage">
<input type="hidden" name="s_codeAll" value="<%=codeSb%>">
<input type="hidden" name="s_office_level" value="<%=ofc_lvl%>"> 
<input type="hidden" name="s_rhq_cd_for_rhq" value="<%=rhq_cd%>">
<input type="hidden" name="s_ofc_cd_for_rhq" value="<%=ofc_cd%>">
<input type="hidden" name="s_n3pty_bil_tp_cd">

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
	<tr>
		<td>
	<!-- ______________________________________________ Start Page Navigation & Title -->
	
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr>
					<td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td>
				</tr>
				<tr>
					<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td>
				</tr>
			</table>
	<!-- |______________________________________________ End Page Navigation & Title -->


	<!-- ______________________________________________ Start Main Button -->
	
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
				<tr>
					<td class="btn1_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<!-- Repeat Pattern -->
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td class="btn1_line"></td>
								<td>
								<% if ( ofc_lvl.equals("H") && (ofc_cd.equals("SELCON")||ofc_cd.equals("SELOPA")) ) { %>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_save" id="btn_save">Save</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								<% } %>
								</td>

								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<!-- Repeat Pattern -->
							</tr>
						</table>
					</td>
				</tr>
			</table>
	<!-- |______________________________________________ End Main Button -->
	<!-- ______________________________________________ Start Search Option -->
			<table class="search">
				<tr>
					<td class="bg">
						<table class="search_in" border="0">
							<tr class="h23">
								<td width="12%">Billing Type Code</td>
								<td>
								    <select name="s_billing_case_cd" style="width:100;">
									</select>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
	<!-- |______________________________________________ End Search Option -->
			<table class="height_10"><tr><td></td></tr></table>
	<!-- ______________________________________________ Start Result Grid -->
	
			<table class="search">
				<tr>
					<td class="bg">
		
						<table width="100%" id="mainTable">
							<tr>
								<td>
									<script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table>
			
						<table width="100%" class="button">
							<tr>
								<td class="btn2_bg">
									<table border="0" cellpadding="0" cellspacing="0">
										<tr>
										<!-- Repeat Pattern -->
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
													<% if ( ofc_lvl.equals("H") && (ofc_cd.equals("SELCON")||ofc_cd.equals("SELOPA")) ) { %>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn_add" id="btn_add">Row Add</td>
														<td class="btn2_right"></td>
													<% } %>
													</tr>
												</table>
											</td>
										<!-- Repeat Pattern -->
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
</table>
	<!-- |______________________________________________ End Result Grid -->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>