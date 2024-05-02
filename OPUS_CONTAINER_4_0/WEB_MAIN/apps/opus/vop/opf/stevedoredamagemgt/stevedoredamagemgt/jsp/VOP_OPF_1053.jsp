<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : vop_opf_1053.jsp
*@FileTitle  : Stevedore Damage Detail
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/17
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%> 
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.event.VopOpf1053Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.OfficeCodeMgr"%>


<%
	VopOpf1053Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String office_cd		= "";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_eml		= "";
	Logger log = Logger.getLogger("com.clt.apps.StevedoreDamageMgt.StevedoreDamageMgt");

	String[] userAuth = null;

   	String mailContent = "[Concerned Office]"
                + "<br>OfficeCode:MailID@XXXXX.com"
                + "<p>";        

	String sdmsNo = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   	office_cd = account.getOfc_cd();
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_eml = account.getUsr_eml();
		userAuth = account.getUserAuth();

		event = (VopOpf1053Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		sdmsNo = request.getParameter("stv_dmg_no");
		//Test!!!!!!!!!!!!!!!!
		//sdmsNo = "HNOS0900101";

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
<%=OfficeCodeMgr.getOfficeCodeListToJS("000001", "OPF")%>
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage('<%=strUsr_id%>', '<%=strUsr_nm%>', '<%=office_cd%>');
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<!-- Developer Performance	-->
<input type="hidden" name="com_rdSubSysCd" value="OPF" id="com_rdSubSysCd" />
<input type="hidden" name="com_from" value="<%=strUsr_eml%>" id="com_from" />
<input type="hidden" name="com_fromName" value="" id="com_fromName" />
<input type="hidden" name="com_recipient" value="" id="com_recipient" />
<input type="hidden" name="com_carbonCopy" value="<%=strUsr_eml%>" id="com_carbonCopy" />
<input type="hidden" name="com_blindCarbonCopy" id="com_blindCarbonCopy" />
<input type="hidden" name="com_subject" value="Re:SDMS Application" id="com_subject" />
<input type="hidden" name="com_fileKey" id="com_fileKey" />
<input type="hidden" name="com_content" id="com_content"/>
<input type="hidden" name="default_content" value="<%=mailContent%>" id="default_content" />
<input type="hidden" name="com_templateMrd" value="VOP_OPF_1153.mrd" id="com_templateMrd" />
<input type="hidden" name="com_templateMrdArguments" id="com_templateMrdArguments" />
<input type="hidden" name="com_templateMrdDescription" id="com_templateMrdDescription" value="UI_OPF_1153.mrd 파일이 첨부되었습니다.">

<!-- Input Box for Report Designer  -->
<input type="hidden" name="com_mrdPath" id="com_mrdPath" />
<input type="hidden" name="com_mrdArguments" id="com_mrdArguments" />
<input type="hidden" name="com_mrdSaveDialogDir" value="c:\\MyFolder\\" id="com_mrdSaveDialogDir" />
<input type="hidden" name="com_mrdSaveDialogFileName" value="StevedoreDamageDetail" id="com_mrdSaveDialogFileName" />
<input type="hidden" name="com_mrdSaveDialogFileExt" value="pdf" id="com_mrdSaveDialogFileExt" />
<input type="hidden" name="com_mrdSaveDialogFileExtLimit" value="xls@pdf@bmp@tif" id="com_mrdSaveDialogFileExtLimit" />
<input type="hidden" name="com_mrdDisableToolbar" id="com_mrdDisableToolbar" />
<input type="hidden" name="com_mrdTitle" value="Stevedore Damage Detail" id="com_mrdTitle" />
<input type="hidden" name="com_mrdBodyTitle" value="Stevedore Damage Detail" id="com_mrdBodyTitle" />

<input type="hidden" name="office_cd" value="<%=office_cd%>" id="office_cd" />

<%
for(String auth : userAuth){
%>
<input type="hidden" name="user_auth" value="<%=auth%>" id="user_auth" />
<%}%>


<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Stevedore Damage Detail</span></h2>
		
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn_Delete" id="btn_Delete" type="button">Delete</button><!--
			--><button class="btn_normal" name="btn_Save" id="btn_Save" type="button">Save</button><!--
			--><button class="btn_normal" name="btn_Print" id="btn_Print" type="button">Print</button><!--
			--><button class="btn_normal" name="btn_Mail" id="btn_Mail" type="button">Mail</button><!--
			--><button class="btn_normal" name="btn_Close" id="btn_Close" type="button">Close</button>
		</div>
	<!-- opus_design_btn (E) -->
	</div>
</div>

<div class="layer_popup_contents">
	<!-- wrap_search(S) -->
	<div class="wrap_search">
	
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="70">				
					<col width="140">				
					<col width="55">				
					<col width="70">				
					<col width="90">				
					<col width="130">				
					<col width="35">				
					<col width="60">				
					<col width="125">				
					<col width="*">				
			   </colgroup> 
			   <tbody>
			   		<tr>
						<th>VVD CD</th>
						<td><input type="text" name="vsl_cd" style="width:55px;" class="input2" readonly id="vsl_cd" /><input type="text" name="skd_voy_no" style="width:40px;" class="input2" readonly id="skd_voy_no" /><input type="text" name="skd_dir_cd" style="width:25px;" class="input2" readonly id="skd_dir_cd" /> </td>
						<th>Port</th>
						<td><input type="text" name="vps_port_cd" style="width:60px;" class="input2" readonly id="vps_port_cd" /> </td>
						<th>Damage Date</th>
						<td><input type="text" style="width:75px;" maxlength="8" class="input2" dataformat="ymd" caption="Damage Date" name="stv_dmg_evnt_dt" readonly id="stv_dmg_evnt_dt" /><button type="button" id="btn_stv_dmg_evnt_dt" name="btn_stv_dmg_evnt_dt" class="calendar ir"></button></td>
						<th>Lane</th>
						<td><input type="text" style="width:40px;" class="input2" name="slan_cd" readonly id="slan_cd" /> </td>
						<th>Vessel Category</th>
						<td><script type="text/javascript">ComComboObject('vsl_oshp_cntr_blk_tp_cd',1,150,1,1,0);</script></td>
			   		</tr>
			   </tbody>
			</table>
			<table>
				<colgroup>
					<col width="70" />				
					<col width="140" />				
					<col width="170" />				
					<col width="285" />				
					<col width="110" />				
					<col width="*" />				
			   </colgroup> 
			   <tbody>
			   		<tr>
						<th>SDMS No.</th>
						<td><input type="text" name="stv_dmg_no" style="width:128px;" class="input2" value="<%=StringUtil.xssFilter(sdmsNo) %>" readonly id="stv_dmg_no" /> </td>
						<th>Report No. (If any at SDR)</th>
						<td><input type="text" name="stv_dmg_ref_no" style="width:178px;ime-mode:disabled;" maxlength="20" id="stv_dmg_ref_no" /> </td>
						<th>Damage Category</th>
						<td width=""><script type="text/javascript">ComComboObject('stv_dmg_prt_cate_cd',1,150,1,1,0);</script></td>
			   		</tr>
			   </tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
	<!-- wrap_search(E) -->

	<!-- wrap_result(S) -->
	<div class="wrap_result">
		
		<div class="opus_design">
			<script type="text/javascript">ComTabObject('tab1')</script>
		</div>
		
		<!-- (TAB) [ Damage ] (S) -->
		<div id="tabLayer" style="display:inline">
			<!-- opus_design_inquiry(S) -->
			<div class="opus_design_inquiry wFit">
				<table>
					<colgroup>
						<col width="130" />				
						<col width="140" />				
						<col width="40" />				
						<col width="322" />				
						<col width="60" />				
						<col width="*" />				
				   </colgroup> 
				   <tbody>
				   		<tr>
							<th>Claim Handling Office</th>
							<td><input type="text" name="clm_hndl_ofc_cd" caption="Claim Handling Office" style="width:70px;ime-mode:disabled;" maxlength="6" class="input1" required="" id="clm_hndl_ofc_cd" /> <button type="button" id="clm_hndl_ofc_cd_pop" name="clm_hndl_ofc_cd_pop" class="input_seach_btn"></button></td>
							<th>Part</th>
							<td> <script type="text/javascript">ComComboObject('stv_dmg_prt_cd',2,245,1,1,1);</script></td>
							<th>Damage</th>
							<td><script type="text/javascript">ComComboObject('stv_dmg_tp_cd',2,183,1,0,1);</script></td>
				   		</tr>
				   		<tr>
							<th>Location / Size / Qty</th>
							<td colspan="5"><input type="text" style="width:100%;ime-mode:disabled;" class="input" name="stv_dmg_loc_desc" maxlength="500" id="stv_dmg_loc_desc" /> </td>
				   		</tr>
				   </tbody>
				</table>
				<table>
					<colgroup>
						<col width="132">				
						<col width="210">				
						<col width="210">				
						<col width="*">				
				   </colgroup>
				   <tbody>
				   		<tr>
							<th>Attach File</th>
							<td><button type="button" class="btn_etc" name="btn_SDR" id="btn_SDR">SDR</button><input type="text" name="stv_dmg_rpt_atch_knt" style="width:45px; text-align:center;" class="input" value="0" readonly id="stv_dmg_rpt_atch_knt" />&nbsp;(Files)</td>
							<td><button type="button" class="btn_etc" name="btn_Picture" id="btn_Picture">Picture</button><input type="text" name="stv_dmg_pict_atch_knt" style="width:45px; text-align:center;" class="input" value="0" readonly id="stv_dmg_pict_atch_knt" />&nbsp;(Files)</td>
							<td><button type="button" class="btn_etc" name="btn_Document" id="btn_Document">Document</button><input type="text" name="stv_dmg_doc_atch_knt" style="width:45px; text-align:center;" class="input" value="0" readonly id="stv_dmg_doc_atch_knt" />&nbsp;(Files)</td>
				   		</tr>
				   </tbody>
				</table>
				<table>
					<colgroup>
						<col width="130">				
						<col width="290">				
						<col width="130">				
						<col width="*">				
				   </colgroup>
				   <tbody>
				   		<tr>
							<th>Related Damage</th>
							<td class="sm pad_left_8"><input type="checkbox" class="trans" name="cntr_dmg_flg" value="Y" id="cntr_dmg_flg" />&nbsp;&nbsp;Damage on Container&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" class="trans" name="cgo_dmg_flg" value="Y" id="cgo_dmg_flg" />&nbsp;&nbsp;Damage on Cargo</td>
							<th>CNTR No.</th>
							<td><input type="text" style="width:135px;" class="input" maxlength="14" name="cntr_no" id="cntr_no" /> </td>
				   		</tr>
				   </tbody>
				</table>
				<table>
					<colgroup>
						<col width="130">				
						<col width="50">				
						<col width="100">				
						<col width="110">				
						<col width="122">				
						<col width="*">				
				   </colgroup>
				   <tbody>
				   		<tr>
							<th>Time Loss (Hours)</th>
							<td><input type="text" style="width:50px;" class="input2" name="time_loss_hours" readonly id="time_loss_hours" /></td>
							<th>From (GMT)</th>
							<td><input type="text" style="width:136px;" class="input" name="fm_tm_lss_dt"  caption="From Loss Hour" maxlength="12" dataformat="ymdhm"  id="fm_tm_lss_dt" /> </td>
							<th>To (GMT)</th>
							<td><input type="text" style="width:135px;" class="input" name="to_tm_lss_dt"  caption="To Loss Hour" maxlength="12" dataformat="ymdhm"  id="to_tm_lss_dt" /> </td>
				   		</tr>
				   </tbody>
				</table>
				<table>
					<colgroup>
						<col width="130">				
						<col width="*">				
				   </colgroup>
				   <tbody>
				   		<tr>
							<th>Remark(s)</th>
							<td colspan="5"><textarea style="width:100%; height:45px;ime-mode:disabled;" name="stv_dmg_rmk" id="stv_dmg_rmk"></textarea></td>
				   		</tr>
				   </tbody>
				</table>
				<table class="line_bluedot"><tr><td></td></tr></table>
				<table>
					<colgroup>
						<col width="130">				
						<col width="230">				
						<col width="105">				
						<col width="112">				
						<col width="60">				
						<col width="112">				
						<col width="30">				
						<col width="*">				
				   </colgroup>
				   <tbody>
				   		<tr>
							<th>Requirement</th>
							<td class="sm pad_left_8"><input type="radio" class="trans" name="stv_dmg_req_cate_cd" id="stv_dmg_req_cate_cd" value="R" checked>&nbsp;Repair&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" class="trans" name="stv_dmg_req_cate_cd" id="stv_dmg_req_cate_cd" value="S">&nbsp;Supply&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" class="trans" name="stv_dmg_req_cate_cd" id="stv_dmg_req_cate_cd" value="Q">&nbsp;Quotation</td></td>
							<th>Voyage No.</th>
							<td><input type="text" style="width:53px;ime-mode:disabled;" maxlength="5" fullfill="" class="input" name="req_skd_voy_dir" caption="Voyage No" id="req_skd_voy_dir" /><button type="button" id="req_skd_voy_dir_pop" name="req_skd_voy_dir_pop" class="input_seach_btn"></button> </td>
							<th>Port</th>
							<td><input type="text" style="width:53px;ime-mode:disabled;" maxlength="5" fullfill="" class="input" name="req_port_cd" caption="Voyage No" id="req_port_cd" /> </td>
							<th>ETA</th>
							<td><input type="text" style="width:75px;" maxlength="8" class="input" dataformat="ymd" caption="ETA Date" name="req_eta_dt" id="req_eta_dt" /><button type="button" id="btn_req_eta_dt" name="btn_req_eta_dt" class="calendar ir"></button></td>
				   		</tr>
				   		<tr>
							<td colspan="2"></td>
							<th>Reason</th>
							<td colspan="5"><script type="text/javascript">ComComboObject('stv_dmg_qttn_rsn_desc',2,100,1,1,0);</script><input type="text" style="width:313px;" class="input2" maxlength="500" name="req_reason_desc" id="req_reason_desc" readOnly></td>
						</tr>
						<tr><td colspan="8" class="line_bluedot"></td></tr>
						<tr>
							<th>Responsible Party</th>
							<td class="sm pad_left_8"><input type="radio" class="trans" name="stv_dmg_respb_pty_kwn_flg" id="stv_dmg_respb_pty_kwn_flg" value="Y" checked>&nbsp;Known&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" class="trans" name="stv_dmg_respb_pty_kwn_flg" id="stv_dmg_respb_pty_kwn_flg" value="N">&nbsp;Unknown</td>
							<th>Details</th>
							<td colspan="5" align="right"><input type="text" style="width:100%;ime-mode:disabled;" maxlength="500" class="input1" name="stv_dmg_respb_desc_dtl" id="stv_dmg_respb_desc_dtl" caption="Details"></td>
						</tr>
						<tr>
							<td colspan="2"></td>
							<th>Reason</th>
							<td colspan="5"><script type="text/javascript">ComComboObject('stv_dmg_respb_desc',2,100,1,1,0);</script><input type="text" style="width:313px;" class="input2" maxlength="500" name="res_reason_desc" id="res_reason_desc" readOnly></td>
						</tr>
				   </tbody>
				</table>
				<table class="line_bluedot"><tr><td></td></tr></table>
				<table>
					<colgroup>
						<col width="930">
						<col width="220">
						<col width="*">				
				   </colgroup>
				   <tbody>
				   		<tr>
				   			<td></td>
							<td><input type="text" name="dmg_auth_sts_cd" style="width:50px;font-weight:bold;text-align:center;" class="input2" maxlength="1" value="X" readonly id="dmg_auth_sts_cd" /><!--
							--><input type="text" name="auth_usr_id" style="width:70px;font-weight:bold;" class="input2" maxlength="20" readonly id="auth_usr_id" /><!--
							--><input type="text" name="auth_dt" style="width:85px;font-weight:bold;" class="input2" readonly id="auth_dt" /></td>
							<td><button type="button" class="btn_etc" name="btnApproval" id="btnApproval">Approval</button></td>
				   		</tr>
				   </tbody>
				</table>
				<table>
					<colgroup>
						<col width="130">
						<col width="*">				
				   </colgroup>
				    <tbody>
						<tr>
							<th>Update DT/ID</th>
							<td><input type="text" name="dmg_upd_dt" id="dmg_upd_dt" style="width:80px;" class="input2" readonly><input type="text" name="dmg_upd_usr_id" id="dmg_upd_usr_id" style="width:100px;" class="input2" readonly></td>
						</tr>
					</tbody>
				</table>
			</div>
			<!-- opus_design_inquiry(E) -->
		</div>
		<!-- (TAB) [ Repair ] (E) -->
		
		<!-- (TAB) [ Repair ] (S) -->
		<div id="tabLayer" style="display:none">
			<!-- opus_design_inquiry(S) -->
			<div class="opus_design_inquiry wFit">
				<table>
					<colgroup>
						
				   </colgroup> 
				   <tbody>
				   		<tr>
							<td class="sm"><input type="radio" name="stv_dmg_rpr_proc_sts_cd" id="stv_dmg_rpr_proc_sts_cd" value="O" class="trans" checked>&nbsp;Ordered&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<!--
							--><input type="radio" name="stv_dmg_rpr_proc_sts_cd" id="stv_dmg_rpr_proc_sts_cd" value="R" class="trans">&nbsp;Repairing&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<!--
							--><input type="radio" name="stv_dmg_rpr_proc_sts_cd" id="stv_dmg_rpr_proc_sts_cd" value="C" class="trans">&nbsp;Completed&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<!--
							--><input type="radio" name="stv_dmg_rpr_proc_sts_cd" id="stv_dmg_rpr_proc_sts_cd" value="Q" class="trans">&nbsp;Quotation</td>
				   		</tr>
				   </tbody>
				</table>
				<table>
				<colgroup>
					<col width="135" />				
					<col width="40" />				
					<col width="160" />				
					<col width="70" />				
					<col width="120" />				
					<col width="60" />				
					<col width="80" />				
					<col width="*" />				
			   </colgroup> 
				   <tbody>
				   		<tr>
							<th>Repair Cost</th>
							<th>USD</th>
							<td><input type="text" name="rpr_cost_usd_amt_total" value="0" dataformat="float" pointcount="2" caption="USD Amount" style="width:90px; text-align:right;" class="input2" readonly id="rpr_cost_usd_amt_total" /> </td>
							<th>Repair Seq.</th>
							<td><input type="text" name="stv_dmg_rpr_seq" style="width:60px; text-align:right;" class="input2" readonly id="stv_dmg_rpr_seq" /><button class="btn_left" name="rpr_seq_prev" id="rpr_seq_prev"></button><button class="btn_right" name="rpr_seq_next" id="rpr_seq_next"></button></td>
							<th>Max Seq.</th>
							<td><input type="text" name="stv_dmg_rpr_seq_total" style="width:60px; text-align:right;" class="input2" readonly id="stv_dmg_rpr_seq_total" /> </td>
							<td><button class="btn_etc" name="rpr_seq_delete" id="rpr_seq_delete">Seq.Delete</button></td>
				   		</tr>
				   </tbody>
			   </table>
				<table>
				<colgroup>
					<col width="135" />				
					<col width="40" />				
					<col width="160" />				
					<col width="70" />				
					<col width="*" />				
			   </colgroup> 
				   <tbody>
				   		<tr>
							<th>Quotation</th>
							<th>USD</th>
							<td><input type="text" name="qttn_cost_usd_amt" caption="USD Amount" style="width:90px; text-align:right;"  readonly maxlength="18" class="input2" id="qttn_cost_usd_amt" /> </td>
							<th>Local</th>
							<td><script type="text/javascript">ComComboObject('qttn_locl_curr_cd',1,70,0,1);</script><input type="text" name="qttn_cost_locl_amt" id="qttn_cost_locl_amt" dataformat="float" pointcount="2" caption="Local Amount" style="width:90px; text-align:right;" maxlength="18" class="input1"></td>
				   		</tr>
				   </tbody>
			   </table>
			   <table class="line_bluedot"><tr><td></td></tr></table>
				<table>
				<colgroup>
					<col width="135" />				
					<col width="195" />				
					<col width="35" />				
					<col width="265" />				
					<col width="53" />				
					<col width="*" />				
			   </colgroup> 
				   <tbody>
				   		<tr>
							<th>Port</th>
							<td><input type="text" name="rpr_port_cd" caption="Port Code" style="width:98px;" maxlength="5" class="input1" id="rpr_port_cd" /><button type="button" id="rpr_port_cd_pop" name="rpr_port_cd_pop" class="input_seach_btn"></button></td>
							<th>Date</th>
							<td><input type="text" name="rpr_dt" dataformat="ymd" caption="Repair Date" style="width:78px;" maxlength="8" class="input1" id="rpr_dt" /><button type="button" id="btn_rpr_dt" name="btn_rpr_dt" class="calendar ir"></button></td>
							<th>Vendor</th>
							<td><input type="text" name="rpr_vndr_nm" caption="Vendor Name" style="width:282px;" maxlength="100" class="input1" id="rpr_vndr_nm" /> </td>
				   		</tr>
				   </tbody>
			   </table>
				<table>
				<colgroup>
					<col width="220" />				
					<col width="275" />				
					<col width="180" />				
					<col width="*" />				
			   </colgroup> 
				   <tbody>
				   		<tr>
							<th>Unsettled Inter-Office Account No.</th>
							<td><input type="text" name="ustl_acct_no" caption="Unsettled Inter-Office Account No" style="width:218px;" maxlength="20" class="input1" id="ustl_acct_no" /> </td>
							<th>Running Repair Account No.</th>
							<td><input type="text" name="run_rpr_acct_no" caption="Running Repair Account No" style="width:282px;" maxlength="20" class="input" id="run_rpr_acct_no" /> </td>
				   		</tr>
				   </tbody>
			   </table>
				<table>
				<colgroup>
					<col width="135" />				
					<col width="40" />				
					<col width="*" />				
			   </colgroup> 
				   <tbody>
				   		<tr>
							<th>Repair Cost</th>
							<th>USD</th>
							<td><input type="text" name="rpr_cost_usd_amt" dataformat="float" pointcount="2" style="width:75px; text-align:right;" maxlength="18" class="input1" id="rpr_cost_usd_amt" /> </td>
				   		</tr>
				   </tbody>
			   </table>
			   <table class="line_bluedot"><tr><td></td></tr></table>
			   <table>
					<colgroup>
						<col width="130">				
						<col width="210">				
						<col width="210">				
						<col width="210">				
						<col width="*">				
				   </colgroup>
				   <tbody>
				   		<tr>
							<th>Supporting</th>
							<td><button type="button" class="btn_etc" name="btn_t2Result" id="btn_t2Result">Result</button><input type="text" name="rpr_rslt_rpt_atch_knt" style="width:45px; text-align:center;" class="input" value="0" readonly id="rpr_rslt_rpt_atch_knt" />&nbsp;(Files)</td>
							<td><button type="button" class="btn_etc" name="btn_t2Invoice" id="btn_t2Invoice">Invoice</button><input type="text" name="rpr_inv_atch_knt" style="width:45px; text-align:center;" class="input" value="0" readonly id="rpr_inv_atch_knt" />&nbsp;(Files)</td>
							<td><button type="button" class="btn_etc" name="btn_t2PIC" id="btn_t2PIC">PIC</button><input type="text" name="rpr_pict_atch_knt" style="width:45px; text-align:center;" class="input" value="0" readonly id="rpr_pict_atch_knt" />&nbsp;(Files)</td>
							<td><button type="button" class="btn_etc" name="btn_t2Document" id="btn_t2Document">Document</button><input type="text" name="rpr_doc_atch_knt" style="width:45px; text-align:center;" class="input" value="0" readonly id="rpr_doc_atch_knt" />&nbsp;(Files)</td>
				   		</tr>
				   </tbody>
				</table>
			   <table>
					<colgroup>
						<col width="130">				
						<col width="*">				
				   </colgroup>
				   <tbody>
				   		<tr>
							<th>Remark(s)</th>
							<td><textarea name="rpr_rmk"  id="rpr_rmk"style="width:100%; height:45;" maxlength="1000"></textarea></td>
				   		</tr>
				   </tbody>
				</table>
			   <table>
					<colgroup>
						<col width="130">				
						<col width="*">				
				   </colgroup>
				   <tbody>
				   		<tr>
							<th>Update DT/ID</th>
							<td><input type="text" name="rpr_upd_dt" id="rpr_upd_dt" style="width:80px;" class="input2" readonly><input type="text" name="rpr_upd_usr_id" id="rpr_upd_usr_id" style="width:100;" class="input2" readonly></td>
				   		</tr>
				   </tbody>
				</table>
			</div>
			<!-- opus_design_inquiry(E) -->
		</div>
		<!-- (TAB) [ Repair ] (E) -->
		
		<!-- (TAB) [ Compensation ] (S) -->
		<div id="tabLayer" style="display:none">
			<!-- opus_design_inquiry(S) -->
			<div class="opus_design_inquiry wFit">
				<table>
					<colgroup>
						<col width="18%" />				
						<col width="64%" />				
						<col width="*" />				
				   </colgroup> 
				   <tbody>
				   		<tr>
							<td class="sm" width="18%"><input type="radio" name="stv_dmg_cmpn_proc_sts_cd" id="stv_dmg_cmpn_proc_sts_cd" value="R" class="trans" checked>&nbsp;Ready&nbsp;&nbsp;<!--
							--><input type="radio" name="stv_dmg_cmpn_proc_sts_cd" id="stv_dmg_cmpn_proc_sts_cd" value="C" class="trans">&nbsp;Claimed</td>
							<td class="sm" width="64%" align="center"><!--
							--><input type="radio" name="stv_dmg_cmpn_proc_sts_cd" id="stv_dmg_cmpn_proc_sts_cd" value="N" class="trans">&nbsp;Noticed&nbsp;&nbsp;<!--
							--><input type="radio" name="stv_dmg_cmpn_proc_sts_cd" id="stv_dmg_cmpn_proc_sts_cd" value="A" class="trans">&nbsp;Accepted&nbsp;&nbsp;<!--
							--><input type="radio" name="stv_dmg_cmpn_proc_sts_cd" id="stv_dmg_cmpn_proc_sts_cd" value="J" class="trans">&nbsp;Rejected&nbsp;&nbsp;<!--
							--><input type="radio" name="stv_dmg_cmpn_proc_sts_cd" id="stv_dmg_cmpn_proc_sts_cd" value="P" class="trans">&nbsp;Completed</td>
							<td class="sm"><input type="radio" name="stv_dmg_cmpn_proc_sts_cd" id="stv_dmg_cmpn_proc_sts_cd" value="E" class="trans">&nbsp;Cancellation</td>
				   		</tr>
				   </tbody>
				</table>
				<table>
					<colgroup>
						<col width="135" />				
						<col width="60" />				
						<col width="160" />				
						<col width="20" />				
						<col width="149" />				
						<col width="40" />				
						<col width="*" />				
				   </colgroup> 
				   <tbody>
				   		<tr>
							<th>Claim Handling</th>
							<th>Office</th>
							<td><input type="text" name="clm_hndl_ofc_cd_cmpn" style="width:90px;" class="input2" readonly id="clm_hndl_ofc_cd_cmpn" /> </td>
							<th>ID</th>
							<td><input type="text" name="clm_hndl_usr_id" style="width:90px;" class="input2" readonly id="clm_hndl_usr_id" /> </td>
							<th>Name</th>
							<td><input type="text" name="clm_hndl_usr_name" style="width:170px;" class="input2" readonly id="clm_hndl_usr_name" /> </td>
				   		</tr>
				   </tbody>
				</table>
				<table>
					<colgroup>
						<col width="135" />				
						<col width="62" />				
						<col width="330" />				
						<col width="40" />				
						<col width="260" />				
						<col width="35" />				
						<col width="*" />				
				   </colgroup> 
				   <tbody>
				   		<tr>
							<th>Responsible Party</th>
							<th>Company</th>
							<td><input type="text" name="stv_dmg_respb_pty_co_nm" caption="Company" style="width:270px;" maxlength="200" class="input1" id="stv_dmg_respb_pty_co_nm" /> </td>
							<th>Name</th>
							<td><input type="text" name="stv_dmg_respb_pty_pic_nm" caption="Name" style="width:170px;" maxlength="200" class="input1" id="stv_dmg_respb_pty_pic_nm" /> </td>
							<th>Title</th>
							<td><input type="text" name="stv_dmg_respb_pty_pic_tit_nm" caption="Title" style="width:100px;" maxlength="200" class="input1" id="stv_dmg_respb_pty_pic_tit_nm" /> </td>
				   		</tr>
				   </tbody>
				</table>
				<table>
					<colgroup>
						<col width="158" />				
						<col width="66" />				
						<col width="160" />				
						<col width="40" />				
						<col width="250" />				
						<col width="30" />				
						<col width="104" />				
						<col width="90" />				
						<col width="*" />				
				   </colgroup> 
				   <tbody>
				   		<tr>
							<th>Compensation</th>
							<th>Date</th>
							<td><input type="text" name="stv_dmg_cmpn_dt" style="width:90px;" dataformat="ymd" caption="Compensation Date" class="input1" id="stv_dmg_cmpn_dt" /> <button type="button" id="btn_stv_dmg_cmpn_dt" name="btn_stv_dmg_cmpn_dt" class="calendar ir"></button></td>
							<th>Local</th>
							<td width="243"><script type="text/javascript">ComComboObject('cmpn_curr_cd',1,78,0,1);</script>&nbsp;<input type="text" name="cmpn_cost_locl_amt" id="cmpn_cost_locl_amt" dataformat="float" pointcount="2" caption="Local Amount" style="width:100; text-align:right;" maxlength="18" class="input1"></td>
							<th>USD</th>
							<td><input type="text" name="cmpn_cost_usd_amt" dataformat="float" pointcount="2" caption="USD Amount" style="width:70px; text-align:right;" maxlength="18" class="input2" readonly id="cmpn_cost_usd_amt" /> </td>
							<th>Inter-Office No.</th>
							<td><input type="text" name="cmpn_acct_no" style="width:100px;" maxlength="20" class="input1" id="cmpn_acct_no" /> </td>
				   		</tr>
				   </tbody>
				</table>
				<table class="line_bluedot"><tr><td></td></tr></table>
				<table>
					<colgroup>
						<col width="130" />				
						<col width="*" />				
				   </colgroup> 
				   <tbody>
				   		<tr>
							<th>Remark(s)</th>
							<td><textarea name="cmpn_rmk" id="cmpn_rmk" style="width:100%; height:45px;"></textarea></td>
				   		</tr>
				   </tbody>
				</table>
				<table>
					<colgroup>
						<col width="130" />				
						<col width="*" />				
				   </colgroup> 
				   <tbody>
				   		<tr>
							<th>Update DT/ID</th>
							<td><input type="text" name="cmpn_upd_dt" id="cmpn_upd_dt" style="width:80px;" class="input2" readonly><input type="text" name="cmpn_upd_usr_id" id="cmpn_upd_usr_id" style="width:100px;" class="input2" readonly></td>
				   		</tr>
				   </tbody>
				</table>
			</div>
			<!-- opus_design_inquiry(E) -->
		</div>
		<!-- (TAB) [ Compensation ] (E) -->
		
		<!-- (TAB) [ Settlement ] (S) -->
		<div id="tabLayer" style="display:none">
			<!-- opus_design_inquiry(S) -->
			<div class="opus_design_inquiry wFit">
				<table>
					<colgroup>
						<col width="135" />				
						<col width="85" />				
						<col width="*" />				
				   </colgroup> 
				   <tbody>
				   		<tr>
							<th>Ship Owner</th>
							<th>Company</th>
							<td><input type="text" name="shp_ownr_co_nm" style="width:170px;" maxlength="200" class="input2" readonly id="shp_ownr_co_nm" /> </td>
				   		</tr>
				   </tbody>
				</table>
				<table>
					<colgroup>
						<col width="220" />				
						<col width="265" />				
						<col width="180" />				
						<col width="*" />				
				   </colgroup> 
				   <tbody>
				   		<tr>
							<th>Unsettled Inter-Office Account No.</th>
							<td><input type="text" name="ustl_acct_no_stl" style="width:170px;" maxlength="20" class="input2" readonly id="ustl_acct_no_stl" /> </td>
							<th>Running Repair Account No.</th>
							<td><input type="text" name="run_rpr_acct_no_stl" style="width:292px;" maxlength="20" class="input2" readonly id="run_rpr_acct_no_stl" /> </td>
				   		</tr>
				   </tbody>
				</table>
				<table>
					<colgroup>
						<col width="135" />				
						<col width="85" />				
						<col width="*" />				
				   </colgroup> 
				   <tbody>
				   		<tr>
							<th>Billing</th>
							<th>Invoice No.</th>
							<td><input type="text" name="bil_inv_no" style="width:170px;" maxlength="20" class="input2" readonly id="bil_inv_no" /> </td>
				   		</tr>
				   </tbody>
				</table>
				<table>
					<colgroup>
						<col width="135" />				
						<col width="85" />				
						<col width="167" />				
						<col width="37" />				
						<col width="210" />				
						<col width="30" />				
						<col width="*" />				
				   </colgroup> 
				   <tbody>
				   		<tr>
							<th>Payment</th>
							<th>Date</th>
							<td><input type="text" name="pay_dt" dataformat="ymd" caption="Payment Date" style="width:90px;" maxlength="8" class="input2" readonly id="pay_dt" /> </td>
							<th>Local</th>
							<td><input type="text" name="pay_curr_cd" style="width:70px; text-align:right;" maxlength="3" class="input" id="pay_curr_cd" /><input type="text" name="pay_locl_amt" dataformat="float" pointcount="2" caption="Local Amount" style="width:90px; text-align:right;" maxlength="18" class="input" id="pay_locl_amt" /> </td>
							<th>USD</th>
							<td><input type="text" name="pay_usd_amt" dataformat="float" pointcount="2" caption="USD Amount" style="width:70px; text-align:right;" maxlength="18" class="input2" readonly id="pay_usd_amt" /> </td>
				   		</tr>
				   </tbody>
				</table>
				<table>
					<colgroup>
						<col width="220">				
						<col width="204">				
						<col width="*">				
				   </colgroup>
				   <tbody>
				   		<tr>
							<th>Supporting</th>
							<td><button type="button" class="btn_etc" name="btn_t4Invoice" id="btn_t4Invoice">Invoice</button><input type="text" name="stl_inv_atch_knt" style="width:45px; text-align:center;" class="input" value="0" readonly id="stl_inv_atch_knt" />&nbsp;(Files)</td>
							<td><button type="button" class="btn_etc" name="btn_t4Document" id="btn_t4Document">Document</button><input type="text" name="stl_doc_atch_knt" style="width:45px; text-align:center;" class="input" value="0" readonly id="stl_doc_atch_knt" />&nbsp;(Files)</td>
				   		</tr>
				   </tbody>
				</table>
				<table>
					<colgroup>
						<col width="220" />				
						<col width="*" />				
				   </colgroup> 
				   <tbody>
				   		<tr>
							<th>Remark(s)</th>
							<td><textarea name="stl_rmk" id="stl_rmk" style="width:100%; height:45;" maxlength="500" class="input2" readonly></textarea></td>
				   		</tr>
				   </tbody>
				</table>
				<table>
					<colgroup>
						<col width="220" />				
						<col width="*" />				
				   </colgroup> 
				   <tbody>
				   		<tr>
							<th>Update DT/ID</th>
							<td><input type="text" name="stl_upd_dt" style="width:80px;" class="input2" readonly id="stl_upd_dt" /><input type="text" name="stl_upd_usr_id" style="width:100px;" class="input2" readonly id="stl_upd_usr_id" /></td>
				   		</tr>
				   </tbody>
				</table>
			</div>
			<!-- opus_design_inquiry(E) -->
		</div>
		<!-- (TAB) [ Settlement ] (E) -->
	
		<!-- hidden Grid (S)-->
		<div style="display:none">
			<!-- wrap_result(S) -->
			<div class="wrap_result">
				<!-- opus_design_grid(S) -->
				<div class="opus_design_grid">
					<!-- wrap_result(E) -->
					<script type="text/javascript">ComSheetObject('sheet1');</script>
					<script type="text/javascript">ComSheetObject('sheet2');</script>
					<script type="text/javascript">ComSheetObject('sheet3');</script>
					<script type="text/javascript">ComSheetObject('sheet4');</script>
					<script type="text/javascript">ComSheetObject('sheet5');</script>
				
				    <script type="text/javascript">ComUploadObject('upload1', '<%=session.getId()%>', 400,300);</script>
				</div>
				<!-- opus_design_grid(E) -->
			</div>	
		</div>	
		<!-- hidden Grid (E)-->
		
		<div id="uploadLayer" class="wrap_result" style="position:fixed; overflow:hidden; width:450px; height:0px; visibility:hidden;z-index:10000; background-color:#ffffff;  border-width:1px; border-color:black; border-style:solid;">
				<div class="opus_design_grid">
					<div class="opus_design_btn">
						   <button type="button" class="btn_normal" name="btn_fileAdd1" id="btn_fileAdd1">File Add</button><!-- 
						--><button type="button" class="btn_normal" name="btn_fileDel1" id="btn_fileDel1">Delete</button><!-- 
						--><button type="button" class="btn_normal" name="btn_fileClose1" id="btn_fileClose1">Close</button>
					</div>
					<script type="text/javascript">ComSheetObject('sheet7');</script>
				</div>
		</div>
	
		<div id="uploadLayer" class="wrap_result" style="position:fixed; overflow:hidden; width:450px; height:0px; visibility:hidden;z-index:10000; background-color:#ffffff;  border-width:1px; border-color:black; border-style:solid;">
				<div class="opus_design_grid">
					<div class="opus_design_btn">
						   <button type="button" class="btn_normal" name="btn_fileAdd2" id="btn_fileAdd2">File Add</button><!-- 
						--><button type="button" class="btn_normal" name="btn_fileDel2" id="btn_fileDel2">Delete</button><!-- 
						--><button type="button" class="btn_normal" name="btn_fileClose2" id="btn_fileClose2">Close</button>
					</div>
					<script type="text/javascript">ComSheetObject('sheet8');</script>
				</div>
		</div>
	
		<div id="uploadLayer" class="wrap_result" style="position:fixed; overflow:hidden; width:450px; height:0px; visibility:hidden;z-index:10000; background-color:#ffffff;  border-width:1px; border-color:black; border-style:solid;">
				<div class="opus_design_grid">
					<div class="opus_design_btn">
						   <button type="button" class="btn_normal" name="btn_fileAdd3" id="btn_fileAdd3">File Add</button><!-- 
						--><button type="button" class="btn_normal" name="btn_fileDel3" id="btn_fileDel3">Delete</button><!-- 
						--><button type="button" class="btn_normal" name="btn_fileClose3" id="btn_fileClose3">Close</button>
					</div>
					<script type="text/javascript">ComSheetObject('sheet9');</script>
				</div>
		</div>
	
		<div id="uploadLayer" class="wrap_result" style="position:absolute; overflow:hidden; width:450px; height:0px; visibility:hidden;z-index:10000; background-color:#ffffff;  border-width:1px; border-color:black; border-style:solid;">
				<div class="opus_design_grid">
					<div class="opus_design_btn">
						   <button type="button" class="btn_normal" name="btn_fileAdd4" id="btn_fileAdd4">File Add</button><!-- 
						--><button type="button" class="btn_normal" name="btn_fileDel4" id="btn_fileDel4">Delete</button><!-- 
						--><button type="button" class="btn_normal" name="btn_fileClose4" id="btn_fileClose4">Close</button>
					</div>
					<script type="text/javascript">ComSheetObject('sheet10');</script>
				</div>
		</div>
	
		<div id="uploadLayer" class="wrap_result" style="position:absolute; overflow:hidden; width:450px; height:0px; visibility:hidden;z-index:10000; background-color:#ffffff;  border-width:1px; border-color:black; border-style:solid;">
				<div class="opus_design_grid">
					<div class="opus_design_btn">
						   <button type="button" class="btn_normal" name="btn_fileAdd5" id="btn_fileAdd5">File Add</button><!-- 
						--><button type="button" class="btn_normal" name="btn_fileDel5" id="btn_fileDel5">Delete</button><!-- 
						--><button type="button" class="btn_normal" name="btn_fileClose5" id="btn_fileClose5">Close</button>
					</div>
					<script type="text/javascript">ComSheetObject('sheet11');</script>
				</div>
		</div>
	
		<div id="uploadLayer" class="wrap_result" style="position:absolute; overflow:hidden; width:450px; height:0px; visibility:hidden;z-index:10000; background-color:#ffffff;  border-width:1px; border-color:black; border-style:solid;">
				<div class="opus_design_grid">
					<div class="opus_design_btn">
						   <button type="button" class="btn_normal" name="btn_fileAdd6" id="btn_fileAdd6">File Add</button><!-- 
						--><button type="button" class="btn_normal" name="btn_fileDel6" id="btn_fileDel6">Delete</button><!-- 
						--><button type="button" class="btn_normal" name="btn_fileClose6" id="btn_fileClose6">Close</button>
					</div>
					<script type="text/javascript">ComSheetObject('sheet12');</script>
				</div>
		</div>
	
		<div id="uploadLayer" class="wrap_result" style="position:absolute; overflow:hidden; width:450px; height:0px; visibility:hidden;z-index:10000; background-color:#ffffff;  border-width:1px; border-color:black; border-style:solid;">
				<div class="opus_design_grid">
					<div class="opus_design_btn">
						   <button type="button" class="btn_normal" name="btn_fileAdd7" id="btn_fileAdd7">File Add</button><!-- 
						--><button type="button" class="btn_normal" name="btn_fileDel7" id="btn_fileDel7">Delete</button><!-- 
						--><button type="button" class="btn_normal" name="btn_fileClose7" id="btn_fileClose7">Close</button>
					</div>
					<script type="text/javascript">ComSheetObject('sheet13');</script>
				</div>
		</div>
	
		<div id="uploadLayer" class="wrap_result" style="position:absolute; overflow:hidden; width:450px; height:0px; visibility:hidden;z-index:10000; background-color:#ffffff;  border-width:1px; border-color:black; border-style:solid;">
				<div class="opus_design_grid">
					<div class="opus_design_btn">
						   <button type="button" class="btn_normal" name="btn_fileAdd8" id="btn_fileAdd8">File Add</button><!-- 
						--><button type="button" class="btn_normal" name="btn_fileDel8" id="btn_fileDel8">Delete</button><!-- 
						--><button type="button" class="btn_normal" name="btn_fileClose8" id="btn_fileClose8">Close</button>
					</div>
					<script type="text/javascript">ComSheetObject('sheet14');</script>
				</div>
		</div>
	
		<div id="uploadLayer" class="wrap_result" style="position:absolute; overflow:hidden; width:450px; height:0px; visibility:hidden; z-index:10000; background-color:#ffffff;  border-width:1px; border-color:black; border-style:solid;">
				<div class="opus_design_grid">
					<div class="opus_design_btn">
						   <button type="button" class="btn_normal" name="btn_fileAdd9" id="btn_fileAdd9">File Add</button><!-- 
						--><button type="button" class="btn_normal" name="btn_fileDel9" id="btn_fileDel9">Delete</button><!-- 
						--><button type="button" class="btn_normal" name="btn_fileClose9" id="btn_fileClose9">Close</button>
					</div>
					<script type="text/javascript">ComSheetObject('sheet15');</script>
				</div>
		</div>
		
	</div>
	<!-- wrap_result(E) -->
</div>
<!-- Developer Performance  end -->
</form>
