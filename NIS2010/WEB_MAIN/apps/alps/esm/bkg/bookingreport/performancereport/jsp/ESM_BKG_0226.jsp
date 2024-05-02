<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0226.jsp
*@FileTitle : e-BKG And S/I Upload Status Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.07.20 김기종
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0226Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0226Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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


		event = (EsmBkg0226Event)request.getAttribute("Event");
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
<title>e-BKG And S/I Upload Status Report</title>
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
					<td width="530">
						<table class="search_sm2" border="0" style="width:520;"> 
							<tr class="h23">
							<td width="100">Duration Option</td>
							<td class="stm" width="200">
								<input type="radio" name="duration" value="D" onClick="setDuration(this.value)" class="trans" checked>Day&nbsp;&nbsp;
								<input type="radio" name="duration" value="W" onClick="setDuration(this.value)" class="trans">Week&nbsp;&nbsp;
								<input type="radio" name="duration" value="M" onClick="setDuration(this.value)" class="trans">Month
							</td>
							<td>
								<table class="search" border="0" style="width:100%;"> 
								<span id="durationHtml">
								<input type="text" name="duration_from_dt" style="width:75;" class="input1" value=""   dataformat="ymd" caption="Start Date" maxlength="10"  cofield="dt_to" required>
								&nbsp;~&nbsp;
								<input type="text" name="duration_to_dt" style="width:75;" class="input1" value=""    dataformat="ymd" caption="End Date" maxlength="10"  cofield="dt_fr" required>&nbsp;
								<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"  style="cursor:hand" onClick="callDatePop('BKG_DATE')"></td>
								</span>
								</table>
								
							</tr>
						</table>
					</td>
					<td width="80">Report Type</td>
					<td width="140">
						<script language="javascript">ComComboObject('report_type', 2, 120, 0,0,1);</script><!--
						
						<select style="width:120;">
						<option value="0" selected>Pending Report</option>
						<option value="1"></option>
						</select>
					--></td>
					<td width="">
						<table class="search_sm2" border="0" style="width:230;"> 
							<tr class="h23">
							<td width="90">e-SVC Type</td>
							<td class="stm" width="180">
								<input type="checkbox" name="doc_tp_b" value="B" class="trans" >e-booking&nbsp;&nbsp;
								<input type="checkbox" name="doc_tp_s" value="S" class="trans">e-S/I</td>
							
							</tr>
						</table>
					
					</td>
				</tr>
				</table>
				
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="60">&nbsp;&nbsp;Region</td>
					<td width="90">
						<script language="javascript">ComComboObject('region_cd', 1, 70, 0,1,0);</script><!--
						<!--<select style="width:70;">
						<option value="0" selected>SHADK </option>
						<option value="1"></option>
						</select>
					--></td>
					<td width="30">GSO</td>
					<td width="70"><input type="text" name="gso" style="width:50;" class="input" value="" style="ime-mode:disabled" dataformat="engup"  caption="GSO" maxlength="6" ></td>
					<td width="90">Booking Office</td>
					<td width="70"><input type="text" name="bkg_ofc" style="width:50;" class="input" value="" style="ime-mode:disabled" dataformat="engup"  caption="Booking Office" maxlength="6" ></td>
					<td width="75">Sales Office</td>
					<td width="70"><input type="text" name="sal_ofc" style="width:50;" class="input" value="" style="ime-mode:disabled" dataformat="engup"  caption="Sales Office" maxlength="6" ></td>
					<td width="30">POR</td>
					<td width="70"><input type="text" name="por_cd" style="width:50;" class="input" value="" style="ime-mode:disabled" dataformat="engupnum"  caption="POR" maxlength="6" ></td>
					<td width="30">POL</td>
					<td width="70"><input type="text" name="pol_cd" style="width:50;" class="input" value="" style="ime-mode:disabled" dataformat="engupnum"  caption="POL" maxlength="6" ></td>
					<td width="30">POD</td>
					<td width="70"><input type="text" name="pod_cd"  style="width:50;" class="input" value="" style="ime-mode:disabled" dataformat="engupnum"  caption="POD" maxlength="6" ></td>
					<td width="30">DEL</td>
					<td width="70"><input type="text" name="del_cd" style="width:50;" class="input" value="" style="ime-mode:disabled" dataformat="engupnum"  caption="DEL" maxlength="6"  ></td>
					<td width="60">Upload Status</td>
					<td width="110">
						<script language="javascript">ComComboObject('bkg_upld_sts_cd',2, 73, '');</script>
					</td>
				</tr>
				</table>
					
				<!--  biz_1   (E) -->
			</td></tr>
		</table>
		<!-- earch Options_Speed (E) --> 	
		<table class="height_8"><tr><td></td></tr></table>

		<!-- Tab (E) -->
		<!-- Tab BG Box ) (S) -->
     	<table class="search"> 
       	<tr><td class="bg">
						<table class="search" border="0" id="sheetTitleTable" style="display:none">
							<tr><td class="title_h"></td>
								<td class="title_s">Report Type - Pending Report </td></tr>
						</table>
						
						<!-- Grid  (S) -->
						<table width="100%"  id="mainTable" style="display:none">
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table>
						<!-- Grid (E) -->
		
				<table class="line_bluedot" id="sheetLineTable"><tr><td colspan="6"></td></tr></table>
		
				<table class="search" border="0" id="sheetTitleTable" style="display:none">
							<tr><td class="title_h"></td>
								<td class="title_s">Report Type - Delay Report  </td></tr>
						</table>
						
						<!-- Grid  (S) -->
						<table width="100%"  id="mainTable" style="display:none">
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet2');</script>
								</td>
							</tr>
						</table>
						<!-- Grid (E) -->
		
						<table class="line_bluedot" id="sheetLineTable"><tr><td colspan="6"></td></tr></table>
									
						<table class="search" border="0" id="sheetTitleTable">
							<tr><td class="title_h"></td>
								<td class="title_s">Report Type - Detail Report </td></tr>
						</table>
						
						<!-- Grid  (S) -->
						<table width="100%"  id="mainTable">
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet3');</script>
								</td>
							</tr>
						</table>
						<!-- Grid (E) -->
				<table border="0" style="width:979"> 
				<tr>
					<td align="left" bgcolor="#E9E9E9">
					<div id='options' style="padding:5 10 5 10;width: 100%;font-size:12px;height:25px;border-right:#000000 1px; border-top: #000000 1px;z-index:1;visibility: visible;overflow: auto;border-left: #000000 1px;border-bottom: #000000 1px;" >
					</div>
					</td>
				</tr>
				</table>
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
					<td class="btn1" name="btn_Retrieve" id="btn_retrieve">Retrieve</td>
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
					<td class="btn1" name="btn_DownExcel">Down&nbsp;Excel</td>
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