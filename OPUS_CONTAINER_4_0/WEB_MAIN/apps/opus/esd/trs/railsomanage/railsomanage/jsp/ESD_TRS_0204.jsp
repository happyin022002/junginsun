<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESD_TRS_0204.jsp
*@FileTitle  : USA Rail Billing S/O Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/26
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.trs.railsomanage.railsomanage.event.EsdTrs0201Event"%>
<%
	SignOnUserAccount account = null;
	EsdTrs0201Event  event = null;
	Exception serverException   = null;
	String strErrMsg = "";

	String today = DateTime.getFormatString("yyyyMMdd");
	String beforeOneMonth = DateTime.addDays(today, -30);

	String selFulEmty  = "";
	String selBnd      = "";
	String selLimtInq  = "";
	String selMVMTSTS = "";
	String optionStr = "000020:ALL:ALL";
	String selThrough = ""; //Through
	
	try {
		account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);

		selFulEmty  = JSPUtil.getCodeCombo("sel_edikind", "01", "style=width:'135'", "CD00136", 0, optionStr);
		selBnd  = JSPUtil.getCodeCombo("sel_bnd", "01", "style=width:'47'", "CD00592", 0, optionStr);
		selLimtInq = JSPUtil.getCodeCombo("sel_limtinq", "01", "style=width:'160'", "CD00922", 0, optionStr);
		selMVMTSTS  = JSPUtil.getCodeCombo("cnmv_sts_cd", "01", "style='width:60'", "CD00252", 0, "000020::");
		selThrough = JSPUtil.getCodeCombo("sel_through", "01", "style=width:79 onChange= 'onChange_through(this);'", "CD00934", 0, optionStr);
		
		event = (EsdTrs0201Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		}
		loadPage();
	}
</script>
<script type="text/javascript">
	<%=JSPUtil.getIBCodeCombo("ibd_ipi_locl_ind_cd", "01", "CD00932", 0, "")%>
</script>

<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="hid_frmdate" value="">
<input type="hidden" name="hid_todate" value="">
<input type="hidden" name="ctrl_ofc_cd" value="<%=account.getOfc_cd()%>">
<input type="hidden" name="ctrl_user_id" value="<%=account.getUsr_id()%>">
<input type="hidden" name="hid_trsp_cost_mod_cd">
<input type="hidden" name="hid_ref_id">
<input type="hidden" name="hid_fm_nod_cd">
<input type="hidden" name="hid_to_nod_cd">
<input type="hidden" name="hid_eq_tpsz_cd">
<input type="hidden" name="rail_billing_type" value="">

	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		
		<!-- page_title(S) -->
	    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->
	
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
			--><button type="button" class="btn_normal" name="btn_reset" id="btn_reset">New</button><!--
			--><button type="button" class="btn_normal" name="btn_minimize" id="btn_minimize">Minimize</button>			
		</div>
		<!-- opus_design_btn(E) -->
	
	   	<!-- page_location(S) -->
	   	<div class="location">
	        <span id="navigation"></span>
	   	</div>
	   	<!-- page_location(E) -->
	</div>
	<!-- page_title_area(E) -->
	
