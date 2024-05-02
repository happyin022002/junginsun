<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1057.jsp
*@FileTitle : Freight & Charge List by VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.12
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2009.09.12 김태경
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg1057Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1057Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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


		event = (EsmBkg1057Event)request.getAttribute("Event");
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
<title>Freight & Charge List by VVD</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
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
<input type="hidden" name="spl_flg">
<input type="hidden" name="pagerows">
<input type="hidden" name="com_mrdPath">
<input type="hidden" name="com_mrdArguments">
<input type="hidden" name="com_mrdTitle" value="Freight & Charge List by VVD">
<input type="hidden" name="com_mrdBodyTitle" value="Freight & Charge List by VVD">


<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
		<!--Page Title, Historical (S)-->
					<table width="100%" border="0" cellpadding="0" cellspacing="0"	   class="title">
						<tr>
							<td class="history"><img src="img/icon_history_dot.gif"
													 align="absmiddle"><span id="navigation"></span></td>
						</tr>
						<tr>
							<td class="title"><img src="img/icon_title_dot.gif"
												   align="absmiddle"><span id="title"></span></td>
						</tr>
					  </table>
	<!--Page Title, Historical (E)-->
	
	
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">

				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width=50><label id="lbTvvd">T/VVD</label><label id="lbAvvd" style="display:none">A/VVD</label></td>
					<td width="90"><input type="text" name ="vvd_cd" style="width:80;" class="input1" value=""  maxlength='9'  required fullfill  dataformat='engupnum' style="ime-mode:disabled"></td>
					<td width="160">
					<table class="search_sm2" border="0" style="width:160;"> 
						<tr class="h23">
						<td width="160" class="stm">(<input type="radio" name ="vvd_chk" value="T" class="trans" onClick ="setSchKey(this.value)" checked> Trunk &nbsp;  
													<input type="radio" name ="vvd_chk" value="A" class="trans" onClick ="setSchKey(this.value)"> Actual ) &nbsp;
						</td> 
						</tr>
					</table>
					</td> 	
					<td width="90"><label id="lbBkg">BKG Date</label><label id="lbOnboard" style="display:none">Onboard Date</label></td>
					<td width="240">
						<input type="text" name="fr_dt" style="width:80;" class="input" value=""   dataformat="ymd" caption="Start Date" maxlength="10"  cofield="to_dt" onFocus="this.select();">
						&nbsp;~&nbsp;
						<input type="text" name="to_dt" style="width:80;" class="input" value=""    dataformat="ymd" caption="End Date" maxlength="10"  cofield="fr_dt" onFocus="this.select();">
						<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"  style="cursor:hand" onClick="callDatePop('BKG_DATE')">
					</td>
					<td width="230">
					<table class="search_sm2" border="0" style="width:230;"> 
						<tr class="h23">
						<td width="230" class="stm">(<input type="radio" name ="dt_chk" value="B" class="trans" onClick ="setSchKey(this.value)" checked> BKG Date &nbsp; 
													<input type="radio" name ="dt_chk" value="O" class="trans" onClick ="setSchKey(this.value)"> Onboard Date )
						</td>
						</tr>
					</table>
					</td> 				
					<td width="50">S/C No</td>
					<td width="85"><input type="text" name ="sc_no" style="width:80;" class="input" value="" maxlength='9' dataformat='engupnum' style="ime-mode:disabled"></td>
					
					
					 
				</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="35">POR</td>
					<td width="90"><input type="text" name ="por_cd" style="width:50;" class="input" value="" maxlength='5' dataformat='engupnum' style="ime-mode:disabled" ></td> 
					<td width="40">B/POL</td>
					<td width="90"><input type="text" name ="pol_cd" style="width:50;" class="input" value="" maxlength='5' dataformat='engupnum' style="ime-mode:disabled" ></td> 
					<td width="40">B/POD</td>
					<td width="90"><input type="text" name ="pod_cd" style="width:50;" class="input" value="" maxlength='5' dataformat='engupnum' style="ime-mode:disabled" ></td> 
					<td width="30">DEL</td>
					<td width="90"><input type="text" name ="del_cd" style="width:50;" class="input" value="" maxlength='5' dataformat='engupnum' style="ime-mode:disabled" ></td>
					<td width="75">Sales Office</td>
					<td width="100"><input type="text" name ="sls_ofc" style="width:50;" class="input" value="" maxlength='6' dataformat='engup' style="ime-mode:disabled"></td> 
					<td width="100">Booking Office</td>
					<td width="88"><input type="text" name ="bkg_ofc" style="width:50;" class="input" value="" maxlength='6' dataformat='engup' style="ime-mode:disabled"></td> 
					<td width="40">Trade</td>
					<td width="95"><input type="text" name ="trd_cd" style="width:30;" class="input" value="" maxlength='2' dataformat='engup' style="ime-mode:disabled"></td>
					<!-- <td width="10" class="stm">
					 <table class="search_sm2" border="0" style="width:265;"> 
						<tr class="h23">
						<td width="100">Window Option</td>
						<td width="" class="stm"><input type="radio" name ="w_option" value="R" class="trans" checked  onClick="javascript:changeTab(0);">&nbsp; Report  &nbsp; &nbsp; <input type="radio" name ="w_option" value="G" class="trans"  onClick="javascript:changeTab(1);">&nbsp;Grid</td>
						</tr>
					</table> 
					</td> -->
				</tr>
				</table>
			<!--  biz_1   (E) -->		
			
		</td></tr></table>

		
			<!-- Tab (E) -->
					<table class="height_8"><tr><td></td></tr></table>
	       			<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%>
					<tr>
						<td width="100%">
							<script language="javascript">ComTabObject('tab1')</script>
						</td>
					</tr>
				</table>
			<!-- Tab (E) -->
				
				
			<table class="search"> 
       			<tr><td class="bg">
		
		<div id="tabLayer" style="display:none">			
			<!-- grid (S) -->
			<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table> 
			<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet2');</script>
					</td>
				</tr>
			</table> 
		</div>
		<div id="tabLayer" style="display:inline">
			<table id="rdTable" width="100%"  height="410">
			<!-- <table id="rdTable" width="980" height="380"> -->
				<tr>
					<td><script language="javascript">
					comRdObject('report1');					
					</script></td>
				</tr>
			</table>
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
					<td class="btn1" name="btn_retrieve" id="btn_Retrieve">Retrieve</td>
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
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_excel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_print">Print</td>
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
<!-- 2010.02.02 version 1.0 -->
</form>
</body>
</html>