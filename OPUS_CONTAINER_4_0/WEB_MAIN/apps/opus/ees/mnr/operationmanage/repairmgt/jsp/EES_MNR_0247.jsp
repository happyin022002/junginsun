<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EES_MNR_0247.jsp
*@FileTitle : MNR EDI Invoice Parking Lot
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.24
*@LastModifier : Jun Kato
*@LastVersion : 1.0
* 2014.12.24Jun Kato
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
<%@ page import="com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.event.EesMnr0247Event" %>
<%@ page import="org.apache.log4j.Logger" %>

<%

	EesMnr0247Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	
	boolean adminAuth = false;
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_auth = "";
	String admin_page = "";
	Logger log = Logger.getLogger("com.clt.apps.test.test");
	SignOnUserAccount account = null;
	
	try {
	   	account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_auth = account.getUsr_auth_tp_cd();
	   
		event = (EesMnr0247Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		log.error(e.toString());
	}
%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		}
		loadPage();
	}
</script>

<!-- <body  onLoad="setupPage();"> -->
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="cell_value" id="cell_value" />
<input type="hidden" name="backendjob_key" id="backendjob_key">

<!-- 개발자 작업	-->
<!-- Developer's task	-->   
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
<!-- page_title(E) -->
<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		 <button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button>
		 <button type="button" class="btn_accent" name="btn_New"   id="btn_New">New</button>
		 <button type="button" class="btn_normal" name="btn_Save" 	 id="btn_Save">Save</button> 
		 <button type="button" class="btn_normal" name="btn_Confirm"  id="btn_Confirm">Confirm</button>
	</div>
<!-- opus_design_btn(E) -->
<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_location(E) -->
<div class= "wrap_search">
<div class= "opus_design_inquiry wFit">
<!-- opus_design_inquiry(S) -->
	<table style="width: 700px">
		<tbody>
			<colgroup>
				<tr class="h23">
					<th>Received Period</th>
					<td>
					   <input type="text" style="width:80px" class="input1" name="cre_fr_dt" maxlength="8" caption="Start DT" dataformat="ymd">
					   <span class="dash">~</span>
					   <input type="text" style="width:80px" class="input1" name="cre_to_dt" maxlength="8" caption="End DT" dataformat="ymd"> 
					   <button type="button" class="calendar ir" name="btn_calendar" id="btn_calendar"></button>
					</td>
					<th>Invoice No.</th>
					<td>
						<input name="inv_no" type="text" size="30" maxlength="11" class="input" dataformat="engupetc" id="inv_no" style="ime-mode: disabled;" onKeyPress="ComKeyOnlyAlphabet('uppernum')"/> 
					</td>	
					<th>EQ No.</th>
					<td>
						<input name="rqst_eq_no" id="rqst_eq_no" type="text" style="width:100px" class="input" dataformat="engup" value=""><!--
						--><button type="button" class="multiple_inq ir" name="eq_no_multi1" id="eq_no_multi1"></button>
					</td>
					
				</tr>
		</tbody>
	</table>
</div>
</div>
<!-- opus_design_inquiry(E) -->
<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<div class="opus_design_grid clear" >
		<h3 id="tr_title1" class="title_design"> Invoice List</h3>
			<!-- opus_grid_btn(S) -->
				<div class="opus_design_btn">
					<button type="button" class="btn_normal" name="btn_rowdel" id="btn_rowdel">Row Del</button>
				</div>
			<!-- opus_grid_btn(E) -->
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
<!-- opus_design_grid(E) -->
<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear" >
	<h3 id="tr_title1" class="title_design">Invoice Detail Information</h3>
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
</div>
<script type="text/javascript">ComSheetObject('sheet3');</script>
<!-- opus_design_grid(E) -->
</form>
<!-- </body> -->