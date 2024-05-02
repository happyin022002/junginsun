<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : EES_MNR_0096.jsp
*@FileTitle  : Total Loss Management
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
<%@ page import="com.clt.apps.opus.ees.mnr.operationmanage.totallossmgt.event.EesMnr0096Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EesMnr0096Event  event = null;				//PDTO(Data Transfer Object including Parameters)
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
	Logger log = Logger.getLogger("com.clt.apps.operationmanage.totallossmgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id    =	account.getUsr_id();
		strUsr_nm    = 	account.getUsr_nm();
		rhqOfcCd     = 	account.getRhq_ofc_cd();
		currOfcCd    = 	account.getOfc_cd();
		currOfcEngNm = 	account.getOfc_eng_nm();

		event = (EesMnr0096Event)request.getAttribute("Event");
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
<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="ttl_lss_sts_cd" id="ttl_lss_sts_cd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="work_type" id="work_type" value="management">


<!-- Variable for Existing logic  -->
<input type="hidden" name="self_ofc" id="self_ofc" value="<%=currOfcCd%>">

<input type="hidden" name="ttl_lss_no" id="ttl_lss_no" value="">
<input type="hidden" name="search_ttl_lss_no" id="search_ttl_lss_no" value="">
<input type="hidden" name="rqst_ofc_cd" id="rqst_ofc_cd" value="">
<input type="hidden" name="rqst_dt" id="rqst_dt" value="">

<input type="hidden" name="ttl_lss_sts_cd_flg" id="ttl_lss_sts_cd_flg" value="">
<input type="hidden" name="ttl_lss_rsn_cd" id="ttl_lss_rsn_cd" value="">
<input type="hidden" name="ttl_lss_dtl_rsn_cd" id="ttl_lss_dtl_rsn_cd" value="">
<!-- input type="text" name="ttl_lss_dt" value="" -->
<input type="hidden" name="apro_ofc_cd" id="apro_ofc_cd" value="">
<input type="hidden" name="file_seq" id="file_seq">
<input type="hidden" name="mnr_sts_ref_no" id="mnr_sts_ref_no">
<input type="hidden" name="respb_ofc_nm" id="respb_ofc_nm" value=""><!-- Only for reference when saving "VO" is not required -->

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
		--><button type="button" class="btn_normal" name="btn_Reject" 	id="btn_Reject">Reject</button><!--
		--><button type="button" class="btn_normal" name="btn_Confirm" 	id="btn_Confirm">Confirm</button>
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<div class="opus_design_inquiry">
		<!-- layout_wrap (S) -->
		<div class="layout_wrap">	
		     <div class="layout_flex_fixed" style="width:350px; height:190px;"> 
	           	<table>
					<tbody>
						<tr>
							<td colspan="2">
							   <script type="text/javascript">ComComboObject('in_search_dt_tp',1, 100 , 1,1)</script><!-- 
					        --><input required type="text" name="in_st_dt" id="in_st_dt" dataformat="ymd" caption="from date" maxlength="10" size="10" cofield="in_end_dt" value="" class="input1"> 
	      						  ~   
	      					<input required type="text" name="in_end_dt" id="in_end_dt" dataformat="ymd" caption="to date" maxlength="10" size="10" cofield="in_st_dt" class="input1"><!-- 
	      						 --><button type="button" class="calendar ir" name="btn_period" id="btn_period"></button>
	      					</td>
						</tr>
						<tr>
							<th>
								TLL No.
							</th>
							<td>
								<input type="text" name="in_ttl_lss_no" id="in_ttl_lss_no" style="width:187px;text-align:Left" class="input" dataformat="engup" maxlength="400" otherchar="-"><!-- 
								 --><button type="button"  name="btn_ttl_lss_no_multi"  id="btn_ttl_lss_no_multi" class="multiple_inq ir"></button>
							</td>
						</tr>
						<tr>
							<th>
								APP OFC
							</th>
							<td>
								<input type="text" name="in_rqst_ofc_cd" id="in_rqst_ofc_cd" style="width:187px" value="<%=currOfcCd%>" class="input2" dataformat="engup" readOnly>
							</td>
						</tr>
					</tbody>
				</table>
		     </div>
		       <div class="layout_flex_flex" style="padding-left:358px"> 
		         <div class="opus_design_grid">
		             <script type="text/javascript">ComSheetObject('sheet2');</script>
		         </div>
		     </div>

	 </div>
  </div>
<!-- layout_wrap (e) -->
</div>

<div class="wrap_result">
	<div class="opus_design_inquiry">
		<table>
			<tbody>
				<tr>
					<th style="width:85px;">
						TLL No.
					</th>
					<td style="width:140px;">
						<input type="text" name="ttl_lss_no_text" id="ttl_lss_no_text" style="width:125px;text-align:center" class="input2" maxlength="20" readonly>
					</td>
					<th style="width:110px;">
						Responsible OFC
					</th>
					<td style="width:138px;">
						<input type="text" name="respb_ofc_cd" id="respb_ofc_cd" style="width:100px;" class="input"  maxlength="6" dataformat="engup"><!-- 
						 --><button type="button" name="respb_ofc_cd_popup" id="respb_ofc_cd_popup" class="input_seach_btn" onClick="openPopup('cust_cd')"></button>
					</td>
					<th style="width:60px;">
						REQ OFC
					</th>
					<td style="width:110px;">
						<input type="text" name="rqst_ofc_cd_nm" id="rqst_ofc_cd_nm" style="width:88px;" class="input2" readOnly="true">
					</td>
					<th style="width:70px;">
						REQ DT
					</th>
					<td style="width:95px;">
						<input type="text" name="rqst_dt_text" id="rqst_dt_text" style="width:80px;text-align:center" class="input2" dataformat="ymd" readOnly="true">
					</td>
					<th style="width:45px;">
						Status
					</th>
					<td style="width:120px;">
						<input type="text" name="ttl_lss_sts_cd_nm" id="ttl_lss_sts_cd_nm" style="width:115px;" class="input2" readOnly="true">
					</td>
					<td></td>
				</tr>
				<tr>
					<th>
						Main Reason
					</th>
					<td>
						<input type="text" name="ttl_lss_rsn_cd_nm" id="ttl_lss_rsn_cd_nm" style="width:125px;" class="input2" readOnly="true">
					</td>
					<th>
						Sub Reason
					</th>
					<td>
						<input type="text" name="ttl_lss_dtl_rsn_cd_nm" id="ttl_lss_dtl_rsn_cd_nm" style="width:100px;" class="input2" readOnly="true">
					</td>
					<th>
						TLL DT
					</th>
					<td>
						<input type="text" name="ttl_lss_dt" id="ttl_lss_dt" dataformat="ymd" caption="TLL Date"  maxlength="10"  size="10"  value="" class="input2"><!-- 
						 --><button type="button" class="calendar ir" name="btn_ttl_lss_dt" id="btn_ttl_lss_dt"></button>
					</td>
					<th>
						APP OFC
					</th>
					<td>
						<input type="text" name="apro_ofc_cd_nm" id="apro_ofc_cd_nm" style="width:80px;text-align:center" class="input2" readOnly="true">
					</td>
					<th style="">Issue Date</th>
					<td>
						<input  type="text" name="ttl_lss_iss_dt" id="ttl_lss_iss_dt" dataformat="ymd" caption="Issue Date"  maxlength="10"  size="10"  value="" class="input2"><!-- 
						 --><button type="button" class="calendar ir" name="btn_iss_dt" id="btn_iss_dt"></button>
					</td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->

	<!-- opus_tab_btn(S) -->
	<div class="opus_design_tab">
		<script type="text/javascript">ComTabObject('tab1')</script>
	</div>
<!-- opus_tab_btn(E) -->

<!-- opus_design_grid(S) -->
<div class="opus_design_grid clear" name="tabLayer" id="tabLayer"  style="display:inline">
		
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_t1EQAdd" id="btn_t1EQAdd">EQ Add</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_t1RowDel" id="btn_t1RowDel">Row Delete</button>
		</div>
		<script type="text/javascript">ComSheetObject('t1sheet1');</script>
		
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
<!-- 							<input type="text" name="t1LossTotal" id="t1LossTotal" style="width:150px;text-align:right;" class="input2" dataformat="float" maxlength="13" pointcount="2" caption="Real number(MaxMin)" readOnly="true"> -->
<!-- 						</td> -->
<!-- 						<th> -->
<!-- 							Recovery Plan Total -->
<!-- 						</th> -->
<!-- 						<td> -->
<!-- 							<input type="text" name="t1RecPlnTotal" id="t1RecPlnTotal" style="width:150px;text-align:right;" class="input2" dataformat="float" maxlength="13" pointcount="2" caption="Real number(MaxMin)" readOnly="true"> -->
<!-- 						</td> -->
<!-- 						<th> -->
<!-- 							Balance Total -->
<!-- 						</th> -->
<!-- 						<td> -->
<!-- 							<input type="text" name="t1BalanceTotal" id="t1BalanceTotal" style="width:150px;text-align:right;" class="input2" dataformat="float" maxlength="13" pointcount="2" caption="Real number(MaxMin)" readOnly="true"> -->
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
<!-- 		<button type="button" class="btn_normal" name="btn_t2RowAdd" id="btn_t2RowAdd">Row Add</button> -->
		<button type="button" class="btn_normal" name="btn_t2RowDel" id="btn_t2RowDel">Row Delete</button>
	</div>
	<script type="text/javascript">ComSheetObject('t2sheet1');</script>
	
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
<!-- 			<tbody> -->
<!-- 				<tr> -->
<!-- 					<th> -->
<!-- 						Loss Total -->
<!-- 					</th> -->
<!-- 					<td> -->
<!-- 						<input type="text" name="t2LossTotal" id="t2LossTotal" style="width:150px;text-align:right;" class="input2" dataformat="float" maxlength="13" pointcount="2" caption="Real number(MaxMin)" readOnly="true"> -->
<!-- 					</td> -->
<!-- 					<th> -->
<!-- 						Recovery Plan Total -->
<!-- 					</th> -->
<!-- 					<td> -->
<!-- 						<input type="text" name="t2RecPlnTotal" id="t2RecPlnTotal" style="width:150px;text-align:right;" class="input2" dataformat="float" maxlength="13" pointcount="2" caption="Real number(MaxMin)" readOnly="true"> -->
<!-- 					</td> -->
<!-- 					<th> -->
<!-- 						Balance Total -->
<!-- 					</th> -->
<!-- 					<td> -->
<!-- 						<input type="text" name="t2BalanceTotal" id="t2BalanceTotal" style="width:150px;text-align:right;" class="input2" dataformat="float" maxlength="13" pointcount="2" caption="Real number(MaxMin)" readOnly="true"> -->
<!-- 					</td> -->
<!-- 				</tr> -->
<!-- 			</tbody> -->
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
<!-- 					<col width="75" /> -->
<!-- 					<col width="150" /> -->
<!-- 					<col width="150" /> -->
<!-- 					<col width="150" /> -->
<!-- 					<col width="150" /> -->
<!-- 					<col width="150" /> -->
<!-- 					<col width="*" /> -->
<!-- 				</colgroup> -->
<!-- 			<tbody> -->
<!-- 				<tr> -->
<!-- 					<th> -->
<!-- 						Loss Total -->
<!-- 					</th> -->
<!-- 					<td> -->
<!-- 						<input type="text" name="t3LossTotal" id="t3LossTotal" style="width:150px;text-align:right;" class="input2" dataformat="float" maxlength="13" pointcount="2" caption="Real number(MaxMin)" readOnly="true"> -->
<!-- 					</td> -->
<!-- 					<th> -->
<!-- 						Recovery Plan Total -->
<!-- 					</th> -->
<!-- 					<td> -->
<!-- 						<input type="text" name="t3RecPlnTotal" id="t3RecPlnTotal" style="width:150px;text-align:right;" class="input2" dataformat="float" maxlength="13" pointcount="2" caption="Real number(MaxMin)" readOnly="true"> -->
<!-- 					</td> -->
<!-- 					<th> -->
<!-- 						Balance Total -->
<!-- 					</th> -->
<!-- 					<td> -->
<!-- 						<input type="text" name="t3BalanceTotal" id="t3BalanceTotal" style="width:150px;text-align:right;" class="input2" dataformat="float" maxlength="13" pointcount="2" caption="Real number(MaxMin)" readOnly="true"> -->
<!-- 					</td> -->
<!-- 				</tr> -->
<!-- 			</tbody> -->
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
<!-- 					<col width="75" /> -->
<!-- 					<col width="150" /> -->
<!-- 					<col width="150" /> -->
<!-- 					<col width="150" /> -->
<!-- 					<col width="150" /> -->
<!-- 					<col width="150" /> -->
<!-- 					<col width="*" /> -->
<!-- 				</colgroup> -->
<!-- 			<tbody> -->
<!-- 				<tr> -->
<!-- 					<th> -->
<!-- 						Loss Total -->
<!-- 					</th> -->
<!-- 					<td> -->
<!-- 						<input type="text" name="t4LossTotal" id="t4LossTotal" style="width:150px;text-align:right;" class="input2" dataformat="float" maxlength="13" pointcount="2" caption="Real number(MaxMin)" readOnly="true"> -->
<!-- 					</td> -->
<!-- 					<th> -->
<!-- 						Recovery Plan Total -->
<!-- 					</th> -->
<!-- 					<td> -->
<!-- 						<input type="text" name="t4RecPlnTotal" id="t4RecPlnTotal" style="width:150px;text-align:right;" class="input2" dataformat="float" maxlength="13" pointcount="2" caption="Real number(MaxMin)" readOnly="true"> -->
<!-- 					</td> -->
					
<!-- 					<th> -->
<!-- 						Balance Total -->
<!-- 					</th> -->
<!-- 					<td> -->
<!-- 						<input type="text" name="t4BalanceTotal" id="t4BalanceTotal" style="width:150px;text-align:right;" class="input2" dataformat="float" maxlength="13" pointcount="2" caption="Real number(MaxMin)" readOnly="true"> -->
<!-- 					</td> -->
<!-- 				</tr> -->
<!-- 			</tbody> -->
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
<!-- 							<input type="text" name="t5LossTotal" id="t5LossTotal" style="width:150px;text-align:right;" class="input2" dataformat="float" maxlength="13" pointcount="2" caption="Real number(MaxMin)" readOnly="true"> -->
<!-- 						</td> -->
<!-- 						<th> -->
<!-- 							Recovery Plan Total -->
<!-- 						</th> -->
<!-- 						<td> -->
<!-- 							<input type="text" name="t5RecPlnTotal" id="t5RecPlnTotal" style="width:150px;text-align:right;" class="input2" dataformat="float" maxlength="13" pointcount="2" caption="Real number(MaxMin)" readOnly="true"> -->
<!-- 						</td> -->
						
<!-- 						<th> -->
<!-- 							Balance Total -->
<!-- 						</th> -->
<!-- 						<td> -->
<!-- 							<input type="text" name="t5BalanceTotal" id="t5BalanceTotal" style="width:150px;text-align:right;" class="input2" dataformat="float" maxlength="13" pointcount="2" caption="Real number(MaxMin)" readOnly="true"> -->
<!-- 						</td> -->
<!-- 					</tr> -->
<!-- 				</tbody> -->
			</table>
		</div>
</div>
<!-- opus_design_grid(E) -->

<!-- layout_wrap (S) -->
 <div class="layout_wrap mar_top_8">
     <div class="layout_flex_flex" style="padding-right:468px">
         <!-- opus_design_grid(S) -->
         <div class="opus_design_grid">
         	 <h3 class="title_design">Total Loss History</h3>
             <div class="opus_design_btn">
      			<button type="button" class="btn_accent" name="btn_RowAdd2" id="btn_RowAdd2">Row Add</button>
     			<button type="button" class="btn_normal" name="btn_RowDel2" id="btn_RowDel2">Row Delete</button>
    		</div>
    		<script type="text/javascript">ComSheetObject('sheet3');</script>
         </div>
         <!-- opus_design_grid(e) -->
     </div>
     <div class="layout_flex_fixed" style="width:460px;float:right!important">
         <!-- opus_design_grid(S) -->
         <div class="opus_design_grid">
         	 	<div class="opus_design_btn">
         	 		<button type="button" class="btn_normal" name="btn_FileAdd" id="btn_FileAdd">File Add</button>
      				<button type="button" class="btn_accent" name="btn_FileDel" id="btn_FileDel">File Delete</button>
    			</div>
             <script type="text/javascript">ComSheetObject('sheet4');</script>
         </div>
         <!-- opus_design_grid(e) -->
     </div>
 </div>
<!-- layout_wrap (e) -->
<div style="display:none">
	<script type="text/javascript">ComUploadObject('upload1', '<%=session.getId()%>');</script>
</div>
</div>
</form>
