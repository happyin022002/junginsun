<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CTM_0460.jsp
*@FileTitle : VL/VD update status
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 우경민
*@LastVersion : 1.0
* 2009.09.25 우경민
* 1.0 Creation
* --------------------------------------------------------
* History
* 2013.07.02 김상수 [CHM-201325058-01] BKG/MVMT VL/VD unmatch Inquiry 기준 값 변경(Yard ->Location)
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.event.EesCtm0460Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesCtm0460Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.EquipmentMovementMgt.LongTxContainerMovementFinder");
	// 현재날짜
	String strEnddate = DateTime.getFormatDate(new java.util.Date(), "yyyy-MM-dd");
	// 7일 이전날짜
	String strStartdate = DateTime.addDays(strEnddate, -6, "yyyy-MM-dd");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesCtm0460Event)request.getAttribute("Event");
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
<title>VL/VD update status</title>
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

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="backendjob_key">
<!-- 개발자 작업	-->


<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	</td></tr>
	<tr><td valign="top">

      <!-- Page Title, Historical (S) -->
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
      </table>
      <!-- Page Title, Historical (E) -->


	<!--biz page (S)-->
		<table class="search">
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="70">ETA / ETD</td>
					<td><input type="text" style="width:80;ime-mode:disabled;" class="input1" value="<%=strStartdate%>" tabindex="1" name="p_date1">&nbsp;~&nbsp;
									<input type="text" style="width:80;ime-mode:disabled;" class="input1" value="<%=strEnddate%>" tabindex="2" name="p_date2">&nbsp;<img src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_Calendar2"></td>
					<td align="right">Status</td>
					<td><select style="width:55;" class="input" name="p_status" tabindex="3">
						<option value="VL" selected>VL</option>
						<option value="VD">VD</option>
						</select></td>
					<td align="right">Trunk/Feeder</td>
					<td><select style="width:60;"class="input" name="p_vsl_svc_tp_cd" tabindex="4">
						<option value="T" selected>Trunk</option>
						<option value="F">Feeder</option>
						</select></td>
					<td><input type="radio" class="trans" name="sel_port" value="PORT" checked>Port&nbsp;<input type="text" style="width:55;" class="input1" maxlength="5" tabindex="5" name="p_yard1">&nbsp;
					&nbsp;<input type="radio" name="sel_port" value="AREA" class="trans">Area
					&nbsp;<SELECT name="area_cd" class="input">
							<OPTION  value="KOR"> KR / JP</OPTION>
							<OPTION  value="CHN"> CHN</OPTION>
							<OPTION  value="SWA"> SWA</OPTION>
							<OPTION  value="EUR"> EUR</OPTION>
							<OPTION  value="USA"> USA</OPTION>
						</SELECT></td>
				</tr>
				<tr class="h23">
					<td>VVD Code</td>
					<td><input type="text" style="width:80;" class="input" index="7" name="p_vvd" maxlength="9"></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td><input type="checkbox" name="restuff" value="Y" class="trans" checked>Restuffing&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="checkbox" name="ttl" value="Y" class="trans" checked>TTL</td>
				</tr>

				</table>
				<!--  biz_1   (E) -->


				<table class="line_bluedot"><tr><td></td></tr></table>

				<!--  biz_2  (S) -->

				<!-- Grid  (S) -->
						<table width="100%"  id="mainTable">
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table>
				<!-- Grid (E) -->



				<!--  biz_2   (E) -->
				</td></tr>
			</table>

	<!--biz page (E)-->


	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;">
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left">
					<td class="btn1" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right">
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Detl">Detail</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->

		</td></tr>
		</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>