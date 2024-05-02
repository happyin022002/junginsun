<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0345.jsp
*@FileTitle  : ESM_BKG-0345
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
<%
	String cntCd = JSPUtil.getParameter(request, "cnt_cd");
	String locCd = JSPUtil.getParameter(request, "loc_cd");
	String cstmsCd = JSPUtil.getParameter(request, "cstms_cd");
	SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	if (cntCd==null) cntCd = account.getCnt_cd();
	if (locCd==null) locCd = "";
	String pgmNo =JSPUtil.getParameter(request, "pgmNo");
%>

<script language="javascript">
	var selHidden = "<%="".equals(pgmNo) ? 0 : 1%>";
	function setupPage(){
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">

<% if ("".equals(pgmNo)) {%>
<!-- 팝업제목(S) -->
<div class="page_title_area clear ">
	<!-- page_title(S) -->
	<h2 class="page_title"><span>Bonded Area by Country Inquiry</span></h2>
	<!-- page_title(E) -->

	<!-- btn_div(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" id="btn_retrieve" name="btn_retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_select">Select</button><!--
		--><button type="button" class="btn_normal" name="btn_downexcel">Down Excel</button><!--
		--><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
	</div>
	<!-- btn_div(E) -->
</div>
<!-- 팝업제목(E) -->
<% } else {%>
<!-- 제목(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->

		<!-- btn_div(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" id="btn_retrieve" name="btn_retrieve">Retrieve</button>
			<button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
		</div>
		<!-- btn_div(E) -->
		<!-- page_location(S) -->
		<div class="location">
		   <span id="navigation"></span>
		</div>
		<!-- page_location(E) -->
	</div>
<!-- 제목(E) -->
<% }%>

<!-- 검색영역(S)-->
<div class="wrap_search">
	<div class="opus_design_inquiry wFit">
		<!--  biz_1 (S) -->
		<table>
			<colgroup>
				<col width="170px" />
				<col width="140px" />
				<col width="70px"  />
				<col width="140px" />
				<col width="146px" />
				<col />
			</colgroup>
			<tbody>
				<tr>
					<th>Country Code</th>
					<td><input type="text" style="width:40px; text-align:center;" class="input1" value="<%=cntCd%>" name="cnt_cd" maxlength="2" style="ime-mode:disabled" dataformat="enguponly"></td>
					<th>Location</th>
					<td><input type="text" style="width:84px;" class="input" value="<%=locCd%>" name="loc_cd" maxlength="5" dataformat="engup" style="ime-mode:disabled"></td>
					<th>Bonded Area Abbr, Code</th>
					<td><input type="text" style="width:80px;" class="input" name="wh_cd" maxlength="5" style="ime-mode:disabled"></td>
				</tr>
				<tr>
					<th>Bonded Area Customs Code</th>
					<td colspan="3"><input type="text" style="width:80px;" class="input" name="cstms_cd" maxlength="10" style="ime-mode:disabled" value="<%=cstmsCd%>"></td>
					<th>Bonded Area Name</th>
					<td><input type="text" style="width:174px;" class="input" name="wh_nm"></td>
				</tr>
			</tbody>
		</table>
		<!--  biz_1   (E) -->
	</div>
</div>
<!-- 검색영역(E)-->

<!-- 시트영역(S) -->
<div class="wrap_result">
	<div class="opus_design_grid">
		<script language="javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
<!-- 시트영역(E) -->
</form>
