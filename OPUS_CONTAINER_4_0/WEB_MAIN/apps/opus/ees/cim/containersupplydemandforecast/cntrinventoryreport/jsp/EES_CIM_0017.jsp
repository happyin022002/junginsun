<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   :  EES_CIM_0017.jsp
*@FileTitle  : Sea Inventory  
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/18
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.event.EesCim0017Event"%>
<%@ page import="com.clt.apps.opus.ees.mst.ruLabelmanagement.ruLabelmanagement.event.EesMst0050Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesCim0017Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//list count of DB ResultSet
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";


	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.ContainerSupplyDemandForecast.CNTRInventoryReport");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EesCim0017Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
	
	// change to table name
	String ruLableTp   = JSPUtil.getCodeCombo("ru_lable_type", "01", "style='width:120'", "CD20097", 0, "000020:ALL:ALL");
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
    function setupPage(){
	    loadPage();
    }
</script>
<form name="form"> 
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="head_cntr_tpsz_cd" value="" id="head_cntr_tpsz_cd" />
<input type="hidden" name="hid_rulabel_type" id="hid_rulabel_type" />



<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		 <button type="button" class="btn_normal" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
		  --><button type="button" class="btn_normal"  name="btn_new" id="btn_new">New</button><!-- 
		  --><button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button>
	</div>
	<!-- opus_design_btn(E) -->
	
	<!-- page_location(S) -->
   	<div class="location">
        <span id="navigation"></span>
   	</div>
</div>
<!-- page_title_area(E) -->

<div class="wrap_search_tab">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table> 
			<colgroup>
				<col width="40">
				<col width="80">
				<col width="318">
				<col width="100">
				<col width="100">
				<col width="63">
				<col width="50">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
						<th>Lane</th>
						<td>
							<input type="text" name="slan_cd" id="slan_cd"  style="ime-mode:inactive;width:43px;" dataformat="engup" size="3" maxlength="3" fulfill  class="input" value=""><!-- 
							 --><button type="button" class="input_seach_btn" name="btn_lane" id="btn_lane"></button>
						</td>
						<th>TP/SZ</th>
						<td>
							<script type="text/javascript">ComComboObject('cntr_tpsz_cd', 1, 115, 1);</script>
						</td>
						<th>IMM. Exit&nbsp;<input type="checkbox" name="imdt_ext_flg" id="imdt_ext_flg" value="Y" class="trans"></th>
						<th><div  style="display:none">Plastic Floor&nbsp;<input type="checkbox" name="plst_flr_flg"  id="plst_flr_flg" value="Y" class="trans"></div></th>
						<th>Prefix</th>
						<td><input type="text" name="cntr_no" id="cntr_no" style="width:40px;" dataformat="engup" size="4" maxlength="4" fulfill class="input" value=""></td>
					</tr>
			</tbody>
		</table>
		<table border="1"> 
				<colgroup>
					<col width="40">
					<col width="290">
					<col width="90">
					<col width="120">
					<col width="82">
					<col width="200">
					<col width="150">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th title="Vessel Voyage Direction">VVD</th>
						<td><button type="button" class="input_seach_btn" name="btn_vvd" id="btn_vvd"></button><!-- 
							 --><input type="text" name="vvd1" id="vvd1" style="ime-mode:inactive;width:88px;" dataformat="engup" size="9" maxlength="9" fulfill class="input" value="" ><!-- 
							 --><input type="text" name="vvd2" id="vvd2" style="ime-mode:inactive;width:88px;" dataformat="engup" size="9" maxlength="9" fulfill  class="input" value=""><!-- 
							 --><input type="text" name="vvd3" id="vvd3" style="ime-mode:inactive;width:88px;" dataformat="engup" size="9" maxlength="9" fulfill  class="input" value="">
						</td>
						<th>Lease Term</th>
						<td>
							<script type="text/javascript">ComComboObject('lstm_cd', 1, 115, 1);</script>
						</td>
						<th>&nbsp;RU Label</th>
						<td><input type="text"  name="rstr_usg_lbl" id="rstr_usg_lbl"    style="ime-mode:inactive;background-color:#ffffff"  style="width:150px;" class="input" value=""> <button type="button" id="btn_rulabel_cd" name="btn_rulabel_cd" class="input_seach_btn"></button></td>
						<td style="display:none">
						<%=ruLableTp%>
						<script language="javascript" >ComComboObject('rstr_usg_lbl1', 1, 140, 1 );</script>
						</td>
						<th><div id="show_add_info" style = "display:none">Add Info:&nbsp;&nbsp;<!-- 
							 --><input type="checkbox" name="view_commodity" id="view_commodity" value="Y" class="trans"><lable for="view_commodity">CMDT&nbsp;&nbsp;&nbsp;&nbsp;</lable><!-- 
							 --><div style="display:none"><lable for="speed" style="display:none">&nbsp;&nbsp;Speed</lable>&nbsp;&nbsp;<input type="checkbox" name="speed" id="speed" class="trans" checked value="Y"></div></th>
							 
						 
						<td><div id = "hide_add_info" style = "display:''" ></div></td>
					</tr>
				</tbody>
		</table>
		
		<table> 
			<colgroup>
				<col width="40">
				<col width="80">
				<col width="229">
				<col width="90">
				<col width="50">
				<col width="82">
				<col width="70">
				<col width="70">
				<col width="60">
				<col width="60">
				<col width="60">
				<col width="60">
				<col width="60">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<td ></td>
					<td ><input type="radio" name="route_tp_cd" id="route_tp_cd1" value="V" class="trans" checked>&nbsp;<lable  for="route_tp_cd1">On-board</lable>&nbsp;</td>
					<td ><input type="radio" name="route_tp_cd" id="route_tp_cd2" value="B" class="trans">&nbsp;<lable for="route_tp_cd2">Booking</lable>&nbsp;</td>
					<th >F/M</th>
					<td>
						<select name="full_flg" id="full_flg" style="width:115px;" class="input">
							<option value="" selected></option>
							<option value="Y">Full</option>
							<option value="N">MTY</option>
						</select>
					</td>
					<th>DMG</th>
					<td>
						<select name="dmg_flg" id="dmg_flg" style="width:75px;" class="input">
							<option value="" selected>Include</option>
							<option value="N">Exclude</option>
							<option value="Y">Only</option>
						</select>
					</td>
					<th >Reefer</th>
					<td ><input type="checkbox" name="rf_tp_cd_c" id="rf_tp_cd_c" value="C" class="trans">&nbsp;<lable for="rf_tp_cd_c">CA</lable></td>
					<td ><input type="checkbox" name="rf_tp_cd_h" id="rf_tp_cd_h" value="M" class="trans">&nbsp;<lable for="rf_tp_cd_h">MA</lable></td>
					<td ><input type="checkbox" name="rf_tp_cd_m" id="rf_tp_cd_m" value="W" class="trans">&nbsp;<lable for="rf_tp_cd_m">WE</lable></td>
					<td ><input type="checkbox" name="rf_cntr" id="rf_cntr" value="N" class="trans">&nbsp;<lable for="rf_cntr">Reefer</lable></td>
					<td ><input type="checkbox" name="rd_cgo_flg" id="rd_cgo_flg" value="Y" class="trans">&nbsp;<lable for="rd_cgo_flg">R/D</lable></td>
					<td> </td>
				</tr>
			</tbody>
		</table>
		<table>
			<colgroup>
					<col width="120">
					<col width="100">
					<col width="98">
					<col width="87">
					<col width="145">
					<col width="60">
					<col width="60">
					<col width="70">
					<col width="300">
					<col width="*">
			</colgroup>
			<tbody>
				<tr>
				
					<th >POL&nbsp;<input type="text" name="pol_cd" id="pol_cd" style="ime-mode:inactive; width:50px;" dataformat="engup" size="5" maxlength="5" fulfill; class="input" value=""><!-- 
						 --><button type="button" class="input_seach_btn" name="btns_pol_search" id="btns_pol_search"></button>
					</th>
					<th >POD&nbsp;<input type="text" name="pod_cd" id="pod_cd" style="ime-mode:inactive; width:50px;" dataformat="engup" size="5" maxlength="5" fulfill;  class="input" value=""><!-- 
						 --><button type="button" class="input_seach_btn" name="btns_pod_search" id="btns_pod_search"></button>
					</th>
					<th >DEL&nbsp;<input type="text" name="del_cd" id="del_cd" style="ime-mode:inactive; width:50px;" dataformat="engup" size="5" maxlength="5" fulfill;  class="input" value=""><!-- 
						 --><button type="button" class="input_seach_btn"  name="btns_del_search" id="btns_del_search"></button>
					</th>
					<th>Staying Day</th>
					<td><input type="text" name="stay_days" id="stay_days" style="ime-mode:inactive;width:50px; text-align:right;" dataformat="num" size="5" maxlength="5" class="input" value=""><b>or over</b></td>
					<th>S.O.C</th>
					<td>
						<select name="soc_cd" id="soc_cd" style="width:75px;" class="input">
							<option value="1"selected>Exclude</option>
							<option value="">Include</option>
							<option value="2">Only</option>
						</select>
					</td>
					<th >EQ MGMT</th>
					<td ><input type="checkbox" name="cntr_hngr_rck_cd"  id="cntr_hngr_rck_cd" value="Y" class="trans"><label for="cntr_hngr_rck_cd">Hanger Rack/Bar</label><!-- 
						 --><input type="checkbox" name="disp_flg" id="disp_flg" value="Y" class="trans"><label for="disp_flg">DPSL</label>&nbsp;<!-- 
						 --><input type="checkbox" name="d2_payld_flg" id="d2_payld_flg" value="Y" class="trans" style="display:none;"><label for="d2_payld_flg" style="display:none;">D2-HP</label>
					</td>
					<td> </td>
				</tr>
			</tbody>
		</table>
	</div>
