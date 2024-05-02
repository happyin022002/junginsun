<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0947.jsp
*@FileTitle  : Work With Booking 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.event.EsmBkg0614Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List" %>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO" %>
<%@ page import="com.clt.apps.opus.esm.bkg.common.*" %>
<%@ page import="com.clt.framework.core.controller.DefaultViewAdapter"%>

<%
	EsmBkg0614Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			// error from server
	String strErrMsg = "";						// error message
	int rowCount	 = 0;						// count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	String sXml				= "";
	Logger log = Logger.getLogger("com.clt.apps.GeneralBookingConduct.GeneralBookingListSearch");

	List<BkgComboVO> bkg_sts_cd = null;
	List<BkgComboVO> bkg_cust_tp_cd = null;
	List<BkgComboVO> cust_ref_no = null;
	List<BkgComboVO> bkg_via_cd = null;
	List<BkgComboVO> si_via_cd = null;
	List<BkgComboVO> conti_cd = null;
	
	List<BkgComboVO> eq_tp_sz_cd = null;

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();


		event = (EsmBkg0614Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		bkg_sts_cd = (List<BkgComboVO>) eventResponse.getCustomData("bkg_sts_cd");
		bkg_cust_tp_cd = (List<BkgComboVO>) eventResponse.getCustomData("bkg_cust_tp_cd");
		cust_ref_no = (List<BkgComboVO>) eventResponse.getCustomData("cust_ref_no");
		conti_cd = (List<BkgComboVO>) eventResponse.getCustomData("conti_cd");

		DefaultViewAdapter adapter = new DefaultViewAdapter();
		sXml = adapter.makeXML(request, response);
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
	var userOfc_cd = "<%=strOfc_cd%>";
	var userId = "<%=strUsr_id%>";

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" 		id="f_cmd">
<input type="hidden" name="pagerows" 	id="pagerows" 		value="<%=pageRows%>">
<input type="hidden" name="mst_bkg_no" 	id="mst_bkg_no">
<input type="hidden" name="message" id="message" value="" />
<input type="hidden" name="sXml" 		id="sXml" 			value="<%=sXml %>">
<input type="hidden" name="ca_rsn_cd" 	id="ca_rsn_cd"      value=""  style="width:30px;">
<input type="hidden" name="ca_remark" 	id="ca_remark"      value=""  style="width:30px;">
<!-- HTML5 RD USER CHECK -->
<input type="hidden" name="html5_rd_flg" id="html5_rd_flg" /> 

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" 	id="btn_retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_New"  		id="btn_New">New</button><!--
		--><button type="button" class="btn_normal" name="btn_DownExcel" 	id="btn_DownExcel">Down Excel</button>
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry">
	<table>
		<tbody>
		    <tr>
				<th width="89">Date</th>
				<td width="150" class="sm" colspan="2">
					<div class="sm">
						<table>
							<tr>
								<td>
									(<input type="radio" name="date_gbn" id="date_gbn_Y" value="Y" checked><label for="date_gbn_Y">Booking</label><input type="radio" name="date_gbn"id="date_gbn_N" value="N"><label for="date_gbn_N">On Board)</label>
								</td>
							</tr>
						</table>
					</div>
				</td>
				<td width="60" colspan="3">
					<input type="text" name="bkg_from_dt" 	id="bkg_from_dt" 	style="width:75px;" 	class="input1"  maxlength="10" caption="Booking Creation DT" dataformat="ymd">
				    ~
				   	<input type="text" name="bkg_to_dt" 	id="bkg_to_dt" 		style="width:75px;"  	class="input1" 	maxlength="10" caption="Booking Creation DT" dataformat="ymd"><button type="button" class="calendar" id="btns_calendar" name="btns_calendar"></button></td>
				<th width="40">VVD</th>
				<td width="60"><input type="text" name="vvd" 			id="vvd" 			style="width:92px;" class="input1" 	maxlength="9" dataformat="engup" value=""></td>
				<th width="40">POL</th>
				<td width="60"><input type="text" name="pol_cd" 		id="pol_cd" 		style="width:65px;" class="input" 	maxlength="5" dataformat="engup" value=""><!--
					--><input type="text" name="pol_yd_cd" 	id="pol_yd_cd" 		style="width:35px;" class="input" 	maxlength="2" dataformat="engup" value=""></td>
				<th width="20">POD</th>
				<td width="50"><input type="text" name="pod_cd" 		id="pod_cd" 		style="width:65px;" class="input" 	maxlength="5" dataformat="engup" value=""><!--
					--><input type="text" name="pod_yd_cd" 	id="pod_yd_cd" 		style="width:35px;" class="input" 	maxlength="2" dataformat="engup" value="" ></td>
				<th width="20">POR</th>
				<td width="50"><input type="text" name="por_cd" 		id="por_cd" 		style="width:65px;" class="input" 	maxlength="5" dataformat="engup" value=""></td>
				<th width="20">DEL</th>
				<td width="50"><input type="text" name="del_cd" 		id="del_cd" 		style="width:65px;" class="input" 	maxlength="5" dataformat="engup" value=""></td>
				<th width="20">DEL Cont</th>
				<td><%=HTMLUtil.getComboString("dlv_ctnt_cd", "width:80px;", "", "","","All", conti_cd)%></td>
		    </tr>
        </tbody>
    </table>
    <table>
        <tbody>
		    <tr>
				<th>BKG STS</th>
				<td width="100"><%=HTMLUtil.getComboString("bkg_sts_cd", "width:110px;", "", "","","All", bkg_sts_cd)%></td>
				<th width="60">BKG OFC</th>
				<td width="60"><input type="text" name="bkg_ofc_cd" 	id="bkg_ofc_cd" style="width:75px;" maxlength="6" 	class="input" dataformat="engup" value=""></td>
				<th width="60">BKG STF</th>
				<td width="80"><input type="text" name="bkg_stf_cd" 	id="bkg_stf_cd" style="width:75px;" maxlength="20" 	class="input" value=""></td>
				<th width="70">Sales OFC</th>
				<td width="70"><input type="text" name="sls_ofc_cd" 	id="sls_ofc_cd" style="width:67px;" maxlength="6" 	class="input" dataformat="engup" value=""></td>
				<th width="60">Sales Rep.</th>
				<td width="100"><input type="text" name="srep_cd" 		id="srep_cd" 	style="width:50px;" maxlength="5"  	class="input" dataformat="engup" value=""></td>
				<td colspan="8">
					<div class="sm" style="width:260px;">
						<table>
							<tr>
								<td>
									<input type="checkbox" name="dcgo_flg" 		id="dcgo_flg" 		value="Y"><label for="dcgo_flg">DG</label><!--
									--><input type="checkbox" name="rf_flg" 		id="rf_flg" 		value="Y"><label for="rf_flg">RF</label><!--
									--><input type="checkbox" name="awk_cgo_flg" 	id="awk_cgo_flg" 	value="Y"><label for="awk_cgo_flg">AK</label><!--
									--><input type="checkbox" name="bb_cgo_flg" 	id="bb_cgo_flg" 	value="Y"><label for="bb_cgo_flg">BB</label><!--
									--><input type="checkbox" name="rd_cgo_flg" 	id="rd_cgo_flg" 	value="Y"><label for="rd_cgo_flg">RD</label><!--
									--><input type="checkbox" name="hngr_flg" 		id="hngr_flg" 		value="Y"><label for="hngr_flg">HG</label>
								</td>
							</tr>
						</table>
					</div>
				</td>
			</tr>
		    <tr>
				<th>Booking No.</th>
				<td>
					<input type="text" name="bkg_no"  id="bkg_no" class="input1" style="width:110px;" maxlength="13" dataformat="engup" />
					<button type="button" class="multiple_inq ir" style="background: url(./style/images/theme_default/sprite_common.png) -98px -157px no-repeat; background-color:#fff;" name="btn_multBkgNo" id="btn_multBkgNo"></button>
				</td>
				<th>Customer</th>
				<td colspan="5"><%=HTMLUtil.getComboString("bkg_cust_tp_cd", "width:108px;", "", "","","All", bkg_cust_tp_cd)%><!--
					--><input type="text" name="cust_cnt_cd" 	id="cust_cnt_cd" 	class="input" 	style="width:25px;" 	maxlength="2" 	dataformat="engup" value=""><!--
					--><input type="text" name="cust_seq" 		id="cust_seq" 		class="input" 	style="width:50px;" 	maxlength="6" 	dataformat="engup" value="" onBlur="if(this.value!=''){this.value=ComLpad(this, 6, '0');}"><!--
					--><input type="text" name="cust_nm" 		id="cust_nm" 		class="input" 	style="width:90px;" 	maxlength="50" 	dataformat="engup" value="" otherchar="!@#$%^&* ()-=_+[]{},./?"><!--
					--><button type="button" class="input_seach_btn" name="btn_ComEns041Pop" id="btn_ComEns041Pop"></button>
				</td>	
				<th colspan="2">Customer Ref No.</th>
				<td colspan="8"><%=HTMLUtil.getComboString("cust_ref_tp_cd", "width:160px;", "", "","","All", cust_ref_no)%><!--
					--><input type="text" name="cust_ref_no" 	id="cust_ref_no" 	class="input" 	style="width:200px;" 	maxlength="50" 	value="">
				</td>
			</tr>
		</tbody>
	</table>
	<table>
		<tbody>
		    <tr>
				<td width="150">
					<input type="radio" name="sc_rfa_gbn" id="sc_rfa_gbn_sc" value="S" checked><label for="sc_rfa_gbn_sc">S/C</label><!-- 
					--><input type="radio" name="sc_rfa_gbn" id="sc_rfa_gbn_rfa" value="R"><label for="sc_rfa_gbn_rfa">RFA</label><!--
					--><input type="radio" name="sc_rfa_gbn" id="sc_rfa_gbn_taa" value="T"><label for="sc_rfa_gbn_taa">TAA</label>
				</td>
				<td width="60">
					<input type="text" 	name="sc_rfa_no" 	id="sc_rfa_no" 	class="input" value="" style="width:85px;" maxlength="11" dataformat="engup">
				</td>
				<th width="40">BDR</th>
				<td width="60">
				  <select style="width:53px;" name="bdr_flg">
					<option value="" selected>All</option>
					<option value="Y">Y</option>
					<option value="N">N</option>
					</select></td>
				<th width="20">S/I</th>
				<td width="120">
				  <select style="width:52px;" name="si_cd">
					<option value="" selected>All</option>
					<option value="Y">Y</option>
					<option value="N">N</option>
					</select>
				</td>
				<th width="50">BKG Via</th>
				<td width="120">
					<script type="text/javascript" >ComComboObject('bkg_via_cd', 1, 110, 1, 0)</script>
					<!-- %=HTMLUtil.getComboString("bkg_via_cd", "width:110;", "", "","","All", bkg_via_cd)%-->
				</td>
				<th width="50">S/I Via</th>
				<td width="120">
					<script type="text/javascript" >ComComboObject('si_via_cd', 1, 110, 1, 0)</script>
					<!-- %=HTMLUtil.getComboString("si_via_cd", "width:110;", "", "","","All", si_via_cd)%-->
				</td>
				<td width="120"><label for="ts_port"><strong>Display T/S Port</strong></label><input type="checkbox" id="ts_port" name="ts_port" onClick="javascript:showTsPortInfo();"></td>
				<th width="60">E/Q Type</th>
				<td>
					<script type="text/javascript" >ComComboObject('eq_tp_sz_cd', 1, 60, 1, 0)</script>
					<label for="bro_ken_route"><strong>Broken Routes</strong></label><input type="checkbox" id="bro_ken_route" name="bro_ken_route">
				</td>
			</tr>
		</tbody>
	</table>
</div>
<!-- opus_design_inquiry(E) -->

<div id='layList' style='position:absolute; z-index:999; display:none; background-color: white;'> <!-- background-color: #d4f6ff; -->
	<table>
		<tr>
			<td>
				<label style="margin-right: 0px;">Rows : </label>
				<label style="margin-right: 0px;" id="rows">000</label>
				<label style="margin-right: 0px;">/</label>
				<label>100</label>
			</td>
		</tr>
	</table>
	<textarea id="mult_bkg_no" name="mult_bkg_no" placeholder="Booking No." class="multi_value mar_none" style="top:0; text-transform: uppercase; width:145px; height: 140px;"></textarea>
</div>

</div>

<div class="wrap_result">
<!-- opus_design_grid(S) -->
<div class="opus_design_grid">
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
<!-- 		<button type="button" class="btn_accent" name="btn_multi_bkg" 		id="btn_Excel">Multi BKG</button> -->
		<button type="button" class="btn_accent" name="btn_BKGCopy" 		id="btn_BKGCopy">BKG Copy</button><!--
		--><button type="button" class="btn_accent" name="btn_BLCopy"  		id="btn_BLCopy">B/L Copy</button><!--
		--><button type="button" class="btn_accent" name="btn_Split" 			id="btn_Split">Split</button><!--
		--><button type="button" class="btn_accent" name="btn_Combine" 		id="btn_Combine">Combine</button><!--
		--><button type="button" class="btn_accent" name="btn_BLPrint" 		id="btn_BLPrint">B/L Print</button>
	<!-- opus_design_btn(E) -->
	</div>
	<script type="text/javascript">ComSheetObject('sheet1');</script>
	<script type="text/javascript">ComSheetObject('sheet2');</script>
	<!-- <script type="text/javascript">ComSheetObject('sheet3');</script> -->
</div>	
<!-- opus_design_grid(E) -->
</div>
</form>