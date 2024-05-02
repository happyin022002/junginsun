<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0028.jsp
*@FileTitle  : M&R Repair Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/19
=========================================================
--%>
			
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.event.EesMnr0028Event"%>
<%@ page import="org.apache.log4j.Logger" %>
		 
<%
	EesMnr0028Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//count of DB resultSet list

	String popup_mode = JSPUtil.getParameter(request, "popup_mode".trim(), "");
	String fromSys = ((request.getParameter("from_sys")==null )?"":request.getParameter("from_sys"));
	String eqNo = ((request.getParameter("eq_no")==null )?"":request.getParameter("eq_no"));         
	String eqType = ((request.getParameter("eq_type")==null )?"":request.getParameter("eq_type"));          
	   
	String successFlag = "";
	String codeList  = "";    
	String pageRows  = "100"; 
 		 
	String strUsr_id		= ""; 
	String strUsr_nm		= "";  
	String strOfc_cd		= "";  
	Logger log = Logger.getLogger("com.clt.apps.OperationManage.RepairMgt");
								        
	try {     
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();       
		strUsr_nm = account.getUsr_nm();    
	    strOfc_cd = account.getOfc_cd();    
						
		event = (EesMnr0028Event)request.getAttribute("Event"); 
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
	var selfOfcCd = "<%=strOfc_cd%>";    
</script> 
<script type="text/javascript">ComSheetObject('sheet1');</script>      
<!-- <body  onLoad="setupPage();">  -->
<form name="form"> 
<input type="hidden" name="f_cmd" id="f_cmd">    
<input type="hidden" name="pagerows" id="pagerows"> 	    
<!-- for distinguish issuing Estimate and audit.(rqst_cre/rqst_aud)--> 	
<input type="hidden" name="tpb_only" id="tpb_only" value="N">       	
<input type="hidden" name="from_sys" id="from_sys" value="<%=fromSys%>">        	
<input type="hidden" name="eq_no" id="eq_no" value="<%=eqNo%>">         	
<input type="hidden" name="default_eq_type" id="default_eq_type" value="<%=eqType%>">  
<input type="hidden" name="user_nm" id="user_nm" value="<%=strUsr_nm%>">           	
<input type="hidden" name="new_port_only" id="new_port_only" value="N">
<input type="hidden" name="sol_only" id="sol_only" value="N">

<!-- for RD  --> 
<input type="hidden" name="com_mrdPath" id="com_mrdPath" value="">  
<input type="hidden" name="com_mrdArguments" id="com_mrdArguments" value="">
<input type="hidden" name="com_mrdBodyTitle" id="com_mrdBodyTitle" value="">
		 	 		
<!-- Developer's task	-->   
	<%
	if("Y".equals(popup_mode)){out.print("<div class=\"layer_popup_title\">");}
	%>

<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<%
	if("Y".equals(popup_mode)){
		out.print("<h2 class=\"page_title\"><span>M&R Repair Inquiry</span></h2>");
	}else{
		out.print("<h2 class=\"page_title\"><button type=\"button\"><span id=\"title\"></span></button></h2>");
	}
	%>
<!-- page_title(E) -->
<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
		--><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button><!-- 
		--><% if(popup_mode.equals("Y") ){out.print("<button type=\"button\" class=\"btn_normal\" name=\"btn_close\" id=\"btn_close\">Close</button>");} %>
	</div>
<!-- opus_design_btn(E) -->
<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>

	<%
	if("Y".equals(popup_mode)){out.print("</div>");}
	%>
<!-- page_location(E) -->
	<%
	if("Y".equals(popup_mode)){out.print("<div class=\"layer_popup_contents\">");}
	%>
<div class= "wrap_search">
<!-- opus_design_inquiry(S) -->
	<div class= "opus_design_inquiry wFit">
		<table>
			<tbody>
				<tr> 
					<th width="100">W/O Type </th>	
					<td width="80"><script type="text/javascript">ComComboObject('wo_type', 1, 130, 1, 1,0,false,0);</script></td> 
					<th width="60">EQ Type</th>
					<td width="150"><script language="javascript">ComComboObject('eq_knd_cd', 1, 134, 1, 1,0,false,0);</script></td> 
					<th width="60">Input Date</th>	
					<td width="60">	  					
						<input type="text" name="fm_est_dt" id="fm_est_dt" dataformat="ymd"   caption="from date"     maxlength="10"  size="10"  cofield="to_est_dt" value="" class="input">   
		                             	~ <input type="text" name="to_est_dt" id="to_est_dt" dataformat="ymd" caption="to date" maxlength="10"  size="10"  cofield="fm_est_dt" class="input"><!--
		                             	--><button type="button" class="calendar ir" name="btn_calendar" id="btn_calendar"></button>
					</td>			
					<th width="50">Status</th>	
					<td><script type="text/javascript">ComComboObject('status_cd', 1, 140, 1, 1,0,false,0);</script>
					</td>					 		 	  	
				</tr>			  
				<tr>     
					<th>EQ No.</th>
					<td><input name="rqst_eq_no" id="rqst_eq_no" type="text" style="width:105px" class="input" dataformat="engup" value=""><!--
						--><button type="button" class="multiple_inq ir" name="eq_no_multi1" id="eq_no_multi1"></button>
					</td>   
					<th>EST No.</th>
					<td><input name="rqst_ref_no" id="rqst_ref_no" type="text" style="width:105px" class="input" dataformat="engup" otherchar="-," value=""><!--
						--><button type="button" class="multiple_inq ir" name="eq_no_multi2" id="eq_no_multi2"></button>
					</td>  
					<th>W/O No.</th> 
					<td colspan="2"><input name="wo_no" id="wo_no" type="text" style="width:100px" class="input" dataformat="engup" value=""><!--
						--><button type="button" class="multiple_inq ir" name="eq_no_multi3" id="eq_no_multi3"></button>
						<label for="temp_tpb_only"><strong>TPB Request Only</strong></label><input name="temp_tpb_only" id="temp_tpb_only" type="checkbox" value="Y">
					</td>	
					<td colspan="2"><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;New Port Invoice Include</b>&nbsp;&nbsp;<input name="temp_new_port_only" id="temp_new_port_only" type="checkbox" value="Y" class="trans"><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SOL Invoice Include</b>&nbsp;&nbsp;<input name="temp_sol_only" id="temp_sol_only" type="checkbox" value="Y" class="trans"></td>
					
				</tr>  
				<tr>	  
					<th>Service Provider</th> 
					<td colspan="3">
						<input type="text" name="vndr_seq" id="vndr_seq" caption="Service Provider" style="width:55px;text-align:left;" class="input" value="" dataformat="num" maxlength="6"><!-- -
					 --><button type="button" class="input_seach_btn" name="btn_vndr" id="btn_vndr"></button><!--
					 --><input type="text" name="vndr_nm" id="vndr_nm" caption="Service Provider" style="width:252px;" class="input2" value="" readonly>
					</td>	 
					<th>C.OFC</th>
					<td>   
						<input name="cost_ofc_cd" id="cost_ofc_cd" type="text" style="width:100px" class="input" dataformat="engup" value="">
					</td> 
					<th>Cost Code</th> 
					<td>
					<script  type="text/javascript">ComComboObject('cost_cd',3, 230, 1, 0,2,false,1);</script>
					</td>
				</tr> 
			</tbody> 
		</table>
	</div>
</div>
<div class="wrap_result">
<!-- opus_design_inquiry(E) -->
<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear" >
	<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button>
			<button type="button" class="btn_normal" name="btn_Detail" id="btn_Detail">Detail(s)</button>
			<button type="button" class="btn_normal" name="btn_Print" id="btn_Print">Print</button>
	</div>
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
	</div>
	<%
	if("Y".equals(popup_mode)){out.print("</div>");}
	%>
<!-- opus_design_grid(E) -->
</form>