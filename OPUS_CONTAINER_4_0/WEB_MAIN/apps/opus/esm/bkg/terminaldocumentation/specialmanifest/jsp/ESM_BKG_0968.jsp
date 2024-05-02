<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ESM_BKG_0968.jsp
*@FileTitle :  DG Declare Main Menu (EU)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/12
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd 		= "";
	Logger log = Logger.getLogger("com.clt.apps.TerminalDocumentation.SpecialManifest");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
	
%>


<script language="javascript">
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
<input type="hidden" name="ofcCd" value="<%=strOfc_cd%>">
<!-- 개발자 작업	-->

<!-- 제목 -->
<div class="page_title_area clear">
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

   <!-- page_location(S) -->
   <div class="location">
		<span id="navigation"></span>
   </div>
</div>
<!-- 제목 -->

<!-- 검색영역 -->
<div class="wrap_search">
<div class="opus_design_inquiry">		
	<table> 
       	<tr><td >

			
		<%
			if(!strOfc_cd.startsWith("ANR")) {

		%>
			<h3 class="title_design">Dangerous Cargo Declaration EDI Transmit</h3>
			<table width="320px" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td>			
					<button type="button" class="btn_etc align_left" id="btn_1_1" onmouseover="obj_MouseOver('btn_1_1')" onmouseout="obj_MouseOut('btn_1_1')" style="width:320px">1. Import Declaration</button>
				</td>
			</tr>
			</table>
			<table width="320px" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td>
					<button type="button" class="btn_etc align_left" id="btn_1_2" onmouseover="obj_MouseOver('btn_1_2')" onmouseout="obj_MouseOut('btn_1_2')" style="width:320px">2. Transit Declaration</button><br>
				</td>
			</tr>
			</table>
			<table width="320px" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td>
				<button type="button" class="btn_etc align_left" id="btn_1_3" onmouseover="obj_MouseOver('btn_1_3')" onmouseout="obj_MouseOut('btn_1_3')" style="width:320px">3. Export Declaration</button><br>
				</td>
			</tr>
			</table>
			<br>									
			<h3 class="title_design">Message Status</h3>
			<table width="320px" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td>			
				<button type="button" class="btn_etc align_left" id="btn_2_1" onmouseover="obj_MouseOver('btn_2_1')" onmouseout="obj_MouseOut('btn_2_1')" style="width:320px">1. Transmit (Sending Results)</button><br>
				</td>
			</tr>
			</table>
		<%
		
			} else {
		%>
					
			<h3 class="title_design">Dangerous Cargo Declaration EDI Transmit</h3>
			<table width="320px" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td>
					<button type="button" class="btn_etc align_left" id="btn_1_1" onmouseover="obj_MouseOver('btn_1_1')" onmouseout="obj_MouseOut('btn_1_1')" style="width:320px">1. Discharging Declaration</button><br>
				</td>
			</tr>
			</table>
			<table width="320px" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td>
					<button type="button" class="btn_etc align_left" id="btn_1_2" onmouseover="obj_MouseOver('btn_1_2')" onmouseout="obj_MouseOut('btn_1_2')" style="width:320px">2. Transit Declaration</button><br>
				</td>
			</tr>
			</table>
			<table width="320px" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td>
					<button type="button" class="btn_etc align_left" id="btn_1_3" onmouseover="obj_MouseOver('btn_1_3')" onmouseout="obj_MouseOut('btn_1_3')" style="width:320px">3. Loading Declaration</button><br>
				</td>
			</tr>
			</table>
			<table width="320px" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td>
					<button type="button" class="btn_etc align_left" id="btn_1_4" onmouseover="obj_MouseOver('btn_1_4')" onmouseout="obj_MouseOut('btn_1_4')" style="width:320px">4. Pre-carriage Declaration</button><br>
				</td>
			</tr>
			</table>
			<table width="320px" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td>
					<button type="button" class="btn_etc align_left" id="btn_1_5" onmouseover="obj_MouseOver('btn_1_5')" onmouseout="obj_MouseOut('btn_1_5')" style="width:320px">5. On-carriage Declaration</button><br>
				</td>
			</tr>
			</table><br>
			<h3 class="title_design">Message Status</h3>
			<table width="320px" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td>
					<button type="button" class="btn_etc align_left" id="btn_2_1" onmouseover="obj_MouseOver('btn_2_1')" onmouseout="obj_MouseOut('btn_2_1')" style="width:320px">1. Transmit (Sending Results)</button>
				</td>
			</tr>
			</table><br>
			<h3 class="title_design">Setup</h3>
			<table width="320px" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td>
					<button type="button" class="btn_etc align_left" id="btn_3_1" onmouseover="obj_MouseOver('btn_3_1')" onmouseout="obj_MouseOut('btn_3_1')" style="width:320px">2. Forwarder Code Setup (Antwerp)</button>
				</td>
			</tr>
			</table>
			<table width="320px" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td>
					<button type="button" class="btn_etc align_left" id="btn_3_2" onmouseover="obj_MouseOver('btn_3_2')" onmouseout="obj_MouseOut('btn_3_2')" style="width:320px">3. Special UN Numbers Setup (Antwerp)</button>
				</td>
			</tr>
			</table>
		
		<%
			}
		%>
		
			
			
			
		</td></tr>
	</table>
</div>
</div>
<!-- 검색영역 -->


</form>