<div class="wrap_search">	
	<!-- opus_design_inquiry (S) -->
	<div class="opus_design_inquiry wFit" id="MiniLayer">
		<table>
			<colgroup>
				<col width="100">
				<col width="280">
				<col width="140">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>Date</th>
					<td class="sm pad_left_8"><!--
						--><input type="radio" name="date_sep" id="date_sep_1" value="SC" class="trans" checked><!--
						--><label for="date_sep_1">Service Order Created</label><!--
						--><input type="radio" name="date_sep" id="date_sep_2" value="BU" class="trans"><!--
						--><label for="date_sep_2">Booking Updated</label>
					</td>
					<td class="sm"><!--
						--><input name="frm_plandate" type="text" style="width:75px;" value="<%=beforeOneMonth%>" maxlength="8" onFocus="javascript:delHypen(this);" onBlur="javascript:getHypen(this); getDateBetween(this);" dataformat="ymd">~&nbsp;<!--
						--><input name="to_plandate" type="text" style="width:75px;" value="<%=today%>" maxlength="8" onFocus="javascript:delHypen(this);" onBlur="javascript:getHypen(this);" onKeyup="javascript:doSearchEnter();" dataformat="ymd"><!--
						--><button type="button" class="calendar" id="btns_calendar" name="btns_calendar"></button>									
					</td>
					<td></td>
				</tr>
			</tbody>
		</table>
		<table>
			<colgroup>
				<col width="100">
				<col width="180">
				<col width="100">
				<col width="180">
				<col width="100">
				<!-- <col width="200"> -->
				<col width="50">
				<col width="80">
				<col width="90">
				<col width="100">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>Status</th>
					<td><!--
					--><select name="sel_status" style="width:136px;"><!--
					--><option value="ALL" selected>ALL</option><!--
					--><option value="C">S/O Created</option><!--
					--><option value="R">S/O Updated</option><!--
					--><option value="I">EDI Sent</option><!--
					--></select>
					</td>
					<th>Full/Empty</th>
					<td><%=selFulEmty%></td>
					<th>Bound</th>
					<td><%=selBnd%></td>
					<th>Through</td>
					<td><%=selThrough%></td>
					<th>VVD/POD Unmatch</th>
					<td><select name="sel_unmatch" style="width:116px;">
							<option value="ALL" selected>ALL</option>
							<option value="Y">Y</option>
							<option value="N">N</option>
						</select>
					</td>		
				</tr>
			</tbody>
		</table>
		<table>
			<colgroup>
				<col width="100">
				<col width="180">
				<col width="100">
				<col width="180">
				<col width="100">
				<col width="200">
				<col width="117">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>Rail Origin</th>
					<td>
						<input name="frm_node" id="frm_node" type="text" style="width:47px;" maxlength="5" onChange="getComboList(this, frm_yard, 'F');" dataformat="engup"><!--								
						--><script type="text/javascript">ComComboObject('frm_yard', 1, 56, 0)</script><!--
						--><button type="button" class="input_seach_btn" id="btns_frmnode" name="btns_frmnode"></button>
					</td>
					<th>Rail Destination</th>
					<td>
						<input name="to_node" id="to_node" type="text" style="width:58px;" maxlength="5" onChange="getComboList(this, to_yard, 'T');" dataformat="engup"><!--								
						--><script type="text/javascript">ComComboObject('to_yard', 1, 56, 0)</script><!--
						--><button type="button" class="input_seach_btn" id="btns_tonode" name="btns_tonode"></button>									
					</td>
					<th>Limit of Inquiry</th>
					<td><%=selLimtInq%></td>
					<th>Reference No.</th>
					<td>
						<input name="refer_no" type="text" style="width:116px;" value="" dataformat="engup"><!--
						--><button type="button" class="multiple_inq" id="btns_multirefer" name="btns_multirefer"></button>																	
					</td>
				</tr>
			</tbody>
		</table>
		<table>
			<colgroup>
				<col width="100">
				<col width="180">
				<col width="280">
				<col width="100">
				<col width="180">
				<col width="100">
				<col width="180">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>Service Provider</th>
					<td colspan="2"><input type="radio" class="trans" id="rad_vendor" name="rad_vendor" value="V1" checked onClick="javascript:do_railroad('W');"><label for="rad_vendor">Rail Road</label><!-- 
					 --><input type="radio" class="trans" id="rad_vendor" name="rad_vendor" value="V2" onClick="javascript:do_railroad('R');"><label for="rad_vendor">WRS</label>
					    <div id="SV" style="display:none"> <!-- 
					     --><input name="combo_svc_provider" type="text" style="width:90px;" value="" maxlength="6" onBlur="vendor_blur();"/><!-- 
						 --><input type="text" name="trsp_so_vndr_no" readonly class="input2" style="width:250px;" value=""/><!-- 
						 --><button type="button" class="input_seach_btn" id="btns_vendor" name="btns_vendor"></button>
					    </div>
					    <div id="SV" style="display:inline">
						    <script type="text/javascript">ComComboObject('sel_railroad',2, 90 , 1 )</script><!-- 
						 --><input name="rail_road_name" type="text" style="width:272px;" readonly class="input2" id="rail_road_name" />
					    </div>
					    <!-- <script type="text/javascript">ComComboObject('sel_railroad',2, 90 , 1 )</script>
					<input name="rail_road_name" type="text" style="width:272px;" readonly class="input2" id="rail_road_name" /> -->
					</td>
					<th>Latest MVMT STS</th>
					<td><%=selMVMTSTS %></td>
					<th>Unplanned</th>
					<td><SELECT name = "unplanned">	<!-- 
				     --><OPTION  value="ALL"> ALL</OPTION><!-- 
				     --><OPTION  value="Y"> Y</OPTION><!-- 
				     --><OPTION  value="N"> N</OPTION><!-- 
				     --></SELECT></td>
				    <td></td>
				</tr>
			</tbody>
		</table>
		<table>
			<colgroup>
				<col width="100">
				<col width="180">
				<col width="100">
				<col width="180">
				<col width="100">
				<col width="210">
				<col width="100">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>T.VVD</th>
					<td>
						<input name="trunk_vvd" type="text" style="width:106px;" value="" onKeyup="javascript:doSearchEnter();" dataformat="engup"><!--
						--><button type="button" class="multiple_inq" id="btns_multivvd" name="btns_multivvd"></button><!--
						--><button type="button" class="input_seach_btn" id="btns_tvvd" name="btns_tvvd"></button>
					</td>
					<th>Booking No.</th>
					<td>
						<input name="bkg_no" type="text" style="width:116px;" onKeyup="javascript:doSearchEnter();" dataformat="engup"><!--
						--><button type="button" class="multiple_inq" id="btns_multibkg" name="btns_multibkg"></button>									
					</td>
					<th>B/L No.</th>
					<td>
						<input name="bill_no" type="text" style="width:140px;" onKeyup="javascript:doSearchEnter();" dataformat="engup"><!--
						--><button type="button" class="multiple_inq" id="btns_multibl" name="btns_multibl"></button>									
					</td>
					<th>Container No.</th>
					<td>
						<input name="cntr_no" type="text" style="width:90px;" onKeyup="javascript:doSearchEnter();" onChange="javascript:this.value=cntrCheckDigit(this.value);" dataformat="engup"><!--
						--><button type="button" class="multiple_inq" id="btns_multibl" name="btns_multicntr"></button>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry (E) -->
</div>	

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="mainTable">
		<!-- opus_grid_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btng_declarant" id="btng_declarant">Declarant</button><!--
			--><button type="button" class="btn_normal" name="btng_modstcc" id="btng_modstcc">Modify STCC</button><!--
			--><button type="button" class="btn_normal" name="btng_sodelete" id="btng_sodelete">S/O Delete</button><!--						
			--><button type="button" class="btn_normal" name="btng_irgadjust" id="btng_irgadjust">IRG Adjust</button>
			<!--
			<button type="button" class="btn_normal" name="btng_ediresend_tti" id="btng_ediresend_tti">EDI Re-sending to TTI</button>
			-->
			<!--
			--><button type="button" class="btn_normal" name="btng_socorrection" id="btng_socorrection">S/O Correction</button><!--
			--><button type="button" class="btn_normal" name="btng_downexcel" id="btng_downexcel">Down Excel</button>
		</div>
		<!-- opus_grid_btn(E) -->
		<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <script type="text/javascript">ComSheetObject('sheet');</script>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->	    
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>
