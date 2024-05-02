<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_DMT_MULTI.jsp
*@FileTitle  : Multi data select common
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/18
=========================================================
--%>


<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.event.DmtComEvent"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
 	DmtComEvent  event = null;				//PDTO(Data Transfer Object including Parameters)
 	Exception serverException   = null;			//error from server
 	String strErrMsg	= "";	 					//error message
 	String strUsr_id	= "";     
 	String strUsr_nm	= "";    
 	
 	String returnVal	= JSPUtil.getParameter(request, "returnval", "");
	String returnTitle	= JSPUtil.getParameter(request, "returntitle", "");
	
	if(!returnTitle.equals("")) {
		returnTitle = " (" + returnTitle + ")";
	}
      	
 	try {
 	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
 		strUsr_id =	account.getUsr_id();
 		strUsr_nm = account.getUsr_nm();
	     	     
 		event = (DmtComEvent)request.getAttribute("Event");
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
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">   
<input type="hidden" name="returnval" value="<%=returnVal%>">

<!-- popup_title_area(S) -->
<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Multiple Input Pop up<%=returnTitle%></span></h2>
		<!-- page_title(E) -->

		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">			
			 <button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->	

	</div>
	<!-- page_title_area(E) -->
</div>
<!-- popup_title_area(E) -->

<!-- popup_contens_area(S) -->
<div class="layer_popup_contents">

	<div class="wrap_result">
		<div class="opus_design_grid">
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">	
		    <button type="button" class="btn_accent" name="btn_RowAdd" id="btn_RowAdd">Row Add</button><!--
		 	--><button type="button" class="btn_normal" name="btn_Apply" id="btn_Apply">Apply</button>
		</div>
		<!-- opus_design_btn(E) -->
			<script type="text/javascript">ComSheetObject('sheet1');</script>			
			<table>	
			<tr style="height:5px"></tr>		
				<tr align="right">
					<td>
						<b>Row Count&nbsp;:&nbsp;</b><input name="row_count" type="text" style="width:30px; height:19; text-align:right" value="1" maxlength="3" onFocus="javascript:select()">					
					</td>					
				</tr>
			</table>			
		</div>
	</div>
</div> 
</form>
