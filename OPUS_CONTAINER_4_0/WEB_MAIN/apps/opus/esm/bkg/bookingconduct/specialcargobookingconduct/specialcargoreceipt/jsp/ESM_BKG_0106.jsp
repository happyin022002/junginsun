<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : esm_bkg_0106.jsp
*@FileTitle : Awakward Cargo Application
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/11
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.event.EsmBkg0106Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.core.controller.util.WebKeys"%>
<%@ page import="com.clt.framework.core.view.template.Screen"%>

<%
	EsmBkg0106Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

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

		event = (EsmBkg0106Event)request.getAttribute("Event");
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

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="temp_cntr_no" id="temp_cntr_no">
<input type="hidden" name="temp_grs_wgt" id="temp_grs_wgt">
<input type="hidden" name="temp_net_wgt" id="temp_net_wgt" value="0">
<input type="hidden" name="title_id" id="title_id" value="bb">
<input type="hidden" name="diff_rmk" id="diff_rmk" value="">
<input type="hidden" name="row_cnt" id="row_cnt" value="">
<input type="hidden" name="button" id="button" value="N">
<input type="hidden" name="old_bkg_no" id="old_bkg_no" value="">
 
<input type="hidden" name="isInquiry" id="isInquiry" value="<%=isInquiry%>">

<!-- 제목 -->
<div class="page_title_area clear">
		<!-- page_title(S) -->
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<% if("true".equals(mainPage)){ %>
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<% } else { %>
		<h2 class="page_title">B.Bulk Cargo Application</h2>
		<% } %>
		<!-- page_title(E) -->

		<!-- btn_div -->
	<div class="opus_design_btn">
	    <button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
	    --><button type="button" class="btn_normal" name="btn_attach_file" id="btn_attach_file">Attach File</button><!--
	    --><button type="button" class="btn_normal" name="btn_terminal_information" name="btn_terminal_information">Terminal Information</button><!--
	    --><button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button><!--
	    --><button type="button" class="btn_normal" name="btn_Request" id="btn_Request">Request</button>
	</div>
	<div class="location">
		<span id="navigation"></span>
	</div>
</div>
<!-- 제목 -->

<div class="wrap_search">
	<div class="opus_design_inquiry wFit">
		<!--  biz_1  (S) -->
		<table border="0" style="width:979px;"> 
		<tr>
			<th width="50px" class="align_left">BKG No.</th>
			<td width="130px"><input name="bkg_no" id="bkg_no" type="text" style="width:96px;" class="input1" value="<%=bkgNo%>" maxlength="13"><button type="button" class="btn_down_list" name="btn_splitPop"></button></td>
			<th width="50px" class="align_left">B/L No.</th>
			<td width="130px"><input name="bl_no" id="bl_no" type="text" style="width:113px;" class="input1" value="" maxlength="12"></td> 
			<th width="125px" class="align_left">Requested by/Date</th>
			<td width="220px"><input name="rqst_usr_id" id="rqst_usr_id" type="text" style="width:90px;" class="input2" value="" readonly><input name="rqst_dt" id="rqst_dt" type="text" style="width:115px;" class="input2" value="" readonly></td>
			<td width="155px"><input name="rqst_gdt" id="rqst_gdt" type="text" style="width:115px;" class="input2" value="" readonly>(GMT)</td>
			<th width="60px" class="align_left"> Approval</th>
			<td><input name="auth_cd" id="auth_cd" type="text" style="width:20px;text-align:center;" class="input2_1" value="" readonly><button type="button" class="input_seach_btn" name="btn_approval"></button></td>
		</tr>
		</table>		
	</div>
</div>

