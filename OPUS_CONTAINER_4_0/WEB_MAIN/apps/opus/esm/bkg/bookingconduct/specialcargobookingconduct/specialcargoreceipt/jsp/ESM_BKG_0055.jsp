<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   esm_bkg_0055.jsp
*@FileTitle  : Awakward Cargo Application 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.event.EsmBkg0055Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%@ page import="com.clt.framework.core.controller.util.WebKeys"%> 
<%@ page import="com.clt.framework.core.view.template.Screen"%>
 


<%
	EsmBkg0055Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";				//error message
	int rowCount	 = 0;				//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.SpecialCargoBookingConduct.SpecialCargoReceipt");

	String bkgNo = "";
	String screenName = "";
	
	String isInquiry = "N";	
	String mainpage = "";
	Screen screen = (Screen) request.getAttribute(WebKeys.CURRENT_SCREEN);
	//inquiry mode
	if (screen.getName().indexOf("Q") >= 0){
		isInquiry = "Y";
	} else {
		isInquiry = "N";			
	}
	
	String mainPage = JSPUtil.getNull(request.getParameter("mainPage"));
	String pgmNo = JSPUtil.getNull(request.getParameter("pgmNo"));
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		mainpage = request.getParameter("mainPage");
		event = (EsmBkg0055Event)request.getAttribute("Event");
		bkgNo = event.getBkgNo();
				
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// getting data from server when load the initial screen
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

<form name="form" id="form">
	<input type="hidden" name="f_cmd" id="f_cmd">
	<input type="hidden" name="pagerows" id="pagerows">
	<input type="hidden" name="frm_awk_cgo_seq" id="frm_awk_cgo_seq">
	<input type="hidden" name="temp_cntr_no" id="temp_cntr_no">
	<input type="hidden" name="cntr_tpsz_cd" id="cntr_tpsz_cd">
	<input type="hidden" name="temp_grs_wgt" id="temp_grs_wgt">
	<input type="hidden" name="temp_net_wgt" id="temp_net_wgt">
	<input type="hidden" name="title_id" id="title_id" value="awk">
	<input type="hidden" name="button" id="button" value="N">
	<input type="hidden" name="old_bkg_no" id="old_bkg_no" value="">
