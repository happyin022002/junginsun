<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ui_bkg_0122.jsp
*@FileTitle : Wharfage Cargo Classification
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/30
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.event.EsmBkg0122Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0122Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//serverException
	String strErrMsg = "";						//error massage
	int rowCount	 = 0;						//DB ResultSet list count

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String sBound = "";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.wharfagemgt.wharfagedecmgt");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0122Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		sBound = (request.getParameter("bound")==null) ? "" : request.getParameter("bound");
		// Inbound / Outbound differ menu
			String sPgmNo = (request.getParameter("pgmNo")==null) ? "" : request.getParameter("pgmNo");
		if ("".equals(sBound)) {
			if (sPgmNo.length() == 12) {
				sBound = "I";
			} else {
				sBound = "O";
			}
		}

		//when open screen, get data in server..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

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
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="frm_attr_ctnt2" id="frm_attr_ctnt2" />
<input type="hidden" name="kr_whf_cntr_20ft_rt" id="kr_whf_cntr_20ft_rt" />
<input type="hidden" name="kr_whf_cntr_40ft_rt" id="kr_whf_cntr_40ft_rt" />
<input type="hidden" name="kr_whf_cntr_45ft_rt" id="kr_whf_cntr_45ft_rt" />
<input type="hidden" name="kr_whf_blk_rt" id="kr_whf_blk_rt" />
<input type="hidden" name="rton_wgt" id="rton_wgt" />
<input type="hidden" name="expt_ton_wgt" id="expt_ton_wgt" />

<!-- Developer Work	-->
<%
	String keyAddr     = (request.getParameter("keyAddr") == null)? "":request.getParameter("keyAddr");
%>

<!-- 제목 -->
<div class="page_title_area clear">
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title">Wharfage Cargo Classification</span></button></h2>
		<!-- page_title(E) -->

		<!-- btn_div -->
   <div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
	    --><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!--
	    --><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
   </div>
   <!-- page_location(S) -->
   <div class="location">
		<span id="navigation"></span>
   </div>
</div>
<!-- 제목 -->


<!-- 검색영역 -->
<div class="wrap_search">
	<div class="opus_design_inquiry">		
		<table>
			 <colgroup>
				<col width="50px" />
				<col width="50px" />
				<col width="50px" />
				<col width="50px" />
				<col width="50px" />
				<col width="50px" />
				<col width="50px" />
				<col width="50px" />
				<col width="50px" />
				<col width="50px" />
				<col width="50px" />
				<col width="50px" />
				<col width="50px" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input type="text" style="width:77px;ime-mode:disabled" class="input1" name="vvd" dataformat="engup" maxlength="9" onkeyup="condition_KeyUp()" ></td>
					<th>Port</th>
					<td><input type="text" style="width:55px;ime-mode:disabled" class="input1" name="port_cd"  dataformat="engup" maxlength="5" onkeyup="condition_KeyUp()"></td>
					<th>Bound</th>
					<td>
					<%=JSPUtil.getCodeCombo("whf_bnd_cd", "", "style='width:140px;' class='input1' onchange='searcgBySelect()'", "CD20044", 0, "")%>
						<script>
						<% if("I".equals(sBound)){ 
								out.println("ComSetObjValue(form.whf_bnd_cd,'IN' );");
							}else if("O".equals(sBound)){
								out.println("ComSetObjValue(form.whf_bnd_cd,'OO' );");
							}
						%>
						</script>
					</td>
					<th class="sm pad_8"><label for="dc_flg">D/C <input type="checkbox" class="trans" name="dc_flg" disabled="disabled"></label></th>
					<th>MRN No.</th>
					<td><input type="text" style="width:90px;" class="input2" name="mf_ref_no" maxlength="22" readonly="readonly" ></td>
					<th>Sailing Date</th>
					<td><input type="text" style="width:75px;" class="input2" name="sail_dt" maxlength="10" dataformat="ymd" readonly="readonly" ></td>
					<th>DEC No.</th>
					<td><input type="text" style="width:155px;" class="input2" name="whf_decl_no" maxlength="10" dataformat="ymd" readonly="readonly"></td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<!-- 검색영역 -->

<!-- 시트영역 -->
<div class="wrap_result">
	<div class="opus_design_grid">	
		<div class="opus_design_btn">
		   <button type="button" class="btn_normal" name="btn_add" id="btn_add">Add</button><!--
		   --><button type="button" class="btn_normal" name="btn_del" id="btn_del">Delete</button><!--
		   --><button type="button" class="btn_normal" name="btn_arif" id="btn_arif">AR I/F</button><!--
		   --><button type="button" class="btn_normal" name="btn_blif" id="btn_blif">BL I/F</button><!--
		   --><button type="button" class="btn_normal" name="btn_rateinquiry" id="btn_rateinquiry">Rate Inquiry</button><!--
		   --><button type="button" class="btn_normal" name="btn_blcheck" id="btn_blcheck">BL Check</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
		<div class="opus_design_inquiry">	
			<table> 
				<tbody>
					<tr>
						<th width="90">Total B/L Count</th>
						<td width="110"><input type="text" style="width:100px;text-align:right" class="input2" name="total_bl_count"></td>
						<th width="80">Total Wharfage</th>
						<td width="110"><input type="text" style="width:100px;text-align:right" class="input2" name="total_wharfage"></td>
						<th width="80">Total Amount</th>
						<td width="110"><input type="text" style="width:100px;text-align:right" class="input2" name="whf_rt_amt"></td>
						<th width="40">R/Total</th>
						<td><input type="text" style="width:80px;text-align:right" class="input2" name="rtotal1"><!--
									 --><input type="text" style="width:80px;text-align:right" class="input2" name="rtotal2"><!--
									 --><input type="text" style="width:80px;text-align:right" class="input2" name="rtotal3"></td>
						<td></td>
					</tr>
				</tbody>
			</table> 
		</div>
		<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
			<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
</div>

<!-- 시트영역 -->

</form>
