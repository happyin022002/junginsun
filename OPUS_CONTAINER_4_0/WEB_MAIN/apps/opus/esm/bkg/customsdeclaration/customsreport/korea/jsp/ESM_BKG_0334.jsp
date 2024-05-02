<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0334.jsp
*@FileTitle  : Discharge Bonded Area by Country Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/28
=========================================================
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.framework.core.controller.util.WebKeys"%>
<%@ page import="com.clt.framework.core.view.template.Screen"%>

<%
	String country  = JSPUtil.getParameter(request, "country");
	String viewType = JSPUtil.getParameter(request, "view_type");
	String otrDchgCd= JSPUtil.getParameter(request, "otr_dchg_cd");
	String main_page = JSPUtil.getParameter(request, "main_page".trim(), "");

	if (viewType==null) viewType = "inquiry";
	if (otrDchgCd==null) otrDchgCd = "";
	SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	if (country==null) country = account.getCnt_cd(); //자신의 국가를 넣어야 함

	Screen screen = (Screen) request.getAttribute(WebKeys.CURRENT_SCREEN);
	String screenName = screen.getName();
	String mainPage =JSPUtil.getParameter(request, "main_page");
%>

<script type="text/javascript">
	function setupPage(){
		$('<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button>').appendTo("#btnArea");
		<%
		if (screenName.indexOf("Q") < 0){
		%>
			$('<button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button>').appendTo("#btnArea");
		<%
		}
		%>
		$('<button type="button" class="btn_normal"  name="btn_Select" id="btn_Select">Select</button>').appendTo("#btnArea");
		$('<button type="button" class="btn_normal"  name="btn_downexcel" id="btn_downexcel">Down Excel</button>').appendTo("#btnArea");

		<%
		if (!"true".equals(JSPUtil.getParameter(request, "main_page"))){
		%>
			$('#btn_downexcel').after($('#btn_Close'));
		<%
			}
		%>
		//document.getElementById("title").innerHTML = "Discharge Bonded Area by Country Creation";
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="loc_cd">
<input type="hidden" name="view_type" id="view_type" value="<%=viewType%>">


<div class="page_title_area clear">


<%
	if (!"true".equals(mainPage))
	{
%>
<!-- OUTER - POPUP (S)tart -->
<!-- page_title_area(S) -->
		<!-- page_title(S) -->
	   <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><span>Discharge Bonded Area by Country Inquiry</span></h2>
		<!-- page_title(E) -->

		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
			--><span name="inq"><button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button></span><!--
			--><span name="inq"><button type="button" class="btn_normal" name="btn_Select" id="btn_Select">Select</button></span><!--
			--><button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button><!--
			--><button type="button" class="btn_normal" name="btn_Close" id="btn_Close" onClick="self.close()" >Close</button>
		</div>
		<!-- opus_design_btn(E) -->
			</div>
	<!-- page_title_area(E) -->

<%
	}else{
%>
<!-- OUTER - POPUP (S)tart -->
<!-- page_title_area(S) -->
		<!-- page_title(S) -->
	   <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->

		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
			--><span name="inq"><button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button></span><!--
			--><span name="inq"><button type="button" class="btn_normal" name="btn_Select" id="btn_Select">Select</button></span><!--
			--><button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button>
		</div>
		<!-- opus_design_btn(E) -->

	<!-- page_title_area(E) -->

<% }%>
		<!-- opus_design_btn(E) -->

		<div class="location">
			<!-- location 내용 동적생성 (별도 코딩 불필요) -->
			<span id="navigation"></span>
		</div>
</div>
<!-- popup_contens_area(S) -->
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="100" />
				<col width="100" />
				<col width="75" />
				<col width="120" />
				<col width="60" />
				<col width="" />
			</colgroup>
			<tbody>
				<tr>
					<th>Country</th>
					<td><input type="text" name="country" style="width:80px;" class="input1" value="<%=country%>" maxlength="2" style="ime-mode:disabled" dataformat="engup"></td>
					<th>Bonded Area Code</th>
					<td><input type="text" name="otr_dchg_cd" style="width:100px;" class="input" style="ime-mode:disabled" dataformat="engup" value="<%=otrDchgCd%>"></td>
					<th>Bonded Area Name</th>
					<td><input type="text" style="width:100px;" class="input" name="loc_nm" style="ime-mode:disabled" dataformat="engup" otherchar=" "></td>
				</tr>
				<tr>
					<th>Yard Code</th>
					<td><input type="text" style="width:80px;" class="input" name="yd_cd" style="ime-mode:disabled" dataformat="engup"></td>
					<th>Bonded Area Loc Code</th>
					<td><input type="text" style="width:100px;" class="input" name="loc_full_cd" style="ime-mode:disabled" dataformat="engup" maxlength="5"></td>
					<th>Port</th>
					<td><input type="text" style="width:100px;" class="input" name="port_cd" maxlength="5" style="ime-mode:disabled" dataformat="engup"></td>
				</tr>
			</tbody>
		</table>
		<!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">

		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<!-- 그리드 버튼 영역(데이터 그리드 상단에 위치) -->
			<!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
			<button type="button" class="btn_normal" name="btn_Add" id="btn_Add">Row&nbsp;Add</button>
			<button type="button" class="btn_normal" name="btn_Del" id="btn_Del">Row&nbsp;Delete</button>
		</div>
		<!-- opus_design_btn(E) -->

		<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
		<script type="text/javascript">ComSheetObject('sheet1');</script>
		<!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>

