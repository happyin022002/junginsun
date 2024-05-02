<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : VOP_OPF_0052.jsp
*@FileTitle  : Damage Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/19
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.event.VopOpf0052Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopOpf0052Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	String strUsr_eml		= "";
	Logger log = Logger.getLogger("com.clt.apps.StevedoreDamageMgt.StevedoreDamageMgt");
	
	String vvdPortComboList ="";
	String categoryComboList ="";
	
	String mailContent = "[Concerned Office]"
	                   + "<br>OfficeCode:MailID@XXXXX.com"
	                   + "<p> ";	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		strUsr_eml = account.getUsr_eml();
	   
		event = (VopOpf0052Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		//vvdPortComboList = eventResponse.getETCData("vvdPortComboList");
		//categoryComboList = eventResponse.getETCData("categoryComboList");
		
	}catch(Exception e) {
		log.error(e.getMessage(),e);
	}
%>
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		
		loadPage('<%=strUsr_id%>','<%=strOfc_cd%>');
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="com_rdSubSysCd" value="OPF" id="com_rdSubSysCd" />
<input type="hidden" name="com_from" value="<%=strUsr_eml%>" id="com_from" />
<input type="hidden" name="com_fromName" value="" id="com_fromName" />
<input type="hidden" name="com_recipient" value="" id="com_recipient" />
<input type="hidden" name="com_carbonCopy" value="<%=strUsr_eml%>" id="com_carbonCopy" />
<input type="hidden" name="com_blindCarbonCopy" id="com_blindCarbonCopy" />
<input type="hidden" name="com_subject" value="Re:SDMS Application" id="com_subject" />
<input type="hidden" name="com_fileKey" id="com_fileKey" />
<input type="hidden" name="com_content" id="com_content" />
<input type="hidden" name="default_content" value="<%=mailContent%>" id="default_content" />
<input type="hidden" name="com_templateMrd" value="VOP_OPF_1153.mrd" id="com_templateMrd" />
<input type="hidden" name="com_templateMrdArguments" id="com_templateMrdArguments" />
<input type="hidden" name="com_templateMrdDescription" id="com_templateMrdDescription" value="UI_OPF_1153.mrd 파일이 첨부되었습니다.">
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" 		id="btn_Retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_New" 			id="btn_New">New</button><!--
		--><button type="button" class="btn_normal" name="btn_Delete"  		id="btn_Delete">Delete</button><!--
		--><button type="button" class="btn_normal" name="btn_Save" 		id="btn_Save">Save</button><!--
		--><button type="button" class="btn_normal" name="btn_Mail"  		id="btn_Mail">Mail</button>	
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<div style="display:none">
	<div class="wrap_search">
		<div class="opus_design_grid clear" >
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
</div>

