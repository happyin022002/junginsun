<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0045.jsp
*@FileTitle  : ACI_Vessel Information
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/09
=========================================================
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>	
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.event.EsmBkg0045Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0045Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0045Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// If you imported data from the server initialization when loading
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
		
		$('<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button>').appendTo("#btnArea");
		$('<button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button>').appendTo("#btnArea");
		$('<button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button>').appendTo("#btnArea");
		$('<button type="button" class="btn_normal" name="btn_cuscar" id="btn_cuscar">CUSCAR</button>').appendTo("#btnArea");
		$('<button type="button" class="btn_normal" name="btn_transfer" id="btn_transfer">CUSCAR Transmit</button>').appendTo("#btnArea");
		$('<button type="button" class="btn_normal" name="btn_contact" id="btn_contact">Contact Point</button>').appendTo("#btnArea");
		
		$('#btn_contact').after($('#btn_Close'));
		loadPage();
	}
</script>

<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="frm_sheet1_attr_ctnt2">


<%
	String vvd   = (request.getParameter("vvd") == null)? "":request.getParameter("vvd");
	String ssrNo = (request.getParameter("ssr_no")== null)?"":request.getParameter("ssr_no");
	String pod   = (request.getParameter("pod")== null)?"":request.getParameter("pod");
	String blNo   = (request.getParameter("bl_no")== null)?"":request.getParameter("bl_no");
	String popup   = (request.getParameter("popup")== null)?"":request.getParameter("popup");
	String kind   = (request.getParameter("pKind")== null)?"N":request.getParameter("pKind");
	
%>

<input type="hidden" name="popup" value="<%=popup %>">
<input type="hidden" name="kind" value="<%=kind %>">
	<!-- : ( Title ) (S) -->
	 <%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp"%>
	<!-- : ( Title ) (E) -->
		
