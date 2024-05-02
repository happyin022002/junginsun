<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0992.jsp
*@FileTitle  : Pickup No Notice Setup copy Popup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/12
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg0992Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.StringUtil" %>

<%
	EsmBkg0992Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";				//error message
	int rowCount	 = 0;				//count of DB resultSET list


	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.InboundBLMgt.PickUpNotice");

    String from_ofc_cd = "";
	String from_del_cd = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

        from_ofc_cd = StringUtil.xssFilter(request.getParameter("from_ofc_cd"));
        from_del_cd = StringUtil.xssFilter(request.getParameter("from_del_cd"));

		event = (EsmBkg0992Event)request.getAttribute("Event");
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
		loadPage();
	}
</script>
<form name="form">
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="pagerows" name="pagerows" type="hidden" />
<input id="usr_id" name="usr_id" value="<%=strUsr_id%>" type="hidden" />
<input id="fm_ofc_cd" name="fm_ofc_cd" value="<%=from_ofc_cd%>" type="hidden" />
<input id="fm_del_cd" name="fm_del_cd" value="<%=from_del_cd%>" type="hidden" />
<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Pick up No Notice Setup copy</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" type="button" name="btn_Copy" id="btn_Copy">Copy</button><!--
			--><button class="btn_normal" type="button" name="btn_Close" id="btn_Close" >Close</button><!--
			--></div>
		<!-- opus_design_btn (E) -->
	</div>
	<!-- page_title_area(E) -->
</div>
<div class="layer_popup_contents">
	<!-- wrap_search(S) -->
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="40">				
					<col width="80">				
					<col width="50">				
					<col width="*">				
			   </colgroup>
			   <tbody>
					<tr>
						 <th>EQ OFC</th>
                         <td><input type="text" style="width:60px;ime-mode:disabled;" class="input1" name="ofc_cd" id="ofc_cd" caption="EQ Office" maxlength="5" minlength="5" dataformat="engup" required="" fullfill="fullfill" /></td>
                         <th title="Place of Delivery">DEL</th>
                         <td><input type="text" style="width:60px;ime-mode:disabled;" class="input1" name="del_cd" id="del_cd" value="" caption="DEL Code" maxlength="5" minlength="3" dataformat="engup" /></td>
					</tr>
			   </tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
	<!-- wrap_search(E) -->
	<!-- wrap_result(S) -->
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet1');</script>		
		</div>
		<!-- opus_design_grid(E) -->
	</div>
	<!-- wrap_result(E) -->
</div>
</form>
<%@include file="/bizcommon/include/common_opus.jsp"%>