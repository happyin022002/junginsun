<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_1502.jsp
*@FileTitle  : B/L Inquiry(Japan 24HR)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/20
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.event.EsmBkg1502Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1502Event event = null;        //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;    //occurring error in server
	String strErrMsg = "";               //error message
	int rowCount = 0;                    //list count of DB ResultSet

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id = "";
	String strUsr_nm = "";

	String blNo = "";
	String tCmrKind = "";
	String polSplitNo = "";
	String podSplitNo = "";
	String popMode = "";

	Logger log = Logger.getLogger("com.clt.apps.esm.bkg.CustomsDeclaration");

	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EsmBkg1502Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		blNo = JSPUtil.getParameter(request, "bl_no");
		tCmrKind = JSPUtil.getParameter(request, "t_cmr_kind");
		polSplitNo = JSPUtil.getParameter(request, "pol_split_no");
		podSplitNo = JSPUtil.getParameter(request, "pod_split_no");
		popMode = JSPUtil.getParameter(request, "pop_mode");

		if (serverException != null) strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch(Exception e) {
		out.println(e.toString());
	}
%>

<script language="javascript">
	var tCmrKind = "<%=tCmrKind%>";
	var polSplitNo = "<%=polSplitNo%>";
	var podSplitNo = "<%=podSplitNo%>";

	function setupPage() {
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

<!-- 개발자 작업 -->
<input type="hidden" name="onchange_flag" id="onchange_flag" />
<input type="hidden" name="pod_cd" id="pod_cd" />
<input type="hidden" name="org_bl_no" id="org_bl_no" />
<input type="hidden" name="pod_div" id="pod_div" />
<input type="hidden" name="rvis_cntr_cust_tp_cd" id="rvis_cntr_cust_tp_cd" />
<input type="hidden" name="del_trasmit_flag" id="del_trasmit_flag" />


<% if ("1".equals(popMode)) { %>
<!-- popup_title_area(S) -->
<div class="layer_popup_title">
<% } %>


<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->


<% if ("1".equals(popMode)) { %>
	<h2 class="page_title"><span id="title"></span></h2>
<% } else {%>
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
<% } %>


	<!-- page_title(E) -->
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" type="button" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
	 --><% if (!"1".equals(popMode)) { %><button class="btn_normal" type="button" name="btn_new" id="btn_new" >New</button><!--
	 --><% } %><button class="btn_normal" type="button" name="btn_save" id="btn_save" >Save</button><!--
	 --><% if (!"1".equals(popMode)) { %><button class="btn_normal" type="button" name="btn_transmit" id="btn_transmit" >Transmit</button>
		<% } else { %><button class="btn_normal" type="button" name="btn_close" id="btn_close" >Close</button>
		<% } %>
	</div>
	<!-- opus_design_btn (E) -->


<% if (!"1".equals(popMode)) { %>
	<!-- page_location(S) -->
	<div class="location"><span id="navigation"></span></div>
	<!-- page_location(E) -->
<% } %>


</div>
<!-- page_title_area(E) -->


<% if ("1".equals(popMode)) { %>
</div>
<!-- popup_title_area(E) -->


<!-- popup_contents_area(S) -->
<div class="layer_popup_contents">
<% } %>


<!-- wrap_search(S) -->
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<table style="width:500px">
			<colgroup>
				<col width="70" />
				<col width="150" />
				<col width="90" />
				<col />
			</colgroup>
			<tbody>
				<tr>
					<th>B/L No.</th>
					<td><input type="text" name="bl_no" id="bl_no" <% if ("1".equals(popMode)) { %>value="<%=blNo%>" class="input2" readOnly<% } else { %>class="input1" dataformat="engup" maxlength="12" required caption="B/L No."<% } %> style="width:120px;"></td>
					<th>T/Status</th>
					<td><select name="t_cmr_kind" id="t_cmr_kind" <% if ("1".equals(popMode)) { %>class="input2" disabled<% } else { %>class="input" caption="T/Status"<% } %> style="width:95px">
							<option value="" selected></option>
							<option value="9">AMR</option>
							<option value="2">CMR(Add)</option>
							<option value="5">CMR(Cor)</option>
							<option value="1">CMR(Del)</option>
						</select></td>
				</tr>
			</tbody>
		</table>
		<table class="line_bluedot"><tr><td></td></tr></table>
		<table>
			<colgroup>
				<col width="70" />
				<col width="150" />
				<col width="90" />
				<col/>
				<col/>
				<col/>
				<col/>
				<col/>
				<col/>
				<col/>
			</colgroup>
			<tbody>
				<tr>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input type="text" name="vvd" style="width:120px;" class="input2" readonly id="vvd" /></td>
					<th>Vessel Name</th>
					<td colspan="3"><input type="text" name="vsl_eng_nm" style="width:180px;" class="input2" readonly id="vsl_eng_nm" /></td>
					<th>Filer Type</th>
					<td colspan="3">
						<select name="mst_bl" id="mst_bl" class="input" style="width:90px">
							<option value="B" selected>Simple</option>
							<option value="N">Console</option>
						</select></td>
					<th style="visibility:hidden;">CMDT CD</th>
					<td style="visibility:hidden;"><input type="text" name="cmdt_cd" style="width:60px;" class="input" maxlength="6" dataformat="engup" id="cmdt_cd" /></td>
				</tr>
				<tr>
					<th title="Port of Loading">POL</th>
					<td><input type="text"  name="pol_cd" id="pol_cd" style="width:75px;" class="input" maxlength="5" dataformat="engup"><!--
						--><select name="pol_split_no"<% if ("1".equals(popMode)) { %> class="input2" disabled<% } else { %> class="input"<% } %> style="width:40px;" id="pol_split_no">
								<option value="" selected></option>
								<% for (int k=1; k<10; k++) { %>
									<option value="<%=k%>"><%=k%></option>
								<% } %>
							</select></td>
					<th title="Port of Discharging">POD</th>
					<td><input type="text" style="width:25px; text-align:center; border-right:none" class="input2" name="pod_prefix" id="pod_prefix" maxlength="2" value="JP" readOnly><input type="text" style="width:46px;border-left:none ; margin-left:-5px" class="input"  name="pod_postfix" id="pod_postfix" maxlength="3" dataformat="engup"><!--
						--><select name="pod_split_no"<% if ("1".equals(popMode)) { %> class="input2" disabled<% } else { %> class="input"<% } %> style="width:55px;">
								<option value="" selected></option>
								<% for (int k=1; k<10; k++) { %>
									<option value="<%=k%>"><%=k%></option>
								<% } %>
						</select></td>
					<th title="Place of Delivery">DEL</th>
					<td><input type="text"  name="bkg_del_cd" id="bkg_del_cd" style="width:60px;" class="input" maxlength="5" dataformat="engup"></td>
					<th>R/D Term</th>
					<td colspan="3"><input type="text" name="rcv_term_cd" style="width:23px;" class="input" dataformat="engup" id="rcv_term_cd" />/ <input type="text" name="de_term_cd" style="width:23px;" class="input" dataformat="engup" id="de_term_cd" /></td>
				</tr>
				<tr>
					<th>Package</th>
					<td><input type="text" name="pck_qty" style="width:75px; text-align:right;" class="input" dataformat="float" maxlength="15" id="pck_qty" caption="Package" /><!--
						--><input type="text" name="pck_tp_cd" style="width:40px;" class="input" id="pck_tp_cd"  dataformat="engup" />
					</td>
					<th>Weight</th>
					<td><input type="text" name="grs_wgt" style="width:70px; text-align:right;" class="input" dataformat="float" maxlength="23" id="grs_wgt" caption="Weight" /><!--
						--><select name="wgt_ut_cd" class="input" style="width:50">
								<option value="KGS" selected>KGS</option>
								<option value="LBS">LBS</option>
							</select></td>
					<th>Measure</th>
					<td><input type="text" name="meas_qty" style="width:60px; text-align:right;" class="input" dataformat="float" maxlength="15" id="meas_qty" caption="Measure" /><!--
						--><select name="meas_ut_cd" class="input" style="width:50">
								<option value="CBM" selected>CBM</option>
								<option value="CBF">CBF</option>
							</select></td>
					<th>IMDG</th>
					<td><input type="text" name="imdg_clss_cd" style="width:60px;" class="input" maxlength="3" dataformat="engup" id="imdg_clss_cd" /></td>
					<th>UN No.</th>
					<td><input type="text" name="imdg_un_no" style="width:60px;" class="input" maxlength="4" dataformat="engup" id="imdg_un_no" /></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<!-- wrap_search(E) -->

<!-- wrap_result(S) -->
<div class="wrap_result">
	<!-- opus_tab_btn(S) -->
	<div class="opus_design_tab">
		<script type="text/javascript">ComTabObject ("tab1")</script>
	</div>
	<!-- opus_tab_btn(E) -->
	<div id="tabLayer" style="display:inline">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<h3 class="title_design">Customer Information</h3>
			<table>
				<colgroup>
					<col width="70" />
					<col/>
					<col/>
					<col/>
					<col/>
				</colgroup>
				<tbody>
					<tr>
						<th style="text-align:center;">Shipper</th>
						<td style="padding-left:8px;"><input type="text" style="width:40px;" dataformat="enguponly" name="shpr_cnt_cd" maxlength="2"></td>
						<td style="visibility:hidden;"><input type="text" dataformat="int" style="width:100px; text-align:right" name="shpr_seq" id="shpr_seq" maxlength="6"><button type="button" name="btn_shpr" id="btn_shpr"  class="calendar ir"></button></td>
						<td style="visibility:hidden;">Tel.&nbsp;<input type="text" style="width:100px;" dataformat="dashfloat" maxlength="20" name="shpr_phn_no" id="shpr_phn_no"></td>
						<td style="visibility:hidden;">Fax&nbsp;<input type="text" style="width:180px;" dataformat="dashfloat" maxlength="20" name="shpr_fax_no" id="shpr_fax_no"></td>
					</tr>
				</tbody>
			</table>
			<table class="grid_2">
				<colgroup>
					<col width="70" />
					<col/>
					<col width="80" />
					<col/>
				</colgroup>
				<tbody>
					<tr>
						<th>Name</th>
						<td style="padding:8px 8px 5px 8px"><textarea style="resize:none;" rows="3" dataformat="engupetc" maxlength="500" name="shpr_nm"></textarea></td>
						<th>Address</th>
						<td style="padding:8px 8px 5px 8px"><textarea style="resize:none;" rows="3" dataformat="engupetc" maxlength="500" name="shpr_addr"></textarea></td>
					</tr>
				</tbody>
			</table>
			<table>
				<colgroup>
					<col width="70" />
					<col/>
					<col/>
					<col/>
					<col/>
				</colgroup>
				<tbody>
					<tr>
						<th style="text-align:center;">Consignee</th>
						<td style="padding-left:8px;"><input type="text" style="width:40px;" dataformat="enguponly" name="cnee_cnt_cd" maxlength="2" id="cnee_cnt_cd" /></td>
						<td style="visibility:hidden;"><input type="text" dataformat="num" style="width:100px; text-align:right" name="cnee_seq" maxlength="6" id="cnee_seq" /><button type="button" name="btn_cnee" id="btn_cnee"  class="calendar ir"></button></td>
						<td style="visibility:hidden;">Tel. <input type="text" style="width:100px;" dataformat="singledfloat" maxlength="20" name="cnee_phn_no" id="cnee_phn_no" /></td>
						<td style="visibility:hidden;">Fax <input type="text" style="width:172px;" dataformat="singledfloat" maxlength="20" name="cnee_fax_no" id="cnee_fax_no" /></td>
					</tr>
				</tbody>
			</table>
			<table class="grid_2">
				<colgroup>
					<col width="70" />
					<col/>
					<col width="80" />
					<col/>
				</colgroup>
				<tbody>
					<tr>
						<th>Name</th>
						<td style="padding:8px 8px 5px 8px"><textarea style="width:100%;resize:none;" rows="3" dataformat="engupetc" maxlength="500" name="cnee_nm"></textarea></td>
						<th>Address</th>
						<td style="padding:8px 8px 5px 8px"><textarea style="width:100%;resize:none;" rows="3" dataformat="engupetc" maxlength="500" name="cnee_addr"></textarea></td>
					</tr>
				</tbody>
			</table>
			<table>
				<colgroup>
					<col width="70" />
					<col/>
					<col/>
					<col/>
					<col/>
				</colgroup>
				<tbody>
					<tr>
						<th style="text-align:center;">Notify</th>
						<td style="padding-left:8px;"><input type="text" style="width:40px;" dataformat="enguponly" name="ntfy_cnt_cd" maxlength="2" id="ntfy_cnt_cd" /></td>
						<td style="visibility:hidden;"><input type="text" dataformat="num" style="width:100px; text-align:right;" name="ntfy_seq" maxlength="6" id="ntfy_seq" /><button type="button" name="btn_ntfy" id="btn_ntfy"  class="calendar ir"></button></td>
						<td style="visibility:hidden;">Tel. <input type="text" style="width:100px;" dataformat="singledfloat" maxlength="20" name="ntfy_phn_no" id="ntfy_phn_no" /></td>
						<td style="visibility:hidden;">Fax <input type="text" style="width:172px;" dataformat="singledfloat" maxlength="20" name="ntfy_fax_no" id="ntfy_fax_no" /></td>
					</tr>
				</tbody>
			</table>
			<table class="grid_2">
				<colgroup>
					<col width="70" />
					<col/>
					<col width="80" />
					<col/>
				</colgroup>
				<tbody>
					<tr>
						<th>Name</th>
						<td style="padding:8px 8px 5px 8px"><textarea style="width:100%;resize:none;" rows="3" dataformat="engupetc" maxlength="500" name="ntfy_nm"></textarea></td>
						<th>Address</th>
						<td style="padding:8px 8px 5px 8px"><textarea style="width:100%;resize:none;" rows="3" dataformat="engupetc" maxlength="500" name="ntfy_addr"></textarea></td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>

	<!-- Tab_Layer_2 (S) -->
	<div id="tabLayer" style="display:none">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<!-- opus_design_btn (S) -->
			<div class="opus_design_btn">
				<button class="btn_accent" name="tab2btn_rowadd" id="tab2btn_rowadd" type="button">Row Add</button><!--
				--><button class="btn_normal" name="tab2btn_delete" id="tab2btn_delete" type="button">Delete</button><!--
				--></div>
			<!-- opus_design_btn (E) -->
			<script type="text/javascript">ComSheetObject("tab2sheet1");</script>
		</div>
		<!-- opus_design_grid(E) -->
	</div>

	<!-- Tab_Layer_3 (S) -->
	<div id="tabLayer" style="display:none">
		<div class="opus_design_inquiry">
			<h3 class="title_design">Mark & Description</h3>
			<table style="width:800px">
				<colgroup>
					<col width="70" />
					<col/>
					<col/>
					<col/>
					<col/>
					<col/>
				</colgroup>
				<tbody>
					<tr>
						<th>HS CD</th>
						<td><input type="text" style="width:100px;" name="cmdt_hs_cd" dataformat="engup" maxlength="10" id="cmdt_hs_cd" /></td>
						<th>L/TS using CD</th>
						<td><select name="jp_cstms_trns_cd" class="input" style="width:60px">
								<option value="" selected></option>
								<option value="TRS">TRS</option>
								<option value="TRT">TRT</option>
								<option value="REV">REV</option>
								<option value="POS">POS</option>
							</select></td>
						<th>L/TS using Period</th>
						<td><input type="text" style="width:72px;" dataformat="engup" maxlength="15" name="lmt_no" id="lmt_no" /></td>
						<td style="visibility:hidden;">CY Operator CD <input type="text" style="width:96px;" dataformat="engup" maxlength="5" name="cy_opr_id" id="cy_opr_id" /></td>
					</tr>
				</tbody>
			</table>
			<!-- layout_wrap(S) -->
			<div class="layout_wrap wFit">
				<!-- layout_vertical_2(S) -->
				<div class="layout_vertical_2 pad_rgt_8">
					<table class="grid_2">
						<tr class="tr2_head">
							<th style="text-align:center"><strong>Marks & No.</strong></th>
						</tr>
						<tr>
							<td style="padding:10px;"><textarea style="width:100%;resize:none;" rows="11" name="diff_rmk" id="diff_rmk" dataformat="engupetc" maxlength="140"></textarea></td>
						</tr>
					</table>
				</div>
				 <!-- layout_vertical_2(E) -->
				 <!-- layout_vertical_2(S) -->
				<div class="layout_vertical_2">
					<table class="grid_2">
						<tr class="tr2_head">
							<th style="text-align:center"><strong>Description</strong></th>
						</tr>
						<tr>
							<td style="padding:10px;"><textarea style="width:100%;resize:none;" rows="11" name="bl_desc" id="bl_desc" dataformat="engupetc" maxlength="350"></textarea></td>
						</tr>
					</table>
				</div>
				 <!-- layout_vertical_2(E) -->
			</div>
			<!-- layout_wrap(E) -->
			<!-- Tab_3_Grid (Hidden) (S) -->
			<div id="tabLayer" style="display:none">
				<script type="text/javascript">ComSheetObject("tab3sheet1");</script>
			</div>
			<!-- Tab_3_Grid (Hidden) (E) -->
		</div>
	</div>
</div>
<!-- wrap_result(E) -->


<% if ("1".equals(popMode)) { %>
</div>
<!-- popup_contents_area(E) -->
<% } %>


</form>
