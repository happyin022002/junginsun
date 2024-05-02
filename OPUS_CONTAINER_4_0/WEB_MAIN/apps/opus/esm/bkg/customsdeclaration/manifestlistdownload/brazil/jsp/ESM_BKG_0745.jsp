<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   :ESM_BKG_0745.jsp
*@FileTitle  : ESM_BKG_0745 
*@author     : CLT
*@version    : 
*@since      : 29/04/2014
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.brazil.event.EsmBkg0745Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0745Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");
	
	String ncmNo = "";

	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
		ncmNo = (request.getParameter("ncm_no") == null) ? "" : request.getParameter("ncm_no");
		
		event = (EsmBkg0745Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// get data from server when load page ..
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
		
		$('<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button>').appendTo("#btnArea");
        $('<button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button>').appendTo("#btnArea");
        $('<button type="button" class="btn_normal" name="btn_Select" id="btn_Select">Select</button>').appendTo("#btnArea");
       // $('<button type="button" class="btn_normal" name="btn_Close" id="btn_Close" onClick="self.close()">Close</button>').appendTo("#btnArea");
        
        $('#btn_Select').after($('#btn_Close'));
        document.getElementById("title").innerHTML = "NCM Code";    
		
		loadPage();
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp"%>

<%if(!mainPage.equals("true")){%><div class="layer_popup_contents"><%}%>
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
	<!--  biz_1 (S) -->
		<table>
			<tbody>
				<colgroup>
					<col width="140"></col>
					<col width="*"></col>
				</colgroup>
				<tr>
					<th>Harmonized Tariff Code</th>
					<td><input type="text" name="brz_cmdt_cd" id="brz_cmdt_cd" style="width:80px;" class="input" value="<%=StringUtil.xssFilter(ncmNo)%>" dataformat="engup" maxlength="8px" caption="NCM(Harmonized Tariff Code)" ></td>
				</tr>
				<tr>
					<th>Description</th>
					<td><input type="text" name="cmdt_desc" id="cmdt_desc" style="width:600px;" class="input" maxlength="36px" caption="Description"></td>
				</tr>
			</tbody>
		</table>
		<!--  biz_1   (E) -->	
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(S) -->
</div>
<%if(!mainPage.equals("true")){	%></div><%}%>
</form>