<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_3002.jsp
*@FileTitle  : Charge Calculation by Booking
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/11
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.event.EesDmt3002Event"%>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt3002Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_Cnt_cd	= "";
	String strRhq_ofc_cd	= "";
	Logger log = Logger.getLogger("com.clt.apps.DMTClosing.ChargeCalculation");
	
	// Retrieving the parameter values ​​for calls to pop-up page
	String bkgNo		= JSPUtil.getParameter(request, "bkg_no", "");
	String blNo			= JSPUtil.getParameter(request, "bl_no", "");
	String dmdtTrfCd	= JSPUtil.getParameter(request, "dmdt_trf_cd", "");
	String dmdtChgStsCd	= JSPUtil.getParameter(request, "dmdt_chg_sts_cd", "");
	String callFlag		= JSPUtil.getParameter(request, "call_flag", "M");
	
	String bodyProp = "";
	String tableProp = "";
	
	if (callFlag.equals("M")) {
		// in case of Main screen
		tableProp 	= "cellpadding='0' cellspacing='0' style='padding-top:2;padding-left:5;'";
	}
	else {
		// in case of PopUp screen (callFlag == "P")
		bodyProp	= "class='popup_bg'";
		tableProp	= "class='popup' cellpadding='5'";
	}

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_Cnt_cd = account.getCnt_cd();
		strRhq_ofc_cd = account.getRhq_ofc_cd();

		event = (EesDmt3002Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// Initial loading logic to extract additional data obtained from the server ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- Developer's task	-->
<input type="hidden" name="usr_cnt_cd" value="<%=strUsr_Cnt_cd%>" id="usr_cnt_cd" />
<input type="hidden" name="call_flag" value="<%=callFlag%>" id="call_flag" />
<input type="hidden" name="dmdt_trf_cd" value="<%=dmdtTrfCd%>" id="dmdt_trf_cd" />
<input type="hidden" name="dmdt_chg_sts_cd" value="<%=dmdtChgStsCd%>" id="dmdt_chg_sts_cd" />
<input type="hidden" name="est_mk" id="est_mk" />
<input type="hidden" name="sch_chg_sts" id="sch_chg_sts" />
<input type="hidden" name="ar_act_cd" id="ar_act_cd" />
<input type="hidden" name="usr_rhq_ofc_cd" value="<%=strRhq_ofc_cd%>" id="usr_rhq_ofc_cd" />
<input type="hidden" name="usr_trf_tp" id="usr_trf_tp" />
<input type="hidden" name="rhq_ofc_cd" id="rhq_ofc_cd" />
<input type="hidden" name="backendjob_key" id="backendjob_key" />
<input type="hidden" name="backendjob_id" id="backendjob_id" />
<input type="hidden" name="head_office" value="<%=ConstantMgr.getHeadOfficeCode()%>" id="head_office" /><!-- HEAD OFFICE -->

<input type="hidden" name="f_cmd_text" id="f_cmd_text" />
<input type="hidden" name="chk_batch" id="chk_batch" />
<input type="hidden" name="bat_run_tm_id" id="bat_run_tm_id" /> 

<% if(callFlag.equals("P")){ %>
<!-- page_title_area(S) -->
<div class="layer_popup_title">  
<div class="page_title_area clear">
  	<h2 class="page_title"><span>Charge Calculation by Booking</span></h2>
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" 	id="btn_Retrieve">Retrieve</button><!--  
		--><button type="button" class="btn_normal" name="btn_New"  		id="btn_New">New</button><!-- 
		--><button type="button" class="btn_normal" name="btn_Minimize" 		id="btn_Minimize">Minimize</button><!-- 
		--><button type="button" class="btn_normal" name="btn_Confirm" 	id="btn_Confirm">Confirm</button><!-- 
		--><button type="button" class="btn_normal" name="btn_Demand" 		id="btn_Demand">Demand</button><!-- 
		--><button type="button" class="btn_normal" name="btn_Billing" 	id="btn_Billing">Billing</button><!-- 
		--><button type="button" class="btn_normal" name="btn_OFCTrans" 		id="btn_OFCTrans">OFC Trans</button><!-- 
		--><button type="button" class="btn_normal" name="btn_Delete" 		id="btn_Delete">Delete</button><!-- 
		--><button type="button" class="btn_normal" name="btn_DELCancel" 		id="btn_DELCancel">DEL Cancel</button><!-- 
		--><button type="button" class="btn_normal" name="btn_ByETA" 		id="btn_ByETA">by ETA</button><!-- 	
		--><button type="button" class="btn_accent" name="btn_Recalc" 	id="btn_Recalc">Charge Recalculation</button><!-- 
		--><button type="button" class="btn_normal" name="btn_ByCNTR"  		id="btn_ByCNTR">by CNTR</button><!-- 
		--><button type="button" class="btn_normal" name="btn_MVMTInq" 		id="btn_MVMTInq">MVMT Inq.</button><!-- 
		--><button type="button" class="btn_normal" name="btn_ExceptionInq" 	id="btn_ExceptionInq">Exception Inq.</button><!-- 
		--><button type="button" class="btn_normal" name="btn_DownExcel" 		id="btn_DownExcel">Down Excel</button><!-- 
		--><button type="button" class="btn_normal" name="btn_Close" id="btn_Close" style="display:none">Close</button><!-- 
	 --></div>
	<!-- opus_design_btn(E) -->
</div>
</div>
<!-- page_title_area(E) -->
<%} else{ %>
<!-- page_title_area(S) -->
<div class="page_title_area clear">
  	<h2 class="page_title"><button type="button"><span id="title">Charge Calculation by Booking</span></button></h2>
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" 	id="btn_Retrieve">Retrieve</button><!--  
		--><button type="button" class="btn_normal" name="btn_New"  		id="btn_New">New</button><!-- 
		--><button type="button" class="btn_normal" name="btn_Minimize" 		id="btn_Minimize">Minimize</button><!-- 
		--><button type="button" class="btn_normal" name="btn_Confirm" 	id="btn_Confirm">Confirm</button><!-- 
		--><button type="button" class="btn_normal" name="btn_Demand" 		id="btn_Demand">Demand</button><!-- 
		--><button type="button" class="btn_normal" name="btn_Billing" 	id="btn_Billing">Billing</button><!-- 
		--><button type="button" class="btn_normal" name="btn_OFCTrans" 		id="btn_OFCTrans">OFC Trans</button><!-- 
		--><button type="button" class="btn_normal" name="btn_Delete" 		id="btn_Delete">Delete</button><!-- 
		--><button type="button" class="btn_normal" name="btn_DELCancel" 		id="btn_DELCancel">DEL Cancel</button><!-- 
		--><button type="button" class="btn_normal" name="btn_ByETA" 		id="btn_ByETA">by ETA</button><!-- 	
		--><button type="button" class="btn_accent" name="btn_Recalc" 	id="btn_Recalc">Charge Recalculation</button><!-- 
		--><button type="button" class="btn_normal" name="btn_ByCNTR"  		id="btn_ByCNTR">by CNTR</button><!-- 
		--><button type="button" class="btn_normal" name="btn_MVMTInq" 		id="btn_MVMTInq">MVMT Inq.</button><!-- 
		--><button type="button" class="btn_normal" name="btn_ExceptionInq" 	id="btn_ExceptionInq">Exception Inq.</button><!-- 
		--><button type="button" class="btn_normal" name="btn_DownExcel" 		id="btn_DownExcel">Down Excel</button><!-- 
		--></div>
	<!-- opus_design_btn(E) -->
	
	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
	
</div>
<!-- page_title_area(E) -->
<%} %>
<!-- opus_design_inquiry(S) -->
<% if(callFlag.equals("P")){ %>
<div class="layer_popup_contents">
<%} %> 
<div id="mini_div" class="wrap_search" style="display: block;">
<div class="opus_design_inquiry wFit">
	<table class="search">
		<tbody>
			<colgroup>
				<col width="55px">
				<col width="130px">
				<col width="50px">
				<col width="135px">
				<col width="70px">
				<col width="110px">
				<col width="50px">
				<col width="150px">
				<col width="65px">
				<col width="100px">
				<col width="*">
		    </colgroup>
			<tr class="h23">
				<th>BKG No.</th>
				<td><input type="text" name="bkg_no" id="bkg_no" value="<%=bkgNo%>" dataformat="engup" maxlength="13"  caption="BKG No."  style="width:110px;" class="input1" value=""></td>
				<th>B/L No.</th>
				<td><input type="text" name="bl_no" id="bl_no" value="<%=blNo%>" dataformat="engup" maxlength="12"   caption="B/L No."  style="width:110px;" class="input1" value=""></td>
				<th>Tariff Type</th>
				<td><script type="text/javascript">ComComboObject('tariff_type',2,70,1,1);</script></td>
				<th>Status</th>
				<td><script type="text/javascript">ComComboObject('combo_status',2,100,1,1);</script><button type="button" class="multiple_inq"></button></td>
				<th>RHQ</th>
				<td><script type="text/javascript">ComComboObject('rhq_ofc',2,70,1,1);</script></td>
				<td class="stm" colspan="2"><input type="checkbox" name="bypodeta" id="bypodeta" value="booking" class="trans">by POD ETA</td>
			</tr>
		</tbody>
	</table>
		
	<table class="search">
		<tbody>
			<colgroup>
				<col width="55px">
				<col width="130px">
				<col width="50px">
				<col width="135px">
				<col width="70px">
				<col width="110px">
				<col width="50px">
				<col width="150px">
				<col width="65px">
				<col width="100px">
				<col width="65px">
				<col width="*">
		    </colgroup>
			<tr class="h23">
				<th>VVD CD</th>
				<td><input type="text" name="vvd_cd" id="vvd_cd"  maxlength="9" style="width:110px;" class="input2" value="" readonly></td>
				<th>ATA</th>
				<td><input type="text" name="vps_eta_dt" id="vps_eta_dt"  style="width:80px;" class="input2" value="" caption="ATA" readonly></td>
				<th>ATB</th>
				<td><input type="text" name="vps_etb_dt" id="vps_etb_dt"  style="width:80px;" class="input2" value="" caption="ATB" readonly></td>
				<th>ATD</th>
				<td><input type="text" name="vps_etd_dt" id="vps_etd_dt"  style="width:80px;" class="input2" value="" caption="ATD" readonly></td>
				<th>Pre Port</th>
				<td><input type="text" name="pre_rly_port_cd" id="pre_rly_port_cd"  style="width:60px;" class="input2" readonly></td>
				<th>Post Port</th>
				<td><input type="text" name="pst_rly_port_cd" id="pst_rly_port_cd" style="width:60px;" class="input2" readonly></td>
			</tr>
		</tbody>
	</table>
	<table class="search">
		<tbody>
			<colgroup>
				<col width="55px">
				<col width="130px">
				<col width="50px">
				<col width="135px">
				<col width="70px">
				<col width="110px">
				<col width="50px">
				<col width="150px">
				<col width="65px">
				<col width="100px">
				<col width="65px">
				<col width="*">
		    </colgroup>
			<tr class="h23">
				<th title="Place of Receipt">POR</th>
				<td><input type="text" name="por_cd" style="width:110px;" class="input2" readonly></td>
				<th title="Port of Loading">POL</th>
				<td><input type="text" name="pol_cd" style="width:80px;" class="input2" readonly></td>
				<th title="Port of Discharging">POD</th>
				<td><input type="text" name="pod_cd" style="width:80px;" class="input2" readonly></td>
				<th title="Place of Delivery">DEL</th>
				<td><input type="text" name="del_cd" style="width:80px;" class="input2" readonly></td>
				<th>R/D</th>
				<td><input type="text" name="rd_term_cd" style="width:60px;" class="input2" readonly></td>
				<td></td>
				<td></td>				
			</tr>
		</tbody>
	</table>
</div>
<!-- opus_design_inquiry(E) -->

<!-- layout_wrap(S) -->
<div class="layout_wrap">
    <div class="layout_vertical_2" style="width:50%;">
        <div class="opus_design_data">
            <table class="grid2" style="width:99%;">
				<tbody>
					<colgroup>
						<col width="50px">
						<col width="70px">
						<col width="360px">
				    </colgroup>
					<tr>
						<th style="text-align:center;"><strong>SHPR</strong></th>
						<td class="noinput2"><input type="text" name="shipper_cd" id="shipper_cd"  readonly style="width:66px;" class="noinput2"></td>
						<td class="noinput2"><input type="text" name="shipper_nm" id="shipper_nm" readonly style="width:350px;" class="noinput2" ></td>
					</tr>
					<tr>
						<th style="text-align:center;"><strong>CNEE</strong></th>
						<td class="noinput2"><input type="text" name="cnee_cd" id="cnee_cd" readonly style="width:66px;" class="noinput2" ></td>
						<td class="noinput2"><input type="text" name="cnee_nm" id="cnee_nm" readonly style="width:350px;" class="noinput2" ></td>
					</tr>
					<tr>
						<th style="text-align:center;"><strong>NTFY</strong></th>
						<td class="noinput2"><input type="text" name="ntfy_cd" id="ntfy_cd" readonly style="width:66px;" class="noinput2" ></td>
						<td class="noinput2"><input type="text" name="ntfy_nm" id="ntfy_nm"  readonly style="width:350px;" class="noinput2" ></td>
					</tr>
					<tr>
						<th style="text-align:center;"><strong>S/P</strong></th>
						<td class="noinput2"><input type="text" name="svc_provdr_cd" id="svc_provdr_cd" readonly style="width:66px;" class="noinput2" ></td>
						<td class="noinput2"><input type="text" name="svc_provdr_nm" id="svc_provdr_nm"  readonly  style="width:350px;" class="noinput2"></td>
					</tr>
				</tbody>
			</table>
        </div>
    </div>
    <div class="layout_vertical_2" style="width:50%;">
        <div class="opus_design_data">
            <table class="grid2" style="width:100%;">
				<tbody>
					<colgroup>
						<col width="90px">
						<col width="90px">
						<col width="60px">
						<col width="90px">
						<col width="80px">
						<col width="25px">
						<col width="*">
				    </colgroup>
					<tr>
						<th style="text-align:center;"><strong>S/C No.</strong></th>
						<td class="noinput2"><input type="text" name="sc_no" id="sc_no" style="width:88px;" class="noinput2" readonly></td>
						<th style="text-align:center;"><strong>RFA No.</strong></th>
						<td class="noinput2"><input type="text" name="rfa_no" id="rfa_no" value="" style="width:87px;" class="noinput2" readonly></td>
						<th style="text-align:center;"><strong>A/Customer</strong></th>
						<td class="noinput2" colspan="2"><input type="text" name="acust" id="acust" style="width:75px;" class="noinput2" readonly></td>
					</tr>
					<tr>
						<th style="text-align:center;"><strong>CMDT</strong></th>
						<td class="noinput2"><input type="text" name="cmdt_cd" id="cmdt_cd" style="width:87px;" class="noinput2" readonly></td>
						<td class="noinput2" colspan="5"><input type="text" name="cmdt_nm" id="cmdt_nm" style="width:300px;" class="noinput2" readonly></td>
					</tr>
					<tr>
						<th style="text-align:center;"><strong>Rep.CMDT</strong></th>
						<td class="noinput2"><input type="text" name="rep_cmdt_cd" id="rep_cmdt_cd" style="width:48px;" class="noinput2" readonly></td>
						<td class="noinput2" colspan="5"><input type="text" name="rep_cmdt_nm" id="rep_cmdt_nm"  style="width:320px;" class="noinput2" value="" readonly></td>
					</tr>
					<tr>
						<th style="text-align:center;"><strong>S/Office</strong></th>
						<td class="noinput2"><input type="text" name="sls_ofc_cd" id="sls_ofc_cd" style="width:88px;" class="noinput2" readonly></td>
						<th style="text-align:center;" id='tdROffice'><strong>R/Office</strong></th>
						<td class="noinput2"><input type="text" name="rlse_ofc" id="rlse_ofc" style="width:100%;" class="noinput2" readonly></td>
						<td class="noinput2"><input type="text" name="d_o" id="d_o" style="width:100%;" class="noinput2" readonly></td>
						<td class="noinput2"><input type="text" name="partial" id="partial" style="width:100%;text-align:center;" class="noinput2" readonly></td>
						<td class="noinput2"><input type="text" name="rlse_dt" id="rlse_dt" style="width:100%;" class="noinput2" readonly></td>
					</tr>
				</tbody>
			</table>
        </div>
    </div>
</div>
<!-- layout_wrap(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->	
	<div class="opus_design_grid" id="mainTable">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
	<div class="opus_design_inquiry">
		<table class="search">
			<tbody>
				<colgroup>
					<col width="70px">
					<col width="50px">
					<col width="110px">
					<col width="250px">
					<col width="60px">
					<col width="120px">
					<col width="*">
			    </colgroup>
				<tr class="h23">
					<th>CNTR Q'TY</th>
					<td><input type="text" name="cntr_qty" id="cntr_qty" style="width:40px;text-align:right;"  class="input2" readonly ></td>
					<th>Total Billable AMT</th>
					<td><input type="text" name="bzc_trf_curr_cd" id="bzc_trf_curr_cd"  value="" style="width:34px;" class="input2" readonly><input type="text" name="tot_bil_amt" id="tot_bil_amt"  style="width:170px;text-align:right;" class="input2" readonly>
					</td>
					<th id="tdDRDate">D/R Date</th>
					<td><input type="text" name="dr_dt" id="dr_dt" dataformat="ymd" maxlength="8" caption="D/R Date"  style="width:80px;" class="input"><button type="button" class="calendar" name="btns_calendar" id="btns_calendar"></button></td>
					<td><button type="button" class="btn_etc" name="btn_PreCal" 	id="btn_PreCal">Pre Cal.</button> 
						<button type="button" class="btn_etc" name="btn_DRSave" 	id="btn_DRSave">D/R Save</button> 
						<button type="button" class="btn_etc" name="btn_Balance" id="btn_Balance">Balance Creation</button>
					</td>
					
					<th>CNTR No.</th>
					<td><input type="text" name="batch_cntr" id="batch_cntr" dataformat="engup" style="width:90px;text-align:left;" class="input"></td>
					<td><button type="button" class="btn_etc" name="btn_Batch" id="btn_Batch">Charge Calculation</button></td>
					
				</tr>
			</tbody>
		</table>
	</div>
</div>
<% if(callFlag.equals("P")){ %>
</div>
<%} %>
</form>