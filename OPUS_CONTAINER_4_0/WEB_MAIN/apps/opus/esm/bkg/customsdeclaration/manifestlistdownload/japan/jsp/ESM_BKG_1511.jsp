<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESM_BKG_1511.jsp
*@FileTitle : Bonded Place Code Maintenance
*@author : CLT
*@version : 1.0
*@since : 2014/11/13
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.event.EsmBkg1511Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EsmBkg1511Event event = null;		//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;	//서버에서 발생한 에러
	String strErrMsg = "";				//에러메세지
	int rowCount = 0;					//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList	= "";
	String pageRows	= "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.clt.apps.esm.bkg.CustomsDeclaration");

	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EsmBkg1511Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
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
</head>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<!-- 개발자 작업 (S) -->


<!-- page_title_area (S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" type="button" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
		--><button class="btn_normal" type="button" name="btn_new" id="btn_new">New</button><!--
		--><button class="btn_normal" type="button" name="btn_save" id="btn_save" >Save</button>
	</div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->


<!-- wrap_search(S) -->
<div class="wrap_search">
	<div class="opus_design_inquiry">
		<table style="width:700px;">
			<colgroup>
				<col width="80" />
				<col />
				<col />
				<col />
				<col />
				<col />
			</colgroup>
			<tbody>
				<tr>
					<th>Yard Code</th>
					<td><input type="text" class="input" style="width:100px; ime-mode:disabled;" name="yd_cd" id="yd_cd" maxlength="7" dataformat="engup"></td>
					<th>Bonded Place Code</th>
					<td><input type="text" class="input" style="width:100px; ime-mode:disabled;" name="cstms_cd" id="cstms_cd" maxlength="10" dataformat="engup"></td>
					<th>Bonded Place Name</th>
					<td><input type="text" class="input" style="width:100px; ime-mode:disabled;" name="wh_nm" id="wh_nm" maxlength="500"></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<!-- wrap_search(E) -->


<!-- wrap_result(S) -->
<div class="wrap_result">
	<div class="opus_design_grid">
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn2_rowadd" id="btn2_rowadd" type="button">Row Add</button><!--
			--><button class="btn_normal" name="btn2_rowdel" id="btn2_rowdel" type="button">Delete</button>
		</div>
		<!-- opus_design_btn (E) -->

		<script type="text/javascript">ComSheetObject("sheet1");</script>
	</div>
</div>
<!-- wrap_result(E) -->


<!-- 개발자 작업 끝 (E) -->
</form>
