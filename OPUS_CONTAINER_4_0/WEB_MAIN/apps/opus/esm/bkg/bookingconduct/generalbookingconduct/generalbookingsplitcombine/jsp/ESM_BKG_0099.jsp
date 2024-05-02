<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec 
*@FileName   : esm_bkg_0099.jsp
*@FileTitle  :  Booking Split
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/25
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.event.EsmBkg0099Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO" %>
<%@ page import="com.clt.apps.opus.esm.bkg.common.*" %>

<%
	EsmBkg0099Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from the server	
	String strErrMsg = "";						//error messege
	int rowCount	 = 0;						//the number of DB ResultSet List

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strAsList = "";
	String strAsCode = "";
	String strAsText = "";
	String strBkgNo = "";
	String popUpFlag = "";
	String calllFunc  = "";
	Logger log = Logger.getLogger("com.clt.apps.GeneralBookingConduct.GeneralBookingSplitCombine");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strAsList=JSPUtil.getIBCodeCombo("", "", "CD01637", 0, "");
		
		if(strAsList != null && strAsList.length() > 8) {
			strAsCode = strAsList.substring(strAsList.indexOf("Code = \"")+8, strAsList.lastIndexOf("\""));
			strAsText = strAsList.substring(strAsList.indexOf("Text = \"")+8, strAsList.indexOf("\";"));  
		}

		event = (EsmBkg0099Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		popUpFlag = JSPUtil.getParameter(request, "popUpFlag");

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// extract additional data obtained from the server during Initial loading ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		strBkgNo =JSPUtil.getNull(event.getBkgBlNoVO().getBkgNo());
		calllFunc  = JSPUtil.getParameter(request, "func");
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		//<input name="txtProgress" style="width:40;" class="input2" readonly>
		//<td class="btn1_line"></td>
		$('<input type="text" class="input2" name="txtProgress"	id="txtProgress" style="width:40px; margin-top:6px;" readonly ></input>').appendTo("#btnArea");
		//$('<td class="btn1_line"></td>').appendTo("#btnArea");
		$('<button type="button" class="btn_accent" name="btn_retrieve"	id="btn_retrieve">Retrieve</button>').appendTo("#btnArea");
        $('<button type="button" class="btn_normal" name="btn_save"  	id="btn_save" style="display:none">Save</button>').appendTo("#btnArea");
        $('<button type="button" class="btn_normal" name="btn_save2"  	id="btn_save2">Save</button>').appendTo("#btnArea");
        
        $('#btn_save2').after($('#btn_Close'));
        
        //document.getElementById("title").innerHTML = "Booking Split";
		
		loadPage("<%=strAsCode%>","<%=strAsText%>");
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">

<!-- Groupmail Hidden --> 
<input type="hidden" name="gw_subject" id="gw_subject">
<input type="hidden" name="gw_contents" id="gw_contents">
<input type="hidden" name="gw_template" id="gw_template" value="ESM_BKG_COMM_01T.html">
<input type="hidden" name="gw_args" id="gw_args" value="reqcontents;">

<input type="hidden" name="dg" id="dg">
<input type="hidden" name="rf" id="rf">
<input type="hidden" name="ak" id="ak">
<input type="hidden" name="bb" id="bb">

<input type="hidden" name="bdr_flag" id="bdr_flag">
<input type="hidden" name="bkgStsCd" id="bkgStsCd">
<input type="hidden" name="split_rsn_cd" id="split_rsn_cd">  <!--check if MEMO SPLIT-->
<input type="hidden" name="bkg_cgo_tp_cd" id="bkg_cgo_tp_cd">
<input type="hidden" name="lastSplitNo" id="lastSplitNo"> 
<input type="hidden" name="custSplitNo" id="custSplitNo">
<input type="hidden" name="memosplitno" id="memosplitno">
<input type="hidden" name="pseudoVvdFlag" id="pseudoVvdFlag">
<input type="hidden" name="partialflag" id="partialflag">
<input type="hidden" name="old_bkg_no" id="old_bkg_no" value="<%=strBkgNo%>">
<input type="hidden" name="codflag" id="codflag" value="N"> <!-- related to COD -->
<input type="hidden" name="caflag" id="caflag">
<input type="hidden" name="pctl_no" id="pctl_no">
<input type="hidden" name="pcIdx" value="0">
<input type="hidden" name="tro_flg">
<input type="hidden" name="splitdel">

<input type="hidden" name="qtySplitNo" id="qtySplitNo">
<input type="hidden" name="cntrSplitNo" id="cntrSplitNo">
<input type="hidden" name="dgCntrSplitNo" id="dgCntrSplitNo">
<input type="hidden" name="rfCntrSplitNo" id="rfCntrSplitNo">
<input type="hidden" name="akCntrSplitNo" id="akCntrSplitNo">
<input type="hidden" name="bbCntrSplitNo" id="bbCntrSplitNo">
<input type="hidden" name="troSplitNo" id="troSplitNo">
<input type="hidden" name="troTp" id="troTp">
<input type="hidden" name="validateSplitNo" id="validateSplitNo">
<input type="hidden" name="bkgsplitno" id="bkgsplitno"> 
<input type="hidden" name="cntrExists" id="cntrExists"> 
<input type="hidden" name="caRsnCd" id="caRsnCd"> 
<input type="hidden" name="caRemark" id="caRemark">
<input type="hidden" name="cntrPopExists" id="cntrPopExists" value="N"> 
<input type="hidden" name="popUpFlag" id="popUpFlag" value="<%=popUpFlag%>">
<input type="hidden" name="bkg_close_flg" id="bkg_close_flg" value="N"> 
<input type="hidden" name="bkg_cbf_flg" id="bkg_cbf_flg" value="N"> 
<input type="hidden" name=obl_iss_flg id=obl_iss_flg value="N">
<input type="hidden" name="vvd_change_flg" id="vvd_change_flg" value="N">
<input type="hidden" name="bkg_wt_chk_flg" id="bkg_wt_chk_flg">
<input type="hidden" name="edi_hld_flg" id="edi_hld_flg">
<input type="hidden" name="calllFunc" id="calllFunc" value="<%=calllFunc%>">
<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp"%>

<%if(!mainPage.equals("true")){%><div class="layer_popup_contents"><%}%>

<!-- wrap_search(S) -->  
<div class="wrap_search">

<!-- layout_wrap(S) -->
<div class="layout_wrap" style="width: 100%">
	<!-- layout_vertical_2(S) -->
	<div class="layout_vertical_2" style="width: 69%">
		<!--Content-->
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry">
			<!--  biz_1_1 (S) -->
			<table> 
				<tr class="h23">
					<th>BKG No.</th>
					<td><input type="text" style="width:110px;" value="<%=strBkgNo%>" class="input1" dataformat="engup" name="bkg_no" maxlength="13" onkeydown="bkg0099_keydown();">
						<button type="button" class="btn_down" name="btn_split_pop" id="btn_split_pop"></button>
					</td>
					<td><div id="splitFlag" style="display:none"></div></td>
					<td><div id="bdrFlag" style="display:none"></div></td>					
					<td><input type="checkbox" name="stwg_cd" id="stwg_cd"></td>
					<td style="font-weight:bold"><label for="stwg_cd">Stowage</label></td>					
					<td><input type="checkbox"  name="rail_blk_cd" id="rail_blk_cd"></td>
					<td style="font-weight:bold"><label for="rail_blk_cd">Bulk Rail</label></td>					
					<td width=""><input type="checkbox" name="fd_grd_flg" id="fd_grd_flg"></td>
					<td style="font-weight:bold"><label for="fd_grd_flg">Food Grade</label></td>
				</tr>				
					
				<tr class="h23">
					<th>B/L No.</th>
					<td><input type="text" style="width:110px;"  class="input1" dataformat="engup" name="bl_no"></td>
					<th>T/VVD</th>
					<td><input type="text" style="width:80px;"  class="input" dataformat="engup" name="tvvd" disabled></td>
					<td><input type="checkbox" name="hngr_flg" id="hngr_flg"></td>
					<td style="font-weight:bold"><label for="hngr_flg">Hanger</label></td>
					<td><input type="checkbox" name="hot_de_flg" id="hot_de_flg"></td>
					<td style="font-weight:bold"><label for="hot_de_flg">Premium</label></td>
					<td><input type="checkbox" name="prct_flg" id="prct_flg"></td>	
					<td style="font-weight:bold"><label for="prct_flg">Precaution</label></td>					
				</tr>
				
				<tr class="h23">
					<th>Route</th>
					<td colspan="3">
						<input type="text" style="width:52px;" class="input" dataformat="engup" name="por_cd" disabled><!--  				
						--><input type="text" style="width:53px;"  class="input" dataformat="engup" name="pol_cd" disabled><!--
						--><input type="text" style="width:53px;"  class="input" dataformat="engup" name="pod_cd" disabled><!--
						--><input type="text" style="width:53px;"  class="input" dataformat="engup" name="del_cd" disabled>
					</td>
					<td><input type="checkbox"  name="stop_off_loc_cd" id="stop_off_loc_cd"></td>
					<td style="font-weight:bold"><label for="stop_off_loc_cd">Stop Off</label></td>
					<td><input type="checkbox"  name="spcl_hide_flg" id="spcl_hide_flg"></td>
					<td style="font-weight:bold"><label for="spcl_hide_flg">Hide</label></td>
					<td><input type="checkbox"  name="remark" id="remark"></td>
					<td style="font-weight:bold"><label for="remark">Remark</label></td>
					
					
				</tr>
			</table>				
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
	<!-- layout_vertical_2(E) -->
	
	<!-- layout_vertical_2(S) -->
	<div class="layout_vertical_2" style="width: 31%">
		<!--Content-->
		<!-- opus_design_inquiry(S) -->			
		<div class="opus_design_inquiry">
			<table class="grid_2"> 
				<tr>
					<th colspan="2" text-align: center;">Type</th>
					<th style="text-align: center;">No.</th>
				</tr>
				<tr>
					<td ><input type="radio" value="C" checked name="splitreason" id="splitreason_C"><label for="splitreason_C">Customer</label></td>
					<td ><input type="radio" value="M" name="splitreason" id="splitreason_M"><label for="splitreason_M">Memo B/L</label></td>
					<td ><input type="text" style="width:60px;" name="splitcount" class="input1" dataformat="num"></td>
				</tr>
				
				<tr>
					<td colspan="4" style="text-align:right"><button type="button" class="btn_etc" onclick="bkg0099_click()" name="btn_auto" id="btn_auto">Auto</button><button type="button" class="btn_etc" onclick="bkg0099_click()" name="btn_manual" id="btn_manual">Manual</button></th>
				</tr>
			</table>								
		</div>
		<!-- opus_design_inquiry(E) -->		
	</div>
     <!-- layout_vertical_2(E) -->		     
</div>
<!-- layout_wrap(E) -->
</div>

<!-- wrap_result(S) -->  
<div class="wrap_result">
	<div class="opus_design_grid">
		<h3 class="title_design mar_btm_8">Original</h3>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	
	<div class="opus_design_grid">
		<h3 class="title_design mar_btm_8">Split</h3>
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>

	<!-- layout_wrap(S) -->
		<table>
			<tr>
				<td width="550px" class="opus_design_grid">
					<script type="text/javascript">ComSheetObject('sheet3');</script>
				</td>
				<td> </td>
				<td width="550x" class="opus_design_grid">
					<script type="text/javascript">ComSheetObject('sheet4');</script>
				</td>
			</tr>
		</table>
<!-- 		<div class="layout_vertical_2  pad_rgt_4" style="width:480px">
			<div class="opus_design_grid">		
				<script type="text/javascript">ComSheetObject('sheet3');</script>		
			</div>
		</div>
		
		<div class="layout_vertical_2 pad_left_4" style="width:480px">
			<div class="opus_design_grid">		
				<script type="text/javascript">ComSheetObject('sheet4');</script>		
			</div>
		</div>
 -->		<!-- layout_vertical_2(E) -->
	<!-- layout_wrap(E) -->

	<div class="opus_design_data mar_top_12">
		<h3 class="title_design mar_btm_8">Special Cargo Application Split</h3>
		<table>
			<tr>
				<td>
					<button type="button" class="btn_etc" name="btn_dg" id="btn_dg">DG</button><!--  
					--><button type="button" class="btn_etc" name="btn_rf" id="btn_rf">RF</button><!--  
					--><button type="button" class="btn_etc" name="btn_ak" id="btn_ak">AK</button><!--  
					--><button type="button" class="btn_etc" name="btn_bb" id="btn_bb">BB</button>
				</td>
			</tr>
		</table>
	</div>
	<div class="opus_design_grid" width="550px">		
		<script type="text/javascript">ComSheetObject('sheet5');</script>		
	</div>
	<!-- opus_design_grid(E) -->
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" width="550px">		
		<script type="text/javascript">ComSheetObject('sheet6');</script>		
	</div>
</div>

<%if(!mainPage.equals("true")){	%></div><%}%>
<script>
	if(typeof(document.getElementById("title")) != "undefined"){
		document.getElementById("title").innerHTML = curTitle;
		document.body.className ="popup_bg";
	}
</script>
<%
if(!mainPage.equals("true")){
%>

<%
}
%>

</form>
 