<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_1110.jsp
*@FileTitle : Outbound Container Movement Status
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.01
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.07.01 김기종
* 1.0 Creation 
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingreport.statusreport.event.EsmBkg1110Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1110Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.BookingReport.StatusReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg1110Event)request.getAttribute("Event");
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
<title>EIR Exchange & Customs Release Check Report</title>
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
<input type="hidden" name="com_mrdPath">
<input type="hidden" name="com_mrdArguments">
<input type="hidden" name="com_mrdTitle" value="EIR Exchange & Customs Release Check Report">
<input type="hidden" name="com_mrdBodyTitle" value="EIR Exchange & Customs Release Check Report">
<!-- 개발자 작업	-->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->   
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">   
        <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;EIR Exchange & Customs Release Check Report</td></tr>        
    </table>   
	<!--Page Title, Historical (E)-->
	
	
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="35">VVD</td>
					<td width="85">
						<input type="text" name="vvd_cd"  style="width:80;" class="input1" value="" style="ime-mode:disabled" dataformat="engup"  caption="VVD" maxlength="9" fullfill required></td> 
					<td width="150">
						<table class="search_sm2" border="0" style="width:140;"> 
							<tr class="h23">
								<td width="30">L/T</td>
								<td class="stm">
									<input type="checkbox" name="chk_lt_type" value="L" class="trans" >Local&nbsp;&nbsp;
									<input type="checkbox" name="chk_lt_type" value="T" class="trans" >T/S</td>
							</tr>
						</table>
					</td>
					<td width="25">POL</td>
					<td width="55"><input type="text" name="pol_cd" style="width:45;" class="input1" value="" style="ime-mode:disabled" dataformat="engup"  caption="POL" maxlength="5"  ></td>
					<td width="25">POR</td>
					<td width="55"><input type="text" name="por_cd" style="width:45;" class="input" value="" style="ime-mode:disabled" dataformat="engup"  caption="POR" maxlength="5" ></td>  
					<td width="60">R/D Term</td>
					<td width="140">
						<script language="javascript" >ComComboObject('rcv_term_cd', 1, 65, 1)</script>
						<!--<select name="rcv_term_cd" style="width:45;">
						<option value="0" selected>Y</option>
						<option value="1"></option>
						</select>
						-->
						&nbsp;
						<script language="javascript" >ComComboObject('de_term_cd', 1, 65, 1)</script>
						<!--<select name="de_term_cd" style="width:45;">
						<option value="0" selected>Y</option>
						<option value="1"></option>
						</select>
						--></td> 
					<td width="50">Pre VVD</td>
					<td width="90"><input type="text" name="pre_1_vvd" style="width:80;" class="input" value="" style="ime-mode:disabled" dataformat="engup"  caption="Pre VVD" maxlength="9" fullfill></td> 
					<td width="50">Pre POL</td>
					<td width="60"><input type="text" name="pre_1_pol_cd" style="width:50;" class="input" value="" style="ime-mode:disabled" dataformat="engup"  caption="Pre POL" maxlength="5" fullfill></td> 
					<td width="36">Yard</td>
					<td width=""><input type="text" name="org_yd_cd" style="width:55;" class="input" value="" style="ime-mode:disabled" dataformat="engup"  caption="Yard" maxlength="7" ></td> 
				</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="55">BKG OFC</td>
					<td width="190" class="stm">
					<input type="text" name="bkg_ofc_cd"  style="width:65;" class="input" value="" style="ime-mode:disabled" dataformat="engup"  caption="BKG OFC" maxlength="5" fullfill>&nbsp;
					(<input type="checkbox" name="ofc_inc_sub" value="Y" class="trans">Including Sub)</td> 
					<td width="60">BKG Date</td>
					<td width="240">
						<input type="text" name="bkg_dt_fr" style="width:75;" class="input" value=""  dataformat="ymd" caption="BKG Start Date" maxlength="10" cofield="bkg_dt_to">
						~
						<input type="text" name="bkg_dt_to" style="width:75;" class="input" value=""    dataformat="ymd" caption="BKG End Date" maxlength="10" cofield="bkg_dt_fr">
						<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"  style="cursor:hand" onClick="callDatePop('BKG_DATE')"></td> 
					<td width="70">BKG Status</td>
					<td width="77">
						<script language="javascript">ComComboObject('bkg_sts_cd', 1, 65, 0,0,0);</script><!--
						
						<select name="bkg_sts_cd" style="width:65;">
						<option value="0" selected></option>
						<option value="1">All</option>
						</select>
					--></td> 
					<td width="60">BKG Kind</td>
					<td width="80">
						<script language="javascript">ComComboObject('xter_bkg_rqst_cd', 1, 65, 0,0,0);</script>
						<!--<select name="xter_bkg_rqst_cd"  style="width:65;">
						<option value="0" selected></option>
						<option value="1">All</option>
						</select>
					--></td> 
					<td width="77">EQ Comfirm</td>
					<td width=""><select name="cntr_cfm_flg" style="width:65;">
						<option value="" selected>All</option>
						<option value="Y">Y</option>
						<option value="N">N</option>
						</select></td> 
					
				</tr>
				</table>
				
				
				<table style="height:5;"><tr><td></td></tr></table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="80">Cargo Type</td>
					<td width="200">
					<script language="javascript">ComComboObject('bkg_cgo_tp_cd', 1, 180, 0,0,0);</script>
					<!--<select name="bkg_cgo_tp_cd" style="width:65;">
						<option value="0" ></option>
						<option value="1"selected>All</option>
						<option value="1">Full</option>
						<option value="1">Empty</option>
						</select>
					--></td> 
					<!-- td width="210">
						<input type="checkbox" name="chk_inc_clm"  value="Y" class="trans" onClick="chkIncClm()">Including CLM Information</td --> 
					<td width="100">Customer Code</td>
					<td width="305">
						<script language="javascript">ComComboObject('cust_tp_cd', 1, 90, 0,0,0);</script>
						<!--<select name="cust_tp_cd" style="width:45;">
						<option value="0" ></option>
						<option value="1" selected>SH</option>
						<option value="1"></option>
						<option value="1"></option>
						</select>&nbsp;
						--><input type="text" name="cust_cnt_cd" style="width:30;" class="input" value="" style="ime-mode:disabled" dataformat="engup"  caption="Country Code" maxlength="2" fullfill>&nbsp;
						<input type="text" name="cust_seq" style="width:50;" class="input" value="" style="ime-mode:disabled" dataformat="num"  caption="Cust Seq" maxlength="6">&nbsp;
						<input type="text" name="cust_nm" style="width:70;" class="input" value="" style="ime-mode:disabled"  dataformat="engup" otherchar="#&*()., -" maxlength="20">
					</td>
					
					<td width="30">EIR</td>	 
					<td width="85"><select name="eir_flg" style="width:65;">
						<option value="" selected>All</option>
						<option value="Y">Y</option>
						<option value="N">N</option>
						</select></td> 
					<td width="110">Customs Release</td>	 
					<td width=""><select name="curl_flg" style="width:65;">
						<option value="" selected>All</option>
						<option value="Y">Y</option>
						<option value="N">N</option>
						</select></td> 
				</tr>
				</table>
				
				
		</td></tr>
	</table>
	
	<table class="height_8"><tr><td colspan="8"></td></tr></table>
	
