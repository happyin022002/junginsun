<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESD_TRS_0202.jsp
*@FileTitle  : USA Rail Billing S/O
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
	Exception serverException  = null;
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
	} catch(Exception e) {
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
	<%=JSPUtil.getIBCodeCombo("auto_xpt_sys_cd", "01", "CD00850", 0, "")%>
</script>

<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="hid_frmdate" value="">
<input type="hidden" name="hid_todate" value="">
<input type="hidden" name="ctrl_user_id" value="<%=account.getUsr_id()%>">
<input type="hidden" name="eq_no_verify" value="">
<input type="hidden" name="to_nod_verify" value="">
<input type="hidden" name="rail_billing_type" value="F"/>

	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
			--><button type="button" class="btn_normal" name="btn_reset" id="btn_reset">New</button><!--
			--><button type="button" class="btn_normal" name="btn_minimize" id="btn_minimize">Minimize</button>			
		</div>
	   	<div class="location">
	        <span id="navigation"></span>
	   	</div>
	</div>
	<div class="wrap_search">
	<div class="opus_design_inquiry wFit" id="MiniLayer">
		<table>
			<tr>
				<td>
					<table>
						<colgroup>				            
				            <col width="160" />
				            <col width="200" />	            
				            <col width="" />
						</colgroup>
						<tbody>
							<tr>
								<th>Planned Departure Date</th>
								<td>
									<input name="frm_plandate" type="text" style="width:75px;" value="" maxlength="8" onFocus="javascript:delHypen(this);" onBlur="javascript:getHypen(this); getDateBetween(this);" dataformat="ymd">~&nbsp;<!--
									--><input name="to_plandate" type="text" style="width:75px;" value="" maxlength="8" onFocus="javascript:delHypen(this);" onBlur="javascript:getHypen(this);" onKeyup="javascript:doSearchEnter();" dataformat="ymd"><!--
									--><button type="button" class="calendar" id="btns_calendar" name="btns_calendar"></button>
								</td>
								<td></td>
							</tr>
						</tbody>
					</table>
				</td>
			</tr>
			<tr>
				<td>
					<table>
						<colgroup>				            
				            <col width="46"/>
				            <col width="190"/>
				            <col width="83"/>
				            <col width="191"/>
				            <col width="101"/>
				            <col width="170"/>
				            <col width="80"/>
				            <col width="150"/>
				            <col width="120"/>
				            <col width="*"/>
						</colgroup>
						<tbody>
							<tr>
								<th>T.VVD</th>
								<td>
									<input name="trunk_vvd" type="text" style="width:80px;" value="" onKeyup="javascript:doSearchEnter();" dataformat="engup"><!--
									--><button type="button" class="multiple_inq" id="btns_multivvd" name="btns_multivvd"></button><!--
									--><button type="button" class="input_seach_btn" id="btns_tvvd" name="btns_tvvd"></button>									
								</td>
								<th>Booking No.</th>
								<td>
									<input name="bkg_no" type="text" style="width:107px;" onKeyup="javascript:doSearchEnter();" dataformat="engup"><!--
									--><button type="button" class="multiple_inq" id="btns_multibkg" name="btns_multibkg"></button>
								</td>
								<th>Container No.</th>
								<td>
									<input name="cntr_no" type="text" style="width:115px;" onKeyup="javascript:doSearchEnter();" onChange="javascript:this.value=cntrCheckDigit(this.value);" dataformat="engup"><!--
									--><button type="button" class="multiple_inq" id="btns_multicntr" name="btns_multicntr"></button>
								</td>
								<th>Office Code</th>
								<td>
									<input name="ctrl_ofc_cd" type="text" style="width:63px;" value="<%=account.getOfc_cd()%>" onBlur="setgetUpper(this);" readonly>
								</td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<th title="Place of Receipt">POR</th>
								<td>
									<input name="por_node" type="text" style="width:57px;" maxlength="5" onChange="getComboList(this, por_yard, 'R');" dataformat="engup"><!--
									--><script type="text/javascript">ComComboObject('por_yard', 1, 48, 0)</script><!--
									--><button type="button" class="input_seach_btn" id="btns_pornode" name="btns_pornode"></button>									
								</td>
								<th>Rail Origin</th>
								<td>
									<input name="frm_node" type="text" style="width:53px;" maxlength="5" onChange="getComboList(this, frm_yard, 'F');" dataformat="engup"><!--								
									--><script type="text/javascript">ComComboObject('frm_yard', 1, 50, 0)</script><!--
									--><button type="button" class="input_seach_btn" id="btns_frmnode" name="btns_frmnode"></button>	
								</td>
								<th>Rail Destination</th>
								<td>
									<input name="to_node" type="text" style="width:62px;" maxlength="5" onChange="getComboList(this, to_yard, 'T');" dataformat="engup"><!--	
									--><script type="text/javascript">ComComboObject('to_yard', 1, 49, 0)</script><!--	
									--><button type="button" class="input_seach_btn" id="btns_tonode" name="btns_tonode"></button>	
								</td>
								<th title="Port of Loading">POL</th>
								<td>
									<input name="pol_node" type="text" style="width:63px;" maxlength="5" onChange="getComboList(this,pol_yard, 'L');" value="" dataformat="engup"><!--
									--><script type="text/javascript">ComComboObject('pol_yard', 1, 47, 0)</script><!--
									--><button type="button" class="input_seach_btn" id="btns_polnode" name="btns_polnode"></button>
								</td>
								<td><input type="checkbox" name="rvis_ind_flg" id="rvis_ind_flg" value="Y" style="vertical-align:text-bottom;"/>&nbsp;<span style="font-weight:bold;vertical-align:text-top;">Revised</span></td>
								<td></td>
							</tr>
							<tr>
								<th title="Stop Off">Stop Off</th>
								<td><script type="text/javascript">ComComboObject('stop_off_flg', 1, 57, 0)</script></td>
								<th title="Overweight">Overweight</th>
								<td><script type="text/javascript">ComComboObject('ovr_wgt_flg', 1, 52, 0)</script></td>
								<th title="Restricted">Restricted</th>
								<td><script type="text/javascript">ComComboObject('rest_flg', 1, 60, 0)</script></td>
								<th>Latest MVMT STS</th>
								<td><%=selMVMTSTS %></td>
								<th title="Booking Special Cargo">BKG SPE</th>
								<td><script type="text/javascript">ComComboObject('bkg_spe', 1, 115, 0)</script></td>
								<td><input type="checkbox" name="unplanned" id="unplanned" value="Y" style="vertical-align:text-bottom;"/>&nbsp;<span style="font-weight:bold;vertical-align:text-top;">Unplanned</span></td>
								<td></td>
							</tr>
						</tbody>
					</table>
				</td>
			</tr>
		</table>
	</div>
	</div>
	
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
	<div class="opus_design_grid" id=bkgdtl style="display:none;">		
	    <script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
	<div class="opus_design_grid" id="mainTable"  style="display:none;">
	    <script type="text/javascript">ComSheetObject('sheet3');</script>
	</div>
	</div>
</form>

