<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ees_mnr_presetmulty.jsp
*@FileTitle  : EQ Component
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/13
=========================================================*/
%>
	
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.event.MnrComEvent"%>
<%@ page import="org.apache.log4j.Logger" %>
   
<%
 	MnrComEvent  event = null;				//PDTO(Data Transfer Object including Parameters)
 	Exception serverException   = null;			//서버에서 발생한 에러
 	String strErrMsg = "";	 					//에러메세지
 	String strUsr_id		= "";     
 	String strUsr_nm		= "";    
 				
 	//기존소스용
 	String returnval = ((request.getParameter("returnval")==null )?"":request.getParameter("returnval"));
	String returntitle = ((request.getParameter("returntitle")==null )?"":request.getParameter("returntitle"));
	String presetData = ((request.getParameter("presetData")==null )?"":request.getParameter("presetData"));      
	String sheet_id = ((request.getParameter("sheet_id")==null )?"":request.getParameter("sheet_id"));      
	String temp_value1 = ((request.getParameter("temp_value1")==null )?"":request.getParameter("temp_value1"));      
	String checked = ((request.getParameter("checked")==null )?"":request.getParameter("checked"));      
	String prefix = ((request.getParameter("prefix")==null )?"":request.getParameter("prefix"));      
				 								 							 	  	   		
 	try {
 	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
 		strUsr_id =	account.getUsr_id();  	
 		strUsr_nm = account.getUsr_nm();  	
	    		     
 		event = (MnrComEvent)request.getAttribute("Event");
 		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
			 
 		if (serverException != null) { 
 			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
 		}  
 	}catch(Exception e) {    
 		out.println(e.toString());
 	} 
 %>

<script type="text/javascript"> 
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);	
		} // end if	
		loadPage();  
	}	
</script> 	
<form name="form">	
<input type="hidden" name="f_cmd" id="f_cmd">	
<input type="hidden" name="pagerows" id="pagerows">  	 				  
<input type="hidden" name="returnval" id="returnval" value="<%=returnval%>">  
<input type="hidden" name="presetData" id="presetData" value="<%=presetData%>">  
<input type="hidden" name="sheet_id" id="sheet_id" value="<%=sheet_id%>">  
<input type="hidden" name="temp_value1" id="temp_value1" value="<%=temp_value1%>">  
<input type="hidden" name="checked" id="checked" value="<%=checked%>">    
<input type="hidden" name="prefix" id="prefix" value="<%=prefix%>">           

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><%=returntitle%></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_Apply" id="btn_Apply" type="button">Apply</button><!--
		--><button class="btn_normal" name="btn_Close" id="btn_Close" type="button">Close</button>
	</div>
	<!-- opus_design_btn (E) -->
</div>
<!-- page_title_area(E) -->	

<div class="wrap_result">
	<div class="opus_design_grid" id="mainTable"><script type="text/javascript">ComSheetObject('sheet1');</script></div>
</div>
</form>
