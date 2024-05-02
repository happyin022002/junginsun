<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0234.jsp
*@FileTitle  : Philippines
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/20
=========================================================
*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.philippine.event.EsmBkg0234Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0234Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //error from server
	String strErrMsg = ""; //error message
	String strUsr_id = "";
	String strUsr_nm = "";
	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EsmBkg0234Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	} catch (Exception e) {
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

<form name="form" id="form" method="post">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="vsl_cd" id="vsl_cd">
<input type="hidden" name="skd_voy_no" id="skd_voy_no">
<input type="hidden" name="skd_dir_cd" id="skd_dir_cd">
<input type="hidden" name="sheetdata" id="sheetdata">
<input type="hidden" name="sheetgubun"  id="sheetgubun">


<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
		--><button class="btn_normal" type="button" name="btn_new" id="btn_new">New</button><!--
		--><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Download To PC</button>
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->

<!-- opus_design_inquiry(S) -->
<div class="wrap_search">
	<div class="opus_design_inquiry">
		<table style="width:900px;">
			<tbody>
				<colgroup>
					<col />
					<col />
					<col />
					<col />
					<col />
					<col />
					<col />
					<col />
					<col />
					<col />
				</colgroup>
				<tr class="h23" align="left">
					<td></td>
					<th>VVD</th>
					<td><input maxlength="9" type="text" style="width: 80px;" class="input1" value="" name="vvd_cd" id="vvd_cd" style="ime-mode: disabled"  dataformat="engup"></td>
					<th>POL</th>
					<td><input maxlength="5" type="text" style="width: 50px;" class="input" value="" name="pol_cd" id="pol_cd" style="ime-mode: disabled"  dataformat="engup"></td>
					<th>POD</th>
					<td><input maxlength="5" type="text" style="width: 50px;" class="input" value="PHMNL" name="pod_cd" id="pod_cd"  style="ime-mode: disabled" dataformat="engup"></td>
					<th>Registry No.</th>
					<td><input maxlength="7" type="text" style="width: 80px;" class="input1" value="" name="reg_no" id="reg_no" style="ime-mode: disabled"  dataformat="engup"></td>
					<th>ETA</th>
					<td><input type="text" class="input" style="width:75px;" name="date_fm" id="date_fm" dataformat="ymd" maxlength="10" caption="From Date" cofield="date_to">~ <!--
					 --><input type="text" class="input" style="width:75px;" name="date_to" id="date_to" dataformat="ymd" maxlength="10" caption="To Date" cofield="date_fm"><!--
					 --><button type="button" id="btn_calendar" name="btn_calendar" class="calendar ir"></button></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->


<!-- opus_tab_btn(S) -->
<div class="wrap_result">
<div class="opus_design_tab">
	<script type="text/javascript">ComTabObject('tab1')</script>
</div>
<!-- opus_tab_btn(E) -->


<div class="opus_design_grid clear" name="tabLayer" id="tabLayer">
	<script type="text/javascript">ComSheetObject('t1sheet1');</script>
</div>


<div class="opus_design_grid clear" name="tabLayer" id="tabLayer">
	<script type="text/javascript">ComSheetObject('t2sheet1');</script>
</div>


<div class="opus_design_grid clear" name="tabLayer" id="tabLayer">
	<script type="text/javascript">ComSheetObject('t3sheet1');</script>
</div>



<div class="opus_design_grid clear" name="tabLayer" id="tabLayer">
	<script type="text/javascript">ComSheetObject('t4sheet1');</script>
</div>


<div class="opus_design_grid clear" name="tabLayer" id="tabLayer">
	<script type="text/javascript">ComSheetObject('t5sheet1');</script>
</div>

</div>
<iframe name="download" id="download" style="display:none;width:1px;height:1px;" onreadystatechange="ComOpenWait(false);"></iframe>
</form>