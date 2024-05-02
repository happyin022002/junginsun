<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   :ESM_BKG_0498.jsp
*@FileTitle  : Awakward Cargo Application
*@author     : CLT
*@version    : 1.0
*@since      : 29/04/2014
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.event.EsmBkg0498Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.core.controller.util.WebKeys"%>
<%@ page import="com.clt.framework.core.view.template.Screen"%>

<%
	EsmBkg0498Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from the server	
	String strErrMsg = "";						//error messege
	int rowCount	 = 0;						//the number of DB ResultSet List

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.SpecialCargoBookingConduct.SpecialCargoReceipt");

	String bkgNo = "";
	String screenName = "";
	
	String isInquiry = "N";	
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


		event = (EsmBkg0498Event)request.getAttribute("Event");
		bkgNo = event.getBkgNo();
				
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// extract additional data obtained from the server during Initial loading ..
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
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="diff_rmk" id="diff_rmk">
<input type="hidden" name="temp_cntr_no" id="temp_cntr_no">
<input type="hidden" name="temp_grs_wgt" id="temp_grs_wgt">
<input type="hidden" name="temp_net_wgt" id="temp_net_wgt">
<input type="hidden" name="cntr_tpsz_cd" id="cntr_tpsz_cd">
<input type="hidden" name="title_id" value="rf" id="title_id">
<input type="hidden" name="button" value="N" id="button">
<input type="hidden" name="old_bkg_no" id="old_bkg_no" value="">

<input type="hidden" name="isInquiry" id="isInquiry" value="<%=isInquiry%>">
		
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<% if("true".equals(mainPage)){ %>
			<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<% } else { %>
			<h2 class="page_title">RF Cargo Application</h2>
		<% } %>
		<!-- page_title(E) -->
			
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_Request" id="btn_Request">Request</button>
			<% if(!"true".equals(mainPage)){ %>
			<button type="button" class="btn_normal" name="btn_Close" id="btn_Close"  onClick="ComClosePopup()">Close</button>
			<%} %>
		</div>
		<!-- opus_design_btn(E) -->	
		<% if("true".equals(mainPage)){ %>
		<!-- page_location(S) -->
		<div class="location">
			<!-- location 내용 동적생성 (별도 코딩 불필요) -->
			<% if("ESM_BKG_0498".equals(pgmNo)){ %>
			<span id="navigation">Service Management > Booking/Documentation > Booking > Special Cargo > RF Cargo Application</span>
			<% }else if("ESM_BKG_0498_Q".equals(pgmNo)){ %>
			<span id="navigation">Service Management > Booking/Documentation > Booking > Special Cargo > RF Cargo Application Inquiry</span>
			<% } %>
		</div>
		<!-- page_location(E) -->
		<% } %>
	</div>
	
	
	<!-- page_title_area(E) -->

