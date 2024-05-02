<%
/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG__0471.jsp
 *@FileTitle : Receive History from SEA_NACCS
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.japan.event.EsmBkg0471Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0471Event event = null; //PDTO(Data Transfer Object including Parameters)
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

		event = (EsmBkg0471Event) request.getAttribute("Event");
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
<input type="hidden" name="jp_msg_tp_cd">
<input type="hidden" size="200" name="com_mrdPath" id="com_mrdPath" value="apps/opus/esm/bkg/customsdeclaration/customsreport/report/ESM_BKG_0881.mrd">
<input type="hidden" size="200" name="com_mrdArguments" id="com_mrdArguments">
<input type="hidden" size="200" name="com_mrdTitle" id="com_mrdTitle" value="Receive History from SEA_NACCS_Print">
<input type="hidden" size="200" name="com_mrdBodyTitle" id="com_mrdBodyTitle" value="<span style=&quot;color:red&quot;>Receive History from SEA_NACCS_Print</span>">


<!-- page_title_area(S) -->
<div class="page_title_area clear ">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
	 --><button type="button" class="btn_normal" name="btn_view" id="btn_view">View Receive File</button><!--
	 --><button type="button" class="btn_normal" name="btn_print" id="btn_print">Print</button>
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location"><span id="navigation"></span></div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->
<div class= "wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<table style="width:950px">
			<colgroup>
				<col />
				<col />
				<col />
				<col />
				<col />
				<col />
			</colgroup>
			<tbody>
				<tr>
					<th>MSG TYPE</th>
					<td><select style="width:89px;" class="input" name="disp_jp_msg_tp_cd1" id="disp_jp_msg_tp_cd1">
							<option value="" selected>ALL</option>
							<option value="CMF01">CMF01</option>
							<option value="CMF03">CMF03</option>
							<option value="CMF21">CMF21</option>
							<option value="DMF">DMF</option>
							<option value="DOR">DOR</option>
							<option value="MFR">MFR</option>
							<option value="MFR21">MFR21</option>
							<option value="BKR">BKR</option>
							<option value="BKC">BKC</option>
						</select>
						<select style="width:89px; display:none;" class="input" name="disp_jp_msg_tp_cd2" id="disp_jp_msg_tp_cd2">
							<option value="" selected>ALL</option>
							<option value="SAS111">SAS111</option>
							<option value="SAS108">SAS108</option>
							<option value="SAMR">SAMR</option>
							<option value="SCMR">SCMR</option>
							<option value="SATD">SATD</option>
						</select>
						<input type="checkbox" value="JP24" class="trans" name="jp24_check" />&nbsp;JP24</td>
					<th>USER ID</th>
					<td><input type="text" style="width:80px;" dataformat="engupetc" name="usr_id" id="usr_id" class="input" maxlength="20" /></td>
					<td rowspan="2">
						<table class="search_sm2" border="0" style="width:80%;">
							<tr>
								<td>&nbsp;&nbsp;MFR ERROR</td>
							</tr>
							<tr>
								<td class="sm">
									<input type="radio" value="A" class="trans" name="error_check" id="error_check" checked />&nbsp;&nbsp;ALL&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="radio" value="E" class="trans" name="error_check" id="error_check" />&nbsp;&nbsp;ERROR
								</td>
							</tr>
						</table>
					</td>
					<th style="text-align:left"><input type="checkbox" value="Y" class="trans" name="date_check" id="date_check" checked />&nbsp;&nbsp;Receive Date</th>
				</tr>
				<tr>
					<th>VVD</th>
					<td><input type="text" style="width:90px;" dataformat="engup" name="in_vvd_cd" id="in_vvd_cd" class="input" maxlength="9"caption="VVD" fullfill /></td>
					<th>POD</th>
					<td><input type="text" style="width:80px;" dataformat="engup" name="in_pod_cd" id="in_pod_cd" class="input" maxlength="5" /></td>
					<td><input type="text" style="width:80px;" value="<%=toDate%>" maxlength="10" dataformat="ymd" class="input1" name="start_rcv_dt" id="start_rcv_dt" caption="Start Date" cofield="end_rcv_dt" required /><!--
						--><input type="text" style="width:50px;" value="00:00" name="start_rcv_dt2" id="start_rcv_dt2" class="input1" maxlength="5" dataformat="hm" caption="Start Time" required />&nbsp;~&nbsp;<!--
						--><input type="text" style="width:80px;" value="<%=toDate%>" name="end_rcv_dt" id="end_rcv_dt" maxlength="10" dataformat="ymd" class="input1" caption="End Date" cofield="start_rcv_dt" required /><!--
						--><input type="text" style="width:50px;" value="23:59" name="end_rcv_dt2" id="end_rcv_dt2" class="input1" maxlength="5" dataformat="hm" caption="End Time" required /><!--
						--><button type="button" class="calendar ir" name="btn_calendar" id="btn_calendar"></button></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script language="javascript">ComSheetObject("sheet1");</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>

</form>
