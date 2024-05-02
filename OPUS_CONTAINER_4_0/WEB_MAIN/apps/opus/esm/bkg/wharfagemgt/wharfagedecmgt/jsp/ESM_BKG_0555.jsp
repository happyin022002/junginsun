<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ui_bkg_0555.jsp
*@FileTitle : ACI_Vessel Information
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/05
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.event.EsmBkg0555Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0555Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd        = "";
	Logger log = Logger.getLogger("com.clt.apps.wharfagemgt.wharfagedecmgt");

	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (EsmBkg0555Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}




%>
<script  type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="frm_attr_ctnt2">
<input type="hidden" name="ofc_cd" value="<%= strOfc_cd %>">


<%
	String keyAddr     = (request.getParameter("keyAddr") == null)? "":request.getParameter("keyAddr");
%>

<div class="page_title_area clear ">
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
			--><button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button><!--
			--><button type="button" class="btn_normal" name="btn_Confirm" id="btn_Confirm">Confirm</button><!--
			--><button type="button" class="btn_normal" name="btn_SumPrint" id="btn_SumPrint">Sum Print</button><!--
			--><button type="button" class="btn_normal" name="btn_Print" id="btn_Print">Print</button>
	</div>

	<div class="location">
		<span id="navigation"></span>
	</div>
</div>

<div class="wrap_search">
	<div class="opus_design_inquiry wFit">
		<table>
			<tr>
			<th title="Vessel Voyage Direction">VVD</th>
			<td><input type="text" style="width:77px;ime-mode:disabled" class="input1" name="vvd" dataformat="engup" maxlength="9"></td>
			<th title="Port of Loading">POL</th>
			<td><input type="text" style="width:49px;" class="input" name="pol_cd" dataformat="engup" maxlength="5"></td>
			<th title="Port of Discharging">POD</th>
			<td><input type="text" style="width:49px;" class="input" name="pod_cd" dataformat="engup" maxlength="5"></td>
			<td><strong>Bound</strong><input type="radio" value="S"class="trans" checked="checked" name="bkg_cust_tp_cd" id="bkg_cust_tp_cd"><!--
				--><label for="bkg_cust_tp_cd">Outbound</label><!--
				--><input type="radio" value="C"class="trans" name="bkg_cust_tp_cd" id="bkg_cust_tp_cd"><label for="bkg_cust_tp_cd">Inbound</label></td>
			<th>Option</th>
			<td>
				<select style="width:100px;" name="bkg_sts_cd" id="bkg_sts_cd">
					<option value="A" selected="selected">All</option>
					<option value="N">OFT (Incl.)</option>
					<option value="Y">EXEM</option>
					<option value="X">Not EXEM</option>
				</select>
			</td>
			</tr>
		</table>
	</div>
  </div>
  <div class="wrap_result">
	<div class="opus_design_inquiry">
		<table border="0">
			<tr>
			<td width="100%" class="sm"><input type="text" style="width:100%;border:0px;text-align:left;padding-left:10px; font-weight:bold;" class="input2" name="retrieve_info" maxlength="15" readonly="readonly"></td>
			</tr>
		</table>
	</div>
	<div class="opus_design_grid">
		<script  type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<div class="opus_design_inquiry">
		<table border="0" style="width:979px;" class="search">
			<tr class="h23">
				<th width="50px" class="align_left">Rate</th>
				<th width="35px" class="align_left">TEU :</th>
				<td width="90px"><input type="text" style="width:50px;text-align:right" class="input2" name="rt_teu" maxlength="15" readonly="readonly"></td>
				<th width="35px" class="align_left">FEU :</th>
				<td width="90px"><input type="text" style="width:50px;text-align:right" class="input2" name="rt_feu" maxlength="15" readonly="readonly"></td>
				<th width="35px" class="align_left">45FT  :</th>
				<td width="90px"><input type="text" style="width:50px;text-align:right" class="input2" name="rt_hcb" maxlength="15" readonly="readonly"></td>
				<th width="60px" class="align_left">TTL AMT :</th>
				<td width="150px"><input type="text" style="width:100px;text-align:right" class="input2" name="ttl_amt" maxlength="15" readonly="readonly"></td>
				<th width="80px" class="align_left">B/L Count :</th>
				<td width="*"><input type="text" style="width:50px;text-align:right" class="input2" name="bl_cnt" maxlength="4" readonly="readonly"></td>
			</tr>
			<tr class="h23">
				<th width="50px" class="align_left">BKG</th>
				<th width="35px" class="align_left">TEU :</th>
				<td width="90px"><input type="text" style="width:50px;text-align:right" class="input2" name="bkg_teu" maxlength="11" readonly="readonly"></td>
				<th width="35px" class="align_left">FEU :</th>
				<td width="90px"><input type="text" style="width:50px;text-align:right" class="input2" name="bkg_feu" maxlength="11" readonly="readonly"></td>
				<th width="35px" class="align_left">45FT  :</th>
				<td width="*" colspan="5"><input type="text" style="width:50px;text-align:right" class="input2" name="bkg_hcb" maxlength="11" readonly="readonly"></td>
			</tr>
		</table>
	</div>
	<div class="opus_design_grid">
		<script  type="text/javascript">ComSheetObject('sheet2');</script>
		<script  type="text/javascript">ComSheetObject('sheet3');</script>
		<script  type="text/javascript">ComSheetObject('sheet4');</script>
		<script  type="text/javascript">ComSheetObject('sheet5');</script>
	</div>
	<div class="opus_design_inquiry">
		<table border="0" style="width:320px; float:right; margin-bottom:20px;">
			<tr class="h23" align="right">
				<th>Confirm 담당자 </th>
				<td><input type="text" style="width:114px;" class="input2" name="cfm_usr_id"><input type="text" style="width:77px;" class="input2" name="upd_dt"></td>
			</tr>
		</table>
	</div>
</div>
</form>
