<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0417.jsp
*@FileTitle : Port Closing Report (for Branch Office)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.06.11 김기종
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.common.HTMLUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0417Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0417Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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


		event = (EsmBkg0417Event)request.getAttribute("Event");
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
<title>Port Closing Report (for Branch Office)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <style type="text/css">
	.left_td{padding-left:5 !important;background-color:#E5E5E5}    
	.right_td{background-color:#E5E5E5}    
	.center_td{background-color:#E5E5E5}    
	.sub_td{font-size: 9px;}    
  </style>
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
<input type="hidden" name="curr_page"      value="1">
<input type="hidden" name="rows_per_page"  value="50">
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
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="26">VVD</td>
					<td width="30">
						<input type="text" name="vvd_cd" style="width:78;" class="input1" value="" style="ime-mode:disabled" dataformat="engupnum" caption="VVD CD" maxlength="9"  fullfill requird></td>
					<td width="15">POL</td>
					<td width="50">
						<input type="text"  name="pol_cd"  style="width:70;" class="input1" value="" style="ime-mode:disabled" dataformat="engupnum" caption="POL CD" maxlength="5"  fullfill requird></td>

                    <td width="60">DEL Conti</td>
					<td width="60">
						<script language="javascript">ComComboObject('del_conti',1, 75, 0,0,2,true);</script>
					</td>
					<td width="105">
						<input type="radio" name="dt_type" value="ETD" class="trans" checked> ETD
						<input type="radio" name="dt_type" value="PCT" class="trans" > PCT&nbsp;
					</td>
					
					<td width="200">
						<input type="text" name="atd" style="width:75;" class="input1" value="" dataformat="ymd" caption="ETD START DATE" maxlength="10"  style="ime-mode:disabled"    cofield="etd">&nbsp;~
						<input type="text" name="etd" style="width:75;" class="input1" value="" dataformat="ymd" caption="ETD END DATE" maxlength="10"  style="ime-mode:disabled" cofield="atd">
						<img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" onClick="callDatePop('ETD')">
					</td>	
					<td width="70">CNEE Code</td>
					<td width="85" style="padding-left:2">
						<input type="text"  name="cnee_cd"  style="width:80;" class="input" value="" style="ime-mode:disabled" dataformat="engupnum" caption="CNEE Code" maxlength="12"  >
					</td>					
				</table>
			   <table border="0" style="width:;">
			   <tr class="h23">
					<td width="45" class="left_td">Office Type</td>
					<td width="85" class="center_td"><script language="javascript"> ComComboObject('ofc_tp_cd', 1, 75, 0, 1, 0, false);</script></td>			   
					<td width="30" class="center_td">RHQ</td>
					<td width="70" class="center_td">
						<script language="javascript">ComComboObject('rhq_cd', 1, 65, 0,1,1);</script>
					</td>
					<td width="30" class="center_td">GSO</td>
					<td width="58" class="right_td">
						<input type="text" name="gso" style="width:50;" class="input" value="" style="ime-mode:disabled" dataformat="engup"  caption="GSO" maxlength="6" >
					</td>
					<td width="55" style="padding-left:10px !important;">BKG OFC</td>
					<td width="58">
						<input type="text"  name="bkg_ofc_cd"  style="width:50;" class="input" value=""  style="ime-mode:disabled" dataformat="engup" caption="Booking Office" maxlength="6"  ></td>
					<td width="50">BKG STF</td>
					<td width="80">
						<input type="text" name="bkg_stf" style="width:70;" class="input" value="" style="ime-mode:disabled" dataformat="engnum" caption="Booking Staff" maxlength="10" ></td>
					<td width="40">C.OFC</td>
					<td width="110">	
						<input type="text" name="ctrt_ofc_cd" style="width:50;" class="input" value="" style="ime-mode:disabled" dataformat="engupnum" maxlength=5 tabindex=52>
						<span class="sub_td">Sub</span><input type="checkbox" class="trans" name="c_ofc_cd_sub">
					</td>
					</td>
					<td width="40">C.REP</td>
					<td width="60">	
						<input type="text" name="ctrt_srep_cd" style="width:45;" class="input" value="" style="ime-mode:disabled" dataformat="engupnum" maxlength=5 tabindex=52>
					</td> 
					<td width="40">L.OFC</td>
					<td width="110">	
						<input type="text" name="ob_sls_ofc_cd" style="width:50;" class="input" value="" style="ime-mode:disabled" dataformat="engupnum" maxlength=5 tabindex=52>
						<span class="sub_td">Sub</span><input type="checkbox" class="trans" name="l_ofc_cd_sub" value="Y">
					</td> 						
				</table>
				<style>
				 .pad10r{ padding-right:10px !important;}
				 .pad20r{ padding-right:10px !important;}
				</style>					
								
				<table border="0"> 	
				<tr class="h23">
					<td width="40">L.REP</td>
					<td width="55">	
						<input type="text" name="ob_srep_cd" style="width:45;" class="input" value="" style="ime-mode:disabled" dataformat="engupnum" maxlength=5 tabindex=52>
					</td> 
					<td width="40">Lane</td>
                    <td width="80"><script language="javascript">ComComboObject("slan_cd",2,70,0,0,0);</script></td>
					<td class="pad10r">Contract No.</td>
					<td class="pad20r">
						<input type="text"  name="ctrt_no"  style="width:90;" class="input" value="" style="ime-mode:disabled" dataformat="engupnum" caption="Contract No" maxlength="14"  >
					</td>	
					
					<td class="pad10r">CNTR Confirm</td>
					<td class="pad20r">
						<select name="cntr_cfm_flg" style="width:50;">
						<option value="" selected>All</option>
						<option value="Y">Y</option>
						<option value="N">N</option>
						</select>
					</td>
					<td class="pad10r">Booking Status</td>
					<td class="pad20r">
						<script language="javascript">ComComboObject('bkg_sts_cd',1, 80, 0,0,1,true);</script>
					</td>	
					<td class="pad10r">Rating Status</td>
					<td class="pad20r">
						<script language="javascript">ComComboObject('brh_cfm_ind',1,80, 0,0,1,true);</script>
					</td>
				</tr>
				</table>
				<table border="0"> 		 
				<tr class="h23">
					<td class="pad10r">No Rate Status</td>
					<td class="pad20r">
						<select class="input" style="width:60;" name="no_rt_sts">
	                    	<option value="" selected>All</option>
	                      	<option value="R">No rate</option>
	                      	<option value="F">Firm</option>
	                      	<option value="P"> </option><!-- 2014.11.3 이전 -->
	                    </select>
					</td>
					<td class="pad10r">Standby Status</td>
					<td class="pad20r">
						<select class="input" style="width:80;" name="aloc_sts_cd">
	                    	<option value="" selected>All</option>
	                      	<option value="F">F-Firm</option>
	                      	<option value="S">S-Standby</option>
	                    </select>
					</td>
					
					<td class="pad10r">Rate Check</td>
					<td class="pad20r">
						<select class="input" style="width:40;" name="rate_check">
	                    	<option value="" selected></option>
	                      	<option value="Y">Y</option>
	                      	<option value="N">N</option>
	                    </select>
					</td>
					<td class="pad10r">Spot Guide RFA</td>
					<td class="pad20r">
						<INPUT class="trans" name="spot_gid_rfa_cd" value="Y" type=checkbox> <!-- spot guide rfa사용 -->
					</td>                    											
					<td class="pad10r">OFT change after PCT</td>
					<td class="pad20r">
						<script language="javascript">ComComboObject("rtro_knd_cd",1,165);</script>
					</td>
					                    											
				</tr>
				</table>	
				<!--  biz_1   (E) -->
			
		</td></tr></table>
		<table class="height_8"><tr><td></td></tr></table>	
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
			
			
				<!-- : ( Grid ) (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table> 				
				<!-- : ( Grid ) (E) -->	
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
				<td width="335">
					<table class="search" border="0" style="width:100%;"> 
					<tr class="h23">
					<td width="90"></td>
					<td width="60" class="stm" valign="bottom">Total</td>
					<td width="51" class="stm" valign="bottom">Firm</td>
					<td width="" class="stm" valign="bottom">Wating</td>
					</tr>
					<tr class="h23">
					<td width="">Booking Status</td>
					<td width=""><input type="text" name="bk_tot_cnt"  style="width:50;text-align:right" class="input2" value="0" readonly>&nbsp;-</td>
					<td width=""><input type="text" name="bk_charge_cnt" style="width:48;text-align:right" class="input2" value="0" readonly>&nbsp;=</td>
					<td width=""><input type="text" name="bk_non_charge_cnt" style="width:40;color:red;text-align:right" class="input2" value="0" readonly>&nbsp;
					<input type="text" name="bk_percent" style="width:53;color:red;text-align:right" class="input2" value="0%"></td>
					</tr>  
					</table> 
				</td>
				<td width="330">
					<table class="search" border="0" style="width:100%;"> 
					<tr class="h23">
					<td width="90"></td>
					<td width="60" class="stm" valign="bottom">Total</td>
					<td width="51" class="stm" valign="bottom">Charged</td>
					<td width="" class="stm" valign="bottom">Non-Charged</td>
					</tr>
					<tr class="h23">
					<td width="">Rating Status</td>
					<td width=""><input type="text" name="rt_tot_cnt" style="width:50;text-align:right" class="input2" value="0" readonly>&nbsp;-</td>
					<td width=""><input type="text" name="rt_firm_cnt" style="width:48;text-align:right" class="input2" value="0" readonly>&nbsp;-</td>
					<td width="">
						<input type="text" name="rt_non_charge_cnt" style="width:40;color:red;text-align:right" class="input2" value="0" readonly>&nbsp;
						<input type="text" name="rt_percent" style="width:53;color:red;text-align:right" class="input2" value="0%" readonly>
					</td>
					</tr>  
					</table> 
				</td>
				<td width="">
					<table class="search" border="0" style="width:100%;"> 
					<tr class="h23">
					<td width="110"></td>
					<td width="60" class="stm" valign="bottom">Total</td>
					<td width="51" class="stm" valign="bottom">Firm</td>
					<td width="" class="stm" valign="bottom">Non-Confirmed</td>
					</tr>
					<tr class="h23">
					<td width="">CNTR Confirm</td>
					<td width=""><input type="text" name="cntr_tot_cnt"  style="width:50;text-align:right" class="input2" value="0" readonly>&nbsp;-</td>
					<td width=""><input type="text" name="cntr_firm_cnt" style="width:48;text-align:right" class="input2" value="0" readonly>&nbsp;=</td>
					<td width=""><input type="text" name="cntr_balance_cnt" style="width:40;color:red;text-align:right" class="input2" value="0" readonly>&nbsp;
					<input type="text" name="cntr_percent" style="width:53;color:red;text-align:right" class="input2" value="0%"></td>
					</tr>  
					</table> 
				</td>
				
				</tr> 
				</table>
				
				
				
				
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
				<td width="335">
					<table class="search" border="0" style="width:100%;"> 
					<tr class="h23">
					<td width="100"></td>
					<td width="60" class="stm" valign="bottom">Total</td>
					<td width="51" class="stm" valign="bottom">Code</td>
					<td width="" class="stm" valign="bottom">Missing Code</td>
					</tr>
					<tr class="h23">
					<td width="">CN/NF Code</td>
					<td width=""><input type="text" name="cn_tot_cnt"  style="width:50;text-align:right" class="input2" value="0" readonly>&nbsp;-</td>
					<td width=""><input type="text" name="cn_code_cnt" style="width:48;text-align:right" class="input2" value="0" readonly>&nbsp;=</td>
					<td width=""><input type="text" name="cn_balance_cnt" style="width:40;color:red;text-align:right" class="input2" value="0" readonly>&nbsp;
					<input type="text" name="cn_percent" style="width:53;color:red;text-align:right" class="input2" value="0%"></td>
					</tr>  
					</table> 
				</td>
				<td width="">
					<table class="search" border="0" style="width:100%;"> 
					<tr class="h23">
					<td width="90"></td>
					<td width="70" class="stm" valign="bottom">Total</td>
					<td width="80" class="stm" valign="bottom">Actual No.</td>
					<td width="80" class="stm" valign="bottom">Dummy No.</td>
					<td width="" class="stm" valign="bottom">Missing No.</td>
					</tr>
					<tr class="h23">
					<td width="">Contract No</td>
					<td width=""><input type="text" name="cont_tot_cnt"  style="width:50;text-align:right" class="input2" value="0" readonly>&nbsp;-</td>
					<td width=""><input type="text" name="cont_act_cnt"  style="width:48;text-align:right" class="input2" value="0" readonly>&nbsp;-</td>
					<td width=""><input type="text" name="cont_dummy_cnt" style="width:48;text-align:right" class="input2" value="0" readonly>&nbsp;=</td>
					<td width=""><input type="text" name="cont_balance_cnt" style="width:40;color:red;text-align:right" class="input2" value="0" readonly>&nbsp;
					<input type="text" name="cont_percent" style="width:53;color:red;text-align:right" class="input2" value="0%"></td>
					</tr>  
					</table> 
				</td>
				</tr>
				</table>
				
				<!-- No Rate Status -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
				<td width="335">
					<table class="search" border="0" style="width:100%;"> 
					<tr class="h23">
					<td width="100"></td>
					<td width="60" class="stm" valign="bottom">Total</td>
					<td width="51" class="stm" valign="bottom">Firm</td>
					<td width="" class="stm" valign="bottom">No Rate</td>
					</tr>
					<tr class="h23">
					<td width="">No rate Status</td>
					<td width=""><input type="text" name="no_rt_tot_cnt"  style="width:50;text-align:right" class="input2" value="0" readonly>&nbsp;-</td>
					<td width=""><input type="text" name="no_rt_frm_cnt" style="width:48;text-align:right" class="input2" value="0" readonly>&nbsp;=</td>
					<td width=""><input type="text" name="no_rt_cnt" style="width:40;color:red;text-align:right" class="input2" value="0" readonly>&nbsp;
					<input type="text" name="no_rt_percent" style="width:53;color:red;text-align:right" class="input2" value="0%"></td>
					</tr>  
					</table> 
				</td>
				<td width="">

				</td>
				</tr>
				</table>
				
				
				
			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_detail" >Booking Detail</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_charge">Charge</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				</tr></table>
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
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve"  id="btn_Retrieve">Retrieve</td>
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
	
<iframe name="hiddenFrame" style="visibility:hiddden" height="0" width="0"></iframe>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>