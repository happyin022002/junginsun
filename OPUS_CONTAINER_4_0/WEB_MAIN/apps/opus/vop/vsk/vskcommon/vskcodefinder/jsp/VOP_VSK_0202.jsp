<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : vop_vsk_0202.jsp
*@FileTitle  : Lane Code Help
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/11
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
	Logger log = Logger.getLogger("com.clt.apps.VSKCommon.VSKCodeFinder");
	String vsl_slan_cd = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (VskGloEvent)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		vsl_slan_cd = request.getParameter("vsl_slan_cd");
		vsl_slan_cd = vsl_slan_cd==null?"":vsl_slan_cd;

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
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
<input type="hidden" name="vsl_svc_tp_cd" id="vsl_svc_tp_cd" value="CD00717">



<!-- popup_title_area(S) -->
 <div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Lane Code Inquiry</span></h2>
		<!-- page_title(E) -->
								
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
			 --><button type="button" class="btn_normal" name="btn_Select" id="btn_Select">Select</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->	
	</div>
	<!-- page_title_area(E) -->
</div>
<!-- popup_title_area(E) -->

<!-- popup_contens_area(S) -->
<div class="layer_popup_contents" style="overflow:hidden;">
	<!-- inquiry_area(S) -->
	<div class="wrap_search">
	<div class="opus_design_inquiry wFit">   <!-- no TAB  -->
		<table> 
			<colgroup>
				<col width="70" />
				<col width="90" />
				<col width="70" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr height ="30">
					<th>Lane Code</th>   
					<td><input type="text" style="width:40px;ime-mode:disabled;text-align:center" class="input" dataformat="engup"  maxlength="3" name="vsl_slan_cd" value="<%=StringUtil.xssFilter(vsl_slan_cd)%>" onKeyPress="if(event.keyCode==13) doSearch();"></td>
					<th>Lane Service Type</th>   
					<td><script type="text/javascript">ComComboObject('combo1',2,120,0);</script></td>
				</tr>
				<tr height ="30">
					<th>Lane Name</th>   
					<td colspan="3"><input type="text" style="width:100%;ime-mode:disabled" class="input" dataformat="engup" otherchar=" " maxlength="50" name="vsl_slan_nm" value="" onKeyPress="if(event.keyCode==13) doSearch();"></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- inquiry_area(E) -->
	</div>

	<div class="wrap_result" >
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" >
			<script type="text/javascript">ComSheetObject('sheet1');</script>
			<!-- opus_grid_design_btn(E) -->
		</div>
		<!-- opus_design_grid(E) -->
	</div>
</div>
<!-- popup_contens_area(E) -->
</form>