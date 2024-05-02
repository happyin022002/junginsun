<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0916.jsp
*@FileTitle  : ESM_BKG_0916
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/16
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
<%@ page import="com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.event.EsmBkg0916Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0916Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String vvdCd		= "";
	String portCd			= "";
	String bkgNo			= "";
	String cntrNo			= "";
	String cntrLodgNo			= "";
	String rowNum ="";
	String gubun = "";
	String gubunValue = "";
	Logger log = Logger.getLogger("com.clt.apps.TerminalDocumentation.CLLCDLManifest");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		vvdCd = StringUtil.xssFilter(request.getParameter("vvdCd"))==null?"":StringUtil.xssFilter(request.getParameter("vvdCd"));
		portCd = StringUtil.xssFilter(request.getParameter("portCd"))==null?"":StringUtil.xssFilter(request.getParameter("portCd"));
		bkgNo = StringUtil.xssFilter(request.getParameter("bkgNo"))==null?"":StringUtil.xssFilter(request.getParameter("bkgNo"));
		cntrNo = StringUtil.xssFilter(request.getParameter("cntrNo"))==null?"":StringUtil.xssFilter(request.getParameter("cntrNo"));
		cntrLodgNo = StringUtil.xssFilter(request.getParameter("cntrLodgNo"))==null?"":StringUtil.xssFilter(request.getParameter("cntrLodgNo"));
		rowNum = StringUtil.xssFilter(request.getParameter("rowNum"))==null?"":StringUtil.xssFilter(request.getParameter("rowNum"));
		gubun = StringUtil.xssFilter(request.getParameter("gubun"))==null?"":StringUtil.xssFilter(request.getParameter("gubun"));
		gubunValue = StringUtil.xssFilter(request.getParameter("gubunValue"))==null?"":StringUtil.xssFilter(request.getParameter("gubunValue"));

		event = (EsmBkg0916Event)request.getAttribute("Event");
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

<head>
<title>ESM_BKG_0916</title>


<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body class="popup_bg"  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="in_vsl_cd" value="<%= vvdCd.substring(0,4)%>" id="in_vsl_cd" />
<input type="hidden" name="in_skd_voy_no" value="<%= vvdCd.substring(4,8)%>" id="in_skd_voy_no" />
<input type="hidden" name="in_skd_dir_cd" value="<%= vvdCd.substring(8)%>" id="in_skd_dir_cd" />
<input type="hidden" name="in_port_cd" value="<%= portCd%>" id="in_port_cd" />
<input type="hidden" name="in_bkg_no" value="<%= bkgNo%>" id="in_bkg_no" />
<input type="hidden" name="in_cntr_no" value="<%= cntrNo%>" id="in_cntr_no" />
<input type="hidden" name="in_cntr_lodg_no" value="<%= cntrLodgNo%>" id="in_cntr_lodg_no" />
<input type="hidden" name="rowNum" value="<%= rowNum%>" id="rowNum" />
<input type="hidden" name="gubun" value="<%= gubun%>" id="gubun" />
<input type="hidden" name="gubunValue" value="<%= gubunValue%>" id="gubunValue" />

<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	
		<!-- page_title(S) -->
		<h2 class="page_title"><span>CLL for EDI - RF Info</span></h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn_save" id="btn_save" type="button">Save</button><!--
			--><button class="btn_normal" name="btn_close" id="btn_close" type="button">Close</button><!--
			--></div>
		<!-- opus_design_btn (E) -->
	</div>
	<!-- page_title_area(E) -->
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry" style="height: 200px">
			<table>
				<colgroup>
					<col width="80" />				
					<col width="100" />				
					<col width="90" />				
					<col width="*" />				
			   </colgroup> 
			   <tbody>
			   		<tr>
						<th>Booking No.</th>
						<td><input type="text" style="width:100px;text-align:center;" class="input2" name="form1_bkg_no" value="<%=bkgNo %>" readonly id="form1_bkg_no" /></td>
						<th>Container No.</th>
						<td><input type="text" style="width:100px;text-align:center;" class="input2" name="form1_cntr_no" value="<%=cntrNo %>" readonly id="form1_cntr_no" /></td>
					</tr>
			   </tbody>
			</table>
			<div class="layout_wrap">
				<div class="layout_flex_fixed floatR" style="width:250px">
					<table class="grid2"> 
						<tr>
							<th rowspan="2">Temperature</th>
							<td><input type="text" style="width:100%;text-align:right" class="noinput" name="form1_cdo_temp" maxlength="9" onblur="cToF();" dataformat="num" id="form1_cdo_temp" /></td>
							<td><input type="text" style="width:100%;" class="noinput" value="C" readonly /></td>
						</tr>
						<tr>
							<td><input type="text" style="width:100%;text-align:right" class="noinput2" name="form1_fdo_temp" value="" readonly id="form1_fdo_temp" /></td>
							<td><input type="text" style="width:100%;" class="noinput2" value="F" readonly /></td>
						</tr>
						<tr>
							<th>Ventilation</th>
							<td><input type="text" style="width:100%;text-align:right" class="noinput" name="form1_cntr_vent_rto" value="" dataformat="num" id="form1_cntr_vent_rto" /></td>
							<td><input type="text" style="width:100%;" class="noinput" value="%" readonly /></td>
						</tr>
					</table>
				</div>
				<div class="layout_flex_flex" style="padding-right:258px">
					<table class="grid2"> 
						<tr>
							<th>Over Front</th>
							<td><input type="text" style="width:100%" class="noinput" name="form1_ovr_fwrd_len" value="" dataformat="num" id="form1_ovr_fwrd_len" /></td>
						</tr>
						<tr>
							<th>Over Rear</th>
							<td><input type="text" style="width:100%" class="noinput" name="form1_ovr_bkwd_len" value="" dataformat="num" id="form1_ovr_bkwd_len" /></td>
						</tr>
						<tr>
							<th>Over Height</th>
							<td><input type="text" style="width:100%" class="noinput" name="form1_ovr_hgt" value="" dataformat="num" id="form1_ovr_hgt" /></td>
						</tr>
						<tr>
							<th>Over Left Width</th>
							<td><input type="text" style="width:100%" class="noinput" name="form1_ovr_port_len" value="" dataformat="num" id="form1_ovr_port_len" /></td>
						</tr>
						<tr>
							<th>Over Right Width</th>
							<td><input type="text" style="width:100%" class="noinput" name="form1_ovr_sd_len" value="" dataformat="num" id="form1_ovr_sd_len" /></td>
						</tr>
						<tr>
							<th>Over Weight</th>
							<td><input type="text" style="width:280px" class="noinput" name="form1_ovr_cntr_wgt" value="" dataformat="num" id="form1_ovr_cntr_wgt" /><%=JSPUtil.getCodeCombo("form1_ovr_wgt_ut_cd", "", " style='width:120px'", "CD00775", 0, "")%></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
</div>

<div class="wrap_result" style="display:none">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>			