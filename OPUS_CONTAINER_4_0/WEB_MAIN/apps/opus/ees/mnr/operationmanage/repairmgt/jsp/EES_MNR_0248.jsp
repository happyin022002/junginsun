<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EES_MNR_0248.jsp
*@FileTitle : MNR SOL Invoice File Import
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.25
*@LastModifier : Jun Kato
*@LastVersion : 1.0
* 2015.02.25Jun Kato
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
<%@ page import="com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.event.EesMnr0248Event" %>
<%@ page import="org.apache.log4j.Logger" %>

<%

	EesMnr0248Event  event = null;				//PDTO(Data Transfer Object including Parameters)
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
	   
		event = (EesMnr0248Event)request.getAttribute("Event");
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
		<span>SOL Invoice File Import</span>
	</h2>
<!-- page_title(E) -->
<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		 <button type="button" class="btn_accent" name="btn_new" id="btn_new">New</button>
		 <button type="button" class="btn_normal" name="btn_downExcel1" id="btn_downExcel1">Down Excel</button>
		 <button type="button" class="btn_normal" name="btn_downExcel" id="btn_downExcel">Format Down Excel</button>
		 <button type="button" class="btn_normal" name="btn_loadExcel" id="btn_loadExcel">Load Excel</button>
		 <button type="button" class="btn_normal" name="btn_ok" id="btn_ok">OK</button> 
		 <button type="button" class="btn_normal" name="btn_close"  id="btn_close">Close</button>
	</div>
<!-- opus_design_btn(E)
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
	<table>
		<tbody>
			<colgroup>
				<col width="100" />
				<col width="*" />
			</colgroup>
			<tr>
				<th>Upload Type&nbsp;&nbsp;&nbsp;&nbsp;</th>
				<td><input type="radio" name="upd_tp" id="upd_tp" value="E" class="trans" checked >Excel&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" name="upd_tp" id="upd_tp" value="C" class="trans" >CSV&nbsp;&nbsp;&nbsp;</td>
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
					<button type="button" class="btn_normal" name="btn_verify" id="btn_verify">Verify</button>
				</div>
			<!-- opus_grid_btn(E) -->
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
<!-- opus_design_grid(E) -->
<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear" >
	<h3 id="tr_title1" class="title_design">Job Order List</h3>
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
</div>
<script type="text/javascript">ComSheetObject('sheet3');</script>
<!-- opus_design_grid(E) -->
</form>
<!-- </body> -->