<div class="wrap_result">
	<div class="opus_design_inquiry">			
		<table border="0" style="width:979px;"> 
		<tr>			
			<th width="50px" class="align_left">T/VVD</th>
			<td width="130px"><input name="tvvd" id="tvvd" type="text" style="width:90px;" class="input2" value="" readonly></td>
			<th width="20px" class="align_left">POL</th>
			<td width="92px">
				<input name="pol_cd" id="pol_cd" type="text" style="width:50px;" class="input2" value="" readonly><!-- 
				 --><input name="pol_nod_cd" id="pol_nod_cd" type="text" style="width:30px;" class="input2" value="" readonly>
			</td> 
			<td width="80px">
				<button type="button" class="btn_etc" name="btn_pol_cd" id="btn_pol_cd">Info.</button>				
			</td>
			<th width="30px" class="align_left">POD</th>
			<td width="92px">
				<input name="pod_cd" id="pod_cd" type="text" style="width:50px;" class="input2" value="" readonly><!-- 
				 --><input name="pod_nod_cd" id="pod_nod_cd" type="text" style="width:30px;" class="input2" value="" readonly>
			</td>
			<td width="*">
				<button type="button" class="btn_etc" name="btn_pod_cd" id="btn_pod_cd">Info.</button>				
			</td>			
		</tr>
		</table>
		<!--  biz_1   (E) -->

