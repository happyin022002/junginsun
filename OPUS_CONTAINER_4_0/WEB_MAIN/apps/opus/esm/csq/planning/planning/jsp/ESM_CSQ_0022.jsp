<%
/*=========================================================
*Copyright(c) 2015 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_CSQ_0022.jsp
*@FileTitle  : QTA Set up by Head Office RHQ Distribute Result
*@author     : CLT
*@version    : 1.0
*@since      : 2015/01/20
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.csq.planning.planning.event.EsmCsq0022Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	String p_bse_tp_cd  = JSPUtil.getParameter(request, "f_bse_tp_cd", "");
	String p_bse_yr     = JSPUtil.getParameter(request, "f_bse_yr", "");
	String p_bse_qtr_cd = JSPUtil.getParameter(request, "f_bse_qtr_cd", "");
	String div_period   = JSPUtil.getParameter(request, "div_period", "");
	String p_ofc_vw_cd  = JSPUtil.getParameter(request, "f_ofc_vw_cd", "");
	String p_trd_cd     = JSPUtil.getParameter(request, "f_trd_cd", "");
	String p_rlane_cd   = JSPUtil.getParameter(request, "f_rlane_cd", "");
	String p_dir_cd     = JSPUtil.getParameter(request, "f_dir_cd", "");
	String p_ob_div_cd  = JSPUtil.getParameter(request, "f_ob_div_cd", "");
	String p_rhq_cd     = JSPUtil.getParameter(request, "f_rhq_cd", "");

	EsmCsq0022Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;		//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.datamanage.basicdata");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmCsq0022Event)request.getAttribute("Event");
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
	var curTitle = "QTA Set up by Head Office_RHQ Distribute Result";
	var curDescription = "QTA Set up by Head Office_RHQ Distribute Result";
	var p_bse_tp_cd = "<%=p_bse_tp_cd%>";

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
<input type="hidden" name="f_ofc_vw_cd" value="<%=p_ofc_vw_cd%>" id="f_ofc_vw_cd" />
<!-- 개발자 작업	-->

<div class="layer_popup_title">

	<!-- page_title_area(S) -->
	<div class="page_title_area clear">

		<!-- page_title(S) -->
		<h2 class="page_title"><span>QTA Set up by Head Office_RHQ Distribute Result</span></h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button><!-- 
			--><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>		
		</div>
		<!-- opus_design_btn(E) -->
	</div>
	<!-- page_title_area(E) -->

</div>

<div class="layer_popup_contents">

	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="95">
					<col width="50">
					<col width="70">
					<col width="50">
					<col width="70">
					<col width="80">
					<col width="70">
					<col width="50">
					<col width="70">
					<col width="50">
					<col width="*" />				
				</colgroup> 
				<tr>
					<td class='sm pad_left_8'><input type="radio" name="f_bse_tp_cd" id="f_bse_tp_cd_y" class="trans" value="Y" disabled><label for="f_bse_tp_cd_y"><strong>Yearly</strong></label></td>
					<th>Year</th>
					<td><input type="text" style="text-align:center; width:45px;" class="input2" name="f_bse_yr" value="<%=p_bse_yr%>" readonly id="f_bse_yr" /></td>
					<th><div id="div_qtr">Quarter</div></th>
					<td><input type="text" style="text-align:center; width:55px;" class="input2" name="f_bse_qtr_cd" value="<%=p_bse_qtr_cd%>" readonly id="f_bse_qtr_cd" /></td>
					<td colspan="2"><div id="div_period"></div></td>
					<th>Office View</th>
					<td><input type="text" style="text-align:center; width:65px;" class="input2" name="ofc_vw_cd" readonly id="ofc_vw_cd" /></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td class='sm pad_left_8'><input type="radio" name="f_bse_tp_cd" id="f_bse_tp_cd_q" class="trans" value="Q" disabled><label for="f_bse_tp_cd_q"><strong>Quarterly</strong></label></td>
					<th>Trade</th>
					<td><input type="text" style="text-align:center; width:45px;" name="f_trd_cd" class="input2" readonly value="<%=p_trd_cd%>" id="f_trd_cd" /></td>
					<th>R/Lane</th>
					<td><input type="text" style="text-align:center; width:55px;" name="f_rlane_cd" class="input2" readonly value="<%=p_rlane_cd%>" id="f_rlane_cd" /></td>
					<th>Trade Bound</th>
					<td><input type="text" style="text-align:center; width:55px;" name="f_dir_cd" class="input2" readonly value="<%=p_dir_cd%>" id="f_dir_cd"></td>
					<th>N.OB/OB</th>
					<td><input type="text" style="text-align:center; width:65px;" name="f_ob_div_cd" class="input2" readonly value="<%=p_ob_div_cd%>" id="f_ob_div_cd" /></td>
					<th>RHQ</th>
					<td><input type="text" style="text-align:center; width:65px;" name="f_rhq_cd" class="input2" readonly value="<%=p_rhq_cd%>" id="f_rhq_cd" /></td>
				</tr>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>

	<div class="wrap_result">
		<div class="opus_design_grid">
			<div class="opus_design_inquiry">
				<table>
					<tr>
						<td style="text-align:right;">[Unit : TEU, $]</td>
					</tr>
				</table>
			</div>
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
</div>
</form>