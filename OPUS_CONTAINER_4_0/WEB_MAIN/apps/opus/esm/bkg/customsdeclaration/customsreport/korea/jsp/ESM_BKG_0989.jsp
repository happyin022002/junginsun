<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0989.jsp
*@FileTitle  : View Send Flat File
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/07
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.event.EsmBkg0989Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0989Event event = null;        // PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;    // 서버에서 발생한 에러
	String strErrMsg = "";               // 에러메세지
	int rowCount = 0;                    // DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.clt.apps.esm.bkg.CustomsDeclaration");

	try {
		SignOnUserAccount account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EsmBkg0989Event)request.getAttribute("Event");
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
	function setupPage() {
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />

<!-- 개발자 작업 -->
<input type="hidden" name="msg_log_tp_id" id="msg_log_tp_id" value='<%=JSPUtil.getParameter(request, "msg_loc_tp_id")%>' />
<input type="hidden" name="snd_dt" id="snd_dt" value='<%=JSPUtil.getParameter(request, "snd_dt")%>' />
<input type="hidden" name="ofc_cd" id="ofc_cd" value='<%=JSPUtil.getParameter(request, "ofc_cd")%>' />
<input type="hidden" name="mf_snd_seq" id="mf_snd_seq" value='<%=JSPUtil.getParameter(request, "mf_snd_seq")%>' />

<div class="layer_popup_contents">
	<!-- page_title_area(S) -->
	<div class="layer_popup_title">
		<div class="page_title_area clear">
			<h2 class="page_title"><span>Transmission History to Korea Customs Send File</span></h2>
			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn"><!--
				 --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
			</div>
			<!-- opus_design_btn(E) -->
		</div>
	</div>
	<!-- page_title_area(E) -->

	<div class="wrap_search">
		<div class="opus_design_inquiry">
			<!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
			<table>
				<tbody>
					<tr>
						<th class="tr2_head" style="text-align:center;">Send File</th>
					</tr>
					<tr class="h23">
						<td><textarea style="width:100%;" rows="20" name="msgTxt">Ready...</textarea></td>
					</tr>
				</tbody>
			</table>
			<!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
		</div>
	</div>

	<div class="wrap_result" id="mainTable" style="display:none;">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject("sheet1");</script>
		</div>
		<!-- opus_design_grid(S) -->
	</div>
</div>
<!-- 개발자 작업 끝 -->
</form>