<div class="wrap_search">
	<div class="opus_design_inquiry">
		<table> 
		<tbody>
			<colgroup>
	         <col width="56">
	         <col width="154">
	         <col width="60">
	         <col width="150">
	         <col width="120">
	         <col width="90">
	         <col width="90">
	         <col width="90">
	         <col width="*">
		   </colgroup>
		        <tr>
				<th>BKG No.</th>
				<td><input type="text" name="bkg_no" id="bkg_no" style="width:96px;" class="input1" value="<%=bkgNo%>" maxlength="13" dataformat="engup"/><button type="button" name="btn_splitPop" id="btn_splitPop" class="btn_down"></button></td>
				<th>B/L No.</th>
				<td><input type="text" name="bl_no" id="bl_no" style="width:113px;" class="input1" value=""></td> 
				<th>Requested by/Date</th>   
				<td><!--
				--><input type="text" name="rqst_usr_id" id="rqst_usr_id" style="width:90px;" class="input2" value="" readonly /><!--
				--><input type="text" name="rqst_dt" id="rqst_dt" style="width:115px;" class="input2" value="" readonly /><!--
				--><input name="rqst_gdt" id="rqst_gdt" type="text" style="width:115px;" class="input2 mar_rgt_12" value="" readonly />(GMT)
				</td>
				<th>Approval</th> 
				<td><input name="auth_cd" id="auth_cd" type="text" style="width:20px;text-align:center;" class="input2_1" value="" readOnly><!-- 
					 --><button type="button" name="btn_approval" id="btn_approval" class="input_seach_btn"></button></td>		
				<td></td>	
				</tr>
			</tbody>
		</table>
		<table> 
			<colgroup>
		        <col width="56">
		        <col width="154">
		        <col width="60">
		        <col width="150">
		        <col width="120">
		       	<col width="*" />
	        </colgroup> 
	        <tbody>
				<tr>
					<th>T/VVD</th>
					<td><input name="tvvd" id="tvvd" type="text" style="width:110px;" class="input2" value="" readOnly></td>
					<th>POL</th>
					<td><input name="pol_cd" id="pol_cd" type="text" style="width:55px;" class="input2" value="" readOnly><!-- 
					 --><input name="pol_nod_cd" id="pol_nod_cd" type="text" style="width:30px;" class="input2" value="" readOnly></td>
					<th>POD</th>
					<td><input name="pod_cd"  id="pod_cd" type="text" style="width:55px;" class="input2" value="" readOnly><input name="pod_nod_cd" id="pod_nod_cd" type="text" style="width:30px;" class="input2" value="" readOnly></td>
				</tr>
			</tbody>
		</table>
		<table> 
		<tbody>
		<colgroup>
		       <col width="152">
		       <col width="110">
		       <col width="225">
		       <col width="*">
	        </colgroup> 
			<tr>
				<th>Application Total Package</th>
				<td><input name="package_sum" id="package_sum" type="text" style="width:110px;text-align:right;" class="input2" value="" readOnly><!-- 
					 --><input name="pck_type_cd" id="pck_type_cd" type="text" style="width:38px;" class="input2" value="" readOnly></td>
				<th>Application Total Weight</th>
				<td><input name="weight_sum" id="weight_sum" type="text" style="width:110px;text-align:right;" class="input2" value="" readOnly><!-- 
				 	--><input name="wgt_ut" id="wgt_ut" type="text" style="width:38px;" class="input2" value="" readOnly></td>
			</tr>
		</tbody>
		</table>
	</div>
</div>

