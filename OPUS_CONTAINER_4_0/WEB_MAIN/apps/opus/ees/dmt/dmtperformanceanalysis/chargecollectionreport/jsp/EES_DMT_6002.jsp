<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_6002.jsp
*@FileTitle : Current Collection Status by Office – Detail(s)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.22
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.09.22 황효근
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecollectionreport.event.EesDmt6002Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt6002Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strRhq_ofc_cd	= "";
	Logger log = Logger.getLogger("com.clt.apps.DMTPerformanceAnalysis.ChargeCollectionReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id		= account.getUsr_id();
		strUsr_nm		= account.getUsr_nm();
		strRhq_ofc_cd	= account.getRhq_ofc_cd();

		event = (EesDmt6002Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// Retrieving the parameter values ​​for calls to pop-up page ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Current Collection Status by Office – Detail(s)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">


<!-- Developer's task	-->
<input type="hidden" name="start_dt"		value="<%=JSPUtil.getParameter(request, "start_dt", "")%>">
<input type="hidden" name="end_dt"			value="<%=JSPUtil.getParameter(request, "end_dt", "")%>">
<input type="hidden" name="grp_flg"			value="<%=JSPUtil.getParameter(request, "grp_flg", "")%>">
<input type="hidden" name="ofc_cd"			value="<%=JSPUtil.getParameter(request, "ofc_cd", "")%>">
<input type="hidden" name="dmdt_trf_cd"		value="<%=JSPUtil.getParameter(request, "dmdt_trf_cd", "")%>">
<input type="hidden" name="dmdt_cntr_tp_cd"	value="<%=JSPUtil.getParameter(request, "dmdt_cntr_tp_cd", "")%>">
<input type="hidden" name="dtl_flg"			value="<%=JSPUtil.getParameter(request, "dtl_flg", "")%>">
<input type="hidden" name="usr_rhq_ofc_cd"	value="<%=strRhq_ofc_cd%>">

<!-- Access permissions to specify the information viewable screen  -->
<input type="hidden" name="role_permit">
<input type="hidden" name="role_auth">

<!-- page_title_area(S) -->

<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><span>Current Collection Status by Office – Detail(s)</span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_ByBKG" id="btn_ByBKG">by BKG</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_ByCNTR"  	id="btn_ByCNTR">by CNTR</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_DownExcel" 	id="btn_DownExcel">Down Excel</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
	</div>
	<!-- opus_design_btn(E) -->
</div>

<!-- page_title_area(E) -->

<div class="wrap_result">
<!-- opus_tab_btn(S) -->
<div  class="opus_design_inquiry wFit">
	<script type="text/javascript">ComSheetObject('sheet1');</script>
	<table class="mar_top_8" >
			<tbody>
				<colgroup>
					<col width="70"/>
					<col width="*"/>
			    </colgroup>
				<tr>
					<td>CNTR Q'ty</td>
					<td><input type="text" name="cntr_qty" id="cntr_qty" style="width:50;text-align:right;" readonly ></td>				
				</tr>
			</tbody>
		</table>
</div>
<!-- opus_tab_btn(E) -->
</div>

</form>