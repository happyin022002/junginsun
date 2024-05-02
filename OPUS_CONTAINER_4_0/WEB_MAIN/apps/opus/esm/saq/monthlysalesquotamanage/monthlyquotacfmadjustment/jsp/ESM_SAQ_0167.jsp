<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SAQ_0167.jsp
*@FileTitle  : Office Add(Quota Edit) 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/31
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacfmadjustment.event.EsmSaq0167Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSaq0167Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String loginOfcCd 	    = "";

	String qtaTgtCd         = JSPUtil.getParameter(request, "qtaTgtCd"        , "");
	String mqtaRlseVerNo    = JSPUtil.getParameter(request, "mqtaRlseVerNo"     , "");
	String org_cd           = JSPUtil.getParameter(request, "org_cd"          , "");
	String bse_yr           = JSPUtil.getParameter(request, "bse_yr"          , "");
	String bse_qtr_cd       = JSPUtil.getParameter(request, "bse_qtr_cd"      , "");
	String trd_cd           = JSPUtil.getParameter(request, "trd_cd"          , "");
	String dir_cd           = JSPUtil.getParameter(request, "dir_cd"          , "");
	String add_tp_cd        = JSPUtil.getParameter(request, "add_tp_cd"       , "");
	String param_rlane_cd   = JSPUtil.getParameter(request, "rlane_cd"        , "");

	Logger log = Logger.getLogger("com.clt.apps.MonthlySalesQuotaManage.monthlyquotacfmadjustment");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id  = account.getUsr_id();
		strUsr_nm  = account.getUsr_nm();
		loginOfcCd = account.getOfc_cd();


		event = (EsmSaq0167Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="qtaTgtCd" value="<%=qtaTgtCd%>" id="qtaTgtCd" />
<input type="hidden" name="mqtaRlseVerNo" value="<%=mqtaRlseVerNo%>" id="mqtaRlseVerNo" />
<input type="hidden" name="add_tp_cd" value="<%=add_tp_cd%>" id="add_tp_cd" />
<input type="hidden" name="param_rlane_cd" value="<%=param_rlane_cd%>" id="param_rlane_cd" />
<input type="hidden" name="rgnOfcCd" id="rgnOfcCd" />
<div class="layer_popup_contents">
	<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title" id="popup_title" name="popup_title"><span>Office Add</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_officeadd" 	id="btn_officeadd">Row Add</button><!--
			--><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!--
			--><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button><!--
		--></div>
		<!-- opus_design_btn(E) -->
		<!-- page_location(S) -->
		<!-- <div class="location">
			<span id="navigation"></span>
		</div> -->
		<!-- page_location(E) -->
	</div>
	<!-- page_title_area(E) -->
	</div>
	<div class= "wrap_search">
		<div class= "opus_design_inquiry wFit">
			<table style="display:none;" id="new_rlane">
				<tr>
					<td width="67">New Lane</td>
					<td><input class="input1" style="width:70;" maxlength="5" name="newRlaneCd" dataformat="engup" ></td>
				</tr>
			</table>
			<table>
				<colgroup>
					<col width="70" />
					<col width="100" />
					<col width="35" />
					<col width="100" />
					<col width="100" />
					<col width="100" />
					<col width="45" />
					<col width="110" />
					<col width="45" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<th>Origin</th>
						<td><input class="input1" style="width:70px;cursor:default;" name="org_cd" value="<%=org_cd%>" unselectable="on" id="org_cd" maxlength="5" dataformat="engup"/> </td>
						<th>Year</th>
						<td><input class="input1" style="width:70px;cursor:default;" name="bse_yr" value="<%=bse_yr%>" unselectable="on" id="bse_yr" maxlength="4" dataformat="engup"/> </td>
						<th>Quarter</th>
						<td><input class="input1" style="width:70px;cursor:default;" name="bse_qtr_cd" value="<%=bse_qtr_cd%>" unselectable="on" id="bse_qtr_cd" maxlength="2" dataformat="engup"/> </td>
						<th>Trade</th>
						<td><input class="input1" style="width:80px;cursor:default;" name="trd_cd" value="<%=trd_cd%>" unselectable="on" id="trd_cd" maxlength="3" dataformat="engup"/> </td>
						<th>Bound</th>
						<td><input class="input1" style="width:70px;cursor:default;" name="dir_cd" value="<%=dir_cd%>" unselectable="on" id="dir_cd" maxlength="1" dataformat="engup"/> </td>
					</tr>
					<tr class="h23">
						<th>Sub Trade</th>
						<td><select class="input1" name="sub_trd_cd" style="width:70px" onchange="setSelect_box(rlane_cd);"></select></td>
						<th>Lane</th>
						<td><select class="input1" name="rlane_cd" style="width:70px" onchange="setSelect_box(rhq_cd);setSelect_box(aq_cd);"></select></td>
						<th>Regional Group</th>
						<td><select class="input1" name="rhq_cd" style="width:70px" onchange="setSelect_box(aq_cd);"></select></td>
						<th>Area</th>
						<td><select name="aq_cd" style="width:80px" onchange="setSelect_box(rgn_ofc_combo);"></select></td>
						<th>Office</th>
						<td><script type="text/javascript">ComComboObject("rgn_ofc_combo", 1, 70, 1, 1);</script></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>			
	
	<!-- opus_design_grid(S) -->
	<div class="wrap_result">
		<div class="opus_design_grid clear" id="mainTable" >
				<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
	<!-- opus_design_grid(S) -->
	<div class="wrap_result" id="hiddenLayer2" style="display:none">
		<div class="opus_design_grid clear" id="mainTable" >
				<script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
</div>

</form>