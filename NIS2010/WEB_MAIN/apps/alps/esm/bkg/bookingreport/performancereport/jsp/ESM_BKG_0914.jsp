<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0914.jsp
*@FileTitle : Port Closing Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.08.17 김기종
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0914Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0914Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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


		event = (EsmBkg0914Event)request.getAttribute("Event");
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
<title>Port Closing Inquiry</title>
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
<input type="hidden" name="sel_bkg_ofc_cd">

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
				<tr class="h23">
					<td width="370">
						<table class="search_sm2" border="0" style="width:350;"> 
							<tr class="h23">
								<td width="110">
								<input type="radio" name="dt_type" value="PCT" class="trans" checked> PCT&nbsp;&nbsp;
								<input type="radio" name="dt_type" value="ETD" class="trans"> ETD</td>
								<td>
								<input type="text" name="fr_dt" style="width:80;" class="input1" value=""   dataformat="ymd" caption="Start Date" maxlength="10"  cofield="to_dt" required>
								&nbsp;~&nbsp;
								<input type="text" name="to_dt" style="width:80;" class="input1" value=""    dataformat="ymd" caption="End Date" maxlength="10"  cofield="fr_dt" required>
								<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"  style="cursor:hand" onClick="callDatePop('BKG_DATE')">
								</td>
							</tr>
						</table>
					</td>
					<td width="30">RHQ</td>
					<td width="90">
						<script language="javascript">ComComboObject('rhq_cd', 1, 70, 0,1,0);</script>
					</td>
					
					<td width="30">GSO</td>
					<td width="90">
						<input type="text" name="gso" style="width:50;" class="input" value="" style="ime-mode:disabled" dataformat="engup"  caption="GSO" maxlength="6" >
					</td>
						
					<td width="90">Booking Office</td>
					<td width="90">
						<input type="text" name="bkg_ofc_cd" style="width:60;" value="" style="ime-mode:disabled" dataformat="engup"  caption="BKG Office" maxlength="6" >
					</td>
					<td width="90">Booking Staff</td>
					<td width="">
						<script language="javascript">ComComboObject('bkg_staff',2, 80, 0,0,0,true);</script>
					</td>
				</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					
					<td width="35">&nbsp;&nbsp;VVD</td>
					<td width="95">
						<input type="text" name="vvd_cd"   style="width:80;" class="input" value="" style="ime-mode:disabled" dataformat="uppernum"  caption="VVD" maxlength="9" fullfill >
					</td>
					<td width="25">POL</td>
					<td width="65">
						<input type="text" name="pol_cd"  style="width:50;" value="" style="ime-mode:disabled" dataformat="uppernum"  caption="POL" maxlength="5" fullfill >
					</td>
					<td width="35">Lane</td>
                    <td width="85">
                    	<script language="javascript">ComComboObject("slan_cd",2,70,0,0,0);</script>
                    </td>	
					<td width="100">Booking Status</td>
					<td width="85">
						<script language="javascript">ComComboObject('bkg_sts_cd', 1, 70, 0,0,0);</script>
					</td>
					<td width="90">Rating Status</td>
					<td width="117">
						<script language="javascript">ComComboObject('bkg_rt_sts_cd',1,102, 0,0,1,true);</script>
					</td>
					<td width="25">REV</td>
					<td width="65">
						<select name="rev_status" style="width:50;">
						<option value="" selected>All</option>
						<option value="Y">Y</option>
						<option value="N">N</option>
						</select>
					</td>
					<td width="85">CNTR Confirm</td>
					<td width="*">
						<select name="cntr_cfm" style="width:50;">
						<option value="" selected>All</option>
						<option value="Y">Y</option>
						<option value="N">N</option>
						</select>
					</td>
				</tr>
				</table>
				<!--  biz_1   (E) -->
												
				
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>	
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="480" valign="top">
						<table class="search_sm2" width="480" style="height:100%"><tr><td valign="top">
						
				
						<table class="search" border="0">
						<tr><td class="title_h"></td>
							<td class="title_s">Office List</td></tr>
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
						
						<table class="height_10"><tr><td colspan="8"></td></tr></table>
						
						<!-- Grid  (S) -->
						<table width="480"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet2');</script>
								</td>
							</tr>
						</table>
						<!-- Grid (E) -->
						<!--  Button_Sub (S) -->
						<table width="100%" class="button"> 
	       					<tr><td class="btn2_bg">
								<table border="0" cellpadding="0" cellspacing="0"><tr>
									<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td>
									<td class="btn2" name="btn_Office">Office</td>
									<td class="btn2_right"></td>
									</tr>
									</table></td>
									
								</tr></table>
							</td></tr>
						</table>
						<!--Button_Sub (E)-->
						</td></tr></table>
						
					</td>
					<td width="19"></td>
					
					<td width="480" valign="top">
						<table class="search_sm2" width="480"><tr><td valign="top">
					
						<table class="search" border="0">
						<tr><td class="title_h"></td>
							<td class="title_s">B/L List</td></tr>
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
						
						<table class="height_5"><tr><td colspan="8"></td></tr></table>
						
						<table style="width:450" class="search" border="0">
							<tr>
								<td width="30%">&nbsp;</td> 
								<td width="15%" align="center">Total		</td>
								<td width="6%">&nbsp;</td>
								<td width="15%" align="center">Firm			</td>
								<td width="6%">&nbsp;</td>
								<td width="*" align="center">Balance</td>	
								</tr>
						</table> 
						<table width="450" class="grid2"> 
							<tr>
								<td width="30%" class="tr2_head">Booking Status</td> 
								<td width="15%" align="center" class="input2">	<input type="text" name="bk_tot_cnt"  style="width:60;text-align:right" class="input2" value="0" readonly>		</td>
								<td width="6%" align="center" class="input2">-	</td>
								<td width="15%" align="center" class="input2"><input type="text" name="bk_charge_cnt" style="width:60;text-align:right" class="input2" value="0" readonly>	</td>
								<td width="6%" align="center" class="input2">=	</td>
								<td width="15%" align="center" class="input2"><input type="text" name="bk_non_charge_cnt" style="width:60;text-align:right" class="input2" value="0" readonly>	</td>
								<td width="*" align="center" class="input2"><input type="text" name="bk_percent" style="width:60;text-align:right" class="input2" value="0%">	</td>		
								</tr>
						</table> 
						
						<table class="height_5"><tr><td colspan="8"></td></tr></table>
						
						<table style="width:450" class="search" border="0"> 
							<tr>
								<td width="30%"> </td> 
								<td width="15%" align="center">Total		</td>
								<td width="6%"></td>
								<td width="15%" align="center">  Charged					</td>
								<td width="6%">	</td>
								<td align="center" colspan="2">Non-Charged	</td>	
								</tr>
						</table> 
						<table width="450" class="grid2"> 
							<tr>
								<td width="30%" class="tr2_head">Rating Status	</td> 
								<td width="15%" align="center" class="input2"><input type="text" name="rt_tot_cnt" style="width:60;text-align:right" class="input2" value="0" readonly></td>
								<td width="6%" align="center" class="input2">-	</td>
								<td width="15%" align="center" class="input2"><input type="text" name="rt_charge_cnt" style="width:60;text-align:right" class="input2" value="0" readonly>	</td>
								<td width="6%" align="center" class="input2">=	</td>
								<td width="15%" align="center" class="input2"><input type="text" name="rt_non_charge_cnt" style="width:60;color:red;text-align:right" class="input2" value="0" readonly>	</td>
								<td width="%" align="center" class="input2"><input type="text" name="rt_percent" style="width:60;color:red;text-align:right" class="input2" value="0%" readonly></td>		
								</tr>
						</table> 
						<table class="height_5"><tr><td colspan="5"></td></tr></table>
						
						<table style="width:450" class="search" border="0"> 
							<tr>
								<td width="30%"> </td> 
								<td width="15%" align="center">Total</td>
								<td width="21%" align="center">CNTR Firmed</td>
								<td width="6%">	</td>
								<td align="center" colspan="2">Non-Confirmed</td>	
								</tr>
						</table> 
						<table width="450" class="grid2"> 
							<tr>
								<td width="30%" class="tr2_head">CNTR Confirm Status</td> 
								<td width="15%" align="center" class="input2"><input type="text" name="cntr_tot_cnt" style="width:60;text-align:right" class="input2" value="0" readonly></td>
								<td width="6%" align="center" class="input2">-	</td>
								<td width="15%" align="center" class="input2"><input type="text" name="cntr_cfm_cnt" style="width:60;text-align:right" class="input2" value="0" readonly>	</td>
								<td width="6%" align="center" class="input2">=	</td>
								<td width="15%" align="center" class="input2"><input type="text" name="cntr_noncfm_cnt" style="width:60;color:red;text-align:right" class="input2" value="0" readonly>	</td>
								<td width="*" align="center" class="input2"><input type="text" name="cntr_percent" style="width:60;color:red;text-align:right" class="input2" value="0%" readonly></td>		
								</tr>
						</table> 
						
						<table class="height_8"><tr><td colspan="8"></td></tr></table>
						
						<!--  Button_Sub (S) -->
						<table width="100%" class="button"> 
	       					<tr><td class="btn2_bg">
								<table border="0" cellpadding="0" cellspacing="0"><tr>
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td>
									<td class="btn2" name="btn_BookingDetail">Booking Detail</td>
									<td class="btn2_right"></td>
									</tr>
									</table></td>
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td>
									<td class="btn2" name="btn_Charge">Charge</td>
									<td class="btn2_right"></td>
									</tr>
									</table></td>
								</tr></table>
							</td></tr>
						</table>
	    				<!-- Button_Sub (E) -->
						
						
						</td></tr></table>
						
					</td>
				</tr>
				</table>
			
				</td></tr>
			</table>
				
		
			<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
		    	<td width="">
					<table class="search" border="0" style="width:250;"> 
						<tr class="h23">
						<td class="">
							<input type="checkbox" name="down_tp_o"  value="OFC" class="trans" >OFC list&nbsp;&nbsp;
							<input type="checkbox" name="down_tp_b"  value="BL" class="trans" >BL list&nbsp;&nbsp;
							<input type="checkbox" name="down_tp_t"  value="TOT" class="trans" >BL total
						</td>
						
						</tr>
					</table>
				
				</td>
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
					<td class="btn1" name="btn_DownExcel">Down Excel</td>
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
	
	</td></tr>
</table>
<!-- Grid  (S) -->
<table width="100%"  id="mainTable" style="display:none;"> 
	<tr>
		<td width="100%">
			<script language="javascript">ComSheetObject('sheet4');</script>
		</td>
	</tr>
</table>
<!-- Grid (E) -->	

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>