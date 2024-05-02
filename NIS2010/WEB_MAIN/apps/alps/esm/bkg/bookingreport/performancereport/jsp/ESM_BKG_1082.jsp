<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1082.jsp
*@FileTitle : booking report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.31
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.08.31 강동윤
* 1.0 Creation
* -----------------------------------------------------------------
* History
* 2010.10.08 김영철 [CHM-201006186-01] 
*   1. 조회조건으로 Contract Office및  Sales Rep.조건 추가
*   2. Direct Down Load(B/L Detail) List상에 Contract Office및 Contract Sales Rep. 추가반영 및 일부항목 Label수정
*   3. bkg실적이 없는 날짜에 bkg된 것처럼 display되는 error수정.
*   4. BKG Trend의 "D" Day의 의미 및 SNAPSHOT Time를 명확히하는 차원에서 Guide문귀 삽입
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg1082Event"%>
<%@ page import="org.apache.log4j.Logger" %>
 
<%
	EsmBkg1082Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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


		event = (EsmBkg1082Event)request.getAttribute("Event");
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
<title>booking report</title>
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
<input type="hidden" name="dis_val">
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top: 2; padding-left: 5;">
	<tr>
		<td valign="top">
	
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>

	<!--Page Title, Historical (E)-->
	
	
	<!--biz page (S)-->
		
		
				<!-- Tab ) (S) -->
     		<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%> 
       		<tr><td width="100%">
						<script language="javascript">ComTabObject('tab1')</script>
						<!-- img src="img/sub_tab.gif" alt="" width="998" height="23" border="0" -->
					</td></tr>
				</table>
		<!-- Tab ) (E) -->
		
		<!--TAB 1 (S) -->
