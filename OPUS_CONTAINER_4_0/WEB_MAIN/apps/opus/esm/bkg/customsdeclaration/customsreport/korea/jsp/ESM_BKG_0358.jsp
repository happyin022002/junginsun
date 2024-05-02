<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0358.jsp
*@FileTitle  : MRN Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/08
=========================================================*/
%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%
	String locCd = JSPUtil.getParameter(request, "loc_cd");
	String mrnNo = JSPUtil.getParameter(request, "mrn_no");
	String vvd   = JSPUtil.getParameter(request, "vvd");
	String portCd= JSPUtil.getParameter(request, "port_cd");

	if (locCd==null) locCd = "";
	if (mrnNo==null) mrnNo = "";
	if (vvd==null)   vvd = "";
	if (portCd==null) portCd = "";
%>

<script type="text/javascript">

	function setupPage(){

		loadPage();
	}

</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="mrn_no" value="<%=mrnNo%>" id="mrn_no" />
<input type="hidden" name="vsl_cd" id="vsl_cd" />
<input type="hidden" name="skd_voy_no" id="skd_voy_no" />
<input type="hidden" name="skd_dir_cd" id="skd_dir_cd" />

<!-- page_title_area(S) -->
	<div class="page_title_area clear">

		<!-- page_title(S) -->
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->

		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
			<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
			 --><button type="button" class="btn_normal" name="btn_select" id="btn_select">Select</button><!--
			 --><button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button>
		</div>
		<!-- opus_design_btn(E) -->

		<!-- page_location(S) -->
		<div class="location">
			<!-- location 내용 동적생성 (별도 코딩 불필요) -->
			<span id="navigation"></span>
		</div>
		<!-- page_location(E) -->
	</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
		<table>
			 <colgroup>
				<col width="40">
				<col width="120">
				<col width="50">
				<col width="250">
				<col width="40">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input type="text" style="width:80px; text-align:center;" class="input" name="vvd" value="<%=vvd%>" maxlength="9" dataformat="engup" id="vvd"/> </td>
					<th>Bound</th>
					<td><select style="width:81px;" class="input" name="io_bnd_cd" id="io_bnd_cd" onChange="ioBndCd_onChange()">
						<option value="" selected>All</option>
						<option value="I">Inbound</option>
						<option value="O">Outbound</option>
						</select></td>
					<th>MRN</th>
					<td><input type="text" style="width:35px;text-align:center;ime-mode:disabled;" class="input1" name="mrn1" id="mrn1" maxlength="2" dataformat="num" ><span class="dash">~</span><!--
						 --><input type="text" style="width:45px;text-align:center;ime-mode:disabled;" class="input" name="mrn2" id="mrn2" maxlength="4" dataformat="engup"><span class="dash">~</span><!--
						 --><input type="text" style="width:45px;text-align:center;ime-mode:disabled;" class="input" name="mrn3" id="mrn3" maxlength="4" dataformat="engup"><span class="dash">~</span><!--
						 --><input type="text" style="width:35px;text-align:center;ime-mode:disabled;" class="input2" name="mrn4" id="mrn4" maxlength="1" dataformat="engup">
					</td>
				</tr>
				<tr>
					<th>Port</th>
					<td><input type="text" style="width:50px;text-align:center;" dataformat="engup" class="input" name="port_cd" value="<%=portCd%>" maxlength="5" id="port_cd"/> </td>
					<th><span id="timeStr">ETA</span></th>
					<td colspan="3"><input type="text" style="width:80px;text-align:center;" class="input" name="from_dt" maxlength="10" dataformat="ymd" id="from_dt" /><!--
					 --><button type="button" id="btn_calendar1" name="btn_calendar1" class="calendar ir"></button><span class="dash">~</span><!--
					 --><input type="text" style="width:80px;text-align:center;" class="input" name="to_dt" maxlength="10" dataformat="ymd" id="to_dt" /><!--
					 --><button type="button" id="btn_calendar2" name="btn_calendar2" class="calendar ir"></button></td>
				</tr>
			</tbody>
		</table>
		<!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
<!-- opus_design_inquiry(E) -->
</div>
<div class="wrap_result">
<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="mainTable">
		<!-- 그리드 데이터 영역 (S) (기존 As-is 구조에서 변경되는 사항 없음) -->
		<script type="text/javascript">ComSheetObject('sheet1');</script>
		<!-- 그리드 데이터 영역 (E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
<!-- opus_design_grid(E) -->
</div>

</form>
