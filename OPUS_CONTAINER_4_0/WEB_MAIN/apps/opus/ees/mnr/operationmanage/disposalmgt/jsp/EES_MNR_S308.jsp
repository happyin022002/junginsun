<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_S308.jsp
*@FileTitle  : Disposal Invoice Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/11
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.event.EesMnrS308Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnrS308Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

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

		event = (EesMnrS308Event)request.getAttribute("Event");  
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {   
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();  
		}       

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {   	  
		out.println(e.toString());
	}		
%>	


<!--MNR 공용 사용  -->                
<script type="text/javascript">    
	var self_usr_nm = "<%=strUsr_nm%>";
	function setupPage(){  
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if	 	 
		loadPage();
	}
</script> 
<script type="text/javascript">ComUploadObject('upload1', '<=session.getId()%>');</script>    

<form name="form"> 
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<!-- App Office를 구하기 위한 -->    
<input type="hidden" name="rhq_cd" value="<%=strRhq_cd%>" id="rhq_cd" />
<input type="hidden" name="mnr_grp_tp_cd" value="DSP" id="mnr_grp_tp_cd" />
<input type="hidden" name="file_seq" value="" id="file_seq" />
<input type="hidden" name="disp_eml_flg" value="N" id="disp_eml_flg" />
<input type="hidden" name="disp_search_type" value="" id="disp_search_type" />
<input type="hidden" name="self_ofc_cd" value="<%=strOfc_cd%>" id="self_ofc_cd" />
<input type="hidden" name="rqst_ofc_cd" value="" id="rqst_ofc_cd" />
<input type="hidden" name="rqst_usr_id" value="" id="rqst_usr_id" />
<input type="hidden" name="in_disp_tp_cd" value="C" id="in_disp_tp_cd" />
<input type="hidden" name="com_mrdArguments" id="com_mrdArguments" />
<input type="hidden" name="com_mrdPath" id="com_mrdPath" />
<input type="hidden" name="com_mrdTitle" id="com_mrdTitle" />
<input type="hidden" name="com_mrdBodyTitle" id="com_mrdBodyTitle" />
<input type="hidden" name="inv_no_list" id="inv_no_list" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button">Disposal Invoice Inquiry</button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" 		id="btn_Retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_New" 			id="btn_New">New</button><!-- 		
		 --><button type="button" class="btn_normal" name="btn_Print" 			id="btn_Print">Print</button><!-- 			
	 --></div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
	
</div>
<!-- page_title_area(E) -->
<div class= "wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<table>
			<tbody>
				<colgroup>
					<col width="110" />
					<col width="230" />
					<col width="150" />
					<col width="120" />
					<col width="90" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<th>INV Date</th>
						<td><input name="from_dt" type="text" style="width:80px;" dataformat="ymd" cofield="to_dt" id="from_dt" /></td>
						<th>Buyer</th>
						<td colspan="3"><input type="text" name="cust_cd" style="width:65px;text-align:center" class="input2" readonly="true" dataformat="engup" maxlength="6" id="cust_cd" /></td>
					</tr>
					<tr>
						<th>Invoice Number</th>
						<td><input name="inv_no" type="text" style="width:90px;" class="input" dataformat="engup" id="inv_no" /><button type="button" id="btn_t1_req_multy" name="btn_t1_req_multy" class="multiple_inq ir"></button></td>
						<th>Disposal(Bidding) No</th>
						<td><input name="disp_no" type="text" style="width:90px;" class="input" dataformat="engup" id="disp_no" /><button type="button" id="btn_t2_req_multy" name="btn_t3_req_multy" class="multiple_inq ir"></button></td>
						<th>Release No</th>
						<td><input name="disp_rlse_no" type="text" style="width:90;" class="input" dataformat="engup"><button type="button" id="btn_t3_req_multy" name="btn_t3_req_multy" class="multiple_inq ir"></button></td>
					</tr> 
				</tbody>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear">
		<table>
			<tr>
				<td><h3 class="title_design">Disposal Invoice List</h3></td>
				<td>
					<div class="opus_design_btn">
					<button type="button" class="btn_accent" name="btn_Detail" 		id="btn_Detail">Invoice Detail(s)</button><!-- 
					 --><button type="button" class="btn_normal" name="btn_Collection" 			id="btn_Collection">Collection Info</button><!-- 		
					 --><button type="button" class="btn_normal" name="btn_DownExcel" 			id="btn_DownExcel">Down Excel</button><!-- 			
				 --></div>
				</td>
			</tr>
		</table>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>	
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear">
	<table>
			<tr>
				<td><h3 class="title_design">Disposal Invoice Detail Information</h3></td>
				<td>
					<div class="opus_design_btn">
						<button type="button" class="btn_accent" name="btn_DownExcelDtl" 		id="btn_DownExcelDtl">Down Excel</button><!-- 
					 --></div>
				</td>
			</tr>
		</table>
		<script type="text/javascript">ComSheetObject('sheet2');</script>
		<script type="text/javascript">ComSheetObject('sheet3');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>				
</form>