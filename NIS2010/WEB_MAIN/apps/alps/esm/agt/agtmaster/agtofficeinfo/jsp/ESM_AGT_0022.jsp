<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESMAGT022.jsp
*@FileTitle : 중국 Inbound 대리점 정보 관리 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.21
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2009.07.21 이호진
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.agt.agtmaster.agtofficeinfo.event.EsmAgt0022Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmAgt0022Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.AGTMaster.AGTOfficeInfo");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmAgt0022Event)request.getAttribute("Event");
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
<title>중국 Inbound 대리점 정보 관리 화면</title>
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

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form name = "hiddenF" mehhod="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="changeCol" value=""><!-- 콤보리스트에서 변화된 컬럼, value: stnd_cost_tp_cd, mgrp_cost_cd -->
<input type="hidden" name="sRow" value=""><!-- 콤보리스트가 변화된 row -->
<input type="hidden" name="changeValue" value=""><!-- 콤보리스트가 변화된 컬럼의 값 -->
</form>

<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">

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
                                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                <tr><td class="btn1_left"></td>
                                                <td class="btn1" name="btn_retrieve">Retrieve</td>
                                                <td class="btn1_right"></td>
                                                </tr>
                                        </table></td>
                                          <td class="btn1_line"></td>
                                          <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                <tr><td class="btn1_left"></td>
                                                <td class="btn1" name="btn_save">Save</td>
                                                <td class="btn1_right"></td>
                                                </tr>
                                        </table></td>	
                                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                <tr><td class="btn1_left"></td>
                                                <td class="btn1" name="btn_downexcel">Down Excel</td>
                                                <td class="btn1_right"></td>
                                                </tr>
                                        </table></td>
                                </tr>
                                </table>
                        </td></tr>
                </table>
                <!-- TABLE '#D' : ( Button : Main ) (E) -->

                <!-- TABLE '#D' : ( Search Options ) (S) -->
                <table class="search">
                <tr><td class="bg">
                        <table class="search_in" border="0">
                        <tr class="h23">
                                <td width="10%">Control Office</td>
                                <td><%=JSPUtil.getCodeCombo("finc_ofc_cd", "", "", "CD00848", 0, "")%></td>
                        </tr>
                        </table>
                </td></tr>
                </table>
                <!-- TABLE '#D' : ( Search Options : BKG Information ) (E) -->

                <table class="height_10"><tr><td></td></tr></table>

                <!-- TABLE '#D' : ( Search Options ) (S) -->
                <table class="search">
                <tr><td class="bg">

                        <!-- : ( BKG Information ) (S) -->

                        <table class="height_5"><tr><td></td></tr></table>

                        <!-- : ( grid ) (S) -->
                        <table width="100%" id="mainTable">
                        <tr><td>
                                <script language="javascript">ComSheetObject('sheet1');</script>
                        </td></tr>
                        </table>
                        <!-- : ( grid ) (E) -->

                        <!-- : ( Button : Sub ) (S) -->
                        <table width="100%" class="button">
                        <tr><td class="btn2_bg">
                                <table border="0" cellpadding="0" cellspacing="0">
                                <tr>

                                        <!-- Repeat Pattern -->
                                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                        <tr><td class="btn2_left"></td><td class="btn2" name="btng_rowadd">Row&nbsp;Add</td><td class="btn2_right"></td></tr></table></td>
                                        <!-- Repeat Pattern -->


                                </tr></table>
                        </td></tr>
                        </table>
                        <!-- : ( Button : Sub ) (E) -->


                </td></tr>
                </table>
                <!-- TABLE '#D' : ( Search Options ) (E) -->



</td></tr>
</table>
<!-- Outer Table (E)-->


</form>
</body>
</html>