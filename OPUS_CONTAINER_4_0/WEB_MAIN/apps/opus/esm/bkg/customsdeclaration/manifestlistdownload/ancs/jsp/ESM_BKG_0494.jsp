<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0494.jsp
*@FileTitle  : ACI_Vessel Information 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>	
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.event.EsmBkg0494Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0494Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//DB ResultSet List count

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");
	
	String vvd   = "";
	String ssrNo = "";
	String pod   = "";
	String popup = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0494Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		vvd   = (request.getParameter("vvd") == null)? "":request.getParameter("vvd");
		ssrNo = (request.getParameter("ssr_no")== null)?"":request.getParameter("ssr_no");
		pod   = (request.getParameter("pod")== null)?"":request.getParameter("pod");
		popup   = (request.getParameter("popup")== null)?"":request.getParameter("popup");		

		// getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
	
%>

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		$('<button type="button" class="btn_accent" name="btn_retrieve"	id="btn_retrieve">Retrieve</button>').appendTo("#btnArea");
		$('<button type="button" class="btn_normal" name="btn_new"	id="btn_new">New</button>').appendTo("#btnArea");
		$('<button type="button" class="btn_normal" name="btn_save"	id="btn_save">Save</button>').appendTo("#btnArea");
		$('<button type="button" class="btn_normal" name="btn_transmission"	id="btn_transmission">CUSREP Transmit</button>').appendTo("#btnArea");
		$('#btn_transmission').after($('#btn_Close'));
		
        
		loadPage();
	}
</script>

<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="frm_attr_ctnt2">
<input type="hidden" name="berth_code">
<input type="hidden" name="pod" value="<%=StringUtil.xssFilter(pod)%>">

<input type="hidden" name="popup" value="<%=StringUtil.xssFilter(popup)%>">
<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp"%>

<%if(!mainPage.equals("true")){%><div class="layer_popup_contents"><%}%>
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="80px" />
	            <col width="*" />			
			</colgroup> 
	        <tbody>
				<tr>
					<th>VVD</th>
					<td><input type="text" style="width:111px;ime-mode:disabled" class="input1" maxlength="9" dataformat="engup" name="vvd" value="<%=StringUtil.xssFilter(vvd) %>"></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_inquiry">
		<table class="wFit">
			<colgroup>
				<col width="80" />
				<col width="250" />
				<col width="50" />
				<col width="250" />
				<col width="150" />
	            <col width="*" />			
			</colgroup> 
			<tr>
				<th>SSR No.</th>
				<td colspan="5"><input type="text" style="width:111px;ime-mode:disabled" class="input" maxlength="6" dataformat="engup" name="frm_ssr_no" ></td>
			</tr>
			<tr>
				<th>Lloyd No.</th>
				<td><select style="width:47;" class="input2" name="frm_lloyd_type">
					<option value="L" selected="selected" >L</option>
					<option value="N" >N</option>
				</select><input type="text" style="width:60;ime-mode:disabled" class="input" maxlength="20" dataformat="engup" name="frm_lloyd_no"></td>
				<th>VSL Flag / Name</th>
				<td><input type="text" style="width:30px;ime-mode:disabled" class="input" maxlength="2" dataformat="engup" name="frm_vsl_flag"><input type="text" style="width:250px;ime-mode:disabled" class="input" maxlength="500" dataformat="engupetc" name="frm_vsl_name"></td>
			</tr>
			<tr>
				<th>PRV Port</th>
				<td><input type="text" style="width:111px;ime-mode:disabled" class="input" maxlength="5" dataformat="engup" name="frm_prv_prot"></td>
				<th>Berth Code</th>
				<td style="padding-left:2;"><script type="text/javascript">ComComboObject('slan_cd', 1, 160, 1)</script></td>
			</tr>
			<tr>
				<th>POD</th>
			    <td style="padding-left:2;"><script type="text/javascript">ComComboObject("frm_pod", 1, 110,0,1);</script></td>					
				<th>Call Date (ETA)</th>
				<td><input type="text" style="width:160px;ime-mode:disabled" class="input" maxlength="10" dataformat="ymd" name="frm_eta_call_date"></td>
				<th>DEM/DET Free Time</th>
				<td><input type="text" style="width:100px;ime-mode:disabled" class="input" maxlength="10" dataformat="ymd" name="frm_demdet_free_time"></td>
			</tr>
			<tr class="grid2">
				<th>Remark(s)</th>
				<td colspan="5"><textarea rows="6" style="width:100%;text-align:left;text-transform:uppercase;ime-mode:disabled;resize:none" maxlength="1500"  dataformat="engupetc"  name="frm_remark" ></textarea></td>
			</tr>
		</table>
		<table>
		    <tr><td></td></tr>
		    <tr class="line_bluedot"><td colspan="9"></td></tr>
		    <tr><td></td></tr>
		</table>
		<table>
			<colgroup>
				<col width="80">
  				<col width="40">
  				<col width="60">
				<col width="40">
				<col width="60">
				<col width="70">
				<col width="100">
	            <col width="*">	
	        </colgroup>
			<tbody>
				<tr>
	  				<th>CUSREP</th>
	  				<td><button type="button" class="input_seach_btn" name="btn_cusrep" id="btn_cusrep"></button></td>
	  				<th>Accept</th><td><img src="img/btng_icon_b.gif" width="13" height="13" alt="" border="0" name="anr_msg_sts_cd"></td>
					<th>Last EDI</th>
					<td><input type="text" style="width:70px;" class="input2" name="frm_last_edi" readonly="readonly"></td>
					<th>User ID / Date</th>
					<td><input type="text" style="width:70px;" class="input2" name="frm_user_id" readonly="readonly"><input type="text" style="width:110px;" class="input2" name="frm_user_date" readonly="readonly"></td>
				</tr>
			</tbody>
		</table>
		<table>
		    <tr><td></td></tr>
		    <tr class="line_bluedot"><td colspan="9"></td></tr>
		    <tr><td></td></tr>
		</table>
		<table class="wFit">
			<colgroup>
				<col width="80">
  				<col width="20">
				<col width="150">
				<col width="180">
				<col width="60">
  				<col width="200">
                <col width="100">
                <col width="*">
	        </colgroup>
			<tbody>
				<tr>
					<th class="sm">Download </th>
					<td class="sm"></td>
					<td class="sm">BKG TTL / DNLD TTL</td>
					<td class="sm"><input type="text" style="width:66px;text-align:center" class="input2" name="frm_bkg_ttl" readonly="readonly"><input type="text" style="width:70px;text-align:center" class="input2" name="frm_dnld_ttl" readonly="readonly"></td>
					<td class="sm">Difference</td>
					<td class="sm"><input type="text" style="width:30px;text-align:center" class="input2" name="frm_diff" readonly="readonly"></td>
					<th align="right" style="padding-right: 0px;">Transmit As </th>
					<td>&nbsp;
					<select style='width:120px;' name='transflag'>
					<option value='O'>Original</option>
					<option value='R'>Replace</option>
					<option value='C'>Cancel</option>
					</select>
					</td>
				</tr>
		</tbody>
		</table>
	</div>
	<!-- opus_design_grid(E) -->	
	<div class="opus_design_grid" style="display:none">
	    <script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
<%if(!mainPage.equals("true")){	%></div><%}%>

</form>