<%
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESM_BKG_1081.jsp
*@FileTitle : Autorating Accuracy Monitoring Report
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.04
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2010.02.04 김기종
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg1081Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1081Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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


		event = (EsmBkg1081Event)request.getAttribute("Event");
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
<title>Autorating Accuracy Monitoring Report</title>
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
<input type="hidden" name="sel_ofc_cd">
<input type="hidden" name="sel_scp_cd">
<!-- 개발자 작업	-->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>

	<!--Page Title, Historical (E)-->
	<!--Button (S) -->
		
    <!--Button (E) -->
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">

				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<td width="460">
					<table class="search_sm2" border="0" style="width:460;"> 
					<tr class="h23">
						<td width="220">
									<input type="radio" name="dt_option" value="R" checked class="trans">Rating Date&nbsp;&nbsp
									<input type="radio" name="dt_option" value="S" class="trans">Sailing Date&nbsp;&nbsp
						</td>
						<td width="220">
							<input type="text" name="fr_dt" style="width:80;" class="input1" value=""   dataformat="ymd" caption="Start Date" maxlength="10"  cofield="to_dt" required>
							&nbsp;~&nbsp;
							<input type="text" name="to_dt" style="width:80;" class="input1" value=""    dataformat="ymd" caption="End Date" maxlength="10"  cofield="fr_dt" required>
							<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"  style="cursor:hand" onClick="callDatePop('BKG_DATE')">
						</td>
						</table>
				</td>
					<td width="60">&nbsp;HQ Office</td>
					<td width="100">
						<script language="javascript">ComComboObject('region', 1, 70, 0,1,0);</script>
					</td>
					
					<td width="60">Contract</td>
					<td width="">
						<script language="javascript">ComComboObject('ctrt_cd', 1, 60, 0,0,0);</script>
					</td>
					
					<!--<td width="120">Dislplay B/L Detail</td>
					<td width="">
						<input type="checkbox" name="dis_bl_detail_flg" value="Y" class="trans">
					</td>
					
				--></tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					
					<td width="90">SVC Scope</td>
					<td width="90">
						<input type="text" name="svc_scp_cd" style="width:50;" class="input1" value="" style="ime-mode:disabled" dataformat="engup"  caption="SVC Scope" maxlength="3" >
					</td>
					<td width="50">S/C No</td>
					<td width="100">
						<input type="text" name="sc_no" style="width:90;" class="input1" value="" style="ime-mode:disabled" dataformat="engnum"  caption="SVC Scope" maxlength="20" >
					</td>
					<td width="97">Booking Office</td>
					<td width="100">
						<input type="text" name="bkg_ofc_cd" style="width:60;" class="input1" value="" style="ime-mode:disabled" dataformat="engup"  caption="BKG Office" maxlength="6" >
					</td>
					<td width="85">Incl. Sub OFC</td>
					<td width="50">
						<input type="checkbox" name="ofc_inc_sub" value="Y" class="trans">
					</td>
					<td width="80">Auto Status</td>
					<td width="">
						<input type="checkbox" name="auto_rat_cd" value="Y" class="trans">
					</td>
				
				</tr>
				</table>
				<!--  biz_1   (E) -->
			<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>	
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="420" valign="top">
						<table class="search" width="420" style="height:100%"><tr><td valign="top">
						
				
						<table class="search" border="0">
						<tr>
							<td class="title_h"></td>
							<td class="title_s">Autorating Accuracy Ratio</td>
						</tr>
						</table>
						<!-- Grid  (S) -->
						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table>
						
						</td></tr></table>
						
					</td>
					<td width="19"></td>
					
					<td width="540" valign="top">
						<table class="search" width="540"><tr><td valign="top">
					
						<table class="search" border="0">
						<tr><td class="title_h"></td>
							<td class="title_s"><span id = "span_autorated_bl">Non Autorated B/L List</span></td>
						</tr>
						</table>
						<!-- Grid  (S) -->
						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet2');</script>
								</td>
							</tr>
						</table>
						<!-- Grid (E) -->
						<table class="height_10"><tr><td colspan="8"></td></tr></table>
						</td></tr></table>
						
					</td>
				</tr>
				</table>
				
			</td></tr>
			</table>
			<!--Button (S) -->
			<table width="979" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
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
					<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_DownExcel_Summary">Down Excel-Summary</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_DownExcel_Detail">Down Excel-B/L List</td>
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
	<!-- Grid BG Box  (S) -->
	<!--biz page (E)-->
	

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>