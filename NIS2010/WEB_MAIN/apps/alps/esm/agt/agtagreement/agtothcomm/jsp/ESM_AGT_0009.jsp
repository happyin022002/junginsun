<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_AGT_0009.jsp
*@FileTitle : Commission Unit Cost Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.01
*@LastModifier : 박성진
*@LastVersion : 1.1
* 1.0 Creation 2009.08.10 추경원
* 1.1 2011.04.01 박성진 [CHM-201109284-01][ESM-AGT]Split 06-ALPS의 Location 조회불가건 수정 보완
* 1.6 2011.09.27 이정수 [CHM-201113545] [ESM-AGT] 화면 Loading 기능 보완
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.agt.agtagreement.agtothcomm.event.EsmAgt0009Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmAgt0009Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.agtagreement.agtothcomm");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmAgt0009Event)request.getAttribute("Event");
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
<title>Commission Unit Cost Inquiry</title>
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
<!-- 개발자 작업	-->
<form name="hiddenF" mehhod="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="ofc_cd"><!-- OfficeCd -->
<input type="hidden" name="comm_yrmon"><!-- CommYrmon -->
</form>

<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="old_OfficeCd">
<input type="hidden" name="old_CommYrmon">


<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>


		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->


		<!-- TABLE '#D' : ( Button : Main ) (S) -->
                        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
                        <tr><td class="btn1_bg">

                                        <table border="0" cellpadding="0" cellspacing="0">
                                        <tr>
                                                <!-- Repeat Pattern -->
                                                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                        <tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
                                                <!-- Repeat Pattern -->

                                        </tr></table>

                                </td></tr>
                        </table>
		<!-- TABLE '#D' : ( Button : Main ) (E) -->


		<!-- TABLE '#D' : ( Search Options ) (S) -->
        <table class="search">
        <tr><td class="bg">
                                <table class="search_in" border="0">
                                        <tr class="h23">
                                                <td width="5%">Office</td>
                                                <td width="19%">&nbsp;<input class="input1" type="text" name="ofc_cd" style="width:70;ime-mode:disabled;" onKeyPress="ComKeyOnlyAlphabet()" onKeyUp="checkEnterOffice(this);" onBlur="searchUpdate();" maxlength="6" style="ime-mode:disabled" >&nbsp;<a href="javascript:openWindowOffice(document.form);" class="purple"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></a></td>
                                                <td width="9%">Apply Month</td>
                                                <td width="10%">&nbsp;<input class="input1" type="text" name="comm_yrmon1" style="width:55;ime-mode:disabled" dataformat="ym" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)" onBlur="checkUpdateDt(this);" maxlength="7">&nbsp;<img class="cursor" name="btns_calendar1" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>
                                                <td class="sm">(YYYY-MM)</td>
                                                <td colspan="2"></td></tr>
                                        <tr class="h23">
                                                <td>POR</td>
                                                <td>&nbsp;<input type="text" name="bkg_por_cd" style="width:70;ime-mode:disabled;" onKeyUp="ComKeyEnter();" onkeypress="ComKeyOnlyAlphabet('uppernum')" maxlength="5">&nbsp;<a href="javascript:openWindowLocation(document.form, 'POR');" class="purple"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></a></td>
                                                <td>DEL</td>
                                                <td width="22%" colspan="2">&nbsp;<input type="text" name="bkg_del_cd" onKeyUp="ComKeyEnter();" onkeypress="ComKeyOnlyAlphabet('uppernum')" style="width:55;ime-mode:disabled;" maxlength="5">&nbsp;<a href="javascript:openWindowLocation(document.form, 'DEL');" class="purple"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></a></td>
                                                <td width="10%"><img class="nostar">Update Date</td>
                                                <td>&nbsp;<input type="text" name="selUpdateDate" style="width:75;" class="input2" readonly="true"></td></tr>
                                </table>
                        </td></tr>
                </table>
		<!-- TABLE '#D' : ( Search Options : BKG Information ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
		<tr><td class="bg_a">

		<!-- : ( BKG Information ) (S) -->

			<table width="100%" class="search">
				<tr><td class="gray_tit"><img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">Ave. Unit Cost (USD)</td></tr>
			</table>
			<!-- : ( grid ) (S) -->
			<table width="100%" id="mainTable">
			  <tr><td>
			 <script language="javascript">ComSheetObject('sheet1');</script>
			  </td></tr>
			</table>
			<!-- : ( grid ) (E) -->

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options : BKG Information ) (E) -->


</td></tr>
</table>
<!-- Outer Table (E)-->

<script language="Javascript">
 var currDate = ComGetNowInfo('ym', '-');
 document.form.comm_yrmon1.value = currDate;
 document.hiddenF.comm_yrmon.value = currDate;
</script>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>