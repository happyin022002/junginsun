<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   EES_DMT_3006.jsp
*@FileTitle  : Charge Inquiry by CNTR
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/10
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.event.EesDmt3006Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt3006Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//DB ResultSet Count of list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id	= "";
	String strUsr_nm	= "";
	Logger log			= Logger.getLogger("com.clt.apps.DMTClosing.ChargeCalculation");
	String callFlag		= JSPUtil.getParameter(request, "call_flag", "M");
	
	String bodyProp = "";
	String tableProp = "";
	
	if (callFlag.equals("M")) {
		//Main page
		tableProp 	= "cellpadding='0' cellspacing='0' style='padding-top:2;padding-left:5;'";
	}
	else {
		//PopUp page (callFlag == "P")
		bodyProp	= "class='popup_bg'";
		tableProp	= "class='popup' cellpadding='5'";
	}

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesDmt3006Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// in loading page, Get data from server
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
<input type="hidden" name="web_ind_flg">
<input type="hidden" name="roll_ovr">
<input type="hidden" name="xch_rt">
<input type="hidden" name="dul_tp_expt_flg">
<input type="hidden" name="usr_trf_tp">
<input type="hidden" name="awk_gauge">

<% if(!"P".equals(callFlag)) { %>
	<!-- page(S) -->
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		
		<!-- page_title(S) -->
	    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->
	
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
			--><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button><!--			
			--><button type="button" class="btn_normal" name="btn_CalcDetail" id="btn_CalcDetail">Calculation Detail</button><!--
			--><button type="button" class="btn_normal" name="btn_CorrHistory" id="btn_CorrHistory">Correction History</button><!--
			--><button type="button" class="btn_normal" name="btn_OTHistory" id="btn_OTHistory">O/T History</button><!--
			--><button type="button" class="btn_normal" name="btn_MVMTInq" id="btn_MVMTInq">MVMT Inq.</button>
		</div>
		<!-- opus_design_btn(E) -->
	
	   	<!-- page_location(S) -->
	   	<div class="location">
			<!-- location 내용 동적생성 (별도 코딩 불필요) -->
	        <span id="navigation"></span>
	   	</div>
	   	<!-- page_location(E) -->
	</div>
	<!-- page_title_area(E) -->
	<!--Page Title, Historical (E)-->
<% } else { %>
<!-- popup_title_area(S) -->
<div class="layer_popup_title">

	<div class="page_title_area clear">
	
		<!-- page_title(S) -->
		<h2 class="page_title"><span id="title"></h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
			--><button type="button" class="btn_normal" name="btn_New"  	 id="btn_New">New</button><!--
			--><button type="button" class="btn_normal" name="btn_CalcDetail" id="btn_CalcDetail">Calculation Detail</button><!--
			--><button type="button" class="btn_normal" name="btn_CorrHistory" id="btn_CorrHistory">Correction History</button><!--
			--><button type="button" class="btn_normal" name="btn_OTHistory" id="btn_OTHistory">O/T History</button><!--
			--><button type="button" class="btn_normal" name="btn_MVMTInq" id="btn_MVMTInq">MVMT Inq.</button><!--
        	--><button type="button" class="btn_normal" name="btn_Close"   id="btn_Close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->
		
	</div>
</div>
<!-- popup_title_area(E) -->

<!-- popup_contens_area(S) -->
<div class="layer_popup_contents">
<% } %>

