<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_BKG_0229_06.jsp 
*@FileTitle  : e-Booking & SI Process Detail(TRO/O) 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/07
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg022906Event"%>
<%@ page import="com.clt.framework.core.controller.DefaultViewAdapter" %>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg022906Event  event = null;			//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//occurring error in server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//list count of DB resultSet 

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.clt.apps.EBookingConduct.EBookingReceipt");
	String sXml = null;

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg022906Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//When initial screen loading, adding logic extrat data obtained from the server.
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		DefaultViewAdapter adapter = new DefaultViewAdapter();
		sXml = adapter.makeXML(request, response);

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script  type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<script type="text/javascript" src="apps/opus/esm/bkg/bookingconduct/ebookingconduct/ebookingreceipt/script/ESM_BKG_0229_06_EU.js" ></script>
<style type="text/css">
	.specialCls {
		float: right;
	}
	.specialCls:after {
		display: block;
		content: " ";
		clear: both;
	}
</style>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="rqst_seq" value="<%=StringUtil.xssFilter(request.getParameter("rqst_seq")) %>" id="rqst_seq" />
<input type="hidden" name="sender_id" value="<%=StringUtil.xssFilter(request.getParameter("sender_id")) %>" id="sender_id" />
<input type="hidden" name="tro_seq" value="" id="tro_seq" />
<input type="hidden" name="tro_opus" value="" id="tro_opus" />
<input type="hidden" name="tro_esvc" value="" id="tro_esvc" />
<input type="hidden" name="is_eur_flg" value="N" id="is_eur_flg" />
<input type="hidden" name="opus_eur_cnt" value="0" id="opus_eur_cnt" />
<input type="hidden" name="cxl_flg" value="N" id="cxl_flg" />
<input type="hidden" name="conti_cd" value="" id="conti_cd" />
<input type="hidden" name="f_del_flg" value="N" id="f_del_flg" />
<input type="hidden" name="io_bnd_cd" value="O" id="io_bnd_cd" />
<input type="hidden" name="rtn_tro_flg" value="N" id="rtn_tro_flg" />
<input type="hidden" name="curr_tro_seq" value="" id="curr_tro_seq" />
<input type="hidden" name="sXml" value="<%=JSPUtil.replace(sXml, "\"", "&quot;")%>" id="sXml" />
<input type="hidden" name="l_trans_result_key" value="" id="l_trans_result_key" />
<input type="hidden" name="tro_type" value="" id="tro_type" />

