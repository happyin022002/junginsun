<%/*=========================================================
*Copyright(c) 2009 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAR_0003.jsp
*@FileTitle  : Multi Office Code Popup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/06
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.event.StmSar0003Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="java.util.*" %>  

<%
    StmSar0003Event event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	
	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.clt.apps.opus.stm.sar.accountreceivablecommon.AccountReceivableCommonSC");
	String[] selOfcCds = null; 
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		
		event = (StmSar0003Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		Collection<String> params = new ArrayList<String>();
		params = JSPUtil.getParametersList(request,"selOfcCds");
		selOfcCds = (String[])params.toArray(new String[params.size()]);
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
				
	} catch(Exception ex) {
		log.error("err " + ex.toString(), ex);
		//out.println(e.toString());
	}
	
%>
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		
		// paramenter office code  
		var selOfcCds = [];
		<%
		if (selOfcCds != null && selOfcCds.length > 0) {
			 for(int i = 0; i < selOfcCds.length; i++) {
				   out.println("selOfcCds[" + i + "] = '" + selOfcCds[i] + "';");			 
			 }
		}		
		%>		
		loadPage(selOfcCds);
	}
</script>
<link href="css/opus_contents.css" rel="stylesheet" type="text/css">
<link href="css/opus_menu.css" rel="stylesheet" type="text/css">
<form name="form" method="post">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><span>Multi Office Code</span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_OK" id="btn_OK" type="button">Apply</button><!--
		--><button class="btn_normal" name="btn_Close" id="btn_Close" type="button">Close</button>
	</div>
	<!-- opus_design_btn (E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="*">
			</colgroup>
			<tbody>
				<tr>                      
                   <th style="text-align:left;">
                   		<input type="checkbox" class="trans" name="chkALL" id="chkALL"><label for="chkALL">ALL</label><!--  
                   		--><input type="checkbox" class="trans" name="chkBRH" id="chkBRH" title="Branch"><label for="chkBRH">BRH</label><!--  
                   		--><input type="checkbox" class="trans" name="chkAGT" id="chkAGT" title="Agent"><label for="chkAGT">AGT</label>
                   </th>
                 </tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="mainTable">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>	
</form>
<%@include file="/bizcommon/include/common_opus.jsp"%>