<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0933.jsp
*@FileTitle  : Container Loading List(KOREA)_Print Preview_Special Cargo 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/29
=========================================================
--%>


<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.event.EsmBkg0933Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0933Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	String inVvdCd = "";
	String inPolCd = "";
	String inPolYdCd = "";
	
	String inCllType = "";
	
	String popup_title = "";
	
	Logger log = Logger.getLogger("com.clt.apps.TerminalDocumentation.CLLCDLManifest");

	String pgmNo = request.getParameter("pgmNo");
	try {
		
		if ("ESM_BKG_0951".equals(pgmNo)){
			popup_title = "Load Summary by POD_ Special Stowage";
		} else {
			popup_title = "Container Loading List(KOREA)_Print Preview_Special CGO";
		}
		
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		
		inVvdCd = StringUtil.xssFilter(request.getParameter("inVvdCd"))==null?"":StringUtil.xssFilter(request.getParameter("inVvdCd"));
		inPolCd = StringUtil.xssFilter(request.getParameter("inPolCcd"))==null?"":StringUtil.xssFilter(request.getParameter("inPolCcd"));		
		inPolYdCd = StringUtil.xssFilter(request.getParameter("inPolYdCd"))==null?"":StringUtil.xssFilter(request.getParameter("inPolYdCd"));
		inCllType = StringUtil.xssFilter(request.getParameter("inCllType"))==null?"":StringUtil.xssFilter(request.getParameter("inCllType"));


		event = (EsmBkg0933Event)request.getAttribute("Event");
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


<script Type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<!-- <body class="popup_bg" onLoad="setupPage();"> -->
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="in_vvd_cd" id="in_vvd_cd" value="<%=inVvdCd%>">
<input type="hidden" name="in_pol_cd" id="in_pol_cd" value="<%=inPolCd%>">
<input type="hidden" name="in_pol_yd_cd" id="in_pol_yd_cd" value="<%=inPolYdCd%>">
<input type="hidden" name="in_by_type" id="in_by_type" value="">
<input type="hidden" name="in_pgm_no" id="in_pgm_no" value="<%=pgmNo%>">
<input type="hidden" name="in_cll_type" id="in_cll_type" value="<%=inCllType %>">

<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Container Loading List(KOREA)_Print Preview_Special Cargo</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<td>
			<!--  <input type="radio" value="" name="in_by_type_temp" id="in_by_type_temp" class="trans" onClick="goBySearch()" checked><label for ="in_by_type_temp">ALL</label> 
			 <input type="radio" value="" name="in_by_type_temp" id="in_by_type_temp" class="trans" onClick="goBySearch()"><label for ="in_by_type_temp">LOCAL</label> 
			 <input type="radio" name="in_by_type_temp" id="in_by_type_temp" value="" class="trans" onClick="goBySearch()"><label for ="in_by_type_temp">T/S</label><!-- 
					 --><select name="in_sort_type" onChange="goSearch();">
						<option value="1" selected>Sort</option>
						<option value="1">POD</option>
						<option value="2">CGO_TYPE</option>
						<option value="3">CNTR</option>
						<option value="4">MLB</option>
					</select>
			</td><!-- 
		 --><button type="button" class="btn_normal" name="btn_Print" id="btn_Print">Print</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->
	</div>
	<!-- page_title_area(E) -->
</div>

<div class="layer_popup_contents">
	<div class= "wrap_search">
		<div class= "opus_design_inquiry">
		<!-- opus_design_inquiry(S) -->
		<h3 style="margin-bottom:0" class="title_design">SPECIAL CARGO DETAIL</h3>
			<table> 
				<colgroup>
					<col width="50">
					<col width="380">
					<col width="50">
					<col width="150">
					<col width="50">
					<col width="50">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th>VVD :</th>
						<td><input type="text" style="width:300px;" class="input2" name="vvd_cd" id="vvd_cd" readonly></td>
						<th>POL :</th>
						<td><input type="text" style="width:80px;" class="input2" name="un_loc_cd" id ="un_loc_cd" readonly></td>
						<th>ETD :</th>
						<td><input type="text" style="width:120px;" class="input2" name="vps_etd_dt" id="vps_etd_dt" readonly></td>
						<td></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid clear">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->
		<!-- opus_design_data(S) -->
		<div class="opus_design_inquiry wFit">
		<table  class="grid_2">
		<colgroup>
				<col width="20">
				<col width="50">
				<col width="50">
				<col width="50">
				<col width="50">
				<col width="50">
				<col width="50">
				<col width="50">
				<col width="50">
				<col width="50">
				<col width="50">
				<col width="50">
				<col width="50">
				<col width="50">
				<col width="50">
				<col width="50">
				<col width="50">
				<col width="50">
				<col width="50">
				<col width="50">
				<col width="50">
				<col width="50">
				<col width="50">
				<col width="50">
				<col width="50">
				<col width="50">
				<col width="50">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>D2	</th>
					<td><input type="text" name="d2" value="" size="2" style="text-align:center;font-weight:bold" readonly id="d2" /> </td>
					<th>D4	</th>
					<td><input type="text" name="d4" value="" size="2" style="text-align:center;font-weight:bold" readonly id="d4" /> </td>
					<th>D5</th>
					<td><input type="text" name="d5" value="" size="2" style="text-align:center;font-weight:bold" readonly id="d5" /> </td>
					<th>D7	</th>
					<td><input type="text" name="d7" value="" size="2" style="text-align:center;font-weight:bold" readonly id="d7" /> </td>
					<th>D8</th>
					<td><input type="text" name="d8" value="" size="2" style="text-align:center;font-weight:bold" readonly id="d8" /> </td>
					<th>D9	</th>
					<td><input type="text" name="d9" value="" size="2" style="text-align:center;font-weight:bold" readonly id="d9" /> </td>
					<th>DW	</th>
					<td><input type="text" name="dw" value="" size="2" style="text-align:center;font-weight:bold" readonly id="dw" /> </td>
					<th>DX	</th>
					<td><input type="text" name="dx" value="" size="2" style="text-align:center;font-weight:bold" readonly id="dx" /> </td>
					<th>R2	</th>
					<td><input type="text" name="r2" value="" size="2" style="text-align:center;font-weight:bold" readonly id="r2" /> </td>
					<th>R4</th>
					<td><input type="text" name="r4" value="" size="2" style="text-align:center;font-weight:bold" readonly id="r4" /> </td>
					<th>R5	</th>
					<td><input type="text" name="r5" value="" size="2" style="text-align:center;font-weight:bold" readonly id="r5" /> </td>
					<th>F2	</th>
					<td><input type="text" name="f2" value="" size="2" style="text-align:center;font-weight:bold" readonly id="f2" /> </td>
					<th>F4	</th>
					<td><input type="text" name="f4" value="" size="2" style="text-align:center;font-weight:bold" readonly id="f4" /> </td>
					<th>F5	</th>
					<td><input type="text" name="f5" value="" size="2" style="text-align:center;font-weight:bold" readonly id="f5" /> </td>
				</tr>
				<tr>
					<th>O2	</th>
					<td><input type="text" name="o2" value="" size="2" style="text-align:center;font-weight:bold" readonly id="o2" /> </td>
					<th>O4		</th>
					<td><input type="text" name="o4" value="" size="2" style="text-align:center;font-weight:bold" readonly id="o4" /> </td>
					<th>O5		</th>
					<td><input type="text" name="o5" value="" size="2" style="text-align:center;font-weight:bold" readonly id="o5" /> </td>
					<th>S2	</th>
					<td><input type="text" name="s2" value="" size="2" style="text-align:center;font-weight:bold" readonly id="s2" /> </td>
					<th>S4		</th>
					<td><input type="text" name="s4" value="" size="2" style="text-align:center;font-weight:bold" readonly id="s4" /> </td>
					<th>T2</th>
					<td><input type="text" name="t2" value="" size="2" style="text-align:center;font-weight:bold" readonly id="t2" /> </td>
					<th>T4		</th>
					<td><input type="text" name="t4" value="" size="2" style="text-align:center;font-weight:bold" readonly id="t4" /> </td>
					<th>A2	</th>
					<td><input type="text" name="a2" value="" size="2" style="text-align:center;font-weight:bold" readonly id="a2" /> </td>
					<th>A4		</th>
					<td><input type="text" name="a4" value="" size="2" style="text-align:center;font-weight:bold" readonly id="a4" /> </td>
					<th>P2	</th>
					<td><input type="text" name="p2" value="" size="2" style="text-align:center;font-weight:bold" readonly id="p2" /> </td>
					<th>P4	</th>
					<td><input type="text" name="p4" value="" size="2" style="text-align:center;font-weight:bold" readonly id="p4" /> </td>
					<th>Z2	</th>
					<td><input type="text" name="z2" value="" size="2" style="text-align:center;font-weight:bold" readonly id="z2" /> </td>
					<th>Z4	</th>
					<td><input type="text" name="z4" value="" size="2" style="text-align:center;font-weight:bold" readonly id="z4" /> </td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<th>D3</th>
					<td><input type="text" name="d3" value="" size="2" style="text-align:center;font-weight:bold" readonly id="d3" /> </td>
					<th>R9</th>
					<td><input type="text" name="r9" value="" size="2" style="text-align:center;font-weight:bold" readonly id="r9" /> </td>
					<th>ETC</th>
					<td><input type="text" name="etc" value="" size="2" style="text-align:center;font-weight:bold" readonly id="etc" /> </td>
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
					<th class="sm" colspan="2">Total</th>
					<td colspan="2"><input type="text" name="totalTpSize" value="" size="5" style="text-align:center;font-weight:bold" readonly id="totalTpSize" /> </td>
				</tr>
			</table>
			<table  class="grid_2"> 
			<colgroup>
				<col width="25">
				<col width="50">
				<col width="50">
				<col width="50">
				<col width="50">
				<col width="50">
				<col width="50">
				<col width="50">
				<col width="50">
				<col width="50">
				<col width="50">
				<col width="50">
				<col width="50">
				<col width="*">
			</colgroup>
			<tbody>
			 	<tr>
					<th>Local</th>
					<td><input type="text" name="local" value="" size="3" style="text-align:center;font-weight:bold" readonly id="local" /> </td>
					<th>Full	</th>
					<td><input type="text" name="localFull" value="" size="3" style="text-align:center;font-weight:bold" readonly id="localFull" /> </td>
					<th>Empty		</th>
					<td><input type="text" name="localEmpty" value="" size="3" style="text-align:center;font-weight:bold" readonly id="localEmpty" /> </td>
					<th>T/S		</th>
					<td><input type="text" name="ts" value="" size="3" style="text-align:center;font-weight:bold" readonly id="ts" /> </td>
					<th>Full			</th>
					<td><input type="text" name="tsFull" value="" size="3" style="text-align:center;font-weight:bold" readonly id="tsFull" /> </td>
					<th>Empty		</th>
					<td><input type="text" name="tsEmpty" value="" size="3" style="text-align:center;font-weight:bold" readonly id="tsEmpty" /> </td>
					<th>WGT	</th>
					<td><input type="text" name="wgt" value="" size="15" style="text-align:center;font-weight:bold" readonly id="wgt" /> </td>
				</tr>
			</tbody>
			</table>
		</div>
		<!-- opus_design_data(E) -->
		
		<div class="opus_design_grid" id="mainTable">
			<script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>	
		<!-- opus_design_grid(E) -->
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" style = "width:500px;" id="mainTable" >
			<script type="text/javascript">ComSheetObject('sheet3');</script>
		</div>		
		<!-- opus_design_grid(E) -->
		<!-- opus_design_grid(S) -->
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" id="mainTable" style="display:none">
			<script type="text/javascript">ComSheetObject('sheet4');</script>
		</div>
	</div>
</div>
<!-- opus_design_grid(E) -->
</form>