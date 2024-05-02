<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_LSE_1002.jsp
*@FileTitle  : Multi data select common
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
<%@ page import="com.clt.apps.opus.ees.lse.lsecommon.lsecommon.event.EesLseComEvent"%>
<%@ page import="org.apache.log4j.Logger" %> 

<%
 	EesLseComEvent  event = null;				//PDTO(Data Transfer Object including Parameters)
 	Exception serverException   = null;			//서버에서 발생한 에러
 	String strErrMsg = "";	 					//에러메세지
 	String strUsr_id		= "";     
 	String strUsr_nm		= "";    

 	//기존소스용
 	String returnval = ((request.getParameter("returnval")==null )?"":request.getParameter("returnval"));
	String returntitle = ((request.getParameter("returntitle")==null )?"":request.getParameter("returntitle"));
	returntitle ="("+returntitle+")";

 	try {
 	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
 		strUsr_id =	account.getUsr_id();
 		strUsr_nm = account.getUsr_nm();

 		event = (EesLseComEvent)request.getAttribute("Event");
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
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="returnval" value="<%=returnval%>" id="returnval" />
<!-- 개발자 작업	-->
<div class="layer_popup_contents">
	<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title"><span>Multiple Input Pop up<%=returntitle%></span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_Close" id="btn_Close">Close</button><!--
		--></div>
		<!-- opus_design_btn(E) -->
		<!-- page_location(S) -->
		<div class="location">
			<span id="navigation"></span>
		</div>
		<!-- page_location(E) -->
	</div>
	<!-- page_title_area(E) -->
	</div>
	
	<!-- opus_design_grid(S) -->	
	<div class="wrap_result">
		<div class="opus_design_grid clear" id="mainTable" >
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_RowAdd" id="btn_RowAdd">Row&nbsp;Add</button> 
				<button type="button" class="btn_normal" name="btn_Apply" id="btn_Apply">Apply</button>
				<button type="button" class="btn_normal" name="btn_loadexcel" id="btn_loadexcel" >Load Excel</button>
			</div>
				<script type="text/javascript">ComSheetObject('sheet1');</script>
			<div class= "opus_design_inquiry wFit">
				<table>
					<colgroup>
						<col width="*" />
					</colgroup>
					<tbody>
						<tr>
							<td>
					    		<b>Row Count&nbsp;:&nbsp;</b><input name="row_count" id="row_count" type="text" style="width:30px; height:19; text-align:right" value="1" maxlength="3" onFocus="javascript:select()">
					    	</td>
				    	</tr>
					</tbody>
				</table>
			</div>	
		</div>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>