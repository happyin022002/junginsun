<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0214.jsp
*@FileTitle : Doc Performance Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.21
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.08.21 김기종
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0214Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0214Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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


		event = (EsmBkg0214Event)request.getAttribute("Event");
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
<title>Doc Performance Report</title>
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
<input type="hidden" name="class_type" value="4">
<input type="hidden" name="sel_bkg_ofc_cd" value="">
<input type="hidden" name="sel_gso_cd" value="">

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
					<td width="400" >
						<table class="search_sm2" border="0" style="width:400;"> 
								<tr class="h23">
								<td class="">
								<input type="radio" name="search_opt" value="A"  onClick="setSchKey(this.value)" class="trans" checked>Date + BKG OFC&nbsp;&nbsp;
								<input type="radio" name="search_opt" value="B"  onClick="setSchKey(this.value)" class="trans">VVD+POL&nbsp;&nbsp;
								<input type="radio" name="search_opt" value="C"  onClick="setSchKey(this.value)" class="trans">Date +POL&nbsp;&nbsp;
								<input type="radio" name="search_opt" value="D"  onClick="setSchKey(this.value)" class="trans">BKG No</td>
	
							</tr>
						</table>
					</td>	
					<td width="55"><label id="lbPct">PCT</label><label id="lbEta" style="display:none">ETA</label></td>
					<td width="240">
						<input type="text" name="fr_dt" style="width:80;" class="input1" value=""   dataformat="ymd" caption="Start Date" maxlength="10"  cofield="to_dt" required onFocus="this.select();">
						&nbsp;~&nbsp;
						<input type="text" name="to_dt" style="width:80;" class="input1" value=""    dataformat="ymd" caption="End Date" maxlength="10"  cofield="fr_dt" required onFocus="this.select();">
						<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"  style="cursor:hand" onClick="callDatePop('BKG_DATE')">
					</td>
					<td width="200">
					</td>
				</tr>
				</table>
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					
					<td width="55">T/VVD</td>
					<td width="125">
						<input type="text" name="vvd_cd"   style="width:80;" class="input" value="" style="ime-mode:disabled" dataformat="uppernum"  caption="VVD" maxlength="9" fullfill >
					</td>
					<td width="25">POL</td>
					<td width="60">
						<input type="text" name="pol_cd"  style="width:50;" value="" style="ime-mode:disabled" dataformat="uppernum"  caption="POL" maxlength="5" fullfill >
					</td>
					<td width="30">LANE</td>
					<td width="65">
						<input type="text" name="slan_cd"  style="width:40;" value="" style="ime-mode:disabled" dataformat="engup"  caption="LANE" maxlength="3" fullfill >
					</td>
					<td width="55">Region</td>
					<td width="190">&nbsp;
						<script language="javascript">ComComboObject('region', 1, 80, 0,1,0);</script>
					</td>
					<td width="30">GSO</td>
					<td width="">
						<input type="text" name="gso" style="width:60;"  class="input" value="" style="ime-mode:disabled" dataformat="engup"  caption="GSO" maxlength="6" >
					</td>
				</tr>
				</table>
				
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="55">BKG No.</td>
					<td width="125">
						<input type="text" style="width:100;" name="bkg_no" value="" class="input" style="ime-mode:disabled" dataformat="uppernum" caption="Booking No." maxlength="13"  fullfill>
					</td>
					<td width="50">B/L No.</td>
					<td width="130">
						<input type="text" style="width:105;" name="bl_no" value="" class="input" style="ime-mode:disabled" dataformat="uppernum" caption="B/L No." maxlength="13"  fullfill>
					</td>
					<td width="90">Booking Office</td>
					<td width="105">
						<input type="text" style="width:77;" name="bkg_ofc_cd"  value="" class="input" style="ime-mode:disabled" dataformat="engup" caption="Booking Office" maxlength="5"  fullfill >
					</td>
					<td width="80">Sales Office</td>
					<td width="">
						<input type="text" style="width:60;" name="ob_sls_ofc_cd"  value="" class="input" style="ime-mode:disabled" dataformat="engup" caption="Sales Office" maxlength="5"  fullfill>
					</td>
				</tr>
				</table>
					
				<!--  biz_1   (E) -->
			</td></tr>
		</table>
		<!-- earch Options_Speed (E) --> 	
		<table class="height_8"><tr><td></td></tr></table>
		
		
		<!-- Tab ) (S) -->
     		<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%> 
       		<tr><td width="100%">
						<script language="javascript">ComTabObject('tab1')</script>
						<!-- img src="img/sub_tab.gif" alt="" width="998" height="23" border="0" -->
					</td></tr>
				</table>
		<!-- Tab ) (E) --> 
		
		
		
