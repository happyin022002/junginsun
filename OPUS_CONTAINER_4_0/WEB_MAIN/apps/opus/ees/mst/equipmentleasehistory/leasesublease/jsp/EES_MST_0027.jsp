<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MST_0027.jsp
*@FileTitle  : Container Status Report 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/04
=========================================================
*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mst.equipmentleasehistory.leasesublease.event.EesMst0027Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMst0027Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.EquipmentLeaseHistory.LeaseSublease");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EesMst0027Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		// adding logic to get data from server when first loading ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	} catch(Exception e) {
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

<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="evnt_dt1" id="evnt_dt1">
<input type="hidden" name="evnt_dt2" id="evnt_dt2">


<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="Retrieve" id="Retrieve">Retrieve</button>
		<button type="button" class="btn_normal" name="New" id="New">New</button>
	</div>
	<!-- opus_design_btn(E) -->
	<div class="location"><span id="navigation"></span></div>
</div>
<!-- page_title_area(E) -->
<div class="wrap_search">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry wFit">
	<table>
		<tbody>
			<colgroup>
				<col width="50" />
				<col width="150" />
				<col width="70" />
				<col width="190" />
				<col width="50" />
				<col width="*" />
			</colgroup>
			<tr>
				<th>Period</th>
				<td><input type="text" style="width: 60px" class="input1" value="" maxlength="7" name="evnt_dt11" id="evnt_dt11" dataformat="ym" onfocus='domFunFocusDel(this)' style="ime-mode:disabled"><button type="button" class="calendar ir" name="btns_calendar1" id="btns_calendar1"></button> ~ <input type="text" style="width: 60px" class="input1" value="" maxlength="7" name="evnt_dt22" id="evnt_dt22" dataformat="ym" onfocus='domFunFocusDel(this)' style="ime-mode:disabled"><button type="button" class="calendar ir" name="btns_calendar2" id="btns_calendar2"></button></td>
				<th>Location</th>
				<td><select style="width: 60px;" class="input1" name="loc_tp_cd" id="loc_tp_cd"><option value="A" selected>All</option><option value="R">RCC</option><option value="L">LCC</option><option value="S">SCC</option></select><input type="text" style="width: 60px;" value="" name="loc_cd" id="loc_cd" class="input" maxlength="5" dataformat="engup" style="ime-mode:disabled"><button type="button" class="input_seach_btn" name="ComOpenPopupWithTargetLoc" id="ComOpenPopupWithTargetLoc"></button></td>
				<td><input type="checkbox" value="N" class="trans" name="ls_flg" id="ls_flg"><lable for="ls_flg">Latest Lost Only</lable></td>
				<td></td>
			</tr>
		</tbody>
	</table>
</div>
<!-- opus_design_inquiry(E) -->	
</div>

<div class="wrap_result">
<!-- opus_design_grid(S) -->
<div class="opus_design_grid">
    <div class="opus_design_btn">
		<button type="button" class="btn_normal" name="Down_Excel" id="Down_Excel">Down Excel</button>
	</div>
	<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
<!-- opus_design_grid(E) -->
</div>
</form>