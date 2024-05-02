<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0017.jsp
*@FileTitle  : Manifest Transmit
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
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.panama.event.EsmBkg0017Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0017Event event = null; 		//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; 	//error from server
	String strErrMsg = "";				//error message

	String strUsr_id = "";
	String strUsr_nm = "";
	String vvdCd = "";
	//Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		
		vvdCd = request.getParameter("vvdCd")==null?"":request.getParameter("vvdCd");

		event = (EsmBkg0017Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

		// getting data from server when load the initial screen
		//GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

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
		
		<!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
		$('<button type="button" class="btn_accent mar_rgt_12" name="btn_retrieve" id="btn_retrieve">Retrieve</button>').appendTo("#btnArea");		
		$('<button type="button" class="btn_normal" name="btn_transmit" id="btn_transmit">Transmit</button>').appendTo("#btnArea"); 
		$('#btn_transmit').after($('#btn_Close'));
		
		//document.getElementById("title").innerHTML = "Notice Manifest";
		
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows"> 
<input type="hidden" name="vsl_cd"> 
<input type="hidden" name="skd_voy_no"> 
<input type="hidden" name="skd_dir_cd"> 
<input type="hidden" name="error_yn"> 
<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp"%>

<%if(!mainPage.equals("true")){%><div class="layer_popup_contents"><%}%>

<div class="wrap_search_tab">
	<!--biz page (S)-->
	<div class="opus_design_inquiry wFit">
		<table>
	        <colgroup>
	            <col width="30px"  />
	            <col width="82px" />
	            <col width="100px"  />
	            <col width="136px" />
	            <col width="150px"  />
	            <col width="66px"  />
	            <col width="100px"  />
	            <col width="75px"  />
	            <col width="65px"  />
	            <col width="90px" />
	            <col width=""      />
	        </colgroup>
	        <tbody>
	            <tr>
	                <th title="Vessel Voyage Direction">VVD</th>
					<td><input type="text" style="width: 90px;" class="input1" maxlength="9" value="<%=StringUtil.xssFilter(vvdCd) %>" name="vvd_cd" id="vvd_cd" dataformat="engup" style="ime-mode:disabled"></td>
					<td><input type="text" style="width: 60px;" class="input2" value=" " name="slan_cd" id="slan_cd" readonly></td>
					<th>ETA at Panama Canal</th>
					<td><input type="text" style="width: 130px;" class="input2" value=" " name="vps_eta_dt" id="vps_eta_dt" readonly></td>
					<th>Prior Port</th>
					<td><input type="text" style="width: 60px;" class="input2" value=" " name="pod_cd" id="pod_cd" readonly></td>
					<th>Next Port</th>
					<td><input type="text" style="width: 60px;" class="input2" value=" " name="pol_cd" id="pol_cd" readonly></td>
					<td></td>
					<td>
						<input type="radio" name="error_yn_temp" id="error_yn_temp_all" checked class="trans" onclick="checkTransmit('1')"><label for="error_yn_temp_all">All</label>
						<input type="radio" name="error_yn_temp" id="error_yn_temp_error" class="trans" onclick="checkTransmit('2')"><label for="error_yn_temp_error">Error</label>
					</td>
	            </tr>
            	            
	            <tr>
	                <th>Ship ID No.</th>
					<td colspan="2">
						<input type="text" style="width: 157px;" class="input2" value=" " name="shp_id_no" id="shp_id_no" readonly>
					</td>
					<th>Visit No.</th>
					<td>
						<input type="text" style="width: 130px;" class="input2" value=" " name="vst_no" id="vst_no" readonly>
					</td>
					<th>MVMT Seq.</th>
					<td>
						<input type="text" style="width: 60px;" class="input2" value=" " name="mvmt_seq" id="mvmt_seq" readonly>
					</td>
					<th>VSL Operator</th>
					<td>
						<input type="text" style="width: 60px;" class="input2" value=" " name="pnm_vsl_opr_cd" id="pnm_vsl_opr_cd" readonly>
					</td>
					<th>Send Target</th>
					<td>
					    <input type="radio" value="All" class="trans" name="error_type"  id="all" checked><label for="all">All</label>
                        <input type="radio" value="Err" class="trans" name="error_type"  id="err"><label for="err">Exclude Error Data</label>
                   </td>
		        </tr>
		        <tr>
		            <th>Origin</th>
					<td colspan="2">
						<input type="text" style="width: 157px;" class="input2" value=" " name="pnm_org_cd_temp" id="pnm_org_cd_temp" readonly>
						<input type="hidden" name="pnm_org_cd">
					</td>					
					<th>Destination</th>
					<td colspan="3">
						<input type="text" style="width: 278px" class="input2" value=" " name="pnm_dest_cd_temp" id="pnm_dest_cd_temp" readonly>
						<input type="hidden" name="pnm_dest_cd">
					<th>Sent Time</td>
					<td colspan="3">
						<input type="text" style="width: 130px;" class="input2" value=" " name="edi_snd_dt" id="edi_snd_dt" readonly>
						<input type="text" name="edi_snd_seq" id="edi_snd_seq" style="width: 20;" class="input2" readonly>
					</td>
		        </tr>
		    </tbody>
		</table> 
		<!--  biz_1   (E) -->   
	</div>
</div>

<div class="wrap_result">
	<!-- opus_design_tab(S) -->
	<div class="opus_design_tab">
	    <script language="javascript">ComTabObject('tab1')</script>
	</div>
	<!-- opus_design_grid(S) -->
	<div name="tabLayer" id="tabLayer"  class="opus_design_grid" style="display:inline">
	    <script language="javascript">ComSheetObject('t1sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid"  id="tabLayer"  name="tabLayer" style="display:none">
	
	    <script language="javascript">ComSheetObject('t2sheet1');</script>
	</div>
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid"  id="tabLayer"  name="tabLayer" style="display:none">
	    <script language="javascript">ComSheetObject('t3sheet1');</script>
	    <!-- 
	    <script language="javascript">ComSheetObject('sheet2');</script>
	     -->
	</div>
</div>
<%if(!mainPage.equals("true")){	%></div><%}%>
</form>