<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0442.jsp
*@FileTitle  : B/L Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/06
=========================================================*/%>

<%@ page import="com.clt.framework.core.controller.util.WebKeys"%>
<%@ page import="com.clt.framework.core.view.template.Screen"%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.event.EsmBkg0442Event"%>
<%@ page import="org.apache.log4j.Logger" %>


<%
 
Exception serverException   = null;			//error from server
String strErrMsg = "";						//error message
int rowCount	 = 0;						//count of DB resultSET list

String successFlag = "";
String codeList  = "";
String pageRows  = "100";

String strUsr_id		= "";
String strUsr_nm		= "";
String ofc_cd           = "";
String cn_no= "";
String frm_bl_no= ""; 
Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");

try {
   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
   	
   	cn_no = request.getParameter("crn_no")==null?"":request.getParameter("crn_no");
   	frm_bl_no = request.getParameter("frm_bl_no")==null?"":request.getParameter("frm_bl_no");
	 
	strUsr_id =	account.getUsr_id();
	ofc_cd    = account.getOfc_cd();  
	strUsr_nm = account.getUsr_nm();

	serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

	if (serverException != null) {
		strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
	}

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
		$('<button type="button" class="btn_normal" name="btn_contact" id="btn_contact">Contact Point</button>').appendTo("#btnArea");
		
		$('#btn_contact').after($('#btn_Close'));
		
		
		loadPage();
		
	}
</script>

<form name="form" method="post">
<input type="hidden" name="f_cmd" 		id="f_cmd">
<input type="hidden" name="f_flag" 		id="f_flag" value ="SEARCH">
<input type="hidden" name="pagerows" 	id="pagerows">
<input type="hidden" name="vsl_cd" 		id="vsl_cd"> 
<input type="hidden" name="skd_voy_no" 	id="skd_voy_no"> 
<input type="hidden" name="skd_dir_cd" 	id="skd_dir_cd">
<input type="hidden" name="mt_flag" 	id="mt_flag">
<input type="hidden" name="pol_cd" 		id="pol_cd">
<input type="hidden" name="cntr_no" 	id="cntr_no">  
<input type="hidden" name="dif_chr" 	id="dif_chr">
<input type="hidden" name="bkg_no" 		id="bkg_no">
<input type="hidden" name="bl_tp_cd" 	id="bl_tp_cd">
<input type="hidden" name="etc_bkg_no" 	id="etc_bkg_no">
<input type="hidden" name="user_id" 	id="user_id" value ="<%=strUsr_id%>">
<input type="hidden" name="cn_no" 		id="cn_no" value="<%=StringUtil.xssFilter(cn_no)%>">
<input type="hidden" name="frm_bl_no" 	id="frm_bl_no" value="<%=StringUtil.xssFilter(frm_bl_no)%>">

<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp"%>
<%if(!mainPage.equals("true")){%><div class="layer_popup_contents"><%}%>

<div class= "wrap_search">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry wFit">
	<table>
		<tbody>
			<colgroup>
				<col width="50">
				<col width="110">
				<col width="50">
				<col width="100">
				<col width="60">
				<col width="160">
				<col width="90">
				<col width="110">
				<col width="80">
				<col width="*">
		    </colgroup>
			<tr>
				<th>CRN</th>
				<td><input type="text" name="frm_crn_number" 	id="frm_crn_number" class="input1" style="ime-mode: disabled;width:110px;" 	maxlength="14" dataformat="engup" value=""></td>
				<th title="Vessel Voyage Direction">VVD</th>
				<td><input type="text" name="vvd_number" 		id="vvd_number" 	class="input2" style="width:90px;" 			maxlength="9" READONLY value=""></td>
				<th>B/L No.</th>
				<td><input type="text" name="bl_no" 			id="bl_no" 			class="input1" style="ime-mode: disabled" 	maxlength="13" dataformat="engup" style="width:120px;" value=""></td>
				<th>Freight Term</th>
				<td><%=JSPUtil.getCodeCombo("frt_term_cd", "",  "", "CD02080", 0,"")%></td>
				<th>CUST PRC</th>
				<td><%=JSPUtil.getCodeCombo("t1_doc_cd", "",  "", "CD01989", 0,"")%><!-- 
				     --><script>
				    	ComAddBeginComboItem(form.t1_doc_cd,"","0");
				    	ComSetObjValue(form.t1_doc_cd,'0' );
				    </script></td>   
			</tr>
		</tbody>
	</table>
