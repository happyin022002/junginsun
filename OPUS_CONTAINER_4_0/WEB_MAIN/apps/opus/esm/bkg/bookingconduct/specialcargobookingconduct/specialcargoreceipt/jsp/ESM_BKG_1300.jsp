<%/*=========================================================
*Copyright(c) 2015 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1300.js
*@FileTitle  : Hazardous Parties
*@author     : CLT
*@version    : 1.0
*@since      : 2015/11/17
=========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.event.EsmBkg1300Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1300Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.SpecialCargoBookingConduct.SpecialCargoReceipt");
	String bkg_no			= "";
	String dcgo_seq			= "";
	String dg_cntr_seq		= "";
	String pop_type			= "";
	String dg_cntr_seq_upd	= ""; //Update target list of dg_cntr_seq like "2|4|5".
	String trsfunc			= "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		bkg_no		= JSPUtil.getParameter(request, "bkg_no");
		dcgo_seq	= JSPUtil.getParameter(request, "dcgo_seq");
		dg_cntr_seq	= JSPUtil.getParameter(request, "dg_cntr_seq");
		pop_type	= JSPUtil.getParameter(request, "pop_type");
		dg_cntr_seq_upd	= JSPUtil.getParameter(request, "dg_cntr_seq_upd");
		trsfunc		= JSPUtil.getParameter(request, "trsfunc");


		event = (EsmBkg1300Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	var trsfunc = "<%= trsfunc %>";
	function setupPage(){
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
<input type="hidden" name="bkg_no" id="bkg_no" value="<%=bkg_no%>"/>
<input type="hidden" name="dcgo_seq" id="dcgo_seq" value="<%=dcgo_seq%>"/>
<input type="hidden" name="dg_cntr_seq" id="dg_cntr_seq" value="<%=dg_cntr_seq%>"/>
<input type="hidden" name="pop_type" id="pop_type" value="<%=pop_type%>"/>
<input type="hidden" name="dg_cntr_seq_upd" id="dg_cntr_seq_upd" value="<%=dg_cntr_seq_upd%>"/>
<input type="hidden" name="cntr_cgo_seq" id="cntr_cgo_seq"/>
<input type="hidden" name="sh_dg_decl_seq" id="sh_dg_decl_seq"/>
<input type="hidden" name="cn_dg_decl_seq" id="cn_dg_decl_seq"/>
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Hazardous Parties</span></h2>
		
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn_save" id="btn_save" type="button">Save</button><!--
			--><button class="btn_normal" name="btn_close" id="btn_close" type="button">Close</button><!--
			--></div>
	</div>
</div>
<!-- page_title_area(E) -->
<div class="layer_popup_contents">

	<!-- opus_design_inquiry(S) -->
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="120">
					<col width="510">
					<col width="150">
					<col width="30">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th>DG Declarant</th>
						<td><input type="text" style="width: 500px;" class="input" name="decl_nm" id="decl_nm" value=""></td>
						<th>Shown Data : Seq</th>
						<td><input type="text" style="width: 30px; text-align:right;" class="input2" name="dg_cntr_ord_seq" id="dg_cntr_ord_seq" value=""></td>
						<td><input type="text" style="width: 110px;" class="input2" name="cntr_no" id="cntr_no" value=""></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>	
	<!-- opus_design_inquiry(E) -->



	<!-- wrap_result (S) -->
	<div class="opus_design_grid" style="Display :none">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<div class="wrap_result" >
		<!-- opus_design_inquiry(3) (S) -->
		<div class="opus_design_inquiry">
				<!-- layout_wrap (S) -->
				<div class="layout_wrap" style="height: 350px">
					<div class="layout_flex_fixed" style="width:465px; height: 350px">
						<div class="opus_design_inquiry sm mar_btm_none" style="height: 350px">
								<table class="grid_2">
									<thead>
										<tr>
											<th colspan="2">Haz Shipper</th>
										</tr>
									</thead>
									<colgroup>
										<col width="100" />
										<col/>
									</colgroup>
									<tbody>
										<tr>
											<th width="50">Shipper</th>
											<td>
												<input type="text" name="sh_cust_cnt_cd" style="width:30px;ime-mode:disabled;text-transform:uppercase;" class="input1" value="" maxlength=2   dataformat="engup"><!--
												--><button type="button" name="btn_sh_cust" id="btn_sh_cust" class="input_seach_btn"></button><!--
												--><input type="text" name="sh_cust_seq" id="sh_cust_seq" style="width:58px;" class="input1" value="" maxlength=6   dataformat="num">
											</td>
										</tr>					
										<tr>
											<th>Name</th>
											<td>
												<textarea cols="35" rows="2" style="width:345px; resize:none; font-family:Courier New; font-size:15px; text-indent:0px;overflow-y:scroll;overflow-x:hidden;line-height: 20px;white-space:pre;" class="textarea_img2" wrap="hard" dataformat="engup" otherchar=" ~!@#$%^&*()`_+-={}|[]\"\':;,./?" onpaste="javascript:mousePaste(this)" name="sh_cust_nm" id="sh_cust_nm"></textarea> 
											</td>
										</tr>					
										<tr>
											<th>Address</th>
											<td>
												<textarea cols="35" rows="3" style="width:345px; resize:none;font-family:Courier New; font-size:15px; text-indent:0px;overflow-y:scroll;overflow-x:hidden;line-height: 20px;white-space:pre" class="textarea_img3" wrap="hard" dataformat="engup" otherchar=" ~!@#$%^&*()`_+-={}|[]\"\':;,./?" onpaste="javascript:mousePaste(this)" name="sh_cust_addr" id="sh_cust_addr"></textarea>
											</td>
										</tr>
									</tbody>
								</table>
								<table class="line_bluedot"><tr><td></td></tr></table>
								<table>
									<colgroup>
										<col width="100" />
										<col width="100" />
										<col width="60" />
										<col />
									</colgroup> 
									<tbody>
										<tr>
											<th>City / State</th>
											<td><input type="text" name="sh_cust_cty_nm" style="width:125px;text-transform:uppercase;" class="input" value="" dataformat="exceptengdn" otherchar=" "  maxlength="30" id="sh_cust_cty_nm" /><input type="text" name="sh_cust_ste_cd" style="width:30px;text-transform:uppercase;" class="input" value="" maxlength="3" dataformat="engup"  id="sh_cust_ste_cd" /></td>
											<th>ZIP Code</th>
											<td><input type="text" name="sh_cust_zip_id" style="width:74px;" class="input" value="" dataformat="engup" otherchar="-\s" maxlength="10" id="sh_cust_zip_id" /><button type="button" id="btn_ShZipCode" name="btn_ShZipCode" class="input_seach_btn"></button></td>
										</tr>
										<tr>
											<th>Country</th>
											<td><input type="text" name="sh_cstms_decl_cnt_cd" style="width:30px;text-transform:uppercase;" class="input" value="" maxlength="2" dataformat="engup"  id="sh_cstms_decl_cnt_cd" /></td>
										</tr>
									</tbody>
								</table>
								<table>
									<colgroup>
										<col width="100" />
										<col />
									</colgroup>
									<tbody>
										<tr>
											<th>Phone</th>
											<td><input type="text" name="sh_phn_no" style="width:200px;" class="input" value="" dataformat="num" otherchar="-"  maxlength="20" id="sh_phn_no" /></td>
										</tr>
										<tr>
											<th>Fax</th>
											<td><input type="text" name="sh_cust_fax_no" style="width:200px;" class="input" value="" maxlength="20" dataformat="num" otherchar="-" id="sh_cust_fax_no" /> </td>
										</tr>
										<tr>
											<th>E-mail</th>
											<td><input type="text" name="sh_cust_eml" style="width:300px;" class="input" value="" maxlength="200" id="sh_cust_eml" /> </td>
										</tr>
									</tbody>
								</table> 
								
			 				</div>
					</div>
					<div class="layout_flex_fixed" style="width:5px; height: 350px">
					</div>
					<div class="layout_flex_fixed"  style="width:465px; height: 350px">
							<div class="opus_design_inquiry sm mar_btm_none" style="height: 350px">
							
								<table class="grid_2">
									<thead>
										<tr>
											<th colspan="2">Haz Consignee</th>
										</tr>
									</thead>
									<colgroup>
										<col width="100" />
										<col/>
									</colgroup>
									<tbody>
										<tr>
											<th width="50">Consignee</th>
											<td>
												<input type="text" name="cn_cust_cnt_cd" style="width:30px;ime-mode:disabled;text-transform:uppercase;" class="input1" value="" maxlength=2   dataformat="engup"><!--
												--><button type="button" name="btn_cn_cust" id="btn_cn_cust" class="input_seach_btn"></button><!--
												--><input type="text" name="cn_cust_seq" id="cn_cust_seq" style="width:58px;" class="input1" value="" maxlength=6   dataformat="num">
											</td>
										</tr>					
										<tr>
											<th>Name</th>
											<td>
												<textarea cols="35" rows="2" style="width:345px; resize:none; font-family:Courier New; font-size:15px; text-indent:0px;overflow-y:scroll;overflow-x:hidden;line-height: 20px;white-space:pre;" class="textarea_img2" wrap="hard" dataformat="engup" otherchar=" ~!@#$%^&*()`_+-={}|[]\"\':;,./?" onpaste="javascript:mousePaste(this)" name="cn_cust_nm" id="cn_cust_nm"></textarea> 
											</td>
										</tr>					
										<tr>
											<th>Address</th>
											<td>
												<textarea cols="35" rows="3" style="width:345px; resize:none;font-family:Courier New; font-size:15px; text-indent:0px;overflow-y:scroll;overflow-x:hidden;line-height: 20px;white-space:pre" class="textarea_img3" wrap="hard" dataformat="engup" otherchar=" ~!@#$%^&*()`_+-={}|[]\"\':;,./?" onpaste="javascript:mousePaste(this)" name="cn_cust_addr" id="cn_cust_addr"></textarea>
											</td>
										</tr>
									</tbody>
								</table>
								<table class="line_bluedot"><tr><td></td></tr></table>
								<table>
									<colgroup>
										<col width="100" />
										<col width="100" />
										<col width="60" />
										<col />
									</colgroup> 
									<tbody>
										<tr>
											<th>City / State</th>
											<td><input type="text" name="cn_cust_cty_nm" style="width:125px;text-transform:uppercase;" class="input" value="" dataformat="exceptengdn" otherchar=" "  maxlength="30" id="cn_cust_cty_nm" /><input type="text" name="cn_cust_ste_cd" style="width:30px;text-transform:uppercase;" class="input" value="" maxlength="3" dataformat="engup"  id="cn_cust_ste_cd" /></td>
											<th>ZIP Code</th>
											<td><input type="text" name="cn_cust_zip_id" style="width:74px;" class="input" value="" dataformat="engup" otherchar="-\s" maxlength="10" id="cn_cust_zip_id" /><button type="button" id="btn_CnZipCode" name="btn_CnZipCode" class="input_seach_btn"></button></td>
										</tr>
										<tr>
											<th>Country</th>
											<td><input type="text" name="cn_cstms_decl_cnt_cd" style="width:30px;text-transform:uppercase;" class="input" value="" maxlength="2" dataformat="engup"  id="cn_cstms_decl_cnt_cd" /></td>
										</tr>
									</tbody>
								</table>
								<table>
									<colgroup>
										<col width="100" />
										<col />
									</colgroup>
									<tbody>
										<tr>
											<th>Phone</th>
											<td><input type="text" name="cn_phn_no" style="width:200px;" class="input" value="" dataformat="num" otherchar="-"  maxlength="20" id="cn_phn_no" /></td>
										</tr>
										<tr>
											<th>Fax</th>
											<td><input type="text" name="cn_cust_fax_no" style="width:200px;" class="input" value="" maxlength="20" dataformat="num" otherchar="-" id="cn_cust_fax_no" /> </td>
										</tr>
										<tr>
											<th>E-mail</th>
											<td><input type="text" name="cn_cust_eml" style="width:300px;" class="input" value="" maxlength="200" id="cn_cust_eml" /> </td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					<div class="layout_flex_fixed" style="width:5px; height: 350px">
					</div>
					<div class="layout_flex_fixed" style="width:200px; height: 350px">
						<h3 class="title_design2">Update Target</h3>
						<script type="text/javascript">ComSheetObject('sheet2');</script>
					</div>
				</div>
				<!-- layout_wrap (E) -->
			
		</div>

		<!-- opus_design_inquiry(3) (E) -->
	</div>
<!-- wrap_result (E) -->
</div> 
</form>
