<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_SCG_0017.js
*@FileTitle  : Break-Bulk CGO Application Details for Own BKG
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
<%@ page import="com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.event.VopScg0017Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopScg0017Event  event = null;				//PDTO(Data Transfer Object including Parameters)
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
	String strCgoSeq 	= request.getParameter("bb_cgo_seq");
	String strRqstSeq 	= request.getParameter("spcl_cgo_apro_rqst_seq");
	String strRow 		= request.getParameter("row");
	String strScgFlg	= request.getParameter("scg_flg");
	String strType		= request.getParameter("type");
	Logger log = Logger.getLogger("com.clt.apps.CargoLoadingApproval.OwnDangerousCargoApproval");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopScg0017Event)request.getAttribute("Event");
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
		document.form.auth_dt.value = toDays;
		
		loadPage();
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="bb_cgo_seq" value="<%=StringUtil.xssFilter(strCgoSeq) %>" id="bb_cgo_seq" />
<input type="hidden" name="spcl_cgo_apro_rqst_seq" value="<%=StringUtil.xssFilter(strRqstSeq) %>" id="spcl_cgo_apro_rqst_seq" />
<input type="hidden" name="row" value="<%=StringUtil.xssFilter(strRow) %>" id="row" />
<input type="hidden" name="scg_flg" value="<%=StringUtil.xssFilter(strScgFlg) %>" id="scg_flg" />
<input type="hidden" name="type" value="<%=StringUtil.xssFilter(strType) %>" id="type" />

<input type="hidden" name="temp_cntr_no" id="temp_cntr_no" />
<input type="hidden" name="cntr_tpsz_cd" id="cntr_tpsz_cd" />
<input type="hidden" name="temp_grs_wgt" id="temp_grs_wgt" />
<input type="hidden" name="temp_net_wgt" id="temp_net_wgt" />

