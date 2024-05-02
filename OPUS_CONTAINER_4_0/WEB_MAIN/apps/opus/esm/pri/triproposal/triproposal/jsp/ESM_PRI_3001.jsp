<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_3001.jsp
*@FileTitle  : TRI Creation & Amendment
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/13
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.triproposal.triproposal.event.EsmPri3001Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri3001Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error from Server
	String strErrMsg = "";						//Error Message
	int rowCount	 = 0;						//Number of DB ResultSet List

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strSRepCd = "";
	String strOfcCd = "";
	String strRhqOfcCd = "";
	Logger log = Logger.getLogger("com.clt.apps.TRIProposal.TRIProposal");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strSRepCd = account.getSrep_cd();
		strOfcCd = account.getOfc_cd();
		strRhqOfcCd = account.getRhq_ofc_cd();

		event = (EsmPri3001Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// Adding Logic extracting data from server when loading initial window ..
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
<input type="hidden" name="f_cmd" 			id="f_cmd">
<input type="hidden" name="pagerows" 		id="pagerows">
<input type="hidden" name="srch_trf_pfx_cd" id="srch_trf_pfx_cd">
<input type="hidden" name="srch_trf_no" 	id="srch_trf_no">
<input type="hidden" name="ibflag" 			id="ibflag">
<input type="hidden" name="trf_pfx_cd" 		id="trf_pfx_cd">
<input type="hidden" name="trf_no" 			id="trf_no">
<input type="hidden" name="prop_sts_cd" 	id="prop_sts_cd">
<input type="hidden" name="amdt_seq" 		id="amdt_seq">
<input type="hidden" name="is_req_usr" 		id="is_req_usr">
<input type="hidden" name="is_apro_usr" 	id="is_apro_usr">
<input type="hidden" name="srep_cd" 		id="srep_cd" value="<%=strSRepCd%>">
<input type="hidden" name="usr_id" 			id="usr_id" value="<%=strUsr_id%>">
<input type="hidden" name="ofc_cd" 			id="ofc_cd" value="<%=strOfcCd%>">
<input type="hidden" name="rhq_ofc_cd" 		id="rhq_ofc_cd" value="<%=strRhqOfcCd%>">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<!-- opus_design_btn(E) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve_s" 	id="btn_retrieve_s">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_new_s"  		id="btn_new_s">New</button><!--
		--><button type="button" class="btn_normal" name="btn_grical_s" 	id="btn_grical_s">GRI Cal.</button><!--
		--><button type="button" class="btn_normal" name="btn_request_s" 	id="btn_request_s">Request</button><!--
		--><button type="button" class="btn_normal" name="btn_rcancel_s" 	id="btn_rcancel_s">R.Cancel</button><!--
		--><button type="button" class="btn_normal" name="btn_approve_s" 	id="btn_approve_s">Approve</button><!--
		--><button type="button" class="btn_normal" name="btn_acancel_s" 	id="btn_acancel_s">A.Cancel</button><!--
		--><button type="button" class="btn_normal" name="btn_publish_s" 	id="btn_publish_s">Publish</button><!--
		--><button type="button" class="btn_normal" name="btn_downexcel_s" id="btn_downexcel_s">Down Excel</button>	
	</div>
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry wFit">
	<table>
		<colgroup>
			<col width="100"/>
			<col width="60"/>
			<col width="105"/>
			<col width="50"/>
			<col width="60"/>
			<col width="65" />
			<col width="60" />
			<col width="60" />
			<col width="30" />
			<col width="128" />
			<col width="115" />
			<col width="90" />
			<col width="*" />
	    </colgroup>
	 	<tbody>
			<tr>
				<th>Tariff Code</th>
				<td colspan="7"><script type="text/javascript">ComComboObject("srch_trf_cd", 2, 90, 0, 1, 0, false);</script><!-- 
				 --><input type="text" name="srch_trf_nm" 	id="srch_trf_nm" style="width:387px;" class="input2" value="" readonly caption="Tariff Code"></td>
				<th>Commodity Code</th>
				<td><input type="text" name="srch_cmdt_cd" 	id="srch_cmdt_cd" style="width:70px;text-align:center;" class="input" value="" dataformat="num" maxlength="6" fullfill caption="Commodity Code"><button type="button" class="input_seach_btn" name="srch_btn_srch_cmdt" id="srch_btn_srch_cmdt"></button></td>
				<th>Access Date</th>
				<td><input type="text" name="srch_acc_dt" 	id="srch_acc_dt" style="width:80px;text-align:center;" class="input" caption="Access Date" maxlength="10" dataformat="ymd"><button type="button" class="calendar" name="srch_btn_acc_dt" id="srch_btn_acc_dt"></button>
				<td></td>
			</tr>
			<tr>
				<th>Origin</th>
				<td><input type="text" name="srch_org_rout_pnt_loc_nm" 		id="srch_org_rout_pnt_loc_nm" 	style="width:60px;text-align:center;" class="input" value="" dataformat="engup" maxlength="5" fullfill caption="Origin"></td>
				<th>Origin Via</th>
				<td><input type="text" name="srch_org_rout_via_port_nm" 	id="srch_org_rout_via_port_nm" 	style="width:60px;text-align:center;" class="input" value="" dataformat="engup" maxlength="5" fullfill caption="Origin Via."></td>
				<th>Dest. Via</th>
				<td><input type="text" name="srch_dest_rout_via_port_nm" 	id="srch_dest_rout_via_port_nm" style="width:60px;text-align:center;" class="input" value="" dataformat="engup" maxlength="5" fullfill caption="Dest Via."></td>
				<th>Destination</th>
				<td><input type="text" name="srch_dest_rout_pnt_loc_nm" 	id="srch_dest_rout_pnt_loc_nm" 	style="width:60px;text-align:center;" class="input" value="" dataformat="engup" maxlength="5" fullfill caption="Destination"></td>
				<th>Tariff Rate Item(TRI)</th>
				<td><input type="text" name="srch_tri_no" 			id="srch_tri_no" 				style="width:110px;text-align:center;" class="input" value="" dataformat="num" maxlength="15" caption="Tariff Rate Item"></td>
				<th>Proposal No.</th>
				<td><input type="text" name="srch_tri_prop_no" 		id="srch_tri_prop_no" 			style="width:103px;text-align:center;" class="input" value="" dataformat="engup" maxlength="10" caption="Proposal No."></td>				
				<td></td>
			</tr>
		</tbody>
	</table>
	<table>
		<colgroup>
			<col width="100"/>
			<col width="75"/>
			<col width="102"/>
			<col width="77"/>
			<col width="50"/>
			<col width="116" />
			<col width="50"/>
			<col width="163" />
			<col width="143" />
			<col width="*" />
	    </colgroup>
		<tbody>
			<tr>
				<th>Approval Office</th>
				<td><script type="text/javascript">ComComboObject('srch_tri_apro_ofc_cd', 2, 67, 0, 0);</script></td>
				<th>Request Office</th>
				<td><input type="text" 		name="srch_tri_rqst_ofc_cd" id="srch_tri_rqst_ofc_cd" 	style="width:60px;text-align:center;" class="input" value="" dataformat="engup" maxlength="5" fullfill caption="Approval Office"></td>
				<th>Status</th>
				<td><script type="text/javascript">ComComboObject('srch_prop_sts_cd', 1, 75, 1, 0);</script></td>
				<td></td>				
				<td><input type="checkbox" 	name="srch_is_gri_appl" 	id="srch_is_gri_appl" value="Y" class="trans"><label for ="srch_is_gri_appl"><b>GRI Cal. Applying list</b></label></td>
				<td><input type="text" 		name="srch_gri_eff_dt" 		id="srch_gri_eff_dt" 		style="width:80px;text-align:center;" class="input" caption="GRI Effective Date" maxlength="10" dataformat="ymd"><button type="button" class="calendar" name="srch_btn_grieffdt" id="srch_btn_grieffdt"></button></td>
				<td><button type="button" class="btn_etc" name="btn_conversion" 	id="btn_conversion">Tariff Formula Rule</button></td>
			</tr>
		</tbody>
	</table>
</div>
<!-- opus_design_inquiry(E) -->
</div>


<div class="wrap_result">
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" 	id="btn_retrieve">Retrieve</button><!--  
		--><button type="button" class="btn_normal" name="btn_new"  		id="btn_new">New</button><!--
		--><button type="button" class="btn_normal" name="btn_save" 		id="btn_save">Save</button><!--
		--><button type="button" class="btn_normal" name="btn_request" 	id="btn_request">Request</button><!--
		--><button type="button" class="btn_normal" name="btn_amend" 		id="btn_amend">Amend</button><!--
		--><button type="button" class="btn_normal" name="btn_coffer" 		id="btn_coffer">C/offer</button><!--
		--><button type="button" class="btn_normal" name="btn_approve" 	id="btn_approve">Approve</button><!--
		--><button type="button" class="btn_normal" name="btn_publish" 	id="btn_publish">Publish</button><!--
		--><button type="button" class="btn_normal" name="btn_assign" 		id="btn_assign">TRI No. Assign</button><!--
		--><button type="button" class="btn_normal" name="btn_cancel" 		id="btn_cancel">Cancel</button><!--
		--><button type="button" class="btn_normal" name="btn_copy" 		id="btn_copy">Copy</button>	
	</div>
	
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="60"/>
				<col width="140"/>
				<col width="100"/>
				<col width="90"/>
				<col width="100"/>
				<col width="350"/>
				<col width="*" />
		    </colgroup>
			<tbody>
				<tr>
					<th>TRI No.</th>
					<td><input type="text" name="tri_no" 		id="tri_no" style="width:130px;text-align:center;" class="input2" value="" maxlength="15" caption="TRI No." readonly></td>
					<th>Proposal No.</th>
					<td><input type="text" name="tri_prop_no" 	id="tri_prop_no" style="width:80px;text-align:center;" class="input2" value="" maxlength="9" fullfill caption="Proposal No." readonly></td>
					<th>Commodity</th>
					<td><input type="text" name="cmdt_cd" 		id="cmdt_cd" style="width:70px;text-align:center;" class="input1" value="" dataformat="num" maxlength="6" fullfill required caption="Commodity"><button type="button" class="input_seach_btn" name="btn_srch_cmdt" id="btn_srch_cmdt"></button><input type="text" name="cmdt_nm" 		id="cmdt_nm" style="width:222px;" class="input2" value="" readonly><button type="button" class="btn_etc" name="btn_taalist" 	id="btn_taalist">Related TAA List</button></td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
	
	<table class="line_bluedot"><tr><td></td></tr></table>
	
	<div class="opus_design_grid">
		<div class="grid_option_left">
			<h3 class="title_design pad_btm_8">Route</h3>
		</div>
		
		<div class="opus_design_data">
			<table class="grid_2">
				<colgroup>
					<col width="270"/>
					<col width="30"/>
					<col width="270"/>
					<col width="30"/>
					<col width="270"/>
					<col width="30"/>
					<col width="270" />
					<col width="*" />
			    </colgroup>
		   		<tbody>
					<tr>
						<th style="border: #E8EFF9 1px solid;width:25%;text-align:center;"><b>Origin</b></th>
						<td><button type="button" class="input_seach_btn" name="btn_srch_org_pnt" id="btn_srch_org_pnt"></button></td>
						<th style="border: #E8EFF9 1px solid;width:25%;text-align:center;"><b>Origin Via</b></th>
						<td><button type="button" class="input_seach_btn" name="btn_srch_org_via" id="btn_srch_org_via"></button></td>
						<th style="border: #E8EFF9 1px solid;width:25%;text-align:center;"><b>Destination Via</b></th>
						<td><button type="button" class="input_seach_btn" name="btn_srch_dest_via" id="btn_srch_dest_via"></button></td>
						<th style="border: #E8EFF9 1px solid;width:25%;text-align:center;"><b>Destination</b></th>
						<td><button type="button" class="input_seach_btn" name="btn_srch_dest_pnt" id="btn_srch_dest_pnt"></button></td>
						
					</tr>
		            <tr>
		                <td colspan=2 class="input"><div style="width:100%; height:45px; word-wrap:break-word; overflow-x:hidden; overflow-y:scroll;"><table width="100%" height="100%"><tr><td style="border:0px; padding:2px; text-indent:0px;" valign="top" id="origin_desc"></td></tr></table></div></td>
		                <td colspan=2 class="input"><div style="width:100%; height:45px; word-wrap:break-word; overflow-x:hidden; overflow-y:scroll;"><table width="100%" height="100%"><tr><td style="border:0px; padding:2px; text-indent:0px;" valign="top" id="ovia_desc"></td></tr></table></div></td>
		                <td colspan=2 class="input"><div style="width:100%; height:45px; word-wrap:break-word; overflow-x:hidden; overflow-y:scroll;"><table width="100%" height="100%"><tr><td style="border:0px; padding:2px; text-indent:0px;" valign="top" id="dvia_desc"></td></tr></table></div></td>
		                <td colspan=2 class="input"><div style="width:100%; height:45px; word-wrap:break-word; overflow-x:hidden; overflow-y:scroll;"><table width="100%" height="100%"><tr><td style="border:0px; padding:2px; text-indent:0px;" valign="top" id="dest_desc"></td></tr></table></div></td>
		            </tr>
				</tbody>
			</table>
		</div>
	</div>

	
	<div class="grid_option_left">
		<h3 class="title_design">Rate</h3>
	</div>
	<script type="text/javascript">ComSheetObject('sheet2');</script>
</div>

<div style="height:30px"></div>

<div id="hiddenSheetLayer" style="display: none;">
	<script type="text/javascript">ComSheetObject('sheet3');</script>
	<script type="text/javascript">ComSheetObject('sheet4');</script>
	<script type="text/javascript">ComSheetObject('sheet5');</script>
	<script type="text/javascript">ComSheetObject('sheet6');</script>
	<script type="text/javascript">ComSheetObject('sheet7');</script>
</div>

</form>