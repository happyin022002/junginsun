﻿<%--=========================================================================
'주  시 스 템 : ENIS
'서브  시스템 : IAS T/S Volume
'프로그램 ID  : apps/enis/esm/coa/lanesimulation/jsp/ESM_COA_169.jsp
'프로그램 명  : IAS T/S Volume
'프로그램개요 : IAS T/S Volume
'작   성   자 :
'작   성   일 : 2009.02
=========================================================================
' History
' 2009.03.31 박은주,임옥영,박상희 S2K-09U-002(Lane Simulation System 개선)
' 2009.08.21 박은주 Alps전환작업 [ESM_COA_0169]   
' 2009.07.20 윤진영 Alps전환작업 
' 2010.12.01 김기종 Ticket ID:CHM-201006305-01 COA Architecture 위배사항 수정
=========================================================================--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%
    Exception serverException   = null; //서버에서 발생한 에러
    String strErrMsg    = "";           //에러메세지
    Logger log = Logger.getLogger("com.hanjin.apps.alps.esm.coa.lanesimulation.ESM_COA_0169");
    
    String ibIOC = "";
    String v_sim_dt = "";    
    String v_sim_no = "";

    try {

        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        } // end else
        v_sim_dt = JSPUtil.getNull(request.getParameter("f_sim_dt")).replaceAll("-","");
        v_sim_no = JSPUtil.getNull(request.getParameter("f_sim_no"));

    }catch(Exception e) {
        log.error("ESM_COA_169 Exception : "+e.toString());
        out.println(e.toString());
    }

%>
<html>
<head>
<title>IAS T/S Volume</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
<!--
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        loadPage();
    }

-->
</script>
</head>


<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd">
<input type="hidden" name="f_sim_dt" value="<%= v_sim_dt %>">
<input type="hidden" name="f_sim_no" value="<%= v_sim_no %>">
<input type="hidden" name="iPage">

<!-- OUTER - POPUP (S)tart -->

<table width="400" class="popup" cellpadding="10" border="0">
	<tr><td class="top"></td></tr>
	<tr>
		<td valign="top">


		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp; T/S Volume</td></tr>
		</table>
		<!-- : ( Title ) (E) -->




			<!-- : ( Grid BG Box ) (S) -->
			<table class="search" width="100%" >
				<tr>
					<td class="bg">
						<!-- : ( Grid ) (S) -->
						<table width="100%" id="mainTable">
							<tr>
								<td>
									<script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table>
						<!-- : ( c ) (E) -->

 						<!-- : ( Grid ) (S) -->

					</td>
				</tr>
			</table>
			<!-- : ( Grid BG Box ) (E) -->


		</td>
	</tr>
</table>
<!-- OUTER - POPUP (E)nd -->


<table class="height_5"><tr><td></td></tr></table>


<!-- : ( Button : pop ) (S) -->
<table width="400" class="sbutton">
<tr><td height="71" class="popup">

		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>

				<!-- Repeat Pattern -->
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_save" id="btn_save">Save</td><td class="btn1_right"></td></tr></table></td>

				<td class="btn1_line"></td>

				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
				<!-- Repeat Pattern -->

			</tr>
		</table>

	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->


</form>
</body>
</html>