</div>
<div class="opus_design_inquiry wFit">
	<table class="grid_2">
		<tbody>
			<colgroup>
				<col width="60"/>
				<col width="100"/>
				<col width="70"/>
				<col width="50"/>
				<col width="*"/>
				<col width="39"/>
		    </colgroup>
			<tr>
				<th>Shipper</th>
					<td colspan="5"><input type="text" name="shpr_cnt_cd" 		id="shpr_cnt_cd" 	dataformat="engup" 		style="width:30px;ime-mode:disabled" maxlength="2" class="input"><!-- 
	                 --><input type="text" name="shpr_cust_seq" 	id="shpr_cust_seq" 	dataformat="num" 		style="width:60px;text-align:right;ime-mode:disabled" maxlength="6" class="input" ><!-- 
	            --><button type="button" class="input_seach_btn" name='pop_shipper' id='pop_shipper'></button></td>
				<th>Consignee</th>
					<td colspan="5"><input type="text" name="cnee_cnt_cd" 		id="cnee_cnt_cd" 	dataformat="engup" 		style="width:30px;ime-mode:disabled" maxlength="2" class="input" ><!-- 
	                --><input type="text" name="cnee_cust_seq" 	id="cnee_cust_seq" 	dataformat="num" 		style="width:60px;text-align:right;ime-mode:disabled" maxlength="6" class="input" ><!-- 
	              --><button type="button" class="input_seach_btn" name='pop_consignee' id='pop_consignee'></button></td>
				<th>Notify</th>
					<td colspan="5"><input type="text" name="ntfy_cnt_cd" 		id="ntfy_cnt_cd" 	dataformat="engup" 		style="width:30px;ime-mode:disabled" maxlength="2" class="input" ><!--
	                --><input type="text" name="ntfy_cust_seq" 	id="ntfy_cust_seq" 	dataformat="num" 		style="width:60px;text-align:right;ime-mode:disabled" maxlength="6" class="input"><!--   
	             --><button type="button" class="input_seach_btn" name='pop_notify' id='pop_notify'></button></td>
			</tr>
			<tr>
				<td colspan="6"><textarea name="shpr_addr1" id="shpr_addr1" style="ime-mode: disabled; resize:none;"  rows="3" dataformat="engupetc"></textarea></td>
				<td colspan="6"><textarea name="cnee_addr1" id="cnee_addr1" style="ime-mode: disabled; resize:none;"  rows="3" dataformat="engupetc"></textarea></td>
				<td colspan="6"><textarea name="ntfy_addr1" id="ntfy_addr1" style="ime-mode: disabled; resize:none;"  rows="3" dataformat="engupetc"></textarea></td>
			</tr>
			<tr>
				<td colspan="6"><textarea name="shpr_addr2" id="shpr_addr2" style="ime-mode: disabled; resize:none;"  rows="3" dataformat="engupetc"></textarea></td>
				<td colspan="6"><textarea name="cnee_addr2" id="cnee_addr2" style="ime-mode: disabled; resize:none;"  rows="3" dataformat="engupetc"></textarea></td>
				<td colspan="6"><textarea name="ntfy_addr2" id="ntfy_addr2" style="ime-mode: disabled; resize:none;"  rows="3" dataformat="engupetc"></textarea></td>
			</tr>
			<tr>
				<th>City</th>
					<td><input type="text" name="shpr_cty_nm" 				id="shpr_cty_nm" 			dataformat="engup" 		style="width:100%;" maxlength="500" 	class="input" style="ime-mode:disabled"></td>
					<th>Country</th>
					<td><input type="text" name="shpr_cstms_decl_cnt_cd" 	id="shpr_cstms_decl_cnt_cd" dataformat="engup" 		style="width:100%;" maxlength="2" 		class="input" style="ime-mode:disabled"></td>
					<th>ZIP Code</th>
					<td><input type="text" name="shpr_zip_id" 				id="shpr_zip_id" 			dataformat="engup" 	style="width:100%;" maxlength="10" 		class="input" style="ime-mode:disabled"></td>
								
				<th>City</th>
					<td><input type="text" name="cnee_cty_nm" 				id="cnee_cty_nm" 			dataformat="engup" 		style="width:100%;" maxlength="500" 	class="input" style="ime-mode:disabled"></td>
					<th>Country</th>
					<td><input type="text" name="cnee_cstms_decl_cnt_cd" 	id="cnee_cstms_decl_cnt_cd" dataformat="engup" 		style="width:100%;" maxlength="2" 		class="input" style="ime-mode:disabled"></td>
					<th>ZIP Code</th>
					<td><input type="text" name="cnee_zip_id" 				id="cnee_zip_id" 			dataformat="engup" 	style="width:100%;" maxlength="10" 		class="input" style="ime-mode:disabled"></td>
								
				<th>City</th>
					<td><input type="text" name="ntfy_cty_nm" 				id="ntfy_cty_nm" 			dataformat="engup" 		style="width:100%;" maxlength="500" 	class="input" style="ime-mode:disabled"></td>
					<th>Country</th>
					<td><input type="text" name="ntfy_cstms_decl_cnt_cd" 	id="ntfy_cstms_decl_cnt_cd" dataformat="engup" 		style="width:100%;" maxlength="2" 		class="input" style="ime-mode:disabled"></td>
					<th>ZIP Code</th>
					<td><input type="text" name="ntfy_zip_id" 				id="ntfy_zip_id" 			dataformat="engup" 	style="width:100%;" maxlength="10" 		class="input" style="ime-mode:disabled"></td>
			</tr>
			<tr>
				<th>Street</th>
					<td colspan="3"><input type="text" name="shpr_st_nm" 				id="shpr_st_nm" 			dataformat="engup" 		style="width:100%;" maxlength="50" class="input" style="ime-mode:disabled">
					<th>EORI#</th>
					<td><input type="text" name="shpr_eori_no" 				id="shpr_eori_no" 			dataformat="engup" 		style="width:100%;" maxlength="20" class="input" style="ime-mode:disabled">
			
				<th>Street</th>
					<td colspan="3"><input type="text" name="cnee_st_nm" 				id="cnee_st_nm" 			dataformat="engup" 		style="width:100%;" maxlength="50" class="input" style="ime-mode:disabled"></td>
					<th>EORI#</th>
					<td><input type="text" name="cnee_eori_no" 				id="cnee_eori_no" 			dataformat="engup" 		style="width:100%;" maxlength="20" class="input" style="ime-mode:disabled"></td>
				
				<th>Street</th>
					<td colspan="3"><input type="text" name="ntfy_st_nm" 				id="ntfy_st_nm" 			dataformat="engup" 		style="width:100%;" maxlength="50" class="input" style="ime-mode:disabled"></td>
					<th>EORI#</th>
					<td><input type="text" name="ntfy_eori_no" 				id="ntfy_eori_no" 			dataformat="engup" 		style="width:100%;" maxlength="20" class="input" style="ime-mode:disabled"></td>
			</tr>
		</tbody>
	</table>
