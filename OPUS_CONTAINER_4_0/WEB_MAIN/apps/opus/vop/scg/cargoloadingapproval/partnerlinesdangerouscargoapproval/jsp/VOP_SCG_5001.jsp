<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : vop_scg_5001.jsp
*@FileTitle  : SPCL CGO APVL Approval/Inquiry for Partner Lines
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/04
=========================================================*/
%>
 
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.event.VopScg5001Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopScg5001Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.CargoLoadingApproval.PartnerLinesDangerousCargoApproval");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopScg5001Event)request.getAttribute("Event");
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
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="user_id" value="<%=strUsr_id%>" id="user_id" />

<input type="hidden" name="tabSelectedIdx" value="0" id="tabSelectedIdx" />

<!-- Mail Parameter -->

<!-- Mail Parameter -->

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
		<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_retrieve" 		id="btn_retrieve">Retrieve</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_new" 			id="btn_new">New</button><!--	
				--><button type="button" class="btn_normal" name="btn_save" 			id="btn_save">Save</button>			
		</div>
	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<!-- opus_design_inquiry(S) -->
<div class= "wrap_search_tab">

	<div class="opus_design_inquiry wFit">
		<table>
			<tr>
			<td style="width:100px;">
				<table>
					<colgroup>
						<col width="50" />				
				   </colgroup> 
				   <tbody>
				   		<tr>
							<th style="float:left;"><input type="radio" name="srch_type" value="N" class="trans" id="srch_type1" checked /><label for="srch_type1">Normal</label></th>
						</tr>
						<tr>
							<th style="float:left;"><input type="radio" name="srch_type" value="R" class="trans" id="srch_type2" /><label for="srch_type2">Recovery</label></th>
						</tr>
						<tr>
							<th style="float:left;"><input type="radio" name="srch_type" value="U" class="trans"  id="srch_type3" /><label for="srch_type3">Update</label></th>
						</tr>
				   </tbody>
				</table>			
			</td>
			<td style="vertical-align:top;float:left">
				<table>
					<colgroup>
						<col width="50" />				
						<col width="96" />							
						<col width="70" />				
						<col width="*" />				
				   </colgroup> 
				   <tbody>
				   		<tr>
							<th>RSO</th>
							<td style="padding-left:4"><script type="text/javascript">ComComboObject('rgn_shp_opr_cd', 3, 74, 1, 1);</script></td>
							<th class="srch_type_1">Lane</th>
							<td class="srch_type_1"><!-- 
								 --><input type="text" name="slan_cd1" caption="Lane Code 1" maxlength="3" dataformat="engup" style="width:50px;ime-mode:disabled;" class="input" value="" id="slan_cd1" /><button type="button" name="btn_SlanCd1" id="btn_SlanCd1" class="input_seach_btn" ></button><!-- 
								 --><input type="text" name="slan_cd2" caption="Lane Code 2" maxlength="3" dataformat="engup" style="width:40px;ime-mode:disabled;" class="input" value="" id="slan_cd2" /><button type="button" name="btn_SlanCd2" id="btn_SlanCd2" class="input_seach_btn" ></button><!-- 
								 --><input type="text" name="slan_cd3" caption="Lane Code 3" maxlength="3" dataformat="engup" style="width:45px;ime-mode:disabled;" class="input" value="" id="slan_cd3" /><button type="button" name="btn_SlanCd3" id="btn_SlanCd3" class="input_seach_btn" ></button><!-- 
								 --><input type="text" name="slan_cd4" caption="Lane Code 4" maxlength="3" dataformat="engup" style="width:45px;ime-mode:disabled;" class="input" value="" id="slan_cd4" /><button type="button" name="btn_SlanCd4" id="btn_SlanCd4" class="input_seach_btn" ></button><!-- 
								 --><input type="text" name="slan_cd5" caption="Lane Code 5" maxlength="3" dataformat="engup" style="width:45px;ime-mode:disabled;" class="input" value="" id="slan_cd5" /><button type="button" name="btn_SlanCd5" id="btn_SlanCd5" class="input_seach_btn" ></button><!-- 
								 --><input type="text" name="slan_cd6" caption="Lane Code 6" maxlength="3" dataformat="engup" style="width:45px;ime-mode:disabled;" class="input" value="" id="slan_cd6" /><button type="button" name="btn_SlanCd6" id=btn_SlanCd6 class="input_seach_btn" ></button><!-- 
								 --><input type="text" name="slan_cd7" caption="Lane Code 7" maxlength="3" dataformat="engup" style="width:45px;ime-mode:disabled;" class="input" value="" id="slan_cd7" /><button type="button" name="btn_SlanCd7" id="btn_SlanCd7" class="input_seach_btn" ></button><!-- 
								 --><input type="text" name="slan_cd8" caption="Lane Code 8" maxlength="3" dataformat="engup" style="width:50px;ime-mode:disabled;" class="input" value="" id="slan_cd8" /><button type="button" name="btn_SlanCd8" id="btn_SlanCd8" class="input_seach_btn" ></button><!-- 
								 --><input type="text" name="slan_cd9" caption="Lane Code 9" maxlength="3" dataformat="engup" style="width:45px;ime-mode:disabled;" class="input" value="" id="slan_cd9" /><button type="button" name="btn_SlanCd9" id="btn_SlanCd9" class="input_seach_btn" ></button><!-- 
								 --><input type="text" name="slan_cd10" caption="Lane Code 10" maxlength="3" dataformat="engup" style="width:45px;ime-mode:disabled;" class="input" value="" id="slan_cd10" /><button type="button" name="btn_SlanCd10" id="btn_SlanCd10" class="input_seach_btn" ></button><!-- 
								 --><input type="text" name="slan_cd11" caption="Lane Code 11" maxlength="3" dataformat="engup" style="width:40px;ime-mode:disabled;" class="input" value="" id="slan_cd11" /><button type="button" name="btn_SlanCd11" id="btn_SlanCd11" class="input_seach_btn" ></button>
							</td>   
							<th class="srch_type_2" style="display:none">BKG Ref No.</th>
							<td class="srch_type_2" style="display:none"><input type="text" name="booking_no2" style="width:120px;" class="input1 srch_type_2" value="" caption="BKG Ref No." maxlength="30" id="booking_no2" /> </td>
							<th class="srch_type_2" style="display:none">VVD CD</th>
							<td class="srch_type_2" style="display:none"><input type="text" name="vsl_cd2" style="width:51px;" class="input" value="" fullfill="" caption="VVD CD" maxlength="4" dataformat="engup" id="vsl_cd2" /><!-- 
						 	--><input type="text" name="skd_voy_no" style="width:37px;" class="input" value="" fullfill="" caption="VVD CD" maxlength="4" dataformat="engup" id="skd_voy_no" /><!-- 
						 	--><input type="text" name="skd_dir_cd" style="width:18px;" class="input" value="" fullfill="" caption="VVD CD" maxlength="1" dataformat="engup" id="skd_dir_cd" /><!-- 
						 	--><button type="button" id="btn_VVDpop" name="btn_VVDpop" class="input_seach_btn"></button><!-- 
						 	--><input type="text" name="vsl_eng_nm" style="width:119px;" class="input2" value="" readonly id="vsl_eng_nm" /> </td>
						 
						</tr>
				   </tbody>
				</table>
				<table class="srch_type_1">
					<colgroup>
						<col width="50" />				
						<col width="120" />	
						<col width="10"/>			
						<col width="100" />		
						<col width="220" />	
						<col width="10"/>				
						<col width="70" />	
						<col width="70" />	
						<col width="50" />		
						<col width="70" />	
						<col width="98" />		
						<col width="*" />	
				   </colgroup> 
				   <tbody>
				   		<tr>
							<th>Vessel</th>
							<td><input type="text" name="vsl_cd" style="width:52px;ime-mode:disabled;" caption="Vessel Code" maxlength="4" dataformat="engup" class="input" value="" id="vsl_cd" /><!-- 
								 --><button type="button" name="btn_Vessel" id="btn_Vessel" class="input_seach_btn" ></button></td>
							<td></td>
							<th class="wrap_search_tab">Approval Status</th>
							<td class="wrap_search_tab" ><!-- 
								 --><input type="radio" name="auth_flg" value="A" class="trans" checked="" id="auth_flg5" />&nbsp;&nbsp;All&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<!-- 
								 --><input type="radio" name="auth_flg" value="R" class="trans" id="auth_flg6" />&nbsp;&nbsp;Request&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<!-- 
							     --><input type="radio" name="auth_flg" value="P" class="trans" id="auth_flg7" />&nbsp;&nbsp;Pending
							</td>
							<td></td>
							<th>BKG Ref No.</th>
							<td><input type="text" name="booking_no" style="width:120px;" class="input1 srch_type_1" value="" caption="BKG Ref No." maxlength="30" id="booking_no" /> </td><%//dataformat="engup"  %>			
							<td align="right"><input type="checkbox" name="from_eta_flg" value="Y" class="trans" checked="" id="from_eta_flg">&nbsp;&nbsp;</td>
							<th>ETA next&nbsp;&nbsp;<input type="text" name="from_eta_dt" style="width:25px;ime-mode:disabled;" class="input1" value="10" dataformat="num" maxlength="3" id="from_eta_dt">&nbsp;days</th>
							<th align="right">I/F Type</th>
							<td><script type="text/javascript">ComComboObject('src_tp_cd', 1, 85, 0, 0);</script></td>
						</tr>
				   </tbody>
				</table>
				<!-- 
				<table class="height_8"><tr><td></td></tr></table>	
					 -->
				<table class="srch_type_2" style="display:none">
					<colgroup>
						<col width="50" />				
						<col width="96" />							
						<col width="70" />				
						<col width="*" />				
				   </colgroup> 
				   <tbody>
				   		<tr>
							<th>POL</th>
							<td><input type="text" name="pol_cd" style="width:55px;" class="input" value="" caption="POL" maxlength="5" dataformat="engup" id="pol_cd" /><!-- 
						 --><button type="button" id="btn_Pol" name="btn_Pol" class="input_seach_btn"></button></td>
							<th class="wrap_search_tab">APVL Type</th>
							<td class="wrap_search_tab"><!-- 
							 --><input type="radio" name="auth_flg" id="auth_flg1" value="Y" class="trans" ><label for="auth_flg1">Approved</label><!-- 
							  --><input type="radio" name="auth_flg" id="auth_flg2" value="U" class="trans auth_flg_update_only"><label for="auth_flg2" class="auth_flg_update_only">Unapproved</label><!-- 
							   --><input type="radio" name="auth_flg" id="auth_flg3" value="N" class="trans"><label for="auth_flg3">Rejected</label><!-- 
							   --><input type="radio" name="auth_flg" id="auth_flg4" value="YN" class="trans"><label for="auth_flg4">All</label>
							</td>
						</tr>
				   </tbody>
				</table>					 
			</td>
			</tr>
		</table>
			
	</div>
	
