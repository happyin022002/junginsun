<%@page import="com.clt.framework.component.util.StringUtil"%>
<%/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : VOP_VSK_0219.jsp
*@FileTitle  : Vessel Code Inquiry(VSL SKD Update (CCA))
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/29
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.event.VskGloEvent"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List" %>
<%@ page import = "com.clt.framework.component.util.StringUtil" %> 
<% 
	VskGloEvent  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB ResultSet list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.vskcommon.vskcodefinder");
	
	String vslCd = null;
	String vslNm = null;
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (VskGloEvent)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		vslCd = request.getParameter("vsl_cd");
		vslCd = vslCd==null?"":vslCd;
		vslNm = request.getParameter("vsl_nm");
		vslNm = vslNm==null?"":vslNm;
		
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
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">

<!-- popup_title_area(S) -->
 <div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Vessel Code Inquiry</span></h2>
		<!-- page_title(E) -->
								
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--  
			--><button type="button" class="btn_normal" name="btn_ok" id="btn_ok">OK</button><!-- 
			--><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->	
	</div>
	<!-- page_title_area(E) -->
</div>
<!-- popup_title_area(E) -->

<!-- popup_contens_area(S) -->
<div class="layer_popup_contents" style="overflow:hidden;">
	<div class="wrap_search">
		<!-- inquiry_area(S) -->
		<div class="opus_design_inquiry wFit">   <!-- no TAB  -->
			<table> 
				<colgroup>
					<col width="80" />
					<col width="330" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<th>Vessel Code</th>   
						<td><input type="text" style="width:40px;text-align:center;ime-mode:disabled;" dataformat="engup" class="input" maxlength=4 name="vsl_cd" id="vsl_cd" value="<%=StringUtil.xssFilter(vslCd) %>" tabindex="1"></td>
						<td></td>
					</tr>
					<tr>
						<th>Vessel Name</th>   
						<td><input type="text" style="width:320px;ime-mode:disabled;" class="input" dataformat="engupetc" otherchar=" " value="<%=StringUtil.xssFilter(vslNm) %>" maxlength=50 name="vsl_eng_nm" id="vsl_eng_nm" tabindex="2"></td>
						<td></td>
					</tr>
					<tr>
						<th>Carrier Code</th>   
						<td><input type="text" style="width:40px;text-align:center;ime-mode:disabled;" dataformat="enguponly" class="input" value="" maxlength=4 name="crr_cd" id="crr_cd" tabindex="3"></td>
						<td></td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- inquiry_area(E) -->
	</div>
	
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" >
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->
	</div>
</div>
<!-- popup_contens_area(E) -->

</form>