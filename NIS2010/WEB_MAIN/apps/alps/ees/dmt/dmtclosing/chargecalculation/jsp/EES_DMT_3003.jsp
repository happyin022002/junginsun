<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_dmt_3003.jsp
*@FileTitle : Charge Calculation by CNTR
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.25
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.06.25 황효근
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
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.event.EesDmt3003Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt3003Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag	= "";
	String codeList		= "";
	String pageRows		= "100";

	String strUsr_id	= "";
	String strUsr_nm	= "";
	Logger log = Logger.getLogger("com.hanjin.apps.DMTClosing.ChargeCalculation");
	
	String cntrNo	= JSPUtil.getParameter(request, "cntr_no", "");
	String callFlag	= JSPUtil.getParameter(request, "call_flag", "M");
	
	String bodyProp = "";
	String tableProp = "";
	
	if (callFlag.equals("M")) {
		//Main 화면일 경우
		tableProp 	= "cellpadding='0' cellspacing='0' style='padding-top:2;padding-left:5;'";
	}
	else {
		//PopUp 화면일 경우 (callFlag == "P")
		bodyProp	= "class='popup_bg'";
		tableProp	= "class='popup' cellpadding='5'";
	}

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesDmt3003Event)request.getAttribute("Event");
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
<title>Charge Calculation by CNTR</title>
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

<body  <%=bodyProp%> onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- 개발자 작업	-->
<input type="hidden" name="ibflag"				value="U">
<input type="hidden" name="call_flag"			value="<%=callFlag%>">
<input type="hidden" name="svr_id"				value="<%=JSPUtil.getParameter(request, "svr_id", "")%>">
<input type="hidden" name="cntr_cyc_no"			value="<%=JSPUtil.getParameter(request, "cntr_cyc_no", "")%>">
<input type="hidden" name="dmdt_trf_cd"			value="<%=JSPUtil.getParameter(request, "dmdt_trf_cd", "")%>">
<input type="hidden" name="dmdt_chg_loc_div_cd"	value="<%=JSPUtil.getParameter(request, "dmdt_chg_loc_div_cd", "")%>">
<input type="hidden" name="chg_seq"				value="<%=JSPUtil.getParameter(request, "chg_seq", "")%>">
<input type="hidden" name="dmdt_chg_sts_cd">
<input type="hidden" name="to_mvmt_sts_cd">
<input type="hidden" name="xcld_flgs">
<input type="hidden" name="ofc_rhq_cd">
<input type="hidden" name="est_mk">
<input type="hidden" name="chg_max_seq">
<input type="hidden" name="web_ind_flg">
<input type="hidden" name="web_cancel_flg">
<input type="hidden" name="yd_cd1">
<input type="hidden" name="chk_yd_cd"			value="Y">
<input type="hidden" name="roll_ovr">
<input type="hidden" name="xch_rt">
<input type="hidden" name="dul_tp_expt_flg">
<input type="hidden" name="uclm_flg">
<input type="hidden" name="cxl_bkg_chg_flg">
<input type="hidden" name="usr_trf_tp">
<input type="hidden" name="awk_gauge">
<input type="hidden" name="cre_ofc_cd">
<input type="hidden" name="dmdt_delt_rqst_sts_cd">
<input type="hidden" name="dr_cancel_btn_flg">
<input type="hidden" name="org_chg_amt">
<input type="hidden" name="bkg_rcv_term_cd">
<input type="hidden" name="bkg_de_term_cd">
<input type="hidden" name="curr_cd">

<!-- 2016.08.02 EES_DMT_3104 수정에 의한 추가 -->
<input type="hidden" name="ui_id" value="EES_DMT_3003">