<div class="wrap_search">	
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<!--  MiniLayer (S) -->
		<table>
			<colgroup>
	            <col width="50px" />
	            <col width="100px" />
	            <col width="30px" />
	            <col width="100px" />
	            <col width="30px" />
	            <col width="100px" />
	            <col width="30px" />
	            <col width="100px" />
	            <col width="60px" />
	            <col width="100px" />
	            <col width="35px" />
	            <col width="" />
			</colgroup>
			<tbody>
				<tr>
					<th>CNTR No. </th>
					<td>
						<input type="text" name="cntr_no" value="<%=JSPUtil.getParameter(request, "cntr_no", "")%>" dataformat="engup" maxlength="14"  caption="CNTR No." style="width:100px;" class="input1" onfocus="obj_focus()"><!--
						--><input type="text" name="cntr_tpsz_cd" readonly style="width:30px;" class="input2" value="">
					</td>
					<th>Tariff Type</th>
					<td>
						<script type="text/javascript">ComComboObject('tariff_type',2,64,1,1);</script><!--
						--><input type="checkbox" name="dul_tp_expt_chk" value="" disabled class="trans">Dual Type Exception	
					</td>
					<th>Status</th>
					<td>
						<input type="text" name="dmdt_chg_sts_desc" readonly style="width:80px;" class="input2" value="">
					</td>
					<th>CHRG Type</th>
					<td colspan="5">
						<select name="chg_type"  style="width:108px;" class="input">
							<option value="G" selected>General</option>
							<option value="B">Balance</option>
						</select>
					</td>					
				</tr>
				<tr>
					<th>BKG No.</th>
					<td>
						<input type="text" name="bkg_no" readonly style="width:110px;" class="input2" value="">
					</td>
					<th>B/L No.</th>
					<td>
						<input type="text" name="bl_no" readonly style="width:110px;" class="input2" value="">
					</td>
					<th>Invoice No.</th>
					<td>
						<input type="text" name="dmdt_inv_no" readonly style="width:90px;" class="input2" value="">
					</td>
					<th>A/R  I/F</th>
					<td colspan="5">
						<input type="text" name="dmdt_ar_if_cd" readonly style="width:80px;" class="input2" value="">
					</td>
				</tr>
				<tr>
					<th>VVD CD</th>
					<td>
						<input type="text" name="vvd_cd" readonly style="width:110px;" class="input2" value="">
					</td>
					<th>ATA</th>
					<td>
						<input type="text" name="vps_eta_dt" readonly style="width:80px;" class="input2" value="">
					</td>
					<th>ATB</th>
					<td>
						<input type="text" name="vps_etb_dt" readonly style="width:80px;" class="input2" value="">
					</td>
					<th>ATD</th>
					<td>
						<input type="text" name="vps_etd_dt" readonly style="width:80px;" class="input2" value="">
					</td>
					<th>Pre Port</th>
					<td>
						<input type="text" name="pre_rly_port_cd" readonly style="width:60px;" class="input2" value="">
					</td>
					<th>Post Port</th>
					<td>
						<input type="text" name="pst_rly_port_cd" readonly style="width:60px;" class="input2" value="">
					</td>
				</tr>
				<tr>
					<th title="Place of Receipt">POR</th>
					<td>
						<input type="text" name="por_cd" readonly style="width:110px;" class="input2" value="">
					</td>
					<th title="Port of Loading">POL</th>
					<td>
						<input type="text" name="pol_cd" readonly style="width:80px;" class="input2" value="">
					</td>
					<th title="Port of Discharging">POD</th>
					<td>
						<input type="text" name="pod_cd" readonly style="width:80px;" class="input2" value="">
					</td>
					<th title="Place of Delivery">DEL</th>
					<td>
						<input type="text" name="del_cd" readonly style="width:80px;" class="input2" value="">
					</td>
					<th>R/D</th>
					<td>
						<input type="text" name="rd_term_cd" readonly style="width:60px;" class="input2" value="">
					</td>
					<th>C/H</th>
					<td>
						<input type="text" name="ch" id="ch" readonly style="width:60px;" class="input2" value="">
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
	
	<!-- layout_wrap(S) -->
	<div class="layout_wrap" style="width:100%;">
		<div class="layout_vertical_2 pad_rgt_12">
			<div class="opus_design_inquiry">
				<table class="grid2">
					<tbody>
						<colgroup>
							<col width="60px">
							<col width="68px">
							<col width="*">
					    </colgroup>
						<tr>
							<th class="tr2_head">SHPR</th>
							<td class="noinput2"><input type="text" name="shipper_cd" readonly style="width:66px;" class="noinput2" value=""></td>
							<td class="noinput2"><input type="text" name="shipper_nm" readonly style="width:320px;" class="noinput2" value=""></td>						
						</tr>
						<tr>
							<th class="tr2_head">CNEE</th>
							<td class="noinput2"><input type="text" name="cnee_cd" readonly style="width:66px;" class="noinput2" value=""></td>
							<td class="noinput2"><input type="text" name="cnee_nm" readonly style="width:320px;" class="noinput2" value=""></td>						
						</tr>
						<tr>
							<th class="tr2_head">NTFY</th>
							<td class="noinput2"><input type="text" name="ntfy_cd" readonly style="width:66px;" class="noinput2" value=""></td>
							<td class="noinput2"><input type="text" name="ntfy_nm" readonly style="width:320px;" class="noinput2" value=""></td>						
						</tr>
						<tr>
							<th class="tr2_head">S/P</th>
							<td class="noinput2"><input type="text" name="svc_provdr_cd" readonly style="width:66px;" class="noinput2" value=""></td>
							<td class="noinput2"><input type="text" name="svc_provdr_nm" readonly style="width:320px;" class="noinput2" value=""></td>						
						</tr>
					</tbody>
				</table>
				<table class="grid2 mar_top_8">
					<tbody>
						<colgroup>
							<col width="60px">
							<col width="130px">
							<col width="80px">
							<col width="*">
					    </colgroup>
						<tr>
							<th>From</th>
							<td><input type="text" name="fm_mvmt_dt" id="fm_mvmt_dt"  readonly dataformat="ymd"  maxlength=8  style="width:80px;"><button type="button" class="calendar" name="btns_calendar1" id="btns_calendar1"></button></td>
							<td><input type="text" name="fm_mvmt_yd_cd" id="fm_mvmt_yd_cd"   readonly dataformat="engup" maxlength=7 style="width:70px;" value=""></td>
							<td><input type="text" name="fm_mvmt_sts_cd" id="fm_mvmt_sts_cd" readonly style="width:60px;" value=""></td>
						</tr>
						<tr>
							<th>To</th>
							<td><input type="text" name="to_mvmt_dt" id="to_mvmt_dt"  readonly  dataformat="ymd"  maxlength=8 style="width:80px;"><button type="button" class="calendar" name="btns_calendar2" id="btns_calendar2"></button></td>
							<td><input type="text" name="to_mvmt_yd_cd" id="to_mvmt_yd_cd"  readonly  dataformat="engup" maxlength=7  style="width:70px;" value=""></td>
							<td><script type="text/javascript">ComComboObject('to_mvmt_sts',2,60,0,1);</script></td>
						</tr>
					</tbody>
				</table>
	        </div>
	    </div>
	    <div class="layout_vertical_2">
	        <div class="opus_design_data">
	        	<table class="grid2 wAuto">
					<colgroup>
						<col width="200">
						<col width="85">
						<col width="200">
						<col width="95">
						<col width="110">
						<col width="80">
						<col width="*">
				    </colgroup>		
					<tr>
						<th>S/C No.</th>
						<td class="noinput2"><input type="text" name="sc_no" readonly style="width:83px;" class="noinput2" value=""></td>
						<th>RFA No.</th>
						<td class="noinput2"><input type="text" name="rfa_no" readonly style="width:92px;" class="noinput2" value=""></td>
						<th>A/Customer</th>
						<td class="noinput2" colspan="2"><input type="text" name="acust" readonly style="width:102px;" class="noinput2" value=""></td>
					</tr>
					<tr>
						<th>CMDT</th>
						<td class="noinput2"><input type="text" name="cmdt_cd" readonly style="width:60px;" class="noinput2" value=""></td>
						<td class="noinput2" colspan="5"><input type="text" name="cmdt_nm" readonly style="width:300px;" class="noinput2" value=""></td>
					</tr>
					<tr>
						<th>Rep. CMDT</th>
						<td class="noinput2"><input type="text" name="rep_cmdt_cd" readonly style="width:60px;" class="noinput2" value=""></td>
						<td class="noinput2" colspan="5"><input type="text" name="rep_cmdt_nm" readonly style="width:300px;" class="noinput2" value=""></td>
					</tr>
					<tr>
						<th>S/OFC</th>
						<td class="noinput2"><input type="text" name="sls_ofc_cd" readonly style="width:70px;" class="noinput2" value=""></td>
						<th>R/OFC</th>
						<td class="noinput2"><input type="text" name="rlse_ofc" readonly style="width:45px;" class="noinput2" value=""></td>
						<td class="noinput2"><input type="text" name="rlse_dt" id="rlse_dt" readonly style="width:108px;" class="noinput2" value="" onmouseover="obj_mouseover()" onmouseout="obj_mouseout()"></td>
						<th>DEM/DET OFC</th>
						<td class="noinput2"><input type="text" name="ofc_cd" readonly style="width:58px;" class="noinput2" value=""></td>
					</tr>
				</table>
				<table class="grid2 wAuto" style="display:none;" id="tbl_webmty">
					<tbody>
						<colgroup>
							<col width="60px">
							<col width="100px">
					    </colgroup>
						<tr>
							<td width="70">Web M'ty</td>
							<td width=""><input type="text" name="web_mty_dt" readonly style="width:99%;" class="noinput2" value=" "></td>
						</tr>
						<tr>
							<td width="70">Grace End</td>
							<td width=""><input type="text" name="grace_end_dt" readonly style="width:99%;" class="noinput2" value=" "></td>
						</tr>
					</tbody>
				</table>				
				<div class="layout_wrap">
				    <div class="layout_vertical_2">
				        <div class="opus_design_inquiry">
				            <table class="grid2">
								<tbody>
									<colgroup>
										<col width="110px">
										<col width="*">
								    </colgroup>
									<tr>
										<th>Free Time CMNC</th>
										<td class="noinput2"><input type="text" name="ft_cmnc_dt" readonly style="width:78px;" class="noinput2" value=""></td>
									</tr>
									<tr>
										<th>Free Time End</th>
										<td class="noinput2"><input type="text" name="ft_end_dt" readonly style="width:78px;" class="noinput2" value=""></td>
									</tr>
								</tbody>
							</table>
				        </div>
				    </div>
				    <div class="layout_vertical_2">
				        <div class="opus_design_inquiry pad_left_8">
				            <table class="grid2" style="width:99%;">
								<tbody>
									<colgroup>
										<col width="70px">
										<col width="*">
								    </colgroup>
									<tr class="">
										<th>Free Time</th>
										<td class="noinput2"><input type="text" name="ft_dys" readonly style="width:40px;text-align:right;" class="noinput2" value=""></td>
									</tr>
									<tr>
										<th>Over Day</th>
										<td class="noinput2"><input type="text" name="fx_ft_ovr_dys" readonly style="width:40px;text-align:right;" class="noinput2" value=""></td>								
									</tr>
								</tbody>
							</table>
				        </div>
				    </div>
				</div>
        	</div>
		</div>
	</div>
	<!-- layout_wrap(E) -->
	<!-- layout_wrap(S) -->
	<div class="layout_wrap" style="width:100%;">
	    <div class="layout_vertical_2 mar_rgt_8" style="width:69%;" >
	        <div class="opus_design_data">
	            <table class="grid2 mar_btm_8">
					<tbody>
						<colgroup>
							<col width="80px">
							<col width="110px">
							<col width="80px">
							<col width="*">
					    </colgroup>
						<tr>
							<th>CNTR Type</th>
							<td class="noinput2"><input type="text" name="dmdt_cntr_tp_cd" readonly style="width:100px;" class="noinput2" value=""></td>
							<th>Cargo Type</th>
							<td class="noinput2"><input type="text" name="dmdt_bkg_cgo_tp_cd" readonly style="width:330px;" class="noinput2" value=""></td>
						</tr>
					</tbody>
				</table>
	        </div>
	        <!-- opus_design_grid(S) -->
	        <div class="opus_design_grid" id="mainTable">
	        	<script type="text/javascript">ComSheetObject('sheet1');</script>
	        </div>
	        <!-- opus_design_grid(E) -->
	    </div>
	    <div class="layout_vertical_2" style="width:30%;" >
	        <div class="opus_design_data">
	            <table class="grid2 mar_btm_8">
					<tbody>
						<colgroup>
							<col width="110px">
							<col width="*">
					    </colgroup>
						<tr>
							<th>Charge Currency</th>
							<td class="noinput2"><input type="text" name="bzc_trf_curr_cd" readonly style="width:46px;" class="noinput2" value=""></td>
						</tr>
					</tbody>
				</table>
				<table class="grid2">
					<tbody>
						<colgroup>
							<col width="110px">
							<col width="*">
					    </colgroup>
						<tr>
							<th>Total AMT</th>
							<td class="noinput2"><input type="text" name="total_amt" readonly style="width:215px;text-align:right" class="noinput2" value=""></td>
						</tr>
						<tr>
							<th>D/C by AMT  or %</th>
							<td class="noinput2"><input type="text" name="aft_expt_dc_amt" readonly style="width:215px;text-align:right" class="noinput2" value=""></td>
						</tr>
						<tr>
							<th>Billable AMT</th>
							<td class="noinput2"><input type="text" name="bil_amt" readonly style="width:215px;text-align:right" class="noinput2" value=""></td>
						</tr>
					</tbody>
				</table>
	        </div>
	    </div>
	</div>
	<!-- layout_wrap(E) -->
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<table   class="grid2" style="width:100%;">
			<tbody>
				<colgroup>
					<col width="100px">
					<col width="800px">
					<col width="*">
			    </colgroup>
				<tr>
					<th>Remark(s)</th>
					<td><textarea  name="corr_rmk" style="width:100%;height:90px;" class="noinput2" readonly></textarea></td>
				</tr>	
			</tbody>
		</table>
	</div>
</div>

<% if ("P".equals(callFlag)) { %>
</div>
<% } %>
<div id="topdeck" style="position:absolute;visibility:hidden;z-index:200;"></div>
</form>