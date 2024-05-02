<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_3005.jsp
*@FileTitle  : Charge Inquiry by Booking
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/19
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.event.EesDmt3005Event"%>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt3005Event  event = null;				//PDTO(Data Transfer Object including Parameters)
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
	
	String callFlag = JSPUtil.getParameter(request, "call_flag", "M");
	String bodyProp = "";
	String tableProp = "";
	
	if (callFlag.equals("M")) {
		//in case of Main
		tableProp 	= "cellpadding='0' cellspacing='0' style='padding-top:2;padding-left:5;'";
	}
	else {
		//in case of PopUp (callFlag == "P")
		bodyProp	= "class='popup_bg'";
		tableProp	= "class='popup' cellpadding='5'";
	}

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_Cnt_cd = account.getCnt_cd();
		strRhq_ofc_cd = account.getRhq_ofc_cd();

		event = (EesDmt3005Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// Retrieving the parameter values ​​for calls to pop-up page ..
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
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">

<!-- Developer's task	-->
<input type="hidden" name="usr_cnt_cd" id="usr_cnt_cd"			value="<%=strUsr_Cnt_cd%>">
<input type="hidden" name="call_flag" id="call_flag"			value="<%=callFlag%>">
<input type="hidden" name="dmdt_trf_cd" id="dmdt_trf_cd"			value="<%=JSPUtil.getParameter(request, "dmdt_trf_cd", "")%>">
<input type="hidden" name="dmdt_chg_sts_cd" id="dmdt_chg_sts_cd"		value="<%=JSPUtil.getParameter(request, "dmdt_chg_sts_cd", "")%>">
<input type="hidden" name="est_mk" id="est_mk">
<input type="hidden" name="sch_chg_sts" id="sch_chg_sts">
<input type="hidden" name="ar_act_cd" id="ar_act_cd">
<input type="hidden" name="usr_trf_tp" id="usr_trf_tp">
<input type="hidden" name="usr_rhq_ofc_cd" id="usr_rhq_ofc_cd"		value="<%=strRhq_ofc_cd%>">
<input type="hidden" name="rhq_ofc_cd" id="rhq_ofc_cd">
<input type="hidden" name="backendjob_key" id="backendjob_key">		<!-- BackEndJob Key -->
<input type="hidden" name="backendjob_id" id="backendjob_id">		<!-- BackEndJob division ID -->
<input type="hidden" name="head_office" id="head_office"			value="<%=ConstantMgr.getHeadOfficeCode()%>"><!-- HEAD OFFICE -->
<input type="hidden" name="status">

<%
	if(callFlag.equals("P")){
%>
<!-- popup_title_area(S) -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Charge Inquiry by Booking</span></h2>
		<div class="opus_design_btn"><!-- 
			 --><button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" onmousedown="obj_mousedown()">Retrieve</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_New" id="btn_New" >New</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_Minimize" id="btn_Minimize" >Minimize</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_ByCNTR" id="btn_ByCNTR" >by CNTR</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_MVMTInq" id="btn_MVMTInq" >MVMT Inq.</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel" >Down Excel</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_Close" 	id="btn_Close" >Close</button><!-- 
		 --></div>
	</div>
</div>
<!-- popup_title_area(E) -->

<!-- popup_contens_area(S) -->
<div class="layer_popup_contents">

<% } else { %>
<!-- page(S) -->
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	
	<!-- page_title(S) -->
    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" >Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_New" id="btn_New" >New</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Minimize" id="btn_Minimize" >Minimize</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_ByCNTR" id="btn_ByCNTR" >by CNTR</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_MVMTInq" id="btn_MVMTInq" >MVMT Inq.</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel" >Down Excel</button>
	</div>
	<!-- opus_design_btn(E) -->

   	<!-- page_location(S) -->
   	<div class="location">
        <span id="navigation"></span>
   	</div>
   	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->
<!--Page Title, Historical (E)-->

<% }%>
	
<div id="mini_div" class="wrap_search" style="display: block;">
	<div class="opus_design_inquiry wFit">
		<table class="search">
			<tbody>
				<colgroup>
		            <col width="55px" />
		            <col width="140px" />
		            <col width="50px" />
		            <col width="140px" />
		            <col width="50px" />
		            <col width="110px" />
		            <col width="50px" />
		            <col width="110px" />
		            <col width="50px" />
		            <col width="110px" />
		            <col width="50px" />
		            <col width="*" />	            
				</colgroup>
				<tr class="h23">
					<th>BKG No.</th>
					<td><input type="text" name="bkg_no" id="bkg_no" value="<%=JSPUtil.getParameter(request, "bkg_no", "")%>" dataformat="engup" maxlength="13" caption="BKG No."  style="width:110px;" class="input1"></td>
					<th>B/L No.</th>
					<td><input type="text" name="bl_no" id="bl_no" value="<%=JSPUtil.getParameter(request, "bl_no", "")%>" dataformat="engup" maxlength="12"   caption="B/L No."  style="width:110px;" class="input1"></td>
					<th>Tariff Type</th>
					<td><script type="text/javascript">ComComboObject('tariff_type',2,70,0,1);</script></td>
					<th>Status</th>
					<td colspan="3"><script type="text/javascript">ComComboObject('status_combo',1,170,0,1);</script><button type="button" class="multiple_inq"></button></td>
					<th>RHQ</th>
					<td><script type="text/javascript">ComComboObject('rhq_ofc',1,70,0,1);</script></td>					
				</tr>
				<tr class="h23">
					<th>VVD CD</th>
					<td><input type="text" name="vvd_cd"  maxlength="9" style="width:110px;" class="input2" value="" readonly></td>
					<th>ATA</th>
					<td><input type="text" name="vps_eta_dt"  style="width:80px;" class="input2" value="" caption="ATA" readonly></td>
					<th>ATB</th>
					<td><input type="text" name="vps_etb_dt"  style="width:80px;" class="input2" value="" caption="ATB" readonly></td>
					<th>ATD</th>
					<td><input type="text" name="vps_etd_dt"  style="width:80px;" class="input2" value="" caption="ATD" readonly></td>
					<th>Pre Port</th>
					<td><input type="text" name="pre_rly_port_cd"  style="width:60px;" class="input2" readonly></td>
					<th>Post Port</th>
					<td><input type="text" name="pst_rly_port_cd" style="width:70px;" class="input2" readonly></td>
				</tr>
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
					<td colspan="3"><input type="text" name="rd_term_cd" style="width:60px;" class="input2" readonly></td>
				</tr>
			</tbody>
		</table>
	</div>

	<div class="layout_wrap wFit">
	    <div class="layout_vertical_3 opus_design_inquiry" style="width:35%;">
			<table class="grid2" style="width:95%">
				<colgroup>
					<col width="70" />
					<col width="90" />
					<col width="" />
				</colgroup>
				<tbody>
					<tr class="h23">
						<th class="tr2_head">SHPR</th>
						<td  class="noinput2"><input type="text" name="shipper_cd"  readonly style="width:100%;" class="noinput2"></td>
						<td class="noinput2"><input type="text" name="shipper_nm" readonly style="width:100%;" class="noinput2" ></td>
					</tr>
					<tr class="h23">
						<th class="tr2_head">CNEE</th>
						<td  class="noinput2"><input type="text" name="cnee_cd" readonly style="width:100%;" class="noinput2" ></td>
						<td class="noinput2"><input type="text" name="cnee_nm" readonly style="width:100%;" class="noinput2" ></td>
					</tr>
					<tr class="h23">
						<th class="tr2_head">NTFY</th>
						<td class="noinput2"><input type="text" name="ntfy_cd" readonly style="width:100%;" class="noinput2" ></td>
						<td  class="noinput2"><input type="text" name="ntfy_nm"  readonly style="width:100%;" class="noinput2" ></td>
					</tr>
					<tr class="h23">
						<th class="tr2_head">S/P</th>
						<td class="noinput2"><input type="text" name="svc_provdr_cd" readonly style="width:100%;" class="noinput2" ></td>
						<td class="noinput2"><input type="text" name="svc_provdr_nm"  readonly  style="width:100%;" class="noinput2"></td>
					</tr>
				</tbody>
			</table>
	    </div>
	    <div class="layout_vertical_2 opus_design_inquiry">
			<table class="grid2" style="width:95%">
				<colgroup>
					<col width="50" />
					<col width="20" />
					<col width="50" />
					<col width="50" />
					<col width="50" />
					<col width="90" />
					<col width="30" />
					<col width="90" />
					<col width="" />
				</colgroup>
				<tbody>
					<tr class="h23">
						<th class="tr2_head">S/C No.</th>
						<td class="noinput2" colspan="2"><input type="text" name="sc_no" style="width:88px;" class="noinput2" readonly></td>
						<th class="tr2_head">RFA No.</th>
						<td class="noinput2" colspan="2"><input type="text" name="rfa_no" value="" style="width:87px;" class="noinput2" readonly></td>
						<th class="tr2_head" >A/Customer</th>
						<td class="noinput2"><input type="text" name="acust" style="width:90px;" class="noinput2" readonly></td>
					</tr> 
					<tr class="h23">
						<th class="tr2_head">CMDT</th>
						<td class="noinput2" colspan="2"><input type="text" name="cmdt_cd" style="width:100%;" class="noinput2" readonly></td>
						<td class="noinput2" colspan="5"><input type="text" name="cmdt_nm" style="width:100%;" class="noinput2" readonly></td>
					</tr>
					<tr class="h23">
						<th class="tr2_head" colspan="2">Rep.CMDT</th>
						<td class="noinput2"><input type="text" name="rep_cmdt_cd" style="width:100%;" class="noinput2" readonly></td>
						<td class="noinput2"  colspan="5"><input type="text" name="rep_cmdt_nm"  style="width:100%;" class="noinput2" value="" readonly></td>
					</tr>
					<tr class="h23">
						<th class="tr2_head">S/Office</th>
						<td class="noinput2" colspan="2"><input type="text" name="sls_ofc_cd" style="width:90px;" class="noinput2" readonly></td>
						<th class="tr2_head" id='tdROffice' title="Cargo Release Office">R/Office </th>
						<td  class="noinput2"><input type="text" name="rlse_ofc" style="width:70px" class="noinput2" readonly></td>
						<td  class="noinput2"><input type="text" name="d_o" style="width:97px;" class="noinput2" readonly></td>
						<td  class="noinput2"><input type="text" name="partial" style="width:30px;text-align:center;" class="noinput2" readonly></td>
						<td  class="noinput2"><input type="text" name="rlse_dt" style="width:90px" class="noinput2" readonly></td>							
					</tr>
				</tbody>
			</table>
	    </div>
	</div>
</div>

<div class="wrap_result">
	<div class="opus_design_grid" >
    	<script type="text/javascript">ComSheetObject('sheet1');</script>
    	<br/>
    	<div class="grid_option_left">  
    	<table>
   			<colgroup>
				<col width="70" />
				<col width="40" />
				<col width="150" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr class="h23">
					<th>CNTR Q'TY</th>
					<td><input type="text" name="cntr_qty" style="width:40px;text-align:right;" class="input2" readonly ></td>
					<th>Total Billable AMT</th>
					<td><input type="text" name="bzc_trf_curr_cd" style="width:40px;" class="input2" readonly ><!--
						--><input type="text" name="tot_bil_amt"  style="width:170px;text-align:right;" class="input2" readonly></td>
				</tr>
			</tbody>
		</table>
    	</div>

    	<div class="grid_option_right">  
    	<table>
    		<colgroup>
				<col width="70" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr class="h23">
					<th id="tdDRDate" title="Delivery & Return Date">D/R Date</th>
					<td><input type="text" name="dr_dt" id="dr_dt" dataformat="ymd" maxlength="8" caption="D/R Date"  style="width:80px;" class="input"><!--
                        --><button type="button" class="calendar ir" name="btns_calendar" id="btns_calendar"  alt="Delivery & Return Date" ></button><button type="button" class="btn_etc" name="btn_PreCal" id="btn_PreCal">Pre Cal.</button></td>
				</tr>
			</tbody>
		</table>
    	</div>    	
	</div>	
</div>	
	
<% 
	if(callFlag.equals("P")){ 
%>
</div>
<% 
	}
%>
  
</form>
