<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_2016.jsp
*@FileTitle  : M.G.Set Attach/Detach Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/09
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.event.EesCgm2016Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@page import="com.clt.framework.component.util.io.HttpUtil"%>

<%
	EesCgm2016Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
// 	String form_day         = "";
// 	String form_hs          = "";
	Logger log = Logger.getLogger("com.clt.apps.MovementMnrHistory.ChassisMgsetAttachDetachHistory");
	
	String xml = HttpUtil.makeXML(request,response);
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

// 		form_day  = DateTime.getDateString().replace(".","-");  
// 		form_hs   = DateTime.getShortTimeString();
// 		form_hs   = form_hs.substring(0,2) + ":" + form_hs.substring(2,4);
		event = (EesCgm2016Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// adding logic to get data from server when first loading
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
<form name="form2">
<input type="hidden" name="sXml" value="<%=xml.replace(" \"","'") %>" id="sXml" />
</form>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="yd_cd" id="yd_cd" />
<input type="hidden" name="eq_no" id="eq_no" />
<input type="hidden" name="eq_knd_cd" value="G" id="eq_knd_cd" />
<%-- <input type="hidden" name="form_day" value="<%=form_day %>" id="form_day" /> --%>
<!-- developer working -->

<!-- page_title_area(S) -->
<div class="page_title_area clear ">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
		<!-- opus_design_btn (S) -->
<div class="opus_design_btn">
	<button class="btn_accent" name="btn_New" id="btn_New" type="button">New</button><!--
	--><button class="btn_normal" name="btn_Save" id="btn_Save" type="button">Save</button><!--
	--></div>
<!-- opus_design_btn (E) -->
	    <!-- page_location(S) -->
	<div class="location">
    <!-- location 내용 동적생성 (별도 코딩 불필요) -->
    <span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->


<!-- wrap_area(S) -->
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="50" />
				<col width="50" />
				<col width="50" />
				<col width="50" />
				<col width="50" />
				<col width="50" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<th>Date</th>
					<td><input type="text" style="width:89px;ime-mode:disabled;text-align:center" dataformat="ymd" maxlength="10" class="input1" name="acth_dt" id="acth_dt" /><button type="button" id="btns_Calendar1" name="btns_Calendar1" class="calendar ir"> </button></td>
					<th>Time</th>
					<td><input type="text" style="width:89px;ime-mode:disabled;text-align:center" class="input1" dataformat="hm" name="acth_dt_hm" maxlength="4" id="acth_dt_hm" /> </td>
					<th>Yard</th>
					<td><input type="text" style="width:87px;ime-mode:disabled;text-align:center" dataformat="engup" name="sts_evnt_yd_cd" class="input1" value="" maxlength="7" id="sts_evnt_yd_cd" /><button type="button" id="ComOpenPopupWithTargetYard" name="ComOpenPopupWithTargetYard" class="input_seach_btn"></button></td>
					<td></td>
				</tr> 
			</tbody>
		</table>
	<!-- opus_design_inquiry(E) -->
	</div>
</div>
<!-- wrap_area(E) -->

<!-- result_area(S) -->
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<div class="opus_design_btn">
				<button class="btn_normal" name="Row_Add" id="Row_Add" type="button">Row Add</button><!-- 
				 --><button class="btn_normal" name="Delete" id="Delete" type="button">Row Delete</button>
			</div>
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	<!-- opus_design_grid(E) -->
</div>
<!-- result_area(E) -->
</form>