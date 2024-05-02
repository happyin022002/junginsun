<%
/*=========================================================
 *Copyright(c) 2014 CyberLogitec All Rights Reserved
 *@FileName : ESM_BKG_0477.jsp
 *@FileTitle : Transmit History to SEA_NACCS
 *@author : CLT
 *@version : 1.0
 *@since : 2014.04.23
 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.japan.event.EsmBkg0477Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0477Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //error from server
	String strErrMsg = ""; //Error message
	//int rowCount = 0; //DB ResultSet list count

	//String successFlag = "";
	//String codeList = "";
	//String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String toDate = "";
	//Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		toDate = JSPUtil.getKST("yyyy-MM-dd");

		event = (EsmBkg0477Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//Add logic information data from the server when loading the initial screen
		//GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

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

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
	 --><button type="button" class="btn_normal" name="btn_view" id="btn_view">View Send File</button><!--
	 --><button type="button" class="btn_normal" name="btn_resend" id="btn_resend">Resend</button>
	 </div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
</div>
<div class="wrap_search">
	<div class="opus_design_inquiry">
		<table style="width:800px">
			<colgroup>
				<col />
				<col />
				<col />
				<col />
			</colgroup>
			<tbody>
				<tr class="h23">
					<th>MSG TYPE</th>
					<td><select style="width:80px;" name="jp_snd_log_id">
							<option value="" selected>ALL</option>
							<option value="CMF01">CMF01</option>
							<option value="CMF03">CMF03</option>
							<option value="DMF">DMF</option>
							<option value="DOR">DOR</option>
							<option value="MFR">MFR</option>
							<option value="BKR">BKR</option>
							<option value="BKC">BKC</option>
						</select></td>
					<th>VVD</th>
					<td><input type="text" style="width:100px;" class="input" dataformat="engup" name="vvd_cd" id="vvd_cd" maxlength="9" caption="VVD" fullfill /></td>
					<th style="text-align:left"><input type="checkbox" value="Y" class="trans" name="date_check" id="date_check" checked />&nbsp;&nbsp;Send Date</th>
				</tr>
				<tr>
					<th>OFFICE</th>
					<td><input type="text" style="width:80px;" name="ofc_cd" id="ofc_cd" maxlength="6" dataformat="engup" class="input" /></td>
					<th>USER  ID</th>
					<td><input type="text" style="width:100px;" name="usr_id" id="usr_id" maxlength="20" dataformat="eng" class="input" maxlength="20" /></td>
					<td><input type="text" style="width:80px;" value="<%=toDate%>" maxlength="10" dataformat="ymd" class="input1" name="start_snd_dt" id="start_snd_dt" caption="Start Date" cofield="end_snd_dt" required /><!--
						--><input type="text" style="width:45px;" value="00:00" name="start_snd_dt2" id="start_snd_dt2" class="input1" dataformat="hm" maxlength="5" caption="Start Time" required /><!--
						-->~&nbsp;<input type="text" style="width:80px;" value="<%=toDate%>" maxlength="10" name="end_snd_dt" id="end_snd_dt" dataformat="ymd" class="input1" caption="End Date" cofield="start_snd_dt" required /><!--
						--><input type="text" style="width:45px;" value="23:59" name="end_snd_dt2" id="end_snd_dt2" class="input1" dataformat="hm" maxlength="5" caption="End Time" required /><!--
						--><button type="button" class="calendar ir" name="btn_calendar" id="btn_calendar"></button>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<div class="wrap_result">
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject("sheet1");</script>
	</div>
</div>

</form>
