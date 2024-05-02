<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_3107.jsp
*@FileTitle  : Calculation Detail
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/30
=========================================================*/
%>


<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.event.EesDmt3107Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt3107Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.DMTClosing.ChargeCalculation");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesDmt3107Event)request.getAttribute("Event");
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
<input type="hidden" name="est_mk" id="est_mk"				value="<%=JSPUtil.getParameter(request, "est_mk", "")%>">
<input type="hidden" name="svr_id" id="svr_id"				value="<%=JSPUtil.getParameter(request, "svr_id", "")%>">
<input type="hidden" name="cntr_cyc_no" id="cntr_cyc_no"			value="<%=JSPUtil.getParameter(request, "cntr_cyc_no", "")%>">
<input type="hidden" name="dmdt_chg_loc_div_cd" id="dmdt_chg_loc_div_cd"	value="<%=JSPUtil.getParameter(request, "dmdt_chg_loc_div_cd", "")%>">
<input type="hidden" name="chg_seq" id="chg_seq"				value="<%=JSPUtil.getParameter(request, "chg_seq", "")%>">
<input type="hidden" name="fm_mvmt_dt" id="fm_mvmt_dt"			value="<%=JSPUtil.getParameter(request, "fm_mvmt_dt", "")%>"> 		<!-- 2010.10.26 추가 -->
<input type="hidden" name="fm_mvmt_yd_cd" id="fm_mvmt_yd_cd"		value="<%=JSPUtil.getParameter(request, "fm_mvmt_yd_cd", "")%>">	<!-- 2010.11.01 추가 -->

<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Calculation Detail(s)</span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_Close" id="btn_Close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry">
			<table>
				<colgroup>
					<col width="60"/>
					<col width="140"/>
					<col width="70"/>
					<col width="70"/>
					<col width="50"/>
					<col width="130"/>
					<col width="50"/>
					<col width="130"/>
					<col width="90"/>
					<col width="*" />				
				</colgroup> 
				<tr>
					<th>CNTR No.</th>
					<td><input type="text" name="cntr_no" id="cntr_no" value="<%=JSPUtil.getParameter(request, "cntr_no", "")%>" readonly style="width:90px;text-align:center;" class="input2"><input type="text" name="cntr_tpsz_cd" id="cntr_tpsz_cd" value="<%=JSPUtil.getParameter(request, "cntr_tpsz_cd", "")%>" readonly  style="width:25px;text-align:center;" class="input2"></td>
					<th>Tariff Type</th>
					<td><input type="text" name="dmdt_trf_cd" id="dmdt_trf_cd" value="<%=JSPUtil.getParameter(request, "dmdt_trf_cd", "")%>" readonly style="width:50px;text-align:center;" class="input2"></td>
					<th>BKG No.</th>
					<td><input type="text" name="bkg_no" id="bkg_no" value="<%=JSPUtil.getParameter(request, "bkg_no", "")%>" readonly style="width:110px;text-align:center;text-align:center;" class="input2"></td>
					<th>B/L No.</th>
					<td><input type="text" name="bl_no" id="bl_no" value="<%=JSPUtil.getParameter(request, "bl_no", "")%>" readonly style="width:110px;text-align:center;" class="input2"></td>
					<th>DEM/DET OFC</th>
					<td><input type="text"  name="ofc_cd" id="ofc_cd" value="<%=JSPUtil.getParameter(request, "ofc_cd", "")%>" readonly  style="width:50px;text-align:center;" class="input2" value=""></td>
				</tr>
			</table>
		</div>
	</div>
	<div class="wrap_result">	
	
		<div class="opus_design_grid" id="mainTable">
			<script type="text/javascript">ComSheetObject('sheet5');</script>
		</div>
		
		<div class="opus_design_grid" id="mainTable">
			<div class="opus_design_inquiry">
				<table>
					<tr>
						<td><h3 class="title_design">Incurred Amount</h3></td>
						<td align="right"><input type="text" name="bzc_trf_curr_cd" id="bzc_trf_curr_cd" readonly style="width:40px;text-align:center"  class="input2"><input type="text" name="org_chg_amt" id="org_chg_amt" readonly style="width:180px;text-align:right" value="" class="input2"></td>
					</tr>
				</table>
			</div>
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		
	
		<div class="opus_design_grid" id="mainTable">
			<div class="opus_design_inquiry">
				<table class="search" border="0">
					<tr><td class="title_h"></td>
						<td><h3 class="title_design">Commodity Exception Amount</h3></td>
						<td align="right"><input type="text" name="bzc_trf_curr_cd" id="bzc_trf_curr_cd" readonly style="width:40px;text-align:center" value="" class="input2"><input type="text" name="cmdt_expt_amt" id="cmdt_expt_amt" readonly style="width:180px;text-align:right" value="" class="input2"></td>
					</tr>
				</table>
			</div>
			<script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>
		
		<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			
		<div class="opus_design_grid" id="mainTable">
			<div class="opus_design_inquiry">
				<table>
					<tr>
						<td><h3 class="title_design">Exception Amount</h3></td>
						<td align="right"><input type="text" name="bzc_trf_curr_cd" id="bzc_trf_curr_cd" readonly style="width:40px;text-align:center" value="" class="input2"><input type="text" name="sc_rfa_expt_amt" id="sc_rfa_expt_amt" readonly style="width:180px;text-align:right" value="" class="input2"></td>
					</tr>
				</table>
			</div>	
			<script type="text/javascript">ComSheetObject('sheet3');</script>
		</div>
		
		<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
		
		<div class="opus_design_grid" id="mainTable">
			<div class="opus_design_inquiry">
				<table>
					<tr>
						<td><h3 class="title_design">Discount Amount</h3></td>
						<td align="right"><input type="text" name="bzc_trf_curr_cd" readonly style="width:40px;text-align:center" value="" class="input2"><input type="text" name="aft_expt_dc_amt" id="aft_expt_dc_amt" readonly style="width:180px;text-align:right" value="" class="input2"></td>
					</tr>
				</table>
			</div>
			<script type="text/javascript">ComSheetObject('sheet4');</script>
		</div>
		
		<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
		
		<div class="opus_design_grid" id="mainTable">
			<div class="opus_design_inquiry">
				<table>
					<tr><td class="title_h"></td>
						<td><h3 class="title_design">Billable Amount</h3></td>
						<td align="right"><input type="text" name="bzc_trf_curr_cd" id="bzc_trf_curr_cd" readonly style="width:40px;text-align:center" value="" class="input2"><input type="text" name="bil_amt" id="bil_amt" readonly style="width:180;text-align:right" value="" class="input2"></td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</div>
</form>