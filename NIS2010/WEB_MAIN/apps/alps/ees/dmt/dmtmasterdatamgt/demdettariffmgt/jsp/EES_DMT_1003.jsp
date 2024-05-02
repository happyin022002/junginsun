<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_1003.jsp
*@FileTitle : Basic Tariff Summary Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.05.20 김태균
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
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.event.EesDmt1003Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EesDmt1003Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.DMTMasterDataMgt.DemDetTariffMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesDmt1003Event)request.getAttribute("Event");
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
<title>Basic Tariff Summary Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	<%= JSPUtil.getIBCodeCombo("f_dmdt_de_term_cd" , "", "CD03257", 0, "")%>
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>
<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows"> 
<input type="hidden" name="cnt_cd">
<input type="hidden" name="conti_cd">
<input type="hidden" name="svr_id">
<input type="hidden" name="dmdt_trf_cd_list">
<input type="hidden" name="dmdt_trf_cd_in"> 
<input type="hidden" name="dmdt_de_term_cd">
<input type="hidden" name="dmdt_de_term_nm">

<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	style="padding-top: 2; padding-left: 5;">

	<tr>
		<td valign="top"><!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr>
				<td class="history"><img src="img/icon_history_dot.gif"	align="absmiddle"><span id="navigation"></span></td>
			</tr>
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif"	align="absmiddle"><span id="title"></span></td>
			</tr>
		</table>
		<!--Page Title, Historical (E)-->


		<table class="search">
			<tr>
				<td class="bg">
				<div id="showMin" style="display: inline"><!--  biz_1  (S) -->
				<table class="search" border="0" style="width: 884;">
					<tr class="h23">
						<td width="80">&nbsp;&nbsp;RHQ</td>
						<td width="88" style="padding-left:2"><select name="rhqCd" style="width:75;"
							class="input1" onchange="searchCountryByRHQ()">
							&nbsp;
							<option value="" selected>All</option>
							<option value="USA">NYCRA</option>
							<option value="EUR">HAMRU</option>
							<option value="CHN">SHARC</option>
							<option value="KOR">SELIB</option>
							<option value="JPN">TYOIB</option>
							<option value="SWA">SINRS</option>
							<option value="VVO">VVOIA</option>
						</select></td>
						<td width="116">Coverage Country</td>
						<td width="80">&nbsp;<script language="javascript">ComComboObject('combo1', 2, 58 , 0)</script></td>
						<td width="110">Origin/Destination</td>
						<td width="80">&nbsp;<script language="javascript">ComComboObject('combo2', 2, 60 , 0)</script></td>
						<td width="195">BKG Term&nbsp;<script language="javascript">ComComboObject('combo3', 2, 60, 1, 1, 0, true);</script></td></tr>
					
					</tr>
					<tr class="h23">
						<td width="">&nbsp;&nbsp;Tariff Type</td>
						<td width="" colspan="5">&nbsp;<script language="javascript">ComComboObject('combo4', 2, 299 , 0, 1)</script>&nbsp;<img	src="img/btns_multisearch.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
					</tr>
				</table>
				<table class="search_sm2" border="0" style="width: 388;">
					<tr class="h23">
						<td width="80">&nbsp;Group Type</td>
						<td width="100" class="stm"><input type="checkbox" name="dmdt_trf_grp_tp_cd1" value="B" class="trans" checked>&nbsp;Billable</td>
						<td width="100" class="stm"><input type="checkbox" name="dmdt_trf_grp_tp_cd2" value="N" class="trans" checked>&nbsp;Exempted</td>
						<td width="" colspan="2"></td>
					</tr>
				</table>
				<table class="height_2">
					<tr>
						<td></td>
					</tr>
				</table>
				<table class="search_sm2" border="0" style="width: 388;">
					<tr class="h23">
						<td width="80">&nbsp;Validity</td>
						<td width="100" class="stm"><input type="checkbox" name="validity1" value="Y" class="trans" checked>&nbsp;Current</td>
						<td width="100" class="stm"><input type="checkbox" name="validity2" value="Y" class="trans" checked>&nbsp;To-be</td>
						<td width="" class="stm" colspan="2"><input type="checkbox"	name="validity3" value="Y" class="trans">&nbsp;Expired</td>
					</tr>
				</table>
				<!--  biz_1  (E) --></div>

				<!--  biz_2  (S) --> <!--  biz_2   (E) --> <!-- Grid  (S) -->
				<table width="100%" id="mainTable">
					<tr>
						<td width="100%"><script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>




				<!-- : ( Search Options ) (E) --></td>
			</tr>
		</table>
		<!-- Tab BG Box  (S) --> <!--biz page (E)--> <!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0"
			cellspacing="0" style="padding-top: 5; , padding-bottom:0;">
			<tr>
				<td class="btn1_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" id="btn_retrieve" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_new">New</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td class="btn1_line"></td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_minimize" id="btn_minimize">Minimize</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_downexcel">Down Excel</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		<!--Button (E) --></td>
	</tr>
</table>


<!-- 개발자 작업  끝 --></form>
</body>
</html>