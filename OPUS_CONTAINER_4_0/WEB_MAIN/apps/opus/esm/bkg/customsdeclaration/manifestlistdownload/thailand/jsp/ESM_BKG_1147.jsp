<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1147.jsp
*@FileTitle  : Thailand Customs Manifest
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/12
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.thailand.event.EsmBkg1147Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg1147Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지

	String strUsr_id = "";
	String strUsr_nm = "";
	String search_flg1 = "";
	String search_flg3 = "";

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		String ofcCd = account.getOfc_cd();

		// Log-in ID 소속 Office 가 "MX" 인 경우 Default
		// 하동일 수석 가이드에 따라 조직코드의 앞 3자리가 MEX인 유저에 대해 로직을 적용함.
		//if(ofcCd != null){
		//	if(ofcCd.substring(0, 3).equals("MEX")){
		//		search_flg1 = "checked";
		//	}
		//}
		//Log-in ID 소속 Office 가 "MX" 가 아닌 경우 Default
		//if( search_flg1.equals("")){
		//	search_flg3 = "checked";
		//}

		event = (EsmBkg1147Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

	} catch (Exception e) {
		out.println(e.toString());
	}
%>

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			//showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="pageno" value="ESM_BKG_1147">
<input type="hidden" name="pol_cd">
<input type="hidden" name="pod_cd">
<input type="hidden" name="trnk_vvd">

<!-- 개발자 작업	-->

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_down_excel" id="btn_down_excel">Down Excel</button>
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

<div class= "wrap_search">
<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<table>
			<colgroup>
				<col width="50">
				<col width="100">
				<col width="50">
				<col width="100">
				<col width="50">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>VVD</th>
					<td><input type="text" style="width:80px; ime-mode:disabled;" class="input1" maxlength="9" name="s_vvd" id="s_vvd" caption="VVD" dataformat="engup" required></td>
					<th>DEL</th>
					<td><input type="text" name="s_del_cd" id="s_del_cd" caption="DEL" maxlength="5" style="width:50px;ime-mode:disabled;" class="input1" dataformat="engup" required> <input type="text" name="s_del_nod_cd" id="s_del_nod_cd" caption="DEL" maxlength="2" style="width:30px;ime-mode:disabled;" class="input1" dataformat="engup" ></td>
					<th>POL</th>
					<td><input type="text" name="s_pol_cd" id="s_pol_cd" caption="POL" maxlength="5" style="width:50px;ime-mode:disabled;" class="input" dataformat="engup"></td>
				</tr>
			</table>
		<!--biz page (E)-->
	</div>
</div>
<div class="wrap_result">
<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" >
		<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
		<script language="javascript">ComSheetObject('sheet1');</script>
		<!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
<!-- opus_design_grid(E) -->
	<!-- opus_tab_btn(S) -->
	<div class="opus_design_tab">
			<script language="javascript">ComTabObject('tab1')</script>
	</div>
	<!-- opus_tab_btn(E) -->

	<!--TAB B/L Info(S) -->
	<div class="opus_design_grid" name="tabLayer" id="tabLayer">
		<!-- opus_grid_right(S)-->
		<div class="grid_option_right mar_btm_8">
			<td>Total B/L Count&nbsp;&nbsp;<input type="text" name="tot_bl_cnt" maxlength="5" style="width:50;text-align:right" class="input2" dataformat="uppernum" readonly></td>
		</div>
		<!-- opus_grid_right(E)-->
		<script language="javascript">ComSheetObject('sheet2');</script>
	</div>

	<!--TAB CNTR Info(S) -->
	<div class="opus_design_grid" name="tabLayer" id="tabLayer">
		<!-- opus_grid_right(S)-->
		<div class="grid_option_right mar_btm_8">
			<td>Total Container Count&nbsp;&nbsp;<input type="text" name="tot_cntr_cnt" maxlength="5" style="width:50;text-align:right" class="input2" dataformat="uppernum" readonly></td>
		</div>
		<!-- opus_grid_right(E)-->
		<script language="javascript">ComSheetObject('sheet3');</script>
	</div>
</div>

<!-- Copyright(E)-->
</form>
