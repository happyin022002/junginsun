<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESM_BKG_1517.jsp
*@FileTitle : Australia Underbond Movement Request - UBMREQ
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
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.event.EsmBkg1517Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EsmBkg1517Event event = null;		//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;	//서버에서 발생한 에러
	String strErrMsg = "";				//에러메세지
	int rowCount = 0;					//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList	= "";
	String pageRows	= "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.clt.apps.esm.bkg.customsdeclaration");

	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EsmBkg1517Event)request.getAttribute("Event");
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


<input type="hidden" name="search_div" id="search_div" value="UBMREQ">


<!-- page_title_area (S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" type="button" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
		--><button class="btn_normal" type="button" name="btn_new" id="btn_new">New</button><!--
		--><button class="btn_normal" type="button" name="btn_umbreq" id="btn_umbreq">UBMREQ</button><!--
		--><button class="btn_normal" type="button" name="btn_transmit" id="btn_transmit">UBMREQ Transmit</button>
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
		<table style="width:850px;">
			<colgroup>
				<col />
				<col />
				<col />
				<col />
				<col />
				<col />
				<col />
			</colgroup>
			<tbody>
				<tr>
					<th>VVD</th>
					<td><input type="text" class="input1" style="width:110px; ime-mode:disabled;" name="vvd" id="vvd" maxlength="9" required caption="VVD" fullfill dataformat="engup"></td>
					<th>POD</th>
					<td><input type="text" class="input1" style="width:70px; ime-mode:disabled;" name="pod_cd" id="pod_cd" maxlength="5" required caption="POD" fullfill dataformat="engup"></td>
					<th>DEL</th>
					<td><input type="text" class="input" style="width:70px; ime-mode:disabled;" name="del_cd" id="del_cd" maxlength="5" dataformat="engup"></td>
					<th>Send Type&nbsp;&nbsp;</th>
					<td><input type="radio" name="edi_ind" id="edi_ind" value="9" class="trans" checked>Orginal&nbsp;&nbsp;<!--
						--><input type="radio" name="edi_ind" id="edi_ind" value="4" class="trans">Change&nbsp;&nbsp;<!--
						--><input type="radio" name="edi_ind" id="edi_ind" value="50" class="trans">Withdraw</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="opus_design_inquiry">
		<table class="line_bluedot"><tr><td></td></tr></table>
	</div>
	<div class="opus_design_inquiry">
		<table style="width:1000px;">
			<colgroup>
				<col />
				<col />
				<col />
				<col />
				<col />
				<col />
				<col />
				<col />
				<col />
				<col />
				<col />
				<col />
			</colgroup>
			<tbody>
				<tr>
					<th>Reason</th>
					<td><script type="text/javascript">ComComboObject("req_reason", 2, 60, 1, 1);</script></td>
					<th>Origin Premises</th>
					<td><input type="text" class="input1" style="width:70px; ime-mode:disabled;" name="org_prms" id="org_prms" maxlength="5" dataformat="engup"></td>
					<th>Dest. Premises</th>
					<td><input type="text" class="input1" style="width:70px; ime-mode:disabled;" name="dst_prms" id="dst_prms" maxlength="5" dataformat="engup"></td>
					<th>Mode</th>
					<td><script type="text/javascript">ComComboObject("it_mode", 2, 60, 1, 1);</script></td>
					<th>On-Carriage Voy</th>
					<td><input type="text" class="input" style="width:70px; ime-mode:disabled;" name="on_crrg" id="on_crrg" maxlength="20" dataformat="engup"></td>
					<th>Lloyd's No</th>
					<td><input type="text" class="input" style="width:70px; ime-mode:disabled;" name="lloyd_no" id="lloyd_no" maxlength="20" dataformat="engup"></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<!-- wrap_search(E) -->


<!-- wrap_result(S) -->
<div class="wrap_result">
	<div class="opus_design_grid" id="mainTable">
		<script type="text/javascript">ComSheetObject("sheet1");</script>
	</div>
</div>
<!-- wrap_result(E) -->


<!-- 개발자 작업 끝 (E) -->
</form>
