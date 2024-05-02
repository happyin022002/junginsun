<%
/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName : esm_bkg_0458.jsp
 *@FileTitle : ESM_BKG-0458
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/06/03
 =========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.event.EsmBkg0458Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0458Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message

	//String successFlag = "";
	//String codeList = "";
	//String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String bl_no= "";
	String gubun= "";
	//Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");

	try {
		bl_no= JSPUtil.getParameter(request, "bl_no");
		gubun= JSPUtil.getParameter(request, "gubun");

		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0458Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

	} catch (Exception e) {
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

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="bl_number" value="<%=bl_no%>">


<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><span> Manifest Registration(MFR) - Marks And Description</span></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!--
		--><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
	</div>
	<!-- opus_design_btn(E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<div class="opus_design_inquiry wFit">
		<h3 class="title_design"> Container  Information </h3>

		<table class="search" border="0" style="width:100%;">
			<tr class="h23">
				<th width="78px" class="align_left">Seq.</th>
				<td width="80px"><select style="width:60px;" name="select_bl_seq" onchange="changeSeq(this)">
					<!--option value="0" selected>01</option>
					<option value="1"></option-->
					</select></td>
				<th width="55px" class="align_left">TTL PKG</th>
				<td width="134px"><input type="text" style="width:50px;text-align:right" name="pck_qty" dataformat="float" maxlength="12" style="ime-mode:disabled">&nbsp;<input type="text" style="width:50px;" name="pck_tp_cd" dataformat="upper" maxlength="2" style="ime-mode:disabled"></td>
				<th width="55px" class="align_left">TTL WGT</th>
				<td width="175px"><input type="text" style="width:82px;text-align:right" name="grs_wgt" dataformat="float" maxlength="18" style="ime-mode:disabled">&nbsp;
					<%=JSPUtil.getCodeCombo("wgt_ut_cd", "", "style='width:57' style='ime-mode:disabled'", "CD00775", 0, "")%> </td>
				<th width="55px" class="align_left">TTL MEA</th>
				<td width="*"><input type="text" style="width:87px;text-align:right" name="meas_qty" dataformat="float" maxlength="18" style="ime-mode:disabled">&nbsp;
					<%=JSPUtil.getCodeCombo("meas_ut_cd", "", "style='width:57px;' style='ime-mode:disabled'", "CD01116", 0, "")%> </td>
			</tr>
		</table>
		<table class="search" border="0" style="width:100%;">
			<tr class="h23">
			<tr class="h23">
				<th width="75px" class="align_left">Local / TS</th>
				<td width="80px">
					<%=JSPUtil.getCodeCombo("locl_ts_flg", "", "style='width:60;'", "CD20033", 0, "")%> </td>
				<th width="104px" class="align_left">L / TS using CD</th>
				<td width="85px">
					<%=new com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil().getCstmsCodeCombo("jp_cstms_trns_cd", "JP", "MANI_TRAN_CD","", "style='width:57px;'")%></td>
				<th width="125px" class="align_left">L / TS using Period</th>
				<td width="106px"><input type="text" style="width:72px" dataformat="num" maxlength="15" name="lmt_no" style="ime-mode:disabled"></td>
				<th width="105px" class="align_left">CY Operator CD</th>
				<td width="*"><input type="text" style="width:96px" dataformat="engup" maxlength="5" name="cy_opr_cd" style="ime-mode:disabled"></td>
			</tr>
		</table>
	</div>
</div>

<div class="wrap_result">
	<div class="opus_design_grid" style="display:none">
		<script language="javascript">ComSheetObject("sheet1");</script>
	</div>
	<div class="opus_design_inquiry">
		<table border="0" style="width:100%;">
			<tr class="h23">
				<td width="50%" style="padding-right:13px;">
					<table border="0" style="width:100%; background-color:white;" class="grid2">
						<tr>
							<th class="align_center">Marks  &  No.</th>
						</tr>
						<tr>
							<td><textarea style="width:100%;" rows="11" name="diff_rmk" dataformat="engupetc" style="ime-mode:disabled" maxlength="2000"></textarea></td>
						</tr>
					</table>
				</td>
				<td width="50%" style="padding-left:13px;">
					<table border="0" style="width:100%; background-color:white;" class="grid2">
						<tr>
							<th class="align_center">Description</th>
						</tr>
						<tr>
							<td><textarea style="width:100%;" rows="11" name="bl_desc" dataformat="engupetc" style="ime-mode:disabled" maxlength="2000"></textarea></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</div>
</div>
</form>
