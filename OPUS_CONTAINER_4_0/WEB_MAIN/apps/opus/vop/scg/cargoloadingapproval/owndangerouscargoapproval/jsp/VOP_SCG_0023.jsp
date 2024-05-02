<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : vop_scg_0023.jsp
*@FileTitle  : SPCL CGO Approved Details
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/26
=========================================================*/
%>


<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.event.VopScg0023Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopScg0023Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.clt.apps.CargoLoadingApproval.OwnDangerousCargoApproval");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopScg0023Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// add logic data extracting from server when loading initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>


<script type="text/javascript">
<%=ConstantMgr.getCompanyCodeToJS()%>
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();

	}
</script>
<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />

<input type="hidden" name="scg_flg" id="scg_flg" />
<input type="hidden" name="user_id" value="<%=strUsr_id%>" id="user_id" />

<!-- RD -->
<input type="hidden" name="com_mrdPath" 				id="com_mrdPath" 				value="">
<input type="hidden" name="com_mrdArguments" 			id="com_mrdArguments" 			value="">
<input type="hidden" name="com_mrdBodyTitle" 			id="com_mrdBodyTitle" 			value=""> 
<input type="hidden" name="com_mrdSaveDialogFileName" 	id="com_mrdSaveDialogFileName" 	value="">
<!-- RD -->

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
	
		<button class="btn_accent" name="btn_stowage_instruction" id="btn_stowage_instruction" type="button">Stowage Instruction</button><!-- 
		 --><button class="btn_accent" name="btn_retrive" id="btn_retrive" type="button">Retrieve</button><!--
		 --><button class="btn_normal" name="btn_new" id="btn_new" type="button">New</button><!--
		<button class="btn_normal" name="btn_Save" id="btn_Save" type="button">Save</button><!--
		--></div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->


	<div class="wrap_search_tab">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry">
			<table>
				<colgroup>
					<col width="80px" />				
					<col width="136px" />
					<col width="70px" />				
					<col width="220px" />				
					<col width="129px" />	
					<col width="86px" />				
					<col width="107px" />				
					<col width="*" />				
			   </colgroup> 
			   <tbody>
					<tr>
						<th>RSO</th>
						<td>
							<script type="text/javascript">ComComboObject('rgn_shp_opr_cd', 2, 77, 0, 1);</script>
						</td>
						<th class="wrap_search_tab">APVL Type</th>
						<td class="wrap_search_tab"><!-- 
						 --><input type="radio" name="auth_flg" id="auth_flg1" value="Y" class="trans" ><label for="auth_flg1">Approved</label><!-- 
						  --><input type="radio" name="auth_flg" id="auth_flg2" value="U" class="trans"><label for="auth_flg2">Unapproved</label><!-- 
						   --><input type="radio" name="auth_flg" id="auth_flg3" value="N" class="trans"><label for="auth_flg3">Rejected</label><!-- 
						   --><input type="radio" name="auth_flg" id="auth_flg4" value="YN" class="trans" checked><label for="auth_flg4">All</label>
						</td>
						<th>Lane</th>
						<td><input type="text" name="slan_cd1" id="slan_cd1" style="width:53px;" class="input1" value="" fullfill="" caption="Lane" maxlength="3" dataformat="engup" id="slan_cd1" /><!-- 
						 --><button type="button" id="btn_SlanCd" name="btn_SlanCd" class="input_seach_btn"></button></td>
						<th>VVD CD</th>
						<td><input type="text" name="vsl_cd" style="width:51px;" class="input1" value="" fullfill="" caption="VVD CD" maxlength="4" dataformat="engup" id="vsl_cd" /><!-- 
						 --><input type="text" name="skd_voy_no" style="width:37px;" class="input1" value="" fullfill="" caption="VVD CD" maxlength="4" dataformat="engup" id="skd_voy_no" /><!-- 
						 --><input type="text" name="skd_dir_cd" style="width:18px;" class="input1" value="" fullfill="" caption="VVD CD" maxlength="1" dataformat="engup" id="skd_dir_cd" /><!-- 
						 --><button type="button" id="btn_VVDpop" name="btn_VVDpop" class="input_seach_btn"></button><!-- 
						 --><input type="text" name="vsl_eng_nm" style="width:119px;" class="input2" value="" readonly id="vsl_eng_nm" /> </td>
					</tr>
			   </tbody>
			</table>
			<table>
				<colgroup>
					<col width="80px" />				
					<col width="95px" />				
					<col width="70px" />				
					<col width="100px" />				
					<col width="140px" />
					<col width="85px" />				
					<col width="100px" />	
					<col width="130px" />				
					<col width="102px" />	
					<col width="130px" />				
					<col width="102px" />				
					<col width="*" />				
			   </colgroup> 
			   <tbody>
					<tr>
						<th title="Port of Loading">POL</th>
						<td><input type="text" name="pol_cd" style="width:55px;" class="input" value="" caption="POL" maxlength="5" dataformat="engup" id="pol_cd" /><!-- 
						 --><button type="button" id="btn_Pol" name="btn_Pol" class="input_seach_btn"></button></td>
						<th title="Port of Discharging">POD</th>
						<td><input type="text" name="pod_cd" style="width:55px;" class="input" value="" caption="POD" maxlength="5" dataformat="engup" id="pod_cd" /><!-- 
						 --><button type="button" id="btn_Pod" name="btn_Pod" class="input_seach_btn"></button></td>
						<th>BKG Company</th>
						<td><input type="text" name="cgo_opr_cd" style="width:40px;" class="input" value="" caption="BKG Company" maxlength="4" dataformat="engup" id="cgo_opr_cd" /><!-- 
						 --><button type="button" id="btn_Carrier" name="btn_Carrier" class="input_seach_btn"></button></td>
						<th>BKG Ref No.</th>
						<td><input type="text" name="booking_no" style="width:120px;" class="input1" value="" caption="BKG Ref No." maxlength="30" id="booking_no" /> </td>
						<th>DG Ref No.</th>
						<td><input type="text" name="dcgo_ref_no" style="width:120px;" class="input" value="" caption="DG Ref No." maxlength="30" dataformat="eng" id="dcgo_ref_no" /> </td>
						<th>Approval No.</th>
						<td><input type="text" name="apro_ref_no" style="width:120px;" class="input" value="" caption="Approval No." maxlength="30" dataformat="engup" id="apro_ref_no" /> </td>
					</tr>
			   </tbody>
			</table>
			
			<table>
				<colgroup>
					<col width="80" />				
					<col width="121" />				
					<col width="44" />				
					<col width="165" />		
					<col width="160" />				
					<col width="210" />				
					<col width="105" />				
					<col width="*" />				
			   </colgroup> 
			   <tbody>
					<tr>
						<th>UN No./Seq.</th>
						<td><input type="text" name="imdg_un_no" fullfill="" style="width:40px;" class="input" value="" caption="UN No." maxlength="4" dataformat="engup" id="imdg_un_no" /><!-- 
						 --><input type="text" name="imdg_un_no_seq" style="width:40px;" class="input" value="" caption="Seq." maxlength="4" dataformat="engup" id="imdg_un_no_seq" /><!-- 
						 --><button type="button" id="btn_UNNo" name="btn_UNNo" class="input_seach_btn"></button></td>
						<th>Class</th>
						<td><script type="text/javascript">ComComboObject('imdg_clss_cd', 1, 56, 0, 0);</script></td>
						<th>PSN</th>
						<td><input type="text" name="prp_shp_nm" style="width:220px;" class="input" value="" id="prp_shp_nm" /> </td><%-- dataformat="engup" --%>
						<th>POL ETA</th>
						<td><input type="text" name="from_eta_dt" style="width:81px;" class="input1" value="" dataformat="ymd" maxlength="8" caption="POL ETA" id="from_eta_dt" />~&nbsp;<!-- 
						 --><input type="text" name="to_eta_dt" style="width:85px;" class="input1" value="" dataformat="ymd" maxlength="8" caption="POL ETA" id="to_eta_dt" /><!-- 
						 --><button type="button" id="btn_Calendar" name="btn_Calendar" class="calendar ir" ></button></td>
					</tr>
			   </tbody>
			</table>
			<table class="height_8"><tr><td></td></tr></table>
			
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
	
	<div class="wrap_result">

		<!-- opus_design_tab(S) -->
		<div class="opus_design_tab">
			<script type="text/javascript">ComTabObject('tab1')</script>
		</div>
		
		<!-- Tab DG (S) -->
		<div id="tabLayer" style="display:inline;"> 
			<!-- opus_design_grid(S) -->
			<div class="opus_design_grid" style="position:relative;">
				<div class="clear">
				  <h2 class="title_design pad_left_none floatL">
				    <input type="checkbox" name="t1Mpa1" id="t1Mpa1">
				    <label for="t1Mpa1">MPA 1</label>
				  </h2>
					
				  <div class="opus_design_btn">
				  	   <button class="btn_normal" name="btn_t1appl0" id="btn_t1appl0" type="button" disabled="">Application Details</button><!--
				    --><button class="btn_normal" name="btn_t1downExcel0" id="btn_t1downExcel0" type="button" disabled="">Down Excel</button>
				  </div>
				</div>
				<!-- opus_design_btn (E) -->				
				<script type="text/javascript">ComSheetObject('t1sheet1');</script>				
			</div>
			<!-- opus_design_grid(E) -->	
		</div>
		<!-- Tab DG (E) -->
		
		<!-- Tab Awkard (S) -->
		<div id="tabLayer" style="display:none">
			<!-- opus_design_grid(S) -->
			<div class="opus_design_grid">
				
				<!-- opus_design_btn (S) -->
				<div class="opus_design_btn"><!-- 
					 --><button class="btn_normal" name="btn_t1appl1" id="btn_t1appl1" type="button">Application Details</button><!--
					 --><button class="btn_normal" name="btn_t1mail1" id="btn_t1mail1" type="button">Mail</button><!-- 
					 --><button class="btn_normal" name="btn_t1downExcel1" id="btn_t1downExcel1" type="button">Down Excel</button><!--
					--></div>
				<!-- opus_design_btn (E) -->
				
				<script type="text/javascript">ComSheetObject('t2sheet1');</script>				
			</div>
			<!-- opus_design_grid(E) -->
		
		</div>
		<!-- Tab Awkard (E) -->
		
		<!-- Tab Break-Bulk (S) -->
		<div id="tabLayer" style="display:none">
			<!-- opus_design_grid(S) -->
			<div class="opus_design_grid">
				
				<!-- opus_design_btn (S) -->
				<div class="opus_design_btn"><!-- 
					 --><button class="btn_normal" name="btn_t1appl2" id="btn_t1appl2" type="button">Application Details</button><!--
					 --><button class="btn_normal" name="btn_t1downExcel2" id="btn_t1downExcel2" type="button">Down Excel</button><!--
					--></div>
				<!-- opus_design_btn (E) -->
				
				<script type="text/javascript">ComSheetObject('t3sheet1');</script>				
			</div>
			<!-- opus_design_grid(E) -->	
		</div>
		<!-- Tab Break-Bulk (E) -->
		
		<!-- Tab 45' (S) -->
		<div id="tabLayer" style="display:none">
			<!-- opus_design_grid(S) -->
			<div class="opus_design_grid">
				
				<!-- opus_design_btn (S) -->
				<div class="opus_design_btn"><!-- 
					 --><button class="btn_normal" name="btn_t1appl3" id="btn_t1appl3" type="button">Application Details</button><!--
					 --><button class="btn_normal" name="btn_t1mail3" id="btn_t1mail3" type="button">Mail</button><!--
					 --><button class="btn_normal" name="btn_t1downExcel3" id="btn_t1downExcel3" type="button">Down Excel</button><!--
					--></div>
				<!-- opus_design_btn (E) -->
				
				<script type="text/javascript">ComSheetObject('t4sheet1');</script>				
			</div>
			<!-- opus_design_grid(E) -->
		
		</div>
		<!-- Tab 45' (E) -->
		
		<!-- Tab Reefer (S) -->
		<div id="tabLayer" style="display:none">
			<!-- opus_design_grid(S) -->
			<div class="opus_design_grid">
				
				<!-- opus_design_btn (S) -->
				<div class="opus_design_btn"><!-- 
					 --><button class="btn_normal" name="btn_t1appl4" id="btn_t1appl4" type="button">Application Details</button><!--
					 --><button class="btn_normal" name="btn_t1downExcel4" id="btn_t1downExcel4" type="button">Down Excel</button><!--
					--></div>
				<!-- opus_design_btn (E) -->
				
				<script type="text/javascript">ComSheetObject('t5sheet1');</script>				
			</div>
			<!-- opus_design_grid(E) -->
			
		</div>
		<!-- Tab Reefer (E) -->
		
		<!-- Tab Special Stow (S) -->
		<div id="tabLayer" style="display:none">
			<!-- opus_design_grid(S) -->
			<div class="opus_design_grid">
				
				<!-- opus_design_btn (S) -->
				<div class="opus_design_btn"><!-- 
					 --><%-- <button class="btn_normal" name="btn_t1appl5" id="btn_t1appl5" type="button">Application Details</button>--%><!--
					 --><button class="btn_normal" name="btn_t1downExcel5" id="btn_t1downExcel5" type="button">Down Excel</button><!--
					--></div>
				<!-- opus_design_btn (E) -->
				
				<script type="text/javascript">ComSheetObject('t7sheet1');</script>				
			</div>
			<!-- opus_design_grid(E) -->
			
		</div>
		<!-- Tab Special Stow (E) -->
	</div>
</form>