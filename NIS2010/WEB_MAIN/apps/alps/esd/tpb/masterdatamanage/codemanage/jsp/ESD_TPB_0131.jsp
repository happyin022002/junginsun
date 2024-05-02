<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TPB_0131.jsp
*@FileTitle : CodeManage
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : Jong-Geon Byeon
*@LastVersion : 1.0
* 2009-08-05 Jong-Geon Byeon	1.0 ALPS Migration 작업
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.tpb.masterdatamanage.codemanage.event.EsdTpb0131Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.apps.alps.esd.tpb.common.TPBUtils"%>

<%
	EsdTpb0131Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	StringBuffer codeSb = new StringBuffer();
	DBRowSet rowSet	  = null;
	
	Logger log = Logger.getLogger("com.hanjin.apps.MasterDataManage.CodeManage");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsdTpb0131Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		if (eventResponse != null) {
			rowSet = eventResponse.getRs();
			if(rowSet != null){
				 //rowCount = rowSet.getRowCount();
				 while(rowSet.next()){
					 codeSb.append(rowSet.getString("n3pty_bil_tp_cd"))
						   .append("|")
						   .append(rowSet.getString("act_flg"))
						   .append("^");
				 }
			} // end if
		} // end if
		
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
		_text_ChangeUpperCase(); // automatic change to uppercase
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="s_codeAll" value="<%=codeSb%>">
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
					<td width="100">I/F Type</td>
					<td><%=TPBUtils.getCodeCombo("s_if_type", "", "style='width:130', class='input'", "CD00581", 0, "0::ALL"+"|1:R:Logistics Revenue", "")%>
					    <!-- <select name="s_if_type" style="width:100;">
						     </select> -->
					</td>
					<td width="12%">Expense Type</td>
					<td>
					    <select name="s_expense_type" style="width:100;">
						</select>
					</td>
					<td width="12%">Billing Type Code</td>
					<td>
					    <select name="s_billing_case_cd" style="width:100;">
						</select>
					</td>
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