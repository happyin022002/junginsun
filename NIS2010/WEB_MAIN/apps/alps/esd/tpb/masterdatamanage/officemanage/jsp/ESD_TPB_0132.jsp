<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TPB_0132.jsp
*@FileTitle : TPB Office Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.06
*@LastModifier : Jong-Geon Byeon
*@LastVersion : 1.0
* 2009-07-06 Jong-Geon Byeon	1.0 ALPS Migration
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.tpb.masterdatamanage.officemanage.event.EsdTpb0132Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdTpb0132Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String rhq_cd		= "";
	String ofc_cd		= "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.MasterDataManage.OfficeManage");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		ofc_cd = account.getOfc_cd();

		event = (EsdTpb0132Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
	
	String[] officeInfo = com.hanjin.apps.alps.esd.tpb.common.TPBUtils.getHandleOfficeLevel( ofc_cd ); // 0:Office Level / 1:Office Code / 2:RHQ Code / 3:HO Code
//	String ofc_top_lvl = JSPUtil.getNull( com.hanjin.apps.enis.esd.tpb.common.TPBUtils.getOfficeTopLevel( ofc_cd ) );
	String ofc_lvl = JSPUtil.getNull( officeInfo[0] ); // Office Level  
	rhq_cd  = JSPUtil.getNull( officeInfo[2] ); // RHQ Code  
%>
<html>
<head>
<title><span id="title"></span></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<script language="javascript">
	<%= JSPUtil.getIBCodeCombo("combo01", "01", "CD00961", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("combo02", "01", "CD01472", 0, "")%>

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		_text_ChangeUpperCase(); // automatic change to uppercase
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="s_office_level" value="H">
<input type="hidden" name="s_rhq_cd_for_rhq" value="">
<input type="hidden" name="s_ofc_cd_for_rhq" value="">
<!-- |______________________________________________ End Hidden Value -->


<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>

	<!-- ______________________________________________ Start Page Navigation & Title -->
	
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
	<!-- |______________________________________________ End Page Navigation & Title -->


	<!-- ______________________________________________ Start Main Button -->
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
				<tr><td class="btn1_bg">

						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
							<td class="btn1_line"></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
							<!-- Repeat Pattern -->

						</tr></table>

				</td></tr>
			</table>
	<!-- |______________________________________________ End Main Button -->


	<!-- ______________________________________________ Start Search Option -->
	
		<table class="search"><tr><td class="bg">
	
			<table class="search_in" border="0">
				<tr class="h23">
					<td width="40"><img class="nostar">RHQ</td>
						<td width="170">
						<select style="width:80;" name="s_if_rhq_cd">
							<option value="" selected>ALL</option>
						</select>
					</td>
					<td width="65">TPB Office</td>
						<Td width="170">
						<select style="width:80;" name="s_if_ofc_cd">
							<option value="" selected>ALL</option>
						</select>
					</td>
					<td width="40">Office</td>
						<td><input type="text" style="width:80;" name="s_ofc_cd" maxlength="11"></td>
				</tr>
			</table>
	
		</td></tr></table>
	<!-- |______________________________________________ End Search Option -->


	<table class="height_10"><tr><td></td></tr></table>

	<!-- ______________________________________________ Start Result Grid -->
	
		<table class="search"><tr><td class="bg">
	
			<table width="100%" id="mainTable">
				<tr>
					<td>
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table>
	
	
		</td></tr></table>
	<!-- |______________________________________________ End Result Grid -->


</td></tr>
</table>
<!-- Outer Table (E)-->

</form>
</body>
</html>