<div id="tabLayer" style="display:inline">
			
	<table class="search"> 
       	<tr><td class="bg" width="100%">
			<table class="search" border="0" style="width:100%;"> 
			<tr class="h23">
			<td width="100%" valign="top">
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Select VVD </td>
					<td>( * Min. one is required among Sailing Date/VVD/ Cancel Date. but those can be combined)</td>
					</tr></table>
				<table class="search_sm2" border="0" style="width:100%;"> 
				<tr class="h23">
				<td width="155">&nbsp;&nbsp;1st POL Sailing Date</td>
				<td  width="260">
					<input type="text" name="pol_etd_fr_dt" style="width:80;" class="input1" value="" dataformat="ymd" caption="Start Date" maxlength="10"  cofield="pol_etd_to_dt" onFocus="this.select();">
					&nbsp;~&nbsp;
					<input type="text" name="pol_etd_to_dt" style="width:80;" class="input1" value="" dataformat="ymd" caption="End Date" maxlength="10"  cofield="pol_etd_fr_dt" onFocus="this.select();">
					<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"  style="cursor:hand" onClick="callDatePop('POL_ETD_DT')">
				</td>
				 
				<td width="95">Cancel Date</td>
				<td  width="">
					<input type="text" name="bkg_cxl_fr_dt" style="width:80;" class="input1" value="" dataformat="ymd" caption="Start Date" maxlength="10"  cofield="bkg_cxl_to_dt" onFocus="this.select();" onblur="checkCancel()">
					&nbsp;~&nbsp;
					<input type="text" name="bkg_cxl_to_dt" style="width:80;" class="input1" value="" dataformat="ymd" caption="End Date" maxlength="10"  cofield="bkg_cxl_fr_dt" onFocus="this.select();" onblur="checkCancel()">
					<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"  style="cursor:hand" onClick="callDatePop('BKG_CXL_DATE')">
				</td>
				</tr>
				</table>
				<table class="search_sm2" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="50">&nbsp;&nbsp;VVD</td>
					<td width="300" ><input type="text" name="vvd_sig" dataformat="engupnum" maxlength="9" class="input" style="width:80;" value="" onChange="javascript:searchLane(this);">&nbsp;<input type="text" name="slan_cd" dataformat="engup" maxlength="3" class="input2" style="width:35;" value="" readonly>&nbsp;<input type="text" name="vvd_idx" dataformat="engup" maxlength="3" class="input2" style="width:18;" value="" readonly>&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" onClick="javascript:getVvds();">&nbsp;<script language="javascript">ComComboObject('vvd', 1, 100, true, '');</script></td>				
					<td width="30">POL</td>
					<td width="100" >
						<input type="text" name="pol_cd" dataformat="engupnum" maxlength="5" style="width:60;" class="input" value="" maxlength="2" size="2">
					</td>
					<td width="30">POD</td>
					<td width="" >
						<input type="text" name="pod_cd" dataformat="engupnum" maxlength="5" style="width:60;" class="input" value="" maxlength="2" size="2">
					</td>					
					
				
				</tr>
				</table> 
				<table class="height_10"><tr><td></td></tr></table>
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Office & Other Condition</td></tr></table>
				<table class="search_sm2" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="90">&nbsp;&nbsp;Contract Ofc.</td>
					<td width="80"><input type="text" style="width:60;" class="input1" value="" name="ctrt_ofc_cd" dataformat="engup" maxlength="6"></td>
					<td width="50">Incl.Sub</td>
					<td width="100"><input type="checkbox" name="ctrt_ofc_sub" value="Y" class="trans"></td>
					<td width="90"> C/ Sales Rep.</td>
					<td width="120"><input type="text" style="width:60;" class="input" value="" name="ctrt_srep_cd" dataformat="engupnum" maxlength="6"></td>
					
					<td width="120"></td>
					<td width=""></td>
				</tr>
				<tr class="h23">
					<td width="90">&nbsp;&nbsp;Sales Ofc.</td>
					<td width="80"><input type="text" style="width:60;" class="input1" value="" name="ob_sls_ofc_cd" dataformat="engup" maxlength="6"></td>
					<td width="50">Incl.Sub</td>
					<td width="100"><input type="checkbox" name="ob_sls_ofc_sub" value="Y" class="trans"></td>
					<td width="90"> L/ Sales Rep.</td>
					<td width="120"><input type="text" style="width:60;" class="input" value="" name="ob_srep_cd" dataformat="engupnum" maxlength="6"></td>
					
					<td width="120"></td>
					<td width=""></td>
				</tr>
				
				<tr class="h23">
					<td width="90">&nbsp;&nbsp;BKG Ofc.</td>
					<td width="80"><input type="text" style="width:60;" class="input1" value="" name="bkg_ofc_cd" dataformat="engup" maxlength="6"></td>
					<td width="50">Incl.Sub</td>
					<td width="100"><input type="checkbox" name="bkg_ofc_sub" value="Y" class="trans"></td>
					<td width="90"> Shipper</td>
					<td width="120"><input type="text" style="width:60;" name="cust_cd" dataformat="engupnum" maxlength="8" class="input" value=""></td>
					<td width="120">Cancelled BKG Only</td>
					<td width=""><input type="checkbox" name="chk_cxl_bkg_only" value="Y" class="trans"></td>
					
				</tr>
				</table> 
				<table class="height_10"><tr><td></td></tr></table>
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Display Level on the Output result</td></tr></table>
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
				<td width="220">
					<table class="search_sm" border="0" style="width:100%;"> 
					<tr class="h23">
					<td width="120">&nbsp;&nbsp;Sales Rep.</td>
					<td width=""><input type="checkbox" name="dis_op" value="1" class="trans" checked></td>
					</tr>
					<tr class="h23">
					<td width="">&nbsp;&nbsp;Customer</td>
					<td width=""><input type="checkbox" name="dis_op" value="2" class="trans" checked></td>
					</tr>
					<!--  
					<tr class="h23">
					<td width="">&nbsp;&nbsp;S.Rep-Customer</td>
					<td width=""><input type="checkbox" name="dis_op" value="3" class="trans" checked></td>
					</tr>
					-->
					<tr class="h23">
					<td width="">&nbsp;&nbsp;CM</td>
					<td width=""><input type="checkbox" name="dis_op" value="3" class="trans" checked></td>
					</tr>
					</table>
				</td>
				<td width="20"></td>
				<td width="" >
					<table class="search_sm" border="0" style="width:100%;"> 
					<tr class="h23">
					<td width="90">Unit View  :</td>
					<td width=""><input type="radio"  name="unit_op" value="FEU" class="trans" >&nbsp;FEU&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio"  name="unit_op" value="TEU" class="trans" checked>&nbsp;TEU </td>
					</tr>
					<tr class="h23">
					<td width="">CM Cur  :</td>
					<td width=""><input type="text" name="cm_cur" style="width:50;" class="input" dataformat="int" value="0">&nbsp;USD</td>
					</tr>
					<tr class="h23">
					<td width="">Date upto  :</td>
					<td width="">Previous&nbsp; <select name="dis_days" style="width:45;" class="input">
							<option value="28" selected>28</option>
							<option value="27">27</option>
					        <option value="26">26</option>
							<option value="25">25</option>
							<option value="24">24</option>
							<option value="23">23</option>
							<option value="22">22</option>
							<option value="21">21</option>
							<option value="20">20</option>
							<option value="19">19</option>
							<option value="18">18</option>
							<option value="17">17</option>
							<option value="16">16</option>
							<option value="15">15</option>
							<option value="14">14</option>
							<option value="13">13</option>
							<option value="12">12</option>
							<option value="11">11</option>
							<option value="10">10</option>
							<option value="9">9</option>
							<option value="8">8</option>
							<option value="7">7</option>
							<option value="6">6</option>
							<option value="5">5</option>
							<option value="4">4</option>
							<option value="3">3</option>
							<option value="2">2</option>
							<option value="1">1</option>
							</select>&nbsp; Days</td>
					</tr>
					
					</table> 
				</td></tr>
					</table> 
			<td width="20">
			</td>
			<td width="419" valign="top">			
			<!-- Grid  (S) -->
			<!--  
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table> 
			-->
			<!-- Grid (E) -->
			<!--  Button_Sub (S) -->
			<!--  
			<table width="100%" class="button"> 			
	      	 	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_RowAdd">Row&nbsp;Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Delete">Row Del</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Delete">Load Exce</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td><img src="img/btn_2_left_up.gif" width="17" height="19" alt="" border="0"></td>
						<td class="btn2" name="">Seq.&nbsp;Up</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td><img src="img/btn_2_left_down.gif" width="17" height="19" alt="" border="0"></td>
						<td class="btn2" name="">Seq.&nbsp;Down</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>
			-->
	    	<!-- Button_Sub (E) -->
			</td></tr>
		</table>
	<!-- Grid BG Box  (S) -->
	
	<!--biz page (E)-->
	
	</td></tr>
		</table>
	</div>
<!--TAB 1 (E) --> 

<!--TAB 2 (S) -->
<div id="tabLayer" style="display:none">

<table class="search"> 
       	<tr><td class="bg">
				<table class="search" border="0">
				<tr>
					<td class="title_h"></td>
					<td>* D : Report Run Day(<span id="to_dt" caption="To DT" dataformat="ymd"></span>) * Daily History Record Time - AM 08:00(KST)</td>
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
			<!-- Grid (E) -->
	<!-- Grid BG Box  (S) -->
	
	<!--biz page (E)-->
	
	</td></tr>
		</table>

</div>

<div id="dTabLayer" style="display:none">

<table class="search"> 
       	<tr><td class="bg">
			
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table> 
			<!-- Grid (E) -->
	<!-- Grid BG Box  (S) -->
	
	<!--biz page (E)-->
	
	</td></tr>
		</table>

</div>

<!--TAB  2 (E) --> 

<!--Button (S) -->
		<table width="979" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name=btn_directDown2Excel>Direct Down Excel (B/L Detail)</td>
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
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_detail">B/L Detail</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
