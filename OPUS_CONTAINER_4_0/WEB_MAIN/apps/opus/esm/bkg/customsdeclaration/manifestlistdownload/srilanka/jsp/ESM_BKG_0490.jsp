<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0490.jsp
*@FileTitle  : Manifest Transmit
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.event.EsmBkg0490Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0490Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";

	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");

	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
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
<input type="hidden" name="f_cmd">
<input type="hidden" name="pgNo">
<input type="hidden" name="pagerows">
<input type="hidden" name="frm_attr_ctnt2">
<input type="hidden" name="vsl_cd">
<input type="hidden" name="skd_voy_no">
<input type="hidden" name="skd_dir_cd">
<input type="hidden" name="vvd_nm">
<input type="hidden" name="sr_sts_cd">
<input type="hidden" name="rgst_dt">
<input type="hidden" name="rjct_dt">
<input type="hidden" name="vsl_auth_no">
<input type="hidden" name="sr_sts_desc">
<input type="hidden" name="sr_cmt_desc">
<input type="hidden" name="decl_bl_qty">

<!-- page(S) -->
<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
	 --><button type="button" class="btn_normal" name="btn_ViewResponse" id="btn_ViewResponse">View Response</button><!--
	 --><button type="button" class="btn_normal" name="btn_Transmit" id="btn_Transmit">EDI Transmit</button>
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


<!-- opus_design_inquiry(S) -->
<div class="wrap_search_tab">
<div class="opus_design_inquiry opus_design_inquiryTab wFit">
	<!--  MiniLayer (S) -->
	<table>
		<colgroup>
			<col width="140px" />
			<col width="50px" />
			<col width="140px" />
			<col width="50px" />
			<col width="110px" />
			<col width="60px" />
			<col width="120px" />
			<col width="180px" />
			<col width="" />
		</colgroup>
		<tbody>
			<tr>
				<th width="130">VVD</th>
				<td width="120"><input name = "vvd_number" dataformat="engup" style="ime-mode: disabled" type="text" style="width:90px;" class="input1" maxlength="9"></td>
				<th width="120">POD</th>
				<td width="220"><input name = "pod_cd" dataformat="engup" style="ime-mode: disabled"   type="text" style="width:80px;" class="input1" value="LKCMB" maxlength="5"></td>
				<th width="30">DEL</th>
				<td width="140"><input name = "del_cd" dataformat="engup" style="ime-mode: disabled" type="text" style="width:80px;" value="LKCMB" maxlength="5"></td>
				<th width="110">Last Call Port CD</th>
				<td><input name = "call_port" dataformat="engup" style="ime-mode: disabled" type="text" style="width:100px;" class="input1" maxlength="5"></td>
			</tr>
			<tr>
				<th width="130">Vessel Approval No.</th>
				<td width="120"><input name = "auth_no"  dataformat="engup" style="ime-mode: disabled" type="text" style="width:90px;" maxlength="10"></td>
				<th width="120">Carrier TIN No.</th>
				<td width="170"><input name = "carrier_no" type="text" style="width:130px;" value="114333611-7000" class="input2" readonly></td>
				<th width="80" colspan="3" style="padding-left:93px;">Vessel Name &nbsp;<input name = "vsl_nm" type="text" style="width:350px;" class="input2" readonly></th>
				<td></td>
			</tr>
			<tr>
				<th width="130">Customs Office Code</th>
				<td width="120"><input  name = "customs_office_code" type="text" dataformat="uppernum" style="ime-mode: disabled" style="width:90px;" value="CBLR1" maxlength="5"></td>
				<th width="120">Vessel Arrival Date</th>
				<td width="110"><input name = "eta_dt" type="text" style="width:80px;" class="input2" readonly></td>
				<th width="140">Vessel Departure Date</th>
				<td width="110"><input name = "etd_dt" type="text" style="width:80px;" class="input2" readonly></td>
				<th width="140">Port Registration No.</th>
				<td>
					<input type="text"  name="reg_no" class="input" style="ime-mode:disabled" maxlength="7" style="width:100px;" onKeyPress="ComKeyAlphabetNChar('uppernum2')">
				</td>
			</tr>
		</tbody>
	</table>
	<!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
</div>
</div>


<!-- opus_tab_btn(S) -->
<div class="wrap_result">
<div class="opus_design_tab">
	<script language="javascript">ComTabObject('tab1')</script>
</div>
<!-- opus_tab_btn(E) -->

<!--TAB B/L Info (S) -->

<div class="opus_design_grid" name="tabLayer" id="tabLayer">
	<script language="javascript">ComSheetObject('t1sheet1');</script>
	<div class="grid_option_left mar_top_8">
		<Label for="total_bl">B/L Total:</Label>
		<input name="total_bl" type="text" style="width:35" class="input2" style="text-align:right" readonly>
	</div>
</div>
<!--TAB B/L Info (E) -->

<!--TAB CNTR Info (S) -->
<div class="opus_design_grid" name="tabLayer" id="tabLayer">
	<script language="javascript">ComSheetObject('t2sheet1');</script>
	<div class="grid_option_left mar_top_8">
		<Label for="total_cntr">CNTR Total:</Label>
		<input name="total_cntr" type="text" style="width:35" class="input2" style="text-align:right" readonly>
	</div>
</div>
<!--TAB CNTR Info (E) -->
	 </div>
</form>