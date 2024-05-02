<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0163.jsp
*@FileTitle  :  Disposal Invoice Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/21   
=========================================================*/
%>
		
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.event.EesMnr0163Event"%>
<%@ page import="org.apache.log4j.Logger" %>
	  
<%
	EesMnr0163Event  event = null;				//PDTO(Data Transfer Object including Parameters)
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
	    
		event = (EesMnr0163Event)request.getAttribute("Event");  
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

<!--Use a common at MNR  -->                 
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
    
<form name="form"> 
<input type="hidden" name="f_cmd" id=f_cmd>    
<input type="hidden" name="pagerows" id="pagerows"> 	   
<input type="hidden" name="rhq_cd" id="rhq_cd" value="<%=strRhq_cd%>">      	              
<input type="hidden" name="mnr_grp_tp_cd" id="mnr_grp_tp_cd" value="DSP">        	              
<input type="hidden" name="file_seq" id="file_seq" value="">      	              
<input type="hidden" name="disp_eml_flg" id="disp_eml_flg" value="N">   
<input type="hidden" name="disp_search_type" id="disp_search_type" value="">               	              
<input type="hidden" name="self_ofc_cd" id="self_ofc_cd" value="<%=strOfc_cd%>">               	              
<input type="hidden" name="rqst_ofc_cd" id="rqst_ofc_cd" value="">                 	              
<input type="hidden" name="rqst_usr_id" id="rqst_usr_id" value="">                	              
<input type="hidden" name="com_mrdArguments" id="com_mrdArguments">
<input type="hidden" name="com_mrdPath" id="com_mrdPath">
<input type="hidden" name="com_mrdTitle" id="com_mrdTitle">
<input type="hidden" name="com_mrdBodyTitle" id="com_mrdBodyTitle">

<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_New"  	id="btn_New">New</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Print" 	id="btn_Print">Print</button>			
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<div class="wrap_search">
	<div class="opus_design_inquiry wFit">
		<table>
			<tr>
				<th width="60">INV Date</th>
				<td width="150"><!--  
				--><input type="text" name="from_dt" id="fm_dt_t2" style="width:80px;" dataformat="ymd"  caption="From Date">~  
					<input type="text" name="to_dt" id="to_dt" style="width:80px;" dataformat="ymd"  caption="To Date" ><!--  
				--><button type="button" class="calendar ir" name="btn_period" id="btn_period"></button></td>
				<th width="120">Buyer</th>
				<td width="150"><!--  
				--><input type="text" name="cust_cd" id="cust_cd" style="width:86px;text-align:center" class="input" dataformat="engup" maxlength="8"><!--  
				--><button type="button" name="btn_provider_popup" id="btn_provider_popup" class="input_seach_btn"></button><!--  
				--><input type="text" name="vndr_lgl_eng_nm" id="vndr_lgl_eng_nm" style="width:200px" class="input2" readOnly="true"></td>
				<th width="60">Status</th>
				<td><script type="text/javascript">ComComboObject('mnr_inv_sts_cd',1, 115 , 0,0);</script></td>				
			</tr>
			<tr>
				<th>Invoice Number</th>
				<td><!--  
				--><input name="inv_no" id="inv_no" type="text" style="width:174px;" class="input" dataformat="engup"><!--  
				--><button type="button" class="multiple_inq ir" name="btn_t1_req_multy" id="btn_t1_req_multy"></button></td>
				<th>INV Creation OFC</th>
				<td ><input name="inv_ofc_cd" id="inv_ofc_cd" type="text" style="width:86px;text-align:center;" value="<%=strOfc_cd%>" class="input"></td>
				<th >EQ No.</th>
				<td><!--  
				--><input name="eq_no_list" id="eq_no_list" type="text" style="width:87px" value="" dataformat="engup"><!--  
				--><button type="button" class="multiple_inq ir" name="btn_t2_req_multy" id="btn_t2_req_multy"></button>
				</td>					
			</tr> 
		</table>	
	</div>
</div>
<div class="wrap_result">
	<div class="opus_design_grid">
		<div class="grid_option_left"><h3 class="title_design">Disposal Invoice List</h3></div>
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn" id="mainTable"><!--  
		--><button type="button" class="btn_accent" name="btn_Detail" id="btn_Detail">Invoice Detail(s)</button><!--  
		--><button type="button" class="btn_normal" name="btn_Collection"  	id="btn_Collection">Collection Info</button><!--  
		--><button type="button" class="btn_normal" name="btn_DownExcel" 	id="btn_DownExcel">Down Excel</button><!--  
		--></div>
		<!-- opus_design_btn(E) -->
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="mainTable">
		<div class="grid_option_left"><h3 class="title_design">Disposal Invoice Detail Information</h3></div>
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn" id="mainTable"><!--  
		--><button type="button" class="btn_normal" name="btn_DownExcelDtl" 	id="btn_DownExcelDtl">Down Excel</button><!--  
		--></div>
		<!-- opus_design_btn(E) -->
		<script type="text/javascript">ComSheetObject('sheet2');</script>
		<script type="text/javascript">ComSheetObject('sheet3');</script>
	</div>
</div>
</form>