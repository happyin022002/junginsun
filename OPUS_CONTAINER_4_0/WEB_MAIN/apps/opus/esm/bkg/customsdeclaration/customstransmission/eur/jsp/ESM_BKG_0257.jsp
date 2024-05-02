<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ESM_BKG_0257.jsp
*@FileTitle : ESM_BKG_0257
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/29
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.event.EsmBkg0257Event"%>

<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0257Event  event = null;				//PDTO(Data Transfer Object including Parameters)
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
	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.CustomsTransmission");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
	   
		event = (EsmBkg0257Event)request.getAttribute("Event");
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
<input type="hidden" name="call_type" value="ESM_BKG_0257" id="call_type" />
<input type="hidden" name="pgmNo" value="<%=strPgmNo%>" id="pgmNo" />
<input type="hidden" name="search_pod_cd" value="" id="search_pod_cd" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" 		id="btn_retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_new"  		id="btn_new">New</button><!--
		--><button type="button" class="btn_normal" name="btn_DownExcel" 	id="btn_DownExcel">Down Excel</button><!--
		--><button type="button" class="btn_normal" name="btn_transmit" 	id="btn_transmit">EDI Transmit</button>
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->

	<!-- opus_design_inquiry(S) -->
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
		  		<col width="10"></col>
		  		<col width="90"></col>
		  		<col width="80"></col>
		  		<col width="110"></col>
		  		<col width="70"></col>
		  		<col width="100"></col>
		  		<col width="40"></col>
		  		<col width="90"></col>
		  		<col width="70"></col>
		  		<col width="*"></col>
		  	</colgroup> 		
			<tbody>
				<tr>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input type="text" style="width:90px; ime-mode: disabled;" value="" class="input1" name="vvd_cd" dataformat="engup" required maxlength="9" fullfill caption="VVD"   ></td>
					<th title="Port of Loading">POL</th>
					<td><input type="text" style="width:60px;ime-mode: disabled;" value="" class="input"  name="pol_cd"dataformat="engup" maxlength="5" fullfill caption="POL"><!-- 
					 --><input type="text" style="width:30px;ime-mode: disabled;" value="" class="input"  name="pol_yd_cd"	dataformat="engup" maxlength="2" caption="POLYD"></td>
					<th title="Port of Discharging">POD</th>
					<td><input type="text" style="width:60px;ime-mode: disabled;" value="" class="input1"  name="pod_cd"	dataformat="engup"  maxlength="5" fullfill caption="POD"><!-- 
					 --><input type="text" style="width:30px;ime-mode: disabled;" value="" class="input"  name="pod_yd_cd"	dataformat="engup" maxlength="2" caption="PODYD"></td>
					<th>(<input type="checkbox" name="check_frob_search" class="trans" id="exID01"><label for="exID01">Incl. FROB</label>)</th>
					<th align="right">B/L No.</th>
					<td><input type="text" style="width:110px; ime-mode: disabled;" value="" class="input" name="bl_no"dataformat="engup" maxlength="12"></td>
					<th>RECEIVER ID</th>
					<td><input type="text" style="width:130px" value="" class="input" name="receiver_id" readOnly></td>
					<th>UVI</th>
					<td><input type="text" style="width:80px" value="" class="input" name="uvi" readOnly dataformat="num" maxlength="5" caption="UVI"></td>
					<th>Cargo Type</th>
					<td><%=JSPUtil.getCodeCombo("cargo_type", "", "style='width:60;'", "CD00748", 0, "")%>
						<script>
						ComAddBeginComboItem(form.cargo_type,"All","")
						form.cargo_type.options[0].selected = true;
						</script>
					</td>
					<th>Transhipment</th>
						<td>
						<select style="width: 70px;" name="trns_mode">
							<option value="" selected>All</option>
							<option value="Y">Y</option>
							<option value="N">N</option>
						</select>
					</td>	
				</tr>
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_grid(S) -->
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
						<td colspan="10">
							<input type="radio" name="p_ori_amd_cd" class="trans" value="O" id="exID02" checked><label for="exID02">Original</label><!-- 
							--><input type="radio" name="p_ori_amd_cd" class="trans" value="U" id="exID03" ><label for="exID03">Update</label>
						</td>
					</tr>
					<tr>
						<th>Vessel Name</th>
						<td><input type="text" style="width:220px; ime-mode: disabled;" value="" class="input2" name="vvd_nm" readOnly></td>
						<th>Vessel LLOYD</th>
						<td><input type="text" style="width:80px; ime-mode: disabled;" value="" class="input2"  name="vvd_ld" readOnly></td>
						<th>Vessel Call Sign</th>
						<td><input type="text" style="width:70px; ime-mode: disabled;" value="" class="input2"  name="vvd_call" readOnly></td>
						<th>ETA</th>
						<td><input type="text" style="width:120px; ime-mode: disabled;" value="" class="input2" name="eta" readOnly></td>
						<th>ETD</th>
						<td><input type="text" style="width:120px; ime-mode: disabled;" value="" class="input2" name="etd" readOnly></td>
					</tr>	
				</tbody>
			</table>
		</div>
	</div>
	<!-- opus_design_inquiry(E) -->

	<div class="opus_design_grid" id="mainTable" style="display:none;">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
</div>
<!-- opus_design_grid(E) -->	

</form>
