 <%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ui_bkg_0282.jsp
*@FileTitle : HongKong Customs Manifest
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/02
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.hongkong.event.EsmBkg0282Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0282Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			// error from server
	String strErrMsg = "";						// error message
	int rowCount	 = 0;						// count of DB resultSET list

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
<input type="hidden" name="pagerows">
<input type="hidden" name="frm_attr_ctnt2">
<input type="hidden" name="vsl_cd">
<input type="hidden" name="skd_voy_no">
<input type="hidden" name="skd_dir_cd">
<input type="hidden" name="pol_cd">
<input type="hidden" name="pod_cd">
<input type="hidden" name="vvd_nm">
<input type="hidden" name="where_query" value="">
<input type="hidden" name="pg_no" value="esm0282">

<!-- 제목 -->
<div class="page_title_area clear">
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->

		<!-- btn_div -->
<div class="opus_design_btn">
	<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
	--><button type="button" class="btn_normal" name="btn_trans" id="btn_trans">EDI Transmit</button>
</div>

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
		<tr class="h23">
		<th width="100px">VVD</th>
		<td width="200px"><input name="vvd_number" type="text" style="text-align:center"  style="width:80px" value="" class="input1" dataformat="engup" style="ime-mode: disabled" maxlength="9"></td>

		<td width="243px">
		<table class="search_sm2" border="0" style="width:120px;">
		<tr class="h23">
			<th width="60px"><input name="pol_flg" type="radio"  class="trans" value="pol"   checked>POL</th>
			<th width="60px"><input  name="pol_flg"  type="radio"  class="trans" value="pod" >&nbsp;&nbsp;POD</th>
			<td width="*"><input    name="pol_code" type="text" style="width:50px" value="CNHKG" class="input1" style="text-align:center" style="ime-mode: disabled" dataformat="engup" maxlength="5"></td>
			</tr>
		</table>
		</td>
		<th width="60px">Total B/L</th>
		<td width="*"><input name="total_bl" type="text" style="width:35px" value="" class="input2" style="text-align:right" readonly></td>
		</tr>
	</table>
	<table
>
		<tr class="h23">
			<th width="100px">Vessel Name</th>
			<td width="227px"><input name="vsl_eng_nm" type="text" style="width:170px" value="" class="input2" readonly></td>
			<th width="60px">Call Sign</th>
			<td width="181px"><input name="call_sign_no" type="text" style="width:70px" value="" class="input2" readonly></td>
			<th width="30px">ETD</th>
			<td width="152px"><input name="etd_dt" type="text" style="width:90px" value="" class="input2" readonly></td>
			<th width="30px">ETA</th>
			<td width="*"><input name="eta_dt" type="text" style="width:90px" value="" class="input2" readonly></td>
		</tr>
	</table>
</div>
</div>
<!-- 검색영역 -->

<!-- 시트영역 -->
<div class="wrap_result">
<div class="opus_design_grid">
	<script language="javascript">ComSheetObject('sheet1');</script>
</div>
</div>
<!-- 시트영역 -->

</form>