<!-- opus_design_inquiry(S) -->
<%if(!mainPage.equals("true")){%><div class="layer_popup_contents"><%}%>
<input type="hidden" name="mainPageFlag" value="<%=mainPage%>">
<div class="wrap_search">
	<div class="opus_design_inquiry wFit">
		<!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <table>
	    <tbody>
	         <colgroup>
	            <col width="60"/>
	            <col width="130"/>
	            <col width="80"/>
	            <col width="70"/>
	            <col width="60"/>
	            <col width="100"/>
	            <col width="70"/>
	            <col width="100"/>
	            <col width="70"/>
	            <col width="*" />
	        </colgroup> 
				<tr> 
					<th>B/L No.</th>
					<td><input type="text" style="width:110px"  name="bl_no" class="input1" maxlength="12" dataformat="engup" value="<%=blNo %>"></td>
					<th>Article No.</th>
					<td><input type="text" style="width:60px" name="frm_sheet1_vvd_seq" class="input2" readOnly></td>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input type="text" style="width:100px; ime-mode:disabled" name="frm_sheet1_vvd" class="input2" maxlength="9" dataformat="engup" readOnly value="<%=vvd %>"></td>
					<th>SSR No.</th>
					<td><input type="text" style="width:70px; ime-mode:disabled" name="frm_sheet1_svc_rqst_no" class="input2" maxlength="7" dataformat="int" readOnly value="<%=ssrNo %>"></td>
					<th>CUST PRC</th>
					<td><input type="text" style="width:70px"  name="frm_sheet1_cstms_prc_cd" class="input2" maxlength="1" dataformat="engup" readOnly></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<div class="wrap_result">
	<h3 style="margin-bottom:0" class="title_design">Container</h3>
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
		<script type="text/javascript">ComSheetObject('sheet2');</script>	
	</div>

	<!-- opus_design_grid(E) -->
	<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
	<h3 style="margin-bottom:0" class="title_design">Article</h3>	
	<table class="grid2">
    	<colgroup>
        <col width="70"/>
         <col width="70"/>
         <col width="70"/>
         <col width="70"/>
         <col width="80"/>
         <col width="100"/>
         <col width="80"/>
         <col width="160"/>
         <col width="80"/>
         <col width="*" />
        </colgroup>
        <tbody> 
			<tr>
				<th>Select</th>
				<td><input type="checkbox" value="" class="trans" name="frm_article_chk" id="frm_article_chk"  onclick="chkCmt()" ></td>
				<th>ACPT</th>
				<td><input type="text" style="width:100%" name="frm_sheet1_bl_ack" id="frm_sheet1_bl_ack" class="noinput2" readOnly></td>
				<th>Last EDI</th>
				<td><input type="text" style="width:100%" name="frm_sheet1_bl_last_edi2" id="frm_sheet1_bl_last_edi2" class="noinput2"  readOnly></td>
				<th>N.Fax</th>
				<td><input class="noinput" type="text" style="width:100%" name="frm_sheet1_fax_no" id="frm_sheet1_fax_no" maxlength="20" dataformat="engupetc"></td>
				<th>N.Email</th>
				<td><input class="noinput" type="text" style="width:100%;text-align: left" name="frm_sheet1_ntfy_eml" id="frm_sheet1_ntfy_eml" maxlength="40" ></td>
			</tr>
		</tbody>
	</table>
	<table class="grid2">
    	<colgroup>
				<col width="80">
				<col width="200">
				<col width="50">
				<col width="*">
        </colgroup>
        <tbody> 
			<tr>
				<th>Package</th>
				<td><input type="text" name="frm_sheet1_pck_qty" id="frm_sheet1_pck_qty" style="width:105px; text-align:left;" class="input" dataformat="num" maxlength="15" caption="Package"><input type="text" name="frm_sheet1_pck_tp_cd" id="frm_sheet1_pck_tp_cd" style="width:35px;" class="input" dataformat="engup"></td>
				<th>Weight</th>
				<td><input type="text" name="frm_sheet1_act_wgt" id="frm_sheet1_act_wgt" style="width:100px; text-align:left;" class="input" dataformat="float" maxlength="23" caption="Weight"><select name="frm_sheet1_act_wgt_ut_cd" id="frm_sheet1_act_wgt_ut_cd" style="width:80px;"><option value="KGS" selected>KGS</option><option value="LBS">LBS</option></select></td>
			</tr>
		</tbody>
	</table> 
	<table class="grid2"> 
	<tbody>
    	<colgroup>
         <col width="350"/>
         <col width="19"/>
         <col width="350"/>
         <col width="19"/>
         <col width="*"/>
         <col width="19"/>
        </colgroup> 
			<tr>
				<th>Shipper Address</th>   
				<td><button type="button" name="btn_shipper" id="btn_shipper" class="input_seach_btn onClick="openPopup('cust_cd')"></button></td>
				<th>Consignee Address</th>    
				<td><button type="button" name="btn_cnee" id="btn_cnee" class="input_seach_btn" onClick="openPopup('cust_cd')"></button></td>
				<th>Notify Address</th>   	
				<td><button type="button" name="btn_noty" id="btn_noty" class="input_seach_btn" onClick="openPopup('cust_cd')"></button></td>
			</tr>
			<tr>
				<td colspan="2"><textarea style="resize: none;ime-mode: disabled" rows="3" dataformat="engupetc" name="frm_sheet1_shpr_name" id="frm_sheet1_shpr_name"></textarea></td>
				<td colspan="2"><textarea style="resize: none; ime-mode: disabled" rows="3" dataformat="engupetc" name="frm_sheet1_cnee_name" id="frm_sheet1_cnee_name"></textarea></td>
				<td colspan="2"><textarea style="resize: none; ime-mode: disabled" rows="3" dataformat="engupetc" name="frm_sheet1_ntfy_name" id="frm_sheet1_ntfy_name"></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><textarea style="resize: none; ime-mode: disabled" rows="3" dataformat="engupetc" name="frm_sheet1_shpr_addr" id="frm_sheet1_shpr_addr"></textarea></td>
				<td colspan="2"><textarea style="resize: none; ime-mode: disabled" rows="3" dataformat="engupetc" name="frm_sheet1_cnee_addr" id="frm_sheet1_cnee_addr"></textarea></td>
				<td colspan="2"><textarea style="resize: none; ime-mode: disabled" rows="3" dataformat="engupetc" name="frm_sheet1_ntfy_addr" id="frm_sheet1_ntfy_addr"></textarea></td>
			</tr>	
	</tbody>						
	</table> 
	<!-- Box (E) -->
	<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>	
	
	<!-- Grid_2 (S) -->
	 	<div class="opus_design_grid">
	    <!-- opus_design_btn(S) -->
	    <div class="opus_design_btn">
	    	<table>
	        <tr>
				<td width="170">Transmit As&nbsp;<select style="width:76;" class="input1" name="transmit" onclick="on_transmission()">
				<option value="O" selected="selected" >Original</option>
				<option value="T">Correction</option>
				<option value="C">Cancel</option>
				<option value="N"></option>
				</select></td>
	        	<td><button type="button" class="btn_normal" name="btn_RowAdd" id="btn_RowAdd">Row Add</button>
	        	<button type="button" class="btn_normal" name="btn_RowDelete" id="btn_RowDelete">Row Delete</button></td>
	        </tr>
	        </table>
	    </div>
	   
		<!-- opus_design_btn(E) -->		    
		<script type="text/javascript">ComSheetObject('sheet3');</script>
	 </div>	
	<!-- opus_design_grid(E) -->
	</div>
<%if(!mainPage.equals("true")){	%></div><%}%>
</form>