<!--TAB  (S) -->
<div id="tabLayer" style="display:inline;visibility:none" >		
		<!-- Tab BG Box ) (S) -->
     	<table class="search"> 
       	<tr><td class="bg">
	       	<table class="search" border="0" style="width:979" > 
				<tr class="h23">
					<td width="320" valign="top">
						<table class="search" border="0">
							<tr><td class="title_h"></td>
								<td class="title_s">Office List</td>
							</tr>
						</table>
					<td>
					<td width="19"></td>
					<td width="660" valign="top">
						<table class="search" border="0">
							<tr><td class="title_h"></td>
								<td class="title_s">B/L List</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>				
       	<%
       	for (int i = 1 ; i < 8 ; i++){
       		String ofcTabSheet = "t1sheet"+i;
       		String blTabSheet = "t1sheet"+(i+7);
       		
       		
       	%>
				<table class="search" border="0" style="width:979" id="mainTable"> 
					<tr class="h23">
						<td width="320" valign="top">
						<!-- 1.Contract No -->
						<table width="100%">
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('<%=ofcTabSheet%>');</script>
								</td>
							</tr>
						</table>
						<!-- Grid (E) -->
						</td>
						<td width="19"></td>
						<td width="660" valign="top">
						<!-- 1.Contract No -->
						<table width="100%">
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('<%=blTabSheet%>');</script>
								</td>
							</tr>
						</table>
						<!-- Grid (E) -->
						</td>
					</tr>
				</table>
		<%
       	}
	    %>	
			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       		<td width="420">	       		
	       			<label id="lbGoto1" style="display:none" >* To check detailed customer code accuracy of each office, please go to  ▶</label>
	       			<label id="lbCnee" style="display:none" >* Codes that firstly inserted by Code Validation within PCT are shown as "Y"</label>
	       		</td>
	       		<td width="" onClick="javscript:gotoCustCodeErrReport()">
	       			<label id="lbGoto2" style="display:none" in><U>"Customer Code Error Report"</U></label>
	       			<!-- <label id="lbGoto2" style="display:none">	       			
					<table width="250" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
						<td class="btn2_left"></td>
						<td class="btn2" name="btn_goto">go to Customer Code Error Report</td>
						<td class="btn2_right"></td>
						</tr>
					</table>
					</label> -->
	       		</td>
	       		<td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr><td>
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
						<td class="btn2_left"></td>
						<td class="btn2" name="btn_t1office">Office</td>
						<td class="btn2_right"></td>
						</tr>
					</table>
				</td></tr>
				</table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
				
			</td></tr>
		</table>
	<!-- Grid BG Box  (S) -->
	<!--biz page (E)-->
</div>
<!--TAB  (E) -->	
	
	
	
	
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
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
				<td>
					<table class="search" border="0" style="width:170;"> 
						<tr class="h23">
							<td>
								<input type="radio"  name="report_type" value="ofc" class="trans" checked>Office List&nbsp;&nbsp;
								<input type="radio" name="report_type" value="bl" class="trans">B/L List</td>
						</tr>
					</table>
				</td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downexcel">Down&nbsp;Excel</td>
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