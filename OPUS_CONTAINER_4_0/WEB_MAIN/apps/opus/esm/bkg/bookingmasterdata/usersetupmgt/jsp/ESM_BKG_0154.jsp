<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_BKG_0154.jsp
*@FileTitle  : Client Default for Booking 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/07
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.core.controller.util.WebKeys"%>
<%@ page import="com.clt.framework.core.view.template.Screen"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.event.EsmBkg0154Event"%>
<%@ page import="com.clt.apps.opus.esm.bkg.common.HTMLUtil" %>
<%@ page import="org.apache.log4j.Logger" %>
 
<%
	EsmBkg0154Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//serverException
	String strErrMsg = "";						//error massage
	int rowCount	 = 0;						//DB ResultSet list count
	String successFlag = "";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String screenName		= "";
	Logger log = Logger.getLogger("com.clt.apps.BookingMasterData.UserSetupMgt");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
		event = (EsmBkg0154Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		//when open screen, get data in server..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		//log.debug("===>>"+eventResponse.getEventName()); 
		
		log.debug("====================================");
		Screen screen = (Screen) request.getAttribute(WebKeys.CURRENT_SCREEN);
		screenName = screen.getName();
		log.debug("====================================");
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="screenName" value="<%=screenName %>">
<input type="hidden" name="bl_prn_chg_tp_cd" value="">


<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->

	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_save" id="btn_save">Save</button>				
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->


<!-- wrap_search(S) -->
<div class="wrap_search">
	<div class="opus_design_inquiry wFit" id="mainTable">
	
		<table>
			<tbody>
				<colgroup>
					<col width="70"></col>
					<col ></col>
				</colgroup>
				<tbody>
					<tr>
						<th>User ID</th>
						<td><input type="text" style="width:110px;" class="input2" value="<%=strUsr_id%>" readonly><!-- 
							--><input type="text" style="width:200px;" class="input2" value="<%=strUsr_nm%>" readonly></td>
					</tr> 
				</tbody>
		</table>

	</div>
</div>
<!-- wrap_search(E) -->


<!-- wrap_result(S) -->
<div class="wrap_result">
		
	<!-- mainTable (S) -->
	<div id="mainTable" name="mainTable">
	
		<!-- 1ST (S) -->
		<div class="opus_design_inquiry wFit ">
			<h3 class="title_design">Booking Main</h3>
			<table>
				<tbody>
					<tr>
						<th>Receiving Term</th>
						<td><script type="text/javascript" >ComComboObject('rcv_term_cd', 2, 60, 1)</script></td>
						<th>Delivery Term</th>
						<td><script type="text/javascript" >ComComboObject('de_term_cd', 2, 60, 1)</script></td>
						<th>Empty P/UP CY</th>
						<td><input type="text" name="mty_pkup_yd_cd" id="mty_pkup_yd_cd" style="width:80px;" class="input" value="" style="ime-mode:disabled" caption="Empty P/UP CY" maxlength="7" dataformat="engup"></td>
						<th>EQ TY/SZ</th>
						<td><input type="text" name="cntr_tpsz_cd" id="cntr_tpsz_cd" style="width:58px;" class="input" value="" style="ime-mode:disabled" caption="EQ TY/SZ" maxlength="4" dataformat="engup"></td>
						<th>Weight Unit</th>
						<td><%=JSPUtil.getCodeCombo("wgt_ut_cd", "", "", "CD00775", 0, "")%></td>	
						<th>Measure Unit</th>
						<td><%=JSPUtil.getCodeCombo("meas_ut_cd", "", "", "CD01116", 0, "")%></td>
						<th>Auto EDI Hold</th>
						<td><input type="checkbox" name="auto_edi_hld_flg" id="auto_edi_hld_flg" value="" class="trans"></td>
					</tr> 
				</tbody>
			</table>
			<table>
				<tbody>
					<tr>
						<th style="width:63px;">Charge</th>
						<td style="width:50px;"><input type="checkbox" id="cho_chg_0" name="cho_chg_0" onclick="onCheck(this);" class="trans"><label for="cho_chg_0">All</label></td>
						<td style="width:60px;"><input type="checkbox" id="cho_chg_1" name="cho_chg_1" onclick="onCheck(this);" class="trans"><label for="cho_chg_1">Collect</label></td>
						<td style="width:60px;"><input type="checkbox" id="cho_chg_2" name="cho_chg_2" onclick="onCheck(this);" class="trans"><label for="cho_chg_2">Prepaid</label></td>
						<td style="width:60px;"><input type="checkbox" id="cho_chg_3" name="cho_chg_3" onclick="onCheck(this);" class="trans"><label for="cho_chg_3">No Charge</label></td>
						<td ><input type="checkbox" id="cho_chg_4" name="cho_chg_4" onclick="onCheck(this);" class="trans"><label for="cho_chg_4">Freight As Arranged</label></td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- 1ST (E) -->
	
	
		<!-- 2ND (S) -->
		<div class="opus_design_inquiry wFit ">
			<h3 class="title_design" style="display:none;">Booking Receipt Notice</h3>
			<table>
				<tbody>
					<tr style="display:none">
						<td><input type="checkbox" name="rtn_cct_dp_flg" id="rtn_cct_dp_flg" value="" class="trans">&nbsp;&nbsp;&nbsp;Cargo Cut-off (Return CY)</td>
						<td><input type="checkbox" name="tml_cct_dp_flg" id="tml_cct
						_dp_flg" value="" class="trans">&nbsp;&nbsp;&nbsp;Cargo Cut-off (Terminal CY)</td>
						<td><input type="checkbox" name="doc_cct_dp_flg" id="doc_cct_dp_flg" value="" class="trans">&nbsp;&nbsp;&nbsp;Documentation Cut-off Time</td>
						<td colspan="3"></td>
					</tr>
					
					<tr style="display:none">
						<td><input type="checkbox" name="xpt_cstms_cct_dp_flg" id="xpt_cstms_cct_dp_flg" value="" class="trans">&nbsp;&nbsp;&nbsp;Export Customs Cut-off Time</td>
						<td><input type="checkbox" name="rail_cct_dp_flg" id="rail_cct_dp_flg" value="" class="trans">&nbsp;&nbsp;&nbsp;Rail Cut-off Time</td>
						<td colspan="4"></td>
					</tr>
					
					<tr style="display:none"><th colspan="6" >Draft B/L</th></tr>
					
					<tr style="display:none">
						<td><input type="checkbox" name="drft_bl_xch_rt_dp_flg" id="drft_bl_xch_rt_dp_flg" value="" class="trans">&nbsp;&nbsp;&nbsp;Exchange Rate</td>
						<td><input type="checkbox" name="drft_bl_call_sgn_dp_flg" id="drft_bl_call_sgn_dp_flg" value="" class="trans">&nbsp;&nbsp;&nbsp;Call Sign</td>
						<td colspan="4"></td>
					</tr>
					
					<tr style="display:none">
						<td colspan="6">Remark. <textarea name="drft_bl_rmk" id="drft_bl_rmk" cols="10" rows="3" style="width:375px;" class=""></textarea></td>
					</tr>
				</tbody>
			</table>
			
			<h3 class="title_design">Arrival Notice</h3>
			<table>
				<tbody>
					<tr>
						<td style="width:175px;">
							<input type="checkbox" name="an_prn_rt_flg" id="an_prn_rt_flg" value="" class="trans">&nbsp;&nbsp;Display Collect Charge</td>
				</tr>
				<tr>
						<td><textarea  name="an_rmk" id="an_rmk"  rows="3" style="width:100%"></textarea></td>
					</tr>
				</tbody>
			</table>					
			
		</div>
		<!-- 2ND (E) -->
		
		
		<!-- 3RD (S) -->
		<div class="opus_design_inquiry wFit ">
			<h3 class="title_design">Receiving mail copy option</h3>
			<table>
				<tbody>
					<tr>
						<th style="width:80px;">Booking : </th>
						<td><input type="checkbox" name="bkg_rct_ntc_rcv_flg" id="bkg_rct_ntc_rcv_flg" value="" class="trans">&nbsp;&nbsp;&nbsp;Booking Receipt Notice</td>
						<td><input type="checkbox" name="mty_rlse_ord_rcv_flg" id="mty_rlse_ord_rcv_flg" value="" class="trans">&nbsp;&nbsp;&nbsp;Empty Release Order</td>
						<td colspan="3"><input type="checkbox" name="tro_ntc_rcv_flg" id="tro_ntc_rcv_flg" value="" class="trans">&nbsp;&nbsp;&nbsp;TRO Notice</td>
					</tr>
					<tr>
						<th>Document : </th>
						<td><input type="checkbox" name="drft_wbl_rcv_flg" id="drft_wbl_rcv_flg" value="" class="trans">&nbsp;&nbsp;&nbsp;Draft & Waybill</td>
						<td><input type="checkbox" name="srnd_ntc_rcv_flg" id="srnd_ntc_rcv_flg" value="" class="trans">&nbsp;&nbsp;&nbsp;Surrender Notice</td>
						<td><input type="checkbox" name="an_rcv_flg" id="an_rcv_flg" value="" class="trans">&nbsp;&nbsp;&nbsp;Arrival Notice</td>
						<td><input type="checkbox" name="eur_cgor_flg"  id="eur_cgor_flg" value="" class="trans">&nbsp;&nbsp;&nbsp;EU Cargo Release</td>
						<td><input type="checkbox" name="fcntr_rlse_flg" id="fcntr_rlse_flg" value="" class="trans">&nbsp;&nbsp;&nbsp;Full Container Release</td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- 3RD (E) -->
		

		<!-- 4TH (S) -->
		<!-- 
		<div class="opus_design_inquiry wFit">
			<table>
				<tr><td><img src="img/ico_star.gif" align="absmiddle"><span id="notice">To update Tel, Fax and E-Mail, please go to "Common -> Security -> User Information"</span></td></tr>
			</table>
		</div>
		 -->
		<!-- 4TH (E) -->
		
		
	</div>
	<!-- mainTable (S) -->
	
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="leftTable" style="display:none"><script type="text/javascript">ComSheetObject('sheet1');</script></div>
	<!-- opus_design_grid(E) -->
		
		
</div>
<!-- wrap_result(E) -->
		
		
</form>
