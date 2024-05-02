<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0166.jsp
*@FileTitle : Disposal Performance by Equipment
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.11
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2010.11.11 장준우
* 1.0 Creation
*========================================================
* 2010.11.30 남궁진호 [CHM-201007327-01] Disposal Performance를 장비별 Detail 내역 조회 추가
*            searchDisposalPFMCByEqDetailListData
*========================================================
* 2011.09.27 허철용 [CHM-201109000-00] Disposal Performance 조회 조건/결과 추가 (Creation Date)
*            searchDisposalPFMCByEqDetailListData
* 2012.07.16 김창헌 [CHM-201218975-01] EQ TP/SZ 조건 추가
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.event.EesMnr0166Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0166Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();


		event = (EesMnr0166Event)request.getAttribute("Event");
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
<title>Disposal Performance by Equipment</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		}
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="p_disp_rsn_cd">
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">

		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->

		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;">
       	<tr><td class="btn1_bg">

		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
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
				</tr>
			</table>
		</td></tr>
		</table>
    	<!--Button (E) -->

		<!--biz page (S)-->
		<table class="search" id="mainTable">
       		<tr><td class="bg">

				<!--  biz  (S) -->
				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="90">Sold Period</td>
					<td width="230">
						<input type="text" name="p_str_evnt_dt" caption="Start Duration" style="width:70;text-align:center;ime-mode:disabled;" class="input1" value="" maxlength="8" dataformat="ymd" !cofield="p_end_evnt_dt">&nbsp;~
						<input type="text" name="p_end_evnt_dt" caption="End Duration" style="width:70;text-align:center;ime-mode:disabled;" class="input1" value="" maxlength="8" dataformat="ymd" !cofield="p_str_evnt_dt">
						<img class="cursor" src="img/btns_calendar.gif" name="btns_calendar" width="19" height="20" border="0" align="absmiddle">
					</td>
					<td width="90">EQ Type</td>
					<td width="140">
						<select name="p_eq_knd_cd" caption="EQ Type" style="width:90;" class="input1">
							<option value="U" selected>Container</option>
							<option value="Z">Chassis</option>
							<option value="G">M.G.Set</option>
	                    </select>
					</td>
					<td width="78">Location By</td>
					<td width="200" class="stm">
					<select name="p_loc_tp" style="width:65;" dataformat="engup">
						<option value="" selected>ALL</option>
			            <option value="RCC">RCC</option>
			            <option value="LCC">LCC</option>
			            <option value="SCC">SCC</option>
		            </select>
			        <input type="text" name="p_loc_cd" caption="Location" style="width:70;ime-mode:disabled;" value="" class="input2"  dataformat="engup" maxlength="5" readonly fullfill>
		            <img class="cursor" name="btns_search" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
					</td>
					<td style="text-align:right"><input type="checkbox" name="p_chk_usd" class="trans">Disposal USD Only&nbsp;&nbsp;</td>
				</tr>
				<tr class="h23">
					<td width="90">Disposal Kind</td>
					<td width="230" style="padding-left:2">
					<script language="javascript">ComComboObject('combo1', 1, 181, 1, 0);</script>
					</td>
					<td width="90">Disposal Type</td>
					<td width="140">
						<select name="p_disp_tp_cd" style="width:90;" class="input">
							<option value="" selected>ALL</option>
							<option value="C">Contract</option>
							<option value="B">Bidding</option>
	                    </select>
					</td>
					<td width="78">Buyer By</td>
					<td colspan="2">
						<input type="text" name="p_cust_cd" caption="Buyer" style="width:65;text-align:center" class="input" dataformat="engup" maxlength="8">&nbsp;<img name="btns_search2" src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
						<input type="text" name="p_vndr_nm" style="width:247" class="input2" readOnly="true">
					</td>
				</tr>
				<tr class="h23">
					<td width="90">Creation DT</td>
					<td width="230">
						<input type="text" name="p_str_cre_dt" caption="Start Duration11" style="width:70;text-align:center;ime-mode:disabled;" class="input" value="" maxlength="8" dataformat="ymd" !cofield="p_end_cre_dt">&nbsp;~
						<input type="text" name="p_end_cre_dt" caption="End Duration22" style="width:70;text-align:center;ime-mode:disabled;" class="input" value="" maxlength="8" dataformat="ymd" !cofield="p_str_cre_dt">
						<img class="cursor" src="img/btns_calendar.gif" name="btns_calendar2" width="19" height="20" border="0" align="absmiddle">
					</td>
					<td width="90">TP/SZ</td>
					<td width="140">
						&nbsp;<script language="javascript">ComComboObject('eq_tpsz_cd', 2, 123, 0);</script>
					</td>
					<td width="78"></td>
					<td width="200" class="stm">
					</td>
					<td ></td>
				</tr>
				</table>
				<!--  biz   (E) -->
		</td></tr></table>

		<table class="height_8"><tr><td></td></tr></table>
		<table class="search" id="mainTable">
       		<tr><td class="bg" style="height:427;" valign="top">


			<!-- Grid  (S) -->
			<table width="100%"  id="mainTable">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table>
			<!-- Grid (E) -->

			<!--  Button_Sub (S) -->
			<table width="100%" class="button">
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_DownExcel">Down Excel</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>

					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->

			</td></tr>
		</table>
		<!--biz page (E)-->

	</td></tr>
</table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>