<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0767.jsp
*@FileTitle : booking report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.06.04 강동윤
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0767Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0767Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	String bkgRptKndCd 		= "C"; 
	
	Logger log = Logger.getLogger("com.hanjin.apps.BookingReport.PerformanceReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		//bkgRptKndCd = request.getParameter("bkg_rpt_knd_cd");
		
		event = (EsmBkg0767Event)request.getAttribute("Event");
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
<title>C/A Summary Template</title>
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

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->

<input type="hidden" name="bkg_rpt_knd_cd" value="<%= bkgRptKndCd %>">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;C/A Summary Template</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 		<table class="search"> 
  		<tr><td class="bg">

			<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="100">Template Name</td>
					<td width="160">
						<select name="rpt_nm" style="width:200;"class="input" onChange="javascript:changeNm()">
						</select>
						<!--  script language="javascript"> ComComboObject('rpt_nm', 1, 150, true, '');</script-->
					</td>
					<td width="160">
						&nbsp;<input type="text" name="add_value" style="width:150;" class="input" value="" >
					</td>
					<td width="70"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_add">Add</td>
							<td class="btn2_right"></td>
						</tr>
						</table></td>
					<td><table width="70" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_delete">Delete</td>
							<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr>
				</table>
		
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">By Date & VVD</td></tr>
			</table>
			<table class="search" border="0" style="width:100%;"> 
			<tr class="h23">
				<td width="100">Correction Date</td>
				<td width="240"><input type="text" name="corr_from_dt" style="width:75" value="" caption="Correction Date" dataformat ="ymd" maxlength='10' OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_corr_sdate">&nbsp;~&nbsp;<input type="text" name="corr_to_dt"style="width:75" value="" caption="Correction Date" dataformat="ymd" maxlength='10' OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_corr_edate"></td>
				<td width="90">Booking Date</td>
				<td width=""><input type="text" name="cre_from_dt" style="width:75" value="" caption="Booking Date" dataformat ="ymd" maxlength='10' OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_cre_sdate">&nbsp;~&nbsp;<input type="text" name="cre_to_dt" style="width:75" value="" caption="Booking Date" dataformat="ymd" maxlength='10' OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_cre_edate"></td>
			</tr>
			</table>
			<table class="search" border="0" style="width:100%;"> 
			<tr class="h23">
				<td width="30">VVD</td>
				<td width=""><input type="text" name="vvd" style="width:80" value="" dataformat="engupnum" fulfill maxlength="9" style="ime-mode:disabled;"></td>
			</tr>
			</table>
			
			<table class="height_8"><tr><td></td></tr></table>
			<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Reason & Type</td></tr>
			</table>
			<table class="grid2" border="0">
				<tr><td width="100" class="tr2_head">C/A Reason</td>
					<td width="480" class="stm">
						<input type="checkbox" name="ca_reason_m" value="" class="trans">M &nbsp;&nbsp;&nbsp;
						<input type="checkbox" name="ca_reason_d" value="" class="trans">D &nbsp;&nbsp;&nbsp;						
						<input type="checkbox" name="ca_reason_c" value="" class="trans">C &nbsp;&nbsp;&nbsp;
						<input type="checkbox" name="ca_reason_g" value="" class="trans">G &nbsp;&nbsp;&nbsp;
						<input type="checkbox" name="ca_reason_a" value="" class="trans">A &nbsp;&nbsp;&nbsp;
						<input type="checkbox" name="ca_reason_o" value="" class="trans">O
					</td>
				</tr>
				<tr><td width="100" class="tr2_head">C/A Class</td>
					<td class="stm">
						<input type="checkbox" name="ca_class_1" value="" class="trans">Revenue&nbsp;&nbsp;&nbsp;
						<input type="checkbox" name="ca_class_2" value="" class="trans">Non-Revenue &nbsp;&nbsp;&nbsp;
						<input type="checkbox" name="ca_class_3" value="" class="trans"> Expense
					</td>
				</tr>
				<tr><td width="100" class="tr2_head">
					<table width="90" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left" style="border:0; padding:0;"></td>
					<td class="btn2" style="border:0; padding:0;" name="btn_cakind">C/A Kind</td>
					<td class="btn2_right" style="border:0; padding:0;"></td></tr>
					</table></td>
					<td class="stm">
						<input type="checkbox" name="ca_kind_a" value="" class="trans">A&nbsp;&nbsp;&nbsp;
						<input type="checkbox" name="ca_kind_b" value="" class="trans">B&nbsp;&nbsp;&nbsp;
						<input type="checkbox" name="ca_kind_c" value="" class="trans">C&nbsp;&nbsp;&nbsp;
						<input type="checkbox" name="ca_kind_d" value="" class="trans">D&nbsp;&nbsp;&nbsp;
						<input type="checkbox" name="ca_kind_e" value="" class="trans">E&nbsp;&nbsp;&nbsp;
						<input type="checkbox" name="ca_kind_f" value="" class="trans">F&nbsp;&nbsp;&nbsp;
						<input type="checkbox" name="ca_kind_g" value="" class="trans">G&nbsp;&nbsp;&nbsp;
						<input type="checkbox" name="ca_kind_h" value="" class="trans">H&nbsp;&nbsp;&nbsp;
						<input type="checkbox" name="ca_kind_i" value="" class="trans">I&nbsp;&nbsp;&nbsp;
						<input type="checkbox" name="ca_kind_j" value="" class="trans">J&nbsp;&nbsp;&nbsp;
						<input type="checkbox" name="ca_kind_k" value="" class="trans">K
					</td>
				</tr>
			</table>
			<table class="height_8"><tr><td></td></tr></table>
			<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Office & Staff</td></tr>
			</table>
			<table class="search" border="0" style="width:100%;"> 
			<tr class="h23">
				<td width="100">C/A Issue Office</td>
				<td width="100"><input type="text" name="ca_issue_off" style="width:60" class="input" value="" dataformat="engup" fulfill maxlength="6"></td>
				<td width="95">BKG Office</td>
				<td width="100"><input type="text" name="bkg_off" style="width:60" class="input" value="" dataformat="engup" fulfill maxlength="6"></td>
				<td width="70">DEL Office</td>
				<td width=""><input type="text" name="del_off" style="width:60" class="input" value="" dataformat="engup" fulfill maxlength="6"></td>
			</tr>
			</table>
			<table class="search" border="0" style="width:100%;"> 
			<tr class="h23">
				<td width="30">Part</td>
				<td width="170"><select name="part" style="width:73;"class="input">
						<option value="" selected>ALL</option>
						<option value="SCA">SCA</option>
						<option value="SCE">SCE</option>
						<option value="SCI">SCI</option>
						</select></td>
				<td width="95">Contract Office</td>
				<td width="100"><input type="text" name="contract_off" style="width:60" class="input" value="" dataformat="engup" fulfill maxlength="6"></td>
				<td width="70">DEL Cont</td>
				<td width="">
						<script language="javascript">ComComboObject('dlv_ctnt_cd', 1, 80, '');</script>
				</td>
			</tr>
			</table>
			<table class="search" border="0" style="width:100%;"> 
			<tr class="h23">
				<td width="100">C/A Issue Staff</td>
				<td width=""><input type="text" name="ca_issue_staff" style="width:255" class="input" value="" maxlength="20"></td>
			</tr>
			</table>
			
			<table class="grid2" border="0">
				<tr><td width="130" class="tr2_head" rowspan="2">Office Display Option</td>
					<td width="450" class="stm">
						<input type="checkbox" name="off_dis_op_1" value="" class="trans">RHQ of C/A OFC&nbsp;&nbsp;&nbsp;
						<input type="checkbox" name="off_dis_op_2" value="" class="trans">BKG OFC&nbsp;&nbsp;&nbsp;
						<input type="checkbox" name="off_dis_op_3" value="" class="trans">C/A OFC&nbsp;&nbsp;&nbsp;
						<input type="checkbox" name="off_dis_op_4" value="" class="trans">Contract
					</td>
				</tr>
				<tr>
					<td class="stm">
						<input type="checkbox" name="off_dis_op_5" value="" class="trans">Sub office of C/A  Issue Office&nbsp;&nbsp;&nbsp;
						<input type="checkbox" name="off_dis_op_6" value="" class="trans">Sub Office of DEL Office	
					</td>
				</tr>				
			</table>
			<table class="height_8"><tr><td></td></tr></table>
			<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Route</td></tr>
			</table>
			<table class="search" border="0" style="width:100%;"> 
			<tr class="h23">
				<td width="30">POR</td>
				<td width="80"><input type="text" name="por" style="width:55" class="input" value="" dataformat="uppernum" fulfill maxlength="5"></td>
				<td width="30">POL</td>
				<td width="80"><input type="text" name="pol" style="width:55" class="input" value="" dataformat="uppernum" fulfill maxlength="5"></td>
				<td width="30">POD</td>
				<td width="80"><input type="text" name="pod" style="width:55" class="input" value="" dataformat="uppernum" fulfill maxlength="5"></td>
				<td width="30">DEL</td>
				<td width=""><input type="text" name="del" style="width:55" class="input" value="" dataformat="uppernum" fulfill maxlength="5"></td>
			</tr>
			</table>
			<table class="height_8"><tr><td></td></tr></table>
			<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Other Options</td></tr>
			</table>
			<table class="search_sm2" border="0" style="width:80%;"> 
			<tr class="h23">
				<td width="180"><input type="checkbox" name="other_op_1" value="" class="trans">Include Carrier Haulage</td>
				<td width="200"><input type="checkbox" name="other_op_2" value="" class="trans">Include Merchant Haulage</td>
				<td width=""><input type="checkbox" name="other_op_3" value="" class="trans">Exempt</td>
			</tr>
			</table>
				
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
			<!-- Grid  (S) -->
				<table width="0"  id="mainTable"> 
					<tr>
						<td width="0">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>			
			<!-- Grid (E) -->

<table class="height_5"><tr><td></td></tr></table>
</td></tr>
</table> 

	
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				
				<td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
				</tr>
				</table></td>
				<td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
				</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right"></td>
				</tr>
				</table></td>
			</tr>
		</table></td>
			</tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>