<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_PRD_0002.jsp
*@FileTitle  : Node Inquiry 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse" %>
<%@ page import="com.clt.apps.opus.esd.prd.common.prdcommon.vo.ContinentVO"%>
<%@ page import="java.util.List" %>
<%
	GeneralEventResponse eventResponse = null;
	Exception serverException   = null;
	List list = null;
	String strErrMsg = "";
	String nodeCd = "";
	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
			eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
			if (eventResponse != null) {
				list = eventResponse.getRsVoList();
			}
		} 
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		nodeCd = "<%=nodeCd%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		}
		loadPage();
	}
</script>

<form method="post" name="form">
<input	type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="iPage" id="iPage">

<!-- page(S) -->
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button>
	</div>
	<!-- opus_design_btn(E) -->

   	<!-- page_location(S) -->
   	<div class="location">
        <span id="navigation"></span>
   	</div>
   	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<!-- opus_design_inquiry(S) -->
<div class="wrap_search">
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
	            <col width="80" />
	            <col width="170" />
	            <col width="110" />
	            <col width="100" />
	            <col width="90" />
	            <col width="50" />
	            <col />
			</colgroup>
			<tr>
				<th>Continent</th>
				<td><input class="input1" type="hidden" name="conti_code" id="conti_code" value="">
				<select class="input1" name="select1" id="select1" style="width:60;" onChange="changeContinent()" tabIndex="1">
				<option value="0" >All</option>
				<%	
					if(list != null) {
						for(int i=0; i< list.size(); i++) {
							ContinentVO vo = (ContinentVO)list.get(i);
							if(vo != null) {
								out.println("<option value='"+ vo.getContiCode() +"' >" + vo.getContiCode() + "</option>");
							}
						}
					}
				%>
				</select>
				</td>
				<th>Sub-Continent</th>
				<td><input class="input1" type="hidden" name="subconti_code" id="subconti_code" value=""><select class="input1" name="select2" id="select2" style="width:70" onChange="changeSubContinent()" tabIndex="2"><option value="0" selected>All</option></select></td>
				<td></td>
				<td colspan="3">
					<div class="sm align_center pad_top_4" style="width:200px;">
						<input type="hidden" name="node_type_div" value="" ><input type="radio" name="radio1" id="radio11" class="trans" value="" checked="checked"  tabIndex="3" ><label for="radio11"> Both </label><input type="radio" name="radio1" e="radio12" class="trans" value="Y" ><label for="radio12"> Yard </label><input type="radio" name="radio1" e="radio13" class="trans" value="Z" ><label for="radio13"> Zone</label>
					</div>
				</td>
			</tr>
			<tr>
				<th>Country</th>
				<td><input class="input1" type="text" maxlength="2" name="country_code" value="" style="width:45px;text-align:center"  tabIndex="4" dataformat="engup" ><button type="button" class="input_seach_btn" name="btn_cnt" id="btn_cnt"></button></td>
				<th>Region</th>
				<td><input type="text" name="region_code" maxlength="3"  value="" style="width:45px;text-align:center"  tabIndex="5"  dataformat="engup" ></td>
				<th>Location</th>
				<td><input type="text" maxlength="5" name="location_code_top" id="location_code_top" value="" style="width:70px;text-align:center" tabIndex="6"  dataformat="engup" ><button type="button" class="input_seach_btn" name="loc_btn" id="loc_btn"></button></td>
				<th>Node</th>
				<td><input type="text" name="node_code_top" id="node_code_top" maxlength="7" value="" style="width:70px; text-align:center"  tabIndex="7"  dataformat="engup"><button type="button" class="input_seach_btn" name="node_btn" id="node_btn"></button></td>
			</tr>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->



