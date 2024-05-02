<%
/*=========================================================
*Copyright(c) 2015 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_CSQ_0212.jsp
*@FileTitle  : Basic CMCB for IAS Sector_COA UC PFMC Retrieve
*@author     : CLT
*@version    : 1.0
*@since      : 2015/02/06
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.csq.datamanage.costmanage.event.EsmCsq0212Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%

	String p_bse_tp_cd  = JSPUtil.getParameter(request, "f_bse_tp_cd", "");
	String p_bse_yr     = JSPUtil.getParameter(request, "f_bse_yr", "");
	String p_bse_qtr_cd = JSPUtil.getParameter(request, "f_bse_qtr_cd", "");
	String p_sub_trd_cd = JSPUtil.getParameter(request, "f_sub_trd_cd", "");
	String p_rlane_cd   = JSPUtil.getParameter(request, "f_rlane_cd", "");
	String p_dir_cd     = JSPUtil.getParameter(request, "f_dir_cd", "");

	EsmCsq0212Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";


	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.datamanage.costmanage");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmCsq0212Event)request.getAttribute("Event");
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

	var curTitle = "Basic CMCB for IAS Sector_COA UC PFMC Retrieve";
	var curDescription = "Basic CMCB for IAS Sector_COA UC PFMC Retrieve";

	var p_bse_tp_cd  = "<%=p_bse_tp_cd%>";
	var p_bse_yr     = "<%=p_bse_yr%>";
	var p_bse_qtr_cd = "<%=p_bse_qtr_cd%>";
	var p_sub_trd_cd = "<%=p_sub_trd_cd%>";
	var p_rlane_cd   = "<%=p_rlane_cd%>";
	var p_dir_cd     = "<%=p_dir_cd%>";

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
<input type="hidden" name="f_fm_wk" id="f_fm_wk" />
<input type="hidden" name="f_to_wk" id="f_to_wk" />
<input type="hidden" name="f_act_flag" value="N" id="f_act_flag" />
<input type="hidden" name="f_trd_cd" id="f_trd_cd" value="IAS"/> 

<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Basic CMCB for IAS Sector_COA UC PFMC Retrieve</span></h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--
			--><button class="btn_normal" name="btn_Downexcel" id="btn_Downexcel" type="button">Down Excel</button><!--
			--><button class="btn_normal" name="btn_Close" id="btn_Close" type="button">Close</button>
		</div>
		<!-- opus_design_btn (E) -->
	</div>
	<!-- page_title_area(E) -->
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
		     		<col width="30">
		     		<col width="100">
		     		<col width="90">
		     		<col width="40">
		     		<col width="80">
		     		<col width="60">
		     		<col width="100">
		     		<col width="60">
		     		<col width="100">
		     		<col width="60">
		     		<col width="100">
		     		<col width="60">
		     		<col width="*">
				</colgroup>
				<tr>
					<th class="sm pad_left_8" style="text-align:left;"><input type="radio" name="f_bse_tp_cd" id="f_bse_tp_cdY" class="trans" value="Y" disabled><label for="f_bse_tp_cdY">Yearly</label></th>
					<th>Year</th>
					<td><script type="text/javascript">ComComboObject('f_bse_yr', 1, 55, 1, 1)</script></td>
					<th><div id="div_qtr">Quarter</div></th>
					<td><script type="text/javascript">ComComboObject('f_bse_qtr_cd', 1, 50, 1, 1)</script></td>
					<td colspan="2"><div id="div_period"></div></td>
					<th>Sub Trade</th>
					<td><script type="text/javascript">ComComboObject('f_sub_trd_cd', 1, 65, 1, 1)</script></td>
					<th>Lane Bound</th>
					<td><script type="text/javascript">ComComboObject('f_dir_cd', 1, 60, 1, 1)</script></td>
					<th></th>
					<td></td>
				</tr>
				<tr>
					<th class="sm pad_left_8" style="text-align:left;"><input type="radio" name="f_bse_tp_cd" id="f_bse_tp_cdQ" class="trans" value="Q" disabled><label for="f_bse_tp_cdQ">Quarterly</label></th>
					<th>End Week</th>
					<td><input type="text" style="text-align:center;width:55px;" class="input1" maxlength="2" name="f_week" id="f_week" onchange="period_OnChange();"></td>
					<th>Duration</th>
					<td><input type="text" style="text-align:center;width:50px;" class="input1" maxlength="1" name="f_duration" id="f_duration"  onchange="period_OnChange();"></td>
					<td colspan="2"><div id="div_period2"></div></td>
					<th>R/Lane</th>
					<td><script type="text/javascript">ComComboObject('f_rlane_cd', 1, 65, 1, 1)</script></td>
					<th>POL</th>
					<td><script type="text/javascript">ComComboObject('f_pol_cd', 1, 60, 1)</script></td>
					<th>POD</th>
					<td><script type="text/javascript">ComComboObject('f_pod_cd', 1, 60, 1)</script></td>
				</tr>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
	
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" id="mainTable">
			<div class="opus_design_inquiry">
				<table>
					<colgroup>
						<col width="*">
					</colgroup>
					<tbody>
						<tr>
							<td style="text-align:right;">[Unit : $/TEU]</td>
						</tr>
					</tbody>
				</table>
			</div>
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<div style="display: none;"><script type="text/javascript">ComSheetObject('sheet2');</script></div>
		<!-- opus_design_grid(E) -->
	</div>
</div>
</form>
