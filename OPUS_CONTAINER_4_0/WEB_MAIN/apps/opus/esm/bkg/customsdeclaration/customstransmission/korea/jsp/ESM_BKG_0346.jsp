<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0346.jsp
*@FileTitle  : Trans Cancellation To Korea Customs
*@author     : CLT
*@version    : 1.0
*@since      : 2014/10/07
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.event.EsmBkg0346Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%
	EsmBkg0346Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.wharfagemgt.wharfagedecmgt");

	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0346Event)request.getAttribute("Event");
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

<script language="javascript">
	function setupPage() 	{
		loadPage();
	}
</script>


<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="vsl_nm" value="<%=JSPUtil.getParameter(request, "vsl_nm")%>">
<input type="hidden" name="io_bnd_cd" value="<%=JSPUtil.getParameter(request, "io_bnd_cd")%>">
<input type="hidden" name="snd_date" value="<%=JSPUtil.getParameter(request, "snd_date")%>">


<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Trans Cancellation To Korea Customs ( ESM_BKG_0346 )</span></h2>
		<div class="opus_design_btn">
						<button type="button" class="btn_normal" name="btn_transmit" id="btn_transmit">Send</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
				<col width="70">
				<col width="200">
				<col width="90">
				<col width="145">
				<col width="120">
				<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th>VVD</th>
						<td><input type="text" style="width:120px; text-align:center" class="input2" value="<%=JSPUtil.getParameter(request, "vvd")%>" name="vvd" id="vvd" dataformat="engup" readonly></td>
						<th>MRN No.</th>
						<td><input type="text" style="width:120px; text-align:center" class="input2" value="<%=JSPUtil.getParameter(request, "mrn_no")%>" name="mrn_no" id="mrn_no" dataformat="engup" readonly></td>
						<th>POL</th>
						<td><input type="text" style="width:60px; text-align:center" value="<%=JSPUtil.getParameter(request, "pol_cd")%>" class="input2" name="pol_cd" dataformat="engup" readonly></td>
					</tr>
					<tr>
						<th>ETD</th>
						<td><input type="text" style="width:120px; text-align:center" class="input2" value="<%=JSPUtil.getParameter(request, "etd_dt")%>" name="etd_dt" id="etd_dt" dataformat="engup" readonly></td>
						<th>RQST DATE</th>
						<td><input type="text" style="width:120px; text-align:center" class="input2" value="" name="rqst_dt" id="rqst_dt" dataformat="engup" readonly></td>
						<th>Local Customs</th>
						<td><input type="text" style="width:60px; text-align:center" value="<%=JSPUtil.getParameter(request, "locl_cstms_cd")%>" class="input2" name="locl_cstms_cd" id="locl_cstms_cd" dataformat="engup" readonly><!--
							--><input type="text" style="width:35px; text-align:center" class="input2" value="<%=JSPUtil.getParameter(request, "locl_cstms_prt_cd")%>" name="locl_cstms_prt_cd" id="locl_cstms_prt_cd" readonly></td>
					</tr>
				</tbody>
			</table>
		</div>
		<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
	<div class="opus_design_inquiry" >
			<div class="opus_design_grid">
			<h3 class="title_design">Vessel Information</h3>
			<table>
				<tr>
					<th>Master B/L Total</th>
					<td colspan="3"><input type="text" style="width:60px; text-align:center" class="input2" name="mst_bl_knt" id="mst_bl_knt" value="<%=JSPUtil.getParameter(request, "mst_bl_knt")%>" readonly></td>
				</tr>
				<tr>
					<th width="123px">Empty B/L Total</th>
					<td width="100px"><input type="text" style="width:60px; text-align:center" class="input2" name="mty_bl_knt" id="mty_bl_knt" value="<%=JSPUtil.getParameter(request, "mty_bl_knt")%>" readonly></td>
					<th width="100px">신청구분</th>
					<td><select name="trsm_cxl_tp_cd" class="input" style="width:80px;">
							<option value="3">해상수입</option>
							<option value="4">해상수출</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>Console B/L Total</th>
					<td width=10><input type="text" style="width:60px; text-align:center" class="input2" name="cnsl_bl_knt" id="cnsl_bl_knt" value="<%=JSPUtil.getParameter(request, "cnsl_bl_knt")%>" readonly></td>
					<th>취하구분</th>
					<td><select name="trsm_cxl_rsn_cd" class="input" style="width:100px;">
							<option value="1">기상악화</option>
							<option value="2">선박(항공기)사고</option>
							<option value="3">선박(항공기)스케줄 변경</option>
							<option value="4">적하목록 관리번호(MRN) 오전송</option>
							<option value="5">기타</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>Simple B/L Total</th>
					<td colspan="3"><input type="text" style="width:60px;text-align:center" class="input2" name="smp_bl_knt" id="smp_bl_knt" value="<%=JSPUtil.getParameter(request, "smp_bl_knt")%>" readonly></td>
				</tr>
				<tr>
					<th>취하사유</th>
					<td colspan="3"><input type="text" style="width:300px; text-align:center" class="input" maxlength="50" name="trsm_cxl_desc"></td>
				</tr>
			</table>
			</br>
			<div class="opus_design_grid clear" style="display: none">
				<div class="opus_design_grid" id="mainTable">
					<script type="text/javascript">ComSheetObject('sheet1');</script>
				</div>
			</div>
		</div>
	</div>
</div>
</div>
<!-- popup_contens_area(E) -->
</form>