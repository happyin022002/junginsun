<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0909.jsp
*@FileTitle  : US Cargo Release
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/06
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0909Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%
	EsmBkg0909Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //error from server
	String strErrMsg = ""; //error message
	int rowCount = 0; //count of DB resultSET list

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String strUsr_email = "";
	String strOfc_cd = "";
	String code = "";
	String value = "";
	String customsCode = "";
	String customsValue = "";
	String clearanceCode = "";
	String clearanceValue = "";
	String mainPage   = "";

	Logger log = Logger.getLogger("com.clt.apps.InboundBLMgt.CargoReleaseOrder");

	try {
		mainPage = JSPUtil.getNull(request.getParameter("mainPage"));
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_email = account.getUsr_eml();
		strOfc_cd = account.getOfc_cd();

		event = (EsmBkg0909Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// get data from server when load page ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		code = eventResponse.getETCData("code");
		value = eventResponse.getETCData("value");
		customsCode = eventResponse.getETCData("customs_code");
		customsValue = eventResponse.getETCData("customs_value");
		clearanceCode = eventResponse.getETCData("clearance_code");
		clearanceValue = eventResponse.getETCData("clearance_value");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
	var evtCode = "<%=code %>|";
	var evtValue = "<%=code %>|";
	var evtCustomsCode = "<%=customsCode %>|";
	var evtCustomsValue = "<%=customsCode %>|";
	var evtClearanceCode = "<%= clearanceCode%>|";
	var evtClearanceValue = "<%= clearanceValue%>|";

	function setupPage(){
		loadPage();
	}
</script>



<form name="form">
	<input name="f_cmd" id="f_cmd" type="hidden" />
	<input type="hidden" name="pagerows" id="pagerows" value="<%=pageRows%>">
	<input type="hidden" name="keys"  id ="keys" value="">
	<input type="hidden" name="bkg_no" id ="bkg_no" value=""> <!-- selected BKG_NO -->
	<input type="hidden" name="req_pod_cd" id ="req_pod_cd" value=""> <!-- selected POD_CD -->
<!-- TPB Status -->
<input type='hidden' name ='tpb_status'  id='tpb_status'>



<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
		 --><button type="button" class="btn_normal" name="btn_History" id="btn_History">History</button><!--
		 --><button type="button" class="btn_normal" name="btn_Ivc" id="btn_Ivc">Complete IVC</button><!--
		 --><button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button><!--
		 --><button type="button" class="btn_normal" name="btn_Hold" id="btn_Hold">Hold</button><!--
		 --><button type="button" class="btn_normal" name="btn_Hold_History" id="btn_Hold_History">Hold History</button><!--
		 --><button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">DownExcel</button><!--
		 --><button type="button" class="btn_normal" name="btn_CFlag" id="btn_CFlag" style="color:red">C flag / CNTR</button>

		<%if (!"true".equals(mainPage)){%>
		 <button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		<%}%>
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
	<div class="opus_design_inquiry wFit">
	<table>
		<tbody>
			<tr>
				   <td width="40"><input type="radio" name="sch_tp" id="sch_tp1" class="trans" checked="checked" /><label for="sch_tp1">B/L No.</label></td>
				   <td width="120"><input type="text" style="width: 100px;" class="input1" value="" name="bl_no" id="bl_no"  caption="B/L No." maxlength="12" style="ime-mode:disabled" dataformat="engup" onFocus="sch_tp[0].checked=true;"></td>
				   <td width="40"><input type="radio" name="sch_tp" id="sch_tp2" class="trans" /><label for="sch_tp2">VVD</label></td>
				   <td width="50"><input type="text" style="width: 80px" class="input1" name="vvd" value="" maxlength="9"  dataformat="engup" onFocus="sch_tp[1].checked=true;" /></td>
				   <td width="40"><label>POD</label></td>
				   <td width="60"><input type="text" style="width: 60px" class="input1" name="pod_cd" value="" maxlength="5" dataformat="engup" onFocus="sch_tp[1].checked=true;" /></td>

				   <td id="date_hide" style="visibility:hidden;">
					   <input type="text" style="width: 75px" dataformat="ymd" minlength="8" maxlength="8" value="" class="input1" caption="Duration Start Date" name="start_date" id="start_date"  style="width:100px;ime-mode:disabled" onKeyPress="ComKeyOnlyNumber(this);" onKeyDown="ComKeyEnter(this)" onFocus="sch_tp[1].checked=true;" />
					   <input type="text" style="width: 44px" class="input1" name="start_time" id="start_time" dataformat="hm" minlength="4" maxlength="4" value="" onKeyPress="ComKeyOnlyNumber(this);" onKeyDown="ComKeyEnter(this)" onFocus="sch_tp[1].checked=true;"/>~
					   <input type="text" style="width: 75px" dataformat="ymd" minlength="8" maxlength="8" value="" class="input1" caption="Duration End Date" name="end_date" id="end_date" style="width:100px;ime-mode:disabled" onKeyPress="ComKeyOnlyNumber(this);" onKeyDown="ComKeyEnter(this)" onFocus="sch_tp[1].checked=true;"/>
					   <input type="text" style="width: 44px" class="input1" name="end_time" id="end_time" dataformat="hm" minlength="4" maxlength="4" value="" onKeyPress="ComKeyOnlyNumber(this);" onKeyDown="ComKeyEnter(this)" onFocus="sch_tp[1].checked=true;" />
						<button type="button" class="calendar" name="btn_end_date" id="btn_end_date"></button>
					</td>
				</tr>
				</tbody></table>
				<table><tbody>
				<tr>
					<th width="40">Freight</th>
					<td width="50">
						  <select style="width: 50px;" class="input1" name="frt_clt_flg"  id="frt_clt_flg" onKeyDown="ComKeyEnter(this)">
							  <option value="">All</option>
							  <option value="Y">Y</option>
							  <option value="N">N</option>
						  </select>
					</td>
					<th width="40">B/L</th>
					<td width="50">
						<select style="width: 50px;" class="input1" name="obl_rdem_flg" onKeyDown="ComKeyEnter(this)">
							<option value="">All</option>
							<option value="Y">Y</option>
							<option value="N">N</option>
						</select>
					</td>
					<th width="40">Customs</th>
					<td width="50">
						<select style="width: 50px;" class="input1" name="cstms_clr_cd" onKeyDown="ComKeyEnter(this)"> </select>
					</td>
					<th width="40">Release</th>
					<td width="50">
						<select style="width: 50px;" class="input1" name="mrn_tml_edi_snd_cd" onKeyDown="ComKeyEnter(this)">
							<option value="">All</option>
							<option value="Y">Y</option>
							<option value="N">N</option>
						</select>
					</td>
					<!--
					<th width="40">VVD</th>
					<td width="50"><input type="text" style="width: 80px" class="input" name="vvd" value="" maxlength="9"  dataformat="engup" /></td>
					<th width="40">POD</th>
					<td width="60"><input type="text" style="width: 60px" class="input" name="pod_cd" value="" maxlength="5" dataformat="enguponly" /></td>
					-->
					<th width="40">DEL</th>
					<td width="60"><input type="text" style="width: 60px" class="input" name="del_cd" value="" maxlength="5" dataformat="engup"/></td>
					<th width="40">HUB</th>
					<td><input type="text" style="width: 67px" class="input" name="hub_loc_cd" value="" maxlength="5" dataformat="engup" /></td>
				</tr>
		</tbody>
	</table>
</div>
</div>


<div class="wrap_result">
<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear" id="mainTable">
		<script type="text/javascript">ComSheetObject('master');</script>
	</div>
<!-- opus_design_grid(E) -->

<div class="opus_design_inquiry" style="width:1200px">
<!-- opus_design_data(S) -->
<div class="layout_vertical_2 pad_rgt_4" style="width:60%">
	<div class="opus_design_data">
	<table>
		<tbody>
			<tr>
				<th width="50" align="left">B/L No.</th>
				<td width="170">
					<input type="text" style="width: 110px; weight: bold" class="input2" name="curr_bl_no" id="curr_bl_no" readonly="readonly" />
					<input type="text" style="width: 45px; color: red;" class="input2" name="do_hld_flg" id="do_hld_flg" value="" readonly="readonly"/>
				</td>
				<th width="50">Partial</th>
				<td width="80"><input type="text" style="width: 45px; color: red;" class="input2" name="prt_ind" id="prt_ind" value="" readonly="readonly" /> </td>
				<th width="100"><h3 class="title_design">TPB status</h3></th>
				<td>
					<img class="cursor" src="img/btng_icon_g.gif" width="13px" height="13px" border="0" align="absmiddle" id="tpb_icon" />
					<input type="text" style="width:20px;text-align:center;" name='tpb_cd' id='tpb_cd' class="input2" readonly="readonly" /><!--
					--><button type="button" class="input_seach_btn" name="btn_tpb" id="btn_tpb"></button>
				</td>
			</tr>
			<tr height="8"></tr>
		</tbody>
	</table>
	<div class="sm">
	<table>
		<tbody>
			<tr>
				<th style="text-align:left"><h3 class="title_design">Freight Receive</h3></th>
				<td colspan="3">
					<select style="width: 50px;" name="info_frt_clt_flg" id="info_frt_clt_flg">
					<option value="Y">Y</option>
					<option value="N">N</option>
					</select>
				</td>
				<th>Outstanding</th>
				<td><select class="input2" style="width:175px; font-weight: bold;" id="tot_ots_amt" name='tot_ots_amt'></select></td>
			</tr>
			<tr>
				<th style="text-align:left"><h3 class="title_design">Customs Clearance</h3></th>
				<td colspan="5">
					<script language="javascript">ComComboObject('info_cstms_clr_cd', 2, 200, true, '', 1);</script>
				</td>
			</tr>
			<tr>
				<th width="150" style="text-align:left"><h3 class="title_design">Demurrage Status</h3></th>
				<td width="60"><input type="text" style="width: 50px; color: red;" class="input2" value="" id="dem_status" name="dem_status" readonly="readonly" /></td>
				<th width="40">Type</th>
				<td width="60"><input type="text" style="width: 40px;"class="input2" value="" name="demur_type" id="demur_type" readonly="readonly" /></td>
				<th width="90">Outstanding</th>
				<td><select style="width:175px;font-weight:bold;" class="input2" id="tot_bil_amt" name='tot_bil_amt'></select><!--
				--><button type="button" class="btn_etc" name="btn_dmdt" id="btn_dmdt">DMDT</button></td>
			</tr>
		</tbody>
	</table>
	</div>
 </div>
<div class="opus_design_grid clear" id="mainTable" style="display: none">
	<script type="text/javascript">ComSheetObject('bkg_do_ref');</script>
</div>

<div class="opus_design_grid clear" id="mainTable" style="display: none">
	<script type="text/javascript">ComSheetObject('bkg_cgo_rlse');</script>
</div>
<div class="opus_design_grid clear" id="mainTable" style="display: none">
	<script type="text/javascript">ComSheetObject('otsRcvInfo');</script>
</div>
<div class="opus_design_grid clear" id="mainTable" style="display: none">
	<script type="text/javascript">ComSheetObject('test_foc');</script>
</div>

<div class="opus_design_grid clear" id="mainTable_sheet_bl_status"  bgcolor="blue" style="display: none">
	<script type="text/javascript">ComSheetObject('sheet_bl_status');</script>
</div>
<!-- Grid (E) -->
<table><tbody><tr height="8"></tr></tbody></table>
<!-- opus_design_inquiry(S) -->
<div class="opus_design_data sm">
	<table>
		<tbody>
			<tr>
				<th style="text-align:left"><h3 class="title_design">B/L Issue</h3></th>
				   <td style="width:60;"><input type="text" name="bl_status" id="bl_status" style="width:50px; text-align: center"class="input2" readonly="readonly" /></td>
				   <th width="40">No.</th>
				   <td width="60"><input type="text" name="bl_cpy_knt" id="bl_cpy_knt" style="width:50px;" class="input2" style="text-align:right" readonly="readonly" /></td>
				   <th width="40">OFC</th>
				   <td width="60"><input type="text" name="bl_rlse_ofc_cd" id="bl_rlse_ofc_cd" style="width:50px;" class="input2" readonly="readonly" /></td>
				   <th width="40">ID</th>
				   <td width="60"><input type="text" name="bl_rlse_usr_id" id="bl_rlse_usr_id" style="width:80px;" class="input2" readonly="readonly" /></td>
				   <th width="40">DT</th>
				   <td><input type="text" name="bl_rlse_dt" id="bl_rlse_dt" style="width:120px;" class="input2" readonly="readonly" /></td>
			</tr>
			<tr>
				<th style="text-align:left"><h3 class="title_design">B/L Receive</h3></th>
				<td>
					<select style="width: 50px;"  name="info_obl_rdem_flg" id="info_obl_rdem_flg" onchange="blStatusInitByObl()">
						<option value="Y">Y</option>
						<option value="N">N</option>
					</select>
					<input type="hidden" style="width: 20px; color: blue;" class="input2" name="obl_ttl_knt" id="obl_ttl_knt" value="" />
				</td>
				<th>No.</th>
				<td><input type="text" name="obl_rdem_knt" id="obl_rdem_knt" style="width:50px;" class="input" style="text-align:right" onKeyPress="ComKeyOnlyNumber(this)" maxlength="1" /></td>
				<th>OFC</th>
				<td><input type="text" name="obl_rdem_ofc_cd" id="obl_rdem_ofc_cd" style="width:50px;" class="input2" readonly="readonly" /></td>
				<th>ID</th>
				<td><input type="text" name="obl_rdem_usr_id" id="obl_rdem_usr_id" style="width:80px;" class="input2" readonly="readonly" /></td>
				<th>DT</th>
				<td>
					 <input type="text" 	name="obl_rdem_dt" id="obl_rdem_dt" style="width:120px;" class="input2" readonly="readonly" /><!--
					  --><button type="button" class="input_seach_btn" name="btn_srnd" id="btn_srnd"></button>
				</td>
			</tr>
			<tr>
				<th rowspan="2" colspan="2" style="text-align:left"><h3 class="title_design">Other Doc RCV</h3></th>
				<th>No.</th>
				<td><input type="text" name="bl_ibd" id="bl_ibd" style="width:50px;" class="input" style="text-align:right" onKeyPress="ComKeyOnlyNumber(this)" maxlength="1" /></td>
				<th>OFC</th>
				<td><input type="text" name="bl_ibd_ofc_cd" id="bl_ibd_ofc_cd" style="width:50px;" class="input2" readonly="readonly" /></td>
				<th>ID</th>
				<td><input type="text" name="bl_ibd_usr_id" id="bl_ibd_usr_id" style="width:80px;" class="input2" readonly="readonly" /></td>
				<th>DT</th>
				<td><input type="text" name="bl_ibd_dt" id="bl_ibd_dt" style="width:120px;" class="input2" readonly="readonly" /></td>
			</tr>
			<tr>
				<th style="text-align:left"></th>
				<td><select style="width: 50px;" name="bl_otr_doc_rcv_cd" id="bl_otr_doc_rcv_cd"></select></td>
				<th>OFC</th>
				<td><input type="text" name="otr_doc_rcv_ofc_cd" id="otr_doc_rcv_ofc_cd" style="width:50px;" class="input2" readonly="readonly" />
				</td>
				<th>ID</th>
				<td><input type="text" name="otr_doc_rcv_usr_id" id="otr_doc_rcv_usr_id" style="width:80px;" class="input2" readonly="readonly" /></td>
				<th>DT</th>
				<td><input type="text" name="otr_doc_rcv_dt" id="otr_doc_rcv_dt" style="width:120px;" class="input2" readonly="readonly" /></td>
			</tr>
			<tr height="8"></tr>
		</tbody>
	</table>
 </div>
 </div>
 <div class="layout_vertical_2 pad_left_4" style="width:40%; padding-top:30px">
		<div class="opus_design_grid clear" id="mainTable">
		<script type="text/javascript">ComSheetObject('container');</script>
				<div class="opus_design_data">
				<div style="height: 2px;"></div>
				<table border="0" style="width:100%; background-color: white;" class="grid2">
					<tr class="h23" align="center">
					<td class="btn2_left" style="border: 1px solid #B8D6F6;" align="center">O/B Remark(s)</td>
					</tr>
					<tr class="h23" align="center" style="border: 1px solid #B8D6F6;">
						<td><textarea style="width: 98%; height:20px" name="obl_iss_rmk" id="obl_iss_rmk" class="noinput2" readonly="readonly"></textarea></td>
					</tr>
				</table>

				<table border="0" style="width:100%; background-color: white;" class="grid2">
					<tr>
						<td align="center">Hold / Internal Remark(s)</td>
						<td align="center"><button type="button" class="btn_etc" name="btn_remark" id="btn_remark">Save</button></td>
					</tr>
					<tr class="h23" align="center" style="border: 1px solid #B8D6F6;">
						<td width="" colspan="2"><textarea style="width: 98%; height: 41px;" name="inter_rmk" class="noinput"></textarea></td>
				</tr>
				</table>
		</div>
	</div>
</div>
</div>
</div>
</form>