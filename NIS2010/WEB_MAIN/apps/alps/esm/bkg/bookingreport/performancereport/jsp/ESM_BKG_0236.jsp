<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0236.jsp
*@FileTitle : bookringreport
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.24
*@LastModifier : 김진주
*@LastVersion : 1.0
* 2013.06.24 김진주
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0236Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0236Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.BookingReport.PerformanceReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc= account.getOfc_cd();

		event = (EsmBkg0236Event)request.getAttribute("Event");
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
<title>SI Receiving List</title>
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
<input type="hidden" name="cust_grp_tp" value="BKG_CUST_TP_CD">
<!-- 개발자 작업	-->


<table width="100%" border="0" cellpadding="0" cellspacing="0"
	style="padding-top: 2; padding-left: 5;">
	<tr>
		<td valign="top"><!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0"
			class="title">
			<tr>
				<td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td>
			</tr>
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td>
			</tr>
		</table>

		<!--Page Title, Historical (E)--> <!--Button (E) --> <!--biz page (S)-->
		<table class="search">
			<tr>
				<td class="bg"><!--  biz_1  (S) -->
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">					
						
						<td width="85"><input type="radio" name="opt_tp" value="D" class="trans" checked> Period</td>
						<td width="300">
							<select class="input" style="width:70;" name="period">
								<option value="R" >Receive</option>
								<option value="E">ETD</option>
								<option value="B" selected>BKG</option>
							</select>
							&nbsp;
							<input type="text" name="fm_dt" style="width: 70" value="" class="input1" dataformat="ymd" caption="Period Start Date" maxlength="10" style="ime-mode:disabled" required cofield="to_dt"> 
							~ <input type="text" name="to_dt" style="width: 70" value="" class="input1" dataformat="ymd" caption="Period End Date" maxlength="10" style="ime-mode:disabled" required cofield="fm_dt"> 
							<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_period">
						</td>
						<td width="50"></td>

						
						<td width="100"><input type="radio" name="opt_tp" value="B" class="trans" > BKG No.</td>
						<td width="115"><input type="text" style="width: 80; ime-mode: disabled" class="input1" dataformat="engupnum" value="" name="bkg_no" maxlength="13"></td>
						<td width="45"></td>
						
						
						<td width="100">e-SVC TYPE</td>
						<td width = "160" class="stm">
							<input type="radio" name="doc_tp_cd" value="B" class="trans" checked>e-booking&nbsp;&nbsp;
							<input type="radio" name="doc_tp_cd" value="S" class="trans" >e-S/I</td>
						<td width="9"></td>

					</tr>
				</table>
				
				
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="30"></td>
						<td width="57">VVD</td>
						<td width="100"><input type="text" style="width: 90; ime-mode: disabled" dataformat="engupnum" class="input" value="" name="vvd" maxlength="9"></td>
						<td width="20"></td>
						
						<td width="14"></td>
						<td width="30">POL</td>
						<td width="70"><input type="text" style="width: 50; ime-mode: disabled" dataformat="engup" class="input" value="" name="pol_cd" maxlength="5"></td>
						<td width="30">POD</td>
						<td width="70"><input type="text" style="width: 50; ime-mode: disabled" dataformat="engup" class="input" value="" name="pod_cd" maxlength="5"></td>

						
						
						<td width="45"></td>
						<td width="80">Contract</td>
						<td width="50"><script language="javascript">ComComboObject('ctrt_tp_cd', 1, 50, 0,0,0);</script></td>
						<td width="100"><input type="text" style="width: 80; ime-mode: disabled" dataformat="engupnum" class="input" value="" name="ctrt_no" maxlength="20"></td>
						
						
						
						<td width="10"></td>
						<td width="100">Customer</td>
						<td width="75"><script language="javascript">ComComboObject('cust_tp_cd', 1, 75, 1,0,0);</script></td>
						<td width="30"><input type="text" name="cust_cnt_cd" style="width:30;" class="input" value="" style="ime-mode:disabled" dataformat="engup"  caption="Country Code" maxlength="2" fullfill ></td>
						<td width="55"><input type="text" style="width: 50; ime-mode: disabled" dataformat="int" class="input" value="" name="cust_seq" maxlength="20"></td>
						<td width="9"></td>
				
					</tr>
				</table>
				
				
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">					
						<td width="30"></td>
						<td width="60">RHQ</td>
						<td width="110"><script language="javascript">ComComboObject("rhq_cd", 1, 110, 1, 0, 1);</script></td>
						<td width="18"></td>
						
						<td width="34"></td>
						<td width="50">GSO</td>
						<td width="70"><input type="text" style="width: 70; ime-mode: disabled" dataformat="engup" class="input" value="" name="gso_cd" maxlength="5"></td>
						<td width="50"></td>
						
						<td width="45"></td>
						<td width="75">BKG Office</td>
						<td width="80"><input type="text" style="width: 80; ime-mode: disabled" dataformat="engup" class="input" value="" name="bkg_ofc_cd" maxlength="5"></td>
						<td width="80"></td>
						
						
						<td width="100">G.Customer</td>
						<td width="75"><script language="javascript">ComComboObject('grp_cust_tp_cd', 1, 75, 1,0,0);</script></td>
						<td width="80"><input type="text" style="width: 80; ime-mode: disabled" dataformat="etc" class="input" value="" name="cust_grp_id" maxlength="20"></td>
						
						<td width="14"></td>
				
					</tr>
				</table>
				</td>
			</tr>
		</table>
		<!--  biz_1   (E) -->
		<table class="line_bluedot">
			<tr>
				<td colspan="8"></td>
			</tr>
		</table>
		
		

		<!-- Tab ) (S) -->
		<table class="tab" border="0" cellpadding="0" cellspacing="0" width="100%">
			<tr>
				<td width="49%"><script language="javascript">ComTabObject('tab1')</script>
				</td>
				
				<td width="1%"></td>
				<td width="50%">
					<table class="search" border="0">
						<tr>
							<td class="title_h"></td>
							<td class="title_s">BKGs</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<!-- Tab ) (E) -->

		<div id="tabLayer" style="display: inline">
		<table class="search">
			<tr>
				<td class="bg"><!-- Grid  (S) -->
					<table width="45%" class="search" id="mainTable">
						<tr>
							<td width="100%"><script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table>
					<table width="45%" class="search" id="mainTable">
						<tr>
							<td width="100%"><script language="javascript">ComSheetObject('sheet2');</script>
							</td>
						</tr>
					</table>
				</td>
				
				<td width="9"></td>
				
				<td class="bg">
					<table width="55%" class="search" id="detailTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet3');</script>
						</td>
					</tr>
					</table>
					<table width="55%" class="search" id="detailTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet4');</script>
						</td>
					</tr>
					</table>
				</td>
				
			</tr>
		</table>
		</div>
		
		
		<!--TAB 1 (E) --> <!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0"
			cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
			<tr>
				<td class="btn1_bg" width="48%" >
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_DownExcel_Summary">Down&nbsp;Excel</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				</td>
				
				<td class="btn1_bg" >
					<table border="0" cellpadding="0" cellspacing="0" class="button">
					<tr>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_DtlRetrieve" id="btn_DtlRetrieve">Retrieve</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_DownExcel_Detail">Down&nbsp;Excel</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
					</tr>
					</table>
				</td>
			</tr>
		</table>
</td></tr>
</table>
	<!-- Grid BG Box  (S) -->
	<!--biz page (E)-->
	
<iframe name="hiddenFrame" style="visibility:hiddden" height="0" width="0"></iframe>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>