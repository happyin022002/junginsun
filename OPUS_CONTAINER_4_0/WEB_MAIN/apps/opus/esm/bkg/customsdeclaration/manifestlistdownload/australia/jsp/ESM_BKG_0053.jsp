	<%/*=========================================================
	*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
	*@FileName : ui_bkg_0053.jsp
	*@FileTitle : Australlia Custom EDI
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

	Exception serverException   = null;			//error from server
	String strErrMsg = "";				//error message
	int rowCount	 = 0;				//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String ofc_cd           = "";


	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");

	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);

		strUsr_id =	account.getUsr_id();
		ofc_cd    = account.getOfc_cd();
		strUsr_nm = account.getUsr_nm();

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
	<input type="hidden" name="f_cmd" id="f_cmd" />
	<input type="hidden" name="f_flag" value="SEARCH" id="f_flag" />
	<input type="hidden" name="pagerows" id="pagerows" />
	<input type="hidden" name="frm_vsl_cd" id="frm_vsl_cd" />
	<input type="hidden" name="frm_skd_voy_no" id="frm_skd_voy_no" />
	<input type="hidden" name="frm_skd_dir_cd" id="frm_skd_dir_cd" />
	<input type="hidden" name="frm_pol_cd" id="frm_pol_cd" />
	<input type="hidden" name="frm_pod_cd" id="frm_pod_cd" />
	<input type="hidden" name="frm_trans_gubun" id="frm_trans_gubun" />
	<input type="hidden" name="frm_edi_ind" value="O" id="frm_edi_ind" />

	<!-- page_title_area(S) -->
		<div class="page_title_area clear">

		<!-- page_title(S) -->
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->

		<!-- page_title(E) -->
		<% if (request.getParameter("pop_up") == null) { %>
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<% } else { %>
		<h2 class="page_title"><button type="button"><span id="title">&nbsp;ROCS:Received History</span></button></h2>
		<% }  %>

		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
			<button type="button" class="btn_normal" name="btn_transmit"   id="btn_transmit">Manifest Transmission</button>
		</div>
		<!-- opus_design_btn(E) -->

		<!-- page_location(S) -->
		<div class="location">
			<!-- location 내용 동적생성 (별도 코딩 불필요) -->
			<span id="navigation"></span>
		</div>
		<!-- page_location(E) -->
		</div>
	<!-- page_title_area(E) -->
	<!-- wrap_search(S) -->
	<div class="wrap_search">
	<!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	<div class="opus_design_inquiry">
		<table>
			 <colgroup>
				<col width="10px"/>
				<col width="50px" />
				<col width="50px" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr class="h23">
					<th title="Vessel Voyage Direction">VVD</th>
					<td>
						<input name="frm_vvd_number" id="frm_vvd_number"  style="ime-mode: disabled;width:80px" maxlength="9" dataformat="engup" type="text"  class="input1"  >
					</td>
					<th class="sm">
						&nbsp;&nbsp;<input type="radio" name="pol_gubun" value="1" class="trans" checked>&nbsp;POL&nbsp;&nbsp;<input type="radio" name="pol_gubun" value="2" class="trans">&nbsp;POD
						<input name="frm_port_cd" id="frm_port_cd" type="text" dataformat="engup" maxlength="5" style="ime-mode: disabled;width:50px;" class="input1"  >
					</th>
					<td></td>
				</tr>
			</tbody>
		</table>
		<table>
			<tbody>
				<tr>
				<td style="height:2px"></td>
				</tr>
			</tbody>
		</table>
		<table>
			<tbody>
			<colgroup>
				<col width="270px"/>
				<col width="*" />
			</colgroup>
			<tr style="display:none;">
				<th class="sm" style="height:25px">&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" value="M" name="edi_gubun" id="edi_gubun" class="trans">&nbsp;&nbsp;&nbsp;Manifest&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="checkbox" value="P" name="edi_gubun2" id="edi_gubun2" class="trans" checked>&nbsp;Port Authority&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
				<td></td>
			</tr>
			</tbody>
		</table>
		<table>
			<tbody>
				<tr>
				<td style="height:2px"></td>
				</tr>
			</tbody>
		</table>
		<h3 class="title_design2">Manifest Type</h3>
		<table>
			<tbody>
				<colgroup>
					<col width="270" />
					<col width="*" />
				</colgroup>
				<tr>
					<th class="sm" height="25px">&nbsp;&nbsp;<input type="radio" name="type_gubun" id="type_gubun" value="O" class="trans" checked>&nbsp;Original&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="type_gubun" id="type_gubun" value="R" class="trans">&nbsp;Replace&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio"  name="type_gubun" id="type_gubun" value="C" class="trans">&nbsp;Cancel&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<!-- wrap_search(E) -->
	<!-- wrap_result(S) -->
	<div class="wrap_result">
	<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
					<script language="javascript">ComSheetObject('sheet1');</script>
		</div>
	<!-- opus_design_grid(E) -->
	</div>
	<!-- wrap_result(E) -->

	</form>