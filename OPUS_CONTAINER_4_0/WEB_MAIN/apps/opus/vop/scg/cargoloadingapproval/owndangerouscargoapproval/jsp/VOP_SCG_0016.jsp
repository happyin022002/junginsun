<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : vop_scg_0016.jsp
*@FileTitle  : Awkward CGO Application Details for Own BKG
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/18
=========================================================*/
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
<%@ page import="com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.event.VopScg0016Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopScg0016Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id	= "";
	String strUsr_nm	= "";
	String strBkgNo 	= request.getParameter("bkg_no");
	String strVvdCd 	= request.getParameter("vvd_cd");
	String strCgoSeq 	= request.getParameter("awk_cgo_seq");
	String strRqstSeq 	= request.getParameter("spcl_cgo_apro_rqst_seq");
	String strRow 		= request.getParameter("row");
	String strScgFlg	= request.getParameter("scg_flg");
	String strType		= request.getParameter("type");
	Logger log = Logger.getLogger("com.clt.apps.CargoLoadingApproval.OwnDangerousCargoApproval");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (VopScg0016Event)request.getAttribute("Event");
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
<input type="hidden" name="frm_awk_cgo_seq" value="" id="frm_awk_cgo_seq" />
<input type="hidden" name="temp_cntr_no" value="" id="temp_cntr_no" />
<input type="hidden" name="cntr_tpsz_cd" value="" id="cntr_tpsz_cd" />
<input type="hidden" name="temp_grs_wgt" value="" id="temp_grs_wgt" />
<input type="hidden" name="temp_net_wgt" value="" id="temp_net_wgt" />
<input type="hidden" name="title_id" value="awk" id="title_id" />
<input type="hidden" name="awk_cgo_seq" value="<%=StringUtil.xssFilter(strCgoSeq) %>" id="awk_cgo_seq" />
<input type="hidden" name="spcl_cgo_apro_rqst_seq" value="<%=StringUtil.xssFilter(strRqstSeq) %>" id="spcl_cgo_apro_rqst_seq" />
<input type="hidden" name="row" value="<%=StringUtil.xssFilter(strRow) %>" id="row" />
<input type="hidden" name="scg_flg" value="<%=StringUtil.xssFilter(strScgFlg) %>" id="scg_flg" />
<input type="hidden" name="type" value="<%=StringUtil.xssFilter(strType) %>" id="type" />
<input type="hidden" name="mailYn" value="N" id="mailYn" />
<input id="isInquiry" name="isInquiry" value="N" type="hidden" />

<!-- layer_popup_title(S) -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<!-- page_title(S) -->
			<h2 class="page_title"><span>Awkward CGO Application Details for Own BKG</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
		       <button type="button" class="btn_accent" name="btn_ApprovalDetails" id="btn_ApprovalDetails">Approval Details</button><!--
			--><button type="button" class="btn_normal" name="btn_attach" id="btn_attach">Attach File</button><!--
			--><button type="button" class="btn_normal" name="btn_Mail" id="btn_Mail">Mail</button><!-- 
		    --><button type="button" class="btn_normal" name="btn_Prev" id="btn_Prev">Prev.</button><!-- 
		    --><button type="button" class="btn_normal" name="btn_Next" id="btn_Next">Next</button><!-- 
		    --><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->
	</div>
	<!-- page_title_area(E) -->
</div>
<!-- layer_popup_title(E) -->

