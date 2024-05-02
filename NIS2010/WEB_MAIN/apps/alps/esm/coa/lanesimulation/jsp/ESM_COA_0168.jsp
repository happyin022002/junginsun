<%--
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_COA_168.jsp
*@FileTitle : Creation (Variant Change)
*Open Issues :
*Change history :
*@LastModifyDate : 2009-03-12
*@LastModifier : Ari
*@LastVersion : 1.0
* 2009-03-12 Ari
* 1.0 최초 생성
* =========================================================
' History
' 2009.03.31 박은주,임옥영,박상희 S2K-09U-002(Lane Simulation System 개선)
' 2009.07.20 윤진영 Alps전환작업 
' 2010.12.01 김기종 Ticket ID:CHM-201006305-01 COA Architecture 위배사항 수정
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.apps.alps.esm.coa.lanesimulation.event.EsmCoa0168Event"%>
<%
	EsmCoa0168Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	GeneralEventResponse eventResponse = null;	//RDTO(Data Transfer Object including DB ResultSet)
	Exception serverException	= null;				//서버에서 발생한 에러
	String strErrMsg = "";							//에러메세지

	String f_sim_no = "";
	String f_sim_dt = "";
	String f_dept_cd = "";
	String f_usr_id = "";
	int f_reportMasterCount = 0;

	//f_dept_cd, f_sim_dt, f_sim_no, f_usr_id


	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		event = (EsmCoa0168Event)request.getAttribute("Event");

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
			eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
			if (eventResponse != null) {
				f_sim_no = JSPUtil.getNull(request.getParameter("f_sim_no"));
				f_sim_dt = JSPUtil.getNull(request.getParameter("f_sim_dt"));
				f_dept_cd = JSPUtil.getNull(request.getParameter("f_dept_cd"));
				f_usr_id = JSPUtil.getNull(request.getParameter("f_usr_id"));
				f_reportMasterCount = Integer.parseInt(eventResponse.getETCData("cnt"));
			} // end if
		} // end else
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Creation (Variant Change)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		setRetrieveAction();
	}
</script>
</head>

<body onload="javascript:setupPage();">
<form method="post" name="form" onKeyDown="ComKeyEnter();">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="f_sim_no" value="<%= f_sim_no %>">
<input type="hidden" name="f_sim_dt" value="<%= f_sim_dt %>">
<input type="hidden" name="f_dept_cd" value="<%= f_dept_cd %>">
<input type="hidden" name="f_usr_id" value="<%= f_usr_id %>">
<input type="hidden" name="f_reportMasterCount" value="<%= f_reportMasterCount %>">

<!-- design start -->
<!-- OUTER - POPUP (S)tart -->
<table width="700" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">



		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp; Creation (Variant Change)</td></tr>
		</table>
		<!-- : ( Title ) (E) -->


		<!--1 Start-->
		<!-- : ( Search Options ) (S) -->
		<table class="search" align="center">
		    <%--
       		<tr><td class="bg">
				<!-- : ( Select 'Simulation No' ) (S) -->
				<table class="search" border="0">
		            <tr class="h23">
                       <td width="70">File Name</td>
                       <td>
                           <input type="text" style="width:80;" name="f_sim_rpt_no" maxlength="8">
                       </td>
                       <td width="20"></td>
                       <td width="60">Remark</td>
                       <td>
                           <input type="text" style="width:380;" name="f_sim_rmk" maxlength="1000">
                       </td>
	                </tr>
                </table>

                </td>
            </tr>
            <tr><td height="5"></td></tr>
            --%>
			<tr><td class="bg">
			<!-- : ( Level Group ) (E) -->
			<table width="100%" id="mainTable">
				<tr><td>
					 <script language="javascript">ComSheetObject('sheet');</script>
				</td></tr>
			</table>

			<!-- : ( Level Group ) (E) -->

		</td></tr>
		</table>
		<!-- : ( Search Options ) (E) -->
<!--1 End-->

</td></tr>
</table>
<!-- OUTER - POPUP (E)nd -->

<table class="height_5"><tr><td></td></tr></table>


<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>

				<!-- Repeat Pattern -->
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_creation" id="btn_creation">Creation</td><td class="btn1_right"></td></tr></table></td>

				<td class="btn1_line"></td>

				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
				<!-- Repeat Pattern -->

			</tr>
		</table>

	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->


<!-- design end -->

</form>
</body>
</html>