<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_LEA_0001.jsp
*@FileTitle : Expense Accrual Batch Main
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchmanage.event.EsdLea0001Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdLea0001Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//The count of DB ResultSet list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.LogisticsExpenseAccrual.AccrualBatchManage");

	String nowYYMM = "";
	
	try {
		event = (EsdLea0001Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		nowYYMM = DateTime.addMonths(JSPUtil.getKST("yyyy-MM"),-1,"yyyy-MM");

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<html>
<head>
<title>Expense Accrual Batch Main</title>
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


<input type="hidden" name="iPage">
<input type="hidden" name="frm_vvd_no">

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>

	<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
	<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
	<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
	</table>
	<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->

	<!--Button_L (S) -->
	<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
	<tr><td class="btn1_bg">
		<table border="0" cellpadding="0" cellspacing="0">
		<tr>
		<!-- Repeat Pattern -->
		<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
			<tr><td class="btn1_left"></td><td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
		<td class="btn1_line"></td>
		<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
			<tr><td class="btn1_left"></td><td class="btn1" id="btn_batchstart" name="btn_batchstart">Batch Start</td><td class="btn1_right"></td></tr></table></td>
		<!-- Repeat Pattern -->
		</tr></table>
	</td></tr>
	</table>
	<!--Button_L (E) -->

	<!-- TABLE '#D' : ( Search Options ) (S) -->
	<table class="search">
	<tr><td class="bg">

		<!-- : ( Year ) (S) -->
		<table class="search_in" border="0">
		<tr class="h23">
			<td width="110">Exe. Year-Month</td>
			<td><input type="text" class="input1" style="width:60;" name="frm_exe_yrmon"  valid="1" desc= "Exe. Year-Month" value="<%=nowYYMM%>" onKeyUp="lea_comm_isNumberMessage(this,6);" onKeyDown="lea_com_enterKeyEvent('lea_enterRetrieve')" onBlur="lea_com_convertYymm(this);" ></td></tr>
		</table>
		<!-- : ( Year ) (E) -->

	</td></tr>
	</table>
	<!-- TABLE '#D' : ( Search Options ) (E) -->

	<table class="height_10"><tr><td></td></tr></table>
	
	<!-- TABLE '#D' : ( Search Options ) (S) -->
	<table class="search">
	 	<tr><td class="bg">
			<table class="search" border="0">
			<tr><td class="title_h"></td>
				<td class="title_s">Checking Conditions</td></tr>
			<tr><td class="height_5"></td></tr>
			</table>

			<!-- : ( Seq. ) (S) -->
			<table style="width:979;" border="0" class="grid2">
			<tr class="tr2_head">
				<td>Seq.</td>
				<td>Checking Items</td>
				<td colspan="2">Status</td></tr>
	
			<tr><td width="80" align="center">1</td>
				<td width="320" align="center">A/P Closing</td>
				<td width="230" style="padding-left:70;"><input type="text" class="input2"  name="frm_ap_clz_flg_nm" style="width:140" readonly></td>
				<td rowspan="3" align="center">
	
					<table border="0" cellpadding="0" cellspacing="0" style="border:1px solid white;">
					<tr>
						<!-- Repeat Pattern -->
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left" style="padding:0; border:0;"></td>
							<td class="btn2" id="btng_confirm" name="btng_confirm" style="padding:0; border:0;">Confirm</td>
							<td class="btn2_right" style="padding:0; border:0;"></td></tr></table></td>
						<!-- Repeat Pattern -->
					</tr></table>
				</td>
			</tr>
			<tr><td align="center">2</td>
				<td align="center">Rev. VVD Interface</td>
				<td style="padding-left:70;"><input type="text" class="input2"  name="frm_rev_vvd_if_flg_nm" style="width:140" readonly>&nbsp;<img class="cursor" src="/opuscntr/img/button/btns_search.gif" name="btns_rev_vvd_search" width="19" height="20" border="0" align="absmiddle"></td>
			</tr>
			<tr><td align="center">3</td>
				<td align="center">Currency Interface</td>
				<td style="padding-left:70;"><input type="text" class="input2"  name="frm_mon_avg_xch_rt_if_flg_nm" style="width:140" readonly></td>
			</tr>
			</table>
			<!-- : ( Seq. ) (E) -->

			<table class="height_10"><tr><td></td></tr></table>
			
			<!-- : ( Input ) (S) -->
			<table style="width:979" class="search">
			<tr><td><input type="text" class="transgray"  name="frm_erp_if_flg_desc" style="width:100%;" readonly></td></tr>
			</table>
			<!-- : ( Input ) (E) -->

		</td></tr>
	</table>
	<!-- TABLE '#D' : ( Search Options ) (E) -->

</td></tr>
</table>
<!-- Outer Table (E)-->

<div id="hidden_sheets1" style="display:none">
<table width="100%"  id="mainTable">
	<tr><td>
		<script language="javascript">ComSheetObject('t1sheet1');</script>
	</td></tr>
</table>
</div>


</form>
</body>
</html>