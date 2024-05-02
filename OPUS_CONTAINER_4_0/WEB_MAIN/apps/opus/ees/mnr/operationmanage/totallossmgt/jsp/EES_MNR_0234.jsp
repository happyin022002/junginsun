<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0234.jsp
*@FileTitle  : Total Loss Detail Pop Up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/22
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.operationmanage.totallossmgt.event.EesMnr0234Event"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0234Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Occurred error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//Row count of retrieved database data

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String rhqOfcCd         = "";
	String currOfcCd       = "";
	String currOfcEngNm     = "";
	String ttlLssNo= StringUtil.xssFilter(request.getParameter("ttl_lss_no"));
	String rqstOfcCd= StringUtil.xssFilter(request.getParameter("rqst_ofc_cd"));

	String aproOfcCd= StringUtil.xssFilter(request.getParameter("apro_ofc_cd"));
	String respbOfcCd= StringUtil.xssFilter(request.getParameter("respb_ofc_cd"));
	String ttlLssDt= StringUtil.xssFilter(request.getParameter("ttl_lss_dt"));
	String rqstDt= StringUtil.xssFilter(request.getParameter("rqst_dt"));
	String ttlLssStsNm= StringUtil.xssFilter(request.getParameter("ttl_lss_sts_nm"));
	String ttlLssRsnNm= StringUtil.xssFilter(request.getParameter("ttl_lss_rsn_nm"));
	String ttlLssDtlRsnNm= StringUtil.xssFilter(request.getParameter("ttl_lss_dtl_rsn_nm"));


	Logger log = Logger.getLogger("com.clt.apps.operationmanage.totallossmgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id    =	account.getUsr_id();
		strUsr_nm    = 	account.getUsr_nm();
		rhqOfcCd     = 	account.getRhq_ofc_cd();
		currOfcCd    = 	account.getOfc_cd();
		currOfcEngNm = 	account.getOfc_eng_nm();

		event = (EesMnr0234Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//Extracting retrieved data from server on load screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
	var currOfcCd = "<%=currOfcCd.trim() %>";
	var usrId     = "<%=strUsr_id.trim()%>";

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<script type="text/javascript">ComSheetObject('sheet1');</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="work_type" value="collection" id="work_type" />


<!-- Variable for existing logic  -->
<input type="hidden" name="self_ofc" value="<%=currOfcCd%>">
<input type="hidden" name="ttl_lss_no" value="<%=ttlLssNo%>">
<input type="hidden" name="search_ttl_lss_no" value="<%=ttlLssNo%>">
<input type="hidden" name="in_rqst_ofc_cd" value="<%=rqstOfcCd%>">
<input type="hidden" name="rqst_ofc_cd" value="<%=rqstOfcCd%>">
<input type="hidden" name="rqst_dt" value="" id="rqst_dt" />
<input type="hidden" name="ttl_lss_sts_cd" value="" id="ttl_lss_sts_cd" />
<input type="hidden" name="ttl_lss_rsn_cd" value="" id="ttl_lss_rsn_cd" />
<input type="hidden" name="ttl_lss_dtl_rsn_cd" value="" id="ttl_lss_dtl_rsn_cd" />
<input type="hidden" name="ttl_lss_dt" value="" id="ttl_lss_dt" />
<input type="hidden" name="apro_ofc_cd" value="" id="apro_ofc_cd" />
<input type="hidden" name="file_seq" id="file_seq" />
<input type="hidden" name="mnr_sts_ref_no" id="mnr_sts_ref_no" />
<input type="hidden" name="respb_ofc_nm" value="" id="respb_ofc_nm" />
<input type="hidden" name="com_mrdArguments" id="com_mrdArguments" />
<input type="hidden" name="com_mrdPath" id="com_mrdPath" />
<input type="hidden" name="com_mrdBodyTitle" id="com_mrdBodyTitle" />

	<!-- page_title_area(S) -->
	<div class="layer_popup_title">
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Total Loss Detail</span></h2>
		<!-- page_title(E) -->
			
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
            <button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->	
	</div>
	</div>
	<!-- page_title_area(E) -->


<!-- page_title_area(E) -->
<!-- wrap_search(S) -->
<div class="layer_popup_contents">
<div class="wrap_search_tab">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry wFit">
	<table>
		<tbody>
			<colgroup>
				<col width="80" />
				<col width="150" />
				<col width="110" />
				<col width="100" />
				<col width="60" />
				<col width="100" />
				<col width="60" />
				<col width="100" />
				<col width="80" />
				<col width="*" />
			</colgroup>
			<tr class="h23">
				<th>TLL No.</th>
				<td><input type="text" name="ttl_lss_no_text" style="width:125px;text-align:center" class="input2" maxlength="20" value="<%=ttlLssNo%>" readonly id="ttl_lss_no_text" /></td>
				<th>Responsible OFC</th>
				<td><input type="text" name="respb_ofc_cd" style="width:100px;" class="input" maxlength="6" dataformat="engup" value="<%=respbOfcCd%>" id="respb_ofc_cd" /></td>
				<th>REQ OFC</th>
				<td><input type="text" name="rqst_ofc_cd_nm" style="width:80px;" class="input2" value="<%=rqstOfcCd%>" readonly="true" id="rqst_ofc_cd_nm" /></td>
				<th>REQ DT</th>
				<td><input type="text" name="rqst_dt_text" style="width:80px;text-align:center" class="input2" value="<%=rqstDt%>" dataformat="ymd" readonly="true" id="rqst_dt_text" /></td>
				<th>Status</th>
				<td><input type="text" name="ttl_lss_sts_cd_nm" style="width:120px;" class="input2" value="<%=ttlLssStsNm%>" readonly="true" id="ttl_lss_sts_cd_nm" /></td>
			</tr>
			</table>
	<table class="search">
			<colgroup>
				<col width="80" />
				<col width="150" />
				<col width="110" />
				<col width="260" />
				<col width="60" />
				<col width="100" />
				<col width="80" />
				<col width="*" />
			</colgroup>
			<tr class="h23">
				<th>Main Reason</th>
				<td><input type="text" name="ttl_lss_rsn_cd_nm" style="width:125px;" class="input2" value="<%=ttlLssRsnNm%>" readonly="true" id="ttl_lss_rsn_cd_nm" /></td>
				<th>Sub Reason</th>
				<td><input type="text" name="ttl_lss_dtl_rsn_cd_nm" style="width:260px;" class="input2" value="<%=ttlLssDtlRsnNm%>" readonly="true" id="ttl_lss_dtl_rsn_cd_nm" /></td>
				<th>TLL DT</th>
				<td><input type="text" name="ttl_lss_dt_text" style="width:80px;text-align:center" class="input2" value="<%=ttlLssDt%>" readonly="true" id="ttl_lss_dt_text" /></td>
				<th>APP OFC</th>
				<td><input type="text" name="apro_ofc_cd_nm" style="width:60px;text-align:center" class="input2" value="<%=aproOfcCd%>" readonly="true" id="apro_ofc_cd_nm" /></td>
			</tr>
		</tbody>
	</table>
</div>
<!-- opus_design_inquiry(E) -->
</div>
<!-- wrap_search(E) -->

<!-- wrap_result(S) -->

<!-- opus_tab_btn(S) -->
<div class="opus_design_tab sm" style="margin-bottom:0!important;">
			<script type="text/javascript">ComTabObject('tab1')</script>
		</div>

<div class="wrap_result">
<div class="layout_wrap">
<div class="layout_vertical_2 pad_rgt_8" >
<!-- opus_tab_btn(E) -->
<div id="tabLayer">
<!-- opus_design_grid(S) -->
<div class="opus_design_grid">
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn" style="margin-bottom:6px;">
	<span  class="grid_option_left"><h3 > &nbsp;</h3></span>
		<button class="btn_accent" name="btn_t1InvoicePreview" id="btn_t1InvoicePreview" type="button" style="display:none">Invoice Preview</button><!--
	
	--></div>
	<!-- opus_design_btn (E) -->
	<script type="text/javascript">ComSheetObject('t1sheet1');</script>
</div>
<!-- opus_design_grid(E) -->
</div>
<div id="tabLayer" style="display:none">
<!-- opus_design_grid(S) -->
<div class="opus_design_grid">
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn" style="margin-bottom:6px;">
	<span  class="grid_option_left"><h3 > &nbsp;</h3></span>
		<button class="btn_accent" name="btn_t2InvoicePreview" id="btn_t2InvoicePreview	" type="button" style="display:none">Invoice Preview</button><!--
	--></div>
	<!-- opus_design_btn (E) -->
	<script type="text/javascript">ComSheetObject('t2sheet1');</script>
</div>
<!-- opus_design_grid(E) -->
</div>
<div id="tabLayer" style="display:none">
<!-- opus_design_grid(S) -->
<div class="opus_design_grid">
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn" style="margin-bottom:6px;">
	<span  class="grid_option_left"><h3 > &nbsp;</h3></span>
		<button class="btn_accent" name="btn_t3InvoicePreview" id="btn_t3InvoicePreview" type="button" style="display:none">Invoice Preview</button><!--
	--></div>
	<!-- opus_design_btn (E) -->
	<script type="text/javascript">ComSheetObject('t3sheet1');</script>
</div>
<!-- opus_design_grid(E) -->
</div>
<div id="tabLayer" style="display:none">
<!-- opus_design_grid(S) -->
<div class="opus_design_grid">
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn" style="margin-bottom:6px;">
	<span  class="grid_option_left"><h3 > &nbsp;</h3></span>
		<button class="btn_accent" name="btn_t4InvoicePreview" id="btn_t4InvoicePreview" type="button" style="display:none">Invoice Preview</button><!--
	--></div>
	<!-- opus_design_btn (E) -->
	<script type="text/javascript">ComSheetObject('t4sheet1');</script>
</div>
<!-- opus_design_grid(E) -->
</div>
<div id="tabLayer" style="display:none">
<!-- opus_design_grid(S) -->
<div class="opus_design_grid">
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn" style="margin-bottom:6px;">
	<span  class="grid_option_left"><h3 > &nbsp;</h3></span>
		<button class="btn_accent" name="btn_t5InvoicePreview" id="btn_t5InvoicePreview" type="button" style="display:none">Invoice Preview</button><!--
	--></div>
	<!-- opus_design_btn (E) -->
	<script type="text/javascript">ComSheetObject('t5sheet1');</script>
</div>
<!-- opus_design_grid(E) -->
</div>
</div>

<!-- <div style="overflow-y:scroll; width:100%; height:220px;"> -->

<div class="layout_vertical_2" style="width: 50%;" >
         <div class="opus_design_grid ">
         	<span  class="grid_option_left"><h3 class="title_design"> Total Loss Collection &amp; Adjustment</h3></span>
         	<div class="opus_design_btn" style="margin-bottom:3px;">
				<table>
					<tbody>
						<tr>
							<td style="width:120px; text-align:left;"><b>Collection Total</b></td>
							<td style="width:120px;"><input type="text" name="tCollectionTotal" id="tCollectionTotal" style="width:120px;text-align:right;" class="input2" dataformat="float" maxlength="13" pointcount="2" caption="실수(최대최소)" readOnly="true"></td>			
						</tr>
					</tbody>
				</table>
			</div>
             <script type="text/javascript">ComSheetObject('sheet3');</script>
         </div>
         <!-- opus_design_grid(e) -->
     </div>
</div>

<!-- opus_design_inquiry(E) -->
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry wFit" style="margin-top:20px">
	<table>
<!-- 		<tbody> -->
<!-- 			<colgroup> -->
<!-- 				<col width="10" /> -->
<!-- 				<col width="100" /> -->
<!-- 				<col width="10" /> -->
<!-- 				<col width="100" /> -->
<!-- 				<col width="10" /> -->
<!-- 				<col width="100" /> -->
<!-- 				<col width="*" /> -->
<!-- 			</colgroup> -->
<!-- 			<tr> -->
<!-- 				<th>Loss Total</th> -->
<!-- 				<td><input type="text" name="t1LossTotal" style="width:120px;text-align:right;" class="input2" dataformat="float" maxlength="13" pointcount="2" caption="Real number(MaxMin)" readonly="true" id="t1LossTotal" /> </td> -->
<!-- 				<th>Recovery Plan Total</th> -->
<!-- 				<td><input type="text" name="t1RecPlnTotal" style="width:120px;text-align:right;" class="input2" dataformat="float" maxlength="13" pointcount="2" caption="Real number(MaxMin)" readonly="true" id="t1RecPlnTotal" /> </td> -->
<!-- 				<th>Balance Total</th> -->
<!-- 				<td><input type="text" name="t1BalanceTotal" style="width:120px;text-align:right;" class="input2" dataformat="float" maxlength="13" pointcount="2" caption="Real number(MaxMin)" readonly="true" id="t1BalanceTotal" /> </td> -->
<!-- 				<td></td> -->
<!-- 			</tr> -->
<!-- 		</tbody> -->
	</table>	
</div>

<div class="layout_wrap">  
     <div class="layout_vertical_2 pad_rgt_12" style="width: 70%">
     	<span  class="grid_option_left"><h3 class="title_design">Total Loss History</h3></span>
         <!-- opus_design_grid(S) -->
         <div class="opus_design_grid">
    		<script type="text/javascript">ComSheetObject('sheet4');</script>
         </div>
         <!-- opus_design_grid(e) -->
     </div>
      <div class="layout_vertical_2" style="width: 30%">
         <span><h3>&nbsp</h3></span>
         <!-- opus_design_grid(S) -->
         <div class="opus_design_grid">
             <script type="text/javascript">ComSheetObject('sheet5');</script>
         </div>
         <!-- opus_design_grid(e) -->
     </div>
 </div>

<!-- opus_design_grid(E) -->
</div>
</div>

<div style="display:none">
<!-- wrap_result(E) -->
<script type="text/javascript">ComUploadObject('upload1', '<%=session.getId()%>',0,0);</script>
</div>
</form>