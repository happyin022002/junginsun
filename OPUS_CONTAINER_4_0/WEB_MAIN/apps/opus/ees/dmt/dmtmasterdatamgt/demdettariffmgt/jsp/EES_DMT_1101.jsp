<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_1101.jsp
*@FileTitle  : Copy Basic Tariff
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
<%@ page import="com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.event.EesDmt1101Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%
	EesDmt1101Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //error from server
	String strErrMsg = ""; //error message
	int rowCount = 0; //count of DB ResultSet list

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String strOfc_cd = "";
	Logger log = Logger.getLogger("com.clt.apps.DMTMasterDataMgt.DemDetTariffMgt");

	String dmdt_trf_cd = "";
	String dmdt_trf_nm = "";
	String cvrg_conti_cd = "";
	String cvrg_cnt_cd = "";
	String cvrg_rgn_cd = "";
	String cvrg_ste_cd = "";
	String cvrg_loc_cd = "";
	String cvrg_yd_cd = "";
	String org_dest_conti_cd = "";
	String org_dest_cnt_cd = "";
	String org_dest_rgn_cd = "";
	String org_dest_ste_cd = "";
	String org_dest_loc_cd = "";
	String svr_id = "";
	String trf_seq = "";
	String trf_grp_seq = "";
	String dmdt_bzc_trf_grp_nm = "";
	String ui_code = "";

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (EesDmt1101Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// in loading page, Get data from server.
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		dmdt_trf_cd 	= JSPUtil.getParameter(request, "dmdt_trf_cd");
		dmdt_trf_nm 	= JSPUtil.getParameter(request, "dmdt_trf_nm");
		cvrg_conti_cd 	= JSPUtil.getParameter(request, "cvrg_conti_cd");
		cvrg_cnt_cd 	= JSPUtil.getParameter(request, "cvrg_cnt_cd");
		cvrg_rgn_cd 	= JSPUtil.getParameter(request, "cvrg_rgn_cd");
		cvrg_ste_cd 	= JSPUtil.getParameter(request, "cvrg_ste_cd");
		cvrg_loc_cd 	= JSPUtil.getParameter(request, "cvrg_loc_cd");
		cvrg_yd_cd 		= JSPUtil.getParameter(request, "cvrg_yd_cd");
		org_dest_conti_cd = JSPUtil.getParameter(request,"org_dest_conti_cd");
		org_dest_cnt_cd = JSPUtil.getParameter(request,"org_dest_cnt_cd");
		org_dest_rgn_cd = JSPUtil.getParameter(request,"org_dest_rgn_cd");
		org_dest_ste_cd = JSPUtil.getParameter(request,"org_dest_ste_cd");
		org_dest_loc_cd = JSPUtil.getParameter(request,"org_dest_loc_cd");
		svr_id 			= JSPUtil.getParameter(request, "svr_id");
		trf_seq 		= JSPUtil.getParameter(request, "trf_seq");
		trf_grp_seq 	= JSPUtil.getParameter(request, "trf_grp_seq");
		dmdt_bzc_trf_grp_nm = JSPUtil.getParameter(request,"dmdt_bzc_trf_grp_nm");
		ui_code			= JSPUtil.getParameter(request,"ui_code");
		
		
	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="conti_cd" id="conti_cd" />
<input type="hidden" name="cnt_cd" id="cnt_cd" />
<input type="hidden" name="rgn_cd" id="rgn_cd" />
<input type="hidden" name="ste_cd" id="ste_cd" />
<input type="hidden" name="loc_cd" id="loc_cd" />
<input type="hidden" name="yd_cd" id="yd_cd" />
<input type="hidden" name="cvrg_rgn_cd" value="<%=cvrg_rgn_cd%>" id="cvrg_rgn_cd" />
<input type="hidden" name="cvrg_ste_cd" value="<%=cvrg_ste_cd%>" id="cvrg_ste_cd" />
<input type="hidden" name="org_dest_rgn_cd" value="<%=org_dest_rgn_cd%>" id="org_dest_rgn_cd" />
<input type="hidden" name="org_dest_ste_cd" value="<%=org_dest_ste_cd%>" id="org_dest_ste_cd" />
<input type="hidden" name="to_cvrg_conti_cd" id="to_cvrg_conti_cd" />
<input type="hidden" name="to_cvrg_cnt_cd" id="to_cvrg_cnt_cd" />
<input type="hidden" name="to_cvrg_rgn_cd" id="to_cvrg_rgn_cd" />
<input type="hidden" name="to_cvrg_ste_cd" id="to_cvrg_ste_cd" />
<input type="hidden" name="to_cvrg_rgn_ste_cd" id="to_cvrg_rgn_ste_cd" />
<input type="hidden" name="to_org_dest_conti_cd" id="to_org_dest_conti_cd" />
<input type="hidden" name="to_org_dest_cnt_cd" id="to_org_dest_cnt_cd" />
<input type="hidden" name="to_org_dest_rgn_cd" id="to_org_dest_rgn_cd" />
<input type="hidden" name="to_org_dest_ste_cd" id="to_org_dest_ste_cd" />
<input type="hidden" name="to_org_dest_loc_cd" id="to_org_dest_loc_cd" />
<input type="hidden" name="ui_code" value="<%=ui_code %>" id="ui_code" />

<div class="page_title_area clear">
			<!-- page_title(S) -->
			<h2 class="page_title" ><span>Copy Basic Tariff</span></h2>
			<!-- page_title(E) -->
			
			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn">
			       <button type="button" class="btn_accent" name="btn_new" id="btn_new">New</button><!--  
			       --><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!--  
			       --><button type="button" class="btn_normal"  name="btn_close" id="btn_close">Close</button>
			</div>
			<!-- opus_design_btn(E) -->
	</div>
    <!-- page_title_area(E) -->

<div class="wrap_search">
	<div class="opus_design_inquiry wFit">		
	      <table>
	      	<colgroup>
				<col width="70">
				<col width="420">
				<col width="80">
				<col width="90">
				<col width="50">
				<col width="*">
			</colgroup>
			<tbody>
		        <tr>
						<th>Tariff Type</th>
						<td>
							<input type="text" name="dmdt_trf_cd" id="dmdt_trf_cd" style="width: 96px;" class="input2" readonly value="<%=dmdt_trf_cd%>"><!-- 
							 --><input type="text" name="dmdt_trf_nm" id="dmdt_trf_nm" style="width: 308px;" class="input2" readonly value="<%=dmdt_trf_nm%>">
						</td>
						<th>User Office</th>
						<td><input type="text" name="ofc_cd" id="ofc_cd" style="width: 65px;" class="input2" readonly value="<%=strOfc_cd%>"></td>
						<th>User Name</th>
						<td><input type="text" name="usr_nm" id="usr_nm" style="width: 150px;" class="input2" readonly value="<%=strUsr_nm%>"></td>
					</tr>
		     </tbody>
	      </table>
	      <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
	      <h3 class="title_design" >From</h3>
	       <table>
	      	<colgroup>
				<col width="70">
				<col width="10">
				<col width="130">
				<col width="130">
				<col width="10">
				<col width="90">
				<col width="140">
				<col width="*">
			</colgroup>
			<tbody>
		        <tr>
						<th>Coverage</th>
						<td></td>
						<td>Continent <input type="text" name="cvrg_conti_cd" id="cvrg_conti_cd" style="width: 40px;" class="input2" readonly value="<%=cvrg_conti_cd%>"></td>
						<td>Country <input type="text" name="cvrg_cnt_cd" id="cvrg_cnt_cd" style="width: 50px;" class="input2" readonly value="<%=cvrg_cnt_cd%>"></td>
						<td><%if (cvrg_cnt_cd.equals("CA") || cvrg_cnt_cd.equals("US")) {%>State<%} else {%>Region<%}%></td>
						<td><input type="text" name="cvrg_rgn_ste_cd" id="cvrg_rgn_ste_cd" style="width: 60px;" class="input2" readonly value=""></td>
						<td>Location <input type="text" name="cvrg_loc_cd" id="cvrg_loc_cd" style="width: 60px;" class="input2" readonly value="<%=cvrg_loc_cd%>"></td>
						<td>Yard <input type="text" name="cvrg_yd_cd" id="cvrg_yd_cd" style="width: 65px;" class="input2" readonly value="<%=cvrg_yd_cd%>"></td>
					</tr>
					<tr>
						<th><%if (dmdt_trf_cd.equals("DMOF") || dmdt_trf_cd.equals("DTOC")|| dmdt_trf_cd.equals("CTOC")) {%>Destination<%} else {%>Origin<%}%></th>
						<td></td>
						<td>Continent <input type="text" name="org_dest_conti_cd" id="org_dest_conti_cd" style="width: 40px;" class="input2" readonly value="<%=org_dest_conti_cd%>"></td>
						<td>Country <input type="text"	name="org_dest_cnt_cd" id="org_dest_cnt_cd" style="width: 50px;" class="input2" readonly value="<%=org_dest_cnt_cd%>"></td>
						<td><%if (org_dest_cnt_cd.equals("CA") || org_dest_cnt_cd.equals("US")) {%>State<%} else {%>Region<%}%></td>
						<td><input type="text" name="org_dest_rgn_ste_cd" id="org_dest_rgn_ste_cd" style="width: 60px;" class="input2" readonly></td>
						<td>Location <input type="text" name="org_dest_loc_cd" id="org_dest_loc_cd" style="width: 60px;" class="input2" readonly value="<%=org_dest_loc_cd%>"></td>
						<td></td>
					</tr>
		     </tbody>
	      </table>
	      <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
	      <h3 class="title_design" >To</h3>
	      <table>
	      	<colgroup>
				<col width="70">
				<col width="10">
				<col width="130">
				<col width="130">
				<col width="10">
				<col width="90">
				<col width="140">
				<col width="*">
			</colgroup>
			<tbody>
		        <tr>
						<th>Coverage</th>
						<td></td>
						<td>Continent <script type="text/javascript">ComComboObject('combo1', 2, 40 , 0, 1, 0, true)</script></td>
						<td>Country <script type="text/javascript">ComComboObject('combo2', 2, 50 , 0, 0, 0, true)</script></td>
						<td><span id="CvrgRegion">Region</span></td>
						<td><script type="text/javascript">ComComboObject('combo3', 2, 60 , 0, 0, 0, true)</script></td>
						<td>Location <input type="text" name="to_cvrg_loc_cd" id="to_cvrg_loc_cd" caption="CvrgLocation" maxlength="5" fullfill class="input" value="" dataformat="engup" style="width: 60px; ime-mode: disabled" onKeyPress="ComKeyOnlyAlphabet('upper')"	OnKeyUp="checkCvrgLocation(this)"></td>
						<td>Yard <input type="text" name="to_cvrg_yd_cd" id="to_cvrg_yd_cd" caption="CvrgYard" maxlength="7" fullfill class="input" value="" dataformat="engup" style="width: 60px; ime-mode: disabled" OnKeyUp="checkCvrgYard(this)"></td>
					</tr>
					<tr>
						<th><%if (dmdt_trf_cd.equals("DMOF") || dmdt_trf_cd.equals("DTOC") || dmdt_trf_cd.equals("CTOC")) {%>Destination<%} else {%>Origin<%}%></th>
						<td></td>
						<td>Continent <script type="text/javascript">ComComboObject('combo4', 2, 40 , 0, 1, 0, true)</script></td>
						<td>Country <script type="text/javascript">ComComboObject('combo5', 2, 50 , 0, 0, 0, true)</script></td>
						<td><span id="Region">Region</span></td>
						<td><script type="text/javascript">ComComboObject('combo6', 2, 60 , 0, 0, 0, true)</script></td>
						<td>Location <input type="text" name="to_org_dest_location" id="to_org_dest_location" caption="Location" maxlength="5" fullfill class="input" value="" dataformat="engup" style="width: 60px; ime-mode: disabled" onKeyPress="ComKeyOnlyAlphabet('upper')"	OnKeyUp="checkLocation(this)"></td>
					</tr>
		     </tbody>
	      </table>
	</div>
</div>
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid"  id="mainTable2" style=display:none;>
		<script type="text/javascript">ComSheetObject('sheet1');</script> 
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>