<input type="hidden" name="mailYn" value="N" id="mailYn" />
<input id="isInquiry" name="isInquiry" value="N" type="hidden" />
<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Break-Bulk CGO Application Details for Own BKG</span></h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn_ApprovalDetails" id="btn_ApprovalDetails" type="button">Approval Details</button><!--
			--><button type="button" class="btn_normal" name="btn_attach" id="btn_attach">Attach File</button><!--
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
		<div class="opus_design_inquiry">
			<!-- layout_wrap(S) -->
			<div class="layout_wrap">
			    <div class="layout_vertical_2" style="width:650px;">
			    	<table style="width:610px;">
						<colgroup>
							<col width="50">
							<col width="115">
							<col width="50">
							<col width="*">
						</colgroup>
						<tbody>
							<tr>
								<th>BKG No.</th>
								<td><input type="text" name="bkg_no" id="bkg_no" style="width:100px;" class="input2" readonly value="<%=StringUtil.xssFilter(strBkgNo) %>"></td>
								<th>B/L No.</th>
								<td><input type="text" name="bl_no" id="bl_no" style="width:100px;" class="input2" readonly value=""></td> 
							</tr>
						</tbody>
					</table>
					<table style="width:645px;">
						<colgroup>
							<col width="50">
							<col width="115">
							<col width="50">
							<col width="150">
							<col width="0">
							<col width="30">
							<col width="90">
							<col width="*">
						</colgroup>
						<tbody>
							<tr>
								<th>VVD CD</th>
								<td><input type="text" 		name="vvd_cd" id="vvd_cd" style="width:100px;" class="input2" readonly value=""></td>
								<th title="Port of Loading">POL</th>
								<td><input type="text" 		name="pol_cd" id="pol_cd" style="width:50px;" class="input2" readonly value=""><!--  
									--><input type="text" 	name="pol_nod_cd" id="pol_nod_cd" style="width:25px;" class="input2" readonly value=""><!-- 
									--><button class="btn_etc" name="btn_PolCd" id="btn_PolCd">Info.</button></td>
								<td></td>
								<th title="Port of Discharging">POD</th>
								<td><input type="text"  	name="pod_cd" id="pod_cd" style="width:50px;" class="input2" readonly value=""><!--  
									--><input type="text" 	name="pod_nod_cd" id="pod_nod_cd"  style="width:25;" class="input2" readonly value=""><!-- 
									--><button class="btn_etc" name="btn_PodCd" id="btn_PodCd">Info.</button></td>
								<td></td>
							</tr>
						</tbody>
					</table>
			    </div>
			    <div class="layout_vertical_2">
			    	<table style="width:500px;">
						<colgroup>
							<col width="65">
							<col width="305">
							<col width="65">
							<col width="*">
						</colgroup>
						<tbody>
							<tr>
								<th>BKG.Staff</th>
								<td><input type="text" 		name="rqst_usr_nm" id="rqst_usr_nm" style="width:150px;" class="input2" readOnly value=""><!--  
									--><input type="text" 	name="rqst_usr_id" id="rqst_usr_id" style="width:65px;" class="input2" readonly value="">
								</td>
								<th>BKG.Office</th>
								<td><input type="text" 		name="rqst_ofc_cd" id="rqst_ofc_cd" style="width:50px;" class="input2" readOnly value=""></td>
							</tr>
						</tbody>
					</table>
			    	<table style="width:500px;">
						<colgroup>
							<col width="173">
							<col width="*">
						</colgroup>
						<tbody>
							<tr>
								<th>Requested Date (GMT)</th>
								<td><input type="text" 		name="rqst_gdt" id="rqst_gdt" style="width:111px;" class="input2" readOnly value=""></td>
							</tr>
						</tbody>
					</table>
			    	<table style="width:500px;">
						<colgroup>
							<col width="65">
							<col width="140">
							<col width="40">
							<col width="*">
						</colgroup>
						<tbody>
							<tr>
								<th>Tel.</th>
								<td><input type="text" 		name="rqst_usr_phn_no" id="rqst_usr_phn_no" style="width:120px;" class="input2" readOnly value=""></td>
								<th>E-mail</th>
								<td><input type="text" 		name="rqst_usr_eml" id="rqst_usr_eml" style="width:240px;" class="input2" readOnly value=""></td>
							</tr>
						</tbody>
					</table>
			    </div>
			</div>
			<!-- layout_wrap(E) -->
		</div>
		<div class="opus_design_inquiry"><table class="line_bluedot"><tr><td></td></tr></table></div>
		<div class="opus_design_inquiry wFit">
			<!-- layout_wrap(S) -->
			<div class="layout_wrap">
			    <div class="layout_vertical_2" style="padding-right:20px;">
			    	<div class="layout_wrap">
					    <div class="layout_vertical_2" style="padding-right:20px;">
					    	<div class="opus_design_grid" id="mainTable">
					    		<script type="text/javascript">ComSheetObject('sheet1');</script>
					    	</div>
					    </div>
					    <div class="layout_vertical_2">
					    	<div class="opus_design_grid" id="mainTable">
					    		<script type="text/javascript">ComSheetObject('sheet2');</script>
					    	</div>
					    </div>
					</div>
					
					<div class="layout_wrap" style="height:10px">
					</div>
					
					<div class="opus_design_grid" >
						<script type="text/javascript">ComSheetObject('sheet3');</script>
						<script type="text/javascript">ComSheetObject('sheet4');</script>
						<script type="text/javascript">ComSheetObject('sheet5');</script>
						<script type="text/javascript">ComSheetObject('sheet6');</script>
					</div>
					<div class="opus_design_inquiry">
						<table style="width:480px;">
							<colgroup>
								<col width="80">
								<col width="230">
								<col width="70">
								<col width="*">
							</colgroup>
							<tbody>
								<tr>
									<th>Total Weight</th>
									<td><input type="text" 			name="weight_sum" id="weight_sum" style="width:120px;text-align:right;" class="input2" readonly value=""><!--  
										--><input type="text" 		name="wgt_ut_cd" id="wgt_ut_cd" style="width:35px;text-align:center;" class="input2" readonly value=""></td>
									<th>Void Space</th>
									<td><input type="text" 			name="ovr_void_slt_qty" id="ovr_void_slt_qty" style="width:60px;text-align:right;" class="input2" readonly value=""><!--  
										--><input type="text" style="width:35px;text-align:center;" class="input2" readonly value="FEU"></td>
								</tr>
							</tbody>
						</table>
					</div>
			    </div>
			    <div class="layout_vertical_2">
			    	<table style="width:490px;">
						<colgroup>
							<col width="200">
							<col width="110">
							<col width="*">
						</colgroup>
						<tbody>
							<tr>
								<th>Detail Information For Cargo Sequence&nbsp;<input type="text" name="Seq" id="Seq" style="width:20px;text-align:center;" class="input2" readonly value=""></th>
								<th>Break Bulk Term</th>
								<td>
									<select 		name="rcv_term_cd" id="rcv_term_cd" style="width:40px;" class="input2" disabled>
										<option value="" ></option>
										<option value="D">D</option>
										<option value="I">I</option>
										<option value="S">S</option>
										<option value="T">T</option>							
										<option value="Y">Y</option>
									</select><!--  
									--><select 		name="de_term_cd" id="de_term_cd" style="width:40px;" class="input2" disabled>
										<option value="" ></option>
										<option value="D">D</option>
										<option value="O">O</option>
										<option value="S">S</option>
										<option value="T">T</option>							
										<option value="Y">Y</option>
									</select>
								</td> 
							</tr>
						</tbody>
					</table>
			    	<table style="width:490px;">
						<colgroup>
							<col width="80">
							<col width="*">
						</colgroup>
						<tbody>
							<tr>
								<th>Commodity</th>
								<td><input type="text" 		name="cmdt_cd" id="cmdt_cd" style="width:50px;" class="input2" readonly value=""><!--  
									--><input type="text" 	name="cmdt_nm" id="cmdt_nm" style="width:318px;" class="input2" readonly value=""><!--  
									--><button type="button" class="input_seach_btn" name="btns_Commodity" id="btns_Commodity"></button>
								</td>
							</tr>
						</tbody>
					</table>
			    	<table style="width:490px;">
						<colgroup>
							<col width="80">
							<col width="84">
							<col width="110">
							<col width="*">
						</colgroup>
						<tbody>
							<tr>
								<th>Sling Point</th>
								<td><select 	name="slng_pnt_flg" id="slng_pnt_flg" style="width:50px;" class="input2" disabled>
										<option value="" ></option>
										<option value="Y">Y</option>
										<option value="N">N</option>
									</select>
								</td>
								<th>Center Of Gravity</th>
								<td><input type="text" name="grav_ctr_desc" id="grav_ctr_desc" style="width:207px;" class="input2" readonly value=""></td>
							</tr>
						</tbody>
					</table>
			    	<table style="width:490px;">
						<colgroup>
							<col width="134">
							<col width="*">
						</colgroup>
						<tbody>
							<tr>
								<th>Cargo Packing Detail</th>
								<td><input type="text" name="pck_dtl_desc" id="pck_dtl_desc" style="width:347px;" class="input2" readonly value=""></td>
							</tr>
						</tbody>
					</table>
			    	<table style="width:490px;">
						<colgroup>
							<col width="134">
							<col width="115">
							<col width="150">
							<col width="*">
						</colgroup>
						<tbody>
							<tr>
								<th>Loading Method</th>
								<td><select name="cgo_lodg_mzd_cd" id="cgo_lodg_mzd_cd" style="width:100px;" class="input2" disabled>
										<option value="" ></option>
										<option value="G">Gantry</option>
										<option value="F">Floating</option>
										<option value="M">Mobile</option>
										<option value="O">Others</option>
									</select>
								</td>
								<th>DG container S/N</th>
								<td><input name="bb_dcgo_seq" id="bb_dcgo_seq" type="text" style="width:53px;" class="input2" readonly value=""><!--  
									--><button type="button" class="input_seach_btn" name="btns_DgCntrSeq" id="btns_DgCntrSeq"></button>
								</td>
							</tr>
						</tbody>
					</table>
			    	<table style="width:490px;">
						<colgroup>
							<col width="134">
							<col width="*">
						</colgroup>
						<tbody>
							<tr>
								<th>Secure & Dunnage</th>
								<td><input type="text" name="scr_dng_ctnt" id="scr_dng_ctnt" style="width:347px;" class="input2" readonly value=""></td>
							</tr>
						</tbody>
					</table>
			    	<table style="width:490px;">
						<colgroup>
							<col width="134">
							<col width="*">
						</colgroup>
						<tbody>
							<tr>
								<th>Special Request</th>
								<td><input type="text" name="spcl_rqst_desc" id="spcl_rqst_desc" style="width:347px;" class="input2" readonly value=""></td>
							</tr>
						</tbody>
					</table>
			    	<table style="width:490px;">
						<colgroup>
							<col width="80">
							<col width="*">
						</colgroup>
						<tbody>
							<tr>
				       			<th>Remark(s)</th>
								<td><input type="text" name="diff_rmk" id="diff_rmk" style="width:401px;" class="input2" readonly value=""></td>									
							</tr>
						</tbody>
					</table>
			    	<table style="width:490px;">
						<colgroup>
							<col width="*">
						</colgroup>
						<tbody>
							<tr>
								<td style="text-align:right;"><button class="btn_etc" style="text-align:left;"><strong>></strong></button></td>									
							</tr>
						</tbody>
					</table>
			    </div>
			</div>
			<!-- layout_wrap(E) -->
		</div>
		<div class="opus_design_inquiry"><table class="line_bluedot"><tr><td></td></tr></table></div>
		<div class="opus_design_inquiry wFit">
			<table style="width:979px;">
				<colgroup>
					<col width="110">
					<col width="120">
					<col width="100">
					<col width="70">
					<col width="70">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th>Approval by</th>
						<td><input type="text" name="auth_usr_id" id="auth_usr_id" style="width:91px;" class="input1" readonly value=""></td>
						<th>Date (GMT)</th>
						<td colspan="3"><input type="text" name="auth_dt" id="auth_dt" style="width:80px;" class="input1" readonly value=""></td> 
					</tr>
					<tr>
						<th>Approval</th>
						<td><select name="spcl_cgo_auth_cd" id="spcl_cgo_auth_cd" style="width:91px;" class="input1" style="font-weight:bold;" onchange="auth_OnChange()">
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
					<tr class="h23">
						<th>Approval Ref. No.</th>
						<td><input type="text" name="apro_ref_no" id="apro_ref_no" style="width:378px;" class="input2" value="" maxlength="50" disabled></td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
</div>

</form>
