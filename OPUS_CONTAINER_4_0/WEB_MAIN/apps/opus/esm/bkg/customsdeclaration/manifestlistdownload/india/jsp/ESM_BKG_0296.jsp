<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0296.jsp
*@FileTitle : ESM_BKG_0296
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.india.event.EsmBkg0296Event"%>

<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0296Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			// error from server
	String strErrMsg = "";						// error message
	int rowCount	 = 0;						// count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strCnt_cd		= "";
	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");


	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strCnt_cd = account.getCnt_cd();


		event = (EsmBkg0296Event)request.getAttribute("Event");
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
			showErrMessage(errMessage);
		} // end if

		loadPage();
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="f_cmd_detail">

<input type="hidden" name="cnt_cd" value="<%=strCnt_cd %>">


	<!-- page_title_area(S) -->
	<div class="page_title_area clear ">
		<!-- page_title(S) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->

			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn">
				<!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
				<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
				--><button type="button" class="btn_normal" name="btn_save"   id="btn_save">Save</button><!--
				--><button type="button" class="btn_normal" name="btn_downexcel"   id="btn_downexcel">Down Excel</button><!--
				--><button type="button" class="btn_normal" name="btn_formset" id="btn_formset">Form Set</button><!--
				--><button type="button" class="btn_normal" name="btn_formprint" id="btn_formprint">Form III Print</button><!--
				--><button type="button" class="btn_normal" name="btn_igmedi" id="btn_igmedi">IGM EDI</button><!--
				--><button type="button" class="btn_normal" name="btn_request" id="btn_request">TP Request (EDI)</button><!--
				--><button type="button" class="btn_normal" name="btn_cntrlist" id="btn_cntrlist">CNTR List</button>
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

<div class="wrap_search_tab">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<!-- 조회영역1 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
		<table style="width:979px;">
			<tbody>
				<colgroup>
					<col width="80">
					<col width="180">
					<col width="65">
					<col width="135">
					<col width="55">
					<col width="150">
					<col width="75">
					<col width="150">
					<col width="50">
					<col width="*">
				</colgroup>
				<tr>
					<th title="Vessel Voyage Direction">VVD</th>
					<td>
						<input type="text" style="width:110px;ime-mode: disabled;" class="input1" name="vvd_cd" value=""  required dataformat="engup" maxlength="9" fullfill caption="VVD">
					</td>
					<th title="Port of Loading">POL</th>
					<td>
						<input type="text" style="width:80px;ime-mode: disabled;" class="input" name="pol_cd" value="" dataformat="engup" caption="POL" fullfill maxlength="5">
					</td>
					<th title="Port of Discharging">POD</th>
					<td>
						<input type="text" style="width:80px;ime-mode: disabled;" class="input1" name="pod_cd" value="" required dataformat="engup" caption="POD" fullfill maxlength="5">
					</td>
					<th>Entry Type</th>
					<td>
						<script type="text/javascript">ComComboObject('entry_type',1,100);</script>
					</td>
					<th>Empty<th>
					<td><input type="checkbox" class="trans" name="empty_check" id="empty_check"></td>
				</tr>
			</tbody>
		</table>
		<!-- 조회영역1 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->

		<!-- 조회영역2 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
		<table style="width:979px;">
			<tbody>
				<colgroup>
					<col width="80">
					<col width="175">
					<col width="70">
					<col width="135">
					<col width="55">
					<col width="18o">
					<col width="*">
				</colgroup>
				<tr>
					<th>IGM No.</th>
					<td><input type="text" style="width:110px;ime-mode: disabled;" class="input2"  readOnly="true" name="igm_no" id="igm_no" ></td>
					<th>IGM Date</th>
					<td><input type="text" style="width:80px;ime-mode: disabled;" class="input2" readOnly="true" name="igm_date" id="igm_date" ></td>
					<th>Line No.</th>
					<td>
						<input type="text" style="width:80px;ime-mode: disabled;" class="input" name="from_line_no" id="from_line_no" dataformat="num" maxlength="4" caption="Line No.">~&nbsp;
						<!--
						--><input type="text" style="width:80px;ime-mode: disabled;" class="input" name="to_line_no" id="to_line_no" dataformat="num" maxlength="4" caption="Line No.">
					</td>
					<td>
						<button type="button" class="btn_etc" name="btns_assign"   id="btns_assign">Assign</button>
					</td>
				</tr>
			</tbody>
		</table>
		<!-- 조회영역2 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->

		<!-- 조회영역3 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
		<table style="width:979px;">
			<tbody>
				<colgroup>
					<col width="80">
					<col width="380">
					<col width="55">
					<col width="150">
					<col width="75">
					<col width="*">
				</colgroup>
				<tr>
					<th>Vessel Name</th>
					<td><input type="text" style="width:325px;ime-mode: disabled;" class="input2"  readOnly="true" name="vsl_nm" ></td>
					<th>ETA</th>
					<td><input type="text" style="width:80px;ime-mode: disabled;" class="input2" readOnly="true" name="eta_dt" ></td>
					<th>Total B/L</th>
					<td><input type="text" style="width:60px;ime-mode: disabled;" class="input2" readOnly="true" name="tot_bl_num" ></td>
				</tr>
			</tbody>
		</table>
		<!-- 조회영역3 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_tab_btn(S) -->
	<div class="opus_design_tab">
		<script type="text/javascript">ComTabObject('tab1')</script>
	</div>
	<!-- opus_tab_btn(E) -->


	<!--TAB File1 (S) -->
	<div id="tabLayer" style="display:inline">

		<div class="opus_design_grid"  id="receivedTabSCTariffLayer"  >
			<!-- <h3>S/C Exception Tariff</h3> -->

			<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
			<script type="text/javascript">ComSheetObject('t1sheet1');</script><!--W/O Issue-->
			<!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
		</div>
	</div>
	<!--TAB File1 (E) -->


	<!--TAB File2 (S) -->
	<div id="tabLayer" style="display:none">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid"  id="sentTabSCTariffLayer"  >

				<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
				<script type="text/javascript">ComSheetObject('t2sheet1');</script><!--W/O Issue-->
				<!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
		</div>
		<!-- opus_design_grid(E) -->
		<div class="opua_design_inquiry">
			<table style="width:100%;">
				<tr>
					<td align="right">CNTR&nbsp;&nbsp;</td>
					<td width="85" class="stm"><input type="text" style="width:50px; text-align:center;" class="input" name="f_cnt" id="f_cnt">&nbsp;&nbsp;F</td>
					<td width="80" class="stm"><input type="text" style="width:50px; text-align:center;" class="input" name="t_cnt" id="t_cnt">&nbsp;&nbsp;T</td>
				</tr>
			</table>
		</div>
	</div>
	<!--TAB File2 (E) -->
</div>
</form>
