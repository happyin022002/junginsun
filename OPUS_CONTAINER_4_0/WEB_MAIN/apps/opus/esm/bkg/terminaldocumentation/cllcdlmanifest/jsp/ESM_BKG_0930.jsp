<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0930.jsp
*@FileTitle  : (Kor)CNTR Loading List (CLL) 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/02
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.event.EsmBkg0930Event"%>
<%@ page import="org.apache.log4j.Logger" %>


<%
	EsmBkg0930Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from the server	
	String strErrMsg = "";						//error messege
	int rowCount	 = 0;						//the number of DB ResultSet List
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String bkgNoList = JSPUtil.getParameter(request,"bkg_no_list");
	String popMode = JSPUtil.getParameter(request,"pop_mode");
	String vgmVvd = JSPUtil.getParameter(request,"vgm_vvd");
	String vgmPol = JSPUtil.getParameter(request,"vgm_pol");
	String lclTs = JSPUtil.getParameter(request,"lcl_ts");
	Logger log = Logger.getLogger("com.clt.apps.TerminalDocumentation.CLLCDLManifest");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EsmBkg0930Event)request.getAttribute("Event");
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


<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="in_bl_cll_data" id="in_bl_cll_data">
<input type="hidden" name="in_cll_type" id="in_cll_type">
<input type="hidden" name="in_bkg_sts_cd" id="in_bkg_sts_cd">
<input type="hidden" name="in_cntr_cfm_flg" id="in_cntr_cfm_flg">
<input type="hidden" name="in_final_edi_flg"  id="in_final_edi_flg" value="N">
<input type="hidden" name="dirty_flg"  id="dirty_flg" value="N">
<input type="hidden" name="bkg_no_list" id="bkg_no_list" value="<%=bkgNoList %>" />
<input type="hidden" name="pop_mode" id="pop_mode" value="<%=popMode %>" />
<input type="hidden" name="vgm_vvd" id="vgm_vvd" value="<%=vgmVvd %>" />
<input type="hidden" name="vgm_pol" id="vgm_pol" value="<%=vgmPol %>" />
<input type="hidden" name="lcl_ts" id="lcl_ts" value="<%=lclTs %>" />


<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title">
		<button type="button"><span id="title">B/L Preview</span></button>
	</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!-- 
		 --><button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_PrintPreview" id="btn_PrintPreview">Print Preview</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Summary" id="btn_Summary">Summary</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Special_CGO" id="btn_Special_CGO">Special CGO</button>
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->


