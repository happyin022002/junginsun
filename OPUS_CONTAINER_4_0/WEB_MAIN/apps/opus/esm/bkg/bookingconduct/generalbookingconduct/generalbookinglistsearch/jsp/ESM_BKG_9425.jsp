<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_9425.jsp
*@FileTitle  : MTY BKG Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/17
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.event.EsmBkg9425Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg9425Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//occurring error in server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//list count of DB resultSet 

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.GeneralBookingConduct.GeneralBookingListSearch");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg9425Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//When initial screen loading, adding logic extrat data obtained from the server.
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


<!-- page_title_area(S) -->
<div class="page_title_area clear ">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button>
	</h2>
	<!-- page_title(E) -->

	    <!-- opus_design_btn(S) -->
	    <div class="opus_design_btn"><!--
	    --><button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
	    --><button type="button" class="btn_normal" name="btn_New"   id="btn_New">New</button><!--
	    --><button type="button" class="btn_normal" name="btn_Cntr"   id="btn_Cntr">CNTR Info.</button><!--
	    --><button type="button" class="btn_normal" name="btn_Update"   id="btn_Update">BKG Update</button>
	    </div>
	    <!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->

</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="50" />				
				<col width="180" />				
				<col width="70" />				
				<col width="100" />				
				<col width="70" />
				<col width="100" />				
				<col width="70" />
				<col width="100" />				
				<col width="70" />
				<col width="100" />				
				<col width="70" />
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
		   			<td><input type="radio" name="bkg_date_tp" value="B" class="trans" checked id="bkg_date_tp" />&nbsp;BKG&nbsp;&nbsp;<input type="radio" name="bkg_date_tp" value="E" class="trans" id="bkg_date_tp" />&nbsp;ETA&nbsp;&nbsp;</td>
					<td><input type="text" style="width:80px;" class="input1" name="cre_from_dt" value="" maxlength="10" dataformat="ymd" id="cre_from_dt" />~ <input type="text" style="width:80px;" class="input1" name="cre_to_dt" value="" maxlength="10" dataformat="ymd" id="cre_to_dt" /><button type="button" id="btns_Calendar" name="btns_Calendar" class="calendar ir"></button></td>
					<th>Office</th>
					<td><input type="text" style="width:70px;" class="input" value="" name="bkg_ofc_cd" dataformat="engup" id="bkg_ofc_cd" /></td>
					<th>BKG</th>
					<td><input type="text" style="width:100px;" class="input" value="" name="bkg_no" dataformat="engup" maxlength="13" id="bkg_no" /></td>
					<th> B/L</th>
					<td><input type="text" style="width:95px;" class="input" value="" name="bl_no" dataformat="engup" maxlength="13" id="bl_no" /></td>
					<th>CNTR</th>
					<td><input type="text" style="width:80px;" class="input" value="" name="cntr_no1" dataformat="engup" maxlength="10" id="cntr_no1" /><input type="text" style="width:18px;" class="input" value="" name="cntr_no2" dataformat="num" maxlength="1" id="cntr_no2" /> </td>
		   		</tr>
		   		<tr> 
		   			<th class="sm">VVD CD</th>
					<td class="sm pad_rgt_8"><input type="text" style="width:80px;" class="input" value="" name="vvd_cd" dataformat="engup" maxlength="11" id="vvd_cd" /><input type="radio" name="vvd_cd_flg" value="A" class="trans" checked="" id="vvd_cd_flg" />  All  <input type="radio" name="vvd_cd_flg" value="E" class="trans" id="vvd_cd_flg" />  Excl. Pre/Post</td>
					<th title="Port of Loading">POL</th>
					<td><input type="text" style="width:70px;" class="input" value="" name="pol_cd" dataformat="engup" maxlength="5" id="pol_cd" /></td>
					<th title="Port of Discharging">POD</th>
					<td><input type="text" style="width:70px;" class="input" value="" name="pod_cd" dataformat="engup" maxlength="5" id="pod_cd" /></td>
					<th>Pre</th>
					<td><input type="text" style="width:70px;" class="input" value="" name="pre_rly_port_cd" dataformat="engup" maxlength="5" id="pre_rly_port_cd" /></td>
					<th>Post</th>
					<td><input type="text" style="width:70px;" class="input" value="" name="pst_rly_port_cd" dataformat="engup" maxlength="5" id="pst_rly_port_cd" /></td>
					<th>CNTR Attached</th>
					<td><!-- 
					--><select style="width:60px;"class="input" name="cntr_attach"><!-- 
						--><option value="A" selected>All</option><!-- 
						--><option value="Y">Yes</option><!-- 
						--><option value="N">No</option><!-- 
					--></select><!-- 
					--></td>
		   		</tr>
		   </tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="mainTable">									
	    <script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
