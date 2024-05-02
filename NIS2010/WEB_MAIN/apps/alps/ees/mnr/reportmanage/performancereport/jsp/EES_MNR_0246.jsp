<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0246.jsp
*@FileTitle : Disposal Performance by Buyer
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.02
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2010.11.02 장준우
* 1.0 Creation
*=======================================================
* 2010.12.06 남궁진호 [CHM-201007441-01]Performance 실적에 대한 팝업 Link
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.event.EesMnr0246Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0246Event  event = null;				//PDTO(Data Transfer Object including Parameters)
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


		event = (EesMnr0246Event)request.getAttribute("Event");
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
<title>Disposal Performance by Buyer</title>
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
<input type="hidden" name="p_rhq_cd">
<input type="hidden" name="p_ofc_cd">
<input type="hidden" name="p_disp_rsn_cd">
<input type="hidden" name="h_etc_params">
<input type="hidden" name="h_cust_cd">
<input type="hidden" name="h_vndr_nm">
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
					<td width="78">Office By</td>
					<td width="89" style="padding-left:2"><script language="javascript">ComComboObject('combo1',1, 88, 1,0);</script></td>
					<td><script language="javascript">ComComboObject('combo2',2, 247 , 0,0,'',0,'');</script></td>
				</tr>
				<tr class="h23">
					<td width="90">Disposal Kind</td>
					<td width="230" style="padding-left:2">
					<script language="javascript">ComComboObject('combo3', 1, 181, 1, 0);</script>
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
						<input type="text" name="p_cust_cd" caption="Buyer" style="width:65;text-align:center" class="input" dataformat="engup" maxlength="8">&nbsp;<img name="btns_search" src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
						<input type="text" name="p_vndr_nm" style="width:247" class="input2" readOnly="true">
					</td>
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
						<script language="javascript">ComSheetObject1('sheet1');</script>
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