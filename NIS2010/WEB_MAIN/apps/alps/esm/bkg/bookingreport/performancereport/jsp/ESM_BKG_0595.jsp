<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0595.jsp
*@FileTitle : Freight & Charge Summary Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.19
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.06.19 김기종 
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0595Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0595Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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


		event = (EsmBkg0595Event)request.getAttribute("Event");
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
<title>Freight & Charge Summary Report</title>
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
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="80">Booking No.</td>
						<td width="195"><input type="text" style="width:100;" name="bkg_no" value="" class="input" style="ime-mode:disabled" dataformat="uppernum" caption="Booking No." maxlength="13"  fullfill></td>
						<td width="50">B/L No.</td>
						<td width="230"><input type="text" style="width:110;" name="bl_no" value="" class="input" style="ime-mode:disabled" dataformat="uppernum" caption="B/L No." maxlength="13"  fullfill></td>
						<td width="33">Lane</td>
						<td width="135"><input type="text" style="width:60;" name="slan_cd" value="" class="input" style="ime-mode:disabled" dataformat="engup" caption="Lane" maxlength="3"  fullfill></td>
						<td width="30">VVD</td>
						<td><input type="text" style="width:90;" name="vvd_cd" value="" class="input1" style="ime-mode:disabled" dataformat="uppernum" caption="VVD CD" maxlength="9" required fullfill></td></tr>
					<tr class="h23">
						<td>POL</td>
						<td class="stm"><input type="text" style="width:60;" name="pol_cd"  value="" class="input" style="ime-mode:disabled" dataformat="uppernum" caption="POL" maxlength="5"  fullfill>&nbsp;(<input type="checkbox" name="pre_rly_port_cd" class="trans">&nbsp;Local)</td>
						<td>POD</td>
						<td class="stm"><input type="text" style="width:60;" name="pod_cd"  value="" class="input" style="ime-mode:disabled" dataformat="uppernum" caption="POD" maxlength="5"  fullfill>&nbsp;(<input type="checkbox" name="pst_rly_port_cd"  class="trans">&nbsp;Local)</td>
						<td>POR</td>
						<td><input type="text" style="width:60;" name="por_cd"  value="" class="input" style="ime-mode:disabled" dataformat="uppernum" caption="POR" maxlength="5"  fullfill></td>
						<td>DEL</td>
						<td><input type="text" style="width:60;" name="del_cd"  value="" class="input" style="ime-mode:disabled" dataformat="uppernum" caption="DEL" maxlength="5"  fullfill></td>
					</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="80">Sales Office</td>
						<td width="413"><input type="text" style="width:60;" name="ob_sls_ofc_cd"  value="" class="input" style="ime-mode:disabled" dataformat="engup" caption="Sales Office" maxlength="5"  fullfill></td>
						<td width="95">Booking Office</td>
						<td><input type="text" style="width:60;" name="bkg_ofc_cd"  value="" class="input" style="ime-mode:disabled" dataformat="engup" caption="Booking Office" maxlength="5"  fullfill></td></tr>
					<tr><td height="3"></td></tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="580">
						
							<table class="search_sm2" border="0" width="550">
								<tr class="h23">
									<td width="75">Customer</td>
									<td width="340" class="stm">
										<input type="checkbox" name="cust_tp_cd" value= "S" class="trans">&nbsp;SHPR&nbsp;&nbsp;
										<input type="checkbox" name="cust_tp_cd" value= "C" class="trans">&nbsp;CNEE&nbsp;&nbsp;
										<input type="checkbox" name="cust_tp_cd" value= "N" class="trans">&nbsp;NTFY&nbsp;&nbsp;
										<input type="checkbox" name="cust_tp_cd" value= "A" class="trans">&nbsp;ANFY&nbsp;&nbsp;
										<input type="checkbox" name="cust_tp_cd" value= "F" class="trans">&nbsp;FWDR&nbsp;</td>
									<td class="stm">
									<input type="text" style="width:25;" name="cust_cnt_cd"  value="" class="input" style="ime-mode:disabled" dataformat="engup" caption="Country" maxlength="2" >&nbsp;<input type="text" style="width:60;" name="cust_seq" value="" class="input" style="ime-mode:disabled" dataformat="int" caption="Cust" maxlength="6">&nbsp;<img src="img/btns_search.gif" name="btn_ComEns041Pop" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
								</tr>
							</table>

						
						</td>
						<td align="right">
						
							<table class="search_sm2" border="0" width="370">
								<tr class="h23">
									<td width="70">&nbsp;&nbsp;Special</td>
									<td class="stm">
										<input type="checkbox" name="dcgo_flg" value= "Y"  class="trans">&nbsp;DG&nbsp;&nbsp;
										<input type="checkbox" name="rc_flg"   value= "Y"  class="trans">&nbsp;RF&nbsp;&nbsp;
										<input type="checkbox" name="awk_cgo_flg" value= "Y"  class="trans">&nbsp;AK&nbsp;&nbsp;
										<input type="checkbox" name="bb_cgo_flg" value= "Y"  class="trans">&nbsp;BB&nbsp;&nbsp;
										<input type="checkbox" name="rd_cgo_flg" value= "Y"  class="trans">&nbsp;RD
									</td>
								</tr>
							</table>
						
						</td>
					</tr>
				</table>

				<table class="search" border="0" style="width:979;"> 
					<tr><td height="3"></td></tr>
					<tr class="h23">
						<td width="80">Commodity</td>
						<td width="150">
							<input type="text" style="width:35;" name="rep_cmdt_cd" value="" class="input" style="ime-mode:disabled" dataformat="int" caption="Rep. Commodity Code" maxlength="4">&nbsp;<input type="text" style="width:60;" name="cmdt_cd" value="" class="input" style="ime-mode:disabled" dataformat="int" caption="Commodity Code" maxlength="6">&nbsp;<img src="img/btns_search.gif" name="btn_CommodityPop"  width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
						</td>
						<td width="95">E/Q Type/Size</td>
						<td width="60">
							 <script language="javascript">ComComboObject('cntr_tpsz_cd', 2, 40, 0,0,0);</script>
							<!--<select style="width:90;">
								<option value="0" selected></option>
								<option value="1"></option>
							</select>
						--></td>
						<td width="143">Freight &amp; Charge Type</td>
						<td width="180">
							<script language="javascript">ComComboObject('frt_chg_tp_cd', 2, 170, 0,0,1,false);</script>
							<!--<select style="width:170;">
								<option value="TF" selected>Trunk FRT : TF</option>
								<option value="CY">CY / CFS Charge : CY</option>
								<option value="OP">Out Port Charge : OP</option>
								<option value="IH">Inland Charge : IH</option>
								<option value="02">Door Service Charge : 02</option>
								<option value="SA">Sales Charge : SA</option>
								<option value="LO">Logistics Charge : LO</option>
								<option value="04">Equipment Charge : 04</option>
								<option value="05">VSL Operation Charge: 05</option>
								<option value="OT">Others : OT</option>
							</select>
						--></td>
						<td width="90">Revenue Class</td>
						<td align="right">
							<script language="javascript">ComComboObject('chg_rev_tp_cd', 2, 190, 0,0,1);</script>
							<!--<select style="width:90;">
							<option value="0" selected>Net</option>
							<option value="1">Non-Net</option>
							<option value="2">Misc</option>
							<option value="3">Others</option>
							</select>
						--></td>
					</tr>
				</table>
				<!--  biz_1   (E) -->		
					
			
		</td></tr></table>
		<table class="height_8"><tr><td></td></tr></table>	
		
		<table class="search" id="mainTable"> 
   		<tr><td class="bg">	
			
			
			<!-- Grid_2 (S) -->
			<table width="100%"  id="mainTable">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table>
			<!-- Grid_2 (E) -->		
			
			<!--  Button_Sub (S) -->
			<table width="100%" class="button"table border="0"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td ></td>
					<td>Sorting Priority&nbsp;</td>
					<td class="">
						<select name="sorting_priority" style="width:120;">
							<option value="" selected></option>
							<option value="VB.SLAN_CD">Lane</option>
							<option value="VB.POR_CD">POR</option>
							<option value="VB.DEL_CD">DEL</option>
							<option value="VB.POL_CD">Booking's POL</option>
							<option value="VB.POD_CD">Booking's POD</option>
							<option value="VB.PRE_POL_CD">Pre's POL</option>
							<option value="VB.PRE_POD_CD">Pre's POD</option>
							<option value="VB.POST_POL_CD">Post's POL</option>
							<option value="VB.POST_POD_CD">Post's POD</option>
							<option value="VB.CMDT_CD">Commodity</option>
							<option value="BKG_RATE.RAT_UT_CD">E/Q Type/Size</option>
							<option value="VB.BKG_OFC_CD">Booking Office</option>
							<option value="VB.OB_SLS_OFC_CD">Sales Office</option>
							<option value="VB.CONSIGNEE">Shipper</option>
							<option value="VB.CONSIGNEE">Consignee</option>
							<option value="VB.NTFY">Notify</option>
							<option value="VB.FFDR">F/FowWarder</option>
							<option value="VB.TRUNK_POL">Trunk's POL</option>
							<option value="VB.TRUNK_POD">Trunk's POD</option>
							<option value="VB.BKG_NO">BKG_NO</option>
							
							<!--<option value="01">Lane</option>
							<option value="02">POR</option>
							<option value="03">DEL</option>
							<option value="04">Booking's POL</option>
							<option value="05">Booking's POD</option>
							<option value="06">Pre's POL</option>
							<option value="07">Pre's POD</option>
							<option value="08">Post's POL</option>
							<option value="09">Post's POD</option>
							<option value="10">Commodity</option>
							<option value="11">E/Q Type/Size</option>
							<option value="12">Booking Office</option>
							<option value="13">Sales Office</option>
							<option value="14">Shipper</option>
							<option value="15">Consignee</option>
							<option value="16">Notify</option>
							<option value="17">F/FowWarder</option>
							<option value="18">Trunk's POL</option>
							<option value="19">Trunk's POD</option>
						--></select>
					</td>
					</tr>
					</table></td>
				</tr>
				</table>
				
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
			
			
			
			</td></tr>
		</table>
		<!--biz page (E)-->

		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
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
	
	

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
<%@ include file="/bizcommon/include/common_auth.jsp"%>