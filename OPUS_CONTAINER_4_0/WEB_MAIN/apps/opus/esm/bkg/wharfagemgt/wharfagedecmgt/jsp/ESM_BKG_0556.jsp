<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ui_bkg_0556.jsp
*@FileTitle : ACI_Vessel Information
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/10
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.event.EsmBkg0556Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0556Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

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

		event = (EsmBkg0556Event)request.getAttribute("Event");
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
<script type="text/javascript" src="/opuscntr/rpt/script/common_rd.js"></script>
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="frm_attr_ctnt2">


<%
	String vvd     = (request.getParameter("vvd") == null)? "":request.getParameter("vvd");
	String portCd     = (request.getParameter("port_cd") == null)? "":request.getParameter("port_cd");
%>


<!-- page_title_area(S) -->
<div class="page_title_area clear ">
	<!-- page_title(S) -->
	<h2 class="page_title">
		<button type="button">
			<span>&nbsp;Wharfage Commission Invoice (화물입항료 대납경비 청구서)</span>
		</button>
	</h2>
	<!-- page_title(E) -->

		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
			<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
			--><button type="button" class="btn_normal" name="btn_downexcel"   id="btn_downexcel">Down Excel</button><!--
			--><button type="button" class="btn_normal" name="btn_print"   id="btn_print">Print</button>
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



	<!-- opus_design_inquiry(S) -->
<div class="wrap_search_tab">
	<div class="opus_design_inquiry">
		<!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
		<table>
			 <colgroup>
				<col width="60px" />
				<col width="160px" />
				<col width="60px" />
				<col width="120px" />
				<col width="60px" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr class="h23">
					<th class="align_left"> 허가 일자</th>
					<td><!--
						--><input type="text" style="width: 75px; ime-mode: disabled" class="input1" value="" dataformat="ymd"
							maxlength="10" name="whf_ntc_dt1" dataformat="eng" caption="ETA" cofield="whf_ntc_dt2" ><!--
						-->&nbsp;~&nbsp;<!--
						--><input type="text" style="width: 75px; ime-mode: disabled" class="input1" value="" dataformat="ymd"
							maxlength="10" name="whf_ntc_dt2" dataformat="eng" caption="ETA" cofield="whf_ntc_dt1"><!--
						--><button type="button" name="btn_calendar" class="calendar"></button><!--
					--></td>
					<th class="align_center"> 수출/입</th>
					<td><!--
						--><input type="radio" value="A" class="trans" checked="checked" name="whf_bnd_cd"> 전체&nbsp;<!--
						--><input type="radio" value="I" class="trans" name="whf_bnd_cd"> 수입&nbsp;<!--
						--><input type="radio" value="O" class="trans" name="whf_bnd_cd"> 수출<!--
					--></td>
					<th class="align_center"> 항만</th>
					<td><!--
						--><input type="radio" value="A" class="trans" checked="checked" name="port_nm"> 전체&nbsp;<!--
						--><input type="radio" value="감천항" class="trans" name="port_nm"> 감천항&nbsp;<!--
						--><input type="radio" value="북항" class="trans" name="port_nm"> 북항&nbsp;<!--
						--><input type="radio" value="인천항" class="trans" name="port_nm"> 인천항&nbsp;<!--
						--><input type="radio" value="광양항" class="trans" name="port_nm"> 광양항&nbsp;<!--
						--><input type="radio" value="신항" class="trans" name="port_nm"> 신항<!--
					--></td>
				</tr>

			</tbody>
		</table>
		<!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->

		<!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
		<table>
			 <colgroup>
				<col width="60px" />
				<col width="160px" />
				<col width="130px" />
				<col width="120px" />
				<col width="60px" />
				<col width="130px" />
				<col width="60px" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr class="h23">
					<th class="align_left"> 청구월</th>
					<td><input type="text" style="width:100%" name="demand_month" maxlength="20" dataformat="ennum" class="input" ></td>
					<th class="align_center"> 투자비보전(정산월)</th>
					<td><input type="text" style="width:100%" name="calculate_month" maxlength="6" dataformat="ennum" class="input" ></td>
					<th class="align_center"> 대표자</th>
					<td><input type="text" style="width:130px" name="represent" maxlength="14" dataformat="ennum" class="input" ></td>
					<th class="align_center"> 전화번호</th>
					<td><input type="text" style="width:150px" name="phone_num" maxlength="20" dataformat="ennum" class="input" ></td>
				</tr>

			</tbody>
		</table>
		<!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->

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

		<div class="opus_design_grid"  id="receivedTabSCTariffLayer" style="display:block">
			<!-- <h3>S/C Exception Tariff</h3> -->

			<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
			<div class="opus_design_RD">
				<script type="text/javascript">rdViewerObject();</script><!--W/O Issue-->
			</div>
			<!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
		</div>
	</div>
	<!--TAB File1 (E) -->


	<!--TAB File2 (S) -->
	<div id="tabLayer" style="display:none">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid"  id="sentTabSCTariffLayer" style="display:block">

			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn">
				<!-- 그리드 버튼 영역(데이터 그리드 상단에 위치) -->
				<!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
				<button type="button" class="btn_normal" name="btn_add" id="btn_add">Row&nbsp;Add</button>
				<button type="button" class="btn_normal" name="btn_del" id="btn_del">Row Delete</button>
			</div>
			<!-- opus_design_btn(E) -->

			<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
			<script type="text/javascript">ComSheetObject('sheet1');</script><!--W/O Issue-->
			<!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->

		</div>
		<!-- opus_design_grid(E) -->
	</div>
	<!--TAB File2 (E) -->

</div>
</form>


