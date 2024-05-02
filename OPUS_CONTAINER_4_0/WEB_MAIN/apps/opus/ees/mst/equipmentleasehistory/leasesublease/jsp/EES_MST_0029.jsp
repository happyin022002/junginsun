<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MST_0029.js
*@FileTitle  : Container Status Inquiry 
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
<%@ page import="com.clt.apps.opus.ees.mst.equipmentleasehistory.leasesublease.event.EesMst0029Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%
	EesMst0029Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String cntr_no          = "";
	Logger log = Logger.getLogger("com.clt.apps.EquipmentLeaseHistory.LeaseSublease");
	String popflag = StringUtil.xssFilter(request.getParameter("popflag"));
	if(popflag == null){
		popflag = "";
	}	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EesMst0029Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		// adding logic to get data from server when first loading ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		cntr_no = StringUtil.xssFilter(request.getParameter("cntr_no"));
		if (cntr_no == null)
			cntr_no = "";
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
<input type="hidden" name="popflag" id="popflag" value="<%=popflag%>">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<%if(popflag == "") {%>
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<% } else { %>
		<h2 class="page_title"><span>Container Status Inquiry</span></h2>
		<% } %>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<%
		if(popflag != "") {
		%>
			<button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		<%
		}
		else
		{
		%>
			<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button>
			<button type="button" class="btn_normal" name="New" id="New">New</button>
		<%
		}
		%>   
	</div>
	<!-- opus_design_btn(E) -->
	<%if(popflag == "") {%>
		<div class="location">
			<span id="navigation"></span>
		</div>
	<%}else{ %>
		
	<%} %> 		
</div>
<!-- page_title_area(E) -->

<!-- opus_design_inquiry(S) -->
<div class="wrap_search">
<div class="opus_design_inquiry wFit">
	<table>
		<tbody>
			<colgroup>
				<col width="10px" />
				<col width="50px" />
				<col width="220px" />
				<col width="30px" />
				<col width="120px" />
				<col width="30px" />
				<col width="120px" />
				<col width="50px" />
				<col width="100px" />
				<col width="*" />
			</colgroup>
			<tr>
				<td></td>
				<th>CNTR No.</th>
				<td><input type="text" name="cntr_no" id="cntr_no" style="width: 80px; text-align:center; text-transform:uppercase; ime-mode:disabled;" class="input1" maxlength="10" dataformat="engup" value="<%=cntr_no%>"><input type="text" style="width: 15px; text-align:center" dataformat="num" class="input2"  readOnly value="" name="chk_dgt" id="chk_dgt"><input type="text" style="width: 60px;" class="input2"  readOnly value="" name="aciac_div_cd" id="aciac_div_cd" style="text-align:center"></td>
				<th>TP/SZ</th>
				<td><input type="text" style="width: 60px;" class="input2"  readOnly value="" name="cntr_tpsz_cd" id="cntr_tpsz_cd" style="text-align:center"></td>
				<th>Term</th>
				<td><input type="text" style="width: 60px;" class="input2"  readOnly value="" name="lstm_cd" id="lstm_cd" style="text-align:center"></td>
				<th>ISO Code</th>
				<td><input type="text" style="width: 60px;" class="input2"  readOnly value="" name="cntr_tpsz_iso_cd" id="cntr_tpsz_iso_cd" style="text-align:center"></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<th>Old/New</th>
				<td><input type="text" style="width: 80px;" class="input2"  readOnly value="" name="cntr_old_van_flg" id="cntr_old_van_flg" style="text-align:center"></td>
				<th>Ownership</th>
				<td><input type="text" style="width: 150px;" class="input2"  readOnly value="" name="ownr_co_cd" id="ownr_co_cd" style="text-align:center"></td>
				<th>Current</th>
				<td><input type="text" style="width: 60px;" class="input2"  readOnly value="" name="cntr_use_co_cd" id="cntr_use_co_cd" style="text-align:center"></td>
				<td></td>
			</tr>
		</tbody>
	</table>
</div>
</div>
<!-- opus_design_inquiry(E) -->	
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