<div class="wrap_search">
<!-- layout_wrap (S) -->
<div class="opus_design_inquiry wFit">
	<div class="layout_wrap">
	    <div class="layout_vertical_2" style="width: 50%;">
			 <div><table><tr><td>
				<table>
					<colgroup>
						<col width="30">
						<col width="100">
						<col width="30">
						<col width="100">
						<col width="40">
						<col width="100">
						<col width="*">
					</colgroup>
					<tbody>
						<tr>
							<th>VVD</th>
							<td><input type="text" style="width:90px" class="input1" dataformat="engup" maxlength="9" value="" name="in_vvd_cd" id="in_vvd_cd" style="ime-mode:disabled"></td>
							<th>POL</th>
							<td><input type="text" style="width:60px" class="input1" dataformat="engup" maxlength="5" value="" name="in_pol_cd" id="in_pol_cd" style="ime-mode:disabled"><input type="text" style="width: 30px; text-align:center" class="input" dataformat="engup" value="" maxlength="2" name="in_pol_yd_cd" id="in_pol_yd_cd" style="ime-mode:disabled"></td>
							<td></td>
							<td><input type="radio" value="" class="trans" name="in_bl_cll_data_tmp" id="B" checked><label for="B"> B/L Data</label><input type="radio" value="" class="trans" name="in_bl_cll_data_tmp" id="D"><label for="D"> Download Data</label></td>
							<td></td>
					</tbody>
				</table>
			</td></tr><tr><td>
				<table>
					<colgroup>
						<col width="50"/>
						<col width="100"/>
						<col width="5"/>
						<col width="30"/>
						<col width="30"/>
						<col width="30"/>
						<col width="*"/>
					</colgroup>
					<tbody>
						<tr>
							<td></td>
							<td colspan="2"></td>
							<th style="text-align:left;" colspan="2">TYPE</th>
							<td><input type="radio" value="" class="trans" name="in_cll_type_tmp" id="L" checked><label for="L"> LOCAL</label><input type="radio" value="" class="trans" name="in_cll_type_tmp" id="T"><label for="T"> T/S</label><input type="radio" value="" class="trans" name="in_cll_type_tmp" id="E"><label for="E">Empty</label></td>
						</tr>
						<tr height="5"></tr>
						<tr>
						    <th style="text-align:left;">BKG Status</th>
							<td colspan="2"><input type="radio" value="" class="trans" name="in_bkg_sts_cd_tmp" id="stt1" checked><label for="stt1"> ALL</label><input type="radio" value="" class="trans" name="in_bkg_sts_cd_tmp" id="stt2"><label for="stt2"> Firm</label><input type="radio" value="" class="trans" name="in_bkg_sts_cd_tmp" id="stt3"><label for="stt3"> Waiting</label></td>
							<th style="text-align:left;" colspan="2">Container Confirm</th>
							<td><input type="radio" value="" class="trans" name="in_cntr_cfm_flg_tmp" id="cntr_cfm_1" checked><label for="cntr_cfm_1">ALL</label><input type="radio" value="" class="trans" name="in_cntr_cfm_flg_tmp" id="cntr_cfm_2"><label for="cntr_cfm_2">Yes</label><input type="radio" value="" class="trans" name="in_cntr_cfm_flg_tmp" id="cntr_cfm_3"><label for="cntr_cfm_3">No</label></td>
						</tr>
					</tbody>
				</table>
			</td></tr></table>
			</div>
	    </div>
	    
	    <div class="layout_vertical_2" style="width: 30%;">
			<div>
				<table>
					<tbody>
						<tr>
							<th>Receiver</th>
							<td>
							<%=new com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil().getCstmsCodeCombo("in_rcv_id", "KR", "KR_CLL_EDI_SND_LIST","", "style='width:100;'")%>
								<!-- <select style="width: 100px;" class="input" name="in_rcv_id" id="in_rcv_id">
									<option value="">--select--</option>
									 <option value="BNCTC050">BNCT (Busan Newport Container Terminal)</option>
									 <option value="DPCTC050">DPCTC (Dongbu Pusan Container Terminal)</option>
									<option value="HJNPC010">HJNC (Hanjin Newport Company)</option>
									<option value="HPNTC050">HPNT (Hyundai Pusan New Port Terminal)</option>
									<option value="GICTC010">HSGT (Hanjin Shipping Gwangyang Terminal)</option>
									<option value="ICTPC050">ICT (Incheon Container Terminal)</option>
									<option value="PECTC050">KBCT (Korea Express Busan Container Terminal)</option>
									<option value="KCTKC011">KCTCBKD  (Bukok CY)</option>
									<option value="KITKC050">KIT (Korea International Container Terminals)</option>
									<option value="NEWCCY10">KRNT (New continental storage)</option>
									<option value="PNCOC010">PNC (Pusan Newport Company)</option>
									<option value="PNITC050">PNIT (Pusan New Port International Terminal)</option>
									<option value="BICTC010">SBTC (Busan International Terminal)</option> 
									
									<option value="BCTOC010">HBCT</option>
									<option value="PECTC010">PECT</option>
									<option value="HJKCC010">KCT</option>
									<option value="BICTC010">SBTC</option>
									<option value="GICTC010">HSGT</option>
									<option value="KEKMC050">KEKMC</option>
									<option value="KEKYC010">KEKYC</option>
									<option value="HDKYC010">HDKYC</option>
									<option value="ICTPC050">ICT</option>
									<option value="DPCTC010">DPCTC010</option>
									<option value="KITKC010">KITKC010</option>
									<option value="DKCTC010">DKCTC010</option>
									<option value="PCCTC050">PCCTC050</option>
									<option value="HJTST100">HJTST100</option>
									<option value="HJTST200">HJTST200</option>
									<option value="PNCOC010">PNCOC010</option>
									<option value="SICTC030">SICT</option>
									<option value="PCTCC030">PCTCC030</option>
									<option value="DBFCC011">DBFCC011</option>
									<option value="HJNPC010">HJNPC010</option>
									<option value="KJTCC050">KJTCC050</option>
									<option value="E1CTC010">E1CTC010</option>
									<option value="UDITC010">UDITC010</option>
									<option value="HPNTC010">HPNTC</option>
									<option value="JUCTC050">JUCTC</option>
									<option value="PNITC010">PNIT</option>
									<option value="BNCTC010">KRPUSBN</option>
									<option value="HJGIC010">KRGINYG</option>
									<option value="HJKPC010">KRGINKT</option>
									<option value="TEST1212">TEST1212</option>  
								</select>-->
							</td>
						</tr>
						<tr>
							<th style="text-align:right">EDI Message Type</th>
							<td>
								<%=new com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil().getCstmsCodeCombo("in_edi_msg_tp", "00", "CLL_EDI_MSG_TP_CD","", "style='width:100;'")%>
								<button type="button" class="btn_etc" name="btn_EDISend" id="btn_EDISend">EDI Send</button>
							</td>
						</tr>
						<tr>			
							<th>TML Vessel Code/Seq.</th>
							<td><input type="text" style="width: 100px; text-align:center" class="input" dataformat="engup" maxlength="7" value="" name="in_ktml_cd" id="in_ktml_cd" style="ime-mode:disabled"><button type="button" class="btn_etc" name="btn_finalEDISend" id="btn_finalEDISend">Final EDI Send</button></td>
							<th>Final EDI Date</th>
							<td><input type="text" style="width: 120px; text-align:center" class="input2" dataformat="ymdhm" value="" name="in_max_edi_snd_dt" id="in_max_edi_snd_dt" style="ime-mode:disabled" readonly="true"></td>
						</tr>
					</tbody>
				</table>
			</div>
	    </div>
	</div>