<!-- start	-->
	<input type="hidden" name="isInquiry" id="isInquiry" value="<%=isInquiry%>">

	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<% if("true".equals(mainPage)){ %>
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<% } else { %>
		<h2 class="page_title">AK Cargo Application</h2>
		<% } %>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
			--><button type="button" class="btn_normal" name="btn_attach"  	id="btn_attach">Attach File</button><!-- 
			--><button type="button" class="btn_normal" name="btn_Save"  	id="btn_Save">Save</button><!-- 
			--><button type="button" class="btn_normal" name="btn_Request" 	id="btn_Request">Request</button> 
		</div>
		<!-- opus_design_btn(E) -->
	
		<!-- page_location(S) -->
		<div class="location">
			<!-- location 내용 동적생성 (별도 코딩 불필요) -->
			<span id="navigation"></span>
		</div>
	</div>
	<!-- page_title_area(E) -->


	<!-- wrap_search (S) -->
	<div class="wrap_search">

		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="60"/>
					<col width="130"/>
					<col width="50"/>
					<col width="210"/>
					<col width="130"/>
					<col width="350"/>
					<col width="80"/>
					<col width="60"/>
					<col width="*"/>
				</colgroup>
				<tbody>
					<tr>
						<th>BKG No.</th>
						<td><input name="bkg_no" id="bkg_no" style="width:96px;" class="input1" value="<%=bkgNo%>" dataformat="engup" maxlength="13"><!-- 
						  	--><button type="button" class="btn_down_list" name="btn_splitPop" id="btn_splitPop"></button></td>
						<th>B/L No.</th>
						<td><input name="bl_no" id="bl_no" style="width:96px;" dataformat="engup" maxlength="12" class="input1"></td> 
						<th class="sm">Requested by/Date</th>
						<td class="sm"><input name="rqst_usr_id" id="rqst_usr_id" style="width:97px;" class="input2" readonly="readonly" /><!-- 
						 				--><input name="rqst_dt" id="rqst_dt" style="width:115px;" class="input2"  readonly="readonly" /><!-- 
						 				--><input name="rqst_gdt" id="rqst_gdt" style="width:115px;" class="input2" readonly> (GMT)</td>
						<th class="sm">Approval</th>
						<td class="sm"><input name="auth_cd" id="auth_cd" style="width:20px;text-align:center;" class="input2_1" readonly="readonly" /><!-- 
						  				--><button type="button" name="btn_approval" id="btns_search1" class="input_seach_btn"></button></td>	
						 <td> </td>
					</tr>
				</tbody>						
			</table>
			<!-- opus_design_inquiry(E) -->
			<table>
				<colgroup>
					<col width="60"/>
					<col width="130"/>
					<col width="50"/>
					<col width="220"/>
					<col width="30"/>
					<col width="*"/>
				</colgroup>
				<tbody>
					<tr>
						<th>T/VVD</th>
						<td><input name="tvvd" id="tvvd" style="width:96px;"  class="input2" readonly="readonly" /></td>
						<th title="Port of Loading">POL</th>
						<td>
							<input name="pol_cd" id="pol_cd" style="width:100px;" class="input2" readonly="readonly" /><!-- 
						  	--><input name="pol_nod_cd" id="pol_nod_cd" style="width:27px;" class="input2" readonly="readonly" /><!-- 
						  	--><button type="button" class="btn_etc" name="btn_pol_cd" style="width:50px;" id="btn_pol_cd">Info</button></td>
						<th title="Port of Discharging">POD</th>
						<td>
							<input name="pod_cd" id="pod_cd" style="width:55px;" class="input2" readonly="readonly" /><!-- 
						  	--><input name="pod_nod_cd" id="pod_nod_cd" style="width:27px;" class="input2" readonly="readonly" /><!-- 
						  	--><button type="button" class="btn_etc" name="btn_pod_cd" style="width:50px;" id="btn_pod_cd">Info</button></td>
					</tr>
				</tbody>
			</table>
			<table>
				<tbody>
					<colgroup>
						<col width="150"/>
						<col width="170"/>
						<col width="170"/>
						<col width="*"/>
					</colgroup>
					<tr>
						<th>Application Total Package</th>
						<td>
							<input name="package_sum" id="package_sum" style="width:60px;text-align:right;" class="input2" readonly="readonly" /><!-- 
						  	--><input name="pck_tp_cd" id="pck_tp_cd" style="width:25px;" class="input2" readonly="readonly" /></td>
						<th>Application Total Weight</th>
						<td><input name="weight_sum" id="weight_sum" style="width:98px; text-align:right;" class="input2" readonly="readonly" /><!-- 
						  	--><input name="wgt_ut_cd" id="wgt_ut_cd" style="width:38px;" class="input2" readonly="readonly" /></td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
	<!-- wrap_search (E) -->
	
	<!-- opus_design_inquiry(S) -->
	<div class="wrap_result">
		 <!-- layout_wrap(S) -->
		<div class="layout_wrap">
		    <div class="layout_vertical_2" style="width:35%;">
		       <!-- opus_design_grid(S) -->
		        <div class="opus_design_grid mar_btm_12">
		            <!-- !!!IBSheet GRID!!! -->
		            <script type="text/javascript">ComSheetObject('sheet1');</script>
		        </div>
		        
		        <div class="opus_design_grid">
					<div class="opus_design_btn">
						<button type="button" class="btn_normal" name="add_button" id="add_button">Row Add</button>
						<button type="button" class="btn_normal" name="del_button" id="del_button">Row Delete</button>
						<button type="button" class="btn_normal" name="btn_Copy" id="btn_Copy">Copy</button>
					</div>
					
		            <!-- !!!IBSheet GRID!!! -->
		            <script type="text/javascript">ComSheetObject('sheet2');</script>
		            <script type="text/javascript">ComSheetObject('sheet3');</script>
		            <script type="text/javascript">ComSheetObject('sheet4');</script>
		            <script type="text/javascript">ComSheetObject('sheet5');</script>
		        </div>
		        <!-- opus_design_grid(E) -->	
		    </div>
		    
		    
		    <div class="layout_vertical_2" style="width:65%;">
		      <!-- opus_design_inquiry(S) -->
    			<div class="opus_design_inquiry" style="padding-left:15px;width:750px;">
					<table>
						<colgroup>
							<col width="150"/>
							<col width="70"/>
							<col width="360"/>
							<col width="*"/>
						</colgroup>
						<tbody>
							<tr>
								<th>Cargo Detail for Container Sequence</th>
								<td><input name="frm_seq" id="frm_seq" style="width:30px;" class="input2" readonly="readonly" /></td>
								<th>Awkward Term</th>
								<td class="align_right"><script type="text/javascript">ComComboObject('rcv_term_cd', 2, 40, 1, 0, 0)</script><!--
									--><script type="text/javascript">ComComboObject('de_term_cd', 2,40, 1, 0, 0)</script></td>
							</tr>
						</tbody>
					</table>
					<table>
						<colgroup>
							<col width="80"/>
							<col width="140"/>
							<col width="80"/>
							<col width="180"/>
							<col width="100"/>
							<col width="*"/>
						</colgroup>
						<tbody>
							<tr>
								<th>Package</th>
								<td>
									<input name="frm_pck_qty" id="frm_pck_qty" style="width:60px;text-align:right;" class="input1" maxlength="7" dataformat="num"><!-- 
								  	--><input name="frm_pck_tp_cd" id="frm_pck_tp_cd" style="width:25px;" class="input1" maxlength="2" dataformat="engup"><!-- 
								   	--><button type="button" name="pck_button" id="pck_button" class="input_seach_btn"></button></td>
								<th>Gross Weight</th>
								<td>
									<input name="frm_grs_wgt" id="frm_grs_wgt" style="width:90px;text-align:right;" class="input1" dataformat="float" pointcount="3" maxlength="11"><!-- 
								  	--><select name="wgt_ut_cd1" id="wgt_ut_cd1" style="width:77px;" class="input1">
								  		<option value="KGS">KGS</option>
								  		<option value="LBS">LBS</option></select></td> 
								<th>Net Weight</th>
								<td><input name="frm_net_wgt" id="frm_net_wgt" style="width:88px;" class="input1 align_right" dataformat="float" pointcount="3" maxlength="11"><!-- 
								  	--><input name="wgt_ut_cd2" id="wgt_ut_cd2" style="width:59px;" class="input2" readonly="readonly" /></td>
							</tr>
						</tbody>
					</table>
					<table> 
						<colgroup>
							<col width="80"/>
							<col width="400"/>
							<col width="130"/>
							<col width="*"/>
						</colgroup>
						<tbody>
							<tr>
								<th>Commodity</th>
								<td>
									<input name="cmdt_cd" id="cmdt_cd" style="width:65px;" class="input1" maxlength="6"><!-- 
								 	--><input name="cmdt_nm" id="cmdt_nm" style="width:283px;" class="input2" readonly="readonly" /><!-- 
								  	--><button type="button" name="cmdt_button" id="cmdt_button" class="input_seach_btn"></button></td>
								<th>DG container S/N</th>
								<td><input name="frm_cntr_cgo_seq" id="frm_cntr_cgo_seq" style="width:88px;" class="input2" readonly="readonly" /><!-- 
								  --><button type="button" name="dg_container_seq" id="dg_container_seq" class="input_seach_btn"></button></td>
							</tr>
						</tbody>
					</table>
	    		    </div>
					<table class="line_bluedot"><tr><td></td></tr></table>
					<div class="opus_design_inquiry" style="padding-left:15px;width:750px;">
		    		<!-- opus_design_inquiry(E) -->
    				<div class="layout_wrap"> 
		    			<!-- opus_design_grid(S) -->
				        <div class="opus_design_inquiry layout_vertical_2" style="width:417px;">
							<table class="grid_2 wInherit">
	                                        <colgroup>
	                                            <col />
	                                            <col width="45" />
	                                            <col width="45" />
	                                            <col width="45" />
	                                            <col width="45" />
	                                            <col width="45" />
	                                            <col width="45" />
	                                            <col width="45" />
	                                        </colgroup>
	                                        <tbody>
									<tr>
										<th colspan="6" style="border-right:1px solid #d3dfeb;" class="align_center">Dimension Information (unit : cm)</th>
										<td colspan="2" rowspan="3" style="border-right:0px; border-top:0px; padding-left:10px;">
											<input name="und_deck_top_flg" id="und_deck_top_flg" type="checkbox" /><!-- 
										 --><label for="und_deck_top_flg">UD-Top</label><br /><!-- 
										 --><input name="inGauge" id="inGauge" type="checkbox" disabled /><!-- 
										 --><label for="inGauge">In-Gauge</label>
										</td>
									</tr>
									<tr class="align_center">
										<td>&nbsp;</td>
										<td colspan="2">Length</td> 									
										<td colspan="2">Width</td>
										<td>Height</td>
									</tr>
									<tr class="noinput align_right">
										<td class="align_center">Total Dimension </td>
										<td colspan="2">
											<input name="ttl_dim_len" id="ttl_dim_len" class="input1" dataformat="num" maxlength="7"/>
										</td>									
										<td colspan="2">
											<input name="ttl_dim_wdt" id="ttl_dim_wdt" class="input1" dataformat="num" maxlength="7"/>
										</td>
										<td>
											<input name="ttl_dim_hgt" id="ttl_dim_hgt" class="input1" dataformat="num" maxlength="7"/>
										</td> 
									</tr>
									<tr class="align_center">
										<td rowspan="2">Over Dimension </td>
										<td>Front</td> 
										<td>Rear</td> 									
										<td>Right</td> 
										<td>Left</td>
										<td>Height</td> 
										<td colspan="2">Void Space</td>
									</tr>
									<tr class="align_right noinput">
										<td><input name="ovr_fwrd_len" id="ovr_fwrd_len" dataformat="num" maxlength="6" style="ime-mode:disabled" /></td> 
										<td><input name="ovr_bkwd_len" id="ovr_bkwd_len" dataformat="num" maxlength="6" style="ime-mode:disabled" /></td>									
										<td><input name="ovr_rt_len" id="ovr_rt_len" dataformat="num" maxlength="6" style="ime-mode:disabled" /></td> 
										<td><input name="ovr_lf_len" id="ovr_lf_len" dataformat="num" maxlength="6" style="ime-mode:disabled" /></td> 
										<td><input name="ovr_hgt" id="ovr_hgt" dataformat="num" maxlength="6" style="ime-mode:disabled" /></td>  									
										<td><input name="ovr_void_slt_qty" id="ovr_void_slt_qty" class="align_right"  dataformat="num" maxlength="6" style="ime-mode:disabled" /></td>
										<td class="align_center">FEU</td>
									</tr>
								</tbody>
							</table>
							
							
							<!--  Button_Sub (S) -->
							<div class="opus_design_btn">
								<button type="button" class="btn_etc" name="criteria_button" id="criteria_button">Criteria</button><!--
								--><button type="button" class="btn_etc mar_none" name="details_button" id="details_button">Details</button>
							</div>
							<!--  Button_Sub (E) -->
							
				        </div>
			        <!-- opus_design_grid(E) -->
			        
			        <!-- opus_design_inquiry(S) -->
			        <div class="opus_design_inquiry layout_vertical_2 wInherit floatR mar_none" style="width:305px;padding:12px 9px;">
		  				<!--  biz_3  (S) -->
						<table>
                            <colgroup>
                                <col />
                                <col width="126" />
                            </colgroup>
							<tbody>
								<tr>
									<th>Corner Post Status</th>
									<td><script type="text/javascript">ComComboObject('crn_pst_sts_cd', 2, 126, 1, 0,1)</script></td>
								</tr>
								<tr>
									<th>Over Height after Extension</th>
									<td><input name="frm_xtd_ovr_qty" id="frm_xtd_ovr_qty" dataformat="float" maxlength="14" pointcount="3"/></td>
								</tr>
								<tr>
									<th>Post Lock Pin</th>
									<td>
										<select name="pst_lck_pin_flg" id="pst_lck_pin_flg">
											<option></option>
											<option value="Y">Engage</option>
											<option value="N" >No</option>
										</select>
									</td>
									<td style="display:none">
										<select name="pst_lck_pin_flg" id="pst_lck_pin_flg">
											<option></option>
											<option value="Y">Engage</option>
											<option value="N">No</option>
										</select>
									</td>
								</tr>
								<tr>
									<th>Gravity Center</th>
									<td><input name="frm_grav_ctr_desc" id="frm_grav_ctr_desc" maxlength="50" /></td>
								</tr>
								<tr>
									<th>Approval Ref. No.</th>
									<td><input name="aply_no" id="aply_no" readonly="readonly" /></td>
								</tr>
							</tbody>
						</table>
						<!--  biz_3   (E) -->
			        </div>
			        <!-- opus_design_inquiry(E) -->
			        </div>
			        
			        
			        <div class="opus_design_inquiry">
				    	<table>
				    		<colgroup>
				    			<col width="110"/>
				    			<col width="*"/>
				    		</colgroup> 
				    		<tbody>
								<tr>
									<th>Stowage Request</th>
									<td><input name="frm_stwg_rqst_desc" id="frm_stwg_rqst_desc" style="width:100%;"></td>
								</tr>
							</tbody>
						</table>
						<div class="opus_design_btn"><!--
						--><button type="button" class="btn_etc" name="btn_Remark" id="btn_Remark">Remark(s)</button><!--
						--><button type="button" class="btn_etc" name="btn_RequestCancel" id="btn_RequestCancel">Request Cancel</button>
						</div>
				    </div>
			    </div>
		    </div>
		</div>
		<!-- layout_wrap(e) -->
	</div>
	<!-- wrap_result (S) -->
	
	
		
	<span style="display:none"><script type="text/javascript">ComSheetObject('sheet6');</script></span>		
	<div id="layList" name="layList" style="position:absolute;z-index:999;display:none" CELLPADDING="5" CELLSPACING="0" BORDER="0">
		<IFRAME id="ifrm" name="ifrm" src="apps/opus/esm/bkg/bookingcommon/bookingutil/jsp/esm_booking_split_no.html"  frameborder=0 marginHeight=0 marginWidth=0 width=115 height=82  style="position:absolute;border:1 #e9e9e9 solid" CELLSPACING=0 scrolling="no"></IFRAME>
	</div>
</form>