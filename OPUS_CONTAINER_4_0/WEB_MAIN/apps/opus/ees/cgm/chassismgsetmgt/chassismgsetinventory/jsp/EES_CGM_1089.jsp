<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_1089.jsp
*@FileTitle  : General Inventory (General Inventory Graphic)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/11
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.event.EesCgm1089Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.io.HttpUtil"%>

<%
	EesCgm1089Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id   = "";
	String strUsr_nm   = "";
	String strOfc_id   = "";
	Logger log = Logger.getLogger("com.clt.apps.ChassisMgsetMgt.ChassisMgsetInventory");
	String xml = HttpUtil.makeXML(request,response);
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_id = account.getOfc_cd();
		event = (EesCgm1089Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	} catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript" src="/opuscntr/rpt/script/common_rd.js"></script>
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if

		loadPage();
	}
</script>

<form name="form2">
<input type="hidden" name="sXml" value="<%=xml.replace("\"","'") %>" id="sXml" />
</form>
<form name="form">
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="pagerows" id="pagerows" />
<!-- developer working -->
<input type="hidden" name="eq_knd_cd" id="eq_knd_cd" />
<input type="hidden" name="intg_cd_id" id="intg_cd_id" />
<input type="hidden" name="yd_cd" id="yd_cd" />
<input type="hidden" name="loc_cd" id="loc_cd" />
<input type="hidden" name="eq_orz_cht_chktype" id="eq_orz_cht_chktype" />
<input type="hidden" name="eq_orz_cht_rcc_cd" id="eq_orz_cht_rcc_cd" />
<input type="hidden" name="eq_orz_cht_lcc_cd" id="eq_orz_cht_lcc_cd" />
<input type="hidden" name="eq_orz_cht_scc_cd" id="eq_orz_cht_scc_cd" />
<input type="hidden" name="s_usr_id" value="<%=strUsr_id %>" id="s_usr_id" />
<input type="hidden" name="s_ofc_id" value="<%=strOfc_id %>" id="s_ofc_id" />
<input type="hidden" name="location" id="location" />
<input type="hidden" name="head_eq_tpsz_cd">
<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_new" id="btn_new" type="button">New</button><!--
		--><button class="btn_normal" name="btn_downexcel" id="btn_downexcel" type="button">Down Excel</button><!--
		--><button class="btn_normal" name="btn_print" id="btn_print" type="button">Print</button><!--
		--></div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location"><span id="navigation"></span></div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="90" />				
				<col width="160" />				
				<col width="90" />				
				<col width="160" />				
				<col width="160" />				
				<col width="60" />				
				<col width="150" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
		   			<th>Location </th>
					<td>
						<script type="text/javascript">ComComboObject('combo_location', 1, 52, 0, 1,0, true);</script><input type="text" name="crnt_loc_cd" id="crnt_loc_cd" dataformat="engup" style="width:63px;ime-mode:disabled" class="input1" value="" maxlength="5"><button type="button" id="btns_crnt_loc_cd" name="btns_crnt_loc_cd" class="input_seach_btn"></button>
					</td>
					<th>Yard </th>
					<td>
						<input type="text" name="crnt_yd_cd" id="crnt_yd_cd" dataformat="engup" style="width:161px;ime-mode:disabled" class="input" value="" id="crnt_yd_cd" /><button type="button" id="btns_crnt_yd_cd" name="btns_crnt_yd_cd" class="input_seach_btn"></button>
					</td>
					<td>Include 'NP' <input type="checkbox" name="include_np" value="" class="trans" id="include_np" /></td>
					<td></td>
					<td class="sm pad_left_4"><input type="radio" name="doc_type" value="" class="trans" checked id="doc_type1" onclick="doc_type_change()" /><label for="doc_type1">Summary</label><input type="radio" name="doc_type" value="" class="trans" id="doc_type2" onclick="doc_type_change()" /><label for="doc_type2">Graphic</label></td>
					<td></td>
		   		</tr>
		   </tbody>
		</table>
		<table>
			<colgroup>
				<col width="90" />				
				<col width="160" />				
				<col width="90" />				
				<col width="400" />				
				<col width="100" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
		   			<th>Active St.</th>
					<td><script type="text/javascript">ComComboObject('aciac_div_cd', 1, 144, 0, 0, 0, true);</script></td>
					<th>Co-Op Pool</th>
					<td><script type="text/javascript">ComComboObject('chss_pool_cd', 1, 276, 0, 0, 0, true);</script></td>
					<th>Staying Days</th>
					<td><input type="text" name="staying_days" dataformat="num" style="width:65px;text-align:right;ime-mode:disabled" class="input" value="" id="staying_days" /> or Over</td>
		   		</tr>
		   </tbody>
		</table>
		<table>
			<colgroup>
				<col width="90" />				
				<col width="160" />				
				<col width="90" />				
				<col width="160" />				
				<col width="90" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
		   			<th>1. Group By</th>
					<td><script type="text/javascript">ComComboObject('group1', 1, 144, 0, 0, 0, true);</script></td>
					<th>2. Group By</th>
					<td><script type="text/javascript">ComComboObject('group2', 1, 144, 0, 0, 0, true);</script></td>
					<th>3. Group By</th>
					<td><script type="text/javascript">ComComboObject('group3', 1, 144, 0, 0, 0, true);</script></td>
		   		</tr>
		   </tbody>
		</table>
		<table>
			<colgroup>
				<col width="90" />				
				<col width="160" />				
				<col width="90" />				
				<col width="160" />				
				<col width="90" />				
				<col width="160" />				
				<col width="90" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
		   			<th>Type/Size</th>
					<td><script type="text/javascript">ComComboObject('eq_tpsz_cd', 1, 144, 0, 0, 0, true);</script></td>
					<th>Lease Term</th>
					<td><script type="text/javascript">ComComboObject('agmt_lstm_cd', 1, 144, 0, 0, 0, true);</script></td>
					<th>Lessor</th>
					<td><input type="text" name="vndr_seq" dataformat="eng" style="width:115px;ime-mode:disabled" class="input" value="" id="vndr_seq" /><button type="button" id="btns_vndr" name="btns_vndr" class="input_seach_btn"></button></td>
					<th>MVMT Status</th>
					<td><script type="text/javascript">ComComboObject('chss_mvmt_sts_cd', 1, 115, 0, 0, 0, true);</script></td>
		   		</tr>
		   </tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result" style="height:500px">
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="sheetLayer" name="sheetLayer">
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_RD rd_hidden" id="chartLayer" name="chartLayer" >
		<script type="text/javascript">rdViewerObject();</script>	
	</div>
	<!-- opus_design_grid(E) -->
</div>

</form>