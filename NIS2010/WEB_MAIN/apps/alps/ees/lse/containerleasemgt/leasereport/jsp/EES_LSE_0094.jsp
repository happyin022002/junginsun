<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_LSE_0094.jsp
*@FileTitle : Sub Lease Out Container Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.14
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.08.14 장준우
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
<%@ page import="com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport.event.EesLse0094Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesLse0094Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesLse0094Event)request.getAttribute("Event");
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
<title>Sub Lease Out Container Summary</title>
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
<!-- 개발자 작업	-->
<input type="hidden" name="lstm_cd">
<input type="hidden" name="cntr_tpsz_cd">
<input type="hidden" name="hcond_params">
<input type="hidden" name="hcond_lstm_cd">
<input type="hidden" name="hcond_tpsz_cd">
<input type="hidden" name="hcond_vndr_seq">
<input type="hidden" name="hcond_loc_cd">
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">

	</td></tr>
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


				<!--  biz  1(S) -->
				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="121"><input type="checkbox" name="total_flg" value="Y" class="trans">Summary Total</td>
					<td width="269" style="padding-left:0">
						<table class="search_sm2" border="0" style="width:240;">
							<tr class="h23">
								<td width="90"><input type="radio" name="lst_sts_flg" value="01" class="trans" checked> Inventory</td>
								<td width="" ><input type="radio" name="lst_sts_flg" value="02" class="trans"> Lease Out Result</td>
							</tr>
						</table>
					</td>
					<td width="60">CNTR STS</td>
					<td width="185" style="padding-left:2;">
						<select name="cntr_sts_cd" style="width:150;" class="input1">
							<option value="SBO" selected>Sub Lease Out</option>
							<option value="MUO">Mis Use Out</option>
							<option value="(SB|MU)O">Sub & Mis Use Out</option>
							<option value="SBI">Sub Lease In</option>
							<option value="MUI">Mis Use In</option>
							<option value="(SB|MU)I">Sub & Mis Use In</option>
						</select>
					</td>
					<td width="70">Own Ship</td>
					<td width="110">
						<select name="lstm_soc_tp" style="width:80;" class="input1">
							<option value="01">Incl SOC</option>
							<option value="02" selected>Excl SOC</option>
							<option value="03">SOC Only</option>
						</select>
					</td>
					<!--td width="70">Company</td>
					<td style="padding-left:2;">
						<select name="cntr_use_co_cd" style="width:80;" class="input">
							<option value="">All</option>
							<option value="H" selected>SML</option>
							<option value="D">SEN</option>
						</select>
					</td-->
				</tr>
				</table>
				<table class="line_bluedot"><tr><td></td></tr></table>
				<table class="search" border="0" style="width:979;">
					<tr class="h23">
					<td width="90">Out Location</td>
					<td width="300">
						<select name="loc_tp">
							<option value="0">All (by RCC)</option>
							<option value="1">All (by Country)</option>
							<option value="2">RCC (by LCC)</option>
							<option value="3">LCC (by SCC)</option>
							<option value="4">SCC (by Yard)</option>
							<option value="5">Country (by Country)</option>
	                    </select>
	                    <input type="text" name="loc_cd" caption="Out Location" style="width:98;text-align:center;" class="input2" value="" maxlength="5" dataformat="engup" readonly>&nbsp;<img class="cursor" src="img/btns_search.gif" name="btns_search" width="19" height="20" border="0" align="absmiddle">
					</td>
					<td width="60">Period</td>
					<td width="270" style="padding-left:2;">
						<input type="text" name="str_evnt_dt" caption="Start Duration" style="width:85;text-align:center;ime-mode:disabled;" class="input" value="" maxlength="8" dataformat="ymd" !cofield="end_evnt_dt">&nbsp; ~&nbsp;
						<input type="text" name="end_evnt_dt" caption="End Duration" style="width:85;text-align:center;ime-mode:disabled;" class="input" value="" maxlength="8" dataformat="ymd" !cofield="str_evnt_dt">
						<img class="cursor" src="img/btns_calendar.gif" name="btns_calendar" width="19" height="20" border="0" align="absmiddle"></td>

					<td width="70">Over</td>
					<td width="" style="padding-left:2;">
						<select name="use_day" style="width:85;" class="input">
							<option value="1">Free days</option>
							<option value="2" selected>Enter days</option>
						</select>
					</td>
					<td width="" class="stm" style="padding-left:2;"><input type="text" name="onh_free_dys" caption="Enter Days" style="width:50;text-align:right" value="" class="input" maxlength="4" dataformat="int"> days</td>
					</tr>

					<tr class="h23">
					<td width="90">Out AGMT No.</td>
					<td width="300">
						<input type="text" name="agmt_cty_cd" caption="AGMT No." style="width:40;text-align:center;" class="input2" value="HHO" readonly>&nbsp;<input type="text" caption="AGMT No." name="agmt_seq" style="width:56;" class="input" value="" maxlength="6" dataformat="int">&nbsp;<img class="cursor" src="img/btns_search.gif" name="btns_search2" width="19" height="20" border="0" align="absmiddle">
						<input type="text" name="ref_no" style="width:142" class="input2" readonly>
					</td>
					<td width="60">Lessee</td>
					<td width="" colspan="3" style="padding-left:2;">
						<input type="text" name="vndr_seq" caption="Lessee" style="width:85;text-align:center;" class="input" value="" maxlength="6" dataformat="int">&nbsp;<img class="cursor" src="img/btns_search.gif" name="btns_search3" width="19" height="20" border="0" align="absmiddle">
						<input type="text" name="vndr_abbr_nm" caption="Lessee" style="width:107;text-align:center;"  class="input2" value="" readonly>
						<input type="text" name="vndr_nm" caption="Lessor." style="width:199"  class="input2" value="" readonly></td>
					</tr>

					<tr class="h23">
					<td width="">Lease Term</td>
					<td width="" style="padding-left:2">
						<script language="javascript" >ComComboObject('combo1', 1, 269, 1);</script>
					</td>
					<td width="">TP/SZ</td>
					<td width="" style="padding-left:4">
						<script language="javascript" >ComComboObject('combo2', 1, 219, 1 );</script>&nbsp;
					</td>
					<!--td width="">Full & MTY</td>
					<td width="" style="padding-left:2;"><select name="cntr_full_flg" style="width:80;" class="input">
						<option value="" selected>All</option>
						<option value="Y">Full</option>
						<option value="N">MTY</option>
						</select></td-->
					</tr>
				</table>
			</td></tr>
		</table>
		<table class="height_8"><tr><td></td></tr></table>
		<table class="search" id="mainTable">
       		<tr><td class="bg">

				<!-- Grid  (S) -->
				<table width="100%" class="search"  id="mainTable">
					<tr>
						<td width="100%">
						<script language="javascript">ComSheetObject1('sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- Grid  (E) -->

				<!--  Button_Sub (S) -->
				<table width="100%" class="button">
		       	<tr><td class="btn2_bg">
					<table border="0" cellpadding="0" cellspacing="0">
					<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_DownExcel">Down Excel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>

						</tr></table>
				</td></tr>
				</table>
		    	<!-- Button_Sub (E) -->
			<table class="height_8"><tr><td></td></tr></table>
		<table class="line_bluedot"><tr><td></td></tr></table>


			<table width="100%">
    			<tr><td width="10">&nbsp;</td><td id="dcondTD" style="color:gray;">&nbsp;</td></tr>
    		</table>
			<!-- Grid  (S) -->
			<table width="100%"  id="sheetTable2">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet2');</script>
					</td>
				</tr>
			</table>
			<!-- Grid (E) -->

			<!--  Button_Sub (S) -->
			<table width="100%" class="button">
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_DownExcel2">Down Excel</td>
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

</td></tr>
		</table>
<table class="height_10"><tr><td></td></tr></table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>