</div>
<!-- opus_design_inquiry(E) -->


<div class= "wrap_result">
	<div class="opus_design_tab">
		<script type="text/javascript">ComTabObject('tab1')</script>
	</div>
	<div name="tabLayer" id="tabLayer"  style="display:inline;">
		<div class="opus_design_grid">
			<span class="srch_type_1" style="background-color: yellow;text-align: center;padding: 5px 5px;"> Updated Item</span>
		    <span class="srch_type_1" style="background-color: lightgreen;text-align: center;padding: 5px 5px;">New Item</span>
			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn">
			    <button type="button" class="btn_accent" name="btn_recovery"     id="btn_recovery">Recovery</button>
				<button type="button" class="btn_accent" name="btn_details_bkg"  id="btn_details_bkg">Application Details(BKG)</button>	
				<button type="button" class="btn_accent" name="btn_details" 	 id="btn_details">Application Details(CGO)</button>			
			</div>
			<!-- opus_design_btn(E) -->
			<script type="text/javascript">ComSheetObject('t1sheet1');</script>
			<script type="text/javascript">ComSheetObject('t2sheet1');</script>
		</div>
	</div>
	<div name="tabLayer" id="tabLayer"  style="display:none;">
		<div class="opus_design_grid">			
			<!-- opus_design_btn(E) -->
			<script type="text/javascript">ComSheetObject('t3sheet1');</script>
		</div>
	</div>

</div>

<!-- 
<div class="wrap_result">
	<div class="opus_design_grid">
	<script type="text/javascript">ComSheetObject('t0sheet1');</script>
	</div>
</div>
 -->


</form>