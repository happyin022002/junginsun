<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_LSE_0022.jsp
*@FileTitle :Off-Hire Confirm from Lessor
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.09
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.10.09 장준우
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
<%@ page import="com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.event.EesLse0022Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesLse0022Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strCur_dt		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EesLse0022Event)request.getAttribute("Event");
		strCur_dt = EesLse0022Event.getCurrentDate("yyyy-MM-dd");
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
<title>Available Off Hire Q'ty List</title>
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
<input type="hidden" name="complex_pk">
<input type="hidden" name="lstm_cd">
<input type="hidden" name="cntr_tpsz_cd">
<input type="hidden" name="cnmv_sts_cd">
<input type="hidden" name="backendjob_key">
<input type="hidden" name="h_curr_dt" value="<%= strCur_dt %>">
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--top menu (S)-->

		<!--top menu (E)-->
	</td></tr>


	<tr><td valign="top">
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->

		<table class="search">
       		<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="80">Division</td>
					<td width="170">
						<select name="loc_case" style="width:85;">
							<option value="0">ALL</option>
							<option value="1" selected>Location</option>
							<option value="2">Port</option>
							<option value="3">CNTR No.</option>
	                    </select>
					</td>
					<td width="68">Location</td>
				    <td width="51">
						<select name="loc_tp" style="width:52">
							<option value="0">RCC</option>
							<option value="1">LCC</option>
							<option value="2" selected>SCC</option>
							<option value="3">Yard</option>
	                    </select></td>
	                    <td width="191"><input type="text" name="loc_cd" caption="Location" style="width:68;text-align:center;ime-mode:disabled;" class="input1" value="" maxlength="5" dataformat="engup">&nbsp;<img class="cursor" src="img/btns_search.gif" name="btns_search1" width="19" height="20" border="0" align="absmiddle">
					</td>
					<td width="98">Vessel Port</td>
					<td width="150">
	                    <input type="text" name="port_cd" caption="Port" style="width:60;text-align:center;ime-mode:disabled;" class="input1" value="" maxlength="5" dataformat="engup">&nbsp;<img class="cursor" src="img/btns_search.gif" name="btns_search6" width="19" height="20" border="0" align="absmiddle">
					</td>
					<td width="90">Vessel Lane</td>
					<td width="">
						<input type="text" name="slan_cd" caption="Lane" style="width:50;text-align:center;ime-mode:inactive;" class="input" value="" maxlength="3" dataformat="engup">&nbsp;<img class="cursor" src="img/btns_search.gif" name="btns_search7" width="19" height="20" border="0" align="absmiddle">
					</td>
				</tr>
				<tr class="h23">
					<td width="80">Delivery SCC</td>
					<td width="170"><input type="text" name="del_cd" caption="Delivery SCC" style="width:60;text-align:center" class="input" value="" maxlength="5" dataformat="engup">&nbsp;<img class="cursor" src="img/btns_search.gif" name="btns_search2" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="68">VVD Code</td>
					<td width="195" colspan="2"><input type="text" name="vvd_cd" caption="VVD Code" style="width:122;text-align:center;" class="input" value="" maxlength="9" dataformat="engup">&nbsp;<img class="cursor" name="btns_search3" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="98">ETA/ETD</td>
					<td width="" colspan="3">
						<select name="estm_tp" style="width:60;">
							<option value="ETA" selected>ETA</option>
							<option value="ETD">ETD</option>
	                    </select>
	                    <input type="text" name="str_estm_dt" caption="Start Duration" style="width:100;text-align:center;ime-mode:disabled;" class="input" value="" maxlength="8" dataformat="ymd" !cofield="end_estm_dt">&nbsp; ~&nbsp;
						<input type="text" name="end_estm_dt" caption="End Duration" style="width:100;text-align:center;ime-mode:disabled;" class="input" value="" maxlength="8" dataformat="ymd" !cofield="str_estm_dt">
						<img class="cursor" src="img/btns_calendar.gif" name="btns_calendar" width="19" height="20" border="0" align="absmiddle">
					</td>
				</tr>
				</table>
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>

				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="82">Lease Term</td>
					<td width="168">
						<script language="javascript" >ComComboObject('combo1', 1, 138, 1);</script>
					</td>
					<td width="70">TP/SZ</td>
					<td width="245">
						<script language="javascript" >ComComboObject('combo2', 1, 212, 1 );</script>
					</td>
					<td width="100">MVMT Status</td>
					<td width="">
						<script language="javascript" >ComComboObject('combo3', 1, 202, 1);</script>
					</td>
					</tr></table>
					<table class="search" border="0" style="width:979;">
					<tr class="h23">
					<td width="80">AGMT No.</td>
					<td width="170"><input type="text" name="agmt_cty_cd" caption="AGMT No." style="width:40;text-align:center;" value="HHO" class="input2" readonly>
						<input type="text" caption="AGMT No." name="agmt_seq" style="width:70" class="input" value="" maxlength="6" dataformat="int">
						<img class="cursor" src="img/btns_search.gif" name="btns_search4" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="68">Lessor</td>
					<td width=""><input type="text" name="vndr_seq" caption="Lessee" style="width:60;text-align:center;" class="input" value="" maxlength="6" dataformat="int">
						<img class="cursor" src="img/btns_search.gif" name="btns_search5" width="19" height="20" border="0" align="absmiddle">
						<input type="text" name="vndr_abbr_nm" caption="Lessee" style="width:123;text-align:center;" class="input2" value="" readonly>
						<input type="text" name="vndr_nm" caption="Lessor." style="width:331" class="input2" value="" readonly></td>
					</tr></table>
					<table class="search" border="0" style="width:979;">
					<tr class="h23">
					<td width="80">Used Days</td>
					<td width="170" class="stm"><input type="text" name="used_dys" caption="Used Days" style="width:40;text-align:right;" value="" class="input" maxlength="3" dataformat="int">&nbsp;Or Over</td>
					<td width="68">Free Days </td>
					<td width="" class="stm"><input type="text" name="free_dys" caption="Free Days" style="width:40;text-align:right;" value="" class="input" maxlength="3" dataformat="int">&nbsp;Or Over</td>
					<td width="100">CNTR No. </td>
					<td width="315"><input type="text" name="cntr_list" style="width:180;" class="input" dataformat="engup">&nbsp;<img src="img/btns_search.gif" name="cntr_no_multi" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
					<!--
					<td width="">
						<table class="search_sm2" border="0" style="width:331;">
						<tr class="h23" align="center">
						<td width="110">Min On Hire Days</td>
						<td width="" class="stm">&nbsp;
							<input type="radio" name="min_onh_dys_tp" value="0" class="trans">&nbsp;Exclude&nbsp;&nbsp;
							<input type="radio" name="min_onh_dys_tp" value="1" class="trans" checked>&nbsp;Include&nbsp;&nbsp;
							<input type="radio" name="min_onh_dys_tp" value="2" class="trans">&nbsp;Only</td>
						</tr></table>
					</td>
					-->
					</tr></table>
			</td></tr>
		</table>
		<table class="height_8"><tr><td></td></tr></table>
		<table class="search" id="mainTable">
       		<tr><td class="bg">
				<!-- Grid  (S) -->
				<table width="100%" class="search"  id="mainTable">
					<tr>
						<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- Grid  (E) -->
		<!--  Button_Sub (S) -->
			<table width="100%" class="button">
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<!--td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Master">Master</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td-->

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

<!-- : ( Search Options ) (E) -->



			</td></tr>
		</table>
	<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:2;">
       	<tr><td class="btn1_bg">

		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="120" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Creation">LSO Creation</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
		         <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
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
	</td></tr>
</table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