</div>
</div>
<!-- opus_design_inquiry(E) -->
<div class="wrap_result">
	<!-- opus_design_grid(S) -->	
	<div class="opus_design_grid">
		<table>
			<tr>
				<td><h3 class="title_design">Container</h3></td>
				<td>
					<div class="opus_design_btn">
					<button type="button" class="btn_normal" name="btn_add1" 	id="btn_add1">Row Add</button>
					<button type="button" class="btn_normal" name="btn_delete1" id="btn_delete1">Row Delete</button>
				</div>
				</td>
			</tr>
		</table>
		
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
	<div class="opus_design_grid">
			<table class="search">
				<tbody>
					<tr>
						<td><h3 class="title_design">Cargo</h3></td>
						<td>
							<div class="opus_design_btn">
							<button type="button" class="btn_normal" name="btn_add2" 	id="btn_add2">Row Add</button>
							<button type="button" class="btn_normal" name="btn_delete2" id="btn_delete2">Row Delete</button>
						</div>
						</td>
					</tr>
				</tbody>
			</table>
		<div style="display:none;"><script type="text/javascript">ComSheetObject('sheet2');</script></div>
		<script type="text/javascript">ComSheetObject('sheet3');</script>
	</div>
<!-- opus_design_grid(E) -->	
</div>

<%if(!mainPage.equals("true")){	%></div><%}%>

</form>