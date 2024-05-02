<% 
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0210.jsp
*@FileTitle  : Customs Data Download
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/19
=========================================================*/
%>


<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.event.EsmBkg0210Event"%>
<%@ page import="org.apache.log4j.Logger" %>


<%
	EsmBkg0210Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from the server
	String strErrMsg = "";						//error messege
	int rowCount = 0;						//the number of DB ResultSet List
	String successFlag = "";
	String codeList = "";
	String pageRows = "50";
	String strUsr_id = "";
	String strUsr_nm = "";
	String strOfc_cd = "";
	String strPgmNo = "";
	String strCustoms = "";
	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");
	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		event = (EsmBkg0210Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		//  extract additional data obtained from the server during Initial loading ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		strPgmNo = JSPUtil.getNull(request.getParameter("pgmNo"));
		if (strPgmNo.indexOf("0210") > 0) {
			if (strPgmNo.endsWith("1")) {
				strCustoms = "Origin US";
			} else if (strPgmNo.endsWith("2")) {
				strCustoms = "US";
			} else if (strPgmNo.endsWith("3")) {
				strCustoms = "Origin CA";
			} else if (strPgmNo.endsWith("4")) {
				strCustoms = "CA";
			} else if (strPgmNo.endsWith("5")){
				strCustoms = "Origin Export";
			}
		}
	} catch(Exception e) {
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
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows" value="<%=pageRows%>">
<input type="hidden" name="total" id="total" value="0">
<input type="hidden" name="vsl_cd" id="vsl_cd">
<input type="hidden" name="skd_voy_no" id="skd_voy_no">
<input type="hidden" name="skd_dir_cd" id="skd_dir_cd">
<input type="hidden" name="customs" id="customs" value="<%=strCustoms%>">
<input type="hidden" name="sheet_id" id="sheet_id">
<input type="hidden" name="v_pol" id="v_pol">
<input type="hidden" name="v_pod" id="v_pod">



<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
	<button class="btn_normal" name="btn_Delete" id="btn_Delete" type="button" style="display:none">Data Delete</button><!--
	--><button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
	--><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button><!--
	--><button type="button" class="btn_normal" name="btn_datadl" id="btn_datadl">Data Download</button>
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<tbody>
				<colgroup>
					<col width="50" />
					<col width="120" />
					<col width="50" />
					<col width="90" />
					<col width="50" />
					<col width="100" />
					<col width="50" />
					<col width="*" />
				</colgroup>
				<tr>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input type="text" style="width: 90px; ime-mode: disabled;" class="input1" dataformat="engup" name="vvd" id="vvd"  maxlength="9" fullfill caption="VVD" required></td>
					<th title="Port of Loading">POL</th>
					<td><input type="text" style="width: 50px; ime-mode: disabled;" value="" class=<%=strCustoms.startsWith("Origin") ? "input1" : "input" %> dataformat="engup" name="pol_cd" id="pol_cd" maxlength="5" fullfill caption="POL" <%=strCustoms.startsWith("Origin") ? "required" : "" %>></td>
					<th title="Port of Discharging">POD</th>
					<td><input type="text" style="width: 50px; ime-mode: disabled;" value="" class=<%=!strCustoms.startsWith("Origin") ? "input1" : "input" %> dataformat="engup" name="pod_cd" id="pod_cd" maxlength="5" fullfill caption="POD" <%=!strCustoms.startsWith("Origin") ? "required" : "" %>></td>
					<th>Cargo Type</th>
					<td><!--
					--><%=JSPUtil.getCodeCombo("bkg_cgo_tp_cd", "", "style='width:80px;'", "CD20023", 0, "")%><!--
					--><script>
							ComSetObjValue(form.bkg_cgo_tp_cd,'F' );
						</script>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet0');</script>
	</div>
	<!-- opus_design_grid(E) -->

	<div class="opus_design_inquiry">
		<label>M.B/L	</label>
		<input type="text" name="mbl_tot" id="mbl_tot" style="width: 40px;" readonly class="input2">
		<label>+ </label>
		<label>H.B/L</label>
		<input type="text" name="hbl_tot" id="hbl_tot"  style="width: 40px;" readonly class="input2">
		<label> =</label>
		<label> Target B/L TTL</label>
		<input type="text" name="bl_ttl"  id="bl_ttl"  style="width: 40px;" readonly class="input2">
	</div>

	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet2');</script>
		<table class="mar_top_12">
			<tr>
				<td align="right">
				<% if (strCustoms.indexOf("CA") < 0) { %>
					<label>Actual Filing</label>
					<select name="act_file_skd_dir_cd" id="act_file_skd_dir_cd">
						<option value=""></option>
						<option value="E">E</option>
						<option value="W">W</option>
					</select>
				<% } %>
				<label>Selected B/L Count:</label>
				<input type="text" name="selected" id="selected" style="width:40;" readonly class="input2">
				<% if (strCustoms.indexOf("CA") < 0) { %>
					<!-- opus_design_btn(S) -->
					<div class="opus_design_btn">
						<button type="button" class="btn_normal" name="btn_edi" id="btn_edi">Terminal EDI</button>
						<span class="mar_left_12" id="all_pol" <%=strPgmNo.endsWith("2") ? "style='line-height:2.2'" : "style='display:none'" %>><input type="checkbox" name="chkAllPol" id="chkAllPol" class="trans"> All POL</span>
					</div>
				 <% } %>
<%-- 				 <div id="all_pol" style="display:<%=strPgmNo.endsWith("2") ? "inline" : "none" %>"> --%>
<!-- 		             <table class="search" border="0" style="width:;">  -->
<!-- 			             <tr> -->
<!-- 			                 <td><input type="checkbox" name="chkAllPol" id="chkAllPol" class="trans"> All POL</td> -->
<!-- 			                 <td width=10></td> -->
<!-- 			             </tr> -->
<!-- 		             </table> -->
<!-- 		         </div> -->
				</td>
			 </tr>
		</table>
	</div>
	<!-- opus_design_grid(E) -->

	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid wFit" style="display: none;">
		<script type="text/javascript">ComSheetObject('sheet3');</script>
	</div>
	<!-- opus_design_grid(E) -->

	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid wFit" style="display: none;">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->

	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid wFit" style="display: none;">
		<script type="text/javascript">ComSheetObject('sheet4');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>