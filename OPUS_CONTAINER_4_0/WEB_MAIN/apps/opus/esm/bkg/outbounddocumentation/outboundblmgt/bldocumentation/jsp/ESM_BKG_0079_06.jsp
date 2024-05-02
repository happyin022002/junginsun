<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0079_06.jsp
*@FileTitle  : Marks & Number/Description of Goods
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event.EsmBkg007906Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List" %>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO" %>
<%@ page import="com.clt.apps.opus.esm.bkg.common.*" %>
<%@ page import="com.clt.framework.core.view.template.Screen"%>
<%@ page import="com.clt.framework.core.controller.util.WebKeys"%>

<%

	EsmBkg007906Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id  = "";
	String strUsr_nm  = "";
	String isInquiry = "N";	
	Logger log = Logger.getLogger("com.clt.apps.outboundblmgt.bldocumentation");

	/*
	*/
	String bkg_no = "";
	String bl_no = "";
	String bl_tp_cd = "";

	List<BkgComboVO> frt_terms = null;
	List<BkgComboVO> wgt_units = null;
	List<BkgComboVO> meas_units = null;

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg007906Event)request.getAttribute("Event");
		bkg_no       = event.getBkgNo();
		bl_no        = event.getBlNo();
		bl_tp_cd     = event.getBlTpCd();

		Screen screen = (Screen) request.getAttribute(WebKeys.CURRENT_SCREEN);
		//inquiry mode
		if (screen.getName().indexOf("Q") >= 0){
			isInquiry = "Y";
		} else {
			isInquiry = "N";			
		}
		
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

        frt_terms = (List<BkgComboVO>) eventResponse.getCustomData("frt_terms");
        wgt_units = (List<BkgComboVO>) eventResponse.getCustomData("wgt_units");
        meas_units = (List<BkgComboVO>) eventResponse.getCustomData("meas_units");

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

<style type="text/css">
	.specialCase {
		background-position: -151px -34px !important;
		padding: 5px 10px 5px !important;
		width: 25px !important;
		height: 25px !important;
	}
	table tr th {
		font-weight: bold !important;
	}
</style>

<form name="form" >
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />

<input type="hidden" name="dirty_flag" id="dirty_flag" />
<input type="hidden" name="bdr_flg" id="bdr_flg" />
<input type="hidden" name="corr_flg" id="corr_flg" />
<input type="hidden" name="ca_exist_flg" id="ca_exist_flg" />
<input type="hidden" name="bkg_sts_cd" id="bkg_sts_cd" />
<input type="hidden" name="cstms_clr_cd" id="cstms_clr_cd" />
<input type="hidden" name="pck_nm" id="pck_nm" />
<input type="hidden" name="cntr_desc" id="cntr_desc" />
<input type="hidden" name="rc_flg" id="rc_flg" />
<input type="hidden" name="xpt_imp_seq" id="xpt_imp_seq" />
<input type="hidden" name="po_cust_flag" id="po_cust_flag" />
<input type="hidden" name="po_ref_flag" id="po_ref_flag" />
<input type="hidden" name="po_ref_dtl_flag" id="po_ref_dtl_flag" />
<input type="hidden" name="obl_iss_flg" id="obl_iss_flg" />
<input type="hidden" name="isInquiry" value="<%=isInquiry%>" id="isInquiry" />
<input type="hidden" name="bl_tp_cd" id="bl_tp_cd" />
<input type="hidden" name="img_flg" id="img_flg" />
<input type="hidden" name="r_po_other_mdt_itm" id="r_po_other_mdt_itm" />
<input type="hidden" name="bkg_ref_tp_ml_cd" id="bkg_ref_tp_ml_cd" />
<input type="hidden" name="po_mrn_ucr_cntr_flg" id="po_mrn_ucr_cntr_flg" />
<input type="hidden" name="mlt_shp_flg" id="mlt_shp_flg"><!-- multiShipment flag : 'Y'/'N' -->

		
<!-- opus_design_btn(S) -->
<div class="opus_design_btn opus_design_normal2">
		<button type="button" class="btn_normal2" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
	--><button type="button" class="btn_normal2" name="btn_t8New" id="btn_t8New">New</button><!--
	--><button type="button" class="btn_normal2" name="btn_t8Save" id="btn_t8Save">Save</button><!--
	--><button type="button" class="btn_normal2" name="btn_t8CopyfromDG" id="btn_t8CopyfromDG">Copy from DG</button><!--
	--><button type="button" class="btn_normal2" name="btn_t8CopyfromCM" id="btn_t8CopyfromCM">Copy from C/M</button><!--
	--><button type="button" class="btn_normal2" name="btn_t8CopyfromHouseBL" id="btn_t8CopyfromHouseBL">Copy from House B/L</button>