<table width="100%" border="0" <%=tableProp%> >
	<tr><td class="top"></td></tr>
	<tr><td valign="top">
	
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<script language="javascript">DmtComPageTitle(<%=(callFlag.equals("P")?"true":"false")%>);</script>
		</table>
	<!--Page Title, Historical (E)-->
	
	<table class="search"> 
       		<tr><td class="bg">
			
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="60">CNTR No. </td>
						<td width="158"><input type="text" name="cntr_no" value="<%=cntrNo%>" dataformat="engup" maxlength="14"  caption="CNTR No." style="width:100;" class="input1" value="">&nbsp;<input type="text" name="cntr_tpsz_cd" readonly style="width:30;" class="input2" value=""></td>
						<td width="70">Tariff Type</td>
						<td width="272" class="sm"><script language="javascript">ComComboObject('tariff_type',2,64,1,1);</script><input type="checkbox" name="dul_tp_expt_chk" value="" disabled class="trans">Dual Type Exception&nbsp;<input type="checkbox" name="uclm_chk" disabled class="trans">UC</td>
						<td width="60">Status </td>
						<td width="140"><input type="text" name="dmdt_chg_sts_desc" readonly style="width:100;" class="input2" value=""></td>
						<td width="80">CHRG Type</td>
						<td width=""><select name="chg_type"  style="width:108;" class="input">
						<option value="G" selected>General</option>
						<option value="B">Balance</option>
						</select></td>
					</tr>
				</table>
				
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="50">BKG No. </td>
						<td width="130"><input type="text" name="bkg_no" readonly style="width:110;" class="input2" value=""></td>
						<td width="60">B/L No.</td>
						<td width="130"><input type="text" name="bl_no" readonly style="width:110;" class="input2" value=""></td>
						<td width="70">Invoice No.</td>
						<td width="120"><input type="text" name="dmdt_inv_no" readonly style="width:90;" class="input2" value=""></td>
						<td width="60">A/R  I/F</td>
						<td width="120"><input type="text" name="dmdt_ar_if_cd" readonly style="width:80;" class="input2" value=""></td>
						<td width="100">Inactive Status </td>
						<td width=""><input type="text" name="inact_sts_nm" readonly style="width:108;" class="input2" value=""></td>
						
					</tr>
				
				</table>
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="50">VVD CD</td>
						<td width="130"><input type="text" name="vvd_cd" readonly style="width:110;" class="input2" value=""></td>
						<td width="30">ATA</td>
						<td width="130"><input type="text" name="vps_eta_dt" readonly style="width:80;" class="input2" value=""></td>
						<td width="30">ATB</td>
						<td width="130"><input type="text" name="vps_etb_dt" readonly style="width:80;" class="input2" value=""></td>
						<td width="30">ATD</td>
						<td width="130"><input type="text" name="vps_etd_dt" readonly style="width:80;" class="input2" value=""></td>
						<td width="60">Pre Port</td>
						<td width="100"><input type="text" name="pre_rly_port_cd" readonly style="width:60;" class="input2" value=""></td>
						<td width="65">Post Port</td>
						<td width=""><input type="text" name="pst_rly_port_cd" readonly style="width:60;" class="input2" value=""></td>
					</tr>
				
				</table>
				
				
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="50">POR</td>
						<td width="130"><input type="text" name="por_cd" readonly style="width:110;" class="input2" value=""></td>
						<td width="30">POL</td>
						<td width="130"><input type="text" name="pol_cd" readonly style="width:80;" class="input2" value=""></td>
						<td width="30">POD</td>
						<td width="130"><input type="text" name="pod_cd" readonly style="width:80;" class="input2" value=""></td>
						<td width="30">DEL</td>
						<td width="130"><input type="text" name="del_cd" readonly style="width:80;" class="input2" value=""></td>
						<td width="60">R/D</td>
						<td width="100"><input type="text" name="rd_term_cd" readonly style="width:60;" class="input2" value=""></td>
						<td width="65" id="td_ch">C/H</td>
						<td width=""><input type="text" name="ch" id="ch" readonly style="width:60;" class="input2" value=""></td>
					</tr>
				
				</table>
				
				
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="480">
						
						<table class="grid2" border="0" style="width:480;"> 
							<tr class="h23">
								<td class="tr2_head" width="50">SHPR</td>
								<td width="68" class="noinput2"><input type="text" name="shipper_cd" readonly style="width:66;" class="noinput2" value=""></td>
								<td width="" class="noinput2"><input type="text" name="shipper_nm" readonly style="width:353;" class="noinput2" value=""></td>
							</tr>
							<tr class="h23">
								<td class="tr2_head" width="50">CNEE</td>
								<td width="68" class="noinput2"><input type="text" name="cnee_cd" readonly style="width:66;" class="noinput2" value=""></td>
								<td width="" class="noinput2"><input type="text" name="cnee_nm" readonly style="width:350;" class="noinput2" value=""></td>
							</tr>
							<tr class="h23">
								<td class="tr2_head" width="50">NTFY</td>
								<td width="68" class="noinput2"><input type="text" name="ntfy_cd" readonly style="width:66;" class="noinput2" value=""></td>
								<td width="" class="noinput2"><input type="text" name="ntfy_nm" readonly style="width:350;" class="noinput2" value=""></td>
							</tr>
							<tr class="h23">
								<td class="tr2_head" width="50">S/P</td>
								<td width="68" class="noinput2"><input type="text" name="svc_provdr_cd" readonly style="width:66;" class="noinput2" value=""></td>
								<td width="" class="noinput2"><input type="text" name="svc_provdr_nm" readonly style="width:350;" class="noinput2" value=""></td>
							</tr>
				
						</table>
				
						
						</td>
						<td width="19">&nbsp;&nbsp;&nbsp;</td>
						<td width="480">
						
						<table class="grid2" border="0" style="width:480;" style="border-bottom:1px solid #E8EFF9;"> 
							<tr class="h23">
								<td class="tr2_head" width="55">S/C No.</td>
								<td width="85" class="noinput2"><input type="text" name="sc_no" readonly style="width:83;" class="noinput2" value=""></td>
								<td class="tr2_head" width="55">RFA No.</td>
								<td width="95" class="noinput2"><input type="text" name="rfa_no" readonly style="width:92;" class="noinput2" value=""></td>
								<td class="tr2_head" width="85">A/Customer</td>
								<td width="105" class="noinput2"><input type="text" name="acust" readonly style="width:102;" class="noinput2" value=""></td>
							</tr>
							<tr class="h23">
								<td class="tr2_head" width="55">CMDT</td>
								<td width="85" class="noinput2"><input type="text" name="cmdt_cd" readonly style="width:60;" class="noinput2" value=""></td>
								<td width="340" colspan="4" class="noinput2"><input type="text" name="cmdt_nm" readonly style="width:300;" class="noinput2" value=""></td>
							</tr>
						</table>
						<table class="grid2" border="0" style="width:480;" style="border-bottom:1px solid #E8EFF9;"> 	
							<tr class="h23">
								<td class="tr2_head" width="75">Rep. CMDT</td>
								<td class="noinput2" width="62"><input type="text" name="rep_cmdt_cd" readonly style="width:60;" class="noinput2" value=""></td>
								<td width="343" class="noinput2"><input type="text" name="rep_cmdt_nm" readonly style="width:300;" class="noinput2" value=""></td>
							</tr>
						</table>
						<table class="grid2" border="0" style="width:480;">
							<tr class="h23">
								<td class="tr2_head" width="50">S/OFC</td>
								<td class="noinput2" width="73"><input type="text" name="sls_ofc_cd" readonly style="width:70;" class="noinput2" value=""></td>
								<td class="tr2_head" width="45"> R/OFC</td>
								<td class="noinput2" width="47"><input type="text" name="rlse_ofc" readonly style="width:45;" class="noinput2" value=""></td>
								<td class="noinput2" width="110"><input type="text" name="rlse_dt" id="rlse_dt" readonly style="width:108;" class="noinput2" value=""></td>
								<td class="tr2_head" width="95">DEM/DET OFC </td>
								<td class="noinput2" width="60"><input type="text" name="ofc_cd" readonly style="width:58;" class="noinput2" value=""></td>
							</tr>
						</table>
						
					</td></tr>
				</table>
				<table class="height_8"><tr><td></td></tr></table>
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="310">
							<table class="grid2" border="0" style="width:308;"> 
							<tr class="h23">
								<td class="tr2_head" width="58">From</td>
								<td width="100" class="input2"><input type="text" name="fm_mvmt_dt"  dataformat="ymd"  maxlength=8  style="width:75;" 
									class="input1">&nbsp;<img src="img/btns_calendar.gif" name="btns_calendar1" width="19" height="20" alt="" border="0" 
									align="absmiddle" style="cursor:hand;"  class="cursor"></td>
								<td width="40" class="noinput2"><input type="text" name="fm_mvmt_dt_time"  dataformat="hm" maxlength=4 style="width:38;" class="noinput2" value="" readonly></td>
								<td width="65" class="noinput2"><input type="text" name="fm_mvmt_yd_cd"  dataformat="engup" maxlength=7 style="width:60;" class="input1" value=""></td>
								<td width="" class="noinput2"><input type="text" name="fm_mvmt_sts_cd" readonly style="width:45;" class="noinput2" value=""></td>
							</tr>
								<td class="tr2_head" width="58">To</td>
								<td width="100" class="input2"><input type="text" name="to_mvmt_dt"  dataformat="ymd"  maxlength=8 style="width:75;" 
									class="input1">&nbsp;<img src="img/btns_calendar.gif" name="btns_calendar2"  width="19"height="20"alt="" border="0" 
									align="absmiddle" style="cursor:hand;" class="cursor"></td>
								<td width="40" class="noinput2"><input type="text" name="to_mvmt_dt_time"  dataformat="hm" maxlength=4  style="width:38;" class="noinput2" value="" readonly></td>
								<td width="65" class="noinput2"><input type="text" name="to_mvmt_yd_cd"  dataformat="engup" maxlength=7  style="width:60;" class="input1" value=""></td>
								<td width="" class="noinput2"><script language="javascript">ComComboObject('to_mvmt_sts',2,45,0,1);</script></td>
							</tr>
							</table>
						
						</td>
						<td width="188">
							<table class="grid2" border="0" id="tbl_webmty" style="width:170;display:none;"> 
							<tr class="h23">
								<td class="tr2_head" width="70">Web M'ty</td>
								<td width="" class="noinput2"><input type="text" name="web_mty_dt" readonly style="width:99%;" class="noinput2" value=" "></td>
							</tr>
							<tr class="h23">
								<td class="tr2_head" width="70">Grace End</td>
								<td width="" class="noinput2"><input type="text" name="grace_end_dt" readonly style="width:99%;" class="noinput2" value=" "></td>
							</tr>
							</table>
						</td>
						<td width="202">
							<table class="grid2" border="0" style="width:192;"> 
							<tr class="h23">
								<td class="tr2_head" width="100">Free Time CMNC</td>
								<td width="" class="noinput2"><input type="text" name="ft_cmnc_dt" readonly style="width:78;" class="noinput2" value=""></td>
							</tr>
							<tr class="h23">
								<td class="tr2_head" width="">Free Time End</td>
								<td width="" class="noinput2"><input type="text" name="ft_end_dt" readonly style="width:78;" class="noinput2" value=""></td>
							</tr>
							</table>
						
						</td>
						<td width="">
							<table class="grid2" border="0" style="width:115;"> 
							<tr class="">
								<td class="tr2_head" width="70"><b>Free Time</b></td>
								<td width="45" class="noinput2"><input type="text" name="ft_dys" readonly style="width:40;text-align:right;" class="noinput2" value=""></td>
								
								<!-- 
								<td width="" class="noinput2"><input type="checkbox" name="xcld_sat_flg" value="Y" class="trans" disabled>SAT</td>
								<td width="" class="noinput2"><input type="checkbox" name="xcld_sun_flg" value="Y" class="trans" disabled>SUN</td>
								<td width="" class="noinput2"><input type="checkbox" name="xcld_hol_flg" value="Y" class="trans" disabled>H/day</td>
								-->
							</tr>
							<tr class="h23">
								<td class="tr2_head" width="">Over Day</td>
								<td width="" class="noinput2"><input type="text" name="fx_ft_ovr_dys" readonly style="width:40;text-align:right;" class="noinput2" value=""></td>											
							</tr>
							</table>
							
						</td>
						<td width="">
							<table class="grid2" border="0" style="width:145;"> 
								<tr class="">
								<td class="tr2_head" width="100" style="text-align:center;"><b>Exception Day</b></td>
								<td width="45" class="noinput2"><input type="text" name="expt_dys" readonly style="width:99%;text-align:right;" class="noinput2" value=""></td>
							</tr>
							</tr>
							<!-- 
							<tr class="h23">
								<td class="tr2_head" width="60">Over Due</td>
								<td width="" class="noinput2"><input type="text" name="ovr_due" readonly style="width:99%;text-align:right;" class="noinput2" value=""></td>
							</tr>
							 -->
							</table>
							<table border="0" style="height:23;"><tr><td></td></tr></table>
						</td>
					</tr>
				</table>
				
				<table class="height_8"><tr><td></td></tr></table>
				
				
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="619">
							<table class="grid2" border="0" style="width:600;"> 
							<tr class="h23">
								<td class="tr2_head" width="100">CNTR Type</td>
								<td width="120" class="noinput2"><input type="text" name="dmdt_cntr_tp_cd" readonly style="width:100;" class="noinput2" value=""></td>
								<td class="tr2_head" width="100">Cargo Type</td>
								<td width="" class="noinput2"><input type="text" name="dmdt_bkg_cgo_tp_cd" readonly style="width:150;" class="noinput2" value=""></td>
							</tr>
							</table>
						</td>
						<td width="360">
							<table class="grid2" border="0" style="width:196;"> 
							<tr class="h23">
								<td class="tr2_head" width="148">Charge Currency</td>
								<td width="45" class="noinput2"><input type="text" name="bzc_trf_curr_cd" readonly style="width:100%;" class="noinput2" value=""></td>
							</tr>
							</table>
						</td>
					</tr>
				</table>
				
				<table class="height_8"><tr><td></td></tr></table>
				
				
				<table class="search" border="0" style="width:600;"> 
					<tr class="h23">
						<td width="600">
							<!-- Grid  (S) -->
							<table width="619"  id="mainTable"> 
								<tr>
									<td width="600">
										<script language="javascript">ComSheetObject('sheet1');</script>
									</td>
								</tr>
							</table>
							<!-- Grid (E) -->
						</td>
						<td width="360" valign="top">
							<table class="grid2" border="0" style="width:360;"> 
							<tr class="h23">
								<td class="tr2_head" width="143">Total AMT</td>
								<td width="" class="noinput2"><input type="text" name="total_amt" readonly style="width:99%;text-align:right" class="noinput2" value=""></td>
							</tr>
							<tr class="h23">
								<td class="tr2_head" width="">D/C by AMT  or %</td>
								<td width="" class="noinput2"><input type="text" name="aft_expt_dc_amt" readonly style="width:99%;text-align:right" class="noinput2" value=""></td>
							</tr>
							<tr class="h23">
								<td class="tr2_head" width="">Billable AMT</td>
								<td width="" class="noinput2"><input type="text" name="bil_amt" readonly style="width:99%;text-align:right" class="noinput2" value=""></td>
							</tr>
							</table>
						</td>
					</tr>
				</table>
				
				<table class="height_8"><tr><td></td></tr></table>
				
				<table class="search" border="0" style="width:100%;">
				<tr>
					<td style="width:805;">
						<table class="grid2" border="0" style="width:800;"> 
						<tr class="h23">
							<td class="tr2_head" width="100">Remark(s)</td>
							<td width="700"><textarea  name="corr_rmk" style="width:100%;height:66"></textarea></td>
						</tr>
						</table>
					</td>
					<td valign="top" style="align:left;">
						<table width="80" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_PreCal" id="btn_PreCal">Pre Cal.</td>
							<td class="btn2_right"></td>
							</tr>
						</table></td>
					<td valign="top">
						<table id="btn_WebCancel" style='display:none;' width="100" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_WebCancel">Web Cancel</td>
							<td class="btn2_right"></td>
							</tr>
						</table></td>
				</tr>
				</table>
				<!--  biz_1  (E) -->
					
			</td></tr>
		</table>
		
<!-- : ( Search Options ) (E) -->
			

	<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->

	
	<!--Button (S) -->
	<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:2;"> 
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
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Confirm">Confirm</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Demand">Demand</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Billing">Billing</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_OFCTrans">OFC Trans</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Delete">Inactive Request</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<!-- td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DelReqCancel" id="btn_DelReqCancel">Inactive REQ Cancel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td -->
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Partial">Partial</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DRCancel">D/R Cancel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
		</tr>
		</table>
    <!--Button (E) -->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_CalcDetail">Calculation Detail</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_CorrHistory">Correction History</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_OTHistory">O/T History</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_ROInfo" id="btn_ROInfo">R/O Info.</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_MVMTInq">MVMT Inq.</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_ExceptionInq">Exception Inq.</td>
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

	</td></tr>
</table>

<!-- : ( Button : pop ) (S) -->
<div id="btnCloseLayer" style="display:none">
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
    	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
					<td class="btn1_right"></td>
				</tr></table></td>
			</tr>
			</table>
		</td></tr>
	</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
</div>
<!-- : ( Button : pop ) (E) -->


<div id="topdeck" style="position:absolute;visibility:hidden;z-index:200;"></div>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>