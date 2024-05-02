<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_CSQ_0035.jsp
*@FileTitle  : QTA Set up by RHQ_Contract TTL retrieve only_Office QTA Summary 
*@author     : CLT
*@version    : 1.0
*@since      : 2015/02/09
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.csq.planning.planning.event.EsmCsq0026Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmCsq0026Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String trdCd = "";
	String dirCd = "";
	String ofcCd = "";
	String bseYr = "";
	String bseQtrCd = "";
	String bound = "";
	String officeView = "";
	String bseTpCd = "";
	String divPeriod = "";
	String obDivCd = "";
	String f_click = "";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.planning.planning");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EsmCsq0026Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		trdCd = JSPUtil.getNull(request.getParameter("f_trd_cd"));
		dirCd = JSPUtil.getNull(request.getParameter("f_dir_cd"));		
		ofcCd = JSPUtil.getNull(request.getParameter("f_rgn_ofc_cd"));
		bseYr = JSPUtil.getNull(request.getParameter("f_bse_yr"));
		bseQtrCd = JSPUtil.getNull(request.getParameter("f_bse_qtr_cd"));
		divPeriod = JSPUtil.getNull(request.getParameter("div_period"));
		bseTpCd = JSPUtil.getNull(request.getParameter("f_bse_tp_cd"));
		obDivCd = JSPUtil.getNull(request.getParameter("f_ob_div_cd"));
	} catch(Exception e) {
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

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="f_qta_step_cd" value="" id="f_qta_step_cd" />
<input type="hidden" name="f_ob_div_cd" value="<%=obDivCd%>" id="f_ob_div_cd" />
<input type="hidden" name="f_ofc_vw_cd" value="C" id="f_ofc_vw_cd" />
<!-- 개발자 작업	-->

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><span>QTA Set up by RHQ_Contract TTL retrieve only_Office QTA Summary</span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_DownExcel" id="btn_DownExcel" type="button">Down Excel</button><!--
		--><button class="btn_normal" name="btn_close" id="btn_close" type="button">Close</button>
	</div>
	<!-- opus_design_btn (E) -->
</div>
<!-- page_title_area(E) -->
<div class="layer_popup_contents">
	<div class="wrap_search">
		<div class="opus_design_inquiry wFit">
			<table class="search">
				<colgroup>
					<col width="95">
					<col width="50">
					<col width="70">
					<col width="50">
					<col width="70">
					<col width="50">
					<col width="90">
					<col width="50">
					<col width="70">
					<col width="50">
					<col width="100">
					<col width="*">				
				</colgroup>
				<tr>
					<td class="sm pad_left_8"><input type="radio" name="f_bse_tp_cd" class="trans" value="Y" <%=bseTpCd.equals("Y")? "checked":"" %>><label><strong>Yearly</strong></label></td>
					<th>Year</th>
					<td><input type="text" style="text-align:center; width: 50px; ime-mode:disabled" name="f_bse_yr" class="input2" maxlength="20" readOnly value="<%=bseYr%>"></td>
					<th><div id="div_qtr">Quarter</div></th>
					<td><input type="text" style="text-align:center; width: 50px; ime-mode:disabled" name="f_bse_qtr_cd" class="input2" maxlength="20" readOnly value="<%=bseQtrCd%>"></td>
					<td colspan="2"><div id="div_period"><%=divPeriod%></div></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td class="sm pad_left_8"><input type="radio" name="f_bse_tp_cd" class="trans" value="Q" <%=bseTpCd.equals("Q")? "checked":"" %>><label><strong>Quarterly</strong></label></td>
					<th>Trade</th>
					<td><input type="text" style="text-align:center; width: 50px; ime-mode:disabled" name="f_trd_cd" class="input2" maxlength="20" readOnly value="<%=trdCd%>"></td>
					<th>Trade Bound</th>
					<td><input type="text" style="text-align:center; width:50px; ime-mode:disabled" name="f_dir_cd" class="input2" maxlength="20" readOnly value="<%=dirCd%>"></td>
					<th>N.OB/OB</th>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" style="text-align:center; width:65px; ime-mode:disabled" name="f_ob" class="input2" maxlength="20" readonly id="f_ob" /></td>
					<th>Office</th>
					<td><input type="text" style="text-align:center; width: 65px; ime-mode:disabled" name="f_rgn_ofc_cd" class="input2" maxlength="20" readOnly value="<%=ofcCd%>"></td>
					<td></td>
				</tr>
			</table>
		</div>
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

<!-- 개발자 작업  끝 -->
</form>