<!-- layer_popup_contents(S) -->
<div class="layer_popup_contents" style="overflow:hidden;">
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table> 
	            <colgroup>
	                <col width="60">
	                <col width="120">
	                <col width="50">
	                <col width="100">
	                <col width="302">
	                <col width="230">
	                <col width="60">
	                <col width="*">
	            </colgroup>
	            <tbody>
		             <tr>
						<th>BKG No.</th>
						<td><input type="text" name="bkg_no" style="width:100px;" class="input2" readonly value="<%=StringUtil.xssFilter(strBkgNo) %>" id="bkg_no" /></td>
						<th>B/L No.</th>
						<td><input type="text" name="bl_no" style="width:100px;" class="input2" readonly value="" id="bl_no" /></td>
						<th>BKG.Staff</th>
						<td>
							<input type="text" name="rqst_usr_nm" style="width:150px;" class="input2" readonly="" value="" id="rqst_usr_nm" /><!-- 
							 --><input type="text" name="rqst_usr_id" style="width:65px;" class="input2" readonly="" value="" id="rqst_usr_id" />
						</td>
						<th>BKG.Office</th>
						<td><input type="text" name="rqst_ofc_cd" style="width:50px;" class="input2" readonly value="" id="rqst_ofc_cd" /></td>
					</tr>
				</tbody>
			</table>
			<table> 
	            <colgroup>
	                <col width="60">
	                <col width="120">
	                <col width="50">
	                <col width="150">
	                <col width="40">
	                <col width="160">
	                <col width="130">
	                <col width="*">
	            </colgroup>
	            <tbody>
		             <tr>
						<th>VVD CD</th>
						<td><input type="text" name="vvd_cd" style="width:100px;" class="input2" readonly value="" id="vvd_cd" /></td>
						<th title="Port of Loading">POL</th>
						<td>
							<input type="text" name="pol_cd" style="width:50px;" class="input2" readonly value="" id="pol_cd" /><!-- 
						 	 --><input type="text" name="pol_nod_cd" style="width:25px;" class="input2" readonly value="" id="pol_nod_cd" /><!-- 
							 --><button type="button" class="btn_etc" name="btn_PolCd" id="btn_PolCd">Info.</button>
						</td>
						<th title="Port of Discharging">POD</th>
						<td>
							<input type="text" name="pod_cd" style="width:50px;" class="input2" readonly value="" id="pod_cd" /><!--  
							 --><input type="text" name="pod_nod_cd" style="width:25px;" class="input2" readonly value="" id="pod_nod_cd" /><!-- 
							 --><button type="button" class="btn_etc" name="btn_PodCd" id="btn_PodCd">Info.</button>
						</td>
						<th>Requested Date (GMT)</th>
						<td><input type="text" name="rqst_gdt" style="width:150px;" class="input2" readonly value="" id="rqst_gdt" /></td>
					</tr>
				</tbody>
			</table>
			<table> 
	            <colgroup>
	                <col width="605">
	                <col width="160">
	                <col width="40">
	                <col width="*">
	            </colgroup>
	            <tbody>
		            <tr>
						<th>Tel.</th>
						<td><input type="text" name="rqst_usr_phn_no" style="width:120px;" class="input2" readonly value="" id="rqst_usr_phn_no" /></td>
						<th>E-mail</th>
						<td><input type="text" name="rqst_usr_eml" style="width:178px;" class="input2" readonly value="" id="rqst_usr_eml" /></td>
					</tr>
				</tbody>
			</table>
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			<table>
				    <colgroup>
		                <col width="150">
		                <col width="90">
		                <col width="30">
		                <col width="*">
			        </colgroup>
		            <tbody>
		            	<tr>
							<th>Awkward Total Package</th>
							<td>
								<input type="text" name="package_sum" style="width:35px;text-align:right;" class="input2" readonly value="" id="package_sum" /><!-- 
							 	 --><input type="text" name="pck_tp_cd" style="width:25px;text-align:center;" class="input2" readonly value="" id="pck_tp_cd" /> 
							</td>
							<th>Awkward Total Weight</th>
							<td>
								<input type="text" name="weight_sum" style="width:100px;text-align:right;" class="input2" readonly value="" id="weight_sum" /><!-- 
							 	 --><input type="text" name="wgt_ut_cd" style="width:35px;text-align:center;" class="input2" readonly value="" id="wgt_ut_cd" />
							</td>
						</tr>
					</tbody>
				</table>
				
		 </div>
	</div>
	<div class="wrap_result">
		<!-- layout_wrap(S) -->
		<div class="layout_wrap">
 		 	<!-- layout_flex_fixed(S) -->
 			<div class="layout_flex_fixed" style="width:250px">
				<!-- opus_design_grid(S) -->
				<div class="opus_design_grid" id="mainTable" >		
					<script type="text/javascript">ComSheetObject('sheet1');</script>
				</div>
				<div class="opus_design_grid" id="mainTable" >	
					<script type="text/javascript">ComSheetObject('sheet2');</script>
				</div>
				<div class="opus_design_grid" id="mainTable" >	
					<script type="text/javascript">ComSheetObject('sheet3');</script>
				</div>
				<div class="opus_design_grid" id="mainTable" >	
					<script type="text/javascript">ComSheetObject('sheet4');</script>
				</div>
				<div class="opus_design_grid" id="mainTable" >	
					<script type="text/javascript">ComSheetObject('sheet5');</script>
				</div>
				<div class="opus_design_grid" id="mainTable" >	
					<script type="text/javascript">ComSheetObject('sheet6');</script>
				</div>
				<!-- opus_design_grid(E) -->
		 	</div>
 			<!-- layout_flex_fixed(S) -->
			<div class="layout_flex_fixed" style="width:501px;margin-left:8px"> 
				<div class="opus_design_inquiry wFit">
					<table> 
			            <colgroup>
			                <col width="220">
			                <col width="*">
			            </colgroup>
			            <tbody>
				             <tr>
								<th style="text-align:left">Cargo Detail for Container Sequence</th>
								<td><input type="text" name="frm_seq" style="width:25px;text-align:center;" class="input2" readonly value="" id="frm_seq" /></td>
							</tr>	
						</tbody>
					</table>
					<table> 
			            <colgroup>
			                <col width="80">
			                <col width="150">
			                <col width="100">
			                <col width="*">
			            </colgroup>
			            <tbody>
				             <tr>
								<th style="text-align:left">Package</th>
								<td>
									<input type="text" name="frm_pck_qty" style="width:50px; text-align:right;" class="input2" readonly value="" id="frm_pck_qty" /><!-- 
									 --><input type="text" name="frm_pck_tp_cd" style="width:25px;text-align:center;" class="input2" readonly value="" id="frm_pck_tp_cd" /><!--  
								 	 --><button type="button" id="btns_Package" name="btns_Package" class="input_seach_btn"></button>
								</td>
								<th>Gross Weight</th>
								<td>
									<input type="text" name="frm_grs_wgt" style="width:90px; text-align:right;" class="input2" readonly value="" id="frm_grs_wgt" /><!-- 
									 --><input type="text" name="wgt_ut_cd1" style="width:35px; text-align:center;" class="input2" readonly value="" id="wgt_ut_cd1" /> 
								</td>
							</tr>
						</tbody>
					</table>
					<table> 
			            <colgroup>
			                <col width="80">
			                <col width="*">
			            </colgroup>
			            <tbody>
				            <tr>
								<th style="text-align:left">Commodity</th>
								<td>
									<input type="text" name="frm_cmdt_cd" style="width:50px; text-align:right;" class="input2" readonly value="" id="frm_cmdt_cd" /><!-- 
									 --><input type="text" name="frm_cmdt_nm" style="width:286px;" class="input2" readonly value="" id="frm_cmdt_nm" /><!--
									 --><button type="button" id="btns_Commodity" name="btns_Commodity" class="input_seach_btn"></button>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="opus_design_data">
					<table class="grid2"> 
			            <colgroup>
			                <col width="200">
			                <col width="80">
			                <col width="80">
			                <col width="80">
			                <col width="80">
			                <col width="80">
			                <col width="100">
			                <col width="*">
			            </colgroup>
			            <tbody>
				            <tr>
								<th colspan="6"><strong>Dimension Information (unit : cm)</strong></th>
								<td rowspan="3" colspan="2" align="left" style="background-color:#f3f2f8; border-right:1px solid #f3f2f8; border-top:1px solid #f3f2f8; padding-left:10px;">
									<br><br><br>
									<br style="font-size:1px;">
									<input type="checkbox" name="inGauge" class="trans" disabled="" id="inGauge" />In Gauge
								</td>
							</tr>
							<tr>
								<th></th>
								<th colspan="2">Length</th>
								<th colspan="2">Width</th>
								<th>Height</th>
							</tr>
							<tr>
								<th>Total Dimension</th>
								<td colspan="2"><input name="ttl_dim_len" type="text" style="width:80px;text-align:right;border:0" class="input2" readonly value="" id="ttl_dim_len" /></td>
								<td colspan="2"><input name="ttl_dim_wdt" type="text" style="width:80px;text-align:right;border:0" class="input2" readonly value="" id="ttl_dim_wdt" /></td>
								<td><input name="ttl_dim_hgt" type="text" style="width:39px;text-align:right;border:0" class="input2" readonly value="" id="ttl_dim_hgt" /></td>
							</tr>
							<tr>
								<th rowspan="2">Over Dimension</th>
								<th>Front</th>
								<th>sRear</th>
								<th>Left</th>
								<th>Right</th>
								<th>Height</th>
								<th colspan="2">Void Space</th>
							</tr>
							<tr>
								<td><input name="ovr_fwrd_len" type="text" style="width:37px;text-align:right;border:0" class="input2" readonly value="" id="ovr_fwrd_len" /></td>
								<td><input name="ovr_bkwd_len" type="text" style="width:37px;text-align:right;border:0" class="input2" readonly value="" id="ovr_bkwd_len" /></td>
								<td><input name="ovr_lf_len" type="text" style="width:37px;text-align:right;border:0" class="input2" readonly value="" id="ovr_lf_len" /></td>
								<td><input name="ovr_rt_len" type="text" style="width:37px;text-align:right;border:0" class="input2" readonly value="" id="ovr_rt_len" /></td>
								<td><input name="ovr_hgt" type="text" style="width:37px;text-align:right;border:0" class="input2" readonly value="" id="ovr_hgt" /></td>
								<td><input name="ovr_void_slt_qty" type="text" style="width:50px;text-align:right;border:0" class="input2" readonly value="" id="ovr_void_slt_qty" /></td>
								<th>FEU</th>
							</tr>
						</tbody>
					</table>
					<table class="mar_btm_8">
						 <colgroup>
	               			 <col width="370">
	                		 <col width="*">
	           			 </colgroup>
		          		 <tbody>
			           		 <tr>
			           		 	<td></td>
			           		 	<td>
									<button type="button"  name="btn_Criteria" id="btn_Criteria" class="btn_etc">Criteria</button><!-- 
						 		 --><button type="button" class="btn_etc" id="details_button" name="btn_Details">Details</button>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<!-- layout_flex_fixed(E) -->
			<!-- layout_flex_flex(S) -->
			<div class="layout_flex_flex" style="padding-left:767px">
				<div class="opus_design_inquiry wFit">
					<table> 
			            <colgroup>
			                <col width="160">
			                <col width="*">
			            </colgroup>
			            <tbody>
				            <tr>
								<th>Awkward Term</th>
								<td>
									<select name="rcv_term_cd" id="rcv_term_cd" style="width:40px;" class="input2" disabled>
										<option value="D">D</option>
										<option value="I">I</option>
										<option value="S">S</option>
										<option value="T">T</option>							
										<option value="Y">Y</option>							
									</select><!-- 
									 --><select name="de_term_cd" id="de_term_cd" style="width:40px;" class="input2" disabled>						
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
					<table> 
			            <colgroup>
			                <col width="160">
			                <col width="*">
			            </colgroup>
			            <tbody>
				            <tr>
								<th>Net Weight</th>
								<td>
									<input type="text" name="frm_net_wgt" style="width:88px; text-align:right;" class="input2" readonly value="" id="frm_net_wgt" /><!-- 
									 --><input type="text" name="wgt_ut_cd2" style="width:35px; text-align:center;" class="input2" readonly value="" id="wgt_ut_cd2" /> 
								</td>
							</tr>
						</tbody>
					</table>
					<table class="mar_btm_4"> 
			            <colgroup>
			                <col width="160">
			                <col width="*">
			            </colgroup>
			            <tbody>
				            <tr>
								<th>DG container S/N</th>
								<td>
									<input type="text" name="frm_cntr_cgo_seq" style="width:88px; text-align:right;" class="input2" readonly value="" id="frm_cntr_cgo_seq" /><!--  
									 --><button type="button" id="btns_DgCntrSeq" name="btns_DgCntrSeq" class="input_seach_btn"></button>
								</td>
							</tr>
						</tbody>
					</table>
					<table class="mar_btm_8"> 
			            <colgroup>
			                <col width="160">
			                <col width="*">
			            </colgroup>
			            <tbody>
				            <tr>
								<th>Corner Post Status</th>
								<td>
									<select name="crn_pst_sts_cd" id="crn_pst_sts_cd" style="width:148px;" class="input2" disabled>
										<option value="1" >1 Feet Extension</option>
										<option value="2" >2 Feet Extension</option>
										<option value="3" >3 Feet Extension</option>
										<option value="4" >4 Feet Extension</option>
										<option value="5" >5 Feet Extension</option>
										<option value="E">Erect-No Extension</option>
										<option value="F">FOLDING</option>
									</select>
								</td>
							</tr>
						</tbody>
					</table>
					<table class="mar_btm_8"> 
			            <colgroup>
			                <col width="160">
			                <col width="*">
			            </colgroup>
			            <tbody>
				            <tr>
								<th>Over Height after Extension</th>
								<td><input type="text" name="frm_xtd_ovr_qty" style="width:148px;" class="input2" readonly value="" id="frm_xtd_ovr_qty" /></td>
							</tr>
						</tbody>
					</table>
					<table class="mar_btm_8">
						<colgroup>
			                <col width="160">
			                <col width="*">
			            </colgroup>
			            <tbody>
							<tr>
								<th>Post Lock Pin</th>
								<td>
									<select name="pst_lck_pin_flg" id="pst_lck_pin_flg"  style="width:148px;" class="input2" disabled>
										<option value="Y">Engage</option>
										<option value="N" >No</option>
									</select>
								</td>
							</tr>
						</tbody>
					</table>
					<table>
						<colgroup>
			                <col width="160">
			                <col width="*">
			            </colgroup>
			            <tbody>
							<tr>
								<th>Gravity Center</th>
								<td><input name="frm_grav_ctr_desc" type="text" style="width:148px;" class="input2" readonly value="" maxlength="50" id="frm_grav_ctr_desc" /></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<!-- layout_flex_flex(E) -->
		</div>
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			 <table> 
	            <colgroup>
	                <col width="330">
	                <col width="*">
	            </colgroup>
	            <tbody>
		            <tr>
						<th>Stowage Request</th>
						<td>
							<input type="text" name="frm_stwg_rqst_desc" style="width:99%;" class="input2" readonly="" value="" id="frm_stwg_rqst_desc" />
						</td>
					</tr>
				</tbody>
			</table>
			<table>
				<colgroup>
	                <col width="225">
	                <col width="105">
	                <col width="*">
	            </colgroup>
	            <tbody>
		       		<tr>
		       			<td></td>
						<th style="text-align:left">Remark(s)</th>
						<td><input type="text" name="diff_rmk" style="width:96%;" class="input2" readonly value="" id="diff_rmk" /><button type="button" class="btn_etc"></button></td>
					</tr>
				</tbody>
			</table>
			<table class="line_bluedot"><tr><td height="20"></td></tr></table>
			<table> 
	            <colgroup>
	                <col width="100">
	                <col width="130">
	                <col width="70">
	                <col width="*">
	            </colgroup>
	            <tbody>
		            <tr>
						<th style="text-align:left">Approval by</th>
						<td><input type="text" name="auth_usr_id" style="width:109px;" class="input1" readonly value="" id="auth_usr_id" /></td>
						<th>Date (GMT)</th>
						<td><input type="text" name="auth_dt" style="width:80px;" class="input1" readonly value="" id="auth_dt" /></td>
					</tr>
				</tbody>
			</table>
			<table>
				<colgroup>
	                <col width="100">
	                <col width="130">
	                <col width="70">
	                <col width="110">
	                <col width="70">
	                <col width="*">
	            </colgroup>
	            <tbody>
					<tr>
						<th style="text-align:left">Approval</th>
						<td>
							<select name="spcl_cgo_auth_cd" id="spcl_cgo_auth_cd" style="width:109px;font-weight:bold;" class="input1">
								<option value="Y" style="color:green;">Y</option>
								<option value="A" style="color:green;">Y(all)</option>
								<option value="N" style="color:red;">N</option>
								<option value="P" style="color:blue;">P</option>
								<option value="" style="color:orange;"></option></select>
						</td>
						<th>RJT Code</th>
						<td> 
							<script type="text/javascript">ComComboObject('spcl_cgo_auth_rjct_cd', 2, 80, 0, 2);</script>								
						</td>
						<th>Remark(s)</th>
						<td><input type="text" name="spcl_cgo_auth_rmk" style="width:100%;" class="input" value="" id="spcl_cgo_auth_rmk" /></td>
					</tr>
				</tbody>
			</table>
			<table> 
	            <colgroup>
	                <col width="100">
	                <col width="*">
	            </colgroup>
	            <tbody>
		            <tr>
						<th style="text-align:left">Approval Ref. No.</th>
						<td><input type="text" name="apro_ref_no" style="width:378px;" class="input2" value="" maxlength="50" disabled id="apro_ref_no" /></td>
					</tr>	
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
</div>
<!-- layer_popup_contents(E) -->
</form>