<div class="wrap_search">
	<!-- layout_wrap (S) -->
	
	<div id="eur_opus" style="display: none;" class="layout_wrap">
        <jsp:include page="ESM_BKG_0229_06_EU.jsp"></jsp:include>
    </div> 
	
	<div id="not_eur_opus" style="display: none;" class="layout_wrap">
		<div class="layout_vertical_2 pad_rgt_8" >
			<div class="opus_design_grid">
				<h3 class="title_design">Booking Data OPUS</h3>
				<div class="specialCls">
					<button type="button" class="btn_etc" name="btn_cancelcopydata" id="btn_cancelcopydata">Cancel Copy Data</button>
				</div>
			</div>
			<!-- opus_design_inquiry (S) -->
			<div class="opus_design_inquiry">
		    	<table>
					<colgroup>
						<col width="30">
						<col width="60">
						<col width="110">
						<col width="*">
					</colgroup>
					<tbody>
						<tr>
							<th>Seq.</th>
							<td><select name="opus_seq" id="opus_seq" style="width:60px;" onChange="javascript:change_seq('sheet3', this)" onClick="javascript:click_seq(this)"></select></td>
							<th>Booking No.</th>
							<td><input type="text" name="bkg_no" id="bkg_no" style="width:105px;" class="input2" value="<%=StringUtil.xssFilter(request.getParameter("bkg_no"))%>" readOnly></td>
						</tr>
					</tbody>
				</table>
				
				<table>
					<colgroup>
						<col width="100">
						<col width="140">
						<col width="100">
						<col width="*">
					</colgroup>
					<tbody>
						<tr>
							<th><label for="self_trk">Self Truck</label><input type="checkbox" name="self_trk" value="Y" class="trans" id="self_trk" /></th>
							<td></td>
							<th>Status</th>
							<td><input type="text" style="width:50px;" name="tro_status" class="input2" id="tro_status" /></td>
						</tr>
						<tr>
							<th>Request Result</th>
							<td><input type="text" name="request_result" style="width:130px;" class="input2" value="" readonly id="request_result" /></td>
							<th>Request Date</th>
							<td><input type="text" name="request_date" style="width:110px;" class="input2" value="" readonly id="request_date" /></td>
						</tr>
						<tr>
							<th>Actual Shipper</th>
							<td colspan="3"><input type="text" name="act_sh" style="width:95.5%;" maxlength="500" class="input" onKeyUp="allowAllCharsButEngup()" value="" id="act_sh" /><!--
							--><button type="button" id="btns_popActCust" name="btns_popActCust" class="input_seach_btn"></button></td>
						</tr>
						<tr>
							<th>Contact Person</th>
							<td colspan="3"><input type="text" name="cntc_pson" style="width:100%;" maxlength="50" class="input" onKeyUp="allowAllCharsButEngup()" value="" id="cntc_pson" /></td>
						</tr>
						<tr>
							<th>Tel.</th>
							<td colspan="3"><input type="text" name="tel" style="width:100%;" maxlength="20" class="input" dataformat="exceptengdn" value="" id="tel" /></td>
						</tr>
						<tr>
							<th>Mobile Phone</th>
							<td><input type="text" name="mobile" style="width:100%;" maxlength="20" class="input" dataformat="exceptengdn" value="" id="mobile" /></td>
							<th>ZIP </th>
							<td><input type="text" name="dor_pst_no" style="width:100%;" maxlength="12" class="input" dataformat="engup" value="" id="dor_pst_no" /></td>
						</tr>
						<tr>
							<th style="vertical-align:top;line-height:29px">Address</th>
							<td colspan="3"><textarea name="addr" id="addr" style="width:100%;height:40px;resize:none" onKeyUp="allowAllCharsButEngup()" maxlength="120"></textarea></td>
						</tr>
						<tr>
							<th>Remark(s)</th>
							<td colspan="3"><textarea name="rmk" id="rmk" style="width:100%;height:40px;resize:none" onKeyUp="allowAllCharsButEngup()" maxlength="1000"></textarea></td>
						</tr>
					</tbody>
				</table>
	    	</div>
	    	<!-- opus_design_inquiry (E) -->
	    	
	    	<!-- opus_design_grid(S) -->
	    	<div class="opus_design_grid" id="mainTable">
	    		<!-- opus_design_btn (S) -->
				<div class="opus_design_btn">
					<button class="btn_accent" name="btn_add" id="btn_add" type="button">Add</button><!--
					--><button class="btn_normal" name="btn_del" id="btn_del" type="button">Del</button><!--
					--><button class="btn_normal" name="btn_copy" id="btn_copy" type="button">Copy</button><!--
					--></div>
				<!-- opus_design_btn (E) -->
	    		<script type="text/javascript">ComSheetObject('sheet1');</script>
	    	</div>
	    	<!-- opus_design_grid(E) -->
		</div>
		<div class="layout_vertical_2" >
			<div class="opus_design_grid">
				<h3 class="title_design">From e- Service</h3>
				<div class="specialCls">
					<button type="button" class="btn_etc" name="btn_datacopytoopus" id="btn_datacopytoopus">Data Copy to OPUS</button>
				</div>
			</div>
			<!-- opus_design_inquiry (S) -->
			<div class="opus_design_inquiry">
		    	<table>
					<colgroup>
						<col width="30">
						<col width="60">
						<col width="80">
						<col width="*">
					</colgroup>
					<tbody>
						<tr>
							<th>Seq.</th>
							<td><select name="xter_seq" id="xter_seq" style="width:60px;" onChange="javascript:change_seq('sheet4', this)"></select></td>
							<th>Request No.</th>
							<td><input type="text" name="rqst_no" id="rqst_no" style="width:105px;" class="input2" value="<%=StringUtil.xssFilter(request.getParameter("rqst_no"))%>" readOnly></td>
						</tr>
					</tbody>
				</table>
				<table>
					<colgroup>
						<col width="100">
						<col width="160">
						<col width="100">
						<col width="*">
					</colgroup>
					<tbody>
						<tr>
							<th><label for="self_trk2">Self Truck</label><input type="checkbox" name="self_trk2" value="" class="trans" readonly id="self_trk2" /></th>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<th>Actual Shipper</th>
							<td colspan="3"><input type="text" name="act_sh2" style="width:100%;" class="input2" value="" readonly id="act_sh2" /></td>
						</tr>
						<tr>
							<th>Contact Person</th>
							<td colspan="3"><input type="text" name="cntc_pson2" style="width:100%;" class="input2" value="" readonly id="cntc_pson2" /></td>
						</tr>
						<tr>
							<th>Tel.</th>
							<td colspan="3"><input type="text" name="tel2" style="width:100%;" class="input2" value="" readonly id="tel2" /></td>
						</tr>
						<tr>
							<th>Mobile Phone</th>
							<td><input type="text" name="mobile2" style="width:160px;" class="input2" value="" readonly id="mobile2" /></td>
							<th>ZIP </th>
							<td><input type="text" name="dor_pst_no2" style="width:100%;" class="input2" value="" readonly id="dor_pst_no2" /></td>
						</tr>
						<tr>
							<th style="vertical-align:top;line-height:29px">Address</th>
							<td colspan="3"><textarea name="addr2" id="addr2" style="width:100%;height:40px;resize:none" class="textarea2" readonly></textarea></td>
						</tr>
						<tr>
							<th>Remark(s)</th>
							<td colspan="3"><textarea name="rmk2" id="rmk2" style="width:100%;height:40px;resize:none" class="textarea2" readonly></textarea></td>
						</tr>
					</tbody>
				</table>
	    	</div>
	    	<!-- opus_design_inquiry (E) -->
	    	<div class="opus_design_grid">
				<script type="text/javascript">ComSheetObject('sheet2');</script>
			</div>
		</div>
	</div>
	<!-- layout_wrap (E) -->
	<div class="opus_design_grid" style="display: none">
		<script type="text/javascript">ComSheetObject('sheet3');</script>
		<script type="text/javascript">ComSheetObject('sheet4');</script>
	</div>
	
	<div style="display: none">
		<script type="text/javascript">ComSheetObject('sheet5');</script>
		<script type="text/javascript">ComSheetObject('sheet6');</script>
	</div>
	
</div>
</form>	