<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0156.js
*@FileTitle  : Disposal Request
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/20
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.event.EesMnr0156Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0156Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//count of DB resultSet list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	String strRhq_cd 		= "";

	Logger log = Logger.getLogger("com.clt.apps.OperationManage.DisposalMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	    strOfc_cd = account.getOfc_cd();
	    strRhq_cd = account.getRhq_ofc_cd();

		event = (EesMnr0156Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//adding logic to get data from sever when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<!--Use a common at MNR  -->
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<script type="text/javascript">ComSheetObject('sheet1');</script>
<div style="display:none">
<script type="text/javascript">ComUploadObject('upload1', '<%=session.getId()%>');</script>
</div>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<!-- Variable for app office -->
<input type="hidden" name="rhq_cd" id="rhq_cd" value="<%=strRhq_cd%>">
<input type="hidden" name="mnr_grp_tp_cd" id="mnr_grp_tp_cd" value="DSP">
<input type="hidden" name="file_seq" value="">
<input type="hidden" name="disp_eml_flg" id="disp_eml_flg" value="Y">
<input type="hidden" name="disp_search_type" id="disp_search_type" value="request">
<input type="hidden" name="self_ofc_cd" id="self_ofc_cd" value="<%=strOfc_cd%>">
<input type="hidden" name="rqst_ofc_cd" id="rqst_ofc_cd" value="<%=strOfc_cd%>">


<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- ??? ?? ???? (?? ?? ???) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!--  
	--><button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--  
	--><button type="button" class="btn_normal" name="btn_New"  	id="btn_New">New</button><!--  
	--><button type="button" class="btn_normal" name="btn_Delete" 	id="btn_Delete">Delete</button><!--  
	--><button type="button" class="btn_normal" name="btn_Save" 	id="btn_Save">Save</button><!--  
	--><button type="button" class="btn_normal" name="btn_Request" 	id="btn_Request">Request</button><!--  
	-->	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>

	<!-- page_title_area(E) -->
<div class="wrap_search">	
	<!-- layout_wrap(S) -->
<div class="layout_wrap">
	<!-- layout_vertical_2(S) -->
	<div class="layout_vertical_2" style="width: 30%;" >
		<div class="opus_design_inquiry">
			<table>
				<colgroup>
					<col width="80">
					<col width="*">
				</colgroup>
				<tr>
					<th>Req. Office</th>
					<td><input type="text" name="in_rqst_ofc_cd" id="in_rqst_ofc_cd" style="width:100px" value="<%=strOfc_cd%>" class="input2" dataformat="engup" readOnly></td>
				</tr>
				<tr>
					<th>User ID</th>
					<td><input type="text" name="in_rqst_usr_id" id="in_rqst_usr_id" style="width:100px" value="<%=strUsr_id%>" class="input2" dataformat="engup" readOnly></td>
				</tr>
			</table>
		</div>
	</div>
     <!-- layout_vertical_2(E) -->
     
     <div class="layout_vertical_2" style="width: 70%;">
     	<div class="opus_design_grid">
     		<script type="text/javascript">ComSheetObject('sheet2');</script>
     	</div>
     </div>
</div>
<!-- layout_wrap(E) -->
</div>
<!-- layout_wrap(S) -->
<div class="wrap_search">
	<div class="layout_wrap" style="width: 100%;">
		<!-- layout_vertical_2(S) -->
		<div class="layout_vertical_2" style="width: 60%;">
			<h3 class="title_design">Disposal Information</h3>
			<div class="opus_design_inquiry">		
				<table>
					<colgroup>
						<col width="70">
						<col width="120">
						<col width="10">
						<col width="110">
						<col width="70">
						<col width="70">
						<col width="*">
					</colgroup>
					<tr>
						<th>Disposal No.</th>
						<td><input type="text" name="disp_no" id="disp_no" style="width:102px" value="" class="input2" readOnly></td>
						<th>Request DT</th>
						<td><input type="text" name="rqst_dt" id="rqst_dt" style="width:102px" value="" class="input2" readOnly></td>
						<th>Status</th>
						<td><script type="text/javascript">ComComboObject('disp_sts_cd', 1, 102, 1, 3,0,false,1);</script></td>
						<td></td>
					</tr>
					<tr>
						<th>EQ Type</th>
						<td><script type="text/javascript">ComComboObject('eq_knd_cd', 1, 102, 1, 1,0,false,0);</script></td>
						<th>App Office</th>
						<td><script type="text/javascript">ComComboObject('apro_ofc_cd', 1, 102, 1, 1,0,false,0);</script></td>
						<th>Currency</th>
						<td><script type="text/javascript">ComComboObject('curr_cd', 1, 102, 1, 1,0,false,0);</script></td>
						<td></td>
					</tr>
					<tr>
						<th>Total Q'ty</th>
						<td><input type="text" name="disp_qty" id="disp_qty" style="width:102px;text-align:right" value="" class="input2" dataformat="num" readOnly></td>
						<th>Total AMT</th>
						<td><input type="text" name="disp_st_prc" id="disp_st_prc" style="width:102px;text-align:right" value="" class="input2" dataformat="float" pointcount="2" readOnly></td>
<!-- 						<td>&nbsp;</td> -->
<!-- 						<th><input name="disp_eml_flg_temp" id="disp_eml_flg_temp" type="checkbox" class="trans">E-mail Notice</th> -->
<!-- 						<td></td> -->
					</tr>
				</table>			
			</div>
		</div>
	     <!-- layout_vertical_2(E) -->
	     
	     <!-- layout_vertical_2(S) -->
		<div class="layout_vertical_2" style="width: 40%;">
			<h3 class="title_design">Buyer Selection</h3>	
			<div class="opus_design_grid">
				<script type="text/javascript">ComSheetObject('sheet3');</script>
			</div>
		</div>
		<!-- layout_vertical_2(E) -->
	</div>
	<!-- layout_wrap(E) -->
</div>

<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<div class="opus_design_grid">
	<!-- opus_design_btn(S) -->
		<div class="opus_design_btn"><!--  
		--><button type="button" class="btn_accent" name="btn_RowAdd" id="btn_RowAdd">Row Add</button><!--  
		--><button type="button" class="btn_normal" name="btn_RowDelete"  	id="btn_RowDelete">Row Delete</button><!--  
		--><button type="button" class="btn_normal" name="btn_Excel" 	id="btn_Excel">Down Excel</button><!--  
		--><button type="button" class="btn_normal" name="btn_Inquiry" 	id="btn_Inquiry">Candidate EQ Inq.</button><!--  
		--></div>
		<!-- opus_design_btn(E) -->
		<script type="text/javascript">ComSheetObject('t1_sheet1');</script>
	</div>
</div>
<!-- opus_design_grid(S) -->
		
<!-- layout_wrap(S) -->
<div class="wrap_result">
	<div class="layout_wrap" style="width: 100%;">
	<!-- layout_vertical_2(S) -->
	<div class="layout_vertical_2" style="width: 62%;">
		<div class="opus_design_inquiry" >
			<table class="grid2" style="margin-top:50px;">
				<colgroup>
					<col width="80">
					<col width="*">
				</colgroup>
				<tr>
					<th style="text-align:center;"><strong>Remark(s)</strong></th>
					<td><textarea name="mnr_disp_rmk" id="mnr_disp_rmk" wrap="off" style="width:100%;height:76px;resize:none;" maxLength="4000"></textarea></td>
				</tr>
			</table>
		</div>
	</div>
     <!-- layout_vertical_2(E) -->
     	<!-- layout_vertical_2(S) -->
	<div class="layout_vertical_2" style="width: 35%;margin-left: 30px;">
		<h3 class="title_design">File Attachment</h3>
		<div class="opus_design_grid">
			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn"><!--  
			--><button type="button" class="btn_accent" name="btn_FileAdd" id="btn_FileAdd">Row Add</button><!--  
			--><button type="button" class="btn_normal" name="btn_FileDelete"  	id="btn_FileDelete">Row Delete</button><!--  
			--></div>
			<!-- opus_design_btn(E) -->
			<script type="text/javascript">ComSheetObject('sheet4');</script>
		</div>
	</div>
     <!-- layout_vertical_2(E) -->
</div>
</div>
<!-- layout_wrap(E) -->
</form>