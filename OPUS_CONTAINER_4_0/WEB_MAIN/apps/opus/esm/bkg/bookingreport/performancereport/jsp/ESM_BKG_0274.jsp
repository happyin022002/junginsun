<%
	/*=========================================================
	 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
	 *@FileName : esm_bkg_0274.jsp
	 *@FileTitle : General Cargo Manifest by VVD/PORT
	 *@author     : CLT
	 *@version    : 1.0
	 *@since      : 2014/05/02
	 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page
	import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page
	import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingreport.performancereport.event.EsmBkg0274Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0274Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //error from the server
	String strErrMsg = ""; //error messege
	int rowCount = 0; //the number of DB ResultSet List

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	boolean bBtn_Disabled = true;
	Logger log = Logger.getLogger("com.clt.apps.opus.esm.bkg.bookingreport.performancereport");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0274Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// extract additional data obtained from the server during Initial loading ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

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

<form name="form">
	<input type="hidden" name="f_cmd">
	<input type="hidden" name="pagerows">
	<input type="hidden" name="ch_usr_id">
	<input type="hidden" name="curr_page"      value="1">
	<input type="hidden" name="rows_per_page"  value="50">
	<input type="hidden" name="order_by" >
	<input type="hidden" name="order_by_title" >

<!-- 제목 -->
<div class="page_title_area clear">
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->

		<!-- btn_div -->
   <div class="opus_design_btn">
	   <button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
	--><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button><!--
	--><button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down&nbsp;Excel</button><!--
	--><button type="button" class="btn_normal" name="btn_Print" id="btn_Print">Print</button>
   </div>

   <!-- page_location(S) -->
   <div class="location">
		<span id="navigation"></span>
   </div>
</div>
<!-- 제목 -->

<div class="wrap_search">
<!-- 검색영역 -->
<div class="opus_design_inquiry wFit" style="margin-bottom:0">
	<table>
		<tbody>
		<tr>
			<td width="180">
				<table class="sm" style="width:200px">
					<tr>
						<th width="40">Mode</th>
						<td>
							<input type="radio" value="O" class="trans" name="mode_type" checked><label for="mode_type">Outbound</label>
							<input type="radio" value="I" class="trans" name="mode_type"><label for="mode_type">Inbound</label>
						</td>
					</tr>
				</table>
			</td>
			<th width="25px">VVD</th>
			<td width="80px"><input type="text" style="width:75px;ime-mode:disabled" class="input1" name="vvd_cd" maxlength="9" dataformat="engup"></td>
			<th width="25px">POL</th>
			<td width="90px"><input type="text" style="width:50px;" class="input1" name="pol_cd" maxlength="5" dataformat="engup">&nbsp; <input type="text" style="width:25px;" class="input" name="pol_yd_cd" maxlength="2" dataformat="engup"></td>
			<th width="25px">POD</th>
			<td width="90px"><input type="text" style="width:50px;" class="input" name="pod_cd" maxlength="5" dataformat="engup">&nbsp; <input type="text" style="width:25px;" class="input" name="pod_yd_cd" maxlength="2" dataformat="engup"></td>
			<td width="180">
				<table class="sm" style="width:240px">
					<tr>
						<th width="70">Cargo Type</th>
						<td>
							<input type="radio" value="ALL" class="trans" name="cargo_type" checked><label for="cargo_type">All</label>
							<input type="radio" value="F" class="trans" name="cargo_type"><label for="cargo_type">Full</label>
							<input type="radio" value="P" class="trans" name="cargo_type"><label for="cargo_type">Empty</label>
						</td>
					</tr>
				</table>
			</td>
			<td width="230">
				<table class="sm" style="width:240px">
					<tr>
						<th width="75">Cargo Route</th>
						<td>
							<input type="radio" value="ALL" class="trans" name="cargo_route" checked><label for="cargo_route">All</label>
							<input type="radio" value="L" class="trans" name="cargo_route"><label for="cargo_route">Local</label>
							<input type="radio" value="T" class="trans" name="cargo_route"><label for="cargo_route">T/S</label>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		</table>
	</div>

	<table class="line_bluedot"><tr><td></td></tr></table>

	<div class="opus_design_inquiry wFit">
		<table>
		<tr>
			<td width="500">
				<table class="sm" style="width:490px">
					<tr>
						<th width="90">Booking Route</th>
						<td width="10">
						<td width="100">POR&nbsp;<input type="text" style="width:50px;" class="input" name="br_por_cd" maxlength="5" dataformat="engup"></td>
						<td width="100">POL&nbsp;<input type="text" style="width:50px;" class="input" name="br_pol_cd" maxlength="5" dataformat="engup"></td>
						<td width="100">POD&nbsp;<input type="text" style="width:50px;" class="input" name="br_pod_cd" maxlength="5" dataformat="engup"></td>
						<td width="*">DEL&nbsp;<input type="text"    style="width:50px;" class="input" name="br_del_cd" maxlength="5" dataformat="engup"></td>
					</tr>
				</table>
			</td>
			<td>
				<table class="sm" style="width:530px">
					<tr>
						<th width="45">Feeder</th>
						<td width="10">
						<td width="140px"><span style="width:55px"><span id="div_pre_post">Pre VVD</span>&nbsp;<input type="text" style="width:75px;ime-mode:disabled" class="input" name="fdr_vvd_cd" maxlength="9" dataformat="engup"></td>
						<td width="140px"><span style="width:50px"><span id="div_pre_post">Pre POL</span>&nbsp;<input type="text" style="width:50px;" class="input" name="fdr_pol_cd" maxlength="5" dataformat="engup">
						<input type="text" style="width:25px;" class="input" name="fdr_pol_yd_cd" maxlength="2" dataformat="engup"></td>
						<td width="140px"><span style="width:55px"><span id="div_pre_post">Pre POD</span>&nbsp;<input type="text" style="width:50px;" class="input" name="fdr_pod_cd" maxlength="5" dataformat="engup"><input type="text" style="width:25px;" class="input" name="fdr_pod_yd_cd" maxlength="2" dataformat="engup"></td>
					</tr>
				</table>
			</td>
		</tbody>
	</table>
</div>
<!-- 검색영역 -->
</div>

<div class="wrap_result">

	<!-- 시트영역 -->
	<div class="opus_design_grid">

		<div class="grid_option_left">
			<table class="search" border="0" style="width:979px;">
				<tr class="h23">
					<th width="35px">&nbsp;VVD</th>
					<td width="100px"><input type="text" style="width:80px;" class="input2" readonly name="hd_vvd_cd"></td>
					<th width="35px" id="hd_pol_pod">POL</th>
					<td width="70px"><input type="text" style="width:50px;" class="input2" readonly name="hd_pol_pod_cd"></td>
					<th width="35px" id="hd_eta_etd">ETD</th>
					<td width="100px"><input type="text" style="width:80px;" class="input2" readonly name="hd_eta_etd_cd"></td>
					<th width="35px">Mode</th>
					<td width="*"><input type="text" style="width:80px;" class="input2" readonly name="hd_mode_type"></td>
				</tr>
			</table>
		</div>

		<div class="opus_design_btn">
		   <button type="button" class="btn_normal" name="btn_Sort" id="btn_Sort">Sort</button>
		   <button type="button" class="btn_normal" name="btn_check_all" id="btn_check_all">Check All</button>
		   <button type="button" class="btn_normal" name="btn_uncheck_all" id="btn_uncheck_all">Uncheck All</button>
		</div>
			<script type="text/javascript">ComSheetObject("sheet1");</script>
	</div>
	<!-- 시트영역 -->
</div>

</form>
<form name="form2" method="POST">
	<input type="hidden" name="message">
</form>
<form name="form3" method="post">
	<input type="hidden" name="mode_type">
	<input type="hidden" name="vvd_cd">
	<input type="hidden" name="pol_cd">
	<input type="hidden" name="pod_cd">
	<input type="hidden" name="cargo_type">
</form>
