<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1084.jsp
*@FileTitle  : TPB Issue Popup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/29
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.event.EsmBkg1084Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1084Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String parBkgNo         = "";
    String parNtcSeq        = "";
	String parBlNo          = "";
	String parCustCd        = "";
	String parCustNm        = "";
	Logger log = Logger.getLogger("com.clt.apps.InboundBLMgt.HoldNotice");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		parBkgNo = JSPUtil.getParameter(request, "bkg_no");
        parNtcSeq= JSPUtil.getParameter(request, "ntc_seq");
        parBlNo  = JSPUtil.getParameter(request, "bl_no");
        parCustCd= JSPUtil.getParameter(request, "cust_cd");
        parCustNm= JSPUtil.getParameter(request, "cust_nm");

		event = (EsmBkg1084Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		
		with(document.form) {
            bkg_no.value  = "<%=parBkgNo%>";
            ntc_seq.value = "<%=parNtcSeq%>";
		    bl_no.value   = "<%=parBlNo%>";
		    cust_cd.value = "<%=parCustCd%>";
		    cust_nm.value = "<%=parCustNm%>";
		}
		
		loadPage();
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="bkg_no" id="bkg_no" />
<input type="hidden" name="ntc_seq" id="ntc_seq" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><span>TPB Issue</span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_GotoTPB" id="btn_GotoTPB" type="button">Go to TPB</button>
		<button class="btn_accent" name="btn_Close" id="btn_Close" type="button">Close</button>
	</div>
	<!-- opus_design_btn (E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<tbody>
				<colgroup>
					<col width="50">
					<col width="140">
					<col width="50">
					<col width="*">
				</colgroup>
				<tr class="h23">
                     <th>B/L No.</th>
                     <td><input type="text" style="width:110px;text-align:center;" class="input2" readonly="readonly" dataformat="" maxlength="13" caption="B/L No." name="bl_no" id="bl_no" /></td>
                     <th>Customer</th>
                     <td><input type="text" style="width:70px;text-align:center;" class="input2" readonly="readonly" name="cust_cd" id="cust_cd" /><!--  
                     	--><input type="text" style="width:220px;text-align:left;" class="input2" readonly="readonly" name="cust_nm" id="cust_nm" />
                     </td>
                 </tr>
			</tbody>
		</table>
		
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
