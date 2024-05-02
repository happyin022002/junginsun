<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : EES_MNR_0095.jsp
*@FileTitle  : Total Loss Request
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/20
=========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.operationmanage.totallossmgt.event.EesMnr0095Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EesMnr0095Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//count of DB resultSet list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String rhqOfcCd         = "";
	String currOfcCd       = "";
	String currOfcEngNm     = "";
	Logger log = Logger.getLogger("com.clt.apps.PlanManage.PlanMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id    =	account.getUsr_id();
		strUsr_nm    = 	account.getUsr_nm();
		rhqOfcCd     = 	account.getRhq_ofc_cd();
		currOfcCd    = 	account.getOfc_cd();
		currOfcEngNm = 	account.getOfc_eng_nm();

		event = (EesMnr0095Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
	strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// adding logic to get data from sever when first loading
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
<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="file_seq"  id="file_seq">
<input type="hidden" name="mnr_sts_ref_no" id="mnr_sts_ref_no">
<input type="hidden" name="work_type" id="work_type" value="request">
<input type="hidden" name="respb_ofc_nm"  id="respb_ofc_nm" value=""><!-- For reference, No need for save -->
<input type="hidden" name="pagerows" id="pagerows">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--  
		--><button type="button" class="btn_normal" name="btn_New"  	id="btn_New">New</button><!--
		--><button type="button" class="btn_normal" name="btn_Save" 	id="btn_Save">Save</button><!--
		--><button type="button" class="btn_normal" name="btn_Delete" 	id="btn_Delete">Delete</button><!--
		--><button type="button" class="btn_normal" name="btn_Request" 	id="btn_Request">Request</button>	
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->
<!-- layout_wrap(S) -->
<div class="wrap_search_tab">
	<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<tbody>
					<colgroup>
						<col width="10" />
						<col width="120" />
						<col width="70" />
						<col width="120" />
						<col width="85" />
						<col width="120" />
						<col width="120" />
						<col width="85" />
						<col width="120" />
						<col width="120" />
						<col width="*" />
					</colgroup>
					<tr class="h23">
						<th>
							TLL No.
						</th>
						<td>
							<input type="text" name="search_ttl_lss_no" id="search_ttl_lss_no" style="width:130px;text-align:center" class="input1" dataformat="engup" maxlength="20" caption="TLL No" otherchar="-" required><!-- 
							 --><button type="button" name="ttl_lss_no_popup" id="ttl_lss_no_popup" class="input_seach_btn"></button><!-- 
							 --><input type="hidden" name="ttl_lss_no" id="ttl_lss_no" class="input2" readOnly="true">
						</td>
						<th>
							Responsible OFC
						</th>
						<td>
							<input type="text" name="respb_ofc_cd" id="respb_ofc_cd" style="width:80px;" class="input"  maxlength="6" dataformat="engup"><!-- 
							 --><button type="button" name="respb_ofc_cd_popup" id="respb_ofc_cd_popup" class="input_seach_btn" onClick="openPopup('cust_cd')"></button>
						</td>
						<th>
							REQ OFC
						</th>
						<td>
							<input type="text" name="rqst_ofc_cd" id="rqst_ofc_cd" style="width:80px;" class="input2" readOnly="true">
						</td>
						<th>
							REQ DT
						</th>
						<td>
							<input type="text" name="rqst_dt" id="rqst_dt" style="width:80px;text-align:center" class="input2" dataformat="ymd" maxlength="10" readOnly="true">
						</td>
						<th>
							Status
						</th>
						<td>
							<script type="text/javascript">ComComboObject('ttl_lss_sts_cd', 1, 135, 1, 0);</script>
						</td>
						<td></td>
					</tr>
					<tr class="h23">
						<th>
							Main Reason
						</th>
						<td>
							<script type="text/javascript">ComComboObject('ttl_lss_rsn_cd', 1, 100, 1, 1);</script>
						</td>
						<th>
							Sub Reason
						</th>
						<td>
							<script type="text/javascript">ComComboObject('ttl_lss_dtl_rsn_cd', 1, 100, 1, 0);</script>
						</td>
						<th>
							TLL DT
						</th>
						<td>
	       						<input type="text" name="ttl_lss_dt" id="ttl_lss_dt" style="width:80px;" class="input" dataformat="ymd"><!-- 
	       						 --><button type="button" class="calendar ir" name="ttl_lss_dt_cal" id="ttl_lss_dt_cal"></button>
						</td>
						<th>
							APP OFC
						</th>
						<td>
							<script type="text/javascript">ComComboObject('apro_ofc_cd', 1, 100, 1, 1);</script>
						</td>
						<td colspan="3"></td>
					</tr>
				</tbody>
			</table>
		</div>
	<!-- opus_design_inquiry(E) -->
	</div>
	
	<!-- layout_wrap(E) -->
	<div class="wrap_result">
	<!-- opus_tab_btn(S) -->
	<div class="opus_design_tab">
		<script type="text/javascript">ComTabObject('tab1')</script>
	</div>
	<!-- opus_tab_btn(E) -->
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear" id="tabLayer"  style="display:inline">
		<div class="opus_design_btn">
				<button type="button" class="btn_normal" name="btn_t1EQAdd" id="btn_t1EQAdd">EQ Add</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_t1RowDel" id="btn_t1RowDel">Row Delete</button>
		</div>
		<script type="text/javascript">ComSheetObject('t1sheet1');</script>
			<table style="width:800px" class="mar_top_8 mar_btm_8">
<!-- 				<tbody> -->
<!-- 					<colgroup> -->
<!-- 						<col width="75" /> -->
<!-- 						<col width="150" /> -->
<!-- 						<col width="150" /> -->
<!-- 						<col width="150" /> -->
<!-- 						<col width="150" /> -->
<!-- 						<col width="150" /> -->
<!-- 						<col width="*" /> -->
<!-- 					</colgroup> -->
<!-- 					<tr> -->
<!-- 						<th> -->
<!-- 							Loss Total -->
<!-- 						</th> -->
<!-- 						<td> -->
<!-- 							<input type="text" name="t1LossTotal" id="t1LossTotal" style="width:150px;text-align:right;" class="input2" dataformat="float" maxlength="13" pointcount="2" readOnly="true"> -->
<!-- 						</td> -->
<!-- 						<th> -->
<!-- 							Recovery Plan Total -->
<!-- 						</th> -->
<!-- 						<td> -->
<!-- 							<input type="text" name="t1RecPlnTotal" id="t1RecPlnTotal" style="width:150px;text-align:right;" class="input2" dataformat="float" maxlength="13" pointcount="2"  readOnly="true"> -->
<!-- 						</td> -->
<!-- 						<th> -->
<!-- 							Balance Total -->
<!-- 						</th> -->
<!-- 						<td> -->
<!-- 							<input type="text" name="t1BalanceTotal" id="t1BalanceTotal" style="width:150px;text-align:right;" class="input2" dataformat="float" maxlength="13" pointcount="2"  readOnly="true"> -->
<!-- 						</td> -->
<!-- 					</tr> -->
<!-- 				</tbody> -->
			</table>

	</div>
	
	<!-- opus_design_grid(E) -->
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear"  name="tabLayer" id="tabLayer"  style="display:none">
		<div class="opus_design_btn">
<!-- 			<button type="button" class="btn_normal" name="btn_t2RowAdd" id="btn_t2RowAdd">Row Add</button> -->
			<button type="button" class="btn_normal" name="btn_t2RowDel" id="btn_t2RowDel">Row Delete</button>
		</div>
		<script type="text/javascript">ComSheetObject('t2sheet1');</script>
		<div class="grid_option_left">
			<table style="width:800px" class="mar_top_8 mar_btm_8">
<!-- 				<tbody> -->
<!-- 					<colgroup> -->
<!-- 						<col width="75" /> -->
<!-- 						<col width="150" /> -->
<!-- 						<col width="150" /> -->
<!-- 						<col width="150" /> -->
<!-- 						<col width="150" /> -->
<!-- 						<col width="150" /> -->
<!-- 						<col width="*" /> -->
<!-- 					</colgroup> -->
<!-- 					<tr> -->
<!-- 						<th> -->
<!-- 							Loss Total -->
<!-- 						</th> -->
<!-- 						<td> -->
<!-- 							<input type="text" name="t2LossTotal" id="t2LossTotal" style="width:150px;text-align:right;" class="input2" dataformat="float" maxlength="13" pointcount="2"   readOnly="true"> -->
<!-- 						</td> -->
<!-- 						<th> -->
<!-- 							Recovery Plan Total -->
<!-- 						</th> -->
<!-- 						<td> -->
<!-- 							<input type="text" name="t2RecPlnTotal" id="t2RecPlnTotal" style="width:150px;text-align:right;" class="input2" dataformat="float" maxlength="13" pointcount="2"  readOnly="true"> -->
<!-- 						</td> -->
<!-- 						<th> -->
<!-- 							Balance Total -->
<!-- 						</th> -->
<!-- 						<td> -->
<!-- 							<input type="text" name="t2BalanceTotal" id="t2BalanceTotal" style="width:150px;text-align:right;" class="input2" dataformat="float" maxlength="13" pointcount="2"   readOnly="true"> -->
<!-- 						</td> -->
<!-- 					</tr> -->
<!-- 				</tbody> -->
			</table>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
	
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear" name="tabLayer" id="tabLayer"  style="display:none">
		
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_t3RowDel" id="btn_t3RowDel">Row Delete</button>
		</div>
		
		<script type="text/javascript">ComSheetObject('t3sheet1');</script>
		
		<div class="grid_option_left">
           <table style="width:800px" class="mar_top_8 mar_btm_8">
<!-- 				<tbody> -->
<!-- 					<colgroup> -->
<!-- 						<col width="75" /> -->
<!-- 						<col width="150" /> -->
<!-- 						<col width="150" /> -->
<!-- 						<col width="150" /> -->
<!-- 						<col width="150" /> -->
<!-- 						<col width="150" /> -->
<!-- 						<col width="*" /> -->
<!-- 					</colgroup> -->
<!-- 					<tr> -->
<!-- 						<th> -->
<!-- 							Loss Total -->
<!-- 						</th> -->
<!-- 						<td> -->
<!-- 							<input type="text" name="t3LossTotal" id="t3LossTotal" style="width:150px;text-align:right;" class="input2" dataformat="float" maxlength="13" pointcount="2" readOnly="true"> -->
<!-- 						</td> -->
<!-- 						<th> -->
<!-- 							Recovery Plan Total -->
<!-- 						</th> -->
<!-- 						<td> -->
<!-- 							<input type="text" name="t3RecPlnTotal" id="t3RecPlnTotal" style="width:150px;text-align:right;" class="input2" dataformat="float" maxlength="13" pointcount="2" readOnly="true"> -->
<!-- 						</td> -->
<!-- 						<th> -->
<!-- 							Balance Total -->
<!-- 						</th> -->
<!-- 						<td> -->
<!-- 							<input type="text" name="t3BalanceTotal" id="t3BalanceTotal" style="width:150px;text-align:right;" class="input2" dataformat="float" maxlength="13" pointcount="2" readOnly="true"> -->
<!-- 						</td> -->
<!-- 						<td>					 -->
<!-- 						</td> -->
<!-- 					</tr> -->
<!-- 				</tbody> -->
			</table>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
	
	
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear"  name="tabLayer" id="tabLayer"  style="display:none">
		
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_t4RowDel" id="btn_t4RowDel">Row Delete</button>
		</div>
		<script type="text/javascript">ComSheetObject('t4sheet1');</script>
		
		<div class="grid_option_left">
            <table style="width:800px" class="mar_top_8 mar_btm_8">
<!-- 				<tbody> -->
<!-- 					<colgroup> -->
<!-- 						<col width="75" /> -->
<!-- 						<col width="150" /> -->
<!-- 						<col width="150" /> -->
<!-- 						<col width="150" /> -->
<!-- 						<col width="150" /> -->
<!-- 						<col width="150" /> -->
<!-- 						<col width="*" /> -->
<!-- 					</colgroup> -->
<!-- 					<tr> -->
<!-- 						<th> -->
<!-- 							Loss Total -->
<!-- 						</th> -->
<!-- 						<td> -->
<!-- 							<input type="text" name="t4LossTotal" id="t4LossTotal" style="width:150px;text-align:right;" class="input2" dataformat="float" maxlength="13" pointcount="2"  readOnly="true"> -->
<!-- 						</td> -->
<!-- 						<th> -->
<!-- 							Recovery Plan Total -->
<!-- 						</th> -->
<!-- 						<td> -->
<!-- 							<input type="text" name="t4RecPlnTotal" id="t4RecPlnTotal" style="width:150px;text-align:right;" class="input2" dataformat="float" maxlength="13" pointcount="2" readOnly="true"> -->
<!-- 						</td> -->
<!-- 						<th> -->
<!-- 							Balance Total -->
<!-- 						</th> -->
<!-- 						<td> -->
<!-- 							<input type="text" name="t4BalanceTotal" id="t4BalanceTotal" style="width:150px;text-align:right;" class="input2" dataformat="float" maxlength="13" pointcount="2"  readOnly="true"> -->
<!-- 						</td> -->
<!-- 						<td>				 -->
							
<!-- 						</td>	 -->
<!-- 					</tr> -->
<!-- 				</tbody> -->
			</table>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
	
	
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear"  name="tabLayer" id="tabLayer"  style="display:none">
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_t5RowDel" id="btn_t5RowDel">Row Delete</button>
		</div>
		<script type="text/javascript">ComSheetObject('t5sheet1');</script>
		<div class="grid_option_left">
           <table style="width:800px" class="mar_top_8 mar_btm_8">
<!-- 				<tbody> -->
<!-- 					<colgroup> -->
<!-- 					<col width="75" /> -->
<!-- 					<col width="150" /> -->
<!-- 					<col width="150" /> -->
<!-- 					<col width="150" /> -->
<!-- 					<col width="150" /> -->
<!-- 					<col width="150" /> -->
<!-- 					<col width="*" /> -->
<!-- 				</colgroup> -->
<!-- 				<tbody> -->
<!-- 					<tr> -->
<!-- 						<th> -->
<!-- 							Loss Total -->
<!-- 						</th> -->
<!-- 						<td> -->
<!-- 							<input type="text" name="t5LossTotal" id="t5LossTotal" style="width:150px;text-align:right;" class="input2" dataformat="float" maxlength="13" pointcount="2"  readOnly="true"> -->
<!-- 						</td>				 -->
<!-- 						<th> -->
<!-- 							Recovery Plan Total -->
<!-- 						</th> -->
<!-- 						<td> -->
<!-- 							<input type="text" name="t5RecPlnTotal" id="t5RecPlnTotal" style="width:150px;text-align:right;" class="input2" dataformat="float" maxlength="13" pointcount="2" readOnly="true"> -->
<!-- 						</td> -->
<!-- 						<th>Balance Total</th> -->
<!-- 						<td> -->
<!-- 							<input type="text" name="t5BalanceTotal" id="t5BalanceTotal" style="width:150px;text-align:right;" class="input2" dataformat="float" maxlength="13" pointcount="2"  readOnly="true"> -->
<!-- 						</td> -->
<!-- 					</tr> -->
<!-- 				</tbody> -->
			</table>
		</div>
	</div>
	<!-- opus_design_grid(E) -->

	<!-- layout_wrap (S) -->
	<div class="layout_wrap">
	<div class="layout_vertical_2" style="width: 68%">
		 <h3 class="title_design">Total Loss History</h3>
		 <!-- opus_design_grid(S) -->
		 <div class="opus_design_grid">
		 <div class="opus_design_btn" style="margin-top:-20px">
		    <button type="button" class="btn_accent" name="btn_RowAdd2" id="btn_RowAdd2">Row Add</button>
		    <button type="button" class="btn_normal" name="btn_RowDel2" id="btn_RowDel2">Row Delete</button>
		 </div>
		 <script type="text/javascript">ComSheetObject('sheet2');</script>
		 </div>
		 <!-- opus_design_grid(e) -->
	</div>
			
	<div class="layout_vertical_2" style="width: 2%">
		<table><tr><td>&nbsp;</td></tr></table>
	</div>
		     
	<div class="layout_vertical_2" style="width: 30%">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
	<div class="opus_design_btn">
	<button type="button" class="btn_normal" name="btn_FileAdd" id="btn_FileAdd">File Add</button>
	<button type="button" class="btn_accent" name="btn_FileDel" id="btn_FileDel">File Delete</button>
	</div>
	<script type="text/javascript">ComSheetObject('sheet3');</script>
	</div>
	<!-- opus_design_grid(e) -->
	</div>
	</div>
	<!-- layout_wrap (e) -->
</div>
<div style="display:none">
	<script type="text/javascript">ComUploadObject('upload1', '<%=session.getId()%>');</script>
</div>
</form>
