<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : EES_MNR_0098.jsp
*@FileTitle  : Total Loss Collection & Inquiry 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/21
=========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.operationmanage.totallossmgt.event.EesMnr0098Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0098Event  event = null;				//PDTO(Data Transfer Object including Parameters)
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
	Logger log = Logger.getLogger("com.clt.apps.operationmanage.totallossmgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id    =	account.getUsr_id();
		strUsr_nm    = 	account.getUsr_nm();
		rhqOfcCd     = 	account.getRhq_ofc_cd();
		currOfcCd    = 	account.getOfc_cd();
		currOfcEngNm = 	account.getOfc_eng_nm();

		event = (EesMnr0098Event)request.getAttribute("Event");
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
	var rhqOfcCd  = "<%=rhqOfcCd.trim()%>";

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
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="work_type" value="collection">

<!-- for existing source  -->
<input type="hidden" name="log_ofc_cd" value="<%=currOfcCd%>">
<input type="hidden" name="self_ofc" value="<%=currOfcCd%>">
<input type="hidden" name="rhq_ofc_cd" value="<%=rhqOfcCd%>">
<input type="hidden" name="ttl_lss_no" value="">
<input type="hidden" name="search_ttl_lss_no" value="">
<input type="hidden" name="rqst_ofc_cd" value="">
<input type="hidden" name="rqst_dt" value="">
<input type="hidden" name="ttl_lss_sts_cd" value="">
<input type="hidden" name="ttl_lss_dt" value="">
<input type="hidden" name="apro_ofc_cd" value="">
<input type="hidden" name="file_seq">
<input type="hidden" name="mnr_sts_ref_no">
<input type="hidden" name="respb_ofc_nm" value=""><!-- For reference, No need for save -->
<input type="hidden" name="com_mrdArguments">
<input type="hidden" name="com_mrdPath">
<input type="hidden" name="com_mrdBodyTitle">
<input type="hidden" name="ttl_lss_cfm_dt">
<input type="hidden" name="combo_ttl_lss_cmpl_cd">

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
		 --><button type="button" class="btn_normal" name="btn_Delete" 	id="btn_Delete">Delete</button><!--
		 --><button type="button" class="btn_normal" name="btn_Save" 	id="btn_Save">Save</button><!--
		 --><button type="button" class="btn_normal" name="btn_Complete" 	id="btn_Complete">Complete</button>	
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->


<!-- layout_wrap (S) -->
<div class="wrap_search">
	<div class="layout_wrap">
	     <div class="layout_flex_fixed" style="width:350px">
	           	<table style="height:150px">
					<tbody>
						<tr>
							<td style="width:100px;">
								<script type="text/javascript">ComComboObject('in_search_dt_tp',1, 100 , 1,1)</script>
							</td>
							<td>
								<input required type="text" name="in_st_dt" id="in_st_dt" dataformat="ymd"    caption="from date"        maxlength="10"  size="10"  cofield="in_end_dt" value="" class="input1">
	      						~ <!-- 
	      						 --><input required type="text" name="in_end_dt" id="in_end_dt" dataformat="ymd"    caption="to date"        maxlength="10"  size="10"  cofield="in_st_dt" class="input1"><!-- 
	      						  --><button type="button" class="calendar ir" name="btn_period" id="btn_period"></button>
	      					</td>
						</tr>
						<tr>
							<th>
								TLL No.
							</th>
							<td>
								<input type="text" name="in_ttl_lss_no" id="in_ttl_lss_no" style="width:192px;text-align:Left" class="input" dataformat="engup" maxlength="400" otherchar="-"><!-- 
								 --><button type="button"  name="btn_ttl_lss_no_multi"  id="btn_ttl_lss_no_multi" class="multiple_inq ir"></button>
							</td>
						</tr>
						<tr>
							<td>
								<script type="text/javascript">ComComboObject('in_ofc_cd_tp',1, 100 , 1,1)</script>
							</td>
							<td>
								<input type="text" name="in_rqst_ofc_cd" style="width:192px;" value="<%=currOfcCd%>" class="input2" dataformat="engup" readOnly>
							</td>
						</tr>
						<tr>
							<th>
								Status
							</th>
							<td>
								<script type="text/javascript">ComComboObject('in_status_tp',1, 100 , 1,1)</script>
							</td>
						</tr>
						<tr>
							<th>
								EQ No.
							</th>
							<td>
								<input name="in_rqst_eq_no" type="text" style="width:192px;" class="input" dataformat="engup" value=""><!-- 
								 --><button type="button"  name="eq_no_multi1"  id="eq_no_multi1" class="multiple_inq ir"></button>
							</td>
						</tr>
					</tbody>
				</table>
	     </div>
          <div class="layout_flex_flex"  style="padding-left:368px">
	         <div class="opus_design_grid">
	             <script type="text/javascript">ComSheetObject('sheet2');</script>
	         </div>
	     </div>
	 </div>
 </div>
<!-- layout_wrap (e) -->

<div class="wrap_result">
	<div class="opus_design_inquiry wFit">
		<table>
			<tbody>
				<tr class="h23">
					<th>
						TLL No.
					</th>
					<td>
						<input type="text" name="ttl_lss_no_text" id="ttl_lss_no_text" style="width:125px;text-align:center" class="input2" maxlength="20" readonly>
					</td>
					<th>
						Responsible OFC
					</th>
					<td>
						<input type="text" name="respb_ofc_cd" id="respb_ofc_cd" style="width:100px;" class="input"  maxlength="6" dataformat="engup"><!--  
						--><button type="button" name="respb_ofc_cd_popup" id="respb_ofc_cd_popup" class="input_seach_btn" ></button>
					</td>
					<th>
						REQ OFC
					</th>
					<td>
						<input type="text" name="rqst_ofc_cd_nm" id="rqst_ofc_cd_nm" style="width:100px;" class="input2" readOnly="true">
					</td>
					<th>
						REQ DT
					</th>
					<td>
						<input type="text" name="rqst_dt_text" id="rqst_dt_text" style="width:80px;text-align:center" class="input2" dataformat="ymd" readOnly="true">
					</td>
					<td colspan="3"></td>
				</tr>
				<tr class="h23">
					<th>
						Status
					</th>
					<td>
						<input type="text" name="ttl_lss_sts_cd_nm" id="ttl_lss_sts_cd_nm" style="width:125px;" class="input2" readOnly="true">
					</td>
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
						<script type="text/javascript">ComComboObject('ttl_lss_dtl_rsn_cd', 1, 100, 1, 1);</script>
					</td>
					<th>
						TLL DT
					</th>
					<td>
						<input type="text" name="ttl_lss_dt_text" style="width:80px;text-align:center" class="input2"   readOnly="true">
					</td>
					<th>
						APP OFC
					</th>
					<td>
						<input type="text" name="apro_ofc_cd_nm" style="width:60px;text-align:center" class="input2" readOnly="true">
					</td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
<!-- opus_design_inquiry(E) -->
	<table class="line_bluedot"><tr><td></td></tr></table>



<!-- layout_wrap (S) -->
<div class="layout_wrap">
     <div class="layout_vertical_2 pad_rgt_12" style="width: 50%">
			<div class="opus_design_tab">
				<script type="text/javascript">ComTabObject('tab1')</script>
			</div>
		<div class="opus_design_grid" id="tabLayer" name="tabLayer" style="display:inline">
			<div class="opus_design_btn">
				<button type="button" class="btn_normal" name="btn_t1InvoicePreview" id="btn_t1InvoicePreview" style="display:none">Invoice Preview</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_t1RowDel" id="btn_t1RowDel">Row Delete</button>
			</div>
			<script type="text/javascript">ComSheetObject('t1sheet1');</script>
		</div>
		<div class="opus_design_grid" id="tabLayer" name="tabLayer" style="display:none">
			<div class="opus_design_btn">
				<button type="button" class="btn_normal" name="btn_t2InvoicePreview" id="btn_t2InvoicePreview" style="display:none">Invoice Preview</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_t2RowDel" id="btn_t2RowDel">Row Delete</button>
			</div>
			<script type="text/javascript">ComSheetObject('t2sheet1');</script>
		</div>
		<div class="opus_design_grid" id="tabLayer" name="tabLayer" style="display:none">
			<div class="opus_design_btn">
				<button type="button" class="btn_normal" name="btn_t3InvoicePreview" id="btn_t3InvoicePreview" style="display:none">Invoice Preview</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_t3RowDel" id="btn_t3RowDel">Row Delete</button>
			</div>
			<script type="text/javascript">ComSheetObject('t3sheet1');</script>
		</div>
		<div class="opus_design_grid" id="tabLayer" name="tabLayer" style="display:none">
			<div class="opus_design_btn">
				<button type="button" class="btn_normal" name="btn_t4InvoicePreview" id="btn_t4InvoicePreview">Invoice Preview</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_t4RowDel" id="btn_t4RowDel">Row Delete</button>
			</div>
			<script type="text/javascript">ComSheetObject('t4sheet1');</script>
		</div>
		<div class="opus_design_grid" id="tabLayer" name="tabLayer" style="display:none">
			<div class="opus_design_btn">
				<button type="button" class="btn_normal" name="btn_t5InvoicePreview" id="btn_t5InvoicePreview">Invoice Preview</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_t5RowDel" id="btn_t5RowDel">Row Delete</button>
			</div>
			<script type="text/javascript">ComSheetObject('t5sheet1');</script>
		</div>
     </div>
     
      <div class="layout_vertical_2" style="width: 50%">
         <div class="opus_design_grid sm">
         	<span  class="grid_option_left"><h3 class="title_design"> Total Loss Collection &amp; Adjustment</h3></span>
         	<div class="opus_design_btn">
				<table>
					<tbody>
						<tr>
							<td style="width:120px; text-align:left;"><b>Collection Total</b></td>
							<td style="width:120px;"><input type="text" name="tCollectionTotal" id="tCollectionTotal" style="width:120px;text-align:right;" class="input2" dataformat="float" maxlength="13" pointcount="2" caption="실수(최대최소)" readOnly="true"></td>
							<td> 
								<button type="button" class="btn_normal" name="btn_Col_Add" id="btn_Col_Add">Row Add</button>
								<button type="button" class="btn_normal" name="btn_Col_Delete" id="btn_Col_Delete">Row Delete</button>
							</td>				
					</tr>
				</tbody>
			</table>
	</div>
             <script type="text/javascript">ComSheetObject('sheet3');</script>
         </div>
         <!-- opus_design_grid(e) -->
     </div>
 </div>
<!-- layout_wrap (e) -->




<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry sm">
		<table>
<!-- 			<tbody> -->
<!-- 				<tr class="h23"> -->
<!-- 						<th style="width:220px;"> -->
<!-- 							Recovery Plan Total -->
<!-- 						</th> -->
<!-- 						<td style="width:150px;"> -->
<!-- 							<input type="text" name="t1RecPlnTotal" style="width:120px;text-align:right;" class="input2" dataformat="float" maxlength="13" pointcount="2" caption="실수(최대최소)" readOnly="true"> -->
<!-- 						</td> -->
<!-- 						<th style="width:170px;"> -->
<!-- 							Loss Total -->
<!-- 						</th> -->
<!-- 						<td style="width:120px;"> -->
<!-- 							<input type="text" name="t1LossTotal" style="width:120px;text-align:right;" class="input2" dataformat="float" maxlength="13" pointcount="2" caption="실수(최대최소)" readOnly="true"> -->
<!-- 						</td> -->
<!-- 						<th style="width:190px;"> -->
<!-- 							Balance Total -->
<!-- 						</th> -->
<!-- 						<td style="width:120px;"> -->
<!-- 							<input type="text" name="t1BalanceTotal" style="width:120px;text-align:right;" class="input2" dataformat="float" maxlength="13" pointcount="2" caption="실수(최대최소)" readOnly="true"> -->
<!-- 						</td> -->
<!-- 						<td></td> -->
<!-- 				</tr> -->
<!-- 			</tbody> -->
		</table>
	</div>
<!-- opus_design_inquiry(E) -->



<!-- layout_wrap (S) -->
 <div class="layout_wrap">
     <div class="layout_vertical_2 pad_rgt_12" style="width: 70%">
     	<span  class="grid_option_left"><h3 class="title_design">Total Loss History</h3></span>
         <!-- opus_design_grid(S) -->
         <div class="opus_design_grid">
             <div class="opus_design_btn">
      			<button type="button" class="btn_accent" name="btn_RowAdd2" id="btn_RowAdd2">Row Add</button>
     			<button type="button" class="btn_normal" name="btn_RowDel2" id="btn_RowDel2">Row Delete</button>
    		</div>
    		<script type="text/javascript">ComSheetObject('sheet4');</script>
         </div>
         <!-- opus_design_grid(e) -->
     </div>
      <div class="layout_vertical_2" style="width: 30%">
         <!-- opus_design_grid(S) -->
         <div class="opus_design_grid">
         	 	<div class="opus_design_btn">
         	 		<button type="button" class="btn_normal" name="btn_FileAdd" id="btn_FileAdd">File Add</button>
      				<button type="button" class="btn_accent" name="btn_FileDel" id="btn_FileDel">File Delete</button>
    			</div>
             <script type="text/javascript">ComSheetObject('sheet5');</script>
         </div>
         <!-- opus_design_grid(e) -->
     </div>
 </div>
</div>
<!-- layout_wrap (e) -->
<div style="display:none">
	<script type="text/javascript">ComUploadObject('upload1', '<%=session.getId()%>',0,0);</script>
</div>

</form>