<!-- opus_design_grid(S) -->
<div class="wrap_result">

	<div class="opus_design_grid">
	    <script  type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	
	<!-- opus_tab_btn(S) -->
	<div class="opus_design_tab">
		<script  type="text/javascript">ComTabObject('tab1')</script>
	</div>
	<!-- opus_tab_btn(E) -->

	<!-- opus_design_grid(S) -->
	<div name="tabLayer" id="tabLayer">
		
		<div class="opus_design_btn">				
			<button type="button" class="btn_normal" name="btng_constraint" id="btng_constraint">Constraint</button>
			<button type="button" class="btn_normal" name="btng_yardcct" id="btng_yardcct">Yard CCT</button>
		</div>
		
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry">
			<!-- layout_wrap(S) -->
			<div class="layout_wrap">
				<div class="layout_vertical_2 pad_rgt_12" style="width:60%">
					<div class="opus_design_inquiry sm">
							<h3 class="title_design">Basic Info.</h3>
							<table>
								<colgroup>
									<col width="140"/>
									<col width="250"/>
									<col width="90"/>
									<col />				
								</colgroup>
								<tr>
									<th>Yard Code</th>
									<td><input id="yard_code" name="yard_code" class="input1" readonly style="width:150px;" value="" type="text" /> </td>
									<th>Loc. Code</th>
									<td><input id="location_code" name="location_code" class="input1" readonly style="width:60px;" value="" type="text" /> </td>
								</tr>
								<tr>
									<th>Yard Name</th>
									<td colspan="3"><input id="yard_name" name="yard_name" class="input1" readonly style="width:150px;" value="" type="text" /> </td>
								</tr>
								<tr>
									<th>Node Type</th>
									<td><input id="node_type" name="node_type" class="input1" readonly style="width:150px;" value="" type="text" /> </td>
									<th>Hub Node</th>
									<td><input id="hub_node" name="hub_node" class="input1" readonly style="width:60px;" value="" type="text" /> </td>
								</tr>
								<tr>
									<th>Service Type</th>
									<td colspan="3"> 
										<div class="opus_design_inquiry sm align_center pad_top_4" style="width:523px;">
										 	<input type="checkbox"  class="noinput1" disabled name="service_type_marinet" value="" class="trans"> Marine.T&nbsp;&nbsp;&nbsp;  
										 	<input type="checkbox"  class="noinput1" disabled name="service_type_barget" value="" class="trans"> Barge.T   &nbsp;&nbsp;&nbsp;
										 	<input type="checkbox"  class="noinput1" disabled name="service_type_cy" value="" class="trans"> CY  &nbsp;&nbsp;&nbsp;
										 	<input type="checkbox"  class="noinput1" disabled name="service_type_cfs" value="" class="trans"> CFS &nbsp;&nbsp;&nbsp;
										 	<input type="checkbox"  class="noinput1" disabled name="service_type_railramp" value="" class="trans"> Rail Ramp &nbsp;&nbsp;&nbsp;
										 	<input type="checkbox"  class="noinput1" disabled name="service_type_pseudoy" value="" class="trans"> Pseudo.Y&nbsp;&nbsp;&nbsp;
										 </div> 
									</td>	
									<td></td>
								</tr>
							</table>
		
							<table class="line_bluedot"><tr><td></td></tr></table>
		
							<h3 class="title_design">Contact Point</h3>
							<table>
								<colgroup>
									<col width="140"/>
									<col width="250"/>
									<col width="90"/>
									<col />					
								</colgroup>
								<tr>
									<th>Person</th>
									<td><input id="person" name="person" class="input1" readonly style="width:150px;" value="" type="text" /> </td>
									<th>E-mail</th>
									<td><input id="email" name="email" class="input1" readonly style="width:183px;" value="" type="text" /> </td>
								</tr>
								<tr>
									<th>Tel.</th>
									<td colspan="3"><input id="tel" name="tel" class="input1" readonly style="width:150px;" value="" type="text" /> </td>
								</tr>
								<tr>
									<th>Fax.</th>
									<td><input id="fax" name="fax" class="input1" readonly style="width:150px;" value="" type="text" /> </td>
									<th>Postal Code</th>
									<td><input id="postal_code" name="postal_code" class="input1" readonly style="width:183px;" value="" type="text" /> </td>
								</tr>
								<tr>
									<th>Yard Address</th>
									<td colspan="3"><input id="yard_address" name="yard_address" class="input1" readonly style="width:523px;" value="" type="text" /> </td>
								</tr>
							</table>
		
							<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
		
							<h3 class="title_design">Service Info.</h3>
							<table>
								<colgroup>
									<col width="140"/>
									<col width="250"/>
									<col width="90"/>
									<col />				
								</colgroup>
								<tr>
									<th rowspan="4">Gate Open Time</th>
									<td><!-- 
										 --><input name="yd_gate_open_week"  class="input1" readonly type="text" style="width:50px" value="Week"><!-- 
										 --><input name="gate_week_open"  class="input1" readonly type="text" style="width:40px" value="">~ <!-- 
										 --><input name="gate_week_close"  class="input1" readonly type="text" style="width:40px" value=""><!-- 
									 --></td>
									<th>Average Dwell Time(R)</th>
									<td><input id="average_dwell_r" name="average_dwell_r" class="input1" readonly style="width:40px;" value="" type="text" /> </td>
								</tr>
								<tr>
									<td><!-- 
										 --><input name="yd_gate_open_sat"  class="input1" readonly type="text" style="width:50px" value="Sat"><!-- 
										 --><input name="gate_sat_open"  class="input1" readonly type="text" style="width:40px" value="">~ <!-- 
										 --><input name="gate_sat_close"  class="input1" readonly type="text" style="width:40px" value=""><!-- 
									 --></td>
									<th>Average Dwell Time(D)</th>
									<td><input id="average_dwell_d" name="average_dwell_d" class="input1" readonly style="width:40px;" value="" type="text" /> </td>
								</tr>
								<tr>
									<td><!-- 
										 --><input name="yd_gate_open_sun"  class="input1" readonly type="text" style="width:50px" value="Sun"><!-- 
										 --><input name="gate_sun_open"  class="input1" readonly type="text" style="width:40px" value="">~ <!-- 
										 --><input name="gate_sun_close"  class="input1" readonly type="text" style="width:40px" value=""><!-- 
									 --></td>
									<th>Minimum Dwell Time(R)</th>
									<td><input id="minimum_dwell_r" name="minimum_dwell_r" class="input1" readonly style="width:40px;" value="" type="text" /> </td>
								</tr>
								<tr>
									<td><!-- 
										 --><input id="yd_gate_open_hol" name="yd_gate_open_hol" class="input1" readonly style="width:50px;" value="Holiday" type="text" /><!-- 
										 --><input name="gate_holiday_open"  class="input1" readonly type="text" style="width:40px" value="">~ <!-- 
										 --><input name="gate_holiday_close"  class="input1" readonly type="text" style="width:40px" value=""><!-- 
									 --></td>
									<th>Minimum Dwell Time(D)</th>
									<td><input id="minimum_dwell_d" name="minimum_dwell_d" class="input1" readonly style="width:40px;" value="" type="text" /> </td>
								</tr>
								<tr>
									<td colspan="2"></td>
									<th>Free Time</th>
									<td><input id="free_time" name="free_time" class="input1" readonly style="width:40px;" value="" type="text" /> </td>
								</tr>
							</table>	
					</div>				
				</div>
				<div class="layout_vertical_2" style="width:40%">
					<div class="opus_design_inquiry sm" style="height:494px;">
							<h3 class="title_design">Yard Operator</h3>
							<table>
								<colgroup>
									<col width="200"/>
									<col />				
								</colgroup>
								<tr>
									<th>CY Handling Vendor</th>
									<td><input id="yard_operator1" name="yard_operator1" class="input1" readonly style="width:200px;" value="" type="text" /> </td>
								</tr>
								<tr>
									<th>Name</th>
									<td><input id="operator1_name" name="operator1_name" class="input1" readonly style="width:200px;" value="" type="text" /> </td>
								</tr>
								<tr>
									<th>Stevedoring Vendor</th>
									<td><input id="yard_operator2" name="yard_operator2" class="input1" readonly style="width:200px;" value="" type="text" /> </td>
								</tr>
								<tr>
									<th>Name</th>
									<td><input id="operator2_name" name="operator2_name" class="input1" readonly style="width:200px;" value="" type="text" /> </td>
								</tr>
								<tr>
									<th>Security Vendor</th>
									<td><input id="yard_operator3" name="yard_operator3" class="input1" readonly style="width:200px;" value="" type="text" /> </td>
								</tr>
								<tr>
									<th>Name</th>
									<td><input id="operator3_name" name="operator3_name" class="input1" readonly style="width:200px;" value="" type="text" /> </td>
								</tr>
							</table>
		
							<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
		
							<h3 class="title_design">Additional Info.</h3>
							<table>
								<colgroup>
									<col width="200"/>
									<col />				
								</colgroup>
								<tr>
									<th>Office Code</th>
									<td><input id="office_code" name="office_code" class="input1" readonly style="width:200px;" value="" type="text" /> </td>
								</tr>
								<tr>
									<th>DEM I/B Collection</th>
									<td><input id="dem_ib_collection" name="dem_ib_collection" class="input1" readonly style="width:200px;" value="" type="text" /> </td>
								</tr>
								<tr>
									<th>DEM O/B Collection</th>
									<td><input id="dem_ob_collection" name="dem_ob_collection" class="input1" readonly style="width:200px;" value="" type="text" /> </td>
								</tr>
								<tr>
									<th>Yard Ownership</th>
									<td><input id="yard_ownership" name="yard_ownership" class="input1" readonly style="width:200px;" value="" type="text" /> </td>
								</tr>
								<tr>
									<th>Bonded Yard</th>
									<td><input id="bonded_yard" name="bonded_yard" class="input1" readonly style="width:200px;" value="" type="text" /> </td>
								</tr>
								<tr>
									<th>C-TPAT</th>
									<td><input id="c_tpat" name="c_tpat" class="input1" readonly style="width:200px;" value="" type="text" /> </td>
								</tr>
								<tr>
									<th>Yard On / Off-hire</th>
									<td><input id="yard_on_off" name="yard_on_off" class="input1" readonly style="width:200px;" value="" type="text" /> </td>
								</tr>
							</table>	
					</div>				
				</div>
			</div>
			<!-- layout_wrap(E) -->
		</div>
	</div>
	<!-- opus_design_grid(E) -->

	<!-- opus_design_grid(S) -->
	<div name="tabLayer" id="tabLayer">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry">
			<!-- layout_wrap(S) -->
			<div class="layout_wrap">
	
				<div class="layout_vertical_2  pad_rgt_12" style="width:40%">
					<div class="opus_design_inquiry sm" style="height:292px;">
							<h3 class="title_design">Location</h3>
			
							<table>
								<colgroup>
									<col width="170"/>		
									<col />				
								</colgroup> 
								<tr>
									<th>Location  Code</th>
									<td><input id="location_code" name="location_code" class="input1" readonly style="width:180px;" value="" type="text" /> </td>
								</tr>
								<tr>
									<th>Location  Name </th>
									<td><input id="location_name" name="location_name" class="input1" readonly style="width:180px;" value="" type="text" /> </td>
								</tr>
							</table>
		
							<table class="line_bluedot"><tr><td></td></tr></table>
		
							<table>
								<colgroup>
									<col width="170"/>		
									<col />				
								</colgroup> 
								<tr>
									<th>Zone  Code</th>
									<td><input id="zone_code" name="zone_code" class="input1" readonly style="width:180px;" value="" type="text" /> </td>
								</tr>
								<tr>
									<th>Zone  Name</th>
									<td><input id="zone_name" name="zone_name" class="input1" readonly style="width:180px;" value="" type="text" /> </td>
								</tr>
								<tr>
									<th>Control Office</th>
									<td><input id="control_office" name="control_office" class="input1" readonly style="width:180px;" value="" type="text" /> </td>
								</tr>
								<tr>
									<th>Cargo Handling Time</th>
									<td><input id="cargo_handling_time" name="cargo_handling_time" class="input1" readonly style="width:180px;" value="" type="text" /> </td>
								</tr>
							</table>
							
					</div>
				</div>
				<div class="layout_vertical_2" style="width:60%">
					<div class="opus_design_inquiry sm">
							<h3 class="title_design">Representative CY</h3>
							<table>
								<colgroup>
									<col width="220"/>		
									<col />				
								</colgroup> 
								<tr>
									<th>Representative CY Code</th>
									<td><input id="representative_code" name="representative_code" class="input1" readonly style="width:180px;" value="" type="text" /> </td>
								</tr>
								<tr>
									<th>Representative CY Name</th>
									<td><input id="representative_name" name="representative_name" class="input1" readonly style="width:180px;" value="" type="text" /> </td>
								</tr>
								<tr>
									<th>Distance(Zone to Rep. CY)</th>
									<td><input id="distance" name="distance" class="input1" readonly style="width:103px;" value="" type="text" /><input id="zn_dist_unit" name="zn_dist_unit" class="input1" readonly style="width:73px;" value="Mile" type="text" /> </td>
								</tr>
								<tr>
									<th>T/T(Zone to Rep. CY)</th>
									<td><input id="tt" name="tt" class="input1" readonly style="width:180px;" value="" type="text" /> </td>
								</tr>
							</table>
		
							<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
							
							<h3 class="title_design">Representative CY</h3>

							<div class="opus_design_grid">
							    <script  type="text/javascript">ComSheetObject('sheet2');</script>
							</div>
							
					</div>
				</div>
			</div>
			<!-- layout_wrap(E) -->
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>
<iframe name="HiddenFrame" id="HiddenFrame" frameborder="0" marginheight="0" marginwidth="0" width="0" height="0"></iframe>