</div>

<div class="wrap_result">
		<div class="opus_design_tab">
			<script type="text/javascript">ComTabObject('tab1')</script>
		</div>
		<div id="tabLayer" name="tabLayer">
			<div class="opus_design_grid"><script type="text/javascript">ComSheetObject('t1sheet1');</script></div>
		</div>
		<div id="tabLayer" name="tabLayer" style="display:none">
			<div class="opus_design_inquiry wFit">
				<table>
					<colgroup>
						<col width="1"/>
						<col width="*"/>
					</colgroup>
					<tbody>
						<tr>
							<th>View</th>
							<td><input type="Radio" name="pol_pod_wise" id="pol_pod_wise" value="POL" class="trans" checked>&nbsp;&nbsp;<lable for="pol_pod_wise">POL-wise</lable>&nbsp;&nbsp;&nbsp;<input type="Radio" name="pol_pod_wise" id="pol_pod_wise2" value="POD" class="trans"><lable for="pol_pod_wise2">POD-wise</lable></td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="opus_design_grid">
				<script type="text/javascript">ComSheetObject('t2sheet1');</script>
			</div>
		</div>
		<div id="tabLayer"  name="tabLayer" style="display:none">
			<div class="opus_design_grid">
			<div class="opus_design_btn"><!--  
			--><button type="button" class="btn_accent" name="btn_more" id="btn_more">More</button><!--
			--></div>
				<script type="text/javascript">ComSheetObject('t3sheet1');</script>
			</div>
		</div>
</div>
</form>