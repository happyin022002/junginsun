<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_1002.jsp
*@FileTitle  : Basic Tariff Creation - Group
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
<%@ page import="com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.event.EesDmt1002Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt1002Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB ResultSet list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	Logger log = Logger.getLogger("com.clt.apps.DMTMasterDataMgt.DemDetaariffMgt");
	String today = DateTime.getDateString();
	today = today.replace(".","-");
	
	String dmdt_trf_cd		= "";
	String dmdt_trf_nm		= "";
	String cvrg_conti_cd	= "";
	String cvrg_cnt_cd		= "";
	String cvrg_rgn_cd		= "";
	String cvrg_ste_cd		= "";
	String cvrg_loc_cd		= "";
	String cvrg_yd_cd		= "";
	String org_dest_conti_cd= "";
	String org_dest_cnt_cd	= "";
	String org_dest_rgn_cd	= "";
	String org_dest_ste_cd	= "";
	String org_dest_loc_cd	= "";
	String button_mode		= "";
	String wknd1			= "";
	String wknd2			= "";
	String before_exp_dt	= "";
	String svr_id			= "";
	String trf_seq			= "";
	String trf_grp_seq			= "";
	String dmdt_bzc_trf_grp_nm	= "";
	String ui_code			= "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();


		event = (EesDmt1002Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// in loading page, Get data from server.
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		dmdt_trf_cd 	= JSPUtil.getParameter(request,"dmdt_trf_cd");
		dmdt_trf_nm 	= JSPUtil.getParameter(request,"dmdt_trf_nm");
		cvrg_conti_cd 	= JSPUtil.getParameter(request,"cvrg_conti_cd");
		cvrg_cnt_cd 	= JSPUtil.getParameter(request,"cvrg_cnt_cd");
		cvrg_rgn_cd 	= JSPUtil.getParameter(request,"cvrg_rgn_cd");
		cvrg_ste_cd 	= JSPUtil.getParameter(request,"cvrg_ste_cd");
		cvrg_loc_cd 	= JSPUtil.getParameter(request,"cvrg_loc_cd");
		cvrg_yd_cd 		= JSPUtil.getParameter(request,"cvrg_yd_cd");
		org_dest_conti_cd = JSPUtil.getParameter(request,"org_dest_conti_cd");
		org_dest_cnt_cd = JSPUtil.getParameter(request,"org_dest_cnt_cd");
		org_dest_rgn_cd = JSPUtil.getParameter(request,"org_dest_rgn_cd");
		org_dest_ste_cd = JSPUtil.getParameter(request,"org_dest_ste_cd");
		org_dest_loc_cd = JSPUtil.getParameter(request,"org_dest_loc_cd");
		button_mode			= JSPUtil.getParameter(request,"button_mode");
		wknd1			= JSPUtil.getParameter(request,"wknd1");
		wknd2			= JSPUtil.getParameter(request,"wknd2");
		before_exp_dt	= JSPUtil.getParameter(request,"exp_dt");
		svr_id			= JSPUtil.getParameter(request,"svr_id");
		trf_seq			= JSPUtil.getParameter(request,"trf_seq");
		trf_grp_seq		= JSPUtil.getParameter(request,"trf_grp_seq");
		dmdt_bzc_trf_grp_nm	= JSPUtil.getParameter(request,"dmdt_bzc_trf_grp_nm");
		ui_code			= JSPUtil.getParameter(request,"ui_code");
		

	}catch(Exception e) {
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
<input type="hidden" name="curr_cd" id="curr_cd" />
<input type="hidden" name="cvrg_rgn_cd" value="<%=cvrg_rgn_cd %>" id="cvrg_rgn_cd" />
<input type="hidden" name="cvrg_ste_cd" value="<%=cvrg_ste_cd %>" id="cvrg_ste_cd" />
<input type="hidden" name="org_dest_rgn_cd" value="<%=org_dest_rgn_cd %>" id="org_dest_rgn_cd" />
<input type="hidden" name="org_dest_ste_cd" value="<%=org_dest_ste_cd %>" id="org_dest_ste_cd" />
<input type="hidden" name="button_mode" value="<%=button_mode %>" id="button_mode" />
<input type="hidden" name="today_dt" value="<%=today %>" id="today_dt" />
<input type="hidden" name="cnt_cd" id="cnt_cd" />
<input type="hidden" name="wknd1" value="<%=wknd1 %>" id="wknd1" />
<input type="hidden" name="wknd2" value="<%=wknd2 %>" id="wknd2" />
<input type="hidden" name="before_exp_dt" value="<%=before_exp_dt %>" id="before_exp_dt" />
<input type="hidden" name="svr_id" value="<%=svr_id %>" id="svr_id" />
<input type="hidden" name="trf_seq" value="<%=trf_seq %>" id="trf_seq" />
<input type="hidden" name="trf_grp_seq" value="<%=trf_grp_seq %>" id="trf_grp_seq" />
<input type="hidden" name="ui_code" value="<%=ui_code %>" id="ui_code" />
<input type="hidden" name="success_yn" id="success_yn" />

<div class="layer_popup_title"> 
<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title"><span>Basic Tariff Creation - Group</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			    <button type="button" class="btn_accent" name="btn_save" id="btn_save">Save</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_next" id="btn_next">Next</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
		<!-- opus_design_btn(E) --> 
	</div>
</div>
	
<div class="layer_popup_contents">
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table> 
				<colgroup>
					<col width="87">
					<col width="375">
					<col width="80">
					<col width="90">
					<col width="50">
					<col width="*">
				</colgroup>
				<tr>
					<th style="text-align:left;padding-left:9px;">Tariff Type</th>
					<td>
						<input type="text" name="dmdt_trf_cd" id="dmdt_trf_cd" style="width:45px;" class="input2" readonly value="<%=dmdt_trf_cd %>"><!-- 
						 --><input type="text" name="dmdt_trf_nm" id="dmdt_trf_nm" style="width:308px;" class="input2" value="<%=dmdt_trf_nm %>">
					</td>
					<th>User Office</th>
					<td><input type="text" name="ofc_cd" id="ofc_cd" style="width:65px;" class="input2" readonly  value="<%=strOfc_cd %>"></td>
					<th>User Name</th>
					<td><input type="text" name="usr_nm" id="usr_nm" style="width:150px;" class="input2" readonly  value="<%=strUsr_nm %>"></td>
				</tr> 
			</table>
			<table> 
		      	<colgroup>
					<col width="70">
					<col width="10">
					<col width="130">
					<col width="130">
					<col width="10">
					<col width="90">
					<col width="160">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th>Coverage</th>
						<td></td>
						<td>Continent&nbsp;<input type="text" name="cvrg_conti_cd" id="cvrg_conti_cd" style="width:40px;" class="input2"  readonly value="<%=cvrg_conti_cd %>"></td>
						<td>Country&nbsp;<input type="text" name="cvrg_cnt_cd" id="cvrg_cnt_cd" style="width:50px;" class="input2"  readonly value="<%=cvrg_cnt_cd %>"></td>
						<td><%if(cvrg_cnt_cd.equals("CA") || cvrg_cnt_cd.equals("US")){%>State<%}else{%>Region<%} %></td>
						<td><input type="text" name="cvrg_rgn_ste_cd" id="cvrg_rgn_ste_cd" style="width:60px;" class="input2" readonly ></td>
						<td>Location&nbsp;<input type="text" name="cvrg_loc_cd" id="cvrg_loc_cd" style="width:60px;" class="input2" readonly value="<%=cvrg_loc_cd %>"></td>
						<td>Yard&nbsp;<input type="text" name="cvrg_yd_cd" id="cvrg_yd_cd" style="width:65px;" class="input2" readonly value="<%=cvrg_yd_cd %>"></td>
					</tr>
					<tr>
						<th><%if(dmdt_trf_cd.equals("DMOF")||dmdt_trf_cd.equals("DTOC")||dmdt_trf_cd.equals("CTOC")){ %>Destination<%}else{ %>Origin<%} %></th>
						<td></td>
						<td>Continent&nbsp;<input type="text" name="org_dest_conti_cd" id="org_dest_conti_cd" style="width:40px;" class="input2"  readonly value="<%=org_dest_conti_cd %>"></td>
						<td>Country&nbsp;<input type="text" name="org_dest_cnt_cd" id="org_dest_cnt_cd" style="width:50px;" class="input2"  readonly value="<%=org_dest_cnt_cd %>"></td>
						<td><%if(org_dest_cnt_cd.equals("CA") || org_dest_cnt_cd.equals("US")){%>State<%}else{%>Region<%} %></td>
						<td><input type="text" name="org_dest_rgn_ste_cd"  id="org_dest_rgn_ste_cd" style="width:60px;" class="input2" readonly ></td>
						<td>Location&nbsp;<input type="text" name="org_dest_loc_cd" id="org_dest_loc_cd" style="width:60px;" class="input2"  readonly value="<%=org_dest_loc_cd %>"></td>
						<td></td>
					</tr>
				</tbody>
			</table>
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			<table> 
				<colgroup>
					<col width="137">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th>Group Name</th>
						<td>
							<%=JSPUtil.getCodeCombo("dmdt_trf_grp_tp_cd", "", "width='90px' class='input1' onChange='changeGroupType(this);'", "CD01979", 0, "")%><!-- 
							--><input type="text" name="dmdt_bzc_trf_grp_nm" id="dmdt_bzc_trf_grp_nm" style="width:236xp;" class="input1" caption="Group Name" maxlength="30" dataformat="engupetc" style="ime-mode:disabled" value="<%=dmdt_bzc_trf_grp_nm %>"> 
						</td>
					</tr>
				</tbody> 
			</table>
			<table> 
				<colgroup>
					<col width="137">
					<col width="120">
					<col width="120">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th>Effective DT</th>
						<td>
							<input type="text" name="eff_dt" id="eff_dt" style="width:86px;" class="input1" value="" maxlength="10" dataformat="ymd"  caption="Effective Date"><!-- 
							 --><button type="button" class="calendar" name="btns_clendar1" id="btns_clendar1"></button>
						</td>
						<th>Expiration DT</th>
						<td>
							<input type="text" name="exp_dt" id="exp_dt" style="width:86px;" class="input2" value=""  maxlength="10" dataformat="ymd"  caption="Expiration Date"><!-- 
							 --><button type="button" class="calendar" id="btns_clendar2" name="btns_clendar2"></button>
						</td>
					</tr>
				</tbody>
			</table>
			<table> 
				<colgroup>
					<col width="135">
					<col width="*">
				</colgroup>
				<tbody><tr><td>* Effective Date: Start Day of DEM/DET Incurrence&nbsp;&nbsp;  * Coverage: DEM - From Yard, DET/Combine - BKG POR or BKG DEL<br><br></td></tr></tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>

	<div class="wrap_result">
		<div class="layout_wrap" style="width:100%;margin-bottom:20px">
			<!-- layout_vertical_2(S) -->
			<div class="layout_vertical_2" style="width:48%;">
				<!-- opus_design_grid(S) -->
				<div class="opus_design_grid" id="mainTable">
					<script type="text/javascript">ComSheetObject('sheet1');</script>
				</div>
			</div>
			<div class="layout_vertical_2 align_center" style="width:4%;padding-top:80px;">
				<button class="btn_right"  type="button" name="btn_add" id="btn_add" ></button><br><br>
				<button type="button" class="btn_left" name="btn_del" id="btn_del"></button>
			</div>
			<div class="layout_vertical_2 align_right" style="width: 48%">
				<div class="opus_design_grid" id="mainTable">
					<script type="text/javascript">ComSheetObject('sheet2');</script>
				</div>
			</div>
		</div>
	
		<div class="layout_wrap" style="width:100%">
			<!-- layout_vertical_2(S) -->
			<div class="layout_vertical_2" style="width:50%;padding-right:20px;">
				<!-- opus_design_inquiry(S) -->
				<div class="opus_design_inquiry wFit">
					<table style="margin-bottom:18px"> 
						<colgroup>
							<col width="80">
							<col width="*">
						</colgroup>
						<tbody>
							<tr>
								<th>F/Time Exclusion</th>
								<td>
									<input type="checkbox" name="xcld_sat_flg" id="xcld_sat_flg" value="Y" class="trans"><span id="wknd1"> SAT</span>
									<input type="checkbox" name="xcld_sun_flg" id="xcld_sun_flg" value="Y"  class="trans"><span id="wknd2"> SUN</span>
									<input type="checkbox" name="xcld_hol_flg" id="xcld_hol_flg" value="Y" class="trans"> HOLIDAY</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="opus_design_grid" id="mainTable">
					<div class="opus_design_btn"> 
						<button class="btn_normal" type="button"  name="btn_rowadd" id="btn_rowadd">Row&nbsp;Add</button><!-- 
						 --><button class="btn_normal" type="button"  name="btn_rowdelete" id="btn_rowdelete">Row&nbsp;Delete</button>
					</div>
					<script type="text/javascript">ComSheetObject('sheet3');</script>
				</div>
			</div>
			<!-- layout_vertical_2(S) -->
			<div class="layout_vertical_2" >
				<!-- opus_design_inquiry(S) -->
				<div class="opus_design_inquiry wFit">
					<table> 
						<colgroup>
							<col width="80">
							<col width="100">
							<col width="120">
							<col width="*">
						</colgroup>
						<tr>
							<th>F/Time Commence</th>
							<td>
								<%=JSPUtil.getCodeCombo("dmdt_chg_cmnc_tp_cd","", "width='90px' class='input1' onChange='changeGroupCd1(this);'", "CD01964", 0, "")%>
								<input type="text" name="cmnc_hr" id="cmnc_hr" style="width:30px;" maxlength="2" class="input" onChange="changeCmncHr();" >&nbsp;HR</td>
							<th>Currency</th>
							<td><select name="currency" id="currency" style="width:80px;" class="input1"></select></td>
						</tr>
					</table>
				</div>
				<div class="opus_design_grid" id="mainTable">
					<div class="opus_design_btn"> 
						<button class="btn_normal" type="button"   name="btn_rowadd2" id="btn_rowadd2">Row&nbsp;Add</button><!-- 
						 --><button class="btn_normal" type="button"  name="btn_rowdelete2" id="btn_rowdelete2">Row&nbsp;Delete</button>
					</div>
					<script type="text/javascript">ComSheetObject('sheet4');</script>
				</div>
				<!-- opus_design_grid(E) -->
			</div>
		</div>
		
	</div>
</div>
</form>