<!-- opus_design_inquiry(S) -->
<div class= "wrap_search">
	<div class= "opus_design_inquiry">
		<table>
			<tbody>
				<tr>
					<th width="60">VVD CD</th>
					<td width="150">
						<input id="vsl_cd" name="vsl_cd" required fullfill="" style="width: 55px;" class="input1" value="" caption="VVD CD" maxlength="4" dataformat="engup" type="text" /><!--
					 --><input id="skd_voy_no" name="skd_voy_no" required fullfill="" style="width:40px;" class="input1" value="" caption="VVD CD" maxlength="4" dataformat="num" type="text" /><!--
					 --><input id="skd_dir_cd" name="skd_dir_cd" required fullfill="" style="width:20px;" class="input1" value="" caption="VVD CD" maxlength="1" type="text" dataformat="enguponly"/><!--
					 --><button type="button" id="vsl_cd_pop" name="vsl_cd_pop" class="input_seach_btn"></button>
					    <input type="hidden" style="width:0px;" name="noname" id="noname" /> </td>
					<th width="30">Port</th>
					<td width="60"><script type="text/javascript">ComComboObject('vps_port_cd', 3, 102, 1, 1);</script></td>
					<th width="85">Damage Date</th>
					<td width="110"><input type="text" style="width:75px;" class="input1" dataformat="ymd" name="stv_dmg_evnt_dt" caption="Damage Date" required="" id="stv_dmg_evnt_dt" /><button type="button" id="btn_stv_dmg_evnt_dt" name="btn_stv_dmg_evnt_dt" class="calendar ir"></button></td>
					<th width="30">Lane</th>
					<td width="60"><input type="text" style="width:50px;" class="input2" name="slan_cd" readonly id="slan_cd" /> </td>
					<th width="60">Vessel Category</th>
					<td><script type="text/javascript">ComComboObject('vsl_oshp_cntr_blk_tp_cd',1,150,1,1,0);</script></td>
				</tr>	
				<tr>
					<th>SDMS No.</th>
					<td colspan="7"><input type="text" name="stv_dmg_no" maxlength="11" style="width:110px;ime-mode:disabled;" class="input" id="stv_dmg_no" dataformat="engup" /> </td>
					<th>Damage Category</th>
					<td><script type="text/javascript">ComComboObject('stv_dmg_prt_cate_cd',1,150,1,1,0);</script></td>
				</tr>
			</tbody>
		</table>
		<!-- phia duoi-->
		<table><tr><td colspan="10" class="line_bluedot"></td></tr></table>
		<table>
			<tbody>
				<colgroup>
					<col width="180"/>
					<col width="100"/>
					<col width="60"/>
					<col width="100"/>
					<col width="60"/>
					<col width="60"/>
					<col width="60"/>
					<col width="60"/>
					<col width="60"/>
					<col width="*"/>
			    </colgroup>
				<tr style="display:none">
					<td colspan="10">Seq.<input type="text" name="seq" style="width:25px;" class="input2" readonly id="seq" />of<input type="text" name="seq_total" style="width:25px;" class="input2" readonly id="seq_total" /> </td>
				</tr>	
				<tr>
					<th>Report No. (If any at SDR)</th>
					<td colspan="2"><input type="text" style="width:120px;ime-mode:disabled;" maxlength="20" class="input" name="stv_dmg_ref_no" id="stv_dmg_ref_no" /> </td>
					<th>Claim Handling Office</th>
					<td colspan="6"><input type="text" style="width:152px;ime-mode:disabled;" maxlength="6" class="input1" name="clm_hndl_ofc_cd" caption="Claim Handling Office" required="" id="clm_hndl_ofc_cd"  dataformat="engup" /><button type="button" id="clm_hndl_ofc_cd_pop" name="clm_hndl_ofc_cd_pop" class="input_seach_btn"></button></td>
				</tr>
				<tr>
					<th>Part</th>
					<td colspan="2"><script type="text/javascript">ComComboObject('stv_dmg_prt_cd',2,240,1,1,1);</script></td>
					<th>Damage</th>
					<td colspan="6"><script type="text/javascript">ComComboObject('stv_dmg_tp_cd',2,180,1,0,1);</script></td>
				</tr>
				<tr>
					<th>Location / Size / Qty</th>
					<td colspan="9"><input type="text" style="width:865px;ime-mode:disabled;" class="input" name="stv_dmg_loc_desc" maxlength="500" id="stv_dmg_loc_desc" /> </td>
				</tr> 
				<tr>
					<th>Supporting</th>
					<td>
						<button type="button" class="btn_etc" name="btn_SDR" id="btn_SDR">SDR</button>
						<div id="uploadLayer1" style="position:absolute;background-color:#ffffff;top:190px;width:485px; height:223px; visibility:hidden; overflow-y:auto; overflow-x:hidden; border-width:1px; border-color:black; border-style:solid; z-index:999px;">
							<div class="wrap_result">
								<div class="opus_design_grid" id="mainTable">
									<div class="opus_design_btn">
										   <button type="button" class="btn_normal" name="btn_fileAdd1" id="btn_fileAdd1">File Add</button><!-- 
										--><button type="button" class="btn_normal" name="btn_fileDel1" id="btn_fileDel1">Delete</button><!--
										--><button type="button" class="btn_normal" name="btn_fileClose1" id="btn_fileClose1" onclick="showHideLayers('SDR')">Close</button>
									</div>
									<script type="text/javascript">ComSheetObject('sheet2');</script>
								</div>
							</div>
						</div>
						<input type="text" name="stv_dmg_rpt_atch_flg" style="width:50px; text-align:center;" class="input" value="0" id="stv_dmg_rpt_atch_flg" />(Files)</td>
					<td>
						<button type="button" class="btn_etc" name="btn_Picture" id="btn_Picture">Picture</button>
						<div id="uploadLayer2" style="position:absolute;background-color:#ffffff;top:190px;width:485px; height:223px; visibility:hidden; overflow-y:auto; overflow-x:hidden; border-width:1px; border-color:black; border-style:solid; z-index:999px;">
							<div class="wrap_result">
								<div class="opus_design_grid" id="mainTable">
									<div class="opus_design_btn">
										   <button type="button" class="btn_normal" name="btn_fileAdd2" id="btn_fileAdd2">File Add</button><!-- 
										--><button type="button" class="btn_normal" name="btn_fileDel2" id="btn_fileDel2">Delete</button><!--
										--><button type="button" class="btn_normal" name="btn_fileClose2" id="btn_fileClose2" onclick="showHideLayers('PIC')">Close</button>
									</div>
									<script type="text/javascript">ComSheetObject('sheet3');</script>
								</div>
							</div>
						</div>
						<input type="text" name="stv_dmg_pict_atch_flg" style="width:50px; text-align:center;" class="input" value="0" readonly id="stv_dmg_pict_atch_flg" />(Files)</td>
					<td></td>
					<td colspan="6">
						<button type="button" class="btn_etc" name="btn_Document" id="btn_Document">Document</button>
						<div id="uploadLayer3" style="position:absolute;background-color:#ffffff;top:190px;width:485px; height:223px; visibility:hidden; overflow-y:auto; overflow-x:hidden; border-width:1px; border-color:black; border-style:solid; z-index:999px;">
							<div class="wrap_result">
								<div class="opus_design_grid" id="mainTable">
									<div class="opus_design_btn">
										   <button type="button" class="btn_normal" name="btn_fileAdd3" id="btn_fileAdd3">File Add</button><!-- 
										--><button type="button" class="btn_normal" name="btn_fileDel3" id="btn_fileDel3">Delete</button><!--
										--><button type="button" class="btn_normal" name="btn_fileClose3" id="btn_fileClose3" onclick="showHideLayers('DOC')">Close</button>
									</div>
									<script type="text/javascript">ComSheetObject('sheet4');</script>
								</div>
							</div>
						</div>
						<input type="text" name="stv_dmg_doc_atch_flg" style="width:50px; text-align:center;" class="input" value="0" readonly id="stv_dmg_doc_atch_flg" />(Files)</td>
				</tr>
				<tr>
					<th>Related Damage</th>
					<td colspan="2" class="wrap_search_btn" ><input type="checkbox" class="trans" name="cntr_dmg_flg" id="cntr_dmg_flg" value="Y"> Damage on Container&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp<!--
						--><input type="checkbox" class="trans" name="cgo_dmg_flg" id="cgo_dmg_flg" value="Y"> Damage on Cargo
					</td>
					<th>CNTR No.</th>
					<td colspan="6"><input type="text" style="width:135px;ime-mode:disabled;" class="input" maxlength="14" name="cntr_no" id="cntr_no" dataformat="engup"/> </td>
				</tr>
				<tr>
					<th>Time Loss (Hours)</th>
					<td><input type="text" style="width:50px;" class="input2" name="time_loss_hours" readonly id="time_loss_hours" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>From (GMT)<b></td>
					<td><input type="text" style="width:135px;" class="input" name="fm_tm_lss_dt" caption="From Loss Hour" maxlength="12" dataformat="ymdhm" id="fm_tm_lss_dt" /> 
					<th>To (GMT)</th>
					<td colspan="5"><input type="text" style="width:135px;" class="input" name="to_tm_lss_dt" caption="To Loss Hour" maxlength="12" dataformat="ymdhm" id="to_tm_lss_dt" /> </td>
				</tr> 
				<tr>
					<th>Remark(s)</th>
					<td colspan="9"><textarea style="width:865px; height:45;ime-mode:disabled;" name="stv_dmg_rmk" id="stv_dmg_rmk"></textarea></td>
				</tr> 
				<tr><td colspan="10" class="line_bluedot"></td></tr>
				<tr>
					<th>Requirement</th>
					<td colspan="2" class="wrap_search_btn"><input type="radio" class="trans" name="stv_dmg_req_cate_cd" value="R" checked="" id="stv_dmg_req_cate_cd" />  Repair&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<!--
						--><input type="radio" class="trans" name="stv_dmg_req_cate_cd" value="S" id="stv_dmg_req_cate_cd" />  Supply&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<!--
						--><input type="radio" class="trans" name="stv_dmg_req_cate_cd" value="Q" id="stv_dmg_req_cate_cd" />  Quotation
					</td>
					<th>Voyage No.</th>
					<td><input type="text" style="width:53px;ime-mode:disabled;" maxlength="5" class="input" name="req_skd_voy_dir" id="req_skd_voy_dir" dataformat="engup"/><button type="button" id="req_skd_voy_dir_pop" name="req_skd_voy_dir_pop" class="input_seach_btn"></button><input type="hidden" name="noname" style="width:0px;" id="noname" /> </td>
					<th>Port</th>
					<td colspan="4"><input type="text" style="width:70px;ime-mode:disabled;" maxlength="5" class="input" name="req_port_cd" id="req_port_cd" dataformat="engup" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>ETA</b>&nbsp;&nbsp;<input type="text" style="width:75px;" maxlength="8" class="input" dataformat="ymd" name="req_eta_dt" id="req_eta_dt" /><button type="button" id="btn_req_eta_dt" name="btn_req_eta_dt" class="calendar ir"></button></td>
				</tr> 
				<tr>
					<th colspan="4">Reason</th>
					<td colspan="6">
						<script type="text/javascript">ComComboObject('stv_dmg_qttn_rsn_desc',2,98,1,1,0);</script><input type="text" style="width:289px;" class="input2" maxlength="500" name="req_reason_desc" id="req_reason_desc" readOnly>
					</td>
				</tr>
				<tr><td colspan="10" class="line_bluedot"></td></tr>
				<tr>
					<th>Responsible Party</th>
					<td colspan="2" class="wrap_search_btn">
						<input type="radio" class="trans"  name="stv_dmg_respb_pty_kwn_flg" id="stv_dmg_respb_pty_kwn_flg" value="Y" checked>  Known&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<!--
						--><input type="radio" class="trans"  name="stv_dmg_respb_pty_kwn_flg" id="stv_dmg_respb_pty_kwn_flg" value="N">  Unknown</td>
						
					<th>Details</th>
					<td colspan="7"><input type="text" style="width:391px;ime-mode:disabled;" maxlength="500" class="input1" name="stv_dmg_respb_desc_dtl" id="stv_dmg_respb_desc_dtl"></td>
				</tr>
				<tr>
					<th colspan="4">Reason</th>
					<td colspan="6">
						<script type="text/javascript">ComComboObject('stv_dmg_respb_desc',2,98,1,1,0);</script><input type="text" style="width:289px;" class="input2" maxlength="500" name="res_reason_desc" id="res_reason_desc" readOnly>
					</td>
				</tr>
				<tr><td colspan="10" class="line_bluedot"></td></tr>
				<tr>
					<td colspan="10" style="padding-left:757px;">
						<input type="text" style="width:50px;font-weight:bold;text-align:center;" class="input2" maxlength="1" name="dmg_auth_sts_cd" value="X" readonly id="dmg_auth_sts_cd" /><!--
						--><input type="text" style="width:70px;font-weight:bold;" class="input2" maxlength="20" name="auth_usr_id" readonly id="auth_usr_id" /><!--
						--><input type="text" style="width:85px;font-weight:bold;" class="input2" name="auth_dt" readonly id="auth_dt" /><!--
						--><button type="button" class="btn_etc" name="btnApproval" id="btnApproval">Approval</button></td>
				</tr>
			</tbody>
		</table>
		
		
		
		
	</div>
</div>
<div style="display:none">
	<!-- opus_design_grid(S) -->
	<div class="wrap_result">
		<div class="opus_design_grid clear" >
			<script type="text/javascript">ComUploadObject('upload1', '<%=session.getId()%>');</script>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>
