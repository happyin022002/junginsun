<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_lse_0004.jsp
*@FileTitle : Agreement List
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.29
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.04.27 노정용
* 1.0 Creation
=========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.event.EesLse0004Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EesLse0004Event event           = null;		//PDTO(Data Transfer Object including Parameters)
	Exception       serverException = null;		//서버에서 발생한 에러
	String          strErrMsg       = "";		//에러메세지

	String successFlag = "";
	String codeList    = "";
	String pageRows    = "100";

	String strUsr_id     = "";
	String strUsr_nm     = "";
	String strCntrTpSzCd = "";
	String strCurYear    = "";
	String strCurMonth   = "";
	Logger log = Logger.getLogger("com.hanjin.apps.containerleasemgt.leaseplan");

	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		
		
		strCurYear  = ""+DateTime.getYear();
		strCurMonth = ""+DateTime.getMonth(); //JSPUtil.getLPAD(""+DateTime.getMonth(), 2, "0");

		event           = (EesLse0004Event)request.getAttribute("Event");
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
<title>Long Term Lease CNTR Delivery Plan</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
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
<input type="hidden" name="org_cntr_tpsz_cd" value="<%= strCntrTpSzCd %>">
<input type="hidden" name="cur_year"  value="<%= strCurYear %>">
<input type="hidden" name="cur_month" value="<%= strCurMonth %>">
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr>
		<td valign="top">
			<!--Page Title, Historical (S)-->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
			<!--Page Title, Historical (E)-->
<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
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
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
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
			<!--biz page (S)-->
			<table class="search" id="mainTable"> 
       			<tr>
       				<td class="bg">
						<!--  biz  (S) -->
						<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
								<td width="110">&nbsp;Expired Date</td>
								<td width="380">
									<input type="text" name="exp_from_dt" caption="From Expired Date" style="width:75;text-align:center;" class="input1" value="" maxlength="8" dataformat="ymd" cofield="exp_to_dt"   required>
									~
									<input type="text" name="exp_to_dt"   caption="To Expired Date"   style="width:75;text-align:center;" class="input1" value="" maxlength="8" dataformat="ymd" cofield="exp_from_dt" required>
									<img class="cursor" src="img/btns_calendar.gif" name="btns_calendar1" width="19" height="20" border="0" align="absmiddle" dataformat="ymd">
								</td>
								<td width="70">Lessor</td>
								<td width="">
									<input type="text" name="vndr_seq" caption="Lessor" style="width:55;text-align:center;" class="input" value="" dataformat="int" maxlength="6">
									<img class="cursor" src="img/btns_search.gif" name="btns_search" width="19" height="20" border="0" align="absmiddle">
									<input type="text" name="vndr_nm" caption="Lessor" style="width:270;" class="input2" value="" readonly>
								</td>
							</tr>
							<tr class="h23">
								<td>&nbsp;Lease Term</td>
								<td>
									<script language="javascript">ComComboObject('lstm_cd', 1, 220, 0, 1);</script>
								</td>
								<td>Office</td>
								<td>
									<input type="text" name="ofc_cd" caption="Office" style="width:55;text-align:center;" class="input" value="" dataformat="engup" maxlength="5">
									<img class="cursor" src="img/btns_search.gif" name="btns_search1" width="19" height="20" border="0" align="absmiddle">
								</td>
							</tr>
						</table>			
						<!--  biz (E) -->
					</td>
				</tr>
			</table>
			<table class="height_8"><tr><td></td></tr></table>
			<table class="search" id="mainTable">
				<tr>
					<td class="bg">
						<!-- Grid  (S) -->
						<table width="100%" id="sheetTable">
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table>
						<!-- Grid (E) -->

						<!--  Button_Sub (S) -->
						<table width="100%" class="button"> 
				       		<tr>
				       			<td class="btn2_bg">
									<table border="0" cellpadding="0" cellspacing="0">
										<tr>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn_DownExcel">Down Excel</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
				    	<!-- Button_Sub (E) -->
					</td>
				</tr>
			</table>
			<!--biz page (E)-->
		</td>
	</tr>
</table>

<!--Button (E) -->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>