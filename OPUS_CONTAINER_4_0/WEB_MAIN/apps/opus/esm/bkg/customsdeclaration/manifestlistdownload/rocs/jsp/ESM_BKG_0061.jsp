<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0061.jsp
*@FileTitle  : Manifest Transmit
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/06
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	Exception serverException   = null;			//error from server
	String strErrMsg = "";				//error message
	int rowCount	 = 0;				//count of DB resultSET list
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String ofc_cd           = "";
	String cn_no= "";
	String vvd_no= ""; 
	String pop_up= ""; 
	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   	cn_no = request.getParameter("crn_no")==null?"":request.getParameter("crn_no");
	   	vvd_no = request.getParameter("vvd_no")==null?"":request.getParameter("vvd_no");
		strUsr_id =	account.getUsr_id();
		ofc_cd    = account.getOfc_cd();  
		strUsr_nm = account.getUsr_nm();
		//event = (EsmBkg0440Event)request.getAttribute("Event");
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
			$('<button type="button" class="btn_accent" name="btn_retrieve"		id="btn_retrieve">Retrieve</button>').appendTo("#btnArea");
	        $('<button type="button" class="btn_normal" name="btn_save"  		id="btn_save">Save</button>').appendTo("#btnArea");
	        $('<button type="button" class="btn_normal" name="btn_downexcel" 	id="btn_downexcel">Down Excel</button>').appendTo("#btnArea");
	        $('<button type="button" class="btn_normal" name="btn_add"			id="btn_add">Add B/L</button>').appendTo("#btnArea");
	        $('<button type="button" class="btn_normal" name="btn_del"   		id="btn_del">Row Delete</button>').appendTo("#btnArea");
	        $('<button type="button" class="btn_normal" name="btn_trans"   		id="btn_trans">Trans to PortInfoLink</button>').appendTo("#btnArea");
	        $('<button type="button" class="btn_normal" name="btn_view"   		id="btn_view">Manifest(B/L)</button>').appendTo("#btnArea");
	        
	        $('#btn_view').after($('#btn_Close'));
	        
	        
		
		loadPage();
	}
</script>
<form name="form" method="post">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="f_flag" id="f_flag" value ="SEARCH">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="vsl_cd" id="vsl_cd"> 
<input type="hidden" name="skd_voy_no" id="skd_voy_no"> 
<input type="hidden" name="skd_dir_cd" id="skd_dir_cd">
<input type="hidden" name="mt_flag" id="mt_flag">
<input type="hidden" name="bl_no" id="bl_no"> 
<input type="hidden" name="bkg_no" id="bkg_no">
<input type="hidden" name="crn_number" id="crn_number">
<input type="hidden" name="user_id" id="user_id" value ="<%=StringUtil.xssFilter(strUsr_id)%>">
<input type="hidden" name="cn_no" id="cn_no" value="<%=StringUtil.xssFilter(cn_no)%>">
<input type="hidden" name="vvd_no" id="vvd_no" value="<%=StringUtil.xssFilter(vvd_no)%>">
<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp"%>
<%if(!mainPage.equals("true")){%><div class="layer_popup_contents"><%}%>
	<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<tbody>
					<tr>
						<th width="40">CRN</th>
						<td width="40"><input name="frm_crn_number" id="frm_crn_number" maxlength="14" dataformat="engup" style="ime-mode: disabled;width:122px;" type="text" style="width:110px;" value="" class="input1"></td>
						<th width="40">VVD</th>
						<td width="40"><input name="frm_vvd_number" id="frm_vvd_number"  maxlength="9" dataformat="engup"  style="ime-mode: disabled;width:122px;" type="text" style="width:110px;" value="" class="input1"></td>
						<th width="70">POL</th>
						<td width="40"><input name="pol_cd" id="pol_cd"  maxlength="5" dataformat="engup"  style="ime-mode: disabled; width:110px;" type="text" value="" class="input"></td>
						<th width="40">POD</th>
						<td width="120"><input name = "pod_cd" id = "pod_cd" type="text" style="width:100px" READONLY value=" NLRTM" class="input2"></td>
						<td><input type="checkbox" id="cargoType" name="cargoType" value=""><label for="cargoType">Empty</label></td>
					</tr>
					<tr>
						<th>ETA</th>
						<td><input name="eta_dt" id="eta_dt"   READONLY type="text" style="width:122px;" value="" class="input2"></td>
						<th>ETD</th>
						<td><input name="etd_dt" id="etd_dt"   type="text" style="width:122px;" value="" class="input2" READONLY></td>
						<th>VSL Name</th>
						<td><input name="eng_nm" id="eng_nm" READONLY type="text" style="width:140px" value="" class="input2"></td>
					</tr>
				</tbody>
			</table>
		</div>
	<!-- opus_design_inquiry(E) -->
	</div>

	<div class="wrap_result">
	<!-- layout_wrap (S) -->
	 <div class="layout_wrap">
	     <div class="layout_vertical_2" style="width: 75%">
	         <!-- opus_design_grid(S) -->
	         <div class="opus_design_grid" style="margin-top: 29px">
	             <script type="text/javascript">ComSheetObject('sheet1');</script>
	         </div>
	         <!-- opus_design_grid(e) -->
	     </div>
	     <div class="layout_vertical_2 pad_left_8" style="width: 25%">
	         <!-- opus_design_grid(S) -->
	         <div class="opus_design_grid">
	             <div class="opus_design_btn">
	      <button type="button" class="btn_accent" name="btn_reject" id="btn_reject">Reject Select</button>
	      <button type="button" class="btn_normal" name="btn_confirm" id="btn_confirm">Confirm All</button>
	    </div>
	    <script type="text/javascript">ComSheetObject('sheet2');</script>
	         </div>
	         <!-- opus_design_grid(e) -->
	     </div>
	 </div>
	 <BR><BR>
	<!-- layout_wrap (e) -->
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet3');</script>
	</div>
	<!-- opus_design_grid(E) -->	
	</div>
<%if(!mainPage.equals("true")){	%></div><%}%>
</form>