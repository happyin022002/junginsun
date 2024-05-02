<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_cim_0001.jsp
*@FileTitle : EQ Operation Trend (Inventory Trend)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.30
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2009.04.30 김종준
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
<%@ page import="com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.event.EesCim0001Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesCim0001Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EesCim0001Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>EQ Operation Trend (Inventory Trend)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="inquiryLevel" value=""> 
<input type="hidden" name="location" value=""> 
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
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
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
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
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
	
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="80">Location by</td>
					<td width="220">
						<select style="width:115;" name="loc_type_code" class="input" ><!-- LOC_TYPE_CODE -->
							<option value="" selected>All (by RCC)</option>
							<option value="1">RCC (by LCC)</option>
							<option value="7">RCC (by ECC)</option>
							<option value="8">RCC (by SCC)</option>
							<option value="2">LCC (by ECC)</option>
							<option value="3">LCC (by SCC)</option>
							<option value="4">ECC (by SCC)</option>
							<option value="5">Country</option>
							<option value="6">SCC</option>
							<!-- loc_cd --> 
						</select> 
						<input type="text" class="input2" name="loc_cd" readOnly=true style="ime-mode:inactive" dataformat="engup" size="5" maxlength="5" fulfill  style="width:50;" class="input" value=""> <img class="cursor" src="img/btns_search.gif" name="btn_loc_cd" width="19" height="20" border="0" align="absmiddle">
					</td>
					<td width="40">Period</td>
					<td width="310">
						<select name="op_trnd_tp_cd" style="width:130;" class="input1">
							<option value="IM" selected>Month(YYYY-MM)</option>
							<option value="IW">Week(YYYY-WW)</option>
						</select>
						&nbsp;<input type="text" name="from_bse_dt" required maxlength="6" style="width:60;" dataformat="ym"  class="input1"  value="">&nbsp;~&nbsp;<input type="text" name="to_bse_dt" style="width:60;" required maxlength="6" dataformat="ym"  class="input1" value="">
					</td>
					<td width="45">TP/SZ</td>
					<td width="140">
						<script language="javascript">ComComboObject('cntr_tpsz_cd', 1, 115, 1);</script>
						<!-- input type="checkbox" class="input2" name="chk_cntr_tpsz_cd" readOnly=true  class="input" value=""> -->					
					</td>
					<td width="60">Company</td>
					<td>
						<input type="text" class="input" name="tem_co_cd" readOnly=true style="width:30;text-align:center;" class="input" value="SML">
						<input type="hidden" name="co_cd" value="H">
					</td>
					
				</tr> 
				

				</table>
				<!--  biz_1   (E) -->
				
				</td></tr>
			</table>
			<table class="height_10"><tr><td colspan="8"></td></tr></table>
			
			
		<!-- Tab ) (S) -->
     		<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%> 
       		<tr><td width="100%">
						<script language="javascript">ComTabObject('tab1')</script>
						<!-- img src="img/sub_tab.gif" alt="" width="998" height="23" border="0" -->
					</td></tr>
				</table>
		<!-- Tab ) (E) --> 
		
		
		
<!--TAB Inventory (S) -->

<div id="tabLayer" style="display:inline">
		
		<!-- Tab BG Box  (S) -->
     	<table class="search"> 
       	<tr><td class="bg">
			
			<!-- Grid  (S) -->
			<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject1('t1sheet1');</script>
					</td>
				</tr>
			</table>
			<!-- Grid (E) -->
			<!--  Grid_button (S) -->
			</td></tr>
		</table>
	<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->

</div>

<!--TAB Inventory (E) -->

<!--TAB Long Staying (S) -->

<div id="tabLayer" style="display:none">

		<!-- Tab BG Box  (S) -->
     	<table class="search"> 
       	<tr><td class="bg">
			<table class="search_sm2">
				<tr class="h23"><td width="70">Full/MTY</td>
					<td class="stm"><input type="radio" name="long_stay_cd" checked value="ALL" class="trans">All&nbsp;&nbsp;&nbsp;<input type="radio" name="long_stay_cd" value="FULL" class="trans">Full&nbsp;&nbsp;&nbsp;<input type="radio" name="long_stay_cd" value="MTY" class="trans">MTY</td>
				</tr>
			</table>
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject1('t2sheet1');</script>
						</td>
					</tr>
				</table>
			<!-- Grid (E) -->

			<!--  Grid_button (S) -->
			</td></tr>
		</table>
	<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->

</div>
			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_match_back">Match Back</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_turn_time">Turn Time</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->

<!--TAB Long Staying (E) -->


<!--TAB Match Back (S) -->

<div id="tabLayer" style="display:none">
		<!-- Tab BG Box  (S) -->
     	<table class="search"> 
       	<tr><td class="bg">
			
			<!-- Grid  (S) -->
			<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%" height="380">
					</td>
				</tr>
			</table>
			<!-- Grid (E) -->
			<!--  Grid_button (S) -->
			</td></tr>
		</table>
		
</div>

<!--TAB Match Back (E) -->	


<!--TAB Turn Time (S) -->

<div id="tabLayer" style="display:none">

			<!-- Tab BG Box  (S) -->
     	<table class="search"> 
       	<tr><td class="bg">
			
			<!-- Grid  (S) -->
			<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%" height="380">
					</td>
				</tr>
			</table>
			<!-- Grid (E) -->
			<!--  Grid_button (S) -->
			</td></tr>
		</table>

</div>

<!--TAB Turn Time (E) -->





<table class="height_10"><tr><td colspan="8"></td></tr></table>

	</td></tr>
</table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>