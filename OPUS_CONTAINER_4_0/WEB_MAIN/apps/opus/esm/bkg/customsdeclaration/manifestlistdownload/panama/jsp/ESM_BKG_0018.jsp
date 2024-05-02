<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1008.jsp
*@FileTitle  : ESM_BKG_1008
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/23
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.panama.event.EsmBkg0018Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0018Event event = null;               //PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message

	String strUsr_id = "";
	String strUsr_nm = "";
	
  	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0018Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}
	} catch (Exception e) {
		out.println(e.toString());
	}
%>

<script language="javascript">
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
<input type="hidden" name="vsl_cd"> 
<input type="hidden" name="skd_voy_no"> 
<input type="hidden" name="skd_dir_cd"> 
<input type="hidden" name="pagerows">  

<!-- page_title_area(S) -->
<div class="page_title_area clear">
    <!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- btn_div(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button>
	    <button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button>
	    <button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button>
	    <button type="button" class="btn_normal" name="btn_transmit" id="btn_transmit">Go to Transmit</button>
	    <button type="button" class="btn_normal" name="btn_history" id="btn_history">Transmit & Receive History</button>
	    <button type="button" class="btn_normal" name="btn_viewRcvFile" id="btn_viewRcvFile">View Receive File</button>
	</div>
	<!-- btn_div(E) -->

   <!-- page_location(S) -->
   <div class="location">
		<span id="navigation"></span>
   </div>
   <!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
<!-- layout_wrap (S) -->
<div class="opus_design_inquiry">
	<!--  biz_1 (S) -->
	<table> 
		<colgroup>
			<col width="25px"  />
			<col width="150px" />
			<col width="135px" />
			<col width="270px" />
			<col width="30px"  />
			<col width="130" />
			<col width="60px"  />
			<col width="130" />
			<col width="60px"  />
			<col width=""      />
		</colgroup>
		<tbody>
				<tr>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input type="text" style="width: 100px;" value="" name="vvdCd" id="vvdCd" class="input1" maxlength="9" dataformat="engup" reqEsmred style="ime-mode:disabled"></td>
					<th>ETA at Panama Canal</th>
					<td><input type="text" style="width: 80px;" value="" name="vps_eta_start_dt" id="vps_eta_start_dt" dataformat="ymd" maxlength="10" class="input1" caption="ETA at Panama Canal" style="ime-mode:disabled">~&nbsp;<input type="text" style="width: 80px;" value="" dataformat="ymd" maxlength="10" name="vps_eta_end_dt" class="input1" caption="ETA at Panama Canal" style="ime-mode:disabled"><button type="button" class="calendar ir" name="btns_calendar" id="btns_calendar"></button></td>
						
					<th>Lane</th>
					<td><input type="text" style="width: 40px;"	class="input" name="slan_cd" id="slan_cd" dataformat="enguponly" maxlength="3" value="" style="ime-mode:disabled"></td>
					<th>Trans. STS</th>
					<td>
					<select name="trans_sts" id="trans_sts">
  					<option value="">ALL</option>
  					<option value="N">NO</option>
  					<option value="Y">YES</option>
					</select>
					</td><th>Ack. STS</th>
					<td>
					<select name="rcv_sts" id="rcv_sts">
  					<option value="">ALL</option>
  					<option value="A">Accept</option>
  					<option value="R">Reject</option>
					</select>
					</td>
				</tr>
		</tbody>
	</table> 
	<!--  biz_1   (E) -->	
</div>
<!-- layout_wrap (E) -->
</div>

<div class="wrap_result">
    <!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script language="javascript">ComSheetObject('sheet1');</script>
	</div>
<!-- opus_design_grid(E) -->         
</div>
</form>
