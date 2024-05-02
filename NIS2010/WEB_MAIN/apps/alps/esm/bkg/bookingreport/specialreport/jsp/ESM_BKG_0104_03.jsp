
<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : ESM_BKG_0104_03.jsp
	 *@FileTitle : B/L Status Report
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2015.01.07
	 *@LastModifier : 조정민
	 *@LastVersion : 1.0
	 * 2015.01.07 조정민
	 * 1.0 Creation
	 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page
	import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page
	import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingreport.specialreport.event.EsmBkg0104Event"%>	
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0104Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String rpt_nm = JSPUtil.getNull(request.getParameter("rpt_nm")); ;
	String edit_yn = JSPUtil.getNull(request.getParameter("edit_yn"));
	boolean bBtn_Disabled = true;
	Logger log = Logger.getLogger("com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0104Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request
				.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Welcome to alps!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	paramReportName="<%=rpt_nm%>";
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
<div id="debug"></div>

<!-- OUTER - POPUP (S)tart -->
<table width="800" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="./img/icon_title_dot.gif" align="absmiddle">&nbsp;B/L Status Report</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		<!-- ********************************************************************************************************************** -->

<!--TAB Search (S) -->
	
		<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
		<table class="search" border="0" style="width:100%;"> 
				<tr><td>
				<!--  biz_1  (S) -->
						<table class="search" border="0" style="width:979;">
						<form method="post" name="tempform" onSubmit="return false;"> 
						<tr class="h23">
							<td width="90">Report Type</td>
							<td width="250"><script language="javascript">ComComboObject('report_type', 1, 240, '');</script></td>
							<td width=""><table width="140" border="0" cellpadding="0" cellspacing="0"></table> 
							<table width="140" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td>
										<td class="btn2" name="btn_ReportTemplate">Report&nbsp;Template</td>
										<td class="btn2_right"></td> 
										</tr>
										</table>
							</td>
							</tr>
							</form>
						</table>
				<!--  biz_1   (E) -->
						
				</td></tr>
		</table>
		
		<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>	
		<form method="post" name="form" onSubmit="return false;" style="margin-top:-1">
		<input type="hidden" name="f_cmd">
		<input type="hidden" name="b_ofc_cd" value="">	
		<input type="hidden" name="p_bkg_rpt_knd_cd" value="L">				
		<input type="hidden" name="edit_yn" value="<%= edit_yn %>">
				<!--  biz_1  (S) -->
		<table class="search" border="0" style="width:100%;"> 
			<tr class="h23">
				<td width="60">Duration</td>
				<td width="123" class="stm">
					<script language="javascript">ComComboObject('dura_opt', 1, 120, 1, 1);</script>
				</td>
				<td width="205" class="sm" align="left"><input type="text" style="width:75;" value="" class="input1" name="dura_from_dt"  maxlength='10' dataformat="ymd">
				              ~&nbsp;<input type="text" style="width:75;" value="" class="input1" name="dura_to_dt"  maxlength='10' dataformat="ymd">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_dura_date">
				</td>	
				<td width="80">B/L Status</td>
				<td><script language="javascript">ComComboObject('bl_sts_cd', 1, 148, true, '');</script>
				</td>
			</tr>
		</table>
		
		<table class="search" border="0" style="width:979;">
			<tr class="h23">
				<td width="27">VVD</td>
				<td width="85"><input type="text" style="width:80;"   value=""  name="vvd_cd" maxlength='9'  fullfill  dataformat='engupnum' style="ime-mode:disabled" class="input1" ></td>
				<td width="27">POL</td>
				<td width="55"><input type="text" style="width:50;"    value="" name="pol_cd" maxlength='5' dataformat='engupnum' style="ime-mode:disabled" class="input"></td>
				<td width="27">POD</td>
				<td width="55"><input type="text" style="width:50;"    value="" name="pod_cd" maxlength='5' dataformat='engupnum' style="ime-mode:disabled" class="input"></td>
				<td width="27">POR</td>
				<td width="55"><input type="text" style="width:50;"    value="" name="por_cd" maxlength='5' dataformat='engupnum' style="ime-mode:disabled" class="input"></td>
				<td width="27">DEL</td>
				<td width="55"><input type="text" style="width:50;"    value="" name="del_cd" maxlength='5' dataformat='engupnum' style="ime-mode:disabled" class="input"></td> 		
				<td width="115">DEL Control Office</td>
				<td width="65"><input type="text" style="width:60;"    value="" name="del_ofc_cd" maxlength='6' dataformat='engup' style="ime-mode:disabled" class="input"></td>
				<td width="135">OB/L Surrender Office</td>
				<td width="65"><input type="text" style="width:60;"    value="" name="obl_ofc_cd" maxlength='6' dataformat='engup' style="ime-mode:disabled" class="input"></td>
				<td width="98">3rd Party Office</td>
				<td width=""><input type="text" style="width:60;"    value="" name="n3pty_ofc_cd" maxlength='6' dataformat='engup' style="ime-mode:disabled" class="input"></td>
			</tr>
		</table>
		<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="90">Booking Office</td>
				<td width="60"><input type="text" style="width:60;"    value="" name="b_ofc_cd_1" maxlength='6' dataformat='engup' style="ime-mode:disabled" class="input"></td>
				<td width="105">
                    		<table width="100" border="0" cellpadding="0" cellspacing="0" class="button">
                      		<tr><td class="btn2_left"></td>
                     				 <td class="btn2" id="btn_multi_ofc" name="btn_multi_ofc">Multi Office.</td>
                     				 <td class="btn2_right"></td>
                      		</tr>
                      	</table>
                      </td>
				<td width="70">Sales Office</td>
				<td width="70"><input type="text" style="width:60;"    value="" name="sal_ofc_cd" maxlength='6' dataformat='engup' style="ime-mode:disabled" class="input"></td>
				<td width="97">B/L Issue Office</td>
				<td width="70"><input type="text" style="width:60;"    value="" name="bl_ofc_cd" maxlength='6' dataformat='engup' style="ime-mode:disabled" class="input"></td>
				<td width="125">OB/L Receive Office</td>
				<td width="90"><input type="text" style="width:60;"    value="" name="obl_rcv_ofc_cd" maxlength='6' dataformat='engup' style="ime-mode:disabled" class="input"></td>
				<td width="12">By</td>
				<td align="right">
					<select style="width:103;" class="input2" name="by_cd">
					<option value="BS">Booking Staff</option>
					<option value="SR">Sales Rep</option>
					<option value="BR">B/L Ready</option>
					<option value="BI">B/L Issue</option>
					<option value="OR">OBL Receive</option>
					</select>&nbsp;<input type="text" style="width:75;" value="" name="staff_id" maxlength='20' dataformat='engnum' style="ime-mode:disabled" class="input">
				</td>
			</tr>						
		</table>
		<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="120"><input type="radio" class="trans" name="bkg_bl_cd" value="BKG" onClick="setSchKey(this.value)">BKG&nbsp;
								<input type="radio" class="trans" name="bkg_bl_cd" value="BL" checked onClick="setSchKey(this.value)">B/L No.</td>
				<td ><input type="text" style="width:106;" value="" name="bkg_bl_no" maxlength='12' dataformat='engupnum' style="ime-mode:disabled" class="input"></td>
				<td>Cust</td>
				<td><script language="javascript">ComComboObject('cust_tp_cd', 2, 50, true, '');</script>&nbsp;<input type="text" style="width:25" value="" class="input" name="cust_cnt_cd" maxlength='2' dataformat='engup' style="ime-mode:disabled">
				<input type="text" style="width:60" value="" class="input" name="cust_seq" maxlength='6' dataformat='num' style="ime-mode:disabled">
				<input type="text" style="width:103" value="" class="input" name="cust_nm" maxlength='50' dataformat='custname' style="ime-mode:disabled"></td>

				<td width="100"><input type="radio" class="trans" name="sc_rfa_cd" value="SC">S/C
								<input type="radio" class="trans" name="sc_rfa_cd" value="RFA" checked >RFA</td>
				<td ><input type="text" style="width:106;" value="" name="sc_rfa_no" maxlength='20' dataformat='engupnum' style="ime-mode:disabled" class="input"></td>
				
				<td width="60">&nbsp;B/L Type</td>
				<td class="stm"><input type="checkbox" class="trans" name="bl_type_ori" value="Y">O/BL
								<input type="checkbox" class="trans" name="bl_type_way" value="Y">Waybill
								<input type="checkbox" class="trans" name="bl_type_web" value="Y">Web O/BL
				</td>							
			</tr>
		</table>
			<!--  biz_1   (E) -->
		</form>		
		</td></tr>
		</table>	
		<!--biz page (E)-->

	
	
	
<!--TAB Search (E) -->					


		<!-- ********************************************************************************************************************** -->

		


</td></tr>
</table> 

<table class="height_5"><tr><td></td></tr></table>
	
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0" align="right">
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_OK">OK</td>
								<td class="btn1_right">
							</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_New">New</td>
								<td class="btn1_right">
							</tr>
						</table>
					</td>
					<!--<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Set">Set</td>
								<td class="btn1_right">
							</tr>
						</table>
					</td>
					--><td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Close">Close</td>
								<td class="btn1_right">
							</tr>
						</table>
					</td>
					</tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
</td>
</tr>
</table>
<!-- : ( Button : pop ) (E) -->
			
<div style="display: none;">
 <!-- Hidden Grid -->
	<script language="javascript">ComSheetObject('sheet1');</script>
</div>
</body>
</html>
<%@include file="/bizcommon/include/common_alps.jsp"%>