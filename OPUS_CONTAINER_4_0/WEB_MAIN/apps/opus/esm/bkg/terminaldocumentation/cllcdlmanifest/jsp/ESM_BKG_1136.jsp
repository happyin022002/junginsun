<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1136.jsp
*@FileTitle  : Container Loading Cross-Check (KOR)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/12
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.event.EsmBkg1136Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1136Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			// error from server
	String strErrMsg = "";						// error message
	int rowCount	 = 0;						// count of DB resultSET list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	String strCnt_cd		= "";
	String strPort_cd		= "";
		
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		strCnt_cd = account.getCnt_cd();
		strPort_cd = strCnt_cd + strOfc_cd.substring(0, 3);
			   
		event = (EsmBkg1136Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
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

<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	    
    <!-- page_title(S) -->
    <h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
    <!-- page_title(E) -->
           
    <!-- opus_design_btn(S) -->
    <div class="opus_design_btn"><!--
    --><button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
    --><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button><!--
    --><button type="button" class="btn_normal" name="btn_Downexcel" id="btn_Downexcel">Down Excel</button></div>
    <!-- opus_design_btn(E) -->
    <!-- page_location(S) -->
    <div class="location">
        <!-- location 내용 동적생성 (별도 코딩 불필요) -->
        <span id="navigation"></span>
    </div>
    <!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->
	
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
	    <table>
	        <colgroup>
	            <col width="30px">
	            <col width="130px">
	            <col width="30px">
	            <col width="100px">
	            <col width="30px">
	            <col width="100px">            
	            <col width="30px">
	            <col width="140px">
	            <col width="150px">
	            <col width="200px">
	            <col width="">
	        </colgroup>
	        <tbody>
				<tr>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input type="text" name="vvd" id="vvd" style="width:90px;ime-mode:disabled" maxlength="9" class="input1" dataformat="engup" required fullfill caption="VVD"></td>
					<th title="Port of Loading">POL</th>
					<td><input type="text" name="pol" id="pol" style="width:60px;ime-mode:disabled" maxlength="5" class="input1" dataformat="enguponly" required fullfill caption="POL"></td>
					<th title="Port of Discharging">POD</th>
					<td><input type="text" name="pod" id="pod" style="width:60px;ime-mode:disabled" maxlength="5" class="input" dataformat="enguponly" caption="POD"></td>
					<th>Type</th>
					<td class="sm pad_left_8"><input type="radio" name="data_type" id="data_type" value="all" class="trans" checked>All&nbsp;&nbsp;&nbsp;<!--
					--><input type="radio" name="data_type" value="local" class="trans">Local&nbsp;&nbsp;&nbsp;<!--
					--><input type="radio" name="data_type" value="ts" class="trans">T/S</td>
					<th>Data Cross-Check</th>
					<td class="sm pad_left_8"><input type="radio" name="data_cross_check" id="data_cross_check" value="all" class="trans" checked>All&nbsp;&nbsp;&nbsp;<!--
					--><input type="radio" name="data_cross_check" value="m" class="trans">Matched&nbsp;&nbsp;&nbsp;<!--
					--><input type="radio" name="data_cross_check" value="u" class="trans">Un-matched</td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>

<!-- wrap_result(S) -->
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid"  id="mainTable">		
  		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
	<div class="layout_wrap" style="width: 50%">
	    <div class="layout_vertical_2" >
	 		<div class="opus_design_grid">
  				<script type="text/javascript">ComSheetObject('sheet2');</script>			
			</div>
		</div>
	</div>
</div>

</form>