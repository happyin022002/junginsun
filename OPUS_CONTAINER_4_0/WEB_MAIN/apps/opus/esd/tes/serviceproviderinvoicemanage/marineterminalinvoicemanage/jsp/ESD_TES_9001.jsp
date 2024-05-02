<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESD_TES_9001.jsp
*@FileTitle  : Node 조회(공통 Popup)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/26
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event.EsdTes9001Event"%>

<%
	EsdTes9001Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//occurring error in server
	String strErrMsg = "";						//error message
	
    String yd_cd = JSPUtil.getParameter(request,"yd_cd");
    String vndr_seq = JSPUtil.getParameter(request,"vndr_seq");
    String vndr_seq_nm = JSPUtil.getParameter(request,"vndr_seq_nm");
    String yd_cd2 = JSPUtil.getParameter(request,"yd_cd").substring(0, 5); 
    String cost_cd_inv_tp_cd = JSPUtil.getParameter(request,"cost_cd_inv_tp_cd");
    
    String atb_dt = JSPUtil.getParameter(request,"atb_dt");
    String min_wrk_dt = JSPUtil.getParameter(request,"min_wrk_dt");
    String max_wrk_dt = JSPUtil.getParameter(request,"max_wrk_dt");
    String iss_dt = JSPUtil.getParameter(request,"iss_dt");
    String fm_prd_dt = JSPUtil.getParameter(request,"fm_prd_dt");
    String to_prd_dt = JSPUtil.getParameter(request,"to_prd_dt");
    
    String yd_nm = JSPUtil.getParameter(request,"yd_nm");
    String vvd = JSPUtil.getParameter(request,"vvd");
    String curr_cd = JSPUtil.getParameter(request,"curr_cd");
    try {
	    event = (EsdTes9001Event)request.getAttribute("Event");
	
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
	
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">

	var sFunc = '<%=JSPUtil.getParameter(request, "func")%>'; //js소스 생성
	var prgm_id = '<%=JSPUtil.getParameter(request, "prgm_id")%>'; //프로그램 ID에 따라 화면 UI가 변경 됨.
	
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" value="">
<input type="hidden" name="agmt_ofc_cty_cd" value="">
<input type="hidden" name="agmt_seq" value="">
<input type="hidden" name="agmt_ver_no" value="">
<input type="hidden" name="tml_trns_mod_cd" value="">
<input type="hidden" name="vndr_seq" value="<%=vndr_seq  %>">
<input type="hidden" name="cost_code" value="">
<input type="hidden" name="tmp_common_code"	value="">
<input type="hidden" name="cost_cd_inv_tp_cd"	value="<%=cost_cd_inv_tp_cd%>">

<input type="hidden" name="atb_dt"	value="<%=atb_dt%>">
<input type="hidden" name="min_wrk_dt"	value="<%=min_wrk_dt%>">
<input type="hidden" name="max_wrk_dt"	value="<%=max_wrk_dt%>">
<input type="hidden" name="iss_dt"	value="<%=iss_dt%>">
<input type="hidden" name="fm_prd_dt"	value="<%=fm_prd_dt%>">
<input type="hidden" name="to_prd_dt"	value="<%=to_prd_dt%>">

<input type="hidden" name="yd_nm"	value="<%=yd_nm%>">
<input type="hidden" name="vvd"	value="<%=vvd%>">
<input type="hidden" name="curr_cd"	value="<%=curr_cd%>">

<!-- 개발자 작업 -->
<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><span>Agreement Information Manual Rate.</span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button 	type="button" class="btn_normal" name="btn_SelectItems" id="btn_SelectItems">Select Items</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Delete"  	id="btn_Delete">Delete</button><!--
	--></div>
	<!-- opus_design_btn (E) -->
</div>
<!-- page_title_area(E) -->
	<!-- page_title_area(S) -->
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit sm">
			<table>
	             <colgroup>
	                <col width="35"  />
	                <col width="70" />
	                <col width="60"  />
	                <col width="90" />
	                <col width="125"  />
	                <col width="115" />
	                <col width="88"  />
	                <col width="*" />
	            </colgroup>
	            <tbody>
					<tr>
						<th>Agreement No.</th>
						<td colspan="3">
							<input class="input2" type="text" style="width:98;text-align:center" name="agmt_no" value='' maxlength=6  DISABLED>
						</td>						
						<th>Agreement Version</th>
						<td>
							<input class="input2" type="text" style="width:68;text-align:right" name="agmt_version" value=''   DISABLED>
						</td>
						<th>Cost Code</th>
						<td>	
							<script language="javascript">ComComboObject('cost_code_combo', 1, 91, 1, 1)</script>
						</td>
					</tr>
					<tr>
						<th>UOM</th>
						<td>
							<SELECT name="tml_agmt_vol_ut_cd" style='width: 60' onChange='form_combo_onChange(this)'>
									<OPTION value="ALL">ALL</OPTION>
										<OPTION value="C">C</OPTION>
										<OPTION value="T">T</OPTION>
										<OPTION value="U">U</OPTION>
										<OPTION value="M">M</OPTION>
										<OPTION value="G">G</OPTION>
										<OPTION value="W">W</OPTION>
								<%if("OS".equals(cost_cd_inv_tp_cd)){ %>	
										<OPTION value="">Over day</OPTION>
								<%} %>	
							</SELECT>
						</td>
						<th>Type Size</th>
						<td>
							<SELECT name="cntr_tpsz_cd" style='width: 70' onChange='form_combo_onChange(this)'>
								<OPTION value="ALL">ALL</OPTION>
							</SELECT>
							<%//= JSPUtil.getCodeCombo("cntr_tpsz_cd", "", "style='width:70' onChange='form_combo_onChange(this)'", "CD00830", 1, "00:ALL:ALL")%>
						</td>
						<th>DG</th>
						<td>
							<%--= JSPUtil.getCodeCombo("dcgo_ind_cd", "N", "style='width:70' onChange='form_combo_onChange(this)'", "CD00167", 1, "00:ALL:ALL")--%>
							
									<SELECT name="dcgo_ind_cd" style='width: 90' onChange='form_combo_onChange(this)'>
									    <OPTION value="ALL">ALL</OPTION>
									    <OPTION value="N">None</OPTION>
									    <OPTION value="AN">Same No DG</OPTION>
									    <OPTION value="AS">Same DG</OPTION>
									    <OPTION value="SN">Sep.No DG</OPTION>
										<OPTION value="1">Sep.1</OPTION>
										<OPTION value="2">Sep.2</OPTION>
										<OPTION value="3">Sep.3</OPTION>
										<OPTION value="4">Sep.4</OPTION>
										<OPTION value="5">Sep.5</OPTION>
										<OPTION value="6">Sep.6</OPTION>
										<OPTION value="7">Sep.7</OPTION>
										<OPTION value="8">Sep.8</OPTION>
										<OPTION value="9">Sep.9</OPTION>																				
									</SELECT>								
						</td>
						<th>Applied Date</th>
						<td>
							<%= JSPUtil.getCodeCombo("tml_wrk_dy_cd", "", "style='width:91' onChange='form_combo_onChange(this)'", "CD00168", 1, "00::")%>
						</td>
					</tr>
				</tbody>
			</table>
		</div>	
			<table class="height_10"><tr><td></td></tr></table>
		<div class="opus_design_inquiry wFit sm">
			<table>
	             <colgroup>
	             	<col width="100"  />
	                <col width="40"  />
	                <col width="100" />
	                <col width="115"  />
	                <col width="120" />
	                <col width="210"  />	                
	                <col width="*" />
	            </colgroup>
	            <tbody>
					<tr>
						<th colspan="2" style="text-align:center">Yard Code</th>
						<td>
							<input class="input2" type="text" style="width:75;text-align:center" name="yd_cd" value='<%=yd_cd%>' maxlength=6  DISABLED>
						</td>						
						<th>S/P Code</th>
						<td>
							<input class="input2" type="text" style="width:75;text-align:center" name="sp_cd" value='<%=vndr_seq  %>'  maxlength=6  DISABLED>
						</td>
						<th>S/P Name (Abbr.)</th>
						<td>	
							<input class="input2" type="text" style="width:180" name="sp_nm" value='<%=vndr_seq_nm %>'  maxlength=6  DISABLED>
						</td>
					</tr>
					<tr>
						<th rowspan="2" style="border-right:1px solid #000">Effective Date</th>
						<th class="pad_left_4">From</th>
						<td>
							<input class="input2" type="text" style="width:75;text-align:center" name="eff_fm_dt" value=''  maxlength=8  DISABLED>
						</td>
						<th>Contract Office</th>
						<td>
							<input class="input2" type="text" style="width:75;text-align:center" name="ctrt_ofc_cd" value=''  maxlength=6  DISABLED>
						</td>
						<th>Creation Office</th>
						<td>
							<input class="input2" type="text" style="width:75;text-align:center" name="cre_ofc_cd" value=''  maxlength=6  DISABLED>
						</td>						
					</tr>
					<tr>
						<th class="pad_left_4">To</th>
						<td>
							<input class="input2" type="text" style="width:75;text-align:center" name="eff_to_dt" value=''  maxlength=8  DISABLED>
						</td>
						<th>Creation Date</th>
						<td>
							<input class="input2" type="text" style="width:75;text-align:center" name="cre_dt" value=''  maxlength=6  DISABLED>
						</td>
						<th>Update Date</th>
						<td>
							<input class="input2" type="text" style="width:75;text-align:center" name="upd_dt" value=''  maxlength=6  DISABLED>
						</td>						
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<!-- page_title_area(E) -->
	<!-- wrap_result(S) -->
	<div class="wrap_result">
	    <!-- opus_design_grid(S) -->
	    <div class="opus_design_grid clear" id="mainTable" >
	    	<!-- opus_design_btn(S) -->
        	<div class="opus_design_btn">
	            <button type="button" class="btn_normal" id="btn_AddItem" name="btn_AddItem">Add Item</button>
	        </div>
	        <script>ComSheetObject('sheet1');</script>
			        
		<table width="100%">
	    	<tr><td height="5"></td></tr>
           	<tr><td height="10" align='center' style='color:#0080c0;'>▼</td></tr>
           	<tr><td height="5"></td></tr>
		</table>
			<script>ComSheetObject('select');</script>
		</div>
	</div>
</form>
<div class="opus_design_grid clear" style="display:none">
	<script>ComSheetObject('costcode');</script>	
</div>