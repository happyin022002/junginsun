<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESM_SPC_0072.jsp
*@FileTitle : Booking List
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.14
*@LastModifier : 신자영
*@LastVersion : 1.0
* 2014.11.14 신자영
* 1.0 Creation
* 2014.11.14 신자영 [CHM-201432770] T/S Booking Report 개선 - ESM_SPC_0105에서 Booking Vol 클릭 시 open
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastinquiry.event.EsmSpc0072Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSpc0072Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
    String ts_port = "";
    String pol_cd = "";
    String pod_cd = "";
    String del_cd = "";
    String pre_vvd = "";
    String post_vvd = "";
    String post_vvd1 = "";
    String post_vvd2 = "";
    String sls_ofc_cd = "";
    String type = "";
    String week = "";
    

	
	Logger log = Logger.getLogger("com.hanjin.apps.SpaceAllocationManage.SpaceAllocationManage");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

     

		event = (EsmSpc0072Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		ts_port    = JSPUtil.getParameter(request, "ts_port",      "");
		pol_cd     = JSPUtil.getParameter(request, "pol_cd",      "");
		pod_cd     = JSPUtil.getParameter(request, "pod_cd",      "");
		del_cd     = JSPUtil.getParameter(request, "del_cd",      "");
		pre_vvd    = JSPUtil.getParameter(request, "pre_vvd",      "");
		post_vvd   = JSPUtil.getParameter(request, "post_vvd",      "");
		post_vvd1  = JSPUtil.getParameter(request, "post_vvd1",      "");
		post_vvd2  = JSPUtil.getParameter(request, "post_vvd2",      "");
		sls_ofc_cd = JSPUtil.getParameter(request, "sls_ofc_cd",      "");
		type       = JSPUtil.getParameter(request, "type",      "");
		week       = JSPUtil.getParameter(request, "week",      "");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Booking List</title>
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

<input type="hidden" name="post_vvd1" value ="<%=post_vvd1 %>">
<input type="hidden" name="post_vvd2" value ="<%=post_vvd2 %>">
<input type="hidden" name="type" value ="<%=type %>">
<input type="hidden" name="week" value ="<%=week %>">


<!-- 개발자 작업	-->
<table width="690" class="popup" cellpadding="10">
<tr><td valign="top">


		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;Booking List</td></tr>
		</table>
		<!-- : ( Title ) (E) -->

		<!-- TABLE '#D' : ( Button : Main ) (S) -->
        <!-- 
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
				<tr><td class="btn1_bg">

						<table border="0" cellpadding="0" cellspacing="0">
						<tr>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_new">New</td><td class="btn1_right"></td></tr></table></td>
					</tr></table>

				</td></tr>
		</table>

		<table class="height_10"><tr><td></td></tr></table>
        -->
		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg">
					<!-- : ( Scenario ID ) (S) -->
					<table class="search" border="0" style="width:590;"> 
					<tr class="h23">
						<td width="5%"><img class="nostar">T.VVD</td>
						<td><input type="text" name="vvd" style="text-align:center; width:80;" onKeyUp="javascript:upper(this);"></td>
						<td><img class="nostar">TS Port</td>
		                <td><input type="text" style="text-align:center; width:50;" name="ts_port" style="ime-mode:disabled;" value="<%= ts_port %>"></td>
						<td><img class="nostar">POL</td>
		                <td><input type="text" style="text-align:center; width:50;" name="pol_cd" style="ime-mode:disabled;" value="<%= pol_cd %>"></td>
						<td><img class="nostar">POD</td>
		                <td><input type="text" style="text-align:center; width:50;" name="pod_cd" style="ime-mode:disabled;" value="<%= pod_cd %>"></td>
						<td><img class="nostar">DEL</td>
		                <td><input type="text" style="text-align:center; width:50;" name="del_cd" style="ime-mode:disabled;" value="<%= del_cd %>"></td>
						</tr>
					<tr class="h23">
						<td width="5%"><img class="nostar">Pre.VVD</td>
						<td><input type="text" style="text-align:center; width:80;" name="pre_vvd" style="ime-mode:disabled;" value="<%= pre_vvd %>"></td>
						<td><img class="nostar">Post.VVD</td>
		                <td><input type="text" style="text-align:center; width:80;" name="post_vvd" style="ime-mode:disabled;" value="<%= post_vvd %>"></td>
						<td><img class="nostar">L.Office</td>
		                <td><input type="text" style="text-align:center; width:50;" name="sls_ofc_cd" style="ime-mode:disabled;" value="<%= sls_ofc_cd %>"></td>
						</tr>
					</table>
					<!-- : ( Scenario ID ) (E) -->
					
					<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
					
					<!-- : ( Grid ) (S) -->
					<!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' ,
				 		'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->
					<table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet1');</script>
                        </td></tr>
		            </table>
					<!-- : ( Grid ) (E) -->
				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->

</td></tr>
</table>
<!-- OUTER - POPUP (E)nd -->

<table class="height_10"><tr><td></td></tr></table>


<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton">
	<tr><td height="71" class="popup">
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
				<tr><td class="btn3_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<!-- Repeat Pattern -->
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr>
								</table></td>
								<!-- Repeat Pattern -->
							</tr>
						</table>
				</td></tr>
			</table>
	</td></tr>
</table>
<!-- : ( Button : Sub ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
<script>
<%if(event != null){%>
var formObj = document.form;
formObj.vvd.value = "<%=event.getSearchTSBookingListConditionVO().getVvd()%>";
<%}%>
</script>