<div id="tabLayer" style="display:inline">		
		<!-- Tab BG Box ) (S) -->		
	<table class="search"> 
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
			
			<!--  Button_Sub (S) -->
			<table width="100%" class="button" border="0">
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr><td class="btn2_left"></td>
				<td class="btn2" name="btn_EQHistory" id="btn_EQHistory">EQ History</td>
				<td class="btn2_right"></td>
				<td class="btn2_left"></td>
				<td class="btn2" name="btn_COP" id="btn_COP">COP</td>
				<td class="btn2_right"></td>
				</tr>
				</table>
				</td>
			</tr></table>
			<!--  Button_Sub (E) -->
			
			<!--  Grid_button (S) -->
			<table class="height_5"><tr><td></td></tr></table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
				<td width="65">BKG Total</td>
				<td width="394"><input name="bkg_total" type="text" style="width:35;" value="" class="input2">
				<input name="bkg_total_f" type="text" style="width:70;" value="" class="input2"></td>
				<td width="75">CNTR Total</td>
				<td width=""><input name="cntr_total" type="text" style="width:40;" value="" class="input2">
				<input name="cntr_total_f" type="text" style="width:70;" value="" class="input2"></td>
				</tr></table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
				<td width="75">EIR Total</td>
				<td width="29">Yes</td>
				<td width="120"><input name="eir_total_y" type="text" style="width:35;" value="" class="input2">
				<input name="eir_tot_y" type="text" style="width:70;" value="" class="input2"></td>
				<td width="25">No</td>
				<td width="210"><input name="eir_total_n" type="text" style="width:40;" value="" class="input2">
				<input name="eir_tot_n" type="text" style="width:70;" value="" class="input2"></td>
				<td width="150">Customs Release Total</td>
				<td width="30">Yes</td>
				<td width="120"><input name="curl_total_y" type="text" style="width:35;" value="" class="input2">
				<input name="curl_tot_y" type="text" style="width:70;" value="" class="input2"></td>
				<td width="25">No</td>
				<td width=""><input name="curl_total_n" type="text" style="width:40;" value="" class="input2">
				<input name="curl_tot_n" type="text" style="width:70;" value="" class="input2"></td>
				</tr>	
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
				<td width="163">Current Movement Total</td>
				<td width="25">OP</td>
				<td width="121"><input name="op" type="text" style="width:35;" value="" class="input2">
				<input name="op_tot" type="text" style="width:70;" value="" class="input2"></td>
				<td width="25">OC</td>
				<td width="120"><input name="oc" type="text" style="width:35;" value="" class="input2">
				<input name="oc_tot" type="text" style="width:70;" value="" class="input2"></td>
				<td width="25">VL</td>
				<td width="120"><input name="vl" type="text" style="width:35;" value="" class="input2">
				<input name="vl_tot" type="text" style="width:70;" value="" class="input2"></td>
				<td width="40">Other</td>
				<td width="192"><input name="ot" type="text" style="width:35;" value="" class="input2">
				<input name="ot_tot" type="text" style="width:70;" value="" class="input2"></td>
				</tr>	
				</table>
			
	    	<!-- Grid_button (E) -->
			</div>
<!--TAB  (E) -->	
	
	<!-- Grid BG Box  (S) -->
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
	<!--biz page (E)-->
	
	</td></tr>
</table>
	

<!-- 개발자 작업  끝 -->
</form>

<!-- 레포트  팝업  -->
<form name="form2" method="post">
    <input type="hidden" name="rfn">
    <input type="hidden" name="mrd">
    <input type="hidden" name="title">
    <input type="hidden" name="rp">
    <input type="hidden" name="rv">
</form>


</body>
</html>