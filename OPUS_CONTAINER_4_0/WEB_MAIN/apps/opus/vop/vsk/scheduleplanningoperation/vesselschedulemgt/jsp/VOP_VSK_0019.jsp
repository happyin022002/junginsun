<%@page import="com.clt.framework.core.controller.util.WebKeys"%>
<%@page import="com.clt.framework.core.view.template.Screen"%>
<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_VSK_0019.jsp
*@FileTitle  : VSL SKD Inquiry by VVD
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/27
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0019Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import = "com.clt.framework.component.util.StringUtil" %>  
<%
	VopVsk0019Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB ResultSet list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.VSKCommon.VSKCodeFinder");

	//Pop-up parameter
	String popMode 		= "";
	String sVslCd 		= "";
	String sSkdVoyNo 	= "";
	String sSkdDirCd 	= "";
	String isPop 		= "";
	Screen screen       = null;

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopVsk0019Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		screen = (Screen) request.getAttribute(WebKeys.CURRENT_SCREEN);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		//Pop-up parameter setting
		popMode		= request.getParameter("pop_mode") == null ? "N" : "Y";
		sVslCd		= request.getParameter("vsl_cd") == null ? "" : request.getParameter("vsl_cd");
		sSkdVoyNo	= request.getParameter("skd_voy_no") == null ? "" : request.getParameter("skd_voy_no");
		sSkdDirCd	= request.getParameter("skd_dir_cd") == null ? "" : request.getParameter("skd_dir_cd");
		isPop = screen.getName().indexOf("POP") >= 0 ? "Y" : "N";
		
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

<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="pop_mode" value="<%=isPop%>" id="pop_mode" />
<!-- RD -->
<input type="hidden" name="com_mrdPath" value="" id="com_mrdPath" />
<input type="hidden" name="com_mrdArguments" value="" id="com_mrdArguments" />
<input type="hidden" name="com_mrdBodyTitle" value="" id="com_mrdBodyTitle" />
<input type="hidden" name="com_mrdSaveDialogFileExt" value="ppt" id="com_mrdSaveDialogFileExt" />
<input type="hidden" name="com_mrdSaveDialogFileExtLimit" value="xls@pdf@doc@ppt" id="com_mrdSaveDialogFileExtLimit" />
<input type="hidden" name="com_mrdSaveDialogFileName" value="" id="com_mrdSaveDialogFileName" />
<input type="hidden" name="com_mrdSaveDialogDir" value="c:\users\" id="com_mrdSaveDialogDir" />
<input type="hidden" name="com_mrdTitle" value="" id="com_mrdTitle" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title">
		<% if ("Y".equals(isPop)) { %>
			<span>Vessel Schedule Inquiry by V.V.D(Pop-up)</span>
		<% } else { %>
			<button type="button"><span id="title"></span></button>
		<% } %>
	</h2>
	<!-- page_title(E) -->
	
	<% if ("N".equals(isPop)) { %>
	<div id="main_layer">
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
			--><button class="btn_normal" name="btn_print" id="btn_print" type="button">Print</button><!--
			--></div>
		<!-- opus_design_btn (E) -->
	</div>
	<% } %>
	<% if ("Y".equals(isPop)) { %>
	<!-- : ( Button : pop ) (S) -->
	<div id="pop_layer">
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn"><!-- 
			--><%if("N".equals(isPop)){ %><button class="btn_accent" name="btn_retrieve_pop" id="btn_retrieve_pop" type="button">Retrieve</button><!--
			--><%} %><button class="<%="N".equals(isPop) ? "btn_normal" : "btn_accent"%>" name="btn_close" id="btn_close" type="button">Close</button><!--
			--></div>
		<!-- opus_design_btn (E) -->
	</div>
	<% } %>

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table><tbody><tr id="top_tr"><td id="top_td"></td></tr></tbody></table>
		<table>
			<colgroup>
				<col width="85" />				
				<col width="160" />				
				<col width="75" />				
				<col width="90" />				
				<col width="90" />				
				<col width="90" />				
				<col width="91" />				
				<col width="*" />					
		   </colgroup> 
		   <tbody>
			   	<tr>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input type="text" name="vsl_cd" style="width:50px;text-align:center;ime-mode:disabled;" class="input1" value="<%=StringUtil.xssFilter(sVslCd) %>" maxlength="4" onfocus="this.select();" id="vsl_cd" dataformat="engup" /><!-- 
					 --><input type="text" name="skd_voy_no" style="width:40px;text-align:center;ime-mode:disabled;" class="input1" value="<%=StringUtil.xssFilter(sSkdVoyNo) %>" maxlength="4" onfocus="this.select();" id="skd_voy_no" dataformat="num" /><!-- 
					 --><input type="text" name="skd_dir_cd" style="width:25px;text-align:center;ime-mode:disabled;" class="input1" value="<%=StringUtil.xssFilter(sSkdDirCd) %>" maxlength="1" onfocus="this.select();" id="skd_dir_cd" dataformat="engup" /><!-- 
					 --><%if("N".equals(isPop)){ %><button type="button" id="btn_vvd_search" name="btn_vvd_search" class="input_seach_btn"></button><%} %></td>
					<th>Lane Code</th>
					<td><input type="text" name="vsl_slan_cd" style="width:40px;text-align:center;" class="input2" value="" readonly="readonly" id="vsl_slan_cd" /> </td>
					<th>P/F SKD Type</th>
					<td><input type="text" name="pf_skd_tp_cd" style="width:50px;text-align:center;" class="input2" value="" readonly="readonly" id="pf_skd_tp_cd" /> </td>
					<th>Created Date</th>
					<td><input type="text" name="cre_dt" style="width:110px;text-align:center;" class="input2" value="" readonly="readonly" id="cre_dt" /><!-- 
					 --><input type="text" name="cre_usr_id" style="width:110px;" class="input2" value="" readonly="readonly" id="cre_usr_id" /> </td>
					<td></td>
				</tr>
				<tr>
					<td></td> 
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<th>Updated Date</th>
					<td><input type="text" name="upd_dt" style="width:110px;text-align:center;" class="input2" value="" readonly="readonly" id="upd_dt" /><!-- 
					 --><input type="text" name="upd_usr_id" style="width:110px;" class="input2" value="" readonly="readonly" id="upd_usr_id" /></td>
					<td></td>
				</tr>

		   </tbody>
		</table>
				<table>
			<colgroup>
				<col width="85" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
					<th>Remark(s)</th>
					<td><textarea style="ime-mode:disabled;width:820px; height:50px;resize:none" name="skd_rmk" id="skd_rmk" readonly="readonly" ></textarea></td>
		   		</tr>
		   </tbody>
		</table>
		<!--  biz_1   (E) -->
		<table class="height_8"><tr><td></td></tr></table>
		
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
</div>



</form>