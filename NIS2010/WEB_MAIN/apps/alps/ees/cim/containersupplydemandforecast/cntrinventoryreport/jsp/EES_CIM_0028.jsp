<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CIM_0028.jsp
*@FileTitle : Stock Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.12
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2009.08.12 김종준
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
<%@ page import="com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.event.EesCim0028Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>



<%
	EesCim0028Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String fm_date = DateTime.addDays(DateTime.getDateString(),-7,"yyyy.MM.dd");
	String chk_date = DateTime.addDays(DateTime.getDateString(),-90,"yyyy.MM.dd");
	fm_date = fm_date.replace(".","-");
	chk_date = chk_date.replace(".","-");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
		event = (EesCim0028Event)request.getAttribute("Event");
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
<title>Stock Report</title>
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

<input type="hidden" name="param_loc_cd">
<input type="hidden" name="param_loc_type_code">
<input type="hidden" name="param_cntr_tpsz_cd">
<input type="hidden" name="param_fm_stk_jb_dt">
<input type="hidden" name="param_to_stk_jb_dt">

<input type="hidden" name="chk_date" value="<%=chk_date%>">

<input type="hidden" name="inquiryLevel" value=""> 
<input type="hidden" name="location" value=""> 
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->
	<tr><td valign="top">
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
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
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
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="60">Location</td>
					<td width="120"><input type="text" name="loc_cd" style="ime-mode:inactive" dataformat="engup" size="5" maxlength="5" fulfill required style="width:50;" class="input1" value="">&nbsp;<img class="cursor" src="img/btns_search.gif" name="btn_loc_cd" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="260">
						<table width="220" class="search_sm2" border="0"> 
							<tr class="h23">
								<td><input type="radio" name="loc_type_code" value="1" class="trans">RCC&nbsp;&nbsp;<input type="radio" name="loc_type_code" value="2" class="trans">LCC&nbsp;&nbsp;<input type="radio" name="loc_type_code" value="3" class="trans">ECC&nbsp;&nbsp;<input type="radio" name="loc_type_code" value="4" class="trans" checked>SCC</td>
							</tr>
						</table>
						
					</td>
					<td width="45">TP/SZ</td>
					<td width="160">
						<script language="javascript">ComComboObject('cntr_tpsz_cd', 1, 115, 1);</script>
						<!-- <input type="checkbox" class="input2" name="chk_cntr_tpsz_cd" readOnly=true  class="input" value=""> -->					
					
					</td>
					<td width="50">Period</td>
					<td class="stm">&nbsp;<input type="text" name="fm_stk_jb_dt" style="width:80;" class="input1" caption="Period FM" dataformat="ymd" size="10" maxlength="10" fulfill required value="<%=fm_date %>">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendarfm"  id="btns_calendarfm">&nbsp;~&nbsp;&nbsp;&nbsp;<input type="text" name="to_stk_jb_dt" caption="Period To" dataformat="ymd" size="10" maxlength="10" fulfill style="width:80;" class="input" value="">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendarto"  id="btns_calendarto"></td></tr>
				</table>
				<!--  biz_1   (E) -->
				
				</td></tr>
			</table>
			<table class="height_8"><tr><td colspan="8"></td></tr></table>

		
			<!-- Tab BG Box  (S) -->
	     	<table class="search"> 
	       	<tr><td class="bg">
				
				
				<!-- Grid - 1 (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table> 				

				<!-- Grid - 1 (E) -->
				<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_cntrdata">CNTR&nbsp;Data</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_duedata">Due Data</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_detail">Detail</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
				</td></tr>
			</table>
		<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->
	
	
<table class="height_10"><tr><td colspan="8"></td></tr></table>
	</td></tr>
</table>
</form>
</body>
</html>
