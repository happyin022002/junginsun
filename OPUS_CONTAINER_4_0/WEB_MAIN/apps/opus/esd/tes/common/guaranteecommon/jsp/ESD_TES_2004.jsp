<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ESD_TES_2004.jsp
*@FileTitle : Ref.No. Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/30
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.tes.common.guaranteecommon.event.EsdTes2004Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdTes2004Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;				//Server Exception
	String strErrMsg = "";							//Error Message
	int rowCount	 = 0;							//DB ResultSet Count

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	
	Logger log = Logger.getLogger("com.clt.apps.GuaranteeManage.GuaranteeManage");
	
	String		cre_flg		= JSPUtil.getParameter(request, "cre_flg".trim(), "");	// JSPUtil.getNull(, "G");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (EsdTes2004Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// To initialize the imported data extracted from the server loading 
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch(Exception e) {
		out.println(e.toString());
	}
%>

<html>
<head>
<title>Ref.No. Inquiry</title>
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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="cre_flg"	value="<%=cre_flg %>">

<!-- popup_title_area(S) -->
 <div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>&nbsp;Reference No. Help</span></h2>
		<!-- page_title(E) -->
			
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--  
			--><button type="button" class="btn_normal" name="btn_select" id="btn_select">Select</button><!-- 
			--><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->	
	</div>
	<!-- page_title_area(E) -->
</div>
<!-- popup_title_area(E) -->


<!-- popup_contens_area(S) -->
<div class="layer_popup_contents">

	<div class="wrap_search">
		<div class="opus_design_inquiry wFit">
			<table class="search" style="width:264px;">
				<colgroup>
					<col width="70"/>
					<col width="*" />				
				</colgroup> 
				<tr>
					<th>CNTR No.</th>
					<td><input type="text" style="width:100px" name="cntr_no" id="cntr_no"  maxlength="14" OnKeyUp='tes_isApNum(this);upper(this);' OnBlur="cntrCheck(this);"></td></tr>
				<tr>
					<th>BL No.</th>
					<td><input type="text" style="width:134px" name="bl_no" id="bl_no" maxlength="12"></td>
				</tr>
			</table>
		</div>
  	</div>
  	
  	<!-- wrap_result(S) -->
	<div class="wrap_result" >
	
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet1');</script>	
		</div>
		<!-- opus_design_grid(E) -->
		
	</div>
	<!-- wrap_result(E) -->
  	
</div>
<!-- 개발자 작업	-->

</form>
</body>
</html>