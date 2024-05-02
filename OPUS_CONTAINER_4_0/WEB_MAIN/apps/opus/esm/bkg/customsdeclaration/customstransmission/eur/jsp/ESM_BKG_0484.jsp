<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0484
*@FileTitle  : ESM_BKG_0484
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/08
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.event.EsmBkg0484Event"%>

<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0484Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from the server 
	String strErrMsg = "";						//error messege
	int rowCount	 = 0;						//the number of DB ResultSet List
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	Logger log = Logger.getLogger("com.clt.opus.CustomsDeclarationEur.CustomsTransmission");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		
		event = (EsmBkg0484Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
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
		}
		loadPage();
	}
</script>

<form name="form"> 
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="call_type" id="call_type" value="ESM_BKG_0484">
<input type="hidden" name="ofcCd" id="ofcCd" value="<%= strOfc_cd %>">
<input type="hidden" name="bnd_cd" id="bnd_cd">
<input type="hidden" name="p_vvd_cd" id="p_vvd_cd">
<input type="hidden" name="p_ori_amd_cd" id="p_ori_amd_cd" value="O">
<input type="hidden" name="edi_preview" id="edi_preview">


<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn"><!-- 
		--><button type="button" id="btn_retrieve" name="btn_retrieve" class="btn_accent">Retrieve</button><!--
		--><button type="button" id="btn_DownExcel" name="btn_DownExcel" class="btn_normal">Down Excel</button><!--
		--><button type="button" id="btn_preview" name="btn_preview" class="btn_normal">EDI Preview</button><!--
		--><button type="button" id="btn_DownLDF" name="btn_DownLDF" class="btn_normal">B/L LDF</button><!--
		<button type="button" id="btn_sitpro" name="btn_sitpro" class="btn_normal">SitPro</button>--><!--
		--><button type="button" id="btn_DownENS" name="btn_DownENS" class="btn_normal">ENS Download</button><!--
		--></div>
	<!-- opus_design_btn (E) -->

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
		<table class="mar_top_4">
			<colgroup>
				<col width="60"/>
				<col width="230"/>
				<col width="100"/>
				<col width="*" />				
			</colgroup> 
			<tr>
				<th class="sm">Option</th>
		   	    <td class="sm pad_left_4"><input type="radio" name="p_option" id="p_option1" value="SP" class="trans" checked><label for="p_option1"><strong>SitPro</strong></label><input type="radio" name="p_option" id="p_option2" value="DL" class="trans"><label for="p_option2"><strong>ENS Download for Feeder</strong></label></td>
				<td class="sm"><strong>( </strong><input type="checkbox" name="mrn" id="mrn" value="" class="trans" disabled="true"><label for="mrn"><strong>Incl. own MRN )</strong></label></td>	
				<td></td>					
			</tr>
		</table>
		<table>
			<colgroup>
				<col width="60">
				<col width="160">
				<col width="120">
				<col width="120">
				<col width="60">
				<col width="20">
				<col width="25">
				<col width="80">
				<col width="40">
				<col width="100">
				<col width="160">
				<col width="*">							
			</colgroup> 
			<tr>
				<th title="Vessel Voyage Direction">VVD</th>
				<td><input id="vvd_cd" style="width:90px; ime-mode: disabled" class="input1" value="" name="vvd_cd" dataformat="engup" maxlength="9" caption="VVD" type="text" /></td>
				<td class="sm pad_left_4"><b>POL</b> <input id="pol_cd" style="width:70px; ime-mode:disabled;" class="input1" value="" name="pol_cd" dataformat="engup" maxlength="5" caption="POL" type="text" /><input id="pol_yd_cd" style="width:25px;" value="" class="input" name="pol_yd_cd" maxlength="2" dataformat="engup" type="text" /></td>
				<td class="sm"><b>POD</b> <input id="pod_cd" style="width:70px; ime-mode:disabled;" class="input1" value="" name="pod_cd" dataformat="engup" maxlength="5" caption="POD" type="text" /><input id="pod_yd_cd" style="width:25px;" value="" class="input" name="pod_yd_cd" maxlength="2" dataformat="engup" type="text" /></td>
				<td class="sm"><strong>( </strong><input value="" class="trans" name="check_ts_search" id="check_ts_search" type="checkbox" /><label for="check_ts_search"><strong>T/S )</strong></label><input id="ts_search_flag" name="ts_search_flag" type="hidden" /></td>
				<td></td>
				<th title="Place of Receipt">POR</th>
				<td><input id="por_cd" style="width:70px; ime-mode:disabled;" class="input" value="" name="por_cd" dataformat="engup" maxlength="5"  caption="POR" type="text" /></td>
				<th title="Place of Delivery">DEL</th>
				<td><input id="del_cd" style="width:70px; ime-mode:disabled;" class="input" value="" name="del_cd" dataformat="engup" maxlength="5" caption="DEL" type="text" /></td>
				<th>POFE (Port of First Entry)</th>
				<td><script type="text/javascript">ComComboObject('p_pod_cd_temp', 1, 100, '');</script><input type="hidden" name="p_pod_cd" e="p_pod_cd"><input type="hidden" name="p_pod_yard_cd" e="p_pod_yard_cd"><input type="hidden" name="p_search_pofe_yard_cd" e="p_search_pofe_yard_cd"></td>
			</tr>
		</table>
		<table>
			<colgroup>
				<col width="60">
				<col width="130">
				<col width="60">
				<col width="130">
				<col width="100">
				<col width="100">
				<col width="100">
				<col width="214">
				<col width="62">
				<col width="*">					
			</colgroup> 
			<tr>
				<th>BKG No.</th>
				<td><input id="bkg_no" style="width:120px; ime-mode:disabled;" class="input" name="bkg_no" dataformat="engup" maxlength="13" caption="BKG No." type="text" /></td>
				<th>B/L No.</th>
				<td><input id="bl_no" style="width:120px; ime-mode:disabled;" class="input" value="" name="bl_no" dataformat="engup" maxlength="12" caption="B/L No." type="text" /></td>
				<th>BKG OFFICE</th>
				<td><input id="bkg_ofc_cd" style="width:100px; ime-mode:disabled;" class="input2" value="<%= strOfc_cd %>" name="bkg_ofc_cd" readonly dataformat="engup" maxlength="6" caption="BKG OFFICE" type="text" /></td>
				<th>BKG STATUS</th>
				<td><select style="width:100px;" name="bkg_sts_cd" id="bkg_sts_cd">
						<option value="" selected>ALL</option>
						<option value="F">Firm</option>
						<option value="W">Wait</option>
						<option value="S">Split (Memo)</option>
						<option value="B">BDR</option>
					</select>
				</td>
				<th>CGO STATUS</th>
				<td><select style="width:80px;" name="bkg_cgo_tp_cd" id="bkg_cgo_tp_cd">
						<option>All</option>
		            	<option value="F" selected>Full</option>
		            	<option value="P">Empty</option>
					</select>
				</td>					
			</tr>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">

	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">	
		<script type="text/javascript">ComSheetObject('sheet1');</script>	
		
	</div>
	<!-- opus_design_grid(E) -->
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid"  style="display:none;">	
		<script type="text/javascript">ComSheetObject('sheet2');</script>		
		<script type="text/javascript">ComSheetObject('sheet3');</script>
		<script type="text/javascript">ComSheetObject('sheet4');</script>	
		<script type="text/javascript">ComSheetObject('sheet5');</script>		

		<script type="text/javascript">ComSheetObject('sheet6');</script>
		<script type="text/javascript">ComSheetObject('sheet7');</script>
		<script type="text/javascript">ComSheetObject('sheet8');</script>
		<script type="text/javascript">ComSheetObject('sheet9');</script>	
		<script type="text/javascript">ComSheetObject('sheet10');</script>
		<script type="text/javascript">ComSheetObject('sheet11');</script>
		<script type="text/javascript">ComSheetObject('sheet12');</script>
		<script type="text/javascript">ComSheetObject('sheet13');</script>
		<script type="text/javascript">ComSheetObject('sheet14');</script>
	</div>
	<!-- opus_design_grid(E) -->

</div>

</form>