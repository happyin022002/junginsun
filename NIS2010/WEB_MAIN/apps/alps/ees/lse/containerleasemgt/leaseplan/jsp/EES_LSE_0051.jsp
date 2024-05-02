<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_lse_0051.jsp
*@FileTitle : Off Hire Plan and Performance
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.16
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.07.16 노정용
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
<%@ page import="com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.event.EesLse0051Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesLse0051Event  event = null;        //PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;     //서버에서 발생한 에러
	String strErrMsg = "";            //에러메세지
	int rowCount   = 0;           //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id    = "";
	String strUsr_nm    = "";
	Logger log = Logger.getLogger("com.hanjin.apps.ContainerLeaseMgt.LeasePlan");

	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EesLse0051Event)request.getAttribute("Event");
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
<input type="hidden" name="offh_yrmon">
<input type="hidden" name="offh_loc_tp_cd">
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr>
		<td valign="top">
			<!--Page Title, Historical (S)-->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
			<!--Page Title, Historical (E)-->
	<!--Button (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:;,padding-bottom:2;"> 
       			<tr>
       				<td class="btn1_bg">
					    <table border="0" cellpadding="0" cellspacing="0">
						    <tr>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Retrieve">Retrieve</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_New">New</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
    		<!--Button (E) -->
			<table class="search"> 
	       		<tr>
	       			<td class="bg">
						<!--  biz_1  (S) -->
						<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
								<td width="320">
									<table border="0" style="width:250;" class="search_sm2"> 
										<tr class="h23">
											<td width="70">Plan Type</td>
											<td class="stm" align="center">
												<input type="radio" name="offh_pln_tp_cd" value="B" class="trans" checked>&nbsp;Basic&nbsp;&nbsp;&nbsp;&nbsp;
												<input type="radio" name="offh_pln_tp_cd" value="O" class="trans" >&nbsp;Operation&nbsp;&nbsp;&nbsp;&nbsp;
											</td>
										</tr>
									</table>
								</td>
								<td width="70">Period</td>
								<td width="">
									<input type="text" name="from_offh_yrmon" caption="From Period" style="width:58;text-align:center;" value="" class="input1" maxlength="6" dataformat="ym" !cofield="to_offh_yrmon"   required>
									<img class="cursor" src="img/btns_calendar.gif" name="btns_calendar1" width="19" height="20" border="0" align="absmiddle">
									~
									<input type="text" name="to_offh_yrmon"   caption="To Period"   style="width:58;text-align:center;" value="" class="input1" maxlength="6" dataformat="ym" !cofield="from_offh_yrmon" required>
									<img class="cursor" src="img/btns_calendar.gif" name="btns_calendar2" width="19" height="20" border="0" align="absmiddle">
								</td>
							</tr></table> 						
							<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
								<td width="70">&nbsp;Location</td>
								<td width="250">
									<script language="javascript">ComComboObject('loc_tp', 1, 50, 0);</script>&nbsp;<input type="text" name="loc_cd" caption="Delivery LOC." style="width:50;text-align:center;" class="input" dataformat="engup" maxlength="5" fullfill>
									<img src="img/btns_search.gif" name="btns_search1" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
								</td>
								<td width="70">Lease Term</td>
								<td width="260" style="padding-left:2">
									<script language="javascript">ComComboObject('lstm_cd', 1, 55, 0);</script>
								</td>
								<td width="50">TP/SZ</td>
								<td width="">
									<script language="javascript">ComComboObject('cntr_tpsz_cd', 1, 180, 0);</script>
									<!--<input type="checkbox" name="chk_cntr_tpsz_cd" class="trans">-->
								</td>
							</tr>
						</table>
						<!--  biz_1  (E) -->
					</td>
				</tr>
			</table>
			<table class="height_8"><tr><td></td></tr></table>
			<table class="search" id="mainTable"> 
				<tr>
					<td class="bg" style="height:425;" valign="top">	
						<!-- Grid  (S) -->
						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet1');</script>
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
											<td class="btn2" name="btn_DownExcel">Down&nbsp;Excel</td>
											<td class="btn2_right"></td></tr>
											</table></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
						<!-- Button_Sub (E) -->
					</td>
				</tr>
			</table>
		
		</td>
	</tr>
</table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>