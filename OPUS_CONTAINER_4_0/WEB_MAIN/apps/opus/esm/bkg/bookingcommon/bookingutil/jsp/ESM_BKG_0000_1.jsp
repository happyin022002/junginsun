<%--
=========================================================
*Copyright(c) 2015 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0000_1.jsp
*@FileTitle  :  
*@author     : KYOUNGIL MOON
*@version    : 1.0 
*@since      : 2015/07/03
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.framework.core.controller.util.WebKeys"%>
<%@ page import="com.clt.framework.core.view.template.Screen"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.event.EsmBookingUtilEvent"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.core.controller.DefaultViewAdapter"%>

<%
	EsmBookingUtilEvent event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지

	String strUsr_id = "";
	String strUsr_nm = "";
	String screenName		= "";
	

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBookingUtilEvent) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request
				.getAttribute("EventResponse");
				Screen screen = (Screen) request.getAttribute(WebKeys.CURRENT_SCREEN);
				screenName = screen.getName();

	} catch (Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	function setupPage(){
		var formObj = document.form;
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		ComSetObjValue(formObj.screenName,"<%=screenName%>");
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="screenName" id="screenName" />


<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
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
			<col width="40" />
		</colgroup>
		<tr>
			<th>BKG NO</th>
			<td><input type="text" name="bkg_no" id="bkg_no" style="width:150;" maxlength="13" dataformat="engup" class="input1"></td>
			<td>
			<button type="button" class="btn_etc" name="btn_activate" id="btn_activate">Reactivate</button></td>
		</tr>
	</table>
	</div>
</div>
<script type="text/javascript">ComSheetObject('sheet1');</script>
</form>

