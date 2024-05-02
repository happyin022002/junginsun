<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0164.jsp	
*@FileTitle  :  Disposal Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08    
=========================================================*/
%>
		
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.event.EesMnr0164Event"%>
<%@ page import="org.apache.log4j.Logger" %>
	  
<%
	EesMnr0164Event  event = null;				//PDTO(Data Transfer Object including Parameters)
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
	    
		event = (EesMnr0164Event)request.getAttribute("Event");  
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
<!-- common use in MNR -->               
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

<form name="form"> 
<input type="hidden" name="f_cmd" id="f_cmd">    
<input type="hidden" name="pagerows" id="pagerows"> 	   
<!-- for App Office -->    
<input type="hidden" name="rhq_cd" id="rhq_cd" value="<%=strRhq_cd%>">      	              
<input type="hidden" name="mnr_grp_tp_cd" id="mnr_grp_tp_cd" value="DSP">        	              
<input type="hidden" name="file_seq" id="file_seq" value="">      	              
<input type="hidden" name="disp_eml_flg" id="disp_eml_flg" value="N">   
<input type="hidden" name="disp_search_type" id="disp_search_type" value="">               	              
<input type="hidden" name="self_ofc_cd" id="self_ofc_cd" value="<%=strOfc_cd%>">               	              
<input type="hidden" name="rqst_ofc_cd" id="rqst_ofc_cd" value="">                 	              
<input type="hidden" name="rqst_usr_id" id="rqst_usr_id" value="">                	              


<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!-- 
	 --><button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
	  --><button type="button" class="btn_normal" name="btn_New"  	id="btn_New">New</button><!-- 
	  --><button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button>	
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
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="30px">
				<col width="80px">
				<col width="110px">
				<col width="50px">
				<col width="80px">
				<col width="80px">
				<col width="100px">
				<col width="80px">
				<col width="100px">
				<col width="*">
			</colgroup>
			<tr>
				<th>Date</th>
				<td><!-- 
				 --><script type="text/javascript">ComComboObject('input_date_type_code', 1, 104, 1, 1,0,false,0);</script><!-- 
				  --><input type="text" name="in_apro_st_dt" id="in_apro_st_dt" style="width:80px;" class="input1" dataformat="ymd"  caption="From Date"><!-- 
				   --><input type="text" name="in_apro_end_dt" id="in_apro_end_dt" style="width:80px;" class="input1" dataformat="ymd"  caption="To Date"><!-- 
				    --><button type="button" class="calendar ir" name="btn_period" id="btn_period"></button>
		       	</td>
				<th>Disposal No.</th>
				<td><!-- 
				 --><input name="disp_no_list" id="disp_no_list" type="text" style="width:75px" value="" dataformat="engup" otherchar="-,"><!-- 
				  --><button type="button" class="multiple_inq ir" name="btn_t1_req_multy" id="btn_t1_req_multy"></button>
				</td>
				<th>EQ No.</th>
				<td><!-- 
				 --><input name="eq_no_list" id="eq_no_list" type="text" style="width:75px" value="" dataformat="engup" otherchar="-,"><!-- 
				  --><button type="button" name="btn_t2_req_multy" id="btn_t2_req_multy" class="multiple_inq ir"></button>
				</td>
				<th>Invoice No.</th>
				<td><!-- 
				 --><input name="inv_no_list" id="inv_no_list" type="text" style="width:75px" value="" dataformat="engup" otherchar="-,"><!-- 
				  --><button type="button" name="btn_t3_req_multy" id="btn_t3_req_multy" class="multiple_inq ir"></button>
				</td>
				<th>Charge Code</th>
				<td><select name="chg_cd" id="chg_cd" style="width:80px">
					<option value="A">ALL</option>
					<option value="EQS">EQS</option>
					<option value="EQD">EQD</option>
					<option value="EQC">EQC</option>
					</select></td>
			</tr> 
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn"><!-- 
		 --><button type="button" class="btn_accent" name="btn_Detail" id="btn_Detail">Detail Info</button>
		</div>
		<!-- opus_design_btn(E) -->
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
	<!-- opus_design_grid(E) --> 
</div>
</form>