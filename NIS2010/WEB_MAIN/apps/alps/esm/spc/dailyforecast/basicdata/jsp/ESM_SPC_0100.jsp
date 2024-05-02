<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0100.jsp
*@FileTitle : ESM_SPC_0100
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.22
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.07.22 한상훈
* 1.0 Creation
* 2011.09.22 김종준 [CHM-201113515-01] SPC내에서 사용하고 있는 Tag Library 제거 작업
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.spc.dailyforecast.basicdata.event.EsmSpc0100Event"%>
<%@ page import="org.apache.log4j.Logger" %>


<%
	EsmSpc0100Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.DailyForecast.BasicData");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmSpc0100Event)request.getAttribute("Event");
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
<title>ESM_SPC_0100</title>
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


<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
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
									<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve" alt="Alt+R">Retrieve</td><td class="btn1_right"></td></tr></table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_new" alt="Alt+N">New</td><td class="btn1_right"></td></tr></table></td>

								<td class="btn1_line"></td>

								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td><td class="btn1" name="btn_save" id="btn_save" alt="Alt+S">Save</td><td class="btn1_right"></td></tr></table></td>



								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td><td class="btn1" name="btn_rowadd" id="btn_rowadd">Row Add</td><td class="btn1_right"></td></tr></table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
								<!-- Repeat Pattern -->

							</tr></table>

					</td></tr>
				</table>
    	<!-- TABLE '#D' : ( Button : Main ) (E) -->

	 	<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<!-- : ( Year ) (S) -->
				<table class="search_in" border="0">
				<tr class="h23">
				    <td width="85"><img class="nostar">Week</td>
					<td width="140">
						<select class="input1" name="year" style="width:60;" onchange="checkWeek();"></select>
						<select class="input1" name="week" style="width:40;"></select>
					</td>

					<td width="75"><img class="nostar">RHQ</td>
					<td width="130">
						<script language="JavaScript">ComComboObject("rhq", 2, 70, 0, 1);</script>
					</td>

					<td width="45"><img class="nostar">VVD</td>
					<td><input type="text" style="width:85;ime-mode:disabled;" name="vvd" value="" maxlength="9" onkeypress="eventKeyChangeChar(UPPER_CASE);"onchange="checkValue('vvd');"></td>
				</tr>
				<tr class="h23">
					<td width="85"><img class="nostar">Rep. Trade</td>
					<td width="140" style="padding-left:2px;">
						<script language="JavaScript">ComComboObject("trade", 2, 104, 0, 1);</script>
					</td>

					<td width="75"><img class="nostar">SubTrade</td>
					<td width="130">
						<script language="JavaScript">ComComboObject("subtrade", 3, 70, 0, 0);</script>
					</td>

					<td width="45"><img class="nostar">Lane</td>
					<td width="130" style="padding-left:2px;">
						<script language="JavaScript">ComComboObject("lane", 4, 85, 0, 0);</script>
					</td>

					<td width="60"><img class="nostar">Bound</td>
					<td width="140">
						<select name="bound" style="width:50;"></select>
					</td>

					<td width="90"><img class="nostar">OCN/IPC/TS</td>
					<td>
						<select name="ocnipc" style="width:75;"></select>
					</td>
				</tr>

				</table>
				<!-- : ( Year ) (E) -->
			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->
		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Tab ) (S) -->
		<table class="tab">
           	<tr><td><script language="javascript">ComTabObject('tab1')</script></td></tr>
		</table>

		<!-- UI_ESM_SPC_028 : THIS IS 1st TAB -->
<div id="tabLayer" style="display:inline">

		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<table class="height_5"><tr><td></td></tr></table>

			<!-- 	<table class="" border="0" width="100%">
				<tr class="h23">
					<td>(WK <span id="sheet1_wk"></span>)</td>
					<td align="right">(Unit : TEU)</td>
					</tr>
				</table>
            -->
				<!-- : ( POR ) (S) -->

					<table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('t1sheet1');</script>
                        </td></tr>
		            </table>


				<!-- : ( POR ) (E) -->




			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

</div>

<!-- UI_ESM_SPC_028_T2 : THIS IS 2st TAB -->
<div id="tabLayer" style="display:none">

		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<table class="height_5"><tr><td></td></tr></table>

				<table class="" border="0" width="100%">

				</table>


				<!-- : ( POR ) (S) -->

					<table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('t2sheet2');</script>
                        </td></tr>
		            </table>


				<!-- : ( POR ) (E) -->


			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

</div>


</td></tr>
</table>
<!-- Outer Table (E)-->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>