</div>
<!-- layout_wrap (E) -->
</div>

<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<div class="opus_design_grid">
		<div class="opus_design_btn"><!-- 
			 --><button type="button" class="btn_accent" name="btn_RowAdd" id="btn_RowAdd">Row Add</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_Delete" id="btn_Delete">Row Delete</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_CopyTsPodMlbDel" id="btn_CopyTsPodMlbDel">Copy TS/POD/MLB/YD</button>&nbsp;
			<select style="width: 80px;" class="input" name="in_sort_type" onChange="goSearch();">
				<option value="" selected>Sort</option>
				<option value="1">POD</option>
				<option value="2">A.POD</option>
				<option value="3">VVD</option>
				<option value="4">MLB</option>
				<option value="5">TYPE</option>
				<option value="6">CNTR</option>
				<option value="7">WEIGHT</option>
			</select>
		</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" style="display: none;">
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
	<!-- opus_design_grid(E) -->
	<div class="opus_design_data">
		<table class="grid_2">
			<tbody>
				<tr>
					<th>D2</th>
					<td><input type="text" name="d2" id="d2" value="" size="2" style="text-align:center; font-weight:bold" readonly class="w100"></td>
					<th>D4</th>
					<td><input type="text" name="d4" id="d4" value="" size="2" style="text-align:center; font-weight:bold" readonly class="w100"></td>
					<th>D5</th>
					<td><input type="text" name="d5" id="d5" value="" size="2" style="text-align:center; font-weight:bold" readonly class="w100"></td>
					<th>D7</th>
					<td><input type="text" name="d7" id="d7" value="" size="2" style="text-align:center; font-weight:bold" readonly class="w100"></td>
					<th>D8</th>
					<td><input type="text" name="d8" id="d8" value="" size="2" style="text-align:center; font-weight:bold" readonly class="w100"></td>
					<th>D9</th>
					<td><input type="text" name="d9" id="d9" value="" size="2" style="text-align:center; font-weight:bold" readonly class="w100"></td>
					<th>DW</th>
					<td><input type="text" name="dw" id="dw" value="" size="2" style="text-align:center; font-weight:bold" readonly class="w100"></td>
					<th>DX</th>
					<td><input type="text" name="dx" id="dx" value="" size="2" style="text-align:center; font-weight:bold" readonly class="w100"></td>
					<th>R2</th>
					<td><input type="text" name="r2" id="r2" value="" size="2" style="text-align:center; font-weight:bold" readonly class="w100"></td>
					<th>R4</th>
					<td><input type="text" name="r4" id="r4" value="" size="2" style="text-align:center; font-weight:bold" readonly class="w100"></td>
					<th>R5</th>
					<td><input type="text" name="r5" id="r5" value="" size="2" style="text-align:center; font-weight:bold" readonly class="w100"></td>
					<th>F2</th>
					<td><input type="text" name="f2" id="f2" value="" size="2" style="text-align:center; font-weight:bold" readonly class="w100"></td>
					<th>F4</th>
					<td><input type="text" name="f4" id="f4" value="" size="2" style="text-align:center; font-weight:bold" readonly class="w100"></td>
					<th>F5</th>
					<td><input type="text" name="f5" id="f5" value="" size="2" style="text-align:center; font-weight:bold" readonly class="w100"></td>
				</tr>
				<tr>
					<th>O2</th>
					<td><input type="text" name="o2" id="o2" value="" size="2" style="text-align:center; font-weight:bold" readonly class="w100"></td>
					<th>O4</th>
					<td><input type="text" name="o4"  id="o4" value="" size="2" style="text-align:center; font-weight:bold" readonly class="w100"></td>
					<th>O5</th>
					<td><input type="text" name="o5" id="o5" value="" size="2" style="text-align:center; font-weight:bold" readonly class="w100"></td>
					<th>S2</th>
					<td><input type="text" name="s2" id="s2" value="" size="2" style="text-align:center; font-weight:bold" readonly class="w100"></td>
					<th>S4</th>
					<td><input type="text" name="s4" id="s4" value="" size="2" style="text-align:center; font-weight:bold" readonly class="w100"></td>
					<th>T2</th>
					<td><input type="text" name="t2"  id="t2"  value="" size="2" style="text-align:center; font-weight:bold" readonly class="w100"></td>
					<th>T4</th>
					<td><input type="text" name="t4" id="t4" value="" size="2" style="text-align:center; font-weight:bold" readonly class="w100"></td>
					<th>A2</th>
					<td><input type="text" name="a2" id="a2" value="" size="2" style="text-align:center; font-weight:bold" readonly class="w100"></td>
					<th>A4</th>
					<td><input type="text" name="a4"  id="a4" value="" size="2" style="text-align:center; font-weight:bold" readonly class="w100"></td>
					<th>P2</th>
					<td><input type="text" name="p2"  id="p2"value="" size="2" style="text-align:center; font-weight:bold" readonly class="w100"></td>
					<th>P4</th> 
					<td><input type="text" name="p4" id="p4" value="" size="2" style="text-align:center; font-weight:bold" readonly class="w100"></td>
					<th>Z2</th>
					<td><input type="text" name="z2"  id="z2" value="" size="2" style="text-align:center; font-weight:bold" readonly class="w100"></td>
					<th>Z4</th>
					<td><input type="text" name="z4" id="z4" value="" size="2" style="text-align:center; font-weight:bold" readonly class="w100"></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<th>D3</th>
					<td><input type="text" name="d3" id="d3" value="" size="2" style="text-align:center; font-weight:bold" readonly class="w100"></td>
					<th>R9</th>
					<td><input type="text" name="r9" id="r9" value="" size="2" style="text-align:center; font-weight:bold" readonly class="w100"></td>
					<th>ETC</th>
					<td><input type="text" name="etc" id="etc" value="" size="2" style="text-align:center; font-weight:bold" readonly class="w100"></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<th><strong>Total</strong></th>
					<td><input type="text" name="totalTpSize" id="totalTpSize" value="" size="9" style="text-align:center; font-weight:bold" readonly class="w100"></td>
				</tr>
			</tbody>
		</table>
		 
		<table class="grid_2">
			<tbody>
				<tr>
					<th><strong>Local</strong></th>
					<td><input type="text" name="local" id="local" value="" size="3" style="text-align:center; font-weight:bold" readonly class="w100"></td>
					<td>Full</td>
					<td><input type="text" name="localFull" id="localFull" value="" size="3" style="text-align:center; font-weight:bold" readonly class="w100"></td>
					<td>Empty</strong></td>
					<td><input type="text" name="localEmpty" id="localEmpty" value="" size="3" style="text-align:center; font-weight:bold" readonly class="w100"></td>
					<th><strong>T/S</th>
					<td><input type="text" name="ts" id="ts" value="" size="3" style="text-align:center; font-weight:bold" readonly class="w100"></td>
					<td>Full</td>
					<td><input type="text" name="tsFull"  id="tsFull" value="" size="3" style="text-align:center; font-weight:bold" readonly class="w100"></td>
					<td>Empty</td>
					<td><input type="text" name="tsEmpty" id="tsEmpty" value="" size="3" style="text-align:center; font-weight:bold" readonly class="w100"></td>
					<th><strong>WGT</strong></th>
					<td><input type="text" name="wgt" id="wgt" value="" size="10" style="text-align:center; font-weight:bold" readonly class="w100"></td>
					<th><strong>VGM</strong></th>
					<td><input type="text" name="vgm" id="vgm" value="" size="10" style="text-align:center; font-weight:bold" readonly class="w100"></td>
				</tr>
			</tbody>
		</table> 
	</div>
</div>
<!-- opus_design_data(E) -->
</form>
