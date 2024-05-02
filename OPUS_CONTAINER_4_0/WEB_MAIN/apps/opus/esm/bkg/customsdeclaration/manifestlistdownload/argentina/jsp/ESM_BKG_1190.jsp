<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ESM_BKG_1190.jsp
*@FileTitle : ESM_BKG_1190
*@author     : CLT
*@version    : 1.0
*@since      : 2014/12/29
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.argentina.event.EsmBkg1190Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
EsmBkg1190Event  event = null;				//PDTO(Data Transfer Object including Parameters)
Exception serverException   = null;			//error from server
String strErrMsg = "";						//error message
int rowCount	 = 0;						//count of DB resultSET list

String successFlag = "";
String codeList  = "";
String pageRows  = "100";

String strUsr_id		= "";
String strUsr_nm		= "";
String strOfc_cd		= "";
String strPgmNo			= "";
Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ArsManifestListDownload");

try {
   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	strUsr_id =	account.getUsr_id();
	strUsr_nm = account.getUsr_nm();
	strOfc_cd = account.getOfc_cd();
   
	event = (EsmBkg1190Event)request.getAttribute("Event");
	serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
	strPgmNo = JSPUtil.getNull(request.getParameter("pgmNo"));

	if (serverException != null) {
		strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
	}
	
	// getting data from server when load the initial screen
	GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	
}catch(Exception e) {
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
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="pgmNo" value="<%=strPgmNo%>" id="pgmNo" />


<div class="page_title_area clear">
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<div class="opus_design_btn">
		<button class="btn_normal" name="btn_delete" id="btn_delete" type="button" style="display:none">Data Delete</button>
		<button type="button" class="btn_accent" name="btn_retrieve" 	id="btn_retrieve">Retrieve</button>
		<button type="button" class="btn_normal" name="btn_new"  		id="btn_new">New</button>
		<button type="button" class="btn_normal" name="btn_save"    	id="btn_save">Save</button>
		<button type="button" class="btn_normal" name="btn_download" 	id="btn_download">Data DownLoad</button>
		<button type="button" class="btn_normal" name="btn_transmit" 	id="btn_transmit">EDI Transmit</button>
		<button type="button" class="btn_normal" name="btn_viewmsg"		id="btn_viewmsg">View MSG</button>
	</div>
	<div class="location">
		<span id="navigation"></span>
	</div>
</div>

<div class="wrap_search">
	<div class="opus_design_inquiry wFit">
		<table  style="width:220px;" >
			<colgroup>
		  		<col width="40"></col>
		  		<col width="10"></col>
		  		<col width="100"></col>		
		  		<col width="*"></col>		  		
		  	</colgroup> 
		  	<tbody>
				<tr> 
					<th class="sm">Mode</th>
					<td class="sm"></td>
					<td class="sm">
						<input type="radio" value="O" class="trans" name="mode_type" id="mode_type1"><label for="mode_type1">Outbound&nbsp;</label>
						<input type="radio" value="I" class="trans" name="mode_type" id="mode_type2" checked><label for="mode_type2">Inbound</label>
					</td>
			</tr>
			</tbody>
		</table> 
		<table>
			<colgroup>
		  		<col width="40"></col>
		  		<col width="100"></col>		  		
		  		<col width="50"></col>
		  		<col width="100"></col>
		  		<col width="50"></col>
		  		<col width="100"></col>
		  		<col width="90"></col>
		  		<col width="*"></col>  		
		  	</colgroup> 		
			<tbody>
				<tr>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input type="text" style="width:90px; ime-mode: disabled;" value="" class="input1" name="vvd_cd" dataformat="engup" maxlength="9" fullfill caption="VVD"   ></td>
					<th title="Port of Loading">POL</th>
					<td><input type="text" style="width:60px;ime-mode: disabled;" value="" class="input"  name="pol_cd"dataformat="engup" maxlength="5" fullfill caption="POL">
					    <input type="text" style="width:30px;ime-mode: disabled;" value="" class="input"  name="pol_yd_cd"	dataformat="engup" maxlength="2" caption="POLYD"></td>
					<th title="Port of Discharging">POD</th>
					<td><input type="text" style="width:60px;ime-mode: disabled;" value="" class="input1"  name="pod_cd"	dataformat="engup"  maxlength="5" fullfill caption="POD">
					    <input type="text" style="width:30px;ime-mode: disabled;" value="" class="input"  name="pod_yd_cd"	dataformat="engup" maxlength="2" caption="PODYD"></td>
					<th align="right">B/L No.</th>
					<td><input type="text" style="width:110px; ime-mode: disabled;" value="" class="input" name="bl_no"dataformat="engup" maxlength="12" ></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>

<div class="wrap_result">
	<div class="opus_design_inquiry">
		<div class=" pad_btm_16">
			<table>
				<tbody>
					<colgroup>
				  		<col width="85"></col>
				  		<col width="100"></col>		  		
				  		<col width="100"></col>
				  		<col width="90"></col>
				  		<col width="110"></col>
				  		<col width="90"></col>
				  		<col width="50"></col>
				  		<col width="120"></col>
				  		<col width="50"></col>
				  		<col width="*"></col>
				  	</colgroup>
					<tr>
						<th>Vessel Name</th>
						<td><input type="text" style="width:220px; ime-mode: disabled;" value="" class="input2" name="vsl_eng_nm" readOnly></td>
						<th>Vessel LLOYD</th>
						<td><input type="text" style="width:80px; ime-mode: disabled;" value="" class="input2"  name="lloyd_no" readOnly></td>
						<th>Vessel Call Sign</th>
						<td><input type="text" style="width:70px; ime-mode: disabled;" value="" class="input2"  name="call_sgn_no" readOnly></td>
						<th>ETA</th>
						<td><input type="text" style="width:120px; ime-mode: disabled;" value="" class="input2" name="eta_dt" readOnly></td>
						<th>ETD</th>
						<td><input type="text" style="width:120px; ime-mode: disabled;" value="" class="input2" name="etd_dt" readOnly></td>
					</tr>	
				</tbody>
			</table>
		</div>
	</div>
</div>

<div class="wrap_result">  
	<div class="opus_design_grid">  
	    <script language="javascript">ComSheetObject('sheet1');</script>
	</div>
</div>

</form>