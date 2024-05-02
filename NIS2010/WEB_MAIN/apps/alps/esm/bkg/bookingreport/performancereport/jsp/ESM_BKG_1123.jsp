<%
/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESM_BKG_1123.jsp
*@FileTitle : TRO Status List(EUR)
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.22
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2011.06.22 채창호
* 1.0 Creation
* history
* 2011.07.25 채창호 CHM-201111754-01:[UI_BKG_1123]TRO Status Report (EUR) 화면 개발
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg1123Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1123Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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


		event = (EsmBkg1123Event)request.getAttribute("Event");
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
<title>TRO Status List</title>
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
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			

				<!--  biz_1 (S) -->
				<table class="search_sm2" border="0" style="width:400;"> 
					<tr class="h23">
						<td width="83">&nbsp;TRO Type</td>
						<td class="stm"><input type="radio" name="io_bnd_cd" value="O" class="trans" checked>&nbsp;&nbsp;TRO/O (Outbound)  &nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="io_bnd_cd" value="I" class="trans" >&nbsp;&nbsp;TRO/I (Inbound)
						</td></tr>
				</table>
				
				<table class="search" border="0" style="width:1000;"> 
					<tr class="h23">
						<td width="70">Door Date</td>
						<td width="233">
							<input type="text" name="door_dt_fr" style="width:75;" class="input" value=""   dataformat="ymd" caption="DOOR Start Date" maxlength="10" cofield="door_dt_fr" onFocus="this.select();">
							&nbsp;~&nbsp;
							<input type="text" name="door_dt_to" style="width:75;" class="input" value=""    dataformat="ymd" caption="DOOR End Date" maxlength="10" cofield="door_dt_to" onFocus="this.select();">&nbsp;
							<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"  style="cursor:hand" onClick="callDatePop('DOOR_DATE')">
						</td>
						<td width="70">TRO Office</td>
						<td width="105">
							<input type="text" name="tro_ofc_cd" style="width:80;" value="" style="ime-mode:disabled" dataformat="engup"  caption="TRO Office" maxlength="6" >
						</td>
						<td width="53">B/L No. </td>
						<td width="130"><input type="text" class="input"  name="bl_no" style="width:100;" value="" style="ime-mode:disabled" dataformat="uppernum"  caption="B/L NO." maxlength="12" fullfill>
						</td>
						<td width="75">BKG Status</td>
						<td width="135">
							<script language="javascript">ComComboObject('bkg_sts_cd', 2, 100, 1, 0, 2);</script>&nbsp;<img src="img/btns_multisearch.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
						<td width="65">TRO Staff</td>
						<td width="" align="right">
							<!--<script language="javascript">ComComboObject('bkg_staff',2, 80, 0,0,0,true);</script>-->
							<input type="text" name="tro_staff" style="width:80;" value="" style="ime-mode:disabled"   caption="TRO Staff" maxlength="20" fullfill>
						</td>
					</tr>
				</table>
				<table class="search" border="0" style="width:1000;"> 
					<tr class="h23">
						<td width="30">VVD</td>
						<td width="99"><input type="text" name="vvd_cd"   style="width:80;" class="input" value="" style="ime-mode:disabled" dataformat="uppernum"  caption="VVD" maxlength="9" fullfill ></td>
						<td width="25">POL</td>
						<td width="80"><input type="text" name="pol_cd"  style="width:60;" value="" style="ime-mode:disabled" dataformat="uppernum"  caption="POL" maxlength="5" fullfill ></td>
						<td width="25">POD</td>
						<td width="80"><input type="text" name="pod_cd"  style="width:60;" value="" style="ime-mode:disabled" dataformat="uppernum"  caption="POD" maxlength="5" fullfill ></td>
						<td width="36">Location</td>
						<td width="130">
						<input type="text" name="loc_cd" style="width:60;" value="" style="ime-mode:disabled" dataformat="engup"  caption="Location" maxlength="6" >
						<input type="text" name="loc_yd_cd" style="width:40;" value="" style="ime-mode:disabled" dataformat="uppernum"  caption="Location" maxlength="2" fullfill>	
						</td>
						<td width="50">Customer</td>
						<td width="208">
							<input type="text" name="cust_cnt_cd" style="width:25;" value="" style="ime-mode:disabled" dataformat="engup"  caption="Country Code" maxlength="2" fullfill>
							<input type="text" name="cust_seq" style="width:60;" value="" style="ime-mode:disabled" dataformat="int"  caption="Cust Seq" maxlength="6">
							<input type="text" name="cust_nm"  style="width:90;" value="" style="ime-mode:disabled"  maxlength="20" onKeyUp="javascript:upper(this);"></td>
						<td width="90">
							<table border="0" style="width:85;"> 
								<tr class="h23">
									<td>
										<input type="checkbox" name="dcgo_flg" value= "DG"  class="trans">DG&nbsp;
										<input type="checkbox" name="rc_flg"   value= "RF"  class="trans">RF&nbsp;
										<input type="checkbox" name="awk_cgo_flg" value= "AK"  class="trans">AK&nbsp;
										<input type="checkbox" name="bb_cgo_flg" value= "BB"  class="trans">BB&nbsp;
										<input type="checkbox" name="so_flg" value="Y" class="trans">S/O&nbsp;
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
				
				<table class="search" border="0" style="width:1000;"> 
					<tr class="h23">
						<td width="63">BKG Date</td>
						<td width="230">
						<input type="text" name="bkg_dt_fr" style="width:75;" class="input" value=""   dataformat="ymd" caption="BKG Start Date" maxlength="10"  cofield="bkg_dt_to" onFocus="this.select();">
						~&nbsp;<input type="text" name="bkg_dt_to" style="width:75;" class="input" value=""    dataformat="ymd" caption="BKG End Date" maxlength="10"  cofield="bkg_dt_fr" onFocus="this.select();">
						<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"  style="cursor:hand" onClick="callDatePop('BKG_DATE')">
						</td>
							<td width="135">P/Up Request Date</td>
						<td width="232">
							<input type="text" name="pup_dt_fr" style="width:75;" class="input" value=""   dataformat="ymd" caption="P/Up Request Start Date" maxlength="10" size="10" cofield="pup_dt_to" onFocus="this.select();">
							&nbsp;~&nbsp;
							<input type="text" name="pup_dt_to" style="width:75;" class="input" value=""  dataformat="ymd" caption="P/Up Request End Date" maxlength="10" size="10" cofield="pup_dt_fr" onFocus="this.select();">&nbsp;
							<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"  style="cursor:hand" onClick="callDatePop('PUP_DATE')">
						<td width="60">P/Up CY</td>
						<td width="145">
							<input type="text" name="pkup_loc_cd" style="width:60;" value="" style="ime-mode:disabled" dataformat="uppernum"  caption="P/Up CY" maxlength="5" fullfill>
							<input type="text" name="pkup_yd_cd" style="width:40;" value="" style="ime-mode:disabled" dataformat="uppernum"  caption="P/Up CY" maxlength="2" fullfill></td>
						<td width="75">Return CY</td>
						<td width="130">
							<input type="text" name="rcv_term_cd" style="width:60;" value="" style="ime-mode:disabled" dataformat="engup"  caption="Return CY" maxlength="6" >
							<input type="text" name="rcv_term_yd_cd" style="width:40;" value="" style="ime-mode:disabled" dataformat="uppernum"  caption="Return CY" maxlength="2" fullfill></td>
							
					</tr>
				</table>
				<!--  biz_1   (E) -->		
			
		</td></tr></table>
		<table class="height_8"><tr><td></td></tr></table>	
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
			
			
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
			<!-- Grid (E) -->			
			
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			

			<table border="0" style="width:990; background-color:white;" class="grid2"> 
			<tr><td width="3%" align="center" class="tr2_head">D2</td>
				<td width="3%" align="center"><input type="text" name="d2" style="width:100%;text-align:right" value="0" class="input2" readonly></td> 
				<td width="3%" align="center" class="tr2_head">D4</td>
				<td width="3%" align="center"><input type="text" name="d4" style="width:100%;text-align:right" value="0" class="input2" readonly></td>
				<td width="3%" align="center" class="tr2_head">D5</td>
				<td width="3%" align="center"><input type="text" name="d5" style="width:100%;text-align:right" value="0" class="input2" readonly></td>
				<td width="3%" align="center" class="tr2_head">D7</td>
				<td width="3%" align="center"><input type="text" name="d7" style="width:100%;text-align:right" value="0" class="input2" readonly></td>
				<td width="3%" align="center" class="tr2_head">D8</td>
				<td width="3%" align="center"><input type="text" name="d8" style="width:100%;text-align:right" value="0" class="input2" readonly></td>
				<td width="3%" align="center" class="tr2_head">D9</td>
				<td width="3%" align="center"><input type="text" name="d9" style="width:100%;text-align:right" value="0" class="input2" readonly></td>
				<td width="3%" align="center" class="tr2_head">DW</td>
				<td width="3%" align="center"><input type="text" name="dw" style="width:100%;text-align:right" value="0" class="input2" readonly></td>
				<td width="3%" align="center" class="tr2_head">DX</td>
				<td width="3%" align="center"><input type="text" name="dx" style="width:100%;text-align:right" value="0" class="input2" readonly></td>
				<td width="3%" align="center" class="tr2_head">R2</td>
				<td width="3%" align="center"><input type="text" name="r2" style="width:100%;text-align:right" value="0" class="input2" readonly></td>
				<td width="3%" align="center" class="tr2_head">R4</td>
				<td width="3%" align="center"><input type="text" name="r4" style="width:100%;text-align:right" value="0" class="input2" readonly></td>
				<td width="3%" align="center" class="tr2_head">R5</td>
				<td width="3%" align="center"><input type="text" name="r5" style="width:100%;text-align:right" value="0" class="input2" readonly></td>
				<td width="3%" align="center" class="tr2_head">R9</td>
				<td width="3%" align="center"><input type="text" name="r9" style="width:100%;text-align:right" value="0" class="input2" readonly></td>
				<td width="3%" align="center" class="tr2_head">F2</td>
				<td width="3%" align="center"><input type="text" name="f2" style="width:100%;text-align:right" value="0" class="input2" readonly></td>
				<td width="3%" align="center" class="tr2_head">F4</td>
				<td width="3%" align="center"><input type="text" name="f4" style="width:100%;text-align:right" value="0" class="input2" readonly></td>
				<td width="3%" align="center" class="tr2_head">F5</td>
				<td width="3%" align="center"><input type="text" name="f5" style="width:100%;text-align:right" value="0" class="input2" readonly></td>
			    
			</tr>
			<tr><td align="center" class="tr2_head">O2</td>
				<td align="center"><input type="text" name="o2" style="width:100%;text-align:right" value="0" class="input2" readonly></td> 
				<td align="center" class="tr2_head">O4</td>
				<td align="center"><input type="text" name="o4" style="width:100%;text-align:right" value="0" class="input2" readonly></td> 
				<td align="center" class="tr2_head">O5</td>
				<td align="center"><input type="text" name="o5" style="width:100%;text-align:right" value="0" class="input2" readonly></td> 
				<td align="center" class="tr2_head">S2</td>
				<td align="center"><input type="text" name="s2" style="width:100%;text-align:right" value="0" class="input2" readonly></td> 
				<td align="center" class="tr2_head">S4</td>
				<td align="center"><input type="text" name="s4" style="width:100%;text-align:right" value="0" class="input2" readonly></td> 
				<td align="center" class="tr2_head">T2</td>
				<td align="center"><input type="text" name="t2" style="width:100%;text-align:right" value="0" class="input2" readonly></td> 
				<td align="center" class="tr2_head">T4</td>
				<td align="center"><input type="text" name="t4" style="width:100%;text-align:right" value="0" class="input2" readonly></td> 
				<td align="center" class="tr2_head">A2</td>
				<td align="center"><input type="text" name="a2" style="width:100%;text-align:right" value="0" class="input2" readonly></td> 
				<td align="center" class="tr2_head">A4</td>
				<td align="center"><input type="text" name="a4" style="width:100%;text-align:right" value="0" class="input2" readonly></td>
				<td align="center" class="tr2_head">A5</td> 
				<td align="center"><input type="text" name="a5" style="width:100%;text-align:right" value="" class="input2" readonly></td>				 
				<td align="center" class="tr2_head">P2</td>
				<td align="center"><input type="text" name="p2" style="width:100%;text-align:right" value="0" class="input2" readonly></td> 
				<td align="center" class="tr2_head">P4</td>
				<td align="center"><input type="text" name="p4" style="width:100%;text-align:right" value="0" class="input2" readonly></td> 
				<td align="center" class="tr2_head">Z2</td>
				<td align="center"><input type="text" name="z2" style="width:100%;text-align:right" value="0" class="input2" readonly></td> 
				<td align="center" class="tr2_head">Z4</td>
				<td align="center"><input type="text" name="z4" style="width:100%;text-align:right" value="0" class="input2" readonly></td>  
				<td align="center" class="tr2_head"></td>
				<td align="center"><input type="text" name="" style="width:100%;text-align:right" value="" class="input2" readonly></td>
			</tr>
			<tr>  
				<td align="center" class="tr2_head"></td>
				<td align="center"><input type="text" name="" style="width:100%;text-align:right" value="" class="input2" readonly></td> 
				<td align="center" class="tr2_head"></td>
				<td align="center"><input type="text" name="" style="width:100%;text-align:right" value="" class="input2" readonly></td> 
				<td align="center" class="tr2_head"></td>
				<td align="center"><input type="text" name="" style="width:100%;text-align:right" value="" class="input2" readonly></td> 
				<td align="center" class="tr2_head"></td>
				<td align="center"><input type="text" name="" style="width:100%;text-align:right" value="" class="input2" readonly></td> 
				<td align="center" class="tr2_head"></td>
				<td align="center"><input type="text" name="" style="width:100%;text-align:right" value="" class="input2" readonly></td> 
				<td align="center" class="tr2_head"></td>
				<td align="center"><input type="text" name="" style="width:100%;text-align:right" value="" class="input2" readonly></td> 
				<td align="center" class="tr2_head"></td>
				<td align="center"><input type="text" name="" style="width:100%;text-align:right" value="" class="input2" readonly></td> 
				<td align="center" class="tr2_head"></td>
				<td align="center"><input type="text" name="" style="width:100%;text-align:right" value="" class="input2" readonly></td> 
				<td align="center" class="tr2_head"></td>
				<td align="center"><input type="text" name="" style="width:100%;text-align:right" value="" class="input2" readonly></td> 
				<td align="center" class="tr2_head"></td>
				<td align="center"><input type="text" name="" style="width:100%;text-align:right" value="" class="input2" readonly></td> 
				<td align="center" class="tr2_head"></td>
				<td align="center"><input type="text" name="" style="width:100%;text-align:right" value="" class="input2" readonly></td> 
				<td align="center" class="tr2_head"></td>
				<td align="center"><input type="text" name="" style="width:100%;text-align:right" value="" class="input2" readonly></td>
				<td align="center" class="tr2_head3" colspan="5"><b>TTL BKG Qty</b></td>
				<td align="center" class="tr2_head3" colspan="2"><input type="text" name="tot_sum" style="width:100%;text-align:right" value="0" class="input2" readonly></td>
			</tr>
			</table>

			
			</td></tr>
		</table>
		<!--biz page (E)-->

	   
	<!-- Grid BG Box  (S) -->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;"> 
       	<tr><td class="btn1_bg">
		   <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_retrieve" >Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0"	class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DownExcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	<!--biz page (E)-->
		
	
	
	</td></tr>
</table>
	

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>