<table class="line_bluedot"><tr><td></td></tr></table>

	<!--  biz_2_1  (S) -->			
		<table style="width:500px;"> 
			<tr>
				<td width="495px" valign="top">
					<!--  biz_2_1_1  (S) -->
					<div class="layout_wrap"> 
   						 <div class="pad_rgt_8 layout_flex_fixed" style="width:245px">
   						 	<div class="opus_design_grid ">
								<script type="text/javascript">ComSheetObject('sheet1');</script>
							</div>
						</div>
						 <div class="layout_flex_fixed" style="width:245px">
						 	<div class="opus_design_grid ">
								<script type="text/javascript">ComSheetObject('sheet2');</script>
							</div>
							<div class="opus_design_btn">
						 		<button type="button" class="btn_etc" name="btn_cntr_add" id="btn_cntr_add">Row Add</button><!--
				    			--><button type="button" class="btn_etc" name="btn_cntr_delete" id="btn_cntr_delete">Row Delete</button>
				    		</div>	
						</div>
						
						
					</div>	
 					<!-- Button_Sub (E) -->
					<!--  biz_2_1_2  (E) -->
					
				</td>
			</tr>
		</table>
		<!--  biz_2_1  (E) -->

		<table class="line_bluedot"><tr><td></td></tr></table>
		
		<div class="layout_wrap" > 
			 <div class="layout_vertical_2 pad_btm_8 layout_flex_fixed" style="width:490px">
				<div class="opus_design_grid">
					<script type="text/javascript">ComSheetObject('sheet3');</script>
					<script type="text/javascript">ComSheetObject('sheet4');</script>							
					<script type="text/javascript">ComSheetObject('sheet5');</script>
				</div>
				
				<div class="opus_design_btn">
						<button type="button" class="btn_etc" name="btn_cargo_add">Row Add</button><!--
						--><button type="button" class="btn_etc" name="btn_cargo_delete">Row Delete</button><!--
						--><button type="button" class="btn_etc" name="btn_Copy">Copy</button>							
				</div>

				<table style="width:480px;"> 
					<tr class="h23">
						<th width="80px" class="align_left">Total Weight</th>
						<td width="230px"><input name="weight_sum" id="weight_sum" type="text" style="width:120px;text-align:right;" class="input2" value="" readonly><!--  
							--><script type="text/javascript">ComComboObject('wgt_ut_cd', 1, 55, 1, 0, 0)</script></td>
						<th width="70px" class="align_left">Void Space</th>
						<td width="*"><input name="ovr_void_slt_qty" id="ovr_void_slt_qty" type="text" style="width:60px;text-align:right;" class="input1" value="" dataformat="num"><input type="text" style="width:35px;" class="input2" value=" FEU" readOnly></td>
					</tr>
				</table>
			</div>
			<!--  Button_Sub (S) -->
			<div class="layout_vertical_2 mar_left_12" style="width:490px">
				<table style="width:480px;"> 
					<tr>
						<th width="294px"  class="align_left">Detail Information For Cargo Sequence&nbsp;<input name="Seq" id="Seq" type="text" style="width:20px;" class="input2" value=""></th>
						<th width="102px"  class="align_left">Break Bulk Term</th>
						<td width="*" nowrap>
							<script type="text/javascript">ComComboObject('rcv_term_cd', 2, 34, 1, 0, 0)</script>
							<script type="text/javascript">ComComboObject('de_term_cd', 2, 34, 1, 0, 0)</script>
						</td>
					</tr>
				</table>
				
				<table border="0" style="width:480px;"> 
					<tr>
						<th width="70px" class="align_left">Commodity</th>
						<td width="*"><input name="cmdt_cd" id="cmdt_cd" type="text" style="width:55px;" class="input1" value="" maxlength="6" dataformat="num"><input name="cmdt_nm" id="cmdt_nm" type="text" style="width:310px;" class="input1" value="" readonly><button type="button" class="input_seach_btn" name="btn_cmdt"></button></td>
					</tr>
				</table>
				<table border="0" style="width:480px;"> 
					<tr>
						<th width="70px" class="align_left">Sling Point</th>
						<td width="90px" style="padding-left:2px;">
							<select name="slng_pnt_flg" id="slng_pnt_flg" style="width:50px;">
							<option value="Y">Y</option>
							<option value="N">N</option>
							</select>
						</td>
						<th width="110px" class="align_left">Center Of Gravity</th>
						<td width="*"><input name="grav_ctr_desc" id="grav_ctr_desc" type="text" style="width:205px;" class="input" value="" maxlength="100"></td>
					</tr>
				</table>
				<table border="0" style="width:480px;"> 
					<tr>
						<th width="130px" class="align_left">Cargo Packing Detail</th>
						<td width="*"><input name="pck_dtl_desc" id="pck_dtl_desc" type="text" style="width:347px;" class="input" value="" maxlength="4000"></td>
					</tr>
				</table>
				<table border="0" style="width:480px;"> 
					<tr >
						<th width="130px" class="align_left">Loading Method</th>
						<td width="162px"><script type="text/javascript">ComComboObject('cgo_lodg_mzd_cd', 2, 100, 1, 0, 0)</script></td>
						<th width="*" class="align_left">DG container S/N&nbsp;<input name="bb_dcgo_seq" id="bb_dcgo_seq" type="text" style="width:53px;" class="input2" value="" readOnly><button type="button" class="input_seach_btn" name="dg_container_seq"></button></th>
					</tr>
				</table>
				<table class="search" border="0" style="width:480px;"> 
					<tr class="h23">
						<th width="130px" class="align_left">Secure & Dunnage</th>
						<td width="*"><input name="scr_dng_ctnt" id="scr_dng_ctnt" type="text" style="width:347px;" class="input" value="" maxlength="1000"></td>
					</tr>
				</table>
				<table border="0" style="width:480px;"> 
					<tr>
						<th width="130px" class="align_left">Special Request</th>
						<td width="*"><input name="spcl_rqst_desc" id="spcl_rqst_desc" type="text" style="width:347px;" class="input" value=" " maxlength="4000"></td>
					</tr>
					<tr>
						<th width="" class="align_left">Approval Ref. No.</th>
						<td><input name="aply_no" id="aply_no" type="text" style="width:347px;" class="input" value="" readonly></td>	
					</tr>
				</table>
				<table class="search" border="0" style="width:480px;"> 
					<tr class="h23">
						<td width="285px"></td>
						<td width="*"  class="align_right">
							<button type="button" class="btn_etc" name="btn_Remark" id="btn_Remark">Remark(s)</button><!--  
							--><button type="button" class="btn_etc" name="btn_RequestCancel" id="btn_RequestCancel" >Request Cancel</button>							
						</td>
					</tr>
				</table>
				
			</div>
			
			
		</div>
	</div>
</div>
			
<!--biz page (E)-->
<span style="display:none"><script type="text/javascript">ComSheetObject('sheet6');</script></span>		
<div id="layList" name="layList" style="position:absolute;z-index:999;display:none" CELLPADDING="5" CELLSPACING="0" BORDER="0">
<IFRAME id="ifrm" name="ifrm" src="apps/opus/esm/bkg/bookingcommon/bookingutil/jsp/esm_booking_split_no.html"  frameborder=0 marginHeight=0 marginWidth=0 width=115 height=82  style="position:absolute;border:1 #e9e9e9 solid" CELLSPACING=0 scrolling="no"></IFRAME>
</div>	
</form>

