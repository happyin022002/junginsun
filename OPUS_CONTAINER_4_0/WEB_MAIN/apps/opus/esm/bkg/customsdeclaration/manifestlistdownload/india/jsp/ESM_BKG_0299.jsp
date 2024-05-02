<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0299.js
*@FileTitle  :
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/24
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.india.event.EsmBkg0296Event"%>

<%@ page import="org.apache.log4j.Logger" %>

<%
	//EsmBkg0299Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");

	String vvdCd = "";
	String polCd = "";
	String podCd = "";
	String chk1 = "";
	String chk2 = "";
	String chk3 = "";
	String vslNm = "";


	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

/*
		event = (EsmBkg0296Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
*/
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		// 부모창에서 넘오온 파라메터 셋팅
		vvdCd = JSPUtil.getParameter(request, ("vvd_cd"));
		polCd = JSPUtil.getParameter(request, ("pol_cd"));
		podCd = JSPUtil.getParameter(request, ("pod_cd"));
		chk1 = JSPUtil.getParameter(request, ("chk1"));
		chk2 = JSPUtil.getParameter(request, ("chk2"));
		chk3 = JSPUtil.getParameter(request, ("chk3"));
		vslNm = JSPUtil.getParameter(request, ("vsl_nm"));

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script  type="text/javascript">
	function setupPage(){
		/*
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		}
		*/

		$('<button type="button" class="btn_accent" name="btn_retrieve"	id="btn_retrieve">Retrieve</button>').appendTo("#btnArea");
		$('#btn_retrieve').after($('#btn_Close'));

		document.getElementById("title").innerHTML = "Form III Print Set-Up";

		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="vvd_cd" value="<%= vvdCd %>" id="vvd_cd" />
<input type="hidden" name="pol_cd" value="<%= polCd %>" id="pol_cd" />
<input type="hidden" name="pod_cd" value="<%= podCd %>" id="pod_cd" />
<input type="hidden" name="vsl_nm" value="<%= vslNm %>" id="vsl_nm" />

	<!-- : ( Title ) (S) -->
	 <%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp"%>
	<!-- : ( Title ) (E) -->


	<!-- popup_contens_area(S) -->
	<div class="layer_popup_contents">
	<div class= "wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry">
			<!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
			<table>
				<colgroup>
					<col width="340"/>
					<col width="*"/>
				</colgroup>
				<tbody>
					<tr>
						<td class="sm pad_left_8"><input type="checkbox" class="trans"  name="chk1" id="chk1" value="1"><label for="chk1"><b>Footer</b></label></td>
						<td></td>
					</tr>
					<tr>
						<td class="sm pad_left_8"><input type="checkbox" class="trans" name="chk2" id="chk2" value="2"><label for="chk2"><b>TP Permit Address</b></label></td>
						<td></td>
					</tr>
					<tr>
						<td class="sm pad_left_8"><input type="checkbox" class="trans" name="chk3" id="chk3" value="3"><label for="chk3"><b>TP Body</b></label></td>
						<td></td>
					</tr>
				</tbody>
		</table>
		</div>
		<!-- opus_design_inquiry(E) -->
		</div>
	</div>
	<!-- popup_contens_area(E) -->



</form>

