<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0335.jsp
*@FileTitle  : Customs Entry Type Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/28
=========================================================
--%>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.core.controller.util.WebKeys"%>
<%@ page import="com.clt.framework.core.view.template.Screen"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>

<%
	SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	String country  = request.getParameter("country")==null ? account.getCnt_cd():request.getParameter("country");
	String viewType = request.getParameter("view_type")==null ? "inquiry":request.getParameter("view_type");
	String entryCode = request.getParameter("entry_code")==null ? "":request.getParameter("entry_code");
	Screen screen = (Screen) request.getAttribute(WebKeys.CURRENT_SCREEN);
	String screenName = screen.getName();
	String mainPage = JSPUtil.getNull(request.getParameter("main_page"));
%>

<script type="text/javascript">
	function setupPage(){
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="view_type" value="<%=viewType%>">

<%
if(mainPage.equals("true")){
%>
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
			--><button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button><!--
			--><button type="button" class="btn_normal" name="btn_Select" id="btn_Select">Select</button><!--
			--><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
		</div>
		<!-- opus_design_btn(E) -->
		<!-- page_location(S) -->
		<div class="location">
			<span id="navigation"></span>
		</div>
		<!-- page_location(E) -->
	</div>
	<!-- page_title_area(E) -->
<%
}else {
%>
<!-- popup_title_area(S) -->
 <div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Customs Entry Type Inquiry</span></h2>
		<!-- page_title(E) -->

		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
			--><button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button><!--
			--><button type="button" class="btn_normal" name="btn_Select" id="btn_Select">Select</button><!--
			--><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button><!--
			--><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->
	</div>
	<!-- page_title_area(E) -->
</div>
<!-- popup_title_area(E) -->
<%
}
%>

<%if(!"true".equals(mainPage)){ %>
<div class="layer_popup_contents" style="overflow:hidden;">
<%} %>
<!-- popup_contens_area(S) -->
	<div class="wrap_search" >
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
		<table>
			 <colgroup>
				<col width="60px" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<th>Country Code</th>
					<td>
						<input type="text" style="width:40px; text-align:center;" class="input1" value="<%=country%>" maxlength="2" style="ime-mode:disabled" dataformat="engup" name="cnt_cd">
					</td>
				</tr>
				<tr>
					<th>Entry Code</th>
					<td>
						<input type="text" style="width:40px; text-align:center;" class="input" name="cstms_entr_cd" maxlength="2"  style="ime-mode:disabled" dataformat="enguponly" value="<%=entryCode%>"><input type="text" style="width:330;" class="input" name="entr_nm" dataformat="enguponly">
					</td>
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
<%if(!"true".equals(mainPage)){ %>
</div>
<!-- popup_contens_area(E) -->
<%}%>
</form>
