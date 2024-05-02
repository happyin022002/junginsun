<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESM_BKG_1510.jsp
*@FileTitle : Approval Number for Bonded Transportation
*@author : CLT
*@version : 1.0
*@since : 2014/10/08
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.event.EsmBkg1510Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1510Event event = null;        // PDTO(Data Transfer Object including Parameters)
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
		event = (EsmBkg1510Event)request.getAttribute("Event");
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
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- 개발자 작업 -->
<input type="hidden" name="bl_no" id="bl_no" value='<%=JSPUtil.getParameter(request, "bl_no")%>' /><br />
<input type="hidden" name="del_bnd" id="del_bnd" value='<%=JSPUtil.getParameter(request, "del_bnd")%>' /><br />
<input type="hidden" name="pod_bnd" id="pod_bnd" value='<%=JSPUtil.getParameter(request, "pod_bnd")%>' />
<input type="hidden" name="delt_flg" id="delt_flg" value='<%=JSPUtil.getParameter(request, "delt_flg")%>' />


<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><span> Approval Number for Bonded Transportation</span></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_del" id="btn_del">Delete</button><!--
		--><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!--
		--><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
	</div>
	<!-- opus_design_btn(E) -->
</div>
<!-- page_title_area(E) -->


<!-- wrap_search(S) -->
<div class="wrap_search">
	<div class="opus_design_inquiry wFit">
		<h3 class="title_design"> Approval Number and Place of Arrival</h3>
		<table>
			<colgroup>
				<col />
				<col />
			</colgroup>
			<tbody>
				<tr>
					<th>Approval Number</th>
					<td><select name="apro_no" id="apro_no" class="input" style="width:180px"></select></td>
				</tr>
				<tr>
					<th>Arrival Place Code</th>
					<td><input type="text" name="cstms_cd" id="cstms_cd" class="input" style="width:180px;" maxlength="10" dataformat="engup" otherchar="_-" /></td>
				</tr>
				<tr>
					<th>Arrival Place Name</th>
					<td><input type="text" name="wh_nm" id="wh_nm" class="input2" style="width:180px;" readOnly></td>
				</tr>
				<tr>
					<th>Bonded Goods</th>
					<td><input type="text" name="trsp_mod_cd" id="trsp_mod_cd" class="input" style="width:180px;" maxlength="2" dataformat="engup" otherchar="_-" /></td>
				</tr>
				<tr>
					<td>&nbsp</td>
					<td>&nbsp</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<!-- wrap_search(E) -->


<!-- wrap_result(S) -->
<div class="wrap_result">
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject("sheet1");</script>
		<script type="text/javascript">ComSheetObject("sheet2");</script>
	</div>
</div>
<!-- wrap_result(E) -->


<!-- 개발자 작업 끝 -->
</form>
