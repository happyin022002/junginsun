<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0958.jsp
*@FileTitle  : Booking QTY Update Pop-up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/29
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event.EsmBkg0958Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0958Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.OutboundBLMgt.BLDocumentation");

	String bkg_pck_qty   = "";
	String bkg_pck_unit  = "";
	String bkg_wgt_qty   = "";
	String bkg_wgt_unit  = "";
	String bkg_meas_qty  = "";
	String bkg_meas_unit = "";

	String cm_pck_qty    = "";
	String cm_pck_unit   = "";
	String cm_wgt_qty    = "";
	String cm_wgt_unit   = "";
	String cm_meas_qty   = "";
	String cm_meas_unit  = "";

	String cntr_ttl_pack_qty  = "";
	String cntr_ttl_wgt_qty  = "";
	String cntr_ttl_meas_qty  = "";

	String var_pck_qty   = "";
	String var_wgt_qty   = "";
	String var_meas_qty  = "";
	
	String styleDiscrepancy = "style=\"font-weight:bolder;color:red;text-align:right\"";
	String styleMatch = "style=\"text-align:right\"";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0958Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		bkg_pck_qty   = JSPUtil.getParameter(request, "bkg_pck_qty"  , "");
		bkg_pck_unit  = JSPUtil.getParameter(request, "bkg_pck_unit" , "");
		bkg_wgt_qty   = JSPUtil.getParameter(request, "bkg_wgt_qty"  , "");
		bkg_wgt_unit  = JSPUtil.getParameter(request, "bkg_wgt_unit" , "");
		bkg_meas_qty  = JSPUtil.getParameter(request, "bkg_meas_qty" , "");
		bkg_meas_unit = JSPUtil.getParameter(request, "bkg_meas_unit", "");
		cm_pck_qty    = JSPUtil.getParameter(request, "cm_pck_qty"   , "");
		cm_pck_unit   = JSPUtil.getParameter(request, "cm_pck_unit"  , "");
		cm_wgt_qty    = JSPUtil.getParameter(request, "cm_wgt_qty"   , "");
		cm_wgt_unit   = JSPUtil.getParameter(request, "cm_wgt_unit"  , "");
		cm_meas_qty   = JSPUtil.getParameter(request, "cm_meas_qty"  , "");
		cm_meas_unit  = JSPUtil.getParameter(request, "cm_meas_unit" , "");
		cntr_ttl_pack_qty  = JSPUtil.getParameter(request, "cntr_ttl_pack_qty" , "");
		cntr_ttl_wgt_qty   = JSPUtil.getParameter(request, "cntr_ttl_wgt_qty"  , "");
		cntr_ttl_meas_qty  = JSPUtil.getParameter(request, "cntr_ttl_meas_qty" , "");

		bkg_pck_qty   = ("".equals(bkg_pck_qty)  || "null".equals(bkg_pck_qty))  ? "0" : bkg_pck_qty;
		bkg_wgt_qty   = ("".equals(bkg_wgt_qty)  || "null".equals(bkg_wgt_qty))  ? "0" : bkg_wgt_qty;
		bkg_meas_qty  = ("".equals(bkg_meas_qty) || "null".equals(bkg_meas_qty)) ? "0" : bkg_meas_qty;

		cm_pck_qty    = ("".equals(cm_pck_qty)   || "null".equals(cm_pck_qty))   ? "0" : cm_pck_qty;
		cm_wgt_qty    = ("".equals(cm_wgt_qty)   || "null".equals(cm_wgt_qty))   ? "0" : cm_wgt_qty;
		cm_meas_qty   = ("".equals(cm_meas_qty)  || "null".equals(cm_meas_qty))  ? "0" : cm_meas_qty;

		cntr_ttl_pack_qty    = ("".equals(cntr_ttl_pack_qty) || "null".equals(cntr_ttl_pack_qty))  ? "0" : cntr_ttl_pack_qty;
		cntr_ttl_wgt_qty    = ("".equals(cntr_ttl_wgt_qty)   || "null".equals(cntr_ttl_wgt_qty))   ? "0" : cntr_ttl_wgt_qty;
		cntr_ttl_meas_qty   = ("".equals(cntr_ttl_meas_qty)  || "null".equals(cntr_ttl_meas_qty))  ? "0" : cntr_ttl_meas_qty;

		var_pck_qty   = String.valueOf(Float.parseFloat(bkg_pck_qty)  - Float.parseFloat(cm_pck_qty));
		var_wgt_qty   = String.valueOf(Float.parseFloat(bkg_wgt_qty)  - Float.parseFloat(cm_wgt_qty));
		var_meas_qty  = String.valueOf(Float.parseFloat(bkg_meas_qty) - Float.parseFloat(cm_meas_qty));

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
<!-- 개발자 작업	-->

<!-- 개발자 작업	-->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span>Total Booking Quantity Update</span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn1_Yes" id="btn1_Yes" type="button">Save & Update</button><!--
		--><button class="btn_normal" name="btn1_No" id="btn1_No" type="button">Save</button><!--
		--><button class="btn_normal" name="btn1_Close" id="btn1_Close" type="button">Save Cancel</button><!--
		--></div>
	<!-- opus_design_btn (E) -->
</div>
<!-- page_title_area(E) -->

