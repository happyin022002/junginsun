<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0211.jsp
*@FileTitle : Tire Purchase W/O Inquiry - Popup
*Open Issues :     
*Change history :  
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0   
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.event.EesMnr0211Event" %>
<%@ page import="org.apache.log4j.Logger" %>

<%

	EesMnr0211Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//count of DB resultSet list
	 
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100"; 
 	 
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String currOfcCd        = "";
	String currOfcEngNm     = "";  
	String reqOfcCd = ((request.getParameter("req_ofc")==null )?"":request.getParameter("req_ofc")); 
		
	Logger log = Logger.getLogger("com.clt.apps.OperationManage.RepairMgt");
	        
	try {     
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id       = account.getUsr_id();  
		strUsr_nm       = account.getUsr_nm();   
		
		//Setting currOfcCd in case of existing reqOfcCd
		if(reqOfcCd != null && !reqOfcCd.equals("")){
			currOfcCd = reqOfcCd;	
		} else {	
			currOfcCd = account.getOfc_cd();  
		}
			  
		currOfcEngNm    = account.getOfc_eng_nm();
	       
		event = (EesMnr0211Event)request.getAttribute("Event"); 
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

<script  type="text/javascript">
    var currOfcCd = "<%=currOfcCd.trim() %>";
    var HOOfc     = "";
    var self_usr_nm = "<%=strUsr_nm%>";
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		
		loadPage();
	}
	
</script>

<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="retfld" id="retfld">
<input type="hidden" name="cost_ofc_cd" id="cost_ofc_cd">
	
	<div class="layer_popup_title">	
		<!-- page_title_area(S) -->
		<!-- page_title_area(S) -->
		<div class="page_title_area clear">
		    
		    <!-- page_title(S) -->
		    <!-- íì´í ë´ì© ëì ìì± (ë³ë ì½ë© ë¶íì) -->
		   	<h2 class="page_title"><span>W/O Inquiry</span></h2>
		    <!-- page_title(E) -->
	
	    	<!-- opus_design_btn(S) -->
		   <div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn1_Retrieve" 	id="btn1_Retrieve">Retrieve</button><!--
			--><button type="button" class="btn_normal" name="btn1_New" 		id="btn1_New">New</button><!--
			--><button type="button" class="btn_normal" name="btn1_OK" 		id="btn1_OK">Ok</button><!--
			--><button type="button" class="btn_normal" name="btn1_Close"  		id="btn1_Close">Close</button>	
			</div>
		    <!-- opus_design_btn(E) -->
		    	</div>
		<!-- page_title_area(E) -->
	</div>
		
		
	<!-- popup_contens_area(S) -->
	<div class="layer_popup_contents">
	<div class= "wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry">
			
		    <table>
		    	<colgroup>
		    		<col width="80">
		    		<col width="150">
		    		<col width="80">
		    		<col width="150">
		    		<col width="80">
		    		<col width="*">
		    	</colgroup>
		        <tbody>
					<tr>
						<th>W/O Type</th>
						<td><script  type="text/javascript">ComComboObject('combo1',2, 120 , 1);</script></td>
		                <th>EQ Type </th>
		                <td>
							<script  type="text/javascript">ComComboObject('combo2',2, 120 , 1);</script>
		                </td>
		                <th>W/O Date</th>
		                <td>
							<input type="text" style="width:80px;text-align:center" class="input1" name="fromcal" dataformat="ymd" required  >~&nbsp;<!-- 
							--><input type="text" style="width:80px;text-align:center" class="input1" name="tocal" dataformat="ymd" required  ><!-- 
							--><button type="button" id="btn_calendar" name="btn_calendar" class="calendar ir"></button>
		                </td>
					</tr>
				</tbody>
			</table>
		</div>	
		</div>
		<!-- opus_design_inquiry(E) -->
		
		<!-- opus_design_grid(S) -->
		<div class="wrap_result">
		<div class="opus_design_grid"> 
			<script  type="text/javascript">ComSheetObject('sheet1');</script>
	    </div>
	    </div>
		<!-- opus_design_grid(E) -->
		

	</div>
	<!-- popup_contens_area(E) -->
	
			
</form>

<%@include file="/bizcommon/include/common_opus.jsp" %>
