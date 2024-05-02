<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0931.jsp
*@FileTitle  : Container Loading List(KOREA)_Print Preview 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/02
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
<%@ page import="com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.event.EsmBkg0931Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0931Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error Message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	String inVvdCd = "";
	String inPolCd = "";
	String inPolYdCd = "";
	String inCllType = "";
	String inBkgStsCd = "";
	String inCntrCfmFlg = "";
	String inSortType = "";
	String inBlCllData="";
	Logger log = Logger.getLogger("com.clt.apps.TerminalDocumentation.CLLCDLManifest");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		
		inVvdCd = StringUtil.xssFilter(request.getParameter("inVvdCd"))==null?"":StringUtil.xssFilter(request.getParameter("inVvdCd"));
		inPolCd = StringUtil.xssFilter(request.getParameter("inPolCcd"))==null?"":StringUtil.xssFilter(request.getParameter("inPolCcd"));
		inPolYdCd = StringUtil.xssFilter(request.getParameter("inPolYdCd"))==null?"":StringUtil.xssFilter(request.getParameter("inPolYdCd"));
		inCllType = StringUtil.xssFilter(request.getParameter("inCllType"))==null?"":StringUtil.xssFilter(request.getParameter("inCllType"));
		inBkgStsCd = StringUtil.xssFilter(request.getParameter("inBkgStsCd"))==null?"":StringUtil.xssFilter(request.getParameter("inBkgStsCd"));
		inCntrCfmFlg = StringUtil.xssFilter(request.getParameter("inCntrCfmFlg"))==null?"":StringUtil.xssFilter(request.getParameter("inCntrCfmFlg"));
		inSortType = StringUtil.xssFilter(request.getParameter("inSortType"))==null?"":StringUtil.xssFilter(request.getParameter("inSortType"));
		inBlCllData = StringUtil.xssFilter(request.getParameter("inBlCllData"))==null?"":StringUtil.xssFilter(request.getParameter("inBlCllData"));
		

		event = (EsmBkg0931Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// If you imported data from the server initialization when loading
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


<!-- <body class="popup_bg" onLoad="setupPage();"> -->
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="in_vvd_cd" value="<%=inVvdCd%>">
<input type="hidden" name="in_pol_cd" value="<%=inPolCd%>">
<input type="hidden" name="in_pol_yd_cd" value="<%=inPolYdCd%>">
<input type="hidden" name="in_cll_type" value="<%=inCllType%>">
<input type="hidden" name="in_bkg_sts_cd" value="<%=inBkgStsCd%>">
<input type="hidden" name="in_cntr_cfm_flg" value="<%=inCntrCfmFlg%>">
<input type="hidden" name="in_sort_type" value="<%=inSortType%>">
<input type="hidden" name="in_bl_cll_data" value="<%=inBlCllData%>">
<input type="hidden" name="in_where_gubun" value="931">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title">
		<button type="button"><span>Container Loading List(KOREA)_Print Preview</span></button>
	</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_normal" name="btn_Summary" id="btn_Summary">Summary</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Special_CGO" id="btn_Special_CGO">Special CGO</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Print" id="btn_Print">Print</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Close" id="btn_Close" >Close</button>
<!-- 		<td class="btn1" name="btn_Close" id="btn_Close" onClick="self.close()">Close</td> -->
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<table>
			<tbody>
				<colgroup>
					<col width="40"/>
					<col width="200"/>
					<col width="50"/>
					<col width="80"/>
					<col width="50"/>
					<col width="*"/>
				</colgroup>
				<tr>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input type="text" style="width:200px;" name="vvd_cd_nm" value="" dataformat="engup" class="input2" readonly></td>
					<th title="Port of Loading">POL</th>
					<td ><input type="text" style="width:70px;" name="pol_cd_print" value="" dataformat="engup" class="input2" readonly></td>
					<th>ETD</th>	
					<td ><input type="text" style="width:125px;" name="vps_etd" value="" dataformat="engup" class="input2" readonly></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>

<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	
	<!-- opus_design_grid(E) -->
	<div class="opus_design_data">
		<table class="grid_2">
			<tbody>
			<tr>
					<td class="sm">D2</td>
					<td><input type="text" name="d2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td class="sm">D4</td>
					<td><input type="text" name="d4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td class="sm">D5</td>
					<td><input type="text" name="d5" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td class="sm">D7</td>
					<td><input type="text" name="d7" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td class="sm">D8</td>
					<td><input type="text" name="d8" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td class="sm">D9</td>
					<td><input type="text" name="d9" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td class="sm">DW</td>
					<td><input type="text" name="dw" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td class="sm">DX</td>
					<td><input type="text" name="dx" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td class="sm">R2</td>
					<td><input type="text" name="r2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td class="sm">R4</td>
					<td><input type="text" name="r4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td class="sm">R5</td>
					<td><input type="text" name="r5" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td class="sm">F2</td>
					<td><input type="text" name="f2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td class="sm">F4</td>
					<td><input type="text" name="f4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td class="sm">F5</td>
					<td><input type="text" name="f5" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				</tr>
				<tr>
					<td class="sm">O2</td>
					<td><input type="text" name="o2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td class="sm">O4</td>
					<td><input type="text" name="o4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td class="sm">O5</td>
					<td><input type="text" name="o5" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td class="sm">S2</td>
					<td><input type="text" name="s2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td class="sm">S4</td>
					<td><input type="text" name="s4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td class="sm">T2</td>
					<td><input type="text" name="t2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td class="sm">T4</th>
					<td><input type="text" name="t4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td class="sm">A2</td>
					<td><input type="text" name="a2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td class="sm">A4</td>
					<td><input type="text" name="a4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td class="sm">P2</td>
					<td><input type="text" name="p2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td class="sm">P4</td>
					<td><input type="text" name="p4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td class="sm">Z2</td>
					<td><input type="text" name="z2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td class="sm">Z4</td>
					<td><input type="text" name="z4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td class="sm"></td>
					<td></td>
				</tr>
				<tr>
					<td class="sm">D3</td>
					<td><input type="text" name="d3" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td class="sm">R9</td>
					<td><input type="text" name="r9" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td class="sm">ETC</td>
					<td><input type="text" name="etc" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>		
					<td class="sm"></td>
					<td width=""align="center"></td>
					<td class="sm"></td>
					<td width=""align="center"></td>
					<td class="sm"></td>
					<td width=""align="center"></td>
					<td class="sm"></td>
					<td width=""align="center"></td>
					<td class="sm"></td>
					<td width=""align="center"></td>
					<td class="sm"></td>
					<td width=""align="center"></td>		
					<td class="sm"></td>
					<td width=""align="center"></td>		
					<td class="sm"></td>
					<td width=""align="center"></td>		
					<td class="sm"></td>
					<td width=""align="center"></td>		
					<th class="sm" colspan="2">Total</th>
					<td colspan="2"><input type="text" name="totalTpSize" value="" size="5" style="text-align:center;font-weight:bold" readonly></td>
				</tr>
			</tbody>
		</table>
		<table class="grid_2"> 
			<tbody>
				<!-- <colgroup>
					<col width="50"/>
					<col width="60"/>
					<col width="50"/>
					<col width="60"/>
					<col width="50"/>
					<col width="60"/>
					<col width="50"/>
					<col width="60"/>
					<col width="50"/>
					<col width="60"/>
					<col width="50"/>
					<col width="60"/>
					<col width="50"/>
					<col width="60"/>
					<col width="50"/>
					<col width="*"/>
				</colgroup> -->
			 	<tr>
					<th class="sm">Local</th>
					<td><input type="text" name="local" value="" size="3" style="text-align:center;font-weight:bold" readonly></td>
					<td class="sm">Full</td>
					<td><input type="text" name="localFull" value="" size="3" style="text-align:center;font-weight:bold" readonly></td>
					<td class="sm">Empty</td>
					<td><input type="text" name="localEmpty" value="" size="3" style="text-align:center;font-weight:bold" readonly></td>
					<th class="sm">T/S</th>
					<td><input type="text" name="ts" value="" size="3" style="text-align:center;font-weight:bold" readonly></td>
					<td class="sm">Full</td>
					<td><input type="text" name="tsFull" value="" size="3" style="text-align:center;font-weight:bold" readonly></td>
					<td class="sm">Empty</td>
					<td><input type="text" name="tsEmpty" value="" size="3" style="text-align:center;font-weight:bold" readonly></td>
					<th class="sm">WGT</th>
					<td><input type="text" name="wgt" value="" size="10" style="text-align:center;font-weight:bold" readonly></td>
					<th class="sm">VGM</th>
					<td><input type="text" name="vgm" value="" size="10" style="text-align:center;font-weight:bold" readonly></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
</form>