<!-- wrap search (S) -->
<div class="wrap_search">
	<table>
		<colgroup>
			<col width="35">
			<col width="*">
		</colgroup>
		<tbody>
			<tr class="align_left">
				<td><img class="cursor" src="img/btns_help.gif" width="19" height="20" border="0" align="absmiddle"></td>
				<th>Do you want to update total Package, Weight &amp; Measure of Booking & Container information according to C/M quantity?</th>
				<td>&nbsp;</td>
			</tr>
		</tbody>
	</table>
	<table class="grid2">
		<tr class="tr2_head2"><td width="25%"></td>
			<th colspan="2">Package		</th>
			<th colspan="2">Weight		</th>
			<th colspan="2">Measure	</th>
		<tr><td class="tr2_head2" align="center">Booking</td>
			<th <%if(cm_pck_qty.toString().equals(bkg_pck_qty.toString())) {out.print(styleMatch);}else{out.print(styleDiscrepancy);}%> id="bkg_pck_qty" name="bkg_pck_qty" ><%=bkg_pck_qty%></th>
			<th style="text-align:left"  id="bkg_pck_unit" name="bkg_pck_unit" ><%=bkg_pck_unit%></th>
			<th <%if(cm_wgt_qty.toString().equals(bkg_wgt_qty.toString())) {out.print(styleMatch);}else{out.print(styleDiscrepancy);}%> id="bkg_wgt_qty" name="bkg_wgt_qty" ><%=bkg_wgt_qty%></th>
			<th style="text-align:left"  id="bkg_wgt_unit" name="bkg_wgt_unit" ><%=bkg_wgt_unit%></th>
			<th <%if(cm_meas_qty.toString().equals(bkg_meas_qty.toString())) {out.print(styleMatch);}else{out.print(styleDiscrepancy);}%> id="bkg_meas_qty" name="bkg_meas_qty" ><%=bkg_meas_qty%></th>
			<th style="text-align:left"  id="bkg_meas_unit" name="bkg_meas_unit" ><%=bkg_meas_unit%></th>
		</tr>
		<tr><td class="tr2_head2" align="center">CNTR</td>
			<th <%if(cm_pck_qty.toString().equals(cntr_ttl_pack_qty.toString())) {out.print(styleMatch);}else{out.print(styleDiscrepancy);}%> id="cntr_ttl_pack_qty"  name="cntr_ttl_pack_qty" ><%=cntr_ttl_pack_qty%></th>
			<th style="text-align:left"  id="cntr_ttl_pack_unit" name="cntr_ttl_pack_unit" ><%=cm_pck_unit%></th>
			<th <%if(cm_wgt_qty.toString().equals(cntr_ttl_wgt_qty.toString())) {out.print(styleMatch);}else{out.print(styleDiscrepancy);}%> id="cntr_ttl_wgt_qty" 	 name="cntr_ttl_wgt_qty" ><%=cntr_ttl_wgt_qty%></th>
			<th style="text-align:left"  id="cntr_ttl_wgt_unit"  name="cntr_ttl_wgt_unit" ><%=cm_wgt_unit%></th>
			<th <%if(cm_meas_qty.toString().equals(cntr_ttl_meas_qty.toString())) {out.print(styleMatch);}else{out.print(styleDiscrepancy);}%> id="cntr_ttl_meas_qty"  name="cntr_ttl_meas_qty" ><%=cntr_ttl_meas_qty%></th>
			<th style="text-align:left"  id="cntr_ttl_meas_unit" name="cntr_ttl_meas_unit" ><%=cm_meas_unit%></th>
		</tr>
		<tr><td class="tr2_head2" align="center" style="font-weight:bolder;color:blue">C/M</td>
			<th style="font-weight:bolder;color:blue;text-align:right"  id="cm_pck_qty" name="cm_pck_qty" ><%=cm_pck_qty%></th>
			<th style="color:blue;text-align:left"  id="cm_pck_unit" name="cm_pck_unit" ><%=cm_pck_unit%></th>
			<th style="font-weight:bolder;color:blue;text-align:right"  id="cm_wgt_qty" name="cm_wgt_qty" ><%=cm_wgt_qty%></th>
			<th style="color:blue;text-align:left"  id="cm_wgt_unit" name="cm_wgt_unit" ><%=cm_wgt_unit%></th>
			<th style="font-weight:bolder;color:blue;text-align:right"  id="cm_meas_qty" name="cm_meas_qty" ><%=cm_meas_qty%></th>
			<th style="color:blue;text-align:left"  id="cm_meas_unit" name="cm_meas_unit" ><%=cm_meas_unit%></th>
		</tr>
		<!-- 
		<tr><td class="tr2_head2" align="center">Variance</td>
			<th id="var_pck_qty" name="var_pck_qty" <%if((Float.parseFloat(bkg_pck_qty)-Float.parseFloat(cm_pck_qty))==0) {out.print("style=\"color:blue;text-align:right\"");}else{out.print("style=\"color:red;text-align:right\"");}%>><%=var_pck_qty%></th>
			<td style="text-align:left"  id="var_pck_unit" name="var_pck_unit" ></td>
			<th id="var_wgt_qty" name="var_wgt_qty"  <%if((Float.parseFloat(bkg_wgt_qty)-Float.parseFloat(cm_wgt_qty))==0)  {out.print("style=\"color:blue;text-align:right\"");}else{out.print("style=\"color:red;text-align:right\"");}%>><%=var_wgt_qty%></th>
			<td style="text-align:left"  id="valr_wgt_unit" name="valr_wgt_unit" ></td>
			<th id="var_meas_qty" name="var_meas_qty" <%if((Float.parseFloat(bkg_meas_qty)-Float.parseFloat(cm_meas_qty))==0)  {out.print("style=\"color:blue;text-align:right\"");}else{out.print("style=\"color:red;text-align:right\"");}%>><%=var_meas_qty%></th>
			<td style="text-align:left"  id="var_meas_unit" name="var_meas_unit" ></td>
		</tr>
		 -->
	</table>
	<table class="line_bluedot"><tr><td></td></tr></table>
</div>
<!-- wrap search (E) -->

<!-- wrap result (S) -->
<div class="wrap_result">
	<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
<!-- wrap result (E) -->
</form>

