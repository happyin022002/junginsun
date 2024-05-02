<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_lse_0046.jsp
*@FileTitle : Off Hire Plan Input and Update by RCC
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.07.03 노정용
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.event.EesLse0046Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesLse0046Event  event = null;        //PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;     //서버에서 발생한 에러
	String strErrMsg = "";            //에러메세지
	int rowCount   = 0;           //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id    = "";
	String strUsr_nm    = "";
	String strCntrTpSzCd    = "";
	Logger log = Logger.getLogger("com.hanjin.apps.ContainerLeaseMgt.LeasePlan");

	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EesLse0046Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		strCntrTpSzCd = (String)eventResponse.getCustomData("cntr_tpsz_cd");
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Off Hire Plan Input and Update by RCC</title>
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
<!-- 개발자 작업  -->
<input type="hidden" name="offh_ver_seq" value="1">
<input type="hidden" name="offh_pln_tp_cd" value="O">
<input type="hidden" name="offh_loc_tp_cd" value="R">
<input type="hidden" name="lstm_cd" value="LT">
<input type="hidden" name="cntr_tpsz_cd" value="<%= strCntrTpSzCd %>">
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr>
		<td valign="top">
			<!--Page Title, Historical (S)-->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
			<!--Page Title, Historical (E)-->

			<table class="search">
				<tr>
					<td class="bg">
						<!--  biz_1  (S) -->
						<table class="search" border="0" style="width:979;">
							<tr class="h23">
								<td width="120">Plan Year & Month</td>
								<td width="130">
									<input type="text" name="offh_yrmon" caption="Plan YYYYMM" style="width:60;text-align:center;" class="input1" value="" maxlength="6" dataformat="ym" required fullfill>
									<img class="cursor" src="img/btns_calendar.gif" name="btns_calendar" width="19" height="20" border="0" align="absmiddle">
								</td>
								<td width="30">RCC</td>
								<td width="190">
									<script language="javascript">ComComboObject('offh_rgn_loc_cd', 1, 150, 0, 1);</script>
									<!-- <input type="checkbox" name="chk_offh_rgn_loc_cd" class="trans"> -->
								</td>
								<td width="35">Term</td>
								<td width="320">
									<input type="text" style="width:50;text-align:center;" class="input2" value="ALL" readonly>
								</td>
								<td width="50">User ID</td>
								<td width="">
									<input type="text" style="width:80;text-align:center;" class="input2" value="<%= strUsr_id %>" readonly>
								</td>
							</tr>
						</table>
						<!--  biz_2  (E) -->
					</td>
				</tr>
			</table>	
			<table class="height_8"><tr><td></td></tr></table>	
			<table class="search" id="mainTable"> 
				<tr>
					<td class="bg" style="height:467;" valign="top">
	
						<!-- Grid  (S) -->
						<table width="100%" class="search" id="sheetTable">
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject1('sheet1');</script>
								</td>
							</tr>
						</table>
						<!-- Grid  (E) -->

						<!--  Button_Sub (S) -->
						<table width="100%" class="button">
							<tr>
								<td class="btn2_bg">
									<table border="0" cellpadding="0" cellspacing="0">
										<tr>
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td>
											<td class="btn2" name="btns_DownExcel">Down&nbsp;Excel</td>
											<td class="btn2_right"></td></tr>
											</table></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
						<!-- Button_Sub (E) -->
					</td></tr>
				</table>
			<!-- Tab BG Box  (S) -->
			<!--biz page (E)-->
			<!--Button (S) -->
				<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;">
					<tr>
						<td class="btn1_bg">
							<table border="0" cellpadding="0" cellspacing="0">
								<tr>
									<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn1_left"></td>
										<td class="btn1" name="btn_DOL">DOL</td>
										<td class="btn1_right"></td>
										</tr>
									</table></td>
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn1_left"></td>
										<td class="btn1" name="btn_AvailOffHireUnits">Available Off-Hire Units</td>
										<td class="btn1_right"></td>
										</tr>
									</table></td>
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn1_left"></td>
										<td class="btn1" name="btn_OffHirePFMC">Off-Hire PFMC</td>
										<td class="btn1_right"></td>
										</tr>
									</table></td>
									<td class="btn1_line"></td>
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn1_left"></td>
										<td class="btn1" name="btn_Retrieve">Retrieve</td>
										<td class="btn1_right"></td>
										</tr>
									</table></td>
									<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn1_left"></td>
										<td class="btn1" name="btn_New">New</td>
										<td class="btn1_right"></td>
										</tr>
									</table></td>
									<td class="btn1_line"></td>
									<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn1_left"></td>
										<td class="btn1" name="btn_Save">Save</td>
										<td class="btn1_right"></td>
										</tr>
									</table></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			<!--Button (E) -->
		</td>
	</tr>
</table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>