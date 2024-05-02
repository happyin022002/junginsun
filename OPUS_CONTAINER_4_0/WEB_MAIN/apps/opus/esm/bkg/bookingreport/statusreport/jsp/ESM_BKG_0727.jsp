<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0727.jsp
*@FileTitle  : BDR Booking No Status - Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/20
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingreport.statusreport.event.EsmBkg0727Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0727Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.BookingReport.StatusReport");
	String vvd_cd		= "";
	String pol_cd		= "";
	String pod_cd			= "";
	String slan_cd			= "";
	String skd_dir_cd		= "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0727Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// get data from server when load page ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		vvd_cd		= JSPUtil.getParameter(request, "vvd_cd");
		pol_cd		= JSPUtil.getParameter(request, "pol_cd");
		pod_cd		= JSPUtil.getParameter(request, "pod_cd");
		slan_cd		= JSPUtil.getParameter(request, "slan_cd");
		skd_dir_cd	= JSPUtil.getParameter(request, "skd_dir_cd");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="com_mrdPath">
<input type="hidden" name="com_mrdArguments">
<input type="hidden" name="com_mrdTitle" value="">
<input type="hidden" name="com_mrdDisableToolbar" value="">
<input type="hidden" name="com_mrdBodyTitle" value="<span style=&quot;color:red&quot;>BDR STATUS</span>">

<input type="hidden" name="vvd_cd" value="<%=vvd_cd%>">
<input type="hidden" name="pol_cd" value="<%=pol_cd%>">
<input type="hidden" name="pod_cd" value="<%=pod_cd%>">
<input type="hidden" name="slan_cd" value="<%=slan_cd%>">
<input type="hidden" name="skd_dir_cd" value="<%=skd_dir_cd%>">

<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>BDR Booking No Status - Inquiry</span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_print" id="btn_print">Print</button><!-- 
			--><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<div class="opus_design_inquiry wFit">
			<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
			</table>
			<!-- : ( Grid ) (E) -->	
			<table class="search" border="0" style="width:566;"> 
				<tr class="h23">
					<td width="55">TTL BKG</td>
					<td width="100"><input type="text" name="ttl_bkg" style="width:60;text-align:right" class="input2" value="0" readonly></td>
					<td width="55">TTL BDR</td>
					<td width="100"><input type="text" name="ttl_bdr" style="width:60;text-align:right" class="input2" value="0" readonly></td> 
					<td width="85">TTL Non BDR</td>
					<td><input type="text" name="non_bdr" style="width:60;text-align:right" class="input2" value="0" readonly></td> </tr>
			</table>
			<!-- : ( Button : Grid ) (S) -->				
		</div>
	</div>
</div>
<!-- popup_contens_area(E) -->
</form>
<%@include file="/bizcommon/include/common_opus.jsp"%>