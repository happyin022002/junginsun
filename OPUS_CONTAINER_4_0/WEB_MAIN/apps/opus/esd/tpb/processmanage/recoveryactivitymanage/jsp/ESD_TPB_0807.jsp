﻿<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESD_TPB_0807.jsp
*@FileTitle  : Recovery Activity Inquiry / Input
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/18
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.tpb.processmanage.recoveryactivitymanage.event.EsdTpb0807Event"%>
<%@ page import="com.clt.apps.opus.esd.tpb.common.TPBUtils" %>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdTpb0807Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Server Exception
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//DB ResultSet list count

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String ofc_cd			= "";
	Logger log = Logger.getLogger("com.clt.apps.ProcessManage.RecoveryactivityManage");
	
	String n3pty_no = JSPUtil.getNull(request.getParameter("n3pty_no"));
	String from_n3pty_no = JSPUtil.getNull(request.getParameter("from_n3pty_no"));
	String n3pty_inv_no = JSPUtil.getNull(request.getParameter("n3pty_inv_no"));
	//String file_no = TPBUtils.getInvFileNo(n3pty_inv_no);
	String is_read_only = JSPUtil.getNull(request.getParameter("is_read_only")).trim();

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);

		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		ofc_cd = account.getOfc_cd();


		event = (EsdTpb0807Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// Add logic information data from the server when loading the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
	
	boolean isReadOnly = false;

	if ( is_read_only.trim().equals("Y") ) { // 
		isReadOnly = true;
	} 
%>
<script  type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<!-- 개발자 작업	-->

<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="s_n3pty_no" value="<%=n3pty_no%>" id="s_n3pty_no" />
<input type="hidden" name="s_from_n3pty_no" value="<%=from_n3pty_no%>" id="s_from_n3pty_no" />
<input type="hidden" name="s_n3pty_inv_no_origin" value="<%=n3pty_inv_no%>" id="s_n3pty_inv_no_origin" />
<input type="hidden" name="s_user_id" value="<%=strUsr_id%>" id="s_user_id" />
<input type="hidden" name="s_if_ofc_cd" value="<%=ofc_cd%>" id="s_if_ofc_cd" />
<input type="hidden" name="s_readonly" value="<%=is_read_only%>" id="s_readonly" />
<input type="hidden" name="user_ofc_cd" value="<%=ofc_cd%>" id="user_ofc_cd" />

<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title"><span>Recovery Activity</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_downexcel" 	id="btn_downexcel">Down Excel</button><!--
			--><button type="button" class="btn_normal" name="btn_close2"  		id="btn_close2">Close</button>	
		</div>
	
	</div>
</div>
<!-- page_title_area(E) -->

<div class="layer_popup_contents">
<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<div id="tabLayer" style="display:inline">
		<div class="opus_design_grid clear" >
		<% if(!isReadOnly){ %>
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_add1" id="btn_add1">Row Add</button><!--
				--><button type="button" class="btn_normal" name="btn_save1" id="btn_save1">Save</button><!--
				<button type="button" class="btn_normal" name="btn_close1" id="btn_close1">Close</button>-->
			</div>
			<% } else { %>
			
		<% } %>
				<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
	 <div id="tabLayer" style="display:none">
	 	<div class= "opus_design_inquiry">
			<table>
				<tbody>
					<colgroup>
						<col width="80"/>
						<col width="*"/>
				    </colgroup>
					<tr>
						<th>Invoice No.</th>
						<td><input type="text" style="width:120px;" name="s_n3pty_inv_no" value="<%=n3pty_inv_no%>" readonly required="" caption="Invoice No." id="s_n3pty_inv_no" /> </td>
						<th>File Attached</th>
						<td><input type="hidden" style="width:330px;" name="s_file_no" value="" id="s_file_no" /><iframe name="ifr" id="ifr" src="" width="330px" height="40px" frameborder="0" style="border: #7F9DB9 1px solid"></iframe> </td>
						<% if(!isReadOnly){ // %>
						<td><img class="cursor" src="/opuscntr/img/button/btng_filesearch.gif" width="85" height="19" border="0" name="btn_filesearch"></td>
						<% } %>
					</tr>	
					
				</tbody>
			</table>
		</div>
		<div class="opus_design_grid clear" >
			<% if(!isReadOnly){ // %>
				<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_add2" id="btn_add2">Row Add</button><!--				
				--><button type="button" class="btn_normal" name="btn_save2" id="btn_save2">Save</button>
			</div>
			<% } %>
			<script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>
	 </div>
	
</div>
<!-- opus_design_grid(E) -->
</div>
</form>