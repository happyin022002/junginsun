<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0227.jsp
*@FileTitle : e-Booking And S/I Performance Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.24
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.07.24 김기종
* 1.0 Creation
* 2011.09.01 변종건[CHM-201112930-01] [BKG] e-S/I 관련 시스템 (추가)보완 요청
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0227Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0227Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.BookingReport.PerformanceReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0227Event)request.getAttribute("Event");
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
<title>e-Booking And S/I Performance Report</title>
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

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	
	<tr><td valign="top">
	
		<!--Page Title, Historical (S)-->   
	    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">   
	        <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>   
	        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>   
	    </table>   
		<!--Page Title, Historical (E)-->
		

	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">

				<!--  biz_1  (S) -->
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="440">
						<table class="search_sm2" border="0" style="width:430;"> 
							<tr class="h23">
							<td width="100">Duration Option</td>
							<td class="stm">
							<input type="radio" name="duration_opt" value="M" onClick="setDuration(this.value)" class="trans" checked>Month
							<input type="radio" name="duration_opt" value="W" onClick="setDuration(this.value)" class="trans">Week
							<input type="radio" name="duration_opt" value="D" onClick="setDuration(this.value)" class="trans">Booking Date
							<input type="radio" name="duration_opt" value="B" onClick="setDuration(this.value)" class="trans">Onboard Date</td>

							</tr>
						</table>
					</td>
					<td width="200">
						<table class="search" border="0" style="width:100%;"> 
						<span id="duration">
							<td width="30">Year</td>
							<td width="60">
								<input type="text" name="duration_year" style="width:40;" class="input" value="" dataformat="yy" caption="Year" maxlength="4"  >
							</td>
							<td width="40">Month</td>
							<td width="60">
								<input type="text" name="duration_month" style="width:30;" class="input" value="" dataformat="mm" caption="Month" maxlength="2" >
							</td>
						</span>
						</table>
					</td>
					<!--<td width="40">Week</td>
					<td width="80">
						<input type="text" name="duration_month" style="width:30;" class="input" value="" dataformat="mm" caption="Month" maxlength="2" > 
						&nbsp;~&nbsp;
						<input type="text" name="duration_month" style="width:30;" class="input" value="" dataformat="mm" caption="Month" maxlength="2" >
					</td>
					--><td width="80">Report Type</td>
					<td width="130">
						<select name="report_type" style="width:120;" class="input1" onChange="setReportType(this.value);" >
							<option value="BR" selected>Booking Office</option>
							<option value="SR">Sales Office</option>
							<option value="CR">Shipper</option>
							<option value="DR">Detail</option>
						</select>
					</td>
					<td width="50">Region</td>
					<td width="">
						<script language="javascript">ComComboObject('region_cd', 1, 70, 0,1,0);</script>
					</td>
				</tr>
				</table>
				
				
				<table class="search" border="0" style="width:1000;"> 
				<tr class="h23">
					<td width="50">&nbsp;&nbsp;T/VVD</td>
					<td width="100">
						<input type="text" name="vvd_cd" style="width:80;" class="input1" value="" style="ime-mode:disabled" dataformat="engupnum"  caption="T/VVD" maxlength="9" >
					</td>
					<td width="30">GSO</td>
					<td width="70">
						<input type="text" name="gso" style="width:50;" class="input" value="" style="ime-mode:disabled" dataformat="engup"  caption="GSO" maxlength="6" >
					</td>
					<td width="50">B.Office</td>
					<td width="70">
						<input type="text" name="bkg_ofc" style="width:50;" class="input" value="" style="ime-mode:disabled" dataformat="engup"  caption="Booking Office" maxlength="6" >
					</td>
					<td width="85">L.Sales Office</td>
					<td width="70">
						<input type="text" name="sal_ofc" style="width:50;" class="input" value="" style="ime-mode:disabled" dataformat="engup"  caption="Sales Office" maxlength="6" >
					</td>
					<td width="50">C.Office</td>
					<td width="70">
						<input type="text" name="ctrt_ofc" style="width:50;" class="input" value="" style="ime-mode:disabled" dataformat="engup"  caption="Contract Office" maxlength="6" >
					</td>
					<td width="325">
						<table class="search_sm2" border="0" style="width:320;"> 
							<tr class="h23">
							<td width="90">e-SVC Type</td>
							<td class="stm">
								<input type="checkbox" name="doc_tp_b"  value="B" class="trans"  checked>e-booking&nbsp;&nbsp;
								<input type="checkbox" name="doc_tp_s"  value="S" class="trans" checked>e-S/I&nbsp;&nbsp;
								<input type="checkbox" name="doc_tp_h"  value="H" class="trans" checked>e-B/L</td>
							
							</tr>
						</table>
					</td>
				</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="300">
						<table class="search_sm2" border="0" style="width:315;"> 
							<tr class="h23">
							<td width="200">
									<input type="radio" name="sc_rfa_type" value="S" class="trans" checked>S/C&nbsp;&nbsp;
									<input type="radio" name="sc_rfa_type" value="R" class="trans">RFA No&nbsp;&nbsp;
									<input type="radio" name="sc_rfa_type" value="T" class="trans">TAA No
								</td>
							<td>
								<input type="text" name="sc_rfa_no" style="width:100;" class="input" value="" style="ime-mode:disabled" dataformat="engnum"  caption="S/C RFA No." maxlength="11">
							</td>

							</tr>
						</table>
					</td>
					<td width="60">Customer</td>
					<td width="">
						<script language="javascript">ComComboObject('bkg_cust_tp_cd', 1, 100, 0,0,0);</script>
						&nbsp;
						<input type="text" name="cust_cnt_cd" style="width:34;" value="" style="ime-mode:disabled" dataformat="engup"  caption="Country Code" maxlength="2" fullfill>
						<input type="text" name="cust_seq" style="width:40;" value="" style="ime-mode:disabled" dataformat="int"  caption="Cust Seq" maxlength="6">
						<input type="text" name="cust_nm"  style="width:100;" value="" style="ime-mode:disabled"  dataformat="engup"  maxlength="20">
					</td>
					<td width="65">By User ID</td>
					<td width="0">
						<input type="text" name="doc_usr_id" style="width:80;" class="input" value="" style="ime-mode:disabled" dataformat="engnum" maxlength="20" >
					</td>
					<td>
						<table border="0"> 
							<tr class="h23">
								<td> &nbsp;Zone</td>
								<td  class="sm">
									<select style="width:100;" class="input" name="zone_cd">
										<option value="">All</option>
										<option value="OCN">OCEAN</option>
										<option value="IPT">INTER PORT</option>
										<option value="EUAF">EUROPE/AFRICA</option>
									</select>
								</td>
							</tr>
						</table>	
						
					</td>

				</tr>
				</table>
					
				<!--  biz_1   (E) -->
			</td></tr>
		</table>
		<!-- earch Options_Speed (E) --> 	
		<table class="height_8"><tr><td></td></tr></table>
		<!-- Tab (S) -->
		<!-- Tab (E) -->
		<!-- Tab BG Box ) (S) -->
     	<table class="search" > 
       	<tr><td class="bg">
       			<div id="sheetLayer" style="display:none">
				<table class="search" border="0">
					<tr><td class="title_h"></td>
						<td class="title_s">Report Type - Booking  Office</td></tr>
				</table>
				<!-- Grid  (S) -->
				<table width="100%" id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				</div>
				<!-- Grid (E) -->
						
				<div id="sheetLayer" style="display:none">
				<table class="search" border="0">
					<tr><td class="title_h"></td>
						<td class="title_s">Report Type - Sales  Office</td></tr>
				</table>
				
				<!-- Grid  (S) -->
				<table width="100%" >
					<tr>
						<td width="100%" id="mainTable"> 
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>
				</div>
				<!-- Grid (E) -->
				<div id="sheetLayer" style="display:none">
				<table class="search" border="0">
					<tr><td class="title_h"></td>
						<td class="title_s">Report Type - Shipper</td></tr>
				</table>
				<!-- Grid  (S) -->
				<table width="100%" >
					<tr>
						<td width="100%" id="mainTable"> 
							<script language="javascript">ComSheetObject('sheet3');</script>
						</td>
					</tr>
				</table>
				</div>
				<!-- Grid (E) -->
				<div id="sheetLayer" style="display:none">
				<table class="search" border="0">
					<tr><td class="title_h"></td>
						<td class="title_s">Report Type - Detail</td></tr>
				</table>
				
				<!-- Grid  (S) -->
				<table width="100%" >
					<tr>
						<td width="100%" id="mainTable"> 
							<script language="javascript">ComSheetObject('sheet4');</script>
						</td>
					</tr>
				</table>
				<!-- Grid (E) -->
				</div>
						
			</td></tr>
		</table>
	<!-- Grid BG Box  (S) -->
	<!--biz page (E)-->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_retrieve" >Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_SummaryById" id="btn_SummaryById" >Summary by ID</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DownExcel" id="btn_DownExcel">Down&nbsp;Excel</td>
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