<div class="wrap_result">
	<!-- layout_wrap(S) -->
	<div class="layout_wrap">
	   <!-- layout_flex_fixed(S) -->
	   <div class="layout_vertical_2" style="width:35%;"> <!-- setting : FIXED width(400px) -->
	       <!-- opus_design_grid(S) -->
	       <div class="opus_design_grid">
	           <script type="text/javascript">ComSheetObject('sheet1');</script>
	       </div>	       
	       <!-- opus_design_grid(E) -->
	   </div>
	   <!-- layout_flex_fixed(E) -->
	   <!-- layout_flex_flex(S) -->
	   <div class="layout_vertical_2" style="width:65%;"> <!-- (fixed Width) + (padding 8px) = 408 -->
	       <!-- opus_design_inquiry(S) -->
	       <div class="opus_design_inquiry" style="padding-left:15px;width:750px;">
	           <table>
					<colgroup>
				       <col width="211">
				       <col width="*">
			        </colgroup>  
		        	<tbody>
						<tr>
							<th>Cargo Detail for Container Sequence</th>
							<td><input name="seq" id="seq" type="text" style="width:30px;text-align:right;" class="input2" value="" readOnly></td>
						</tr>
					</tbody>
				</table>
				<table>
					<colgroup>
						<col width="110" />
						<col width="*" />
					</colgroup>
					<tbody>
						<tr>
							<th>Commodity</th>
							<td>
							<input name="cmdt_cd" id="cmdt_cd" type="text" style="width:71px" class="input1" value="" maxlength="6"><!-- 
							 --><input name="cmdt_nm" id="cmdt_nm" type="text" style="width:333px;" class="input2" value="" readonly><!-- 
							 --><button type="button" name="cmdt_button" id="cmdt_button" class="input_seach_btn"></button></td>
						</tr>
						<tr>
							<th>Temperature</th>
							<td>
								<select style="width:45px;" class="input1" name="plusMinus1" id="plusMinus1">
									<option value="+">+</option>
									<option value="-">-</option>
								</select><!-- 
							 	--><input type="text" name="cdo_temp" id="cdo_temp" style="width:40px;text-align:right;" class="input1" value="" dataformat="float" pointcount="1" maxlength="4"><!-- 
							 	--><input type="text" style="width:22px;" class="input2" value="&ordm;C" readOnly><!-- 
								--><select style="width:45px;" class="input1" name="plusMinus2" id="plusMinus2">
								 		<option value="+">+</option><option value="-">-</option>
								 	</select><!-- 
								--><input type="text" name="fdo_temp" id="fdo_temp" style="width:40px;text-align:right;" class="input1" value="" dataformat="float" pointcount="1" maxlength="4"><!-- 
							 	--><input type="text" style="width:22px;" class="input2" value="&ordm;F" readOnly></td>
							<th>Nature</th>
							<td align="left" width="120px">
								<select name="clng_tp_cd"  id="clng_tp_cd"  style="width:95px;" class="input1">
									<option value=""></option> 
									<option value="F">Frozen</option>
									<option value="C" >Chilled</option>
									<option value="S" >Fresh</option>
								</select></td>
						</tr>
						<tr>
							<th>Ventilation</th>
							<td>
								<input type="text" name="vent_rto" id="vent_rto" style="width:61px;text-align:right;" class="input1" value="" dataformat="float" pointcount="1" maxlength="5"><!-- 
								 --><select name="cntr_vent_tp_cd" id="cntr_vent_tp_cd" style="width:80px;" class="input1">
								 		<option value="P">% Open</option>
								 		<option value="C" >CMH</option>
								 	</select></td>
							<th>Humidity</th>
							<td>
								<input type="text" name="humid_no" id="humid_no" style="width:69px;text-align:right;" class="input" value=""><!--  
								--><input type="text" style="width:22px;" class="input2" value="%" readOnly></td>
						</tr>
					</tbody>
				</table>
				
	       </div>
	       <!-- opus_design_inquiry(E) -->
	   </div>
	   <!-- layout_flex_flex(E) -->
	</div>
	<!-- layout_wrap(E) -->
	 <div class="line_bluedot" style="height:15px"></div>
	<!-- layout_wrap(S) -->
	<div class="layout_wrap">
	   <!-- layout_flex_fixed(S) -->
	   <div class="layout_vertical_2" style="width:35%;"> <!-- setting : FIXED width(400px) -->
	       <!-- opus_design_grid(S) -->
	       <div class="opus_design_grid">
	       		<!-- opus_design_btn(S) -->
				<div class="opus_design_btn">
				    <button type="button" class="btn_normal" name="btn_add" id="btn_add">Row Add</button><!--
				 --><button type="button" class="btn_normal" name="btn_delete" id="btn_delete">Row Delete</button><!--
				 --><button type="button" class="btn_normal" name="btn_Copy" id="btn_Copy">Copy</button>
				</div>
				<!-- opus_design_btn(E) -->
	
	           <script type="text/javascript">ComSheetObject('sheet2');</script>
	       </div>
	       
	       <!-- opus_design_grid(E) -->
	   </div>
	   <!-- layout_flex_fixed(E) -->
	  
	   <!-- layout_flex_flex(S) -->
	   <div class="layout_vertical_2" style="width:65%;"> <!-- (fixed Width) + (padding 8px) = 408 -->
	       <!-- opus_design_inquiry(S) -->
	       <div class="opus_design_inquiry" style="padding-left:15px;width:750px;">
	       		<table>
					<colgroup>
						<col width="110" />
						<col width="300" />
						<col width="*" />
					</colgroup>
					<tbody>
						<tr>
							<th>Package</th>
							<td><input type="text" name="pck_qty" id="pck_qty" style="width:115px;text-align:right;" class="input" value=""><!--  
								--><input type="text" name="pck_tp_cd" id="pck_tp_cd" style="width:25px;" class="input" value="" maxlength="2"><!-- 
								--><button type="button" name="pck_button" id="pck_button" class="input_seach_btn"></button>
							</td>
							<td><input type="checkbox" name="ctrl_atms_flg" id="ctrl_atms_flg" class="trans"><label for= "ctrl_atms_flg"><b>Control Atmosphere (CA)</b></label></td>
						</tr>
						
						<tr>
							<th>Gross Weight</th>
							<td><input type="text" name="grs_wgt" id="grs_wgt" style="width:144px;text-align:right;" class="input1" value="" dataformat="float" pointcount="3" maxlength="11"><!--  
								--><select name="wgt_ut_cd1" id="wgt_ut_cd1" style="width:65px;" class="input1">
										<option value="KGS">KGS</option>
										<option value="LBS" >LBS</option>
								   </select></td> 
							<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" style="width:27px;" value="O&sup2;" class="input2" readOnly><input type="text" style="width:40px;text-align:right;" name="oxgn_rto" id="oxgn_rto" class="input" value="" dataformat="float" pointcount="1" maxlength="5"><input type="text" style="width:22px;" value="%" class="input2" readOnly>
							    <input type="text" style="width:33px;" value="CO&sup2;" class="input2" readOnly><input type="text" style="width:40px;text-align:right;" name="crbn_dxd_rto" id="crbn_dxd_rto" class="input" value="" dataformat="float" pointcount="1" maxlength="5"><input type="text" style="width:22px;" value="%" class="input2" readOnly>
							
							</td>
						</tr>
						
						<tr>
							<th>Net Weight</th>
							<td><input type="text" name="net_wgt" id="net_wgt" style="width:144px;text-align:right;" class="input" value="" dataformat="float" pointcount="3" maxlength="11"><!--  
								--><input type="text" name="wgt_ut_cd2" id="wgt_ut_cd2" style="width:65px;" class="input2" value="" readonly>
							</td>
							<td><input type="checkbox" name="modi_atms_flg" id="modi_atms_flg" class="trans"><label for= "modi_atms_flg"><b>Modified CA (MA)</b></label></td>
						</tr>
						
						<tr>
							<th>DG container S/N</th>
							<td><input type="text" name="rf_dcgo_seq" id="rf_dcgo_seq" style="width:60px;text-align:right;" class="input2" value="" readOnly><!--  
								--><button type="button" name="dg_container_seq" id="dg_container_seq" class="input_seach_btn"></button><!--
								--><button type="button" class="btn_etc" name="btn_dg_seq_del" id="btn_dg_seq_del">Del</button>
							</td>
							<td><input type="checkbox" name="humid_ctrl_flg" id="humid_ctrl_flg" class="trans"><label for= "humid_ctrl_flg"><b>Humidity Control (HM)</b></label>
							</td>
						</tr>
						
						<tr>
							<th>Sensitive Cargo</th>
							<td>
								<select name="sns_cgo_knd_cd" id="sns_cgo_knd_cd" style="width:120px;" class="input">
									 <option value=""></option>
									 <option value="B">blood plasma</option>
									 <option value="I">ice cream</option> 
									 <option value="U">USDA</option>
								</select>  
							</td>
							<td>
							</td>
						</tr>
						
						
						<tr>
							<th>Approval Ref. No.</th>
							<td><input name="aply_no" id="aply_no" type="text" style="width:212px;" class="input" value="" readonly></td>
							<td><strong>Drain</strong>&nbsp;&nbsp;<select name="cntr_drn_cd" id="cntr_drn_cd" style="width:65px;" class="input">
									 <option value="N">N/A</option>
									 <option value="O" >Open</option> 
									 <option value="C" >Close</option>
								</select>
							</td>
						</tr>
					</tbody>
				</table>
				
				<!-- opus_design_btn(S) -->
				<div class="opus_design_grid" style="text-align:right;">
				    <button type="button" class="btn_etc" name="btn_Remark" id="btn_Remark">Remark(s)</button><!-- 
				     --><button type="button" class="btn_etc" name="btn_RequestCancel" id="btn_RequestCancel">Request Cancel</button>
				</div>
				<!-- opus_design_btn(E) -->
	       </div>
	       <!-- opus_design_inquiry(E) -->
	   </div>
	   <!-- layout_flex_flex(E) -->
	</div>
	<!-- layout_wrap(E) -->
</div>

<div class="opus_design_grid">
           <script type="text/javascript">ComSheetObject('sheet3');</script>
       </div>
       <div class="opus_design_grid">
           <script type="text/javascript">ComSheetObject('sheet4');</script>
       </div>


<script>
	if(typeof(document.getElementById("title")) != "undefined"){
		document.getElementById("title").innerHTML = curTitle;
		document.body.className ="popup_bg";
	}
</script>

<div id="layList" name="layList" style="position:absolute;z-index:999;display:none" CELLPADDING="5" CELLSPACING="0" BORDER="0">
	<IFRAME id="ifrm" name="ifrm" src="apps/opus/esm/bkg/bookingcommon/bookingutil/jsp/esm_booking_split_no.html"  frameborder=0 marginHeight=0 marginWidth=0 width=115 height=82  style="position:absolute;border:1 #e9e9e9 solid" CELLSPACING=0 scrolling="no"></IFRAME>
</div>
	
</form>
