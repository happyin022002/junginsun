<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_SCG_0018.jsp
*@FileTitle  : Reefer CGO Application Details for Own BKG
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/20
*=========================================================
*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.event.VopScg0018Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopScg0018Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strBkgNo 	= request.getParameter("bkg_no");
	String strVvdCd 	= request.getParameter("vvd_cd");
	String strCgoSeq 	= request.getParameter("rc_seq");
	String strRqstSeq 	= request.getParameter("spcl_cgo_apro_rqst_seq");
	String strRow 		= request.getParameter("row");
	String strScgFlg	= request.getParameter("scg_flg");
	String strType		= request.getParameter("type");
	Logger log = Logger.getLogger("com.clt.apps.CargoLoadingApproval.OwnDangerousCargoApproval");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopScg0018Event)request.getAttribute("Event");
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
		
		var toDay = new Date();
	    var year  = toDay.getFullYear();
	    var month = toDay.getMonth() + 1;
	    var day   = toDay.getDate();
	    var hours = toDay.getHours();
	    var minutes = toDay.getMinutes();
	    if(month < 10) month = '0' + month;
	    if(day < 10) day = '0' + day;
	    if(hours < 10) hours = '0' + hours;
	    if(minutes < 10) minutes = '0' + minutes;
	    //var toDays = year + '-' + month + '-' + day + ' ' + hours + ':' + minutes;
	    var toDays = year + '-' + month + '-' + day;
		document.form.auth_usr_id.value = '<%=strUsr_id%>';
		document.form.vvd_cd.value = '<%=StringUtil.xssFilter(strVvdCd)%>';
		document.form.vsl_cd.value = '<%=StringUtil.xssFilter(strVvdCd.substring(0,4))%>';
		document.form.skd_voy_no.value = '<%=StringUtil.xssFilter(strVvdCd.substring(4,8))%>';
		document.form.skd_dir_cd.value = '<%=StringUtil.xssFilter(strVvdCd.substring(8,9))%>';
		document.form.auth_dt.value = toDays;
		
		loadPage();
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="temp_cntr_no" id="temp_cntr_no" />
<input type="hidden" name="temp_grs_wgt" id="temp_grs_wgt" />
<input type="hidden" name="temp_net_wgt" id="temp_net_wgt" />
<input type="hidden" name="cntr_tpsz_cd" id="cntr_tpsz_cd" />

<input type="hidden" name="rc_seq" value="<%=StringUtil.xssFilter(strCgoSeq) %>" id="rc_seq" />
<input type="hidden" name="spcl_cgo_apro_rqst_seq" value="<%=StringUtil.xssFilter(strRqstSeq) %>" id="spcl_cgo_apro_rqst_seq" />
<input type="hidden" name="row" value="<%=StringUtil.xssFilter(strRow) %>" id="row" />
<input type="hidden" name="scg_flg" value="<%=StringUtil.xssFilter(strScgFlg) %>" id="scg_flg" />
<input type="hidden" name="type" value="<%=StringUtil.xssFilter(strType) %>" id="type" />

<input type="hidden" name="bkg_por_cd" id="bkg_por_cd" />
<input type="hidden" name="bkg_por_yd_cd" id="bkg_por_yd_cd" />
<input type="hidden" name="bkg_del_cd" id="bkg_del_cd" />
<input type="hidden" name="bkg_del_yd_cd" id="bkg_del_yd_cd" />
<input type="hidden" name="org_trns_mod_cd" id="org_trns_mod_cd" />
<input type="hidden" name="dest_trns_mod_cd" id="dest_trns_mod_cd" />

<input type="hidden" name="bkg_pol_cd" id="bkg_pol_cd" />
<input type="hidden" name="bkg_pol_yd_cd" id="bkg_pol_yd_cd" />
<input type="hidden" name="bkg_pod_cd" id="bkg_pod_cd" />
<input type="hidden" name="bkg_pod_yd_cd" id="bkg_pod_yd_cd" />

