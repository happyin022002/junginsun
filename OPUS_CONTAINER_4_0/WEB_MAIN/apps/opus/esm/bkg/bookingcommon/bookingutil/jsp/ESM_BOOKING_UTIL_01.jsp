<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : ESM_BOOKING_UTIL_01.jsp
	 *@FileTitle :  Query Execution
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 
	 *@LastModifier : 
	 *@LastVersion : 1.0
	 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page
	import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page
	import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	String strErrMsg = ""; //error messege
	int rowCount = 0; //the number of DB ResultSet List

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	boolean bBtn_Disabled = true;
	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

	} catch (Exception e) {
		out.println(e.toString());
	}

%>	
<html>
<head>
<title> Query Execution</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body onLoad="setupPage();">
<div id="debug"></div>
<form name="form">
	<input type="hidden" name="f_cmd"> 
	<input type="hidden" name="pagerows"> 
<!-- OUTER - POPUP (S)tart -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title">Query Execution</span></button></h2>
	<!-- page_title(E) -->
	
	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<div class="wrap_search">
	<div class="opus_design_inquiry wFit">
	<table>
		<colgroup>
			<col width="40" />
		</colgroup>
		<tr>
			<th><h2>Execute Query</h2></th>
			<td>		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
		    <button type="button" class="btn_normal" name="btn_execute" id="btn_execute">excute Query</button> 
		</div>
		<!-- opus_design_btn(E) --></td>
		</tr>
	</table>
	</div>
</div>

<div class= "opus_design_inquiry sm">
	    <table>
	        <tbody>
				<tr>
					<th>Description</th>
					<td colspan="10"><textarea style="width:1000px;height:200px; ime-mode:disabled;" name="sql" id="sql" class="input"  maxlength="4000"></textarea></td>
				</tr>
			</tbody>
		</table>

		<table class="grid2 sm" style="width:1000px;">
				<tr>
					<th><B>Result</B></th>
					<td><div class="opus_design_grid" id='result' style="width: 1300px;height:450px;overflow: auto;"></div></td>
				</tr>
			</tbody>
		</table>
</div>
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
	    <script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>

</body>
</html>
