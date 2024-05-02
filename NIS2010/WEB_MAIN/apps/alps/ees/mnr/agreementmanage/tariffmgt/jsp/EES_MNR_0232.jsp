<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0232.jsp
*@FileTitle : Disposal Tariff Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.27
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2010.09.27 장준우
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
<%@ page import="com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.event.EesMnr0232Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0232Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();


		event = (EesMnr0232Event)request.getAttribute("Event");
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
<title>Disposal Tariff Inquiry</title>
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
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">

		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->

		<!--biz page (S)-->
		<table class="search" id="mainTable">
       		<tr><td class="bg">

				<!--  biz  (S) -->
				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="160">Effective Year/Quarter</td>
					<td width="90"><input type="text" name="p_trf_eff_yr" caption="Effective Year" style="width:60;text-align:center;ime-mode:disabled;" class="input1" value="" maxlength="4" dataformat="int" required fullfill>&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar1"></td>
					<td width="180">
						<select name="p_trf_eff_qtr_no" caption="Effective Quarter" style="width:90;">
							<option value="">ALL</option>
							<option value="1">1/4 QTA</option>
							<option value="2">2/4 QTA</option>
							<option value="3">3/4 QTA</option>
							<option value="4">4/4 QTA</option>
	                    </select>
					</td>
					<td width="70">EQ Type</td>
					<td width="200">
						<select name="p_eq_knd_cd" caption="EQ Type" style="width:90;" class="input1">
							<option value="U" selected>Container</option>
							<option value="Z">Chassis</option>
							<option value="G">M.G.Set</option>
	                    </select>
					</td>
					<td width="85">Location By</td>
					<td width="300">
						<select name="p_loc_tp">
							<option value="0">ALL (by RCC)</option>
							<option value="1">RCC (by LCC)</option>
							<option value="2">LCC (by SCC)</option>
	                    </select>
	                    <input type="text" name="p_loc_cd" caption="Location" style="width:60;text-align:center;ime-mode:disabled;" class="input2" value="" maxlength="5" dataformat="engup" readonly>&nbsp;<img class="cursor" src="img/btns_search.gif" name="btns_search" width="19" height="20" border="0" align="absmiddle">
					</td>
					</tr>
				</table>
				<!--  biz   (E) -->
		</td></tr></table>

		<table class="height_8"><tr><td></td></tr></table>

			<!-- Tab (S) -->
   		<table class="tab" border="0" cellpadding="0" cellspacing="0" width="100%">
     		<tr><td width="100%">
					<script language="javascript">ComTabObject('tab1')</script>
					<!-- img src="img/sub_tab.gif" alt="" width="998" height="23" border="0" -->
				</td></tr>
			</table>
			<!-- Tab (E) -->

			<!--TAB CNTR (S) -->
			<div id="tabLayer" style="display:inline">
				<table class="search" id="mainTable">
	       		<tr><td class="bg">
				<!-- Grid  (S) -->
				<table width="100%" id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t1sheet1');</script>
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
						<td class="btn2" name="btn_DownExcel1">Down Excel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						</tr></table>
				</td></tr>
				</table>
		    	<!-- Button_Sub (E) -->
				</td></tr></table>
			</div>
			<!--TAB CNTR (E) -->

			<!--TAB CHSS (S) -->
			<div id="tabLayer" style="display:none">
				<table class="search" id="mainTable">
	       		<tr><td class="bg">
				<!-- Grid  (S) -->
				<table width="100%" id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t2sheet1');</script>
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
						<td class="btn2" name="btn_DownExcel2">Down Excel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						</tr></table>
				</td></tr>
				</table>
		    	<!-- Button_Sub (E) -->
				</td></tr></table>
			</div>
			<!--TAB CHSS (E) -->

			<!--TAB CHSS (S) -->
			<div id="tabLayer" style="display:none">
				<table class="search" id="mainTable">
	       		<tr><td class="bg">
				<!-- Grid  (S) -->
				<table width="100%" id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t3sheet1');</script>
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
						<td class="btn2" name="btn_DownExcel3">Down Excel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						</tr></table>
				</td></tr>
				</table>
		    	<!-- Button_Sub (E) -->
				</td></tr></table>
			</div>
			<!--TAB CHSS (E) -->

			<!--TAB CHSS (S) -->
			<div id="tabLayer" style="display:none">
				<table class="search" id="mainTable">
	       		<tr><td class="bg">
				<!-- Grid  (S) -->
				<table width="100%" id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t4sheet1');</script>
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
						<td class="btn2" name="btn_DownExcel4">Down Excel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						</tr></table>
				</td></tr>
				</table>
		    	<!-- Button_Sub (E) -->
				</td></tr></table>
			</div>
			<div style="display:none">
				<script language="javascript">ComSheetObject('t5sheet1');</script>
			</div>
			<!--TAB CHSS (E) -->

		<!--biz page (E)-->

		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;">
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

	</td></tr>
</table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>