<input type="hidden" name="vsl_cd" id="vsl_cd" />
<input type="hidden" name="skd_voy_no" id="skd_voy_no" />
<input type="hidden" name="skd_dir_cd" id="skd_dir_cd" />
<input type="hidden" name="mailYn" value="N" id="mailYn" />

<input type="hidden" name="org_spcl_cgo_auth_cd" id="org_spcl_cgo_auth_cd" />

<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title">Reefer CGO Application Details for Own BKG</h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn_ApprovalDetails" id="btn_ApprovalDetails" type="button">Approval Details</button><!--
			--><button class="btn_normal" name="btn_Mail" id="btn_Mail" type="button">Mail</button><!--
			--><button class="btn_normal" name="btn_Prev" id="btn_Prev" type="button">Prev.</button><!--
			--><button class="btn_normal" name="btn_Next" id="btn_Next" type="button">Next</button><!--
			--><button class="btn_normal" name="btn_Close" id="btn_Close" type="button">Close</button>
		</div>
		<!-- opus_design_btn (E) -->
	</div>
	<!-- page_title_area(E) -->
</div>

<div class="layer_popup_contents" style="overflow:hidden;">
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<!-- layout_wrap(S) -->
			<div class="layout_wrap">
			    <div class="layout_vertical_2">
			    	<table>
						<colgroup>
							<col width="50">
							<col width="115">
							<col width="50">
							<col width="*">
						</colgroup>
						<tbody>
							<tr>
								<th>BKG No.</th>
								<td><input type="text" name="bkg_no" id="bkg_no" style="width:100px;" class="input2" readOnly value="<%=StringUtil.xssFilter(strBkgNo) %>"></td>
								<th>B/L No.</th>
								<td><input type="text" name="bl_no" id="bl_no" style="width:100px;" class="input2" readOnly value=""></td> 
							</tr>
						</tbody>
					</table>
			    	<table>
						<colgroup>
							<col width="50">
							<col width="115">
							<col width="50">
							<col width="80">
							<col width="50">
							<col width="*">
						</colgroup>
						<tbody>
							<tr>
								<th>VVD CD</th>
								<td><input type="text" 		name="vvd_cd" id="vvd_cd" style="width:100px;" class="input2" readOnly value=""></td>
								<th title="Port of Loading">POL</th>
								<td><input type="text" 		name="pol_cd" id="pol_cd" style="width:50px;" class="input2" readOnly value=""><!--  
									--><input type="text" 	name="pol_nod_cd" id="pol_nod_cd" style="width:25px;" class="input2" readonly value=""></td>
								<th title="Port of Discharging">POD</th>
								<td><input type="text"  	name="pod_cd" id="pod_cd" style="width:50px;" class="input2" readOnly value=""><!--  
									--><input type="text"	name="pod_nod_cd" id="pod_nod_cd" style="width:25px;" class="input2" readonly value=""></td>
							</tr>
						</tbody>
					</table>
			    </div>
			    <div class="layout_vertical_2">
			    	<table>
						<colgroup>
							<col width="60">
							<col width="235">
							<col width="65">
							<col width="*">
						</colgroup>
						<tbody>
							<tr>
								<th>BKG.Staff</th>
								<td><input type="text" 	name="rqst_usr_nm" id="rqst_usr_nm" style="width:150px;" class="input2" readOnly value=""><!--  
									--><input type="text" 	name="rqst_usr_id" id="rqst_usr_id" style="width:70px;" class="input2" readonly value="">
								</td>
								<th>BKG.Office</th>
								<td><input type="text" 		name="rqst_ofc_cd" id="rqst_ofc_cd" style="width:50px;" class="input2" readOnly value=""></td>
							</tr>
						</tbody>
					</table>
			    	<table>
						<colgroup>
							<col width="168">
							<col width="*">
						</colgroup>
						<tbody>
							<tr>
								<th style="text-align:left">Requested Date (GMT)</th>
								<td><input type="text" name="rqst_gdt" id="rqst_gdt" style="width:111px;" class="input2" readOnly value=""></td>
							</tr>
						</tbody>
					</table>
			    	<table>
						<colgroup>
							<col width="25">
							<col width="135">
							<col width="45">
							<col width="*">
						</colgroup>
						<tbody>
							<tr>
								<th>Tel.</th>
								<td><input type="text" name="rqst_usr_phn_no" id="rqst_usr_phn_no" style="width:120px;" class="input2" readOnly value=""></td>
								<th>E-mail</th>
								<td><input type="text" name="rqst_usr_eml" id="rqst_usr_eml" style="width:205px;" class="input2" readOnly value=""></td>
							</tr>
						</tbody>
					</table>
			    </div>
			</div>
			<!-- layout_wrap(E) -->
		</div>
		<div class="opus_design_inquiry"><table class="line_bluedot"><tr><td></td></tr></table></div>
		<!-- opus_design_inquiry(E) -->
	</div>
	<div class="wrap_result">
		<div class="opus_design_inquiry">
			<!-- layout_wrap(S) -->
			<div class="layout_wrap">
			    <div class="layout_vertical_2" style="width:320px;padding-right:10px;">
			    	<div class="opus_design_grid" id="mainTable">
			    		<script type="text/javascript">ComSheetObject('sheet1');</script>
			    	</div>
			    	<div class="opus_design_grid" id="mainTable">
			    		<script type="text/javascript">ComSheetObject('sheet2');</script>
			    	</div>
			    	<div class="opus_design_grid" id="mainTable">
			    		<script type="text/javascript">ComSheetObject('sheet3');</script>
			    	</div>
			    	<div class="opus_design_grid" id="mainTable">
			    		<script type="text/javascript">ComSheetObject('sheet4');</script>
			    	</div>
			    	<div class="opus_design_grid" id="mainTable">
			    		<script type="text/javascript">ComSheetObject('sheet5');</script>
			    	</div>
			    </div>
			    <div class="layout_vertical_2">
			    	<table style="width:660px;">
						<colgroup>
							<col width="175">
							<col width="170">
							<col width="170">
							<col width="*">
						</colgroup>
						<tbody>
							<tr>
								<th style="text-align:left">Application Total Package</th>
								<td><input type="text" 		name="package_sum" id="package_sum" style="width:75px; text-align:right;" class="input2" readonly value=""><!--  
									--><input type="text" 	name="pck_type_cd" id="pck_type_cd" style="width:25px;text-align:center;" class="input2" readonly value=""></td>
								<th>Application Total Weight</th>
								<td><input type="text" 		name="weight_sum" id="weight_sum" style="width:120px; text-align:right;" class="input2" readonly value=""><!--  
									--><input type="text" 	name="wgt_ut" id="wgt_ut" style="width:35px;text-align:center;" class="input2" readonly value=""></td>
							</tr>
						</tbody>
					</table>
					<table class="line_bluedot" style="width:100%"><tr><td></td></tr></table>
					<table style="width:660px;">
						<colgroup>
							<col width="*">
						</colgroup>
						<tbody>
							<tr>
								<th style="text-align:left">Cargo Detail for Container Sequence &nbsp;&nbsp;&nbsp;<input type="text" name="seq" id="seq" style="width:25px;text-align:center;" class="input2" readOnly value="<%=strCgoSeq %>"></th>
							</tr>
						</tbody>
					</table>
					<table style="width:660px;">
						<colgroup>
							<col width="115">
							<col width="*">
						</colgroup>
						<tbody>
							<tr>
								<th style="text-align:left">Commodity</th>
								<td><input type="text" name="cmdt_cd" id="cmdt_cd" style="width:50px;" class="input2" readOnly value=""><!--  
									--><input type="text" name="cmdt_nm" id="cmdt_nm" style="width:355px;" class="input2" readOnly value=""><!--  
									--><button type="button" class="input_seach_btn" name="btns_Commodity" id="btns_Commodity"></button>
								</td>
							</tr>
						</tbody>
					</table>
					<table style="width:660px;">
						<colgroup>
							<col width="115">
							<col width="285">
							<col width="60">
							<col width="*">
						</colgroup>
						<tbody>
							<tr>
								<th style="text-align:left">Temperature</th>
								<td><input type="text" 		name="cdo_temp" id="cdo_temp" style="width:40px; text-align:right;" class="input2" readOnly value="">&nbsp;<strong>&deg;C</strong>&nbsp;&nbsp;&nbsp;<!--  
									--><input type="text" 	name="fdo_temp" id="fdo_temp" style="width:40px; text-align:right;" class="input2" readOnly value="">&nbsp;<strong>&deg;F</strong>
								</td>
								<th>Nature</th>
								<td><select name="clng_tp_cd" id="clng_tp_cd" style="width:93px;" class="input2" disabled >
										<option value="" ></option>
										<option value="S" >Fresh</option>
										<option value="C" >Chilled</option>
										<option value="F" >Frozen</option>
									</select>
								</td>
							</tr>
							<tr>
								<th style="text-align:left">Ventilation</th>
								<td><input type="text" name="vent_rto" id="vent_rto" style="width:55px; text-align:right;" class="input2" readonly value=""><!--  
									--><select name="cntr_vent_tp_cd" id="cntr_vent_tp_cd" style="width:79px;" class="input2" disabled>
										<option value="" ></option>
										<option value="P" >% Open</option>
										<option value="C" >CMH</option>
									</select>
								</td>
								<th>Humidity</th>
								<td><input type="text" name="humid_no" id="humid_no" style="width:69px; text-align:right;" class="input2" readonly value="">&nbsp;<strong>%</strong></td>
							</tr>
						</tbody>
					</table>
					<table style="width:660px;">
						<colgroup>
							<col width="115">
							<col width="275">
							<col width="150">
							<col width="*">
						</colgroup>
						<tbody>
							<tr>
								<th style="text-align:left">Package</th>
								<td><input type="text" name="pck_qty" id="pck_qty" style="width:55px; text-align:right;" class="input2" readonly value=""><!--  
									--><input type="text" name="pck_tp_cd" id="pck_tp_cd" style="width:35px;text-align:center;" class="input2" readonly value=""><!--  
									--><button type="button" class="input_seach_btn" name="btns_Package" id="btns_Package"></button>
								</td>
								<th style="text-align:left;"><input type="checkbox" name="ctrl_atms_flg" id="ctrl_atms_flg" class="trans" disabled> <label for="ctrl_atms_flg">Control Atmosphere (CA)</label></th>
								<td></td>
							</tr>
							<tr>
								<th style="text-align:left">Gross Weight</th>
								<td><input type="text" name="grs_wgt" id="grs_wgt" style="width:144px; text-align:right;" class="input2" readonly value=""><!--  
									--><select name="wgt_ut_cd1" id="wgt_ut_cd1" style="width:65px;" class="input2" disabled>
										<option value="" ></option>
										<option value="KGS" >KGS</option>
										<option value="LBS" >LBS</option>
									</select>
								</td> 
								<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;O2 <input type="text" name="oxgn_rto" id="oxgn_rto" style="width:40px; text-align:right;" class="input2" readonly value="">%   
								    &nbsp;&nbsp;CO2 <input type="text" name="crbn_dxd_rto" id="crbn_dxd_rto" style="width:40px; text-align:right;" class="input2" readonly value="">%</th>
								<td></td>
							</tr>
							<tr>
								<th style="text-align:left">Net Weight</th>
								<td><input type="text" name="net_wgt" id="net_wgt" style="width:144px; text-align:right;" class="input2" readonly value=""><!--  
									--><select name="wgt_ut_cd2" id="wgt_ut_cd2" style="width:65px;" class="input2" disabled>
										<option value="" ></option>
										<option value="KGS" >KGS</option>
										<option value="LBS" >LBS</option>
									</select>
								</td>
								<th style="text-align:left;"><input type="checkbox" name="modi_atms_flg" id="modi_atms_flg" class="trans" disabled> <label for="modi_atms_flg">Modified CA (MA)</label></th>
								<td></td>
							</tr>
							<tr>
								<th style="text-align:left">DG container S/N</th>
								<th style="text-align:left"><input type="text" name="rf_dcgo_seq" id="rf_dcgo_seq" style="width:65px; text-align:right;" class="input2" readonly value=""><!--  
									--><button type="button" class="input_seach_btn" name="btns_DgCntrSeq" id="btns_DgCntrSeq"></button>
									<span style="margin-left:11px;">Drain</span>
									<select name="cntr_drn_cd" id="cntr_drn_cd" style="width:65px;" class="input2" disabled>
										<option value="" ></option>
										<option value="N" >N/A</option>
										<option value="O" >Open</option>
										<option value="C" >Close</option>
									</select>
								</th>	
								<th style="text-align:left;"><input type="checkbox" name="humid_ctrl_flg" id="humid_ctrl_flg" class="trans" disabled><label for="humid_ctrl_flg">Humidity Control (HM)</label></th>
								<td></td>
							</tr>
						</tbody>
					</table>
					<table style="width:660px;">
						<colgroup>
							<col width="115">
							<col width="*">
						</colgroup>
						<tbody>
							<tr>
				       			<th style="text-align:left">Sensitive Cargo</th>
								<td><select name="sns_cgo_knd_cd" id="sns_cgo_knd_cd" style="width:100px;" class="input2" disabled>
										<option value="" ></option>
										<option value="B" >Blood Plasma</option>
										<option value="I" >Ice Cream</option>
										<option value="U" >USDA</option>
									</select></td>						
							</tr>
						</tbody>
					</table>					
					<table style="width:660px;">
						<colgroup>
							<col width="115">
							<col width="*">
						</colgroup>
						<tbody>
							<tr>
				       			<th style="text-align:left">Remark(s)</th>
								<td><input type="text" name="diff_rmk" id="diff_rmk" style="width:100%;" class="input2" readonly value=""></td>						
							</tr>
						</tbody>
					</table>
			    </div>
			</div>
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			<!-- layout_wrap(E) -->
			<table style="width:979px;">
				<colgroup>
					<col width="110">
					<col width="135">
					<col width="70">
					<col width="100">
					<col width="70">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th style="text-align:left">Approval by</th>
						<td><input type="text" name="auth_usr_id" id="auth_usr_id" style="width:100px;" class="input1" readonly value=""></td>
						<th>Date (GMT)</th>
						<td colspan="3"><input type="text" name="auth_dt" id="auth_dt" style="width:80px;" class="input1" readonly value=""></td> 
					</tr>
					<tr>
						<th style="text-align:left">Approval</th>
						<td><select name="spcl_cgo_auth_cd" id="spcl_cgo_auth_cd" style="width:100px;" class="input1" style="font-weight:bold;" onchange="auth_OnChange()">
								<option value="Y" style="color:green;">Y</option>
								<option value="A" style="color:green;">Y(all)</option>
								<option value="N" style="color:red;">N</option>
								<option value="P" style="color:blue;">P</option>
								<option value="" style="color:orange;"></option>
							</select></td>
						<th>RJT Code</th>
						<td><script type="text/javascript">ComComboObject('spcl_cgo_auth_rjct_cd', 2, 80, 0, 2);</script></td>
						<th>Remark(s)</th>
						<td><input type="text" name="spcl_cgo_auth_rmk" id="spcl_cgo_auth_rmk" style="width:100%;" class="input" value=""></td>
					</tr>
				</tbody>
			</table>
			<table style="width:979px;">
				<colgroup>
					<col width="110">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th style="text-align:left">Approval Ref. No.</th>
						<td><input type="text" name="apro_ref_no" id="apro_ref_no" style="width:378px;" class="input2" value="" maxlength="50" disabled></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>

</form>
