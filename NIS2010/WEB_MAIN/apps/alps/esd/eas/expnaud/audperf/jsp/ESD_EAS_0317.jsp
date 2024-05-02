<%
/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ESD_EAS_0317.jsp
*@FileTitle : Logistics Expense Result
*Open Issues :
*Change history :
*@LastModifyDate : 2015-02-02
*@LastModifier : 9014613
*@LastVersion : 1.0
* 2015-02-02 9014613 			1.0	최초 생성
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.eas.expnaud.audperf.event.EsdEas0317Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdEas0317Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.alps.esd.eas.expnaud.audperf.AudPerfBC");
	
	String ofc_cd = "";
		
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		
		ofc_cd = account.getOfc_cd();
		
		event = (EsdEas0317Event)request.getAttribute("Event");
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
<title>JO TPB Process Inquiry</title>
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
<!-- 개발자 작업	-->
<!-- ______________________________________________ Start Hidden Value -->
<!-- | --> <input type="hidden" name="code_key">
<!-- | --> <input type="hidden" name="s_rhq_yn" value="Y">
<!-- | --> <input type="hidden" name="ofc_cd" 		value="<%=ofc_cd%>" >
<!-- | --> <input type="hidden" name="s_compare_mon" 		value="1" >
<!-- |______________________________________________ End Hidden Value -->


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


	<!-- ______________________________________________ Start Main Button -->
	<!-- | -->
	<!-- | -->	<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
				<tr><td class="btn1_bg">

						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_new">New</td><td class="btn1_right"></td></tr></table></td>

							<td class="btn1_line"></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>

							<!-- Repeat Pattern -->

						</tr></table>

				</td></tr>
		</table>
	<!-- |______________________________________________ End Main Button -->


	<!-- ______________________________________________ Start Search Option -->
	<!-- | -->
	<!-- | -->	<table class="search"><tr><td class="bg">
	<!-- | -->
	<!-- | -->		<table class="search_in" border="0">
	<!-- | -->			<tr class="h23">
	<!-- | -->				<td width="70">RHQ</td>
	<!-- | -->				<td width="80" style="padding-left:2;">
	<!-- | -->					<script language="javascript">ComComboObject('s_rhq_ofc_cd',1,100,0,0,0);</script>
	<!-- | -->				</td>
	<!-- | -->				<td width="84">Office</td>
	<!-- | -->				<td width="82" style="padding-left:0;">
	<!-- | -->					<script language="javascript">ComComboObject('s_ofc_cd',1,100,0,0,0);</script>
	<!-- | -->				</td>
	<!-- | -->				<td width="70">Period</td>
	<!-- | -->				<td width="190"><input class="input1" type="text" name="s_fm_ym" required style="width:60; text-align: center;" caption="G/L Month - From" dataformat="ym" maxlength="6" size="10" >&nbsp;<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar1">&nbsp;~&nbsp;<input class="input1" type="text" name="s_to_ym" required style="width:60; text-align: center;" caption="G/L Month - To" dataformat="ym" maxlength="6" size="10" >&nbsp;<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar2"></td>
	<!-- | -->				<td width="230"><input type="checkbox" name = "s_compare_mon_radio" class="trans" >&nbsp;Comparison</td>
	<!-- | -->			</tr>
	<!-- | -->			<tr class="h23">
	<!-- | -->				<td width="70">Module</td>
	<!-- | -->				<td width="88">
	<!-- | -->					<select class="input" style="width:100;" name="s_mdl_cd" caption="Module">
	<!-- | -->						<option value="" selected></option>
	<!-- | -->						<option value="SO_TRANS" >TRS</option>
	<!-- | -->						<option value="SO_TERMINAL" >TES</option>
	<!-- | -->						<option value="SO_PORT" >PSO</option>
	<!-- | -->						<option value="SO_M&R" >MNR</option>
	<!-- | -->					</select>
	<!-- | -->				</td>
	<!-- | -->				<td width="85">Cost Code</td>
	<!-- | -->				<td width="120">
	<!-- | -->					<script language="javascript">ComComboObject('s_lgs_cost_cd',4,100,0,0,0);</script>
	<!-- | -->				</td>
	<!-- | -->				<td width="75" title="Cargo Type">Cargo Type</td>
	<!-- | -->				<td width="35" title="Cargo Type" style="padding-left:2px;">
	<!-- | -->					<script language="javascript">ComComboObject('s_cgo_tp_cd',1,60,1,0,0);</script>
	<!-- | -->				</td>	
	<!-- | -->				<td width="">&nbsp;
	<!-- | -->                 <script language="javascript">ComComboObject('s_rto_tp_cd',1,120,1,0,0);</script>&nbsp;
	<!-- | -->                 <input type="text" name="s_rto" dataformat="float" class="input" style="width:50; text-align: right;"> %
	<!-- | -->             </td>
	<!-- | -->			</tr>
	<!-- | -->		</table>
	<!-- | -->
	<!-- | -->
	<!-- | -->
	<!-- | -->	</td></tr></table>
	<!-- |______________________________________________ End Search Option -->


	<table class="height_10"><tr><td></td></tr></table>

	<!-- ______________________________________________ Start Result Grid -->
	<!-- | -->
	<!-- | -->	<table class="search"><tr><td class="bg">
	<!-- | -->
	<!-- | -->		<table width="100%" id="mainTable">
	<!-- | -->			<tr>
	<!-- | -->				<td>
	<!-- | -->					<script language="javascript">ComSheetObject('sheet1');</script>
	<!-- | -->				</td>
	<!-- | -->			</tr>
	<!-- | -->		</table>
	<!-- | -->
	<!-- | -->	</td></tr></table>
	<!-- | -->
	<!-- | -->	<table class="search" style="display:none;"><tr><td class="bg">
	<!-- | -->
	<!-- | -->		<table width="100%" id="mainTable">
	<!-- | -->			<tr>
	<!-- | -->				<td>
	<!-- | -->					<script language="javascript">ComSheetObject('sheet2');</script>
	<!-- | -->				</td>
	<!-- | -->			</tr>
	<!-- | -->		</table>
	<!-- | -->
	<!-- | -->	</td></tr></table>
	<!-- |______________________________________________ End Result Grid -->



    </td></tr>
</table>
<!-- Outer Table (E)-->


</form>
</body>
</html>