</div>
<!-- opus_design_btn(E) -->

<!-- wrap_search (S) -->
<div class="wrap_search coupled_btn_normal2">
	<div class="opus_design_inquiry"> 
		<table> 
			<colgroup>
				<col width="55" />
				<col width="180" />
				<col width="55" />
				<col />
			</colgroup>
			<tbody>
				<tr>
					<th>BKG No.</th>
					<td>
						<input type="text" id="bkg_no" name="bkg_no" class="input" value="<%=bkg_no%>" maxlength="13" style="ime-mode:disabled;width:110px;" dataformat="engup"><!-- 
						 --><button type="button" class="btn_down_list" name="btn_splitPop" id="btn_splitPop"></button>
					</td>
					<th>B/L No.</th>
					<td>
						<input type="text" name="bl_no" class="input" value="<%//=bl_no%>" style="ime-mode:disabled;width:123px;" dataformat="engup">
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<!-- wrap_search (E) -->
		
<!-- wrap_result (S) -->
<div class="wrap_result coupled_btn_normal2">
	
	<!-- opus_design_inquiry(1) (S) -->
	<div class="opus_design_inquiry mar_btm_none wFit"> 
		<table>
			<colgroup>
				<col width="130" />
				<col width="137" />
				<col width="45" />
				<col width="280" />
				<col width="65" />
				<col />
			</colgroup>
			<tbody>
				<tr>
					<th>T/VVD</th>
				    <td><!--
				  		--><input type="text" name="t_vvd" size="14" class="input2" readOnly><!--
				    	--><input type="hidden" name="vsl_cd"><!--
				    	--><input type="hidden" name="skd_voy_no"><!--
				    	--><input type="hidden" name="skd_dir_cd">
				    </td>
					<th>Route</th>
					<td><!--
						--><input type="text" name="por_cd" class="input2" readOnly style="ime-mode:disabled;width:60px;" dataformat="engup"><!--
						--><input type="text" name="pol_cd" class="input2" readOnly style="ime-mode:disabled;width:60px;" dataformat="engup"><!--
						--><input type="text" name="pod_cd" class="input2" readOnly style="ime-mode:disabled;width:60px;" dataformat="engup"><!--
						--><input type="text" name="del_cd" class="input2" readOnly style="ime-mode:disabled;width:60px;" dataformat="engup">
					</td>
					<th>R/D Term</th>
					<td><!--
						--><input type="text" name="rcv_term_cd" class="input2" readOnly style="ime-mode:disabled;width:20px;" dataformat="engup"><!--
						--><input type="text" name="de_term_cd" class="input2" readOnly style="ime-mode:disabled;width:20px;" dataformat="engup">
					</td>
				</tr>
			</tbody>
		</table>
		<table>
			<colgroup>
				<col width="130" />
				<col width="810" />
				<col width="60" />
				<col />
			</colgroup>
			<tbody>
				<tr>
					<th>Commodity</th>
					<td><!--
						--><input name="cmdt_cd" type="text" class="input2" readOnly style="width:68px;" dataformat="engup"><!--
						--><input name="rep_cmdt_cd" type="text" class="input2" readOnly style="width:50px;" dataformat="engup"><!--
						--><input name="cmdt_desc" type="text" class="input2" readOnly style="ime-mode:disabled;width:80%;" dataformat="engup" otherchar="~!@#$%^&*().-|">
					</td>
					<th>FRT Term</th>
					<td> 
						<%=HTMLUtil.getComboString("frt_term_cd", "width:90;", "input1", "P", frt_terms)%>
						(Print<input type="checkbox" name="frt_term_prn_flg" class="trans" value="Y" id="exID02" checked />&nbsp;)
					</td>
				</tr>
			</tbody>
		</table>
		<table>
			<colgroup>
				<col width="130" />
				<col width="156" />
				<col width="80" />
				<col width="244" />
				<col width="90" />
				<col width="238" />
				<col />
			</colgroup>
			<tbody>
				<tr>
					<th>Total Package</th>
					<td><!--
						--><input name="pck_qty" type="text" class="input1" dataformat="int" maxlength="7" style="width:68px; text-align:right;"><!--
						--><input name="pck_tp_cd" type="text" class="input1 input_search" style="ime-mode:disabled;width:50px;" dataformat="engup" maxlength="2"><button type="button" class="input_seach_btn" name="btn_find_package" id="btn_find_package"></button>
					</td>
					<th>Total Weight</th>
					<td><!--
						--><input name="act_wgt" type="text" class="input1" dataformat="float" maxlength="13" pointcount="3" style="width:93px; text-align:right;"><!--
						--><%=HTMLUtil.getComboString("wgt_ut_cd", "width:60px;", "input1", "", wgt_units)%><!--
						-->(Print<input type="checkbox" name="act_wgt_prn_flg" class="trans" value="Y" id="exID01" checked >)
					</td>
					<th>Total Measure</th>
					<td><!--
						--><input name="meas_qty" type="text" class="input" dataformat="float" maxlength="9" pointcount="3" style="width:88px; text-align:right;"><!--
						--><%=HTMLUtil.getComboString("meas_ut_cd", "width:60px;", "input", "", meas_units)%><!--
						-->(Print<input type="checkbox" name="meas_qty_prn_flg" class="trans" value="Y" id="exID01" checked >)
					</td>
					<td><!--
						--><button type="button" class="btn_etc" name="btn_t8ExportImportInfo" id="btn_t8ExportImportInfo" style="width:154px;text-align:center;">Export & Import Info.</button><!--
						--> <button type="button" class="btn_etc" name="btn_t8multishp" id="btn_t8multishp" style="width:110px;text-align:center;">Multi-Shipment</button>
					</td>
				</tr>
			</tbody>
		</table>
		<table>
			<colgroup>
				<col width="130" />
				<col width="156" />
				<col width="80" />
				<col width="130" />
				<col width="120" />
				<col width="40" />
				<col width="47" />
				<col width="180" />
				<col />
			</colgroup>
			<tbody>
				<tr>
					<th>Container Weight</th>
					<td>(Print<input type="checkbox" name="cntr_wgt_prn_flg" class="trans" value="Y" id="exID01" checked >)
					</td>
					<th>Container Measure</th>
					<td>(Print<input type="checkbox" name="cntr_meas_prn_flg" class="trans" value="Y" id="exID01" checked >)
					</td>
					<th>M&D</th>
					<td>(Print<input type="checkbox" name="mk_desc_prn_flg" class="trans" value="Y" onclick="onCheck(this);" id="exID01">)
					</td>
					<th>C/M</th>
					<td>(Print<input type="checkbox" name="mf_desc_prn_flg" class="trans" value="Y" onclick="onCheck(this);" id="exID01" checked >)
					</td>
					<td><button type="button" class="btn_etc" name="btn_t8POOtherNo" id="btn_t8POOtherNo" style="width:154px;text-align:center;"> P/O & Other No. </button>
					</td>
				</tr>
			</tbody>
		</table>
		<table>
			<colgroup>
				<col width="130" />
				<col width="810" />
				<col width="60" />
				<col />
			</colgroup>
			<tbody>
				<tr>
					<th>Customs Description</th>
					<td><!--
						--><input name="cstms_desc" type="text" class="input1" style="ime-mode:disabled;width:772px;" dataformat="engup" otherchar="<%=getSpecialChars()%>" onpaste="javascript:mousePaste(this)" maxlength="4000" />
					</td>
					<th>PAYABLE AT/BY</th>
					<td>(Print<input type="checkbox" name="frt_pay_ofc_prn_flg" class="trans" value="Y" id="exID01" checked >&nbsp;)
					</td>
				</tr>
			</tbody>
		</table>
	
	</div>
	<!-- opus_design_inquiry(1) (E) -->
	
	<table class="line_bluedot mar_btm_8"><tbody><tr><td></td></tr></tbody></table>

		
	
	<!-- layout_wrap (S) -->
	<div class="layout_wrap">
		<div class="layout_flex_fixed" style="width:300px">
			
			<h3 class="title_design">Marks & Numbers</h3>
			<div class="opus_design_inquiry sm">
				<table>
					<colgroup>
						<col width="70" />
						<col />
					</colgroup>
					<tbody>
						<tr>
						    <th>Template</th>
						    <td><select name="mk_word_template" id="mk_word_template" style="width:130px;">
									<option value="0" selected>Select Template</option>
								</select><!--
						    	--><button type="button" class="input_seach_btn specialCase" name="find_tmplt_m" id="find_tmplt_m"></button>
							</td>
						</tr>
						<tr>
						    <th></th>
							<td><textarea name="mk_desc" id="mk_desc" cols="16" rows="14"  style="width:160px;ime-mode:disabled;resize:none; font-family:Courier New;font-size:14px;text-indent:0px;overflow-x:hidden;overflow-y:scroll;word-break:keep-all;line-height: 20px;word-break:break-all" dataformat="engup" otherchar="<%=getSpecialChars()%>" onpaste="javascript:mousePaste(this)" wrap="hard"></textarea></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		
		<div class="layout_flex_flex" style="padding-left:308px">
			<h3 class="title_design">Description of Goods</h3>
			<div class="opus_design_inquiry sm">
				<table>
					<colgroup>
						<col width="120" />
						<col />
					</colgroup>
					<tbody>
						<tr>
							<th>Template</th>
				    		<td><select name="dg_word_template" style="width:120px;">
								<option value="0" selected>Select Template</option>
								</select><!--
				    		--><button type="button" class="input_seach_btn specialCase" name="find_tmplt_d" id="find_tmplt_d"></button>
							</td>
						</tr>
						<tr>
							<th>No. of PKG/CNTR</th>
							<td><input type="text" name="pck_cmdt_desc" maxlength="1000" class="input" style="ime-mode:disabled;width:600px;" dataformat="engup" otherchar="<%=getSpecialChars()%>" onpaste="javascript:mousePaste(this)"></td>
						</tr>
						<tr>
							<th>
								<button type="button" class="btn_etc" name="btn_copy" id="btn_copy" style="width:70px;text-align:center;">Copy</button>
							</th>
							<td>
								<input type="text" name="cntr_cmdt_desc" class="input" style="ime-mode:disabled;width:600px;" dataformat="engup" otherchar="<%=getSpecialChars()%>" maxlength="1000" onpaste="javascript:mousePaste(this)">
							</td>
						</tr>
						<tr>
						    <th></th>
							<td>
								<textarea name="dg_cmdt_desc" id="dg_cmdt_desc" cols="33" rows="10" style="width:305px;height:168px;ime-mode:disabled;resize:none; font-family:Courier New;font-size:14px;text-indent:0px;overflow-x:hidden;overflow-y:scroll;line-height: 20px;word-break:break-all"  dataformat="engup" otherchar="<%=getSpecialChars()%>" onpaste="javascript:mousePaste(this)" onblur="javascript:validateCols('33',this);" wrap="hard" ></textarea>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			
		</div>
	</div>
	<!-- layout_wrap (S) -->
	
	<div class="opus_design_inquiry sm">
		<table>
			<colgroup>
				<col width="200" />
				<col width="670" />
				<col width="60" />
				<col />
			</colgroup>
			<tbody>
				<tr>
					<th>Total No. of PKG/CNTR in Word</th>
					<td><input name="ttl_pck_desc" type="text" class="input" style="ime-mode:disabled;width:633px" dataformat="engup" otherchar="<%=getSpecialChars()%>" onpaste="javascript:mousePaste(this)"></td>
					<th>Template</th>
					<td>
						<select name="tp_word_template" style="width:140px;">
						<option value="0" selected>Select Template</option>
						</select><!--
						--><button type="button" class="input_seach_btn specialCase" name="find_tmplt_t" id="find_tmplt_t"></button>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	

</div>
<!-- wrap_result (E) -->


<div class="wrap_result">
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('t8sheet1');</script>
		<script type="text/javascript">ComSheetObject('t8sheet2');</script>
	</div>
</div>
<div id="layList" name="layList" style="position:absolute;z-index:999;display:none" CELLPADDING="5" CELLSPACING="0" BORDER="0">
<iframe id="descRequest" name="descRequest" src="about:blank" width="100%" height="200" onload="descSend()" width="0" height="0" style="display:none"></iframe>
	<IFRAME id="ifrm" name="ifrm" src="apps/opus/esm/bkg/bookingcommon/bookingutil/jsp/esm_booking_split_no.html"  frameborder="0" marginHeight="0' marginWidth="0" width="150px" height="82px"  style="position:absolute;border:1 #e9e9e9 solid" CELLSPACING="0" scrolling="no"/></IFRAME>
</div>
</form>

<%!

	public String getSpecialChars() {
		return " ~!@#$%^&*()`_+-={}|[]\\\"\\':;,./?"; 
	}
		
%>