<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESD_TRS_0201.jsp
*@FileTitle  : USA Rail Billing S/O creation
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
	String selMVMTSTS = "";
	try {
		selMVMTSTS  = JSPUtil.getCodeCombo("cnmv_sts_cd", "01", "style='width:60'", "CD00252", 0, "000020::");
		
		account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
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

<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="hid_frmdate" value="">
<input type="hidden" name="hid_todate" value="">
<input type="hidden" name="ctrl_user_id" value="<%=account.getUsr_id()%>">
<input type="hidden" name="rail_billing_type" value="C">
<input type="hidden" name="eq_no_verify" value="">
<input type="hidden" name="rail_billing_type" value="F"/>

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
			<!-- location 내용 동적생성 (별도 코딩 불필요) -->
	        <span id="navigation"></span>
	   	</div>
	   	<!-- page_location(E) -->
	</div>
	<!-- page_title_area(E) -->
	
	<!-- opus_design_inquiry(S) -->
<div class="wrap_search">
	<div class="opus_design_inquiry" id="MiniLayer">
		<!--  MiniLayer (S) -->
		<table>
			<colgroup>
	            <col width="50px" />
	            <col width="178px" />
	            <col width="65px" />
	            <col width="165px" />
	            <col width="98px" />
	            <col width="163px" />
	            <col width="101px" />
	            <col width="111px" />	            
	            <col width="" />
			</colgroup>
			<tbody>
				<tr>
					<th>T.VVD</th>
					<td><input name="trunk_vvd" type="text" style="width:104px;" value="" onBlur="setgetUpper(this);" onKeyup="javascript:doSearchEnter();" dataformat="engup"><!--
						--><button type="button" class="multiple_inq" id="btns_multivvd" name="btns_multivvd"></button><!--
						--><button type="button" class="input_seach_btn" id="btns_tvvd" name="btns_tvvd"></button>
					</td>
					<th>B/L No.</th>
					<td><input name="bill_no" type="text" style="width:112px;" onBlur="setgetUpper(this);" onKeyup="javascript:doSearchEnter();" dataformat="engup"><!--
						--><button type="button" class="multiple_inq" id="btns_multibl" name="btns_multibl"></button>
					</td>
					<th>Booking No.</th>
					<td><input name="bkg_no" type="text" style="width:115px;" onBlur="setgetUpper(this);" onKeyup="javascript:doSearchEnter();" dataformat="engup"><!--
						--><button type="button" class="multiple_inq" id="btns_multibkg" name="btns_multibkg"></button>									
					</td>
					<th>Container No.</th>
					<td><input name="cntr_no" type="text" style="width:118px;" onKeyup="javascript:doSearchEnter();" onBlur="setgetUpper(this);" onChange="javascript:this.value=cntrCheckDigit(this.value);" dataformat="engup"><!--
						--><button type="button" class="multiple_inq" id="btns_multicntr" name="btns_multicntr"></button>									
					</td>
					<td></td>
				</tr>
			</tbody>
		</table>
		<table>
			<colgroup>
	            <col width="155px" />
	            <col width="215px" />
	            <col width="65px" />
	            <col width="85px" />
	            <col width="130px" />
	            <col width="155px" />
	            <col width="80px" />
	            <col width="83px" />	            
	            <col width="" />
			</colgroup>
			<tbody>
				<tr>
					<th>Planned Departure Date</th>
					<td><input name="frm_plandate" type="text" style="width:75px;" value="" maxlength="8" onFocus="javascript:delHypen(this);" onBlur="javascript:getHypen(this); getDateBetween(this);" dataformat="ymd">~&nbsp;<!--
						--><input name="to_plandate" type="text" style="width:75px;" value="" maxlength="8" onFocus="javascript:delHypen(this);" onBlur="javascript:getHypen(this);" onKeyup="javascript:doSearchEnter();" dataformat="ymd"><!--
						--><button type="button" class="calendar" id="btns_calendar" name="btns_calendar"></button>
					</td>
					<th>Customs</th>
					<td><select name="sel_customs" style="width:60px;">
							<option value="ALL">ALL</option>
							<option value="LOC">LOCAL</option>
							<option value="WIT">W / IT</option>
						</select>
					</td>
					<th>Service Contract No.</th>
					<td><input name="sc_no" type="text" style="width:111px;" onKeyup="javascript:doSearchEnter();" onBlur="setgetUpper(this);" onChange="javascript:this.value=cntrCheckDigit(this.value);" dataformat="engup"><!--
						--><button type="button" class="multiple_inq" id="btns_multisc" name="btns_multisc"></button>									
					</td>
					<th>Office Code</th>
					<td><input name="ctrl_ofc_cd" type="text" style="width:83px;" value="<%=account.getOfc_cd()%>" onBlur="setgetUpper(this);" readonly>
					</td>
					<td></td>
				</tr>
			</tbody>
		</table>
		<table>
			<colgroup>
			    <col width="50px"></col>
			    <col width="54px"></col>
			    <col width="124px"></col>
			    <col width="65px"></col>
			    <col width="59px"></col>
			    <col width="106px"></col>
			    <col width="109px"></col>
			    <col width="108px"></col>
			    <col width="*"></col>
			</colgroup>
			<tbody>
				<tr>
					<th title="Port of Discharging">POD</th>
					<td><input name="pod_node" type="text" style="width:50px;" maxlength="5" onchange="getComboList(this,pod_yard, 'P');" dataformat="engup"><!--								
						--><script type="text/javascript">ComComboObject('pod_yard', 1, 51, 0)</script><!--
						--><button type="button" class="input_seach_btn" id="btns_podnode" name="btns_podnode"></button>
					</td>
					<th>Rail Origin</th>
					<td><input name="frm_node" type="text" style="width:55px;" maxlength="5" onchange="getComboList(this,frm_yard,'F');" dataformat="engup"><!--								
						--><script type="text/javascript">ComComboObject('frm_yard', 1, 55, 0)</script><!--
						--><button type="button" class="input_seach_btn" id="btns_frmnode" name="btns_frmnode"></button>									
					</td>
					<th>Rail Destination</th>
					<td >
						<input name="to_node" type="text" style="width:64px;" maxlength="5" onchange="getComboList(this,to_yard,  'T');" dataformat="engup"><!--								
						--><script type="text/javascript">ComComboObject('to_yard', 1, 49, 0)</script><!--
						--><button type="button" class="input_seach_btn" id="btns_tonode" name="btns_tonode"></button>									
					</td>
					<th>Delivery</th>								
					<td><input name="del_node" type="text" style="width:64px;" maxlength="5" onchange="getComboList(this,del_yard,  'D');" dataformat="engup"><!--
						--><script type="text/javascript">ComComboObject('del_yard', 1, 49, 0)</script><!--
						--><button type="button" class="input_seach_btn" id="btns_delnode" name="btns_delnode"></button>									
					</td>
					<td><input type="checkbox" name="rvis_ind_flg" id="rvis_ind_flg" value="Y" style="vertical-align:text-bottom;"/>&nbsp;<span style="font-weight:bold;vertical-align:text-top;">Revised</span></td>
				</tr>
				<tr>
					<th title="Booking Special Cargo">BKG SPE</th>
					<td><script type="text/javascript">ComComboObject('bkg_spe', 1, 105, 0)</script></td>
					<th>Latest MVMT STS</th>
					<td><%=selMVMTSTS %></td>
					<td><input type="checkbox" name="unplanned" id="unplanned" value="Y" style="vertical-align:text-bottom;"/>&nbsp;<span style="font-weight:bold;vertical-align:text-top;">Unplanned</span></td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
	<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<div class="opus_design_grid" id="mainTable">
		<!-- opus_grid_btn(S) -->
		<div class="opus_design_btn">
				<button type="button" class="btn_normal" name="btng_declarant" id="btng_declarant">Declarant</button><!--
			--><button type="button" class="btn_normal" name="btng_modstcc" id="btng_modstcc">Modify STCC</button><!-- 
			--><button type="button" class="btn_normal" name="btng_downexcel" id="btng_downexcel">Down Excel</button><!--
			--><button type="button" class="btn_normal" name="btng_irgadjust" id="btng_irgadjust">IRG Adjust</button><!--
			--><button type="button" class="btn_normal" name="btng_socreation" id="btng_socreation">S/O Creation</button>
		</div>
	    <script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<div class="opus_design_grid" id="mainTable">		
	    <script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
</div>
</form>