<!-- opus_design_grid(E) -->

<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="mainTable" style="display:none">									
	    <script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
<!-- opus_design_grid(E) -->

<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" style="display:none">	    
	    <script type="text/javascript">ComSheetObject('sheet3');</script>
	</div>
<!-- opus_design_grid(E) -->
	<div class="opus_design_grid">
		<div class="layout_wrap">
			<div class="layout_vertical_2" style="width:20%;">
				<div class="opus_design_inquiry">
					<table class="grid_2">
						<tr>
							<th>Total</th>
							<th>TEU</th>
							<td><input type="text" style="width:55px;text-align:right" class="noinput" value="" name="sum_teu" readonly id="sum_teu" /> </td>
							<th>FEU</th>
							<td><input type="text" style="width:55px;text-align:right" class="noinput" value="" name="sum_feu" readonly id="sum_feu" /> </td>
							<th>BOX</th>
							<td><input type="text" style="width:55px;text-align:right" class="noinput" value="" name="sum_box" readonly id="sum_box" /> </td>
						</tr>
					</table>
				</div>
			</div>
			<div class="layout_vertical_2" style="width:10%;">
				<div class="opus_design_inquiry">
				</div>
			</div>			
			<div class="layout_vertical_2" style="width:40%">
				<div class="opus_design_inquiry">
					<table class="grid_2">
						<tr>
							<th>D2</th>
							<td><input type="text" style="width:40px;text-align:right" class="noinput" value="" name="sum_d2" readonly id="sum_d2" /> </td>
							<th>D4</th>
							<td><input type="text" style="width:40px;text-align:right" class="noinput" value="" name="sum_d4" readonly id="sum_d4" /> </td>
							<th>D5</th>
							<td><input type="text" style="width:40px;text-align:right" class="noinput" value="" name="sum_d5" readonly id="sum_d5" /> </td>
							<th>D7</th>
							<td><input type="text" style="width:40px;text-align:right" class="noinput" value="" name="sum_d7" readonly id="sum_d7" /> </td>
							<th>R2</th>
							<td><input type="text" style="width:40px;text-align:right" class="noinput" value="" name="sum_r2" readonly id="sum_r2" /> </td>
							<th>R4</th>
							<td><input type="text" style="width:40px;text-align:right" class="noinput" value="" name="sum_r4" readonly id="sum_r4" /> </td>
							<th>R5</th>
							<td><input type="text" style="width:40px;text-align:right" class="noinput" value="" name="sum_r5" readonly id="sum_r5" /> </td>
							<th>F2</th>
							<td><input type="text" style="width:40px;text-align:right" class="noinput" value="" name="sum_f2" readonly id="sum_f2" /> </td>
						</tr>
						<tr>
							<th>F4</th>
							<td><input type="text" style="width:40px;text-align:right" class="noinput" value="" name="sum_f4" readonly id="sum_f4" /> </td>
							<th>F5</th>
							<td><input type="text" style="width:40px;text-align:right" class="noinput" value="" name="sum_f5" readonly id="sum_f5" /> </td>
							<th>O2</th>
							<td><input type="text" style="width:40px;text-align:right" class="noinput" value="" name="sum_o2" readonly id="sum_o2" /> </td>
							<th>O4</th>
							<td><input type="text" style="width:40px;text-align:right" class="noinput" value="" name="sum_o4" readonly id="sum_o4" /> </td>
							<th>A2</th>
							<td><input type="text" style="width:40px;text-align:right" class="noinput" value="" name="sum_a2" readonly id="sum_a2" /> </td>
							<th>A4</th>
							<td><input type="text" style="width:40px;text-align:right" class="noinput" value="" name="sum_a4" readonly id="sum_a4" /> </td>
							<th>S2</th>
							<td><input type="text" style="width:40px;text-align:right" class="noinput" value="" name="sum_s2" readonly id="sum_s2" /> </td>
							<th>S4</th>
							<td><input type="text" style="width:40px;text-align:right" class="noinput" value="" name="sum_s4" readonly id="sum_s4" /> </td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>
</form>